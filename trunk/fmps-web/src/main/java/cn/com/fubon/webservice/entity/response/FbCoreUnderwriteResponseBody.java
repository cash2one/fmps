package cn.com.fubon.webservice.entity.response;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 核心承保-响应报文体
 *
 */
public class FbCoreUnderwriteResponseBody extends ResponseBody {

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
