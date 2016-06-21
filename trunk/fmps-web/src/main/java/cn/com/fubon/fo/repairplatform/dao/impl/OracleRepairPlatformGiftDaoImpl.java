package cn.com.fubon.fo.repairplatform.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import cn.com.fubon.fo.common.dao.impl.OracleGenericBaseCommonDao;
import cn.com.fubon.fo.repairplatform.dao.OracleRepairPlatformGiftDao;

/**
 * @author guojunjie
 */
@SuppressWarnings("rawtypes")
@Repository("oracleRepairPlatformGiftDao")
public class OracleRepairPlatformGiftDaoImpl extends OracleGenericBaseCommonDao
		implements OracleRepairPlatformGiftDao {

	private static final Logger logger = Logger
			.getLogger(OracleRepairPlatformGiftDaoImpl.class);

	public List<Map<String, Object>> findRepairPlatformGift(
			String identifynumber, String customercname) {
		String sql = "select * from ecomm_netqueryinsured where identifynumber=? and customercname=? ";
		return this.findForJdbc(sql, identifynumber, customercname);
	}
}
