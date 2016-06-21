/**
 * 
 */
package cn.com.fubon.rest.entity.response;

import java.util.List;

import cn.com.fubon.product.entity.Product;
import cn.com.fubon.rest.entity.BaseResult;

/**
 * @author qingqu.huang
 *
 */
public class ProductListResponse extends BaseResult {

	private List productList;

	/**
	 * @return the productList
	 */
	public List getProductList() {
		return productList;
	}

	/**
	 * @param productList
	 *            the productList to set
	 */
	public void setProductList(List productList) {
		this.productList = productList;
	}

}
