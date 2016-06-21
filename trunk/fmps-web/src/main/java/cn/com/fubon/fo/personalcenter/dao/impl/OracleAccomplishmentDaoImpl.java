package cn.com.fubon.fo.personalcenter.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import cn.com.fubon.fo.common.dao.impl.OracleGenericBaseCommonDao;
import cn.com.fubon.fo.personalcenter.dao.AccomplishmentDao;

/**
 * @author patrick.z
 */
@SuppressWarnings({ "rawtypes" })
@Repository("oracleAccomplishmentDao")
public class OracleAccomplishmentDaoImpl extends OracleGenericBaseCommonDao
		implements AccomplishmentDao {
	private static final Logger logger = Logger
			.getLogger(OracleAccomplishmentDaoImpl.class);

	@Override
	public List<Map<String, Object>> getAccomplishmentAllByCutomerId(
			String customerCode) {
	
		logger.info("getAccomplishmentAllByCutomerId(String customerCode)" + customerCode);
		StringBuilder sqlStrBuilder = new StringBuilder("");
		sqlStrBuilder.append("select to_char(achv_time, 'mm.dd') as achv_month,");
		sqlStrBuilder.append("	 		achv_name,");
		sqlStrBuilder.append("	 		to_char(achv_time, 'yyyy') as achv_year,");
        sqlStrBuilder.append("	 		achv_time as achv_date,");
		sqlStrBuilder.append("    		achv_describe");
		sqlStrBuilder.append("      	from weixin_achievement_info_show");
		sqlStrBuilder.append("      where 1=1");
		sqlStrBuilder.append(" 		and customercode=? ");
		sqlStrBuilder.append("		order by achv_date desc");
		
		List<Map<String, Object>> accomplishmentList = this.findForJdbc(sqlStrBuilder.toString(), new String[] {customerCode});
		logger.info("成就查询  Sql:" + sqlStrBuilder.toString() + "\n");
		return accomplishmentList;
	}

}
