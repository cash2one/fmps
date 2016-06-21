package cn.com.fubon.fo.repairplatform.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jodd.datetime.JDateTime;
import jodd.util.StringUtil;

import org.apache.log4j.Logger;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.extend.datasource.DataSourceContextHolder;
import org.jeecgframework.core.extend.datasource.DataSourceType;
import org.jeecgframework.core.util.ResourceUtil;
import org.jeecgframework.core.util.UUIDGenerator;
import org.jeecgframework.web.system.pojo.base.TSType;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import weixin.guanjia.account.entity.WeixinAccountEntity;
import weixin.guanjia.account.service.WeixinAccountServiceI;
import weixin.guanjia.core.util.WeixinUtil;
import weixin.idea.huodong.entity.HuodongEntity;
import weixin.popular.util.JsonUtil;
import weixin.util.JsSdkUtil;
import cn.com.fubon.common.entity.WeixinEvaluation;
import cn.com.fubon.common.entity.WeixinGiftSet;
import cn.com.fubon.fo.cashcoupon.service.CashCouponService;
import cn.com.fubon.fo.customerbind.entity.WeiXinGzUserInfo;
import cn.com.fubon.fo.repairplatform.entity.BaseResult;
import cn.com.fubon.fo.repairplatform.entity.WeixinRepairEvaluation;
import cn.com.fubon.fo.repairplatform.entity.request.ActivityAllListRequest;
import cn.com.fubon.fo.repairplatform.entity.request.AdvertisementListRequest;
import cn.com.fubon.fo.repairplatform.entity.request.GiftSetDetailRequest;
import cn.com.fubon.fo.repairplatform.entity.request.ReceiveGiftSetRequest;
import cn.com.fubon.fo.repairplatform.entity.request.RecommendListRequest;
import cn.com.fubon.fo.repairplatform.entity.request.RecommendRepairListRequest;
import cn.com.fubon.fo.repairplatform.entity.request.RepairEntityRequest;
import cn.com.fubon.fo.repairplatform.entity.request.RepairListRequest;
import cn.com.fubon.fo.repairplatform.entity.response.ActivityAllListResponse;
import cn.com.fubon.fo.repairplatform.entity.response.AdvertisementListResponse;
import cn.com.fubon.fo.repairplatform.entity.response.GiftSetDetailResponse;
import cn.com.fubon.fo.repairplatform.entity.response.ReceiveGiftSetResponse;
import cn.com.fubon.fo.repairplatform.entity.response.RecommendListResponse;
import cn.com.fubon.fo.repairplatform.entity.response.RecommendRepairListResponse;
import cn.com.fubon.fo.repairplatform.entity.response.RepairEntityResponse;
import cn.com.fubon.fo.repairplatform.service.CarHomeWsService;
import cn.com.fubon.fo.repairplatform.service.RepairPlatformGiftService;
import cn.com.fubon.fo.repairplatform.service.RepairPlatformService;
import cn.com.fubon.fo.repairplatform.service.RepairPlatformWsService;
import cn.com.fubon.util.AESUtils;
import cn.com.fubon.util.CachedUtils;
import cn.com.fubon.util.Constants;

@Scope("prototype")
@Controller
@RequestMapping("/fo/carHomeController")
public class CarHomeController {
	private static final Logger logger = Logger
			.getLogger(CarHomeController.class);

	@Resource
	private WeixinAccountServiceI weixinAccountService;
	@Resource
	private RepairPlatformService repairPlatformService;

	@Resource
	private CarHomeWsService carHomeWsService;
	@Resource
	private RepairPlatformWsService repairPlatformWsService;
	@Resource
	private RepairPlatformGiftService repairPlatformGiftService;
	@Resource
	private CashCouponService cashCouponServiceImpl;
	
	private final static String CHE_YI_XING_AES_KEY = "1234567890123456";
	private final static String CHE_YI_XING_USER_FROM = "fubang2015";

