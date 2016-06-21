package cn.com.fubon.fo.customerclaims.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.jeecgframework.core.extend.datasource.DataSourceContextHolder;
import org.jeecgframework.core.extend.datasource.DataSourceType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.fubon.fo.common.dao.impl.OracleGenericBaseCommonDao;
import cn.com.fubon.fo.customerclaims.service.ICustomerClaimsService;
import cn.com.fubon.fo.customermessage.service.impl.CustomerMessageServiceImpl;

/**
 * 客户理赔服务类
 * @author shanqi.wang
 *
 */

@Service("customerClaimsService")
@Transactional
public class CustomerClaimsServiceImpl extends OracleGenericBaseCommonDao implements
		ICustomerClaimsService {
	private static final Logger logger = Logger.getLogger(CustomerClaimsServiceImpl.class);

	@Override
	public List<Map<String, Object>> getClaimsPolicyAllInformation(String identifynumber, String insuredname){
		logger.info("getClaimsPolicyAllInformation(String identifynumber)"+identifynumber );	
		String sql =" select pol.policyno as policyno, "
                  +"       pol.applyName as applyName, "
                  +"       pol.insureName as insureName, "
                  +"       pol.licenseno as licenseno, "
                  +"       ma.startdate as startdate,"
                  +"       ma.enddate as enddate,"
                  +"       trunc(lo.FLOWINTIME) as claimsdate, "
                  +"       sate.sumthispaid as claimsamount, "
                  +"       lo.nodename as claimsStatus "
                  +"  from netquerylregist net, "
                  +"   (select lo.flowintime, lo.nodename, lo.registno     from NETQUERYLWFLOG lo, "
                  +"               (select flog.registno, max(flog.logno) as logno from NETQUERYLWFLOG flog  group by flog.registno) flog "
                  +"                 where lo.registno = flog.registno     and lo.logno = flog.logno) lo, "
                  +"     (select sat.policyno as policyno,sat.registno as registno, sum(sat.sumthispaid) as sumthispaid  from NETQUERYLCOMPENSATE sat  group by sat.policyno ,sat.registno) sate, "
                  +"     (select app.policyno, "
                  +"               app.insuredname as applyName, "
                  +"               ins.insuredname as insureName, "
                  +"              car.licenseno "
                  +"          from (select ins.policyno, ins.insuredname insuredname  from NETQUERYINSURED ins   where ins.insuredflag = 2) app, "
                  +"              (select ins.policyno,   to_char(wmsys.wm_concat(distinct(ins.insuredname))) insuredname "
                  +"                  from NETQUERYINSURED ins  where ins.insuredflag = 1 "
                  +"                   and ins.policyno in  (select distinct ins.policyno   from ecomm_netqueryinsured ins   where ins.identifynumber=? and ins.insuredname=?)  and  exists (select 1 from NETQUERYINSURED net having net.policyno=ins.policyno and count(net.policyno) <10 group by net.policyno ) group by ins.policyno) ins, "
                  +"               netquerycitem_car car "
                  +"         where app.policyno = ins.policyno "
                  +"           and ins.policyno = car.policyno(+)) pol , "
                  +"          ( select distinct  ma.policyno , ma.startdate,ma.enddate from NETQUERYCMAIN  ma  ) ma "
                  +" where pol.policyno = net.policyno "
                  +"   and pol.policyno=ma.policyno "
                  +"   and net.registno=sate.registno(+) "
                  +"   and net.policyno = sate.policyno(+) "
                  +"   and net.registno=lo.registno  "
                  +" order by pol.policyno, lo.FLOWINTIME desc ";
	List<Map<String, Object>> returnList= this.findForJdbc(sql, new String[]{identifynumber,insuredname} );		
		return returnList;
	}

}
