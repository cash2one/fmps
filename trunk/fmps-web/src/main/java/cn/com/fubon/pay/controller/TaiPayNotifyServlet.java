package cn.com.fubon.pay.controller;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.util.ApplicationContextUtil;
import org.jeecgframework.core.util.ResourceUtil;
import org.jeecgframework.web.system.service.SystemService;
import org.springframework.beans.BeansException;

import weixin.guanjia.account.service.WeixinAccountServiceI;
import weixin.popular.api.MessageAPI;
import weixin.popular.bean.pay.PayNotify;
import weixin.popular.bean.pay.RefPayNotify;
import weixin.popular.bean.templatemessage.TemplateMessage;
import weixin.popular.bean.templatemessage.TemplateMessageItem;
import weixin.popular.util.SignatureUtil;
import weixin.popular.util.XMLConverUtil;
import cn.com.fubon.fo.taitravel.entity.StuPolicy;
import cn.com.fubon.fo.taitravel.service.IStuPolicyService;
import cn.com.fubon.pay.service.OfflineWechatPayService;
import cn.com.fubon.pay.service.PayNotifyService;
import cn.com.fubon.product.entity.Plan;
import cn.com.fubon.util.Constants;
import cn.com.fubon.util.XmlUtils;

/**
 * 支付回调通知
 * 
 * @author guojunjie
 *
 */

public class TaiPayNotifyServlet extends HttpServlet {
	private static final Logger logger = Logger
			.getLogger(TaiPayNotifyServlet.class);
	private PayNotifyService payNotifyServiceImpl;
	private WeixinAccountServiceI weixinAccountService;
	private SystemService systemService;
	private OfflineWechatPayService offlineWechatPayService;
	private IStuPolicyService stupolicyService;
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
			weixinAccountService = (WeixinAccountServiceI) ApplicationContextUtil
					.getContext().getBean("weixinAccountService");
			stupolicyService = (IStuPolicyService) ApplicationContextUtil
					.getContext().getBean("stupolicyService");
			offlineWechatPayService = (OfflineWechatPayService) ApplicationContextUtil
					.getContext().getBean("offlineWechatPayService");

			// 获取请求数据
			PayNotify payNotify = XMLConverUtil.convertToObject(PayNotify.class,
					request.getInputStream());
			logger.info("原始的XML报文:" + XmlUtils.toXML(payNotify));
			// 签名验证
			pay_sign_key = ResourceUtil.getPartnerKey();
			if (!SignatureUtil.validateAppSignature(payNotify, pay_sign_key)) {
				// 签名验证不通过处理
				logger.info("微信支付后台通知接口调用验签不通过");
				refPayNotify.setReturn_msg("验签不通过");
			} else {
				if (!this.isRepeat(payNotify))
					this.doSuccessfulReturn(payNotify);
				logger.info("微信支付后台通知接口成功处理");
				refPayNotify.setReturn_code("SUCCESS");
				refPayNotify.setReturn_msg("");
				
				String out_trade_no=payNotify.getOut_trade_no();
				
				StuPolicy stuPolicy = stupolicyService.findUniqueByProperty(StuPolicy.class,
						"payorderno", out_trade_no);
				String payCode="";
				// 记录系统日志
				String message = "OfflineWechatPay,payCode:[" + payCode + "]支付成功！";
			//	systemService.addLog(message, Globals.Log_Type_INSERT,
					//	Globals.Log_Leavel_INFO);
				offlineWechatPayService.updOrderInfoByOrderIdAndStatus(stuPolicy.getId(), 1);
				stuPolicy.setPaystatus("1");
				stupolicyService.updateEntitie(stuPolicy);
				//request.setAttribute("message", "支付成功");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
		// 更新订单表

		// 发送模板消息
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

		return true;
	}

}
