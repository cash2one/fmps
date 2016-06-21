/**
 * 
 */
package cn.com.fubon.fo.cashcoupon.controller;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.util.IpUtil;
import org.jeecgframework.core.util.ResourceUtil;
import org.jeecgframework.core.util.StringUtil;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import weixin.guanjia.account.entity.WeixinAccountEntity;
import weixin.guanjia.account.service.WeixinAccountServiceI;
import weixin.idea.huodong.entity.HuodongEntity;
import weixin.util.JsSdkUtil;
import cn.com.fubon.fo.cashcoupon.service.CashCouponService;
import cn.com.fubon.fo.customerbind.service.CustomerBindService;
import cn.com.fubon.fo.dynamicpassword.service.DynamicPasswordService;
import cn.com.fubon.util.FBStringUtils;

/**
 * 微信红包controller
 * 
 * @author qingqu.huang
 * @date 2015-07-13
 */
@Scope("prototype")
@Controller
@RequestMapping("/fo/cashCouponController")
public class CashCouponController {
	private static final Logger logger = Logger
			.getLogger(CashCouponController.class);
	private static final String CERT_NAME = "apiclient_cert";
	private static final String CASHCOUPON_URL = "cashcouponurl";
	private static final String TITLE = "红包君等等！";
	private static final String DESC = "富邦派送现金红包啦！更多百元现金红包，等你来领！";
	@Resource
	private CashCouponService cashCouponServiceImpl;

	@Resource
	private WeixinAccountServiceI weixinAccountService;
	@Resource
	private CustomerBindService customerBindService;
	@Resource
	private DynamicPasswordService dynamicPasswordService;

