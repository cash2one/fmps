package cn.com.fubon.pay.controller;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.jeecgframework.core.common.service.CommonService;
import org.jeecgframework.core.util.ApplicationContextUtil;
import org.jeecgframework.core.util.ResourceUtil;

import weixin.popular.api.MessageAPI;
import weixin.popular.bean.pay.PayNotify;
import weixin.popular.bean.pay.RefPayNotify;
import weixin.popular.bean.templatemessage.TemplateMessage;
import weixin.popular.bean.templatemessage.TemplateMessageItem;
import weixin.popular.util.SignatureUtil;
import weixin.popular.util.XMLConverUtil;
import cn.com.fubon.fo.taitravel.entity.StuPolicy;
import cn.com.fubon.fo.taitravel.service.IStuPolicyService;
import cn.com.fubon.fo.totaiwan.service.ToTaiWanPayNotifyService;
import cn.com.fubon.microshop.service.MicroShopNotifyService;
import cn.com.fubon.pay.entity.WeiXinOfflineOrderInfo;
import cn.com.fubon.pay.service.OfflineWechatPayService;
import cn.com.fubon.pay.service.PayNotifyService;
import cn.com.fubon.pay.service.TelesaleWebService;
import cn.com.fubon.util.Constants;
import cn.com.fubon.util.MD5Utils;
import cn.com.fubon.util.XmlUtils;
import cn.com.fubon.webservice.externl.telesalesystem.TelesaleWSConstants;

/**
 * 支付回调通知
 * 
 * @author wang shanqi
 *
 */

public class PayNotifyServlet extends HttpServlet {
	private static final Logger logger = Logger
			.getLogger(PayNotifyServlet.class);
	private PayNotifyService payNotifyServiceImpl;
	private TelesaleWebService telesaleWebService;
	private IStuPolicyService stupolicyService;
	private MicroShopNotifyService microShopNotifyService;
	private ToTaiWanPayNotifyService toTaiWanPayNotifyServiceImpl;
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String pay_sign_key = ""; // 微信支付申请人邮箱获取
		logger.info("进入微信支付回调方法 payNotify ");
		// 微信返回对象
		RefPayNotify refPayNotify = new RefPayNotify();
		refPayNotify.setReturn_code("FAIL");
		refPayNotify.setReturn_msg("未知错误");
		try {
			payNotifyServiceImpl = (PayNotifyService) ApplicationContextUtil
					.getContext().getBean("payNotifyServiceImpl");
			telesaleWebService = (TelesaleWebService) ApplicationContextUtil
					.getContext().getBean("telesaleWebService");
			microShopNotifyService = (MicroShopNotifyService) ApplicationContextUtil
					.getContext().getBean("microShopNotifyService");
			toTaiWanPayNotifyServiceImpl = (ToTaiWanPayNotifyService) ApplicationContextUtil
					.getContext().getBean("toTaiWanPayNotifyServiceImpl");
			// 获取请求数据
			PayNotify payNotify = XMLConverUtil.convertToObject(
					PayNotify.class, request.getInputStream());
			logger.info("原始的XML报文:" + XmlUtils.toXML(payNotify));
			// 签名验证
			pay_sign_key = ResourceUtil.getPartnerKey();
			if (!SignatureUtil.validateAppSignature(payNotify, pay_sign_key)) {
				// 签名验证不通过处理
				logger.info("微信支付后台通知接口调用验签不通过");
				refPayNotify.setReturn_msg("验签不通过");
			} else {
				if (!this.isRepeat(payNotify))
					//this.doSuccessfulReturn(payNotify);
					//改用service层重写
				  payNotifyServiceImpl.doSuccessfulReturn(payNotify);				
				logger.info("微信支付后台通知接口成功处理");
				refPayNotify.setReturn_code("SUCCESS");
				refPayNotify.setReturn_msg("");
			}
		} catch (Exception e) {
			logger.error("访问异常", e);
			refPayNotify.setReturn_msg("访问异常");
			request.setAttribute("message", "系统发生未知错误！");
			request.setAttribute(Constants.MESSAGE_TYPE,
					Constants.MESSAGE_TYPE_ERROR);
			response.sendRedirect("fo/common/message");
		}

