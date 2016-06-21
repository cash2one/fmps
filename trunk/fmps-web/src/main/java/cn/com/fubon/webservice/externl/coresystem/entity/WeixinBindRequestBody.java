package cn.com.fubon.webservice.externl.coresystem.entity;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 认证接口外部request
 * @author fangfang.guo
 *
 */
public class WeixinBindRequestBody{
	
	@XStreamAlias("insuredCode")
	private String insuredCode;
	
	@XStreamAlias("openId")
	private String openid;
	
	@XStreamAlias("nickName")
	private String nickName;
	
	@XStreamAlias("telephone")
	private String telephone;
	
	public String getInsuredCode() {
		return insuredCode;
	}
	public void setInsuredCode(String insuredCode) {
		this.insuredCode = insuredCode;
	}

	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	
}
