package cn.com.fubon.fo.totaiwan.entity;

import java.util.Map;

import cn.com.fubon.rest.entity.BaseHead;

/**
 * 
 * @author fbxmn07 creat by 2015-12-19
 */
public class PolicyRequest extends BaseHead {

	private String messageKey; // 消息key
	private Map<String, String> messageData; // 内容

	public PolicyRequest() {
		super();
	}

	public PolicyRequest(String fromUser, String toUser,
			String transactionFormat, String transactionType,
			String transactionId, String messageKey,
			Map<String, String> messageData) {
		super(fromUser, toUser, transactionFormat, transactionType,
				transactionId);
		this.messageKey = messageKey;
		this.messageData = messageData;
	}

	public String getMessageKey() {
		return messageKey;
	}

	public void setMessageKey(String messageKey) {
		this.messageKey = messageKey;
	}

	public Map<String, String> getMessageData() {
		return messageData;
	}

	public void setMessageData(Map<String, String> messageData) {
		this.messageData = messageData;
	}

}
