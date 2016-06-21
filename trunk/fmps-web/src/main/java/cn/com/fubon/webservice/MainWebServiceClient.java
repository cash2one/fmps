/**
 * 
 */
package cn.com.fubon.webservice;

import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;
import org.apache.commons.chain.impl.ContextBase;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import cn.com.fubon.webservice.entity.request.FbWSRequest;
import cn.com.fubon.webservice.externl.telesalesystem.TelesaleWSConstants;
import cn.com.fubon.webservice.externl.telesalesystem.resphandler.TelesaleResponseHandler;

/**
 * 
 * @author binbin.wang
 *
 */
public class MainWebServiceClient {
	
	private static final Logger logger = Logger.getLogger(MainWebServiceClient.class);
	
	private Context context ;
	
	private String externlRequestClassName;
	private String externlResponseClassName;
	
	//WebService调用入口地址
	private String entryUrl;
	
	//WebService调用的方法
	private String wsMethodName;
	
	//WebService调用的tns
	private String targetNamespace;
	
	//调用WebService的请求
	private FbWSRequest request;
	
	//是否异步调用
	private boolean isAsyncInvoke;
	
	@Autowired
	private Command clientWsChain;
	
	@Autowired
	private Command telesaleClientWsChain;
	
	
	private ResponseHandler responseHandler;
	
	private TelesaleResponseHandler telesaleResponseHandler;

	/**
	 * 初始化chain所使用的上下文。<br/>
	 * entryUrl可从外部注入，request可由代码写入 
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private Context initContext() {
		Context context = new ContextBase();
		//web service调用入口
		context.put(WsConstants.CHAIN_CONTEXT_KEY_WS_ENTRY_URL, this.entryUrl);
		
		//web service调用targetNamespace
		context.put(WsConstants.CHAIN_CONTEXT_KEY_WS_TARGET_NAMESPACE, this.targetNamespace);
		
		//调用请求对象
		context.put(WsConstants.CHAIN_CONTEXT_KEY_WS_REQUEST, this.request);
		
		//要转换的外部系统请求对象类名
		context.put(WsConstants.CHAIN_CONTEXT_KEY_EXTERNL_REQEUST_CLASS_NAME, this.externlRequestClassName);
		
		//要转换的外部系统响应对象类名
		context.put(WsConstants.CHAIN_CONTEXT_KEY_EXTERNL_RESPONSE_CLASS_NAME, this.externlResponseClassName);
		
		//是否异步调用web service
		context.put(WsConstants.CHAIN_CONTEXT_KEY_WS_IS_ASYNC_INVOKE, this.isAsyncInvoke);

		//如果为异步调用，将响应处理接口传递至WebService异步调用方法处
		//if (this.isAsyncInvoke)
			context.put(WsConstants.CHAIN_CONTEXT_KEY_WS_RESPONSE_HANDLER, this.responseHandler);
			
			context.put(TelesaleWSConstants.CHAIN_CONTEXT_KEY_TELESALE_WS_RESPONSE_HANDLER, this.telesaleResponseHandler);
		
		if (!StringUtils.isEmpty(this.wsMethodName))
			context.put(WsConstants.CHAIN_CONTEXT_KEY_WS_METHOD_NAME, this.wsMethodName);
		
		
		
		return context;
	}
	
	public Context startExecuteChain() throws Exception {
		Context context = initContext();
		clientWsChain.execute(context);
		
		//如果本次webservice不是异步调用，则直接在这里处理响应
		if (!this.isAsyncInvoke && responseHandler != null) {
			responseHandler.process(context);
		}
		return context;
	}
	
	public Context telesaleStartExecuteChain() throws Exception {
		Context context = initContext();
		telesaleClientWsChain.execute(context);
		
		return context;
	}

	public Context getContext() {
		return context;
	}
	
	public void setContext(Context context) {
		this.context = context;
	}

	public String getEntryUrl() {
		return entryUrl;
	}

	public void setEntryUrl(String entryUrl) {
		this.entryUrl = entryUrl;
	}

	public String getWsMethodName() {
		return wsMethodName;
	}

	public void setWsMethodName(String wsMethodName) {
		this.wsMethodName = wsMethodName;
	}

	public FbWSRequest getRequest() {
		return request;
	}
	
	public void setRequest(FbWSRequest request) {
		this.request = request;
	}

	public String getExternlRequestClassName() {
		return externlRequestClassName;
	}

	public void setExternlRequestClassName(String externlRequestClassName) {
		this.externlRequestClassName = externlRequestClassName;
	}

	public String getExternlResponseClassName() {
		return externlResponseClassName;
	}

	public void setExternlResponseClassName(String externlResponseClassName) {
		this.externlResponseClassName = externlResponseClassName;
	}

	public boolean isAsyncInvoke() {
		return isAsyncInvoke;
	}

	public void setAsyncInvoke(boolean isAsyncInvoke) {
		this.isAsyncInvoke = isAsyncInvoke;
	}

	public ResponseHandler getResponseHandler() {
		return responseHandler;
	}

	public void setResponseHandler(ResponseHandler responseHandler) {
		this.responseHandler = responseHandler;
	}

	public TelesaleResponseHandler getTelesaleResponseHandler() {
		return telesaleResponseHandler;
	}

	public void setTelesaleResponseHandler(TelesaleResponseHandler telesaleResponseHandler) {
		this.telesaleResponseHandler = telesaleResponseHandler;
	}

	public String getTargetNamespace() {
		return targetNamespace;
	}

	public void setTargetNamespace(String targetNamespace) {
		this.targetNamespace = targetNamespace;
	}
}
