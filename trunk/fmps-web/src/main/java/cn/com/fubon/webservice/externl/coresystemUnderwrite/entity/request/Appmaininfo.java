package cn.com.fubon.webservice.externl.coresystemUnderwrite.entity.request;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 微店承保请求报文APPMAININFO部分
 * 
 * @author yaoming.zhang
 */
@XStreamAlias("APPMAININFO")
public class Appmaininfo {
	
	@XStreamAlias("RISKCODE")
	private String riskcode;
	
	@XStreamAlias("PRODUCTCODE")
	private String productcode;
	
	@XStreamAlias("ISADDTIONAL")
	private String isaddtional;	//是否投保附加险,默认值Y，Y是，N否
	
	@XStreamAlias("STARTDATE")
	private String startdate;
	
	@XStreamAlias("STARTHOUR")
	private String starthour;
	
	@XStreamAlias("ENDDATE")
	private String enddate;
	
	@XStreamAlias("ENDHOUR")
	private String endhour;
	
	@XStreamAlias("PERIOD")
	private String period;			//保险期间
	
	@XStreamAlias("APPNUM")
	private String appnum;
	
	@XStreamAlias("INSUREDNUM")
	private String insurednum;
	
	@XStreamAlias("TRAVELDESTINATION")
	private String traveldestination;
	
	@XStreamAlias("RATE")
	private String rate;			//折扣率,五折--0.50  八折--0.80
	
	@XStreamAlias("AMOUNT")
	private String amount;			//保额
	
	@XStreamAlias("PREMIUM")
	private String premium;			//保单原保费
	
	@XStreamAlias("DISCOUNTPREMIUM")
	private String discountpremium;
	
	@XStreamAlias("AUTOTRANSRENEWFLAG")
	private String autotransrenewflag;
	
	@XStreamAlias("AGENTCODE")
	private String agentcode;
	
	@XStreamAlias("AGREEMENTNO")
	private String agreementno;
	
	@XStreamAlias("OPERATECODE")
	private String operatecode;
	
	@XStreamAlias("HANDLER1CODE")
	private String handler1code;
	
	@XStreamAlias("CHANNELTYPE")
	private String channeltype;
	
	@XStreamAlias("BUSINESSNATURE")
	private String businessnature;
	
	@XStreamAlias("PAYSERIALNO")
	private String payserialno;	//交易流水号
	
	@XStreamAlias("ORDERNO")
	private String orderNo;	//订单号
	
	@XStreamAlias("AGENCYTRANSACTIONNO")
	private String agencyTransacTionNO;	//代理交易码
	
	@XStreamAlias("POLICYNO")
	private String policyNo;	//保单号	

	@XStreamAlias("JOBUNIT")
	private String jobUnit; //学校
	

	@XStreamAlias("COMCODE")
	private String comCode; //归属机构
	
	@XStreamAlias("JFEEFLAG")
	private String jfeeFlag; //见费标志
	
	@XStreamAlias("OPERATEDATE")
	private String operateDate; // 操作日期 

		
	public String getRiskcode() {
		return riskcode;
	}

	public void setRiskcode(String riskcode) {
		this.riskcode = riskcode;
	}

	public String getProductcode() {
		return productcode;
	}

	public void setProductcode(String productcode) {
		this.productcode = productcode;
	}

	public String getIsaddtional() {
		return isaddtional;
	}

	public void setIsaddtional(String isaddtional) {
		this.isaddtional = isaddtional;
	}

	public String getStartdate() {
		return startdate;
	}

	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}

	public String getStarthour() {
		return starthour;
	}

	public void setStarthour(String starthour) {
		this.starthour = starthour;
	}

	public String getEnddate() {
		return enddate;
	}

	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}

	public String getEndhour() {
		return endhour;
	}

	public void setEndhour(String endhour) {
		this.endhour = endhour;
	}

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public String getAppnum() {
		return appnum;
	}

	public void setAppnum(String appnum) {
		this.appnum = appnum;
	}

	public String getInsurednum() {
		return insurednum;
	}

	public void setInsurednum(String insurednum) {
		this.insurednum = insurednum;
	}

	public String getTraveldestination() {
		return traveldestination;
	}

	public void setTraveldestination(String traveldestination) {
		this.traveldestination = traveldestination;
	}

	public String getRate() {
		return rate;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}
	
	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getPremium() {
		return premium;
	}

	public void setPremium(String premium) {
		this.premium = premium;
	}

	public String getDiscountpremium() {
		return discountpremium;
	}

	public void setDiscountpremium(String discountpremium) {
		this.discountpremium = discountpremium;
	}

	public String getAutotransrenewflag() {
		return autotransrenewflag;
	}

	public void setAutotransrenewflag(String autotransrenewflag) {
		this.autotransrenewflag = autotransrenewflag;
	}

	public String getAgentcode() {
		return agentcode;
	}

	public void setAgentcode(String agentcode) {
		this.agentcode = agentcode;
	}

	public String getAgreementno() {
		return agreementno;
	}

	public void setAgreementno(String agreementno) {
		this.agreementno = agreementno;
	}

	public String getOperatecode() {
		return operatecode;
	}

	public void setOperatecode(String operatecode) {
		this.operatecode = operatecode;
	}

	public String getHandler1code() {
		return handler1code;
	}

	public void setHandler1code(String handler1code) {
		this.handler1code = handler1code;
	}

	public String getChanneltype() {
		return channeltype;
	}

	public void setChanneltype(String channeltype) {
		this.channeltype = channeltype;
	}

	public String getBusinessnature() {
		return businessnature;
	}

	public void setBusinessnature(String businessnature) {
		this.businessnature = businessnature;
	}	

	public String getPayserialno() {
		return payserialno;
	}

	public void setPayserialno(String payserialno) {
		this.payserialno = payserialno;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getAgencyTransacTionNO() {
		return agencyTransacTionNO;
	}

	public void setAgencyTransacTionNO(String agencyTransacTionNO) {
		this.agencyTransacTionNO = agencyTransacTionNO;
	}

	public String getPolicyNo() {
		return policyNo;
	}

	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}

	public String getJobUnit() {
		return jobUnit;
	}

	public void setJobUnit(String jobUnit) {
		this.jobUnit = jobUnit;
	}

	public String getComCode() {
		return comCode;
	}

	public void setComCode(String comCode) {
		this.comCode = comCode;
	}

	public String getJfeeFlag() {
		return jfeeFlag;
	}

	public void setJfeeFlag(String jfeeFlag) {
		this.jfeeFlag = jfeeFlag;
	}

	public String getOperateDate() {
		return operateDate;
	}

	public void setOperateDate(String operateDate) {
		this.operateDate = operateDate;
	}
	
	
}
