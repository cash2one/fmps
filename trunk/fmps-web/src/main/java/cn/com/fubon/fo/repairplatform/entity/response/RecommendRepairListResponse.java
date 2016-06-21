package cn.com.fubon.fo.repairplatform.entity.response;

import java.util.List;

import cn.com.fubon.fo.repairplatform.entity.BaseResult;
import cn.com.fubon.common.entity.WeixinRepair;

public class RecommendRepairListResponse extends BaseResult {
	
	private String citycode; // 当前城市code
	private List<WeixinRepair> repairList; // 维修厂列表
	
	public String getCitycode() {
		return citycode;
	}
	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}	
	public List<WeixinRepair> getRepairList() {
		return repairList;
	}
	public void setRepairList(List<WeixinRepair> repairList) {
		this.repairList = repairList;
	}
	

}
