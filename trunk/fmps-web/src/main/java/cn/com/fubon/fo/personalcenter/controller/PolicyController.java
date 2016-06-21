package cn.com.fubon.fo.personalcenter.controller;

import java.math.BigDecimal;
import java.net.SocketException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import jodd.datetime.JDateTime;
import jodd.typeconverter.impl.JDateTimeConverter;

import org.apache.commons.lang.math.RandomUtils;
import org.apache.log4j.Logger;
import org.jeecgframework.core.util.IdcardUtils;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.core.util.oConvertUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import weixin.idea.huodong.entity.HuodongEntity;
import weixin.idea.huodong.service.HuodongService;
import cn.com.fubon.fo.cashcoupon.entity.CashCoupon;
import cn.com.fubon.fo.customerbind.entity.WeiXinGzUserInfo;
import cn.com.fubon.fo.personalcenter.entity.WeixinPolicyClauseReading;
import cn.com.fubon.fo.personalcenter.service.PolicyService;
import cn.com.fubon.pay.service.TelesaleWebService;
import cn.com.fubon.util.CachedUtils;
import cn.com.fubon.util.Constants;

/**
 * 个人中心改版--保单相关控制器
 * @author fangfang.guo
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/fo/binded/personalCenter/policyController")
public class PolicyController {
	private static final Logger logger = Logger.getLogger(PolicyController.class);
	
	@Resource(name="PolicyService")
	private PolicyService policyService;	
	@Resource
	private HuodongService huodongService;
	
	@Resource
	private TelesaleWebService telesaleWebService;
	
	/**
	 * 进入保单首页(新)
	 * @author fangfang.guo 20150727
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "method=Index")
	public String policyIndex(HttpServletRequest request) {
		// openid通过拦截器中的attribute传入
		String openid = (String) request.getAttribute("openid");
		if (StringUtil.isEmpty(openid)) {
			openid = request.getParameter("openid");
		}

		//如果openid还是空,就给到提示信息页
		if(StringUtil.isEmpty(openid)){
			request.setAttribute("message", Constants.PERSONALCENTER_MESSAGE_OPENID_IS_NULL);
			return "/fo/common/message";
		}
		
		//从memcache获取证件号码和客户姓名
		String identifyNumber = (String)CachedUtils.get(openid + Constants.MEMKEY_IDENTIFYNUMBER);
		String customerCname = (String)CachedUtils.get(openid + Constants.MEMKEY_CUSTOMERCNAME);
		
		if(StringUtil.isEmpty(identifyNumber) || StringUtil.isEmpty(customerCname)){
			WeiXinGzUserInfo weiXinGzUserInfo = policyService
					.findUniqueByProperty(WeiXinGzUserInfo.class, "openid",
							openid);
			identifyNumber = weiXinGzUserInfo.getIdentifynumber();
			customerCname = weiXinGzUserInfo.getCustomercname();
		}
		//查询mysql中的表单
		List<Map<String, Object>> policysMysql = policyService.findAllPolicys(openid);
		List<Map<String, Object>> policys = new ArrayList<Map<String, Object>>();
		String policyNoStr = null;
		String[] mySqlPolicyNoArr = null;
		if(policysMysql !=null && policysMysql.size() > 0){
			for(int i=0;i<policysMysql.size();i++){
				if(StringUtil.isNotEmpty(policysMysql.get(i).get("policyno"))){
					if(i==0)
						policyNoStr = (String) policysMysql.get(i).get("policyno");
					else
						policyNoStr += ","+(String) policysMysql.get(i).get("policyno");
					mySqlPolicyNoArr= policyNoStr.split(",");
				}
			}
			policys.addAll(policysMysql);
		}
		String telesaledate= Constants.READ_CLAUSE_RULE_DATE;
		String telesalechanne= Constants.TELESALE_CHANNEL;
		List policysOracle = policyService.findAllPolicys(identifyNumber,customerCname,mySqlPolicyNoArr,telesaledate,telesalechanne);
		if(policysOracle !=null && policysOracle.size() > 0){
				Object[] polist = policysOracle.toArray();
				for (Object policy : polist) {
					Map<String, Object> map = new HashMap<String, Object>();
					Object[] os = (Object[]) policy;
					map.put("policyno", os[0]);
					map.put("licenseno", os[1]);
					map.put("riskshortname", os[2]);
					map.put("policyname", os[3]);
					map.put("enddate", os[4]);
					map.put("endhour", os[5]);
					map.put("operatedate", os[6]);
					map.put("operateyear", os[7]);
					map.put("status", os[8]);
					map.put("m", os[9]);
					map.put("telesalepolicy", os[10]);
					map.put("productcode", os[11]);
					policys.add(map);
				}
		}
		
		
		//投保年份排序
		Comparator<Map<String, Object>> comparator = new Comparator<Map<String, Object>>(){
			public int compare(Map<String, Object> map1,Map<String, Object> map2){
				return map2.get("operateyear").toString().compareTo(map1.get("operateyear").toString());
			}
		};
		Collections.sort(policys,comparator);
		//保单首页按投保年份分段
		String currentOperateYear = null;
		List<Map<String, Object>> policysPage = new ArrayList<Map<String, Object>>();
		for(Map<String, Object> policy : policys){
			String tempOperateYear = null;
			if (currentOperateYear == null) {
				tempOperateYear = (String)policy.get("operateyear");
				currentOperateYear = tempOperateYear;
			} else {
				if (!currentOperateYear.equals((String)policy.get("operateyear"))) {
					tempOperateYear = (String)policy.get("operateyear");
					currentOperateYear = tempOperateYear;
				}
			}
			//电销红包
			/**
			 * 判断是否符合电销领红包需求，符合就显示领红包页面
			 */