	/**
	 * 进入打开红包界面
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "cashcoupon")
	public String cashCouponEntry(HttpServletRequest request) {
		String huodongid = request.getParameter("huodongid");
		String fromtag = request.getParameter("fromtag");
		String openid = (String) request.getAttribute("openid");
		if (StringUtil.isEmpty(openid)) {
			openid = request.getParameter("openid");
		}
		logger.info("用户的openid为：" + openid);
		request.setAttribute("huodongid", huodongid);
		request.setAttribute("openid", openid);
		request.setAttribute("fromtag", fromtag);
		request.setAttribute("title", TITLE);
		request.setAttribute("desc", DESC);

		// 活动前，直接跳到倒计时页面
		// added by qingqu.huang 20150907
		HuodongEntity huodongEntity = cashCouponServiceImpl.getEntity(
				HuodongEntity.class, huodongid);
		Date starttime = huodongEntity.getStarttime();
		Date nowdate = new Date();
		if (nowdate.before(starttime)) {
			return "redirect:/fo/cashCouponController.do?cashCouponCountdown&id="
					+ huodongid + "&openid=" + openid;
		}
		String JSONString = this.getJsonStr(request);
		request.setAttribute("JSONString", JSONString);
		Map<String, String> configMap = cashCouponServiceImpl.getConfigMap(
				"分享", huodongid);
		request.setAttribute("flink", configMap.get("flink"));
		request.setAttribute("zonelink", configMap.get("zonelink"));
		request.setAttribute("imgurl", configMap.get("imgurl"));
		List<Map<String, Object>> cashHistoryList = cashCouponServiceImpl
				.getCashHistoryList(huodongid);
		request.setAttribute("cashHistoryList", cashHistoryList);
		Map<String, Object> cashMap = cashCouponServiceImpl.getCashCouponMap(
				openid, huodongid);
		if (cashMap != null && cashMap.size() > 0) {
			String status = (String) cashMap.get("status");
			String mch_billno = (String) cashMap.get("mch_billno");
			boolean result = false;
			if (StringUtil.isNotEmpty(status)
					&& !"SUCCESS".equalsIgnoreCase(status)) {
				result = cashCouponServiceImpl.queryCouponResut(mch_billno,
						openid);
			}
			if ((StringUtil.isNotEmpty(status) && status
					.equalsIgnoreCase("SUCCESS")) || result) {
				request.setAttribute(
						"total_amount",
						(double) (Math.round((int) cashMap.get("total_amount")) / 100.0));
				String desc = configMap.get("desc");
				desc = desc.replace("{amount}", String.valueOf((double) (Math
						.round((int) cashMap.get("total_amount")) / 100.0)));
				request.setAttribute("desc", desc);
				request.setAttribute("title", configMap.get("title"));
				request.setAttribute("appid", this.getAppid());
				return "/fo/cashcoupon/LotteryResult";
			}
		}
		// int seqid = cashCouponServiceImpl.getSeqid(openid, huodongid);
		// logger.info("seqid:" + seqid);
		return "/fo/cashcoupon/GetCashCoupon";

	}

	/**
	 * 打开红包
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "getCashCoupon")
	public String getCashCoupon(HttpServletRequest request) {
		if (cashCouponServiceImpl.checkTime()) {
			request.setAttribute("message", "十分抱歉，因微信红包领取规则限制，00:00-8:00不能领取红包");
			return "/fo/cashcoupon/Message";
		}
		String huodongid = request.getParameter("huodongid");
		String openid = request.getParameter("openid");
		String fromtag = request.getParameter("fromtag");
		HuodongEntity huodongEntity = cashCouponServiceImpl.getEntity(
				HuodongEntity.class, huodongid);
		String JSONString = this.getJsonStr(request);
		request.setAttribute("JSONString", JSONString);
		Map<String, String> configMap = cashCouponServiceImpl.getConfigMap(
				"分享", huodongid);
		request.setAttribute("flink", configMap.get("flink"));
		request.setAttribute("zonelink", configMap.get("zonelink"));
		request.setAttribute("imgurl", configMap.get("imgurl"));
		request.setAttribute("desc", DESC);
		request.setAttribute("title", TITLE);
		Date starttime = huodongEntity.getStarttime();
		Date endtime = huodongEntity.getEndtime();
		Date nowdate = new Date();
		SimpleDateFormat myFmt = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
		String message = "";
		if (nowdate.before(starttime)) {
			message = "来早啦，红包于" + myFmt.format(starttime) + "开抢.";
			request.setAttribute("message", message);
			return "/fo/cashcoupon/OutOfDate";
		}
		request.setAttribute("openid", openid);
		request.setAttribute("fromtag", fromtag);
		List<Map<String, Object>> cashHistoryList = cashCouponServiceImpl
				.getCashHistoryList(huodongid);
		request.setAttribute("cashHistoryList", cashHistoryList);
		Map<String, Object> cashMap = cashCouponServiceImpl.getCashCouponMap(
				openid, huodongid);
		if (cashMap != null && cashMap.size() > 0) {
			String status = (String) cashMap.get("status");
			String mch_billno = (String) cashMap.get("mch_billno");
			boolean result = false;
			if (StringUtil.isNotEmpty(status)
					&& !"SUCCESS".equalsIgnoreCase(status)) {
				result = cashCouponServiceImpl.queryCouponResut(mch_billno,
						openid);
			}
			if ((StringUtil.isNotEmpty(status) && status
					.equalsIgnoreCase("SUCCESS")) || result) {
				request.setAttribute(
						"total_amount",
						(double) (Math.round((int) cashMap.get("total_amount")) / 100.0));
				String desc = configMap.get("desc");
				desc = desc.replace("{amount}", String.valueOf((double) (Math
						.round((int) cashMap.get("total_amount")) / 100.0)));
				request.setAttribute("desc", desc);
				request.setAttribute("title", configMap.get("title"));
				request.setAttribute("appid", this.getAppid());
				return "/fo/cashcoupon/LotteryResult";
			}
		}
		int seqid = cashCouponServiceImpl.getSeqid(openid, huodongid);
		int totalnum = cashCouponServiceImpl.getCount(huodongid);
		if (seqid > totalnum) {
			request.setAttribute("message", "手慢了~红包已派送完，请关注下次红包派送活动");
			return "/fo/cashcoupon/OutOfDate";
		}
		if (nowdate.after(endtime)) {
			message = "来晚啦，红包于" + myFmt.format(endtime) + "已结束。";
			request.setAttribute("message", message);
			return "/fo/cashcoupon/OutOfDate";
		}
		if (customerBindService.isBinded(openid)) {
			return "redirect:/fo/cashCouponController.do?sendCashCoupon&openid="
					+ openid
					+ "&huodongid="
					+ huodongid
					+ "&fromtag="
					+ fromtag;
		} else {
			request.setAttribute("huodongid", huodongid);
			return "/fo/cashcoupon/ReceiveCard";
		}
	}

	/**
	 * 发送微信红包
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "sendCashCoupon")
	public String sendCashCoupon(HttpServletRequest request) {
		String huodongid = request.getParameter("huodongid");
		String openid = request.getParameter("openid");
		String fromtag = request.getParameter("fromtag");
		int total_amout = 0;
		String cashcouponid = "";
		String requestxml = "";
		List<Map<String, Object>> cashHistoryList = cashCouponServiceImpl
				.getCashHistoryList(huodongid);
		request.setAttribute("cashHistoryList", cashHistoryList);
		request.setAttribute("openid", openid);
		request.setAttribute("JSONString", this.getJsonStr(request));
		Map<String, String> configMap = cashCouponServiceImpl.getConfigMap(
				"分享", huodongid);
		request.setAttribute("flink", configMap.get("flink"));
		request.setAttribute("zonelink", configMap.get("zonelink"));
		request.setAttribute("imgurl", configMap.get("imgurl"));
		request.setAttribute("desc", DESC);
		request.setAttribute("title", TITLE);
		Map<String, Object> cashMap = cashCouponServiceImpl.getCashCouponMap(
				openid, huodongid);
		boolean retry = false;
		if (cashMap != null && cashMap.size() > 0) {
			String status = (String) cashMap.get("status");
			String mch_billno = (String) cashMap.get("mch_billno");
			if (StringUtil.isNotEmpty(status)
					&& !"SUCCESS".equalsIgnoreCase(status)) {
				retry = cashCouponServiceImpl.queryCouponResut(mch_billno,
						openid);
			}
			if ((StringUtil.isNotEmpty(status) && status
					.equalsIgnoreCase("SUCCESS")) || retry) {
				request.setAttribute(
						"total_amount",
						(double) (Math.round((int) cashMap.get("total_amount")) / 100.0));
				String desc = configMap.get("desc");
				desc = desc.replace("{amount}", String.valueOf((double) (Math
						.round((int) cashMap.get("total_amount")) / 100.0)));
				request.setAttribute("desc", desc);
				request.setAttribute("title", configMap.get("title"));
				request.setAttribute("appid", this.getAppid());
				return "/fo/cashcoupon/LotteryResult";
			}
		}
		// cashCouponServiceImpl.updateCard(openid, huodongid);
		String client_ip = IpUtil.getPayIpAddr(request);
		int seqid = cashCouponServiceImpl.getSeqid(openid, huodongid);
		Map<String, Object> cashcouponMap = cashCouponServiceImpl
				.getCashCoupon(seqid, huodongid);
		total_amout = (int) cashcouponMap.get("amount");
		cashcouponid = (String) cashcouponMap.get("id");
		requestxml = cashCouponServiceImpl.getRequestXml(openid, client_ip,
				total_amout, total_amout, total_amout, 1, huodongid, fromtag,
				cashcouponid, seqid);
		String returncode = "";
		// 判断程序运行环境，如果是生产，则调用微信发送红包结果
		String activedProfile = request.getSession().getServletContext()
				.getInitParameter("spring.profiles.active");
		try {
			Map<String, Object> resultMap = cashCouponServiceImpl
					.sendCashcoupon(requestxml, CASHCOUPON_URL, CERT_NAME,
							openid, huodongid, activedProfile);
			returncode = (String) resultMap.get("returncode");
			if (StringUtil.isNotEmpty(returncode)
					&& "FAIL".equalsIgnoreCase(returncode)) {
				request.setAttribute("message",
						(String) resultMap.get("message"));
				return "/fo/cashcoupon/OutOfDate";

			}
		} catch (Exception e) {
			logger.error("发放红包接口出现异常", e);
			request.setAttribute("message", "领取失败，请稍候再试");
			return "/fo/cashcoupon/Message";
		}
		request.setAttribute("total_amount",
				(double) (Math.round(total_amout) / 100.0));
		String desc = configMap.get("desc");
		desc = desc.replace("{amount}",
				String.valueOf((double) (Math.round(total_amout) / 100.0)));
		request.setAttribute("desc", desc);
		request.setAttribute("title", configMap.get("title"));
		request.setAttribute("appid", this.getAppid());
		return "/fo/cashcoupon/LotteryResult";
	}

	/**
	 * 记录用户手机号
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "receiveCard")
	public String receiveCard(HttpServletRequest request) {
		String huodongid = request.getParameter("huodongid");
		String openid = request.getParameter("openid");
		String phonenum = request.getParameter("phonenum");
		String fromtag = request.getParameter("fromtag");
		cashCouponServiceImpl.setPhonenumForUser(phonenum, openid);
		return "redirect:/fo/cashCouponController.do?sendCashCoupon&openid="
				+ openid + "&huodongid=" + huodongid + "&fromtag=" + fromtag;
	}

	/**
	 * 验证手机号和验证码
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "checkPhone")
	@ResponseBody
	public String checkPhone(HttpServletRequest request) {
		String phonenum = request.getParameter("phonenum");
		String verifcode = request.getParameter("verifcode");
		if (!FBStringUtils.checkMobile(phonenum)) {
			return "2";
		}
		boolean isverifcode = dynamicPasswordService.isValidDynamicPassword(
				phonenum, verifcode);
		if (isverifcode) {
			return "0";
		} else {
			return "1";
		}
	}

	/**
	 * 跳转到红包倒计时页面
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "cashCouponCountdown")
	public String cashCouponCountdown(HttpServletRequest request) {
		List<WeixinAccountEntity> weixinAccountEntityList = weixinAccountService
				.findValidWeixinAccounts();
		WeixinAccountEntity weixinAccountEntity = weixinAccountEntityList
				.get(0);
		Date nowTime = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
		String dateStr = sdf.format(nowTime);
		logger.info("当前时间是==>" + dateStr);
		String id = request.getParameter("id");
		logger.info("活动id是==>" + id);
		HuodongEntity huodongEntity = cashCouponServiceImpl.getEntity(
				HuodongEntity.class, id);
		String endtimeStr = "";
		if (huodongEntity != null && huodongEntity.getStarttime() != null) {
			endtimeStr = sdf.format(huodongEntity.getStarttime());
		}
		// }
		logger.info("红包开奖时间是==>" + endtimeStr);
		Date nowTimee = new Date();
		java.util.Date endDate = new Date();
		try {
			nowTimee = sdf.parse(dateStr);
			endDate = sdf.parse(endtimeStr);
		} catch (ParseException e) {
			logger.error("日期格式化失败", e);
		}

		int i = nowTimee.compareTo(endDate);

		if (i >= 0) {
			String url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid={APPID}&redirect_uri={domain}%2Ffo%2FcashCouponController.do%3Fcashcoupon%26fromtag%3D2%26huodongid%3D8a828ebb49166847014916deca570004"
					+ "&response_type=code&scope=snsapi_base&state=STATE#wechat_redirect";
			String domain = ResourceUtil.getDomain();
			url = url.replace("{APPID}", weixinAccountEntity.getAccountappid())
					.replace("{domain}", domain);
			logger.info("customerHonorTitleAfter redirect url==>" + url);
			request.setAttribute("url", url);
			return "/fo/cashcoupon/cashCouponRedirect";
		} else {
			request.setAttribute("APPID", weixinAccountEntity.getAccountappid());
			String JSONString = this.getJsonStr(request);
			request.setAttribute("JSONString", JSONString);
			request.setAttribute("endtimeStr", endtimeStr);
			request.setAttribute("id", id);
			return "/fo/cashcoupon/cashCouponCountdown";
		}

	}

	@RequestMapping(params = "init")
	public String init(HttpServletRequest request) {
		String huodongid = request.getParameter("huodongid");
		HuodongEntity huodongEntity = cashCouponServiceImpl.getEntity(
				HuodongEntity.class, huodongid);
		cashCouponServiceImpl.initcashcoupon(huodongEntity);
		request.setAttribute("message", "初始化完成");
		return "/fo/cashcoupon/Message";
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
		String appid = getAppid();
		String URL = ResourceUtil.getDomain() + request.getServletPath() + "?"
				+ request.getQueryString();
		logger.info("jssdkPage url ===>" + URL);
		JsSdkUtil JsSdkUtil = new JsSdkUtil(URL, appid, accessToken);
		String JSONString = JsSdkUtil.getWxConfigJSONString();
		return JSONString;
	}

	/**
	 * 获取appid
	 * 
	 * @return
	 */
	private String getAppid() {
		List<WeixinAccountEntity> weixinAccountEntityList = weixinAccountService
				.findValidWeixinAccounts();
		WeixinAccountEntity weixinAccountEntity = weixinAccountEntityList
				.get(0);
		String appid = weixinAccountEntity.getAccountappid();
		return appid;
	}

