package cn.com.fubon.webservice.externl.coresystemUnderwrite.entity.request;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 微店承保请求报文APPLICANT部分
 * 
 * @author yaoming.zhang
 */
@XStreamAlias("APPLICANT")
public class Applicant {
	
	@XStreamAlias("APPLINAME")
	private String appliName;		//投保人姓名
	
	@XStreamAlias("IDCODE")
	private String idCode;			//投保人证件号码
	
	@XStreamAlias("IDTYPE")
	private String idType;			//投保人证件类型
	
	@XStreamAlias("IDPERIOD")
	private String idperiod;		//投保人证件有效期
	
	@XStreamAlias("BIRTHDAY")
	private String birthday;		//投保人出生日期
	
	@XStreamAlias("SEX")
	private String sex;			//投保人性别
	
	@XStreamAlias("AGE")
	private String age;	//年龄
	
	@XStreamAlias("TELEPHONE")
	private String telephone;				//投保人联系电话
	
	@XStreamAlias("MOBILE")
	private String mobile;			//投保人手机
	
	@XStreamAlias("EMAIL")
	private String email;			//投保人邮箱
	
	@XStreamAlias("ADDRESS")
	private String address;	//投保人所在省
	
	@XStreamAlias("ZIPCODE")
	private String zipcode;		//投保人所在市

	public String getAppliName() {
		return appliName;
	}

	public void setAppliName(String appliName) {
		this.appliName = appliName;
	}

	public String getIdCode() {
		return idCode;
	}

	public void setIdCode(String idCode) {
		this.idCode = idCode;
	}

	public String getIdType() {
		return idType;
	}

	public void setIdType(String idType) {
		this.idType = idType;
	}

	public String getIdperiod() {
		return idperiod;
	}

	public void setIdperiod(String idperiod) {
		this.idperiod = idperiod;
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

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

}
