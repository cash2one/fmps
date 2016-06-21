package cn.com.fubon.webservice.externl.telesalesystem.entity;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 商业险信息项
 * @author fangfang.guo
 */
@XStreamAlias("PRPTITEMKIND")
public class PrpTitemkind {
	//标的
	@XStreamAlias("ITEMNAME")
	private String itemname;
	//险种名称
	@XStreamAlias("KINDNAME")
	private String kindName;
	//保额 
	@XStreamAlias("AMOUNT")
	private String amount;
	//保费
	@XStreamAlias("PREMIUM")
	private String premium;
	//险种序号 1：商业险，2：交强险，3：车船税，4：交通守护保险，5：非车险
	@XStreamAlias("RISKKIND")
	private String riskKind;
	//不计免赠:N否，Y是
	@XStreamAlias("NONDEDUCTIBLE")
	private String nonDeductible;
	
	public String getKindName() {
		return kindName;
	}
	public void setKindName(String kindName) {
		this.kindName = kindName;
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
	public String getRiskKind() {
		return riskKind;
	}
	public void setRiskKind(String riskKind) {
		this.riskKind = riskKind;
	}
	public String getNonDeductible() {
		return nonDeductible;
	}
	public void setNonDeductible(String nonDeductible) {
		this.nonDeductible = nonDeductible;
	}
	public String getItemname() {
		return itemname;
	}
	public void setItemname(String itemname) {
		this.itemname = itemname;
	}
	
}