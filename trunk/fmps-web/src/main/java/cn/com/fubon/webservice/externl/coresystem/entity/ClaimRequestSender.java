package cn.com.fubon.webservice.externl.coresystem.entity;

/**
 * 理赔请求报文发送者类
 * 
 * @author fangfang.guo
 *
 */
public class ClaimRequestSender extends RequestSender{
	
	private String transactionDate;
	private String transactionTime;
	
	public ClaimRequestSender(){
		this.setMessageType(null);
	}

	public String getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}

	public String getTransactionTime() {
		return transactionTime;
	}

	public void setTransactionTime(String transactionTime) {
		this.transactionTime = transactionTime;
	}

}
