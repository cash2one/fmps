package cn.com.fubon.fo.card.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.extend.datasource.DataSourceContextHolder;
import org.jeecgframework.core.extend.datasource.DataSourceType;
import org.jeecgframework.core.util.IpUtil;
import org.jeecgframework.core.util.ResourceUtil;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.tag.vo.datatable.SortDirection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import weixin.guanjia.account.entity.WeixinAccountEntity;
import weixin.guanjia.account.service.WeixinAccountServiceI;
import weixin.guanjia.core.util.WeixinUtil;
import weixin.popular.util.JsonUtil;
import weixin.util.JsSdkUtil;
import cn.com.fubon.common.entity.occupationtypeEntity.Occupation;
import cn.com.fubon.common.entity.occupationtypeEntity.OccupationResponse;
import cn.com.fubon.emarketing.api.product.service.ProductService;
import cn.com.fubon.emarketing.entity.webservices.transaction.external.ebs.response.KindInfo;
import cn.com.fubon.emarketing.product.dto.ProductDto;
import cn.com.fubon.fo.card.entity.Card;
import cn.com.fubon.fo.card.entity.ContractAddress;
import cn.com.fubon.fo.card.entity.Customer;
import cn.com.fubon.fo.card.entity.Policy;
import cn.com.fubon.fo.card.entity.PolicyInsured;
import cn.com.fubon.fo.card.interceptor.Token;
import cn.com.fubon.fo.card.service.CardPolicyService;
import cn.com.fubon.fo.card.service.ICardService;
import cn.com.fubon.fo.card.service.ICardWS;
import cn.com.fubon.fo.card.service.IContractAddressService;
import cn.com.fubon.fo.card.service.ICustomerService;
import cn.com.fubon.fo.card.service.IPolicyInsuredService;
import cn.com.fubon.fo.card.service.IPolicyService;
import cn.com.fubon.fo.card.service.imp.ICardWSImp;
import cn.com.fubon.fo.customerbind.entity.WeiXinGzUserInfo;
import cn.com.fubon.fo.customerbind.service.CustomerBindService;
import cn.com.fubon.product.entity.AddressCode;
import cn.com.fubon.product.entity.Affiliated;
import cn.com.fubon.product.entity.Plan;
import cn.com.fubon.product.entity.Product;
import cn.com.fubon.product.entity.Responsibility;
import cn.com.fubon.product.service.IAddressCodeService;
import cn.com.fubon.product.service.IPlanService;
import cn.com.fubon.product.service.IProductRuleService;
import cn.com.fubon.product.service.IProductService;
import cn.com.fubon.util.CachedUtils;
import cn.com.fubon.util.Constants;
import cn.com.fubon.webservice.externl.coresystem.entity.CardResponse;
import cn.com.fubon.webservice.externl.coresystem.entity.PolicyResponse;

/**
 * 保险卡控制器
 * 
 * @author 郭俊杰
 * 
 */
@Scope("prototype")
@Controller
@RequestMapping("/fo/cardController")
public class CardController {
	@Resource
	private CardPolicyService cardPolicyServiceImpl;
	@Resource
	private IAddressCodeService addressCodeService;
	@Resource
	private CustomerBindService customerBindService;

	@Resource
	private IPlanService iPlanService;

	@Resource
	private IProductRuleService productRuleService;

	@Resource
	private ICardService cardService;

	@Resource
	private ICardWS cardWS;
	@Resource
	private ICustomerService customerService;
	@Resource
	private IPolicyInsuredService policyInsuredService;

	@Resource
	private IPolicyService policyService;

	@Resource
	private IContractAddressService contractAddressService;

	@Resource
	private WeixinAccountServiceI weixinAccountService;
	@Resource
	private IProductService ProductService_fmps;
	
	@Autowired
	private ProductService productService;	
	
	public static final String IDENTITY = "1";
	public String lunarNewYearPlanId = "8a8195b3523360c3015233aac8ee001a";

	private static final Logger logger = Logger.getLogger(CardController.class);

