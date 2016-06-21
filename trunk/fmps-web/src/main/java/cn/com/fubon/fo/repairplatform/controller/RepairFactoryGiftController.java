package cn.com.fubon.fo.repairplatform.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import jodd.util.StringUtil;
import org.apache.log4j.Logger;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.util.ResourceUtil;
import org.jeecgframework.core.util.UUIDGenerator;
import org.jeecgframework.web.system.service.SystemService;
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
import cn.com.fubon.fo.customerbind.entity.WeiXinGzUserInfo;
import cn.com.fubon.fo.customerbind.service.CustomerBindService;
import cn.com.fubon.fo.customernewcarlicence.service.CustomerNewCarLicenceService;
import cn.com.fubon.fo.repairplatform.entity.WeixinGiftsetDetail;
import cn.com.fubon.fo.repairplatform.entity.WeixinRepairEvaluation;
import cn.com.fubon.fo.repairplatform.entity.request.AreaGiftSetRequest;
import cn.com.fubon.fo.repairplatform.entity.request.GiftSetInstructionsRequest;
import cn.com.fubon.fo.repairplatform.entity.response.AreaGiftSetResponse;
import cn.com.fubon.fo.repairplatform.entity.response.GiftSetInstructionsResponse;
import cn.com.fubon.fo.repairplatform.service.RepairPlatformGiftService;
import cn.com.fubon.fo.repairplatform.service.RepairPlatformGiftWsService;
import cn.com.fubon.fo.repairplatform.service.RepairPlatformService;
import cn.com.fubon.fo.repairplatform.service.RepairPlatformWsService;
import cn.com.fubon.util.CachedUtils;
import cn.com.fubon.util.Constants;
import cn.com.fubon.webservice.server.WebServiceClientManagementService;
import cn.com.fubon.wechatClaims.service.ReportInfoService;

