package cn.com.fubon.fo.repairplatform.service.impl;

import javax.annotation.Resource;

import org.apache.commons.chain.Context;
import org.apache.log4j.Logger;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.jeecgframework.core.util.ResourceUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import weixin.popular.util.JsonUtil;
import cn.com.fubon.fo.repairplatform.entity.request.AreaGiftSetRequest;
import cn.com.fubon.fo.repairplatform.entity.request.GiftSetInstructionsRequest;
import cn.com.fubon.fo.repairplatform.entity.response.AreaGiftSetResponse;
import cn.com.fubon.fo.repairplatform.entity.response.GiftSetInstructionsResponse;
import cn.com.fubon.fo.repairplatform.service.RepairPlatformGiftWsService;
import cn.com.fubon.rest.service.impl.RestWebServiceClient;
import cn.com.fubon.webservice.WsConstants;
import cn.com.fubon.webservice.server.entity.WebServiceClientManagement;

@Service("repairPlatformGiftWsService")
@Transactional
public class RepairPlatformGiftWsServiceImpl extends CommonServiceImpl
		implements RepairPlatformGiftWsService {
	private static final Logger logger = Logger
			.getLogger(RepairPlatformGiftWsServiceImpl.class);

	@Resource(name = "giftSetInstructions")
	private RestWebServiceClient giftSetInstructionsClient;
	
	@Resource(name = "getMoreGiftSetByCountyCode")
	private RestWebServiceClient moreGiftSetWebServiceClient;

	@Override
	public GiftSetInstructionsResponse getGiftSetInstructionsResponse(
			GiftSetInstructionsRequest giftSetInstructionsRequest) {
		Context context = null;
		String clientCode = ResourceUtil.getBundleEnvAbout().getString(
				"clientCode");
		WebServiceClientManagement WebServiceClientManagement = this
				.findUniqueByProperty(WebServiceClientManagement.class,
						"clientCode", clientCode);
		String repairJson = JsonUtil.toJSONString(giftSetInstructionsRequest);
		logger.info("发送的json=== " + repairJson);
		try {
			context = giftSetInstructionsClient.startExecuteChain(repairJson,
					WebServiceClientManagement.getToken(),
					WebServiceClientManagement.getAESKey(), clientCode);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String responeXML = (String) context.get(WsConstants.RESPONSEJSON);
		logger.info("返回回来的xml=== " + responeXML);
		GiftSetInstructionsResponse giftSetInstructionsResponse = JsonUtil
				.parseObject(responeXML, GiftSetInstructionsResponse.class);
		return giftSetInstructionsResponse;
	}
	
	@Override
	public AreaGiftSetResponse getMoreGiftSetByCountyCode(
			AreaGiftSetRequest areaGiftSetRequest) {
		Context context = null;
		String clientCode = ResourceUtil.getBundleEnvAbout().getString(
				"clientCode");
		WebServiceClientManagement WebServiceClientManagement = this
				.findUniqueByProperty(WebServiceClientManagement.class,
						"clientCode", clientCode);
		String repairJson = JsonUtil.toJSONString(areaGiftSetRequest);
		logger.info("发送的json=== " + repairJson);
		try {
			context = moreGiftSetWebServiceClient.startExecuteChain(repairJson,
					WebServiceClientManagement.getToken(),
					WebServiceClientManagement.getAESKey(), clientCode);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String responeJson = (String) context.get(WsConstants.RESPONSEJSON);
		logger.info("返回回来的xml=== " + responeJson);
		AreaGiftSetResponse areaGiftSetResponse = JsonUtil
				.parseObject(responeJson, AreaGiftSetResponse.class);
		return areaGiftSetResponse;
	}

}
