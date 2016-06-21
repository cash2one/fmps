/**
 * 
 */
package cn.com.fubon.rest.entity.request;

import cn.com.fubon.rest.entity.BaseHead;

/**
 * @author qingqu.huang
 * @date 2015-10-12
 */
public class ProductRequest extends BaseHead {

	private String productid;
	private String typeid;

	public ProductRequest() {
		super();
	}

	public ProductRequest(String fromUser, String toUser,
			String transactionFormat, String transactionType,
			String transactionId, String productid) {
		super(fromUser, toUser, transactionFormat, transactionType,
				transactionId);
		this.productid = productid;
	}
	
	public ProductRequest(String fromUser, String toUser,
			String transactionFormat, String transactionType,
			String transactionId, String productid, String typeid) {
		super(fromUser, toUser, transactionFormat, transactionType,
				transactionId);
		this.productid = productid;
		this.typeid = typeid;
	}

	/**
	 * @return the productid
	 */
	public String getProductid() {
		return productid;
	}

	/**
	 * @param productid
	 *            the productid to set
	 */
	public void setProductid(String productid) {
		this.productid = productid;
	}

	public String getTypeid() {
		return typeid;
	}
	public void setTypeid(String typeid) {
		this.typeid = typeid;
	}

}
