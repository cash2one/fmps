/**
 * 
 */
package cn.com.fubon.webservice.commands.client;

import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;
import org.apache.log4j.Logger;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

import cn.com.fubon.webservice.WsConstants;
import cn.com.fubon.webservice.entity.request.FbWSRequest;

/**
 * 内部请求类型转换为外部请求类型
 * 
 * @author binbin.wang
 *
 */
public class InnerRequestConvertToExternalRequest implements Command {

	private static final Logger logger = Logger.getLogger(InnerRequestConvertToExternalRequest.class);
	
	@Autowired
	private Mapper mapper;
	
	/**
	 * 
	 */
	public InnerRequestConvertToExternalRequest() {
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean execute(Context context) throws Exception {
		
		FbWSRequest fbWsRequest = (FbWSRequest)context.get(WsConstants.CHAIN_CONTEXT_KEY_WS_REQUEST);
		String externlClassName = (String)context.get(WsConstants.CHAIN_CONTEXT_KEY_EXTERNL_REQEUST_CLASS_NAME);
		Object externlRequest = mapper.map(fbWsRequest, Class.forName(externlClassName));
		
		//将外部请求对象传递到下一个节点
		context.put(WsConstants.CHAIN_CONTEXT_KEY_WS_EXTERNL_REQUEST, externlRequest);
		
		return false;
	}
}
