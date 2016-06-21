package cn.com.fubon.webservice.externl.telesalesystem.entity;


import cn.com.fubon.util.XmlUtils;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("PACKET")
public class TelesaleResponse {
	@XStreamAlias("HEAD")
	private TelesaleResponseHead telesaleResponseHead;
	@XStreamAlias("PROPOSAL")
	private TelesaleResponseProposal telesaleResponseProposal;
	
	public TelesaleResponseHead getTelesaleResponseHead() {
		return telesaleResponseHead;
	}
	public void setTelesaleResponseHead(TelesaleResponseHead telesaleResponseHead) {
		this.telesaleResponseHead = telesaleResponseHead;
	}
	public TelesaleResponseProposal getTelesaleResponseProposal() {
		return telesaleResponseProposal;
	}
	public void setTelesaleResponseProposal(TelesaleResponseProposal telesaleResponseProposal) {
		this.telesaleResponseProposal = telesaleResponseProposal;
	}
	
	public static void main(String[] args) {
		String xml = ""
				+ "<PACKET>"
				+ "<HEAD>"
				+ "<PACKETTYPE>getPayInfo</PACKETTYPE>"
				+ "<PAYCODE>179261</PAYCODE>"
				+ "<CLASSCODE>FC</CLASSCODE>"
				+ "<YANZHENGMASTATUS>005</YANZHENGMASTATUS>"
				+ "</HEAD>" 
				+ "<PROPOSAL>"
				+ "<INSUREDNAME>测试</INSUREDNAME>"
				+ "<IDENTIFYNUMBER>1234567890</IDENTIFYNUMBER>"
				+ "<LICENSENO>闽D12345</LICENSENO>"
				+ "<STARTDATE>201512031843</STARTDATE>" + "<SUMPREMIUM>200</SUMPREMIUM>"
				+ "<RISKLIST>"
				+ "<RISKNAME>测试险</RISKNAME>" + "<SUBPREMIUM>100</SUBPREMIUM>"
				+ "<PRPTITEMKINDLIST>"
				+ "<PRPTITEMKIND>"
				+ "<ITEMNAME>1</ITEMNAME>" + "<KINDNAME>测试</KINDNAME>"
				+ "<AMOUNT>100</AMOUNT>"
				+ "<PREMIUM>100</PREMIUM>" + "<RISKKIND>5</RISKKIND>"
				+ "<NONDEDUCTIBLE>N</NONDEDUCTIBLE>"
				+ "</PRPTITEMKIND>"
				+ "</PRPTITEMKINDLIST>"
				+ "</RISKLIST>"
				+ "</PROPOSAL>"
				+ "</PACKET>";

		TelesaleResponse claimResponse = (TelesaleResponse) XmlUtils.fromXML(xml, "PACKET", TelesaleResponse.class);
		String riskname = claimResponse.getTelesaleResponseProposal().getRisklist().get(0).getRiskname();
		String itemname = claimResponse.getTelesaleResponseProposal().getRisklist().get(0).getPrpTitemkindList().get(0).getItemname();
		System.out.println(xml);
		System.out.println(claimResponse.toString());
		System.out.println(riskname);
		System.out.println(itemname);
	}
}

