package cn.com.fubon.fo.servicebranch.dao;

import java.util.List;
import java.util.Map;

/**
 * 服务网点查询类
 * @author patrick.z
 */
public interface ServiceBranchDao {
	/**
	 * 查询所有服务网点信息。
	 * @return
	 */
	Map<String, Object> getServiceNetWorkAll();
}
