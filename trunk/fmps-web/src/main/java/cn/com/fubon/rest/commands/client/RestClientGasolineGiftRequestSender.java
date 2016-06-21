package cn.com.fubon.rest.commands.client;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.util.List;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

import net.sf.json.JSONObject;

import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;
import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.Logger;
import org.jeecgframework.core.util.ApplicationContextUtil;

import weixin.guanjia.account.entity.WeixinAccountEntity;
import weixin.guanjia.account.service.WeixinAccountServiceI;
import weixin.guanjia.core.util.SignUtil;
import weixin.popular.util.JsonUtil;
import weixin.util.DateUtils;
import cn.com.fubon.exceptions.WebServiceException;
import cn.com.fubon.rest.entity.request.GasolineGiftCarRequest;
import cn.com.fubon.rest.entity.request.GasolineGiftQueryRequest;
import cn.com.fubon.rest.entity.response.GasolineGiftCarResponse;
import cn.com.fubon.rest.entity.response.GasolineGiftQueryResponse;
import cn.com.fubon.rest.service.impl.CommonWebServiceImpl;
import cn.com.fubon.transaction.entity.TransactionRecord;
import cn.com.fubon.transaction.service.ITransactionRecordService;
import cn.com.fubon.util.AESUtils;
import cn.com.fubon.util.MD5Utils;
import cn.com.fubon.webservice.WsConstants;
















import com.sun.jersey.api.client.WebResource;


import com.sun.jersey.core.util.MultivaluedMapImpl;

public class RestClientGasolineGiftRequestSender implements Command {
	private static final Logger logger = Logger.getLogger(RestClientGasolineGiftRequestSender.class); 
	
	private RestClient  restClient  ;
	 
	public RestClient getRestClient() {
		return restClient;
	}
	public void setRestClient(RestClient restClient) {
		this.restClient = restClient;		
	} 
	
	
	@Override
	public boolean execute(Context context) throws Exception {
		
		String inputJson = (String)context.get(WsConstants.CHAIN_CONTEXT_KEY_WS_INPUTJSON);
		String url = (String)context.get(WsConstants.CHAIN_CONTEXT_KEY_WS_ENTRY_URL);
		String secretKey = (String)context.get(WsConstants.CHAIN_CONTEXT_KEY_WS_secretKey);

		String requestJsonBase64 = "";
		try {
			requestJsonBase64 = Base64.encodeBase64String(inputJson.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String signature = MD5Utils.MD5(requestJsonBase64+secretKey);
		WebResource webResource =restClient.getClient().resource(url);		
		MultivaluedMap<String, String> param = new MultivaluedMapImpl();
		param.add("signature", signature);
		param.add("reqContent",URLEncoder.encode(requestJsonBase64));		
		String encryptResponseJson = null;		
		try{
			encryptResponseJson = webResource.path("").queryParams(param)
				.type(MediaType.APPLICATION_JSON).post(String.class);
		} catch(Exception e){
			logger.error(WsConstants.RETURNMESSAGE_9,e);		 
		}		
		String responseJson=decryptResponse (encryptResponseJson,secretKey);
		context.put(WsConstants.RESPONSEJSON, responseJson);	
		packetPutDB(inputJson, responseJson);		
		return true;
	  } 
	  /**
	   * 解密及验签
	   * @param response
	   * @return
	   */
	private String decryptResponse(String response,String secretKey){
		String responseBase64 = null;		
		try {
			responseBase64=java.net.URLDecoder.decode(response,"UTF-8");
		} catch (UnsupportedEncodingException e) {			
			e.printStackTrace();
		}
		String signatureResp=responseBase64.substring(10,responseBase64.indexOf("&respContent="));
		String reqContent=responseBase64.substring(responseBase64.indexOf("&respContent=")+13);		
		String signature = MD5Utils.MD5(reqContent+secretKey);
		String returnMessage="";
		if (signatureResp.equals(signature)){	
		try {
			returnMessage=new String(Base64.decodeBase64(reqContent),"UTF-8");
		   } catch (UnsupportedEncodingException e) {			
			 e.printStackTrace();
		   }
		} else{	
			logger.info("加油宝接口，换回报文验签不通过"+reqContent);
			returnMessage="接口验签错误";
		}		
		return returnMessage;
	}
	

	/**
	 * 交易报文入库
	 */
	private void packetPutDB(String inputJson, String responseJson) {
		WeixinAccountServiceI weixinAccountService = (WeixinAccountServiceI) ApplicationContextUtil
				.getContext().getBean("weixinAccountService");
		List<WeixinAccountEntity> weixinAccountEntityList = weixinAccountService
				.findValidWeixinAccounts();
		WeixinAccountEntity weixinAccountEntity = weixinAccountEntityList
				.get(0);

		TransactionRecord transactionRecord = new TransactionRecord();
		try {
			JSONObject requestJson = JSONObject.fromObject(inputJson);
			transactionRecord.setFromuser("hexin");
			transactionRecord.setTouser("fubon");
			transactionRecord.setTransactionFormat("json");
			transactionRecord.setTransactionType(" ");			
			transactionRecord.setTransactionId(requestJson.get("transId")
					.toString());
		} catch (Exception e) {
			logger.error("trans inputJson to json failed", e);
		}

		transactionRecord.setExternalRequest(inputJson);
		transactionRecord.setExternalResponse(responseJson);

		Timestamp dateTime = Timestamp.valueOf(DateUtils
				.getDate("yyyy-MM-dd HH:mm:ss"));
		transactionRecord.setCreateTime(dateTime);
		transactionRecord.setAccount(weixinAccountEntity);
		transactionRecord.setRespDateTime(dateTime);
		ITransactionRecordService transactionRecordService = (ITransactionRecordService) ApplicationContextUtil
				.getContext().getBean("transactionRecordService");
		transactionRecordService.save(transactionRecord);
	}
	
	
}
