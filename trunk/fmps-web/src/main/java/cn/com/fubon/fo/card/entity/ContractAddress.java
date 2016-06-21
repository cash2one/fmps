/**
 * 
 */
package cn.com.fubon.fo.card.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.jeecgframework.core.common.entity.IdEntity;

/**
 * 标的地址实体类
 * 
 * @author qingqu.huang
 *
 */
@Entity
@Table(name = "weixin_policy_contract_address")
@PrimaryKeyJoinColumn(name = "id")
public class ContractAddress extends IdEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String policyno; // 保单编号
	private String provincecode; // 省编码
	private String citycode; // 市编码
	private String countycode; // 区县编码
	private String insuredaddress; // 标的所在详细地址
	private String orderno;

	/**
	 * @return the policyno
	 */
	@Column(name = "policyno", nullable = false, length = 20)
	public String getPolicyno() {
		return policyno;
	}

	/**
	 * @param policyno
	 *            the policyno to set
	 */
	public void setPolicyno(String policyno) {
		this.policyno = policyno;
	}

	 

	public String getProvincecode() {
		return provincecode;
	}

	public void setProvincecode(String provincecode) {
		this.provincecode = provincecode;
	}

	/**
	 * @return the citycode
	 */
	@Column(name = "citycode", nullable = false, length = 10)
	public String getCitycode() {
		return citycode;
	}

	/**
	 * @param citycode
	 *            the citycode to set
	 */
	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}

	/**
	 * @return the countycode
	 */
	@Column(name = "countycode", nullable = false, length = 10)
	public String getCountycode() {
		return countycode;
	}

	/**
	 * @param countycode
	 *            the countycode to set
	 */
	public void setCountycode(String countycode) {
		this.countycode = countycode;
	}

	/**
	 * @return the insuredaddress
	 */
	@Column(name = "insuredaddress", nullable = false, length = 100)
	public String getInsuredaddress() {
		return insuredaddress;
	}

	/**
	 * @param insuredaddress
	 *            the insuredaddress to set
	 */
	public void setInsuredaddress(String insuredaddress) {
		this.insuredaddress = insuredaddress;
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
