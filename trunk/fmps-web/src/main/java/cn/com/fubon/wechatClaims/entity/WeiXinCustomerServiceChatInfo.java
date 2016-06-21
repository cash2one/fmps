package cn.com.fubon.wechatClaims.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.jeecgframework.core.common.entity.IdEntity;

/**
 * 客服聊天信息表 weixin_customer_service_chatinfo
 * 
 * @author patrick.z 20150126
 *
 */

@Entity
@Table(name = "weixin_customer_service_chatinfo")
@PrimaryKeyJoinColumn(name = "id")
public class WeiXinCustomerServiceChatInfo extends IdEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// 客服工号
	private String operatorCode;
	// 消息内容
	private String content;
	// 文件路径
	private String filepath;
	// 消息类型
	private String msgtype;
	// 添加时间
	@Temporal(TemporalType.TIMESTAMP)
	private Date createTime;

	@Column(name = "operatorcode")
	public String getOperatorCode() {
		return operatorCode;
	}

	public void setOperatorCode(String operatorCode) {
		this.operatorCode = operatorCode;
	}

	@Column(name = "content")
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "filepath")
	public String getFilepath() {
		return filepath;
	}

	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}

	@Column(name = "msgtype")
	public String getMsgtype() {
		return msgtype;
	}

	public void setMsgtype(String msgtype) {
		this.msgtype = msgtype;
	}

	@Column(name = "createTime")
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}
