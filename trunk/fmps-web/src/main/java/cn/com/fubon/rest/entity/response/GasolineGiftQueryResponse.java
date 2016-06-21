package cn.com.fubon.rest.entity.response;

public class GasolineGiftQueryResponse {
	private String respCode;
	private String respMsg;
	private String respTime;	
	private String oilCardNo; //油卡卡号
	private String rchgDct;   //充值返点
	private String rchgDctExpire; //优惠有效期
	private String applyStatus; //申请状态
	
	
	public String getRespCode() {
		return respCode;
	}
	public void setRespCode(String respCode) {
		this.respCode = respCode;
	}
	public String getRespMsg() {
		return respMsg;
	}
	public void setRespMsg(String respMsg) {
		this.respMsg = respMsg;
	}
	public String getRespTime() {
		return respTime;
	}
	public void setRespTime(String respTime) {
		this.respTime = respTime;
	}
	public String getOilCardNo() {
		return oilCardNo;
	}
	public void setOilCardNo(String oilCardNo) {
		this.oilCardNo = oilCardNo;
	}
	public String getRchgDct() {
		return rchgDct;
	}
	public void setRchgDct(String rchgDct) {
		this.rchgDct = rchgDct;
	}
	public String getRchgDctExpire() {
		return rchgDctExpire;
	}
	public void setRchgDctExpire(String rchgDctExpire) {
		this.rchgDctExpire = rchgDctExpire;
	}
	public String getApplyStatus() {
		return applyStatus;
	}
	public void setApplyStatus(String applyStatus) {
		this.applyStatus = applyStatus;
	}
		
}
