package cn.com.fubon.webservice.externl.coresystemUnderwrite.entity;

import cn.com.fubon.webservice.externl.coresystemUnderwrite.entity.request.UnderwriteRequestBody;
import cn.com.fubon.webservice.externl.coresystemUnderwrite.entity.request.UnderwriteRequestHead;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 微店承保请求报文TRANSACTION部分
 * 
 * @author yaoming.zhang
 */
@XStreamAlias("TRANSACTION")
public class UnderwriteTransaction {
	
	@XStreamAlias("HEAD")
	private UnderwriteRequestHead head;
	
	@XStreamAlias("BODY")
	private UnderwriteRequestBody body;

	public UnderwriteRequestHead getHead() {
		return head;
	}

	public void setHead(UnderwriteRequestHead head) {
		this.head = head;
	}

	public UnderwriteRequestBody getBody() {
		return body;
	}

	public void setBody(UnderwriteRequestBody body) {
		this.body = body;
	}
	
}
