package cn.com.fubon.pay.service.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.hibernate.qbc.HqlQuery;
import org.jeecgframework.core.common.hibernate.qbc.PageList;
import org.jeecgframework.core.common.model.common.DBTable;
import org.jeecgframework.core.common.model.common.UploadFile;
import org.jeecgframework.core.common.model.json.DataGridReturn;
import org.jeecgframework.core.common.model.json.ImportFile;
import org.jeecgframework.core.common.model.json.TreeGrid;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.jeecgframework.tag.vo.datatable.DataTableReturn;
import org.jeecgframework.tag.vo.easyui.Autocomplete;
import org.jeecgframework.tag.vo.easyui.ComboTreeModel;
import org.jeecgframework.tag.vo.easyui.TreeGridModel;
import org.jeecgframework.web.system.pojo.base.TSDepart;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import weixin.popular.api.MessageAPI;
import weixin.popular.bean.pay.PayNotify;
import weixin.popular.bean.templatemessage.TemplateMessage;
import weixin.popular.bean.templatemessage.TemplateMessageItem;
import cn.com.fubon.fo.taitravel.service.IStuPolicyService;
import cn.com.fubon.fo.totaiwan.service.ToTaiWanPayNotifyService;
import cn.com.fubon.microshop.service.MicroShopNotifyService;
import cn.com.fubon.pay.controller.PayNotifyServlet;
import cn.com.fubon.pay.entity.PaymentConstants;
import cn.com.fubon.pay.entity.WeiXinOfflineOrderInfo;
import cn.com.fubon.pay.service.PayNotifyService;
import cn.com.fubon.pay.service.TelesaleWebService;
import cn.com.fubon.util.MD5Utils;
import cn.com.fubon.webservice.externl.telesalesystem.TelesaleWSConstants;

@Service("payNotifyServiceImpl")
@Transactional
public class PayNotifyServiceImpl extends CommonServiceImpl implements
		PayNotifyService {
	private static final Logger logger = Logger
			.getLogger(PayNotifyServiceImpl.class);
	@Resource
	private TelesaleWebService telesaleWebService;
	@Resource
	private IStuPolicyService stupolicyService;
	@Resource
	private MicroShopNotifyService microShopNotifyService;
	@Resource
	private ToTaiWanPayNotifyService toTaiWanPayNotifyServiceImpl;
	@Override
	public List<PayNotify> getListByTransactionId(String transaction_id) {
		return this.findByProperty(PayNotify.class, "transaction_id",
				transaction_id);

	}

	public boolean updateOrderStatus(String payCode) {
		WeiXinOfflineOrderInfo weiXinOfflineOrderInfo = this
				.findUniqueByProperty(WeiXinOfflineOrderInfo.class, "payCode",
						payCode);
		if (PaymentConstants.PAYSTATUS_1 != weiXinOfflineOrderInfo.getPayStatus()) {
			weiXinOfflineOrderInfo.setPayStatus(1);
			weiXinOfflineOrderInfo
					.setPayCodeStatus(TelesaleWSConstants.PAYCODESTATUS_4);
			this.updateEntitie(weiXinOfflineOrderInfo);
			return true;
		}
		return false;
	}
	

	public boolean doSuccessfulReturn(PayNotify payNotify) {
		String attach = payNotify.getAttach();
		logger.info("支付成功，开始处理成功回调==attach==>" + attach);
		String[] attachArray = attach.split(","); // 原样返回[支付来源，订单号，其他信息]
		if (attachArray[0].contains("TaiPay")) {
			logger.info("赴台旅游投保对应的业务逻辑处理....");
			// updateStuPolicyPayStatus(payNotify.getOut_trade_no());
			toTaiWanPayNotifyServiceImpl.doUnderwriting(attachArray[1],payNotify);
					
		} else if (attachArray[0].contains("CorePay")) {
			logger.info("核心支付码支付成功处理");
			if(this.updateOrderStatus(attachArray[1])){
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
	
}
