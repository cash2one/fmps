/**
 * 
 */
package cn.com.fubon.rest.entity.response;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 交易响应
 * 
 * @author binbin.wang
 *
 */
public class CpwsResponse {
	
	@XStreamAlias("RETURN_CODE")
	private String returnCode;
	
	@XStreamAlias("RETURN_MESSAGE")
	private String returnMessage;
	
	public String getReturnCode() {
		return returnCode;
	}

	public void setReturnCode(String returnCode) {
		this.returnCode = returnCode;
	}

	public String getReturnMessage() {
		return returnMessage;
	}

	public void setReturnMessage(String returnMessage) {
		this.returnMessage = returnMessage;
	}
	
}
