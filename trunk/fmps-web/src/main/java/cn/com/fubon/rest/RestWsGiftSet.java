package cn.com.fubon.rest;

import java.util.Date;
import java.util.Map;

import javax.jws.WebService;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.apache.log4j.Logger;
import org.jeecgframework.core.util.ApplicationContextUtil;
import org.springframework.util.StringUtils;

import weixin.popular.util.JsonUtil;
import cn.com.fubon.fo.repairplatform.entity.BaseResult;
import cn.com.fubon.fo.repairplatform.entity.WeixinGiftsetDetail;
import cn.com.fubon.fo.repairplatform.entity.request.GiftsetQrScanRequest;
import cn.com.fubon.fo.repairplatform.entity.request.QrScanRequest;
import cn.com.fubon.fo.repairplatform.service.RepairPlatformGiftService;
import cn.com.fubon.rest.service.impl.CommonWebServiceImpl;
import cn.com.fubon.util.CachedUtils;
import cn.com.fubon.util.Constants;
import cn.com.fubon.webservice.WsConstants;
import cn.com.fubon.wechatClaims.service.ClaimWebService;


/**
 * 企业号扫码后调用本服务
 * @author shanqi.wang
 *
 */
@WebService
@Path("/giftSet")
public class RestWsGiftSet  extends CommonWebServiceImpl {
	

	private static Logger logger = Logger.getLogger(RestWsGiftSet.class);
	
	/**
	 * 扫码服务
	 * @param timestamp
	 * @param signature
	 * @param input
	 * @param clientCode
	 * @return
	 */
	@POST
	@Path("qrScan")
	@Produces("application/json;charset=UTF-8")
	public String qrScan(@QueryParam("timestamp") String timestamp,
			@QueryParam("signature") String signature,
			@QueryParam("inputJson") String inputJson,
			@QueryParam("clientCode") String clientCode) {
		logger.debug("Receieving quest for timestamp: " + timestamp + "****"
				+ "signature:" + signature + "****" + "inputJson:" + inputJson
				+ "****" + "clientCode:" + clientCode);
		
		
		Map<String, Object> map = super.checkSignatureAndDecrypt(timestamp,
				signature, inputJson, clientCode);
		inputJson = (String) map.get(WsConstants.INPUTJSON);
		String responseJson = (String) map.get(WsConstants.RESPONSEJSON);
		byte[] key = (byte[]) map.get(WsConstants.AESKEY);

		if (StringUtils.isEmpty(responseJson)) {
			responseJson = this.process(inputJson);
		}
		// 报文明文入库，表weixin_transaction_record
		super.packetPutDB(inputJson, responseJson);

		// 响应报文加密
		responseJson = super.encryptJson(responseJson, key);

		return responseJson;
				
	}

	public String process(String inputJson){
		logger.info("开始处理扫码");
		BaseResult baseResult =new BaseResult();
		GiftsetQrScanRequest giftsetQrScanRequest = JsonUtil.parseObject(inputJson,
				GiftsetQrScanRequest.class);
		
		CachedUtils.set(giftsetQrScanRequest.getGiftset_detail_id(),giftsetQrScanRequest.getIfException()+","+giftsetQrScanRequest.getRepairid()+","+giftsetQrScanRequest.getRepairname()+","+giftsetQrScanRequest.getExceptionMessage());					
		logger.info("CachedUtils.get(giftsetQrScanRequest.getGiftset_detail_id())==>" + CachedUtils.get(giftsetQrScanRequest.getGiftset_detail_id()));
		if(Constants.QRCODEAJAX_0.equals(giftsetQrScanRequest.getIfException())) { //系统扫描后，企业号放回正常，修改券的使用状态
		updateWeixinGiftsetDetail(giftsetQrScanRequest.getGiftset_detail_id(),giftsetQrScanRequest.getRepairid(),giftsetQrScanRequest.getRepairname());
		  }
		baseResult.setErrcode(WsConstants.RETURNCODE_1);
		baseResult.setErrmsg(WsConstants.RETURNMESSAGE_1);	
		return JsonUtil.toJSONString(baseResult);
	}

	private void updateWeixinGiftsetDetail(String  giftsetDetailId,String repairid ,String repairname ){
		RepairPlatformGiftService	repairPlatformGiftService = (RepairPlatformGiftService) ApplicationContextUtil.getContext()
				.getBean("repairPlatformGiftService");
		WeixinGiftsetDetail weixinGiftsetDetail=repairPlatformGiftService.findUniqueByProperty(WeixinGiftsetDetail.class, "id", giftsetDetailId);
		weixinGiftsetDetail.setScanrepairid(repairid);
		weixinGiftsetDetail.setScanrepairname(repairname);
		weixinGiftsetDetail.setScandate(new Date());
		repairPlatformGiftService.updateEntitie(weixinGiftsetDetail);
	}
	
	
}
