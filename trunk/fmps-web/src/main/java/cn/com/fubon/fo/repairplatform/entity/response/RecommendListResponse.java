package cn.com.fubon.fo.repairplatform.entity.response;

import java.util.List;

import cn.com.fubon.fo.repairplatform.entity.BaseResult;
import cn.com.fubon.common.entity.WeixinMerchandiseRecommend;


public class RecommendListResponse extends BaseResult {
	
	private String citycode; // 当前城市code	
	private List<WeixinMerchandiseRecommend> recommendList; // 精品推荐列表
	
	public String getCitycode() {
		return citycode;
	}
	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}
	
	public List<WeixinMerchandiseRecommend> getRecommendList() {
		return recommendList;
	}
	public void setRecommendList(List<WeixinMerchandiseRecommend> recommendList) {
		this.recommendList = recommendList;
	}
}
