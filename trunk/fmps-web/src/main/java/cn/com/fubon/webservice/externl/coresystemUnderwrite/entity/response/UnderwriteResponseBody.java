package cn.com.fubon.webservice.externl.coresystemUnderwrite.entity.response;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 微店承保响应报文BODY部分
 * 
 * @author yaoming.zhang
 */
public class UnderwriteResponseBody {
	
	@XStreamAlias("POLICYNO")
	private String policyno;

	@XStreamAlias("APPLICUSTOMERCODE")
	private String applicustomercode;	//投保人客户号
	
	public String getPolicyno() {
		return policyno;
	}
	public void setPolicyno(String policyno) {
		this.policyno = policyno;
	}
	public String getApplicustomercode() {
		return applicustomercode;
	}
	public void setApplicustomercode(String applicustomercode) {
		this.applicustomercode = applicustomercode;
	}
	
}
