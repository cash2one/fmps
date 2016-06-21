package cn.com.fubon.webservice.externl.coresystemUnderwrite.entity.request;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 微店承保请求报文BENEFICIARY部分
 * 
 * @author yaoming.zhang
 */
@XStreamAlias("BENEFICIARY")
public class Beneficiary {
	
	@XStreamAlias("BENEFNAME")
	private String benefName;	//受益人姓名
	
	@XStreamAlias("IDCODE")
	private String idCode;		//受益人证件号码
	
	@XStreamAlias("IDTYPE")
	private String idType;		//受益人证件类型
	
	@XStreamAlias("IDPERIOD")
	private String idperiod;	//受益人出生日期
	
	@XStreamAlias("RELATION")
	private String relation;	//受益人与被保险人的关系
	
	@XStreamAlias("BENEFITRATE")
	private String benefitrate;	//受益人与被保险人的关系
	
	@XStreamAlias("BIRTHDAY")
	private String birthday;	//受益人出生日期
	
	@XStreamAlias("SEX")
	private String sex;		//受益人性别
	
	@XStreamAlias("AGE")
	private String age;		//受益人住址
	
	@XStreamAlias("TELEPHONE")
	private String telephone;		//受益人邮编
	
	@XStreamAlias("MOBILE")
	private String mobile;		//受益人联系电话
	
	@XStreamAlias("EMAIL")
	private String email;		//受益人手机
	
	@XStreamAlias("ADDRESS")
	private String address;		//受益人邮箱
	
	@XStreamAlias("ZIPCODE")
	private String zipcode;		//受益人邮箱

	public String getBenefName() {
		return benefName;
	}

	public void setBenefName(String benefName) {
		this.benefName = benefName;
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

	public String getRelation() {
		return relation;
	}

	public void setRelation(String relation) {
		this.relation = relation;
	}

	public String getBenefitrate() {
		return benefitrate;
	}

	public void setBenefitrate(String benefitrate) {
		this.benefitrate = benefitrate;
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
