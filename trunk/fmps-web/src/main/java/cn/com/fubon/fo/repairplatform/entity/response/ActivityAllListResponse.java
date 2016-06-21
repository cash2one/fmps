package cn.com.fubon.fo.repairplatform.entity.response;

import java.util.List;

import cn.com.fubon.common.entity.AddressCode;
import cn.com.fubon.common.entity.Catagory;
import cn.com.fubon.common.entity.WeixinRepair;
import cn.com.fubon.fo.repairplatform.entity.BaseResult;

public class ActivityAllListResponse extends BaseResult {

	private String citycode; // 当前城市code
	private String countycode; // 当前区县code
	private List<Catagory> catagoryList; // 分类列表
	private List<AddressCode> addresscodeList; // 城市列表
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

	public String getCountycode() {
		return countycode;
	}

	public void setCountycode(String countycode) {
		this.countycode = countycode;
	}

	public List<Catagory> getCatagoryList() {
		return catagoryList;
	}

	public void setCatagoryList(List<Catagory> catagoryList) {
		this.catagoryList = catagoryList;
	}

	public List<AddressCode> getAddresscodeList() {
		return addresscodeList;
	}

	public void setAddresscodeList(List<AddressCode> addresscodeList) {
		this.addresscodeList = addresscodeList;
	}
}
