package cn.com.fubon.fo.repairplatform.entity.request;

import cn.com.fubon.fo.repairplatform.entity.BaseHead;

public class EvaluationSaveRequest  extends BaseHead  {	
	private String repairid; // 维修厂ID
	private String openid; // 评价人员openid
	private String nickname; // 昵称
	private String headimgurl; // 头像
	private String evaluation; // 评价
	private String comment; // 评语		
	
	public EvaluationSaveRequest(String fromUser, String toUser,
			String transactionFormat, String transactionType,
			String transactionId, String repairid, String openid,
			String nickname, String headimgurl, String evaluation,
			String comment) {
		super(fromUser, toUser, transactionFormat, transactionType,
				transactionId);
		this.repairid = repairid;
		this.openid = openid;
		this.nickname = nickname;
		this.headimgurl = headimgurl;
		this.evaluation = evaluation;
		this.comment = comment;
	}
	public String getRepairid() {
		return repairid;
	}
	public void setRepairid(String repairid) {
		this.repairid = repairid;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
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
	public String getEvaluation() {
		return evaluation;
	}
	public void setEvaluation(String evaluation) {
		this.evaluation = evaluation;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}			 
	

}