	/**
	 * 进入厂商列表界面
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "method=carHomeIndex")
	public ModelAndView carHomeIndex(HttpServletRequest request) {
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
		String hasLbs = "YES";
		String latitude = (String) CachedUtils
				.get(Constants.MEMKEY_WEIXIN_latitude + openid);
		String longitude = (String) CachedUtils
				.get(Constants.MEMKEY_WEIXIN_longitude + openid);
		if (StringUtil.isEmpty(latitude) && StringUtil.isEmpty(longitude)) {
			hasLbs = "NO";
			latitude = "0";
			longitude = "0";
		}
		logger.info("缓存的地理位置为===>" + latitude + ":" + longitude);
		
		//违章代缴user_id
		WeiXinGzUserInfo gzUserInfo = (WeiXinGzUserInfo)CachedUtils.get(openid + Constants.MEMKEY_WEIXIN_GZUSERINFO);
		if(null != gzUserInfo){
			request.setAttribute("weixin_gzuserinfo_id", gzUserInfo.getId());
			request.setAttribute("user_from", CHE_YI_XING_USER_FROM);
			try{
				String beforeToken = AESUtils.encryptData(gzUserInfo.getId() + CHE_YI_XING_USER_FROM,CHE_YI_XING_AES_KEY.getBytes("UTF-8"));
				request.setAttribute("token",URLEncoder.encode(beforeToken,"UTF-8"));
			}catch(UnsupportedEncodingException e){
				logger.error("encode CheYiXing token UnsupportedEncodingException",e);
			}
		}
		request.setAttribute("hasLbs", hasLbs);
		request.setAttribute("latitude", latitude);
		request.setAttribute("longitude", longitude);
		request.setAttribute("openid", openid);
		List<TSType> cityList = repairPlatformService
				.getCityFromTSType("citylist");
		request.setAttribute("cityList", cityList);
		request.setAttribute("JSONString", JSONString);
		return new ModelAndView("/fo/repairplatform/carHomeindex");
	}

	/**
	 * 根据地区、地址获取爱车之家首页广告信息
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(params = "getadvertisementList")
	@ResponseBody
	public String getadvertisementList(HttpServletRequest request)
			throws Exception {
		Date time_start=new Date();
		//AjaxJson jsonString = new AjaxJson();
		String cityCode = request.getParameter("cityCode");
		String openid = request.getParameter("openid");
		String latitude = request.getParameter("latitude");
		String longitude = request.getParameter("longitude");
		if (!StringUtil.isEmpty(latitude) && !StringUtil.isEmpty(longitude)) {
			CachedUtils
					.set(Constants.MEMKEY_WEIXIN_latitude + openid, latitude);
			CachedUtils.set(Constants.MEMKEY_WEIXIN_longitude + openid,
					longitude);
			logger.info("上传的地理位置为===>" + latitude + ":" + longitude);
		}
		Map<String, Object> AttributesMap = new HashMap<String, Object>();
		AdvertisementListRequest advertisementListRequest = new AdvertisementListRequest(
				"fmps", "fcps", "json", "26", UUIDGenerator.generate(),
				cityCode, "");
		AdvertisementListResponse advertisementListResponse = carHomeWsService
				.getAdvertisementList(advertisementListRequest);
		AttributesMap.put("carHomeResponse", advertisementListResponse);
		//jsonString.setAttributes(AttributesMap);
		// jsonString.setSuccess(false);
		// jsonString.setMsg("未知错误 ");
		//logger.info("返回的数据为 " + jsonString.toString());
		Date time_end=new Date();
		logger.info("getadvertisementList==time_end-time_start===>"+(time_end.getTime()-time_start.getTime()));
		
		String result = JsonUtil.toJSONString(advertisementListResponse);
		return result;
		//return jsonString;
	}

	/**
	 * 根据地区、地址获取爱车之家首页精品信息
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(params = "getrecommendList")
	@ResponseBody
	public String getrecommendList(HttpServletRequest request)
			throws Exception {
		Date time_start=new Date();
		//AjaxJson jsonString = new AjaxJson();
		String cityCode = request.getParameter("cityCode");
		String openid = request.getParameter("openid");
		String latitude = request.getParameter("latitude");
		String longitude = request.getParameter("longitude");
		if (!StringUtil.isEmpty(latitude) && !StringUtil.isEmpty(longitude)) {
			CachedUtils
					.set(Constants.MEMKEY_WEIXIN_latitude + openid, latitude);
			CachedUtils.set(Constants.MEMKEY_WEIXIN_longitude + openid,
					longitude);
			logger.info("上传的地理位置为===>" + latitude + ":" + longitude);
		}
		Map<String, Object> AttributesMap = new HashMap<String, Object>();
		RecommendListRequest recommendListRequest = new RecommendListRequest(
				"fmps", "fcps", "json", "31", UUIDGenerator.generate(),
				cityCode, "");
		RecommendListResponse recommendListResponse = carHomeWsService
				.getRecommendList(recommendListRequest);
		AttributesMap.put("carHomeResponse", recommendListResponse);
		//jsonString.setAttributes(AttributesMap);
		// jsonString.setSuccess(false);
		// jsonString.setMsg("未知错误 ");
		//logger.info("返回的数据为 " + jsonString.toString());
		Date time_end=new Date();
		logger.info("getrecommendList==time_end-time_start===>"+(time_end.getTime()-time_start.getTime()));
		String result = JsonUtil.toJSONString(recommendListResponse);
		return result;
		
		//return jsonString;
	}

	/**
	 * 根据地区、地址获取爱车之家首页信息
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(params = "getrecommendRepairList")
	@ResponseBody
	public String getrecommendRepairList(HttpServletRequest request)
			throws Exception {
		Date time_start=new Date();
		//AjaxJson jsonString = new AjaxJson();
		String cityCode = request.getParameter("cityCode");
		String address = java.net.URLDecoder.decode(
				request.getParameter("address"), "UTF-8");
		logger.info("已经进入方法===citycode=====>" + cityCode + " . address:"
				+ address);
		String openid = request.getParameter("openid");
		String latitude = request.getParameter("latitude");
		String longitude = request.getParameter("longitude");
		if (!StringUtil.isEmpty(latitude) && !StringUtil.isEmpty(longitude)) {
			CachedUtils
					.set(Constants.MEMKEY_WEIXIN_latitude + openid, latitude);
			CachedUtils.set(Constants.MEMKEY_WEIXIN_longitude + openid,
					longitude);
			logger.info("上传的地理位置为===>" + latitude + ":" + longitude);
		}
		Map<String, Object> AttributesMap = new HashMap<String, Object>();
		RecommendRepairListRequest recommendRepairListRequest = new RecommendRepairListRequest(
				"fmps", "fcps", "json", "32", UUIDGenerator.generate(),
				cityCode, address);
		RecommendRepairListResponse recommendRepairListResponse = carHomeWsService
				.getRecommendRepairList(recommendRepairListRequest);
		AttributesMap.put("carHomeResponse", recommendRepairListResponse);
		//jsonString.setAttributes(AttributesMap);
		// jsonString.setSuccess(false);
		// jsonString.setMsg("未知错误 ");
		//logger.info("返回的数据为 " + jsonString.toString());
		Date time_end=new Date();
		logger.info("getrecommendRepairList==time_end-time_start===>"+(time_end.getTime()-time_start.getTime()));
		String result = JsonUtil.toJSONString(recommendRepairListResponse);
		return result;		
		//return jsonString;
	}

	/**
	 * 进入厂商主页面
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "method=MerchantMain")
	public ModelAndView merchantMain(HttpServletRequest request) {
		String repairId = (String) request.getAttribute("repairId");
		if (StringUtil.isEmpty(repairId)) {
			repairId = request.getParameter("repairId");
		}
		String openid = (String) request.getAttribute("openid");
		if (StringUtil.isEmpty(openid)) {
			openid = request.getParameter("openid");
		}
		logger.info("openid===" + openid);
		request.setAttribute("openid", openid);
		RepairEntityRequest repairEntityRequest = new RepairEntityRequest(
				"fmps", "fcps", "json", "12", UUIDGenerator.generate(),
				repairId, openid);
		logger.info("开始发送请求=== ");
		RepairEntityResponse repairEntityResponse = repairPlatformWsService
				.getRepairEntityResponse(repairEntityRequest);

		WeixinRepairEvaluation weixinRepairEvaluation = new WeixinRepairEvaluation();
		weixinRepairEvaluation.setOpenid(openid);
		weixinRepairEvaluation.setRepairid(repairId);
		CriteriaQuery cq = new CriteriaQuery(WeixinRepairEvaluation.class);
		cq.isNull("evaluation");
		cq.isNull("comment");
		// 查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq,
				weixinRepairEvaluation);
		cq.add();
		List<WeixinRepairEvaluation> weixinRepairEvaluationList = repairPlatformService
				.getListByCriteriaQuery(cq, true);

		WeixinRepairEvaluation weixinRepairEvaluationn = new WeixinRepairEvaluation();
		weixinRepairEvaluationn.setOpenid(openid);
		weixinRepairEvaluationn.setRepairid(repairId);
		CriteriaQuery cqq = new CriteriaQuery(WeixinRepairEvaluation.class);
		cqq.isNotNull("evaluation");
		cqq.isNotNull("comment");
		// 查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(
				cqq, weixinRepairEvaluationn);
		cqq.add();
		List<WeixinRepairEvaluation> weixinRepairEvaluationListt = repairPlatformService
				.getListByCriteriaQuery(cqq, false);

		if (weixinRepairEvaluationList.size() > 0) {
			request.setAttribute("evaluationflag", "1");
		}
		if (weixinRepairEvaluationListt.size() > 0) {
			request.setAttribute("evaluationcount",
					weixinRepairEvaluationListt.size());
		} else {
			request.setAttribute("evaluationcount", "0");
		}

		if (repairEntityResponse != null) {
			// request.setAttribute("weixinevaluation",repairEntityResponse.getWeixinEvaluation());
			request.setAttribute("repairImageList",
					repairEntityResponse.getRepairImageList());	
			List<WeixinEvaluation> weixinEvaluationList=new ArrayList<WeixinEvaluation>();
			for(WeixinEvaluation weixinEvaluation: repairEntityResponse.getEvaluationList()){	    		
				try {
					WeiXinGzUserInfo weiXinGzUserInfo=carHomeWsService.findByProperty(WeiXinGzUserInfo.class, "openid", weixinEvaluation.getOpenid()).get(0);
					weixinEvaluation.setNickname(weiXinGzUserInfo.getNickname());
				} catch (Exception e) {
					weixinEvaluation.setNickname("");
					 logger.info("没有查找到评价客户的昵称" ,e);
				}
				weixinEvaluationList.add(weixinEvaluation);				
			}
			request.setAttribute("evaluationList",
					weixinEvaluationList);
			request.setAttribute("WeixinRepair",
					repairEntityResponse.getRepair());
			request.setAttribute("repairId", repairId);
			request.setAttribute("openid", openid);
			request.setAttribute("giftSetList",
					repairEntityResponse.getGiftSetList());
			List<WeixinGiftSet> carWashList = new ArrayList<WeixinGiftSet>();
			int hour = new JDateTime().getHour();
			if( repairEntityResponse.getCarWashList()!=null){ 
			for (WeixinGiftSet weixinGift : repairEntityResponse
					.getCarWashList()) {
				if (weixinGift.getType().equals("5")) {
					String[] stingTime = weixinGift.getStarttime().split(":");
					weixinGift.setStarttime(stingTime[0] + ":" + stingTime[1]);
					String[] endTime = weixinGift.getEndtime().split(":");
					weixinGift.setEndtime(endTime[0] + ":" + endTime[1]);
					if (hour >= Integer.parseInt(stingTime[0])
							&& hour <= Integer.parseInt(endTime[0])) {
						weixinGift.setReceivedQuantity("cz");
					}
				}
				carWashList.add(weixinGift);

			}
			}
			request.setAttribute("carWashList", carWashList);
			return new ModelAndView("/fo/repairplatform/MerchantMain");
		} else {
			request.setAttribute("message", "系统通讯异常，请稍候再试...");
			return new ModelAndView("/fo/common/message");
		}

	}

	/**
	 * 进入到抵用券详情页
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "method=goToGiftSetDetail")
	public ModelAndView goToGiftsetDetail(HttpServletRequest request) {
		String giftSetId = (String) request.getAttribute("giftSetId");
		if (StringUtil.isEmpty(giftSetId)) {
			giftSetId = request.getParameter("giftSetId");
		}
		String openid = (String) request.getAttribute("openid");
		if (StringUtil.isEmpty(openid)) {
			openid = request.getParameter("openid");
		}
		if (StringUtil.isEmpty(openid)) {
			String code = request.getParameter("code");
			DataSourceContextHolder
					.setDataSourceType(DataSourceType.dataSource_jeecg);
			List<WeixinAccountEntity> weixinAccountEntityList = weixinAccountService
					.findValidWeixinAccounts();
			WeixinAccountEntity weixinAccountEntity = weixinAccountEntityList
					.get(0);
			openid = WeixinUtil.getOpenId(
					weixinAccountEntity.getAccountappid(),
					weixinAccountEntity.getAccountappsecret(), code);
		}

		request.setAttribute("openid", openid);

		String state = (String) request.getAttribute("state");
		if (StringUtil.isEmpty(state)) {
			state = request.getParameter("state");
		}
		if (StringUtil.isEmpty(giftSetId)) {
			giftSetId = state; // 从双11页面带过来的 券ID
		}
		logger.info("method=goToGiftSetDetail==giftSetId==>" + giftSetId
				+ ",openid:" + openid + ",state:" + state);
		// 请求报文
		GiftSetDetailRequest giftSetDetailRequest = new GiftSetDetailRequest(
				"fmps", "fcps", "json", "22", UUIDGenerator.generate(), openid,
				giftSetId);
		// 响应报文
		GiftSetDetailResponse giftSetDetailResponse = repairPlatformWsService
				.getGiftSetDetailResponse(giftSetDetailRequest);

		if (giftSetDetailResponse != null) {
			request.setAttribute("giftSet", giftSetDetailResponse.getGiftSet());
			request.setAttribute("merchant",
					giftSetDetailResponse.getMerchant());
			request.setAttribute("status", this.getStatus(openid, giftSetId,
					giftSetDetailResponse.getGiftSet().getRemainQuantity(),giftSetDetailResponse.getGiftSet().getStarttime(),giftSetDetailResponse.getGiftSet().getEndtime(),giftSetDetailResponse.getGiftSet().getType()));
			// 获取jssdk配置
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
			String jsonString = JsSdkUtil.getWxConfigJSONString();
			request.setAttribute("jsonString", jsonString);
			request.setAttribute("appid", this.getAppid(request));
			String huodongid=ResourceUtil.getBundleEnvAbout().getString(
					"cashcouponhuodongid");
			request.setAttribute("huodongid", huodongid);
			if(cashCouponServiceImpl.getCashCoupon(openid, huodongid)!=null){
				request.setAttribute("hasCashcoupon", "YES");
			}else{
				request.setAttribute("hasCashcoupon", "NO");
			}
			return new ModelAndView("/fo/repairplatform/giftSetDetail");
		} else {
			request.setAttribute("message", "系统通讯异常，请稍候再试...");
			return new ModelAndView("/fo/common/message");
		}
	}

	/**
	 * 获取微信初始化数据
	 * 
	 * @param request
	 * @return
	 */
	public String getJsonStr(HttpServletRequest request) {
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
		String jsonString = JsSdkUtil.getWxConfigJSONString();
		logger.info("jssdkConfig ===>" + jsonString);
		return jsonString;
	}
 
