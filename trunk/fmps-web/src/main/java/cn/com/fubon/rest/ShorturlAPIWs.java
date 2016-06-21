package cn.com.fubon.rest;

import java.util.Map;

import javax.jws.WebService;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.apache.log4j.Logger;
import org.jeecgframework.core.util.ApplicationContextUtil;
import org.springframework.util.StringUtils;

import weixin.guanjia.account.service.WeixinAccountServiceI;
import weixin.popular.api.ShorturlAPI;
import weixin.popular.util.JsonUtil;
import cn.com.fubon.rest.entity.request.ShorturlAPIRequest;
import cn.com.fubon.rest.entity.response.ShorturlAPIResponse;
import cn.com.fubon.rest.service.impl.CommonWebServiceImpl;
import cn.com.fubon.webservice.WsConstants;

/**
 * 短连接查询接口
 * 
 * @author guojunjie
 *
 */
@WebService
@Path("/shorturlAPI")
public class ShorturlAPIWs extends CommonWebServiceImpl {

	private static Logger logger = Logger.getLogger(ShorturlAPIWs.class);

	/**
	 * 获得短链接
	 * 
	 * @param timestamp
	 * @param signature
	 * @param input
	 * @param clientCode
	 * @return
	 */
	@POST
	@Path("shortURL")
	@Produces("application/json;charset=UTF-8")
	public String shortURL(@QueryParam("timestamp") String timestamp,
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

	public String process(String inputJson) {
		logger.info("开始获得短链接");
		ShorturlAPIResponse shorturlAPIResponse = new ShorturlAPIResponse();
		ShorturlAPIRequest shorturlAPIRequest = JsonUtil.parseObject(inputJson,
				ShorturlAPIRequest.class);
		WeixinAccountServiceI weixinAccountService = (WeixinAccountServiceI) ApplicationContextUtil
				.getContext().getBean("weixinAccountService");

		String accessToken = weixinAccountService
				.getAccessTokenFromAccountEntity();
		String shortUrl = ShorturlAPI.shortURL(accessToken,
				shorturlAPIRequest.getUrl());

		shorturlAPIResponse.setUrl(shortUrl);
		shorturlAPIResponse.setErrcode(WsConstants.RETURNCODE_1);
		shorturlAPIResponse.setErrmsg(WsConstants.RETURNMESSAGE_OK);
		return JsonUtil.toJSONString(shorturlAPIResponse);
	}

}
