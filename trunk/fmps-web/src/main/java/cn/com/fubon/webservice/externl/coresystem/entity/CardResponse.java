package cn.com.fubon.webservice.externl.coresystem.entity;

import cn.com.fubon.util.XmlUtils;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 激活卡webservice返回
 * 
 * @author fangfang.guo
 *
 */
@XStreamAlias("PACKET")
public class CardResponse {

	@XStreamAlias("HEAD")
	private CardResponseSender sender;

	@XStreamAlias("BODY")
	private CardResponseBody body;

	public CardResponseSender getSender() {
		return sender;
	}

	public void setSender(CardResponseSender sender) {
		this.sender = sender;
	}

	public CardResponseBody getBody() {
		return body;
	}

	public void setBody(CardResponseBody body) {
		this.body = body;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String xml = "" + "<packet>" + "<head>"
				+ "<TRANSTYPE>RESPONSE</TRANSTYPE>"
				+ "<TRANSCODE>612001</TRANSCODE>" + "<USER></USER>"
				+ "<PASSWORD></PASSWORD>" + "<SVCSEQNO></SVCSEQNO>"
				+ "<RESPONSE_CODE></RESPONSE_CODE>"
				+ "<ERROR_MESSAGE></ERROR_MESSAGE>" + "<USERIP></USERIP>"
				+ "<SIMULATION>0</SIMULATION>" + "</head>" + "<body>"
				+ "<CARD_NO>03130001140000042</CARD_NO>"
				+ "<CARD_VERSION_CODE>0313000100000000</CARD_VERSION_CODE>"
				+ "<VALIDATE>1</VALIDATE>" + "<STATE>-1</STATE>"
				+ "<NOT_PASS_REASON>-1</NOT_PASS_REASON>"
				+ "<COM_CODE>0000078000</COM_CODE>"
				+ "<COM_NAME>富邦财产保险有限公司</COM_NAME>"
				+ "<COM_ADDRESS>厦门市湖滨北路101号商业大厦4楼A区</COM_ADDRESS>" + "</body>"
				+ "</packet>";

		CardResponse claimResponse = (CardResponse) XmlUtils.fromXML(xml,
				"packet", CardResponse.class);
		System.out.println(claimResponse.getBody().getState());
	}

}
