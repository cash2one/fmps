/**
 * 
 */
package cn.com.fubon.fo.huodong.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import jodd.util.StringUtil;

import org.apache.log4j.Logger;
import org.jeecgframework.core.extend.datasource.DataSourceContextHolder;
import org.jeecgframework.core.extend.datasource.DataSourceType;
import org.jeecgframework.core.util.ResourceUtil;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import weixin.guanjia.account.entity.WeixinAccountEntity;
import weixin.guanjia.account.service.WeixinAccountServiceI;
import weixin.guanjia.core.util.WeixinUtil;
import weixin.idea.huodong.entity.HuodongEntity;
import weixin.util.JsSdkUtil;
import cn.com.fubon.fo.customerbind.entity.WeiXinGzUserInfo;
import cn.com.fubon.fo.dynamicpassword.service.DynamicPasswordService;
import cn.com.fubon.fo.huodong.service.GasCardService;
import cn.com.fubon.util.CachedUtils;

/**
 * 加油卡活动controller
 * 
 * @author qingqu.huang
 * @DATE 2015-10-19
 */
@Scope("prototype")
@Controller
@RequestMapping("/fo/gasCardController")
public class GasCardController {

	private static final Logger logger = Logger
			.getLogger(GasCardController.class);
	@Resource
	private WeixinAccountServiceI weixinAccountService;
	@Resource
	private DynamicPasswordService dynamicPasswordService;

	@Resource
	private GasCardService gasCardServiceImpl;
	// 帮抢页面，标识可帮抢
	private String FLAG_HELP = "0";
	// 帮抢页面，标识自己不能帮自己抢
	private String FLAG_HELP_SELF = "1";
	// 帮抢页面，标识已帮忙抢过
	private String FLAG_HELPED = "2";

	private final static String STARTTIME = "2015-11-11 09:00:00";
	private final static String ENDTIME = "2015-11-14 00:00:00";
	// UAT环境appid 注：memcached成为瓶颈，appid从缓存中移除，直接写成常量 @DATE 20151113104544
	private String UATAPPID = "wx0399bb88eebabd18";
	// 生产环境appid
	private String PRODAPPID = "wxeee8b84bc1946b90";
	// 预生产环境appid
	private String PREAPPID = "wx530ce440f6f9de09";

