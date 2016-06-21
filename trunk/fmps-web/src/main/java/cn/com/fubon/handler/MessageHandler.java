/**
 * 
 */
package cn.com.fubon.handler;

import java.util.Map;

import weixin.guanjia.core.entity.message.customer.BaseCustomerMessage;
import weixin.guanjia.core.entity.message.resp.BaseMessageResp;

/**
 * 消息处理器
 * 
 * @author pollux
 *
 */
public interface MessageHandler {
	/**
	 * 同步执行消息处理
	 * 
	 * @param requestMap
	 * @return
	 */
	BaseMessageResp execute(Map<String, String> requestMap) throws Exception;
	
	/**
	 * 异步执行消息处理，处理结果以客服消息的方式发送给微信客户
	 * 
	 * @param requestMap
	 * @return
	 */
	String asyncExecute(Map<String, String> requestMap)  throws Exception;
}
