package cn.com.fubon.transaction.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.jeecgframework.core.common.entity.IdEntity;

import weixin.guanjia.account.entity.WeixinAccountEntity;

/**
 * 报文实体类
 * 
 * @author shanqi.wang
 *
 */

@Entity
@Table(name = "weixin_transaction_record")
public class TransactionRecord extends IdEntity implements Serializable {

	// 报文id
	private String transactionId;
	// 发送方帐号
	private String fromuser;
	// 接收方账户
	private String touser;
	// 交易格式 XML、json、text等
	private String transactionFormat;
	// 交易类型（账户绑定、解绑、照片上传,文本等）
	private String transactionType;
	// 消息创建时间
	private Timestamp createTime;
	// 消息接收时间
	private Timestamp reqDateTime;
	// 消息处理完成时间
	private Timestamp respDateTime;
	// 微信账户ID
	private WeixinAccountEntity account;

	private String internalRequest; // '请求内部内容',
	private String externalRequest; // '请求外部内容',
	private String internalResponse; // '回复内部内容',
	private String externalResponse; // '回复外部内容',	
	private String signature; //报文签名

	@Column(name = "transaction_id")
	public String getTransactionId() {
		return this.transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	@Column(name = "fromuser")
	public String getFromuser() {
		return this.fromuser;
	}

	public void setFromuser(String fromuser) {
		this.fromuser = fromuser;
	}

	@Column(name = "touser")
	public String getTouser() {
		return this.touser;
	}

	public void setTouser(String touser) {
		this.touser = touser;
	}

	@Column(name = "transaction_format")
	public String getTransactionFormat() {
		return this.transactionFormat;
	}

	public void setTransactionFormat(String transactionFormat) {
		this.transactionFormat = transactionFormat;
	}

	@Column(name = "transaction_type")
	public String getTransactionType() {
		return this.transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	@Column(name = "createtime")
	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "accountid")
	public WeixinAccountEntity getAccount() {
		return account;
	}

	public void setAccount(WeixinAccountEntity account) {
		this.account = account;
	}

	@Column(name = "internalRequest")
	public String getInternalRequest() {
		return internalRequest;
	}

	public void setInternalRequest(String internalRequest) {
		this.internalRequest = internalRequest;
	}

	@Column(name = "externalRequest")
	public String getExternalRequest() {
		return externalRequest;
	}

	public void setExternalRequest(String externalRequest) {
		this.externalRequest = externalRequest;
	}

	@Column(name = "internalResponse")
	public String getInternalResponse() {
		return internalResponse;
	}

	public void setInternalResponse(String internalResponse) {
		this.internalResponse = internalResponse;
	}

	@Column(name = "externalResponse")
	public String getExternalResponse() {
		return externalResponse;
	}

	public void setExternalResponse(String externalResponse) {
		this.externalResponse = externalResponse;
	}
	@Column(name = "reqDateTime")
	public Timestamp getReqDateTime() {
		return reqDateTime;
	}

	public void setReqDateTime(Timestamp reqDateTime) {
		this.reqDateTime = reqDateTime;
	}
	@Column(name = "respDateTime")
	public Timestamp getRespDateTime() {
		return respDateTime;
	}

	public void setRespDateTime(Timestamp respDateTime) {
		this.respDateTime = respDateTime;
	}
	@Column(name = "signature")
	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}
	

}
