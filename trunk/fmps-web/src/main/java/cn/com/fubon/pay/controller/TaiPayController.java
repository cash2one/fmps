/**
 * 
 */
package cn.com.fubon.pay.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import jodd.datetime.JDateTime;

import org.apache.log4j.Logger;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.util.IpUtil;
import org.jeecgframework.core.util.MyBeanUtils;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.core.util.UUIDGenerator;
import org.jeecgframework.web.system.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import weixin.guanjia.account.service.WeixinAccountServiceI;
import cn.com.fubon.emarketing.api.product.service.ProductService;
import cn.com.fubon.emarketing.product.dto.ProductDto;
import cn.com.fubon.fo.card.entity.Customer;
import cn.com.fubon.fo.card.entity.Policy;
import cn.com.fubon.fo.card.entity.PolicyInsured;
import cn.com.fubon.fo.card.interceptor.Token;
import cn.com.fubon.fo.card.service.IContractAddressService;
import cn.com.fubon.fo.card.service.ICustomerService;
import cn.com.fubon.fo.card.service.IPolicyInsuredService;
import cn.com.fubon.fo.card.service.IPolicyService;
import cn.com.fubon.fo.customerbind.entity.WeiXinGzUserInfo;
import cn.com.fubon.fo.customerbind.service.CustomerBindService;
import cn.com.fubon.fo.taitravel.entity.StuPolicy;
import cn.com.fubon.fo.taitravel.service.IStuPolicyService;
import cn.com.fubon.fo.totaiwan.entity.TaiwanConstants;
import cn.com.fubon.fo.totaiwan.service.ToTaiwanService;
import cn.com.fubon.pay.service.OfflineWechatPayService;
import cn.com.fubon.pay.service.WechatPayService;
import cn.com.fubon.product.entity.Plan;
import cn.com.fubon.product.entity.Product;
import cn.com.fubon.product.service.IProductService;
import cn.com.fubon.util.Constants;

/**
 * 赴台旅游在线投保支付处理类
 * 
 * @author 黄清渠
 * @date 20150626
 *
 */

@Scope("prototype")
@Controller
@RequestMapping("/pay/taipayController")
public class TaiPayController {
	private Logger logger = Logger.getLogger(TaiPayController.class);
	@Resource
	private WechatPayService wechatPayService;
	@Resource
	private SystemService systemService;
	@Resource
	private OfflineWechatPayService offlineWechatPayService;
	@Resource
	private ICustomerService customerService;
	@Resource
	private IContractAddressService contractAddressService;
	@Resource
	private IPolicyInsuredService policyInsuredService;
	@Resource
	private WeixinAccountServiceI weixinAccountService;
	@Resource
	private IStuPolicyService stupolicyService;
	@Resource
	private IPolicyService policyService;
	@Resource
	private ToTaiwanService toTaiwanServiceImpl;
	@Resource
	private CustomerBindService customerBindService;
	@Resource
	private IProductService productService_fmps;
	@Autowired
	private ProductService productService;	


