package cn.com.fubon.rest.service.impl;

import javax.annotation.Resource;

import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;
import org.apache.commons.chain.impl.ContextBase;

import cn.com.fubon.rest.handler.RestResponseHandler;
import cn.com.fubon.webservice.WsConstants;

/**
 * restful方式接口链条入口
 * @author 
 *
 */
public class RestWebServiceGasolineGiftClient {
	
	//WebService调用入口地址
	private String url;	
	
	//WebService调用的方法
	private String inputJson;
	
	private String secretKey;
		
	@Resource
	private Command restClientGasolineGiftWsChain;
	
	/**
	 * 初始化chain所使用的上下文。<br/>
	 * Url可从外部注入，request可由代码写入 
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private Context initContext(String inputJson) {
		Context context = new ContextBase();
		//web service调用入口
		context.put(WsConstants.CHAIN_CONTEXT_KEY_WS_ENTRY_URL, this.getUrl());
		context.put(WsConstants.CHAIN_CONTEXT_KEY_WS_INPUTJSON, inputJson);
		context.put(WsConstants.CHAIN_CONTEXT_KEY_WS_secretKey, this.getSecretKey());
		return context;
	}
	
	public Context startExecuteChain(String inputJson) throws Exception  {
		Context context = initContext(inputJson);
		restClientGasolineGiftWsChain.execute(context);		
		return context;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getInputJson() {
		return inputJson;
	}

	public void setInputJson(String inputJson) {
		this.inputJson = inputJson;
	}

	public String getSecretKey() {
		return secretKey;
	}

	public void setSecretKey(String secretKey) {
		this.secretKey = secretKey;
	}

	public Command getRestClientGasolineGiftWsChain() {
		return restClientGasolineGiftWsChain;
	}

	public void setRestClientGasolineGiftWsChain(
			Command restClientGasolineGiftWsChain) {
		this.restClientGasolineGiftWsChain = restClientGasolineGiftWsChain;
	}
	
}