	public String getStatus(String openid, String giftSetId,
			String remainQuantity,String starttime ,String endtime ,String type ) {
		// status:0 领取、status:1已领取、status:2 已抢光、status:3 您已经领满200张券 、status:4 已过领取时间
		//是否已过抢的时间 
		if(type.equals("5")){			 
			Date star_date = null ;
			Date end_date = null ;
			Date  now=new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			try {
				  star_date = sdf.parse(starttime);
				  end_date = sdf.parse(endtime);
			    } catch (ParseException e) {				 
				 logger.info("超值洗车券领取页面日期转换错误" ,e);
			   }
			  if(now.getTime()<star_date.getTime()||now.getTime()>end_date.getTime()){
				  return "4";
			   }
		      }
		// 1.判断库存量
		if (Integer.parseInt(remainQuantity) <= 0)
			return "2";
		// 2.判断是否已领取该张券
		if (repairPlatformGiftService.isReceivedThisGiftSet(openid, giftSetId))
			return "1";
		// 3.判断每人本年度是否领取200张券
		if (repairPlatformGiftService.isReceivedLimitedQuantityGiftSet(openid))
			return "3";
		return "0";
	}

	@RequestMapping(params = "method=getMerchandiseRecommend")
	public ModelAndView getMerchandiseRecommend(HttpServletRequest request) {
		String merchandiseId = request.getParameter("merchandiseId"); // 推荐产品id
		String type = request.getParameter("type"); // 类型 1、券 2、商户
		String openid = request.getParameter("openid"); // 类型 1、券 2、商户
		if (type.equals("1")) {
			return new ModelAndView(
					"redirect:/fo/carHomeController.do?method=goToGiftSetDetail&openid="
							+ openid + "&giftSetId=" + merchandiseId);
		} else {
			return new ModelAndView(
					"redirect:/fo/carHomeController.do?method=MerchantMain&openid="
							+ openid + "&repairId=" + merchandiseId);
		}
	}

