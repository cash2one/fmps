/**
 * 
 */
package cn.com.fubon.fo.card.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.jeecgframework.core.common.entity.IdEntity;

/**
 * 被保人实体
 * 
 * @author qingqu.huang
 *
 */
@Entity
@Table(name = "weixin_policy_insured_identity")
@PrimaryKeyJoinColumn(name = "id")
public class PolicyInsured extends IdEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Customer customer;// 投保人
	private String identity; // 身份
	private String policyno; // 保单编号
	private String occupationgrade; // 职业类别（1~6）
	private String occupationcode; // 职业代码
	private String occupationname; // 职业类别中文名称
	private String orderno;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customerid")
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * @return the identity
	 */
	@Column(name = "identity", nullable = false, length = 3)
	public String getIdentity() {
		return identity;
	}

	/**
	 * @return the policyno
	 */
	@Column(name = "policyno", nullable = false, length = 20)
	public String getPolicyno() {
		return policyno;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	/**
	 * @param identity
	 *            the identity to set
	 */
	public void setIdentity(String identity) {
		this.identity = identity;
	}

	/**
	 * @param policyno
	 *            the policyno to set
	 */
	public void setPolicyno(String policyno) {
		this.policyno = policyno;
	}

	@Column(name = "occupationgrade", length = 3)
	public String getOccupationgrade() {
		return occupationgrade;
	}

	public void setOccupationgrade(String occupationgrade) {
		this.occupationgrade = occupationgrade;
	}

	@Column(name = "occupationcode", length = 10)
	public String getOccupationcode() {
		return occupationcode;
	}

	public void setOccupationcode(String occupationcode) {
		this.occupationcode = occupationcode;
	}

	@Column(name = "occupationname", length = 100)
	public String getOccupationname() {
		return occupationname;
	}

	public void setOccupationname(String occupationname) {
		this.occupationname = occupationname;
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

}
