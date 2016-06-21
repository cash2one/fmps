package cn.com.fubon.fo.personalcenter.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.jeecgframework.core.common.entity.IdEntity;

import cn.com.fubon.fo.card.entity.Card;
import cn.com.fubon.fo.cashcoupon.entity.CashCoupon;
import cn.com.fubon.product.entity.Product;

@Entity
@Table(name = "weixin_policy_clause_reading")
@PrimaryKeyJoinColumn(name = "id")
public class WeixinPolicyClauseReading extends IdEntity implements Serializable {
 
	private String openid; //
	private String policyNo; //
	private int isAgree; //是否阅读（1、同意，空 或0 不同意）
	private CashCoupon cashcouponId; // 红包领取记录	 
	private Date createTime; //  创建时间
	
	
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public String getPolicyNo() {
		return policyNo;
	}
	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}
	public int getIsAgree() {
		return isAgree;
	}
	public void setIsAgree(int isAgree) {
		this.isAgree = isAgree;
	}
	
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name ="cashcouponId", nullable = true  )
	public CashCoupon getCashcouponId() {
		return cashcouponId;
	}
	public void setCashcouponId(CashCoupon cashcouponId) {
		this.cashcouponId = cashcouponId;
	}
	 
	
	
}
