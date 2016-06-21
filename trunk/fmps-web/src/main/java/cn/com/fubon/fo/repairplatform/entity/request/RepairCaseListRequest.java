package cn.com.fubon.fo.repairplatform.entity.request;

import java.util.List;

import cn.com.fubon.common.entity.RepairCase;
import cn.com.fubon.fo.repairplatform.entity.BaseHead;

public class RepairCaseListRequest   extends BaseHead {

	private String repairid; // 维修厂ID
	private String openid; // 评价人员openid	
	private String userId; // 企业号用户ID
	private String agentId; //企业号应用ID	
	private String qrType; //二维码类型	
	private List<RepairCase> repairCaseList; // 维修厂列表	 	
	public RepairCaseListRequest(){}
	public RepairCaseListRequest(String fromUser, String toUser,
			String transactionFormat, String transactionType,
			String transactionId, String repairid, String openid,
			String userId, String agentId, String qrType,
			List<RepairCase> repairCaseList) {
		super(fromUser, toUser, transactionFormat, transactionType,
				transactionId);
		this.repairid = repairid;
		this.openid = openid;
		this.userId = userId;
		this.agentId = agentId;
		this.qrType = qrType;
		this.repairCaseList = repairCaseList;
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
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getAgentId() {
		return agentId;
	}
	public void setAgentId(String agentId) {
		this.agentId = agentId;
	}
	public String getQrType() {
		return qrType;
	}
	public void setQrType(String qrType) {
		this.qrType = qrType;
	}
	public List<RepairCase> getRepairCaseList() {
		return repairCaseList;
	}
	public void setRepairCaseList(List<RepairCase> repairCaseList) {
		this.repairCaseList = repairCaseList;
	}
	
	
	 
	 
}
