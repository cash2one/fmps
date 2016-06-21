package cn.com.fubon.fo.customerbind.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import cn.com.fubon.fo.common.dao.impl.OracleGenericBaseCommonDao;
import cn.com.fubon.fo.customerbind.dao.CustomerBindDao;

@SuppressWarnings("rawtypes")
@Repository("oracleCustomerBindDao")
public class OracleCustomerBindDaoImpl extends OracleGenericBaseCommonDao
		implements CustomerBindDao {

	private static final Logger logger = Logger
			.getLogger(OracleCustomerBindDaoImpl.class);

	/**
	 * 根据证件号,客户名称得到客户信息用于绑定weixin_gzuserinfo表做更新
	 */
	@Override
	public Map<String, String> findCustomerInfo(String identifynumber,
			String customercname) {

		Map<String, String> customerinfo = findCustomerInfoOther(
				identifynumber, customercname);

		return customerinfo;
	}

	/**
	 * 非车:证件号+客户名称
	 */
	@SuppressWarnings("unchecked")
	public Map<String, String> findCustomerInfoOther(String identifynumber,
			String customercname) {

		StringBuilder sql = new StringBuilder("");
		Map<String, String> customerinfo = null;
		
		//查出证件号码和客户名称对应的所有客户代码，用逗号分隔
		sql.append(" select insuredname, \n")
		.append("	 identifynumber, \n")
		.append("	 to_char(wmsys.wm_concat(distinct(insuredcode))) as customercode \n")
		.append("	from ecomm_netqueryinsured i \n")
		.append("	where 1=1 \n")
		.append("	and i.insuredname = ? \n")
		.append("	and i.identifynumber = ? \n")
		.append("	group by i.insuredname, i.identifynumber \n");

		List<Map<String, String>> list = this.findForJdbc(sql.toString(),
				customercname, identifynumber.toUpperCase());
		String loginfo = "insuredname=>" + customercname
				+ ";identifynumber=>" + identifynumber.toUpperCase();

		if (list != null && list.size() > 0) {
			customerinfo = list.get(0);
			loginfo = "\n" + sql + "\n";
		} else {
			loginfo = "\n" + sql + "\n未查询出数据。" + loginfo;
		}

		logger.info(loginfo);

		return customerinfo;
	}

}
