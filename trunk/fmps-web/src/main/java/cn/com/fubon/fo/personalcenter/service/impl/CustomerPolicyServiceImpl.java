package cn.com.fubon.fo.personalcenter.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.fubon.fo.personalcenter.dao.CustomerPolicyDao;
import cn.com.fubon.fo.personalcenter.service.CustomerPolicyService;

@Service("customerPolicyService")
@Transactional
public class CustomerPolicyServiceImpl extends CommonServiceImpl implements
		CustomerPolicyService {

	@Resource
	private CustomerPolicyDao oracleCustomerPolicyDao;

	@Resource
	private CustomerPolicyDao customerPolicyDao;

	@Override
	public List<Map<String, Object>> getCustomerCarPolicyAll(String identifynumber,String customercname,List<Map<String, Object>> riskCodes) {
		return oracleCustomerPolicyDao.getCustomerCarPolicyAll(identifynumber,customercname,riskCodes);
	}

	@Override
	public List<Map<String, Object>> getCustomerNotCarPolicyAll(String identifynumber,String customercname,List<Map<String, Object>> riskCodes) {
		return oracleCustomerPolicyDao.getCustomerNotCarPolicyAll(identifynumber,customercname,riskCodes);
	}

	@Override
	public List<Map<String, Object>> getInsPlanCodeListByInsPlanCode(
			String insPlanCode) {
		return customerPolicyDao.getInsPlanCodeListByInsPlanCode(insPlanCode);
	}

}