	/**
	 * 卡单激活初始化方法
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "initIndexCard")
	public String initIndexCard(HttpServletRequest request) {
		if (request.getSession().getAttribute("count") != null) {
			request.getSession().setAttribute("count", 0);
		}
		String openid;
		String openidParameter = request.getParameter("openid");
		String openidAttribute = (String) request.getAttribute("openid");
		String code = request.getParameter("code");
		logger.info("code=>" + code);
		if (StringUtil.isEmpty(openidParameter)) {
			openid = openidAttribute;
		} else {
			openid = openidParameter;
		}

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
			logger.info("根据code获取 openid,获取到的openid=>" + openid);
		}
		return "redirect:/fo/cardController.do?indexCard&openid=" + openid;
	}

	@RequestMapping(params = "indexCard")
	public String indexCard(HttpServletRequest request) {
		request.setAttribute("openid", request.getParameter("openid"));
		return "fo/card/cardactindex";
	}

	/**
	 * 保险卡商品列表
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "cardCommodity")
	public String cardCommodity(HttpServletRequest request) {
		String cardno = request.getParameter("cardcount");
		String password = request.getParameter("password");
		String openid = request.getParameter("openid");
		request.setAttribute("openid", openid);
		request.setAttribute("cardno", cardno);
		Card card = new Card();
		Policy policy = policyService.getPolicy(cardno);
		CardResponse cardResponse = null;
		try {
			cardResponse = cardWS.validateCard(cardno, password);
		} catch (IOException e) {
			logger.error("系统通讯异常，请稍候再试...", e);
			request.setAttribute("message", "系统通讯异常，请稍候再试...");
			return "/fo/common/message";
		}
		card = cardWS.saveCard(cardResponse, openid);

		if (Constants.CARD_VALIDATE_1.equals(card.getValidate())) {

			if (policy != null
					&& Constants.TYPE_POLICY_2.equals(policy.getType())) {
				List<Map<String, Object>> cardPolicyList = cardPolicyServiceImpl
						.getCardPolicyAll(cardno);
				request.setAttribute("customerPolicyList", cardPolicyList);
				request.setAttribute("title", "保单");
				if (cardPolicyList.size() < 1) {
					request.setAttribute("message", "没有查询到您的保单信息！");
					return "/fo/common/message";
				} else {
					// return "fo/person/customernotcarpolicy";
					return "redirect:/fo/cardController.do?viewnewdetail&policyNo="
							+ cardno + "&openid=" + openid;
				}
			}
			if (Constants.CARD_STATE_1.equals(card.getStatus())) {
				request.getSession().setAttribute("count", 0);
				// PolicyInsured policyInsured = policyInsuredService
				// .findUniqueByProperty(PolicyInsured.class, "policyno",
				// cardno);
				logger.info("获取到的cardno=>" + cardno);
				
     //*************************************************
		Plan plan = iPlanService.findUniqueByProperty(Plan.class,"coreproductcode", card.getCard_version_code());
		request.setAttribute("plan", plan);
		logger.info("获取到的planid=>" + plan.getProductid());
		//Product product = ProductService_fmps.findUniqueByProperty(	Product.class, "id", plan.getProductid());
	 //************************************************************			
		ProductDto productDto=productService.findCardBaseInfo(card.getCard_version_code());
	
					if (productDto != null) {
						request.setAttribute("product", productDto);						
     //根据商品配置参数，判断是否出现标的地址。
				String showContractAddress=	ProductService_fmps.getProductParameterValue(plan.getProductid(),plan.getId(),"general","showContractAddress");
						if ("Y".equals(showContractAddress)) {
							String accessToken = weixinAccountService
									.getAccessTokenFromAccountEntity();
							List<WeixinAccountEntity> weixinAccountEntityList = weixinAccountService
									.findValidWeixinAccounts();
							WeixinAccountEntity weixinAccountEntity = weixinAccountEntityList
									.get(0);
							String appid = weixinAccountEntity
									.getAccountappid();
							String URL = ResourceUtil.getDomain()
									+ request.getServletPath() + "?"
									+ request.getQueryString();
							logger.info("jssdkPage url ===>" + URL);
							JsSdkUtil JsSdkUtil = new JsSdkUtil(URL, appid,
									accessToken);
							String JSONString = JsSdkUtil
									.getWxConfigJSONString();
							request.setAttribute("JSONString", JSONString);
							request.setAttribute("showContractAddress",showContractAddress);
						}

					}
					List<AddressCode> addressCodes = addressCodeService
							.loadAll(AddressCode.class);

					// map.put("addressCodes", addressCodes);
					JSONArray json = JSONArray.fromObject(addressCodes);
					request.setAttribute("json", json);
					Boolean isbinded = customerBindService.isBinded(openid);
					if (isbinded) {
						List<WeiXinGzUserInfo> weiXinGzUserInfos = customerBindService
								.findByProperty(WeiXinGzUserInfo.class,
										"openid", openid);
						if (weiXinGzUserInfos.size() > 0) {
							WeiXinGzUserInfo weiXinGzUserInfo = weiXinGzUserInfos
									.get(0);
							request.setAttribute("customer", weiXinGzUserInfo);
						}

					}
					logger.info("获取到的productid=>" + plan.getProductid());
					String applicant = "投保人";
					String insured = "被保人";
					//int minage = productRuleService.findAgeRuleMinageByProductid(plan.getProductid(),insured);
					//int maxage = productRuleService.findAgeRuleByProductid(	plan.getProductid(), insured);
					request.setAttribute("age", productDto.getInsuranceAge() + "岁"); //被保险人年龄

					//int applicantminage = productRuleService.findAgeRuleMinageByProductid(plan.getProductid(),	applicant);
					//int applicantmaxage = productRuleService.findAgeRuleByProductid(plan.getProductid(),applicant);
					request.setAttribute("toubaoage", productDto.getApplicantAge() + "岁"); //投保人年龄

					/*
					 * List<Responsibility> responsibilityList = productService
					 * .findByProperty(Responsibility.class, "planid",
					 * plan.getId());
					 */

