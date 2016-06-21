package cn.com.fubon.wechatClaims.controller;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.ComboTree;
import org.jeecgframework.core.common.service.CommonService;
import org.jeecgframework.core.util.DateUtils;
import org.jeecgframework.core.util.NumberComparator;
import org.jeecgframework.core.util.UUIDGenerator;
import org.jeecgframework.tag.vo.easyui.ComboTreeModel;
import org.jeecgframework.web.system.pojo.base.Client;
import org.jeecgframework.web.system.pojo.base.TSBaseUser;
import org.jeecgframework.web.system.pojo.base.TSUser;
import org.jeecgframework.web.system.service.SystemService;
import org.jeecgframework.web.system.service.UserService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import weixin.guanjia.account.service.WeixinAccountServiceI;
import weixin.guanjia.core.util.WeixinUtil;
import weixin.guanjia.message.entity.ReceiveMessage;
import weixin.guanjia.message.service.ReceiveMessageServiceI;
import cn.com.fubon.entity.WeChatContext;
import cn.com.fubon.fo.customerbind.entity.WeiXinGzUserInfo;
import cn.com.fubon.fo.customerbind.service.CustomerBindService;
import cn.com.fubon.fo.personalcenter.service.PersonalCenterService;
import cn.com.fubon.util.CachedUtils;
import cn.com.fubon.util.Constants;
import cn.com.fubon.wechatClaims.entity.ReportInfo;
import cn.com.fubon.wechatClaims.entity.WeiXinCustomerServiceChatDetail;
import cn.com.fubon.wechatClaims.entity.WeiXinCustomerServiceChatInfo;
import cn.com.fubon.wechatClaims.entity.WeixinClaimCommonWords;
import cn.com.fubon.wechatClaims.service.ClaimsSessionManagement;
import cn.com.fubon.wechatClaims.service.CustomerChatService;
import cn.com.fubon.wechatClaims.service.GetReportRunnable;
import cn.com.fubon.wechatClaims.service.ReportInfoService;

/**
 * 客服聊天系统类
 * 
 * @author patrick.z 20150127
 */
@Scope("prototype")
@Controller
@RequestMapping("/wechatClaims/CustomerChat")
public class CustomerChatController {

	private static final Logger logger = Logger
			.getLogger(CustomerChatController.class);
	@Resource
	private PersonalCenterService personalCenterService;

	@Resource
	private CustomerChatService customerChatService;

	@Resource
	private ReportInfoService reportInfoService;

	@Resource
	private UserService userService;

	@Resource
	private CommonService commonService;

	@Resource
	private ClaimsSessionManagement claimsSessionManagementService;

	@Resource
	private WeixinAccountServiceI weixinAccountService;
	@Resource
	private ReceiveMessageServiceI receiveMessageService;
	@Resource
	private CustomerBindService customerBindService;
	@Resource
	private SystemService systemService;

	public CustomerChatController() {
	}

