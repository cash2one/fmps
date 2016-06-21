/**
 * 
 */
package cn.com.fubon.rest.entity.request;

import java.io.ObjectStreamException;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * @author binbin.wang
 *
 */
@XStreamAlias("CPWS")
public class FbWSRequest {

	@XStreamAlias("CPWS_HEAD")
	private RequestHead requestHead;

	@XStreamAlias("CPWS_BODY")
	private RequestBody requestBody;

	/**
	 * 
	 */
	public FbWSRequest() {
		// TODO Auto-generated constructor stub
	}

	public RequestHead getRequestHead() {
		return requestHead;
	}

	public void setRequestHead(RequestHead requestHead) {
		this.requestHead = requestHead;
	}

	public RequestBody getRequestBody() {
		return requestBody;
	}

	public void setRequestBody(RequestBody requestBody) {
		this.requestBody = requestBody;
	}

	public static void main(String[] args) throws ObjectStreamException {
		RequestHead head = new RequestHead();
		FbWSRequest wsRequest = new FbWSRequest();
		wsRequest.setRequestHead(head);
	}

}
