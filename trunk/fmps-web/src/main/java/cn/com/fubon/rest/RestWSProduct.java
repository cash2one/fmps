/**
 * 
 */
package cn.com.fubon.rest;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

import javax.jws.WebService;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import jodd.util.StringUtil;

import org.apache.log4j.Logger;
import org.jeecgframework.core.util.ApplicationContextUtil;
import org.springframework.util.StringUtils;

import weixin.popular.util.JsonUtil;
import cn.com.fubon.rest.entity.request.ProductListRequest;
import cn.com.fubon.rest.entity.request.ProductRequest;
import cn.com.fubon.rest.entity.response.ProductListResponse;
import cn.com.fubon.rest.entity.response.ProductResponse;
import cn.com.fubon.rest.service.ProductWSService;
import cn.com.fubon.rest.service.impl.CommonWebServiceImpl;
import cn.com.fubon.rest.service.impl.ProductWSServiceImpl;
import cn.com.fubon.webservice.WsConstants;

/**
 * 保险产品查询webservice
 * 
 * @author qingqu.huang
 * @DATE 2015-10-14
 */
@WebService
@Path("/product")
public class RestWSProduct extends ProductWSServiceImpl {
	private static Logger logger = Logger.getLogger(RestWSProduct.class);

	/**
	 * 获取在售商品列表
	 * 
	 * @param timestamp
	 * @param signature
	 * @param inputJson
	 * @param clientCode
	 * @return
	 */
	@POST
	@Path("productList")
	@Produces("application/json;charset=UTF-8")
	public String productList(@QueryParam("timestamp") String timestamp,
			@QueryParam("signature") String signature,
			@QueryParam("inputJson") String inputJson,
			@QueryParam("clientCode") String clientCode) {
		Map<String, Object> map = super.checkSignatureAndDecrypt(timestamp,
				signature, inputJson, clientCode);
		inputJson = (String) map.get(WsConstants.INPUTJSON);
		String responseJson = (String) map.get(WsConstants.RESPONSEJSON);
		byte[] key = (byte[]) map.get(WsConstants.AESKEY);
		if (StringUtils.isEmpty(responseJson)) {
			responseJson = this.getProductListProcess(inputJson);
			logger.info(responseJson);
		}
		// 报文明文入库，表weixin_transaction_record
		super.packetPutDB(inputJson, responseJson);
		// 响应报文加密
		responseJson = super.encryptJson(responseJson, key);
		return responseJson;
	}

	/**
	 * 获取在售商品List
	 */
	public String getProductListProcess(String inputJson) {
		ProductListRequest productRequest = JsonUtil.parseObject(inputJson,
				ProductListRequest.class);
		ProductListResponse productListResponse = new ProductListResponse();
		List productList = super.findProductList(productRequest.getSaleway(),
				productRequest.getSeq());
		if (productList.size() <= 0) {
			productListResponse.setErrcode("0001");
			productListResponse.setErrmsg("没有在售商品...");
			return JsonUtil.toJSONString(productListResponse);
		}
		productListResponse.setErrcode(WsConstants.RETURNCODE_1);
		productListResponse.setErrmsg(WsConstants.RETURNMESSAGE_OK);
		productListResponse.setProductList(productList);
		return JsonUtil.toJSONString(productListResponse);
	}

	/**
	 * 获取商品基本信息，包含投保年龄和商品介绍
	 * 
	 * @param timestamp
	 * @param signature
	 * @param inputJson
	 * @param clientCode
	 * @return
	 */
	@POST
	@Path("productBaseMessage")
	@Produces("application/json;charset=UTF-8")
	public String product(@QueryParam("timestamp") String timestamp,
			@QueryParam("signature") String signature,
			@QueryParam("inputJson") String inputJson,
			@QueryParam("clientCode") String clientCode) {
		Map<String, Object> map = super.checkSignatureAndDecrypt(timestamp,
				signature, inputJson, clientCode);
		inputJson = (String) map.get(WsConstants.INPUTJSON);
		String responseJson = (String) map.get(WsConstants.RESPONSEJSON);
		byte[] key = (byte[]) map.get(WsConstants.AESKEY);
		if (StringUtils.isEmpty(responseJson)) {
			responseJson = this.getProductProcess(inputJson);
			logger.info(responseJson);
		}
		// 报文明文入库，表weixin_transaction_record
		super.packetPutDB(inputJson, responseJson);
		// 响应报文加密
		responseJson = super.encryptJson(responseJson, key);
		return responseJson;
	}

