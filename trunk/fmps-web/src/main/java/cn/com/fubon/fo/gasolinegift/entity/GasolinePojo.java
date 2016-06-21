package cn.com.fubon.fo.gasolinegift.entity;

public class GasolinePojo {
	
	private String openid; 
	private String mobile; // 手机号
	private String licenseno; // 车牌号
	private String address; // 客户详细地址
	private String receiveAddress;	//领取地址
	private String username; // 用户姓名	
	private int channel; // 渠道（1、富邦2、94频道）'
	private int receiveWay; // 领取方式（取领方式 邮寄10  渠道自取20）
	private String cityCode; // 城市代码
	private String area_parent; // 城市
	private String area_child; // 区县
	private String villages ; //  乡镇
	private String isCarCustomer ; //  是否车险客户
	private String licensenoList ; // 车险客户车牌选择列表
	private String carLicense ; // 车牌号中文部分
	private String carNo ; // 车牌号非中文部分
	
	
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getLicenseno() {
		return licenseno;
	}
	public void setLicenseno(String licenseno) {
		this.licenseno = licenseno;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getReceiveAddress() {
		return receiveAddress;
	}
	public void setReceiveAddress(String receiveAddress) {
		this.receiveAddress = receiveAddress;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getChannel() {
		return channel;
	}
	public void setChannel(int channel) {
		this.channel = channel;
	}
	public int getReceiveWay() {
		return receiveWay;
	}
	public void setReceiveWay(int receiveWay) {
		this.receiveWay = receiveWay;
	}
	public String getCityCode() {
		return cityCode;
	}
	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}
	public String getArea_parent() {
		return area_parent;
	}
	public void setArea_parent(String area_parent) {
		this.area_parent = area_parent;
	}
	public String getArea_child() {
		return area_child;
	}
	public void setArea_child(String area_child) {
		this.area_child = area_child;
	}
	public String getVillages() {
		return villages;
	}
	public void setVillages(String villages) {
		this.villages = villages;
	}
	public String getIsCarCustomer() {
		return isCarCustomer;
	}
	public void setIsCarCustomer(String isCarCustomer) {
		this.isCarCustomer = isCarCustomer;
	}
	public String getLicensenoList() {
		return licensenoList;
	}
	public void setLicensenoList(String licensenoList) {
		this.licensenoList = licensenoList;
	}
	public String getCarLicense() {
		return carLicense;
	}
	public void setCarLicense(String carLicense) {
		this.carLicense = carLicense;
	}
	public String getCarNo() {
		return carNo;
	}
	public void setCarNo(String carNo) {
		this.carNo = carNo;
	}
	

}
