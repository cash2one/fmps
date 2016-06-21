package cn.com.fubon.rest.commands.client;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;
import org.apache.log4j.Logger;

import weixin.guanjia.core.util.SignUtil;
import weixin.util.DateUtils;
import cn.com.fubon.exceptions.WebServiceException;
import cn.com.fubon.rest.service.impl.CommonWebServiceImpl;
import cn.com.fubon.util.AESUtils;
import cn.com.fubon.webservice.WsConstants;



import com.sun.jersey.api.client.WebResource;


import com.sun.jersey.core.util.MultivaluedMapImpl;

public class RestClientRequestSender extends CommonWebServiceImpl implements Command{
	private static final Logger logger = Logger.getLogger(RestClientRequestSender.class); 
	
	private RestClient  restClient;
	 
	
	public RestClient getRestClient() {
		return restClient;
	}


	public void setRestClient(RestClient restClient) {
		this.restClient = restClient;
	}


	@Override
	public boolean execute(Context context)  {
		/*	
		大致流程:	
		1.	请求报文inputJson加密
		2.	生成签名
		3.	发送
		4.	获得响应解密
		5.	交易入库
		*/
		String token = (String)context.get(WsConstants.CHAIN_CONTEXT_KEY_WS_TOKEN);
		String inputJson = (String)context.get(WsConstants.CHAIN_CONTEXT_KEY_WS_INPUTJSON);
		String timestamp = DateUtils.getDate("yyyy-MM-dd HH:mm:ss");
		
		String password = (String)context.get(WsConstants.CHAIN_CONTEXT_KEY_WS_AESKEY);
		String url = (String)context.get(WsConstants.CHAIN_CONTEXT_KEY_WS_ENTRY_URL);
		String clientCode = (String)context.get(WsConstants.CHAIN_CONTEXT_KEY_WS_CLIENTCODE);
		String method = (String)context.get(WsConstants.CHAIN_CONTEXT_KEY_WS_METHOD_NAME);
		
		byte[] key = null;
		try {
			key = AESUtils.initKey(password);
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e1) {
			logger.error("initKey failed",e1);
			throw new WebServiceException("initKey failed",e1);
		}
		
		String encryptInputJson = super.encryptJson(inputJson, key);
		
		String signature = SignUtil.generateSignature(token, timestamp, encryptInputJson);		
		
		WebResource webResource =restClient.getClient().resource(url);
		
		MultivaluedMap<String, String> param = new MultivaluedMapImpl();
		param.add("timestamp", timestamp);
		param.add("signature", signature);
		param.add("inputJson", encryptInputJson);
		param.add("clientCode", clientCode);
		
		String encryptResponseJson = null;

		//如果WebService调用失败是否要捕获异常,如果捕获就会调用链条后续的process做业务处理,先做抛出
		try{
			encryptResponseJson = webResource.path(method).queryParams(param)
				.type(MediaType.APPLICATION_JSON).post(String.class);
		} catch(Exception e){
			logger.error(WsConstants.RETURNMESSAGE_9);
			throw new WebServiceException(WsConstants.RETURNMESSAGE_9,e);
		}
		
		String responseJson = super.decryptJson(encryptResponseJson, key);		
		context.put(WsConstants.RESPONSEJSON, responseJson);		
		try {
			super.packetPutDB(inputJson, responseJson);
		} catch (Exception e) {
			logger.info("Rest报文保存数据库失败inputJson==>"+inputJson,e);
		}
		
		return true;
	}

}
