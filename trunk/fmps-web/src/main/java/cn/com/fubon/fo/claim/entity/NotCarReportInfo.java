package cn.com.fubon.fo.claim.entity;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import org.jeecgframework.core.common.entity.IdEntity;
import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("report")
@Entity
@Table(name="weixin_notcar_report_info")
@PrimaryKeyJoinColumn(name = "id")
public class NotCarReportInfo extends IdEntity  {
	//报案号
	private String registNo;
	//保单号
	private String policyNo;
	//被保险人
	private String insuredName;
	//报案人名称
	private String reportorName;
	//报案日期 YYYY-MM-DD
	private String reportDate;
	//报案时间 HH24:MM:SS
	private String reportTime;
	//保险起期
	private String startDate;
	//保险止期
	private String endDate;
	//出险摘要
	private String remark;
	//案件状态 1:未结案;2:已结案，缺材料;100:查看调度改派修改理赔方式;110:核赔提交;111-案件注销;112-案件零结
	private Integer caseStatus;
	
	public String getRegistNo() {
		return registNo;
	}
	public void setRegistNo(String registNo) {
		this.registNo = registNo;
	}
	public String getPolicyNo() {
		return policyNo;
	}
	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}
	public String getInsuredName() {
		return insuredName;
	}
	public void setInsuredName(String insuredName) {
		this.insuredName = insuredName;
	}
	public String getReportorName() {
		return reportorName;
	}
	public void setReportorName(String reportorName) {
		this.reportorName = reportorName;
	}
	public String getReportDate() {
		return reportDate;
	}
	public void setReportDate(String reportDate) {
		this.reportDate = reportDate;
	}
	public String getReportTime() {
		return reportTime;
	}
	public void setReportTime(String reportTime) {
		this.reportTime = reportTime;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Integer getCaseStatus() {
		return caseStatus;
	}
	public void setCaseStatus(Integer caseStatus) {
		this.caseStatus = caseStatus;
	}
	
}
