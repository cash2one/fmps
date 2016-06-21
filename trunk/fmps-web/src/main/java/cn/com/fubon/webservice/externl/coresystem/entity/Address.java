/**
 * 
 */
package cn.com.fubon.webservice.externl.coresystem.entity;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * @author qingqu.huang
 *
 */
@XStreamAlias("PROPERT_REPOSE_ADDRESS")
public class Address {
	@XStreamAlias("PROVINCECODE")
	private String provincecode;
	@XStreamAlias("CITYCODE")
	private String citycode;
	@XStreamAlias("COUNTYCODE")
	private String countycode;
	@XStreamAlias("INSUREDADDRESS")
	private String insuredaddress;
	@XStreamAlias("STRUCTURENAME")
	private String structurename;

	/**
	 * @return the provincecode
	 */
	public String getProvincecode() {
		return provincecode;
	}

	/**
	 * 
	 * 
	 * @param provincecode
	 *            the provincecode to set
	 */
	public void setProvincecode(String provincecode) {
		this.provincecode = provincecode;
	}

	/**
	 * @return the citycode
	 */
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
	 * @return the structurename
	 */
	public String getStructurename() {
		return structurename;
	}

	/**
	 * @param structurename
	 *            the structurename to set
	 */
	public void setStructurename(String structurename) {
		this.structurename = structurename;
	}

}
