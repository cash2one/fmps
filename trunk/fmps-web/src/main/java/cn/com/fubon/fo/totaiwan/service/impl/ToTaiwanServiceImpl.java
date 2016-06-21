/**
 * 
 */
package cn.com.fubon.fo.totaiwan.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.hibernate.criterion.Restrictions;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.jeecgframework.tag.vo.datatable.SortDirection;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.fubon.fo.totaiwan.controller.ToTaiwanController;
import cn.com.fubon.fo.totaiwan.service.ToTaiwanService;
import cn.com.fubon.product.entity.Product;

/**
 * @author qingqu.huang
 *
 */
@Service("toTaiwanServiceImpl")
@Transactional
public class ToTaiwanServiceImpl extends CommonServiceImpl implements
		ToTaiwanService {

	private static final Logger logger = Logger
			.getLogger(ToTaiwanController.class);

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}

	/**
	 * 根据用户openid统计该用户已上传的图片数量
	 * 
	 * @param openid
	 * @return
	 */
	@Override
	public int getCount(String openid) {
		long sumnum = this
				.getCountForJdbcParam(
						"select count(*) from weixin_claim_image where openid=?",
						new Object[] { openid });
		return (int) sumnum;
	}

	@Override
	public List<Map<String, Object>> findProductList(String salemode,String[] internalcodes) {
		CriteriaQuery criteriaQuery = new CriteriaQuery(Product.class);
		criteriaQuery.add(Restrictions.in("internalcode",internalcodes));
		criteriaQuery.add(Restrictions.eq("status","1"));
		//criteriaQuery.add(Restrictions.eq("salemode",salemode));
		criteriaQuery.addOrder("createtime", SortDirection.asc); 
		criteriaQuery.addOrder("createtime", SortDirection.asc); 
		return getListByCriteriaQuery(criteriaQuery,false);
	}

	@Override
	public List<Map<String, Object>> loadProvinceList() {
		List<Map<String, Object>> provinceList = this
				.findForJdbc("select distinct province,provincecode from weixin_address_code");
		return provinceList;
	}

	@Override
	public List<Map<String, Object>> loadCityList(String provinceid) {
		List<Map<String, Object>> cityList = this
				.findForJdbc(
						"select distinct address.city,address.citycode from weixin_address_code address where address.provincecode=?",
						provinceid);
		return cityList;
	}

	@Override
	public List<Map<String, Object>> loadCounty(String cityid) {
		List<Map<String, Object>> countyList = this
				.findForJdbc(
						"select distinct address.county,address.countycode from weixin_address_code address where address.citycode=?",
						cityid);
		return countyList;
	}

	@Override
	public List<Map<String, Object>> getunPaidPolicyList(String openid,int paging) {
		List<Map<String, Object>> unpaidPolicyList = this.findForJdbcParam("select policy.productid,policy.productname,policy.planname,policy.period,policy.orderno,policy.startdate,policy.enddate,policy.premium,customer.name from weixin_policy policy left join weixin_policy_insured_identity  identity on policy.orderno=identity.orderno left join weixin_customer customer on identity.customerid=customer.id where policy.status in('0','3','4') and policy.openid=? order by policy.createtime desc", paging, 10, new Object[]{openid});
		return unpaidPolicyList;
	}

	public List<Map<String, Object>> getPolicyList(String openid, String status,int paging) {
		List<Map<String, Object>> policyList = this.findForJdbcParam("select policy.productid,policy.policyno,policy.productname,policy.planname,policy.period,policy.orderno,policy.startdate,policy.enddate,policy.premium,customer.name from weixin_policy policy left join weixin_policy_insured_identity  identity on policy.orderno=identity.orderno left join weixin_customer customer on identity.customerid=customer.id where policy.status =? and policy.openid=? order by policy.createtime desc", paging, 10, new Object[]{status, openid});
		return policyList;
	}
}
