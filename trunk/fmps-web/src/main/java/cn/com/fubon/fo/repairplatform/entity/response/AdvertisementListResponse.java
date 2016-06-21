package cn.com.fubon.fo.repairplatform.entity.response;

import java.util.List;

import cn.com.fubon.fo.repairplatform.entity.BaseResult;
import cn.com.fubon.common.entity.WeixinActivityAdvertisement;
import cn.com.fubon.common.entity.WeixinMerchandiseRecommend;
import cn.com.fubon.common.entity.WeixinRepair;

public class AdvertisementListResponse extends BaseResult {
	
	private String citycode; // 当前城市code
	private List<WeixinActivityAdvertisement> advertisementList; // 活动广告列表	
	
	public String getCitycode() {
		return citycode;
	}
	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}
	public List<WeixinActivityAdvertisement> getAdvertisementList() {
		return advertisementList;
	}
	public void setAdvertisementList(
			List<WeixinActivityAdvertisement> advertisementList) {
		this.advertisementList = advertisementList;
	}	

}
