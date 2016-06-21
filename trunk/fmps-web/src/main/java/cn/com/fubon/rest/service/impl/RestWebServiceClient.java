package cn.com.fubon.rest.service.impl;

import javax.annotation.Resource;

import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;
import org.apache.commons.chain.impl.ContextBase;

import cn.com.fubon.rest.handler.RestResponseHandler;
import cn.com.fubon.webservice.WsConstants;

/**
 * restful方式接口链条入口
 * @author fangfang.guo
 *
 */
public class RestWebServiceClient {
	
	//WebService调用入口地址
	private String entryUrl;
	
	private RestResponseHandler restResponseHandler;
	
	//WebService调用的方法
	private String wsMethodName;
	
	@Resource
	private Command restClientWsChain;
	
	/**
	 * 初始化chain所使用的上下文。<br/>
	 * entryUrl可从外部注入，request可由代码写入 
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private Context initContext(String inputJson,String token, String AESKey, String clientCode) {
		Context context = new ContextBase();
		//web service调用入口
		context.put(WsConstants.CHAIN_CONTEXT_KEY_WS_ENTRY_URL, this.getEntryUrl());
		
		//如果为异步调用，将响应处理接口传递至WebService异步调用方法处
		context.put(WsConstants.CHAIN_CONTEXT_KEY_WS_RESPONSE_HANDLER, this.getRestResponseHandler());
		
		context.put(WsConstants.CHAIN_CONTEXT_KEY_WS_METHOD_NAME, this.getWsMethodName());
		context.put(WsConstants.CHAIN_CONTEXT_KEY_WS_INPUTJSON, inputJson);
		context.put(WsConstants.CHAIN_CONTEXT_KEY_WS_TOKEN, token);
		context.put(WsConstants.CHAIN_CONTEXT_KEY_WS_AESKEY, AESKey);
		context.put(WsConstants.CHAIN_CONTEXT_KEY_WS_CLIENTCODE, clientCode);
			
		return context;
	}
	
	public Context startExecuteChain(String inputJson,String token, String AESKey, String clientCode) throws Exception  {
		Context context = initContext(inputJson,token,AESKey,clientCode);
		restClientWsChain.execute(context);
		
		//如果本次webservice不是异步调用，则直接在这里处理响应
		this.getRestResponseHandler().process(context);
		return context;
	}

	public String getEntryUrl() {
		return entryUrl;
	}

	public void setEntryUrl(String entryUrl) {
		this.entryUrl = entryUrl;
	}

	public RestResponseHandler getRestResponseHandler() {
		return restResponseHandler;
	}

	public void setRestResponseHandler(RestResponseHandler restResponseHandler) {
		this.restResponseHandler = restResponseHandler;
	}

	public String getWsMethodName() {
		return wsMethodName;
	}

	public void setWsMethodName(String wsMethodName) {
		this.wsMethodName = wsMethodName;
	}
}
