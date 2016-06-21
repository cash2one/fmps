package cn.com.fubon.fo.repairplatform.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import weixin.util.DateUtils;

import org.apache.log4j.Logger;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.fubon.fo.repairplatform.entity.WeixinGiftsetDetail;
import cn.com.fubon.fo.repairplatform.entity.response.ReceiveGiftSet;
import cn.com.fubon.fo.repairplatform.service.RepairPlatformGiftService;

@Service("repairPlatformGiftService")
@Transactional
public class RepairPlatformGiftServiceImpl extends CommonServiceImpl implements
		RepairPlatformGiftService {

	private static final Logger logger = Logger.getLogger(RepairPlatformGiftServiceImpl.class);
	
	/**
	 * 获取根据保单号从 weixin_giftset_detail 查找 ，满足 当前日期 > EndDate and RepairId is
	 * null的数据
	 * 
	 * @return
	 */
	public List<WeixinGiftsetDetail> getWeixinGiftsetDetailList(
			String identifynumber, String customercname,String openid ) {
	
		String HQL = "  from  WeixinGiftsetDetail where (etlStatus=1 or policyno is null) and scanrepairid is null  and  enddate >:nowDate and ((insuredname=:insuredname and insidentifynumber=:insidentifynumber)  or (applicantname=:applicantname and appIdentifynumber=:appIdentifynumber) or(openid=:openid)) order by enddate asc";
		/*
		 * SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd "); String
		 * date = df.format(new java.util.Date(new java.util.Date() .getTime() -
		 * 5 * 60 * 1000)); java.sql.Date endDate = java.sql.Date.valueOf(date);
		 */
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date now = new Date();
		System.out.println("当前时间：" + sdf.format(now));
		Date nowDate = new Date(now.getTime());
		return this.getSession().createQuery(HQL)
				.setParameter("nowDate", nowDate)
				.setParameter("insuredname", customercname)
				.setParameter("insidentifynumber", identifynumber)
				.setParameter("applicantname", customercname)
				.setParameter("appIdentifynumber", identifynumber)
				.setParameter("openid", openid).list();
	}

	/**
	 * 根据保单号从 weixin_giftset_detail 查找 ，满足 当前日期 < EndDate or RepairId is not
	 * null
	 * 
	 * @return
	 */
	public List<WeixinGiftsetDetail> getInvalidWeixinGiftsetDetailList(
			String identifynumber, String customercname ,String openid) {
		
		String HQL = "  from  WeixinGiftsetDetail where  (etlStatus=1 or policyno is null) and (scanrepairid is not null or  enddate <:nowDate) and ((insuredname=:insuredname and insidentifynumber=:insidentifynumber)  or (applicantname=:applicantname and appIdentifynumber=:appIdentifynumber) or(openid=:openid) ) order by enddate asc";
		/*
		 * SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd "); String
		 * date = df.format(new java.util.Date(new java.util.Date() .getTime() -
		 * 5 * 60 * 1000)); java.sql.Date endDate = java.sql.Date.valueOf(date);
		 */
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date now = new Date();
		System.out.println("当前时间：" + sdf.format(now));
		Date nowDate = new Date(now.getTime());
		return this.getSession().createQuery(HQL)
				.setParameter("nowDate", nowDate)
				.setParameter("insuredname", customercname)
				.setParameter("insidentifynumber", identifynumber)
				.setParameter("applicantname", customercname)
				.setParameter("appIdentifynumber", identifynumber)
				.setParameter("openid", openid).list();
	}
	
	@Override
	public boolean isReceivedLimitedQuantityGiftSet(String openid){
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT COUNT(*) ");
		sql.append("   FROM WEIXIN_GIFTSET_DETAIL t ");
		sql.append(" where t.openid = ? ");
		sql.append("   and t.policyno is null ");
		sql.append("   and year(t.receivedate) = year(now()) ");
		
		Long size= this.getCountForJdbcParam(sql.toString(), new String[]{openid});
		return size.intValue() >=200 ? true : false;
	}
	
	@Override
	public boolean isReceivedThisGiftSet(String openid, String giftsetid) {
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT COUNT(*) ");
		sql.append("   FROM WEIXIN_GIFTSET_DETAIL t ");
		sql.append(" where t.openid = ? ");
		sql.append("   and t.giftsetid = ? ");
		sql.append("   and (t.etl_status=1 or t.policyno is null) and t.scanrepairid is null  and  t.enddate > now() "); //加入同一时间在同一家维修厂只能有一张有效的券
		
		Long size= this.getCountForJdbcParam(sql.toString(), new String[]{openid,giftsetid});
		return size.intValue() >=1 ? true : false;
	}
	
	@Override
	public boolean saveGiftSetIntoWeixinGiftsetDetail(ReceiveGiftSet giftSet, String openid, String huodongid) {
		StringBuffer sql = new StringBuffer();
		sql.append(" INSERT INTO weixin_giftset_detail (id, giftsetname, giftsetid, name, repairlogo, deepcolor, lightcolor, providerepairname, startdate, enddate, huodongid, areaname, cardtype, openid, receivedate) ");
		sql.append(" VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ");

		Integer size = 0;
		try {
			size = this.executeSql(sql.toString(),
					giftSet.getGiftsetDetailId(), giftSet.getGiftsetname(),
					giftSet.getGiftsetid(), giftSet.getName(),
					giftSet.getRepairlogo(), giftSet.getDeepcolor(),
					giftSet.getLightcolor(), giftSet.getProviderepairname(),
					giftSet.getStartdate(), giftSet.getEnddate(), huodongid,
					giftSet.getAreaname(), giftSet.getCardtype(), openid,
					giftSet.getReceivedate());
		} catch (Exception e) {
			logger.error("insertIntoWeixinGiftsetDetail", e);
			return false;
		}
		return size.intValue() >= 1 ? true : false;
	}

}
