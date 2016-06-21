/**
 * 
 */
package cn.com.fubon.webservice.commands.client;

import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;
import org.apache.log4j.Logger;

import cn.com.fubon.util.XmlUtils;
import cn.com.fubon.webservice.WsConstants;
import cn.com.fubon.webservice.entity.request.FbWSRequest;

/**
 * 请求转换成XML文件
 * @author binbin.wang
 *
 */
public class RequestToXml  implements Command {

	private static final Logger logger = Logger.getLogger(RequestToXml.class);
	
	/**
	 * 
	 */
	public RequestToXml() {
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean execute(Context context) throws Exception {
		FbWSRequest fbWsRequest = (FbWSRequest)context.get(WsConstants.CHAIN_CONTEXT_KEY_WS_REQUEST);
		Object externalRequest = context.get(WsConstants.CHAIN_CONTEXT_KEY_WS_EXTERNL_REQUEST);
		
		String fbWsRequestXml = XmlUtils.toXML(fbWsRequest);
		String externalRequestXml = XmlUtils.toXML(externalRequest);
		
		logger.info("fbWsRequestXml=======>" + fbWsRequestXml);
		logger.info("externalRequestXml=======>" + externalRequestXml);
		
		context.put(WsConstants.CHAIN_CONTEXT_KEY_WS_REQUEST_XML, fbWsRequestXml);
		context.put(WsConstants.CHAIN_CONTEXT_KEY_WS_EXTERNL_REQUEST_XML, externalRequestXml);
		return false;
	}

}