	/**
	 * 使用门店页面
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "method=merchantList")
	public ModelAndView merchantList(HttpServletRequest request) {
		String giftset_detail_id = request.getParameter("id");
		String cardtype = request.getParameter("cardtype");
		String openid = (String) request.getAttribute("openid");
		if (StringUtil.isEmpty(openid)) {
			openid = request.getParameter("openid");
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
		String code = request.getParameter("code");
		logger.info("code=>" + code);
		logger.info("openid=>" + openid);
		if (StringUtil.isEmpty(openid) && !StringUtil.isEmpty(code)) {
			openid = WeixinUtil.getOpenId(
					weixinAccountEntity.getAccountappid(),
					weixinAccountEntity.getAccountappsecret(), code);
			logger.info("根据code获取 openid,获取到的openid=>" + openid);
		}
		String hasLbs = "YES";
		String latitude = (String) CachedUtils
				.get(Constants.MEMKEY_WEIXIN_latitude + openid);
		String longitude = (String) CachedUtils
				.get(Constants.MEMKEY_WEIXIN_longitude + openid);
		if (StringUtil.isEmpty(latitude) && StringUtil.isEmpty(longitude)) {
			hasLbs = "NO";
			latitude = "0";
			longitude = "0";
		}
		logger.info("缓存的地理位置为===>" + latitude + ":" + longitude);
		request.setAttribute("hasLbs", hasLbs);
		request.setAttribute("latitude", latitude);
		request.setAttribute("longitude", longitude);
		request.setAttribute("openid", openid);
		request.setAttribute("JSONString", JSONString);
		request.setAttribute("giftsetDetailId", giftset_detail_id);
		request.setAttribute("cardtype", cardtype);
		return new ModelAndView("/fo/repairplatform/merchantList");
	}

	/**
	 * 根据券ID获取使用门店
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(params = "getmerchantListByGiftSetId")
	@ResponseBody
	public AjaxJson getRepairPlatformByArea(HttpServletRequest request)
			throws Exception {
		logger.info("已经进入方法========>");
		String giftsetDetailId = request.getParameter("giftsetDetailId");
		AjaxJson jsonString = new AjaxJson();
		String order = request.getParameter("order");
		String city = java.net.URLDecoder.decode(request.getParameter("city"),
				"UTF-8");
		String address = java.net.URLDecoder.decode(
				request.getParameter("address"), "UTF-8");
		String paging = request.getParameter("paging");
		String openid = request.getParameter("openid");
		String cardtype = request.getParameter("cardtype");
		String latitude = request.getParameter("latitude");
		String longitude = request.getParameter("longitude");
		String seqId = request.getParameter("seqId");
		if (!StringUtil.isEmpty(latitude) && !StringUtil.isEmpty(longitude)) {
			CachedUtils
					.set(Constants.MEMKEY_WEIXIN_latitude + openid, latitude);
			CachedUtils.set(Constants.MEMKEY_WEIXIN_longitude + openid,
					longitude);
			logger.info("上传的地理位置为===>" + latitude + ":" + longitude);
		}
		logger.info("上传的 ===城市为========>" + city + "\r\n上传的  ===地址为========>"
				+ address + "\r\n上传的 ===排序为==-=====> " + order
				+ "\r\n上传的 ===分页为==-=====> " + paging
				+ "\r\n上传的 ===openid为==-=====> " + openid
				+ "\r\n上传的 ===giftset_detail_id为==-=====> " + giftsetDetailId
				+ "\r\n上传的 ===cardtype为==-=====> " + cardtype);
		Map<String, Object> AttributesMap = new HashMap<String, Object>();
		RepairListRequest repair = new RepairListRequest("fmps", "fcps",
				"json", "11", UUIDGenerator.generate(), city, order, address,
				paging, openid, giftsetDetailId);

		String merchantListResponse = repairPlatformWsService
				.getRepairListResponse(repair, seqId);
		// 厂商列表
		// List<WeixinRepair> weixinRepairPlatformList = repairListResponse
		// .getRepairList();

		// AttributesMap.put("weixinRepairPlatformList", repairListResponse);
		jsonString.setObj(merchantListResponse);
		logger.info("返回的数据为 " + jsonString.toString());
		return jsonString;
	}

	/**
	 * (搜索功能)进入搜索页面
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(params = "method=carHomeSearch")
	public ModelAndView carHomeSearch(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		// 获取session的openid
		String openid = (String) request.getSession().getAttribute(
				Constants.SESSION_KEY_OPENID);

		// 条件
		String citycode = request.getParameter("citycode");
		String address = java.net.URLDecoder.decode(
				request.getParameter("address"), "UTF-8");
		String searchnameTemp = request.getParameter("searchname");
		String searchname = (searchnameTemp == null) ? "" : java.net.URLDecoder
				.decode(request.getParameter("searchname"), "UTF-8");
		String order = "distance"; // 默认：distance
		String paging = "1"; // 默认：1

		request.setAttribute("openid", openid);
		request.setAttribute("citycode", citycode);
		request.setAttribute("address", address);
		request.setAttribute("searchname", searchname);
		request.setAttribute("order", order);
		request.setAttribute("paging", paging);
		return new ModelAndView("/fo/repairplatform/carHomeSearch");
	}

	/**
	 * (搜索功能)进入搜索结果页面
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(params = "method=toCarHomeSearchResultPage")
	public ModelAndView toCarHomeSearchResultPage(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		// 获取session的openid
		String openid = (String) request.getSession().getAttribute(
				Constants.SESSION_KEY_OPENID);
		// 条件
		String citycode = request.getParameter("citycode");
		String address = java.net.URLDecoder.decode(
				request.getParameter("address"), "UTF-8");
		String searchname = java.net.URLDecoder.decode(
				request.getParameter("searchname"), "UTF-8");
		String order = "distance"; // 默认：distance
		String paging = "1"; // 默认：1

		request.setAttribute("openid", openid);
		request.setAttribute("citycode", citycode);
		request.setAttribute("address", address);
		request.setAttribute("searchname", searchname);
		request.setAttribute("order", order);
		request.setAttribute("paging", paging);
		return new ModelAndView("/fo/repairplatform/carHomeSearchResult");
	}

	/**
	 * (搜索功能)ajax加载：获取搜索全部厂商列表
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws throws Exception
	 */
	@RequestMapping(params = "method=getAllFactoryList")
	@ResponseBody
	public String getAllFactoryList(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		// 条件
		String citycode = request.getParameter("citycode");// 350200
		String countycode = request.getParameter("countycode");
		String address = request.getParameter("address");
		address = address.equalsIgnoreCase("") ? "厦门市港务大厦" : address;
		String searchname = request.getParameter("searchname");
		String categoryid = request.getParameter("categoryid");
		String categoryindex = "1";// 默认：1
		String order = request.getParameter("order");// 默认：distance
		order = order.equalsIgnoreCase("") ? "distance" : order;
		String paging = request.getParameter("paging");// 默认：1
		paging = paging.equalsIgnoreCase("") ? "1" : paging;

		// 请求报文
		ActivityAllListRequest searchRequest = new ActivityAllListRequest(
				"fmps", "fcps", "json", "27", UUIDGenerator.generate(),
				citycode, countycode, address, searchname, categoryid,
				categoryindex, order, paging);
		// 响应报文
		ActivityAllListResponse searchResultResponse = carHomeWsService
				.getSearchResult(searchRequest);

		String result = JsonUtil.toJSONString(searchResultResponse);

		return result;
	}

