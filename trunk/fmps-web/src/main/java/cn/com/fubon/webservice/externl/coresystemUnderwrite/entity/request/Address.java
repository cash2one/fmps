package cn.com.fubon.webservice.externl.coresystemUnderwrite.entity.request;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 微店承保请求报文ADDRESS部分
 * 
 * @author yaoming.zhang
 */
@XStreamAlias("ADDRESS")
public class Address {
	
	@XStreamAlias("ADDRESSCODE")
	private String addressCode;
	
	@XStreamAlias("ADDRESSNAME")
	private String addressName;
	
	@XStreamAlias("PROVINCECODE")
	private String provinceCode;
	
	@XStreamAlias("PROVINCENAME")
	private String provinceName;
	
	@XStreamAlias("CITYCODE")
	private String cityCode;
	
	@XStreamAlias("CITYNAME")
	private String cityName;
	
	@XStreamAlias("DISTRICTCODE")
	private String districtCode;
	
	@XStreamAlias("DISTRICTNAME")
	private String districtName;
	
	@XStreamAlias("STRUCTURECODE")
	private String structureCode;
	
	@XStreamAlias("STRUCTURENAME")
	private String structureName;

	public String getAddressCode() {
		return addressCode;
	}

	public void setAddressCode(String addressCode) {
		this.addressCode = addressCode;
	}

	public String getAddressName() {
		return addressName;
	}

	public void setAddressName(String addressName) {
		this.addressName = addressName;
	}

	public String getProvinceCode() {
		return provinceCode;
	}

	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}

	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getDistrictCode() {
		return districtCode;
	}

	public void setDistrictCode(String districtCode) {
		this.districtCode = districtCode;
	}

	public String getDistrictName() {
		return districtName;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

	public String getStructureCode() {
		return structureCode;
	}

	public void setStructureCode(String structureCode) {
		this.structureCode = structureCode;
	}

	public String getStructureName() {
		return structureName;
	}

	public void setStructureName(String structureName) {
		this.structureName = structureName;
	}

}
