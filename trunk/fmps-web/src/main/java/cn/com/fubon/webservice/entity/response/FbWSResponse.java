/**
 * 
 */
package cn.com.fubon.webservice.entity.response;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * @author binbin.wang
 *
 */
@XStreamAlias("TRANSACTION")
public class FbWSResponse {

	@XStreamAlias("TRANSACTION_HEAD")	
	private ResponseHead responseHead;
	
	@XStreamAlias("TRANSACTION_BODY")
	private ResponseBody responseBody;
	
	public ResponseHead getResponseHead() {
		return responseHead;
	}
	public void setResponseHead(ResponseHead responseHead) {
		this.responseHead = responseHead;
	}
	public ResponseBody getResponseBody() {
		return responseBody;
	}
	public void setResponseBody(ResponseBody responseBody) {
		this.responseBody = responseBody;
	}

}
