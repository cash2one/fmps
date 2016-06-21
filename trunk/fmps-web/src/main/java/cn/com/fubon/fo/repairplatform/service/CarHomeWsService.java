package cn.com.fubon.fo.repairplatform.service;

import org.jeecgframework.core.common.service.CommonService;

import cn.com.fubon.fo.repairplatform.entity.request.ActivityAllListRequest;
import cn.com.fubon.fo.repairplatform.entity.request.AdvertisementListRequest;
import cn.com.fubon.fo.repairplatform.entity.request.CarHomeIndexListRequest;
import cn.com.fubon.fo.repairplatform.entity.request.RecommendListRequest;
import cn.com.fubon.fo.repairplatform.entity.request.RecommendRepairListRequest;
import cn.com.fubon.fo.repairplatform.entity.response.ActivityAllListResponse;
import cn.com.fubon.fo.repairplatform.entity.response.AdvertisementListResponse;
import cn.com.fubon.fo.repairplatform.entity.response.CarHomeIndexListResponse;
import cn.com.fubon.fo.repairplatform.entity.response.RecommendListResponse;
import cn.com.fubon.fo.repairplatform.entity.response.RecommendRepairListResponse;

public interface CarHomeWsService extends CommonService {
	
	public AdvertisementListResponse getAdvertisementList(
			AdvertisementListRequest advertisementListRequest);
	
	public ActivityAllListResponse getSearchResult(
			ActivityAllListRequest searchRequest);
	
	public ActivityAllListResponse get4sFactoryResult(
			ActivityAllListRequest searchRequest);
	
	public ActivityAllListResponse getRepairFactoryResult(
			ActivityAllListRequest searchRequest);
	
	public ActivityAllListResponse getOtherServicesResult(
			ActivityAllListRequest searchRequest);

	RecommendListResponse getRecommendList(
			RecommendListRequest recommendListRequest);

	RecommendRepairListResponse getRecommendRepairList(
			RecommendRepairListRequest recommendRepairListRequest);

	public ActivityAllListResponse loadCarWashMerchantList(ActivityAllListRequest activityAllListRequest);
}