/**
 * 维修平台礼包controller
 * 
 * @author guojunjie
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/fo/binded/repairFactoryGiftController")
public class RepairFactoryGiftController {
	private static final Logger logger = Logger
			.getLogger(RepairFactoryGiftController.class);
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
	private RepairPlatformGiftWsService repairPlatformGiftWsService;

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
	 * 礼包列表页面
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "method=giftList")
	public ModelAndView giftList(HttpServletRequest request) {
		String openid = (String) request.getAttribute("openid");
		if (StringUtil.isEmpty(openid)) {
			openid = request.getParameter("openid");
		}		
		String identifynumber = "";
		String customercname = "";
		identifynumber = (String) CachedUtils.get(openid
				+ Constants.MEMKEY_IDENTIFYNUMBER);
		customercname = (String) CachedUtils.get(openid
				+ Constants.MEMKEY_CUSTOMERCNAME);
		String activedProfile = request.getSession()
				.getServletContext()
				.getInitParameter("spring.profiles.active");
		logger.info("进入礼包列表页面=======openid====>"+openid);
		if(WeixinUtil.isSubscribe(openid, activedProfile)){	//增加用户是否关注判断，避免空指针	
		if (StringUtil.isEmpty(identifynumber)||StringUtil.isEmpty(customercname)) {
			WeiXinGzUserInfo weiXinGzUserInfo = repairPlatformGiftService
					.findUniqueByProperty(WeiXinGzUserInfo.class, "openid", openid);
			identifynumber = weiXinGzUserInfo.getIdentifynumber();
			customercname = weiXinGzUserInfo.getCustomercname();
		  }
		}		
		List<WeixinGiftsetDetail> weixinGiftsetDetailList = repairPlatformGiftService
				.getWeixinGiftsetDetailList(identifynumber, customercname,openid);
		String statusflag = "1";
		if (weixinGiftsetDetailList.size() > 0) {
			request.setAttribute("weixinGiftsetDetailList",
					weixinGiftsetDetailList);
		} else {
			// request.setAttribute("message", "当前暂无礼包");
			return new ModelAndView("/fo/repairplatform/giftanonymous");
			// return new ModelAndView("/fo/common/message");
		}

		request.setAttribute("openid", openid);
		request.setAttribute("statusflag", statusflag);

		return new ModelAndView("/fo/repairplatform/giftList");
	}

	/**
	 * 失效礼包列表页面
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "method=InvalidgiftList")
	public ModelAndView InvalidgiftList(HttpServletRequest request) {
		String openid = (String) request.getAttribute("openid");
		if (StringUtil.isEmpty(openid)) {
			openid = request.getParameter("openid");
		}		
		String identifynumber = "";
		String customercname = "";
		identifynumber = (String) CachedUtils.get(openid
				+ Constants.MEMKEY_IDENTIFYNUMBER);
		customercname = (String) CachedUtils.get(openid
				+ Constants.MEMKEY_CUSTOMERCNAME);
		if (StringUtil.isEmpty(identifynumber)||StringUtil.isEmpty(customercname)) {
			WeiXinGzUserInfo weiXinGzUserInfo = repairPlatformGiftService
					.findUniqueByProperty(WeiXinGzUserInfo.class, "openid", openid);
			identifynumber = weiXinGzUserInfo.getIdentifynumber();
			customercname = weiXinGzUserInfo.getCustomercname();
		}
		List<WeixinGiftsetDetail> invalidWeixinGiftsetDetailList = repairPlatformGiftService
				.getInvalidWeixinGiftsetDetailList(identifynumber,
						customercname,openid);
		if (invalidWeixinGiftsetDetailList.size() > 0) {
			request.setAttribute("invalidWeixinGiftsetDetailList",
					invalidWeixinGiftsetDetailList);
		} else {
			request.setAttribute("message", "当前暂无礼包");
			return new ModelAndView("/fo/common/message");
			// return new ModelAndView("/fo/repairplatform/giftanonymous");
		}
		request.setAttribute("openid", openid);
		return new ModelAndView("/fo/repairplatform/invalidgiftList");
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
		String id = request.getParameter("id");
		logger.info("获得uuid是 " + uuid);
		logger.info("获得id是 " + id);
		String reString = "";

		String allString = (String) CachedUtils.get(id);

		logger.info("CachedUtils取出来的value值是 " + allString);
		if (!Constants.QRCODEAJAX_0.equals(allString) && null != allString) {
			String[] arrAllstr = allString.split(",");
			if (arrAllstr[0].equals(Constants.QRCODEAJAX_0)) {

				logger.info("返回之后要刷新 ");
				reString = Constants.QRCODEAJAX_1;
			} else {
				logger.info("扫描异常，返回之后要跳转到扫描失败公共提示页面 ");
				reString = Constants.QRCODEAJAX_2;
			}

		} else {
			logger.info("返回之后不要刷新 ");
			reString = Constants.QRCODEAJAX_0;
		}
		// logger.info("返回的数据为 " + jsonString.toString());
		return reString;

	}

	/**
	 * 抵用卷主页面
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "method=vouchersMain")
	public ModelAndView vouchersMain(HttpServletRequest request) {
		String statusflag = request.getParameter("statusflag");
		String id = request.getParameter("id");
		String openid = (String) request.getAttribute("openid");
		if (StringUtil.isEmpty(openid)) {
			openid = request.getParameter("openid");
		}
		WeixinGiftsetDetail weixinGiftsetDetail = repairPlatformGiftService
				.getEntity(WeixinGiftsetDetail.class, id);
		// 生产uuid
		String uuid = UUIDGenerator.generate();

		String JSONString = this.getJsonStr(request);

		String identifynumber = (String) CachedUtils.get(openid
				+ Constants.MEMKEY_IDENTIFYNUMBER);
		String customercname = (String) CachedUtils.get(openid
				+ Constants.MEMKEY_CUSTOMERCNAME);
		logger.info("CachedUtils取出来的identifynumber值是 " + identifynumber);
		logger.info("CachedUtils取出来的customercname值是 " + customercname);
		WeiXinGzUserInfo weiXinGzUserInfo = customerBindService
				.findUniqueByProperty(WeiXinGzUserInfo.class, "openid", openid);

		if (StringUtil.isEmpty(identifynumber)) {
			identifynumber = weiXinGzUserInfo.getIdentifynumber();
			logger.info("weiXinGzUserInfo取出来的identifynumber值是 "
					+ identifynumber);
		}
		if (StringUtil.isEmpty(customercname)) {
			customercname = weiXinGzUserInfo.getCustomercname();
			logger.info("weiXinGzUserInfo取出来的identifynumber值是 " + customercname);
		}

		// 已经完成上牌的车辆，车架号
		String framenoList = "'frameno'";

		// 查询客户已经上牌的车辆
		List<Map<String, Object>> NewCarHasLicenceList = new ArrayList<Map<String, Object>>(); // 已经完成上牌的车辆
		NewCarHasLicenceList = customerNewCarLicenceService
				.getNewCarHasLicenceRecord(identifynumber, customercname);
		// 把mysql 的已经上牌的数据 查出，以便ORACLE 查询排除
		for (int i = 0; i < NewCarHasLicenceList.size(); i++) {
			framenoList = framenoList + ",'"
					+ (String) NewCarHasLicenceList.get(i).get("frameno") + "'";
		}

		List<Map<String, Object>> customerNewCarLicenceList = new ArrayList<Map<String, Object>>(); // 传递到JSP的数据
		customerNewCarLicenceList = oracleCustomerNewCarLicenceService
				.getCustomerNewCarLicenceRecord(identifynumber, customercname,
						framenoList);

		if (customerNewCarLicenceList.size() < 1) {
			request.setAttribute("newCarFlag", "2");// 没新车
		} else {
			request.setAttribute("newCarFlag", "1");// 有新车
		}
		request.setAttribute("JSONString", JSONString);
		request.setAttribute("statusflag", statusflag);
		request.setAttribute("openid", openid);
		request.setAttribute("uuid", uuid);
		request.setAttribute("weixinGiftsetDetail", weixinGiftsetDetail);
		return new ModelAndView("/fo/repairplatform/vouchersMain");
	}

	/**
	 * 二维码扫描失败，跳到失败页面
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "method=qRcodeFailcommon")
	public ModelAndView qRcodeFailcommon(HttpServletRequest request) {
		String id = request.getParameter("id");
		logger.info("获得id是 " + id);
		String allString = (String) CachedUtils.get(id);
		String[] arrAllstr = allString.split(",");
		logger.info("CachedUtils取出来的value值是 " + allString);
		request.setAttribute("message", arrAllstr[3]);
		return new ModelAndView("/fo/common/message");
	}

	/**
	 * 抵用卷详情
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "method=vouchersDetails")
	public ModelAndView vouchersDetails(HttpServletRequest request) {
		String openid = (String) request.getAttribute("openid");
		String giftset_detail_id = request.getParameter("id");
		if (StringUtil.isEmpty(openid)) {
			openid = request.getParameter("openid");
		}

		GiftSetInstructionsRequest giftSetInstructionsRequest = new GiftSetInstructionsRequest(
				"fmps", "fcps", "json", "17", UUIDGenerator.generate(),
				giftset_detail_id);
		GiftSetInstructionsResponse giftSetInstructionsResponse = repairPlatformGiftWsService
				.getGiftSetInstructionsResponse(giftSetInstructionsRequest);

		request.setAttribute("openid", openid);
		if (giftSetInstructionsResponse.getErrmsg().equals("ok")) {
			if (StringUtil.isEmpty(giftSetInstructionsResponse.getContent())) {
				request.setAttribute("message", "没查询到您的信息券详情");
				return new ModelAndView("/fo/common/message");
			} else {
				request.setAttribute("content",
						giftSetInstructionsResponse.getContent());
			}

		} else {
			request.setAttribute("message", "没查询到您的信息券详情");
			return new ModelAndView("/fo/common/message");
		}

		return new ModelAndView("/fo/repairplatform/vouchersDetails");
	}

	/**
	 * 使用门店
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "method=useStore")
	public ModelAndView useStore(HttpServletRequest request) {
		String openid = (String) request.getAttribute("openid");
		String id = request.getParameter("id");
		if (StringUtil.isEmpty(openid)) {
			openid = request.getParameter("openid");
		}
		WeixinGiftsetDetail weixinGiftsetDetail = repairPlatformGiftService
				.getEntity(WeixinGiftsetDetail.class, id);
		request.setAttribute("openid", openid);
		request.setAttribute("id", id);
		request.setAttribute("weixinGiftsetDetail", weixinGiftsetDetail);
		return new ModelAndView("/fo/repairplatform/useStore");
	}

	/**
	 * 根据 openid获取二维码
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(params = "getGitQRcode")
	public void getGitQRcode(HttpServletRequest request,
			HttpServletResponse response) {
		// 设置页面不缓存
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		String openid = request.getParameter("openid");
		String id = request.getParameter("id");
		String uuid = request.getParameter("uuid");

		logger.info("uuid是========>" + uuid);
		WeixinGiftsetDetail weixinGiftsetDetail = repairPlatformGiftService
				.getEntity(WeixinGiftsetDetail.class, id);

		String logoPath = "/plug-in/cashcoupon/images/logo.jpg";

		String path = this.getClass().getClassLoader().getResource("")
				.getPath();
		File file = new File(path); // 默认图片，二维码无法生成时显示
		File parentfile = new File(file.getParent());
		File png = null;
		logger.info("二维码嵌入图片全路径是========>" + parentfile.getParent() + logoPath);

		// 二维码信息
		String QRmessage = "";

		QRmessage = weixinGiftsetDetail.getId();

		// if (reportInfoList.size() > 0) {
		if (!StringUtil.isEmpty(QRmessage)) {	//类型标识位改为礼券类型。2015-12-11		
			png = webServiceClientManagementService.getQRPng(openid, uuid,
					logoPath, parentfile, QRmessage,weixinGiftsetDetail.getCardtype().toString());
			//if (weixinGiftsetDetail.getCardtype() == 1) {
			//	png = webServiceClientManagementService.getQRPng(openid, uuid,
			//			logoPath, parentfile, QRmessage, "2");
			//}
			//if (weixinGiftsetDetail.getCardtype() == 2) {
			//	png = webServiceClientManagementService.getQRPng(openid, uuid,
			//			logoPath, parentfile, QRmessage, "3");
			//}
		}

		// }
		if (!StringUtil.isEmpty(QRmessage)) {
			// 未扫码（初始化为0）
			CachedUtils.set(QRmessage, "0");
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
	 * 跳转到结果页面
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "method=toResult")
	public ModelAndView toResualt(HttpServletRequest request) {
		String openid = (String) request.getAttribute("openid");
		if (StringUtil.isEmpty(openid)) {
			openid = request.getParameter("openid");
		}
		logger.info("openid是========>" + openid);
		String id = request.getParameter("id");
		logger.info("id是========>" + id);
		String uuid = request.getParameter("uuid");
		logger.info("uuid是========>" + uuid);
		WeixinGiftsetDetail weixinGiftsetDetail = repairPlatformGiftService
				.getEntity(WeixinGiftsetDetail.class, id);
		// 取得用户的昵称和头像
		WeiXinGzUserInfo weiXinGzUserInfo = repairPlatformGiftService
				.findUniqueByProperty(WeiXinGzUserInfo.class, "openid", openid);

		WeixinRepairEvaluation weixinRepairEvaluationn = new WeixinRepairEvaluation();
		weixinRepairEvaluationn.setRepairid(weixinGiftsetDetail
				.getScanrepairid());
		weixinRepairEvaluationn.setOpenid(openid);
		weixinRepairEvaluationn.setRepairname(weixinGiftsetDetail
				.getScanrepairname());

		if (weiXinGzUserInfo != null) {
			weixinRepairEvaluationn.setNickname(weiXinGzUserInfo.getNickname());
			weixinRepairEvaluationn.setHeadimgurl(weiXinGzUserInfo
					.getHeadimgurl());
		}
		weixinRepairEvaluationn.setqRcodeUUID(uuid);
		weixinRepairEvaluationn.setScanQrCodeTime(new Date());
		repairPlatformWsService.saveOrUpdate(weixinRepairEvaluationn);

		WeixinRepairEvaluation weixinRepairEvaluation = new WeixinRepairEvaluation();
		weixinRepairEvaluation.setOpenid(openid);
		weixinRepairEvaluation.setRepairid(weixinGiftsetDetail
				.getScanrepairid());
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

		request.setAttribute("weixinGiftsetDetail", weixinGiftsetDetail);
		request.setAttribute("openid", openid);
		return new ModelAndView("/fo/repairplatform/toResult");
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
		String JSONString = JsSdkUtil.getWxConfigJSONString();
		return JSONString;
	}
	
	/**
	 * 根据地区码，获取更多礼券
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "moreGiftSet")
	public ModelAndView moreGiftSet(HttpServletRequest request) {	
	String countyCode = request.getParameter("countyCode");
	String countyJson =java.net.URLDecoder.decode( request.getParameter("countyJson"));	
	request.setAttribute("countyJson", countyJson);	//所有区 
	request.setAttribute("countyCode", countyCode);	//当前区
	
	return new ModelAndView("/fo/repairplatform/moregiftset");
	}
	
	
	@RequestMapping(params = "getmoreGiftSetByArea")
	@ResponseBody
	public AjaxJson getmoreGiftSetByArea(HttpServletRequest request)
			throws Exception {		 
		String countycode = request.getParameter("countycode"); //地区码
		String paging = request.getParameter("paging");		//分页		
		logger.info("更多礼券页面上传的参数为====countycode====>"+countycode+". paging:"+paging);	
		AjaxJson jsonString = new AjaxJson();		 
		AreaGiftSetRequest areaGiftSetRequest = new AreaGiftSetRequest(	"fmps", "fcps", "json", "40", UUIDGenerator.generate(),countycode,paging);
		AreaGiftSetResponse areaGiftSetResponse = repairPlatformGiftWsService.getMoreGiftSetByCountyCode(areaGiftSetRequest);
		jsonString.setObj(areaGiftSetResponse);		 
		logger.info("返回的数据为 " + jsonString.toString());
		return jsonString;
	}
	
}