	/**
	 * 支付学生旅游险
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(params = "payStuP")
	@ResponseBody
	public AjaxJson payStuP(HttpServletRequest request) throws Exception {
		AjaxJson jsonString = new AjaxJson();
		boolean isPayCodeValid = true;
		String id = request.getParameter("id"); // id
		String premium = request.getParameter("premium");
		String openid = request.getParameter("openid");
		String body = request.getParameter("schemetype");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");

		String message;
		if (isPayCodeValid) {
			// 调用核心接口检测支付码
			// 微信下单并返回JOSN对象

			String json = "   ";
			String outTradeNo = "";// 支付码
			String totalFee = "";// 总保费
			String attach = "";// 用户名_手机号
			String spbillCreateIp = IpUtil.getPayIpAddr(request);
			// 总费用处理 取分
			String sumPremium = premium + "";
			int totalFeeTemp = (int) (Double.valueOf(sumPremium) * 100);
			totalFee = totalFeeTemp + "";
			outTradeNo = UUIDGenerator.generate();
			attach = "TaiPay" + "," + outTradeNo + "," + name + phone;
			StuPolicy stuPolicy = stupolicyService.getEntity(StuPolicy.class,
					id);
			stuPolicy.setPayorderno(outTradeNo);
			stupolicyService.updateEntitie(stuPolicy);
			logger.info("openid:" + openid + "body:" + body + "outTradeNo:"
					+ outTradeNo + "totalFee:" + totalFee + "spbillCreateIp:"
					+ spbillCreateIp + "attach:" + attach);
			// 调用支付接口返回支付jason
			String activedProfile = request.getSession().getServletContext()
					.getInitParameter("spring.profiles.active");
			if (activedProfile.equals("prod")) {// 生产环境
				json = wechatPayService.getPayJsRequestJsonNew(openid, body,
						outTradeNo, totalFee, spbillCreateIp, attach);
			} else {// 其他环境
				json = wechatPayService.getPayJsRequestJsonNew(openid, body,
						outTradeNo, "1", spbillCreateIp, attach);
			}
			jsonString.setObj(json);
			logger.info("getPayJson=openid+json====>" + openid + ":" + json);
			// 记录系统日志
			message = "OfflineWechatPay,openid:[" + openid + "]发起支付！";
			systemService.addLog(message, Globals.Log_Type_INSERT,
					Globals.Log_Leavel_INFO);

		}
		return jsonString;
	}

	/**
	 * 保费支付结果
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "showPayResult")
	public String showPayResult(HttpServletRequest request) {
		String resultType = request.getParameter("result");
		String orderno = request.getParameter("orderno");
		String msg = request.getParameter("msg");
		String openid = request.getParameter("openid");
		String appliName = request.getParameter("appliName");
		String appliIdentifyType = request.getParameter("appliIdentifyType");
		String appliIdentifyNumber = request
				.getParameter("appliIdentifyNumber");
		logger.info("showPayResult,orderno=>" + orderno + "\bresultType=>"
				+ resultType + "\bmsg=>" + msg);
		Policy policy = policyService.findUniqueByProperty(Policy.class,
				"orderno", orderno);
		if (resultType.equals("success")) {
			// 记录系统日志
			String message = "OfflineWechatPay,openid:[" + openid + "]支付成功！";
			systemService.addLog(message, Globals.Log_Type_INSERT,
					Globals.Log_Leavel_INFO);
			offlineWechatPayService.updOrderInfoByOrderIdAndStatus(orderno, 1);
			String status=policy.getStatus();
			if(StringUtil.isNotEmpty(status)&&TaiwanConstants.POLICYSTATUS_0.equals(status)){
				policy.setStatus(TaiwanConstants.POLICYSTATUS_1);
				policyService.updateEntitie(policy);
			}			
		   //是否为人工成功方式
		   String productId=policyService.get(Plan.class, policy.getPlanid()).getProductid();
		   String salemode= policyService.get(Product.class, productId).getSalemode();
			if("4".equals(salemode)){ //销售方式为4手工承保
				request.setAttribute("underwriting", "offline"); //离线承保	 
			}else{
				request.setAttribute("underwriting", "online");	 //在线承保	
			 }
			
			Boolean isbinded = customerBindService.isBinded(openid);
			if(isbinded){
				request.setAttribute("isbinded", "YES");
			}
			Customer applicant=policy.getApplicant();
			request.setAttribute("openid", openid);
			request.setAttribute("appliName", applicant.getName());
			request.setAttribute("appliIdentifyType", applicant.getIdentifytype());
			request.setAttribute("appliIdentifyNumber", applicant.getIdentifynumber());
			return "/fo/taitravel/payResult";
		} else {
			offlineWechatPayService.updOrderInfoByOrderIdAndStatus(orderno, 2);
			policy.setStatus(TaiwanConstants.POLICYSTATUS_3);
			request.setAttribute("message", "保费支付失败！" + msg);
			return "/fo/common/message";
		}

	}

	/**
	 * 支付失败结果处理
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(params = "goToPayResultfail")
	@ResponseBody
	public AjaxJson goToPayResultfail(HttpServletRequest request)
			throws Exception {
		AjaxJson jsonString = new AjaxJson();
		String orderno = request.getParameter("orderno"); // id
		String msg = request.getParameter("msg");
		String policystatus = "";
		if ("get_brand_wcpay_request:fail".trim().equals(msg.trim())) {
			policystatus = TaiwanConstants.POLICYSTATUS_3;
		}
		if ("get_brand_wcpay_request:cancel".trim().equals(msg.trim())) {
			policystatus = TaiwanConstants.POLICYSTATUS_4;
		}
		Policy policy = policyService.findUniqueByProperty(Policy.class,
				"orderno", orderno);
		policy.setStatus(policystatus);
		policyService.updateEntitie(policy);
		return jsonString;
	}

	/**
	 * 保存被保人和保单信息
	 * 
	 * @param req
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	// @ResponseBody
	@RequestMapping(params = "savePolicy")
	public String savePolicy(HttpServletRequest req)
			throws UnsupportedEncodingException {

		String insuredIdentifytype = req.getParameter("insuredIdentifytype"); //
		String insuredIdentifynumber = req
				.getParameter("insuredIdentifynumber"); //

		String schemetype = req.getParameter("schemetype"); //
		schemetype = java.net.URLDecoder.decode(schemetype, "UTF-8");
		String period = req.getParameter("period"); //
		period = java.net.URLDecoder.decode(period, "UTF-8");
		String premium = req.getParameter("premium"); //
		// String id = req.getParameter("id"); //
		String name = req.getParameter("name");
		String identifytype = req.getParameter("identifytype");
		String identifynumber = req.getParameter("identifynumber");
		String phone = req.getParameter("phone");
		String school = req.getParameter("school");
		String province = req.getParameter("province");
		String city = req.getParameter("city");
		String area = req.getParameter("area");
		String detail = req.getParameter("detail");

		String openid = "";

		String openidParameter = req.getParameter("openid");
		logger.info("根据code获取 openid,获取到的openid=>" + openid);
		String openidAttribute = (String) req.getAttribute("openid");
		if (StringUtil.isEmpty(openidParameter)) {
			openid = openidAttribute;
		} else {
			openid = openidParameter;
		}
		// StuPolicy stuPolicy =systemService.getEntity(StuPolicy.CLASS, id);
		StuPolicy stuPolicy = new StuPolicy();
		stuPolicy.setName(name);
		stuPolicy.setIdentifytype(identifytype);
		stuPolicy.setIdentifynumber(identifynumber);
		stuPolicy.setPhone(phone);
		stuPolicy.setCity(city);
		stuPolicy.setProvince(province);
		stuPolicy.setSchool(school);
		stuPolicy.setArea(area);
		stuPolicy.setDetail(detail);
		stuPolicy.setPaystatus("0");
		stuPolicy.setSchemetype(schemetype);
		stuPolicy.setPeriod(period);
		stuPolicy.setPremium(premium);
		stuPolicy.setOpenid(openid);
		stuPolicy.setCreatetime(new Date());
		stupolicyService.saveOrUpdate(stuPolicy);
		req.setAttribute("customerg", stuPolicy);
		req.setAttribute("id", stuPolicy.getId());
		req.setAttribute("insuredIdentifytype", insuredIdentifytype);
		req.setAttribute("insuredIdentifynumber", insuredIdentifynumber);
		req.setAttribute("schemetype", schemetype);
		req.setAttribute("period", period);
		req.setAttribute("openid", openid);
		req.setAttribute("premium", premium);

		return "fo/taitravel/taitraveldetail";
	}

	@RequestMapping(params = "prepareProposal")
	public String prepareProposal(HttpServletRequest request) {
		String openid = request.getParameter("openid");
		String orderno = request.getParameter("orderno");
		String productid=request.getParameter("productid");
		String productname=request.getParameter("productname");
		String planid=request.getParameter("planid");
		String planname=request.getParameter("planname");
		String period=request.getParameter("period");
		String premium=request.getParameter("premium");
		String insuranceAge=request.getParameter("insuranceAge");
		Policy policyPage = new Policy();
		//如果是重新支付
		if(!StringUtil.isEmpty(orderno)){
			Policy policyDB = policyService.getPolicyByOrderNo(orderno);
			try{
				MyBeanUtils.copyBean2Bean(policyPage,policyDB);
			}catch(Exception e){
				logger.error("repay failed by copy policyDB to policyPage",e);
			}
		}else{
			//认证信息用于自动填充投保人信息
			WeiXinGzUserInfo gzUserInfo = policyService.findUniqueByProperty(WeiXinGzUserInfo.class,"openid",openid);
			Customer applicant = new Customer();
			applicant.setName(gzUserInfo.getCustomercname());
			applicant.setIdentifynumber(gzUserInfo.getIdentifynumber());
			applicant.setPhone(gzUserInfo.getMobile());
			applicant.setBirthday(gzUserInfo.getCustomerBirthday());
			applicant.setGender(gzUserInfo.getCustomerSex());
			applicant.setIdentifytype(gzUserInfo.getIdentifyType());
			policyPage.setApplicant(applicant);
		}
		logger.info("进入商品填写页面========orderno====>"+orderno);		
		/*policy=policyService.findUniqueByProperty(Policy.class,
		"orderno", orderno);*/
		String paystatus = policyPage.getStatus();
		String ispaid = "";
		policyPage.setPeriod(period);
		policyPage.setPlanid(planid);
		policyPage.setPlanname(planname);
		policyPage.setPremium(Double.valueOf(premium));
		policyPage.setProductid(productid);
		policyPage.setProductname(productname);
		policyPage.setOpenid(openid);
		//查询产品参数，获取固定起保日期
		Date startDate = this.productService_fmps.getFixedStartDate(productid,planid);
		if(startDate != null){
			policyPage.setStartdate(startDate);
			//用于标记产品用固定的起保日期
			request.setAttribute("FIXED_STARTDATE",startDate);
		}

