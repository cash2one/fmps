/**
 * 
 */
package cn.com.fubon.fo.card.service.imp;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.jeecgframework.core.util.IdcardUtils;
import org.jeecgframework.core.util.StringUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.fubon.fo.card.dao.CardPolicyDao;
import cn.com.fubon.fo.card.service.CardPolicyService;

/**
 * 个人中心卡单激活查询
 * 
 * @author qingqu.huang
 *
 */
@Service("cardPolicyServiceImpl")
@Transactional
public class CardPolicyServiceImpl extends CommonServiceImpl implements
		CardPolicyService {
	@Resource
	private CardPolicyDao cardPolicyDao;

	/**
	 * 获取卡单信息
	 */
	@Override
	public List<Map<String, Object>> getCardPolicyAll(String cardno) {
		List<Map<String, Object>> cardPolicyListTemp = cardPolicyDao
				.getCardPolicyAll(cardno);
		List<Map<String, Object>> cardPolicyList = new ArrayList<Map<String, Object>>();
		List<Map<String, Object>> cardPolicyDetailList = new ArrayList<Map<String, Object>>();
		Map<String, Object> cardPolicyMap = new HashMap<String, Object>();
		for (int i = 0; i < cardPolicyListTemp.size(); i++) {
			Map<String, Object> cardPolicyMapTemp = cardPolicyListTemp.get(i);
			String policyNoTemp = "";
			policyNoTemp = (String) cardPolicyMapTemp.get("policyno");
			if (i == 0) {
				String identitynum = (String) cardPolicyMapTemp
						.get("identifynumber");
				if (identitynum != null) {
					identitynum = IdcardUtils
							.getEncryptionIdentifyNum(identitynum);
				}
				cardPolicyMap.put("policyno", policyNoTemp);
				cardPolicyMap.put("insuredname", cardPolicyMapTemp.get("name"));
				cardPolicyMap.put("identifynumber", identitynum);
				cardPolicyMap.put("startdate",
						cardPolicyMapTemp.get("startdate"));// 开始日期
				cardPolicyMap.put("enddate", cardPolicyMapTemp.get("enddate"));
				cardPolicyList.add(cardPolicyMap);
			}
			Map<String, Object> cardPolicyDetailMap = new HashMap<String, Object>();
			cardPolicyDetailMap.put("kindname",
					cardPolicyMapTemp.get("productname"));
			cardPolicyDetailMap.put("itemdetailname",
					cardPolicyMapTemp.get("liability"));
			String unit = (String) cardPolicyMapTemp.get("unit");
			if (!"".equals(unit) && "万元".equals(unit)) {
				String amount = (String) cardPolicyMapTemp.get("amount");
				cardPolicyDetailMap.put("amount",
						Integer.parseInt(amount) * 10000);// 保额
			} else {
				cardPolicyDetailMap.put("amount",
						cardPolicyMapTemp.get("amount"));// 保额
			}
			if (i == 0) {
				cardPolicyDetailMap.put("premium",
						cardPolicyMapTemp.get("premium"));// 保费
			} else {
				cardPolicyDetailMap.put("premium", 0);// 保费
			}
			cardPolicyDetailList.add(cardPolicyDetailMap);
			cardPolicyMap.put("customerPolicyDetailList", cardPolicyDetailList);
		}

		double premiumSum;
		DecimalFormat df = new DecimalFormat("#.00");
		for (Map<String, Object> cardPolicyMapTemp : cardPolicyList) {
			premiumSum = 0;
			for (Map<String, Object> cardPolicyMapTemp2 : (List<Map<String, Object>>) (cardPolicyMapTemp
					.get("customerPolicyDetailList"))) {
				String kindname = (String) cardPolicyMapTemp2.get("kindname");
				Double premiumSumTemp = Double.parseDouble(cardPolicyMapTemp2
						.get("premium").toString());
				premiumSum += premiumSumTemp;
			}

			cardPolicyMapTemp.put("sumPremium", df.format(premiumSum));
		}
		return cardPolicyList;
	}

	/**
	 * 获取卡单头部信息
	 */
	@Override
	public Map<String, String> findPolicyDetailHead(String cardno) {
		Map<String, String> headMap = cardPolicyDao
				.findPolicyDetailHead(cardno);
		if (headMap != null) {
			String identitynumber = headMap.get("identifynumber");
			if (StringUtil.isNotEmpty(identitynumber)) {
				identitynumber = IdcardUtils
						.getEncryptionIdentifyNum(identitynumber);
			}
			headMap.put("identifynumber", identitynumber);
		}
		return headMap;
	}

	/**
	 * 获取卡单详细保障信息
	 */
	@Override
	public List<Map<String, String>> findPolicyDetailBody(String cardno) {
		return cardPolicyDao.findPolicyDetailBody(cardno);
	}
	
	/**
	 * 获取春节赠险卡单详细保障信息
	 */
	public List<Map<String, String>> findLunarNewYearPolicyDetailBody(String cardno,String planid){
		return cardPolicyDao.findLunarNewYearPolicyDetailBody(cardno,planid);
	}
	
	@Override
	public boolean isFractureProduct(String policyNo){
		String sql="select po.policyno from weixin_policy po ,weixin_plan pl where po.planid=pl.id  and pl.coreproductcode like '2715%' and po.policyno=?  ";
		List<Map<String, Object>> policyList =this.findForJdbc(sql,policyNo);  
		if(policyList.size()>0){
			return true;
		}
		return false;
	}

	
	
	
}
