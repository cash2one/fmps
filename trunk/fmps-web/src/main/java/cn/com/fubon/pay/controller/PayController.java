/**
 * 
 */
package cn.com.fubon.pay.controller;

import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.util.IdcardUtils;
import org.jeecgframework.core.util.ResourceUtil;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.web.system.service.SystemService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

import weixin.popular.util.XMLConverUtil;
import cn.com.fubon.pay.entity.Notify;
import cn.com.fubon.pay.entity.PaymentConstants;
import cn.com.fubon.pay.entity.WeiXinOfflineOrderDetail;
import cn.com.fubon.pay.entity.WeiXinOfflineOrderInfo;
import cn.com.fubon.pay.service.IPayService;
import cn.com.fubon.pay.service.OfflineWechatPayService;
import cn.com.fubon.pay.service.TelesaleWebService;
import cn.com.fubon.util.Constants;
import cn.com.fubon.util.MD5Utils;
import cn.com.fubon.webservice.externl.telesalesystem.TelesaleWSConstants;

import com.alipay.util.AlipayNotify;

/**
 * 第三方支付controller
 * 
 * @author qingqu.huang
 * @date 20150612
 */
@Scope("prototype")
@Controller
@RequestMapping("/pay/payController")
public class PayController {

	private static final Logger logger = Logger.getLogger(PayController.class);
	@Resource()
	private IPayService payServiceImpl;
	@Resource()
	private OfflineWechatPayService offlineWechatPayService;
	@Resource
	private SystemService systemService;
	@Resource
	private TelesaleWebService telesaleWebService;

