package cn.com.fubon.fo.customerbind.dao;

import java.util.Map;

public interface CustomerBindDao {

	public Map<String, String> findCustomerInfo(String identifynumber,
			String customercname);

}
