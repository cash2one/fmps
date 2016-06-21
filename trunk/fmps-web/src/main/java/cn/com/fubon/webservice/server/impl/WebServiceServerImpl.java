package cn.com.fubon.webservice.server.impl;

/**
 * 富邦微信平台WebService服务端入口
 * @author fangfang.guo
 * 2015-01-27
 */
import java.io.UnsupportedEncodingException;
import java.lang.annotation.Annotation;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.jws.WebService;

import jodd.datetime.JDateTime;

import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.Logger;
import org.jeecgframework.core.common.service.CommonService;
import org.jeecgframework.core.util.ApplicationContextUtil;
import org.jeecgframework.core.util.StringUtil;
import org.springframework.core.annotation.AnnotationUtils;

import weixin.guanjia.account.entity.WeixinAccountEntity;
import weixin.guanjia.account.service.WeixinAccountServiceI;
import weixin.guanjia.core.util.SignUtil;
import weixin.util.DateUtils;
import cn.com.fubon.exceptions.WebServiceException;
import cn.com.fubon.transaction.entity.TransactionRecord;
import cn.com.fubon.transaction.service.ITransactionRecordService;
import cn.com.fubon.util.AESUtils;
import cn.com.fubon.util.XmlUtils;
import cn.com.fubon.webservice.WsConstants;
import cn.com.fubon.webservice.entity.request.FbWSRequest;
import cn.com.fubon.webservice.entity.response.FbWSResponse;
import cn.com.fubon.webservice.entity.response.ResponseHead;
import cn.com.fubon.webservice.entity.response.TransResponse;
import cn.com.fubon.webservice.server.WebServiceServer;
import cn.com.fubon.webservice.server.handler.ServerHandler;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@WebService(targetNamespace = WsConstants.NS)
public class WebServiceServerImpl implements WebServiceServer {
	private static final Logger logger = Logger
			.getLogger(WebServiceServerImpl.class);

	@Resource(name = "transactionRecordService")
	private ITransactionRecordService transactionRecordService;

	@Resource(name = "weixinAccountService")
	private WeixinAccountServiceI weixinAccountService;

	@Resource(name = "commonService")
	private CommonService commonService;

	/**
	 * @param timestamp 客户端调用时间戳
	 * @param clientCode 客户端代码
	 * @param signature 签名
	 * @param inputXml 客户端加密后的报文
	 * @return 返回加密后的响应报文
	 * @throws Exception
	 */
	@Override
	public String service(String timestamp, String clientCode,
			String signature, String inputXml) {
		String token = null;
		String AESKey = null;
		String responseXml = null;
		byte[] key = null;
		FbWSResponse fbWSResponse = null;

		// 根据客户端代码获取(双方约定的16位随机码)token和(双方约定的43位随机码)AESKey
		Map<String, Object> clientManagement = commonService.findOneForJdbc(
				"select token,AESKey from webservice_client_management "
						+ "where status=1 and clientCode = ? ", clientCode);
		logger.info("EnterWebService==clientCode===>" + clientCode);
		if(clientManagement == null){
			// 客户端代码不存在或者无效
			logger.error("service invalid clientCode, clientCode==>" + clientCode + "==token==>" + token + "==signature==>" + signature + 
						"==timestamp==>" + timestamp + "==inputXml==>" + inputXml);
			throw new WebServiceException(WsConstants.RETURNMESSAGE_2);
		} else {
			token = (String) clientManagement.get("token");
			AESKey = (String) clientManagement.get("AESKey");
			try {
				// 初始化密钥
				key = AESUtils.initKey(AESKey);
			} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
				logger.error("service initKey failed!",e);
				throw new WebServiceException(WsConstants.RETURNMESSAGE_9);
			}

		}

		// 验签
		if (!SignUtil.checkSignature(token, signature, timestamp, inputXml)) {
			// 验签失败处理
			logger.error(WsConstants.RETURNMESSAGE_3 + "==token==>" + token + "==signature==>" + signature + 
					"==timestamp==>" + timestamp + "==inputXml==>" + inputXml);
			throw new WebServiceException(WsConstants.RETURNMESSAGE_3);
			
		} 
		
		// 验签通过，开始解密
		try {
			// 解密
			inputXml = new String(AESUtils.decrypt(
					Base64.decodeBase64(inputXml.getBytes("UTF-8")), key),
					"UTF-8");
			// logger.info("decrypted inputXml==>" + inputXml);

		} catch (Exception e) {
			logger.error("service decrypt failed, token==>" + token + "==signature==>" + signature + 
					"==timestamp==>" + timestamp + "==inputXml==>" + inputXml,e);
			// 解密失败,抛出异常
			throw new WebServiceException(WsConstants.RETURNMESSAGE_4);
		}
		
		// 客户端请求报文转成请求对象
		FbWSRequest fbWSRequest = this.convertXmlToFbWSRequest(inputXml);

		if (StringUtil.isEmpty(responseXml)) {
			// 得到实际的处理类
			ServerHandler handler = this.getActualHandler(clientCode);

			// 实际的处理方法返回FbWSResponse对象
			fbWSResponse = handler.process(fbWSRequest);

			// 服务端响应对象转成响应报文
			responseXml = this.convertFbWSResponseToXml(fbWSResponse);

		}

