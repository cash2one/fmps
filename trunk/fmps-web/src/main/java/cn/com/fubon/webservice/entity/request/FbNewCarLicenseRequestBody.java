package cn.com.fubon.webservice.entity.request;

/**
 * 新车上牌核心接口用到的RequestBody
 * @author fangfang.guo
 *
 */
public class FbNewCarLicenseRequestBody extends RequestBody{
	//保单号
	private String policyNo;
	//新的车牌号
	private String licenseNo;
	//客户编码
	private String insuredCode;
	//微信账号
	private String openId;
	
	public String getPolicyNo() {
		return policyNo;
	}
	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}
	public String getLicenseNo() {
		return licenseNo;
	}
	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}
	public String getInsuredCode() {
		return insuredCode;
	}
	public void setInsuredCode(String insuredCode) {
		this.insuredCode = insuredCode;
	}
	public String getOpenId() {
		return openId;
	}
	public void setOpenId(String openId) {
		this.openId = openId;
	}
	
}
