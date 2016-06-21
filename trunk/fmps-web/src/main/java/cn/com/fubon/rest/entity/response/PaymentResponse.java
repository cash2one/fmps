/**
 * 
 */
package cn.com.fubon.rest.entity.response;

import cn.com.fubon.rest.entity.BaseResult;

/**
 * @author qingqu.huang
 *
 */
public class PaymentResponse extends BaseResult {

	private String paycode;
	private String paytype;
	private String status;
	private String serialnumber;
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
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * @return the serialnumber
	 */
	public String getSerialnumber() {
		return serialnumber;
	}
	/**
	 * @param serialnumber the serialnumber to set
	 */
	public void setSerialnumber(String serialnumber) {
		this.serialnumber = serialnumber;
	}
	
}
