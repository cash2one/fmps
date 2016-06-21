package cn.com.fubon.fo.personalcenter.dao.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import cn.com.fubon.fo.common.dao.impl.OracleGenericBaseCommonDao;
import cn.com.fubon.fo.personalcenter.dao.CustomerPolicyDao;

/**
 * @author patrick.z
 */
@SuppressWarnings("rawtypes")
@Repository("oracleCustomerPolicyDao")
public class OracleCustomerPolicyDaoImpl extends OracleGenericBaseCommonDao
		implements CustomerPolicyDao {

	private static final Logger logger = Logger
			.getLogger(OracleCustomerPolicyDaoImpl.class);

	@SuppressWarnings("unchecked")
	@Override
	public List<Map<String, Object>> getCustomerCarPolicyAll(String identifynumber,String customercname,List<Map<String, Object>> riskCodes) {

		logger.info("getCustomerCarPolicyAll(String identifynumber,String customercname,String riskCodes)==>"
				+ identifynumber + "," + customercname + "," + Arrays.toString(riskCodes.toArray()));
		List<Map<String, Object>> customerPolicyList = null;
		
		StringBuilder sql = new StringBuilder("");
		sql.append(" select distinct cmain.policyno, ");
		sql.append("        cmain.startdate, ");
		sql.append("        cmain.enddate, ");
		sql.append("        cmain.insuredname, ");
		sql.append("        car.licenseno, ");
		sql.append("        car.licensed, ");
		sql.append("        car.frameno, ");
		sql.append("        kind.itemkindno, ");
		sql.append("        kind.kindname, ");
		sql.append("        kind.itemdetailname, ");
		sql.append("        kind.amount, ");
		sql.append("        kind.premium, ");
		sql.append("        cmain.sumPremium, ");
		sql.append("        kind.flag, ");
		sql.append("        decode(SUBSTR(kind.flag, 5, 1), ");
		sql.append("               '1', ");
		sql.append("               '是', ");
		sql.append("               decode(instr('A,B,D11,D12,G,D2,L,X1,X,V1', kind.kindcode), ");
		sql.append("                      0, ");
		sql.append("                      '-', ");
		sql.append("                      '否')) isdeductible ");                      
		sql.append("   from netquerycitem_kind kind, netquerycitem_car car, netquerycmain cmain, ecomm_netqueryinsured insured ");
		sql.append("  where kind.policyno = cmain.policyno ");
		sql.append("    and cmain.policyno = car.policyno ");
		sql.append("    and cmain.policyno = insured.policyno ");
		sql.append("    and insured.identifynumber = ? ");
		sql.append("    and insured.insuredname = ? ");
		sql.append("    and kind.riskcode in ( ");
		
		for (int i = 0; i < riskCodes.size(); i++) {
			if (i == riskCodes.size() - 1) {
				sql.append("?");
			} else {
				sql.append("?,");
			}
		}
		sql.append(" ) ");
		
		sql.append("    and nvl(cmain.coinsflag,'-') != '2' "); 
		sql.append(" union "); 
		sql.append(" select cmain.policyno,cmain.startdate, ");
		sql.append("        cmain.enddate, ");
		sql.append("        cmain.insuredname,null,null,null,null,'车船税',null,null,tax.sumpaytax,null,null,null  ");
		sql.append("	from netqueryccarshiptax tax,netquerycmain cmain, ");
		sql.append("        ecomm_netqueryinsured insured ");
		sql.append(" where tax.policyno=cmain.policyno  ");
		sql.append(" and cmain.policyno = insured.policyno ");
		sql.append(" and insured.identifynumber = ? ");
		sql.append(" and insured.insuredname = ? ");
		sql.append(" and nvl(cmain.coinsflag,'-') != '2'  ");
		sql.append(" order by enddate desc,policyno,itemkindno ");
	
		//参数
		List params = new ArrayList();
		params.add(identifynumber.toUpperCase());
		params.add(customercname);
		for (Map<String, Object> riskCode : riskCodes) {
			params.add(riskCode.get("risk_code"));
		}
		params.add(identifynumber.toUpperCase());
		params.add(customercname);
		
		customerPolicyList = this.findForJdbc(sql.toString(),params.toArray());
		logger.info("保单查询-车险 Sql:" + sql + "\n");

		return customerPolicyList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Map<String, Object>> getCustomerNotCarPolicyAll(String identifynumber,String customercname,List<Map<String, Object>> riskCodes) {
		
		logger.info("getCustomerNotCarPolicyAll(String identifynumber,String customercname,String riskCodes)==>"
				+ identifynumber + "," + customercname + "," + Arrays.toString(riskCodes.toArray()));
		List<Map<String, Object>> customerPolicyList = null;
		
		StringBuilder sql = new StringBuilder("");
		sql.append(" select distinct cmain.policyno, ");
		sql.append("        cmain.startdate, ");
		sql.append("        cmain.enddate, ");
		sql.append("        insured.insuredname, ");
		sql.append("        insured.identifynumber, ");
		sql.append("        kind.kindname, ");
		sql.append("        kind.itemdetailname, ");
		sql.append("        kind.amount, ");
		sql.append("        kind.premium, ");
		sql.append("        cmain.sumPremium ");
		//sql.append("        cmain.currencycname ");
		sql.append("        from netquerycitem_kind kind,netquerycmain cmain,ecomm_netqueryinsured insured ");
		sql.append("        where kind.policyno = cmain.policyno ");
		sql.append("        and cmain.policyno = insured.policyno ");
		sql.append("        and insured.identifynumber = ? ");
		sql.append("        and insured.insuredname = ? ");
		sql.append("        and cmain.riskcode in ( ");
		
		for (int i = 0; i < riskCodes.size(); i++) {
			if (i == riskCodes.size() - 1) {
				sql.append("?");
			} else {
				sql.append("?,");
			}
		}
		
		sql.append(" ) ");
		sql.append("        and nvl(cmain.coinsflag,'-') != '2' "); 
		sql.append(" union ");
		sql.append(" select distinct kind.policyno, ");
		sql.append("        cmain.startdate, ");
		sql.append("        cmain.enddate, ");
		sql.append("        insured.insuredname, ");
		sql.append("        insured.identifynumber, ");
		sql.append("        kind.kindname, ");
		sql.append("        kind.itemdetailname, ");
		sql.append("        kind.amount, ");
		sql.append("        kind.premium, ");
		sql.append("        cmain.sumPremium ");
		//sql.append("        cmain.currencycname ");
		sql.append("        from netquerycitem_kind kind,netquerycmain cmain,ecomm_netqueryinsured insured ");
		sql.append("        where kind.policyno = cmain.policyno ");
		sql.append("        and kind.policyno = insured.policyno ");
		sql.append("        and cmain.classcode='23'   ");                 //组合险才需要根据subriskcode取
		sql.append("        and insured.identifynumber = ? ");
		sql.append("        and insured.insuredname = ? ");
		sql.append("        and nvl(cmain.coinsflag,'-') != '2' ");
		sql.append("        and kind.subriskcode in ( ");
		
		for (int i = 0; i < riskCodes.size(); i++) {
			if (i == riskCodes.size() - 1) {
				sql.append("?");
			} else {
				sql.append("?,");
			}
		}
		sql.append(" ) ");
		
		sql.append("        order by enddate desc,policyno ");

		//参数
		List params = new ArrayList();
		params.add(identifynumber.toUpperCase());
		params.add(customercname);
		for (Map<String, Object> riskCode : riskCodes) {
			params.add(riskCode.get("risk_code"));
		}
		params.add(identifynumber.toUpperCase());
		params.add(customercname);
		for (Map<String, Object> riskCode : riskCodes) {
			params.add(riskCode.get("risk_code"));
		}
		
		customerPolicyList = this.findForJdbc(sql.toString(),params.toArray());
		logger.info("保单查询-非车险 Sql:" + sql + "\n");

		return customerPolicyList;
	}

	@Override
	public List<Map<String, Object>> getInsPlanCodeListByInsPlanCode(
			String insPlanCode) {
		// TODO Auto-generated method stub
		return null;
	}

}
