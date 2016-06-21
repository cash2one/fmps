package cn.com.fubon.fo.huodong.service;

import java.util.List;
import java.util.Map;

import org.jeecgframework.core.common.service.CommonService;

public interface LunarNewYearGiftInsuranceService extends CommonService {	
	
	//查询需要发送赠险核心承保客户列表
	public List<Map<String, Object>> getLunarNewYearGiftInsuranceList();
	//查询保单表
	public List<Map<String, Object>> getLunarNewYearPolicyList();
	//通过活动id和openid获取赠险总保额
	public Map<String,Object> getTotalAmount(String huodongid,String openid);
	
}
