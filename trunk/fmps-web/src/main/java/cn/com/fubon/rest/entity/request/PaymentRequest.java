/**
 * 
 */
package cn.com.fubon.rest.entity.request;

import cn.com.fubon.rest.entity.BaseHead;

/**
 * @author qingqu.huang
 *
 */
public class PaymentRequest extends BaseHead {
	
	private String paycode;
	private String paytype;

	public PaymentRequest() {
		super();
	}

	public PaymentRequest(String fromUser, String toUser,
			String transactionFormat, String transactionType,
			String transactionId,String paycode,String paytype) {
		super(fromUser, toUser, transactionFormat, transactionType, transactionId);
		this.paycode=paycode;
		this.paytype=paytype;
	}

	/**
	 * @return the paycode
	 */
	public String getPaycode() {
		return paycode;
	}

	/**
	 * @param paycode the paycode to set
	 */
	public void setPaycode(String paycode) {
		this.paycode = paycode;
	}

	/**
	 * @return the paytype
	 */
	public String getPaytype() {
		return paytype;
	}

	/**
	 * @param paytype the paytype to set
	 */
	public void setPaytype(String paytype) {
		this.paytype = paytype;
	}

}