	/**
	 * 双旦红包活动-跳转到领取结果页面
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "showCouponResult")
	public String showCouponResult(HttpServletRequest request) {
		String huodongid = request.getParameter("huodongid");
		String openid = request.getParameter("openid");
		String amount = "";
		Map<String, Object> cashCouponMap = cashCouponServiceImpl
				.getCashCoupon(openid, huodongid);
		amount = String.valueOf(Integer.parseInt(String.valueOf(cashCouponMap
				.get("amount"))) / 100.0);
		String JSONString = this.getJsonStr(request);
		request.setAttribute("JSONString", JSONString);
		request.setAttribute("appid", this.getAppid());
		request.setAttribute("amount", amount);
		request.setAttribute("openid", openid);
		request.setAttribute("huodongid", huodongid);
		return "/fo/repairplatform/showCoupon";
	}

	/**
	 * 双旦红包活动-ajax异步发放红包
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "sendCoupon")
	@ResponseBody
	public AjaxJson sendCoupon(HttpServletRequest request) {
		AjaxJson ajaxJson = new AjaxJson();
		String huodongid = request.getParameter("huodongid");
		String openid = request.getParameter("openid");
		Map<String, Object> cashCouponMap = cashCouponServiceImpl
				.getCashCoupon(openid, huodongid);
		String client_ip = IpUtil.getPayIpAddr(request);
		int total_amout = Integer.parseInt(String.valueOf(cashCouponMap
				.get("amount")));
		String cashcouponid = (String) cashCouponMap.get("id");
		int seqid = (int) cashCouponMap.get("seqid");
		String requestxml = cashCouponServiceImpl.getRequestXml(openid,
				client_ip, total_amout, total_amout, total_amout, 1, huodongid,
				"1", cashcouponid, seqid);
		// 判断程序运行环境，如果是生产，则调用微信发送红包结果
		String activedProfile = request.getSession().getServletContext()
				.getInitParameter("spring.profiles.active");
		try {
			cashCouponServiceImpl.sendCashcoupon(requestxml, CASHCOUPON_URL,
					CERT_NAME, openid, huodongid, activedProfile);
		} catch (Exception e) {
			logger.error("发放红包接口出现异常", e);
		}
		return ajaxJson;
	}

}
