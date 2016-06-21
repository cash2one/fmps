package cn.com.fubon.fo.personalcenter.service;

import java.util.List;
import java.util.Map;

import org.jeecgframework.core.common.service.CommonService;

/**
 * 客户成就查询类
 * 
 * @author patrick.z
 */
public interface AccomplishmentService extends CommonService {
	/**
	 * 根据 客户号查询成就信息。
	 * 
	 * @param customerCode
	 * @return
	 */
	List<Map<String, Object>> getAccomplishmentAllByCutomerId(
			String customerCode);
}
