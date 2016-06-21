/**
 * 
 */
package cn.com.fubon.product.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.jeecgframework.core.common.entity.IdEntity;

/**
 * @author qingqu.huang
 *
 */
@Entity
@Table(name = "weixin_plan")
@PrimaryKeyJoinColumn(name = "id")
public class Plan extends IdEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int serialno; // 计划序号
	private String planname; // 计划名称
	private String productid; // 产品ID
	private String coreproductcode; // 核心产品代码
	private int period; // 期限
	private String periodtype; // 期限类型
	private BigDecimal premium; // 保费
	private Date createtime; // 创建时间
	private String status; // 状态

	/**
	 * @return the serialno
	 */
	@Column(name = "serialno", nullable = false, length = 6)
	public int getSerialno() {
		return serialno;
	}

	/**
	 * @param serialno
	 *            the serialno to set
	 */
	public void setSerialno(int serialno) {
		this.serialno = serialno;
	}

	/**
	 * @return the planname
	 */
	@Column(name = "planname", nullable = false, length = 32)
	public String getPlanname() {
		return planname;
	}

	/**
	 * @param planname
	 *            the planname to set
	 */
	public void setPlanname(String planname) {
		this.planname = planname;
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
	 * @return the coreproductcode
	 */
	@Column(name = "coreproductcode", nullable = false, length = 20)
	public String getCoreproductcode() {
		return coreproductcode;
	}

	/**
	 * @param coreproductcode
	 *            the coreproductcode to set
	 */
	public void setCoreproductcode(String coreproductcode) {
		this.coreproductcode = coreproductcode;
	}

	/**
	 * @return the period
	 */
	@Column(name = "period", nullable = false, length = 6)
	public int getPeriod() {
		return period;
	}

	/**
	 * @param period
	 *            the period to set
	 */
	public void setPeriod(int period) {
		this.period = period;
	}

	/**
	 * @return the periodtype
	 */
	@Column(name = "periodtype", nullable = false, length = 5)
	public String getPeriodtype() {
		return periodtype;
	}

	/**
	 * @param periodtype
	 *            the periodtype to set
	 */
	public void setPeriodtype(String periodtype) {
		this.periodtype = periodtype;
	}

	/**
	 * @return the premium
	 */
	@Column(name = "premium", nullable = false, length = 6)
	public BigDecimal  getPremium() {
		return premium;
	}

	/**
	 * @param premium
	 *            the premium to set
	 */
	public void setPremium(BigDecimal  premium) {
		this.premium = premium;
	}

	/**
	 * @return the createtime
	 */
	@Column(name = "createtime", nullable = false, length = 255)
	public Date getCreatetime() {
		return createtime;
	}

	/**
	 * @param createtime
	 *            the createtime to set
	 */
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	@Column(name = "status", nullable = false, length = 5)
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
