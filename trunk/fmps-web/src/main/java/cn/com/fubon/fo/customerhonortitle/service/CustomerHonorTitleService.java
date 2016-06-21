package cn.com.fubon.fo.customerhonortitle.service;

import java.util.Map;

import org.jeecgframework.core.common.service.CommonService;

public interface CustomerHonorTitleService extends CommonService{
	public Map<String,Object> findHonorByPremium(Double premium);
}
