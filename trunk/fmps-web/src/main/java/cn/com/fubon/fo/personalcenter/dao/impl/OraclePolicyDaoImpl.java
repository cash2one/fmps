package cn.com.fubon.fo.personalcenter.dao.impl;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import weixin.util.DateUtils;
import cn.com.fubon.fo.common.dao.impl.OracleGenericBaseCommonDao;
import cn.com.fubon.fo.personalcenter.dao.PolicyDao;

/**
 * @author fangfang.guo
 */
@SuppressWarnings("rawtypes")
@Repository("oraclePolicyDao")
public class OraclePolicyDaoImpl extends OracleGenericBaseCommonDao
		implements PolicyDao {

	private static final Logger logger = Logger.getLogger(OraclePolicyDaoImpl.class);

	@Override
	public List<Map<String, Object>> findAllCars(String customercname,
			String identifynumber) {
		StringBuilder sql = new StringBuilder();
		sql.append("select distinct c.licenseno, c.brandname, c.frameno, c.licensed ");
		sql.append("  from ecomm_netqueryinsured i, netquerycitem_car c ");
		sql.append(" where i.policyno = c.policyno");
		sql.append(" and i.insuredname = ?");
		sql.append(" and i.identifynumber = ?");
		List<Map<String, Object>> cars = this.findForJdbc(sql.toString(), customercname,identifynumber);
		if(cars == null || cars.isEmpty()){
			logger.info(sql.toString() + "\n==>未查询到车辆信息,insuredname==>" + customercname
					+ ",identifynumber==>" + identifynumber);
		}
		return cars;
	}

	@Override
	public List findAllPolicys(String identifyNumber,
			String customerCname,String[] policynoList,String telesaledate,String telesalechannel) {
//		String temp = "("+policynoList+")";
		Map map = new HashMap();
		StringBuilder sql = new StringBuilder();

		sql.append("select distinct i.policyno as policyno, ");
		sql.append("                c.licenseno as licenseno, ");
		sql.append("                m.riskshortname, ");
		sql.append("                case ");
		sql.append("                  when c.licenseno is null then ");
		sql.append("                   m.riskcname ");
		sql.append("                  else ");
		sql.append("                   m.riskcname || '(' || c.licenseno || ')' ");
		sql.append("                end as policyname, ");
		sql.append("                '有效期至 ' || to_char(m.enddate, 'YYYY\"年\"MM\"月\"DD\"日\"') as enddate, ");
		//endhour为保单终止时间中的小时,0<=endhour<=24,decode格式化成'HH24'
		sql.append("                decode(length(m.endhour), ");
		sql.append("                       0, ");
		sql.append("                       '00', ");
		sql.append("                       1, ");
		sql.append("                       '0' || m.endhour, ");
		sql.append("                       m.endhour) endhour, ");
		sql.append("                m.operatedate, ");
		sql.append("                extract(year from m.operatedate) || '年' as operateyear, ");
		//case when是为了拼接enddate和endhour字段,跟sysdate比较,返回是否已过期
		sql.append("                case ");
		sql.append("                  when to_date(to_char(m.enddate, 'yyyy-mm-dd') || ' ' || ");
		sql.append("                               decode(length(m.endhour), ");
		sql.append("                                      0, ");
		sql.append("                                      '00:00:00', ");
		sql.append("                                      decode((m.endhour), ");
		sql.append("                                             24, ");
		sql.append("                                             '23:59:59', ");
		sql.append("                                             m.endhour || ':00:00')), ");
		sql.append("                               'yyyy-mm-dd hh24:mi:ss') - sysdate > 0 then ");
		sql.append("                   null ");
		sql.append("                  else ");
		sql.append("                   '已过期' ");
		sql.append("                end as status,1 m");
		if(StringUtils.isNotBlank(telesaledate)&&StringUtils.isNotBlank(telesalechannel)){
			sql.append(",case when to_char(m.startdate,'YYYY-MM-DD') >:telesaledate ");
			map.put("telesaledate",telesaledate);
			sql.append("  and ch.businessnature =:telesalechannel ");
			map.put("telesalechannel",telesalechannel);
			sql.append("  and m.classcode <>'05' and p.productcode is not null then '1' else '0' end as telesalepolicy,p.productcode  ");
		}
		sql.append("  from ecomm_netqueryinsured i, netquerycmain m, netquerycitem_car c, netquerychannel ch,net_prpcproduct p ");
		sql.append(" where i.policyno = m.policyno ");
		sql.append("   and i.policyno = c.policyno(+) ");
		if(StringUtils.isNotBlank(telesaledate)&&StringUtils.isNotBlank(telesalechannel)){
			sql.append("    and m.policyno=ch.certino(+) ");
			sql.append("    and m.policyno = p.policyno(+) "); 
		}
		if(StringUtils.isNotBlank(identifyNumber)){
			sql.append(" and i.identifynumber =:identifyNumber ");
			map.put("identifyNumber",identifyNumber);
		}
		if(StringUtils.isNotBlank(customerCname)){
			sql.append(" and i.insuredname =:customerCname ");
			map.put("customerCname",customerCname);
		}
		if(policynoList !=null){
			sql.append(" and m.policyno NOT IN :policynoList ");
			map.put("policynoList",policynoList);
		}
		sql.append(" order by m.operatedate desc ");
		List policys = null;
		if(policynoList !=null){
//			 policys = this.findForJdbcSql(sql.toString(),new String[]{identifyNumber,customerCname,policynoList},new int[]{java.sql.Types.VARCHAR,java.sql.Types.VARCHAR,java.sql.Types.VARCHAR});
			policys = this.getSession().createSQLQuery(sql.toString()).setProperties(map).list();
		}else{
//			 policys = this.findForJdbc(sql.toString(), identifyNumber,customerCname);
			 policys = this.getSession().createSQLQuery(sql.toString()).setProperties(map).list();
		}
		if(policys == null || policys.isEmpty()){
			logger.info(sql.toString() + "\n==>未查询到保单列表,insuredname==>" + customerCname
					+ ",identifynumber==>" + identifyNumber);
		}
		return policys;
	}

	@Override
	public Map<String, String> findPolicyDetailHead(String policyno,boolean isCar) {
		StringBuilder sql = new StringBuilder();
		
		if(isCar){
			//车险保单头
			sql.append("select m.policyno, ");
			sql.append("       m.riskshortname, ");
			sql.append("       m.insuredname, ");
			sql.append("       c.licenseno, ");
			sql.append("       to_char(m.startdate, 'YYYY\"年\"MM\"月\"DD\"日\"') startdate, ");
			sql.append("       to_char(m.enddate, 'YYYY\"年\"MM\"月\"DD\"日\"') enddate, ");
			//endhour为保单终止时间中的小时,0<=endhour<=24,decode格式化成'HH24'
			sql.append("       decode(length(m.endhour), 0, '00', 1, '0' || m.endhour, m.endhour) endhour, ");
			//case when是为了拼接enddate和endhour字段,跟sysdate比较,返回是否已过期
			sql.append("       case ");
			sql.append("         when to_date(to_char(m.enddate, 'yyyy-mm-dd') || ' ' || ");
			sql.append("                      decode(length(m.endhour), ");
			sql.append("                             0, ");
			sql.append("                             '00:00:00', ");
			sql.append("                             decode((m.endhour), ");
			sql.append("                                    24, ");
			sql.append("                                    '23:59:59', ");
			sql.append("                                    m.endhour || ':00:00')), ");
			sql.append("                      'yyyy-mm-dd hh24:mi:ss') - sysdate > 0 then ");
			sql.append("          null ");
			sql.append("         else ");
			sql.append("          '已过期' ");
			sql.append("       end status, ");
			sql.append("       c.frameno, ");
			sql.append("       decode(c.licensed, '1', '1', '0') oraclelicensed, ");
			sql.append("       m.sumpremium ");
			sql.append("  from netquerycmain m, netquerycitem_car c ");
			sql.append(" where m.policyno = c.policyno ");
			sql.append("   and m.policyno = ? ");
			
		} else{
			//非车保单头
			sql.append("select m.policyno, ");
			sql.append("       m.riskshortname,  ");
			sql.append("       m.applyname,  ");
			sql.append("       m.insuredname,  ");
			sql.append("       m.identifynumber,  ");
			sql.append("       to_char(m.startdate, 'YYYY\"年\"MM\"月\"DD\"日\"') startdate,  ");
			sql.append("       to_char(m.enddate, 'YYYY\"年\"MM\"月\"DD\"日\"') enddate,  ");
			//endhour为保单终止时间中的小时,0<=endhour<=24,decode格式化成'HH24'
			sql.append("       decode(length(m.endhour), 0, '00', 1, '0' || m.endhour, m.endhour) endhour, ");
			//case when是为了拼接enddate和endhour字段,跟sysdate比较,返回是否已过期
			sql.append("       case ");
			sql.append("         when to_date(to_char(m.enddate, 'yyyy-mm-dd') || ' ' || ");
			sql.append("                      decode(length(m.endhour), ");
			sql.append("                             0, ");
			sql.append("                             '00:00:00', ");
			sql.append("                             decode((m.endhour), ");
			sql.append("                                    24, ");
			sql.append("                                    '23:59:59', ");
			sql.append("                                    m.endhour || ':00:00')), ");
			sql.append("                      'yyyy-mm-dd hh24:mi:ss') - sysdate > 0 then ");
			sql.append("          null ");
			sql.append("         else ");
			sql.append("          '已过期' ");
			sql.append("       end status, ");
			sql.append("       case ");
			sql.append("         when c.businessnature='99' then  ");  //赠险
			sql.append("         0.00 ");
			sql.append("         else ");
			sql.append("         m.sumpremium  ");
			sql.append("       end sumpremium ");
			sql.append("  from netquerycmain m,netquerychannel c ");
			sql.append(" where m.policyno=c.certino(+) ");
			sql.append(" and m.policyno = ?  ");
		}
		
		Map<String, String> policyHead = this.findOneForJdbc(sql.toString(), policyno);
		if(policyHead == null || policyHead.isEmpty()){
			logger.info(sql.toString() + "\n==>未查询到保单头,policyno==>" + policyno);
		}
		return policyHead;
	}

	@Override
	public List<Map<String, String>> findPolicyDetailBody(String policyno,boolean isCar) {
		StringBuilder sql = new StringBuilder();
		List<Map<String, String>> policyBodys = null;
		if(isCar){
			//车险保单体,包括:险种名称,不计免赔,保额,费用
			sql.append("select distinct kind.itemkindno,kind.kindname, ");
			sql.append("       kind.amount, ");
			sql.append("       kind.premium, ");
			sql.append("       decode(SUBSTR(kind.flag, 5, 1), ");
			sql.append("              '1', ");
			sql.append("              '是', ");
			sql.append("              decode(instr('A,B,D11,D12,G,D2,L,X1,X,V1', kind.kindcode), ");
			sql.append("                     0, ");
			sql.append("                     '-', ");
			sql.append("                     '否')) isdeductible   ");                    
			sql.append("  from netquerycitem_kind kind, netquerycmain cmain ");
			sql.append(" where kind.policyno = cmain.policyno ");
			sql.append("   and cmain.classcode = '05' ");
			sql.append("   and nvl(cmain.coinsflag,'-') != '2' ");
			sql.append("   and cmain.policyno = ? ");
			sql.append("union ");
			sql.append("select null,'车船税',null,tax.sumpaytax,null from netqueryccarshiptax tax,netquerycmain cmain ");
			sql.append("where tax.policyno=cmain.policyno  ");
			sql.append("and nvl(cmain.coinsflag,'-') != '2'  ");
			sql.append("and cmain.policyno = ? ");
			sql.append("order by itemkindno ");
			policyBodys = this.findForJdbc(sql.toString(), policyno,policyno);
			
		} else{
			//非车保单体,包括:险种名称,保障信息,保额
			sql.append("select distinct kindname,itemdetailname,amount from netquerycitem_kind where policyno=?");
			policyBodys = this.findForJdbc(sql.toString(), policyno);
		}
		
		return policyBodys;
	}

	
	@Override
	public Map<String, Object> findPolicyByTeleSale(String policyno,String date,String channel) {
	StringBuilder sql = new StringBuilder();
			//非车保单
			sql.append(" select m.policyno,m.startdate,m.enddate, p.productcode,c.businessnature,c.businessnaturename ");
			sql.append(" from netquerycmain m,netquerychannel c,net_prpcproduct p ");
			sql.append(" where m.policyno=c.certino(+) ");
			sql.append(" and m.policyno = p.policyno(+) ");
			sql.append(" and m.policyno = ?  ");
			sql.append(" and to_char(m.startdate,'YYYY-MM-DD') > ?  ");
			sql.append(" and c.businessnature = ?  ");
			sql.append(" and m.classcode <>'05' ");
			sql.append(" and p.productcode is not null  ");
		Map<String, Object> policyInfo = this.findOneForJdbc(sql.toString(), policyno,date,channel);
		if(policyInfo == null || policyInfo.isEmpty()){
			logger.info(sql.toString() + "\n==>未查询到符合的电子表单,policyno==>" + policyno+",date==>" + date+",channel==>" + channel);
		}
		return policyInfo;
	}
	
	@Override
	public  List<Map<String, Object>> findNotCarPolicyByTeleSale(String customerCname,String identifyNumber,String date,String channel) {
		StringBuilder sql = new StringBuilder();
		List<Map<String, Object>> policyInfos = null;
		//非车保单
		sql.append(" select distinct i.policyno,m.startdate,m.enddate, p.productcode,c.businessnature,c.businessnaturename ");
		sql.append(" from ecomm_netqueryinsured i, netquerycmain m,netquerychannel c,net_prpcproduct p ");
		sql.append(" where i.policyno = m.policyno ");
		sql.append(" and m.policyno=c.certino(+) ");
		sql.append(" and m.policyno = p.policyno(+) ");
		sql.append(" and i.insuredname = ?  ");
		sql.append(" and i.identifynumber = ?  ");
		sql.append(" and to_char(m.startdate,'YYYY-MM-DD') > ?  ");
		sql.append(" and c.businessnature = ?  ");
		sql.append(" and m.classcode <>'05' ");
		sql.append(" and p.productcode is not null  ");
		policyInfos = this.findForJdbc(sql.toString(), customerCname,identifyNumber,date,channel);
		return policyInfos;
	}
	
	
	@Override
	public  List<Map<String, Object>> findNotCarPolicyFifteenByTeleSale(String customerCname,String identifyNumber,String date,String channel,String fifteen) {
		StringBuilder sql = new StringBuilder();
		List<Map<String, Object>> policyInfos = null;
		//非车保单
		sql.append(" select distinct i.policyno,m.startdate,m.enddate,p.productcode,c.businessnature,c.businessnaturename ");
		sql.append(" from ecomm_netqueryinsured i,netquerycmain m,netquerychannel c,net_prpcproduct p ");
		sql.append(" where i.policyno = m.policyno ");
		sql.append(" and m.policyno=c.certino(+) ");
		sql.append(" and m.policyno = p.policyno(+) ");
		sql.append(" and i.insuredname = ?  ");
		sql.append(" and i.identifynumber = ?  ");
		sql.append(" and to_char(m.startdate,'YYYY-MM-DD') > ?  ");
		sql.append(" and c.businessnature = ?  ");
		sql.append(" and m.classcode <>'05' ");
		sql.append(" and p.productcode is not null  ");
		sql.append(" and ceil(To_date(sysdate)-(To_date(m.startdate)))= ? ");
		
		policyInfos = this.findForJdbc(sql.toString(), customerCname,identifyNumber,date,channel,fifteen);
		return policyInfos;
	}

	@SuppressWarnings("unchecked")
	@Override
	public BigDecimal getSumPremium(String policyno) {
		StringBuilder sql = new StringBuilder();		
		sql.append(" select sum( ma.sumpremium) as sumpremium from netquerycmain  ma where ma.policyno=?");		
		 Map<String, Object> sumpremiumMap=this.findOneForJdbc(sql.toString(),policyno);
		return (BigDecimal) sumpremiumMap.get("sumpremium");
	}


}
