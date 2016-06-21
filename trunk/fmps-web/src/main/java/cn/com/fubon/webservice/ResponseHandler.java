/**
 * 
 */
package cn.com.fubon.webservice;

import org.apache.commons.chain.Context;
import cn.com.fubon.webservice.entity.request.FbWSRequest;

/**
 * 异步WebService响应处理器
 * 
 * @author binbin.wang
 *
 */
public interface ResponseHandler {
	void process(Context context);
	 void  saveSendFailure (FbWSRequest request);
	 void convertExternalResponseToInnerResponse(Context context);
	 String getWsClientBeanName();
	
}
