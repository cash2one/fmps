package cn.com.fubon.pay.service;

import java.util.List;
import java.util.Map;

import org.jeecgframework.core.common.service.CommonService;

import weixin.popular.bean.pay.PayNotify;

public interface FmcpPayService extends CommonService {
	
	//是否下过单,返回true 表示已经下过单了
	public boolean isUnifiedOrder(String userPayCode);
	//是否已经支付
	public boolean isPaid(String out_trade_no);
    public PayNotify getPayNotify(String out_trade_no);
    //查询已经下单的订单号列表
    public  List<Map<String, Object>>  getUnifiedOrderlist(String userPayCode);
    //根据用户订单号，查询支付金额
    public String getTotalFee(String userPayCode );
}
