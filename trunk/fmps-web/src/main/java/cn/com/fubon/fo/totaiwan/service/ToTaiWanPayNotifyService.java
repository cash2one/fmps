package cn.com.fubon.fo.totaiwan.service;

import weixin.popular.bean.pay.PayNotify;

public interface ToTaiWanPayNotifyService {
	
	/**
	 * 收费成功后，根据 订单号获取保单信息，发送核心承保报文
	 * @param orderNo
	 * @param payNotify
	 */
	public void doUnderwriting(String orderNo,PayNotify payNotify );

}