	/**
	 * 进入加油卡活动主页
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "gasCardIndex")
	public String gasCardIndex(HttpServletRequest request) {
		String huodongid = request.getParameter("id");
		String openid = (String) request.getAttribute("openid");
		if (StringUtil.isEmpty(openid)) {
			openid = request.getParameter("openid");
		}
		String mobilekey = openid + "mobile";
		String mobile = (String) CachedUtils.get(mobilekey);
		if (StringUtil.isEmpty(mobile)) {
			WeiXinGzUserInfo userinfo = gasCardServiceImpl
					.findUniqueByProperty(WeiXinGzUserInfo.class, "openid",
							openid);
			if (userinfo != null) {
				mobile = userinfo.getMobile();
				if (StringUtil.isNotEmpty(mobile)) {
					CachedUtils.add(mobilekey, mobile);
				}
			}
		}
		String activedProfile = request.getSession().getServletContext()
				.getInitParameter("spring.profiles.active");
		String appid = "";
		if ("prod".equalsIgnoreCase(activedProfile)) {
			appid = PRODAPPID;
		} else if ("uat".equalsIgnoreCase(activedProfile)) {
			appid = UATAPPID;
		} else if ("pre".equals(activedProfile)) {
			appid = PREAPPID;
		}
		request.setAttribute("appid", appid);
		request.setAttribute("phonenum", mobile);
		request.setAttribute("cnt",
				gasCardServiceImpl.getCnt(huodongid, openid));
		request.setAttribute("huodongid", huodongid);
		request.setAttribute("openid", openid);
		return "/fo/huodong/gascard/gascardIndex";
	}

	/**
	 * 保存用户手机号码
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "savephonenum")
	@ResponseBody
	public String savePhonenum(HttpServletRequest request) {
		String openid = (String) request.getAttribute("openid");
		if (StringUtil.isEmpty(openid)) {
			openid = request.getParameter("openid");
		}
		String phonenum = request.getParameter("phonenum");
		if (dynamicPasswordService.isBindedMobile(phonenum)) {
			return "1";
		}
		WeiXinGzUserInfo userinfo = gasCardServiceImpl.findUniqueByProperty(
				WeiXinGzUserInfo.class, "openid", openid);
		userinfo.setMobile(phonenum);
		gasCardServiceImpl.save(userinfo);
		return "0";
	}

	/**
	 * 查看排行榜
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "showRankList")
	public String showRankList(HttpServletRequest request) {
		String huodongid = request.getParameter("huodongid");
		List<Map<String, Object>> rankList = gasCardServiceImpl
				.getRankList(huodongid);
		Date updatetime = new Date();
		if (rankList.size() > 0) {
			updatetime = (Date) rankList.get(0).get("updatetime");
			for (int i = 0; i < rankList.size(); i++) {
				String nickname = String.valueOf(rankList.get(i)
						.get("nickname"));
				if (nickname.length() > 7) {
					nickname = nickname.substring(0, 6) + "...";
					rankList.get(i).put("nickname", nickname);
				}
			}
		}
		request.setAttribute("rankList", rankList);
		request.setAttribute("updateTime", updatetime);
		return "/fo/huodong/gascard/rankList";
	}

	/**
	 * 进入帮抢页面
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "helpIndex")
	public String helpIndex(HttpServletRequest request) {
		String activedProfile = request.getSession().getServletContext()
				.getInitParameter("spring.profiles.active");
		String huodongid = request.getParameter("huodongid");
		if ("prod".equalsIgnoreCase(activedProfile)) {
			if (!isRangeOfDate()) {
				request.setAttribute("message", "不在活动时间");
				return "/fo/common/message";
			}
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

		String appid = "";
		if ("prod".equalsIgnoreCase(activedProfile)) {
			appid = PRODAPPID;
		} else if ("uat".equalsIgnoreCase(activedProfile)) {
			appid = UATAPPID;
		} else if ("pre".equals(activedProfile)) {
			appid = PREAPPID;
		}
		String sponsor = request.getParameter("sponsor");
		if (openid.equals(sponsor)) {
			request.setAttribute("appid", appid);
			return "/fo/huodong/gascard/gascardRedirect";
		} else if (gasCardServiceImpl.isHelped(openid, sponsor, huodongid)) {
			request.setAttribute("helpflag", FLAG_HELPED);
		} else {
			request.setAttribute("helpflag", FLAG_HELP);
		}

		WeiXinGzUserInfo userinfo = gasCardServiceImpl.findUniqueByProperty(
				WeiXinGzUserInfo.class, "openid", sponsor);
		request.getSession().setAttribute("openid", openid);
		request.setAttribute("userinfo", userinfo);
		request.setAttribute("openid", openid);
		request.setAttribute("huodongid", huodongid);
		request.setAttribute("sponsor", sponsor);
		request.setAttribute("appid", appid);
		return "/fo/huodong/gascard/helpIndex";
	}

	/**
	 * 记录帮抢信息
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "help")
	@ResponseBody
	public String help(HttpServletRequest request) {
		String sponsor = request.getParameter("sponsor");
		String huodongid = request.getParameter("huodongid");
		String openid = (String) request.getSession().getAttribute("openid");
		// String openid = (String) request.getAttribute("openid");
		// if (StringUtil.isEmpty(openid)) {
		// openid = request.getParameter("openid");
		// }
		if (openid.equals(sponsor)) {
			return "1";
		}
		if (gasCardServiceImpl.isHelped(openid, sponsor, huodongid)) {
			return "2";
		}
		gasCardServiceImpl.saveGasCardRecord(openid, sponsor, huodongid);
		return "0";
	}

	private static boolean isRangeOfDate() {
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date nowdate = new Date();
		try {
			if (nowdate.after(sf.parse(STARTTIME))
					&& nowdate.before(sf.parse(ENDTIME))) {
				return true;
			}
		} catch (ParseException e) {
			logger.error("日期格式化出错...", e);
			return false;
		}
		return false;
	}
}
