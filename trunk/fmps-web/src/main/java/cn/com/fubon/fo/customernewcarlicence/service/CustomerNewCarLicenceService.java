package cn.com.fubon.fo.customernewcarlicence.service;

import java.util.List;
import java.util.Map;

import org.jeecgframework.core.common.service.CommonService;

public interface CustomerNewCarLicenceService extends CommonService {
	
	/**
	 * 从 ORACLE 数据库 查询新车列表 
	 */

	List<Map<String, Object>> getCustomerNewCarLicenceRecord(String identifynumber,String customercname , String framenoList);
	/**
	 * 从mysql 数据库 查询已经上牌的新车 
	 */

	List<Map<String, Object>> getNewCarHasLicenceRecord(String identifynumber,String customercname);
	/**
	 * 根据车架号 从 ORACLE 数据库中查询出 保单号 与 客户号 
	 * @param identifynumber
	 * @param customercname
	 * @param frameno
	 * @return
	 */
	Map<String, Object>  getCustomerPolicyNoAndCustomerID(String identifynumber,String customercname,String frameno);
	
	
	public Map<String, Object>  getWeiXinOpenId(String customerId);
	
}
