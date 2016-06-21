/**
 * 
 */
package cn.com.fubon.fo.totaiwan.controller;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import jodd.datetime.JDateTime;
import net.sf.json.JSONObject;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import weixin.guanjia.account.service.WeixinAccountServiceI;
import cn.com.fubon.emarketing.api.product.service.ProductService;
import cn.com.fubon.emarketing.product.dto.ProductDto;
import cn.com.fubon.fo.card.entity.Policy;
import cn.com.fubon.fo.card.service.IPolicyService;
import cn.com.fubon.fo.customerbind.entity.WeiXinGzUserInfo;
import cn.com.fubon.fo.totaiwan.service.ToTaiwanService;
import cn.com.fubon.product.entity.Affiliated;
import cn.com.fubon.product.service.IAddressCodeService;
import cn.com.fubon.product.service.IPlanService;
import cn.com.fubon.rest.entity.response.ProductResponse;
import cn.com.fubon.rest.service.ProductWSService;
import cn.com.fubon.util.Constants;

/**
 * 赴台专区（新版）
 * 
 * @author qingqu.huang
 * @date 2015-11-12
 */
@Scope("prototype")
@Controller
@RequestMapping("/fo/taiwanController")
public class TaiwanController {
	private static final Logger logger = Logger
			.getLogger(TaiwanController.class);
	@Resource
	private ProductWSService productWSServiceImpl;
	@Resource
	private ToTaiwanService toTaiwanServiceImpl;
	@Resource
	private WeixinAccountServiceI weixinAccountService;
	@Resource
	private IAddressCodeService addressCodeService;
	@Resource
	private IPlanService iPlanService;
	@Resource
	private IPolicyService policyService;
	
	@Autowired
	private ProductService productService;	

	//销售方式：微信
	private static final String SALEMODE = "2";
	//指定的产品代码：ft0001
	private static final String[] INTERNALCODES = {"ft0001","X00001"};
	