	/**
	 * 进入主页
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "chatIndex")
	public String chatIndex(HttpServletRequest request) {
		String operatorCode = "";
		String roleCode = "";
		HttpSession session = request.getSession();
		Client client = (Client) session
				.getAttribute(Constants.SESSION_KEY_BO_USER);
		if (client != null) {
			TSUser user = client.getUser();
			if (user != null) {
				operatorCode = user.getUserName();// 理赔客服工号
				// 获取用户角色code
				roleCode = userService.getUserRole(user);
			}
		}
		logger.info("operatorCode =>" + operatorCode);

		List<Map<String, Object>> registNoList = customerChatService
				.getRegistNoListByOperatorCode(operatorCode, roleCode);

		// 待处理的案件数量
		int registNoCount = 0;
		// 未读信息总量
		int totalNotReadedMessageCount = 0;
		for (Map<String, Object> tempMap : registNoList) {
			int notReadedMessageCount = Integer.parseInt(tempMap
					.get("messageTotal") + "");
			totalNotReadedMessageCount += notReadedMessageCount;
			int sessionState = Integer.parseInt(tempMap.get("sessionState")
					+ "");

			if (sessionState == Constants.WECHATCLAIMS_REGISTNO_SESSTIONSTATE_LINE) {
				registNoCount += 1;
			}
		}

		// 获取用户头像
		String userImageUrl = "";
		TSBaseUser tsBaseUser = customerChatService.getTSBaseUser(operatorCode);
		if (null != tsBaseUser) {
			userImageUrl = tsBaseUser.getImageUrl();
		}
		request.setAttribute("userImageUrl", userImageUrl);
		request.setAttribute("totalNotReadedMessageCount",
				totalNotReadedMessageCount);
		request.setAttribute("registNoCount", registNoCount);
		request.setAttribute("operatorCode", operatorCode);
		request.setAttribute("roleCode", roleCode);
		return "weixin/mutilcustomerservice/customerchat";
	}

	/**
	 * 进入案件列表页面
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "registNoListIndex")
	public String registNoListIndex(HttpServletRequest request) {
		String operatorCode = request.getParameter("operatorCode") + "";
		String roleCode = request.getParameter("roleCode") + "";
		String notReadCount = request.getParameter("notReadCount") + "";
		request.setAttribute("operatorCode", operatorCode);
		request.setAttribute("roleCode", roleCode);
		request.setAttribute("notReadCount", notReadCount);
		return "weixin/mutilcustomerservice/registnolist";
	}

	/**
	 * 获取所有符合条件案件信息
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(params = "registNoList")
	@ResponseBody
	public AjaxJson registNoList(HttpServletRequest request) throws Exception {
		
		AjaxJson jsonString = new AjaxJson();
		Map<String, Object> reportInfoMap = new HashMap<String, Object>();
		String operatorCode = request.getParameter("operatorCode");
		String roleCode = request.getParameter("roleCode");
		// 获取更新前案件列表信息
		List<Map<String, Object>> registNoList = customerChatService
				.getRegistNoListByOperatorCode(operatorCode, roleCode);

		// 超时案件处理
		checkRegistIsTimeout(operatorCode, roleCode);

		int totalNotReadedMessageCount = 0;
		for (Map<String, Object> tempMap : registNoList) {
			int notReadedMessageCount = Integer.parseInt(tempMap
					.get("messageTotal") + "");
			totalNotReadedMessageCount += notReadedMessageCount;
		}

		if (registNoList.size() <= 0) {
			jsonString.setMsg("您暂时没有待处理的案件信息！");
			jsonString.setSuccess(false);
		} else {
			reportInfoMap.put("totalNotReadedMessageCount",
					totalNotReadedMessageCount);
			reportInfoMap.put("registNoList", registNoList);
			jsonString.setAttributes(reportInfoMap);
		}

		return jsonString;
	}

	/**
	 * 进入即时聊天窗口
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "instantChatIndex")
	public String instantChatIndex(HttpServletRequest request) {
		String registNo = request.getParameter("registno");
		String openId = request.getParameter("openid");
		String operatorCode = request.getParameter("operatorCode");
		String roleCode = request.getParameter("roleCode");
		// 案件信息
		Map<String, Object> reportInfoMap = reportInfoService
				.getReportInfoByRegistNo(registNo);

		// 案件处理人信息
		String currOperatorCode = reportInfoMap.get("operatorCode") + "";
		String currOperatorName = getCurrentOperatorName(currOperatorCode);
		reportInfoMap.put("currOperatorCode", currOperatorCode);
		reportInfoMap.put("currOperatorName", currOperatorName);

		// 未读的记录
		List<Map<String, Object>> customerChatNotReadedList = customerChatService
				.getCustomerServiceChatNotReaded(registNo);
		// 更新未读记录状态为已读
		updCustomerServiceChatMessageReadedById(customerChatNotReadedList);

		// 已读最近十条记录
		List<Map<String, Object>> customerChatReadedList = getCustomerServiceChatReaded(registNo);
		String userlasttime = "";
		// 保存客服/用户最后一次聊天时间
		for (Map<String, Object> tempMap : customerChatReadedList) {
			userlasttime = tempMap.get("userlasttime") + "";
			if (userlasttime.length() > 20) {
				userlasttime = userlasttime.substring(0,
						userlasttime.length() - 2);
			}
		}

		request.setAttribute("userlasttime", userlasttime);
		request.setAttribute("reportInfoMap", reportInfoMap);
		request.setAttribute("customerChatReadedList", customerChatReadedList);
		request.setAttribute("openid", openId);
		request.setAttribute("registno", registNo);
		request.setAttribute("operatorCode", operatorCode);
		request.setAttribute("roleCode", roleCode);
		return "weixin/mutilcustomerservice/registnochatcontent";
	}

	/**
	 * 话术树形列表
	 * 
	 * @param request
	 * @param comboTree
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping(params = "wordTree")
	@ResponseBody
	public List<ComboTree> wordTree(HttpServletRequest request,
			ComboTree comboTree) throws UnsupportedEncodingException {
		CriteriaQuery cq = new CriteriaQuery(WeixinClaimCommonWords.class);
		if (comboTree.getId() != null) {
			cq.eq("uwords.id", comboTree.getId());
		}
		if (comboTree.getId() == null) {
			cq.isNull("uwords");
		}
		cq.add();
		List<WeixinClaimCommonWords> UwordssList = systemService
				.getListByCriteriaQuery(cq, false);

		Collections.sort(UwordssList, new NumberComparator(false, true));
		List<ComboTree> comboTrees = new ArrayList<ComboTree>();

		List<WeixinClaimCommonWords> loginActionlist = new ArrayList<WeixinClaimCommonWords>();// 已有
		ComboTreeModel comboTreeModel = new ComboTreeModel("id", "hsName",
				"Uwordss");
		String currOperatorName = request.getParameter("currOperatorName");
		currOperatorName = new String(currOperatorName.getBytes("ISO-8859-1"),
				"UTF-8");
		String currOperatorCode = request.getParameter("currOperatorCode");
		String registNo = request.getParameter("registno");
		String picturenum = "";
		ReportInfo reportInfo = reportInfoService.getReportInfo(registNo);
		String reportorname = reportInfo.getReportorName();
		currOperatorCode = reportInfo.getOperatorCode();
		currOperatorName = reportInfo.getOperatorName();
		String reportorsex = "";
		String opendId = reportInfo.getOpenid();
		WeChatContext weChatContext = null;
		if (opendId != null && opendId != "") {
			WeiXinGzUserInfo weiXinGzUserInfo = customerBindService
					.findUniqueByProperty(WeiXinGzUserInfo.class, "openid",
							opendId);
			String sex = weiXinGzUserInfo.getSex();

			if (Constants.MR_FLAG.equals(sex)) {
				reportorsex = "先生";
			}
			if (Constants.MISS_FLAG.equals(sex)) {
				reportorsex = "小姐";
			}
			weChatContext = (WeChatContext) CachedUtils
					.get(Constants.MEMKEY_WEIXIN_WeChat_claims + opendId);
		}
		int imagetotal = 0;
		if (weChatContext != null) {
			imagetotal = (int) weChatContext
					.get(Constants.WEIXINCLAIMS_claimsImage_total);
		}

		picturenum = String.valueOf(imagetotal);
		Map<String, String> reaplaceMap = new HashMap<String, String>();

		reaplaceMap.put("$(reportorname)", reportorname);
		reaplaceMap.put("$(operatorname)", currOperatorName);
		reaplaceMap.put("$(operatorcode)", currOperatorCode);
		reaplaceMap.put("$(reportorsex)", reportorsex);
		reaplaceMap.put("$(picturenum)", picturenum);

		request.setAttribute("reportorname", reportorname);
		request.setAttribute("currOperatorCode", currOperatorCode);
		request.setAttribute("currOperatorName", currOperatorName);

		comboTrees = systemService.CommonWordsComboTree(UwordssList,
				comboTreeModel, loginActionlist, reaplaceMap);
		return comboTrees;
	}

	/**
	 * 话术树形列表(查询)
	 * 
	 * @param request
	 * @param comboTree
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping(params = "wordTreeS")
	@ResponseBody
	public List<ComboTree> wordTreeS(HttpServletRequest request,
			ComboTree comboTree) throws UnsupportedEncodingException {
		String searchName = request.getParameter("searchName");
		searchName = "%" + searchName + "%";
		try {
			searchName = new String(searchName.getBytes("ISO-8859-1"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CriteriaQuery cq = new CriteriaQuery(WeixinClaimCommonWords.class);
		if (comboTree.getId() != null) {
			cq.eq("uwords.id", comboTree.getId());
			if (searchName != null && searchName != "") {
				cq.like("hsName", searchName);
			}
		}
		if (comboTree.getId() == null) {
			cq.isNull("uwords");
		}
		cq.isNull("uwords.parentwordid");
		cq.add();
		List<WeixinClaimCommonWords> UwordssList = systemService
				.getListByCriteriaQuery(cq, false);
		Collections.sort(UwordssList, new NumberComparator(false, true));
		List<ComboTree> comboTrees = new ArrayList<ComboTree>();

		List<WeixinClaimCommonWords> loginActionlist = new ArrayList<WeixinClaimCommonWords>();// 已有
		ComboTreeModel comboTreeModel = new ComboTreeModel("id", "hsName",
				"Uwordss");
		String currOperatorName = request.getParameter("currOperatorName");
		currOperatorName = new String(currOperatorName.getBytes("ISO-8859-1"),
				"UTF-8");
		String currOperatorCode = request.getParameter("currOperatorCode");
		String registNo = request.getParameter("registno");

		ReportInfo reportInfo = reportInfoService.getReportInfo(registNo);
		String reportorname = reportInfo.getReportorName();
		request.setAttribute("reportorname", reportorname);
		request.setAttribute("currOperatorCode", currOperatorCode);
		request.setAttribute("currOperatorName", currOperatorName);
		String reportorsex = "";
		String opendId = reportInfo.getOpenid();
		if (opendId != null && opendId != "") {
			WeiXinGzUserInfo weiXinGzUserInfo = customerBindService
					.findUniqueByProperty(WeiXinGzUserInfo.class, "openid",
							opendId);
			String sex = weiXinGzUserInfo.getSex();

			if (Constants.MR_FLAG.equals(sex)) {
				reportorsex = "先生";
			}
			if (Constants.MISS_FLAG.equals(sex)) {
				reportorsex = "小姐";
			}
		}
		Map<String, String> reaplaceMap = new HashMap<String, String>();

		reaplaceMap.put(reportorname, "$(reportorname)");
		reaplaceMap.put(currOperatorName, "$(currOperatorName)");
		reaplaceMap.put(currOperatorCode, "$(currOperatorCode)");
		reaplaceMap.put(registNo, "$(registNo)");
		reaplaceMap.put(reportorsex, "$(reportorsex)");
		comboTrees = systemService.CommonWordsComboTree(UwordssList,
				comboTreeModel, loginActionlist, reaplaceMap);
		return comboTrees;
	}

	/**
	 * 话术树形列表(根节点id)
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "serchRoot")
	@ResponseBody
	public String serchRoot(HttpServletRequest request) {
		String idString = "";
		CriteriaQuery cq = new CriteriaQuery(WeixinClaimCommonWords.class);
		cq.isNull("uwords");
		cq.add();
		List<WeixinClaimCommonWords> uwordssList = systemService
				.getListByCriteriaQuery(cq, false);
		for (int i = 0; i < uwordssList.size(); i++) {
			WeixinClaimCommonWords uwords = uwordssList.get(i);
			String id = uwords.getId();
			idString = idString + id + ";";
		}
		return idString;
	}

	/**
	 * 客服发送消息
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(params = "sendMessage")
	@ResponseBody
	public AjaxJson sendMessage(HttpServletRequest request) throws Exception {
		AjaxJson jsonString = new AjaxJson();
		String openid = request.getParameter("openid");
		String content = "";
		content = java.net.URLDecoder.decode(request.getParameter("content"),
				"UTF-8");
		String operatorCode = request.getParameter("operatorcode");
		String msgType = request.getParameter("msgtype");
		String registNo = request.getParameter("registno");

		// 检测可用性
		// 检测客户状态
		boolean onlineBool = claimsSessionManagementService
				.customerIsOnline(openid);
		if (!onlineBool) {
			jsonString.setMsg("客户已经退出此次会话！");
			jsonString.setSuccess(false);
			return jsonString;
		}

		// 不为空
		if (!StringUtils.isNotEmpty(content)) {
			jsonString.setMsg("内容不能为空！");
			jsonString.setSuccess(false);
			return jsonString;
		}
		// 长度限制
		if (content.length() > 999) {
			jsonString.setMsg("内容长度不能超过1000个字符！");
			jsonString.setSuccess(false);
			return jsonString;
		}

		boolean returnRes = false;
		try {
			// 聊天记录表插入记录 WeiXinCustomerServiceChatInfo
			WeiXinCustomerServiceChatInfo weiXinCusomerServiceChatInfo = new WeiXinCustomerServiceChatInfo();
			weiXinCusomerServiceChatInfo.setId(UUIDGenerator.generate());
			weiXinCusomerServiceChatInfo.setOperatorCode(operatorCode);
			weiXinCusomerServiceChatInfo.setMsgtype(msgType);
			weiXinCusomerServiceChatInfo.setContent(content);
			customerChatService
					.saveWeiXinCustomerServiceChatInfo(weiXinCusomerServiceChatInfo);

			// 聊天记录映射表插入记录 WeiXinCustomerServiceChatDetail
			WeiXinCustomerServiceChatDetail weiXinCustomerServiceChatDetail = new WeiXinCustomerServiceChatDetail();
			weiXinCustomerServiceChatDetail.setId(UUIDGenerator.generate());
			weiXinCustomerServiceChatDetail.setClaimRegistNo(registNo);
			weiXinCustomerServiceChatDetail
					.setMessageSource(Constants.WECHATCLAIMS_MESSAGE_SOURCE_CUSTOMERSERVICE);// 设置来源为客服聊天记录表
			weiXinCustomerServiceChatDetail
					.setIsMessageReaded(Constants.WECHATCLAIMS_MESSAGE_READED);// 客服消息默认已读
			weiXinCustomerServiceChatDetail
					.setCustomerServiceId(weiXinCusomerServiceChatInfo.getId());
			customerChatService
					.saveWeiXinCustomerServiceChatDetail(weiXinCustomerServiceChatDetail);

			// 调用微信接口给用户发送聊天内容
			String sendMsgType = "text";
			if (msgType.equals(Constants.WECHATCLAIMS_MESSAGE_TYPE_TEXT)) {
				sendMsgType = "text";
			}
			if (msgType.equals(Constants.WECHATCLAIMS_MESSAGE_TYPE_IMAGE)) {
				sendMsgType = "image";
			}
			WeixinUtil.sendCustomerServiceMessage(openid, sendMsgType, content);
			returnRes = true;
		} catch (Exception e) {
			returnRes = false;
			logger.info("sendMessage exception:" + e.getMessage());
		}

		if (returnRes) {
			jsonString.setMsg("消息发送成功！");
			jsonString.setSuccess(true);
		} else {
			jsonString.setMsg("消息发送失败！");
			jsonString.setSuccess(false);
		}

		return jsonString;
	}

	/**
	 * 获取用户聊天信息
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(params = "getCustomerMessage")
	@ResponseBody
	public AjaxJson getCustomerMessage(HttpServletRequest request)
			throws Exception {
		AjaxJson jsonString = new AjaxJson();
		Map<String, Object> reportInfoMap = new HashMap<String, Object>();
		String registNo = request.getParameter("registno");

		// 未读的记录
		List<Map<String, Object>> customerChatNotReadedList = customerChatService
				.getCustomerServiceChatNotReaded(registNo);
		// 已读照片数量
		int readedCount = customerChatService.getCustomerServiceChatReadedImages(registNo);
		
		for(int i = 0; i <customerChatNotReadedList.size();i++){
			if("image".equalsIgnoreCase(customerChatNotReadedList.get(i).get("msgtype").toString())){
				readedCount++;
			}
			customerChatNotReadedList.get(i).put("imagesNum", readedCount);
		}

		if (customerChatNotReadedList.size() <= 0) {
			jsonString.setMsg("您暂时没有待处理的案件信息！");
			jsonString.setSuccess(false);
		} else {
			// 更新未读记录状态为已读
			updCustomerServiceChatMessageReadedById(customerChatNotReadedList);

			reportInfoMap.put("customerChatNotReadedList",
					customerChatNotReadedList);
			jsonString.setAttributes(reportInfoMap);
		}

		return jsonString;
	}

	/**
	 * 关闭会话
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(params = "closeCustomerChat")
	@ResponseBody
	public AjaxJson closeCustomerChat(HttpServletRequest request)
			throws Exception {
		AjaxJson jsonString = new AjaxJson();
		Map<String, Object> reportInfoMap = new HashMap<String, Object>();
		String registNo = request.getParameter("registno");
		String openid = request.getParameter("openid");

		// 更新案件表状态
		boolean returnRes = reportInfoService.updReportInfoByRegistNo(registNo);
		if (returnRes) {
			// 关闭上下文对话状态,给微信端发送关闭消息
			claimsSessionManagementService.colseWechatSession(openid);
			jsonString.setSuccess(true);
			//
			// WeixinUtil.sendCustomerServiceMessage(openid, "text",
			// "您好，客服已将此次会话关闭！");
		} else {
			jsonString.setMsg("关闭会话失败！");
			jsonString.setSuccess(true);
		}
		jsonString.setAttributes(reportInfoMap);
		return jsonString;
	}

	/**
	 * 进入历史聊天记录窗口
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "historyChatIndex")
	public String historyChatIndex(HttpServletRequest request) {
		String openid = request.getParameter("openid") + "";
		String registno = request.getParameter("registno") + "";
		String operatorcode = request.getParameter("operatorcode") + "";
		String rolecode = request.getParameter("rolecode") + "";

		if (operatorcode.equals("null") || rolecode == "null") {
			HttpSession session = request.getSession();
			Client client = (Client) session
					.getAttribute(Constants.SESSION_KEY_BO_USER);
			if (client != null) {
				TSUser user = client.getUser();
				if (user != null) {
					operatorcode = user.getUserName();// 理赔客服工号
					// 获取用户角色code
					rolecode = userService.getUserRole(user);
				}
			}
		}

		// 获取用户头像
		String userImageUrl = "";
		TSBaseUser tsBaseUser = customerChatService.getTSBaseUser(operatorcode);
		if (null != tsBaseUser) {
			userImageUrl = tsBaseUser.getImageUrl();
		}

		// 指定案件信息
		Map<String, Object> reportInfoMap = reportInfoService
				.getReportInfoByRegistNo(registno);
		if (reportInfoMap == null) {
			reportInfoMap = new HashMap<String, Object>();
		}
		// 指定案件号的所有聊天记录
		List<Map<String, Object>> customerChatList = getCustomerServiceChatAll(registno);

		// 指定案件号的最后聊天时间
		String userlasttime = "";
		for (Map<String, Object> tempMap : customerChatList) {
			userlasttime = tempMap.get("userlasttime") + "";
			if (userlasttime.length() > 20) {// 截取时间
				userlasttime = userlasttime.substring(0,
						userlasttime.length() - 2);
			}
		}

		// 案件处理人信息
		String currOperatorCode = reportInfoMap.get("operatorCode") + "";
		String currOperatorName = getCurrentOperatorName(currOperatorCode);
		reportInfoMap.put("currOperatorCode", currOperatorCode);
		reportInfoMap.put("currOperatorName", currOperatorName);

		request.setAttribute("customerChatList", customerChatList);
		request.setAttribute("reportInfoMap", reportInfoMap);

		request.setAttribute("userlasttime", userlasttime);
		request.setAttribute("userImageUrl", userImageUrl);

		request.setAttribute("registno", registno);
		request.setAttribute("operatorCode", operatorcode);
		request.setAttribute("roleCode", rolecode);
		request.setAttribute("openid", openid);
		return "weixin/mutilcustomerservice/customerhistorychat";
	}

	/**
	 * 根据条件查询历史案件信息
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(params = "historyRegistNoList")
	@ResponseBody
	public AjaxJson historyRegistNoList(HttpServletRequest request)
			throws Exception {
		AjaxJson jsonString = new AjaxJson();
		Map<String, Object> reportInfoMap = new HashMap<String, Object>();
		// 查询条件
		String operatorCode = request.getParameter("operatorcode");
		String roleCode = request.getParameter("rolecode");
		String licenseno = java.net.URLDecoder.decode(
				request.getParameter("licenseno"), "UTF-8");
		String registno = request.getParameter("registno");
		String startTime = request.getParameter("startTime");
		String endTime = request.getParameter("endTime");

		// 当前页码
		String currPageNoTemp = request.getParameter("currpageno");
		int currPageNo = 0;
		if (!StringUtils.isEmpty(currPageNoTemp)) {
			currPageNo = Integer.parseInt(currPageNoTemp);
		}

		// 获取当前客服分页案件号信息
		List<Map<String, Object>> registNoList = customerChatService
				.getPageHistoryRegistNoListByOperatorCode(currPageNo,
						operatorCode, roleCode, licenseno, registno, startTime,
						endTime);
		// 分页案件总记录数
		int total = customerChatService
				.getHistoryRegistNoListByOperatorCode(operatorCode, roleCode,
						licenseno, registno, startTime, endTime).size();

		reportInfoMap.put("total", total);

		if (registNoList.size() <= 0) {
			jsonString.setMsg("没有查询到符合条件的案件信息！");
			jsonString.setSuccess(false);
		} else {
			reportInfoMap.put("registNoList", registNoList);
			jsonString.setAttributes(reportInfoMap);
		}

		return jsonString;
	}

	/**
	 * 根据案件号查询历史聊天记录
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(params = "historyChatInfoList")
	@ResponseBody
	public String historyChatInfoList(HttpServletRequest request)
			throws Exception {
		AjaxJson jsonString = new AjaxJson();
		String registno = request.getParameter("registno");

		// 指定案件信息
		Map<String, Object> reportInfoMap = reportInfoService
				.getReportInfoByRegistNo(registno);

		// 指定案件号的所有聊天记录
		List<Map<String, Object>> customerChatList = getCustomerServiceChatAll(registno);

		// 指定案件号的最后聊天时间
		String userlasttime = "";
		for (Map<String, Object> tempMap : customerChatList) {
			userlasttime = tempMap.get("userlasttime") + "";
			if (userlasttime.length() > 20) {// 截取时间
				userlasttime = userlasttime.substring(0,
						userlasttime.length() - 2);
			}
		}
		// 案件处理人信息
		String currOperatorCode = reportInfoMap.get("operatorCode") + "";
		String currOperatorName = getCurrentOperatorName(currOperatorCode);
		reportInfoMap.put("currOperatorCode", currOperatorCode);
		reportInfoMap.put("currOperatorName", currOperatorName);

		reportInfoMap.put("customerChatList", customerChatList);
		reportInfoMap.put("userlasttime", userlasttime);
		jsonString.setAttributes(reportInfoMap);        
		return jsonString.getJsonStr();
	}

	/**
	 * 检测对话是否超时
	 * 
	 * @param request
	 * @return
	 * @throws ParseException
	 */
	private void checkRegistIsTimeout(String operatorCode, String roleCode) {
		// 超时25分钟的案件
		List<Map<String, Object>> registNoTWList = customerChatService
				.getTimeoutTWRegistNoListByOperatorCode(operatorCode, roleCode);
		// 超时30分钟的案件
		List<Map<String, Object>> registNoTHList = customerChatService
				.getTimeoutTHRegistNoListByOperatorCode(operatorCode, roleCode);

		for (Map<String, Object> tempMap : registNoTWList) {
			String openid = tempMap.get("openid") + "";
			int sessionState = Integer.parseInt(tempMap.get("sessionState")
					+ "");
			// 检测会话未结束的案件
			if (sessionState == Constants.WECHATCLAIMS_REGISTNO_SESSTIONSTATE_LINE) {
				// 调用更新状态接口(25-30分钟内等待客户输入信息)
				WeChatContext weChatContext = (WeChatContext) CachedUtils
						.get(Constants.MEMKEY_WEIXIN_WeChat_claims + openid);
				if (weChatContext != null) {
					claimsSessionManagementService
							.sendCloseSessionMessage(openid);
				}
			}
		}
		for (Map<String, Object> tempMap : registNoTHList) {

			int sessionState = Integer.parseInt(tempMap.get("sessionState")
					+ "");
			String openid = tempMap.get("openid") + "";
			String registNo = tempMap.get("registNo") + "";

			// 检测会话未结束的案件
			if (sessionState == Constants.WECHATCLAIMS_REGISTNO_SESSTIONSTATE_LINE) {
				boolean returnRes = reportInfoService
						.updReportInfoByRegistNo(registNo);
				if (returnRes) {
					// 给微信端发送关闭消息 调用善奇接口
					WeChatContext weChatContext = (WeChatContext) CachedUtils
							.get(Constants.MEMKEY_WEIXIN_WeChat_claims + openid);
					if (weChatContext != null) {
						claimsSessionManagementService
								.timeoutCloseSession(openid);
					}
				}
			}
		}
	}

