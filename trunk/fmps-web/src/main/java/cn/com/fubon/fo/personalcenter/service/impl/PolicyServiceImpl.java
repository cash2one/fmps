package cn.com.fubon.fo.personalcenter.service.impl;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.jeecgframework.core.util.oConvertUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.fubon.fo.cashcoupon.entity.CashCoupon;
import cn.com.fubon.fo.personalcenter.dao.PolicyDao;
import cn.com.fubon.fo.personalcenter.entity.WeixinPolicyClauseReading;
import cn.com.fubon.fo.personalcenter.service.PolicyService;
import cn.com.fubon.util.Constants;

/* 已存在名为"policyService",所以这里用大写P */
@Service("PolicyService")
@Transactional
public class PolicyServiceImpl extends CommonServiceImpl implements
		PolicyService {
	private static final Logger logger = Logger.getLogger(PolicyServiceImpl.class);
	@Resource
	private PolicyDao oraclePolicyDao;

	@Override
	public List<Map<String, Object>> findAllCars(String customercname,
			String identifynumber) {
		return oraclePolicyDao.findAllCars(customercname, identifynumber);
	}

	@Override
	public List findAllPolicys(String identifyNumber,
			String customerCname,String[] policynoList,String telesaledate,String telesalechannel) {
		return oraclePolicyDao.findAllPolicys(identifyNumber, customerCname,policynoList,telesaledate,telesalechannel);
	}

	@Override
	public Map<String, String> findPolicyDetailHead(String policyno,
			boolean isCar) {
		return oraclePolicyDao.findPolicyDetailHead(policyno, isCar);
	}

	@Override
	public List<Map<String, String>> findPolicyDetailBody(String policyno,
			boolean isCar) {
		return oraclePolicyDao.findPolicyDetailBody(policyno, isCar);
	}

	@Override
	public List<Map<String, Object>> findAllPolicys(String openid) {
		StringBuilder sql = new StringBuilder();
		sql.append("select distinct policy.policyno,date_format(policy.startdate,'%Y年%m月%d日') startdate,concat('有效期至 ',date_format(policy.enddate,'%Y年%m月%d日')) enddate,");
		sql.append(" case when policy.enddate>now() then null else '已过期' end as status,concat(extract(year from policy.createtime),'年') operateyear,");
		sql.append(" plan.premium sumpremium,product.riskshortname policyname,customer.name insuredname,customer.identifynumber,policy.openid,2 m,0 telesalepolicy,null productcode ");
		sql.append(" from weixin_policy policy left join weixin_plan plan on policy.planid=plan.id");
		sql.append(" left join weixin_product product on product.id=plan.productid");
		sql.append(" left join weixin_policy_insured_identity identity on policy.policyno=identity.policyno");
		sql.append(" left join weixin_customer customer on identity.customerid=customer.id");
		sql.append("  where policy.type ='2' and policy.openid=? order by operateyear");
		return this.findForJdbc(sql.toString(),openid);
	}
	
	@Override
	public Map<String, Object> findPolicyByTeleSale(String policyno,String date,String channel) {
		return oraclePolicyDao.findPolicyByTeleSale(policyno, date,channel);
	}
	
	@Override
	public List<Map<String, Object>> findNotCarPolicyByTeleSale(String customerCname,String identifyNumber,String date,String channel) {
		return oraclePolicyDao.findNotCarPolicyByTeleSale(customerCname,identifyNumber, date,channel);
	}
	
	
	@Override
	public List<Map<String, Object>> findClauseByCoreProductCode(String coreProductCode) {
		StringBuilder sql = new StringBuilder();
		
		sql.append(" SELECT c.afid as afid,c.description as description,c.document as document,pl.coreproductcode as coreproductcode");
		sql.append(" FROM weixin_plan pl ");
		sql.append(" LEFT JOIN ( ");
		sql.append(" SELECT ins.productid,ins.planid,af.description,af.document,af.id as afid ");
		sql.append(" FROM weixin_plan_insurancekind ins ");
		sql.append(" LEFT JOIN weixin_product_affiliated af ON ins.affiliatedId=af.id ");
		sql.append(" ORDER BY af.sorting) c ON c.planid =pl.id ");
		sql.append(" WHERE pl.coreproductcode=?"
				+ "  AND c.afid is not null ");
		return this.findForJdbc(sql.toString(),coreProductCode);
	}
	
	@Override
	public Map<String, Object> findAffiliatedById(String afid) {
		StringBuilder sql = new StringBuilder();		
		sql.append(" select t.id as afid,t.document as document,t.description as description from weixin_product_affiliated t ");		
		sql.append(" where t.id =? ");
		
		return this.findOneForJdbc(sql.toString(),afid);
	}

	
	@Override
	public Map<String, Object> findPolicyClauseReadByPolicyNo(String policyno) {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT openid,policyno ");
		sql.append(" FROM weixin_policy_clause_reading t ");
		sql.append(" where t.policyNo =? ");
		return this.findOneForJdbc(sql.toString(),policyno);
	}
	
	@Override
	public boolean  saveCashCouponAndClauseReadingRecord(String hdid,String openid,String policyNo,BigDecimal amount){
		try {
		//保存红包记录
		CashCoupon cashCoupon = new CashCoupon();
		  cashCoupon.setAmount(amount.doubleValue());
		  cashCoupon.setHuodongid(hdid);
		  cashCoupon.setOpenid(openid);
		  cashCoupon.setExternalSerialNo(policyNo);
		  cashCoupon.setReceivetime(new Date());		
		  String ip = oConvertUtils.getRealIp();
		  cashCoupon.setIp(ip);		
		//this.save(cashCoupon);
	      WeixinPolicyClauseReading  weixinPolicyClauseReading =new WeixinPolicyClauseReading(); 
	    //weixinPolicyClauseReading.setCashcouponId(cashCoupon);
	      weixinPolicyClauseReading.setCreateTime(new Date());
	      weixinPolicyClauseReading.setOpenid(openid);
	      weixinPolicyClauseReading.setPolicyNo(policyNo);	 
	      weixinPolicyClauseReading.setIsAgree(1);	 
	     this.save(weixinPolicyClauseReading);	
		}  catch ( IOException e) {
			logger.info("阅读条款抽红包，保存数据库出错==openid==>"+openid+",policyNo:"+policyNo);
			e.printStackTrace();
			return false; 	 
		}
		return true;		
	}
	
	@Override
	public BigDecimal getSumPremium(String policyno) {
	return	oraclePolicyDao.getSumPremium(policyno);
	}

	/**
	 * 查询满足电销需求且生效15天的保单
	 * @param customerCname
	 * @param identifyNumber
	 * @param date
	 * @param channel
	 * @param fifteen
	 * @return
	 */
	public List<Map<String, Object>> findNotCarFifteenPolicyByTeleSale(String customerCname,String identifyNumber,String date,String channel,String fifteen) {
		return oraclePolicyDao.findNotCarPolicyFifteenByTeleSale(customerCname,identifyNumber, date,channel,fifteen);
	}
	
	/**
	 * 查询某用户是否存在未读条款的保单
	 * @param customercname
	 * @param identifynumber
	 * @return
	 */
	public List<Map<String, Object>> isNeedSendNotifyMessage(String customercname,String identifynumber){
		String date =Constants.READ_CLAUSE_RULE_DATE;
		String channel=Constants.TELESALE_CHANNEL;
		String fifteenday=Constants.CUSTOMER_READ_CLAUSE_FIFTEEN;
		//存放未领红包保单信息
		List<Map<String, Object>> unReadpolicys = new ArrayList<Map<String, Object>>();
		//查询满足电销需求且生效15天的保单
		List<Map<String,Object>> policyInfos=findNotCarFifteenPolicyByTeleSale(customercname,identifynumber,date,channel,fifteenday);
		for(Map<String, Object> policy : policyInfos){
			Boolean isOutOfDay=ifOutOfDay(policy);
			List<Map<String, Object>> clauseList = findClauseByCoreProductCode(policy.get("productcode").toString());
			Map<String,Object> policyClause = findPolicyClauseReadByPolicyNo(policy.get("policyno").toString());
			if (!clauseList.isEmpty()&&!isOutOfDay&&policyClause==null){
				unReadpolicys.add(policy);
			}
		}
		return unReadpolicys;
	}
	
	/**
	 * 判断保单是否过期
	 * @param policyInfo
	 * @return
	 */
	private Boolean ifOutOfDay(Map<String, Object> policyInfo) {
		Date enddate = null;
		Boolean isoutOfDay = true;
		Timestamp ts =(Timestamp)policyInfo.get("enddate");  
		enddate =	new Date(ts.getTime());
		Date nowdate = new Date();
		if (enddate.after(nowdate)){
			isoutOfDay =false;
		}
		return isoutOfDay;
	}
	
}


