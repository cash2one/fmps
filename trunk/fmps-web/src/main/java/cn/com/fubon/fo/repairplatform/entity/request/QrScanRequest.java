package cn.com.fubon.fo.repairplatform.entity.request;

import cn.com.fubon.fo.repairplatform.entity.BaseHead;

public class QrScanRequest  extends BaseHead   {
	
	private String repairid; //维修厂ID
	private String uuid; //二维码UUID
	private String scanOpenId; //扫码时客户openId
	private String userId; // 企业号用户ID
	private String agentId; //企业号应用ID	
	private String qrType; //二维码类型	
	private String repairname; //维修厂名称	
	public QrScanRequest(){	}
	public QrScanRequest(String fromUser, String toUser,
			String transactionFormat, String transactionType,
			String transactionId, String repairid, String uuid,
			String scanOpenId, String userId, String agentId, String qrType,
			String repairname) {
		super(fromUser, toUser, transactionFormat, transactionType,
				transactionId);
		this.repairid = repairid;
		this.uuid = uuid;
		this.scanOpenId = scanOpenId;
		this.userId = userId;
		this.agentId = agentId;
		this.qrType = qrType;
		this.repairname = repairname;
	}
	public String getRepairid() {
		return repairid;
	}
	public void setRepairid(String repairid) {
		this.repairid = repairid;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getScanOpenId() {
		return scanOpenId;
	}
	public void setScanOpenId(String scanOpenId) {
		this.scanOpenId = scanOpenId;
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
	public String getRepairname() {
		return repairname;
	}
	public void setRepairname(String repairname) {
		this.repairname = repairname;
	}	
	 
	 
	
}
