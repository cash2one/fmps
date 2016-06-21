package cn.com.fubon.fo.personalcenter.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import jodd.util.StringUtil;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.extend.datasource.DataSourceContextHolder;
import org.jeecgframework.core.extend.datasource.DataSourceType;
import org.jeecgframework.core.util.IdcardUtils;
import org.jeecgframework.core.util.JSONHelper;
import org.jeecgframework.core.util.MyBeanUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import weixin.guanjia.account.entity.WeixinAccountEntity;
import weixin.guanjia.account.service.WeixinAccountServiceI;
import weixin.guanjia.core.util.WeixinUtil;
import weixin.popular.util.JsonUtil;
import weixin.util.WeiXinConstants;
import cn.com.fubon.fo.cashcoupon.service.CashCouponService;
import cn.com.fubon.fo.customerbind.entity.WeiXinGzUserInfo;
import cn.com.fubon.fo.customerbind.service.CustomerBindService;
import cn.com.fubon.fo.personalcenter.entity.WeixinHuodongCard;
import cn.com.fubon.fo.personalcenter.service.PersonalCenterService;
import cn.com.fubon.fo.personalcenter.service.PolicyService;
import cn.com.fubon.fo.repairplatform.entity.WeixinRepairEvaluation;
import cn.com.fubon.fo.repairplatform.service.RepairPlatformService;
import cn.com.fubon.util.Constants;
import cn.com.fubon.wechatClaims.service.ReportInfoService;

/**
 * 个人中心类
 * 
 * @author patrick.z
 */
@Scope("prototype")
@Controller
@RequestMapping("/fo/binded/personalCenterController")
public class PersonalCenterController {
	@Resource
	private PersonalCenterService personalCenterService;
	@Resource
	private ReportInfoService reportInfoService;
	@Resource
	private CustomerBindService customerBindService;
	@Resource
	private RepairPlatformService repairPlatformService;
	@Resource
	private CashCouponService cashCouponService;

	@Resource
	private WeixinAccountServiceI weixinAccountService;

	@Resource(name = "PolicyService")
	private PolicyService policyService;

	public PersonalCenterController() {

	}

	private static final Logger logger = Logger
			.getLogger(PersonalCenterController.class);

