/**
 * 
 */
package cn.com.fubon.webservice.externl.coresystem.entity;

import java.util.Map;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 核心微信绑定报文
 * @author binbin.wang
 *
 */
@XStreamAlias("Underwrite")
public class CommonResponse {

	@XStreamAlias("sender")
	private ResponseSender sender;
	
	public ResponseSender getSender() {
		return sender;
	}

	public void setSender(ResponseSender sender) {
		this.sender = sender;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}

}
