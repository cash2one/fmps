package cn.com.fubon.webservice.entity.request;

import com.thoughtworks.xstream.annotations.XStreamAlias;


/**
 * 核心承保接口用到的内部RequestHead
 *
 */
public class FbCoreUnderwriteRequestHead extends RequestHead{
	
	@XStreamAlias("USER")
	private String user;
	
	@XStreamAlias("PASSWORD")
	private String password;

	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
