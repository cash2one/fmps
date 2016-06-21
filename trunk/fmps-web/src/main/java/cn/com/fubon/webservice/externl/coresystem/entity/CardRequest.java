package cn.com.fubon.webservice.externl.coresystem.entity;

import cn.com.fubon.util.XmlUtils;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 卡单激活request封装类
 * 
 * @author qingqu.huang
 *
 */
@XStreamAlias("PACKET")
public class CardRequest {
	@XStreamAlias("HEAD")
	private CardRequestSender sender;

	@XStreamAlias("BODY")
	private CardRequestBody body;

	public CardRequestSender getSender() {
		return sender;
	}

	public void setSender(CardRequestSender sender) {
		this.sender = sender;
	}

	public CardRequestBody getBody() {
		return body;
	}

	public void setBody(CardRequestBody body) {
		this.body = body;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CardRequestSender sender = new CardRequestSender();
		// sender.setTransactionNo(UUIDGenerator.generate());
		sender.setTransType("request");
		sender.setTransCode("612001");
		sender.setSimulation("0");

		CardRequestBody body = new CardRequestBody();
		body.setCardNo("03130001140000042");
		body.setCardPasswd("6273352241");

		CardRequest cardRequest = new CardRequest();
		cardRequest.setSender(sender);
		cardRequest.setBody(body);

		System.out.println(XmlUtils.toXML(cardRequest).toString());

	}

}
