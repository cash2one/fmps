/**
 * 
 */
package cn.com.fubon.rest.service;

import java.util.List;
import java.util.Map;

/**
 * @author qingqu.huang
 * @DATE 2015-10-14
 */
public interface ProductWSService extends CommonWebService {

	/**
	 * 根据销售方式和排序条件查询在线商品列表
	 * 
	 * @param salemode
	 * @param seq
	 * @return
	 */
	public List<Map<String, Object>> findProductList(String salemode,
			String seq);

	/**
	 * 根据商品ID获取相关计划list
	 * 
	 * @param productid
	 * @return
	 */
	public List<Map<String, Object>> findPlanList(String productid);

	/**
	 * 根据商品ID获取商品的基本信息，包含商品介绍和投保规则
	 * 
	 * @param productid
	 * @return
	 */
	public Map<String, Object> findProduct(String productid);
	
	public List<Map<String, Object>> findPlanNameList(String planid);
	
	public Map<String, Object> findProduct(String typeId, String productid);
}
