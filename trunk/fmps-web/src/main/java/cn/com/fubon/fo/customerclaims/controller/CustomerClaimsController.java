package cn.com.fubon.fo.customerclaims.controller;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import jodd.datetime.JDateTime;
import jodd.util.StringUtil;
import org.apache.log4j.Logger;
import org.jeecgframework.core.common.service.CommonService;
import org.jeecgframework.core.util.ResourceUtil;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import weixin.guanjia.account.service.WeixinAccountServiceI;
import weixin.popular.api.MessageAPI;
import cn.com.fubon.fo.customerbind.service.CustomerBindService;
import cn.com.fubon.fo.customerclaims.service.ICustomerClaimsService;
import cn.com.fubon.util.CachedUtils;
import cn.com.fubon.util.Constants;
import cn.com.fubon.util.CurrencyUtils;
import cn.com.fubon.webservice.WsConstants;
import cn.com.fubon.webservice.entity.response.FbWSResponse;
import cn.com.fubon.wechatClaims.entity.ReportInfo;
import cn.com.fubon.wechatClaims.service.ClaimWebService;
import cn.com.fubon.wechatClaims.timingtask.ConfirmUnderwritingTask;

/**
 * 
 * @author shanqi.wang
 *
 */

@Scope("prototype")
@Controller
@RequestMapping("/fo/binded/customerClaims/customerClaimsController")
public class CustomerClaimsController{
	private static final Logger logger = Logger
			.getLogger(CustomerClaimsController.class);

	@Resource
	private ICustomerClaimsService customerClaimsService;

	@Resource
	private CustomerBindService customerBindService;

	@Resource
	private CommonService commonService;

	@Resource(name = "claimWebService")
	private ClaimWebService claimWebService;

	@Resource
	private WeixinAccountServiceI weixinAccountService;

	@Resource
	private ConfirmUnderwritingTask confirmUnderwritingTask;

	/**
	 * 根据客户id,查找客户理赔记录。一次返回客户所有保单理赔记录
	 * 
	 * @param request
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping(params = "method=getClaimsPolicyByCustomerId")
	public ModelAndView getClaimsPolicyByCustomerId(HttpServletRequest request)
			throws UnsupportedEncodingException{
		// String customerCode=(String)
		// request.getSession().getAttribute(Constants.SESSION_CUSTOMERCODE);
		/* 20141208 patrick.z */
		String openid = (String)request.getAttribute("openid");
		if(StringUtil.isEmpty(openid)){
			openid = request.getParameter("openid");
		}
		// String customerCode =(String)CachedUtils.get(openid);
		String identifynumber = (String)CachedUtils.get(openid
				+ Constants.MEMKEY_IDENTIFYNUMBER);
		String customercname = (String)CachedUtils.get(openid
				+ Constants.MEMKEY_CUSTOMERCNAME);
		// WeiXinGzUserInfo weiXinGzUserInfo =
		// customerBindService.findUniqueByProperty(WeiXinGzUserInfo.class,
		// "openid", openid);
		// identifynumber=weiXinGzUserInfo.getIdentifynumber();
		// customercname=weiXinGzUserInfo.getCustomercname();

