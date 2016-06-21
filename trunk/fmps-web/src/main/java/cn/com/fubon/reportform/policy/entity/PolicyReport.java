package cn.com.fubon.reportform.policy.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="weixin_policy_report_view")
public class PolicyReport {

	private String policyNo; //保单号
	
	private String openid; //微信号
	
	private String nickname;   //昵称
	
	private String insuredName;   //被保人姓名
	
	private String identifyNumber;   //证件号码
	
	private String address; //地址
	
	private String phone;   //电话
	
	private String school; //学校
	
	private String premium;   //保费
	
	@Temporal(TemporalType.DATE)
	private String createTime;   //投保日期
	
	private String policyStatus;   //保单状态
	
	private String totalFee;   //支付金额
	
	@Id
	@Column(name="policyNo")
	public String getPolicyNo() {
		return policyNo;
	}
	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}
	
	@Column(name="openid")
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	
	@Column(name="nickname")
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	@Column(name="insuredName")
	public String getInsuredName() {
		return insuredName;
	}
	public void setInsuredName(String insuredName) {
		this.insuredName = insuredName;
	}
	
	@Column(name="identifyNumber")
	public String getIdentifyNumber() {
		return identifyNumber;
	}
	public void setIdentifyNumber(String identifyNumber) {
		this.identifyNumber = identifyNumber;
	}
	
	@Column(name="address")
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	@Column(name="phone")
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@Column(name="school")
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	
	@Column(name="premium")
	public String getPremium() {
		return premium;
	}
	public void setPremium(String premium) {
		this.premium = premium;
	}
	
	@Column(name="createTime")
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	
	@Column(name="policyStatus")
	public String getPolicyStatus() {
		return policyStatus;
	}
	public void setPolicyStatus(String policyStatus) {
		this.policyStatus = policyStatus;
	}
	
	@Column(name="totalFee")
	public String getTotalFee() {
		return totalFee;
	}
	public void setTotalFee(String totalFee) {
		this.totalFee = totalFee;
	}

}
