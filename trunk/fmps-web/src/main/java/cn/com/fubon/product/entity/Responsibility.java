/**
 * 
 */
package cn.com.fubon.product.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.jeecgframework.core.common.entity.IdEntity;

/**
 * 责任维护Entity
 * 
 * @author qingqu.huang
 *
 */
@Entity
@Table(name = "weixin_plan_responsibility")
@PrimaryKeyJoinColumn(name = "id")
public class Responsibility extends IdEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String productid; // 保险产品ID
	private String planid; // 计划ID
	private String liabilitycode; // 责任代码
	private String liability; // 保险责任
	private String amount; // 保额
	private String unit; // 单位
	private String kindid; // 险种ID

	/**
	 * @return the productid
	 */
	@Column(name = "productid", nullable = false, length = 32)
	public String getProductid() {
		return productid;
	}

	/**
	 * @param productid
	 *            the productid to set
	 */
	public void setProductid(String productid) {
		this.productid = productid;
	}

	/**
	 * @return the kindid
	 */
	@Column(name = "kindid", nullable = false, length = 32)
	public String getKindid() {
		return kindid;
	}

	/**
	 * @param kindid
	 *            the kindid to set
	 */
	public void setKindid(String kindid) {
		this.kindid = kindid;
	}

	/**
	 * @return the unit
	 */
	@Column(name = "unit", nullable = false, length = 20)
	public String getUnit() {
		return unit;
	}

	/**
	 * @param unit
	 *            the unit to set
	 */
	public void setUnit(String unit) {
		this.unit = unit;
	}

	/**
	 * @return the planid
	 */
	@Column(name = "planid", nullable = false, length = 32)
	public String getPlanid() {
		return planid;
	}

	/**
	 * @param planid
	 *            the planid to set
	 */
	public void setPlanid(String planid) {
		this.planid = planid;
	}

	/**
	 * @return the liabilitycode
	 */
	@Column(name = "liabilitycode", nullable = false, length = 20)
	public String getLiabilitycode() {
		return liabilitycode;
	}

	/**
	 * @param liabilitycode
	 *            the liabilitycode to set
	 */
	public void setLiabilitycode(String liabilitycode) {
		this.liabilitycode = liabilitycode;
	}

	/**
	 * @return the liability
	 */
	@Column(name = "liability", nullable = false, length = 100)
	public String getLiability() {
		return liability;
	}

	/**
	 * @param liability
	 *            the liability to set
	 */
	public void setLiability(String liability) {
		this.liability = liability;
	}

	/**
	 * @return the amount
	 */
	@Column(name = "amount", nullable = false, length = 10)
	public String getAmount() {
		return amount;
	}

	/**
	 * @param amount
	 *            the amount to set
	 */
	public void setAmount(String amount) {
		this.amount = amount;
	}

}
