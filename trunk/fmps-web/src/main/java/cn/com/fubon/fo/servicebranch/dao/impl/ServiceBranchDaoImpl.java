package cn.com.fubon.fo.servicebranch.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.jeecgframework.core.common.dao.impl.GenericBaseCommonDao;
import org.springframework.stereotype.Repository;

import cn.com.fubon.fo.servicebranch.dao.ServiceBranchDao;

/**
 * @author patrick.z
 */
@Repository("serviceBranchDao")
public class ServiceBranchDaoImpl extends GenericBaseCommonDao implements
		ServiceBranchDao {
	private static final Logger logger = Logger
			.getLogger(ServiceBranchDaoImpl.class);

	@Override
	public Map<String, Object> getServiceNetWorkAll() {
		// TODO Auto-generated method stub
		return null;
	}


}
