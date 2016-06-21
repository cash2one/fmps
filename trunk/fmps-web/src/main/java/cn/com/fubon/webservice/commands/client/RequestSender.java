/**
 * 
 */
package cn.com.fubon.webservice.commands.client;

import java.util.Date;

import javax.annotation.Resource;
import javax.xml.namespace.QName;

import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.client.async.AxisCallback;
import org.apache.axis2.context.MessageContext;
import org.apache.axis2.rpc.client.RPCServiceClient;
import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import cn.com.fubon.webservice.ResponseHandler;
import cn.com.fubon.webservice.WsConstants;
import cn.com.fubon.webservice.entity.request.FbWSRequest;
import cn.com.fubon.webservice.entity.response.FbWSResponse;
import cn.com.fubon.webservice.externl.coresystem.resphandler.DefaultCoreWSResponseHandler;

/**
 * 请求发送到服务端
 * 
 * @author binbin.wang
 *
 */
public class RequestSender implements Command {

	private static final Logger logger = Logger.getLogger(RequestSender.class);
	
	 @Resource 
	private Command clientWsResponseChain;	  
	int total=1; 

	/**
	 * 
	 */
	public RequestSender() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean execute(final Context context) throws Exception {
		logger.info("enter RequestSender");	
	
	    String resultXml = "";
		String wsEntryUrl = (String) context
				.get(WsConstants.CHAIN_CONTEXT_KEY_WS_ENTRY_URL);
		String externalRequestXml = WsConstants.XML_DECLARATION;
		externalRequestXml += (String) context
				.get(WsConstants.CHAIN_CONTEXT_KEY_WS_EXTERNL_REQUEST_XML);
		String wsMethodName = (String) context
				.get(WsConstants.CHAIN_CONTEXT_KEY_WS_METHOD_NAME);
		RPCServiceClient client = new RPCServiceClient();
		Options options = client.getOptions();
		EndpointReference endpoint = new EndpointReference(wsEntryUrl);
		options.setTo(endpoint);
		options.setTimeOutInMilliSeconds(600000L);	//600*1000毫秒(10分钟 )后调用超时
		
		logger.info("RequestSender-请求报文xml:"+externalRequestXml);
		final ResponseHandler	responseHandler=(ResponseHandler) context.get(WsConstants.CHAIN_CONTEXT_KEY_WS_RESPONSE_HANDLER);	   
		
		String targetNamespace = (String) context.get(WsConstants.CHAIN_CONTEXT_KEY_WS_TARGET_NAMESPACE);
		QName opQName = null;
		if (StringUtils.isEmpty(wsMethodName))
			opQName = new QName(WsConstants.CORE_SYSTEM_NS);
		else
			opQName = new QName(targetNamespace, wsMethodName);
		
		long start = System.currentTimeMillis();		
		boolean isAsyncInvoke=(Boolean) context.get(WsConstants.CHAIN_CONTEXT_KEY_WS_IS_ASYNC_INVOKE);	
		if (isAsyncInvoke) {
			client.invokeNonBlocking(opQName,
					new Object[] { externalRequestXml }, new AxisCallback() {

						@Override
						public void onMessage(MessageContext arg0) {
							logger.info(" onMessage(MessageContext arg0)");						
							String	resultXml=arg0.getEnvelope()
									.getFirstElement().getFirstElement()
									.getFirstElement().getText();	
							logger.info("isAsyncInvoke_resultXML===>"+resultXml);											
							context.put(WsConstants.CHAIN_CONTEXT_KEY_WS_EXTERNL_RESPONSE_XML,	resultXml);
							try {
								clientWsResponseChain.execute(context);								
								FbWSResponse fbWSResponse=(FbWSResponse)context.get(WsConstants.CHAIN_CONTEXT_KEY_WS_RESPOSNE);
								String returnCode = fbWSResponse.getResponseHead().getTransResponse().getReturnCode();								
								if(!returnCode.equalsIgnoreCase("0000")&&"claimWSClientGetNotCarPicture".equals(responseHandler.getWsClientBeanName())){ //不是0000就是失败
									FbWSRequest fbWsRequest = (FbWSRequest)context.get(WsConstants.CHAIN_CONTEXT_KEY_WS_REQUEST);				 
									responseHandler.saveSendFailure(fbWsRequest);									
								}else if(returnCode.equalsIgnoreCase("0000")&&"claimWSClientGetNotCarPicture".equals(responseHandler.getWsClientBeanName())){
									responseHandler.process(context);
								}
							} catch (Exception e) {
								logger.info("异步返回报文，后续处理错误");
								e.printStackTrace();
							}	
						}

						@Override
						public void onFault(MessageContext arg0) {
							logger.info("onFault(MessageContext arg0)");
							// TODO Auto-generated method stub							
						}

						@Override
						public void onError(Exception arg0) {
							logger.info("onError(Exception arg0)错误次数"+total);
							//if(total==1){
							FbWSRequest fbWsRequest = (FbWSRequest)context.get(WsConstants.CHAIN_CONTEXT_KEY_WS_REQUEST);				 
							responseHandler.saveSendFailure(fbWsRequest);
							//total++;
							//}
							// TODO Auto-generated method stub						
						}

						@Override
						public void onComplete() {	
							logger.info("void onComplete()");
							// TODO Auto-generated method stub

						}
					});

			return false;
		} else {
			Object[] results={};
			try{
		   results = client.invokeBlocking(opQName,
					new Object[] { externalRequestXml },
					new Class[] { String.class });
			}catch(Exception e){
				//系统同步发送报文错误，不做重发记录
				//FbWSRequest fbWsRequest = (FbWSRequest)context.get(WsConstants.CHAIN_CONTEXT_KEY_WS_REQUEST);				 
				//responseHandler.saveSendFailure(fbWsRequest);
				e.printStackTrace();
				logger.info("系统同步发送报文错误");
				return false;
			}
			
			
			logger.info("invoke web service "
					+ String.valueOf(System.currentTimeMillis() - start)
					+ " ms");

			if (results.length > 0)
				resultXml = results[0].toString();
			else
				logger.error("invoke webservice return values length is 0;wsEntryUrl=>"
						+ wsEntryUrl + ";wsMethodName=>" + wsMethodName);

			logger.info("webservice return=>" + resultXml);
			context.put(WsConstants.CHAIN_CONTEXT_KEY_WS_EXTERNL_RESPONSE_XML,
					resultXml);
			clientWsResponseChain.execute(context);
			return false;
		}

	}

	public static void main(String[] args) throws InterruptedException {
		long start = System.currentTimeMillis();
		Thread.sleep(3000);
		long end = System.currentTimeMillis();

		long span = end - start;

		System.out.println(String.valueOf(span));
	}

}
