package cn.com.fubon.fo.repairplatform.entity.request;

import cn.com.fubon.fo.repairplatform.entity.BaseHead;

/**
 * 礼包详情request
 * 
 * @author yaoming.zhang
 *
 */
public class GiftSetDetailRequest extends BaseHead {
	
	private String openid;	// openid
	private String giftSetId; // giftSetId
	
	public GiftSetDetailRequest(String fromUser, String toUser,
			String transactionFormat, String transactionType,
			String transactionId, String openid, String giftSetId) {
		super(fromUser, toUser, transactionFormat, transactionType,
				transactionId);
		this.openid = openid;
		this.giftSetId = giftSetId;
	}

	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public String getGiftSetId() {
		return giftSetId;
	}
	public void setGiftSetId(String giftSetId) {
		this.giftSetId = giftSetId;
	}

}