		// 报文入库，报文实体TransactionRecord，表weixin_transaction_record
		packetPutDB(fbWSRequest, inputXml, fbWSResponse, responseXml);

		// 响应报文加密
		responseXml = encryptResponseXml(responseXml, key);

		return responseXml;

	}

	/**
	 * 客户端请求报文转成FbWSRequest对象
	 * 
	 * @param inputXml
	 * @return
	 */
	public FbWSRequest convertXmlToFbWSRequest(String inputXml) {
		Annotation annotation = FbWSRequest.class
				.getAnnotation(XStreamAlias.class);
		String annotationValue = (String) AnnotationUtils.getValue(annotation);
		return (FbWSRequest) XmlUtils.fromXML(inputXml, annotationValue,
				FbWSRequest.class);
	}

	/**
	 * FbWSResponse对象转成响应报文
	 * 
	 * @param response
	 * @return
	 */
	public String convertFbWSResponseToXml(FbWSResponse response) {
		return WsConstants.XML_DECLARATION + XmlUtils.toXML(response);
	}

	/**
	 * 根据客户端代码得到实际的处理对象
	 * 
	 * @param clientCode
	 */
	public ServerHandler getActualHandler(String clientCode) {
		clientCode = clientCode.toLowerCase();
		String serverHandler = "client" + clientCode + "ServerHandler";
		ServerHandler handler = (ServerHandler) ApplicationContextUtil
				.getContext().getBean(serverHandler);
		return handler;
	}

	/**
	 * 响应报文加密
	 * 
	 * @param responseXml 响应报文
	 * @param AESKey AES密钥
	 */
	public String encryptResponseXml(String responseXml, byte[] AESKey){
		// 响应报文加密
		byte[] responseData = responseXml.getBytes();
		
		try {
			responseData = AESUtils.encrypt(responseData, AESKey);
		} catch (InvalidKeyException | NoSuchAlgorithmException
				| NoSuchPaddingException | IllegalBlockSizeException
				| BadPaddingException e) {
			
			logger.error("service encryptResponseXml failed!", e);
			// 加密失败,抛出异常
			throw new WebServiceException(WsConstants.RETURNMESSAGE_5);
		}
		responseXml = Base64.encodeBase64String(responseData);
		return responseXml;
	}

	/**
	 * 报文入库
	 * 
	 * @param fbWsRequest 内部请求对象
	 * @param fbWsRequestXml 内部请求xml
	 * @param fbWsResponse 内部响应对象
	 * @param fbWsResponseXml 内部响应xml
	 */
	public void packetPutDB(FbWSRequest fbWsRequest, String fbWsRequestXml,
			FbWSResponse fbWsResponse, String fbWsResponseXml) {
		List<WeixinAccountEntity> weixinAccountEntityList = weixinAccountService
				.findValidWeixinAccounts();
		WeixinAccountEntity weixinAccountEntity = weixinAccountEntityList
				.get(0);
		TransactionRecord transactionRecordEntity = new TransactionRecord();
		transactionRecordEntity.setTransactionId(fbWsResponse.getResponseHead()
				.getTranscationSeqNo());
		Timestamp dateTime = Timestamp.valueOf(DateUtils
				.getDate("yyyy-MM-dd HH:mm:ss"));
		transactionRecordEntity.setCreateTime(dateTime);
		transactionRecordEntity.setFromuser(fbWsRequest.getRequestHead()
				.getClientCode());
		transactionRecordEntity.setTouser(fbWsRequest.getRequestHead()
				.getServerCode());
		transactionRecordEntity.setTransactionFormat("XML");
		transactionRecordEntity.setTransactionType(fbWsRequest.getRequestHead()
				.getTranscationCode());
		transactionRecordEntity.setAccount(weixinAccountEntity);
		transactionRecordEntity.setInternalRequest(fbWsRequestXml);
		transactionRecordEntity.setInternalResponse(fbWsResponseXml);
		transactionRecordService.save(transactionRecordEntity);
	}

	/**
	 * 返回代码和信息响应报文给客户端
	 * 
	 * @param returnCode
	 * @param returnMessage
	 * @return String 响应报文
	 * @throws Exception
	 */
	public Map<String, FbWSResponse> returnMessageToClient(String returnCode,
			String returnMessage) {
		FbWSResponse response = new FbWSResponse();
		ResponseHead responseHead = new ResponseHead();
		JDateTime jnow = new JDateTime(new Date());
		responseHead.setTranscationDate(jnow.toString("YYYYMMDD"));
		responseHead.setTranscationTime(jnow.toString("hhmmss"));
		TransResponse transResponse = new TransResponse();
		transResponse.setReturnCode(returnCode);
		transResponse.setReturnMessage(returnMessage);
		responseHead.setTransResponse(transResponse);
		response.setResponseHead(responseHead);
		Map<String, FbWSResponse> map = new HashMap<String, FbWSResponse>();
		map.put(WsConstants.XML_DECLARATION + XmlUtils.toXML(response),
				response);
		return map;
	}
}
