/**
 * 
 */
package cn.com.fubon.fo.customermessage.service;

import java.util.List;

import org.jeecgframework.core.common.service.CommonService;

import cn.com.fubon.fo.customerbind.entity.WeiXinGzUserInfo;
import cn.com.fubon.fo.customermessage.entity.CustomerMessageRecord;

/**
 * 
 * 
 * @author binbin.wang
 *
 */
public interface ICustomerMessageService extends CommonService {
	
	/**
	 * 发送单条客服消息记录
	 *  
	 * @param customerMessageRecord	一条客服消息记录
	 */
	void sendMessage(CustomerMessageRecord customerMessageRecord, String newCustomerMessageEntryUrl);
	
	/**
	 * 获取未发送客服消息列表
	 * 
	 * @return 未发送客服消息列表
	 */
	List<CustomerMessageRecord> getNotSendedCustomerMessage(String weixinAccountId);
	
	void scheduleSendCustomerMessage();
}
