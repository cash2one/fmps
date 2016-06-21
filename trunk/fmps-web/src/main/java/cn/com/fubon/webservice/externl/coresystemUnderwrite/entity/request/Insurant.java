package cn.com.fubon.webservice.externl.coresystemUnderwrite.entity.request;

import java.util.List;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 微店承保请求报文INSURANT部分
 * 
 * @author yaoming.zhang
 */
@XStreamAlias("INSURANT")
public class Insurant {
	
	@XStreamAlias("INSUREDNAME")
	private String insuredName;	//被保险人姓名
	
	@XStreamAlias("IDCODE")
	private String idCode;		//被保险人证件号码
	
	@XStreamAlias("IDTYPE")
	private String idType;		//被保险人证件类型
	
	@XStreamAlias("JOBUNIT")
	private String jobunit;		//学校	
	
	@XStreamAlias("DEPARTMENT")
	private String  department ;	//院系	
	
	@XStreamAlias("STUDENTNO")
	private String studentNo;	//学号
	
	@XStreamAlias("IDPERIOD")
	private String idperiod;	//被保险人证件类型
	
	@XStreamAlias("RELATION")
	private String relation;		//被保险人与投保人关系
	
	@XStreamAlias("OCCUPATIONCODE")
	private String occupationCode;		//被保险人证件类型
	
	@XStreamAlias("BIRTHDAY")
	private String birthday;	//被保险人出生日期
	
	@XStreamAlias("SEX")
	private String sex;		//被保险人性别
	
	@XStreamAlias("AGE")
	private String age;		//被保险人性别
	
	@XStreamAlias("TELEPHONE")
	private String telephone;		//被保险人性别
	
	@XStreamAlias("MOBILE")
	private String mobile;		//被保险人地址
	
	@XStreamAlias("EMAIL")
	private String email;		//被保险人邮编
	
	@XStreamAlias("ADDRESS")
	private String address;			//被保险人电话号码
	
	@XStreamAlias("ZIPCODE")
	private String zipCode;//被保险人职业类别
	
	@XStreamAlias("BEWAY")
	private String beway;		//被保险人手机好号码
	
	@XStreamAlias("BENEFICIARYLIST")
	private List<Beneficiary> beneficiaryList;
	
	@XStreamAlias("ADDRESSLIST")
	private List<Address> addressList;

	public String getInsuredName() {
		return insuredName;
	}

	public void setInsuredName(String insuredName) {
		this.insuredName = insuredName;
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
	
	public String getJobunit() {
		return jobunit;
	}

	public void setJobunit(String jobunit) {
		this.jobunit = jobunit;
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

	public String getOccupationCode() {
		return occupationCode;
	}

	public void setOccupationCode(String occupationCode) {
		this.occupationCode = occupationCode;
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

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getBeway() {
		return beway;
	}

	public void setBeway(String beway) {
		this.beway = beway;
	}

	public List<Beneficiary> getBeneficiaryList() {
		return beneficiaryList;
	}

	public void setBeneficiaryList(List<Beneficiary> beneficiaryList) {
		this.beneficiaryList = beneficiaryList;
	}

	public List<Address> getAddressList() {
		return addressList;
	}

	public void setAddressList(List<Address> addressList) {
		this.addressList = addressList;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getStudentNo() {
		return studentNo;
	}

	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
	}
	
}
