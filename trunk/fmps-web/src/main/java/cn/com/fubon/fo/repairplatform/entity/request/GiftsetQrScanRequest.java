package cn.com.fubon.fo.repairplatform.entity.request;

import cn.com.fubon.fo.repairplatform.entity.BaseHead;

public class GiftsetQrScanRequest  extends BaseHead  {
	private String repairid; //维修厂ID
	private String giftset_detail_id; //礼券ID	
	private String repairname; //维修厂名称
	private String ifException; //0 ：正常   1：异常
	private String exceptionMessage; //异常信息	
	
	 public GiftsetQrScanRequest() {
		 super();
		// TODO Auto-generated constructor stub
	 }
	 public GiftsetQrScanRequest(String fromUser, String toUser,
			String transactionFormat, String transactionType,
			String transactionId, String repairid, String giftset_detail_id,
			String repairname, String ifException, String exceptionMessage) {
		super(fromUser, toUser, transactionFormat, transactionType,
				transactionId);
		this.repairid = repairid;
		this.giftset_detail_id = giftset_detail_id;
		this.repairname = repairname;
		this.ifException = ifException;
		this.exceptionMessage = exceptionMessage;
	}

	public String getRepairid() {
		return repairid;
	}


	public void setRepairid(String repairid) {
		this.repairid = repairid;
	}


	public String getGiftset_detail_id() {
		return giftset_detail_id;
	}


	public void setGiftset_detail_id(String giftset_detail_id) {
		this.giftset_detail_id = giftset_detail_id;
	}


	public String getRepairname() {
		return repairname;
	}


	public void setRepairname(String repairname) {
		this.repairname = repairname;
	}


	public String getIfException() {
		return ifException;
	}


	public void setIfException(String ifException) {
		this.ifException = ifException;
	}


	public String getExceptionMessage() {
		return exceptionMessage;
	}


	public void setExceptionMessage(String exceptionMessage) {
		this.exceptionMessage = exceptionMessage;
	}
	
	 

}
