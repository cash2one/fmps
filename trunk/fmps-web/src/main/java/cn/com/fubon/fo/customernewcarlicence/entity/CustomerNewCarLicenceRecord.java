package cn.com.fubon.fo.customernewcarlicence.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.jeecgframework.core.common.entity.IdEntity;

import weixin.guanjia.account.entity.WeixinAccountEntity;


@Entity
@Table(name="weixin_newcar_licenseno")
@PrimaryKeyJoinColumn(name = "id")
public class CustomerNewCarLicenceRecord extends IdEntity implements Serializable{


	private String customerCode;					//厂牌信息
	private String brandname;					//厂牌信息
	private String frameno;						//车架号
	private String licenseno;					//车牌
	private Date createTime;				    //消息创建时间
	private String status;				     	//状态 1 成功  2 失败
	private String applicationNo;			 	//核心系统批单号
	private String identifynumber;				//证件号码
	private String customercname;			 	//客户姓名
	
	
	
	
	
	
	@Column(name = "brandname")
	public String getBrandname() {
		return brandname;
	}
	public void setBrandname(String brandname) {
		this.brandname = brandname;
	}
	@Column(name = "frameno")
	public String getFrameno() {
		return frameno;
	}
	public void setFrameno(String frameno) {
		this.frameno = frameno;
	}
	@Column(name = "licenseno")
	public String getLicenseno() {
		return licenseno;
	}
	public void setLicenseno(String licenseno) {
		this.licenseno = licenseno;
	}
	@Column(name = "createTime")
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	@Column(name = "status")
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Column(name = "customerCode")
	public String getCustomerCode() {
		return customerCode;
	}
	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}
	@Column(name = "applicationNo")
	public String getApplicationNo() {
		return applicationNo;
	}
	public void setApplicationNo(String applicationNo) {
		this.applicationNo = applicationNo;
	}
	@Column(name = "identifynumber")
	public String getIdentifynumber() {
		return identifynumber;
	}
	public void setIdentifynumber(String identifynumber) {
		this.identifynumber = identifynumber;
	}
	@Column(name = "customercname")
	public String getCustomercname() {
		return customercname;
	}
	public void setCustomercname(String customercname) {
		this.customercname = customercname;
	}

	
}