			      /*
			     Responsibility responsibility = new Responsibility();
					responsibility.setPlanid(plan.getId());

					CriteriaQuery cq = new CriteriaQuery(Responsibility.class);
					cq.addOrder("liabilitycode", SortDirection.asc);
					// 查询条件组装器
					org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil
							.installHql(cq, responsibility);
					cq.add();
					List<Responsibility> responsibilityList = ProductService_fmps
							.getListByCriteriaQuery(cq, true);	*/			
				
					List<KindInfo> kindInfoList= productService.findProductKindInfosByCoreProductCode(card.getCard_version_code());
					request.setAttribute("responsibilityList",	kindInfoList);
					
					
		//根据商品配置参数，判断是否出现车辆信息输入。
				String showCarMessage=	ProductService_fmps.getProductParameterValue(plan.getProductid(),plan.getId(),"general","showCarMessage");
				 request.setAttribute("showCarMessage", showCarMessage);
				return "fo/card/cardcommodity";
			} else {
				request.setAttribute("message", "卡号已经激活");
				return "fo/common/message";
			}

		} else {

			if (Constants.NOT_PASS_REASON_0.equals(card.getNot_pass_reason())
					|| Constants.NOT_PASS_REASON_1.equals(card
							.getNot_pass_reason())) {

				if (request.getSession().getAttribute("count") == null) {
					request.getSession().setAttribute("count", 1);

				} else {
					int countt = (int) request.getSession().getAttribute(
							"count");
					request.getSession().setAttribute("count", countt + 1);
				}

				request.setAttribute("message", "卡号不存在或密码错误");
			} else if (Constants.NOT_PASS_REASON_2.equals(card
					.getNot_pass_reason())) {
				request.setAttribute("message", "该种保险卡已停用");
			} else if (Constants.NOT_PASS_REASON_3.equals(card
					.getNot_pass_reason())) {
				request.setAttribute("message", "该保险卡已过期");

			} else if (Constants.NOT_PASS_REASON_4.equals(card
					.getNot_pass_reason())) {
				request.setAttribute("message", "该保险卡状态错误,不能被激活或者查看");
			} else {
				request.setAttribute("message", "该保险卡对应的产品数据配置异常");
			}

			if (Constants.CARD_STATE_2.equals(card.getStatus())) {
				List<Map<String, Object>> cardPolicyList = cardPolicyServiceImpl
						.getCardPolicyAll(cardno);
				request.setAttribute("customerPolicyList", cardPolicyList);
				request.setAttribute("title", "保单");
				if (cardPolicyList.size() < 1) {
					request.setAttribute("message", "没有查询到您的保单信息！");
					return "/fo/common/message";
				} else {
					// return "fo/person/customernotcarpolicy";
					return "redirect:/fo/cardController.do?viewnewdetail&policyNo="
							+ cardno + "&openid=" + openid;
				}
			}

			return "fo/common/message";
		}

	}

	/**
	 * 关键字职业查询列表
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "occupationLevels")
	public void getOccupationLevels(HttpServletRequest request,HttpServletResponse response) {
		String occupationName = request.getParameter("occupationName");	
		String basicDataType = request.getParameter("occupLevels");
		String openid = request.getParameter("openid");
		String ip=IpUtil.getPayIpAddr(request);
		request.setAttribute("openid", openid);
		OccupationResponse occupationResponse = null;
		try {
			//返回响应报文
			occupationResponse = cardWS.getOccupationType(basicDataType, occupationName,ip);
			List<Occupation> occupation = occupationResponse.getBody().getOccupation();
//			String json = JSON.toJSONString(occupation);
			JsonUtil.outWrite(response, JsonUtil.toJson(occupation));
		} catch (IOException e) {
			logger.error("系统通讯异常...", e);
			request.setAttribute("message", "系统通讯异常，请稍候再试...");
		}

	}
	
	/**
	 * 投保须知列表
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "cardNotice")
	public String cardNotice(HttpServletRequest request) {
		String cardno = request.getParameter("cardno");
		Card card = ProductService_fmps.findUniqueByProperty(Card.class, "card_no",
				cardno);

		Plan plan = iPlanService.findUniqueByProperty(Plan.class,
				"coreproductcode", card.getCard_version_code());

		String document = addressCodeService.findDocumentListByProductid(plan
				.getProductid());
		if (document != null) {
			request.setAttribute("document", document);
		}

		return "fo/card/notice";

	}

	/**
	 * 保险条款列表
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "cardArticle")
	public String cardArticle(HttpServletRequest request) {
		String cardno = request.getParameter("cardno");
		Card card = ProductService_fmps.findUniqueByProperty(Card.class, "card_no",
				cardno);

		Plan plan = iPlanService.findUniqueByProperty(Plan.class,
				"coreproductcode", card.getCard_version_code());

		List<Map<String, Object>> affiliated = addressCodeService
				.findArticleListByProductid(plan.getProductid());

		// List<Map<String, Object>> affiliated2 = addressCodeService
		// .findArticleListByProductid2(plan.getProductid());

		List<Affiliated> affiliatedList = new ArrayList<Affiliated>();

		for (int i = 0; i < affiliated.size(); i++) {
			Affiliated affiliatedd = new Affiliated();
			affiliatedd.setDescription((String) affiliated.get(i).get(
					"description"));
			affiliatedd.setDocument((String) affiliated.get(i).get("document"));
			affiliatedList.add(affiliatedd);
		}

		request.setAttribute("affiliatedList", affiliatedList);
		return "fo/card/article";

	}
	
	/**
	 * 微店-获取条款列表
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "microShopArticle")
	public String microShopArticle(HttpServletRequest request) {
		String coreproductcode = request.getParameter("coreproductcode");

		Plan plan = iPlanService.findUniqueByProperty(Plan.class,
				"coreproductcode", coreproductcode);

		List<Map<String, Object>> affiliated = addressCodeService
				.findArticleListByProductid(plan.getProductid());

		List<Affiliated> affiliatedList = new ArrayList<Affiliated>();

		for (int i = 0; i < affiliated.size(); i++) {
			Affiliated affiliatedd = new Affiliated();
			affiliatedd.setDescription((String) affiliated.get(i).get(
					"description"));
			affiliatedd.setDocument((String) affiliated.get(i).get("document"));
			affiliatedList.add(affiliatedd);
		}

		request.setAttribute("affiliatedList", affiliatedList);
		return "fo/card/article";

	}

	/**
	 * 检查验证码
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "checkCode")
	@ResponseBody
	public String checkCode(HttpServletRequest request) {

		String openid = request.getParameter("openid");
		logger.info("获取到的openid=>" + openid);
		HttpSession session = request.getSession();
		String randCode = request.getParameter("randCode");
		logger.info("客户端传的验证码=>" + randCode);
		String randCodeInSession = (String) session
				.getAttribute(Constants.SESSION_KEY_RAND_CODE);
		logger.info("session产生 的验证码=>" + randCodeInSession);
		String state = "";

		// 若session为空则从membercahced中取值
		if (StringUtils.isEmpty(randCodeInSession)) {
			randCodeInSession = (String) CachedUtils.get("randCode" + openid);
			logger.info("membercahced中获得的验证码=>" + randCodeInSession);
		}

		if (!(StringUtils.isEmpty(randCode))) {
			if (!(randCodeInSession.toString().equalsIgnoreCase(randCode))) { // 忽略验证码大小写
				state = "0";
			} else {
				state = "1";
			}

		}
		return state;

	}

	/**
	 * 保存保险卡信息
	 * 
	 * @param req
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	// @ResponseBody
	@Token(needRemoveToken = true)
	@RequestMapping(params = "saveCard")
	public String saveCard(HttpServletRequest req)
			throws UnsupportedEncodingException {
		String cardno = req.getParameter("cardno"); //

		String insuredName = req.getParameter("insuredName"); // 被保人名字
		String insuredNameZ = "";
		if (insuredName != null) {
			insuredNameZ = java.net.URLDecoder.decode(insuredName, "UTF-8");
		}

		String insuredIdentifytype = req.getParameter("insuredIdentifytype"); //

		String insuredIdentifynumber = req
				.getParameter("insuredIdentifynumber"); //

		String insuredGender = req.getParameter("insuredGender"); //

		String insuredBirthday = req.getParameter("insuredBirthday");

		String insuredPhone = req.getParameter("insuredPhone"); //

		String applicantName = req.getParameter("applicantName"); //
		String applicantNameZ = "";
		if (applicantName != null) {
			applicantNameZ = java.net.URLDecoder.decode(applicantName, "UTF-8");
		}

		String applicantIdentifytype = req
				.getParameter("applicantIdentifytype"); //

		String applicantNumber = req.getParameter("applicantNumber"); //

		String applicantPhone = req.getParameter("applicantPhone"); //

		String applicantGender = req.getParameter("applicantGender"); //

		String applicantBirthday = req.getParameter("applicantBirthday");

		String provinceCode = req.getParameter("provinceCode"); //

		String cityCode = req.getParameter("cityCode"); //

		String areaCode = req.getParameter("areaCode"); //

		String detial = req.getParameter("detial"); //
		
		String occupationname = req.getParameter("occupationName"); //职业类型中文名
		
		String occupationcode = req.getParameter("codeCode");	//职业代码
		
		String occupationgrade = req.getParameter("flagCode");		//职业类型
		
        String insuredCarOwnersValue = req.getParameter("insuredCarOwnersValue");//与车主关系代码
		
		String insuredCarOwnersText = req.getParameter("insuredCarOwnersText");// 与车主关系名称
		
		String insuredCarOwnerName = req.getParameter("insuredCarOwnerName");// 车主姓名
		String insuredLicenseNo = req.getParameter("insuredLicenseNo");// 车牌号
		
		String detialZ = "";
		if (detial != null) {
			detialZ = java.net.URLDecoder.decode(detial, "UTF-8");

		}

		String InsuredidentityFlag = ""; // 1、 投保保人相同
		String checkh = req.getParameter("checkh"); //

		if (Constants.CHECK_FLAG_0.equals(checkh)) {
			InsuredidentityFlag = Constants.INSUREDIDENTITYFLAG_2;
		} else {
			InsuredidentityFlag = Constants.INSUREDIDENTITYFLAG_1;
		}

		String type = req.getParameter("type"); //

		String openid = "";

		String openidParameter = req.getParameter("openid");
		logger.info("根据code获取 openid,获取到的openid=>" + openid);
		String openidAttribute = (String) req.getAttribute("openid");
		if (StringUtil.isEmpty(openidParameter)) {
			openid = openidAttribute;
		} else {
			openid = openidParameter;
		}

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		Date applicantDate = new Date();
		try {
			date = sdf.parse(insuredBirthday.trim());
		} catch (ParseException e) {
			logger.error("时间转换失败...", e);
		}
		if (!StringUtil.isEmpty(applicantBirthday)) {
			try {
				applicantDate = sdf.parse(applicantBirthday.trim());
			} catch (ParseException e) {
				logger.error("时间转换失败...", e);
			}
		}
	
		//boolean isJCK = false; // 是否家财卡
		logger.info("获取到的cradno=>" + cardno);
		String beneficiaryFlag = "1"; // 1、是法定受益人，2、是指定受益人
		Card card = cardService.findUniqueByProperty(Card.class, "card_no",
				cardno);
		Plan plan = iPlanService.findUniqueByProperty(Plan.class,
				"coreproductcode", card.getCard_version_code());
		Product product = ProductService_fmps.findUniqueByProperty(Product.class,
				"id", plan.getProductid());	
		//if (product != null) {
		//	if (product.getType() == Constants.PRODUCT_TYPE_2) {
		//		isJCK = true;
		//	}
		//}
		Policy policy = policyService.getPolicy(cardno);

		if (policy != null && Constants.TYPE_POLICY_2.equals(policy.getType())) {
			req.setAttribute("cardno", cardno);
			req.setAttribute("openid", openid);
			return "fo/card/success";
		}
		// 被保人
		Customer insured = customerService.getCustomer(insuredNameZ,
				insuredIdentifytype, insuredIdentifynumber, insuredGender,
				date, insuredPhone, "", "",insuredCarOwnersValue,insuredCarOwnersText,insuredCarOwnerName,insuredLicenseNo);
		policy.setPolicyno(cardno); // 卡号即 保单号
		policy.setPlanid(plan.getId());
		policy.setType(Constants.TYPE_POLICY_1); // 1投保单
		policy.setCreatetime(new Date()); // 创建时间

		Date startdate = ICardWSImp.getEndDate(1, "天");
		Date enddate = ICardWSImp.getEndDate(plan.getPeriod(),
				plan.getPeriodtype());

		String startdateStr = new SimpleDateFormat("yyyy-MM-dd")
				.format(startdate);
		startdateStr = startdateStr + " 00:00:00";
		String enddateStr = new SimpleDateFormat("yyyy-MM-dd").format(enddate);
		enddateStr = enddateStr + " 23:59:59";

		SimpleDateFormat stf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date startTime = new Date();
		Date endTime = new Date();
		try {
			startTime = stf.parse(startdateStr);
			endTime = stf.parse(enddateStr);
		} catch (ParseException e1) {
			logger.error("时间转换失败...", e1);
		}

		policy.setStartdate(startTime);// 起保时间
		policy.setEnddate(endTime);// 终保时间
		// policy.setApplicant(insured); // 被保人
		// policy.setInsuredidentity(InsuredidentityFlag); // 投保人关系
		PolicyInsured policyInsured = new PolicyInsured();
		policyInsured.setCustomer(insured);
		policyInsured.setPolicyno(cardno);
		policyInsured.setIdentity(IDENTITY);
		policyInsured.setOccupationname(occupationname);
		policyInsured.setOccupationcode(occupationcode);
		policyInsured.setOccupationgrade(occupationgrade);
		policyInsuredService.save(policyInsured);
		List<Customer> insuredList = new ArrayList<Customer>();
		insuredList.add(insured);
		policy.setInsuredList(insuredList);
		policy.setInsuredidentity(InsuredidentityFlag); // 设置投被保人关系
		policy.setIsbeneficiary(beneficiaryFlag); // 是法定受益人
		if (Constants.INSUREDIDENTITYFLAG_1.equals(InsuredidentityFlag)) { // 投被保人关系为本人的情况
			policy.setApplicant(insured); // 被保人

		} else {
			Customer applicant = customerService.getCustomer(applicantNameZ,
					applicantIdentifytype, applicantNumber, applicantGender,
					applicantDate, applicantPhone, "", "","","","","");
			policy.setApplicant(applicant); // 被保人
		}
		//根据商品配置参数，判断是否出现标的地址。
		String showContractAddress=	ProductService_fmps.getProductParameterValue(plan.getProductid(),plan.getId(),"general","showContractAddress");
		if ("Y".equals(showContractAddress)) { // 需要判断是否填写标的地址
			ContractAddress contractAddress = contractAddressService
					.getContractAddress(cardno, provinceCode, cityCode,
							areaCode, detialZ);
			policy.setAddressId(contractAddress); // 保单标的地址
		}

		policy.setOpenid(openid); //
		policy.setCard(card);

		policyService.saveOrUpdate(policy);
		PolicyResponse response = null;
		try {
			response = cardWS.sendInsured(policy, type,policyInsured);
		} catch (IOException e) {
			logger.error("投保失败...", e);
			req.setAttribute("message", "系统通讯异常，请稍候再试...");
			return "/fo/common/message";
		}
//		String errtype = response.getBody().getExceptiontype();
		String errmsg = response.getBody().getExceptionmessage();
		if (errmsg == null || "".equals(errmsg)) {
			policy.setType(Constants.TYPE_POLICY_2);
			policyService.updateEntitie(policy);
			card.setValidate(Constants.CARD_VALIDATE_0);
			card.setStatus(Constants.CARD_STATE_2);
			cardService.updateEntitie(card);
			req.setAttribute("cardno", cardno);

			// added by qingqu.huang .20150616
			String applicode = response.getBody().getApplicant().getApplicode();
			req.setAttribute("applicode", applicode);

			if (Constants.INSUREDIDENTITYFLAG_1.equals(InsuredidentityFlag)) {
				req.setAttribute("applicantPhone", insuredPhone);
				req.setAttribute("applicantNumber", insuredIdentifynumber);
				req.setAttribute("applicantName", insuredName);
			} else {
				req.setAttribute("applicantPhone", applicantPhone);
				req.setAttribute("applicantNumber", applicantNumber);
				req.setAttribute("applicantName", applicantName);
			}
			Boolean isbinded = customerBindService.isBinded(openid);
			req.setAttribute("isbinded", isbinded);
			req.setAttribute("openid", openid);
			if (product != null) {
				req.setAttribute("productName", product.getProductname());
			}

			return "fo/card/success";
		} else {
			req.setAttribute("message", errmsg);
			return "fo/common/message";
		}

	}

	/**
	 * 查看保单(已过期）
	 * 
	 * @param request
	 *            传入卡号
	 * @return 返回整个保单详细
	 */
	@RequestMapping(params = "viewdetail")
	public String viewDetail(HttpServletRequest request) {
		logger.info("进入查看保险卡激活信息方法...");
		String cardno = request.getParameter("cardno");
		List<Map<String, Object>> cardPolicyList = cardPolicyServiceImpl
				.getCardPolicyAll(cardno);
		request.setAttribute("customerPolicyList", cardPolicyList);
		request.setAttribute("title", "保单");
		if (cardPolicyList.size() < 1) {
			request.setAttribute("message", "没有查询到您的保单信息！");
			return "/fo/common/message";
		} else {
			return "fo/person/customernotcarpolicy";
		}
	}

	/**
	 * 查看保单
	 * 
	 * @param request
	 *            传入卡号
	 * @return 返回整个保单详细
	 */
	@RequestMapping(params = "viewnewdetail")
	public String viewNewDetail(HttpServletRequest request) {
		logger.info("进入查看保险卡激活信息方法...");
		String greetingCardLink="0" ; //默认无贺卡链接
		String policyNo = request.getParameter("policyNo");
		if(StringUtil.isEmpty(policyNo)){
			policyNo=(String) request.getAttribute("policyNo");	
		}
		// 保单头信息
		Map<String, String> policyHead = cardPolicyServiceImpl
				.findPolicyDetailHead(policyNo);
		List<Map<String, String>> policyBodys = new ArrayList<Map<String, String>>();
		Policy policy = policyService.getPolicy(policyNo);
		if(lunarNewYearPlanId.equalsIgnoreCase(policy.getPlanid())){
			// 如果是春节赠险计划id，则获取总保额
			policyBodys = cardPolicyServiceImpl.findLunarNewYearPolicyDetailBody(policyNo, lunarNewYearPlanId);
		}else{
			// 保单体信息 车险包括:险种名称,不计免赔,保额,费用;非车包括:险种名称,保障信息,保额
			policyBodys = cardPolicyServiceImpl
					.findPolicyDetailBody(policyNo);
		}
		if(cardPolicyServiceImpl.isFractureProduct(policyNo)&&this.isRangeOfDate()){
			greetingCardLink="1";			
		  }		
		if (policyHead == null) {
			request.setAttribute("message", "没有查询到您的保单信息！");
			return "/fo/common/message";
		}
		request.setAttribute("greetingCardLink", greetingCardLink);
		request.setAttribute("policyHead", policyHead);
		request.setAttribute("policyBodys", policyBodys);
		return "/fo/personalcenter/notcarpolicydetail";
	}

	
	    //判断是否在活动期间内
	private static boolean isRangeOfDate() {
			String ENDTIME = "2016-02-29 00:00:00";
			SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date nowdate = new Date();
			try {
				if (nowdate.before(sf.parse(ENDTIME))) {
					return true;
				}
			} catch (ParseException e) {
				logger.error("日期格式化出错...", e);
				return false;
			}
			return false;
		}
	
	
	
	/**
	 * 未认证用户自动认证
	 * 
	 * @author qingqu.huang
	 * @date 20150603
	 * @param request
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping(params = "customerBind")
	public String customerBind(HttpServletRequest request)
			throws UnsupportedEncodingException {
		String name = request.getParameter("name");
		String nameZ = null;
		if (name != null) {
			nameZ = java.net.URLDecoder.decode(name, "UTF-8");
		}
		String phonenum = request.getParameter("phonenum");
		String identitynumber = request.getParameter("identitynumber");
		String openid = request.getParameter("openid");
		request.setAttribute("customercname", nameZ);
		request.setAttribute("identifynumberother", identitynumber);
		request.setAttribute("mobileother", phonenum);
		request.setAttribute("openid", openid);
		return "/fo/customerbind/customerBind";
	}
	
	@RequestMapping(params = "showArticle")
	public String showArticle(HttpServletRequest request) {
		String productid = request.getParameter("productid");
		String planid = request.getParameter("planid");		
		List<cn.com.fubon.emarketing.product.entity.Affiliated>  affiliatedList=productService.findProductClauseTitles(planid);
	  	request.setAttribute("affiliatedList", affiliatedList);
		return "fo/taitravel/policyclause";
	}

	
	@RequestMapping(params = "method=clauseDetail")
	public String clauseDetail(HttpServletRequest request) {
		
		// openid通过拦截器中的attribute传入
		String openid = (String) request.getAttribute("openid");
		if (StringUtil.isEmpty(openid)) {
			openid = request.getParameter("openid");
		}		
		//根据条款id获取对应的条款
		String afid=request.getParameter("afid");
		String document=productService.findProductClauseContents(afid);		
		//Map<String, Object> policyInfo = policyService.findAffiliatedById(afid);
		//request.setAttribute("document", policyInfo.get("document"));
		request.setAttribute("document", document);
		
		return "fo/taitravel/policyclausedetail";
		
	}
	@RequestMapping(params = "showNotice")
	public String showNotice(HttpServletRequest request) {
		String productid = request.getParameter("productid");		
		String document =productService.findProductNotice(productid);		
		//String document = addressCodeService.findDocumentListByProductid(productid);
		if (document != null) {
			request.setAttribute("document", document);
		}
		return "fo/card/notice";

	}
	
	

}
