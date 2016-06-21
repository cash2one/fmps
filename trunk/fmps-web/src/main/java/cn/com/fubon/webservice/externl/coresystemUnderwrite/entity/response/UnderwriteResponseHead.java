package cn.com.fubon.webservice.externl.coresystemUnderwrite.entity.response;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 微店承保响应报文HEAD部分
 * 
 * @author yaoming.zhang
 */
public class UnderwriteResponseHead {
	
	@XStreamAlias("TRANSACTIONNO")
	private String transactionno;
	@XStreamAlias("REQUESTTYPE")
	private String requesttype;
	@XStreamAlias("RETURNCODE")
	private String returncode;
	@XStreamAlias("RETURNMESSAGE")
	private String returnmessage;
	
	public String getTransactionno() {
		return transactionno;
	}
	public void setTransactionno(String transactionno) {
		this.transactionno = transactionno;
	}
	public String getRequesttype() {
		return requesttype;
	}
	public void setRequesttype(String requesttype) {
		this.requesttype = requesttype;
	}
	public String getReturncode() {
		return returncode;
	}
	public void setReturncode(String returncode) {
		this.returncode = returncode;
	}
	public String getReturnmessage() {
		return returnmessage;
	}
	public void setReturnmessage(String returnmessage) {
		this.returnmessage = returnmessage;
	}
	
}