	public String getProductProcess(String inputJson) {
		ProductResponse productResponse = new ProductResponse();
		ProductRequest productRequest = JsonUtil.parseObject(inputJson,
				ProductRequest.class);
		String productid = productRequest.getProductid();
		if (StringUtil.isEmpty(productid)) {
			productResponse.setErrcode("0001");
			productResponse.setErrmsg("商品编号错误...");
			return JsonUtil.toJSONString(productResponse);
		}
		Map productMap = super.findProduct(productid);
		if (productMap == null) {
			productResponse.setErrcode("0002");
			productResponse.setErrmsg("没有查到对应的商品...");
			return JsonUtil.toJSONString(productResponse);
		}
		productResponse.setErrcode(WsConstants.RETURNCODE_1);
		productResponse.setErrmsg(WsConstants.RETURNMESSAGE_OK);
		productResponse
				.setImagehref(String.valueOf(productMap.get("imagehref")));
		productResponse.setType(String.valueOf(productMap.get("type")));
		productResponse.setInsuranceAge(String.valueOf(productMap
				.get("insuranceAge")));
		productResponse.setOccupationLevels(String.valueOf(productMap
				.get("occupationLevels")));
		productResponse.setProductname(String.valueOf(productMap
				.get("productname")));
		productResponse.setIntroduction(String.valueOf(productMap
				.get("introduction")));
		productResponse.setStatus(String.valueOf(productMap.get("status")));
		DecimalFormat df = new DecimalFormat("######0.00");
		BigDecimal minpremium = (BigDecimal) productMap.get("minpremium");
		BigDecimal maxpremium = (BigDecimal) productMap.get("maxpremium");
		productResponse.setMinpremium(minpremium.toString());
		productResponse.setMaxpremium(maxpremium.toString());
		List plannameList = super.findPlanNameList(productid);
		productResponse.setPlannameList(plannameList);
		List premiumList = super.findPlanList(productid);
		productResponse.setPremiumList(premiumList);
		return JsonUtil.toJSONString(productResponse);
	}

	/**
	 * 微店接口： 根据商品ID及类型ID(商品详情-typeId:4、常见问题-typeId:5、投保须知-typeId:2)，获取商品信息
	 * 
	 * @param timestamp
	 * @param signature
	 * @param inputJson
	 * @param clientCode
	 * @return
	 */
	@POST
	@Path("productInfo")
	@Produces("application/json;charset=UTF-8")
	public String productInfo(@QueryParam("timestamp") String timestamp,
			@QueryParam("signature") String signature,
			@QueryParam("inputJson") String inputJson,
			@QueryParam("clientCode") String clientCode) {
		Map<String, Object> map = super.checkSignatureAndDecrypt(timestamp,
				signature, inputJson, clientCode);
		inputJson = (String) map.get(WsConstants.INPUTJSON);
		String responseJson = (String) map.get(WsConstants.RESPONSEJSON);
		byte[] key = (byte[]) map.get(WsConstants.AESKEY);
		if (StringUtils.isEmpty(responseJson)) {
			responseJson = this.getProductInfoProcess(inputJson);
			logger.info(responseJson);
		}
		// 报文明文入库，表weixin_transaction_record
		super.packetPutDB(inputJson, responseJson);
		// 响应报文加密
		responseJson = super.encryptJson(responseJson, key);
		return responseJson;
	}

	public String getProductInfoProcess(String inputJson) {
		ProductResponse productResponse = new ProductResponse();
		ProductRequest productRequest = JsonUtil.parseObject(inputJson,
				ProductRequest.class);
		String productid = productRequest.getProductid();
		String typeid = productRequest.getTypeid();
		if (StringUtil.isEmpty(productid)) {
			productResponse.setErrcode("0001");
			productResponse.setErrmsg("商品编号错误...");
			return JsonUtil.toJSONString(productResponse);
		}
		Map productMap = super.findProduct(typeid, productid);
		if (productMap == null) {
			productResponse.setErrcode("0002");
			productResponse.setErrmsg("没有查到对应的商品...");
			return JsonUtil.toJSONString(productResponse);
		}
		productResponse.setErrcode(WsConstants.RETURNCODE_1);
		productResponse.setErrmsg(WsConstants.RETURNMESSAGE_OK);
		productResponse.setContent((String) productMap.get("content"));

		return JsonUtil.toJSONString(productResponse);
	}

}
