/**
 * 
 */
package cn.com.fubon.rest;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;

import javax.jws.WebService;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import jodd.util.StringUtil;

import org.apache.log4j.Logger;
import org.jeecgframework.core.common.service.CommonService;
import org.jeecgframework.core.util.ApplicationContextUtil;
import org.springframework.core.annotation.AnnotationUtils;

import weixin.popular.bean.pay.PayOrderqueryResult;
import weixin.popular.bean.paymch.UnifiedorderExp;
import weixin.popular.util.JsonUtil;
import cn.com.fubon.pay.entity.Notify;
import cn.com.fubon.pay.entity.PaymentConstants;
import cn.com.fubon.pay.entity.WeiXinOfflineOrderInfo;
import cn.com.fubon.pay.service.WechatPayService;
import cn.com.fubon.rest.entity.request.PaymentRequest;
import cn.com.fubon.rest.entity.response.PaymentResponse;
import cn.com.fubon.rest.entity.response.SingleTradeResponse;
import cn.com.fubon.rest.entity.response.Trade;
import cn.com.fubon.rest.service.impl.PaymentWSServiceImpl;
import cn.com.fubon.util.XmlUtils;
import cn.com.fubon.webservice.WsConstants;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * @author qingqu.huang
 *
 */
@WebService
@Path("/payment")
public class RestWSPayment extends PaymentWSServiceImpl {
	private static Logger logger = Logger.getLogger(RestWSPayment.class);

	/**
	 * 
	 * @param timestamp
	 * @param signature
	 * @param inputJson
	 * @param clientCode
	 * @return
	 */
	@POST
	@Path("queryOrderStatus")
	@Produces("application/json;charset=UTF-8")
	public String queryOrderStatus(@QueryParam("timestamp") String timestamp,
			@QueryParam("signature") String signature,
			@QueryParam("inputJson") String inputJson,
			@QueryParam("clientCode") String clientCode) {
		Map<String, Object> map = super.checkSignatureAndDecrypt(timestamp,
				signature, inputJson, clientCode);
		inputJson = (String) map.get(WsConstants.INPUTJSON);
		String responseJson = (String) map.get(WsConstants.RESPONSEJSON);
		if (StringUtil.isEmpty(responseJson)) {
			responseJson = this.queryOrderStatusProcess(inputJson);
		}
		super.packetPutDB(inputJson, responseJson);
		byte[] key = (byte[]) map.get(WsConstants.AESKEY);
		responseJson = super.encryptJson(responseJson, key);
		return responseJson;
	}

	public String queryOrderStatusProcess(String inputJson) {
		PaymentRequest paymentRequest = JsonUtil.parseObject(inputJson,
				PaymentRequest.class);
		String paycode = paymentRequest.getPaycode();
		String paytype = paymentRequest.getPaytype();
		PaymentResponse paymentResponse = new PaymentResponse();
		paymentResponse.setPaycode(paycode);
		paymentResponse.setPaytype(paytype);
		if (StringUtil.isEmpty(paycode)) {
			paymentResponse.setErrcode(PaymentConstants.ERRORCODE_0001);
			paymentResponse.setErrmsg(PaymentConstants.ERRMSG_PAYCODENOTNULL);
			paymentResponse.setStatus("");
			paymentResponse.setSerialnumber("");
			return JsonUtil.toJSONString(paymentResponse);
		}
		if (StringUtil.isEmpty(paytype)) {
			paymentResponse.setErrcode(PaymentConstants.ERRORCODE_0001);
			paymentResponse.setErrmsg(PaymentConstants.ERRMSG_PAYTYPENOTNULL);
			paymentResponse.setStatus("");
			paymentResponse.setSerialnumber("");
			return JsonUtil.toJSONString(paymentResponse);
		}
		WeiXinOfflineOrderInfo weiXinOfflineOrderInfo = this
				.getOrderInfo(paycode);
		if (weiXinOfflineOrderInfo == null) {
			paymentResponse.setErrcode(PaymentConstants.ERRORCODE_0002);
			paymentResponse.setErrmsg(PaymentConstants.ERRMSG_NOTFIND);
			paymentResponse.setStatus(PaymentConstants.PAYCODESTATUS_001);
			paymentResponse.setSerialnumber("");
			return JsonUtil.toJSONString(paymentResponse);
		}
		String paycodeStatus = weiXinOfflineOrderInfo.getPayCodeStatus();
		if (PaymentConstants.PAYCODESTATUS_002.equals(paycodeStatus)
				|| PaymentConstants.PAYCODESTATUS_003.equals(paycodeStatus)) {
			paymentResponse.setErrcode(PaymentConstants.ERRORCODE_0000);
			paymentResponse.setErrmsg(PaymentConstants.ERRMSG_OK);
			paymentResponse.setStatus(paycodeStatus);
			paymentResponse.setSerialnumber("");
			return JsonUtil.toJSONString(paymentResponse);
		}
		CommonService commonService = (CommonService) ApplicationContextUtil
				.getContext().getBean("commonService");
		if (StringUtil.isNotEmpty(paytype) && PaymentConstants.PAYTYPE_1.equals(paytype)) {
			paymentResponse = aliQueryOrderStatus(paymentResponse,
					weiXinOfflineOrderInfo, commonService);
		}
		if (StringUtil.isNotEmpty(paytype) && PaymentConstants.PAYTYPE_2.equals(paytype)) {
			paymentResponse = this.wxQueryOrderStatus(paymentResponse,
					weiXinOfflineOrderInfo, commonService);
		}
		return JsonUtil.toJSONString(paymentResponse);
	}

