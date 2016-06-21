package cn.com.fubon.webservice.externl.coresystemUnderwrite.entity.response;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 微店承保响应报文TRANSACTION部分
 * 
 * @author yaoming.zhang
 */
@XStreamAlias("TRANSACTION")
public class UnderwriteResponse {
	
	@XStreamAlias("HEAD")
	private UnderwriteResponseHead head;
	@XStreamAlias("BODY")
	private UnderwriteResponseBody body;
	
	public UnderwriteResponseHead getHead() {
		return head;
	}
	public void setHead(UnderwriteResponseHead head) {
		this.head = head;
	}
	public UnderwriteResponseBody getBody() {
		return body;
	}
	public void setBody(UnderwriteResponseBody body) {
		this.body = body;
	}
}
