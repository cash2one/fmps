package cn.com.fubon.webservice.externl.coresystem.entity;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 激活卡用到的ResponseBody
 * 
 * @author fangfang.guo
 *
 */
public class CardResponseBody {

	@XStreamAlias("CARD_NO")
	private String cardNo;
	@XStreamAlias("CARD_VERSION_CODE")
	private String cardVersionCode;
	@XStreamAlias("VALIDATE")
	private String validate;
	@XStreamAlias("STATE")
	private String state;
	@XStreamAlias("NOT_PASS_REASON")
	private String notPassReason;
	@XStreamAlias("COM_CODE")
	private String comCode;
	@XStreamAlias("COM_NAME")
	private String comName;
	@XStreamAlias("COM_ADDRESS")
	private String comAddress;
	/**
	 * @return the cardNo
	 */
	public String getCardNo() {
		return cardNo;
	}
	/**
	 * @param cardNo the cardNo to set
	 */
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	/**
	 * @return the cardVersionCode
	 */
	public String getCardVersionCode() {
		return cardVersionCode;
	}
	/**
	 * @param cardVersionCode the cardVersionCode to set
	 */
	public void setCardVersionCode(String cardVersionCode) {
		this.cardVersionCode = cardVersionCode;
	}
	/**
	 * @return the validate
	 */
	public String getValidate() {
		return validate;
	}
	/**
	 * @param validate the validate to set
	 */
	public void setValidate(String validate) {
		this.validate = validate;
	}
	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}
	/**
	 * @return the notPassReason
	 */
	public String getNotPassReason() {
		return notPassReason;
	}
	/**
	 * @param notPassReason the notPassReason to set
	 */
	public void setNotPassReason(String notPassReason) {
		this.notPassReason = notPassReason;
	}
	/**
	 * @return the comCode
	 */
	public String getComCode() {
		return comCode;
	}
	/**
	 * @param comCode the comCode to set
	 */
	public void setComCode(String comCode) {
		this.comCode = comCode;
	}
	/**
	 * @return the comName
	 */
	public String getComName() {
		return comName;
	}
	/**
	 * @param comName the comName to set
	 */
	public void setComName(String comName) {
		this.comName = comName;
	}
	/**
	 * @return the comAddress
	 */
	public String getComAddress() {
		return comAddress;
	}
	/**
	 * @param comAddress the comAddress to set
	 */
	public void setComAddress(String comAddress) {
		this.comAddress = comAddress;
	}

}
