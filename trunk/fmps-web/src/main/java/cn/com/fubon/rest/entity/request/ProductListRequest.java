/**
 * 
 */
package cn.com.fubon.rest.entity.request;

import cn.com.fubon.rest.entity.BaseHead;

/**
 * @author qingqu.huang
 * @date 2015-10-12
 */
public class ProductListRequest extends BaseHead {

	private String saleway;
	private String seq;

	public ProductListRequest() {
		super();
	}

	public ProductListRequest(String fromUser, String toUser,
			String transactionFormat, String transactionType,
			String transactionId, String saleway, String seq) {
		super(fromUser, toUser, transactionFormat, transactionType,
				transactionId);
		this.saleway = saleway;
		this.seq = seq;
	}

	/**
	 * @return the seq
	 */
	public String getSeq() {
		return seq;
	}

	/**
	 * @param seq
	 *            the seq to set
	 */
	public void setSeq(String seq) {
		this.seq = seq;
	}

	/**
	 * @return the saleway
	 */
	public String getSaleway() {
		return saleway;
	}

	/**
	 * @param saleway
	 *            the saleway to set
	 */
	public void setSaleway(String saleway) {
		this.saleway = saleway;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}

}
