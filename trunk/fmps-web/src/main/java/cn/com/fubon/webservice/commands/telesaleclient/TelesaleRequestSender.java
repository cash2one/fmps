package cn.com.fubon.webservice.commands.telesaleclient;

import javax.annotation.Resource;

import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMFactory;
import org.apache.axiom.om.OMNamespace;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.client.ServiceClient;
import org.apache.axis2.client.async.AxisCallback;
import org.apache.axis2.context.MessageContext;
import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;
import org.apache.log4j.Logger;

import cn.com.fubon.util.XmlUtils;
import cn.com.fubon.webservice.WsConstants;
import cn.com.fubon.webservice.entity.request.FbTelesaleRequestBody;
import cn.com.fubon.webservice.entity.request.FbWSRequest;
import cn.com.fubon.webservice.externl.telesalesystem.TelesaleWSConstants;
import cn.com.fubon.webservice.externl.telesalesystem.resphandler.TelesaleResponseHandler;

/**
 * 请求发送到电销服务端
 * @author fangfang.guo
 */
public class TelesaleRequestSender implements Command {

	private static final Logger logger = Logger.getLogger(TelesaleRequestSender.class);
	
	@Resource 
	private Command telesaleClientWsResponseChain;
	int total=1;

	@Override
	public boolean execute(final Context context) throws Exception {
		logger.info("enter TelesaleRequestSender");	
	
		String wsEntryUrl = (String) context.get(WsConstants.CHAIN_CONTEXT_KEY_WS_ENTRY_URL);
		
		final FbWSRequest fbWSRequest =  (FbWSRequest)context.get(WsConstants.CHAIN_CONTEXT_KEY_WS_REQUEST);
		String fbWsRequestXml = XmlUtils.toXML(fbWSRequest);
		context.put(WsConstants.CHAIN_CONTEXT_KEY_WS_REQUEST_XML, fbWsRequestXml);
		
		String wsMethodName = (String) context.get(WsConstants.CHAIN_CONTEXT_KEY_WS_METHOD_NAME);
		
		FbTelesaleRequestBody requestBody = (FbTelesaleRequestBody)fbWSRequest.getRequestBody();
		
		//把存到request的参数名称和参数值转成数组
		String paramNames = (String)requestBody.getParamNames();
		String[] paramNamesArr = paramNames.substring(1, paramNames.length()-1).replace(" ", "").split(",");
		String params = (String)requestBody.getParams();
		String[] paramsArr = params.substring(1, params.length()-1).replace(" ", "").split(",");
		
		Options options = new Options();
		EndpointReference targetEPR = new EndpointReference(wsEntryUrl);
		options.setTo(targetEPR);
		ServiceClient sender = new ServiceClient();
		sender.setOptions(options);

		OMFactory iOMFactory = OMAbstractFactory.getOMFactory();
		OMNamespace namespace=iOMFactory.createOMNamespace((String)context.get(WsConstants.CHAIN_CONTEXT_KEY_WS_TARGET_NAMESPACE),null);
		//调用的接口方法名
		OMElement method = iOMFactory.createOMElement(wsMethodName, namespace);
		//调用的接口方法参数名
		OMElement symbol =  null;
		
		//预设有几个参数名就有几个参数值
		for(int i=0 ; i < paramNamesArr.length ; i++){
			symbol = iOMFactory.createOMElement(paramNamesArr[i], null);
			symbol.addChild(iOMFactory.createOMText(symbol, paramsArr[i]));
			method.addChild(symbol);
		}
		
		method.build();

		OMElement result = null;
		String resultXml = "";
		final TelesaleResponseHandler telesaleResponseHandler=(TelesaleResponseHandler) context.get(TelesaleWSConstants.CHAIN_CONTEXT_KEY_TELESALE_WS_RESPONSE_HANDLER);
		long start = System.currentTimeMillis();		
		boolean isAsyncInvoke=(Boolean) context.get(WsConstants.CHAIN_CONTEXT_KEY_WS_IS_ASYNC_INVOKE);	
		
		if (isAsyncInvoke) {
			sender.sendReceiveNonBlocking(method, new AxisCallback() {
				
				@Override
				public void onMessage(MessageContext arg0) {
					logger.info(" onMessage(MessageContext arg0)");						
					String resultXml=arg0.getEnvelope()
							.getFirstElement().getFirstElement()
							.getFirstElement().getText();	
					logger.info("telesale webservice isAsyncInvoke_resultXML===>"+resultXml);											
					context.put(WsConstants.CHAIN_CONTEXT_KEY_WS_EXTERNL_RESPONSE_XML,	resultXml);
					try {
						logger.info("telesaleClientWsResponseChain execute");
						telesaleClientWsResponseChain.execute(context);
					} catch (Exception e) {
						logger.info("异步返回报文，后续处理错误");
						e.printStackTrace();
					}	
					
				}
				
				@Override
				public void onFault(MessageContext arg0) {
					logger.info("onFault(MessageContext arg0)");
				}
				
				@Override
				public void onError(Exception arg0) {
					logger.info("onError(Exception arg0)");
					if(total==1){
						telesaleResponseHandler.saveSendFailure(fbWSRequest);
						total++;
					}
				}
				
				@Override
				public void onComplete() {
					logger.info("void onComplete()");
				}
			});

			return false;
		} else {
			
			result = sender.sendReceive(method);
			resultXml = result.getFirstElement().getText();
			
			logger.info("invoke telesale web service " + String.valueOf(System.currentTimeMillis() - start) + " ms");

			logger.info("telesale webservice return=>" + resultXml);
			context.put(WsConstants.CHAIN_CONTEXT_KEY_WS_EXTERNL_RESPONSE_XML, resultXml);
			logger.info("telesaleClientWsResponseChain execute");
			telesaleClientWsResponseChain.execute(context);
			return false;
		}

	}

}