	/**
	 * 进入个人中心首页(新) 个人中心首页,个人信息页和查看领用的保险卡都不需要进认证的拦截器
	 * 
	 * @author modified by fangfang.guo 20150725
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "method=Index")
	public String personalCenterIndex(HttpServletRequest request) {
		// 从菜单进,没有进认证拦截器,根据code获取openid
		String code = request.getParameter("code");
		logger.info("method=Index code==>" + code);
		String openid = request.getParameter("openid");
		logger.info("method=Index openid from request==>" + openid);

		if (StringUtil.isEmpty(openid)) {
			DataSourceContextHolder
					.setDataSourceType(DataSourceType.dataSource_jeecg);
			List<WeixinAccountEntity> weixinAccountEntityList = weixinAccountService
					.findValidWeixinAccounts();
			WeixinAccountEntity weixinAccountEntity = weixinAccountEntityList
					.get(0);
			openid = WeixinUtil.getOpenId(
					weixinAccountEntity.getAccountappid(),
					weixinAccountEntity.getAccountappsecret(), code);
			logger.info("get openid from code,openid==>" + openid);
		}

		// 如果openid还是空,就给到提示信息页
		if (StringUtil.isEmpty(openid)) {
			request.setAttribute("message",
					Constants.PERSONALCENTER_MESSAGE_OPENID_IS_NULL);
			return "/fo/common/message";
		}

		logger.info("PersonalCenterController openid =>" + openid);

		// 若用户信息不够，重新更新一次关注用户
		WeiXinGzUserInfo weiXinGzUserInfo = customerBindService
				.findUniqueByProperty(WeiXinGzUserInfo.class, "openid", openid);

		// 如果用户是未关注提示用户关注

		String headImagUrl = weiXinGzUserInfo.getHeadimgurl();
		String nicknameGz = weiXinGzUserInfo.getNickname();

		if (StringUtil.isEmpty(headImagUrl) || StringUtil.isEmpty(nicknameGz)) {

			WeixinAccountEntity weixinAccountEntity = personalCenterService
					.getWeixinAccountByStatus();
			String accessToken = weixinAccountService
					.getAccessToken(weixinAccountEntity);

			String requestUrl = WeixinUtil.get_customer_url.replace(
					"ACCESS_TOKEN", accessToken).replace("OPENID", openid);
			JSONObject customerJSONObject = WeixinUtil.httpRequest(requestUrl,
					"GET", null);

			//WeiXinGzUserInfo weiXinGzUserInfoTemp = (WeiXinGzUserInfo) JSONHelper.json2Object(customerJSONObject.toString(),WeiXinGzUserInfo.class);
			WeiXinGzUserInfo weiXinGzUserInfoTemp = JsonUtil.parseObject(customerJSONObject.toString(),	WeiXinGzUserInfo.class);
			if (weiXinGzUserInfoTemp != null) {
				try {
					MyBeanUtils.copyBeanNotNull2Bean(weiXinGzUserInfoTemp,
							weiXinGzUserInfo);
					personalCenterService.updateEntitie(weiXinGzUserInfo);
				} catch (Exception e) {
					logger.error(
							"copyBeanNotNull2Bean weiXinGzUserInfoTemp to weiXinGzUserInfo failed",
							e);
					if (!StringUtils.isEmpty(weiXinGzUserInfoTemp
							.getHeadimgurl())) {
						weiXinGzUserInfo.setHeadimgurl(weiXinGzUserInfoTemp
								.getHeadimgurl());
					}
					if (!StringUtils
							.isEmpty(weiXinGzUserInfoTemp.getNickname())) {
						weiXinGzUserInfo.setNickname(weiXinGzUserInfoTemp
								.getNickname());
					}
				}
			} else {
				// 头像和昵称为空应该怎么处理?暂时先返回提示信息页面 20150725 added by guo
				request.setAttribute("message", "没有获取到您的头像或者昵称");
				return "/fo/common/message";
			}

		}

		String nickName = weiXinGzUserInfo.getNickname();
		// 如果是未认证用户,在个人中心首页的昵称加上(待认证)
		if (weiXinGzUserInfo.getBindTime() == null) {
			nickName = nickName + Constants.NOT_BINDED;
		}

		// 判断是否存在可以评论的数据
		WeixinRepairEvaluation weixinRepairEvaluation = new WeixinRepairEvaluation();
		weixinRepairEvaluation.setOpenid(openid);
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
			request.setAttribute("count", weixinRepairEvaluationList.size());
		}

		request.setAttribute("nickname", nickName);
		request.setAttribute("headimgurl", weiXinGzUserInfo.getHeadimgurl());
		request.setAttribute("openid", openid);

		return "/fo/personalcenter/index";

	}

	/**
	 * 个人中心首页查看个人信息(包括个人和车辆), 个人中心首页,个人信息页和查看领用的保险卡都不需要进认证的拦截器
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "PersonalInfo")
	public String personalInfo(HttpServletRequest request) {

		String openid = request.getParameter("openid");

		WeiXinGzUserInfo weiXinGzUserInfo = customerBindService
				.findUniqueByProperty(WeiXinGzUserInfo.class, "openid", openid);

		// 如果用户是未关注提示用户关注
		if (weiXinGzUserInfo == null
				|| !WeiXinConstants.SUBSCRIBE_TYPE_VALUE
						.equals(weiXinGzUserInfo.getSubscribe())) {
			request.setAttribute("message",
					Constants.WEIXINBIND_MESSAGE_NOT_SUBSCRIBE);
			return "/fo/common/notSubscribe";
		}

		// 先取认证客户的性别,如果为空就取微信的性别
		String customerSex = weiXinGzUserInfo.getCustomerSex(); // M:男,F:女
		if (StringUtils.isEmpty(customerSex)) {
			customerSex = weiXinGzUserInfo.getSex(); // 1:男，2:女，0:未知
			switch (customerSex) {
			case "1":
				customerSex = "男";
				break;
			case "2":
				customerSex = "女";
				break;
			default:
				customerSex = "未知";
			}
		} else {
			switch (customerSex) {
			case "M":
				customerSex = "男";
				break;
			case "F":
				customerSex = "女";
				break;
			default:
				customerSex = "未知";
			}
		}

		// 关注表中的证件号码
		String identifynumberGz = weiXinGzUserInfo.getIdentifynumber();
		// 证件号码加密
		String identifynumber = null;
		if (!StringUtils.isEmpty(identifynumberGz)) {
			identifynumber = IdcardUtils
					.getEncryptionIdentifyNum(identifynumberGz);
		}

		// 关注表中的客户名称
		String customercnameGz = weiXinGzUserInfo.getCustomercname();
		// 根据证件号码和客户名称查询车辆信息(包括车牌号,厂牌型号,车架号,是否上牌)
		List<Map<String, Object>> cars = null;
		if (!StringUtils.isEmpty(customercnameGz)
				&& !StringUtils.isEmpty(identifynumberGz)) {
			cars = policyService.findAllCars(customercnameGz, identifynumberGz);
		}

		String nickName = weiXinGzUserInfo.getNickname();
		// 如果是未认证用户,在个人中心首页的昵称加上(待认证)
		if (weiXinGzUserInfo.getBindTime() == null) {
			nickName = nickName + Constants.NOT_BINDED;
		}

		logger.info("PersonalInfo openid =>" + openid);

		request.setAttribute("nickname", nickName);
		request.setAttribute("headimgurl", weiXinGzUserInfo.getHeadimgurl());
		request.setAttribute("customercname",
				StringUtils.isEmpty(customercnameGz) ? null : customercnameGz);
		request.setAttribute("customerSex", customerSex);
		request.setAttribute("identifynumber",
				StringUtils.isEmpty(identifynumber) ? null : identifynumber);
		request.setAttribute("cars", cars);
		request.setAttribute("openid", openid);

		return "fo/personalcenter/personalinfo";
	}

	/**
	 * 个人中心查看领用的保险卡, 个人中心首页,个人信息页和查看领用的保险卡都不需要进认证的拦截器
	 * 
	 * @author junjie
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "CardIndex")
	public String cardIndex(HttpServletRequest request) {
		String huodongid = request.getParameter("huodongid");
		String openid = request.getParameter("openid");
		if (StringUtil.isEmpty(openid)) {
			openid = (String) request.getAttribute("openid");
		}
		logger.info("查看领用的保险卡的 openid =>" + openid);
		String sql = " select w.openid, w.*, w1.id,w1.status,c.productname,c.producticon from weixin_huodong_card w left join weixin_card_info w1"
				+ " on w.cardno = w1.card_no LEFT JOIN weixin_product c on w.productid=c.id"
				+ " where w.openid=?" + " and w.openid is not null";

		WeixinHuodongCard weixinHuodongCard = new WeixinHuodongCard();
		weixinHuodongCard.setOpenid(openid);
		CriteriaQuery cq = new CriteriaQuery(WeixinHuodongCard.class);
		// 查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq,
				weixinHuodongCard);
		cq.add();
		// List<WeixinHuodongCard> weixinHuodongCardListt =
		// cashCouponService
		// .getListByCriteriaQuery(cq, true);
		request.setAttribute("weixinHuodongCard", weixinHuodongCard);
		List<Map<String, Object>> weixinHuodongCardList = cashCouponService
				.findForJdbc(sql, new String[] { openid });

		if (weixinHuodongCardList.size() > 0) {
			request.setAttribute("weixinHuodongCardList", weixinHuodongCardList);
		} else {
			request.setAttribute("message", "没有查询到您的保险卡信息！");
			return "/fo/common/message";
		}

		request.setAttribute("openid", openid);
		return "fo/personalcenter/cardindex";
	}

	@RequestMapping(params = "enterCard")
	public String enterCard(HttpServletRequest request) {

		String openid = request.getParameter("openid");
		logger.info("保险卡的 openid =>" + openid);
		Boolean isnoticFb = cashCouponService.checkUserByOpenid(openid);
		if (isnoticFb) {

			WeixinHuodongCard weixinHuodongCard = new WeixinHuodongCard();
			weixinHuodongCard.setOpenid(openid);
			CriteriaQuery cq = new CriteriaQuery(WeixinHuodongCard.class);
			// 查询条件组装器
			org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil
					.installHql(cq, weixinHuodongCard);
			cq.add();
			List<WeixinHuodongCard> weixinHuodongCardList = cashCouponService
					.getListByCriteriaQuery(cq, true);
			if (weixinHuodongCardList.size() > 0) {
				request.setAttribute("weixinHuodongCardList",
						weixinHuodongCardList);
			} else {
				request.setAttribute("message", "没有查询到您的保险卡信息！");
				return "/fo/common/message";
			}

		}

		request.setAttribute("openid", openid);
		return "fo/personalcenter/cardindex";
	}

	@RequestMapping(params = "myEvaluation")
	public String myEvaluation(HttpServletRequest request) {

		String openid = request.getParameter("openid");
		logger.info("openid=== " + openid);
		// logger.info("评论的repaireid=== " + repaireid);

		// 待评价的数据
		WeixinRepairEvaluation weixinRepairEvaluationn = new WeixinRepairEvaluation();
		weixinRepairEvaluationn.setOpenid(openid);
		// weixinRepairEvaluation.setRepairid(repaireid);

		CriteriaQuery cqq = new CriteriaQuery(WeixinRepairEvaluation.class);
		cqq.isNull("evaluation");
		cqq.isNull("comment");
		// 查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(
				cqq, weixinRepairEvaluationn);
		cqq.add();
		List<WeixinRepairEvaluation> weixinRepairEvaluationnList = repairPlatformService
				.getListByCriteriaQuery(cqq, true);

		// 已经评价的数据
		WeixinRepairEvaluation weixinRepairEvaluation = new WeixinRepairEvaluation();
		weixinRepairEvaluation.setOpenid(openid);
		// weixinRepairEvaluation.setRepairid(repaireid);

		CriteriaQuery cq = new CriteriaQuery(WeixinRepairEvaluation.class);
		cq.isNotNull("evaluation");
		cq.isNotNull("comment");
		// 查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq,
				weixinRepairEvaluation);
		cq.add();
		List<WeixinRepairEvaluation> weixinRepairEvaluationList = repairPlatformService
				.getListByCriteriaQuery(cq, true);

		request.setAttribute("weixinRepairEvaluationList",
				weixinRepairEvaluationList);
		request.setAttribute("weixinRepairEvaluationnList",
				weixinRepairEvaluationnList);
		request.setAttribute("openid", openid);
		return "fo/personalcenter/myEvaluation";
	}

}
