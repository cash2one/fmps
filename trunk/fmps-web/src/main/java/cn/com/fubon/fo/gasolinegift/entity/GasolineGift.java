package cn.com.fubon.fo.gasolinegift.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.jeecgframework.core.common.entity.IdEntity;

/**
 * 
 * @author fbxmn07
 *
 */
@Entity
@Table(name = "weixin_gasolinegift")
@PrimaryKeyJoinColumn(name = "id")
public class GasolineGift extends IdEntity implements Serializable {
	private String openid;
	private Date applyTime; // 申请时间
	private String giftid; // 加油宝券id
	private String mobile; // 手机号
	private String licenseno; // 车牌号
	private String address; // 客户详细地址
	private int getstatus; // 0上门领取,1寄送
	private String receiveAddress;	//领取地址
	private String username; // 用户姓名	
	private int channel; // 渠道（1、富邦2、94频道）'
	private int receiveWay; // 领取方式（取领方式 邮寄10  渠道自取20）
	private String orgCode; // 子机构编码
	private String applyId; // 申请流水号
	private String respCode; // 响应码	
	private String respMsg; // 应答信息
	private String applyStatus; // 申请状态05:待预充值支付 10:申请待处理（表示已支付）20:申请处理完成
	private String oilCardNo; // 油卡卡号
	private int rchgDct; // 充值返点例如3%
	private Date rchgDctExpire; // 优惠有效期	
	private int payStatus; // 支付情况：1、完成支付、
	private Date updateTime; // 更新时间	
	
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public Date getApplyTime() {
		return applyTime;
	}
	public void setApplyTime(Date applyTime) {
		this.applyTime = applyTime;
	}
	public String getGiftid() {
		return giftid;
	}
	public void setGiftid(String giftid) {
		this.giftid = giftid;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getLicenseno() {
		return licenseno;
	}
	public void setLicenseno(String licenseno) {
		this.licenseno = licenseno;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getGetstatus() {
		return getstatus;
	}
	public void setGetstatus(int getstatus) {
		this.getstatus = getstatus;
	}
	public String getReceiveAddress() {
		return receiveAddress;
	}
	public void setReceiveAddress(String receiveAddress) {
		this.receiveAddress = receiveAddress;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getChannel() {
		return channel;
	}
	public void setChannel(int channel) {
		this.channel = channel;
	}
	public int getReceiveWay() {
		return receiveWay;
	}
	public void setReceiveWay(int receiveWay) {
		this.receiveWay = receiveWay;
	}
	public String getOrgCode() {
		return orgCode;
	}
	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}
	public String getApplyId() {
		return applyId;
	}
	public void setApplyId(String applyId) {
		this.applyId = applyId;
	}
	public String getRespCode() {
		return respCode;
	}
	public void setRespCode(String respCode) {
		this.respCode = respCode;
	}
	public String getRespMsg() {
		return respMsg;
	}
	public void setRespMsg(String respMsg) {
		this.respMsg = respMsg;
	}
	public String getApplyStatus() {
		return applyStatus;
	}
	public void setApplyStatus(String applyStatus) {
		this.applyStatus = applyStatus;
	}
	public String getOilCardNo() {
		return oilCardNo;
	}
	public void setOilCardNo(String oilCardNo) {
		this.oilCardNo = oilCardNo;
	}
	public int getRchgDct() {
		return rchgDct;
	}
	public void setRchgDct(int rchgDct) {
		this.rchgDct = rchgDct;
	}
	public Date getRchgDctExpire() {
		return rchgDctExpire;
	}
	public void setRchgDctExpire(Date rchgDctExpire) {
		this.rchgDctExpire = rchgDctExpire;
	}
	public int getPayStatus() {
		return payStatus;
	}
	public void setPayStatus(int payStatus) {
		this.payStatus = payStatus;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	 	
}
