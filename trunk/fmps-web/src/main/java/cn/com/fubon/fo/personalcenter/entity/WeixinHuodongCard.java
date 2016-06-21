package cn.com.fubon.fo.personalcenter.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.jeecgframework.core.common.entity.IdEntity;

import cn.com.fubon.fo.card.entity.Card;
import cn.com.fubon.product.entity.Product;

@Entity
@Table(name = "weixin_huodong_card")
@PrimaryKeyJoinColumn(name = "id")
public class WeixinHuodongCard extends IdEntity implements Serializable {

	private Card cardinfoid; //
	private String cardno; //
	private String huodongid; //
	private String openid; //
	private String password; //
	private Product productid; //
	private Timestamp receivetime; //

	private Timestamp validtime; //

	/*
	 * @ManyToOne(fetch = FetchType.LAZY)
	 * 
	 * @JoinColumn(name = "cardinfoid", nullable = true) public Card
	 * getCardinfoid() { return cardinfoid; }
	 */
	@ManyToOne(targetEntity = Card.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "cardno", insertable = false, updatable = false, referencedColumnName = "card_no")
	public Card getCardinfoid() {
		return cardinfoid;
	}

	@Column(name = "cardno")
	public String getCardno() {
		return cardno;
	}

	@Column(name = "huodongid")
	public String getHuodongid() {
		return huodongid;
	}

	@Column(name = "openid")
	public String getOpenid() {
		return openid;
	}

	@Column(name = "password")
	public String getPassword() {
		return password;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "productid", nullable = true)
	public Product getProductid() {
		return productid;
	}

	@Column(name = "receivetime")
	public Timestamp getReceivetime() {
		return receivetime;
	}

	@Column(name = "validtime")
	public Timestamp getValidtime() {
		return validtime;
	}

	public void setCardinfoid(Card cardinfoid) {
		this.cardinfoid = cardinfoid;
	}

	/*
	 * public void setCardinfoid(Card cardinfoid) { this.cardinfoid =
	 * cardinfoid; }
	 */
	public void setCardno(String cardno) {
		this.cardno = cardno;
	}

	public void setHuodongid(String huodongid) {
		this.huodongid = huodongid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setProductid(Product productid) {
		this.productid = productid;
	}

	public void setReceivetime(Timestamp receivetime) {
		this.receivetime = receivetime;
	}

	public void setValidtime(Timestamp validtime) {
		this.validtime = validtime;
	}

}
