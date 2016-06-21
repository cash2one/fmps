package cn.com.fubon.webservice.server;

/**
 * @author fangfang.guo
 * 微信平台作为服务端的webservice接口
 */

import javax.jws.WebParam;
import javax.jws.WebService; 
import cn.com.fubon.webservice.WsConstants;

@WebService(targetNamespace=WsConstants.NS)
public interface WebServiceServer {
	/**
	 * @param timestamp 客户端调用时间戳
	 * @param clientCode 客户端代码
	 * @param signature 签名
	 * @param inputXml 客户端加密后的报文
	 * @return 返回加密后的响应报文
	 */	
	public String service(@WebParam(name="timestamp") String timestamp,
						  @WebParam(name="clientCode") String clientCode,
						  @WebParam(name="signature") String signature,
						  @WebParam(name="inputXml") String inputXml);
	
}
