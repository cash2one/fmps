/**
 * 
 */
package cn.com.fubon.webservice.externl.coresystem.entity;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * @author qingqu.huang
 *
 */
public class InsuranceCard {
	@XStreamAlias("CARDNO")
	private String cardno;
	@XStreamAlias("STATUS")
	private String status;
	@XStreamAlias("CARDVERSIONCODE")
	private String cardversioncode;
	@XStreamAlias("VALIDATEFLAG")
	private String validateflag;
	@XStreamAlias("COMCODE")
	private String comcode;
	@XStreamAlias("COMNAME")
	private String comname;
	@XStreamAlias("COMADDRESS")
	private String comaddress;
	@XStreamAlias("NOTPASSREASON")
	private String notpassreason;
	/**
	 * @return the cardno
	 */
	public String getCardno() {
		return cardno;
	}
	/**
	 * @param cardno the cardno to set
	 */
	public void setCardno(String cardno) {
		this.cardno = cardno;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * @return the cardversioncode
	 */
	public String getCardversioncode() {
		return cardversioncode;
	}
	/**
	 * @param cardversioncode the cardversioncode to set
	 */
	public void setCardversioncode(String cardversioncode) {
		this.cardversioncode = cardversioncode;
	}
	/**
	 * @return the validateflag
	 */
	public String getValidateflag() {
		return validateflag;
	}
	/**
	 * @param validateflag the validateflag to set
	 */
	public void setValidateflag(String validateflag) {
		this.validateflag = validateflag;
	}
	/**
	 * @return the comcode
	 */
	public String getComcode() {
		return comcode;
	}
	/**
	 * @param comcode the comcode to set
	 */
	public void setComcode(String comcode) {
		this.comcode = comcode;
	}
	/**
	 * @return the comname
	 */
	public String getComname() {
		return comname;
	}
	/**
	 * @param comname the comname to set
	 */
	public void setComname(String comname) {
		this.comname = comname;
	}
	/**
	 * @return the comaddress
	 */
	public String getComaddress() {
		return comaddress;
	}
	/**
	 * @param comaddress the comaddress to set
	 */
	public void setComaddress(String comaddress) {
		this.comaddress = comaddress;
	}
	/**
	 * @return the notpassreason
	 */
	public String getNotpassreason() {
		return notpassreason;
	}
	/**
	 * @param notpassreason the notpassreason to set
	 */
	public void setNotpassreason(String notpassreason) {
		this.notpassreason = notpassreason;
	}
	
}
