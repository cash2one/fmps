/**
 * 
 */
package cn.com.fubon.webservice.externl.coresystem.entity;

import java.util.HashMap;
import java.util.Map;

import cn.com.fubon.util.MapConverter;
import cn.com.fubon.util.XmlUtils;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;

/**
 * 保单服务请求报文
 * @author binbin.wang
 *
 */
@XStreamAlias("Underwrite")
public class PolicyServiceRequest {

	@XStreamAlias("sender")
	private RequestSender sender;
	
	@XStreamConverter(MapConverter.class)
	private Map<String, String> policyInfo;
	
	public RequestSender getSender() {
		return sender;
	}

	public void setSender(RequestSender sender) {
		this.sender = sender;
	}

	public Map<String, String> getPolicyInfo() {
		return policyInfo;
	}

	public void setPolicyInfo(Map<String, String> policyInfo) {
		this.policyInfo = policyInfo;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		RequestSender sender = new RequestSender();
		sender.setClientCode("clientCode_1");
		sender.setMessageType("messageType_1");
		sender.setSendDate("20140515");
		
		Map<String, String> maps = new HashMap<String, String>();
		maps.put("insuredCode", "insuredCode_1");
		maps.put("openId", "openId_1");
		maps.put("nickName", "nickName_1");
		
		PolicyServiceRequest policyServiceRequest = new PolicyServiceRequest();
		policyServiceRequest.setSender(sender);
		policyServiceRequest.setPolicyInfo(maps);
		
		System.out.println(XmlUtils.toXML(policyServiceRequest));
		
	}

}
