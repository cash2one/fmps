package cn.com.fubon.fo.repairplatform.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
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
import org.jeecgframework.web.system.service.SystemService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import weixin.guanjia.account.entity.WeixinAccountEntity;
import weixin.guanjia.account.service.WeixinAccountServiceI;
import weixin.guanjia.core.util.WeixinUtil;
import weixin.guanjia.message.service.ReceiveMessageServiceI;
import weixin.util.JsSdkUtil;
import cn.com.fubon.common.entity.RepairCase;
import cn.com.fubon.fo.customerbind.entity.WeiXinGzUserInfo;
import cn.com.fubon.fo.customerbind.service.CustomerBindService;
import cn.com.fubon.fo.customernewcarlicence.service.CustomerNewCarLicenceService;
import cn.com.fubon.fo.repairplatform.entity.BaseResult;
import cn.com.fubon.fo.repairplatform.entity.WeixinRepairEvaluation;
import cn.com.fubon.fo.repairplatform.entity.request.EvaluationSaveRequest;
import cn.com.fubon.fo.repairplatform.entity.request.GiftSetDetailRequest;
import cn.com.fubon.fo.repairplatform.entity.request.ReceiveGiftSetRequest;
import cn.com.fubon.fo.repairplatform.entity.request.RepairCaseListRequest;
import cn.com.fubon.fo.repairplatform.entity.request.RepairEntityRequest;
import cn.com.fubon.fo.repairplatform.entity.request.RepairListRequest;
import cn.com.fubon.fo.repairplatform.entity.response.GiftSetDetailResponse;
import cn.com.fubon.fo.repairplatform.entity.response.ReceiveGiftSetResponse;
import cn.com.fubon.fo.repairplatform.entity.response.RepairEntityResponse;
import cn.com.fubon.fo.repairplatform.service.RepairPlatformGiftService;
import cn.com.fubon.fo.repairplatform.service.RepairPlatformService;
import cn.com.fubon.fo.repairplatform.service.RepairPlatformWsService;
import cn.com.fubon.util.CachedUtils;
import cn.com.fubon.util.Constants;
import cn.com.fubon.webservice.server.WebServiceClientManagementService;
import cn.com.fubon.wechatClaims.entity.ReportInfo;
import cn.com.fubon.wechatClaims.service.ReportInfoService;

