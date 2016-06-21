package cn.com.fubon.fo.personalcenter.dao.impl;

import java.util.Map;
import org.apache.log4j.Logger;
import org.jeecgframework.core.common.dao.impl.GenericBaseCommonDao;
import org.springframework.stereotype.Repository;
import cn.com.fubon.fo.personalcenter.dao.PersonalCenterDao;

/**
 * @author patrick.z
 */
@SuppressWarnings({ "rawtypes", "unchecked" })
@Repository("personalCenterDao")
public class PersonalCenterDaoImpl extends GenericBaseCommonDao implements
		PersonalCenterDao {
	private static final Logger logger = Logger
			.getLogger(PersonalCenterDaoImpl.class);

	@Override
	public Map<String, String> getCustomerInfoByOpenId(String openid) {
		logger.info("getCustomerInfoByOpenId(String openid)" + openid);
		String sqlString = " SELECT headimgurl,nickname,identifynumber,customercname,customerSex,sex FROM weixin_gzuserinfo where openid = ? ";
		String loginfo = "";
		Map<String, String> customerMap = this
				.findOneForJdbc(sqlString, openid);
		if (customerMap == null || customerMap.isEmpty()) {
			loginfo = "\n" + sqlString + "\n未查询出数据。";
		} else {
			loginfo = "\n" + sqlString;
		}

		logger.info(loginfo);

		return customerMap;
	}
}
