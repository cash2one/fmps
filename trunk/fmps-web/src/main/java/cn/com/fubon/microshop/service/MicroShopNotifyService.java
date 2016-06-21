package cn.com.fubon.microshop.service;

import weixin.popular.bean.pay.PayNotify;

public interface MicroShopNotifyService {
	/**
	 * 收费成功后，根据企业号订单号，获取保单信息，保全保单信息，发送核心承保报文
	 * @param fmcpPayCode
	 */
	public void doUnderwriting(String fmcpPayCode, PayNotify payNotify );

}
