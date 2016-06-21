package cn.com.fubon.pay.service;

import java.util.List;
import java.util.Map;

import cn.com.fubon.pay.entity.WeiXinOfflineOrderInfo;

/**
 * 线上微信支付类
 * 
 * @author patrick.z
 */
public interface OfflineWechatPayService {
	/**
	 * 检测支付码是否对应的订单。
	 * 
	 * @param payCode
	 * @return boolean
	 */
	boolean checkOrderByPayCode(String payCode);

	/**
	 * 修改订单状态信息。
	 * 
	 * @param payCode
	 * @param payStatus
	 * @return boolean
	 */
	boolean updOrderInfoByOrderIdAndStatus(String orderId,int payStatus);
	
	/**
	 * 保存日志。
	 * @param payStatus
	 * @param errMsg
	 * @param orderId
	 * @return
	 */
	void saveOrderInfoLog(String orderId,String payStatus,String errMsg);
	
	/**
	 * 根据支付码查询订单信息。
	 * 返回订单实体类
	 * 
	 * @param payCode
	 * @return WeiXinOfflineOrderInfo
	 * @throws Exception 
	 */
	WeiXinOfflineOrderInfo getOrderInfoByPayCode(String payCode) throws Exception;
	
	/**
	 * 根据订单ID获取订单的详细信息
	 * @param id
	 * @return
	 * @throws Exception
	 */
	Map<String, Object> getOrderInfoByDetail(String id) throws Exception;
}
