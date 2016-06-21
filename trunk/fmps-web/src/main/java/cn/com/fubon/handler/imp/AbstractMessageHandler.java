/**
 * 
 */
package cn.com.fubon.handler.imp;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Map;

import weixin.guanjia.core.entity.message.customer.BaseCustomerMessage;
import weixin.guanjia.core.entity.message.req.TextMessage;
import weixin.guanjia.core.entity.message.resp.BaseMessageResp;
import cn.com.fubon.handler.MessageHandler;

/**
 * @author binbin.wang
 *
 */
public abstract class AbstractMessageHandler<T> implements MessageHandler    {

	
	/**
	 * 将map转换成请求消息Bean
	 * 
	 * @param requestMap
	 * @return
	 * @throws NoSuchMethodException 
	 * @throws SecurityException 
	 */
	protected abstract T convert(Map<String, String> requestMap) throws Exception;
	
	/**
	 * 进行具体的业务处理
	 * 
	 * @param requestMessage
	 * @return
	 */
	protected abstract BaseMessageResp doExecute(T requestMessage) throws Exception  ;
	
	/**
	 * 异步进行具体的业务处理
	 * 
	 * @param requestMessage
	 * @return
	 */
	protected abstract void doAsyncExecute(T requestMessage);

	@Override
	public BaseMessageResp execute(Map<String, String> requestMap) throws Exception  {
		
		T requestMessage = this.convert(requestMap);
		
		BaseMessageResp baseMessageResp = this.doExecute( requestMessage);
		return baseMessageResp;
	};
	
	@Override
	public String asyncExecute(Map<String, String> requestMap) throws Exception {
		
		T requestMessage = this.convert(requestMap);
		this.doAsyncExecute(requestMessage);
		
		return "";
	}
}
