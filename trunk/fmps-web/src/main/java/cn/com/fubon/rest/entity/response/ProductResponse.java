/**
 * 
 */
package cn.com.fubon.rest.entity.response;

import java.util.List;

import cn.com.fubon.rest.entity.BaseResult;

/**
 * @author qingqu.huang
 *
 */
public class ProductResponse extends BaseResult {

	private List premiumList;
	private String productname;
	private String introduction;
	private String occupationLevels;
	private String imagehref;
	private String insuranceAge;
	private List plannameList;
	private String status;
	private String minpremium;
	private String maxpremium;
	private String type;
	// add by yaoming.zhang
	private String content;
	

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the minpremium
	 */
	public String getMinpremium() {
		return minpremium;
	}

	/**
	 * @param minpremium
	 *            the minpremium to set
	 */
	public void setMinpremium(String minpremium) {
		this.minpremium = minpremium;
	}

	/**
	 * @return the maxpremium
	 */
	public String getMaxpremium() {
		return maxpremium;
	}

	/**
	 * @param maxpremium
	 *            the maxpremium to set
	 */
	public void setMaxpremium(String maxpremium) {
		this.maxpremium = maxpremium;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the plannameList
	 */
	public List getPlannameList() {
		return plannameList;
	}

	/**
	 * @param plannameList
	 *            the plannameList to set
	 */
	public void setPlannameList(List plannameList) {
		this.plannameList = plannameList;
	}

	/**
	 * @return the premiumList
	 */
	public List getPremiumList() {
		return premiumList;
	}

	/**
	 * @return the productname
	 */
	public String getProductname() {
		return productname;
	}

	/**
	 * @param productname
	 *            the productname to set
	 */
	public void setProductname(String productname) {
		this.productname = productname;
	}

	/**
	 * @return the introduction
	 */
	public String getIntroduction() {
		return introduction;
	}

	/**
	 * @param introduction
	 *            the introduction to set
	 */
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	/**
	 * @return the occupationLevels
	 */
	public String getOccupationLevels() {
		return occupationLevels;
	}

	/**
	 * @param occupationLevels
	 *            the occupationLevels to set
	 */
	public void setOccupationLevels(String occupationLevels) {
		this.occupationLevels = occupationLevels;
	}

	/**
	 * @return the imagehref
	 */
	public String getImagehref() {
		return imagehref;
	}

	/**
	 * @param imagehref
	 *            the imagehref to set
	 */
	public void setImagehref(String imagehref) {
		this.imagehref = imagehref;
	}

	/**
	 * @return the insuranceAge
	 */
	public String getInsuranceAge() {
		return insuranceAge;
	}

	/**
	 * @param insuranceAge
	 *            the insuranceAge to set
	 */
	public void setInsuranceAge(String insuranceAge) {
		this.insuranceAge = insuranceAge;
	}

	/**
	 * @param premiumList
	 *            the premiumList to set
	 */
	public void setPremiumList(List premiumList) {
		this.premiumList = premiumList;
	}

	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
}
