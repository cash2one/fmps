package cn.com.fubon.businessReminder.entity;

import java.io.Serializable;

import javax.persistence.Column;

/**
 * 新车上牌消息实体类
 * @author yaoming.zhang
 */
public class NewCarMsgEntity implements Serializable {

	private static final long serialVersionUID = -974392685175431049L;
	
	@Column(name = "id")  
	private String id;
	
	@Column(name = "openid")
	private String openid;
	
	@Column(name = "identifynumber")
	private String identifynumber;
	
	@Column(name = "insuredname")
	private String insuredname;
	
	@Column(name = "sex")
	private String sex;
	
	@Column(name = "msgtype")
	private Long msgtype;
	
	@Column(name = "sendstatus")
	private Long sendstatus;
	
	@Column(name = "brandname")
	private String brandname;
	
	@Column(name = "engineno")
	private String engineno;
	
	@Column(name = "frameno")
	private String frameno;
	
	@Column(name = "policyno")
	private String policyno;
	
	@Column(name = "licenseno")
	private String licenseno;
	
	@Column(name = "nextsendtime")
	private String nextsendtime;
	
	public NewCarMsgEntity() {
		super();
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public String getIdentifynumber() {
		return identifynumber;
	}
	public void setIdentifynumber(String identifynumber) {
		this.identifynumber = identifynumber;
	}
	public String getInsuredname() {
		return insuredname;
	}
	public void setInsuredname(String insuredname) {
		this.insuredname = insuredname;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Long getMsgtype() {
		return msgtype;
	}
	public void setMsgtype(Long msgtype) {
		this.msgtype = msgtype;
	}
	public Long getSendstatus() {
		return sendstatus;
	}
	public void setSendstatus(Long sendstatus) {
		this.sendstatus = sendstatus;
	}
	public String getBrandname() {
		return brandname;
	}
	public void setBrandname(String brandname) {
		this.brandname = brandname;
	}
	public String getEngineno() {
		return engineno;
	}
	public void setEngineno(String engineno) {
		this.engineno = engineno;
	}
	public String getFrameno() {
		return frameno;
	}
	public void setFrameno(String frameno) {
		this.frameno = frameno;
	}
	public String getPolicyno() {
		return policyno;
	}
	public void setPolicyno(String policyno) {
		this.policyno = policyno;
	}
	public String getLicenseno() {
		return licenseno;
	}
	public void setLicenseno(String licenseno) {
		this.licenseno = licenseno;
	}
	public String getNextsendtime() {
		return nextsendtime;
	}
	public void setNextsendtime(String nextsendtime) {
		this.nextsendtime = nextsendtime;
	}
}
