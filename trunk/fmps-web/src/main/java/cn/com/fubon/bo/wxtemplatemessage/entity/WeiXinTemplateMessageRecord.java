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
import weixin.guanjia.account.entity.WeixinAccountEntity;

/**
 * @author binbin.wang
 *
 */

@Entity
@Table(name = "weixin_template_mesasge_record")
@PrimaryKeyJoinColumn(name = "id")
public class WeiXinTemplateMessageRecord  extends IdEntity implements Serializable {

	private static final long serialVersionUID = 3850799957104972219L;
	
	private String touser;
	private String messageContent;
	private WeiXinTemplate template;
	// 重新封装的微信模板消息送达状态 0：成功；1：用户拒绝接收；2：发送失败（非用户拒绝）；
	private Integer status;
	private WeixinAccountEntity account;
	private Date createTime;
	//模板消息接口调用返回码
	private String errCode;
	//模板消息接口调用返回消息
	private String errMsg;
	//定时任务重发时间
	private Date nextInvokeTime;
	//已发送次数
	private Integer sendCount;
	
	@Column(name="errcode")
	public String getErrCode() {
		return errCode;
	}

	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}

	@Column(name="errmsg")
	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

	@Column(name="next_invoke_time")
	public Date getNextInvokeTime() {
		return nextInvokeTime;
	}

	public void setNextInvokeTime(Date nextInvokeTime) {
		this.nextInvokeTime = nextInvokeTime;
	}

	@Column(name="send_count")
	public Integer getSendCount() {
		return sendCount;
	}

	public void setSendCount(Integer sendCount) {
		this.sendCount = sendCount;
	}

	@Column(name="touser", length=36)
	public String getTouser() {
		return touser;
	}
	
	public void setTouser(String touser) {
		this.touser = touser;
	}
	
	@Column(name="message_content", length=1000)
	public String getMessageContent() {
		return messageContent;
	}
	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "weixin_template_id")
	public WeiXinTemplate getTemplate() {
		return template;
	}
	public void setTemplate(WeiXinTemplate template) {
		this.template = template;
	}
	
	@Column(name="status")
	public Integer getStatus(){
		return status;
	}

	public void setStatus(Integer status){
		this.status = status;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "account_id")
	public WeixinAccountEntity getAccount() {
		return account;
	}
	public void setAccount(WeixinAccountEntity account) {
		this.account = account;
	}
	
	@Column(name="create_time")
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
}
