package cn.com.fubon.webservice.externl.coresystemUnderwrite.entity.request;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 微店承保请求报文HEAD部分
 * 
 * @author yaoming.zhang
 */
@XStreamAlias("HEAD")
public class UnderwriteRequestHead {
	
	@XStreamAlias("REQUESTTYPE")
	private String requestType;		//投保接口：PRP01
	
	@XStreamAlias("USER")
	private String user;
	
	@XStreamAlias("PASSWORD")
	private String password;
	
	@XStreamAlias("OPERATESITE")
	private String operatesite;		//合作点
	
	@XStreamAlias("TRANSACTIONNO")
	private String transactionno;	//合作站点+交易流水号
	
	@XStreamAlias("REQUESTDATE")	
	private String requestdate;		//交易时间,格式YYYY-MM-DD HH:MM:SS
	
	@XStreamAlias("TOUSER")
	private String touser;			//接收方
	

	public String getRequestType() {
		return requestType;
	}

	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}

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

	public String getOperatesite() {
		return operatesite;
	}

	public void setOperatesite(String operatesite) {
		this.operatesite = operatesite;
	}

	public String getTransactionno() {
		return transactionno;
	}

	public void setTransactionno(String transactionno) {
		this.transactionno = transactionno;
	}

	public String getRequestdate() {
		return requestdate;
	}

	public void setRequestdate(String requestdate) {
		this.requestdate = requestdate;
	}

	public String getTouser() {
		return touser;
	}

	public void setTouser(String touser) {
		this.touser = touser;
	}
	
}