	/**
	 * 进入赴台专区首页
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "index")
	public String index(HttpServletRequest request) {
		String openid = (String) request.getAttribute("openid");
		String hasUnpaidPolicy = "FALSE";		
		if (StringUtil.isEmpty(openid)) {
			openid = request.getParameter("openid");
		}
		List<Map<String, Object>> unpaidPolicyList = toTaiwanServiceImpl
				.getunPaidPolicyList(openid,1);
		if (unpaidPolicyList.size() > 0) {
			hasUnpaidPolicy = "YES";
		}
		//销售方式是微信，且产品代码是哪几个（表示赴台的）
		List<Map<String, Object>> productList = toTaiwanServiceImpl
				.findProductList(SALEMODE,INTERNALCODES);
		request.setAttribute("hasUnpaidPolicy", hasUnpaidPolicy);
		request.setAttribute("productList", productList);
		return "fo/taitravel/index";
	}

	/**
	 * 进入商品首页
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "showProduct")
	public String showProduct(HttpServletRequest request) {
		String openid = request.getParameter("openid");
		if(StringUtil.isEmpty(openid)){
			openid = (String)request.getSession().getAttribute(Constants.SESSION_KEY_OPENID);
		}
		
		String productid = request.getParameter("productid");
		String orderno=request.getParameter("orderno");
		logger.info("进入投保专区商品首页===orderno====>"+orderno);
		if(StringUtil.isNotEmpty(orderno)){
			Policy policy =policyService.findUniqueByProperty(Policy.class,"orderno", orderno);
			request.setAttribute("planname",policy.getPlanname());
			request.setAttribute("period", policy.getPeriod());
			productid=policy.getProductid();
		logger.info("进入投保专区商品首页=已有订单号查询==productid====>"+productid);
		}
		
        /*
		ProductResponse productResponse = new ProductResponse();
		Map<String, Object> productMap = productWSServiceImpl
				.findProduct(productid);
		if (productMap == null) {
			request.setAttribute("message", "没有查到响应的商品信息");
			return "/fo/common/message";
		}
		try {
			BeanUtils.populate(productResponse, productMap);
		} catch (IllegalAccessException | InvocationTargetException e) {
			logger.error("商品map转换成对象失败..", e);
			request.setAttribute("message", "获取商品信息异常，请稍后再试...");
			return "/fo/common/message";
		}
		DecimalFormat df = new DecimalFormat("######0.00");
		BigDecimal minpremium = (BigDecimal) productMap.get("minpremium");
		BigDecimal maxpremium = (BigDecimal) productMap.get("maxpremium");
		productResponse.setMinpremium(minpremium.toString());
		productResponse.setMaxpremium(maxpremium.toString());
		List<Map<String, Object>> plannameList = productWSServiceImpl
				.findPlanNameList(productid);
		productResponse.setPlannameList(plannameList);
		List<Map<String, Object>> premiumList = productWSServiceImpl
				.findPlanList(productid);
		productResponse.setPremiumList(premiumList);
		JSONObject product = JSONObject.fromObject(productResponse);*/
		//****************************			
		ProductDto  productDto=productService.findProductBaseInfo(productid);//8a828ec655518b8b015551c2399d0001
		JSONObject product = JSONObject.fromObject(productDto);		
		//****************************		
		request.setAttribute("productid", productid);
		request.setAttribute("openid", openid);
		request.setAttribute("product", product);		
		request.setAttribute("orderno", orderno);
		return "/fo/taitravel/product";
	}

	/**
	 * 获取商品详情
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "details")
	@ResponseBody
	public String details(HttpServletRequest request) {
		String productid = request.getParameter("productid");
		String afftype = request.getParameter("afftype");
		String content = "";		
		/*Map<String, Object> productMap = productWSServiceImpl.findProduct(
				afftype, productid);
		if (productMap != null) {
			content = String.valueOf(productMap.get("content"));
			logger.info("details content=>" + content);
		}*/
		if(afftype.equals("4")){
		content=productService.findProductDetails(productid);
		}else{
			content=productService.findProductFAQ(productid);	
		}
		
		return content;
	}

	@RequestMapping(params = "loadCityList")
	@ResponseBody
	public AjaxJson loadCityList(HttpServletRequest request) {
		AjaxJson ajaxJson = new AjaxJson();
		String provinceCode = request.getParameter("provinceCode");
		List<Map<String, Object>> cityList = toTaiwanServiceImpl
				.loadCityList(provinceCode);
		ajaxJson.setObj(cityList);
		return ajaxJson;
	}

	@RequestMapping(params = "loadCountyList")
	@ResponseBody
	public AjaxJson loadCountyList(HttpServletRequest request) {
		AjaxJson ajaxJson = new AjaxJson();
		String cityCode = request.getParameter("cityCode");
		List<Map<String, Object>> countyList = toTaiwanServiceImpl
				.loadCounty(cityCode);
		ajaxJson.setObj(countyList);
		return ajaxJson;
	}

	@RequestMapping(params = "customerbind")
	@ResponseBody
	public AjaxJson customerbind(HttpServletRequest request) {
		AjaxJson ajaxJson = new AjaxJson();
		String openid = request.getParameter("openid");
		String appliName = request.getParameter("appliName");
		String appliIdentifyType = request.getParameter("appliIdentifyType");
		String appliIdentifyNumber = request
				.getParameter("appliIdentifyNumber");
		WeiXinGzUserInfo userInfo = toTaiwanServiceImpl.findUniqueByProperty(
				WeiXinGzUserInfo.class, "openid", openid);
		if (userInfo != null && StringUtil.isEmpty(userInfo.getCustomercname())) {
			userInfo.setCustomercname(appliName);
			userInfo.setIdentifyType(appliIdentifyType);
			userInfo.setIdentifynumber(appliIdentifyNumber);
			JDateTime bindDate = new JDateTime();
			userInfo.setBindTime(bindDate.convertToDate());
			toTaiwanServiceImpl.updateEntitie(userInfo);
			ajaxJson.setSuccess(true);
		}
		return ajaxJson;
	}

	@RequestMapping(params = "showArticle")
	public String showArticle(HttpServletRequest request) {
		String productid = request.getParameter("productid");
		String planid = request.getParameter("planid");
		
	    /*List<Map<String, Object>> affiliated = addressCodeService.findArticleListByProductid(productid);
		List<Affiliated> affiliatedList = new ArrayList<Affiliated>();
		for (int i = 0; i < affiliated.size(); i++) {
			Affiliated affiliatedd = new Affiliated();
			affiliatedd.setDescription((String) affiliated.get(i).get(
					"description"));
			affiliatedd.setDocument((String) affiliated.get(i).get("document"));
			affiliatedList.add(affiliatedd);
		}*/		
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
