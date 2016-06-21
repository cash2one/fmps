package cn.com.fubon.fo.customerbind.controller;

import java.net.URL;
import java.net.URLEncoder;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jodd.datetime.JDateTime;
import jodd.util.StringUtil;

import org.apache.log4j.Logger;
import org.jeecgframework.core.util.DateUtils;
import org.jeecgframework.core.util.IdcardUtils;
import org.jeecgframework.core.util.ResourceUtil;
import org.jeecgframework.core.util.UUIDGenerator;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import weixin.idea.huodong.entity.HuodongEntity;
import weixin.idea.huodong.service.HuodongService;
import cn.com.fubon.fo.customerbind.entity.WeiXinGzUserInfo;
import cn.com.fubon.fo.customerbind.service.CustomerBindService;
import cn.com.fubon.fo.dynamicpassword.service.DynamicPasswordService;
import cn.com.fubon.fo.dynamicpassword.service.ReadClauseService;
import cn.com.fubon.fo.personalcenter.service.PolicyService;
import cn.com.fubon.util.CachedUtils;
import cn.com.fubon.util.Constants;
import cn.com.fubon.util.FBStringUtils;
import cn.com.fubon.webservice.MainWebServiceClient;
import cn.com.fubon.webservice.WsConstants;
import cn.com.fubon.webservice.entity.request.FbWSRequest;
import cn.com.fubon.webservice.entity.request.FbWeixinBindRequestBody;
import cn.com.fubon.webservice.entity.request.RequestHead;

@Scope("prototype")
@Controller
@RequestMapping("/fo/customerBindController")
public class CustomerBindController {
	private static final Logger logger = Logger
			.getLogger(CustomerBindController.class);
	// 认证页面的地址
	private static final String BIND_INDEX_PAGE = "/fo/customerbind/customerBind";
	// 公共提示页面的地址
	private static final String FO_COMMON_MESSAGE_PAGE = "/fo/common/message";
	// 关注提示页面的地址
	private static final String SUBSCRIBE_MESSAGE_PAGE = "/fo/common/notSubscribe";

	@Resource
	private CustomerBindService customerBindService;

	@Resource(name = "coreosWSClientWeixinBind")
	private MainWebServiceClient wsClient;

	@Resource
	private DynamicPasswordService dynamicPasswordService;
	
	@Resource
	private HuodongService huodongService;
	
	@Resource(name="PolicyService")
	private PolicyService policyService;
	
	
	@Resource
	private ReadClauseService readClauseService;

	public CustomerBindController() {
	}

	private String getOpenid(HttpServletRequest request){
		String openid = request.getParameter("openid");
		if (StringUtil.isEmpty(openid)) {
			openid = (String) request.getAttribute("openid");
		}
		if (StringUtil.isEmpty(openid)) {
			openid = (String) request.getSession().getAttribute(Constants.SESSION_KEY_OPENID);
		}
		return openid;
	}
	
