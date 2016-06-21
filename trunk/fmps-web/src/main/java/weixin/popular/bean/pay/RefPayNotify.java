package weixin.popular.bean.pay;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 微信支付后台通用通知接口返回数据
 * @author  
 *
 */
 @XmlRootElement(name="xml")
 @XmlAccessorType(XmlAccessType.FIELD)
public class RefPayNotify {
	
	private String return_code;	//SUCCESS/FAIL SUCCESS 表示商户接收通知	成功并校验成功
	private String return_msg; //返回信息，如非空，为错误	原因	签名失败参数格式校验错误
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

	
}
