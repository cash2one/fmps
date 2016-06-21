/**
 * 
 */
package cn.com.fubon.webservice.externl.coresystem.entity;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * @author qingqu.huang
 *
 */
public class Applicant {
	@XStreamAlias("INSUREDNAME")
	private String insuredname;
	@XStreamAlias("IDENTIFYTYPE")
	private String identifyType;
	@XStreamAlias("IDENTIFYNUMBER")
	private String identifyNumber;
	@XStreamAlias("PHONENUMBER")
	private String phoneNumber;
	@XStreamAlias("EMAIL")
	private String email;
	@XStreamAlias("INSUREDIDENTITY")
	private String insuredIdentity;
	@XStreamAlias("BIRTHDAY")
	private String birthday;	
	@XStreamAlias("AGE")
	private String age;	
	@XStreamAlias("SEX")
	private String sex;

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
	 * @return the identifyNumber
	 */
	public String getIdentifyNumber() {
		return identifyNumber;
	}

	/**
	 * @param identifyNumber
	 *            the identifyNumber to set
	 */
	public void setIdentifyNumber(String identifyNumber) {
		this.identifyNumber = identifyNumber;
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
	 * @return the insuredIdentity
	 */
	public String getInsuredIdentity() {
		return insuredIdentity;
	}

	/**
	 * @param insuredIdentity
	 *            the insuredIdentity to set
	 */
	public void setInsuredIdentity(String insuredIdentity) {
		this.insuredIdentity = insuredIdentity;
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

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}
}