	/**
	 * 支付宝订单查询
	 * 
	 * @param paytype
	 * @param paycode
	 * @param weiXinOfflineOrderInfo
	 * @param commonService
	 * @return
	 */
	private PaymentResponse aliQueryOrderStatus(PaymentResponse paymentResponse,
			WeiXinOfflineOrderInfo weiXinOfflineOrderInfo,
			CommonService commonService) {
		Notify notify = this.getNotify(weiXinOfflineOrderInfo.getId());
		if (notify != null) {
			paymentResponse.setErrcode(PaymentConstants.ERRORCODE_0000);
			paymentResponse.setErrmsg(PaymentConstants.ERRMSG_OK);
			paymentResponse.setStatus(PaymentConstants.PAYCODESTATUS_004);
			paymentResponse.setSerialnumber(notify.getTrade_no());
			return paymentResponse;
		}
		String result = this.queryAliOrder(weiXinOfflineOrderInfo.getId(),
				paymentResponse.getPaytype());
		logger.info("支付宝单笔交易查询接口返回内容："+result);
		Class<SingleTradeResponse> responseClass = SingleTradeResponse.class;
		Annotation annotation = responseClass.getAnnotation(XStreamAlias.class);
		String annotationValue = (String) AnnotationUtils.getValue(annotation);
		SingleTradeResponse singleTradeResponse = (SingleTradeResponse) XmlUtils
				.fromXML(result, annotationValue, SingleTradeResponse.class);
		if (PaymentConstants.ALIPAY_IS_SUCCESS_T.equals(singleTradeResponse
				.getIs_success())) {
			Trade trade = singleTradeResponse.getSingleTradeResponseBody()
					.getTrade();
			String tradeStatus = trade.getTrade_status();
			paymentResponse.setErrcode(PaymentConstants.ERRORCODE_0000);
			paymentResponse.setErrmsg(PaymentConstants.ERRMSG_OK);
			if (PaymentConstants.ALIPAY_TRADE_STATUS_SUCCESS
					.equals(tradeStatus)
					|| PaymentConstants.ALIPAY_TRADE_STATUS_FINISHED
							.equals(tradeStatus)) {
				weiXinOfflineOrderInfo
						.setPayStatus(PaymentConstants.PAYSTATUS_1);
				weiXinOfflineOrderInfo
						.setPayCodeStatus(PaymentConstants.PAYCODESTATUS_004);
				commonService.updateEntitie(weiXinOfflineOrderInfo);
				paymentResponse.setStatus(PaymentConstants.PAYCODESTATUS_004);
				paymentResponse.setSerialnumber(trade.getTrade_no());
			} else if (PaymentConstants.ALIPAY_TRADE_STATUS_CLOSED
					.equals(tradeStatus)) {
				weiXinOfflineOrderInfo
						.setPayStatus(PaymentConstants.PAYSTATUS_2);
				commonService.updateEntitie(weiXinOfflineOrderInfo);
				paymentResponse.setStatus(PaymentConstants.PAYCODESTATUS_005);
				paymentResponse.setSerialnumber("");
			} else {
				paymentResponse.setStatus(PaymentConstants.PAYCODESTATUS_005);
				paymentResponse.setSerialnumber("");
			}
		} else if (PaymentConstants.ALIPAY_IS_SUCCESS_F
				.equals(singleTradeResponse.getIs_success())) {
			paymentResponse.setErrcode(PaymentConstants.ERRORCODE_9999);
			paymentResponse.setStatus("");
			paymentResponse.setSerialnumber("");
			if (PaymentConstants.ALIPAY_TRADE_NOT_EXIST
					.equals(singleTradeResponse.getError())) {
				int paystatus = weiXinOfflineOrderInfo.getPayStatus();
				if (paystatus != 0) {
					paymentResponse
							.setErrmsg(PaymentConstants.ERRMSG_ERRORTYPE);
				} else {
					paymentResponse
							.setErrmsg(PaymentConstants.ERRMSG_CONFIRMTYPE);
				}
			} else {
				paymentResponse.setErrmsg(PaymentConstants.ERRMSG_ALIPAYERR);
			}
		}
		return paymentResponse;
	}

