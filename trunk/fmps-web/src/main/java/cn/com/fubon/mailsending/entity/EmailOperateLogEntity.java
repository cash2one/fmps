package cn.com.fubon.mailsending.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.jeecgframework.core.common.entity.IdEntity;


/**
 * 邮箱操作日志表
 * 
 * @author yaoming.zhang
 * @date 2015-12-23
 */
@Entity
@Table(name = "weixin_email_operatelog")
public class EmailOperateLogEntity extends IdEntity implements java.io.Serializable {
	
	private static final long serialVersionUID = -8498136124293788239L;
	
	private String operatelogId;
	
	@Temporal(TemporalType.DATE)
	private Date operateTime;
	
	private String broswer;	//用户浏览器类型
	
	private String operateType;	//操作动作
	
	private String logContent;
	
	private String importBatchId; //导入动作，同时记录导入批次号
	
	private String huodongid; //活动id
	
	private String operater;
	
	private String ipAddr;
	
	@Column(name = "operatelogId")
	public String getOperatelogId() {
		return operatelogId;
	}
	public void setOperatelogId(String operatelogId) {
		this.operatelogId = operatelogId;
	}
	
	@Column(name = "operateTime")
	public Date getOperateTime() {
		return operateTime;
	}
	public void setOperateTime(Date operateTime) {
		this.operateTime = operateTime;
	}
	
	@Column(name = "broswer")
	public String getBroswer() {
		return broswer;
	}
	public void setBroswer(String broswer) {
		this.broswer = broswer;
	}
	
	@Column(name = "operateType")
	public String getOperateType() {
		return operateType;
	}
	public void setOperateType(String operateType) {
		this.operateType = operateType;
	}
	
	@Column(name = "logContent")
	public String getLogContent() {
		return logContent;
	}
	public void setLogContent(String logContent) {
		this.logContent = logContent;
	}
	
	@Column(name = "operater")
	public String getOperater() {
		return operater;
	}
	public void setOperater(String operater) {
		this.operater = operater;
	}
	
	@Column(name = "ipAddr")
	public String getIpAddr() {
		return ipAddr;
	}
	public void setIpAddr(String ipAddr) {
		this.ipAddr = ipAddr;
	}
	
	@Column(name = "importBatchId")
	public String getImportBatchId() {
		return importBatchId;
	}
	public void setImportBatchId(String importBatchId) {
		this.importBatchId = importBatchId;
	}
	
	@Column(name = "huodongid")
	public String getHuodongid() {
		return huodongid;
	}
	public void setHuodongid(String huodongid) {
		this.huodongid = huodongid;
	}

}