	/**
	 * (4s专区)进入4s专区主页
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(params = "method=toCarHome4sFactory")
	public ModelAndView toCarHome4sFactory(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		// 获取session的openid
		String openid = (String) request.getSession().getAttribute(
				Constants.SESSION_KEY_OPENID);
		String appid = this.getAppid(request);
		String domain = ResourceUtil.getDomain();
		// 条件
		String citycode = request.getParameter("citycode");
		String address = java.net.URLDecoder.decode(
				request.getParameter("address"), "UTF-8");
		String order = "distance"; // 默认：distance
		String paging = "1"; // 默认：1

		request.setAttribute("openid", openid);
		request.setAttribute("appid", appid);
		request.setAttribute("domain", domain);
		request.setAttribute("citycode", citycode);
		request.setAttribute("address", address);
		request.setAttribute("order", order);
		request.setAttribute("paging", paging);
		return new ModelAndView("/fo/repairplatform/carHome4s");
	}

	/**
	 * (4s专区)ajax加载：获取4S店厂商列表
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws throws Exception
	 */
	@RequestMapping(params = "method=get4sFactoryList")
	@ResponseBody
	public String get4sFactoryList(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		// 条件
		String citycode = request.getParameter("citycode");
		String countycode = request.getParameter("countycode");
		String address = request.getParameter("address");
		String categoryid = request.getParameter("categoryid");
		String order = request.getParameter("order");// 默认：distance
		order = order.equalsIgnoreCase("") ? "distance" : order;
		String paging = request.getParameter("paging");// 默认：1
		paging = paging.equalsIgnoreCase("") ? "1" : paging;

		// 请求报文
		ActivityAllListRequest searchRequest = new ActivityAllListRequest(
				"fmps", "fcps", "json", "30", UUIDGenerator.generate(),
				citycode, countycode, address, categoryid, order, paging);
		// 响应报文
		ActivityAllListResponse searchResultResponse = carHomeWsService
				.get4sFactoryResult(searchRequest);

		String result = JsonUtil.toJSONString(searchResultResponse);

		return result;
	}

