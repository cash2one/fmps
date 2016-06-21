package cn.com.fubon.fo.repairplatform.entity;

import java.io.Serializable;

public class GiftsetBaseInfo  implements Serializable {
	private String giftSetId; //券ID
	private String giftSetName;	 //券名称
	private String repairName;   //维修厂名称	
	public String getGiftSetId() {
		return giftSetId;
	}
	public void setGiftSetId(String giftSetId) {
		this.giftSetId = giftSetId;
	}
	public String getGiftSetName() {
		return giftSetName;
	}
	public void setGiftSetName(String giftSetName) {
		this.giftSetName = giftSetName;
	}
	public String getRepairName() {
		return repairName;
	}
	public void setRepairName(String repairName) {
		this.repairName = repairName;
	}
		
}
