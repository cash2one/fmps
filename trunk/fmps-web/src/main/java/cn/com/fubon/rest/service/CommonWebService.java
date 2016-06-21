package cn.com.fubon.rest.service;

import java.util.Map;

import cn.com.fubon.fo.repairplatform.entity.BaseResult;

/**
 * restful方式新增的CommonWebService
 * @author fangfang.guo
 *
 */
public interface CommonWebService {
	
	/**
	 * 验签和解密
	 * 
	 * @param timestamp 时间戳
	 * @param signature 签名
	 * @param inputJson 请求报文
	 * @param clientCode 客户端代码
	 * @return Map<byte[],String> 存key,加密前的responseJson和解密后的inputJson
	 */
	public Map<String,Object> checkSignatureAndDecrypt(String timestamp,
			String signature, String inputJson, String clientCode);
	
	/**
	 * 交易报文入库
	 * @param inputJson
	 * @param responseJson
	 */
	public void packetPutDB(String inputJson, String responseJson);
	
	/**
	 * 业务处理
	 * @param inputJson
	 * @return responseJson
	 */
	public String process(String inputJson);
	
	/**
	 * 返回信息到客户端
	 * 
	 * @param baseResult
	 * @return
	 */
	public String returnMessageToClient(BaseResult baseResult);
	
	/**
	 * 交易报文加密
	 * 
	 * @param json 交易报文明文
	 * @param AESKey AES密钥
	 */
	public String encryptJson(String json, byte[] AESKey) ;
}