/**
 * 维修平台controller
 * 
 * @author qingqu.huang
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/fo/repairFactoryController")
public class RepairFactoryController {
	private static final Logger logger = Logger
			.getLogger(RepairFactoryController.class);
	@Resource
	private WeixinAccountServiceI weixinAccountService;
	@Resource
	private RepairPlatformService repairPlatformService;
	@Resource
	private ReceiveMessageServiceI receiveMessageService;
	@Resource
	private ReportInfoService reportInfoService;
	@Resource
	private RepairPlatformWsService repairPlatformWsService;

	@Resource
	private RepairPlatformGiftService repairPlatformGiftService;
	@Resource(name = "customerNewCarLicenceService")
	private CustomerNewCarLicenceService customerNewCarLicenceService;
	@Resource(name = "oracleCustomerNewCarLicenceService")
	private CustomerNewCarLicenceService oracleCustomerNewCarLicenceService;

	@Resource
	private SystemService systemService;
	@Resource
	private CustomerBindService customerBindService;
	@Resource
	private WebServiceClientManagementService webServiceClientManagementService;

	/**
	 * 进入厂商列表界面
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "method=repairList")
	public ModelAndView repairList(HttpServletRequest request) {
		String giftset_detail_id = request.getParameter("id");
		String cardtype = request.getParameter("cardtype");
		String citygift = request.getParameter("citygift");
		String Zcitygift = "";
		try {
			if (!StringUtil.isEmpty(citygift)) {
				Zcitygift = new String(citygift.getBytes("ISO-8859-1"), "UTF-8");
			}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.info("初始化的cardtype=>" + cardtype + 
				"\r\n初始化的citygift=>" + citygift + 
				"\r\n初始化的Zcitygift=>" + Zcitygift);
		String accessToken = weixinAccountService
				.getAccessTokenFromAccountEntity();
		List<WeixinAccountEntity> weixinAccountEntityList = weixinAccountService
				.findValidWeixinAccounts();
		WeixinAccountEntity weixinAccountEntity = weixinAccountEntityList
				.get(0);
		String appid = weixinAccountEntity.getAccountappid();
		String URL = ResourceUtil.getDomain() + request.getServletPath() + "?"
				+ request.getQueryString();
		// String URL = request.getRequestURL() + "?" +
		// request.getQueryString();
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
		String hasLbs="YES";		
		String latitude = (String) CachedUtils.get(Constants.MEMKEY_WEIXIN_latitude+openid);
		String longitude = (String) CachedUtils.get(Constants.MEMKEY_WEIXIN_longitude+openid);		
		if (StringUtil.isEmpty(latitude)&&StringUtil.isEmpty(longitude)) {
			hasLbs="NO";
			latitude="0";
			longitude="0";		
		}
		logger.info("缓存的地理位置为===>"+latitude+":"+longitude);
		request.setAttribute("hasLbs", hasLbs);
		request.setAttribute("latitude", latitude);
		request.setAttribute("longitude", longitude);		
		request.setAttribute("openid", openid);
		List<TSType> cityList = repairPlatformService
				.getCityFromTSType("citylist");
		request.setAttribute("cityList", cityList);		
		request.setAttribute("JSONString", JSONString);
		request.setAttribute("giftset_detail_id", giftset_detail_id);
		request.setAttribute("cardtype", cardtype);
		request.setAttribute("citygift", citygift);
		if (!StringUtil.isEmpty(giftset_detail_id)) {
			request.setAttribute("flag", "2");
		}
		return new ModelAndView("/fo/repairplatform/repairList");
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
		logger.info("已经进入方法========>");
		String giftset_detail_id = request.getParameter("id");
		AjaxJson jsonString = new AjaxJson();
		String order = request.getParameter("order");
		String city = java.net.URLDecoder.decode(request.getParameter("city"),
				"UTF-8");
		String address = java.net.URLDecoder.decode(
				request.getParameter("address"), "UTF-8");
		String paging = request.getParameter("pageNo");
		String openid = request.getParameter("openid");
		String citygift = request.getParameter("citygift");
		String citygiftDecode = "";
		String cardtype = request.getParameter("cardtype");
		if (!StringUtil.isEmpty(citygift)) {
			citygiftDecode = java.net.URLDecoder.decode(citygift, "UTF-8");
		}
		String latitude = request.getParameter("latitude");
		String longitude = request.getParameter("longitude");
		String seqId = request.getParameter("seqId");		
		if (!StringUtil.isEmpty(latitude)&&!StringUtil.isEmpty(longitude)) {
			CachedUtils.set(Constants.MEMKEY_WEIXIN_latitude+openid,  latitude);
			CachedUtils.set(Constants.MEMKEY_WEIXIN_longitude+openid,  longitude);
		logger.info("上传的地理位置为===>"+latitude+":"+longitude);
		}
		logger.info("上传的 ===城市为========>" + city + 
				"\r\n上传的  ===地址为========>" + address + 
				"\r\n上传的 ===排序为==-=====> " + order + 
				"\r\n上传的 ===分页为==-=====> " + paging + 
				"\r\n上传的 ===openid为==-=====> " + openid + 
				"\r\n上传的 ===giftset_detail_id为==-=====> " + giftset_detail_id + 
				"\r\n上传的 ===cardtype为==-=====> " + cardtype + 
				"\r\n上传的 ===citygift为==-=====> " + citygiftDecode);
		Map<String, Object> AttributesMap = new HashMap<String, Object>();
		// URLEncoder.encode(city, "UTF-8");
		if ("1".equals(cardtype)) {
			// 现金券
			city = citygiftDecode;
		} else if ("2".equals(cardtype)) {
			// 非现金券
			city = "";
		}
		RepairListRequest repair = new RepairListRequest("fmps", "fcps",
				"json", "11", UUIDGenerator.generate(), city, order, address,
				paging, openid, giftset_detail_id);

		String repairListResponse = repairPlatformWsService
				.getRepairListResponse(repair,seqId);
		// 厂商列表
		//List<WeixinRepair> weixinRepairPlatformList = repairListResponse
		//		.getRepairList();
		 
		AttributesMap.put("weixinRepairPlatformList", repairListResponse);
		jsonString.setAttributes(AttributesMap);
		logger.info("返回的数据为 " + jsonString.toString());
		return jsonString;
	}

	/**
	 * 进入厂商主页面
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "method=repairMain")
	public ModelAndView repairMain(HttpServletRequest request) {
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
			request.setAttribute("evaluationList",
					repairEntityResponse.getEvaluationList());
			request.setAttribute("WeixinRepair",
					repairEntityResponse.getRepair());
			request.setAttribute("repairId", repairId);
			request.setAttribute("openid", openid);
			request.setAttribute("giftSetList", repairEntityResponse.getGiftSetList());
			return new ModelAndView("/fo/repairplatform/repairMain");
		} else {
			request.setAttribute("message", "系统通讯异常，请稍候再试...");
			return new ModelAndView("/fo/common/message");
		}

	}

	/**
	 * 进入厂商评价页面
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "method=evaluation")
	public ModelAndView evaluation(HttpServletRequest request) {
		String repairId = (String) request.getAttribute("repairId");
		if (StringUtil.isEmpty(repairId)) {
			repairId = request.getParameter("repairId");
		}
		String openid = request.getParameter("openid");
		logger.info("进入厂商评价页面的openid是========>" + openid + 
				"\r\n进入厂商评价页面的repairId是========>" + repairId);
		String repairname = request.getParameter("repairname");
		String repairnameZ = "";
		try {
			repairnameZ = java.net.URLDecoder.decode(repairname, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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

		if (weixinRepairEvaluationList.size() > 0) {
			request.setAttribute("evaluationflag", "1");
		}
		request.setAttribute("repairId", repairId);
		request.setAttribute("openid", openid);
		request.setAttribute("repairname", repairnameZ);
		return new ModelAndView("/fo/repairplatform/repairEvaluation");
	}

	/**
	 * 提交点评
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "eval", method = RequestMethod.POST)
	public ModelAndView eval(HttpServletRequest request) {
		// 获取点评参数，提交到企业号
		String score = request.getParameter("score");
		String openid = (String) request.getAttribute("openid");
		if (StringUtil.isEmpty(openid)) {
			openid = request.getParameter("openid");
		}
		request.setAttribute("openid", openid);
		String comment = request.getParameter("idea");
		String repaireid = request.getParameter("repairId");
		logger.info("openid是 " + openid);
		WeixinRepairEvaluation weixinRepairEvaluation = new WeixinRepairEvaluation();
		weixinRepairEvaluation.setOpenid(openid);
		weixinRepairEvaluation.setRepairid(repaireid);
		logger.info("评论的openid=== " + openid + 
				"\r\n评论的repaireid=== " + repaireid);
		CriteriaQuery cq = new CriteriaQuery(WeixinRepairEvaluation.class);
		cq.isNull("evaluation");
		cq.isNull("comment");
		// 查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq,
				weixinRepairEvaluation);
		cq.add();
		List<WeixinRepairEvaluation> weixinRepairEvaluationList = repairPlatformService
				.getListByCriteriaQuery(cq, true);

		if (weixinRepairEvaluationList.size() > 0) {
			logger.info("有可以评论的数据 ");
			WeixinRepairEvaluation weixinRepairEvaluationn = weixinRepairEvaluationList
					.get(0);
			EvaluationSaveRequest repair = new EvaluationSaveRequest("fmps",
					"fcps", "json", "14", UUIDGenerator.generate(), repaireid,
					openid, weixinRepairEvaluationn.getNickname(),
					weixinRepairEvaluationn.getHeadimgurl(), score, comment);
			logger.info("开始发送请求 ");
			BaseResult repairCaseResponse = repairPlatformWsService
					.getEvaluationSave(repair);
			if (repairCaseResponse.getErrmsg().equals("ok")) {
				logger.info("评论记录的id=== " + weixinRepairEvaluationn.getId() + 
						"\r\n评论的内容=== " + comment + 
						"\r\n评论的星级=== " + score);
				weixinRepairEvaluationn.setComment(comment);
				weixinRepairEvaluationn.setEvaluation(Integer.parseInt(score));
				repairPlatformService.updateEntitie(weixinRepairEvaluationn);
				request.setAttribute("message", "点评成功,感谢您的点评!");
			} else {
				request.setAttribute("message", "点评失败,请重新点评!");
			}

		}
		return new ModelAndView("/fo/repairplatform/message");
	}

	/**
	 * 进入评价历史界面
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "method=historicalEvaluation")
	public ModelAndView historicalEvaluation(HttpServletRequest request) {
		String repairId = (String) request.getAttribute("repairId");
		if (StringUtil.isEmpty(repairId)) {
			repairId = request.getParameter("repairId");
		}
		// String openid = request.getParameter("openid");
		String repairname = request.getParameter("repairname");
		String repairnameZ = "";
		try {
			repairnameZ = java.net.URLDecoder.decode(repairname, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*
		 * RepairEntityRequest repairEntityRequest = new RepairEntityRequest(
		 * "fmps", "fcps", "json", "15", UUIDGenerator.generate(), repairId,
		 * openid);
		 * 
		 * RepairEntityResponse repairEntityResponse = repairPlatformWsService
		 * .getRepairEntityResponse(repairEntityRequest);
		 * request.setAttribute("evaluationList",
		 * repairEntityResponse.getEvaluationList());
		 */
		request.setAttribute("weixinRepairName", repairnameZ);
		request.setAttribute("repairId", repairId);
		return new ModelAndView("/fo/repairplatform/historicalEvaluation");
	}

	/**
	 * 进入评价历史界面(ajax分页)
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "method=historicalEvaluationajax")
	@ResponseBody
	public List<Map<String, Object>> historicalEvaluationajax(
			HttpServletRequest request) throws Exception {
		String startget = request.getParameter("start");
		String repairId = request.getParameter("repairId");
		String evaluationstate = request.getParameter("evaluationstate");
		int start = Integer.parseInt(startget);
		int count = 10;
		List<Map<String, Object>> weixinRepairEvaluation = repairPlatformService
				.findEvaluationListt(start, count, evaluationstate, repairId);
		// List<WeixinRepairEvaluation> weixinRepairEvaluation =
		// repairPlatformService
		// .findEvaluationList(start, count, evaluationstate, repairId);
		logger.info("返回的数据为 " + weixinRepairEvaluation);
		return weixinRepairEvaluation;

	}

	/**
	 * 进入二维码页面
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "method=QRcodePage")
	public ModelAndView QRcodePage(HttpServletRequest request) {
		String openid = (String) request.getAttribute("openid");
		if (StringUtil.isEmpty(openid)) {
			openid = request.getParameter("openid");
		}
		// 生产uuid
		String uuid = UUIDGenerator.generate();
		logger.info("二维码的uuid是========>" + uuid);
		request.setAttribute("openid", openid);
		request.setAttribute("uuid", uuid);
		return new ModelAndView("/fo/repairplatform/QRcode");
	}

	/**
	 * 进入手机获得二维码页面
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "method=QRcodePagePhone")
	public ModelAndView QRcodePagePhone(HttpServletRequest request) {
		String openid = (String) request.getAttribute("openid");
		if (StringUtil.isEmpty(openid)) {
			openid = request.getParameter("openid");
		}
		// 生产uuid
		String uuid = UUIDGenerator.generate();
		request.setAttribute("openid", openid);
		request.setAttribute("uuid", uuid);
		return new ModelAndView("/fo/repairplatform/QRcodePhone");
	}

	/**
	 * 检查memcache二维码信息
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "method=qRcodeajax")
	@ResponseBody
	public String qRcodeajax(HttpServletRequest request) throws Exception {
		String uuid = request.getParameter("uuid");
		logger.info("获得uuid是 " + uuid);
		String reString = "";
		String numb = (String) CachedUtils.get(uuid);
		logger.info("CachedUtils取出来的value值是 " + numb);
		if (!Constants.QRCODEAJAX_0.equals(numb) && null != numb) {
			logger.info("返回之后要刷新 ");
			reString = Constants.QRCODEAJAX_1;
		} else {
			logger.info("返回之后不要刷新 ");
			reString = Constants.QRCODEAJAX_0;
		}
		// logger.info("返回的数据为 " + jsonString.toString());
		return reString;

	}

	/**
	 * 检查手机号码是否有二维码
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "qPhoneRcodeajax")
	@ResponseBody
	public AjaxJson qPhoneRcodeajax(HttpServletRequest request)
			throws Exception {
		String openid = request.getParameter("openid");
		String uuid = request.getParameter("uuid");
		String QRphone = request.getParameter("QRphone");
		logger.info("获得uuid是 " + uuid);
		AjaxJson jsonString = new AjaxJson();
		List<ReportInfo> reportInfoList = new ArrayList<ReportInfo>();
		if (!StringUtil.isEmpty(openid)) {
			ReportInfo reportInfoo = reportInfoService
					.getReportInfoByOpenid(openid);
			if (reportInfoo != null) {
				reportInfoList = reportInfoService.getReportInfoList(
						reportInfoo, "2");
				if (reportInfoList.size() > 0) {
					jsonString.setSuccess(true);
				} else {
					jsonString.setSuccess(false);
				}
				// reportInfoList = this.getReportInfoList(reportInfoo);
			} else {
				jsonString.setSuccess(false);
			}

		}

		if (!StringUtil.isEmpty(QRphone)) {
			ReportInfo reportInfoo = reportInfoService
					.getReportInfoByPhone(QRphone);
			if (reportInfoo != null) {
				reportInfoList = reportInfoService.getReportInfoList(
						reportInfoo, "1");
				if (reportInfoList.size() > 0) {
					jsonString.setSuccess(true);
				} else {
					jsonString.setSuccess(false);
				}
				// reportInfoList = this.getReportInfoList(reportInfoo);
			} else {
				jsonString.setSuccess(false);
			}
		}

		return jsonString;

	}

	/**
	 * 跳转到案件列表页面
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "method=toCaseList")
	public ModelAndView toCaseList(HttpServletRequest request) {
		String openid = request.getParameter("openid");
		String uuid = request.getParameter("uuid");
		String QRphone = request.getParameter("QRphone");

		String phone = "";
		String repairname = "";
		if (!StringUtil.isEmpty(uuid)) {
			String repairStr = (String) CachedUtils.get(uuid);
			if (!StringUtil.isEmpty(repairStr)) {
				String repairStrArr[] = repairStr.split(",");
				if (repairStrArr.length == 4) {
					repairname = repairStrArr[3];
				}
			}
		}

		List<ReportInfo> reportInfoList = new ArrayList<ReportInfo>();
		if (!StringUtil.isEmpty(openid)) {
			ReportInfo reportInfoo = reportInfoService
					.getReportInfoByOpenid(openid);
			if (reportInfoo != null) {
				reportInfoList = reportInfoService.getReportInfoList(
						reportInfoo, "2");
				if (reportInfoList.size() > 0) {
					request.setAttribute("countsize", reportInfoList.size());
				}

			}
		}

		if (!StringUtil.isEmpty(QRphone)) {

			ReportInfo reportInfooo = reportInfoService
					.getReportInfoByPhone(QRphone);
			if (reportInfooo != null) {
				reportInfoList = reportInfoService.getReportInfoList(
						reportInfooo, "1");
				if (reportInfoList.size() > 0) {
					request.setAttribute("countsize", reportInfoList.size());
				}

			}

		}
		request.setAttribute("openid", openid);
		request.setAttribute("uuid", uuid);
		request.setAttribute("phone", phone);
		request.setAttribute("repairname", repairname);
		request.setAttribute("reportInfoList", reportInfoList);
		return new ModelAndView("/fo/repairplatform/caseList");
	}

	/**
	 * 根据 openid 电话号码获取二维码
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(params = "getQRcode")
	public void getQRcode(HttpServletRequest request,
			HttpServletResponse response) {
		// 设置页面不缓存
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);

		String flag = request.getParameter("flag");
		String QRphone = (String) request.getAttribute("QRphone");
		if (StringUtil.isEmpty(QRphone)) {
			QRphone = request.getParameter("QRphone");
			if (!StringUtil.isEmpty(QRphone)) {
				QRphone = QRphone.trim();
			}
		}
		String openid = (String) request.getAttribute("openid");
		if (StringUtil.isEmpty(openid)) {
			openid = request.getParameter("openid");
			if (!StringUtil.isEmpty(openid)) {
				openid = openid.trim();
			}
		}
		String uuid = request.getParameter("uuid");
		logger.info("uuid是========>" + uuid);
		// changed by qingqu.huang @date 20150701
		String weixinjpg = "/plug-in/repair/erweima_3.jpg";
		String phonejpg = "/plug-in/repair/erweima_2.jpg";
		String initjpg = "/plug-in/repair/erweima_4.jpg";
		String logoPath = "/plug-in/repair/futai_index_pro.jpg";
		String path = this.getClass().getClassLoader().getResource("")
				.getPath();
		File file = new File(path); // 默认图片，二维码无法生成时显示
		File parentfile = new File(file.getParent());
		File png = null;

		List<ReportInfo> reportInfoList = new ArrayList<ReportInfo>();
		// ReportInfo reportInfo = new ReportInfo();
		// 二维码信息
		String QRmessage = "";
		if (!"1".equals(flag)) {
			if (!StringUtil.isEmpty(openid)) {
				ReportInfo reportInfoo = reportInfoService
						.getReportInfoByOpenid(openid);
				if (reportInfoo != null) {
					reportInfoList = reportInfoService.getReportInfoList(
							reportInfoo, "2");
					if (reportInfoList.size() > 0) {
						QRmessage = reportInfoo.getPhoneNumber();
						// reportInfoList = this.getReportInfoList(reportInfoo);
					} else {
						png = new File(parentfile.getParent() + weixinjpg);
					}
					// reportInfoList = this.getReportInfoList(reportInfoo);
				} else {
					png = new File(parentfile.getParent() + weixinjpg);
				}

			} else if (!StringUtil.isEmpty(QRphone)) {
				ReportInfo reportInfoo = reportInfoService
						.getReportInfoByPhone(QRphone);
				if (reportInfoo != null) {
					reportInfoList = reportInfoService.getReportInfoList(
							reportInfoo, "1");
					if (reportInfoList.size() > 0) {
						QRmessage = reportInfoo.getPhoneNumber();
						// reportInfoList = this.getReportInfoList(reportInfoo);
					} else {
						png = new File(parentfile.getParent() + phonejpg);
					}

				} else {
					png = new File(parentfile.getParent() + phonejpg);
				}
			}
		} else {
			png = new File(parentfile.getParent() + initjpg);//
		}
		if (reportInfoList.size() > 0) {
			if (!StringUtil.isEmpty(QRmessage)) {
				png = webServiceClientManagementService.getQRPng(openid, uuid,
						logoPath, parentfile, QRmessage, "0");
			}

		}
		if (!StringUtil.isEmpty(uuid)) {
			// 未扫码（初始化为0）
			CachedUtils.set(uuid, "0");
		}

		InputStream in = null;
		try {
			// 一次读一个字节
			in = new FileInputStream(png);
			int tempbyte;
			while ((tempbyte = in.read()) != -1) {
				response.getOutputStream().write(tempbyte);
			}
			response.getOutputStream().flush();// 必须清除流，否则图片不能正常显示
			in.close();
		} catch (IOException e) {
			e.printStackTrace();

		}
	}

	/**
	 * 进入地图页面
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "method=goToMapPage")
	public ModelAndView goToMapPage(HttpServletRequest request) {
		String latitude = request.getParameter("latitude");
		String longitude = request.getParameter("longitude");
		String repairname = "";
		try {
			repairname = java.net.URLDecoder.decode(
					request.getParameter("repairname"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		request.setAttribute("latitude", latitude);
		request.setAttribute("longitude", longitude);
		request.setAttribute("repairname", repairname);
		return new ModelAndView("/fo/repairplatform/mapPage");
	}

	/**
	 * 提交选择的案件
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "checkcase", method = RequestMethod.POST)
	public ModelAndView checkcase(HttpServletRequest request) {
		// 获取点评参数，提交到企业号

		String countsize = request.getParameter("countsize");
		String uuid = request.getParameter("uuid");
		String openid = request.getParameter("openid");
		String deleteId = request.getParameter("deleteId");
		String repairname = request.getParameter("repairname");

		String[] deleteIdarr;
		// 处理删除的案件
		if (!StringUtil.isEmpty(deleteId)) {
			deleteIdarr = deleteId.split(",");
			logger.info("开始处理删除的案件");
			for (int k = 1; k < deleteIdarr.length; k++) {
				logger.info("删除的维修厂id------>" + deleteIdarr[k]);
				ReportInfo reportInfoll = reportInfoService
						.findUniqueByProperty(ReportInfo.class, "id",
								deleteIdarr[k]);
				reportInfoll.setRepairState(2);
				reportInfoService.updateEntitie(reportInfoll);
			}
		}

		String str = "";
		String strall = "";
		for (int i = 0; i < Integer.parseInt(countsize); i++) {
			str = str + "," + i;
			String ra = request.getParameter("ra" + String.valueOf(i));
			if (ra != null) {
				strall = strall + ";" + ra;
			}
		}

		String[] stra;
		stra = strall.split(";");

		List<ReportInfo> reportInfoList = new ArrayList<ReportInfo>();
		for (int i = 1; i < stra.length; i++) {
			ReportInfo reportInfol = reportInfoService.findUniqueByProperty(
					ReportInfo.class, "id", stra[i]);
			reportInfoList.add(reportInfol);

		}
		List<RepairCase> repairCaseList = new ArrayList<RepairCase>();
		for (int j = 0; j < reportInfoList.size(); j++) {
			ReportInfo reportInfo = reportInfoList.get(j);
			RepairCase repairCase = new RepairCase();
			if (reportInfo != null) {
				repairCase.setCaseID(reportInfo.getRegistNo());
				repairCase.setLicenseNo(reportInfo.getLicenseNo());
				if (reportInfo.getClaimCaseFee() != null) {
					repairCase.setCash(reportInfo.getClaimCaseFee().toString());
				}
				repairCase.setPhoneNumber(reportInfo.getPhoneNumber());
				repairCase.setRemark(reportInfo.getRemark());
			}

			repairCaseList.add(repairCase);
		}
		String repairId = "";
		BaseResult repairCaseResponse = new BaseResult();
		if (!StringUtil.isEmpty(uuid)) {
			String repairStr = (String) CachedUtils.get(uuid);
			String repairStrArr[] = repairStr.split(",");
			repairId = repairStrArr[0];
			String agentId = repairStrArr[1];
			String userId = repairStrArr[2];
			String qrType = repairStrArr[4];
			logger.info("uuid是========>" + UUIDGenerator.generate() + 
					"\r\nrepairId是========>" + repairId + 
					"\r\nopenid是========>" + openid + 
					"\r\nuserId是========>" + userId + 
					"\r\nagentId是========>" + agentId + 
					"\r\nrepairCaseList是========>" + repairCaseList);

			RepairCaseListRequest repairCaseListRequest = new RepairCaseListRequest(
					"fmps", "fcps", "json", "16", UUIDGenerator.generate(),
					repairId, openid, userId, agentId, qrType, repairCaseList);
			repairCaseResponse = repairPlatformWsService
					.getRepairCaseListResponse(repairCaseListRequest);
		}

		if (repairCaseResponse.getErrmsg().equals("ok")) {
			logger.info("数据更新到本地数据库");
			for (int i = 1; i < stra.length; i++) {
				ReportInfo reportInfol = reportInfoService
						.findUniqueByProperty(ReportInfo.class, "id", stra[i]);
				reportInfol.setRepairState(1);
				reportInfoService.updateEntitie(reportInfol);
			}

			// 取得用户的昵称和头像
			List<WeiXinGzUserInfo> weiXinGzUserInfos = customerBindService
					.findByProperty(WeiXinGzUserInfo.class, "openid", openid);
			WeiXinGzUserInfo weiXinGzUserInfo = new WeiXinGzUserInfo();
			if (weiXinGzUserInfos.size() > 0) {
				weiXinGzUserInfo = weiXinGzUserInfos.get(0);
			}

			// 返回成功，添加一条评价记录
			for (int i = 1; i < stra.length; i++) {
				WeixinRepairEvaluation weixinRepairEvaluation = new WeixinRepairEvaluation();
				weixinRepairEvaluation.setRepairid(repairId);
				weixinRepairEvaluation.setOpenid(openid);
				weixinRepairEvaluation.setRepairname(repairname);

				ReportInfo reportInfol = reportInfoService
						.findUniqueByProperty(ReportInfo.class, "id", stra[i]);
				weixinRepairEvaluation.setReportInfo(reportInfol);

				if (weiXinGzUserInfos.size() > 0) {
					weixinRepairEvaluation.setNickname(weiXinGzUserInfo
							.getNickname());
					weixinRepairEvaluation.setHeadimgurl(weiXinGzUserInfo
							.getHeadimgurl());
				}
				weixinRepairEvaluation.setqRcodeUUID(uuid);
				weixinRepairEvaluation.setScanQrCodeTime(new Date());
				repairPlatformWsService.saveOrUpdate(weixinRepairEvaluation);
			}
			request.setAttribute("message", "案件处理成功");
		} else {
			logger.info("错误码是===" + repairCaseResponse.getErrcode());
			request.setAttribute("message", "案件处理失败");
		}

		return new ModelAndView("/fo/repairplatform/message");
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
			DataSourceContextHolder.setDataSourceType(DataSourceType.dataSource_jeecg);
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
			giftSetId = state;   //从双11页面带过来的 券ID
		}		
		logger.info("method=goToGiftSetDetail==giftSetId==>"+giftSetId+",openid:"+openid+",state:"+state); 
		//请求报文
		GiftSetDetailRequest giftSetDetailRequest = new GiftSetDetailRequest(
				"fmps", "fcps", "json", "22", UUIDGenerator.generate(), openid, giftSetId);
		//响应报文
		GiftSetDetailResponse giftSetDetailResponse = repairPlatformWsService
				.getGiftSetDetailResponse(giftSetDetailRequest);
		
		if (giftSetDetailResponse != null) {
			request.setAttribute("giftSet", giftSetDetailResponse.getGiftSet());
			request.setAttribute("merchant", giftSetDetailResponse.getMerchant());
			request.setAttribute("status",this.getStatus(openid, giftSetId, giftSetDetailResponse.getGiftSet().getRemainQuantity()));
			
			//获取jssdk配置
			String jsonString = this.getJsonStr(request);
			request.setAttribute("jsonString",jsonString);
			
			return new ModelAndView("/fo/repairplatform/giftSetDetail");
		} else {
			request.setAttribute("message", "系统通讯异常，请稍候再试...");
			return new ModelAndView("/fo/common/message");
		}
	}
	
	/**
	 * 领用活动券接口
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "method=receiveGiftSet")
	@ResponseBody
	public BaseResult receiveGiftSet(HttpServletRequest request) {
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
		if(!WeixinUtil.isSubscribe(openid, activedProfile)){
			BaseResult result = new BaseResult();
			result.setErrcode("0");
			result.setErrmsg("未关注富邦财险公众号，请先关注");
			
			return result;
		}
		
		//活动id
		String huodongid = request.getParameter("huodongid");
		
		//领券时间
		JDateTime jnow = new JDateTime(new Date());
		String receivedate = jnow.toString("YYYY-MM-DD hh:mm:ss");
		
		//请求报文
		ReceiveGiftSetRequest receiveGiftSetRequest = new ReceiveGiftSetRequest(
				"fmps", "fcps", "json", "23", UUIDGenerator.generate(), giftSetId, openid, huodongid, receivedate);
		//响应报文
		ReceiveGiftSetResponse receiveGiftSetResponse = repairPlatformWsService
				.receiveGiftSetResponse(receiveGiftSetRequest);
		
		/**
			errcode ：00000   errmsg: 领取成功
			errcode ：10011   errmsg: 券ID为空或格式问题
			errcode ：10014   errmsg: openid 为空
			errcode ：10010   errmsg: 券库存数量不足
			errcode ：10015   errmsg: 已领过此抵用券
			errcode ：10016   errmsg: 领取失败，请在线联系客服或拨打4008-518-718
		 */
		BaseResult result = new BaseResult(); //默认初始化(errcode : 10016, errmsg : 领取失败，请在线联系客服或拨打4008-518-718)
		result.setErrcode(Constants.DOUBLE_11_ERRCODE_10016);
		result.setErrmsg(Constants.DOUBLE_11_ERRCODE_10016_MSG);
		
		if (receiveGiftSetResponse != null) {
			if(Constants.DOUBLE_11_ERRCODE_10010.equalsIgnoreCase(receiveGiftSetResponse.getErrcode())){ //券库存数量不足
				result.setErrcode(Constants.DOUBLE_11_ERRCODE_10010);
				result.setErrmsg(Constants.DOUBLE_11_ERRCODE_10010_MSG);
			}
			
			if(Constants.DOUBLE_11_ERRCODE_10015.equalsIgnoreCase(receiveGiftSetResponse.getErrcode())){ //已领过此抵用券
				result.setErrcode(Constants.DOUBLE_11_ERRCODE_10015);
				result.setErrmsg(Constants.DOUBLE_11_ERRCODE_10015_MSG);
			}
			
			if(Constants.DOUBLE_11_ERRCODE_00000.equalsIgnoreCase(receiveGiftSetResponse.getErrcode())){ //领取成功
				// 保存活动券信息到weixin_giftset_detail表
				boolean saveSuccess = repairPlatformGiftService.saveGiftSetIntoWeixinGiftsetDetail(receiveGiftSetResponse.getGiftsetDetail(), openid, huodongid);
				if (saveSuccess) {
					result.setErrcode(Constants.DOUBLE_11_ERRCODE_00000);
					result.setErrmsg(Constants.DOUBLE_11_ERRCODE_00000_MSG);
				}
			}
		}
		
		return result;
	}
	
	public String getStatus(String openid, String giftSetId, String remainQuantity){
		//status:0 领取、status:1已领取、status:2 已抢光、status:3 您已经领满5张券
		//1.判断库存量
		if (Integer.parseInt(remainQuantity) <= 0)
			return "2";
		
		//2.判断是否已领取该张券
		if (repairPlatformGiftService.isReceivedThisGiftSet(openid, giftSetId))
			return "1";
		
		//3.判断每人本年度是否领取200张券
		if (repairPlatformGiftService.isReceivedLimitedQuantityGiftSet(openid))
			return "3";
		
		return "0";
	}
	
	/**
	 * 获取微信初始化数据
	 * 
	 * @param request
	 * @return
	 */
	public String getJsonStr(HttpServletRequest request) {
		String accessToken = weixinAccountService.getAccessTokenFromAccountEntity();
		List<WeixinAccountEntity> weixinAccountEntityList = weixinAccountService.findValidWeixinAccounts();
		WeixinAccountEntity weixinAccountEntity = weixinAccountEntityList.get(0);
		String appid = weixinAccountEntity.getAccountappid();
		String URL = ResourceUtil.getDomain() + request.getServletPath() + "?" + request.getQueryString();
		logger.info("jssdkPage url ===>" + URL);
		JsSdkUtil JsSdkUtil = new JsSdkUtil(URL, appid, accessToken);
		String jsonString = JsSdkUtil.getWxConfigJSONString();
		logger.info("jssdkConfig ===>" + jsonString);
		return jsonString;
	}
}
