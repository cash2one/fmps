package cn.com.fubon.fo.repairplatform.service.impl;

import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.log4j.Logger;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.jeecgframework.core.util.ResourceUtil;
import org.jeecgframework.core.util.StringUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import weixin.popular.util.JsonUtil;
import cn.com.fubon.fo.repairplatform.entity.BaseResult;
import cn.com.fubon.fo.repairplatform.entity.request.EvaluationSaveRequest;
import cn.com.fubon.fo.repairplatform.entity.request.GiftSetDetailRequest;
import cn.com.fubon.fo.repairplatform.entity.request.ReceiveGiftSetRequest;
import cn.com.fubon.fo.repairplatform.entity.request.RepairCaseListRequest;
import cn.com.fubon.fo.repairplatform.entity.request.RepairEntityRequest;
import cn.com.fubon.fo.repairplatform.entity.request.RepairListRequest;
import cn.com.fubon.fo.repairplatform.entity.response.GiftSetDetailResponse;
import cn.com.fubon.fo.repairplatform.entity.response.ReceiveGiftSetResponse;
import cn.com.fubon.fo.repairplatform.entity.response.RepairCaseResponse;
import cn.com.fubon.fo.repairplatform.entity.response.RepairEntityResponse;
import cn.com.fubon.fo.repairplatform.entity.response.RepairListResponse;
import cn.com.fubon.fo.repairplatform.service.RepairPlatformWsService; 
import cn.com.fubon.rest.RestClient;
import cn.com.fubon.rest.service.impl.RestWebServiceClient;
import cn.com.fubon.util.CachedUtils;
import cn.com.fubon.webservice.WsConstants;
import cn.com.fubon.webservice.server.entity.WebServiceClientManagement;

import org.apache.commons.chain.Context;


