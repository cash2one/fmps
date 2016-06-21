/**
 * 
 */
package cn.com.fubon.webservice.externl.coresystem.entity;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 投保响应报文实体
 * 
 * @author qingqu.huang
 *
 */
@XStreamAlias("PACKET")
public class PolicyResponse {
	@XStreamAlias("HEAD")
	private PolicyResponseSender sender;
	@XStreamAlias("BODY")
	private PolicyResponseBody body;

	/**
	 * @return the sender
	 */
	public PolicyResponseSender getSender() {
		return sender;
	}

	/**
	 * @param sender
	 *            the sender to set
	 */
	public void setSender(PolicyResponseSender sender) {
		this.sender = sender;
	}

	/**
	 * @return the body
	 */
	public PolicyResponseBody getBody() {
		return body;
	}

	/**
	 * @param body
	 *            the body to set
	 */
	public void setBody(PolicyResponseBody body) {
		this.body = body;
	}
}
