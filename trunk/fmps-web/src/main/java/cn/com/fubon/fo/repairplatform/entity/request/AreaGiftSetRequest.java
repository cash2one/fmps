package cn.com.fubon.fo.repairplatform.entity.request;

import cn.com.fubon.fo.repairplatform.entity.BaseHead;

public class AreaGiftSetRequest extends BaseHead {	
	private String countycode; // 区县编号
	private String paging; // 分页
	
	public String getCountycode() {
		return countycode;
	}
	public void setCountycode(String countycode) {
		this.countycode = countycode;
	}
	public String getPaging() {
		return paging;
	}
	public void setPaging(String paging) {
		this.paging = paging;
	}
	
	public AreaGiftSetRequest(String fromUser, String toUser,
			String transactionFormat, String transactionType,
			String transactionId, String countycode, String paging) {
		super(fromUser, toUser, transactionFormat, transactionType,
				transactionId);
		this.countycode = countycode;
		this.paging = paging;
	}
	
	
}
