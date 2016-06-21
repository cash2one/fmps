package cn.com.fubon.pay.service;

import java.util.List;

import org.jeecgframework.core.common.service.CommonService;

import weixin.popular.bean.pay.PayNotify;

public interface PayNotifyService  extends CommonService {

	/**
	 * 根据微信订单号查询记录
	 * @param transaction_id
	 * @return
	 */
	public  List<PayNotify>  getListByTransactionId (String transaction_id   );
	
	public boolean updateOrderStatus(String payCode);
	
	//微信支付成功回调处理
	public boolean doSuccessfulReturn(PayNotify payNotify);
	
}
