package cn.com.fubon.fo.repairplatform.service.impl;

import javax.annotation.Resource;

import org.apache.commons.chain.Context;
import org.apache.log4j.Logger;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.jeecgframework.core.util.ResourceUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import weixin.popular.util.JsonUtil;
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
import cn.com.fubon.fo.repairplatform.service.CarHomeWsService;
import cn.com.fubon.rest.service.impl.RestWebServiceClient;
import cn.com.fubon.webservice.WsConstants;
import cn.com.fubon.webservice.server.entity.WebServiceClientManagement;

@Service("carHomeWsService")
@Transactional
public class CarHomeWsServiceImpl extends CommonServiceImpl implements
CarHomeWsService  {
	@Resource(name="advertisementList")
	private RestWebServiceClient advertisementList;	
	
	@Resource(name="recommendList")
	private RestWebServiceClient recommendList;	
	
	@Resource(name="recommendRepairList")
	private RestWebServiceClient recommendRepairList;	
	
	@Resource(name="carHomeSearch")
	private RestWebServiceClient carHomeSearch;
	
	@Resource(name="carHome4sFactory")
	private RestWebServiceClient carHome4sFactory;
	
	@Resource(name="carHomeRepairFactory")
	private RestWebServiceClient carHomeRepairFactory;
	
	@Resource(name="carHomeOtherServices")
	private RestWebServiceClient carHomeOtherServices;
	
	@Resource(name="carwashmerchantList")
	private RestWebServiceClient carwashmerchantList;	
	
	private static final Logger logger = Logger
			.getLogger(CarHomeWsServiceImpl.class);
    //广告活动 
	@Override
	public AdvertisementListResponse getAdvertisementList(
			AdvertisementListRequest advertisementListRequest) {		
		Context context = null;		
		String clientCode = ResourceUtil.getBundleEnvAbout().getString(
				"clientCode");
		WebServiceClientManagement WebServiceClientManagement = this
				.findUniqueByProperty(WebServiceClientManagement.class,
						"clientCode", clientCode);		
		String advertisementListJson = JsonUtil.toJSONString(advertisementListRequest);
		logger.info("发送的json=carHomeIndexListRequest==> " + advertisementListJson);		
		try {
			context= advertisementList.startExecuteChain(advertisementListJson, WebServiceClientManagement.getToken(), WebServiceClientManagement.getAESKey(), clientCode);
		} catch (Exception e) {
			logger.info("获取爱车之家首页活动信息失败",e);
			e.printStackTrace();
		}
		String responeJson=(String) context.get(WsConstants.RESPONSEJSON);		
		logger.info("爱车之家首页活动返回来的json===> " + responeJson);
		AdvertisementListResponse advertisementListResponse = JsonUtil.parseObject(responeJson,
				AdvertisementListResponse.class);		
		return advertisementListResponse;
	}
	
	//精品推荐 
	@Override
	public RecommendListResponse getRecommendList(
			RecommendListRequest recommendListRequest) {		
		Context context = null;		
		String clientCode = ResourceUtil.getBundleEnvAbout().getString(
				"clientCode");
		WebServiceClientManagement WebServiceClientManagement = this
				.findUniqueByProperty(WebServiceClientManagement.class,
						"clientCode", clientCode);		
		String recommendListJson = JsonUtil.toJSONString(recommendListRequest);
		logger.info("发送的json=carHomeIndexListRequest==> " + recommendListJson);		
		try {
			context= recommendList.startExecuteChain(recommendListJson, WebServiceClientManagement.getToken(), WebServiceClientManagement.getAESKey(), clientCode);
		} catch (Exception e) {
			logger.info("获取爱车之家首页活动信息失败",e);
			e.printStackTrace();
		}
		String responeJson=(String) context.get(WsConstants.RESPONSEJSON);		
		logger.info("爱车之家首页活动返回来的json===> " + responeJson);
		RecommendListResponse recommendListResponse = JsonUtil.parseObject(responeJson,
				RecommendListResponse.class);		
		return recommendListResponse;
	}
	
	//精品商家列表 
	@Override
	public RecommendRepairListResponse getRecommendRepairList(
			RecommendRepairListRequest recommendRepairListRequest) {		
		Context context = null;		
		String clientCode = ResourceUtil.getBundleEnvAbout().getString(
				"clientCode");
		WebServiceClientManagement WebServiceClientManagement = this
				.findUniqueByProperty(WebServiceClientManagement.class,
						"clientCode", clientCode);		
		String recommendRepairListJson = JsonUtil.toJSONString(recommendRepairListRequest);
		logger.info("发送的json=carHomeIndexListRequest==> " + recommendRepairListJson);		
		try {
			context= recommendRepairList.startExecuteChain(recommendRepairListJson, WebServiceClientManagement.getToken(), WebServiceClientManagement.getAESKey(), clientCode);
		} catch (Exception e) {
			logger.info("获取爱车之家首页精品商家信息失败",e);
			e.printStackTrace();
		}
		String responeJson=(String) context.get(WsConstants.RESPONSEJSON);		
		logger.info("爱车之家首页精品商家返回来的json===> " + responeJson);
		RecommendRepairListResponse recommendRepairListResponse = JsonUtil.parseObject(responeJson,
				RecommendRepairListResponse.class);
		
		return recommendRepairListResponse;
	}

	@Override
	public ActivityAllListResponse getSearchResult(
			ActivityAllListRequest searchRequest) {
		Context context = null;
		String clientCode = ResourceUtil.getBundleEnvAbout().getString(
				"clientCode");
		WebServiceClientManagement WebServiceClientManagement = this
				.findUniqueByProperty(WebServiceClientManagement.class,
						"clientCode", clientCode);
		String requestJson = JsonUtil.toJSONString(searchRequest);
		logger.info("发送的json(爱车之家查询数据)=== " + requestJson);
		try {
			context = carHomeSearch.startExecuteChain(requestJson,
					WebServiceClientManagement.getToken(),
					WebServiceClientManagement.getAESKey(), clientCode);
		} catch (Exception e) {
			logger.info("获取爱车之家查询结果数据失败   ", e);
			e.printStackTrace();
		}
		String responeJson = (String) context.get(WsConstants.RESPONSEJSON);
		logger.info("获取爱车之家查询结果数据返回的json=== " + responeJson);
		ActivityAllListResponse responseJson = JsonUtil.parseObject(
				responeJson, ActivityAllListResponse.class);
		return responseJson;
	}

	@Override
	public ActivityAllListResponse get4sFactoryResult(
			ActivityAllListRequest searchRequest) {
		Context context = null;
		String clientCode = ResourceUtil.getBundleEnvAbout().getString(
				"clientCode");
		WebServiceClientManagement WebServiceClientManagement = this
				.findUniqueByProperty(WebServiceClientManagement.class,
						"clientCode", clientCode);
		String requestJson = JsonUtil.toJSONString(searchRequest);
		logger.info("发送的json(爱车之家4s店)=== " + requestJson);
		try {
			context = carHome4sFactory.startExecuteChain(requestJson,
					WebServiceClientManagement.getToken(),
					WebServiceClientManagement.getAESKey(), clientCode);
		} catch (Exception e) {
			logger.info("获取爱车之家4s店数据失败   ", e);
			e.printStackTrace();
		}
		String responeJson = (String) context.get(WsConstants.RESPONSEJSON);
		logger.info("获取爱车之家4s店返回的json=== " + responeJson);
		ActivityAllListResponse responseJson = JsonUtil.parseObject(
				responeJson, ActivityAllListResponse.class);
		return responseJson;
	}

	@Override
	public ActivityAllListResponse getRepairFactoryResult(
			ActivityAllListRequest searchRequest) {
		Context context = null;
		String clientCode = ResourceUtil.getBundleEnvAbout().getString(
				"clientCode");
		WebServiceClientManagement WebServiceClientManagement = this
				.findUniqueByProperty(WebServiceClientManagement.class,
						"clientCode", clientCode);
		String requestJson = JsonUtil.toJSONString(searchRequest);
		logger.info("发送的json(爱车之家维修保养店)=== " + requestJson);
		try {
			context = carHomeRepairFactory.startExecuteChain(requestJson,
					WebServiceClientManagement.getToken(),
					WebServiceClientManagement.getAESKey(), clientCode);
		} catch (Exception e) {
			logger.info("获取爱车之家维修保养店数据失败   ", e);
			e.printStackTrace();
		}
		String responeJson = (String) context.get(WsConstants.RESPONSEJSON);
		logger.info("获取爱车之家维修保养店返回的json=== " + responeJson);
		ActivityAllListResponse responseJson = JsonUtil.parseObject(
				responeJson, ActivityAllListResponse.class);
		return responseJson;
	}
	
	@Override
	public ActivityAllListResponse getOtherServicesResult(
			ActivityAllListRequest searchRequest) {
		Context context = null;
		String clientCode = ResourceUtil.getBundleEnvAbout().getString(
				"clientCode");
		WebServiceClientManagement WebServiceClientManagement = this
				.findUniqueByProperty(WebServiceClientManagement.class,
						"clientCode", clientCode);
		String requestJson = JsonUtil.toJSONString(searchRequest);
		logger.info("发送的json(爱车之家维修保养店)=== " + requestJson);
		try {
			context = carHomeOtherServices.startExecuteChain(requestJson,
					WebServiceClientManagement.getToken(),
					WebServiceClientManagement.getAESKey(), clientCode);
		} catch (Exception e) {
			logger.info("获取爱车之家维修保养店数据失败   ", e);
			e.printStackTrace();
		}
		String responeJson = (String) context.get(WsConstants.RESPONSEJSON);
		logger.info("获取爱车之家维修保养店返回的json=== " + responeJson);
		ActivityAllListResponse responseJson = JsonUtil.parseObject(
				responeJson, ActivityAllListResponse.class);
		return responseJson;
	}
	
	public ActivityAllListResponse loadCarWashMerchantList(
			ActivityAllListRequest activityAllListRequest) {
		Context context = null;
		String clientCode = ResourceUtil.getBundleEnvAbout().getString(
				"clientCode");
		WebServiceClientManagement WebServiceClientManagement = this
				.findUniqueByProperty(WebServiceClientManagement.class,
						"clientCode", clientCode);
		String requestJson = JsonUtil.toJSONString(activityAllListRequest);
		logger.info("发送的json(爱车之家查询数据)=== " + requestJson);
		try {
			context = carwashmerchantList.startExecuteChain(requestJson,
					WebServiceClientManagement.getToken(),
					WebServiceClientManagement.getAESKey(), clientCode);
		} catch (Exception e) {
			logger.info("获取爱车之家查询结果数据失败   ", e);
			e.printStackTrace();
		}
		String responeJson = (String) context.get(WsConstants.RESPONSEJSON);
		logger.info("获取爱车之家查询结果数据返回的json=== " + responeJson);
		ActivityAllListResponse responseJson = JsonUtil.parseObject(
				responeJson, ActivityAllListResponse.class);
		return responseJson;
	}

}
