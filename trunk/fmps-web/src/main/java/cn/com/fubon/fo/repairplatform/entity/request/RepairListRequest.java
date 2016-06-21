package cn.com.fubon.fo.repairplatform.entity.request;

import cn.com.fubon.fo.repairplatform.entity.BaseHead;

public class RepairListRequest   extends BaseHead {
	
	private String city; //城市名称
	private String order; //排序(可评价数：toBeEvaluated；好评优先：evaluation; 离我最近：distance)
	private String address; //地址
	private String paging;  //分页
	private String openid;  //当前客户OPENID
	private String giftset_detail_id;  //礼券ID
	public RepairListRequest(String fromUser, String toUser,
			String transactionFormat, String transactionType,
			String transactionId, String city, String order, String address,
			String paging, String openid, String giftset_detail_id) {
		super(fromUser, toUser, transactionFormat, transactionType,
				transactionId);
		this.city = city;
		this.order = order;
		this.address = address;
		this.paging = paging;
		this.openid = openid;
		this.giftset_detail_id = giftset_detail_id;
	}
	public String getGiftset_detail_id() {
		return giftset_detail_id;
	}
	public void setGiftset_detail_id(String giftset_detail_id) {
		this.giftset_detail_id = giftset_detail_id;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPaging() {
		return paging;
	}
	public void setPaging(String paging) {
		this.paging = paging;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	
	 
	
}