	/**
	 * 返回绑定页面
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "method=bindIndex")
	public String bindIndex(HttpServletRequest request) {
		request.setAttribute("requestPath", request.getParameter("requestPath"));
		String openid = getOpenid(request);

		if (StringUtil.isEmpty(openid)) {
			request.setAttribute("message",
					Constants.WEIXINBIND_MESSAGE_OPENID_IS_NULL);
			return FO_COMMON_MESSAGE_PAGE;
		}

		// 根据openid获取关注用户表数据,自动填上姓名customercname、身份证号码identifynumberother、手机号码mobileother
		WeiXinGzUserInfo weiXinGzUserInfo = customerBindService
				.findUniqueByProperty(WeiXinGzUserInfo.class, "openid", openid);
		if (weiXinGzUserInfo != null) {
			// 如果该微信号已经认证，返回个人中心 20150921 added by guofangfang begin
			if (weiXinGzUserInfo.getBindTime() != null) {
				CachedUtils.add(openid + Constants.MEMKEY_IDENTIFYNUMBER,
						weiXinGzUserInfo.getIdentifynumber().toUpperCase());
				CachedUtils.add(openid + Constants.MEMKEY_CUSTOMERCNAME,
						weiXinGzUserInfo.getCustomercname());

				return "redirect:/fo/binded/personalCenterController.do?method=Index&openid="
						+ openid;
			}
			// 如果该微信号已经认证，返回个人中心 20150921 added by guofangfang end

			request.setAttribute("customercname",
					weiXinGzUserInfo.getCustomercname());
			request.setAttribute("identifynumberother",
					weiXinGzUserInfo.getIdentifynumber());
			request.setAttribute("mobileother", weiXinGzUserInfo.getMobile());
		}

		request.setAttribute("openid", openid);
		logger.info("bindIndex openid==>" + openid);
		return "/fo/customerbind/customerBind";
	}

	/**
	 * 根据openid判断是否已绑定,若未绑定则做绑定操作,更新weixin_gzuserinfo 若已绑定则返回保单查询页面
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(params = "bindCustomer")
	public String bindCustomer(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		String requestPath = request.getParameter("requestPath");
		// 清空message
		request.setAttribute("message", "");

		String openid = getOpenid(request);
		String customercname = request.getParameter("customercname");
		String identifynumber = request.getParameter("identifynumberother");
		String mobile = request.getParameter("mobileother");
		String dynamicpassword = request.getParameter("dynamicpasswordother");

		// 如果字段为空或空字符串则返回message页面 20141014
		String message = "";

		// 1、校验openid是否为空
		if (StringUtil.isEmpty(openid)) {
			// openid为空,无法做绑定操作。
			logger.info(Constants.WEIXINBIND_MESSAGE_OPENID_IS_NULL);
			initRequestAttribute(request,
					Constants.WEIXINBIND_MESSAGE_OPENID_IS_NULL);
			return BIND_INDEX_PAGE;
		}

		// 2、校验openid以外的参数是否为空或空字符串,赋值提示信息
		if (StringUtil.isEmpty(identifynumber)) {
			message = Constants.WEIXINBIND_MESSAGE_IDENTIFYNUMBER_IS_NULL;
		} else if (StringUtil.isEmpty(mobile)) {
			message = Constants.WEIXINBIND_MESSAGE_MOBILE_IS_NULL;
		} else if (StringUtil.isEmpty(customercname)) {
			message = Constants.WEIXINBIND_MESSAGE_CUSTOMERCNAME_IS_NULL;
		} else if (StringUtil.isEmpty(dynamicpassword)) {
			message = Constants.WEIXINBIND_MESSAGE_DYNAMICPASSWORD_IS_NULL;
		}
		if (StringUtil.isNotEmpty(message)) {
			logger.info("message ==> " + message);
			initRequestAttribute(request, message);
			return BIND_INDEX_PAGE;
		}

		// 3、校验是否合法手机号
		if (!FBStringUtils.checkMobile(mobile)) {
			initRequestAttribute(request,
					Constants.WEIXINBIND_MESSAGE_UNAVAILABLE_MOBILE);
			return BIND_INDEX_PAGE;
		}

		// 4、验证码是否有效
		if (!dynamicPasswordService.isValidDynamicPassword(mobile,
				dynamicpassword)) {
			// 验证码不可用
			initRequestAttribute(request,
					Constants.WEIXINBIND_MESSAGE_UNAVAILABLE_DYNAMICPASSWORD);
			return BIND_INDEX_PAGE;
		}

		// 5、校验用户是否已关注
		WeiXinGzUserInfo weiXinGzUserInfo = customerBindService
				.findUniqueByProperty(WeiXinGzUserInfo.class, "openid", openid);

		// 6、校验微信号是否已认证
		if (weiXinGzUserInfo != null && weiXinGzUserInfo.getBindTime() != null) {
			// 该微信号已经绑定过,需要重新关注才可重新绑定
			initRequestAttribute(request, Constants.WEIXINBIND_MESSAGE_REBIND);
			return BIND_INDEX_PAGE;
		}

		// 7、校验客户是否已被其他微信号认证
		// 如果该客户已经绑定过其他微信号,需要后台人工改数 20150921 added by guofangfang
		if (customerBindService.isBinded(identifynumber, customercname)) {
			initRequestAttribute(request,
					Constants.WEIXINBIND_MESSAGE_CUSTOMER_REBIND);
			return BIND_INDEX_PAGE;
		}

		// 8、校验是否查到客户信息
		// 根据identifynumber,customercname取客户信息，Map返回的key是大写的
		Map<String, String> customerInfo = findCustomerInfo(identifynumber,
				customercname);
		if (customerInfo == null || customerInfo.isEmpty()) {
			// 不存在对应的客户信息
			logger.info("CustomerBindController message ==> "
					+ Constants.WEIXINBIND_MESSAGE_CUSTOMERINFO_NOTFOUND);
			initRequestAttribute(request,
					Constants.WEIXINBIND_MESSAGE_CUSTOMERINFO_NOTFOUND);
			return BIND_INDEX_PAGE;
		}

		saveOrUpdateWeiXinGzUserInfo(openid, customercname, identifynumber,
				mobile, customerInfo.get("customercode"));

		addIdentifynumberAndCustomercameToCache(openid, customercname,
				identifynumber);
		//电销红包
		//判断是否有符合电销需求的保单信息
		isNeedSendMessage(request,openid,customercname,identifynumber,mobile);
		// 转至称号页面或绑定前的页面
		if (StringUtil.isEmpty(requestPath)) {

			// 为了后续页面可以通过浏览器返回按钮返回称号页面 这里需要用redirect
			return "redirect:/fo/binded/personalCenterController.do?method=Index&openid="
					+ openid;
		}

		return "redirect:/" + requestPath + "&openid=" + openid;

	}

	/**
	 * 如果用户未绑定 根据identifynumber(证件号码),customercname(客户名称)
	 * 取customerInfo用于更新weixin_gzuserinfo
	 * 
	 * @param request
	 * @return 返回Object数组
	 */
	private Map<String, String> findCustomerInfo(String identifynumber,
			String customercname) {
		return customerBindService.findCustomerInfo(identifynumber,
				customercname);
	}

