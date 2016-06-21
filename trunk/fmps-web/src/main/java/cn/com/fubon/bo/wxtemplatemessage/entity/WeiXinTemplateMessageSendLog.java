/**
 * 
 */
package cn.com.fubon.bo.wxtemplatemessage.entity;

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

/**
 * @author binbin.wang
 *
 */

@Entity
@Table(name = "weixin_template_message_send_log")
@PrimaryKeyJoinColumn(name = "id")
public class WeiXinTemplateMessageSendLog  extends IdEntity implements Serializable {

	private static final long serialVersionUID = -894247391713109351L;
	
	private String touser;
	
	private String messageId;
	
	//模板消息送达状态:success成功;failed:user block用户拒绝接收;failed: system failed发送失败（非用户拒绝）;-1:达到最大发送次数
	// 重新封装的微信模板消息送达状态 0：成功；1：用户拒绝接收；2：发送失败（非用户拒绝）；
	private Integer status;
		
	private WeiXinTemplateMessageRecord templateMessageRecord;
	
	private Date createTime;
	//模板消息接口调用返回码
	private String errCode;
	//模板消息接口调用返回消息
	private String errMsg;

	@Column(name = "errcode")
	public String getErrCode() {
		return errCode;
	}

	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}

	@Column(name = "errmsg")
	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

	@Column(name = "touser")
	public String getTouser() {
		return touser;
	}

	public void setTouser(String touser) {
		this.touser = touser;
	}

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="record_id")
	public WeiXinTemplateMessageRecord getTemplateMessageRecord() {
		return templateMessageRecord;
	}

	public void setTemplateMessageRecord(
			WeiXinTemplateMessageRecord templateMessageRecord) {
		this.templateMessageRecord = templateMessageRecord;
	}

	@Column(name = "create_time")
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Column(name = "message_id")
	public String getMessageId() {
		return messageId;
	}

	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}

	@Column(name = "status")
	public Integer getStatus(){
		return status;
	}

	public void setStatus(Integer status){
		this.status = status;
	}
}
