package weixin.guanjia.core.entity.message.customer;

public abstract class BaseCustomerMessage {
	private String touser;
	protected String msgtype;

	public String getTouser() {
		return touser;
	}

	public void setTouser(String touser) {
		this.touser = touser;
	}

	public String getMsgtype() {
		return msgtype;
	}

	public void setMsgtype(String msgtype) {
		this.msgtype = msgtype;
	}

	public BaseCustomerMessage() {

	}

}
