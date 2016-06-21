package cn.com.fubon.fo.personalcenter.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.jeecgframework.core.common.service.CommonService;

/**
 * @author fangfang.guo
 */
public interface PolicyService extends CommonService {
	
	/**
	 * 个人中心--个人信息--车辆
	 * @param customercname
	 * @param identifynumber
	 * @return 车牌号,厂牌型号,车架号,是否上牌
	 */
	List<Map<String, Object>> findAllCars(String customercname,String identifynumber);

	/**
	 * 个人中心--保单首页
	 * @param identifyNumber
	 * @param customerCname
	 * @return
	 */
	List findAllPolicys(String identifyNumber,
			String customerCname,String[] policynoList,String telesaledate,String telesalechanne);

	/**
	 * 个人中心--保单首页 mysql数据
	 * @param openid
	 * @return
	 */
	List<Map<String, Object>> findAllPolicys(String openid);

	/**
	 * 个人中心--保单详细页--保单头
	 * @param policyno 保单号
	 * @param isCar 是否车险
	 * @return
	 */
	Map<String, String> findPolicyDetailHead(String policyno,boolean isCar);

	/**
	 * 个人中心--保单详细页--保单体
	 * @param policyno 保单号
	 * @param isCar 是否车险
	 * @return
	 */
	List<Map<String, String>> findPolicyDetailBody(String policyno,boolean isCar);
	
	/**
	 * 个人中心--保单详细页--判断这个保单是否符合电销需求
	 * @param policyno 保单号
	 * @param date     日期
	 * @param channel  渠道
	 * @return
	 */
	Map<String, Object> findPolicyByTeleSale(String policyno,String date,String channel);
	
	/**
	 * 用户认证--查找符合电销需求（查看条款领红包）的保单信息
	 * @param customerCname
	 * @param identifyNumber
	 * @param date
	 * @param channel
	 * @return
	 */
	List<Map<String, Object>> findNotCarPolicyByTeleSale(String customerCname,String identifyNumber,String date,String channel);
	
	/**
	 * 个人中心--保单详细页--查看条款页
	 * @param coreProductCode 核心产品代码
	 * @return
	 */
	List<Map<String, Object>> findClauseByCoreProductCode(String coreProductCode);
	/**
	 * 个人中心--保单详细页--查看条款页--条款明细
	 * @param afid 条款id
	 * @return
	 */
	Map<String, Object> findAffiliatedById(String afid);
	/**
	 * 个人中心--保单详细页--判断某个用户某个保单是否已经阅读条款，领取红包
	 * @param policyno
	 * @return
	 */
	Map<String, Object> findPolicyClauseReadByPolicyNo(String policyno);
	
	/**
	 * 查找某用户是否存在未读条款的保单信息
	 * @param customercname
	 * @param identifynumber
	 * @return
	 */
	List<Map<String, Object>> isNeedSendNotifyMessage(String customercname,String identifynumber);

	boolean saveCashCouponAndClauseReadingRecord(String hdid, String openid,String policyNo, BigDecimal amount);
	
	BigDecimal getSumPremium(	String   policyno);
}
