package cn.com.fubon.fo.personalcenter.dao;

import java.util.List;
import java.util.Map;

/**
 * 成就查询类
 * @author patrick.z
 */
public interface AccomplishmentDao {
	/**
	 * 根据 客户号查询成就信息。
	 * @param customerCode
	 * @return
	 */
	List<Map<String, Object>> getAccomplishmentAllByCutomerId(String customerCode);
}
