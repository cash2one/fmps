/**
 * 
 */
package cn.com.fubon.webservice.entity;

import java.io.Serializable;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * @author binbin.wang
 *
 */
public class BaseHead implements Serializable{

	@XStreamAlias("TRANSACTION_SEQNO")
	private String transcationSeqNo;
	
	@XStreamAlias("TRANSACTION_DATE")
	private String transcationDate;
	
	@XStreamAlias("TRANSACTION_TIME")
	private String transcationTime;
	
	@XStreamAlias("TRANSACTION_CODE")
	private String transcationCode;
	
	@XStreamAlias("SERVER_CODE")
	private String serverCode;
	
	@XStreamAlias("CLIENT_CODE")
	private String clientCode;
	
	/**
	 * 
	 */
	public BaseHead() {
		// TODO Auto-generated constructor stub
	}

	public String getTranscationSeqNo() {
		return transcationSeqNo;
	}

	public void setTranscationSeqNo(String transcationSeqNo) {
		this.transcationSeqNo = transcationSeqNo;
	}

	public String getTranscationDate() {
		return transcationDate;
	}

	public void setTranscationDate(String transcationDate) {
		this.transcationDate = transcationDate;
	}

	public String getTranscationTime() {
		return transcationTime;
	}

	public void setTranscationTime(String transcationTime) {
		this.transcationTime = transcationTime;
	}

	public String getTranscationCode() {
		return transcationCode;
	}

	public void setTranscationCode(String transcationCode) {
		this.transcationCode = transcationCode;
	}

	public String getServerCode() {
		return serverCode;
	}

	public void setServerCode(String serverCode) {
		this.serverCode = serverCode;
	}

	public String getClientCode() {
		return clientCode;
	}

	public void setClientCode(String clientCode) {
		this.clientCode = clientCode;
	}
	
}
