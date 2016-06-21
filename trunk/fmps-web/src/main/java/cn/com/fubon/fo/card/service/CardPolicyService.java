/**
 * 
 */
package cn.com.fubon.fo.card.service;

import java.util.List;
import java.util.Map;

import org.jeecgframework.core.common.service.CommonService;

/**
 * 个人中心卡单激活查询接口类
 * 
 * @author qingqu.huang
 *
 */
public interface CardPolicyService extends CommonService {

	List<Map<String, Object>> getCardPolicyAll(String cardno);

	// 获取保单头部信息
	public Map<String, String> findPolicyDetailHead(String cardno);
	/**
	 * 获取卡单详细保障信息
	 */
	public List<Map<String, String>> findPolicyDetailBody(String cardno);
	/**
	 * 获取春节赠险卡单详细保障信息
	 */
	public List<Map<String, String>> findLunarNewYearPolicyDetailBody(String cardno,String planid);
	
	/**
	 * 根据保单号查询是否有骨折卡
	 * @param policyNo
	 * @return
	 */
	public boolean isFractureProduct(String policyNo);
}
