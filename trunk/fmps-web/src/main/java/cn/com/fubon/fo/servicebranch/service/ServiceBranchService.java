package cn.com.fubon.fo.servicebranch.service;

import java.util.List;
import java.util.Map;

import org.jeecgframework.core.common.service.CommonService;

/**
 * 服务网点查询类
 * @author patrick.z
 */
public interface ServiceBranchService extends CommonService{
	/**
	 * 查询所有服务网点信息。
	 * @return
	 */
	Map<String, Object> getServiceNetWorkAll();
}
