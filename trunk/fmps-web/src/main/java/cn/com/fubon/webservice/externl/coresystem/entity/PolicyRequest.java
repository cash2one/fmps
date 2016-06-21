/**
 * 
 */
package cn.com.fubon.webservice.externl.coresystem.entity;

import cn.com.fubon.util.XmlUtils;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 投保报文实体
 * @author qingqu.huang
 *
 */
@XStreamAlias("PACKET")
public class PolicyRequest {
	@XStreamAlias("HEAD")
	private PolicyRequestSender sender;
	@XStreamAlias("BODY")
	private PolicyRequestBody body;

	/**
	 * @return the sender
	 */
	public PolicyRequestSender getSender() {
		return sender;
	}

	/**
	 * @param sender
	 *            the sender to set
	 */
	public void setSender(PolicyRequestSender sender) {
		this.sender = sender;
	}

	/**
	 * @return the body
	 */
	public PolicyRequestBody getBody() {
		return body;
	}

	/**
	 * @param body
	 *            the body to set
	 */
	public void setBody(PolicyRequestBody body) {
		this.body = body;
	}

	public static void main(String[] args) {
		PolicyRequestSender sender = new PolicyRequestSender();
		sender.setTransType("request");
		sender.setTransCode("612002");
		PolicyRequestBody body = new PolicyRequestBody();
		Applicant ac=new Applicant();
		ac.setEmail("896737372@qq.com");
		body.setApplicant(ac);
		
		PolicyRequest req=new PolicyRequest();
		req.setBody(body);
		req.setSender(sender);
		System.out.println(XmlUtils.toXML(req).toString());
	}

}
