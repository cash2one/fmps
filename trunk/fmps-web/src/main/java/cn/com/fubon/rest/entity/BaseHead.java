package cn.com.fubon.rest.entity;

public class BaseHead {	
	    //发送方
		private String fromUser;		
		//接收方
		private String toUser;
		//交易格式
		private String transactionFormat;		
		//交易类型
		private String transactionType;
		//交易编号
		private String transactionId;
	 	  public BaseHead(){}
		
		public BaseHead(String fromUser, String toUser,
				String transactionFormat, String transactionType,
				String transactionId) {
			super();
			this.fromUser = fromUser;
			this.toUser = toUser;
			this.transactionFormat = transactionFormat;
			this.transactionType = transactionType;
			this.transactionId = transactionId;
		}
		public String getFromUser() {
			return fromUser;
		}
		public void setFromUser(String fromUser) {
			this.fromUser = fromUser;
		}
		public String getToUser() {
			return toUser;
		}
		public void setToUser(String toUser) {
			this.toUser = toUser;
		}
		public String getTransactionFormat() {
			return transactionFormat;
		}
		public void setTransactionFormat(String transactionFormat) {
			this.transactionFormat = transactionFormat;
		}
		public String getTransactionType() {
			return transactionType;
		}
		public void setTransactionType(String transactionType) {
			this.transactionType = transactionType;
		}
		public String getTransactionId() {
			return transactionId;
		}
		public void setTransactionId(String transactionId) {
			this.transactionId = transactionId;
		}	
}