	/**
	 * 获取当前案件处理人信息
	 * 
	 * @param currOperatorCode
	 * @return
	 */
	private String getCurrentOperatorName(String currOperatorCode) {
		String userName = "";
		TSBaseUser tsBaseUser = customerChatService
				.getTSBaseUser(currOperatorCode);
		if (null != tsBaseUser) {
			userName = tsBaseUser.getRealName();
		}
		return userName;
	}

	/**
	 * 根据报案号获取所有历史聊天记录
	 * 
	 * @param registNo
	 * @return
	 */
	private List<Map<String, Object>> getCustomerServiceChatAll(String registNo) {

		List<Map<String, Object>> customerServiceChatList = new ArrayList<Map<String, Object>>();
		// sql查询指定案件好的聊天记录
		List<Map<String, Object>> tempList = this.customerChatService
				.getCustomerServiceChatList(registNo);
		int i = 0;
		int count = tempList.size() - 1;
		String currentDate = null;
		for (Map<String, Object> tempMap : tempList) {
			String tempDate = null;
			Map<String, Object> customerServiceChatMap = new HashMap<String, Object>();
			customerServiceChatMap.put("id", tempMap.get("id"));
			customerServiceChatMap.put("claim_registno",
					tempMap.get("claim_registno"));
			customerServiceChatMap.put("message_id", tempMap.get("message_id"));
			customerServiceChatMap.put("message_source",
					tempMap.get("message_source"));
			customerServiceChatMap.put("message_readed",
					tempMap.get("message_readed"));
			customerServiceChatMap.put("customer_service_id",
					tempMap.get("customer_service_id"));
			customerServiceChatMap.put("createtime", tempMap.get("createtime"));

			// tempDate聊天历史记录按日期分段
			// 循环第一次时
			if (currentDate == null) {
				tempDate = DateUtils.dataformat(tempMap.get("createtime") + "",
						"yyyy-MM-dd");
				currentDate = tempDate;
			} else {
				if (!currentDate.equals(DateUtils.dataformat(
						tempMap.get("createtime") + "", "yyyy-MM-dd"))) {
					tempDate = DateUtils.dataformat(tempMap.get("createtime")
							+ "", "yyyy-MM-dd");
					currentDate = tempDate;
				}
			}
			customerServiceChatMap.put("tempDate", tempDate);

			// 获取聊天详细信息
			int source = (int) tempMap.get("message_source");
			// 客服
			if (source == Constants.WECHATCLAIMS_MESSAGE_SOURCE_CUSTOMERSERVICE) {
				String customerId = (String) tempMap.get("customer_service_id");
				WeiXinCustomerServiceChatInfo customerServiceChatInfo = customerChatService
						.getWeiXinCustomerServiceChatInfo(customerId);
				customerServiceChatMap.put("customerServiceChatInfo",
						customerServiceChatInfo);
				// 保存客服最后一次回复的时间
				if (i == count) {
					customerServiceChatMap.put("userlasttime",
							customerServiceChatInfo.getCreateTime());
				}
			}
			// 用户
			if (source == Constants.WECHATCLAIMS_MESSAGE_SOURCE_USER) {
				String messageId = (String) tempMap.get("message_id");
				ReceiveMessage receiveMessage = customerChatService
						.getReceiveMessage(messageId);
				customerServiceChatMap.put("receiveMessage", receiveMessage);
				// 保存用户最后一次回复的时间
				if (i == count) {
					customerServiceChatMap.put("userlasttime",
							receiveMessage.getCreateTime());
				}
			}
			customerServiceChatList.add(customerServiceChatMap);
			i++;
		}
		return customerServiceChatList;
	}

