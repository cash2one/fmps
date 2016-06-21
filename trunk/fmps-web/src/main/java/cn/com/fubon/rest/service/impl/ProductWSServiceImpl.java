/**
 * 
 */
package cn.com.fubon.rest.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jeecgframework.core.common.service.CommonService;
import org.jeecgframework.core.util.ApplicationContextUtil;
import org.jeecgframework.core.util.ResourceUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.fubon.rest.service.ProductWSService;

/**
 * @author qingqu.huang
 * @DATE 2015-10-14
 */
@Service("ProductWSService")
@Transactional
public class ProductWSServiceImpl extends CommonWebServiceImpl implements
		ProductWSService {

	/**
	 * 根据销售方式和排序条件查询在线商品列表
	 * 
	 * @param salemode
	 * @param seq
	 * @return
	 */
	@Override
	public List<Map<String, Object>> findProductList(String salemode,
			String seq) {
		String querysql = "select product.id,product.productname,concat('"
				+ ResourceUtil.getDomain();
		querysql = querysql
				+ "','/',product.imagehref) as imagehref,product.feature,product.occupationLevels,price from weixin_product product left join (select min(premium) as price,productid from weixin_plan plan group by productid) p on p.productid=product.id where product.salemode=? and product.status='1' ";
		System.out.println(querysql);
		CommonService commonService = (CommonService) ApplicationContextUtil
				.getContext().getBean("commonService");
		List<Map<String, Object>> productList = commonService.findForJdbc(
				querysql, salemode);
		return productList;
	}

	/**
	 * 根据商品ID获取相关计划list
	 * 
	 * @param productid
	 * @return
	 */
	@Override
	public List<Map<String, Object>> findPlanList(String productid) {
		CommonService commonService = (CommonService) ApplicationContextUtil
				.getContext().getBean("commonService");
		List<Map<String, Object>> planList = commonService
				.findForJdbc(
						"select plan.id,plan.planname,plan.coreproductcode,concat(cast(plan.premium as DECIMAL(6,2)),'') as premium,case when plan.periodtype='月' then concat(plan.period,'个月') else concat(plan.period,plan.periodtype) end as period from weixin_plan plan where plan.productid=? and plan.status='有效' order by plan.serialno;",
						productid);
		return planList;
	}

	/**
	 * 根据商品ID获取商品的基本信息，包含商品介绍和投保规则
	 * 
	 * @param productid
	 * @return
	 */
	public Map<String, Object> findProduct(String productid) {
		Map<String, Object> productMap = new HashMap<String, Object>();
		CommonService commonService = (CommonService) ApplicationContextUtil
				.getContext().getBean("commonService");
		String querysql = "select product.id,product.productname,product.type,product.status,concat('"
				+ ResourceUtil.getDomain();
		querysql = querysql
				+ "','/',product.imagehref) as imagehref,product.occupationLevels,insuranceAge,introduction,minpremium,maxpremium from weixin_product product"
				+ " left join (select concat(rule.minage,'-',rule.maxage) as insuranceAge,productid from weixin_product_rule rule where rule.ruletype='被保人' and rule.ruleclass='年龄规则') productrule on productrule.productid=product.id "
				+ "left join (select document as introduction,productid from weixin_product_affiliated  where type='3') affiliated on affiliated.productid=product.id  "
				+ " left join (select min(plan.premium) as minpremium,max(plan.premium) as maxpremium,plan.productid from  weixin_plan plan group by plan.productid ) p on p.productid=product.id "
				+ "where product.id=?";
		productMap = commonService.findOneForJdbc(querysql, productid);
		return productMap;
	}

	@Override
	public List<Map<String, Object>> findPlanNameList(String productid) {
		CommonService commonService = (CommonService) ApplicationContextUtil
				.getContext().getBean("commonService");
		List<Map<String, Object>> planNameList = commonService
				.findForJdbc(
						"select plan.planname,plan.serialno from weixin_plan plan  where plan.productid=? group by plan.planname  order by plan.serialno",
						productid);
		return planNameList;
	}
	
	/**
	 * 根据typeId和productId获取对应内容
	 * 商品详情(typeId:4)、常见问题(typeId:5)、投保须知(typeId:2)
	 * 
	 * @param productid
	 * @return
	 */
	public Map<String, Object> findProduct(String typeId, String productid) {
		Map<String, Object> productMap = new HashMap<String, Object>();
		CommonService commonService = (CommonService) ApplicationContextUtil
				.getContext().getBean("commonService");
		StringBuffer querysql = new StringBuffer();
		querysql.append("	select product.id, product.productname, product.status, affiliated.content ");
		querysql.append("	  from weixin_product product ");
		querysql.append("	  left join (select document as content, productid ");
		querysql.append("	               from weixin_product_affiliated ");
		querysql.append("	              where type = ?) affiliated on affiliated.productid = product.id ");
	    querysql.append("	 where product.id = ? ");
	    
		productMap = commonService.findOneForJdbc(querysql.toString(), new String[] { typeId, productid });
		return productMap;
	}

}
