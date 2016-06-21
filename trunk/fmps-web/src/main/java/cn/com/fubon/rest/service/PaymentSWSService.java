/**
 * 
 */
package cn.com.fubon.rest.service;

import java.util.List;

import weixin.popular.bean.paymch.UnifiedorderExp;
import cn.com.fubon.pay.entity.Notify;
import cn.com.fubon.pay.entity.WeiXinOfflineOrderInfo;

/**
 * @author qingqu.huang
 *
 */
public interface PaymentSWSService extends CommonWebService {

	public WeiXinOfflineOrderInfo getOrderInfo(String paycode);
	
	public Notify getNotify(String out_trade_no);
	
	public String queryAliOrder(String out_trade_no,String paytype);
	
	public List<UnifiedorderExp> isUnifiedOrder(String paycode);
	
	public String queryTransactionid(String paycode);
}
