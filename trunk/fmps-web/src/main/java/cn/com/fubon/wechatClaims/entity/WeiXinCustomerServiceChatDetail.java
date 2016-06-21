package cn.com.fubon.wechatClaims.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.jeecgframework.core.common.entity.IdEntity;

import weixin.guanjia.message.entity.ReceiveMessage;

/**
 * 聊天记录映射表 weixin_customer_service_chat_map
 * 
 * @author patrick.z 20150126
 *
 */

@Entity
@Table(name = "weixin_customer_service_chat_map")
@PrimaryKeyJoinColumn(name = "id")
public class WeiXinCustomerServiceChatDetail extends IdEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// 报案号
	private String claimRegistNo;
	// 消息来源 0：客服 1：客户
	private int messageSource;
	// 客户信息是否读取 0：未读 1：已读
	private int isMessageReaded;
	// 添加时间
	@Temporal(TemporalType.TIMESTAMP)
	private Date createTime;

	// 微信消息存储id
	private String messageId;

	// 聊天记录表id
	private String customerServiceId;
	@Column(name = "message_id")
	public String getMessageId() {
		return messageId;
	}

	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}
	@Column(name = "customer_service_id")
	public String getCustomerServiceId() {
		return customerServiceId;
	}

	public void setCustomerServiceId(String customerServiceId) {
		this.customerServiceId = customerServiceId;
	}

	//客户聊天信息表
	private WeiXinCustomerServiceChatInfo weiXinCusomerServiceChatInfo;

	// 微信信息存储表
	private ReceiveMessage receiveMessage;

	@Column(name = "claim_registno")
	public String getClaimRegistNo() {
		return claimRegistNo;
	}

	public void setClaimRegistNo(String claimRegistNo) {
		this.claimRegistNo = claimRegistNo;
	}

	@Column(name = "message_source")
	public int getMessageSource() {
		return messageSource;
	}

	public void setMessageSource(int messageSource) {
		this.messageSource = messageSource;
	}

	@Column(name = "message_readed")
	public int getIsMessageReaded() {
		return isMessageReaded;
	}

	public void setIsMessageReaded(int isMessageReaded) {
		this.isMessageReaded = isMessageReaded;
	}

	@Column(name = "createtime")
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Transient//设置为不能持久化
	public WeiXinCustomerServiceChatInfo getWeiXinCusomerServiceChatInfo() {
		return weiXinCusomerServiceChatInfo;
	}

	public void setWeiXinCusomerServiceChatInfo(
			WeiXinCustomerServiceChatInfo weiXinCusomerServiceChatInfo) {
		this.weiXinCusomerServiceChatInfo = weiXinCusomerServiceChatInfo;
	}

	@Transient
	public ReceiveMessage getReceiveMessage() {
		return receiveMessage;
	}

	public void setReceiveMessage(ReceiveMessage receiveMessage) {
		this.receiveMessage = receiveMessage;
	}
}