	/**
	 * 微信订单查询
	 * 
	 * @param paycode
	 * @param paytype
	 * @param weiXinOfflineOrderInfo
	 * @param commonService
	 * @return
	 */
	public PaymentResponse wxQueryOrderStatus(PaymentResponse paymentResponse,
			WeiXinOfflineOrderInfo weiXinOfflineOrderInfo,
			CommonService commonService) {
		int paystatus = weiXinOfflineOrderInfo.getPayStatus();
		List<UnifiedorderExp> unifiedordeList = this
				.isUnifiedOrder(weiXinOfflineOrderInfo.getPayCode());
		if (unifiedordeList.size() > 0) {
			String transactionid = this
					.queryTransactionid(weiXinOfflineOrderInfo.getPayCode());
			if (StringUtil.isNotEmpty(transactionid)) {
				paymentResponse.setErrcode(PaymentConstants.ERRORCODE_0000);
				paymentResponse.setErrmsg(PaymentConstants.ERRMSG_OK);
				paymentResponse.setStatus(PaymentConstants.PAYCODESTATUS_004);
				paymentResponse.setSerialnumber(transactionid);
				return paymentResponse;
			} else {
				for (UnifiedorderExp unifiedorderExp : unifiedordeList) {
					WechatPayService wechatPayServiceImpl = (WechatPayService) ApplicationContextUtil
							.getContext().getBean("wechatPayServiceImpl");
					PayOrderqueryResult payOrderqueryResult = wechatPayServiceImpl
							.queryOrderByOutTradeNo(unifiedorderExp
									.getOut_trade_no());
					if ("SUCCESS".equals(payOrderqueryResult.getTrade_state())) {
						weiXinOfflineOrderInfo.setPayStatus(1);
						weiXinOfflineOrderInfo
								.setPayCodeStatus(PaymentConstants.PAYCODESTATUS_004);
						commonService.updateEntitie(weiXinOfflineOrderInfo);
						paymentResponse
								.setErrcode(PaymentConstants.ERRORCODE_0000);
						paymentResponse.setErrmsg(PaymentConstants.ERRMSG_OK);
						paymentResponse
								.setStatus(PaymentConstants.PAYCODESTATUS_004);
						paymentResponse.setSerialnumber(payOrderqueryResult
								.getTransaction_id());
						return paymentResponse;
					}
				}
				if (paystatus == 3) {
					weiXinOfflineOrderInfo
							.setPayCodeStatus(PaymentConstants.PAYCODESTATUS_006);
					commonService.updateEntitie(weiXinOfflineOrderInfo);
					paymentResponse.setErrcode(PaymentConstants.ERRORCODE_0000);
					paymentResponse.setErrmsg(PaymentConstants.ERRMSG_OK);
					paymentResponse
							.setStatus(PaymentConstants.PAYCODESTATUS_006);
					paymentResponse.setSerialnumber("");
					return paymentResponse;
				}
				paymentResponse.setErrcode(PaymentConstants.ERRORCODE_0000);
				paymentResponse.setErrmsg(PaymentConstants.ERRMSG_OK);
				paymentResponse.setStatus(PaymentConstants.PAYCODESTATUS_005);
				paymentResponse.setSerialnumber("");
			}
		} else {
			if (paystatus != 0 && paystatus != 3) {
				paymentResponse.setErrcode(PaymentConstants.ERRORCODE_9999);
				paymentResponse.setErrmsg(PaymentConstants.ERRMSG_ERRORTYPE);
				paymentResponse.setStatus("");
				paymentResponse.setSerialnumber("");
			} else {
				paymentResponse.setErrcode(PaymentConstants.ERRORCODE_0000);
				paymentResponse.setErrmsg(PaymentConstants.ERRMSG_OK);
				paymentResponse.setStatus(PaymentConstants.PAYCODESTATUS_005);
				paymentResponse.setSerialnumber("");
			}
		}
		return paymentResponse;
	}
}
