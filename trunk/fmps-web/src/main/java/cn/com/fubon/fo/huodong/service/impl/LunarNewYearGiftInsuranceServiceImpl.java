package cn.com.fubon.fo.huodong.service.impl;

import java.net.SocketException;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.jeecgframework.core.util.oConvertUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.fubon.fo.huodong.service.LunarNewYearGiftInsuranceService;


@Service("lunarNewYearGiftInsuranceService")
@Transactional
public class LunarNewYearGiftInsuranceServiceImpl extends CommonServiceImpl implements LunarNewYearGiftInsuranceService {

	private static final Logger logger = Logger.getLogger(LunarNewYearGiftInsuranceServiceImpl.class);

	@Override
	public List<Map<String, Object>> getLunarNewYearGiftInsuranceList() {
		String currentIp = "";
		try {
			currentIp = oConvertUtils.getRealIp();
		} catch (SocketException e) {
			logger.error("获取当前ip异常："+e);
		}
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT u.openid, u.customercname, u.identifynumber, u.phonenum as mobile, u.ip, re.huodongid, sum(re.amount) as totalamount ");
		sql.append("   FROM (SELECT openid, sponsor, customercname, identifynumber, phonenum, ip ");
		sql.append("           from weixin_huodong_record ");
		sql.append("          where huodongid = '8a828edfedfre68475034fd3dca5799634' ");
		sql.append("            and openid = sponsor ");
		sql.append("            and customercname is not null ");
		sql.append("            and identifynumber is not null ");
		sql.append("            and phonenum is not null ");
		sql.append("            and ip = ?) u, ");
		sql.append("        weixin_huodong_record re ");
		sql.append("  where re.huodongid = '8a828edfedfre68475034fd3dca5799634' ");	//春节活动:8a828edfedfre68475034fd3dca5799634
		sql.append("    and u.openid = re.sponsor ");
		sql.append("    and not exists ");
		sql.append("    (select policy.openid ");
		sql.append("             from weixin_policy policy ");
		sql.append("            where policy.openid = re.sponsor ");
		sql.append("              and policy.planid = '8a8195b3523360c3015233aac8ee001a' "); //赠送意外险1个月计划id:8a8195b3523360c3015233aac8ee001a
		sql.append("              and policy.huodongid = '8a828edfedfre68475034fd3dca5799634') ");
		sql.append("    group by re.sponsor ");
		logger.info("春节赠险：获取保存到保单表的新数据列表sql(getRealIp:"+currentIp+",getIp:"+oConvertUtils.getIp()+"):" + sql.toString());
		
	 	List<Map<String, Object>> list = this.findForJdbc(sql.toString(),currentIp);
	 	
		return list;
	}
	
	@Override
	public List<Map<String, Object>> getLunarNewYearPolicyList() {
		String currentIp = "";
		try {
			currentIp = oConvertUtils.getRealIp();
		} catch (SocketException e) {
			logger.error("获取当前ip异常："+e);
		}
		StringBuffer sql = new StringBuffer();
		sql.append(" select policy.orderno ");
		sql.append("   from weixin_policy policy , weixin_huodong_record re ");
		sql.append("  where policy.planid = '8a8195b3523360c3015233aac8ee001a' "); //赠送意外险1个月计划id:8a8195b3523360c3015233aac8ee001a
		sql.append("    and policy.huodongid = '8a828edfedfre68475034fd3dca5799634' ");
		sql.append("    and (policy.policyno is null or policy.policyno ='') ");
		sql.append("    and policy.openid = re.sponsor ");
		sql.append("    and re.ip = ? ");
		logger.info("春节赠险：获取保单(尚未承保成功)列表sql(getRealIp:"+currentIp+",getIp:"+oConvertUtils.getIp()+"):" + sql.toString());
		
	 	List<Map<String, Object>> policyList= this.findForJdbc(sql.toString(),currentIp);
		return policyList;
	}

	@Override
	public Map<String, Object> getTotalAmount(String huodongid,String openid) {
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT re.sponsor,re.openid,re.huodongid,sum(re.amount) as totalamount ");
		sql.append("   FROM weixin_huodong_record re ");
		sql.append("  WHERE re.huodongid = ? ");
		sql.append("    AND re.sponsor = ? ");
		sql.append("  group by re.sponsor ");
		logger.info("春节赠险：获取总保额sql:" + sql.toString());
		
		Map<String, Object> map= this.findOneForJdbc(sql.toString(), huodongid,openid);
		return map;
	}
	
}
