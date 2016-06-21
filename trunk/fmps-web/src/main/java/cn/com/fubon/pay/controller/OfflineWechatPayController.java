package cn.com.fubon.pay.controller;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import jodd.util.StringUtil;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.util.IdcardUtils;
import org.jeecgframework.core.util.IpUtil;
import org.jeecgframework.core.util.UUIDGenerator;
import org.jeecgframework.web.system.service.SystemService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import weixin.guanjia.account.entity.WeixinAccountEntity;
import weixin.guanjia.account.service.WeixinAccountServiceI;
import weixin.guanjia.core.util.WeixinUtil;
import cn.com.fubon.pay.entity.PaymentConstants;
import cn.com.fubon.pay.entity.WeiXinOfflineOrderDetail;
import cn.com.fubon.pay.entity.WeiXinOfflineOrderInfo;
import cn.com.fubon.pay.service.IPayService;
import cn.com.fubon.pay.service.OfflineWechatPayService;
import cn.com.fubon.pay.service.TelesaleWebService;
import cn.com.fubon.pay.service.WechatPayService;
import cn.com.fubon.util.CachedUtils;
import cn.com.fubon.util.Constants;
import cn.com.fubon.util.MD5Utils;
import cn.com.fubon.webservice.externl.telesalesystem.TelesaleWSConstants;

/**
 * 线下微信支付类
 * 
 * @author patrick.z
 */
@Scope("prototype")
@Controller
@RequestMapping("/pay/offlinePay")
public class OfflineWechatPayController {
	@Resource
	private OfflineWechatPayService offlineWechatPayService;

	@Resource
	private WechatPayService wechatPayServiceImpl;

	@Resource(name = "telesaleWebService")
	private TelesaleWebService telesaleWebService;

	@Resource
	private WeixinAccountServiceI weixinAccountService;

	@Resource
	private SystemService systemService;

	@Resource()
	private IPayService payServiceImpl;

	private static final Logger logger = Logger
			.getLogger(OfflineWechatPayController.class);

	public OfflineWechatPayController() {

	}

