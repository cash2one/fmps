/**
 * 
 */
package cn.com.fubon.fo.customermessage.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.jeecgframework.core.common.entity.IdEntity;

import weixin.guanjia.account.entity.WeixinAccountEntity;

/**
 * 客服消息发送日志表
 * 
 * @author binbin.wang
 *
 */

@Entity
@Table(name = "weixin_customer_message_send_log")
@PrimaryKeyJoinColumn(name = "id")
public class CustomerMessageSendLog extends IdEntity implements Serializable {

	private String touser;
	private String msgtype;		
	private Date createTime;
	private Integer returnCode;
	private String returnMsg;
	
	private CustomerMessageRecord customerMessageRecord;

	@Column(name = "touser", length = 36)
	public String getTouser() {
		return touser;
	}
	
	public void setTouser(String touser) {
		this.touser = touser;
	}
	
	@Column(name = "msgtype", length = 100)
	public String getMsgtype() {
		return this.msgtype;
	}

	public void setMsgtype(String msgtype) {
		this.msgtype = msgtype;
	}
	
	@Column(name = "create_time", length = 10)
	public Date getCreateTime() {
		return createTime;
	}
	
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Column(name = "return_code", length = 10)
	public Integer getReturnCode() {
		return returnCode;
	}

	public void setReturnCode(Integer returnCode) {
		this.returnCode = returnCode;
	}

	@Column(name = "return_msg", length = 200)
	public String getReturnMsg() {
		return returnMsg;
	}
	
	public void setReturnMsg(String returnMsg) {
		this.returnMsg = returnMsg;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "message_id")
	public CustomerMessageRecord getCustomerMessageRecord() {
		return customerMessageRecord;
	}
	
	public void setCustomerMessageRecord(
			CustomerMessageRecord customerMessageRecord) {
		this.customerMessageRecord = customerMessageRecord;
	}

	
}
