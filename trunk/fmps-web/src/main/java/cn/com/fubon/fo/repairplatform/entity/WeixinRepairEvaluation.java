package cn.com.fubon.fo.repairplatform.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.jeecgframework.core.common.entity.IdEntity;

import cn.com.fubon.fo.card.entity.ContractAddress;
import cn.com.fubon.wechatClaims.entity.ReportInfo;

@Entity
@Table(name = "weixin_repair_evaluation")
@PrimaryKeyJoinColumn(name = "id")
public class WeixinRepairEvaluation extends IdEntity implements Serializable {

	private String comment; // 评价内容
	private Date createtime; // 评价时间
	private Integer evaluation; // 评价星级

	private String headimgurl; // 服务号用户头像

	private String nickname; // 服务号用户昵称

	private String openid; // 服务号用户微信号

	private String qRcodeUUID; // 二维码UUID
	
	private String repairid; // 维修厂ID

	private String repairname; // 维修厂名称
	
	private ReportInfo reportInfo; //  微信报案信息表id
	private Date scanQrCodeTime; // 扫码时间

	
	@Column(name = "comment")
	public String getComment() {
		return comment;
	}

	@Column(name = "createtime")
	public Date getCreatetime() {
		return createtime;
	}

	@Column(name = "evaluation")
	public Integer getEvaluation() {
		return evaluation;
	}

	@Column(name = "headimgurl")
	public String getHeadimgurl() {
		return headimgurl;
	}

	@Column(name = "nickname")
	public String getNickname() {
		return nickname;
	}

	@Column(name = "openid")
	public String getOpenid() {
		return openid;
	}

	@Column(name = "qRcodeUUID")
	public String getqRcodeUUID() {
		return qRcodeUUID;
	}

	@Column(name = "repairid")
	public String getRepairid() {
		return repairid;
	}

	@Column(name = "repairname")
	public String getRepairname() {
		return repairname;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "reportinfoid", nullable = true)
	public ReportInfo getReportInfo() {
		return reportInfo;
	}

	@Column(name = "scanQrCodeTime")
	public Date getScanQrCodeTime() {
		return scanQrCodeTime;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public void setEvaluation(Integer evaluation) {
		this.evaluation = evaluation;
	}

	public void setHeadimgurl(String headimgurl) {
		this.headimgurl = headimgurl;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public void setqRcodeUUID(String qRcodeUUID) {
		this.qRcodeUUID = qRcodeUUID;
	}

	public void setRepairid(String repairid) {
		this.repairid = repairid;
	}

	public void setRepairname(String repairname) {
		this.repairname = repairname;
	}

	public void setReportInfo(ReportInfo reportInfo) {
		this.reportInfo = reportInfo;
	}


	public void setScanQrCodeTime(Date scanQrCodeTime) {
		this.scanQrCodeTime = scanQrCodeTime;
	}

}
