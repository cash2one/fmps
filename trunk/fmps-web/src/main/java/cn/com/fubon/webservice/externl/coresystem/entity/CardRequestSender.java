package cn.com.fubon.webservice.externl.coresystem.entity;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 卡单激活requestHeader封装类
 * 
 * @author qingqu.huang
 *
 */
public class CardRequestSender {

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

	public CardRequestSender() {
		transType = "request";
		simulation = "0";
	}

	public String getTransType() {
		return transType;
	}

	public void setTransType(String transType) {
		this.transType = transType;
	}

	public String getTransCode() {
		return transCode;
	}

	public void setTransCode(String transCode) {
		this.transCode = transCode;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSvcSeqNo() {
		return svcSeqNo;
	}

	public void setSvcSeqNo(String svcSeqNo) {
		this.svcSeqNo = svcSeqNo;
	}

	public String getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getUserIp() {
		return userIp;
	}

	public void setUserIp(String userIp) {
		this.userIp = userIp;
	}

	public String getSimulation() {
		return simulation;
	}

	public void setSimulation(String simulation) {
		this.simulation = simulation;
	}
}
