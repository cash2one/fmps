package cn.com.fubon.fo.personalcenter.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.jeecgframework.core.common.dao.impl.GenericBaseCommonDao;
import org.springframework.stereotype.Repository;

import cn.com.fubon.fo.personalcenter.dao.CustomerPolicyDao;

/**
 * @author patrick.z
 */
@SuppressWarnings("rawtypes")
@Repository("customerPolicyDao")
public class CustomerPolicyDaoImpl extends GenericBaseCommonDao implements
		CustomerPolicyDao {
	private static final Logger logger = Logger
			.getLogger(CustomerPolicyDaoImpl.class);

	@Override
	public List<Map<String, Object>> getCustomerCarPolicyAll(String identifynumber,String customercname,List<Map<String, Object>> riskCodes) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Map<String, Object>> getCustomerNotCarPolicyAll(String identifynumber,String customercname,List<Map<String, Object>> riskCodes) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Map<String, Object>> getInsPlanCodeListByInsPlanCode(
			String insPlanCode) {
		logger.info("getInsPlanCodeListByInsPlanCode(String insPlanCode)" + insPlanCode);
		String sql = " select risk_code from weixin_plan_risk_map where insurance_plan_code = ? ";
		List<Map<String, Object>> insPlanCodesList = null;
		insPlanCodesList = this.findForJdbc(sql, new String[] {insPlanCode});
		logger.info("保单查询-非车险 Sql:" + sql + "\n");
		
		return insPlanCodesList;
	}

}
