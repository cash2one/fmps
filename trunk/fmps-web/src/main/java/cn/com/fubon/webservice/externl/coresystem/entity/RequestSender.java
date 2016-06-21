/**
 * 
 */
package cn.com.fubon.webservice.externl.coresystem.entity;

/**
 * 请求报文发送者类
 * 
 * @author binbin.wang
 *
 */
public class RequestSender {
	
	//消息类型
	private String messageType;
	
	//交易流水号
	private String transactionNo;
	
	//客户端代码
	private String clientCode;
	
	//发送日期
	private String sendDate;
	
	//发送时间
	private String sendTime;
	
	public RequestSender() {
		this.messageType = "1";
	}

	public String getMessageType() {
		return messageType;
	}

	public void setMessageType(String messageType) {
		this.messageType = messageType;
	}

	public String getTransactionNo() {
		return transactionNo;
	}

	public void setTransactionNo(String transactionNo) {
		this.transactionNo = transactionNo;
	}

	public String getClientCode() {
		return clientCode;
	}

	public void setClientCode(String clientCode) {
		this.clientCode = clientCode;
	}

	public String getSendDate() {
		return sendDate;
	}

	public void setSendDate(String sendDate) {
		this.sendDate = sendDate;
	}

	public String getSendTime() {
		return sendTime;
	}

	public void setSendTime(String sendTime) {
		this.sendTime = sendTime;
	}

}
