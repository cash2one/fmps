package cn.com.fubon.webservice.externl.coresystem.entity;

import cn.com.fubon.util.XmlUtils;
import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("Underwrite")
public class WeixinNewCarRequest {
	
    private RequestSender sender;
    
	private WeixinNewCarLicenseRequestBody policyInfo;
	
	public RequestSender getSender() {
		return sender;
	}

	public void setSender(RequestSender sender) {
		this.sender = sender;
	}

	public WeixinNewCarLicenseRequestBody getPolicyInfo() {
		return policyInfo;
	}

	public void setPolicyInfo(WeixinNewCarLicenseRequestBody policyInfo) {
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
		
		WeixinNewCarLicenseRequestBody body = new WeixinNewCarLicenseRequestBody();
		body.setInsuredCode("insuredCode_1");
		body.setOpenId("openId_1");
		body.setPolicyNo("policyNo");
		
		WeixinNewCarRequest request = new WeixinNewCarRequest();
		request.setSender(sender);
		request.setPolicyInfo(body);
		
		System.out.println(XmlUtils.toXML(request));
		
	}

}