		// logger.info("客户理赔控制类ModelAndViewCustomercode ====> " + customerCode);
		List<Map<String,Object>> customerClaimsRecord = customerClaimsService
				.getClaimsPolicyAllInformation(identifynumber,customercname);
		String policyNo = ""; // 初始保单号
		List<Map<String,Object>> customerClaimsList = new ArrayList<Map<String,Object>>(); // 传递到JSP的数据
		Map<String,Object> policyMap = new HashMap<String,Object>(); // 用于保存1个完整保单
		List<Map<String,Object>> policyClaimsRecordList = new ArrayList<Map<String,Object>>();// 用于保存理赔记录集合
		for(Map<String,Object> customerClaims : customerClaimsRecord){
			Map<String,Object> policyClaimsRecord = new HashMap<String,Object>(); // 用于保存1个完整理赔记录
			if(!customerClaims.get("policyno").equals(policyNo)){ // 保单号不同，
				policyNo = (String)customerClaims.get("policyno"); // 取下一个保单号。
				policyMap = new HashMap<String,Object>(); // 保全保单纪录
				policyClaimsRecordList = new ArrayList<Map<String,Object>>(); // 保全理赔纪录集合
				// 保单主要信息
				policyMap.put("policyno",customerClaims.get("policyno"));
				policyMap.put("applyName",customerClaims.get("applyName"));
				policyMap.put("insureName",customerClaims.get("insureName"));
				policyMap.put("licenseno",customerClaims.get("licenseno"));
				policyMap.put("startdate",customerClaims.get("startdate"));
				policyMap.put("enddate",customerClaims.get("enddate"));
				customerClaimsList.add(policyMap);
			}

			if(policyMap.get("claimRecord") != null){
				// 取出map中的list，加入新的理赔记录
				policyClaimsRecord.put("claimsdate",
						customerClaims.get("claimsdate"));
				policyClaimsRecord.put("claimsamount",
						customerClaims.get("claimsamount"));
				policyClaimsRecord.put("claimsStatus",
						customerClaims.get("claimsStatus"));
				((List<Map<String,Object>>)policyMap.get("claimRecord"))
						.add(policyClaimsRecord);
			}else{
				// 直接将理赔记录PUT到Map
				policyClaimsRecord.put("claimsdate",
						customerClaims.get("claimsdate"));
				policyClaimsRecord.put("claimsamount",
						customerClaims.get("claimsamount"));
				policyClaimsRecord.put("claimsStatus",
						customerClaims.get("claimsStatus"));
				policyClaimsRecordList.add(policyClaimsRecord);
				policyMap.put("claimRecord",policyClaimsRecordList);
			}
		}
		if(customerClaimsList.size() < 1){
			request.setAttribute("message","没有查询到您的理赔记录");
			return new ModelAndView("/fo/common/message");
		}else{
			request.setAttribute("customerClaimsList",customerClaimsList);
			return new ModelAndView("/fo/customerclaims/claimsInformation");
		}
	}

	/**
	 * 案件处理人准备做理赔金额确认,不进认证拦截器
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "method=prepareConfirmClaimFee")
	public String prepareConfirmClaimFee(HttpServletRequest request){

		// 通过getOpenid拦截器获取当前用户openid
		String openid = (String)request.getAttribute("openid");
		logger.info("prepareConfirmClaimFee request Attribute openid==>"
				+ openid);
		if(StringUtil.isEmpty(openid)){
			openid = request.getParameter("openid");
			logger.info("prepareConfirmClaimFee request Parameter openid==>"
					+ openid);
		}

		if(StringUtil.isEmpty(openid)){
			logger.warn("openid is Empty");
			request.setAttribute("message",
					Constants.CLAIM_FEE_CONFIRMED_INVALID_CURRENTOPENID);
			return "/fo/common/message";
		}

		// 获取核赔模板消息对应的案件号
		String registNo = request.getParameter("state");
		logger.info("prepareConfirmClaimFee registNo==>" + registNo);
		// 得到案件号对应的报案人的openid
		ReportInfo reportInfo = commonService.findUniqueByProperty(
				ReportInfo.class,"registNo",registNo);

		// 如果查不到微信案件信息,提示无该微信号的报案记录
		if(reportInfo == null){
			request.setAttribute("message",
					Constants.WS_CLAIM_FEE_CONFIRMED_FAILED);
			return "/fo/common/message";
		}

		// 如果已经核赔确认,则提示已核赔确认
		if(reportInfo.getConfirmTime() != null
				|| !StringUtil.isEmpty(reportInfo.getConfirmStyle())){
			request.setAttribute("message",
					Constants.CLAIM_FEE_CONFIRMED_SUCCESS);
			return "/fo/common/message";
		}

		// 核赔金额转成大写传给前端
		BigDecimal claimCaseFee = reportInfo.getClaimCaseFee();
		String upperClaimFee = CurrencyUtils.upperCurrency(claimCaseFee
				.toString());
		request.setAttribute("openid",openid);
		request.setAttribute("registNo",registNo);
		request.setAttribute("claimFee",claimCaseFee.toString());
		request.setAttribute("upperClaimFee",upperClaimFee);
		return "/fo/customerclaims/claimfeeconfirm";
	}

	/**
	 * 案件处理人做理赔金额确认
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "method=confirmClaimFee")
	public String confirmClaimFee(HttpServletRequest request){

		// 通过getOpenid拦截器获取当前用户openid
		String openid = (String)request.getAttribute("openid");
		logger.info("confirmClaimFee request Attribute openid==>" + openid);
		if(StringUtil.isEmpty(openid)){
			openid = request.getParameter("openid");
			logger.info("confirmClaimFee request Parameter openid==>" + openid);
		}

		logger.info("confirmClaimFee currentOpenid==>" + openid);

		// 报文中必须有weChatId节点,报文中的weChatId对应微信公众号的openid,值可以为空字符串
		if(openid == null){
			logger.warn("openid is null");
			request.setAttribute("message",
					Constants.CLAIM_FEE_CONFIRMED_INVALID_CURRENTOPENID);
			return "/fo/common/message";
		}

		String registNo = request.getParameter("registNo");
		logger.info("confirmClaimFee registNo==>" + registNo);
		ReportInfo reportInfo = commonService.findUniqueByProperty(
				ReportInfo.class,"registNo",registNo);
		// 如果核赔确认openid不是报案openid
		if(reportInfo == null){
			request.setAttribute("message",
					Constants.CLAIM_FEE_CONFIRMED_INVALID_REGISTNO);
			return "/fo/common/message";
		}
		String reportorOpenid = reportInfo.getOpenid();
		boolean isCurrentOpenidEqualsReportorOpenid = openid
				.equalsIgnoreCase(reportorOpenid);
		if(!isCurrentOpenidEqualsReportorOpenid){
			request.setAttribute("message",
					Constants.CLAIM_FEE_CONFIRMED_INVALID_OPENID);
			return "/fo/common/message";
		}

		logger.info("confirmClaimFee reportorOpenid==>" + reportorOpenid);
		logger.info("confirmClaimFee isCurrentOpenidEqualsReportorOpenid==>"
				+ isCurrentOpenidEqualsReportorOpenid);

		FbWSResponse response = claimWebService.claimFeeConfirmed(openid,
				registNo,Constants.WS_CLAIM_FEE_CONFIRM_STYLE_1);

		// 如果没有返回
		if(response == null){
			request.setAttribute("message",
					Constants.WS_CLAIM_FEE_CONFIRMED_FAILED);
			return "/fo/common/message";
		}

		// 如果没有返回成功
		if(!WsConstants.RETURNCODE_1.equals(response.getResponseHead()
				.getTransResponse().getReturnCode())){
			request.setAttribute("message",response.getResponseHead()
					.getTransResponse().getReturnMessage());
			return "/fo/common/message";
		}

		JDateTime jnow = new JDateTime(new Date());
		// 更新核赔确认时间以及核赔确认方式
		reportInfo.setConfirmStyle(Constants.WS_CLAIM_FEE_CONFIRM_STYLE_1);
		reportInfo.setConfirmTime(jnow.convertToSqlTimestamp());

		logger.info("sendMessageToFcps start,registNo==>" + registNo);
		// 异步调用企业号接口发送消息给员工
		confirmUnderwritingTask.sendMessageToFcps(reportInfo);

		// update实体
		commonService.saveOrUpdate(reportInfo);
		// 核赔金额转成大写
		BigDecimal claimCaseFee = reportInfo.getClaimCaseFee();
		String upperClaimFee = CurrencyUtils.upperCurrency(claimCaseFee
				.toString());
		request.setAttribute("claimFee",claimCaseFee.toString());
		request.setAttribute("upperClaimFee",upperClaimFee);
		return "/fo/customerclaims/claimfeeconfirmsuccessed";

	}

	/* 测试模板消息推送事件处理 */
	@RequestMapping(params = "method=testTemplateMessage2")
	public String testTemplateMessage2(HttpServletRequest request){
		String openid = request.getParameter("openid");

		// 核赔确认页面,临时转至其他页面做测试
		String url = request.getParameter("url");

		ResourceBundle resourceBundle = ResourceUtil.getBundleEnvAbout();
		// 模板编号
		String templateMessageId = resourceBundle
				.getString("template_message_id_2");

		Map<String,String> messageData = new HashMap<String,String>();
		messageData.put("first","尊敬的先生/女士，您的理赔案件最新进展信息");
		messageData.put("keyword1","闽D00000");
		messageData.put("keyword2","张三");
		messageData
				.put("keyword3",
						"2015-03-16日17时38分由黄小姐(13599521190)驾驶闽EBU866号车于福建省漳州市芗城区天宝镇大寨村235号发生碰撞事故");
		messageData.put("keyword4","1000.00");
		messageData.put("keyword5","行驶证");
		messageData
				.put("remark",
						"您好，案件已审核通过，赔款稍后会支付到您指定银行卡。请于5个工作日将所缺资料补齐。如有疑问您可回复数字 0 转微信人工客服或拨打4008-817-518进行咨询。【富邦财险】");

		new MessageAPI().sendTemplateMessage(templateMessageId,url,openid,
				messageData);
		return "";
	}
}