		if (StringUtil.isNotEmpty(paystatus)
				&& (TaiwanConstants.POLICYSTATUS_1.equals(paystatus) || TaiwanConstants.POLICYSTATUS_2
						.equals(paystatus))) {
			ispaid = "success";
		}	 
		request.setAttribute("TO_TAI", productService_fmps.getToTaiProductParameterValue(productid));		
		request.setAttribute("TO_TAI_Description", productService_fmps.getToTaiProductDescription(productid));		
		request.setAttribute("department", productService_fmps.getProductParameterValue(productid,"general","department"));
		
		String needMailingAddress = productService_fmps.getNeedMailingAddressProductParameterValue(productid);
		request.setAttribute("NEED_MAILING_ADDRESS", needMailingAddress);		
		//保单寄送方式
		//String productId=policyService.get(Plan.class, planid).getProductid();
		String delivery="";
		ProductDto  productDto=productService.findProductBaseInfo(productid) ;
	    Object delivery_int=productDto.getDelivery();
	    if(delivery_int!=null){
	    	delivery=String.valueOf(delivery_int);
	      }	
		if("2".equals(delivery)){ //保单寄送方式 2为电子保单
				request.setAttribute("delivery", "email"); 	 
			}else{
				request.setAttribute("delivery", "delivery"); 	
			} 
		Customer applicant = policyPage.getApplicant();
		List<Customer> insuredList = policyPage.getInsuredList();
		if (insuredList != null && insuredList.size() > 0) {
			Customer insured = policyPage.getInsuredList().get(0);
			request.setAttribute("insured", insured);
		}
		/*List<Map<String, Object>> provinceList = toTaiwanServiceImpl.loadProvinceList();
		request.setAttribute("provinceList", provinceList);*/
		request.setAttribute("ispaid", ispaid);
		request.setAttribute("applicant", applicant);
		request.setAttribute("policy", policyPage);
		request.setAttribute("insuranceAge", insuranceAge);
		return "/fo/taitravel/proposal";
	}

	/**
	 * 保存保单信息并发起微信支付
	 * 
	 * @param req
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Token(needRemoveToken = true)
	@RequestMapping(params = "proposal")
	@ResponseBody
	public AjaxJson proposal(HttpServletRequest req) {
		AjaxJson jsonString = new AjaxJson();
		Map<String, Object> proposalMap = req.getParameterMap();
		Map<String, String> params = new HashMap<String, String>();
		for (Iterator<String> iter = proposalMap.keySet().iterator(); iter
				.hasNext();) {
			String name = (String) iter.next();
			String[] values = (String[]) proposalMap.get(name);
			String valueStr = "";
			for (int i = 0; i < values.length; i++) {
				valueStr = (i == values.length - 1) ? valueStr + values[i]
						: valueStr + values[i] + ",";
			}
			params.put(name, valueStr);
		}
		String orderno = params.get("orderno");
		
		JDateTime startdate = new JDateTime(params.get("startDate"));
		JDateTime now = new JDateTime();
		if (startdate.convertToDate().before(now.convertToDate())) {
			jsonString.setSuccess(false);
			jsonString.setMsg("起保日期必须晚于当前日期");
			return jsonString;
		}
		Policy policy = policyService.findUniqueByProperty(Policy.class,
				"orderno", orderno);
		if (policy == null) {
			policy = new Policy();
			orderno = UUIDGenerator.generate();
		}
		logger.info("进入提交支付下单=======orderno====>"+orderno);		
		String openid = params.get("openid");
		String huodongid = params.get("huodongid");
		Customer applicant = new Customer();
		applicant.setName(params.get("appliName"));
		applicant.setIdentifytype(params.get("appliIdentifyType"));
		applicant.setIdentifynumber(params.get("appliIdentifyNumber"));
		applicant = getCustomer(applicant);
		applicant.setPhone(params.get("appliPhone"));
		applicant.setGender(params.get("appliGender"));
		applicant.setSchool(params.get("applischool"));
		applicant.setDepartment(params.get("applidepartment"));
		applicant.setStudentNo(params.get("applistudentNo"));
		applicant.setAddress(params.get("applicantAddress"));
		applicant.setEmail(params.get("applicantEmail"));
		JDateTime appliBirthday = new JDateTime(params.get("appliBirthday"));
		applicant.setBirthday(appliBirthday.convertToDate());
		customerService.saveOrUpdate(applicant);
		String insuredIdentity = params.get("insuredIdentity");
		ArrayList<Customer> insuredList = new ArrayList<Customer>();
		PolicyInsured policyInsured = policyInsuredService
				.findUniqueByProperty(PolicyInsured.class, "orderno", orderno);
		if (policyInsured == null) {
			policyInsured = new PolicyInsured();
			policyInsured.setOrderno(orderno);
		}
		if (StringUtil.isNotEmpty(insuredIdentity)
				&& TaiwanConstants.INSUREDIDENTITYFLAG_01
						.equals(insuredIdentity)) {
			insuredList.add(applicant);
			policyInsured.setIdentity(TaiwanConstants.INSUREDIDENTITYFLAG_01);
			policyInsured.setCustomer(applicant);
		} else {
			Customer insured = new Customer();
			insured.setName(params.get("insuredName"));
			insured.setIdentifytype(params.get("insuredIdentifyType"));
			insured.setIdentifynumber(params.get("insuredIdentifyNumber"));
			insured = this.getCustomer(insured);
			insured.setPhone(params.get("insuredPhone"));
			insured.setGender(params.get("insuredGender"));
			insured.setAddress(params.get("insuredAddress"));
			insured.setSchool(params.get("insuredSchool"));//保存被保险人学校			
			insured.setDepartment(params.get("insureddepartment"));//保存被保险人院系
			insured.setStudentNo(params.get("insuredstudentNo"));//保存被保险人学号			
			insured.setEmail(params.get("insuredEmail")); 
			JDateTime insuredBirthday = new JDateTime(
					params.get("insuredBirthday"));
			insured.setBirthday(insuredBirthday.convertToDate());
			customerService.saveOrUpdate(insured);
			insuredList.add(insured);
			policyInsured.setIdentity(params.get("insuredIdentity"));
			policyInsured.setCustomer(insured);
		}
		policyInsuredService.saveOrUpdate(policyInsured);
		policy.setOrderno(orderno);
		policy.setPlanid(params.get("planid"));
		policy.setCreatetime(new Date());
		policy.setOpenid(openid);
		//外键不能是空字符串，可以为Null
		policy.setHuodongId(StringUtil.isEmpty(huodongid)?null:huodongid);
		policy.setApplicant(applicant);
		policy.setInsuredidentity(insuredIdentity);
		policy.setInsuredList(insuredList);
		policy.setPremium(Double.valueOf(params.get("premium")));
		policy.setStartdate(startdate.convertToDate());
		JDateTime endDate = new JDateTime();
		String periodStr = params.get("period");
		int period = Integer.parseInt(periodStr.replaceAll("\\D", ""));
		if (periodStr.endsWith("年")) {
			// 取保期的数字
			endDate = startdate.addYear(period);
		} else if (periodStr.endsWith("月")) {
			// 取保期的数字
			endDate = startdate.addMonth(period);
		} else if (periodStr.endsWith("日")) {
			// 取保期的数字
			endDate = startdate.addDay(period);
		}
		endDate=startdate.addDay(-1);
		policy.setEnddate(endDate.convertToDate());
		policy.setIsbeneficiary(params.get("isBeneficiary"));
		policy.setType(Constants.TYPE_POLICY_1);
		policy.setProductid(params.get("productid"));
		policy.setProductname(params.get("productname"));
		policy.setPlanname(params.get("planname"));
		policy.setStatus(TaiwanConstants.POLICYSTATUS_0);
		policy.setPeriod(periodStr);
		policy.setPaytime(new Date());
		policyService.saveOrUpdate(policy);
		String json = "";
		String spbillCreateIp = IpUtil.getPayIpAddr(req);
		// 总费用处理 取分
		int totalFeeTemp = (int) (Double.valueOf(params.get("premium")) * 100);
		String totalFee = totalFeeTemp + "";
		String body = params.get("productname") + "(" + params.get("planname")
				+ "," + periodStr + ")";
		String attach = "TaiPay" + "," + orderno + ","
				+ params.get("appliName") + params.get("appliPhone");
		logger.info("openid=" + openid + ",productname="
				+ params.get("productname") + ",orderno=" + orderno
				+ ",spbillCreateIp=" + spbillCreateIp + ",attach=" + attach
				+ ",body=" + body);
		String activedProfile = req.getSession().getServletContext()
				.getInitParameter("spring.profiles.active");
		logger.info("微信支付下单前========orderno=======>"+orderno);
		if (activedProfile.equals("prod")) {// 生产环境
			json = wechatPayService.getPayJsRequestJsonNew(openid, body, orderno,
					totalFee, spbillCreateIp, attach);
		} else {// 其他环境
			json = wechatPayService.getPayJsRequestJsonNew(openid, body, orderno,
					"1", spbillCreateIp, attach);
		}
		jsonString.setObj(json);
		Map<String, Object> orderMap = new HashMap<String,Object>();
		orderMap.put("orderno",orderno);
		jsonString.setAttributes(orderMap);
		logger.info("getPayJson=" + json);
		// 记录系统日志
		String message = "OfflineWechatPay,openid:[" + openid + "]发起支付！";
		systemService.addLog(message, Globals.Log_Type_INSERT,
				Globals.Log_Leavel_INFO);
		jsonString.setSuccess(true);
		return jsonString;
	}

	/**
	 * 个人中心-进入订单
	 * 
	 * @param request
	 * @param dataGrid
	 * @return
	 */
	@RequestMapping(params = "index")
	public String orderIndex(HttpServletRequest request, DataGrid dataGrid) {
		String openid = (String) request.getAttribute("openid");
		if (StringUtil.isEmpty(openid)) {
			openid = request.getParameter("openid");
		}
//		List<Map<String, Object>> unpaidPolicyList = toTaiwanServiceImpl
//				.getunPaidPolicyList(openid);
//		request.setAttribute("unpaidPolicyList", unpaidPolicyList);
		request.setAttribute("openid", openid);
		return "/fo/personalcenter/order";
	}

	@RequestMapping(params = "pay")
	@ResponseBody
	public AjaxJson pay(HttpServletRequest req) {
		AjaxJson jsonString = new AjaxJson();
		String orderno = req.getParameter("orderno");
		String openid = req.getParameter("openid");
		Policy policy = policyService.findUniqueByProperty(Policy.class,
				"orderno", orderno);
		Date startDate = policy.getStartdate();
		JDateTime now = new JDateTime();
		if (startDate.before(now.convertToDate())) {
			jsonString.setSuccess(false);
			jsonString.setMsg("起保日期必须晚于当前日期,请到投保页面修改起保日期");
			return jsonString;
		}
		String json = "";
		String spbillCreateIp = IpUtil.getPayIpAddr(req);
		// 总费用处理 取分
		int totalFeeTemp = (int) (policy.getPremium() * 100);
		String totalFee = totalFeeTemp + "";
		String body = policy.getProductname() + "(" + policy.getPlanname()
				+ "," + policy.getPeriod() + ")";
		String attach = "TaiPay" + "," + orderno + ","
				+ policy.getApplicant().getName()
				+ policy.getApplicant().getPhone();
		logger.info("openid=" + openid + ",productname="
				+ policy.getProductname() + ",orderno=" + orderno
				+ ",spbillCreateIp=" + spbillCreateIp + ",attach=" + attach
				+ ",body=" + body);
		String activedProfile = req.getSession().getServletContext()
				.getInitParameter("spring.profiles.active");
		if (activedProfile.equals("prod")) {// 生产环境
			json = wechatPayService.getPayJsRequestJson(openid, body, orderno,
					totalFee, spbillCreateIp, attach);
		} else {// 其他环境
			json = wechatPayService.getPayJsRequestJson(openid, body, orderno,
					"1", spbillCreateIp, attach);
		}
		jsonString.setObj(json);
		logger.info("getPayJson=" + json);
		// 记录系统日志
		String message = "OfflineWechatPay,openid:[" + openid + "]发起支付！";
		systemService.addLog(message, Globals.Log_Type_INSERT,
				Globals.Log_Leavel_INFO);
		jsonString.setSuccess(true);
		return jsonString;
	}

	private Customer getCustomer(Customer customer) {
		CriteriaQuery cq = new CriteriaQuery(Customer.class);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq,
				customer);
		cq.add();
		List<Customer> customerList = customerService.getListByCriteriaQuery(
				cq, true);
		if (customerList.size() > 0) {
			customer = customerList.get(0);
		}
		return customer;
	}
}
