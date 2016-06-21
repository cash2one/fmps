package cn.com.fubon.rest;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.Logger;

import weixin.guanjia.core.util.SignUtil;
import weixin.util.DateUtils;
import cn.com.fubon.util.AESUtils;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;
import com.sun.jersey.core.util.MultivaluedMapImpl;

public class RestClient {
	private static final Logger logger = Logger.getLogger(RestClient.class);
	
	private String url;
	private String method;
	private String token;
	private String AESKey;
	private String clientCode; 
	
	public RestClient( String url,String method,String token, String AESKey, String clientCode){
		this.url=url;
		this.method=method;
		this.token=token;
		this.AESKey=AESKey;
		this.clientCode=clientCode;	 
	}
	
	public String send( String input){
		ClientConfig clientConfig = new DefaultClientConfig();
		clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING,
				Boolean.TRUE);
		Client c = Client.create(clientConfig);	
		WebResource r = c.resource(url);	
		String timestamp = DateUtils.getDate("yyyy-MM-dd HH:mm:ss");		
		String signature = null;		
		byte[] inputDataByte=null;
		byte[] inputDataAES=null;
		try {
			//inputEncode = URLEncoder.encode(input,"UTF-8").toString();
			inputDataByte = input.getBytes("UTF-8");
			inputDataAES = AESUtils.encrypt(inputDataByte, AESUtils.initKey(AESKey));
		} catch (InvalidKeyException | UnsupportedEncodingException
				| NoSuchAlgorithmException | NoSuchPaddingException
				| IllegalBlockSizeException | BadPaddingException e) {
			logger.error("encrypt failed", e);
		}
		
		String	inputBase64 = Base64.encodeBase64String(inputDataAES);
		signature = SignUtil.generateSignature(token, timestamp, inputBase64);
		MultivaluedMap<String, String> param = new MultivaluedMapImpl();
		param.add("timestamp", timestamp);
		param.add("signature", signature);
		param.add("inputJson", inputBase64);
		param.add("clientCode", clientCode);
		String respone = r.path(method).queryParams(param)
				.type(MediaType.APPLICATION_JSON).post(String.class);
		logger.info(respone);
		String responeXML = null;
		
		try {
			responeXML = new String(AESUtils.decrypt(
					Base64.decodeBase64(respone.getBytes("UTF-8")),
					AESUtils.initKey(AESKey)),"UTF-8");
			//	responeXML =java.net.URLDecoder.decode(responeXML, "UTF-8");
		} catch (InvalidKeyException | UnsupportedEncodingException
				| NoSuchAlgorithmException | NoSuchPaddingException
				| IllegalBlockSizeException | BadPaddingException e) {
			logger.error("decrypt failed", e);
		}
		
		logger.info(responeXML);		
		return responeXML;
	}
	
	
	

}
