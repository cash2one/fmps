/**
 * 
 */
package cn.com.fubon.product.service;

import java.util.List;

import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.DataGridReturn;
import org.jeecgframework.core.common.service.CommonService;

/**
 * @author guojunjie
 *
 */
public interface IProductRuleService extends CommonService {

	public DataGridReturn getDataGridReturn(CriteriaQuery cq, boolean isOffset);

	public <T> List<T> getList(Class clas);

	/**
	 * 根据产品id查年龄规则maxage
	 * 
	 * @param productid
	 * @return
	 */
	public int findAgeRuleByProductid(String productid, String ruletype);

	/**
	 * 根据产品id查年龄规则minage
	 * 
	 * @param productid
	 * @return
	 */
	public int findAgeRuleMinageByProductid(String productid, String ruletype);
}
