package cn.com.fubon.rest.entity.request;

public class GasolineGiftCarRequest {
	
	private String transId; //交易流水号
	private String merId;   //合作商户代码
	private String reqTime; //请求时间
	private String phone;   //手机号
	private String name;  //会员姓名
	private String birthday; //会员生日
	private String carNo;   //车牌号
	private String address;  //会员地址
	private String receiveWay;  //取领方式 邮寄10  渠道自取20
	private String orgCode;  //子机构编码
	 
	public GasolineGiftCarRequest(String transId, String merId, String reqTime,
			String phone, String name, String birthday, String carNo,
			String address, String receiveWay, String orgCode) {
		super();
		this.transId = transId;
		this.merId = merId;
		this.reqTime = reqTime;
		this.phone = phone;
		this.name = name;
		this.birthday = birthday;
		this.carNo = carNo;
		this.address = address;
		this.receiveWay = receiveWay;
		this.orgCode = orgCode;
	}
	public String getTransId() {
		return transId;
	}
	public void setTransId(String transId) {
		this.transId = transId;
	}
	public String getMerId() {
		return merId;
	}
	public void setMerId(String merId) {
		this.merId = merId;
	}
	public String getReqTime() {
		return reqTime;
	}
	public void setReqTime(String reqTime) {
		this.reqTime = reqTime;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getCarNo() {
		return carNo;
	}
	public void setCarNo(String carNo) {
		this.carNo = carNo;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getReceiveWay() {
		return receiveWay;
	}
	public void setReceiveWay(String receiveWay) {
		this.receiveWay = receiveWay;
	}
	public String getOrgCode() {
		return orgCode;
	}
	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}
	
	
	
}
