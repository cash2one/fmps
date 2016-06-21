package cn.com.fubon.fo.repairplatform.entity.response;

import java.sql.Timestamp;
import java.util.List;

import cn.com.fubon.common.entity.WeixinRepair;
import cn.com.fubon.fo.repairplatform.entity.BaseResult;

public class RepairListResponse extends BaseResult  {
	
	private String city; // 当前城市 
	private List<WeixinRepair> repairList; // 维修厂列表	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public List<WeixinRepair> getRepairList() {
		return repairList;
	}
	public void setRepairList(List<WeixinRepair> repairList) {
		this.repairList = repairList;
	}


}
