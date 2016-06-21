package cn.com.fubon.pay.service;

import java.util.List;

import org.jeecgframework.core.common.service.CommonService;

import weixin.popular.bean.paymch.UnifiedorderResult;

public interface WechatUnifiedOrderResult   extends CommonService  {
	
	/**
	 * 根据商家订单号查询订单记录
	 * @param out_trade_no
	 * @return
	 */
	public List<UnifiedorderResult> getEntityByOutTradeNo(String out_trade_no);

}
