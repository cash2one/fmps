/**
 * 
 */
package cn.com.fubon.fo.cashcoupon.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.jeecgframework.core.common.entity.IdEntity;

/**
 * @author fbxmn06
 *
 */
@Entity
@Table(name = "weixin_cashcoupon")
@PrimaryKeyJoinColumn(name = "id")
public class CashCoupon extends IdEntity implements Serializable {

	private double amount;
	private String huodongid;
	private int seqid;
	private String openid;
	private String externalSerialNo;
	private Date receivetime;
	private String ip;
	
	public int getSeqid() {
		return seqid;
	}

	public void setSeqid(int seqid) {
		this.seqid = seqid;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getHuodongid() {
		return huodongid;
	}

	public void setHuodongid(String huodongid) {
		this.huodongid = huodongid;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}
	
	public String getExternalSerialNo() {
		return externalSerialNo;
	}

	public void setExternalSerialNo(String externalSerialNo) {
		this.externalSerialNo = externalSerialNo;
	}

	public Date getReceivetime() {
		return receivetime;
	}

	public void setReceivetime(Date receivetime) {
		this.receivetime = receivetime;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}
	
	
}
