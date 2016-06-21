/**
 * 
 */
package cn.com.fubon.webservice.externl.coresystem.entity;

/**
 * 响应报文发送者类
 * 
 * @author binbin.wang
 *
 */
public class ResponseSender {

	//消息类型
	private String messageType;
	
	//交易流水号
	private String transactionNo;
	
	//客户端代码
	private String clientCode;
	
	//处理状态
	private String auditStruts;
	
	//处理消息
	private String auditMessage;
	
	/**
	 * 
	 */
	public ResponseSender() {
		// TODO Auto-generated constructor stub
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

	public String getAuditStruts() {
		return auditStruts;
	}

	public void setAuditStruts(String auditStruts) {
		this.auditStruts = auditStruts;
	}

	public String getAuditMessage() {
		return auditMessage;
	}

	public void setAuditMessage(String auditMessage) {
		this.auditMessage = auditMessage;
	}

}