		// 返回数据给微信
		String refPayNotifyXML = XmlUtils.toXML(refPayNotify, "xml",
				RefPayNotify.class);
		logger.info("返回数据给微信字符串为：" + refPayNotifyXML);
		response.getOutputStream().write(refPayNotifyXML.getBytes());

	}

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * 根据订单号查询是否重复 ,没有重复先保全实体再返回false
	 * 
	 * @param transaction_id
	 * @return
	 */
	protected synchronized boolean isRepeat(PayNotify payNotify) {
		List<PayNotify> payNotifyList = payNotifyServiceImpl
				.getListByTransactionId(payNotify.getTransaction_id());
		boolean isRepeat = payNotifyList.size() > 0 ? true : false;
		if (!isRepeat)
			payNotifyServiceImpl.save(payNotify);
		return isRepeat;
	}

	/**
	 * 处理成功支付回调
	 * 
	 * @param payNotify
	 * @return
	 */

	protected boolean doSuccessfulReturn(PayNotify payNotify) {
		String attach = payNotify.getAttach();
		logger.info("支付成功，开始处理成功回调==attach==>" + attach);
		String[] attachArray = attach.split(","); // 原样返回[支付来源，订单号，其他信息]
		if (attachArray[0].contains("TaiPay")) {
			logger.info("赴台旅游投保对应的业务逻辑处理....");
			// updateStuPolicyPayStatus(payNotify.getOut_trade_no());
			toTaiWanPayNotifyServiceImpl.doUnderwriting(attachArray[1],payNotify);
					
		} else if (attachArray[0].contains("CorePay")) {
			logger.info("核心支付码支付成功处理");
			if(payNotifyServiceImpl.updateOrderStatus(attachArray[1])){
				notifyExternalWS(attachArray[1], payNotify.getTransaction_id(),
						payNotify.getOpenid());
			}
		} else if (attachArray[0].contains("FMCP")) { // 企业号微店付款
			logger.info("企业号付款成功处理==>" + attachArray[1]);
			microShopNotifyService.doUnderwriting(attachArray[1], payNotify);
		} else {
			logger.info("支付成功处理，未定义");
		}
		sendTemplateMsg(payNotify);
		return true;
	}

	/**
	 * 发送模板消息
	 * 
	 * @param payNotify
	 */
	private void sendTemplateMsg(PayNotify payNotify) {
		TemplateMessage templateMessage = new TemplateMessage();
		templateMessage.setTouser(payNotify.getOpenid());
		// templateMessage.setTouser("owJamuM6qTM0Q9exfOcvHyvRag_8");
		templateMessage.setTopcolor("#FF0000");
		templateMessage
				.setTemplate_id("w1fxI814LjhUqzwlOHj1a9Kxbjz_syKZUy7BloKGAjU"); // 模板编号

		TemplateMessageItem out_trade_no = new TemplateMessageItem("您好，支付码为："
				+ payNotify.getOut_trade_no() + "的保单已经成功支付。", "#173177");
		TemplateMessageItem Total_fee = new TemplateMessageItem(
				payNotify.getTotal_fee(), "#173177");
		TemplateMessageItem time_end = new TemplateMessageItem(
				payNotify.getTime_end(), "#173177");
		TemplateMessageItem attach = new TemplateMessageItem(
				payNotify.getAttach(), "#173177");
		LinkedHashMap<String, TemplateMessageItem> map = new LinkedHashMap<String, TemplateMessageItem>();
		map.put("first", out_trade_no);
		map.put("period", time_end);
		map.put("keynote1", Total_fee);
		map.put("remark", attach);
		templateMessage.setData(map);
		MessageAPI messageAPI = new MessageAPI();
		// 未启用模板
		// TemplateMessageResult templateMessageResult =
		// messageAPI.messageTemplateSend(weixinAccountService.getAccessTokenFromAccountEntity(),templateMessage);
	}

	/**
	 * 更新订单支付状态
	 * 
	 * @param payNotify
	 */
	private void updateOrderInfoPayStatus(String payCode) {
		CommonService commonService = (CommonService) ApplicationContextUtil
				.getContext().getBean("commonService");
		WeiXinOfflineOrderInfo weiXinOfflineOrderInfo = commonService
				.findUniqueByProperty(WeiXinOfflineOrderInfo.class, "payCode",
						payCode);
		weiXinOfflineOrderInfo.setPayStatus(1);
		commonService.updateEntitie(weiXinOfflineOrderInfo);
	}

	/**
	 * 支付成功通知外部系统
	 * 
	 * @param payNotify
	 */
	private void notifyExternalWS(String payCode, String Transaction_id,
			String openid) {
		try {
			telesaleWebService.updatePayInfo(MD5Utils.MD5(payCode), // 核心支付码
					Transaction_id, openid);
		} catch (Exception e) {
			logger.info("发送核心系统订单状态更新失败,支付码：" + Transaction_id, e);
		}
	}

	/**
	 * 更新赴台订单支付状态
	 * 
	 * @param payNotify
	 */
	private void updateStuPolicyPayStatus(String payorderno) {

		stupolicyService = (IStuPolicyService) ApplicationContextUtil
				.getContext().getBean("stupolicyService");
		StuPolicy stuPolicy = stupolicyService.findUniqueByProperty(
				StuPolicy.class, "payorderno", payorderno);
		stuPolicy.setPaystatus("1");
		stupolicyService.updateEntitie(stuPolicy);
	}

}
