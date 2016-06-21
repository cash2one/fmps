/**
 * 
 */
package cn.com.fubon.rest.entity.response;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * @author binbin.wang
 *
 */
@XStreamAlias("CPWS")
public class FbWSResponse {

	@XStreamAlias("CPWS_HEAD")
	private ResponseHead responseHead;

	@XStreamAlias("CPWS_BODY")
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
