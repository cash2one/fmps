package weixin.popular.bean.paymch;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import weixin.popular.bean.AdaptorCDATA;

@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class MchBaseResult {
	@XmlElement
	@XmlJavaTypeAdapter(value = AdaptorCDATA.class)
	protected String return_code;
	@XmlElement
	@XmlJavaTypeAdapter(value = AdaptorCDATA.class)
	protected String return_msg;
	@XmlElement
	@XmlJavaTypeAdapter(value = AdaptorCDATA.class)
	protected String appid;
	@XmlElement
	@XmlJavaTypeAdapter(value = AdaptorCDATA.class)
	protected String mch_id;
	@XmlElement
	@XmlJavaTypeAdapter(value = AdaptorCDATA.class)
	protected String nonce_str;
	@XmlElement
	@XmlJavaTypeAdapter(value = AdaptorCDATA.class)
	protected String sign;
	@XmlElement
	@XmlJavaTypeAdapter(value = AdaptorCDATA.class)
	protected String result_code;
	@XmlElement
	@XmlJavaTypeAdapter(value = AdaptorCDATA.class)
	protected String err_code;
	@XmlElement
	@XmlJavaTypeAdapter(value = AdaptorCDATA.class)
	protected String err_code_des;

	public String getReturn_code() {
		return return_code;
	}

	public void setReturn_code(String return_code) {
		this.return_code = return_code;
	}

	public String getReturn_msg() {
		return return_msg;
	}

	public void setReturn_msg(String return_msg) {
		this.return_msg = return_msg;
	}

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
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

	public String getResult_code() {
		return result_code;
	}

	public void setResult_code(String result_code) {
		this.result_code = result_code;
	}

	public String getErr_code() {
		return err_code;
	}

	public void setErr_code(String err_code) {
		this.err_code = err_code;
	}

	public String getErr_code_des() {
		return err_code_des;
	}

	public void setErr_code_des(String err_code_des) {
		this.err_code_des = err_code_des;
	}

}
