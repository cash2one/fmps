package cn.com.fubon.fo.repairplatform.entity.response;

import java.util.List;

import cn.com.fubon.fo.repairplatform.entity.BaseResult;
import cn.com.fubon.fo.repairplatform.entity.GiftsetBaseInfo;

public class AreaGiftSetResponse extends BaseResult  {	
	
	private List<GiftsetBaseInfo> giftSetMoreList; // 地区券列表

	public List<GiftsetBaseInfo> getGiftSetMoreList() {
		return giftSetMoreList;
	}
	
	public void setGiftSetMoreList(List<GiftsetBaseInfo> giftSetMoreList) {
		this.giftSetMoreList = giftSetMoreList;
	}

	

}