	/**
	 * (维修保养专区)进入维修保养专区主页
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(params = "method=toCarHomeRepairFactory")
	public ModelAndView toCarHomeRepairFactory(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		// 获取session的openid
		String openid = (String) request.getSession().getAttribute(
				Constants.SESSION_KEY_OPENID);
		String appid = this.getAppid(request);
		String domain = ResourceUtil.getDomain();
		// 条件
		String citycode = request.getParameter("citycode");
		String address = java.net.URLDecoder.decode(
				request.getParameter("address"), "UTF-8");
		String order = "distance"; // 默认：distance
		String paging = "1"; // 默认：1

		request.setAttribute("openid", openid);
		request.setAttribute("appid", appid);
		request.setAttribute("domain", domain);
		request.setAttribute("citycode", citycode);
		request.setAttribute("address", address);
		request.setAttribute("order", order);
		request.setAttribute("paging", paging);
		return new ModelAndView("/fo/repairplatform/carHomeRepairFactory");
	}

	/**
	 * (维修保养专区)ajax加载：获取维修美容厂商列表
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws throws Exception
	 */
	@RequestMapping(params = "method=getRepairFactoryList")
	@ResponseBody
	public String getRepairFactoryList(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		// 条件
		String citycode = request.getParameter("citycode");
		String countycode = request.getParameter("countycode");
		String address = request.getParameter("address");
		String categoryid = request.getParameter("categoryid");
		String order = request.getParameter("order");// 默认：distance
		order = order.equalsIgnoreCase("") ? "distance" : order;
		String paging = request.getParameter("paging");// 默认：1
		paging = paging.equalsIgnoreCase("") ? "1" : paging;

		// 请求报文
		ActivityAllListRequest searchRequest = new ActivityAllListRequest(
				"fmps", "fcps", "json", "29", UUIDGenerator.generate(),
				citycode, countycode, address, categoryid, order, paging);
		// 响应报文
		ActivityAllListResponse searchResultResponse = carHomeWsService
				.getRepairFactoryResult(searchRequest);

		String result = JsonUtil.toJSONString(searchResultResponse);

		return result;
	}
	
