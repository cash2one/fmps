/**
 * 
 */
package cn.com.fubon.webservice.impl;

import java.util.Date;

import javax.jws.WebService;

import weixin.guanjia.core.entity.message.resp.TextMessageResp;
import weixin.guanjia.core.util.MessageUtil;
import cn.com.fubon.webservice.IHelloWorldService;
import cn.com.fubon.webservice.WsConstants;

/**
 * @author binbin.wang
 *
 */
@WebService(endpointInterface="cn.com.fubon.webservice.IHelloWorldService",serviceName="helloWorldService",targetNamespace=WsConstants.NS)
public class HelloWorldService implements IHelloWorldService {

	/**
	 * 
	 */
	public HelloWorldService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String sayHello() {
		TextMessageResp textMessage = new TextMessageResp();
		textMessage.setToUserName("toUserName");
		textMessage.setFromUserName("fromUserName");
		textMessage.setCreateTime(new Date().getTime());
		textMessage.setContent("this is response");
		
		return MessageUtil.messageToXml(textMessage);
	}

	public static void main(String[] args) {
		HelloWorldService hws = new HelloWorldService();
		String result = hws.sayHello();
		System.out.println(result);
	}
}
