package cn.com.fubon.mailsending.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.jeecgframework.core.common.entity.IdEntity;

/**
 * 邮箱用户信息表
 * 
 * @author yaoming.zhang
 * @date 2015-12-21
 */
@Entity
@Table(name="weixin_email_userinfo")
public class EmailUserinfoEntity extends IdEntity{
	
	private static final long serialVersionUID = 9181412501962760029L;
	
//	private String id;
	
	private String name;
	
	private String identifynumber;
	
	private String sex;
	
	private String email;
	
	@Temporal(TemporalType.DATE)
	private Date sendtime;
	
	private String sendstatus;
	
	private String insuranceno;
	
	private String importBatchId;
	
	@Temporal(TemporalType.DATE)
	private Date importTime;
	
	private String importOperator;
	
	private String operatelogId;
	
	private String huodongid;

//	@Column(name="id")
//	public String getId() {
//		return id;
//	}
//	public void setId(String id) {
//		this.id = id;
//	}

	@Column(name="name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Column(name="identifynumber")
	public String getIdentifynumber() {
		return identifynumber;
	}
	public void setIdentifynumber(String identifynumber) {
		this.identifynumber = identifynumber;
	}

	@Column(name="sex")
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}

	@Column(name="email")
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name="sendtime")
	public Date getSendtime() {
		return sendtime;
	}
	public void setSendtime(Date sendtime) {
		this.sendtime = sendtime;
	}

	@Column(name="sendstatus")
	public String getSendstatus() {
		return sendstatus;
	}
	public void setSendstatus(String sendstatus) {
		this.sendstatus = sendstatus;
	}

	@Column(name="insuranceno")
	public String getInsuranceno() {
		return insuranceno;
	}
	public void setInsuranceno(String insuranceno) {
		this.insuranceno = insuranceno;
	}

	@Column(name="importBatchId")
	public String getImportBatchId() {
		return importBatchId;
	}
	public void setImportBatchId(String importBatchId) {
		this.importBatchId = importBatchId;
	}

	@Column(name="importTime")
	public Date getImportTime() {
		return importTime;
	}
	public void setImportTime(Date importTime) {
		this.importTime = importTime;
	}

	@Column(name="importOperator")
	public String getImportOperator() {
		return importOperator;
	}
	public void setImportOperator(String importOperator) {
		this.importOperator = importOperator;
	}

	@Column(name="operatelogId")
	public String getOperatelogId() {
		return operatelogId;
	}
	public void setOperatelogId(String operatelogId) {
		this.operatelogId = operatelogId;
	}

	@Column(name="huodongid")
	public String getHuodongid() {
		return huodongid;
	}
	public void setHuodongid(String huodongid) {
		this.huodongid = huodongid;
	}
	
}
