/**
 * 
 */
package cn.com.fubon.rest.entity.response;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * @author qingqu.huang
 *
 */
@XStreamAlias("alipay")
public class SingleTradeResponse {

	private String is_success;
	private String sign;
	private String sign_type;
	private String error;
	@XStreamAlias("request")
	private SingleTradeResponseHead singleTradeResponseHead;
	@XStreamAlias("response")
	private SingleTradeResponseBody singleTradeResponseBody;
	/**
	 * @return the is_success
	 */
	public String getIs_success() {
		return is_success;
	}
	/**
	 * @param is_success the is_success to set
	 */
	public void setIs_success(String is_success) {
		this.is_success = is_success;
	}
	/**
	 * @return the sign
	 */
	public String getSign() {
		return sign;
	}
	/**
	 * @param sign the sign to set
	 */
	public void setSign(String sign) {
		this.sign = sign;
	}
	/**
	 * @return the sign_type
	 */
	public String getSign_type() {
		return sign_type;
	}
	/**
	 * @param sign_type the sign_type to set
	 */
	public void setSign_type(String sign_type) {
		this.sign_type = sign_type;
	}
	/**
	 * @return the error
	 */
	public String getError() {
		return error;
	}
	/**
	 * @param error the error to set
	 */
	public void setError(String error) {
		this.error = error;
	}
	/**
	 * @return the singleTradeResponseHead
	 */
	public SingleTradeResponseHead getSingleTradeResponseHead() {
		return singleTradeResponseHead;
	}
	/**
	 * @param singleTradeResponseHead the singleTradeResponseHead to set
	 */
	public void setSingleTradeResponseHead(
			SingleTradeResponseHead singleTradeResponseHead) {
		this.singleTradeResponseHead = singleTradeResponseHead;
	}
	/**
	 * @return the singleTradeResponseBody
	 */
	public SingleTradeResponseBody getSingleTradeResponseBody() {
		return singleTradeResponseBody;
	}
	/**
	 * @param singleTradeResponseBody the singleTradeResponseBody to set
	 */
	public void setSingleTradeResponseBody(
			SingleTradeResponseBody singleTradeResponseBody) {
		this.singleTradeResponseBody = singleTradeResponseBody;
	}
	

}
