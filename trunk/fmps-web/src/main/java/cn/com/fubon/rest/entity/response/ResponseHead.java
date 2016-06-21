/**
 * 
 */
package cn.com.fubon.rest.entity.response;

import cn.com.fubon.rest.entity.BaseHead;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 响应报文头
 * 
 * @author binbin.wang
 *
 */
public class ResponseHead extends BaseHead {

	@XStreamAlias("CPWS_RESPONSE")
	private CpwsResponse cpwsResponse;

	/**
	 * 
	 */
	public ResponseHead() {
		// TODO Auto-generated constructor stub
	}

	public CpwsResponse getCpwsResponse() {
		return cpwsResponse;
	}

	public void setCpwsResponse(CpwsResponse cpwsResponse) {
		this.cpwsResponse = cpwsResponse;
	}
}
