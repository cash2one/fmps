package cn.com.fubon.webservice.externl.coresystem.entity;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("packet")
public class ClaimNotCarRequest {
	@XStreamAlias("head")
    private ClaimRequestSender sender;
	
	private ClaimNotCarRequestBody body;
	

	public ClaimRequestSender getSender() {
		return sender;
	}

	public void setSender(ClaimRequestSender sender) {
		this.sender = sender;
	}

	public ClaimNotCarRequestBody getBody() {
		return body;
	}

	public void setBody(ClaimNotCarRequestBody body) {
		this.body = body;
	}
	
}
