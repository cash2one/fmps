/**
 * 
 */
package cn.com.fubon.fo.card.dao;

import java.util.List;
import java.util.Map;

/**
 * @author qingqu.huang
 *
 */
public interface CardPolicyDao {
	// 已过期
	public List<Map<String, Object>> getCardPolicyAll(String cardno);

	// 获取保单头部信息
	public Map<String, String> findPolicyDetailHead(String cardno);
	
	public List<Map<String, String>> findPolicyDetailBody(String cardno);
	
	public List<Map<String, String>> findLunarNewYearPolicyDetailBody(String cardno,String planid);
}
