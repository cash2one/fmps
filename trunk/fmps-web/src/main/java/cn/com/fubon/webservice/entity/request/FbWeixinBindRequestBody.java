package cn.com.fubon.webservice.entity.request;

import com.thoughtworks.xstream.annotations.XStreamAlias;


/**
 * 用户绑定核心接口用到的内部RequestBody
 * @author fangfang.guo
 *
 */
public class FbWeixinBindRequestBody extends RequestBody{
	@XStreamAlias("INSUREDCODE")
	private String insuredCode;
	
	@XStreamAlias("NICKNAME")
	private String nickName;
	
	@XStreamAlias("TELEPHONE")
	private String telephone;
	
	public String getInsuredCode() {
		return insuredCode;
	}
	public void setInsuredCode(String insuredCode) {
		this.insuredCode = insuredCode;
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
