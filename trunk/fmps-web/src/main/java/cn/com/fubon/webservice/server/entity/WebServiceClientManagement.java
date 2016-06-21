package cn.com.fubon.webservice.server.entity;

import javax.persistence.Entity;

import org.jeecgframework.core.common.entity.IdEntity;

@Entity(name="webservice_client_management")
public class WebServiceClientManagement extends IdEntity{
	//客户端代码
	private String clientCode;
	//签名用的token
	private String token;
	//AES密钥
	private String AESKey;
	//是否有效 1：有效 0：无效
	private int status;
	
	public String getClientCode() {
		return clientCode;
	}
	public void setClientCode(String clientCode) {
		this.clientCode = clientCode;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getAESKey() {
		return AESKey;
	}
	public void setAESKey(String aESKey) {
		AESKey = aESKey;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
}
