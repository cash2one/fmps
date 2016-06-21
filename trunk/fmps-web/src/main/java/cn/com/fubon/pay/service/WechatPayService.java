package cn.com.fubon.pay.service;

import weixin.popular.bean.pay.PayOrderqueryResult;

public interface WechatPayService {
/**
 * 
  * @param openid
	 *            客户的openid
	 * @param body
	 *            商品描述
	 * @param out_trade_no
	 *            最多32位订单号
	 * @param total_fee
	 *            订单总金额，单位为分，不能带小数点
	 * @param spbill_create_ip
	 *            订单生成的机器IP
	 * @param attach
	 *            附加数据原样返回，可保存被保险人等信息以便对账等
  * @return
 */
	public String getPayJsRequestJson(String openid, String body,
			String out_trade_no, String total_fee, String spbill_create_ip,
			String attach);
	
	/**
	 * 
	 * @param openid
	 * @param body
	 * @param out_trade_no
	 * @param total_fee
	 * @param spbill_create_ip
	 * @param attach
	 * @param serlvetname
	 * @return
	 */
	public String getPayRequestJson(String openid, String body,
			String out_trade_no, String total_fee, String spbill_create_ip,
			String attach,String serlvetname);
	
	/**
	 * 根据订单号查询订单支付情况
	 * @param out_trade_no
	 * @return
	 */
	public PayOrderqueryResult queryOrderByOutTradeNo(String outTradeNo);
	/**
	 * 企业号微店付款
	 * @param openid
	 * @param body
	 * @param out_trade_no
	 * @param total_fee
	 * @param spbill_create_ip
	 * @param attach
	 * @param fmcpPayCode
	 * @return
	 */
	public String getFcpsPayJsRequestJson(String openid, String body,
			String out_trade_no, String total_fee, String spbill_create_ip,
			String attach,String fmcpPayCode);

	/**
	 * 此方法会先判断此orderno 订单号是否已经支付，若已经支付，就返回已经支付的金额。未支付走正常支付流程
	 * @param openid
	 * @param body
	 * @param orderno
	 * @param total_fee
	 * @param spbill_create_ip
	 * @param attach
	 * @return
	 */
	String getPayJsRequestJsonNew(String openid, String body,
			String order_no, String total_fee, String spbill_create_ip,
			String attach);
}