	/**
	 * 进入输入验证码页面
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "showRandCode")
	public String showRandCode(HttpServletRequest request) {
		String payCode = request.getParameter("PayCode_MD5");
		String paytype = request.getParameter("paytype");
		request.setAttribute("payCode", payCode);
		request.setAttribute("paytype", paytype);
		return "/fo/offlinepay/randCode";
	}

	/**
	 * 检查验证码是否正确
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "checkRandCode")
	@ResponseBody
	public AjaxJson checkRandCode(HttpServletRequest request) {
		AjaxJson jsonString = new AjaxJson();
		String randCode = request.getParameter("randCode");
		HttpSession session = request.getSession();
		String randCodeInSession = (String) session
				.getAttribute(Constants.SESSION_KEY_RAND_CODE);
		if (StringUtil.isEmpty(randCode)) {
			jsonString.setSuccess(false);
			jsonString.setMsg("请输入验证码");
		} else if (randCode.equalsIgnoreCase(randCodeInSession)) {
			jsonString.setSuccess(true);
		} else {
			jsonString.setSuccess(false);
			jsonString.setMsg("验证码错误");
		}
		return jsonString;
	}

	/**
	 * 进入保单详情页面
	 * 
	 * 如果带有参数，直接用参数初始化，否则取cookie中的保单号进行初始化
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "showPolicy")
	public String showPolicy(HttpServletRequest request,
			HttpServletResponse response) {
		logger.info("初始化保单详情...");
		String payCode = request.getParameter("payCode");
		String paytype = request.getParameter("paytype");
		String kindType = "";
		if (StringUtil.isEmpty(payCode)) {
			// 读取cookie中的保单号
			Cookie cookie = WebUtils.getCookie(request, "payCode");
			if (cookie != null) {
				String cookievalues = cookie.getValue();
				logger.info("cookie中存储的值为：" + cookievalues);
				String cookievalue[] = cookievalues.split(",");
				payCode = cookievalue[0];
				paytype = cookievalue[1];
			}
		}
		if (StringUtil.isEmpty(payCode)) {
			request.setAttribute("message", "网页访问失败，请确认链接是否正确...");
			return "/fo/offlinepay/payFail";
		}
		WeiXinOfflineOrderInfo weiXinOfflineOrderInfo = new WeiXinOfflineOrderInfo();
		// 1、验证支付码是否有效
		try {
			weiXinOfflineOrderInfo = telesaleWebService.checkPayCode(payCode);
			if (TelesaleWSConstants.PAYCODESTATUS_1
					.equalsIgnoreCase(weiXinOfflineOrderInfo.getPayCodeStatus())) {
				request.setAttribute("message", "网页访问失败，请确认链接是否正确...");
				return "/fo/offlinepay/payFail";
			}
			if (TelesaleWSConstants.PAYCODESTATUS_2
					.equalsIgnoreCase(weiXinOfflineOrderInfo.getPayCodeStatus())) {
				request.setAttribute("message", "您访问的链接已过期，请与工作人员联系，获取新的支付链接。");
				return "/fo/offlinepay/payFail";
			}
			if (TelesaleWSConstants.PAYCODESTATUS_3
					.equalsIgnoreCase(weiXinOfflineOrderInfo.getPayCodeStatus())) {
				request.setAttribute("message", "您访问的链接已失效，请与工作人员联系，获取新的支付链接。");
				return "/fo/offlinepay/payFail";
			}
			if (TelesaleWSConstants.PAYCODESTATUS_4
					.equalsIgnoreCase(weiXinOfflineOrderInfo.getPayCodeStatus())) {
				return "/fo/offlinepay/paySuccess";
			}
		} catch (Exception e) {
			logger.error("验证支付码接口调取失败", e);
			request.setAttribute("message", "获取投保单信息异常，请稍候重试");
			return "/fo/offlinepay/payFail";
		}
		Map<String, Object> detailList = null;
		try {
			// 2、从核心读取保单信息并保存到系统表里
			weiXinOfflineOrderInfo = offlineWechatPayService
					.getOrderInfoByPayCode(payCode);
			detailList = offlineWechatPayService.getOrderInfoByDetail(weiXinOfflineOrderInfo.getId());
		} catch (Exception e) {
			logger.error("通过支付码获取保单信息失败", e);
			request.setAttribute("message", "获取投保单信息异常，请稍候重试");
			return "/fo/offlinepay/payFail";
		}
		if (TelesaleWSConstants.CLASSCODE_CX
				.equalsIgnoreCase(weiXinOfflineOrderInfo.getClassCode())) {
			String licenseNo = weiXinOfflineOrderInfo.getLicenseNo();
			if (StringUtil.isNotEmpty(licenseNo)) {
				licenseNo = IdcardUtils.getEncryptionIdentifyNum(licenseNo);
				weiXinOfflineOrderInfo.setLicenseNo(licenseNo);
			}
			kindType = "0";
		} else {
			String identifyNumber = weiXinOfflineOrderInfo.getIdentifyNumber();
			if (StringUtil.isNotEmpty(identifyNumber)) {
				identifyNumber = IdcardUtils
						.getEncryptionIdentifyNum(identifyNumber);
				weiXinOfflineOrderInfo.setIdentifyNumber(identifyNumber);
			}
			kindType = "1";
		}
		String subject = "";
		String totalpremium = "";
		Double total = 0.0;
		DecimalFormat df = new DecimalFormat("#.00"); 
		for (WeiXinOfflineOrderDetail weiXinOfflineOrderDetail : weiXinOfflineOrderInfo
				.getWeiXinOfflineOrderDetails()) {
			subject += weiXinOfflineOrderDetail.getKindName() + ",";
			//保存核心返回的总金额
			total+= Double.parseDouble(weiXinOfflineOrderDetail.getPremium());
		}
		totalpremium = df.format(total);
		if(subject.length()>256){
			subject=subject.substring(0,252)+"...";
		}
		request.setAttribute("payCode", payCode);
		request.setAttribute("subject", subject);
		request.setAttribute("weiXinOfflineOrderInfo", weiXinOfflineOrderInfo);
		request.setAttribute("kindType", kindType);
		request.setAttribute("detailList", detailList);
		request.setAttribute("paytype", paytype);
		request.setAttribute("totalpremium", totalpremium);
		return "/fo/offlinepay/policyInfo";
	}

	/**
	 * 下单并跳转到第三方支付的登录界面
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "paypolicy", method = RequestMethod.POST)
	public String payPolicy(HttpServletRequest request,
			HttpServletResponse response) {
		logger.info("调用第三方支付");
		String paytype = request.getParameter("paytype");
		String out_trade_no = request.getParameter("orderid");
		String total_fee = request.getParameter("total_fee"); //总保额
		String payCode = request.getParameter("payCode");
		String subject = request.getParameter("subject");
		String totalpremium = request.getParameter("totalpremium"); //获取各险种保费之和
		double sumP = Double.parseDouble(total_fee);
		double totalF = Double.parseDouble(totalpremium);
		DecimalFormat df = new DecimalFormat("#.00");
		WeiXinOfflineOrderInfo weiXinOfflineOrderInfo = new WeiXinOfflineOrderInfo();
//		// 1、验证支付码是否有效
		try {
			weiXinOfflineOrderInfo = telesaleWebService.checkPayCode(payCode);
			if (TelesaleWSConstants.PAYCODESTATUS_1
					.equalsIgnoreCase(weiXinOfflineOrderInfo.getPayCodeStatus())) {
				request.setAttribute("message", "网页访问失败，请确认链接是否正确...");
				return "/fo/offlinepay/payFail";
			}
			if (TelesaleWSConstants.PAYCODESTATUS_2
					.equalsIgnoreCase(weiXinOfflineOrderInfo.getPayCodeStatus())) {
				request.setAttribute("message", "您访问的链接已过期，请与工作人员联系，获取新的支付链接。");
				return "/fo/offlinepay/payFail";
			}
			if (TelesaleWSConstants.PAYCODESTATUS_3
					.equalsIgnoreCase(weiXinOfflineOrderInfo.getPayCodeStatus())) {
				request.setAttribute("message", "您访问的链接已失效，请与工作人员联系，获取新的支付链接。");
				return "/fo/offlinepay/payFail";
			}
			if(Math.abs(sumP-totalF) > 0.1){//验证是否与核心的总金额相等
				request.setAttribute("message", "总保费["+df.format(sumP)+"]与分项保费合计["+df.format(totalF)+"]不符，不允许进行支付。");
				return "/fo/offlinepay/payFail";
			}
			if (TelesaleWSConstants.PAYCODESTATUS_4
					.equalsIgnoreCase(weiXinOfflineOrderInfo.getPayCodeStatus())) {
				return "/fo/offlinepay/paySuccess";
			}

		} catch (Exception e) {
			logger.error("验证支付码接口调取失败", e);
			request.setAttribute("message", "获取投保单信息异常，请稍候重试");
			return "/fo/offlinepay/payFail";
		}
		// 将订单号写入本地cookie
		Cookie cookie = new Cookie("payCode", payCode + "," + paytype);
		cookie.setDomain(ResourceUtil.getBundleEnvAbout().getString(
				"cookiedomain"));
		response.addCookie(cookie);
		// 根据支付方式获取对应的第三方支付配置信息
		Map<String, String> configMap = payServiceImpl.getConfigMap(paytype);
		String activedProfile = request.getSession().getServletContext()
				.getInitParameter("spring.profiles.active");
		if (StringUtil.isNotEmpty(activedProfile)
				&& !"prod".equalsIgnoreCase(activedProfile)) {
			total_fee = "0.01";
		}
		String message = "alipay,订单号:[" + out_trade_no + "]发起支付...";
		systemService.addLog(message, Globals.Log_Type_INSERT,
				Globals.Log_Leavel_INFO);
		request.setAttribute("out_trade_no", out_trade_no);
		request.setAttribute("subject", subject);
		request.setAttribute("total_fee", total_fee);
		request.setAttribute("configMap", configMap);
		return configMap.get("req_url").toString();
	}

	/**
	 * 支付宝支付成功同步通知
	 * 
	 * @param request
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "success", method = RequestMethod.GET)
	public ModelAndView paySuccess(HttpServletRequest request) {
		logger.info("支付成功立即跳转...");
		Map<String, String> configMap = payServiceImpl.getConfigMap("alipay");
		boolean ret = false;
		// 获取支付宝POST过来反馈信息
		Map map = request.getParameterMap();
		Map<String, String> params = new HashMap<String, String>();
		for (Iterator iter = map.keySet().iterator(); iter.hasNext();) {
			String name = (String) iter.next();
			String[] values = (String[]) map.get(name);
			String valueStr = "";
			for (int i = 0; i < values.length; i++) {
				valueStr = (i == values.length - 1) ? valueStr + values[i]
						: valueStr + values[i] + ",";
			}
			params.put(name, valueStr);
		}
		// 商户订单号
		String out_trade_no = "";
		try {
			out_trade_no = new String(request.getParameter("out_trade_no")
					.getBytes("ISO-8859-1"), "UTF-8");
			// 支付宝交易号
			String trade_no = new String(request.getParameter("trade_no")
					.getBytes("ISO-8859-1"), "UTF-8");
			// 交易状态
			String result = new String(request.getParameter("result").getBytes(
					"ISO-8859-1"), "UTF-8");
			boolean verify_result = AlipayNotify
					.verifyReturn(params, configMap);
			if (verify_result) {
				ret = true;
			} else {
				ret = false;
			}
			payServiceImpl.addPayLog(out_trade_no, "02", result, "", "alipay");
		} catch (UnsupportedEncodingException e) {
			logger.error("编码失败...", e);
		}
		WeiXinOfflineOrderInfo weiXinOfflineOrderInfo = payServiceImpl
				.getEntity(WeiXinOfflineOrderInfo.class, out_trade_no);
		if (ret) {
			if (weiXinOfflineOrderInfo != null) {
				int paystatus = weiXinOfflineOrderInfo.getPayStatus();
				if (paystatus != TelesaleWSConstants.PAYSTATUS_SUCCESS) {
					weiXinOfflineOrderInfo
							.setPayStatus(TelesaleWSConstants.PAYSTATUS_FINISH);
					weiXinOfflineOrderInfo
							.setPayCodeStatus(TelesaleWSConstants.PAYCODESTATUS_6);
					payServiceImpl.updateEntitie(weiXinOfflineOrderInfo);
				}
			}
			String message = "alipay,订单号:[" + out_trade_no + "]支付成功...";
			systemService.addLog(message, Globals.Log_Type_INSERT,
					Globals.Log_Leavel_INFO);
			try {
				this.receivePayCodeStatus(out_trade_no);
			} catch (Exception e) {
				logger.error("支付完成调用通知公共服务接口错误。。。", e);
			}
			return new ModelAndView("/fo/offlinepay/paySuccess");
		} else {
			if (weiXinOfflineOrderInfo != null) {
				weiXinOfflineOrderInfo
						.setPayStatus(TelesaleWSConstants.PAYSTATUS_FAIL);
				payServiceImpl.updateEntitie(weiXinOfflineOrderInfo);
			}
			request.setAttribute("message", "保单支付失败，请确认您的银行卡是否正常可使用或者支付额度是否足够。");
			return new ModelAndView("/fo/offlinepay/payFail");
		}
	}

	/**
	 * 支付宝支付成功异步通知
	 * 
	 * @param request
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "notify", method = RequestMethod.POST)
	public void notify(HttpServletRequest request, HttpServletResponse response) {
		logger.info("支付宝异步通知支付成功...");
		Map<String, String> configMap = payServiceImpl.getConfigMap("Alipay");
		PrintWriter out;
		String ret = "fail";
		// 获取支付宝POST过来反馈信息
		Map map = request.getParameterMap();
		Map<String, String> params = new HashMap<String, String>();
		for (Iterator iter = map.keySet().iterator(); iter.hasNext();) {
			String name = (String) iter.next();
			String[] values = (String[]) map.get(name);
			String valueStr = "";
			for (int i = 0; i < values.length; i++) {
				valueStr = (i == values.length - 1) ? valueStr + values[i]
						: valueStr + values[i] + ",";
			}
			params.put(name, valueStr);
		}
		Document doc_notify_data;
		try {
			out = response.getWriter();
			doc_notify_data = DocumentHelper.parseText(params
					.get("notify_data"));
			String out_trade_no = doc_notify_data.selectSingleNode(
					"//notify/out_trade_no").getText();
			// 支付宝交易号
			String trade_no = doc_notify_data.selectSingleNode(
					"//notify/trade_no").getText();
			logger.info("异步通知处理的单号：" + out_trade_no);
			String trade_status = doc_notify_data.selectSingleNode(
					"//notify/trade_status").getText();
			Notify notify = new Notify();
			notify = XMLConverUtil.convertToObject(Notify.class,
					params.get("notify_data"));
		    List<Notify> notifyList= payServiceImpl.findByProperty(Notify.class, "trade_no", notify.getTrade_no());
			if(notifyList.size()>0){
				logger.info("重复保存数据库了,异步通知处理的单号：" + notify.getTrade_no());	
			}else{
				 payServiceImpl.save(notify);	
			}
			boolean isUpdatedSuccess = offlineWechatPayService
					.updOrderInfoByOrderIdAndStatus(out_trade_no,
							TelesaleWSConstants.PAYSTATUS_SUCCESS);
			if (AlipayNotify.verifyNotify(params, configMap)) {
				if ("TRADE_FINISHED".equals(trade_status)
						|| "TRADE_SUCCESS".equals(trade_status)) {
					if (isUpdatedSuccess) {
						notifyExternalSystem(out_trade_no, trade_no,
								notify.getBuyer_email());
					}
					ret = "success";
				} else {
					ret = "fail";
				}
			}
			out.print(ret);
			out.close();
		} catch (DocumentException e) {
			logger.error("************支付宝即时到账，回调通知支付宝出错！", e);
		} catch (Exception e) {
			logger.error("************支付宝即时到账，回调通知支付宝出错！", e);
		}
	}
	
	@RequestMapping(params = "test")
	public String test(HttpServletRequest request){
		String out_trade_no=request.getParameter("out_trade_no");
		try {
			this.receivePayCodeStatus(out_trade_no);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	private void receivePayCodeStatus(String out_trade_no) throws Exception {
		WeiXinOfflineOrderInfo weiXinOfflineOrderInfo = payServiceImpl
				.getEntity(WeiXinOfflineOrderInfo.class, out_trade_no);
		telesaleWebService.ReceivePayCodeStatus(
				weiXinOfflineOrderInfo.getPaycodemd5(),
				PaymentConstants.PAYCODESTATUS_006);
	}

	/**
	 * 支付成功，通知外部系统
	 * 
	 * @param out_trade_no
	 * @param trade_no
	 * @throws Exception
	 */
	private void notifyExternalSystem(String out_trade_no, String trade_no,
			String account) throws Exception {
		WeiXinOfflineOrderInfo weiXinOfflineOrderInfo = payServiceImpl
				.getEntity(WeiXinOfflineOrderInfo.class, out_trade_no);
		telesaleWebService.updatePayInfo(
				MD5Utils.MD5(weiXinOfflineOrderInfo.getPayCode()), trade_no,
				account);
	}

}
