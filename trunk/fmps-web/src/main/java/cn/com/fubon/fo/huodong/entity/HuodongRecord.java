/**
 * 
 */
package cn.com.fubon.fo.huodong.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.jeecgframework.core.common.entity.IdEntity;

/**
 * @author qingqu.huang
 *
 */
@Entity
@Table(name = "weixin_huodong_record")
@PrimaryKeyJoinColumn(name = "id")
public class HuodongRecord extends IdEntity implements Serializable {

	private String sponsor; // 发起人
	private String openid; // 帮抢人openid
	private Date createdate; // 帮抢日期
	private String huodongid;
	private String phonenum;
	private Date starttime;		//领取结束时间
	private Date endtime;		//领取结束时间
	private double amount;		//金额
	private String cashcouponid;	//初始表ID
	private int status;  	//领取状态：1成功，0失败
	private String customercname;//客户名称
	private String identifynumber;	//证件号码
	private String ip;	//ip地址
	
	
	

	public String getPhonenum() {
		return phonenum;
	}

	public void setPhonenum(String phonenum) {
		this.phonenum = phonenum;
	}

	/**
	 * @return the huodongid
	 */
	public String getHuodongid() {
		return huodongid;
	}

	/**
	 * @param huodongid the huodongid to set
	 */
	public void setHuodongid(String huodongid) {
		this.huodongid = huodongid;
	}

	/**
	 * @return the sponsor
	 */
	public String getSponsor() {
		return sponsor;
	}

	/**
	 * @param sponsor
	 *            the sponsor to set
	 */
	public void setSponsor(String sponsor) {
		this.sponsor = sponsor;
	}

	/**
	 * @return the openid
	 */
	public String getOpenid() {
		return openid;
	}

	/**
	 * @param openid
	 *            the openid to set
	 */
	public void setOpenid(String openid) {
		this.openid = openid;
	}

	/**
	 * @return the createdate
	 */
	public Date getCreatedate() {
		return createdate;
	}

	/**
	 * @param createdate
	 *            the createdate to set
	 */
	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	public Date getStarttime() {
		return starttime;
	}

	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}

	public Date getEndtime() {
		return endtime;
	}

	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getCashcouponid() {
		return cashcouponid;
	}

	public void setCashcouponid(String cashcouponid) {
		this.cashcouponid = cashcouponid;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getCustomercname() {
		return customercname;
	}

	public void setCustomercname(String customercname) {
		this.customercname = customercname;
	}

	public String getIdentifynumber() {
		return identifynumber;
	}

	public void setIdentifynumber(String identifynumber) {
		this.identifynumber = identifynumber;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}
	
}
