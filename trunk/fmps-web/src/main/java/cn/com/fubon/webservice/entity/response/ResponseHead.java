/**
 * 
 */
package cn.com.fubon.webservice.entity.response;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import cn.com.fubon.webservice.entity.BaseHead;

/**
 * 响应报文头
 * @author binbin.wang
 *
 */
public class ResponseHead extends BaseHead {

	@XStreamAlias("TRANS_RESPONSE")
	private TransResponse transResponse;
	
	/**
	 * 
	 */
	public ResponseHead() {
		// TODO Auto-generated constructor stub
	}

	public TransResponse getTransResponse() {
		return transResponse;
	}

	public void setTransResponse(TransResponse transResponse) {
		this.transResponse = transResponse;
	}
}
