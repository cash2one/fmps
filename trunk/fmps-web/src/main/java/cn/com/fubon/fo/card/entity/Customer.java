/**
 * 
 */
package cn.com.fubon.fo.card.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.jeecgframework.core.common.entity.IdEntity;

/**
 * 投保人实体类
 * 
 * @author qingqu.huang
 *
 */
@Entity
@Table(name = "weixin_customer")
@PrimaryKeyJoinColumn(name = "id")
public class Customer extends IdEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name; // 客户姓名
	private String identifytype; // 证件类型
	private String identifynumber; // 证件号码
	private String gender; // 性别
	private Date birthday; // 出生日期
	private String phone; // 手机
	private String address; // 联系地址
	private String email; // 邮件
	private String school; //学校
	
	private String department ;	//院系
	private String studentNo;	//学号	
	
	private String occupationgrade;	//职业类别（1~6）
	private String occupationcode;	//职业代码
	private String occupationname;	//职业类别中文名称
	
	private String carRelation;	//与车主关系代码
	private String carRelationname;	//与车主关系名称
	private String carownername;	//车主名称
	private String licenseno;	//车牌号
	
	
	/**
	 * @return the name
	 */
	@Column(name = "name", nullable = false, length = 20)
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the identifytype
	 */
	@Column(name = "identifytype", nullable = false, length = 10)
	public String getIdentifytype() {
		return identifytype;
	}

	/**
	 * @param identifytype
	 *            the identifytype to set
	 */
	public void setIdentifytype(String identifytype) {
		this.identifytype = identifytype;
	}

	/**
	 * @return the identifynumber
	 */
	@Column(name = "identifynumber", nullable = false, length = 60)
	public String getIdentifynumber() {
		return identifynumber;
	}

	/**
	 * @param identifynumber
	 *            the identifynumber to set
	 */
	public void setIdentifynumber(String identifynumber) {
		this.identifynumber = identifynumber;
	}

	/**
	 * @return the gender
	 */
	@Column(name = "gender", nullable = false, length = 5)
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender
	 *            the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * @return the birthday
	 */
	@Column(name = "birthday", nullable = false, length = 255)
	public Date getBirthday() {
		return birthday;
	}

	/**
	 * @param birthday
	 *            the birthday to set
	 */
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	/**
	 * @return the phone
	 */
	@Column(name = "phone", nullable = false, length = 20)
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone
	 *            the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @return the address
	 */
	@Column(name = "address", nullable = false, length = 120)
	public String getAddress() {
		return address;
	}

	/**
	 * @param address
	 *            the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the email
	 */
	@Column(name = "email", nullable = false, length = 100)
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
	 * @return the school
	 */
	public String getSchool() {
		return school;
	}

	/**
	 * @param school the school to set
	 */
	public void setSchool(String school) {
		this.school = school;
	}
	
	@Transient
	public String getOccupationgrade() {
		return occupationgrade;
	}
	public void setOccupationgrade(String occupationgrade) {
		this.occupationgrade = occupationgrade;
	}
	@Transient
	public String getOccupationcode() {
		return occupationcode;
	}
	public void setOccupationcode(String occupationcode) {
		this.occupationcode = occupationcode;
	}
	@Transient
	public String getOccupationname() {
		return occupationname;
	}
	public void setOccupationname(String occupationname) {
		this.occupationname = occupationname;
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
