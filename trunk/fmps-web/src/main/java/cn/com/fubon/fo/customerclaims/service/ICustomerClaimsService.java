package cn.com.fubon.fo.customerclaims.service;

import java.util.List;
import java.util.Map;

/**
 * shanqi.wang
 */



import org.jeecgframework.core.common.service.CommonService;

public interface ICustomerClaimsService   {


	
	/**
	 * 根据 客户号，一次查询理赔保单所有信息。
	 * @param customerId
	 * @return
	 */
	
	
	public List<Map<String, Object>> getClaimsPolicyAllInformation(String identifynumber, String insuredname);
	
}
