package cn.com.fubon.rest.entity.request;

public class GasolineGiftQueryRequest {
	
	private String transId; //交易流水号
	private String merId;   //合作商户代码
	private String reqTime; //请求时间
	private String phone;   //手机号	
	private String carNo;   //车牌号
	private String applyId;   //applyId	
	 
	public GasolineGiftQueryRequest(String transId, String merId,
			String reqTime, String phone, String carNo, String applyId) {
		super();
		this.transId = transId;
		this.merId = merId;
		this.reqTime = reqTime;
		this.phone = phone;
		this.carNo = carNo;
		this.applyId = applyId;
	}
	public String getApplyId() {
		return applyId;
	}
	public void setApplyId(String applyId) {
		this.applyId = applyId;
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
	public String getCarNo() {
		return carNo;
	}
	public void setCarNo(String carNo) {
		this.carNo = carNo;
	}

	
	 
}
