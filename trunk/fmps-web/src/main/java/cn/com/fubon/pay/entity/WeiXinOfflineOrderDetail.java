package cn.com.fubon.pay.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.apache.log4j.Logger;
import org.jeecgframework.core.common.entity.IdEntity;

import cn.com.fubon.pay.service.impl.OfflineWechatPayServiceImpl;

/**
 * 微信线下订单详细表 weixin_offline_order_detail
 * 
 * @author patrick.z 20141218
 *
 */
@Entity
@Table(name = "weixin_offline_order_detail")
@PrimaryKeyJoinColumn(name = "id")
public class WeiXinOfflineOrderDetail extends IdEntity implements Comparable{
	
	//标的项目信息
	private String itemname;
	// 险种名称
	private String kindName;
	// 保额
	private double amount;
	// 保费
	private String premium;
	// 不计免赔 0 否 1 是
	private String nonDeductible;

	// 险种类别 1：商业险，2：交强险，3：车船税，4：交通守护保险，5：非车险
	private int riskKind;
	
	private String riskname;	//保存险种类别详细内容
	//险种保费
	private String subpremium;	
	
	// 订单ID
	private WeiXinOfflineOrderInfo orderInfo;
	
	@Column(name = "itemname")
	public String getItemname() {
		return itemname;
	}

	public void setItemname(String itemname) {
		this.itemname = itemname;
	}

	@Column(name = "kindName")
	public String getKindName() {
		return kindName;
	}

	public void setKindName(String kindName) {
		this.kindName = kindName;
	}

	@Column(name = "amount")
	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Column(name = "premium")
	public String getPremium() {
		return premium;
	}

	public void setPremium(String premium) {
		this.premium = premium;
	}

	@Column(name = "nonDeductible")
	public String getNondeductible() {
		return nonDeductible;
	}

	public void setNondeductible(String nonDeductible) {
		this.nonDeductible = nonDeductible;
	}

	@Column(name = "riskKind")
	public int getRiskKind() {
		return riskKind;
	}

	public void setRiskKind(int riskKind) {
		this.riskKind = riskKind;
	}
	
	@ManyToOne
	@JoinColumn(name = "orderinfo_id")
	public WeiXinOfflineOrderInfo getOrderInfo() {
		return orderInfo;
	}

	public void setOrderInfo(WeiXinOfflineOrderInfo orderInfo) {
		this.orderInfo = orderInfo;
	}
	
	@Column(name = "riskname")
	public String getRiskname() {
		return riskname;
	}

	public void setRiskname(String riskname) {
		this.riskname = riskname;
	}
	@Column(name = "subpremium")
	public String getSubpremium() {
		return subpremium;
	}

	public void setSubpremium(String subpremium) {
		this.subpremium = subpremium;
	}

	private static final Logger logger = Logger
			.getLogger(OfflineWechatPayServiceImpl.class);
	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		WeiXinOfflineOrderDetail p = (WeiXinOfflineOrderDetail)o;
		logger.info("entity ,"+(this.riskKind - p.riskKind));
        int result =  this.riskKind - p.riskKind;// 升序排列，反之降序
        if(result==0)
        	result = this.riskKind;
         return result;
	}

}
