package cn.com.fubon.rest;

import java.util.Map;

import javax.jws.WebService;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.apache.log4j.Logger;
import org.springframework.util.StringUtils;

import weixin.popular.util.JsonUtil;
import cn.com.fubon.fo.repairplatform.entity.BaseResult;
import cn.com.fubon.fo.repairplatform.entity.request.QrScanRequest;
import cn.com.fubon.rest.service.impl.CommonWebServiceImpl;
import cn.com.fubon.util.CachedUtils;
import cn.com.fubon.webservice.WsConstants;

/**
 * 企业号扫码后调用本服务
 * @author shanqi.wang
 *
 */
@WebService
@Path("/repair")
public class RestWsRepair extends CommonWebServiceImpl{
	private static Logger logger = Logger.getLogger(RestWsRepair.class);
	
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
	public String getlist(@QueryParam("timestamp") String timestamp,
			@QueryParam("signature") String signature,
			@QueryParam("inputJson") String inputJson,
			@QueryParam("clientCode") String clientCode) {
		logger.debug("Receieving quest for timestamp: " + timestamp + "______"
				+ "signature:" + signature + "______" + "inputJson:" + inputJson
				+ "______" + "clientCode:" + clientCode);
		
		
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
		BaseResult baseResult =new BaseResult();
		QrScanRequest qrScanRequest = JsonUtil.parseObject(inputJson,
				QrScanRequest.class);
		CachedUtils.set(qrScanRequest.getUuid(),qrScanRequest.getRepairid()+","+qrScanRequest.getAgentId()+","+qrScanRequest.getUserId()+","+qrScanRequest.getRepairname()+","+qrScanRequest.getQrType());					
		logger.info("CachedUtils.get(qrScanRequest.getUuid())==>" + CachedUtils.get(qrScanRequest.getUuid()));
		baseResult.setErrcode(WsConstants.RETURNCODE_1);
		baseResult.setErrmsg(WsConstants.RETURNMESSAGE_1);	
		return JsonUtil.toJSONString(baseResult);
	}
}