	/**
	 * (其他服务专区)进入其他服务专区主页
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(params = "method=toCarHomeOtherServices")
	public ModelAndView toCarHomeOtherServices(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		// 获取session的openid
		String openid = (String) request.getSession().getAttribute(
				Constants.SESSION_KEY_OPENID);
		String appid = this.getAppid(request);
		String domain = ResourceUtil.getDomain();
		// 条件
		String citycode = request.getParameter("citycode");
		String address = java.net.URLDecoder.decode(
				request.getParameter("address"), "UTF-8");
		String order = "distance"; // 默认：distance
		String paging = "1"; // 默认：1

		request.setAttribute("openid", openid);
		request.setAttribute("appid", appid);
		request.setAttribute("domain", domain);
		request.setAttribute("citycode", citycode);
		request.setAttribute("address", address);
		request.setAttribute("order", order);
		request.setAttribute("paging", paging);
		return new ModelAndView("/fo/repairplatform/carHomeOtherServices");
	}

	/**
	 * (其他服务专区)ajax加载：获取其他服务商家列表
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws throws Exception
	 */
	@RequestMapping(params = "method=getOtherServicesList")
	@ResponseBody
	public String getOtherServicesList(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		// 条件
		String citycode = request.getParameter("citycode");
		String countycode = request.getParameter("countycode");
		String address = request.getParameter("address");
		String categoryid = request.getParameter("categoryid");
		String order = request.getParameter("order");// 默认：distance
		order = order.equalsIgnoreCase("") ? "distance" : order;
		String paging = request.getParameter("paging");// 默认：1
		paging = paging.equalsIgnoreCase("") ? "1" : paging;

		// 请求报文
		ActivityAllListRequest searchRequest = new ActivityAllListRequest(
				"fmps", "fcps", "json", "33", UUIDGenerator.generate(),
				citycode, countycode, address, categoryid, order, paging);
		// 响应报文
		ActivityAllListResponse searchResultResponse = carHomeWsService
				.getOtherServicesResult(searchRequest);

		String result = JsonUtil.toJSONString(searchResultResponse);

		return result;
	}

	/**
	 * 领用活动券接口
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "method=receiveGiftSet")
	@ResponseBody
	public AjaxJson receiveGiftSet(HttpServletRequest request) {
		AjaxJson json = new AjaxJson();
		HashMap<String, Object> couponmap = new HashMap<String, Object>();
		couponmap.put("amount", "0");
		String giftSetId = (String) request.getAttribute("giftSetId");
		if (StringUtil.isEmpty(giftSetId)) {
			giftSetId = request.getParameter("giftSetId");
		}
		String openid = (String) request.getAttribute("openid");
		if (StringUtil.isEmpty(openid)) {
			openid = request.getParameter("openid");
		}
		request.setAttribute("openid", openid);

		/**
		 * 点击“领取”，判断是否关注用户，关注用户才可以领取
		 */
		String activedProfile = request.getSession().getServletContext()
				.getInitParameter("spring.profiles.active");
		if (!WeixinUtil.isSubscribe(openid, activedProfile)) {
			BaseResult result = new BaseResult();
			result.setErrcode("0");
			result.setErrmsg("未关注富邦财险公众号，请先关注");
			json.setObj(result);
			return json;
		}

