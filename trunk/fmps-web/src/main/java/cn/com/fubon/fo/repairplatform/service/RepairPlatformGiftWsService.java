package cn.com.fubon.fo.repairplatform.service;

import org.jeecgframework.core.common.service.CommonService;

import cn.com.fubon.fo.repairplatform.entity.request.AreaGiftSetRequest;
import cn.com.fubon.fo.repairplatform.entity.request.GiftSetInstructionsRequest;
import cn.com.fubon.fo.repairplatform.entity.response.AreaGiftSetResponse;
import cn.com.fubon.fo.repairplatform.entity.response.GiftSetInstructionsResponse;

public interface RepairPlatformGiftWsService extends CommonService {

	/**
	 * 获取礼包券详情
	 * 
	 * @param giftSetInstructionsRequest
	 * @return
	 */
	public GiftSetInstructionsResponse getGiftSetInstructionsResponse(
			GiftSetInstructionsRequest giftSetInstructionsRequest);
	
  /**
   * 根据地区获取更多券 
   * @param areaGiftSetRequest
   * @return
   */
	public AreaGiftSetResponse getMoreGiftSetByCountyCode(
			AreaGiftSetRequest areaGiftSetRequest);

}
