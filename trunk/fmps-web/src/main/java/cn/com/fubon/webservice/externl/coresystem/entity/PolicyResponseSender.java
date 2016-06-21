/**
 * 
 */
package cn.com.fubon.webservice.externl.coresystem.entity;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 投保响应报文header
 * 
 * @author qingqu.huang
 *
 */
public class PolicyResponseSender {

	@XStreamAlias("TRANSTYPE")
	private String transType;
	@XStreamAlias("TRANSCODE")
	private String transCode;
	@XStreamAlias("USER")
	private String user;
	@XStreamAlias("PASSWORD")
	private String password;
	@XStreamAlias("SVCSEQNO")
	private String svcSeqNo;
	@XStreamAlias("RESPONSE_CODE")
	private String responseCode;
	@XStreamAlias("ERROR_MESSAGE")
	private String errorMessage;
	@XStreamAlias("USERIP")
	private String userIp;
	@XStreamAlias("SIMULATION")
	private String simulation;
	/**
	 * @return the transType
	 */
	public String getTransType() {
		return transType;
	}
	/**
	 * @param transType the transType to set
	 */
	public void setTransType(String transType) {
		this.transType = transType;
	}
	/**
	 * @return the transCode
	 */
	public String getTransCode() {
		return transCode;
	}
	/**
	 * @param transCode the transCode to set
	 */
	public void setTransCode(String transCode) {
		this.transCode = transCode;
	}
	/**
	 * @return the user
	 */
	public String getUser() {
		return user;
	}
	/**
	 * @param user the user to set
	 */
	public void setUser(String user) {
		this.user = user;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the svcSeqNo
	 */
	public String getSvcSeqNo() {
		return svcSeqNo;
	}
	/**
	 * @param svcSeqNo the svcSeqNo to set
	 */
	public void setSvcSeqNo(String svcSeqNo) {
		this.svcSeqNo = svcSeqNo;
	}
	/**
	 * @return the responseCode
	 */
	public String getResponseCode() {
		return responseCode;
	}
	/**
	 * @param responseCode the responseCode to set
	 */
	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}
	/**
	 * @return the errorMessage
	 */
	public String getErrorMessage() {
		return errorMessage;
	}
	/**
	 * @param errorMessage the errorMessage to set
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	/**
	 * @return the userIp
	 */
	public String getUserIp() {
		return userIp;
	}
	/**
	 * @param userIp the userIp to set
	 */
	public void setUserIp(String userIp) {
		this.userIp = userIp;
	}
	/**
	 * @return the simulation
	 */
	public String getSimulation() {
		return simulation;
	}
	/**
	 * @param simulation the simulation to set
	 */
	public void setSimulation(String simulation) {
		this.simulation = simulation;
	}
}