		// 活动id
		String huodongid = "" ;//request.getParameter("huodongid");

		// 领券时间
		JDateTime jnow = new JDateTime(new Date());
		String receivedate = jnow.toString("YYYY-MM-DD hh:mm:ss");

		// 请求报文
		ReceiveGiftSetRequest receiveGiftSetRequest = new ReceiveGiftSetRequest(
				"fmps", "fcps", "json", "23", UUIDGenerator.generate(),
				giftSetId, openid, huodongid, receivedate);
		// 响应报文
		ReceiveGiftSetResponse receiveGiftSetResponse = repairPlatformWsService
				.receiveGiftSetResponse(receiveGiftSetRequest);

		/**
		 
		 * errcode	errmsg
           00000	ok
           10011	券ID为空或格式问题
           10014	openid 为空
           10015	已领过此抵用券
           10016	领取失败,请重新领取
           10025	领券时间为空
           10026	领券时间无效
           10029	券库存不足
           10010    券库存数量不足
		 * 
		 * 
		 */
		BaseResult result = new BaseResult(); // 默认初始化(errcode : 10016, errmsg :
												// 领取失败，请在线联系客服或拨打4008-518-718)
		result.setErrcode(Constants.DOUBLE_11_ERRCODE_10016);
		result.setErrmsg(Constants.DOUBLE_11_ERRCODE_10016_MSG);

		if (receiveGiftSetResponse != null) {
			if (Constants.DOUBLE_11_ERRCODE_10010
					.equalsIgnoreCase(receiveGiftSetResponse.getErrcode())) { // 券库存数量不足
				result.setErrcode(Constants.DOUBLE_11_ERRCODE_10010);
				result.setErrmsg(Constants.DOUBLE_11_ERRCODE_10010_MSG);
			}

			if (Constants.DOUBLE_11_ERRCODE_10015
					.equalsIgnoreCase(receiveGiftSetResponse.getErrcode())) { // 已领过此抵用券
				result.setErrcode(Constants.DOUBLE_11_ERRCODE_10015);
				result.setErrmsg(Constants.DOUBLE_11_ERRCODE_10015_MSG);
			}
			if (Constants.CAR_HOME_ERRCODE_10025
					.equalsIgnoreCase(receiveGiftSetResponse.getErrcode())) { // 已领过此抵用券
				result.setErrcode(Constants.CAR_HOME_ERRCODE_10025);
				result.setErrmsg(Constants.CAR_HOME_ERRCODE_10025_MSG);
			}
			if (Constants.CAR_HOME_ERRCODE_10026
					.equalsIgnoreCase(receiveGiftSetResponse.getErrcode())) { // 已领过此抵用券
				result.setErrcode(Constants.CAR_HOME_ERRCODE_10026);
				result.setErrmsg(Constants.CAR_HOME_ERRCODE_10026_MSG);
			}
			if (Constants.CAR_HOME_ERRCODE_10029
					.equalsIgnoreCase(receiveGiftSetResponse.getErrcode())) { // 已领过此抵用券
				result.setErrcode(Constants.CAR_HOME_ERRCODE_10029);
				result.setErrmsg(Constants.CAR_HOME_ERRCODE_10029_MSG);
			}

			if (Constants.DOUBLE_11_ERRCODE_00000
					.equalsIgnoreCase(receiveGiftSetResponse.getErrcode())) { // 领取成功
				// 保存活动券信息到weixin_giftset_detail表
				boolean saveSuccess = repairPlatformGiftService
						.saveGiftSetIntoWeixinGiftsetDetail(
								receiveGiftSetResponse.getGiftsetDetail(),
								openid, huodongid);
				if (saveSuccess) {
					/**
					try {						
						HuodongEntity huodongEntity = cashCouponServiceImpl
								.getEntity(HuodongEntity.class, huodongid);
						if (cashCouponServiceImpl.isRangeOfDate(huodongEntity)) {
							String amount = cashCouponServiceImpl
									.getCashCouponAmount(openid, huodongid);
							if (StringUtil.isNotEmpty(amount)) {								
								couponmap.put("amount", amount);								
							}
						}						
					} catch (Exception e) {
						logger.error("领取红包发生异常", e);
					}
					**/
					result.setErrcode(Constants.DOUBLE_11_ERRCODE_00000);
					result.setErrmsg(Constants.DOUBLE_11_ERRCODE_00000_MSG);
				}
			}
		}
		json.setAttributes(couponmap);
		json.setObj(result);
		return json;
	}

	/**
	 * 获取appid
	 * 
	 * @param request
	 * @return
	 */
	public String getAppid(HttpServletRequest request) {
		List<WeixinAccountEntity> weixinAccountEntityList = weixinAccountService
				.findValidWeixinAccounts();
		WeixinAccountEntity weixinAccountEntity = weixinAccountEntityList
				.get(0);
		String appid = weixinAccountEntity.getAccountappid();

		return appid;
	}

}
