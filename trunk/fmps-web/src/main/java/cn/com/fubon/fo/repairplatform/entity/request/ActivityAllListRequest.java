package cn.com.fubon.fo.repairplatform.entity.request;

import cn.com.fubon.fo.repairplatform.entity.BaseHead;

public class ActivityAllListRequest extends BaseHead {

	private String citycode; // 城市代码
	private String countycode; // 区县代码
	private String address; // 地址
	private String searchname;// 查询内容
	private String categoryid; // 分类id
	private String categoryIndex;// 1、首页，2、洗车，3、维修美容，4、4S店
	private String order;// 排序 好评优先：evaluation; 离我最近：distance
	private String paging;// 分页
	
	public ActivityAllListRequest() {
	}

	public ActivityAllListRequest(String fromUser, String toUser,
			String transactionFormat, String transactionType,
			String transactionId, String citycode, String countycode,
			String address, String searchname, String categoryid,
			String categoryIndex, String order, String paging) {
		super(fromUser, toUser, transactionFormat, transactionType,
				transactionId);
		this.citycode = citycode;
		this.countycode = countycode;
		this.address = address;
		this.searchname = searchname;
		this.categoryid = categoryid;
		this.categoryIndex = categoryIndex;
		this.order = order;
		this.paging = paging;
	}
	
	/**
	 * 4s店、维修美容厂商
	 * 
	 * @param fromUser
	 * @param toUser
	 * @param transactionFormat
	 * @param transactionType
	 * @param transactionId
	 * @param citycode
	 * @param countycode
	 * @param address
	 * @param categoryid
	 * @param order
	 * @param paging
	 */
	public ActivityAllListRequest(String fromUser, String toUser,
			String transactionFormat, String transactionType,
			String transactionId, String citycode, String countycode,
			String address, String categoryid, String order, String paging) {
		super(fromUser, toUser, transactionFormat, transactionType,
				transactionId);
		this.citycode = citycode;
		this.countycode = countycode;
		this.address = address;
		this.categoryid = categoryid;
		this.order = order;
		this.paging = paging;
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

	public String getCountycode() {
		return countycode;
	}

	public void setCountycode(String countycode) {
		this.countycode = countycode;
	}

	public String getSearchname() {
		return searchname;
	}

	public void setSearchname(String searchname) {
		this.searchname = searchname;
	}

	public String getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(String categoryid) {
		this.categoryid = categoryid;
	}

	public String getCategoryIndex() {
		return categoryIndex;
	}

	public void setCategoryIndex(String categoryIndex) {
		this.categoryIndex = categoryIndex;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public String getPaging() {
		return paging;
	}

	public void setPaging(String paging) {
		this.paging = paging;
	}
}
