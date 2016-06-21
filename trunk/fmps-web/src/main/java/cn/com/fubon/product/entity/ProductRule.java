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
 * 产品规则Entity
 * 
 * @author qingqu.huang
 * @date 2015-05-08
 */
@Entity
@Table(name = "weixin_product_rule")
@PrimaryKeyJoinColumn(name = "id")
public class ProductRule extends IdEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String productid; // 产品ID
	private int maxage; // 投保最大年龄
	private int minage; // 投保最小年龄
	private int unit; // 最大份数
	private String rulename; // 规则名称
	private String ruletype; // 规则类型
	private String ruleclass; // 规则分类

	/**
	 * @return the rulename
	 */
	@Column(name = "rulename", nullable = false, length = 100)
	public String getRulename() {
		return rulename;
	}

	/**
	 * @param rulename
	 *            the rulename to set
	 */
	public void setRulename(String rulename) {
		this.rulename = rulename;
	}

	/**
	 * @return the ruletype
	 */
	@Column(name = "ruletype", nullable = false, length = 20)
	public String getRuletype() {
		return ruletype;
	}

	/**
	 * @param ruletype
	 *            the ruletype to set
	 */
	public void setRuletype(String ruletype) {
		this.ruletype = ruletype;
	}

	/**
	 * @return the ruleclass
	 */
	@Column(name = "ruleclass", nullable = false, length = 50)
	public String getRuleclass() {
		return ruleclass;
	}

	/**
	 * @param ruleclass
	 *            the ruleclass to set
	 */
	public void setRuleclass(String ruleclass) {
		this.ruleclass = ruleclass;
	}

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
	 * @return the maxage
	 */
	@Column(name = "maxage", nullable = false, length = 6)
	public int getMaxage() {
		return maxage;
	}

	/**
	 * @param maxage
	 *            the maxage to set
	 */
	public void setMaxage(int maxage) {
		this.maxage = maxage;
	}

	/**
	 * @return the minage
	 */
	@Column(name = "minage", nullable = false, length = 6)
	public int getMinage() {
		return minage;
	}

	/**
	 * @param minage
	 *            the minage to set
	 */
	public void setMinage(int minage) {
		this.minage = minage;
	}

	/**
	 * @return the unit
	 */
	@Column(name = "unit", nullable = false, length = 6)
	public int getUnit() {
		return unit;
	}

	/**
	 * @param unit
	 *            the unit to set
	 */
	public void setUnit(int unit) {
		this.unit = unit;
	}

}
