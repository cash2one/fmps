package cn.com.fubon.webservice.externl.coresystem.entity;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 理赔webservice返回
 * @author xiaomei.wu
 *
 */
@XStreamAlias("packet")
public class ClaimNotCarResponse {

	@XStreamAlias("head")
	private ClaimResponseSender sender;
	
	@XStreamAlias("body")	
	private ClaimNotCarResponseBody body;
	
	public ClaimResponseSender getSender() {
		return sender;
	}

	public void setSender(ClaimResponseSender sender) {
		this.sender = sender;
	}

	public ClaimNotCarResponseBody getBody() {
		return body;
	}

	public void setBody(ClaimNotCarResponseBody body) {
		this.body = body;
	}
}

