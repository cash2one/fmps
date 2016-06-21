package cn.com.fubon.fo.gasolinegift.service;

import java.util.List;
import java.util.Map;

import org.jeecgframework.core.common.service.CommonService;

import cn.com.fubon.rest.entity.request.GasolineGiftCarRequest;
import cn.com.fubon.rest.entity.request.GasolineGiftQueryRequest;
import cn.com.fubon.rest.entity.response.GasolineGiftCarResponse;
import cn.com.fubon.rest.entity.response.GasolineGiftQueryResponse;

/**
 * 加油宝service接口
 * @author yaoming.zhang
 * 2015-08-26
 */

public interface IGasolineGiftService extends CommonService {

	/**
	 * 通过openid查询该用户领取加油宝数量
	 */
	public boolean getGasolineGiftByOpenid(String openid);
	
	/**
	 * 通过openid获取加油宝邀请码
	 */
	public Map<String, Object> getMyGasolineGiftDetailByOpenid(String openid);
	
	/**
	 * 申请加油宝邀请码
	 */
	public boolean applyMyGasolinegift(String openid,String giftid);
	
	/**
	 * 保存领取信息
	 * 
	 * @param openid
	 * @param giftid
	 * @param address
	 * @param mobile
	 * @param getStatus
	 * @param licenseno
	 */
	public void addGasolineGift(String openid,String giftid,String address,String mobile,String getStatus,String receiveAddress,String licenseno,String username);
	
	/**
	 * 根据OPENID查询客户已经申请的车牌列表
	 * @param openid
	 * @return
	 */
	public	List<Map<String, Object>>  queryMysqlCarLicensenoList(String openid);

	public GasolineGiftCarResponse   sendRegisterMessage(GasolineGiftCarRequest  gasolineGiftCarRequest);

	public String getOrgCode(String orgName);
	
	public GasolineGiftQueryResponse   queryOilCarApplyStatus(GasolineGiftQueryRequest  gasolineGiftQueryRequest);
}