	/**
	 * 更新未读信息状态
	 * 
	 * @param registNo
	 * @return
	 */
	private void updCustomerServiceChatMessageReadedById(
			List<Map<String, Object>> customerChatNotReadedList) {
		String ids = "";

		for (Map<String, Object> tempMap : customerChatNotReadedList) {
			ids += "'" + tempMap.get("cid") + "',";
		}
		if (ids.length() > 0) {
			ids = ids.substring(0, ids.length() - 1);
		}
		if (StringUtils.isEmpty(ids)) {
			logger.info("update ids value fail: ids is null");
		} else {
			logger.info("update ids value:" + ids);
			customerChatService.updCustomerServiceChatMessageReadedById(ids); // 正式环境开启
		}
	}

	/**
	 * 获取已读信息
	 * 
	 * @param registNo
	 * @return
	 */
	private List<Map<String, Object>> getCustomerServiceChatReaded(
			String registNo) {
		List<Map<String, Object>> customerServiceChatReadedList = new ArrayList<Map<String, Object>>();
		// Sql查询的已读信息
		List<Map<String, Object>> tempList = this.customerChatService
				.getCustomerServiceChatReaded(registNo);
		int i = 0;
		int count = tempList.size() - 1;
		for (Map<String, Object> tempMap : tempList) {
			Map<String, Object> customerServiceChatMap = new HashMap<String, Object>();
			customerServiceChatMap.put("id", tempMap.get("id"));
			customerServiceChatMap.put("claim_registno",
					tempMap.get("claim_registno"));
			customerServiceChatMap.put("message_id", tempMap.get("message_id"));
			customerServiceChatMap.put("message_source",
					tempMap.get("message_source"));
			customerServiceChatMap.put("message_readed",
					tempMap.get("message_readed"));
			customerServiceChatMap.put("customer_service_id",
					tempMap.get("customer_service_id"));
			customerServiceChatMap.put("createtime", tempMap.get("createtime"));
			// 获取聊天详细信息
			int source = (int) tempMap.get("message_source");
			// 客服
			if (source == Constants.WECHATCLAIMS_MESSAGE_SOURCE_CUSTOMERSERVICE) {
				String customerId = (String) tempMap.get("customer_service_id");
				WeiXinCustomerServiceChatInfo customerServiceChatInfo = customerChatService
						.getWeiXinCustomerServiceChatInfo(customerId);
				customerServiceChatMap.put("customerServiceChatInfo",
						customerServiceChatInfo);
				// 保存客服最后一次回复的时间
				if (i == count) {
					customerServiceChatMap.put("userlasttime",
							customerServiceChatInfo.getCreateTime());
				}
			}
			// 用户
			if (source == Constants.WECHATCLAIMS_MESSAGE_SOURCE_USER) {
				String messageId = (String) tempMap.get("message_id");
				ReceiveMessage receiveMessage = customerChatService
						.getReceiveMessage(messageId);
				customerServiceChatMap.put("receiveMessage", receiveMessage);
				// 保存用户最后一次回复的时间
				if (i == count) {
					customerServiceChatMap.put("userlasttime",
							receiveMessage != null ? receiveMessage.getCreateTime() : "");
				}
			}
			customerServiceChatReadedList.add(customerServiceChatMap);
			i++;
		}
		return customerServiceChatReadedList;
	}