@Service("repairPlatformWsService")
@Transactional
public class RepairPlatformWsServiceImpl extends CommonServiceImpl implements
		RepairPlatformWsService {
	private static final Logger logger = Logger
			.getLogger(RepairPlatformWsServiceImpl.class);
	
	@Resource(name="repairPlatformByArea")
	private RestWebServiceClient repairPlatformByAreaWsClient;
	
	@Resource(name="repairEntityResponse")
	private RestWebServiceClient repairEntityResponseWsClient;
	
	@Resource(name="caseListRequest")
	private RestWebServiceClient caseListRequestWsClient;
	
	@Resource(name="addEvaluation")
	private RestWebServiceClient addEvaluationWsClient;
	
	@Resource(name="getGiftSetInfo")
	private RestWebServiceClient getGiftSetInfoWsClient;
	
	@Resource(name="insertGiftSetDetail")
	private RestWebServiceClient insertGiftSetDetailWsClient;

	@Override
	public String getRepairListResponse(
			RepairListRequest repairListRequest ,String seqId  ) {
		Context context = null;		
		String clientCode = ResourceUtil.getBundleEnvAbout().getString(
				"clientCode");
		WebServiceClientManagement WebServiceClientManagement = this
				.findUniqueByProperty(WebServiceClientManagement.class,
						"clientCode", clientCode);
		// RepairListRequest repairRequest=new
		// RepairListRequest("厦门市","distance","厦门市思明区", "1");		
		String repairJson = JsonUtil.toJSONString(repairListRequest);		
		String cachekey = DigestUtils.md5Hex(repairListRequest.getCity()+repairListRequest.getAddress()+repairListRequest.getPaging()+repairListRequest.getOrder()+repairListRequest.getGiftset_detail_id()+seqId).toUpperCase();
		String cachevalue = (String) CachedUtils.get(cachekey);
		String responeXML = null;
		if (StringUtil.isEmpty(cachevalue)) {	
			try {
				long  dateStart=new Date().getTime();			
				context=  repairPlatformByAreaWsClient.startExecuteChain(repairJson, WebServiceClientManagement.getToken(), WebServiceClientManagement.getAESKey(),clientCode);
				long  dateEnd=new Date().getTime();
				logger.info("获取维修厂列表所需毫秒数====seqId======> " + String.valueOf(dateEnd-dateStart) );	
			} catch (Exception e) {
				// TODO Auto-generated catch block
				logger.info("获取维修厂列表失败   ",e);
				e.printStackTrace();
			}
			responeXML=(String) context.get(WsConstants.RESPONSEJSON);
			CachedUtils.set(cachekey, responeXML);
		} else {
			responeXML = cachevalue;
		}
		//RepairListResponse repairList = JsonUtil.parseObject(responeXML,RepairListResponse.class);		
		JSONObject  json=      JSONObject.fromObject(responeXML);
		String  repairListjson= json.get("repairList").toString();
		return repairListjson;
	}

	@Override
	public RepairEntityResponse getRepairEntityResponse(
			RepairEntityRequest repairEntityRequest) {
		Context context = null;		
		String clientCode = ResourceUtil.getBundleEnvAbout().getString(
				"clientCode");
		WebServiceClientManagement WebServiceClientManagement = this
				.findUniqueByProperty(WebServiceClientManagement.class,
						"clientCode", clientCode);		
		String repairJson = JsonUtil.toJSONString(repairEntityRequest);
		logger.info("发送的json=== " + repairJson);		
		try {
			context= repairEntityResponseWsClient.startExecuteChain(repairJson, WebServiceClientManagement.getToken(), WebServiceClientManagement.getAESKey(), clientCode);
		} catch (Exception e) {
			logger.info("获取单个维修厂失败   ",e);
			e.printStackTrace();
		}
		String responeXML=(String) context.get(WsConstants.RESPONSEJSON);		
		logger.info("返回回来的xml=== " + responeXML);
		RepairEntityResponse repairEntity = JsonUtil.parseObject(responeXML,
				RepairEntityResponse.class);
		return repairEntity;
	}

	@Override
	public BaseResult getEvaluationSave(
			EvaluationSaveRequest evaluationSaveRequest) {
		Context context = null;			
		String clientCode = ResourceUtil.getBundleEnvAbout().getString(
				"clientCode");
		WebServiceClientManagement WebServiceClientManagement = this
				.findUniqueByProperty(WebServiceClientManagement.class,
						"clientCode", clientCode);
		// RepairListRequest repairRequest=new
		// RepairListRequest("厦门市","distance","厦门市思明区", "1");
		String repairJson = JsonUtil.toJSONString(evaluationSaveRequest);
		logger.info("发送出去的json数据 " + repairJson);
		
		try {
			context =addEvaluationWsClient.startExecuteChain(repairJson, WebServiceClientManagement.getToken(), WebServiceClientManagement.getAESKey(), clientCode);
		} catch (Exception e) {
			logger.info("保存维修厂评价失败   ",e);
			e.printStackTrace();
		}	
		String responeXML=(String) context.get(WsConstants.RESPONSEJSON);		 
		logger.info("返回回来的xml " + responeXML);
		BaseResult baseResult = JsonUtil.parseObject(
				responeXML, BaseResult.class);
		return baseResult;
	}

	@Override
	public BaseResult getRepairCaseListResponse(
			RepairCaseListRequest repairCaseListRequest) {
		Context context = null;	
		String URL = ResourceUtil.getBundleEnvAbout().getString(
				"RepairWSClientGetRepairscanQrCodeUrl");
		String clientCode = ResourceUtil.getBundleEnvAbout().getString(
				"clientCode");
		WebServiceClientManagement WebServiceClientManagement = this
				.findUniqueByProperty(WebServiceClientManagement.class,
						"clientCode", clientCode);
		// RepairListRequest repairRequest=new
		// RepairListRequest("厦门市","distance","厦门市思明区", "1");
		String repairJson = JsonUtil.toJSONString(repairCaseListRequest);
		logger.info("发送的json是===" + repairJson);		
		 try {
			context= caseListRequestWsClient.startExecuteChain(repairJson, WebServiceClientManagement.getToken(), WebServiceClientManagement.getAESKey(), clientCode);
		} catch (Exception e) {
			logger.info("获取维修厂二维码失败   ",e);
			e.printStackTrace();
		}
		 String responeXML=(String) context.get(WsConstants.RESPONSEJSON);		
		logger.info("返回的xml是===" + responeXML);
		RepairCaseResponse repairCaseResponse = JsonUtil.parseObject(
				responeXML, RepairCaseResponse.class);
		return repairCaseResponse;
	}
	
	@Override
	public GiftSetDetailResponse getGiftSetDetailResponse(
			GiftSetDetailRequest giftSetDetailRequest) {
		Context context = null;		
		String clientCode = ResourceUtil.getBundleEnvAbout().getString(
				"clientCode");
		WebServiceClientManagement WebServiceClientManagement = this
				.findUniqueByProperty(WebServiceClientManagement.class,
						"clientCode", clientCode);		
		String requestJson = JsonUtil.toJSONString(giftSetDetailRequest);
		logger.info("发送的json=== " + requestJson);		
		try {
			context= getGiftSetInfoWsClient.startExecuteChain(requestJson, WebServiceClientManagement.getToken(), WebServiceClientManagement.getAESKey(), clientCode);
		} catch (Exception e) {
			logger.info("获取礼包失败   ",e);
			e.printStackTrace();
		}
		String responeXML=(String) context.get(WsConstants.RESPONSEJSON);		
		logger.info("返回回来的xml=== " + responeXML);
		GiftSetDetailResponse repairEntity = JsonUtil.parseObject(responeXML,
				GiftSetDetailResponse.class);
		return repairEntity;
	}

	@Override
	public ReceiveGiftSetResponse receiveGiftSetResponse(
			ReceiveGiftSetRequest receiveGiftSetRequest) {
		Context context = null;		
		String clientCode = ResourceUtil.getBundleEnvAbout().getString(
				"clientCode");
		WebServiceClientManagement WebServiceClientManagement = this
				.findUniqueByProperty(WebServiceClientManagement.class,
						"clientCode", clientCode);		
		String requestJson = JsonUtil.toJSONString(receiveGiftSetRequest);
		logger.info("发送的json=== " + requestJson);		
		try {
			context= insertGiftSetDetailWsClient.startExecuteChain(requestJson, WebServiceClientManagement.getToken(), WebServiceClientManagement.getAESKey(), clientCode);
		} catch (Exception e) {
			logger.info("获取礼包失败   ",e);
			e.printStackTrace();
		}
		String responeXML=(String) context.get(WsConstants.RESPONSEJSON);
		logger.info("返回回来的xml=== " + responeXML);
		ReceiveGiftSetResponse repairEntity = JsonUtil.parseObject(responeXML,
				ReceiveGiftSetResponse.class);
		return repairEntity;
	}

}
