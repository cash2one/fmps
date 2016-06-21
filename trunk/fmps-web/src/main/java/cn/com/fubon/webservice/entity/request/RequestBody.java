package cn.com.fubon.webservice.entity.request;

import java.io.Serializable;

import com.thoughtworks.xstream.annotations.XStreamAlias;

//别名在XML转对象时需要
@XStreamAlias("TRANSACTION_BODY")
public class RequestBody implements Serializable{
	/**
	 * 服务端接口报文体属性
	 */
	@XStreamAlias("CLAIM_CASE_NO")
	private String claimCaseNo;
	
	@XStreamAlias("CLAIM_CASE_STATUS")
	private String claimCaseStatus;
	
	@XStreamAlias("CLAIM_CASE_HANDLE_WAY")
	private String claimCaseHandleWay;
	
	@XStreamAlias("CLAIM_CASE_FEE")
	private String claimCaseFee;
	
	@XStreamAlias("OPENID")
	private String openid;
	
	@XStreamAlias("CLAIM_END_DATE")
	private String claimEndDate;
	
	@XStreamAlias("CLAIM_END_TIME")
	private String claimEndTime;
	
	@XStreamAlias("INSURED_NAME")
	private String insuredName;
	
	@XStreamAlias("OPERATOR_NAME")
	private String operatorName;
	
	@XStreamAlias("OPERATOR_MOBILE")
	private String operatorMobile;

	public RequestBody(){
		
	}

	public String getClaimCaseNo() {
		return claimCaseNo;
	}

	public void setClaimCaseNo(String claimCaseNo) {
		this.claimCaseNo = claimCaseNo;
	}

	public String getClaimCaseStatus() {
		return claimCaseStatus;
	}

	public void setClaimCaseStatus(String claimCaseStatus) {
		this.claimCaseStatus = claimCaseStatus;
	}

	public String getClaimCaseHandleWay() {
		return claimCaseHandleWay;
	}

	public void setClaimCaseHandleWay(String claimCaseHandleWay) {
		this.claimCaseHandleWay = claimCaseHandleWay;
	}

	public String getClaimCaseFee() {
		return claimCaseFee;
	}

	public void setClaimCaseFee(String claimCaseFee) {
		this.claimCaseFee = claimCaseFee;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getClaimEndDate() {
		return claimEndDate;
	}

	public void setClaimEndDate(String claimEndDate) {
		this.claimEndDate = claimEndDate;
	}

	public String getClaimEndTime() {
		return claimEndTime;
	}

	public void setClaimEndTime(String claimEndTime) {
		this.claimEndTime = claimEndTime;
	}

	public String getInsuredName() {
		return insuredName;
	}

	public void setInsuredName(String insuredName) {
		this.insuredName = insuredName;
	}

	public String getOperatorName() {
		return operatorName;
	}

	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}

	public String getOperatorMobile() {
		return operatorMobile;
	}

	public void setOperatorMobile(String operatorMobile) {
		this.operatorMobile = operatorMobile;
	}
}
