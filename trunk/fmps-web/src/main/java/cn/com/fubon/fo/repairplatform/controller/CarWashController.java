/**
 * 
 */
package cn.com.fubon.fo.repairplatform.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.util.ResourceUtil;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.core.util.UUIDGenerator;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import weixin.guanjia.account.entity.WeixinAccountEntity;
import weixin.guanjia.account.service.WeixinAccountServiceI;
import weixin.popular.util.JsonUtil;
import weixin.util.JsSdkUtil;
import cn.com.fubon.common.entity.AddressCode;
import cn.com.fubon.common.entity.Catagory;
import cn.com.fubon.common.entity.WeixinGiftSet;
import cn.com.fubon.common.entity.WeixinRepair;
import cn.com.fubon.fo.repairplatform.entity.request.ActivityAllListRequest;
import cn.com.fubon.fo.repairplatform.entity.response.ActivityAllListResponse;
import cn.com.fubon.fo.repairplatform.service.CarHomeWsService;

/**
 * 洗车专区
 * 
 * @author qingqu.huang
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/fo/carWashController")
public class CarWashController {

	private static final Logger logger = Logger
			.getLogger(CarWashController.class);
	@Resource
	private CarHomeWsService carHomeWsService;
	@Resource
	private WeixinAccountServiceI weixinAccountService;

	@RequestMapping(params = "carWashIndex")
	public String carWashIndex(HttpServletRequest request) {
		String openid = (String) request.getAttribute("openid");
		if (StringUtil.isEmpty(openid)) {
			openid = request.getParameter("openid");
		}
		String citycode = request.getParameter("citycode");
		String address = request.getParameter("address");
		logger.info("首页传递过来的地址" + address);
		if (StringUtil.isNotEmpty(address)) {
			try {
				address = java.net.URLDecoder.decode(address, "UTF-8");
			} catch (UnsupportedEncodingException e) {
				logger.error("地址decode失败", e);
			}
		}
		String accessToken = weixinAccountService
				.getAccessTokenFromAccountEntity();
		List<WeixinAccountEntity> weixinAccountEntityList = weixinAccountService
				.findValidWeixinAccounts();
		WeixinAccountEntity weixinAccountEntity = weixinAccountEntityList
				.get(0);
		String appid = weixinAccountEntity.getAccountappid();
		String URL = ResourceUtil.getDomain() + request.getServletPath() + "?"
				+ request.getQueryString();
		logger.info("jssdkPage url ===>" + URL);
		JsSdkUtil JsSdkUtil = new JsSdkUtil(URL, appid, accessToken);
		String JSONString = JsSdkUtil.getWxConfigJSONString();
		request.setAttribute("appid", appid);
		request.setAttribute("JSONString", JSONString);
		request.setAttribute("address", address);
		request.setAttribute("openid", openid);
		request.setAttribute("citycode", citycode);
		return "/fo/repairplatform/carWashIndex";
	}

	@RequestMapping(params = "getMerchantList")
	@ResponseBody
	public String getMerchantList(HttpServletRequest request) {
		String openid = request.getParameter("openid");
		String paging = request.getParameter("paging");
		String order = request.getParameter("orderby");
		String citycode = request.getParameter("citycode");
		String countycode = request.getParameter("countycode");
		String categoryid = request.getParameter("categoryid");
		String address = request.getParameter("address");
		if (StringUtil.isNotEmpty(address)) {
			try {
				address = java.net.URLDecoder.decode(address, "UTF-8");
			} catch (UnsupportedEncodingException e) {
				logger.error("地址decode失败", e);
			}
		}
		logger.info("openid=" + openid + ",categoryid=" + categoryid
				+ ",paging=" + paging + ",order=" + order + ",citycode="
				+ citycode + ",countcode=" + countycode);
		ActivityAllListRequest activityAllListRequest = new ActivityAllListRequest(
				"fmps", "fcps", "json", "28", UUIDGenerator.generate(),
				citycode, countycode, address, "", categoryid, "", order,
				paging);
		ActivityAllListResponse allFactory = carHomeWsService
				.loadCarWashMerchantList(activityAllListRequest);
		String result = JsonUtil.toJSONString(allFactory);
		return result;
	}

}
