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
 * 地区选择
 * 
 * @author guojunjie
 *
 */
@Entity
@Table(name = "weixin_address_code")
@PrimaryKeyJoinColumn(name = "id")
public class AddressCode extends IdEntity implements java.io.Serializable {
	private String city; // 市
	private String cityCode; // 市代码
	private String county; // 区县
	private String countyCode; // 区县代码
	private String province; // 省
	private String provinceCode; // 省份代码
	@Column(name = "city", nullable = false, length = 10)
	public String getCity() {
		return city;
	}
	@Column(name = "cityCode", nullable = false, length = 10)
	public String getCityCode() {
		return cityCode;
	}
	@Column(name = "county", nullable = false, length = 10)
	public String getCounty() {
		return county;
	}
	@Column(name = "countyCode", nullable = false, length = 10)
	public String getCountyCode() {
		return countyCode;
	}
	@Column(name = "province", nullable = false, length = 10)
	public String getProvince() {
		return province;
	}
	@Column(name = "provinceCode", nullable = false, length = 10)
	public String getProvinceCode() {
		return provinceCode;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}
	public void setCounty(String county) {
		this.county = county;
	}
	public void setCountyCode(String countyCode) {
		this.countyCode = countyCode;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}

	
	
	
}
