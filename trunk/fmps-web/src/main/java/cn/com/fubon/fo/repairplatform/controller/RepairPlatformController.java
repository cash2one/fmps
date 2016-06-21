package cn.com.fubon.fo.repairplatform.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import jodd.util.StringUtil;

import org.apache.log4j.Logger;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.util.ResourceUtil;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import weixin.guanjia.account.entity.WeixinAccountEntity;
import weixin.guanjia.account.service.WeixinAccountServiceI;
import weixin.guanjia.core.util.WeixinUtil;
import weixin.guanjia.message.service.ReceiveMessageServiceI;
import weixin.util.JsSdkUtil;
import cn.com.fubon.fo.repairplatform.entity.WeixinRepairPlatform;
import cn.com.fubon.fo.repairplatform.service.RepairPlatformService;

@Scope("prototype")
@Controller
@RequestMapping("/fo/repairPlatformController")
public class RepairPlatformController {
	private static final Logger logger = Logger
			.getLogger(RepairPlatformController.class);
	@Resource
	private WeixinAccountServiceI weixinAccountService;
	@Resource
	private RepairPlatformService repairPlatformService;
	@Resource
	private ReceiveMessageServiceI receiveMessageService;

	@RequestMapping(params = "method=index")
	public ModelAndView index(HttpServletRequest request) {
		String accessToken = weixinAccountService
				.getAccessTokenFromAccountEntity();
		List<WeixinAccountEntity> weixinAccountEntityList = weixinAccountService
				.findValidWeixinAccounts();
		WeixinAccountEntity weixinAccountEntity = weixinAccountEntityList
				.get(0);
		String appid = weixinAccountEntity.getAccountappid();
		String URL = ResourceUtil.getDomain()+request.getServletPath() + "?" + request.getQueryString();		
		logger.info("jssdkPage url ===>" + URL);
		// appid = "wxeee8b84bc1946b90";
		// accessToken="0_tm5xkd1CyjJdlluZKgTCnAUmI8SmZcrId--OYC6Hglzk6ZTDHs5Mslzb38fW_gFtT3jk-0G7BtLLxWfuHBfjPmWBaLepPWlKCDaL9nj00";
		JsSdkUtil JsSdkUtil = new JsSdkUtil(URL, appid, accessToken);
		String JSONString = JsSdkUtil.getWxConfigJSONString();
		String code = request.getParameter("code");
		logger.info("code=>" + code);
		String openid = (String) request.getAttribute("openid");
		if (StringUtil.isEmpty(openid)) {
			openid = request.getParameter("openid");
		}
		logger.info("openid=>" + openid);
		if (StringUtil.isEmpty(openid) && !StringUtil.isEmpty(code)) {
			openid = WeixinUtil.getOpenId(
					weixinAccountEntity.getAccountappid(),
					weixinAccountEntity.getAccountappsecret(), code);
			logger.info("根据code获取 openid,获取到的openid=>" + openid);
		}
		// 查询用户2小时之内的最新上报地理位置
		String sql = "SELECT * FROM weixin_receive_message where date_add(createtime, interval 2 hour)>now() and   fromusername=? and  msgtype='location' order by createtime desc  LIMIT 1";

		List<Map<String, Object>> locationMessagelist = receiveMessageService
				.findForJdbc(sql, new String[] { openid });
		String latitude = "0";
		String longitude = "0";
		String address = "    ";
		if (locationMessagelist.size() > 0) {
			request.setAttribute("hasLocation", "YES");
			latitude = (String) locationMessagelist.get(0).get("Location_X");
			longitude = (String) locationMessagelist.get(0).get("Location_Y");
			address = (String) locationMessagelist.get(0).get("Location_Y");
		} else {
			request.setAttribute("hasLocation", "NO");
		}
		request.setAttribute("cityList", repairPlatformService.getCity());
		request.setAttribute("latitude", latitude);
		request.setAttribute("longitude", longitude);
		request.setAttribute("address", address);
		request.setAttribute("JSONString", JSONString);
		return new ModelAndView("/fo/repairplatform/repairPlatform");

	}

	/**
	 * 根据地区获取维修厂列表
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(params = "getRepairPlatformByArea")
	@ResponseBody
	public AjaxJson getRepairPlatformByArea(HttpServletRequest request)
			throws Exception {
		AjaxJson jsonString = new AjaxJson();
		Map<String, Object> AttributesMap = new HashMap<String, Object>();
		String city = "";
		city = java.net.URLDecoder
				.decode(request.getParameter("city"), "UTF-8");
		logger.info("上传的城市为 " + city);
		// 厂商列表
		List<WeixinRepairPlatform> weixinRepairPlatformList = repairPlatformService
				.getRepairPlatformList(city);
		AttributesMap.put("weixinRepairPlatformList", weixinRepairPlatformList);
		jsonString.setAttributes(AttributesMap);
		logger.info("返回的数据为 " + jsonString.toString());
		return jsonString;
	}

	@RequestMapping(params = "method=goToMapPage")
	public ModelAndView goToMapPage(HttpServletRequest request) {
		String latitude = request.getParameter("latitude");
		String longitude = request.getParameter("longitude");
		request.setAttribute("latitude", latitude);
		request.setAttribute("longitude", longitude);
		return new ModelAndView("/fo/repairplatform/mapPage");
	}

}
