/**
 * 
 */
package cn.com.fubon.rest.entity.response;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamImplicit;

/**
 * @author qingqu.huang
 *
 */
public class SingleTradeResponseHead {

	@XStreamImplicit
	private List<String> param;

	/**
	 * @return the param
	 */
	public List<String> getParam() {
		return param;
	}

	/**
	 * @param param
	 *            the param to set
	 */
	public void setParam(List<String> param) {
		this.param = param;
	}

}
