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
 * 客服消息记录表
 * 
 * @author binbin.wang
 *
 */
@Entity
@Table(name = "weixin_customer_message_record")
@PrimaryKeyJoinColumn(name = "id")
public class CustomerMessageRecord extends IdEntity implements Serializable {

	private String touser;								//接收客服消息的客户，openid
	private String msgtype;					//消息类型
	private String content;								//消息内容
	private String mediaId;							//多媒体ID
	private String thumbMediaId;					//缩略图媒体ID
	private String title;									//多媒体元素的标题
	private String description;						//多媒体元素的描述
	private String musicurl;							//音乐链接
	private String hqmusicurl;						//高清音乐链接
	private Integer status;								//该消息发送的状态	
	private Date createTime;							//消息创建时间
	private WeixinAccountEntity account;		//商铺ID 

	@Column(name = "touser", length = 36)
	public String getTouser() {
		return touser;
	}
	public void setTouser(String touser) {
		this.touser = touser;
	}
	
	@Column(name = "msgtype", length = 20)
	public String getMsgtype() {
		return msgtype;
	}
	public void setMsgtype(String msgtype) {
		this.msgtype = msgtype;
	}
	
	@Column(name = "content", length = 1000)
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	@Column(name = "media_id", length = 50)
	public String getMediaId() {
		return mediaId;
	}
	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}
	
	@Column(name = "thumb_media_id", length = 50)
	public String getThumbMediaId() {
		return thumbMediaId;
	}
	public void setThumbMediaId(String thumbMediaId) {
		this.thumbMediaId = thumbMediaId;
	}
	
	@Column(name = "title", length = 100)
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	@Column(name = "description", length = 200)
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Column(name = "musicurl", length = 200)
	public String getMusicurl() {
		return musicurl;
	}
	public void setMusicurl(String musicurl) {
		this.musicurl = musicurl;
	}
	
	@Column(name = "hqmusicurl", length = 200)
	public String getHqmusicurl() {
		return hqmusicurl;
	}
	public void setHqmusicurl(String hqmusicurl) {
		this.hqmusicurl = hqmusicurl;
	}
	
	@Column(name = "status", length = 3)
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	@Column(name = "create_time")
	public Date getCreateTime() {
		return createTime;
	}
	
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
		
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "account_id")
	public WeixinAccountEntity getAccount() {
		return account;
	}

	public void setAccount(WeixinAccountEntity account) {
		this.account = account;
	}
}
