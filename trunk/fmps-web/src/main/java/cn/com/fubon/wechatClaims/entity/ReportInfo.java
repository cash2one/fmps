package cn.com.fubon.wechatClaims.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import org.jeecgframework.core.common.entity.IdEntity;
import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("report")
@Entity
@Table(name="weixin_report_info")
@PrimaryKeyJoinColumn(name = "id")
public class ReportInfo extends IdEntity  {
	//报案号
	private String registNo;
	//报案人名称
	private String reportorName;
	//车牌号
	private String licenseNo;
	//报案日期 YYYY-MM-DD
	private String reportDate;
	//报案时间 HH24:MM:SS
	private String reportTime;
	//理赔人员工号
	private String operatorCode;
	//理赔人员名称
	private String operatorName;
	//欠缺材料类型
	private String certiMaterialType;
	//出险摘要
	private String remark;
	//案件状态 1:未结案;2:已结案，缺材料;100:查看调度改派修改理赔方式;110:核赔提交;111-案件注销;112-案件零结
	private Integer caseStatus;
	//是否新车 1：是 0：否
	private Integer newCarFlag;
	//openid
	private String openid;
	//昵称
	private String nickname;
    //用户头像
	private String headimgurl;
    //会话状态  1:会话中;0:结束会话
    private Integer  sessionState;
    // 报案电话
    private  String  phoneNumber;
	// 核赔结束时间
	private Timestamp underwritingTime;
	//理赔耗时 单位:秒 核赔结束时间-报案时间
	private Integer claimConsumeTime;
	//险别信息
	private String kindName;
	//车型;车架号;发动机号
	private String carModel;
	
	//理赔金额
	private BigDecimal claimCaseFee;
	//新增时间
	private Timestamp createTime;	
	
	//0-未扫码; 1-兜底维修厂扫码 ; 2-其他修理厂修改
	private Integer repairState ;
	//理赔金额确认时间
	private Timestamp confirmTime ;
	//理赔金额确认方式1、手动  0、系统自动
	private String confirmStyle ;
	  
	public Integer getRepairState() {
		return repairState;
	}
	public void setRepairState(Integer repairState) {
		this.repairState = repairState;
	}
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	
	public BigDecimal getClaimCaseFee() {
		return claimCaseFee;
	}
	public void setClaimCaseFee(BigDecimal claimCaseFee) {
		this.claimCaseFee = claimCaseFee;
	}
	public String getRegistNo() {
		return registNo;
	}
	public void setRegistNo(String registNo) {
		this.registNo = registNo;
	}
	public String getLicenseNo() {
		return licenseNo;
	}
	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
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
	public String getOperatorCode() {
		return operatorCode;
	}
	public void setOperatorCode(String operatorCode) {
		this.operatorCode = operatorCode;
	}
	public String getCertiMaterialType() {
		return certiMaterialType;
	}
	public void setCertiMaterialType(String certiMaterialType) {
		this.certiMaterialType = certiMaterialType;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getReportorName() {
		return reportorName;
	}
	public void setReportorName(String reportorName) {
		this.reportorName = reportorName;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	
	public Integer getCaseStatus() {
		return caseStatus;
	}
	public void setCaseStatus(Integer caseStatus) {
		this.caseStatus = caseStatus;
	}
	public Integer getNewCarFlag() {
		return newCarFlag;
	}
	public void setNewCarFlag(Integer newCarFlag) {
		this.newCarFlag = newCarFlag;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getHeadimgurl() {
		return headimgurl;
	}
	public void setHeadimgurl(String headimgurl) {
		this.headimgurl = headimgurl;
	}
	public Integer getSessionState() {
		return sessionState;
	}
	public void setSessionState(Integer sessionState) {
		this.sessionState = sessionState;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Timestamp getUnderwritingTime() {
		return underwritingTime;
	}
	public void setUnderwritingTime(Timestamp underwritingTime) {
		this.underwritingTime = underwritingTime;
	}
	public Integer getClaimConsumeTime() {
		return claimConsumeTime;
	}
	public void setClaimConsumeTime(Integer claimConsumeTime) {
		this.claimConsumeTime = claimConsumeTime;
	}
	public String getOperatorName() {
		return operatorName;
	}
	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}
	public String getKindName() {
		return kindName;
	}
	public void setKindName(String kindName) {
		this.kindName = kindName;
	}
	public String getCarModel() {
		return carModel;
	}
	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}
	 
	public Timestamp getConfirmTime() {
		return confirmTime;
	}
	public void setConfirmTime(Timestamp confirmTime) {
		this.confirmTime = confirmTime;
	}
	public String getConfirmStyle() {
		return confirmStyle;
	}
	public void setConfirmStyle(String confirmStyle) {
		this.confirmStyle = confirmStyle;
	}
}
