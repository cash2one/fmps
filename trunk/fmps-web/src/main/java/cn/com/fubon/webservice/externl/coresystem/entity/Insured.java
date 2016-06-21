/**
 * 
 */
package cn.com.fubon.webservice.externl.coresystem.entity;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * @author qingqu.huang
 *
 */
@XStreamAlias("INSURED")
public class Insured {
	@XStreamAlias("INSUREDNAME")
	private String insuredname;
	@XStreamAlias("IDENTIFYTYPE")
	private String identifyType;
	@XStreamAlias("IDENTIFYNUMBER")
	private String identifyNumber;
	@XStreamAlias("OCCUPATIONCODE")
	private String occupationcode;
	@XStreamAlias("PHONENUMBER")
	private String phoneNumber;
	@XStreamAlias("EMAIL")
	private String email;
	@XStreamAlias("OCCUPATIONLEVEL")
	private String occupationlevel;
	@XStreamAlias("BIRTHDAY")
	private String birthday;
	@XStreamAlias("SEX")
	private String sex;
	@XStreamAlias("AGE")
	private String age;	
	@XStreamAlias("CAROWNERS")
	private String carRelation;
	@XStreamAlias("CAROWNERSNAME")
	private String carRelationname;
	@XStreamAlias("CAROWNERNAME")
	private String carownername;
	@XStreamAlias("LICENSENO")
	private String licenseno;
	
	
	
	/**
	 * @return the identifyNumber
	 */
	public String getIdentifyNumber() {
		return identifyNumber;
	}

	/**
	 * @param identifyNumber the identifyNumber to set
	 */
	public void setIdentifyNumber(String identifyNumber) {
		this.identifyNumber = identifyNumber;
	}

	/**
	 * @return the insuredname
	 */
	public String getInsuredname() {
		return insuredname;
	}

	/**
	 * @param insuredname
	 *            the insuredname to set
	 */
	public void setInsuredname(String insuredname) {
		this.insuredname = insuredname;
	}

	/**
	 * @return the identifyType
	 */
	public String getIdentifyType() {
		return identifyType;
	}

	/**
	 * @param identifyType
	 *            the identifyType to set
	 */
	public void setIdentifyType(String identifyType) {
		this.identifyType = identifyType;
	}

	/**
	 * @return the occupationcode
	 */
	public String getOccupationcode() {
		return occupationcode;
	}

	/**
	 * @param occupationcode
	 *            the occupationcode to set
	 */
	public void setOccupationcode(String occupationcode) {
		this.occupationcode = occupationcode;
	}

	/**
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * @param phoneNumber
	 *            the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the occupationlevel
	 */
	public String getOccupationlevel() {
		return occupationlevel;
	}

	/**
	 * @param occupationlevel
	 *            the occupationlevel to set
	 */
	public void setOccupationlevel(String occupationlevel) {
		this.occupationlevel = occupationlevel;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getCarRelation() {
		return carRelation;
	}

	public void setCarRelation(String carRelation) {
		this.carRelation = carRelation;
	}

	public String getCarRelationname() {
		return carRelationname;
	}

	public void setCarRelationname(String carRelationname) {
		this.carRelationname = carRelationname;
	}

	public String getCarownername() {
		return carownername;
	}

	public void setCarownername(String carownername) {
		this.carownername = carownername;
	}

	public String getLicenseno() {
		return licenseno;
	}

	public void setLicenseno(String licenseno) {
		this.licenseno = licenseno;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	
}
