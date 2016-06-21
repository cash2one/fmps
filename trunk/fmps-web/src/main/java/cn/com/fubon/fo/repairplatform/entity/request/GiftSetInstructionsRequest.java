package cn.com.fubon.fo.repairplatform.entity.request;

import cn.com.fubon.fo.repairplatform.entity.BaseHead;

public class GiftSetInstructionsRequest extends BaseHead {
	
	private String giftset_detail_id;
	 
	public GiftSetInstructionsRequest(String fromUser, String toUser,
			String transactionFormat, String transactionType,
			String transactionId, String giftset_detail_id) {
		super(fromUser, toUser, transactionFormat, transactionType,
				transactionId);
		this.giftset_detail_id = giftset_detail_id;
	}

	public String getGiftset_detail_id() {
		return giftset_detail_id;
	}

	public void setGiftset_detail_id(String giftset_detail_id) {
		this.giftset_detail_id = giftset_detail_id;
	}
	

}