	/**
	 * 发送weiXinGzUserInfo部分信息给核心
	 * 
	 * @param openid
	 * @throws Exception
	 */
	private void sendMessageToCore(WeiXinGzUserInfo weiXinGzUserInfo)
			throws Exception {
		JDateTime jnow = new JDateTime(new Date());
		RequestHead requestHead = new RequestHead();
		requestHead
				.setClientCode(WsConstants.REQUEST_HEAD_KEY_CLIENT_CODE_COREOS);
		requestHead
				.setServerCode(WsConstants.REQUEST_HEAD_KEY_SERVER_CODE_CORE);
		requestHead
				.setTranscationCode(WsConstants.REQUEST_HEAD_KEY_TRANSATION_CODE_1);
		requestHead.setTranscationDate(jnow.toString("YYYYMMDD"));
		requestHead.setTranscationTime(jnow.toString("hhmmss"));
		requestHead.setTranscationSeqNo(UUIDGenerator.generate());

		FbWeixinBindRequestBody requestBody = new FbWeixinBindRequestBody();
		requestBody.setInsuredCode(weiXinGzUserInfo.getCustomercode());
		requestBody.setOpenid(weiXinGzUserInfo.getOpenid());
		requestBody.setNickName(weiXinGzUserInfo.getNickname());
		requestBody.setTelephone(weiXinGzUserInfo.getMobile());

		FbWSRequest request = new FbWSRequest();
		request.setRequestHead(requestHead);
		request.setRequestBody(requestBody);
		wsClient.setRequest(request);
		wsClient.startExecuteChain();
	}

	private HttpServletRequest initRequestAttribute(HttpServletRequest request,
			String message) {

		request.setAttribute("messageother", message);
		request.setAttribute("openid", request.getParameter("openid"));
		request.setAttribute("requestPath", request.getParameter("requestPath"));
		request.setAttribute("identifynumberother",
				request.getParameter("identifynumberother"));
		request.setAttribute("customercname",
				request.getParameter("customercname"));
		request.setAttribute("mobileother", request.getParameter("mobileother"));
		request.setAttribute("dynamicpasswordother",
				request.getParameter("dynamicpasswordother"));
		return request;

	}

	private void saveOrUpdateWeiXinGzUserInfo(String openid,
			String customercname, String identifynumber, String mobile,
			String customercode) throws Exception {
		WeiXinGzUserInfo weiXinGzUserInfo = customerBindService
				.findUniqueByProperty(WeiXinGzUserInfo.class, "openid", openid);
		weiXinGzUserInfo.setCustomercname(customercname);
		weiXinGzUserInfo.setIdentifynumber(identifynumber);
		weiXinGzUserInfo.setMobile(mobile);
		weiXinGzUserInfo.setBindTime(DateUtils.getTimestamp());
		// 如果是用身份证认证，就填充相关的客户性别，出生日期和证件类型代码
		boolean isIdCard = IdcardUtils.validateCard(identifynumber);
		if (isIdCard) {
			weiXinGzUserInfo.setIdentifyType(Constants.IDENTIFYTYPE_01);
			weiXinGzUserInfo.setCustomerSex(IdcardUtils
					.getGenderByIdCard(identifynumber));
			weiXinGzUserInfo.setCustomerBirthday(DateUtils.parseDate(
					IdcardUtils.getBirthByIdCard(identifynumber), "yyyyMMdd"));
		}

		customerBindService.saveOrUpdate(weiXinGzUserInfo);
		// 调用核心认证接口
		weiXinGzUserInfo.setCustomercode(customercode);
		sendMessageToCore(weiXinGzUserInfo);

	}

