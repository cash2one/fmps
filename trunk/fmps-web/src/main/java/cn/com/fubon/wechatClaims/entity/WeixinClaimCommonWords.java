package cn.com.fubon.wechatClaims.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.jeecgframework.core.common.entity.IdEntity;

@Entity
@Table(name = "Weixin_Claim_Common_Words")
public class WeixinClaimCommonWords extends IdEntity {
	private String hsName;// 话术名称
	private String hsOrder;// 话术排序
	private WeixinClaimCommonWords uwords;// 父话术
	private List<WeixinClaimCommonWords> Uwordss = new ArrayList<WeixinClaimCommonWords>();

	@Column(name = "wordname")
	public String getHsName() {
		return hsName;
	}

	@Column(name = "wordorder")
	public String getHsOrder() {
		return hsOrder;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "parentwordid")
	public WeixinClaimCommonWords getUwords() {
		return uwords;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "uwords")
	public List<WeixinClaimCommonWords> getUwordss() {
		return Uwordss;
	}

	public void setHsName(String hsName) {
		this.hsName = hsName;
	}

	public void setHsOrder(String hsOrder) {
		this.hsOrder = hsOrder;
	}

	public void setUwords(WeixinClaimCommonWords uwords) {
		this.uwords = uwords;
	}

	public void setUwordss(List<WeixinClaimCommonWords> uwordss) {
		Uwordss = uwordss;
	}

}
