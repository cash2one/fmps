package cn.com.fubon.rest.entity.response;

import java.util.List;

import cn.com.fubon.rest.entity.Organization;

public class GasolineGiftOrgListResponse {	
	private String respCode;
	private String respMsg;
	private String respTime; 
	private List<Organization>  orgList   ;
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
	public List<Organization> getOrgList() {
		return orgList;
	}
	public void setOrgList(List<Organization> orgList) {
		this.orgList = orgList;
	}
	 
	
	
	
}