	/**
	 * 微信卡激活成功后,未认证客户自动认证,保存weixin_gzuserinfo
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(params = "bindCardCustomer")
	public String bindCardCustomer(HttpServletRequest request) throws Exception {
		String openid = request.getParameter("openid");
		if (StringUtils.isEmpty(openid)) {
			openid = (String) request.getAttribute("openid");
		}
		String customercname = request.getParameter("customercname");
		if (customercname != null) {
			customercname = java.net.URLDecoder.decode(customercname, "UTF-8");
		}
		String identifynumber = request.getParameter("identitynumber");
		String mobile = request.getParameter("phonenum");
		// 激活卡投保人客户代码
		String applicode = request.getParameter("applicode");

		addIdentifynumberAndCustomercameToCache(openid, customercname,
				identifynumber);

		saveOrUpdateWeiXinGzUserInfo(openid, customercname, identifynumber,
				mobile, applicode);

		return "redirect:/fo/binded/personalCenterController.do?method=Index&openid="
				+ openid;
	}
	
	private void addIdentifynumberAndCustomercameToCache(String openid,
			String customercname, String identifynumber) {
		// memcache中存证件号码和客户名称
		CachedUtils.add(openid + Constants.MEMKEY_IDENTIFYNUMBER,
				identifynumber.toUpperCase());
		CachedUtils.add(openid + Constants.MEMKEY_CUSTOMERCNAME, customercname);
	}
	
	//判断是否在活动期间内
	private   boolean isRangeOfDate(String  huodongid) {
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String startTime=(String)CachedUtils.get(Constants.HUODON_START_DATE+huodongid); //活动开始时间
		String endTime=(String)CachedUtils.get(Constants.HUODON_END_DATE+huodongid);  //活动结束时间		
		if(StringUtil.isEmpty(startTime)||StringUtil.isEmpty(endTime)){		
		   HuodongEntity huodongEntity=huodongService.getEntity(HuodongEntity.class,huodongid);		
		   startTime=sf.format(huodongEntity.getStarttime());
		   endTime=sf.format(huodongEntity.getEndtime());
		   CachedUtils.set(Constants.HUODON_START_DATE+huodongid,startTime);
		   CachedUtils.set(Constants.HUODON_END_DATE+huodongid,endTime);		
		}
		Date nowdate = new Date();
		try {
			if (nowdate.after(sf.parse(startTime))
					&& nowdate.before(sf.parse(endTime))) {
				return true;
			}
		} catch (ParseException e) {
			logger.error("日期格式化出错...", e);
			return false;
		}
		return false;
	}
	//是否符合查看条款领红包需求的保单，有就发送短信
	private void isNeedSendMessage(HttpServletRequest request,String openid,String customercname,String identifynumber,String mobile){
		boolean isRod=isRangeOfDate(Constants.TELESALE_READ_CLAUSE_huodongid);
		//是否在活动区间内
		if (isRod){
			String date =Constants.READ_CLAUSE_RULE_DATE;
			String channel=Constants.TELESALE_CHANNEL;
			//存放未领红包保单信息
			List<Map<String, Object>> unReadpolicys = new ArrayList<Map<String, Object>>();
			//符合电销看条款领红包的保单信息
			List<Map<String,Object>> policyInfos=policyService.findNotCarPolicyByTeleSale(customercname,identifynumber,date,channel);
			for(Map<String, Object> policy : policyInfos){
				Boolean isOutOfDay=ifOutOfDay(policy);
				List<Map<String, Object>> clauseList = policyService.findClauseByCoreProductCode(policy.get("productcode").toString());
				Map<String,Object> policyClause = policyService.findPolicyClauseReadByPolicyNo(policy.get("policyno").toString());
				if (!clauseList.isEmpty()&&!isOutOfDay&&policyClause==null){
					unReadpolicys.add(policy);
				}
			}
			//存在符合条件未领红包的保单，则调用短信接口发送消息提醒
			if(unReadpolicys.size()>0){
				String activedProfile = request.getSession().getServletContext().getInitParameter("spring.profiles.active");
				String configFileName = activedProfile != null && activedProfile.length() > 0 ? "dbconfig-" + activedProfile : "dbconfig";
				String url = ResourceBundle.getBundle(configFileName).getString("PLATFORM_MSG_URL");
				readClauseService.sendReadClauseMsg(url, Constants.CUSTOMER_READ_CLAUSE_MSGID, unReadpolicys.get(0).get("policyno").toString(), mobile,customercname);
			}
		}
	}
	
	/**
	 * 判断保单是否过期
	 * @param policyInfo
	 * @return
	 */
	private Boolean ifOutOfDay(Map<String, Object> policyInfo) {
		Date enddate = null;
		Boolean isoutOfDay = true;
		Timestamp ts =(Timestamp)policyInfo.get("enddate");  
		enddate =	new Date(ts.getTime());
		Date nowdate = new Date();
		if (enddate.after(nowdate)){
			isoutOfDay =false;
		}
		return isoutOfDay;
	}
}
