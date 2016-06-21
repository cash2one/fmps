package cn.com.fubon.rest.entity.request;

import cn.com.fubon.fo.repairplatform.entity.BaseHead;

public class ShorturlAPIRequest extends BaseHead {
	// 支付url
	private String url;

	public ShorturlAPIRequest() {
	}

	public ShorturlAPIRequest(String fromUser, String toUser,
			String transactionFormat, String transactionType,
			String transactionId, String url) {
		super(fromUser, toUser, transactionFormat, transactionType,
				transactionId);
		this.url = url;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
