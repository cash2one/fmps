/**
 * 
 */
package cn.com.fubon.fo.taitravel.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.jeecgframework.core.common.entity.IdEntity;

/**
 * (学生) (微信保单表)
 * 
 * @author guojunjie
 *
 */
@Entity
@Table(name = "weixin_stu_policy")
@PrimaryKeyJoinColumn(name = "id")
public class StuPolicy extends IdEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1557153269301860410L;
	private String area; // 区
	private String city; // 城市
	private Date createtime; // 创建时间
	private String detail; // 详细地址
	private String identifynumber; // 证件号码
	private String identifytype; // 证件类型
	private String name; // 学生客户姓名

	private String openid; // openid

	private String payorderno; // 支付订单号
	private String paystatus; // 支付状态
	private String period; // 保险期限

	private String phone; // 手机
	private String policyno; // 保单号
	private String premium; // 保费
	private String province; // 省份
	private String schemetype; // 方案类型

	private String school; // 学校

	@Column(name = "area")
	public String getArea() {
		return area;
	}

	@Column(name = "city")
	public String getCity() {
		return city;
	}

	/**
	 * @return the createtime
	 */
	@Column(name = "createtime", nullable = false, length = 255)
	public Date getCreatetime() {
		return createtime;
	}

	@Column(name = "detail")
	public String getDetail() {
		return detail;
	}

	/**
	 * @return the identifynumber
	 */
	@Column(name = "identifynumber", nullable = false, length = 60)
	public String getIdentifynumber() {
		return identifynumber;
	}

	/**
	 * @return the identifytype
	 */
	@Column(name = "identifytype", nullable = false, length = 10)
	public String getIdentifytype() {
		return identifytype;
	}

	/**
	 * @return the name
	 */
	@Column(name = "name", nullable = false, length = 20)
	public String getName() {
		return name;
	}

	/**
	 * @return the openid
	 */
	@Column(name = "openid", nullable = false, length = 100)
	public String getOpenid() {
		return openid;
	}

	@Column(name = "payorderno")
	public String getPayorderno() {
		return payorderno;
	}

	@Column(name = "paystatus")
	public String getPaystatus() {
		return paystatus;
	}

	@Column(name = "period")
	public String getPeriod() {
		return period;
	}

	/**
	 * @return the phone
	 */
	@Column(name = "phone", nullable = false, length = 20)
	public String getPhone() {
		return phone;
	}

	@Column(name = "policyno")
	public String getPolicyno() {
		return policyno;
	}

	@Column(name = "premium")
	public String getPremium() {
		return premium;
	}

	@Column(name = "province")
	public String getProvince() {
		return province;
	}

	@Column(name = "schemetype")
	public String getSchemetype() {
		return schemetype;
	}

	@Column(name = "school")
	public String getSchool() {
		return school;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @param createtime
	 *            the createtime to set
	 */
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	/**
	 * @param identifynumber
	 *            the identifynumber to set
	 */
	public void setIdentifynumber(String identifynumber) {
		this.identifynumber = identifynumber;
	}

	/**
	 * @param identifytype
	 *            the identifytype to set
	 */
	public void setIdentifytype(String identifytype) {
		this.identifytype = identifytype;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param openid
	 *            the openid to set
	 */
	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public void setPayorderno(String payorderno) {
		this.payorderno = payorderno;
	}

	public void setPaystatus(String paystatus) {
		this.paystatus = paystatus;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	/**
	 * @param phone
	 *            the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setPolicyno(String policyno) {
		this.policyno = policyno;
	}

	public void setPremium(String premium) {
		this.premium = premium;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public void setSchemetype(String schemetype) {
		this.schemetype = schemetype;
	}

	public void setSchool(String school) {
		this.school = school;
	}

}
