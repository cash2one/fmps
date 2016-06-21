/**
 * 
 */
package cn.com.fubon.bo.wsinvokelog.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.jeecgframework.core.common.entity.IdEntity;

/**
 * WebService调用失败日志
 * 
 * @author binbin.wang
 *
 */

@Entity
@Table(name="webservice_invoke_failure_log")
@PrimaryKeyJoinColumn(name = "id")
public class WsInvokeFailureLog extends IdEntity  {
	
	private String clientCode;
	private String transcationSeqNo; 
	private String orginTranscationSeqNo;
	private String internalRequest;
	private String internalResponse;
	private String returnCode;
	private String returnMessage;
	private String wsClientBeanName;
	private Date nextInvokeTime;
	private int status;
	private int sendCount;

	//序列化内部类
	private byte[] internalRequestObj;

	public WsInvokeFailureLog() {
		// TODO Auto-generated constructor stub
	}
	
	
	@Column(name="client_code", length=10)
	public String getClientCode() {
		return clientCode;
	}

	public void setClientCode(String clientCode) {
		this.clientCode = clientCode;
	}

	@Column(name="transcation_seq_no", length=20)
	public String getTranscationSeqNo() {
		return transcationSeqNo;
	}

	public void setTranscationSeqNo(String transcationSeqNo) {
		this.transcationSeqNo = transcationSeqNo;
	}

	@Column(name="orgin_transcation_seq_no", length=20)
	public String getOrginTranscationSeqNo() {
		return orginTranscationSeqNo;
	}

	public void setOrginTranscationSeqNo(String orginTranscationSeqNo) {
		this.orginTranscationSeqNo = orginTranscationSeqNo;
	}

	@Column(name="internal_request", length=2550)
	public String getInternalRequest() {
		return internalRequest;
	}

	public void setInternalRequest(String internalRequest) {
		this.internalRequest = internalRequest;
	}

	@Column(name="internal_response", length=5100)
	public String getInternalResponse() {
		return internalResponse;
	}

	public void setInternalResponse(String internalResponse) {
		this.internalResponse = internalResponse;
	}

	@Column(name="return_code", length=10)
	public String getReturnCode() {
		return returnCode;
	}

	public void setReturnCode(String returnCode) {
		this.returnCode = returnCode;
	}

	@Column(name="return_message", length=500)
	public String getReturnMessage() {
		return returnMessage;
	}

	public void setReturnMessage(String returnMessage) {
		this.returnMessage = returnMessage;
	}

	@Column(name="ws_client_beanname", length=20)
	public String getWsClientBeanName() {
		return wsClientBeanName;
	}

	public void setWsClientBeanName(String wsClientBeanName) {
		this.wsClientBeanName = wsClientBeanName;
	}
	
	@Column(name="next_invoke_time")
	public Date getNextInvokeTime() {
		return nextInvokeTime;
	}

	public void setNextInvokeTime(Date nextInvokeTime) {
		this.nextInvokeTime = nextInvokeTime;
	}

	@Column(name="status", length=20)
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Column(name="send_count", length=20)
	public int getSendCount() {
		return sendCount;
	}

	public void setSendCount(int sendCount) {
		this.sendCount = sendCount;
	}

	@Column(name ="internal_request_obj")
	public byte[] getInternalRequestObj() {
		return internalRequestObj;
	}

	public void setInternalRequestObj(byte[] internalRequestObj) {
		this.internalRequestObj = internalRequestObj;
	}
}
