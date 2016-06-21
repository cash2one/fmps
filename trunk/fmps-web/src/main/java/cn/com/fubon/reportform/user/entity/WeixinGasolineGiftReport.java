package cn.com.fubon.reportform.user.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.jeecgframework.core.common.entity.IdEntity;

/**
 * 加油宝报表
 * 
 * @author yaoming.zhang
 * @date 2015-10-27
 */
@Entity
@Table(name="weixin_gasolinegift_report")
public class WeixinGasolineGiftReport extends IdEntity{
	
	private static final long serialVersionUID = 423243379168136892L;
	
	//id
	private String id;
	//openid
	private String openid;
	//身份证号
	private String identifynumber;
	//客户名称
	private String customercname;
	//手机
	private String mobile;
	//车牌号
	private String licenseno;
	//机构名称
	private String comcname;
	//业务员工号
	private String handlercode;
	//业务员姓名
	private String handlername;
	//使用日期
	@Temporal(TemporalType.DATE)
	private Date applyTime;
	//加油宝券id
	private String giftid;
	//领取方式(0上门自取,1寄送)
	private String getWay;
	//快递寄送地址
	private String expressAddress;
	//上门自取地址
	private String pickupAddress;	
	private Integer channel;//渠道（1、富邦2、94频道）
	private Integer receiveWay;//领取方式（取领方式 邮寄10  渠道自取20）
	private Integer applyStatus; //申请状态05:待预充值支付 10:申请待处理（表示已支付）20:申请处理完成
	private String oilCardNo;//油卡卡号
	private Integer rchgDct;//充值返点例如3%
	private Integer payStatus;  //支付情况：1、完成支付、
	@Temporal(TemporalType.DATE)
	private Date rchgDctExpire; //优惠有效期	
	
	@Column(name="id")
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	@Column(name="openid")
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	
	@Column(name="identifynumber")
	public String getIdentifynumber() {
		return identifynumber;
	}
	public void setIdentifynumber(String identifynumber) {
		this.identifynumber = identifynumber;
	}
	
	@Column(name="customercname")
	public String getCustomercname() {
		return customercname;
	}
	public void setCustomercname(String customercname) {
		this.customercname = customercname;
	}
	
	@Column(name="mobile")
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	@Column(name="licenseno")
	public String getLicenseno() {
		return licenseno;
	}
	public void setLicenseno(String licenseno) {
		this.licenseno = licenseno;
	}
	
	@Column(name="comcname")
	public String getComcname() {
		return comcname;
	}
	public void setComcname(String comcname) {
		this.comcname = comcname;
	}
	
	@Column(name="handlercode")
	public String getHandlercode() {
		return handlercode;
	}
	public void setHandlercode(String handlercode) {
		this.handlercode = handlercode;
	}
	
	@Column(name="handlername")
	public String getHandlername() {
		return handlername;
	}
	public void setHandlername(String handlername) {
		this.handlername = handlername;
	}
	
	@Column(name="applyTime")
	public Date getApplyTime() {
		return applyTime;
	}
	public void setApplyTime(Date applyTime) {
		this.applyTime = applyTime;
	}
	
	@Column(name="giftid")
	public String getGiftid() {
		return giftid;
	}
	public void setGiftid(String giftid) {
		this.giftid = giftid;
	}
	
	@Column(name="getWay")
	public String getGetWay() {
		return getWay;
	}
	public void setGetWay(String getWay) {
		this.getWay = getWay;
	}
	
	@Column(name="expressAddress")
	public String getExpressAddress() {
		return expressAddress;
	}
	public void setExpressAddress(String expressAddress) {
		this.expressAddress = expressAddress;
	}
	
	@Column(name="pickupAddress")
	public String getPickupAddress() {
		return pickupAddress;
	}
	public void setPickupAddress(String pickupAddress) {
		this.pickupAddress = pickupAddress;
	}
	public Integer getChannel() {
		return channel;
	}
	public void setChannel(Integer channel) {
		this.channel = channel;
	}
	public Integer getReceiveWay() {
		return receiveWay;
	}
	public void setReceiveWay(Integer receiveWay) {
		this.receiveWay = receiveWay;
	}
	public Integer getApplyStatus() {
		return applyStatus;
	}
	public void setApplyStatus(Integer applyStatus) {
		this.applyStatus = applyStatus;
	}
	public String getOilCardNo() {
		return oilCardNo;
	}
	public void setOilCardNo(String oilCardNo) {
		this.oilCardNo = oilCardNo;
	}
	public Integer getRchgDct() {
		return rchgDct;
	}
	public void setRchgDct(Integer rchgDct) {
		this.rchgDct = rchgDct;
	}
	public Integer getPayStatus() {
		return payStatus;
	}
	public void setPayStatus(Integer payStatus) {
		this.payStatus = payStatus;
	}
	public Date getRchgDctExpire() {
		return rchgDctExpire;
	}
	public void setRchgDctExpire(Date rchgDctExpire) {
		this.rchgDctExpire = rchgDctExpire;
	}
	
	
}
