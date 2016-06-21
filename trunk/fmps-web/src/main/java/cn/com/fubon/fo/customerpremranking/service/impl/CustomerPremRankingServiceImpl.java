package cn.com.fubon.fo.customerpremranking.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.fubon.fo.customerpremranking.service.CustomerPremRankingService;

@Service("customerPremRankingService")
@Transactional
public class CustomerPremRankingServiceImpl extends CommonServiceImpl implements CustomerPremRankingService {
	private static final Logger logger = Logger.getLogger(CustomerPremRankingServiceImpl.class);

	/**
	 * 查询保费排名前20名的记录和客户的荣誉称号
	 * 
	 * @return
	 */
	@Override
	public List<Map<String,Object>> customerPremRanking() {
		
		StringBuffer sql = new StringBuffer("");
		sql.append("select identifynumber,rank,customername,premium,honor_name \n")
		 .append(" from weixin_customer_prem_ranking,weixin_honor_title where rank <=20 \n")
		 .append(" and premium between prem_start and prem_end \n");
		
		logger.info(sql.toString());
		return this.findForJdbc(sql.toString());
		
	}
	
	/**
	 * 查询当前客户的保费排名记录和客户的微信险种大类
	 */
	@Override
	public Map<String,Object> customerPremRanking(String identifynumber,String customercname) {
		// 不能用openid关联，因为当天认证的用户在保费排名表openid为空
		StringBuffer sql = new StringBuffer("");
		sql.append("select identifynumber,rank,customername,premium,honor_name,honor_desc \n")
		 .append(" from weixin_customer_prem_ranking,weixin_honor_title where identifynumber = ? \n")
		 .append(" and customername = ? \n")
		 .append(" and premium between prem_start and prem_end \n");
		
		logger.info(sql.toString() + "\n identifynumber=====>" + identifynumber + " customername===>" + customercname);
		return this.findOneForJdbc(sql.toString(),identifynumber,customercname);
	}

}
