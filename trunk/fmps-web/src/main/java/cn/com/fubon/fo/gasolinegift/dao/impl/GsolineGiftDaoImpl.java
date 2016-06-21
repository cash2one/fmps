package cn.com.fubon.fo.gasolinegift.dao.impl;

import java.util.Date;
import java.util.Map;
import java.util.UUID;

import jodd.util.StringUtil;

import org.jeecgframework.core.common.dao.impl.GenericBaseCommonDao;
import org.springframework.stereotype.Repository;

import cn.com.fubon.fo.gasolinegift.dao.IGsolineGiftDao;
import cn.com.fubon.fo.gasolinegift.entity.GasolineGift;

/**
 * 加油宝dao接口实现
 * @author yaoming.zhang
 * 2015-08-26
 */
@SuppressWarnings({ "unchecked", "rawtypes" })
@Repository("gsolineGifDaoDao")
public class GsolineGiftDaoImpl extends GenericBaseCommonDao implements IGsolineGiftDao {
	
	/**
	 * 通过openid查询该用户领取加油宝数量
	 */
	@Override
	public Integer getGasolineGiftByOpenid(String openid){
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT COUNT(*) AS total ");
		sql.append("   FROM weixin_gasolinegift t ");
		sql.append(" WHERE t.openid = ? ");
		
		Integer returnList= this.countByJdbc(sql.toString(), openid);
		return returnList;
	}
	
	/**
	 * 通过openid获取加油宝邀请码
	 */
	@Override
	public Map<String, Object> getMyGasolineGiftDetailByOpenid(String openid){
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT t.id, t.openid, t.applyTime, t.giftid ");
		sql.append("   FROM weixin_gasolinegift t ");
		sql.append(" WHERE t.openid = ? ");
		
		Map<String, Object> returnList= this.findOneForJdbc(sql.toString(), openid);
		return returnList;
	}
	
	/**
	 * 申请加油宝邀请码
	 */
	@Override
	public Integer applyMyGasolinegift(String openid,String giftid){
		String uuid = UUID.randomUUID().toString();
		
		StringBuffer sql = new StringBuffer();
		sql.append(" INSERT INTO weixin_gasolinegift (id, openid, applyTime, giftid) ");
		sql.append(" VALUES ('"+uuid+"', ?, DATE_FORMAT(now(), '%Y-%m-%d %H:%i:%s'), '"+giftid+"') ");
		
		Integer returnList= this.executeSql(sql.toString(), openid);
		return returnList;
	}
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
	public void addGasolineGift(String openid,String giftid,String address,String mobile,String getStatus,String receiveAddress,String licenseno,String username){
		GasolineGift gift = new GasolineGift();
		gift.setOpenid(openid);
		gift.setAddress(address);
		gift.setMobile(mobile);
		if(StringUtil.isNotBlank(getStatus)){
			gift.setGetstatus(Integer.parseInt(getStatus));
		}else{	
			gift.setGetstatus(0);
		}
		gift.setReceiveAddress(receiveAddress);
		gift.setLicenseno(licenseno);
		gift.setGiftid(giftid);
		gift.setApplyTime(new Date());
		gift.setUsername(username);
		this.save(gift);
	}
}