	/**
	 * 获取多媒体消息数据流
	 */
	@RequestMapping(params = "getMediaidStream")
	public void getMediaidStream(HttpServletRequest request,
			HttpServletResponse response) {

		String mediaid = request.getParameter("mediaid");
		InputStream inputStream = null;
		byte[] byteArr = WeixinUtil.blockingDownloadMedia(mediaid);
		ReceiveMessage receiveMessage = receiveMessageService
				.findUniqueByProperty(ReceiveMessage.class, "mediaId", mediaid);
		if (byteArr != null && byteArr.length > 0) {
			inputStream = new ByteArrayInputStream(byteArr);
			this.writeStreamToResponse(inputStream,
					receiveMessage.getContentType(), response);
		} else {
			logger.info("getMediaidStream byteArr is null mediaid=>" + mediaid);
		}

	}

	/**
	 * 把流输出要页面
	 * 
	 * @param inputStream
	 * @param contentType
	 * @param response
	 */
	private void writeStreamToResponse(InputStream inputStream,
			String contentType, HttpServletResponse response) {
		BufferedInputStream bis = new BufferedInputStream(inputStream);
		// 头信息
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		response.setContentType(contentType);

		byte[] b = new byte[1024];
		try {
			while (bis.read(b) > -1) {
				response.getOutputStream().write(b);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (inputStream != null) {

				try {
					inputStream.close();
				} catch (IOException e) {
					logger.info("close inputStream IOException");
				}
			}
			if (bis != null) {

				try {
					bis.close();
				} catch (IOException e) {
					logger.info("getVoice IOException");
				}
			}

		}
	}

	@RequestMapping(params = "testGetReport")
	public String testGetReport(HttpServletRequest request) {
		GetReportRunnable getReportRunnable;
		String[][] argArray = { { "openid15159773283", "15159773283" },
				{ "openid15659258278", "15659258278" },
				{ "openid18965859231", "18965859231" },
				{ "openid13959295086", "13959295086" },
				{ "openid18965852380", "18965852380" },
				{ "openid13364116677", "13364116677" },
				{ "openid13606918469", "13606918469" },
				{ "openid18059253009", "18059253009" },
				{ "openid13666095718", "13666095718" },
				{ "openid18965116117", "18965116117" },
				{ "openid13959295086", "13959295086" } };
		for (int i = 0; i < argArray.length; i++) {
			getReportRunnable = new GetReportRunnable(argArray[i][0],
					argArray[i][1]);
			Thread testThread = new Thread(getReportRunnable);
			testThread.start();

		}
		return "";
	}

}
