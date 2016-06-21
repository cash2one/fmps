package cn.com.fubon.fo.repairplatform.entity.request;

import cn.com.fubon.fo.repairplatform.entity.BaseHead;

public class RecommendListRequest extends BaseHead {
	private String citycode; // 城市名称
	private String address; // 地址
	
	public RecommendListRequest(String fromUser, String toUser,
			String transactionFormat, String transactionType,
			String transactionId, String citycode, String address) {
		super(fromUser, toUser, transactionFormat, transactionType,
				transactionId);
		this.citycode = citycode;
		this.address = address;
	}
	public String getCitycode() {
		return citycode;
	}
	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	

}
