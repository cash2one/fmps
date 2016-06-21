/**
 * 
 */
package cn.com.fubon.product.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.DataGridReturn;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.fubon.product.service.IProductRuleService;

/**
 * 卡单激活模块service
 * 
 * @author guojunjie
 *
 */
@Service("productRuleService")
@Transactional
public class ProductRuleServiceImp extends CommonServiceImpl implements
		IProductRuleService {
	private static final Logger logger = Logger
			.getLogger(ProductRuleServiceImp.class);

	@Override
	public DataGridReturn getDataGridReturn(CriteriaQuery cq, boolean isOffset) {
		return super.getDataGridReturn(cq, isOffset);
	}

	@Override
	public <T> List<T> getList(Class clas) {
		return super.getList(clas);
	}

	/**
	 * 根据产品id查年龄规则maxage
	 * 
	 * @param productid
	 * @return
	 */
	public int findAgeRuleByProductid(String productid, String ruletype) {
		String sql = "select maxage from weixin_product_rule where ruleclass='年龄规则' and ruletype='"
				+ ruletype
				+ "' and productid='"
				+ productid
				+ "' order by productid asc";
		int str = 0;
		List<Integer> strs = commonDao.findListbySql(sql);
		if (strs.size() > 0) {
			str = strs.get(0);
		}
		return str;
	}

	/**
	 * 根据产品id查年龄规则minage
	 * 
	 * @param productid
	 * @return
	 */
	public int findAgeRuleMinageByProductid(String productid, String ruletype) {
		String sql = "select minage from weixin_product_rule where ruleclass='年龄规则' and ruletype='"
				+ ruletype
				+ "' and productid='"
				+ productid
				+ "' order by productid asc";
		int str = 0;
		List<Integer> strs = commonDao.findListbySql(sql);
		if (strs.size() > 0) {
			str = strs.get(0);
		}
		return str;
	}

}
