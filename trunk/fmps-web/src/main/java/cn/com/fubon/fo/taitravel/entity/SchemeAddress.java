/**
 * 
 */
package cn.com.fubon.fo.taitravel.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.jeecgframework.core.common.entity.IdEntity;

/**
 * 方案地址对应实体
 * 
 * @author guojunjie
 *
 */
@Entity
@Table(name = "weixin_scheme_address")
@PrimaryKeyJoinColumn(name = "id")
public class SchemeAddress extends IdEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3904427644732649273L;
	private String period; // 保险期限
	private String premiumsf; // 方案一保险费
	private String premiumss; // 方案二保险费
	private String premiumst; // 方案三保险费
	private String province; // 省份
	private String schemename; // 方案名称

	@Column(name = "period")
	public String getPeriod() {
		return period;
	}

	@Column(name = "premiumsf")
	public String getPremiumsf() {
		return premiumsf;
	}

	@Column(name = "premiumss")
	public String getPremiumss() {
		return premiumss;
	}

	@Column(name = "premiumst")
	public String getPremiumst() {
		return premiumst;
	}

	@Column(name = "province")
	public String getProvince() {
		return province;
	}

	@Column(name = "schemename")
	public String getSchemename() {
		return schemename;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public void setPremiumsf(String premiumsf) {
		this.premiumsf = premiumsf;
	}

	public void setPremiumss(String premiumss) {
		this.premiumss = premiumss;
	}

	public void setPremiumst(String premiumst) {
		this.premiumst = premiumst;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public void setSchemename(String schemename) {
		this.schemename = schemename;
	}

}
