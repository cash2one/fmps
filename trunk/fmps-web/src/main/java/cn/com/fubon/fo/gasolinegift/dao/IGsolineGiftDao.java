package cn.com.fubon.fo.gasolinegift.dao;

import java.util.Map;

/**
 * 加油宝dao接口
 * @author yaoming.zhang
 * 2015-08-26
 */
public interface IGsolineGiftDao {

	/**
	 * 通过openid查询该用户领取加油宝数量
	 */
	public Integer getGasolineGiftByOpenid(String openid);
	
	/**
	 * 通过openid获取加油宝邀请码
	 */
	public Map<String, Object> getMyGasolineGiftDetailByOpenid(String openid);
	
	/**
	 * 申请加油宝邀请码
	 */
	public Integer applyMyGasolinegift(String openid,String giftid);
	
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
}
