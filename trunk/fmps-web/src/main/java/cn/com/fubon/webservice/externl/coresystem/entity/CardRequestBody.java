package cn.com.fubon.webservice.externl.coresystem.entity;

import com.thoughtworks.xstream.annotations.XStreamAlias;
/**
 * 卡单requstbody封装类<BODY>
 * @author qingqu.huang
 *
 */
public class CardRequestBody {

	@XStreamAlias("CARD_NO")
	private String cardNo;
	@XStreamAlias("CARD_PASSWD")
	private String cardPasswd;

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getCardPasswd() {
		return cardPasswd;
	}

	public void setCardPasswd(String cardPasswd) {
		this.cardPasswd = cardPasswd;
	}
}
