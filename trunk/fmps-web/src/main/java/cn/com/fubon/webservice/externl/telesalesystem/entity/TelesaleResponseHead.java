package cn.com.fubon.webservice.externl.telesalesystem.entity;

import com.thoughtworks.xstream.annotations.XStreamAlias;

public class TelesaleResponseHead {

	//报文类型
	@XStreamAlias("PACKETTYPE")
	private String packetType;
	
	//用来区分车险和非车：CX代表车险，FC代表非车险
	@XStreamAlias("CLASSCODE")
	private String classCode;
	
	/* 支付码状态: 001：支付码不存在,002：支付码过期,003：支付码无效-人工置失败,004：已完成支付,005：支付码可用*/
	@XStreamAlias("YANZHENGMASTATUS")
	private String payCodeStatus;
	
	//支付码
	@XStreamAlias("PAYCODE")
	private String payCode;

	public String getClassCode() {
		return classCode;
	}
	public void setClassCode(String classCode) {
		this.classCode = classCode;
	}
	public String getPayCodeStatus() {
		return payCodeStatus;
	}
	public void setPayCodeStatus(String payCodeStatus) {
		this.payCodeStatus = payCodeStatus;
	}
	public String getPacketType() {
		return packetType;
	}
	public void setPacketType(String packetType) {
		this.packetType = packetType;
	}
	public String getPayCode() {
		return payCode;
	}
	public void setPayCode(String payCode) {
		this.payCode = payCode;
	}
}
