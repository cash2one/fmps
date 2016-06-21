package cn.com.fubon.fo.repairplatform.entity.request;

import cn.com.fubon.fo.repairplatform.entity.BaseHead;

public class RepairEntityRequest  extends BaseHead  {
	private String repairid; // 维修厂ID 
	private String openid; // openid
	public RepairEntityRequest(String fromUser, String toUser,
			String transactionFormat, String transactionType,
			String transactionId, String repairid, String openid) {
		super(fromUser, toUser, transactionFormat, transactionType,
				transactionId);
		this.repairid = repairid;
		this.openid = openid;
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
	

}
