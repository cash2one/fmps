package cn.com.fubon.fo.servicebranch.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.fubon.fo.servicebranch.dao.ServiceBranchDao;
import cn.com.fubon.fo.servicebranch.service.ServiceBranchService;

@Service("serviceBranchService")
@Transactional
public class ServiceBranchServiceImpl extends CommonServiceImpl implements
		ServiceBranchService {
	@Resource
	private ServiceBranchDao oracleServiceBranchDao;
	
	@Override
	public Map<String,Object> getServiceNetWorkAll() {
		return oracleServiceBranchDao.getServiceNetWorkAll();
	}

}
