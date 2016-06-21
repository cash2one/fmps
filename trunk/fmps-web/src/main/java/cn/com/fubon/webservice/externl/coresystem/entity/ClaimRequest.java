package cn.com.fubon.webservice.externl.coresystem.entity;

import org.jeecgframework.core.util.UUIDGenerator;

import cn.com.fubon.util.XmlUtils;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("packet")
public class ClaimRequest {
	@XStreamAlias("head")
    private ClaimRequestSender sender;
	
	//生成的XML不显示insuredPersons标签,WeixinBindRequestBody跟sender并列
	private ClaimRequestBody body;
	

	public ClaimRequestSender getSender() {
		return sender;
	}

	public void setSender(ClaimRequestSender sender) {
		this.sender = sender;
	}

	public ClaimRequestBody getBody() {
		return body;
	}

	public void setBody(ClaimRequestBody body) {
		this.body = body;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ClaimRequestSender sender = new ClaimRequestSender();
		sender.setTransactionNo(UUIDGenerator.generate());
		sender.setTransactionDate("2015-01-22");
		sender.setTransactionTime("15:05:00");
		
		ClaimRequestBody body = new ClaimRequestBody();
		body.setReportPhoneNo("15248960243");
		body.setWeChatId("oELqIsyh_VguKRN-0MONSbeLz5r1");
		
		ClaimRequest claimRequest = new ClaimRequest();
		claimRequest.setSender(sender);
		claimRequest.setBody(body);
	
		System.out.println(XmlUtils.toXML(claimRequest));
		
	}





}
