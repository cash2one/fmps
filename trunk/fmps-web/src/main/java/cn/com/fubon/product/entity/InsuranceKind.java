/**
 * 
 */
package cn.com.fubon.product.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.jeecgframework.core.common.entity.IdEntity;

/**
 * 保险产品险种实体类
 * 
 * @author qingqu.huang
 *
 */
@Entity
@Table(name = "weixin_plan_insurancekind")
@PrimaryKeyJoinColumn(name = "id")
public class InsuranceKind extends IdEntity implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3110405972702414285L;
	private String productid; // 保险产品ID
	private String planid; // 保险产品计划ID
	private String kindname; // 保险产品险种名称
	private String kindcode; // 保险产品险种代码
	private String affiliatedId; // 保险产品对应条款ID

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
	 * @return the kindcode
	 */
	@Column(name = "kindcode", nullable = false, length = 10)
	public String getKindcode() {
		return kindcode;
	}

	/**
	 * @param kindcode
	 *            the kindcode to set
	 */
	public void setKindcode(String kindcode) {
		this.kindcode = kindcode;
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
	 * @return the kindname
	 */
	@Column(name = "kindname", nullable = false, length = 200)
	public String getKindname() {
		return kindname;
	}

	/**
	 * @param kindname
	 *            the kindname to set
	 */
	public void setKindname(String kindname) {
		this.kindname = kindname;
	}

	public String getAffiliatedId() {
		return affiliatedId;
	}

	public void setAffiliatedId(String affiliatedId) {
		this.affiliatedId = affiliatedId;
	}
	
}
