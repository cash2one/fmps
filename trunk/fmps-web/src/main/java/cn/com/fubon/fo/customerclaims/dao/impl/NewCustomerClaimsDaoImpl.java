package cn.com.fubon.fo.customerclaims.dao.impl;

import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import cn.com.fubon.fo.common.dao.impl.OracleGenericBaseCommonDao;
import cn.com.fubon.fo.customerclaims.dao.NewCustomerClaimsDao;

/**
 * 
 * @author fbxmn07
 *
 */
@SuppressWarnings("rawtypes")
@Repository("oracleNewCustomerClaimsDao")
public class NewCustomerClaimsDaoImpl extends OracleGenericBaseCommonDao implements NewCustomerClaimsDao {
	
	private static final Logger logger = Logger.getLogger(NewCustomerClaimsDaoImpl.class);
	
	@Override
	public List<Map<String, Object>> getIndexInfo(String insuredname,String identifynumber) {
		StringBuffer sql = new StringBuffer();
		sql.append(" select distinct c.ID, ");
		sql.append("  c.title, ");
		sql.append("  c.remark, ");
		sql.append("  c.insuredname, ");
		sql.append("  c.identifynumber, ");
		sql.append("  c.registno, ");
		sql.append("  c.weixin_nodename nodename, ");
		sql.append("  c.current_desc, ");
		sql.append("  c.flowintime, ");
		sql.append("  c.claimcasefee, ");
		sql.append("  extract(year from r.reportdate) || '年' as reportyear, ");
		sql.append("  to_char(flowintime, 'YYYY\"年\"MM\"月\"DD\"日\"HH24\"时\"MI\"分\"') flowintime ");
		sql.append("  from weixin_claim_record c, netquerylregist r ");
		sql.append(" where c.registno = r.registno ");
		sql.append("   and c.insuredname = ? ");
		sql.append("   and c.identifynumber = ? and c.weixin_nodename is not null ");
		sql.append(" order by c.flowintime desc ");
		
		List<Map<String, Object>> indexList = this.findForJdbc(sql.toString(), insuredname,identifynumber);
		if (indexList == null || indexList.isEmpty()){
			logger.info(sql.toString() + "\n==>未查询理赔信息,insuredname==>" + insuredname + ",identifynumber==>" + identifynumber);
			return null;
		}
		return indexList;
	}

	@Override
	public List<Map<String, Object>> getDetailInfo(String registno) {
		StringBuffer sql = new StringBuffer();
		sql.append(" select weixin_nodename nodename, ");
		sql.append("       nodedesc, ");
		sql.append("       to_char(flowintime, 'YYYY\"年\"MM\"月\"DD\"日\"HH24\"时\"MI\"分\"') flowintime ");
		sql.append("  from (select row_number() over(partition by weixin_nodename order by flowintime desc) rn, ");
		sql.append("               weixin_nodename, ");
		sql.append("               nodedesc, ");
		sql.append("               flowintime ");
		sql.append("          from weixin_claim_node_log ");
		sql.append("         WHERE registno = ? ");
		sql.append("         order by flowintime) ");
		sql.append(" where rn = 1 ");
 
		List<Map<String, Object>> detailList = this.findForJdbc(sql.toString(),registno);
		if (detailList != null && !detailList.isEmpty()){
			return detailList;
		}
		logger.info(sql.toString() + "\n==>未查询理赔信息,registno==>" + registno);
		return null;
	}

	@Override
	public Map<String, Object> getClaimRecordInfo(String id) {
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT distinct c.title, ");
		sql.append("     c.remark, ");
		sql.append("     c.insuredname, ");
		sql.append("     c.identifynumber, ");
		sql.append("     c.registno, ");
		sql.append("     c.weixin_nodename nodename, ");
		sql.append("     c.flowintime, ");
		sql.append("     c.claimcasefee, ");
		sql.append("     c.current_desc ");
		sql.append("   FROM weixin_claim_record c, netquerylregist r ");
		sql.append("  WHERE c.registno = r.registno ");
		sql.append("    and c.ID = ? ");
		
		Map<String, Object> infoMap = this.findOneForJdbc(sql.toString(), id);
		if(infoMap!=null && infoMap.size() !=0){
			return infoMap;
		}
		logger.info(sql.toString() + "\n==>未查询理赔信息,id==>" + id);
		return null;
	}

}
