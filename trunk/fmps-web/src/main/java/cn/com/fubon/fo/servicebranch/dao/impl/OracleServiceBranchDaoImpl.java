package cn.com.fubon.fo.servicebranch.dao.impl;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import cn.com.fubon.fo.common.dao.impl.OracleGenericBaseCommonDao;
import cn.com.fubon.fo.servicebranch.dao.ServiceBranchDao;
/**
 * @author patrick.z
 */
@SuppressWarnings({ "rawtypes", "unchecked" })
@Repository("oracleServiceBranchDao")
public class OracleServiceBranchDaoImpl extends OracleGenericBaseCommonDao
		implements ServiceBranchDao {
	
	private static final Logger logger = Logger
			.getLogger(OracleServiceBranchDaoImpl.class);
	
	@Override
	public Map<String, Object> getServiceNetWorkAll() {
		Map<String, Object> serviceNetWorks = new LinkedHashMap<String, Object>();
		
		List<Map<String, String>> areaList = this.findForJdbc("select area, min(openingdate) openingdate from netquerydservicenetwork group by area order by openingdate");
		for(Map<String, String> area : areaList){
			List<Map<String, String>> serviceNetWorksByArea = this.findForJdbc("select networkname,phonenumber,address from netquerydservicenetwork where area = ? order by openingdate", area.get("area"));
			serviceNetWorks.put((String)area.get("area"), serviceNetWorksByArea);
		}
		return serviceNetWorks;
	}

}
