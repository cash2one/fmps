/**
 * 
 */
package cn.com.fubon.webservice.converter;

import cn.com.fubon.webservice.entity.request.FbWSRequest;

/**
 * 请求报文转换器
 * 
 * @author binbin.wang
 *
 */
public interface RequestConverter<T> {

	/**
	 * 將FbWsReqeust转换为外部系统
	 * @param fbWsRequest
	 * @return
	 */
	T convertToExternlType(FbWSRequest fbWsRequest);
	
	/**
	 * 将外部类型转换为FbWsRequest
	 * 
	 * @param externalType
	 * @return
	 */
	FbWSRequest convertToFbWSRequest(T externalType);
}
