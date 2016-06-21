package cn.com.fubon.webservice.externl.telesalesystem.entity;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

public class TelesaleResponseProposal {

	//被保险人名称
	@XStreamAlias("INSUREDNAME")
	private String insuredName;
	//车牌号
	@XStreamAlias("LICENSENO")
	private String licenseNo;
	//商业险信息
	@XStreamImplicit(itemFieldName="RISKLIST")
	private List<Risklist> risklist;
	//保单起保日期
	@XStreamAlias("STARTDATE")
	private String startDate;
	//总保费
	@XStreamAlias("SUMPREMIUM")
	private String sumPremium;
	//被保险人证件号码
	@XStreamAlias("IDENTIFYNUMBER")
	private String identifyNumber;
	//购买险种名称
	@XStreamAlias("PRODUCTNAME")
	private String productName;
	//支付失败代码
	@XStreamAlias("RETURNCODE")
	private String returnCode;
	//支付失败原因
	@XStreamAlias("RETURNMESSAGE")
	private String returnMessage;
	
	public String getInsuredName() {
		return insuredName;
	}
	public void setInsuredName(String insuredName) {
		this.insuredName = insuredName;
	}
	public String getLicenseNo() {
		return licenseNo;
	}
	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}
	
	public List<Risklist> getRisklist() {
		return risklist;
	}
	public void setRisklist(List<Risklist> risklist) {
		this.risklist = risklist;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getSumPremium() {
		return sumPremium;
	}
	public void setSumPremium(String sumPremium) {
		this.sumPremium = sumPremium;
	}
	public String getIdentifyNumber() {
		return identifyNumber;
	}
	public void setIdentifyNumber(String identifyNumber) {
		this.identifyNumber = identifyNumber;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getReturnCode() {
		return returnCode;
	}
	public void setReturnCode(String returnCode) {
		this.returnCode = returnCode;
	}
	public String getReturnMessage() {
		return returnMessage;
	}
	public void setReturnMessage(String returnMessage) {
		this.returnMessage = returnMessage;
	}
	
}


