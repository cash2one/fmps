package cn.com.fubon.pay.service;

/**
 * 电销webservice调用接口
 * @author fangfang.guo
 */
import cn.com.fubon.pay.entity.WeiXinOfflineOrderInfo;

public interface TelesaleWebService {
	public WeiXinOfflineOrderInfo getPayInfo(String payCode) throws Exception;

	public WeiXinOfflineOrderInfo checkPayCode(String payCode) throws Exception;

	public WeiXinOfflineOrderInfo updatePayInfo(String payCode, String liushuihao,
			String account) throws Exception;
	public WeiXinOfflineOrderInfo ReceivePayCodeStatus(String payCode,String payCodeStatus) throws Exception;
	
	public String sendMessageToTelesale(String policyno, String wxreadflag,String wxgiftflag, String wxgift);
}
