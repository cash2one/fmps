package cn.com.fubon.fo.repairplatform.entity.request;

import cn.com.fubon.fo.repairplatform.entity.BaseHead;

/**
 * 领用活动券request
 * 
 * @author yaoming.zhang
 *
 */
public class ReceiveGiftSetRequest extends BaseHead {
	
	private String giftSetId;	// giftSetId
	private String openid;		// openid
	private String huodongid;	// huodongid
	private String receivedate;	// 领券时间
	
	public ReceiveGiftSetRequest(String fromUser, String toUser,
			String transactionFormat, String transactionType,
			String transactionId, String giftSetId, String openid, String huodongid, String receivedate) {
		super(fromUser, toUser, transactionFormat, transactionType,
				transactionId);
		this.giftSetId = giftSetId;
		this.openid = openid;
		this.huodongid = huodongid;
		this.receivedate = receivedate;
	}

	public String getGiftSetId() {
		return giftSetId;
	}
	public void setGiftSetId(String giftSetId) {
		this.giftSetId = giftSetId;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public String getHuodongid() {
		return huodongid;
	}
	public void setHuodongid(String huodongid) {
		this.huodongid = huodongid;
	}
	public String getReceivedate() {
		return receivedate;
	}
	public void setReceivedate(String receivedate) {
		this.receivedate = receivedate;
	}
	
}
