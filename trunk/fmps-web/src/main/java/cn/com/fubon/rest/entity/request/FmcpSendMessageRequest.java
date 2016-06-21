package cn.com.fubon.rest.entity.request;

import java.util.List;

import cn.com.fubon.rest.entity.BaseHead;

public class FmcpSendMessageRequest extends BaseHead {

	private String content; // 内容
	private List<String> eipIdList; // eipId集合
	private String agentid; // 应用ID

	public FmcpSendMessageRequest() {
	}

	public FmcpSendMessageRequest(String fromUser, String toUser,
			String transactionFormat, String transactionType,
			String transactionId, String content, List<String> eipIdList,
			String agentid) {
		super(fromUser, toUser, transactionFormat, transactionType,
				transactionId);
		this.content = content;
		this.eipIdList = eipIdList;
		this.agentid = agentid;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public List<String> getEipIdList() {
		return eipIdList;
	}

	public void setEipIdList(List<String> eipIdList) {
		this.eipIdList = eipIdList;
	}

	public String getAgentid() {
		return agentid;
	}

	public void setAgentid(String agentid) {
		this.agentid = agentid;
	}
}
