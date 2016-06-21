package cn.com.fubon.fo.customerpremranking.service;

import java.util.List;
import java.util.Map;

import org.jeecgframework.core.common.service.CommonService;

public interface CustomerPremRankingService extends CommonService{
	public List<Map<String,Object>> customerPremRanking();
	public Map<String,Object> customerPremRanking(String identifynumber,String customercname);

}
