package cn.com.fubon.fo.repairplatform.service;

import java.util.List;

import org.jeecgframework.core.common.service.CommonService;

import cn.com.fubon.fo.repairplatform.entity.WeixinGiftsetDetail;
import cn.com.fubon.fo.repairplatform.entity.response.ReceiveGiftSet;

public interface RepairPlatformGiftService extends CommonService {
	/**
	 * 获取根据保单号从 weixin_giftset_detail 查找 ，满足 当前日期 > EndDate and RepairId is
	 * null的数据
	 * 
	 * @return
	 */
	public List<WeixinGiftsetDetail> getWeixinGiftsetDetailList(
			String identifynumber, String customercname ,String openid);

	/**
	 * 根据保单号从 weixin_giftset_detail 查找 ，满足 当前日期 < EndDate or RepairId is not
	 * null
	 * 
	 * @return
	 */
	public List<WeixinGiftsetDetail> getInvalidWeixinGiftsetDetailList(
			String identifynumber, String customercname,String openid);
	
	/**
	 * 查询某个openid本年度领取券是否超200张
	 */
	public boolean isReceivedLimitedQuantityGiftSet(String openid);
	
	/**
	 * 查询某个openid是否已领取giftid券
	 */
	public boolean isReceivedThisGiftSet(String openid, String giftsetid);
	
	/**
	 * 保存活动券信息到weixin_giftset_detail表
	 */
	public boolean saveGiftSetIntoWeixinGiftsetDetail(ReceiveGiftSet giftSet, String openid, String huodongid);
}
