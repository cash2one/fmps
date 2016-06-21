package cn.com.fubon.fo.repairplatform.entity.response;

import cn.com.fubon.fo.repairplatform.entity.BaseResult;

/**
 * 领用活动券response
 * 
 * @author yaoming.zhang
 *
 */
public class ReceiveGiftSetResponse extends BaseResult {
	
	private ReceiveGiftSet giftsetDetail;	// giftsetDetail

	public ReceiveGiftSet getGiftsetDetail() {
		return giftsetDetail;
	}
	public void setGiftsetDetail(ReceiveGiftSet giftsetDetail) {
		this.giftsetDetail = giftsetDetail;
	}
	
}
