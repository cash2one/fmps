package cn.com.fubon.fo.gasolinegift.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.jeecgframework.core.common.entity.IdEntity;

@Entity
@Table(name = "weixin_oilcard_organization")
@PrimaryKeyJoinColumn(name = "id")
public class OilcardOrganization extends IdEntity implements Serializable  { 
	
	private Date updateTime; // 新增时间 
	private String orgCode; // 机构编码
	private String orgName; // 机构名称
	
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public String getOrgCode() {
		return orgCode;
	}
	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	
}
