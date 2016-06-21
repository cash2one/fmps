package cn.com.fubon.fo.repairplatform.entity.request;

import cn.com.fubon.fo.repairplatform.entity.BaseHead;

public class EvaluationListRequest extends BaseHead  {	
	 
	private String repairid; // 维修厂ID
	private String order; // 排序
	private String paging; // 分页
	public EvaluationListRequest(String fromUser, String toUser,
			String transactionFormat, String transactionType,
			String transactionId, String repairid, String order, String paging) {
		super(fromUser, toUser, transactionFormat, transactionType,
				transactionId);
		this.repairid = repairid;
		this.order = order;
		this.paging = paging;
	}
	public String getRepairid() {
		return repairid;
	}
	public void setRepairid(String repairid) {
		this.repairid = repairid;
	}
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
	public String getPaging() {
		return paging;
	}
	public void setPaging(String paging) {
		this.paging = paging;
	}

}
