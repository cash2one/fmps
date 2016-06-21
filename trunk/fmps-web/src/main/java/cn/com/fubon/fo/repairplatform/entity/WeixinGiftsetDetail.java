package cn.com.fubon.fo.repairplatform.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.jeecgframework.core.common.entity.IdEntity;

@Entity
@Table(name = "weixin_giftset_detail")
@PrimaryKeyJoinColumn(name = "id")
public class WeixinGiftsetDetail extends IdEntity implements Serializable {

	private String appIdentifynumber;
	private String applicantname;
	private String areaName;


	private String deepcolor;

	private Date enddate;
	private Date etlInserttime;


	private String giftsetid;

	private String giftsetname;

	private String insIdentifynumber;

	private String insuredname;

	private String lightcolor;

	private String name;

	private String policyno;
	private String providerepairname;

	private String repairlogo;
	private Date scandate;
	private String scanrepairid;
	private String scanrepairname;
	private Date startdate;

	private String usedopenid;
	
	private String openid;
	
	private Integer batchid;
	private Integer cardtype;
	private Integer etlStatus;
	
	//双11活动id
	private String huodongid;
	

	@Column(name = "appIdentifynumber")
	public String getAppIdentifynumber() {
		return appIdentifynumber;
	}

	@Column(name = "applicantname")
	public String getApplicantname() {
		return applicantname;
	}

	@Column(name = "areaname")
	public String getAreaName() {
		return areaName;
	}

	
	@Column(name = "deepcolor")
	public String getDeepcolor() {
		return deepcolor;
	}

	@Column(name = "enddate")
	public Date getEnddate() {
		return enddate;
	}

	@Column(name = "etl_inserttime")
	public Date getEtlInserttime() {
		return etlInserttime;
	}

	

	@Column(name = "giftsetid")
	public String getGiftsetid() {
		return giftsetid;
	}

	@Column(name = "giftsetname")
	public String getGiftsetname() {
		return giftsetname;
	}

	@Column(name = "insIdentifynumber")
	public String getInsIdentifynumber() {
		return insIdentifynumber;
	}

	@Column(name = "insuredname")
	public String getInsuredname() {
		return insuredname;
	}

	@Column(name = "lightcolor")
	public String getLightcolor() {
		return lightcolor;
	}

	@Column(name = "name")
	public String getName() {
		return name;
	}

	@Column(name = "policyno")
	public String getPolicyno() {
		return policyno;
	}

	@Column(name = "providerepairname")
	public String getProviderepairname() {
		return providerepairname;
	}

	@Column(name = "repairlogo")
	public String getRepairlogo() {
		return repairlogo;
	}

	@Column(name = "scandate")
	public Date getScandate() {
		return scandate;
	}

	@Column(name = "scanrepairid")
	public String getScanrepairid() {
		return scanrepairid;
	}

	@Column(name = "scanrepairname")
	public String getScanrepairname() {
		return scanrepairname;
	}

	@Column(name = "startdate")
	public Date getStartdate() {
		return startdate;
	}

	@Column(name = "usedopenid")
	public String getUsedopenid() {
		return usedopenid;
	}

	public void setAppIdentifynumber(String appIdentifynumber) {
		this.appIdentifynumber = appIdentifynumber;
	}

	public void setApplicantname(String applicantname) {
		this.applicantname = applicantname;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	

	public void setDeepcolor(String deepcolor) {
		this.deepcolor = deepcolor;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}

	public void setEtlInserttime(Date etlInserttime) {
		this.etlInserttime = etlInserttime;
	}

	public void setGiftsetid(String giftsetid) {
		this.giftsetid = giftsetid;
	}

	public void setGiftsetname(String giftsetname) {
		this.giftsetname = giftsetname;
	}

	public void setInsIdentifynumber(String insIdentifynumber) {
		this.insIdentifynumber = insIdentifynumber;
	}

	public void setInsuredname(String insuredname) {
		this.insuredname = insuredname;
	}

	public void setLightcolor(String lightcolor) {
		this.lightcolor = lightcolor;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPolicyno(String policyno) {
		this.policyno = policyno;
	}

	public void setProviderepairname(String providerepairname) {
		this.providerepairname = providerepairname;
	}

	public void setRepairlogo(String repairlogo) {
		this.repairlogo = repairlogo;
	}

	public void setScandate(Date scandate) {
		this.scandate = scandate;
	}

	public void setScanrepairid(String scanrepairid) {
		this.scanrepairid = scanrepairid;
	}

	public void setScanrepairname(String scanrepairname) {
		this.scanrepairname = scanrepairname;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	public void setUsedopenid(String usedopenid) {
		this.usedopenid = usedopenid;
	}
	@Column(name = "openid")
	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}
	@Column(name = "batchid")
	public Integer getBatchid() {
		return batchid;
	}

	public void setBatchid(Integer batchid) {
		this.batchid = batchid;
	}
	@Column(name = "cardtype")
	public Integer getCardtype() {
		return cardtype;
	}

	public void setCardtype(Integer cardtype) {
		this.cardtype = cardtype;
	}
	@Column(name = "etl_status")
	public Integer getEtlStatus() {
		return etlStatus;
	}

	public void setEtlStatus(Integer etlStatus) {
		this.etlStatus = etlStatus;
	}
	@Column(name = "huodongid")
	public String getHuodongid() {
		return huodongid;
	}
	public void setHuodongid(String huodongid) {
		this.huodongid = huodongid;
	}
	
	

}