//			if (policy.get("telesalepolicy").toString().equalsIgnoreCase("1")){
//				List<Map<String, Object>> clauseList = policyService.findClauseByCoreProductCode(policy.get("productcode").toString());
//				Map<String,Object> policyClause = policyService.findPolicyClauseReadByPolicyNo(policy.get("policyno").toString());
//				//条款为空或者已领红包则不显示图片
//				if (clauseList.isEmpty()||policyClause!=null){
//					policy.put("telesalepolicy", "0");
//				}
//			}
			policy.put("tempOperateYear", tempOperateYear);
			policysPage.add(policy);
			
			
		}
		
		logger.info("personalcenter policy openid =>" + openid);
		request.setAttribute("openid", openid);
		request.setAttribute("policys", policysPage);

		return "/fo/personalcenter/policyindex";

	}
	
	/**
	 * 进入保单详细页(新)
	 * @author fangfang.guo 20150727
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "method=Detail")
	public String policyDetail(HttpServletRequest request) {
		
		// openid通过拦截器中的attribute传入
		String openid = (String) request.getAttribute("openid");
		if (StringUtil.isEmpty(openid)) {
			openid = request.getParameter("openid");
		}
				
		String policyno = request.getParameter("policyno");
		
		//如果policyno是空,就给到提示信息页
		if(StringUtil.isEmpty(policyno)){
			request.setAttribute("message", "无效的保单号");
			return "/fo/common/message";
		}
		
		boolean isCar = false;
		//805012015000001000046,车险保单号长度21,保险卡保单长度是17,8开头,险类是05
		if(policyno.length() == Constants.CORE_CAR_POLICY_LENGTH && Constants.CORE_CAR_CLASSCODE.equals(policyno.substring(1, 3))){
			isCar = true;
		}
		
		//保单头信息
		Map<String,String> policyHead = policyService.findPolicyDetailHead(policyno,isCar);
		//保单体信息  车险包括:险种名称,不计免赔,保额,费用;非车包括:险种名称,保障信息,保额
		List<Map<String,String>> policyBodys = policyService.findPolicyDetailBody(policyno,isCar);
		
		String currentIdentifyNumber = (String)CachedUtils.get(openid + Constants.MEMKEY_IDENTIFYNUMBER);
		String currentCustomerCname = (String)CachedUtils.get(openid + Constants.MEMKEY_CUSTOMERCNAME);
		
		if(StringUtils.isEmpty(currentIdentifyNumber) || StringUtils.isEmpty(currentCustomerCname)){
			WeiXinGzUserInfo weiXinGzUserInfo = policyService.findUniqueByProperty(WeiXinGzUserInfo.class, "openid", openid);
			currentIdentifyNumber = weiXinGzUserInfo.getIdentifynumber();
			currentCustomerCname = weiXinGzUserInfo.getCustomercname();
		}
		
		//车险,是否上牌要排除Mysql已上牌的车辆weixin_newcar_licenseno
		//如果oracle中为未上牌,且mysql中无已上牌记录则显示"新车上牌"链接
		if(isCar && Constants.CAR_NOT_LICENSED.equals(policyHead.get("oraclelicensed"))){
			
			//查询在mysql已上牌的车架号集合
			String sql ="select li.frameno from weixin_newcar_licenseno li where li.identifynumber=? and li.customercname=? ";
			List<Map<String, Object>> licensedFrameNoList = policyService.findForJdbc(sql, currentIdentifyNumber, currentCustomerCname);
			
			Map<String,Object> currFramenoMap = new HashMap<String,Object>();
			currFramenoMap.put("frameno", policyHead.get("frameno"));
			if(!licensedFrameNoList.contains(currFramenoMap)){
				policyHead.put("licensed","0");// 是否上牌 1已上牌
			}
		}
		
		//证件号码加密
		String identifynumber = policyHead.get("identifynumber");
		if(!StringUtil.isEmpty(identifynumber)){
			
			identifynumber = IdcardUtils.getEncryptionIdentifyNum(identifynumber);
			policyHead.put("identifynumber", identifynumber);
		}
		
		//被保险人可能有多个,由于认证客户本人要么是投保人要么是被保险人,如果投保人不是本人,那就把被保险人的名称和证件号码置成本人 20150824
		String applyName = policyHead.get("applyname");
		String insuredName = policyHead.get("insuredname");
		if(!currentCustomerCname.equalsIgnoreCase(applyName)
				&& !currentCustomerCname.equalsIgnoreCase(insuredName)){
			policyHead.put("identifynumber", IdcardUtils.getEncryptionIdentifyNum(currentIdentifyNumber));
			policyHead.put("insuredname", currentCustomerCname);
		}
		
		
		request.setAttribute("policyHead", policyHead);
		request.setAttribute("policyBodys", policyBodys);
		if(!isCar){
			boolean isRod=isRangeOfDate(Constants.TELESALE_READ_CLAUSE_huodongid);
			if (isRod){
				String date =Constants.READ_CLAUSE_RULE_DATE;
				String channel=Constants.TELESALE_CHANNEL;
				//符合电销渠道的保单信息
				Map<String,Object> policyInfo = policyService.findPolicyByTeleSale(policyno,date,channel);
				//该保单是否已经读取条款
				Map<String,Object> policyClause = policyService.findPolicyClauseReadByPolicyNo(policyno);
			
				//符合电销保单
				if (policyInfo!=null){
					Boolean isOutOfDay=ifOutOfDay(policyInfo);
					List<Map<String, Object>> clauseList = policyService.findClauseByCoreProductCode(policyInfo.get("productcode").toString());
					//符合有关联条款，保单未过去，未阅读
					if (!clauseList.isEmpty()&&!isOutOfDay&&policyClause==null){
						request.setAttribute("productcode", policyInfo.get("productcode"));
						request.setAttribute("hasUnReadClause", "YES");
					}
					//符合有关联条款，保单未过去，已阅读
					if (!clauseList.isEmpty()&&!isOutOfDay&&policyClause!=null){
						request.setAttribute("productcode", policyInfo.get("productcode"));
						request.setAttribute("hasUnReadClause", "NO");
					}
				}
			}
		}
		
		return isCar ? "/fo/personalcenter/carpolicydetail" : "/fo/personalcenter/notcarpolicydetail";
		
	}
	/**
	 * 判断保单是否过期
	 * @param policyInfo
	 * @return
	 */
	private Boolean ifOutOfDay(Map<String, Object> policyInfo) {
		Date enddate = null;
		Boolean isoutOfDay = true;
		Timestamp ts =(Timestamp)policyInfo.get("enddate");  
		enddate =	new Date(ts.getTime());
		Date nowdate = new Date();
		if (enddate.after(nowdate)){
			isoutOfDay =false;
		}
		return isoutOfDay;
	}
	
	/**
	 * 满足电信渠道非车商品跳转到条款页面
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "method=goClause")
	public String goClause(HttpServletRequest request) {
		
		// openid通过拦截器中的attribute传入
		String openid = (String) request.getAttribute("openid");
		if (StringUtil.isEmpty(openid)) {
			openid = request.getParameter("openid");
		}
				
		String policyno = request.getParameter("policyno");
		
		//如果policyno是空,就给到提示信息页
		if(StringUtil.isEmpty(policyno)){
			request.setAttribute("message", "无效的保单号");
			return "/fo/common/message";
		}
		
		//根据核心商品代码获取对应的条款
		String productcode = request.getParameter("productcode");//"27650901";
		String hasUnReadClause= request.getParameter("hasUnReadClause");
		List<Map<String, Object>> clauseList = policyService.findClauseByCoreProductCode(productcode);
		WeixinPolicyClauseReading weixinPolicyClauseReading = policyService
				.findUniqueByProperty(WeixinPolicyClauseReading.class, "policyNo",
						policyno);
		if(weixinPolicyClauseReading!=null){
			DateFormat format2= new SimpleDateFormat("yyyy年MM月dd日 HH时mm分"); 
			String readtime=format2.format(weixinPolicyClauseReading.getCreateTime());
			request.setAttribute("readtime", readtime);
		}
		request.setAttribute("clauseList", clauseList);
		request.setAttribute("productcode", productcode);
		request.setAttribute("policyno", policyno);
		request.setAttribute("openid", openid);
		request.setAttribute("hasUnReadClause", hasUnReadClause);
		return "/fo/personalcenter/policyclause";
		
	}
	
	/**
	 * 满足电信渠道非车商品跳转到条款页面
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "method=clauseDetail")
	public String clauseDetail(HttpServletRequest request) {
		
		// openid通过拦截器中的attribute传入
		String openid = (String) request.getAttribute("openid");
		if (StringUtil.isEmpty(openid)) {
			openid = request.getParameter("openid");
		}				
		String policyno = request.getParameter("policyno");
		
		//如果policyno是空,就给到提示信息页
		if(StringUtil.isEmpty(policyno)){
			request.setAttribute("message", "无效的保单号");
			return "/fo/common/message";
		}
		//根据条款id获取对应的条款
		String afid=request.getParameter("afid");
		Map<String, Object> policyInfo = policyService.findAffiliatedById(afid);
		request.setAttribute("document", policyInfo.get("document"));
		return "/fo/personalcenter/policyclausedetail";
		
	}
	
	@RequestMapping(params = "method=cashcoupon")
	public String cashcoupon(HttpServletRequest request) {		
		   String openid = (String) request.getAttribute("openid");
			if (StringUtil.isEmpty(openid)) {
				openid = request.getParameter("openid");
			}				
			String policyno = request.getParameter("policyno");			
			if(StringUtil.isEmpty(policyno)){
				request.setAttribute("message", "无效的保单号");
				return "/fo/common/message";
		}
	   logger.info("用户进入阅读条款领红包页面===openid==>" + openid+",policyno:"+policyno);		 	   
       List<WeixinPolicyClauseReading> weixinPolicyClauseReadingList=policyService.findByProperty(WeixinPolicyClauseReading.class, "policyNo", policyno);
	  //判断用户是否已经领过红包       
       if(weixinPolicyClauseReadingList.size()>0){ //此保单红包已经被领取 
    	 //领取过显示已领结果
    	   logger.info("用户进入阅读条款领红包页面,此保单已经领取过红包了===openid==>" + openid+",policyno:"+policyno);	  
    	   request.setAttribute("cashCoupon", weixinPolicyClauseReadingList.get(0).getCashcouponId().getAmount()/100);
       
       }else {
    	 //未领过，计算红包金额，保存红包记录，保存领取记录  
         BigDecimal premium=policyService.getSumPremium(policyno);
         
         
      	 logger.info("用户进入阅读条款领红包页面,查询oracle数据库===premium==>" + premium); 
      	BigDecimal cashCoupon=this.calculateCashCoupon(premium);      
        boolean isSuccessful=policyService.saveCashCouponAndClauseReadingRecord( Constants.TELESALE_READ_CLAUSE_huodongid, openid, policyno,cashCoupon);	 
        request.setAttribute("cashCoupon", cashCoupon.divide(new BigDecimal("100")));
        if(!isSuccessful){
    	   request.setAttribute("message", "领取红包出现错误，请稍后再试.");
		   return "/fo/common/message";  
         } else { //发送红包领取消息给电销
        	 telesaleWebService.sendMessageToTelesale(policyno, "1", "1", "0"  /*cashCoupon.divide(new BigDecimal("100")).toString()*/); 
          }
    	   
       }
        request.setAttribute("openid", openid);
		//return "/fo/personalcenter/cashcoupon";
		return "redirect:/fo/binded/personalCenter/policyController.do?method=Index&openid=" + openid;
		
	}
	
	       /**
	       * 这个方法计算后返回的红包金额为分
	       */
	 private  BigDecimal calculateCashCoupon(BigDecimal premium){
		 int randomAmount= RandomUtils.nextInt(100) ; //取100之内的随机整数 
		 int fixedAmount=100; //单位为分 
		//也就是说compareTo()比较的是二者的值是否相等，不考虑精确度，返回值0表示相等，-1表示小于，1表示大于。
         if(premium.compareTo(new BigDecimal(1500))>0){
        	 fixedAmount=1800; 
         } else if (premium.compareTo(new BigDecimal(1000))>0){
        	 fixedAmount=800;
         }else if (premium.compareTo(new BigDecimal(500))>0){
        	 fixedAmount=500;
         }else if (premium.compareTo(new BigDecimal(300))>0){
        	 fixedAmount=200;
         }	
         logger.info("用户进入阅读条款领红包页面,计算红包金额===保费为==>" + premium+",计算后红包金额为:"+(fixedAmount+randomAmount)+"分");	
		 return new BigDecimal (fixedAmount+randomAmount);		 
	 } 
	 
	
	 //判断是否在活动期间内
		private   boolean isRangeOfDate(String  huodongid) {
			SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String startTime=(String)CachedUtils.get(Constants.HUODON_START_DATE+huodongid); //活动开始时间
			String endTime=(String)CachedUtils.get(Constants.HUODON_END_DATE+huodongid);  //活动结束时间		
			if(StringUtil.isEmpty(startTime)||StringUtil.isEmpty(endTime)){		
			   HuodongEntity huodongEntity=huodongService.getEntity(HuodongEntity.class,huodongid);		
			   startTime=sf.format(huodongEntity.getStarttime());
			   endTime=sf.format(huodongEntity.getEndtime());
			   CachedUtils.set(Constants.HUODON_START_DATE+huodongid,startTime);
			   CachedUtils.set(Constants.HUODON_END_DATE+huodongid,endTime);		
			}
			Date nowdate = new Date();
			try {
				if (nowdate.after(sf.parse(startTime))
						&& nowdate.before(sf.parse(endTime))) {
					return true;
				}
			} catch (ParseException e) {
				logger.error("日期格式化出错...", e);
				return false;
			}
			return false;
		}
}
