package cn.com.fubon.rest.service.impl;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import net.sf.json.JSONObject;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.jeecgframework.core.common.service.CommonService;
import org.jeecgframework.core.util.ApplicationContextUtil;
import org.jeecgframework.core.util.DateUtils;

import weixin.guanjia.account.entity.WeixinAccountEntity;
import weixin.guanjia.account.service.WeixinAccountServiceI;
import weixin.guanjia.core.util.SignUtil;
import cn.com.fubon.exceptions.WebServiceException;
import cn.com.fubon.fo.repairplatform.entity.BaseResult;
import cn.com.fubon.rest.service.CommonWebService;
import cn.com.fubon.transaction.entity.TransactionRecord;
import cn.com.fubon.transaction.service.ITransactionRecordService;
import cn.com.fubon.util.AESUtils;
import cn.com.fubon.webservice.WsConstants;
import cn.com.fubon.webservice.server.entity.WebServiceClientManagement;

import com.google.gson.JsonObject;

public class CommonWebServiceImpl implements CommonWebService {
	Logger logger = Logger.getLogger(CommonWebServiceImpl.class);

	/**
	 * 验签和解密
	 * 
	 * @param timestamp
	 * @param signature
	 * @param inputJson
	 * @param clientCode
	 * @return Map<byte[],String> key和responseJson
	 */
	public Map<String, Object> checkSignatureAndDecrypt(String timestamp,
			String signature, String inputJson, String clientCode) {

		String token = null;
		String AESKey = null;
		String responseJson = null;
		byte[] key = null;
		Map<String, Object> resultMap = new HashMap<String, Object>();
		CommonService commonService = (CommonService) ApplicationContextUtil
				.getContext().getBean("commonService");
		WebServiceClientManagement webServiceClientManagement = commonService
				.findUniqueByProperty(WebServiceClientManagement.class,
						"clientCode", clientCode);
		BaseResult baseResult = new BaseResult();

		// 查不到记录会返回[],所以不需要校验空指针
		if (webServiceClientManagement == null) {
			// 客户端代码不存在或者无效
			logger.error(WsConstants.RETURNMESSAGE_2 + ",clientCode==>"
					+ clientCode);
			throw new WebServiceException(WsConstants.RETURNMESSAGE_2);
		} else {
			token = webServiceClientManagement.getToken();
			AESKey = webServiceClientManagement.getAESKey();
			try {
				// 初始化密钥
				key = AESUtils.initKey(AESKey);
			} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
				logger.error(
						"service initKey NoSuchAlgorithmException or UnsupportedEncodingException!",
						e);
				// 其他未知错误
				logger.error(WsConstants.RETURNMESSAGE_9);
				throw new WebServiceException(WsConstants.RETURNMESSAGE_9);
			}

			// 验签
			boolean isSignatureOk = false;
			if (StringUtils.isEmpty(responseJson)) {
				isSignatureOk = SignUtil.checkSignature(token, signature,
						timestamp, inputJson);
			}
			if (isSignatureOk) {
				// 验签通过，开始解密
				inputJson = this.decryptJson(inputJson, key);

			} else if (StringUtils.isEmpty(responseJson) && !isSignatureOk) {
				// 验签失败处理
				baseResult.setErrcode(WsConstants.RETURNCODE_3);
				baseResult.setErrmsg(WsConstants.RETURNMESSAGE_3);
				responseJson = this.returnMessageToClient(baseResult);
			}

		}

		resultMap.put(WsConstants.RESPONSEJSON, responseJson);
		resultMap.put(WsConstants.AESKEY, key);
		resultMap.put(WsConstants.INPUTJSON, inputJson);
		return resultMap;
	}

	/**
	 * 交易报文入库
	 */
	public void packetPutDB(String inputJson, String responseJson) {
		WeixinAccountServiceI weixinAccountService = (WeixinAccountServiceI) ApplicationContextUtil
				.getContext().getBean("weixinAccountService");
		List<WeixinAccountEntity> weixinAccountEntityList = weixinAccountService
				.findValidWeixinAccounts();
		WeixinAccountEntity weixinAccountEntity = weixinAccountEntityList
				.get(0);

		TransactionRecord transactionRecord = new TransactionRecord();
		try {
			JSONObject requestJson = JSONObject.fromObject(inputJson);
			transactionRecord.setFromuser(requestJson.get("fromUser")
					.toString());
			transactionRecord.setTouser(requestJson.get("toUser").toString());
			transactionRecord.setTransactionFormat(requestJson.get(
					"transactionFormat").toString());
			transactionRecord.setTransactionType(requestJson.get(
					"transactionType").toString());
			transactionRecord.setTransactionId(requestJson.get("transactionId")
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

	@Override
	public String process(String inputJson) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String returnMessageToClient(BaseResult baseResult) {
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("errcode", baseResult.getErrcode());
		jsonObject.addProperty("errmsg", baseResult.getErrmsg());
		return jsonObject.toString();
	}

	/**
	 * 报文解密
	 * 
	 * @param json
	 *            交易报文明文
	 * @param AESKey
	 *            AES密钥
	 */
	public String decryptJson(String json, byte[] AESKey) {
		try {
			json = new String(AESUtils.decrypt(
					Base64.decodeBase64(json.getBytes("UTF-8")), AESKey),
					"UTF-8");
			logger.info("decrypted json==>" + json);
		} catch (InvalidKeyException | UnsupportedEncodingException
				| NoSuchAlgorithmException | NoSuchPaddingException
				| IllegalBlockSizeException | BadPaddingException e) {
			logger.error("service decrypt error!", e);
			// 返回解密失败响应报文
			throw new WebServiceException(WsConstants.RETURNMESSAGE_8);
		}
		return json;
	}

	/**
	 * 报文加密
	 * 
	 * @param json
	 *            交易报文明文
	 * @param AESKey
	 *            AES密钥
	 */
	public String encryptJson(String json, byte[] AESKey) {
		byte[] jsonData = null;
		try {
			// changed by qingqu.huang,2015-10-13 处理中文乱码问题
			jsonData = json.getBytes("UTF-8");
			jsonData = AESUtils.encrypt(jsonData, AESKey);
		} catch (InvalidKeyException | NoSuchAlgorithmException
				| NoSuchPaddingException | IllegalBlockSizeException
				| BadPaddingException | UnsupportedEncodingException e) {
			logger.error("encrypt failed,json:\n" + json, e);
			throw new WebServiceException(WsConstants.RETURNMESSAGE_7, e);
		}

		return Base64.encodeBase64String(jsonData);
	}
}
