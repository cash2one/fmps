package weixin.guanjia.message.entity;

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
 * 文本消息存储实体类
 * @author Administrator
 *
 */
@Entity
@Table(name="weixin_receive_message")
public class ReceiveText extends IdEntity {
	// 开发者微信号
    private String toUserName;
    // 发送方帐号（一个OpenID）
    private String FromUserName;
    // 消息创建时间 （整型）
    private Timestamp createTime;
    // 消息类型（text/image/location/link）
    private String MsgType;
    // 消息id，64位整型
    private String MsgId;
    //消息内容
    private String Content;
    //是否回复
    private String response;
    //回复内容
    private String rescontent;
    //用户昵称
    private String nickName;
    //微信账号Id
    private WeixinAccountEntity account; 
  
	//图片链接
    private String PicUrl ;
    //图片消息媒体ID
    private String MediaId;
    //语音格式，如amr，speex等
    private String Format ;
    //视频消息缩略图的媒体id
    private String ThumbMediaId ;
    //地理位置维度
    private String Location_X;
    //地理位置经度
    private String Location_Y;
    //地图缩放大小
    private String Scale;
    //地理位置信息
    private String Label;
    //消息标题(链接消息)
    private String Title ;
    //消息描述(链接消息)
    private String Description;
    //消息链接(链接消息)
    private String Url;
 
   
	@Column(name="tousername")
	public String getToUserName() {
		return toUserName;
	}
	public void setToUserName(String toUserName) {
		this.toUserName = toUserName;
	}
	
	@Column(name="fromusername")
	public String getFromUserName() {
		return FromUserName;
	}
	
	public void setFromUserName(String fromUserName) {
		FromUserName = fromUserName;
	}
	
	@Column(name="picurl")
	public String getPicUrl() {
		return PicUrl;
	}
	public void setPicUrl(String picUrl) {
		PicUrl = picUrl;
	}
	@Column(name="mediaid")
	public String getMediaId() {
		return MediaId;
	}
	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}
	@Column(name="format")
	public String getFormat() {
		return Format;
	}
	public void setFormat(String format) {
		Format = format;
	}
	@Column(name="thumbmediaid")
	public String getThumbMediaId() {
		return ThumbMediaId;
	}
	public void setThumbMediaId(String thumbMediaId) {
		ThumbMediaId = thumbMediaId;
	}
	@Column(name="location_x")
	public String getLocation_X() {
		return Location_X;
	}
	public void setLocation_X(String location_X) {
		Location_X = location_X;
	}
	@Column(name="location_y")
	public String getLocation_Y() {
		return Location_Y;
	}
	public void setLocation_Y(String location_Y) {
		Location_Y = location_Y;
	}
	@Column(name="scale")
	public String getScale() {
		return Scale;
	}
	public void setScale(String scale) {
		Scale = scale;
	}
	@Column(name="label")
	public String getLabel() {
		return Label;
	}
	public void setLabel(String label) {
		Label = label;
	}
	@Column(name="title")
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	@Column(name="description")
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	@Column(name="url")
	public String getUrl() {
		return Url;
	}
	public void setUrl(String url) {
		Url = url;
	}	
	@Column(name="msgtype")
	public String getMsgType() {
		return MsgType;
	}
	public void setMsgType(String msgType) {
		MsgType = msgType;
	}
	@Column(name="msgid")
	public String getMsgId() {
		return MsgId;
	}
	public void setMsgId(String msgId) {
		MsgId = msgId;
	}
	@Column(name="content")
	public String getContent() {
		return Content;
	}
	public void setContent(String content) {
		Content = content;
	}
	@Column(name="response")
	public String getResponse() {
		return response;
	}
	public void setResponse(String response) {
		this.response = response;
	}
	@Column(name="rescontent")
	public String getRescontent() {
		return rescontent;
	}
	public void setRescontent(String rescontent) {
		this.rescontent = rescontent;
	}
	@Column(name="createtime")
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	@Column(name="nickname")
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "accountId")
   public WeixinAccountEntity getAccount() {
			return account;
		}
	public void setAccount(WeixinAccountEntity account) {
			this.account = account;
		}
	
}
