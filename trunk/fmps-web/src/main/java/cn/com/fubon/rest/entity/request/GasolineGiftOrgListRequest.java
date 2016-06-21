package cn.com.fubon.rest.entity.request;

public class GasolineGiftOrgListRequest {
	
	private String transId; //交易流水号
	private String merId;   //合作商户代码
	private String reqTime; //请求时间	
	
	public GasolineGiftOrgListRequest(String transId, String merId,
			String reqTime) {
		super();
		this.transId = transId;
		this.merId = merId;
		this.reqTime = reqTime;
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
	 

}
