package cn.com.fubon.fo.personalcenter.dao;

import java.util.List;
import java.util.Map;

/**
 * 客户保单查询类
 * @author patrick.z
 */
public interface CustomerPolicyDao {
	
	/**
	 * 根据 证件号码、客户名称和险种，查询保单-车险信息。
	 * @param customerCode
	 * @param riskCodeList
	 * @return
	 */
	List<Map<String, Object>> getCustomerCarPolicyAll(String identifynumber,String customercname,List<Map<String, Object>> riskCodes);
	
	/**
	 * 根据 证件号码、客户名称和险种，查询保单-非车险信息。
	 * @param customerCode
	 * @param riskCodeList
	 * @return
	 */
	List<Map<String, Object>> getCustomerNotCarPolicyAll(String identifynumber,String customercname,List<Map<String, Object>> riskCodes);
	
	/**
	 * 根据 险种大类，查询核心险种。
	 * @param insPlanCode
	 * @return
	 */
	List<Map<String, Object>> getInsPlanCodeListByInsPlanCode(String insPlanCode);
}
