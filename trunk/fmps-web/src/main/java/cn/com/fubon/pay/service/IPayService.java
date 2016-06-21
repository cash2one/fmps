/**
 * 
 */
package cn.com.fubon.pay.service;

import java.util.Map;

import org.jeecgframework.core.common.service.CommonService;

import cn.com.fubon.pay.entity.PayConfig;
import cn.com.fubon.pay.entity.WeiXinOfflineOrderInfo;

/**
 * @author qingqu.huang
 *
 */
public interface IPayService extends CommonService {

	/**
	 * 根据支付方式获取配置信息
	 * 
	 * @param type
	 * @return
	 */
	public Map<String, String> getConfigMap(String type);

	/**
	 * 保存保单信息
	 * 
	 * @param out_trade_no
	 *            保单号
	 * @param total_fee
	 *            保单总额
	 * @param subject
	 *            保单险种名称
	 * @param payConfig
	 *            支付方式对应的配置信息
	 */
	public void saveOrder();

	/**
	 * 第三方支付下单获取授权记录
	 * 
	 * @param out_trade_no
	 *            保单单号
	 * @param request_token
	 *            授权
	 * @param sHtmlTextToken
	 *            授权失败错误String
	 * @param type
	 *            支付方式
	 */
	public void saveTokenLog(String out_trade_no, String total_fee,
			String req_data, String request_token, String sHtmlTextToken,
			String type);

	/**
	 * 保存交易记录
	 * 
	 * @param out_trade_no
	 *            保单单号
	 * @param trade_status
	 *            交易结果
	 * @param type
	 *            支付类型
	 */
	public void addPayLog(String out_trade_no, String reqtype,
			String trade_status, String total_fee, String type);

	/**
	 * 判断投保单是否过期
	 * 
	 * @param weiXinOfflineOrderInfo
	 * @return
	 * @throws Exception
	 */
	public boolean isExpired(String out_trade_no)
			throws Exception;
}
