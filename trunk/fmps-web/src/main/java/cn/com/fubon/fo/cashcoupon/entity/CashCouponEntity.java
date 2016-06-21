/**
 * 
 */
package cn.com.fubon.fo.cashcoupon.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.jeecgframework.core.common.entity.IdEntity;

import com.thoughtworks.xstream.annotations.XStreamOmitField;

import weixin.popular.bean.AdaptorCDATA;

/**
 * 现金红包实体类
 * 
 * @author qingqu.huang
 *
 */
@Entity
@Table(name = "weixin_cashcouponhistory")
@PrimaryKeyJoinColumn(name = "id")
@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class CashCouponEntity extends IdEntity implements java.io.Serializable {

	@XmlElement
	@XmlJavaTypeAdapter(value = AdaptorCDATA.class)
	private String act_name;
	@XmlElement
	private String client_ip;
	@XmlElement
	private String logo_imgurl;
	@XmlElement
	private int max_value;
	@XmlElement
	private String mch_billno;
	@XmlElement
	private String mch_id;
	@XmlElement
	private int min_value;
	@XmlElement
	@XmlJavaTypeAdapter(value = AdaptorCDATA.class)
	private String nick_name;
	@XmlElement
	private String nonce_str;
	@XmlElement
	private String re_openid;
	@XmlElement
	@XmlJavaTypeAdapter(value = AdaptorCDATA.class)
	private String remark;
	@XmlElement
	@XmlJavaTypeAdapter(value = AdaptorCDATA.class)
	private String send_name;
	@XmlElement
	private int total_amount;
	@XmlElement
	private int total_num;
	@XmlElement
	@XmlJavaTypeAdapter(value = AdaptorCDATA.class)
	private String wishing;
	@XmlElement
	private String wxappid;
	@XmlElement
	@XmlJavaTypeAdapter(value = AdaptorCDATA.class)
	private String sign;

	@XStreamOmitField
	private String status; // 发放状态
	@XStreamOmitField
	private Date rltime; // 发放时间
	@XStreamOmitField
	private String huodongid;// 活动编号
	@XStreamOmitField
	private String fromtag; // 来源
	@XStreamOmitField
	private String cashcouponid;// 红包编号

	public String getCashcouponid() {
		return cashcouponid;
	}

	public void setCashcouponid(String cashcouponid) {
		this.cashcouponid = cashcouponid;
	}

	public String getFromtag() {
		return fromtag;
	}

	public void setFromtag(String fromtag) {
		this.fromtag = fromtag;
	}

	public String getHuodongid() {
		return huodongid;
	}

	public void setHuodongid(String huodongid) {
		this.huodongid = huodongid;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getRltime() {
		return rltime;
	}

	public void setRltime(Date rltime) {
		this.rltime = rltime;
	}

	/**
	 * @return the nonce_str
	 */
	public String getNonce_str() {
		return nonce_str;
	}

	/**
	 * @param nonce_str
	 *            the nonce_str to set
	 */
	public void setNonce_str(String nonce_str) {
		this.nonce_str = nonce_str;
	}

	/**
	 * @return the sign
	 */
	public String getSign() {
		return sign;
	}

	/**
	 * @param sign
	 *            the sign to set
	 */
	public void setSign(String sign) {
		this.sign = sign;
	}

	/**
	 * @return the mch_billno
	 */
	public String getMch_billno() {
		return mch_billno;
	}

	/**
	 * @param mch_billno
	 *            the mch_billno to set
	 */
	public void setMch_billno(String mch_billno) {
		this.mch_billno = mch_billno;
	}

	/**
	 * @return the mch_id
	 */
	@Transient
	public String getMch_id() {
		return mch_id;
	}

	/**
	 * @param mch_id
	 *            the mch_id to set
	 */
	public void setMch_id(String mch_id) {
		this.mch_id = mch_id;
	}

	/**
	 * @return the wxappid
	 */
	@Transient
	public String getWxappid() {
		return wxappid;
	}

	/**
	 * @param wxappid
	 *            the wxappid to set
	 */
	public void setWxappid(String wxappid) {
		this.wxappid = wxappid;
	}

	/**
	 * @return the nick_name
	 */
	@Transient
	public String getNick_name() {
		return nick_name;
	}

	/**
	 * @param nick_name
	 *            the nick_name to set
	 */
	public void setNick_name(String nick_name) {
		this.nick_name = nick_name;
	}

	/**
	 * @return the send_name
	 */
	@Transient
	public String getSend_name() {
		return send_name;
	}

	/**
	 * @param send_name
	 *            the send_name to set
	 */
	public void setSend_name(String send_name) {
		this.send_name = send_name;
	}

	/**
	 * @return the re_openid
	 */
	public String getRe_openid() {
		return re_openid;
	}

	/**
	 * @param re_openid
	 *            the re_openid to set
	 */
	public void setRe_openid(String re_openid) {
		this.re_openid = re_openid;
	}

	/**
	 * @return the total_amount
	 */
	public int getTotal_amount() {
		return total_amount;
	}

	/**
	 * @param total_amount
	 *            the total_amount to set
	 */
	public void setTotal_amount(int total_amount) {
		this.total_amount = total_amount;
	}

	/**
	 * @return the min_value
	 */
	public int getMin_value() {
		return min_value;
	}

	/**
	 * @param min_value
	 *            the min_value to set
	 */
	public void setMin_value(int min_value) {
		this.min_value = min_value;
	}

	/**
	 * @return the max_value
	 */
	public int getMax_value() {
		return max_value;
	}

	/**
	 * @param max_value
	 *            the max_value to set
	 */
	public void setMax_value(int max_value) {
		this.max_value = max_value;
	}

	/**
	 * @return the total_num
	 */
	public int getTotal_num() {
		return total_num;
	}

	/**
	 * @param total_num
	 *            the total_num to set
	 */
	public void setTotal_num(int total_num) {
		this.total_num = total_num;
	}

	/**
	 * @return the wishing
	 */
	@Transient
	public String getWishing() {
		return wishing;
	}

	/**
	 * @param wishing
	 *            the wishing to set
	 */
	public void setWishing(String wishing) {
		this.wishing = wishing;
	}

	/**
	 * @return the client_ip
	 */
	public String getClient_ip() {
		return client_ip;
	}

	/**
	 * @param client_ip
	 *            the client_ip to set
	 */
	public void setClient_ip(String client_ip) {
		this.client_ip = client_ip;
	}

	/**
	 * @return the act_name
	 */
	@Transient
	public String getAct_name() {
		return act_name;
	}

	/**
	 * @param act_name
	 *            the act_name to set
	 */
	public void setAct_name(String act_name) {
		this.act_name = act_name;
	}

	/**
	 * @return the remark
	 */
	@Transient
	public String getRemark() {
		return remark;
	}

	/**
	 * @param remark
	 *            the remark to set
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

	/**
	 * @return the logo_imgurl
	 */
	@Transient
	public String getLogo_imgurl() {
		return logo_imgurl;
	}

	/**
	 * @param logo_imgurl
	 *            the logo_imgurl to set
	 */
	public void setLogo_imgurl(String logo_imgurl) {
		this.logo_imgurl = logo_imgurl;
	}

}
