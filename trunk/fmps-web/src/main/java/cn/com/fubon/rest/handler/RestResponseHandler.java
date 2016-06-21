package cn.com.fubon.rest.handler;

import org.apache.commons.chain.Context;

/**
 * restful方式接口响应处理
 * @author fangfang.guo
 *
 */
public interface RestResponseHandler {
	void process(Context context) throws Exception;
	
//	/**
//	 * WS发送失败的的处理,先保留
//	 */
//	void saveSendFailure();
}
