package cn.com.fubon.fo.event.entity;

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
 * 客户地理位置事件记录类
 * @author shanqi.wang
 *
 */

@Entity
@Table(name = "weixin_event_location")
@PrimaryKeyJoinColumn(name = "id")
public class CustomerLocationEvent extends IdEntity implements Serializable {
	
	private WeixinAccountEntity accountid;		    //商铺ID 	
	private String fromUserName;			        //发送方帐号（一个OpenID）
	private String toUserName;					    //开发者微信号	
	private Date createTime;					    //消息创建时间	
	private String msgType;							//消息类型，event
	private String event;							//事件类型，LOCATION
	private String latitude;				    	//地理位置纬度
	private String longitude;						//地理位置经度
	private String precision;						//地理位置精度
	
	@Column(name="FromUserName")
	public String getFromUserName() {
		return fromUserName;
	}
	public void setFromUserName(String fromUserName) {
		this.fromUserName = fromUserName;
	}
	@Column(name="ToUserName")
	public String getToUserName() {
		return toUserName;
	}
	public void setToUserName(String toUserName) {
		this.toUserName = toUserName;
	}
	@Column(name="CreateTime")
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	@Column(name="MsgType")
	public String getMsgType() {
		return msgType;
	}
	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}
	@Column(name="`Event`")
	public String getEvent() {
		return event;
	}
	public void setEvent(String event) {
		this.event = event;
	}
	@Column(name="Latitude")
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	@Column(name="Longitude")
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	@Column(name="`Precision`")
	public String getPrecision() {
		return precision;
	}
	public void setPrecision(String precision) {
		this.precision = precision;
	}
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "accountid")
	public WeixinAccountEntity getAccountid() {
		return accountid;
	}
	public void setAccountid(WeixinAccountEntity accountid) {
		this.accountid = accountid;
	}

}
