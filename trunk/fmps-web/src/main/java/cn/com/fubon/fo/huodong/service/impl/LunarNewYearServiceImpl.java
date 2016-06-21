package cn.com.fubon.fo.huodong.service.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import weixin.idea.huodong.entity.HdRecordEntity;
import cn.com.fubon.fo.huodong.entity.HuodongRecord;
import cn.com.fubon.fo.huodong.service.LunarNewYearService;


@Service("lunarNewYearService")
@Transactional
public class LunarNewYearServiceImpl extends CommonServiceImpl implements LunarNewYearService {

	private static final Logger logger = Logger.getLogger(LunarNewYearServiceImpl.class);
	
	@Override
	public boolean isFirstEnter(String huodongid, String openid) {
		String sql="  select   re.sponsor  from weixin_huodong_record re   where   re.huodongid=?  and re.sponsor=?  ";
	 	List<Map<String, Object>> friendList=this.findForJdbc(sql,huodongid,openid);
		if(friendList.size()==0){
			return true;
		}
		return false;
	   }
	
	public List<Map<String, Object>> getFriendList(String huodongid, String openid){
		String sql=" select inf.nickname,re.amount from weixin_huodong_record re ,weixin_gzuserinfo inf where re.openid=inf.openid and re.huodongid=? and re.sponsor=? and re.openid!=?  order by re.createdate desc ";
	 	List<Map<String, Object>> friendList=this.findForJdbc(sql,huodongid,openid,openid);
	 	return friendList;		
	}
	
	public  BigDecimal  getAmount(String huodongid, String openid){
		String sql="  select  sum(re.amount) as amount from weixin_huodong_record re   where  re.huodongid=? and re.sponsor=?  ";
	 	 Map<String, Object>  amountMap =this.findOneForJdbc(sql,huodongid,openid);
	 	return (BigDecimal) amountMap.get("amount");		
	}
	
	@Override
	public boolean isHelpHim(String sponsor, String huodongid, String openid){
		StringBuffer sql = new StringBuffer();
		sql.append(" select * ");
		sql.append("   from weixin_huodong_record ");
		sql.append("  where sponsor = ? ");
		sql.append("    and huodongid = ? ");
		sql.append("    and openid = ? ");
		logger.info("是否帮他抢过保额sql:" + sql.toString() + ",sponsor:"+sponsor+",huodongid:"+huodongid+",openid:"+openid);
		
	 	List<Map<String, Object>> list=this.findForJdbc(sql.toString(),sponsor,huodongid,openid);
		if(list.size()==1){
			return true;
		}
		return false;
	}

	@Override
	public BigDecimal getHelpHisAmount(String sponsor, String huodongid, String openid) {
		StringBuffer sql = new StringBuffer();
		sql.append(" select re.amount as amount ");
		sql.append("   from weixin_huodong_record re ");
		sql.append("  where sponsor = ? ");
		sql.append("    and huodongid = ? ");
		sql.append("    and openid = ? ");
		logger.info("获取帮他抢得保额sql:" + sql.toString() + ",sponsor:"+sponsor+",huodongid:"+huodongid+",openid:"+openid);
		
		Map<String, Object>  amountMap =this.findOneForJdbc(sql.toString(),sponsor,huodongid,openid);
	 	return (BigDecimal) amountMap.get("amount");		
	}

	@Override
	public Long getPremiumCount(String hdid) {
		String sql="  select  sum(re.amount) as amount from weixin_huodong_record re   where  re.huodongid=?";
		Long premiumCount =this.getCountForJdbcParam(sql,new Object[] { hdid});
		
		return premiumCount == null ? 0 : premiumCount;
	}

	@Override
	public List<Map<String, Object>> getPeopleInProvince(String hdid) {
		String sql="   select gz.province as name,count(distinct hr.openid)as value from weixin_huodong_record hr , weixin_gzuserinfo gz  where hr.openid = gz.openid and hr.huodongid = ? group by gz.province";
	 	List<Map<String, Object>> peopleInProvince=this.findForJdbc(sql,hdid);
		return peopleInProvince;
	}

	@Override
	public Map<String, Object> getFastestPeople(String hdid) {
		StringBuilder sqlBuilder =new StringBuilder("select  sponsor,min(diff)as minTime,gz.nickname from  ")
				.append(" (select sponsor , TIMESTAMPDIFF(SECOND,minTime,maxTime)as diff from( select re.sponsor ,max(re.createdate)as maxTime,min(re.createdate)as minTime")   
				.append(" from weixin_huodong_record re where   re.huodongid= ? ")
				.append(" group by re.sponsor  having sum(re.amount) >=100000)as a order by diff limit 1) b ")
				.append(" left join weixin_gzuserinfo gz on gz.openid = b.sponsor");
		List<Map<String, Object>> fastestPeopleList = this.findForJdbc(sqlBuilder.toString(),hdid);
		if(fastestPeopleList!=null){
			return	fastestPeopleList.get(0);
		}
		return null;
	}

	@Override
	public boolean hasPolicy(String huodongid, String openid) {
		String sql="  select po.policyno  from weixin_policy po where  po.type='2'  and  po.huodongid=? and po.openid=? ";
	 	List<Map<String, Object>> friendList=this.findForJdbc(sql,huodongid,openid);
		if(friendList.size()>0){
			return true;
		}
		return false;	 
	}

	@Override
	public BigDecimal getSelfAmount(String huodongid, String sponsor,
			String openid) {
		String sql="  select  sum(re.amount) as amount from weixin_huodong_record re   where  re.huodongid=? and re.sponsor=? and re.openid= ?  ";
	 	 Map<String, Object>  amountMap =this.findOneForJdbc(sql,huodongid,sponsor,openid);
	 	return (BigDecimal) amountMap.get("amount");	
	}

	@Override
	public HuodongRecord getHuodongRecord(String huodongid, String openid) {
		String hql = "from HuodongRecord where huodongid= ? and openid= ? and sponsor= ?";
		List<HuodongRecord> huodongRecordList = this.findHql(hql, huodongid,openid,openid);
		return huodongRecordList.size()>0 ?huodongRecordList.get(0):null;
	}

	@Override
	public boolean isUserCheckIn(String identifynumber, String customercname) {
		String hql = "from HuodongRecord where customercname= ? and identifynumber= ? ";
		List<HuodongRecord> huodongRecordList = this.findHql(hql, customercname,identifynumber);
		return huodongRecordList.size()>0 ?true:false;
	}
	
}
