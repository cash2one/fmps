package cn.com.fubon.fo.personalcenter.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.jeecgframework.core.common.dao.impl.GenericBaseCommonDao;
import org.springframework.stereotype.Repository;

import cn.com.fubon.fo.personalcenter.dao.AccomplishmentDao;

/**
 * @author patrick.z
 */
@SuppressWarnings({ "rawtypes", "unchecked" })
@Repository("accomplishmentDao")
public class AccomplishmentDaoImpl extends GenericBaseCommonDao implements
		AccomplishmentDao {
	private static final Logger logger = Logger
			.getLogger(AccomplishmentDaoImpl.class);
	
	@Override
	public List<Map<String, Object>> getAccomplishmentAllByCutomerId(
			String customerCode) {
		return null;
	}

}
