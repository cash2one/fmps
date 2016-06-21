package cn.com.fubon.fo.repairplatform.entity.response;

import cn.com.fubon.fo.repairplatform.entity.BaseResult;
import cn.com.fubon.common.entity.WeixinGiftSet;
import cn.com.fubon.common.entity.WeixinRepair;

/**
 * 礼包详情response
 * 
 * @author yaoming.zhang
 */
public class GiftSetDetailResponse extends BaseResult {

	private WeixinGiftSet giftSet;
	private WeixinRepair merchant;
	private String remainQuantity;
	
	public WeixinGiftSet getGiftSet() {
		return giftSet;
	}
	public void setGiftSet(WeixinGiftSet giftSet) {
		this.giftSet = giftSet;
	}
	public WeixinRepair getMerchant() {
		return merchant;
	}
	public void setMerchant(WeixinRepair merchant) {
		this.merchant = merchant;
	}
	public String getRemainQuantity() {
		return remainQuantity;
	}
	public void setRemainQuantity(String remainQuantity) {
		this.remainQuantity = remainQuantity;
	}
	
}