	/**
	 * 进入保费支付画面
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "payIndex")
	public String payIndex(HttpServletRequest request) {
		String code = request.getParameter("code");
		logger.info("code=>" + code);
		String openid = (String) request.getAttribute("openid");
		if (StringUtil.isEmpty(openid)) {
			openid = request.getParameter("openid");
		}
		logger.info("openid=>" + openid);
		if (StringUtil.isEmpty(openid)) {
			List<WeixinAccountEntity> weixinAccountEntityList = weixinAccountService
					.findValidWeixinAccounts();
			WeixinAccountEntity weixinAccountEntity = weixinAccountEntityList
					.get(0);
			openid = WeixinUtil.getOpenId(
					weixinAccountEntity.getAccountappid(),
					weixinAccountEntity.getAccountappsecret(), code);
			logger.info("根据code获取 openid,获取到的openid=>" + openid);
		}
		request.setAttribute("openid", openid);
		int versionNum = WeixinUtil.getWechatVersion(request);
		if (versionNum >= 5) {
			return "fo/offlinepay/payCode";
		} else {
			request.setAttribute("message", "您的微信版本过低，请升级版本为5.0以上！");
			return "/fo/common/message";
		}
	}

	/**
	 * 检测验证码和支付码状态
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(params = "checkValidateCode")
	@ResponseBody
	public AjaxJson checkValidateCode(HttpServletRequest request)
			throws Exception {
		AjaxJson jsonString = new AjaxJson();
		// 检查验证码/支付码状态
		String randCode = request.getParameter("randCode");
		String payCode = request.getParameter("payCode");

		String randCodeInSession = getSessionRandCode(request);
		logger.info("offlineWechatPay,from client, randCode=>" + randCode);
		boolean isValidateCodeValid = true;

		if (StringUtils.isEmpty(randCode) || StringUtils.isEmpty(payCode)) {
			isValidateCodeValid = false;
			jsonString.setMsg("请输入验证码和支付码！");
			jsonString.setSuccess(false);
		} else if (!randCode.equalsIgnoreCase(randCodeInSession)) {
			isValidateCodeValid = false;
			jsonString.setMsg("验证码错误！");
			jsonString.setSuccess(false);
		} else if (payCode.length() != 6) {
			isValidateCodeValid = false;
			jsonString.setMsg("支付码只能长度为6位！");
			jsonString.setSuccess(false);
		}
		if (isValidateCodeValid) {// 验证码通过
			// 调用核心接口检测支付码
			boolean checkRes = getCoreChkResByPayCode(payCode);
			String message = getCoreMessageByPayCode(payCode);

			if (!checkRes) {// 支付码不可用
				logger.info("offlineWechatPay,The paycode from browser do not use==>"
						+ payCode);
				jsonString.setMsg(message);
				jsonString.setSuccess(false);
			}
		}
		return jsonString;
	}

	/**
	 * 检测支付码状态(调用核心接口)
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(params = "checkPayCode")
	@ResponseBody
	public AjaxJson checkPayCode(HttpServletRequest request) throws Exception {
		AjaxJson jsonString = new AjaxJson();
		boolean isPayCodeValid = true;
		String payCode = request.getParameter("payCode");
		String openid = request.getParameter("openid");
		String totalpremium = request.getParameter("totalpremium"); //获取各险种保费之和

		if (StringUtils.isEmpty(payCode)) {
			isPayCodeValid = false;
			jsonString.setMsg("请输入支付码！");
			jsonString.setSuccess(false);
		} else if (payCode.length() != 6) {
			isPayCodeValid = false;
			jsonString.setMsg("支付码只能长度为6位！");
			jsonString.setSuccess(false);
		}
		if (isPayCodeValid) {
			// 调用核心接口检测支付码
			boolean checkRes = getCoreChkResByPayCode(payCode);
			String message = getCoreMessageByPayCode(payCode);

			if (!checkRes) {// 支付码不可用
				logger.info("offlineWechatPay,The paycode from browser do not use.");
				jsonString.setMsg(message);
				jsonString.setSuccess(false);
			} else {
				// 微信下单并返回JOSN对象
				String body = "";// 险种名称
				String json = "   ";
				String kindName = "";
				String outTradeNo = "";// 支付码
				String totalFee = "";// 总保费
				String attach = "";// 订单号+被保险人名称+核心订单号
				String orderId = "";// 订单号
				String spbillCreateIp = IpUtil.getPayIpAddr(request);
				WeiXinOfflineOrderInfo weiXinOfflineOrderInfo = offlineWechatPayService
						.getOrderInfoByPayCode(payCode);
				// 总费用处理 取分
				totalFee = String.valueOf(BigDecimal.valueOf(weiXinOfflineOrderInfo.getSumPremium()).multiply(BigDecimal.valueOf(100)).intValue());
				DecimalFormat df = new DecimalFormat("#.00");
				double sumP =weiXinOfflineOrderInfo.getSumPremium();
				double totalF = Double.parseDouble(totalpremium);
				if(Math.abs(sumP-totalF) > 0.1){//验证是否与核心的总金额相等
					logger.info("offlineWechatPay,totalFeeTemp no eq sumPremium.");
					jsonString.setMsg("总保费["+df.format(sumP)+"]与分项保费合计["+df.format(totalF)+"]不符，不允许进行支付。");
					jsonString.setSuccess(false);
				}else{
					attach = "CorePay"+","+weiXinOfflineOrderInfo.getPayCode()+","+weiXinOfflineOrderInfo.getInsuredName();
					outTradeNo = weiXinOfflineOrderInfo.getPayCode() + "_"
							+ UUIDGenerator.generate().substring(15);
					for (WeiXinOfflineOrderDetail weiXinOfflineOrderDetail : weiXinOfflineOrderInfo
							.getWeiXinOfflineOrderDetails()) {
						kindName = weiXinOfflineOrderDetail.getKindName();
						body += kindName + ",";
					}
					if (body.length() > 0) {
						body = body.substring(0, body.length() - 1);
					}
					logger.info("openid=body=outTradeNo=totalFee=spbillCreateIp=attach===>"
							+ openid
							+ ":"
							+ body
							+ ":"
							+ outTradeNo
							+ ":"
							+ totalFee + ":" + spbillCreateIp + ":" + attach);
					// 调用支付接口返回支付jason
					String activedProfile = request.getSession()
							.getServletContext()
							.getInitParameter("spring.profiles.active");
					if (activedProfile.equals("prod")) {// 生产环境
						json = wechatPayServiceImpl.getPayJsRequestJson(openid,
								body, outTradeNo, totalFee, spbillCreateIp, attach);
					} else {// 其他环境
						json = wechatPayServiceImpl.getPayJsRequestJson(openid,
								body, outTradeNo, "1", spbillCreateIp, attach);
					}
					jsonString.setObj(json);
					logger.info("getPayJosn=openid+json====>" + openid + ":" + json);
					// 记录系统日志
					message = "OfflineWechatPay,payCode:[" + payCode + "]发起支付！";
					systemService.addLog(message, Globals.Log_Type_INSERT,
							Globals.Log_Leavel_INFO);
				}
			}
		}
		return jsonString;
	}

	/**
	 * 保费支付
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(params = "payOrder")
	public String payOrder(HttpServletRequest request) throws Exception {
		// 检查验证码状态
		String randCode = request.getParameter("randCode");
		String randCodeInSession = getSessionRandCode(request);
		if (!randCode.equalsIgnoreCase(randCodeInSession)) {
			logger.info("The randcode from browser not equal in httpsession.");
			request.setAttribute("message", "验证码错误！");
			return "/fo/offlinepay/payFail";
		}
		String payCode = request.getParameter("paycode");
		String openid = (String) request.getAttribute("openid");
		if (StringUtil.isEmpty(openid)) {
			openid = request.getParameter("openid");
		}
		String orderId = "";// 订单号
		String kindType = "0";// 0车险 1 非车险
		Map<String, Object> detailList = null;
		WeiXinOfflineOrderInfo weiXinOfflineOrderInfo = offlineWechatPayService
				.getOrderInfoByPayCode(payCode);
		detailList = offlineWechatPayService.getOrderInfoByDetail(weiXinOfflineOrderInfo.getId());
		//保存返回的总金额
		String totalpremium = "";
		Double total = 0.0;
		DecimalFormat df = new DecimalFormat("#.00");
		for (WeiXinOfflineOrderDetail weiXinOfflineOrderDetail : weiXinOfflineOrderInfo
				.getWeiXinOfflineOrderDetails()) {
			total+= Double.parseDouble(weiXinOfflineOrderDetail.getPremium());
		}
		totalpremium = df.format(total);
		// 参照起保日期来判断当前日期是否过期
		int isEqDate = -1;
		boolean isGtDate = false;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		// 系统当前日期
		String dateSysString = sdf.format(new java.util.Date());
		Date dateSysTemp = sdf.parse(dateSysString);
		if (null != weiXinOfflineOrderInfo.getId()) {
			isGtDate = dateSysTemp.after(weiXinOfflineOrderInfo
					.getPolicyStartDate());
			isEqDate = (dateSysTemp.compareTo(weiXinOfflineOrderInfo
					.getPolicyStartDate()));
		}
		// 订单信息
		if (null == weiXinOfflineOrderInfo.getId()) {
			request.setAttribute("message", "微信支付订单信息为空，下单失败！");
			return "/fo/offlinepay/payFail";
		} else if (weiXinOfflineOrderInfo.getPayStatus() == TelesaleWSConstants.PAYSTATUS_SUCCESS) {
			request.setAttribute("message", "微信支付订单状态为支付成功，下单失败！");
			return "/fo/offlinepay/payFail";
		} else if (weiXinOfflineOrderInfo.getPayStatus() == TelesaleWSConstants.PAYSTATUS_FAIL) {
			request.setAttribute("message", "微信支付订单状态为支付失败，下单失败！");
			return "/fo/offlinepay/payFail";
		} else if (isGtDate || isEqDate == 0) {// 判断 起保日期 >当前日期
			request.setAttribute(
					"message",
					"微信支付订单起保日期已过期，有效期为"
							+ sdf.format(weiXinOfflineOrderInfo
									.getPolicyStartDate()) + "，下单失败！");
			return "/fo/offlinepay/payFail";
		} else if (!getChkResByPayCodeStatus(weiXinOfflineOrderInfo
				.getPayCodeStatus())) {// 支付码状态检测
			String message = getMessageByPayCodeStatus(weiXinOfflineOrderInfo
					.getPayCodeStatus());
			request.setAttribute("message", message);
			return "/fo/offlinepay/payFail";
		} else if (null != weiXinOfflineOrderInfo.getId()
				& weiXinOfflineOrderInfo.getPayStatus() == TelesaleWSConstants.PAYSTATUS_NOTPAY) {
			orderId = weiXinOfflineOrderInfo.getId();
			// 非车/车险判断
			String classType = weiXinOfflineOrderInfo.getClassCode();
			if (classType.toUpperCase()
					.equals(TelesaleWSConstants.CLASSCODE_CX)) {// 车险
				kindType = "0";
			}
			if (classType.toUpperCase()
					.equals(TelesaleWSConstants.CLASSCODE_FC)) {// 非车
				kindType = "1";
			}
			// 身份证加密
			String identifyNumber = weiXinOfflineOrderInfo.getIdentifyNumber();
			identifyNumber = IdcardUtils
					.getEncryptionIdentifyNum(identifyNumber);
			weiXinOfflineOrderInfo.setIdentifyNumber(identifyNumber);
		}
		request.setAttribute("payCode", weiXinOfflineOrderInfo.getPayCode());
		request.setAttribute("kindType", kindType);
		request.setAttribute("orderId", orderId);
		request.setAttribute("openid", openid);
		// changed by laiyaobin 201512041749
		request.setAttribute("detailList", detailList);
		request.setAttribute("weiXinOfflineOrderInfo", weiXinOfflineOrderInfo);
		request.setAttribute("totalpremium", totalpremium);
		// changed by qingqu.huang 201509221746
		request.setAttribute("paytype", "wxpay");
		return "fo/offlinepay/policyInfo";
	}

	/**
	 * 保费支付结果
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "showPayResult")
	public String showPayResult(HttpServletRequest request) {
		String resultType = request.getParameter("result");
		String orderId = request.getParameter("orderId");
		String payCode = request.getParameter("payCode");
		String msg = request.getParameter("msg");
		String openid = (String) request.getAttribute("openid");
		if (StringUtil.isEmpty(openid)) {
			openid = request.getParameter("openid");
		}
		logger.info("showPayResult,orderId=>" + orderId + "\bresultType=>"
				+ resultType + "\bmsg=>" + msg);
		/* 微信支付日志处理 */
		offlineWechatPayService.saveOrderInfoLog(orderId, resultType, msg);

