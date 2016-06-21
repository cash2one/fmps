package cn.com.fubon.fo.personalcenter.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.fubon.fo.personalcenter.dao.AccomplishmentDao;
import cn.com.fubon.fo.personalcenter.service.AccomplishmentService;

@Service("accomplishmentService")
@Transactional
public class AccomplishmentServiceImpl extends CommonServiceImpl implements
		AccomplishmentService {
	@Resource
	private AccomplishmentDao oracleAccomplishmentDao;

	@Override
	public List<Map<String, Object>> getAccomplishmentAllByCutomerId(
			String customerCode) {
		// TODO Auto-generated method stub
		return oracleAccomplishmentDao.getAccomplishmentAllByCutomerId(customerCode);
	}

}
