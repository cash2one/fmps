/**
 * 
 */
package cn.com.fubon.fo.cashcoupon.entity;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 红包查询接口请求实体
 * 
 * @author qingqu.huang
 * @date 20150915
 */
@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class Hbinfo implements Serializable {

	@XmlElement
	private String appid;
	@XmlElement
	private String bill_type;
	@XmlElement
	private String mch_billno;
	@XmlElement
	private String mch_id;
	@XmlElement
	private String nonce_str;
	@XmlElement
	private String sign;

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getBill_type() {
		return bill_type;
	}

	public void setBill_type(String bill_type) {
		this.bill_type = bill_type;
	}

	public String getMch_billno() {
		return mch_billno;
	}

	public void setMch_billno(String mch_billno) {
		this.mch_billno = mch_billno;
	}

	public String getMch_id() {
		return mch_id;
	}

	public void setMch_id(String mch_id) {
		this.mch_id = mch_id;
	}

	public String getNonce_str() {
		return nonce_str;
	}

	public void setNonce_str(String nonce_str) {
		this.nonce_str = nonce_str;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}
}
