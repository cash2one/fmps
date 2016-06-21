/**
 * 
 */
package cn.com.fubon.fo.card.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.jeecgframework.core.common.entity.IdEntity;

/**
 * @author qingqu.huang
 *
 */
@Entity
@Table(name = "weixin_policy")
@PrimaryKeyJoinColumn(name = "id")
public class Policy extends IdEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ContractAddress addressId; // 标的地址ID
	private Customer applicant; // 投保人
	private Card card; // card
	private Date createtime; // 创建时间
	private Date enddate; // 保单终止时间
	private String insuredidentity; // 投被保人关系
	private List<Customer> insuredList; // 被保人
	private String isbeneficiary; // 是否法定受益人
	private String openid; // openid
	private String planid; // planid
	private String policyno; // 保单号
	private Date startdate; // 保单起始时间
	private String type; // 类型（1，投保单；2，保单）	
	private double premium; // 保单原保费
	private String orderno;
	private String status;
	private String productid;
	private String productname;
	private String planname;
	private String period;
	private Date paytime;
	private String operateCode;	//出单人员
	
	private String huodongId; 

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "addressId", nullable = true)
	public ContractAddress getAddressId() {
		return addressId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "applicant")
	public Customer getApplicant() {
		return applicant;
	}

	@Transient
	public Card getCard() {
		return card;
	}

	/**
	 * @return the createtime
	 */
	@Column(name = "createtime", nullable = false, length = 255)
	public Date getCreatetime() {
		return createtime;
	}

	/**
	 * @return the enddate
	 */
	@Column(name = "enddate", nullable = false, length = 255)
	public Date getEnddate() {
		return enddate;
	}

	@Column(name = "insuredidentity", nullable = false, length = 20)
	public String getInsuredidentity() {
		return insuredidentity;
	}

	@Transient
	public List<Customer> getInsuredList() {
		return insuredList;
	}

	/**
	 * @return the isbeneficiary
	 */
	@Column(name = "isbeneficiary", nullable = false, length = 5)
	public String getIsbeneficiary() {
		return isbeneficiary;
	}

	/**
	 * @return the openid
	 */
	@Column(name = "openid", nullable = false, length = 100)
	public String getOpenid() {
		return openid;
	}

	@Column(name = "planid", nullable = false, length = 32)
	public String getPlanid() {
		return planid;
	}

	@Column(name = "policyno", nullable = false, length = 20)
	public String getPolicyno() {
		return policyno;
	}

	/**
	 * @return the startdate
	 */
	@Column(name = "startdate", nullable = false, length = 255)
	public Date getStartdate() {
		return startdate;
	}

	/**
	 * @return the type
	 */
	@Column(name = "type", nullable = false, length = 5)
	public String getType() {
		return type;
	}

	public void setAddressId(ContractAddress addressId) {
		this.addressId = addressId;
	}

	public void setApplicant(Customer applicant) {
		this.applicant = applicant;
	}

	public void setCard(Card card) {
		this.card = card;
	}

	/**
	 * @param createtime
	 *            the createtime to set
	 */
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	/**
	 * @param enddate
	 *            the enddate to set
	 */
	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}

	public void setInsuredidentity(String insuredidentity) {
		this.insuredidentity = insuredidentity;
	}

	public void setInsuredList(List<Customer> insuredList) {
		this.insuredList = insuredList;
	}

	/**
	 * @param isbeneficiary
	 *            the isbeneficiary to set
	 */
	public void setIsbeneficiary(String isbeneficiary) {
		this.isbeneficiary = isbeneficiary;
	}

	/**
	 * @param openid
	 *            the openid to set
	 */
	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public void setPlanid(String planid) {
		this.planid = planid;
	}

	public void setPolicyno(String policyno) {
		this.policyno = policyno;
	}

	/**
	 * @param startdate
	 *            the startdate to set
	 */
	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	@Column(name = "premium")
	public double getPremium() {
		return premium;
	}

	public void setPremium(double premium) {
		this.premium = premium;
	}

	/**
	 * @return the orderno
	 */
	public String getOrderno() {
		return orderno;
	}

	/**
	 * @param orderno the orderno to set
	 */
	public void setOrderno(String orderno) {
		this.orderno = orderno;
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
	 * @return the productid
	 */
	public String getProductid() {
		return productid;
	}

	/**
	 * @param productid the productid to set
	 */
	public void setProductid(String productid) {
		this.productid = productid;
	}

	/**
	 * @return the productname
	 */
	public String getProductname() {
		return productname;
	}

	/**
	 * @param productname the productname to set
	 */
	public void setProductname(String productname) {
		this.productname = productname;
	}

	/**
	 * @return the planname
	 */
	public String getPlanname() {
		return planname;
	}

	/**
	 * @param planname the planname to set
	 */
	public void setPlanname(String planname) {
		this.planname = planname;
	}

	/**
	 * @return the period
	 */
	public String getPeriod() {
		return period;
	}

	/**
	 * @param period the period to set
	 */
	public void setPeriod(String period) {
		this.period = period;
	}

	/**
	 * @return the paytime
	 */
	public Date getPaytime() {
		return paytime;
	}

	/**
	 * @param paytime the paytime to set
	 */
	public void setPaytime(Date paytime) {
		this.paytime = paytime;
	}

	public String getOperateCode() {
		return operateCode;
	}

	public void setOperateCode(String operateCode) {
		this.operateCode = operateCode;
	}

	@Column(name = "huodongid")
	public String getHuodongId(){
		return huodongId;
	}

	public void setHuodongId(String huodongId){
		this.huodongId = huodongId;
	}

}
