package cn.com.fubon.fo.personalcenter.dao;

import java.util.Map;

/**
 * 个人中心类
 * 
 * @author patrick.z
 */
public interface PersonalCenterDao {

	/**
	 * 查询客户信息。
	 * @param openid
	 * @return
	 */
	Map<String, String> getCustomerInfoByOpenId(String openid);
}
