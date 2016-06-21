package cn.com.fubon.fo.taitravel.service;

public interface StuWechatPayService {
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
}
