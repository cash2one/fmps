/**
 * 
 */
package cn.com.fubon.webservice.externl.coresystem.entity;

import java.util.ArrayList;
import java.util.List;

import cn.com.fubon.util.XmlUtils;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

/**
 * 核心微信绑定报文
 * @author binbin.wang
 *
 */
@XStreamAlias("Underwrite")
public class WeixinBindRequest {

	private RequestSender sender;
	
	private WeixinBindRequestBody insuredPerson;
	
	public RequestSender getSender() {
		return sender;
	}

	public void setSender(RequestSender sender) {
		this.sender = sender;
	}

	public WeixinBindRequestBody getInsuredPerson() {
		return insuredPerson;
	}

	public void setInsuredPerson(WeixinBindRequestBody insuredPerson) {
		this.insuredPerson = insuredPerson;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		RequestSender sender = new RequestSender();
		sender.setClientCode("clientCode_1");
		sender.setMessageType("messageType_1");
		sender.setSendDate("20140515");
		
		WeixinBindRequestBody body = new WeixinBindRequestBody();
		body.setInsuredCode("insuredCode_1");
		body.setNickName("nickName_1");
		body.setOpenid("openid_1");
		body.setTelephone("telephone_1");
		
		WeixinBindRequest weixinBindRequest = new WeixinBindRequest();
		weixinBindRequest.setSender(sender);
		weixinBindRequest.setInsuredPerson(body);
		
		System.out.println(XmlUtils.toXML(weixinBindRequest));
		
	}

}
