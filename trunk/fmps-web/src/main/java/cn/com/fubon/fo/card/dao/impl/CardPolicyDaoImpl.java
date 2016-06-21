/**
 * 
 */
package cn.com.fubon.fo.card.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.jeecgframework.core.common.dao.impl.GenericBaseCommonDao;
import org.springframework.stereotype.Repository;

import cn.com.fubon.fo.card.dao.CardPolicyDao;

/**
 * @author qingqu.huang
 *
 */
@SuppressWarnings({ "rawtypes", "unchecked" })
@Repository("cardPolicyDao")
public class CardPolicyDaoImpl extends GenericBaseCommonDao implements
		CardPolicyDao {

	private static final Logger logger = Logger
			.getLogger(CardPolicyDaoImpl.class);

	/**
	 * 取得保单所有信息（已过期）
	 */
	@Override
	public List<Map<String, Object>> getCardPolicyAll(String cardno) {
		logger.info("进入获取保单信息方法...卡号=>" + cardno);
		List<Map<String, Object>> cardPolicyList = null;
		StringBuilder sql = new StringBuilder("");
		sql.append("select product.productname,plan.premium,plan.coreproductcode,res.liability,res.amount,res.unit,");
		sql.append("policy.policyno,policy.startdate,policy.enddate,identity.customerid,customer.name,customer.identifynumber ");
		sql.append(" from  weixin_product product ");
		sql.append(" left join weixin_plan plan on product.id=plan.productid ");
		sql.append(" left join weixin_plan_responsibility res on plan.id=res.planid ");
		sql.append(" left join weixin_policy policy on policy.planid =plan.id ");
		sql.append(" left join weixin_policy_insured_identity identity on policy.policyno=identity.policyno ");
		sql.append(" left join weixin_customer customer on identity.customerid=customer.id ");
		sql.append(" where policy.policyno=?");
		logger.info("获取保单信息SQL：" + sql.toString());
		cardPolicyList = this.findForJdbc(sql.toString(), cardno);
		return cardPolicyList;
	}

	/**
	 * 获取卡单头部信息
	 */
	@Override
	public Map<String, String> findPolicyDetailHead(String cardno) {
		StringBuilder sql = new StringBuilder("");
		sql.append("select distinct policy.policyno,date_format(policy.startdate,'%Y年%m月%d日') startdate,");
		sql.append("date_format(policy.enddate,'%Y年%m月%d日') enddate,case when policy.enddate>now() then null else '已过期' end as status,");
		sql.append("plan.premium sumpremium,product.riskshortname,customer.name insuredname,customer.identifynumber");
		sql.append(" from weixin_policy policy left join weixin_plan plan on policy.planid=plan.id");
		sql.append(" left join weixin_product product on product.id=plan.productid");
		sql.append(" left join weixin_policy_insured_identity identity on policy.policyno=identity.policyno");
		sql.append(" left join weixin_customer customer on identity.customerid=customer.id");
		sql.append("  where policy.policyno=?");
		logger.info("查询卡单头部信息SQL:" + sql.toString());
		Map<String, String> policyHead = this.findOneForJdbc(sql.toString(),
				cardno);
		if (policyHead == null || policyHead.isEmpty()) {
			logger.info(sql.toString() + "\n==>未查询到保单头,cardno==>" + cardno);
		}
		return policyHead;
	}

	/**
	 * 获取卡单详细保障信息
	 */
	@Override
	public List<Map<String, String>> findPolicyDetailBody(String cardno) {
		List<Map<String, String>> cardPolicyList = null;
		StringBuilder sql = new StringBuilder("");
		sql.append("select distinct insurancekind.kindname,res.liability itemdetailname,case when res.unit='万元' then res.amount*10000 else res.amount end as amount");
		sql.append(" from weixin_plan_responsibility res ");
		sql.append(" left join weixin_plan_insurancekind insurancekind on res.kindid=insurancekind.id  ");
		sql.append(" left join weixin_plan plan on plan.id=res.planid ");
		sql.append("  left join weixin_policy policy on policy.planid =plan.id ");
		sql.append("  where policy.policyno=? order by res.liabilitycode ");
		logger.info("获取保单信息SQL：" + sql.toString());
		cardPolicyList = this.findForJdbc(sql.toString(), cardno);
		return cardPolicyList;
	}
	
	/**
	 * 获取春节赠险卡单详细保障信息
	 */
	@Override
	public List<Map<String, String>> findLunarNewYearPolicyDetailBody(String cardno,String planid) {
		List<Map<String, String>> cardPolicyList = null;
		StringBuilder sql = new StringBuilder("");
		sql.append(" select distinct insurancekind.kindname,res.liability itemdetailname,  po.amount  as amount ");
		sql.append("   from weixin_plan_responsibility res  ");
		sql.append("  left join weixin_plan_insurancekind insurancekind on res.kindid=insurancekind.id   ");
		sql.append("  left join weixin_plan plan on plan.id=res.planid ");
		sql.append(" left join weixin_policy policy on policy.planid =plan.id , ");
		sql.append("  ( select  re.sponsor , max(po.policyno) as policyno  ,sum(re.amount) as amount    from weixin_huodong_record  re  ,   weixin_policy  po  where re.huodongid='8a828edfedfre68475034fd3dca5799634' and po.policyno=? and re.sponsor=po.openid  group by  re.sponsor) po  ");
		sql.append("  where  po.policyno= policy.policyno and      policy.policyno=?  ");
		sql.append(" and plan.id=? ");	      
				      
		logger.info("获取保单信息SQL：" + sql.toString());
		cardPolicyList = this.findForJdbc(sql.toString(), cardno, cardno, planid);
		return cardPolicyList;
	}
}
