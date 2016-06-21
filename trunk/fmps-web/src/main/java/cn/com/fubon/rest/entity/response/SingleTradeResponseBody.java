/**
 * 
 */
package cn.com.fubon.rest.entity.response;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * @author qingqu.huang
 *
 */
public class SingleTradeResponseBody {

	@XStreamAlias("trade")
	private Trade Trade;

	/**
	 * @return the trade
	 */
	public Trade getTrade() {
		return Trade;
	}

	/**
	 * @param trade the trade to set
	 */
	public void setTrade(Trade trade) {
		Trade = trade;
	}
	
}
