package cn.com.fubon.pay.entity;

import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.jeecgframework.core.common.entity.IdEntity;

/**
 * 微信线下订单表 weixin_offline_orderinfo
 * 
 * @author patrick.z 20141218
 *
 */

@Entity
@Table(name = "weixin_offline_orderinfo")
@PrimaryKeyJoinColumn(name = "id")
public class WeiXinOfflineOrderInfo extends IdEntity {

	// 支付码
	private String payCode;
	// 核心订单号
	private String coreOrderNo;
	// 订单时间
	@Temporal(TemporalType.TIMESTAMP)
	private Date createTime;
	// 订单状态 0未支付 1支付成功 2支付失败
	private int payStatus;
	// 微信支付订单号
	private String transactionId;
	// 订单类别 CX代表车险，FC代表非车险
	private String classCode;
	// 验证码状态
	/*
	 * 001：验证码不存在 002：验证码过期 003：验证码无效-人工置失败 004：已完成支付 005：验证码可用
	 */
	private String payCodeStatus;
	// 被保险人名称
	private String insuredName;
	// 总保费
	private double sumPremium;
	// 保单起保日期
	@Temporal(TemporalType.DATE)
	private Date policyStartDate;
	// 车牌号
	private String licenseNo;
	// 证件号码
	private String identifyNumber;
	// MD5支付码
	private String paycodemd5;
	
	private List<WeiXinOfflineOrderDetail> weiXinOfflineOrderDetails;

	/**
	 * @return the paycodemd5
	 */
	@Column(name = "paycode_md5")
	public String getPaycodemd5() {
		return paycodemd5;
	}

	/**
	 * @param paycodemd5
	 *            the paycodemd5 to set
	 */
	public void setPaycodemd5(String paycodemd5) {
		this.paycodemd5 = paycodemd5;
	}

	@Column(name = "payCode")
	public String getPayCode() {
		return payCode;
	}

	public void setPayCode(String payCode) {
		this.payCode = payCode;
	}

	@Column(name = "createTime")
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Column(name = "payStatus")
	public int getPayStatus() {
		return payStatus;
	}

	public void setPayStatus(int payStatus) {
		this.payStatus = payStatus;
	}

	@Column(name = "transactionId")
	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	@Column(name = "classCode")
	public String getClassCode() {
		return classCode;
	}

	public void setClassCode(String classCode) {
		this.classCode = classCode;
	}

	@Column(name = "insuredName")
	public String getInsuredName() {
		return insuredName;
	}

	public void setInsuredName(String insuredName) {
		this.insuredName = insuredName;
	}

	@Column(name = "sumPremium")
	public double getSumPremium() {
		return sumPremium;
	}

	public void setSumPremium(double sumPremium) {
		this.sumPremium = sumPremium;
	}

	@Column(name = "licenseNo")
	public String getLicenseNo() {
		return licenseNo;
	}

	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}

	@Column(name = "identifyNumber")
	public String getIdentifyNumber() {
		return identifyNumber;
	}

	public void setIdentifyNumber(String identifyNumber) {
		this.identifyNumber = identifyNumber;
	}

	@Column(name = "coreOrderNo")
	public String getCoreOrderNo() {
		return coreOrderNo;
	}

	public void setCoreOrderNo(String coreOrderNo) {
		this.coreOrderNo = coreOrderNo;
	}

	@Column(name = "payCodeStatus")
	public String getPayCodeStatus() {
		return payCodeStatus;
	}

	public void setPayCodeStatus(String payCodeStatus) {
		this.payCodeStatus = payCodeStatus;
	}

	@Column(name = "policyStartDate")
	public Date getPolicyStartDate() {
		return policyStartDate;
	}

	public void setPolicyStartDate(Date policyStartDate) {
		this.policyStartDate = policyStartDate;
	}
	
	@OneToMany(mappedBy = "orderInfo")
	public List<WeiXinOfflineOrderDetail> getWeiXinOfflineOrderDetails() {
		return weiXinOfflineOrderDetails;
	}

	public void setWeiXinOfflineOrderDetails(
			List<WeiXinOfflineOrderDetail> weiXinOfflineOrderDetails) {
		this.weiXinOfflineOrderDetails = weiXinOfflineOrderDetails;
	}

}
