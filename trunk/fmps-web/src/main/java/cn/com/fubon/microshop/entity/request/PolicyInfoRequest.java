package cn.com.fubon.microshop.entity.request;

import cn.com.fubon.rest.entity.BaseHead;

public class PolicyInfoRequest extends BaseHead {
	
	private String fmcpPayCode; //企业号支付码	
	private String wxPayTransactionId ; // 微信支付订单号  是  String(32)   
	private String outTradeNo  ;  // 商户订单号  是  String(32)   
	private String attach     ;    // 商家数据包  否  String(128)
	private String orderNo;
	private String policyNo;
	private String underwritingStatus; //1、成功  2、失败
	private String errorMessage; //错误消息
	
	
	public PolicyInfoRequest(String fromUser, String toUser,
			String transactionFormat, String transactionType,
			String transactionId, String fmcpPayCode,
			String wxPayTransactionId, String outTradeNo, String attach,
			String orderNo, String policyNo, String underwritingStatus,
			String errorMessage) {
		super(fromUser, toUser, transactionFormat, transactionType,
				transactionId);
		this.fmcpPayCode = fmcpPayCode;
		this.wxPayTransactionId = wxPayTransactionId;
		this.outTradeNo = outTradeNo;
		this.attach = attach;
		this.orderNo = orderNo;
		this.policyNo = policyNo;
		this.underwritingStatus = underwritingStatus;
		this.errorMessage = errorMessage;
	}
	
	
	public PolicyInfoRequest(){
		super();
	}
	
	public PolicyInfoRequest(String fromUser, String toUser,
			String transactionFormat, String transactionType,
			String transactionId, String fmcpPayCode,
			String wxPayTransactionId, String outTradeNo, String attach) {
		super(fromUser, toUser, transactionFormat, transactionType,
				transactionId);
		this.fmcpPayCode = fmcpPayCode;
		this.wxPayTransactionId = wxPayTransactionId;
		this.outTradeNo = outTradeNo;
		this.attach = attach;
	}
	public PolicyInfoRequest(String fromUser, String toUser,
			String transactionFormat, String transactionType,
			String transactionId, String orderNo, String policyNo) {
		super(fromUser, toUser, transactionFormat, transactionType,
				transactionId);
		this.orderNo = orderNo;
		this.policyNo = policyNo;
	}
	public String getFmcpPayCode() {
		return fmcpPayCode;
	}
	public void setFmcpPayCode(String fmcpPayCode) {
		this.fmcpPayCode = fmcpPayCode;
	}
	public String getWxPayTransactionId() {
		return wxPayTransactionId;
	}
	public void setWxPayTransactionId(String wxPayTransactionId) {
		this.wxPayTransactionId = wxPayTransactionId;
	}
	public String getOutTradeNo() {
		return outTradeNo;
	}
	public void setOutTradeNo(String outTradeNo) {
		this.outTradeNo = outTradeNo;
	}
	public String getAttach() {
		return attach;
	}
	public void setAttach(String attach) {
		this.attach = attach;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getPolicyNo() {
		return policyNo;
	}
	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}

	public String getUnderwritingStatus() {
		return underwritingStatus;
	}

	public void setUnderwritingStatus(String underwritingStatus) {
		this.underwritingStatus = underwritingStatus;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	
}