		if (resultType.equals("success")) {
			// 记录系统日志
			String message = "OfflineWechatPay,payCode:[" + payCode + "]支付成功！";
			systemService.addLog(message, Globals.Log_Type_INSERT,
					Globals.Log_Leavel_INFO);
			WeiXinOfflineOrderInfo weiXinOfflineOrderInfo = payServiceImpl
					.getEntity(WeiXinOfflineOrderInfo.class, orderId);
			if (weiXinOfflineOrderInfo.getPayStatus() != 1) {
				offlineWechatPayService.updOrderInfoByOrderIdAndStatus(orderId,
						3);
			}
			try {
				telesaleWebService.ReceivePayCodeStatus(weiXinOfflineOrderInfo.getPaycodemd5(), PaymentConstants.PAYCODESTATUS_006);
			} catch (Exception e) {
				logger.error("支付完成调用通知公共服务接口错误。。。", e);
			}
			request.setAttribute("openid", openid);
			return "/fo/offlinepay/payResult";
		} else {
			offlineWechatPayService.updOrderInfoByOrderIdAndStatus(orderId, 2);
			request.setAttribute("message", "保费支付失败！" + msg);
			return "/fo/offlinepay/payFail";
		}
	}

	/**
	 * 根据支付码调用核心接口返回文字信息(对外调用)
	 * 
	 * @param payCodeStatus
	 * @return String
	 * @throws Exception
	 */
	private String getCoreMessageByPayCode(String payCode) throws Exception {
		String message = (String) checkCorePayCode(payCode).get("coreMessage");
		return message;
	}

	/**
	 * 根据支付码调用核心接口检测支付码是否可用(对外调用)
	 * 
	 * @param payCodeStatus
	 * @return boolean
	 * @throws Exception
	 */
	private boolean getCoreChkResByPayCode(String payCode) throws Exception {
		boolean checkRes = Boolean.parseBoolean(checkCorePayCode(payCode).get(
				"coreChkReturn")
				+ "");
		return checkRes;
	}

	/**
	 * 根据支付码状态返回文字信息(对外调用)
	 * 
	 * @param payCodeStatus
	 * @return String
	 */
	private String getMessageByPayCodeStatus(String payCodeStatus) {
		String message = (String) getPayCodeStatus(payCodeStatus)
				.get("message");
		return message;
	}

	/**
	 * 根据支付码状态检测支付码是否可用(对外调用)
	 * 
	 * @param payCodeStatus
	 * @return boolean
	 */
	private boolean getChkResByPayCodeStatus(String payCodeStatus) {
		boolean checkRes = Boolean.parseBoolean(""
				+ getPayCodeStatus(payCodeStatus).get("chkReturn"));
		return checkRes;
	}

	/**
	 * 支付码状态文字信息 key：message,chkReturn 如果状态是005（支付成功），checkReturn则返回true,message
	 * 为支付码没通过的错误信息
	 * 
	 * @param payCodeState
	 * @return orderPayCodeStatusMap
	 */
	private Map<String, Object> getPayCodeStatus(String payCodeStatus) {
		String message = "支付码不存在！";
		boolean res = false;
		if (payCodeStatus.equals(TelesaleWSConstants.PAYCODESTATUS_1))
			message = "您输入的支付码不存在，请重新输入！";
		if (payCodeStatus.equals(TelesaleWSConstants.PAYCODESTATUS_2))
			message = "您输入的支付码已过期，请与工作人员联系，获取新的支付码！";
		if (payCodeStatus.equals(TelesaleWSConstants.PAYCODESTATUS_3))
			message = "您输入的支付码已失效，请与工作人员联系，获取新的支付码！";
		if (payCodeStatus.equals(TelesaleWSConstants.PAYCODESTATUS_4))
			message = "您输入的支付码已完成支付，请重新输入！";
		if (payCodeStatus.equals(TelesaleWSConstants.PAYCODESTATUS_5))
			res = true;
		Map<String, Object> orderPayCodeStatusMap = new HashMap<String, Object>();
		orderPayCodeStatusMap.put("message", message);
		orderPayCodeStatusMap.put("chkReturn", res);// 测试 true
		return orderPayCodeStatusMap;
	}

	/**
	 * 从session获取验证码
	 * 
	 * @param request
	 * @return String
	 */
	private String getSessionRandCode(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String openid = request.getParameter("openid");
		String randCodeInSession = (String) session
				.getAttribute(Constants.SESSION_KEY_RAND_CODE);
		logger.info("offlineWechatPay,from server session, randCode=>"
				+ randCodeInSession + ",sessionid=>" + session.getId());
		// 若session为空则从membercahced中取值
		if (StringUtils.isEmpty(randCodeInSession)) {
			randCodeInSession = (String) CachedUtils.get("randCode" + openid);
			logger.info("offlineWechatPay,from server membercahced, randCode=>"
					+ randCodeInSession);
		}
		return randCodeInSession;
	}

	/**
	 * 调用核心接口检测支付码
	 * 
	 * @param payCode
	 * @return orderPayCodeMap
	 * @throws Exception
	 */
	private Map<String, Object> checkCorePayCode(String payCode)
			throws Exception {
		// changed by qingqu.huang 201509221746
		if (StringUtil.isNotEmpty(payCode)) {
			payCode = MD5Utils.MD5(payCode);
		}
		String payCodeStatus = "";
		WeiXinOfflineOrderInfo weiXinOfflineOrderInfo = telesaleWebService
				.checkPayCode(payCode);
		if (null != weiXinOfflineOrderInfo
				&& null != weiXinOfflineOrderInfo.getPayCodeStatus()) {
			payCodeStatus = weiXinOfflineOrderInfo.getPayCodeStatus();
		}
		logger.info("offlineWechatPay,from client, payCode=>" + payCode);
		logger.info("offlineWechatPay,from server, payCodeStatus=>"
				+ payCodeStatus);
		boolean checkRes = getChkResByPayCodeStatus(payCodeStatus);
		String message = getMessageByPayCodeStatus(payCodeStatus);
		Map<String, Object> orderPayCodeMap = new HashMap<String, Object>();
		orderPayCodeMap.put("coreMessage", message);
		orderPayCodeMap.put("coreChkReturn", checkRes);
		return orderPayCodeMap;
	}
}