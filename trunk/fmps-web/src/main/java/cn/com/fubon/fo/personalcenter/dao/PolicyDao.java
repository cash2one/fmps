package cn.com.fubon.fo.personalcenter.dao;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * 个人中心改版--保单相关Dao
 * @author fangfang.guo
 *
 */
public interface PolicyDao {

	List<Map<String, Object>> findAllCars(String customercname,String identifynumber);

	List findAllPolicys(String identifyNumber,String customerCname,String[] policynoList,String telesaledate,String telesalechannel);

	Map<String, String> findPolicyDetailHead(String policyno,boolean isCar);

	List<Map<String, String>> findPolicyDetailBody(String policyno,boolean isCar);
	
	Map<String, Object> findPolicyByTeleSale(String policyno,String date,String channel);
	
	List<Map<String, Object>> findNotCarPolicyByTeleSale(String customerCname,String identifyNumber,String date,String channel);
	
	List<Map<String, Object>> findNotCarPolicyFifteenByTeleSale(String customerCname,String identifyNumber,String date,String channel,String fifteen);
	
	BigDecimal getSumPremium(String policyno);
}
