package cn.com.fubon.webservice.externl.coresystem.entity;

import java.util.Map;

import cn.com.fubon.util.MapConverter;
import cn.com.fubon.util.XmlUtils;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

/**
 * 理赔webservice返回
 * @author fangfang.guo
 *
 */
@XStreamAlias("packet")
public class ClaimResponse {

	@XStreamAlias("head")
	private ClaimResponseSender sender;
	
	@XStreamAlias("body")	
	private ClaimResponseBody body;
	
	public ClaimResponseSender getSender() {
		return sender;
	}

	public void setSender(ClaimResponseSender sender) {
		this.sender = sender;
	}

	public ClaimResponseBody getBody() {
		return body;
	}

	public void setBody(ClaimResponseBody body) {
		this.body = body;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String xml = "" 
			 + "<packet>" 
			 + "<head>"
			 + "<transactionNo> 8a828ec64b107bb2014b107bb2f60000</transactionNo>"
			 + "<transactionDate>20150122</transactionDate>"
			 + "<transactionTime>125032</transactionTime>"
			 + "<responseCode>1111</responseCode>"
			 + "<errorMessage>成功</errorMessage>"
			 + "</head>"
			 + "<body>"
			 + "<reportList>"
			 + "<report>"
			 + "<registNo>605012012000000006146</registNo>"
			 + "<licenseNo>闽D00000</licenseNo>"
			 + "<reportDate>2015-01-15</reportDate>"
			 + "<reportTime>11:20:00</reportTime >"
			 + "<operatorCode>0000130</operatorCode>"
			 + "<certiMaterialType>身份证，银行卡</certiMaterialType>"
			 + "<remark>2011-02-17日8时55分由林敏(5859383)驾驶闽DHE252号车于厦门市厦禾路856号（金榜公园附近）发生玻璃破碎事故,三者车：备注：</remark>"
			 + "</report>"
			 + "<report>"
			 + "<registNo>605012012000000006147</registNo>"
			 + "<licenseNo>闽D00001</licenseNo>"
			 + "<reportDate>2015-01-16</reportDate>"
			 + "<reportTime>11:20:00</reportTime >"
			 + "<operatorCode>0000130</operatorCode>"
			 + "<certiMaterialType>身份证，银行卡</certiMaterialType>"
			 + "<remark>2011-02-17日8时55分由林敏(5859383)驾驶闽DHE252号车于厦门市厦禾路856号（金榜公园附近）发生玻璃破碎事故,三者车：备注：</remark>"
			 + "</report>"
			 + "</reportList>"
			 + "</body>"
			 + "</packet>"
			;
		
		ClaimResponse claimResponse = (ClaimResponse)XmlUtils.fromXML(xml,"packet",ClaimResponse.class);
		System.out.println(claimResponse);
	}

}

