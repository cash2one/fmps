package cn.com.fubon.fo.huodong.controller;

import java.math.BigDecimal;
import java.net.SocketException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import jodd.util.StringUtil;
import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.RandomUtils;
import org.apache.log4j.Logger;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.extend.datasource.DataSourceContextHolder;
import org.jeecgframework.core.extend.datasource.DataSourceType;
import org.jeecgframework.core.util.JSONHelper;
import org.jeecgframework.core.util.ResourceUtil;
import org.jeecgframework.core.util.oConvertUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.druid.support.json.JSONUtils;

import weixin.guanjia.account.entity.WeixinAccountEntity;
import weixin.guanjia.account.service.WeixinAccountServiceI;
import weixin.guanjia.core.util.WeixinUtil;
import weixin.idea.huodong.entity.HuodongEntity;
import weixin.idea.huodong.service.HdRecordService;
import weixin.idea.huodong.service.HuodongService;
import weixin.popular.api.SnsAPI;
import weixin.popular.bean.User;
import weixin.util.JsSdkUtil;
import cn.com.fubon.fo.customerbind.entity.WeiXinGzUserInfo;
import cn.com.fubon.fo.customerbind.service.CustomerBindService;
import cn.com.fubon.fo.dynamicpassword.service.DynamicPasswordService;
import cn.com.fubon.fo.event.service.IEventProcessingService;
import cn.com.fubon.fo.huodong.entity.HuodongRecord;
import cn.com.fubon.fo.huodong.service.LunarNewYearService;
import cn.com.fubon.util.CachedUtils;
import cn.com.fubon.util.Constants;



@Scope("prototype")
@Controller
@RequestMapping("/fo/lunarNewYearController")
public class LunarNewYearController {
		
	@Resource
	private WeixinAccountServiceI weixinAccountService;
	
	@Resource
	private LunarNewYearService lunarNewYearService;
	
	@Resource
	private CustomerBindService customerBindService;
	
	@Resource
	private HdRecordService hdRecordService;
	
	@Resource
	private DynamicPasswordService dynamicPasswordService;
	
	@Resource
	private HuodongService huodongService;
	
	@Resource
	private IEventProcessingService eventProcessingService;
	 
	//UAT环境appid
	private String UATAPPID = "wx0399bb88eebabd18";	
	// 预生产环境appid
	private String PREAPPID = "wx530ce440f6f9de09";
	// 生产环境appid
	private String PRODAPPID = "wxeee8b84bc1946b90";
	private String  huodongid="8a828edfedfre68475034fd3dca5799634";	
	private static final Logger logger = Logger
			.getLogger(LunarNewYearController.class);	
	
	@RequestMapping(params = "huodongIndex")
	public String huodongIndex(HttpServletRequest request) {
		String openid = (String) request.getSession().getAttribute(Constants.SESSION_KEY_OPENID);
		if (StringUtil.isEmpty(openid)) {
			openid = request.getParameter("openid");
		}
		logger.info("huodongIndex=====openid===>"+openid);		
		//活动是否结束
		if(!this.isRangeOfDate()){
			String hasPolicy=lunarNewYearService.hasPolicy(huodongid, openid)?"YES":"NOT" ;
			 request.setAttribute("hasPolicy", hasPolicy);
			 return "/fo/huodong/lunarnewyear/huodongEnd"; 			
		}		
		if (lunarNewYearService.isFirstEnter(huodongid, openid)){ //首次进入活动
			 request.setAttribute("openid", openid);
			 return "/fo/huodong/lunarnewyear/huodongIndex"; 
		 }		
		 return "redirect:/fo/lunarNewYearController.do?huodongMain";				
	   }
	
	
	@RequestMapping(params = "huodongMain")
	public String huodongMain(HttpServletRequest request) {		
		String accessToken = weixinAccountService
				.getAccessTokenFromAccountEntity();		
		String openid = (String) request.getSession().getAttribute(Constants.SESSION_KEY_OPENID);
		if (StringUtil.isEmpty(openid)) {
			openid = request.getParameter("openid");
		}
		logger.info("huodongMain=====openid===>"+openid);		
		//活动是否结束(不在活动期间)
		if(!this.isRangeOfDate()){
			String hasPolicy=lunarNewYearService.hasPolicy(huodongid, openid)?"YES":"NOT" ;
			 request.setAttribute("hasPolicy", hasPolicy);
			 return "/fo/huodong/lunarnewyear/huodongEnd"; 			
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
      if (lunarNewYearService.isFirstEnter(huodongid, openid)){ //首次进入
		//保存随机保额	
    	  HuodongRecord  huodongRecord=new HuodongRecord();
    	  huodongRecord.setAmount(this.getRandomAmount(huodongid, openid)+10000 ); //首次随机保额多1万
    	  huodongRecord.setCreatedate(new Date());
    	  huodongRecord.setSponsor(openid);
    	  huodongRecord.setOpenid(openid);
    	  huodongRecord.setHuodongid(huodongid);
    	  try {
    		  String ip = oConvertUtils.getRealIp();
    		  huodongRecord.setIp(ip);
    	  } catch (SocketException e) {
    		  logger.error("获取服务器端IP出现异常...", e);
    	  }
    	  lunarNewYearService.save(huodongRecord);	
		}       
       BigDecimal amount=lunarNewYearService.getAmount( huodongid, openid);	      
  	   List<Map<String, Object>> friendList=lunarNewYearService.getFriendList(huodongid, openid);
  		// 获取我的保障进度百分比%
		int myProgress = this.getMyProgress(amount);
		double myamountWan = amount.intValue()/10000.0;
		// 剩余抽奖次数
		int remainTimes = this.getMyRemainTimes(amount, openid);
		// 参与人数 
		long peopleCount = 1L;
		peopleCount = hdRecordService.getPeopleCount(huodongid);
		request.setAttribute("amount", amount);
  	    request.setAttribute("friendList", friendList);
		request.setAttribute("appid", appid);	
		request.setAttribute("huodongid", huodongid);
		request.setAttribute("openid", openid);
		request.setAttribute("myamountWan", myamountWan);
		request.setAttribute("myProgress", myProgress);
		request.setAttribute("remainTimes", remainTimes);
		request.setAttribute("peopleCount", peopleCount);
		return "/fo/huodong/lunarnewyear/huodongMain";
	}	
	 //判断是否在活动期间内
	private   boolean isRangeOfDate() {
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String startTime=(String)CachedUtils.get(Constants.HUODON_START_DATE); //活动开始时间
		String endTime=(String)CachedUtils.get(Constants.HUODON_END_DATE);  //活动结束时间		
		if(StringUtil.isEmpty(startTime)||StringUtil.isEmpty(endTime)){		
		   HuodongEntity huodongEntity=huodongService.getEntity(HuodongEntity.class,huodongid);		
		   startTime=sf.format(huodongEntity.getStarttime());
		   endTime=sf.format(huodongEntity.getEndtime());
		   CachedUtils.set(Constants.HUODON_START_DATE,startTime);
		   CachedUtils.set(Constants.HUODON_END_DATE,endTime);		
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

	//获取随机保额
	private int getRandomAmount(String huodongid, String openid ){		 
		 int rand= RandomUtils.nextInt(10)+1 ;		
		 int randomAmount=   rand*1000  ;
		 BigDecimal amount=lunarNewYearService.getAmount( huodongid, openid);
		  if (amount==null){ //首次查询数据库为空
			 amount=new BigDecimal(0);
			 }
		  int	amountTotal= randomAmount+ amount.intValue();  
		 if(amountTotal>=100000){
			 randomAmount=100000-amount.intValue();
		   }
			return randomAmount;
	       }

	/**
	 * 进入分享页面
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "sharePage")
	public String sharePage(HttpServletRequest request) {		
		// 帮抢者(即我)
		String openid = (String) request.getSession().getAttribute(Constants.SESSION_KEY_OPENID); // 获取session的openid
	    String activedProfile = request.getSession().getServletContext().getInitParameter("spring.profiles.active");
		if(StringUtil.isEmpty(openid)&&!"prod".equals(activedProfile)){
			openid = request.getParameter("openid");	
		  }
		String code = request.getParameter("code");
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
		}		
		List<WeiXinGzUserInfo>  userinfoList=lunarNewYearService.findByProperty(WeiXinGzUserInfo.class,"openid",openid);
		if(userinfoList.size()==0){
			logger.info("帮抢用户未关注，进入下载用户信息====openid===>"+openid);			
			String  oauth2_access_token =(String) CachedUtils.get(Constants.OAUTH2_ACCESS_TOKEN+code);
			logger.info("帮抢用户未关注，进入下载用户信息====oauth2_access_token===>"+oauth2_access_token);
			saveUnSubscribeUser(openid,oauth2_access_token);  //下载未关注用户信息。	
		 }
		// 1、活动结束，不允许进入活动页面，跳转到...
		if (!this.isRangeOfDate()) {
		  String hasPolicy=lunarNewYearService.hasPolicy(huodongid, openid)?"YES":"NOT" ;
		  request.setAttribute("hasPolicy", hasPolicy);
		  return "/fo/huodong/lunarnewyear/huodongEnd"; 	
		}
		// 分享者(即他)
		String sponsor = request.getParameter("sponsor");
		logger.info("分享者openid:" + sponsor);
		logger.info("帮抢者openid:" + openid);
		// 分享者头像
		String headimgurl = ResourceUtil.getDomain() + "/plug-in/fo/images/peck_head.png";
		WeiXinGzUserInfo userinfo = lunarNewYearService.findUniqueByProperty(WeiXinGzUserInfo.class, "openid", sponsor);
		if (userinfo != null) {
			headimgurl = userinfo.getHeadimgurl();
		}
		// 帮分享者抢过标记
		boolean helpHimFlag = false;
		
		// 2、自己不能帮自己抢保额
		if (openid.equalsIgnoreCase(sponsor)) {
			request.setAttribute("message", "openid、sponsor("+sponsor+")->抱歉，自己不能帮自己抢保额");
			logger.info("openid、sponsor("+sponsor+")->抱歉，自己不能帮自己抢保额");
			return "redirect:/fo/lunarNewYearController.do?huodongIndex";
		}
			
		// 3、帮抢者(即我)是否已经领取过保额
		if (lunarNewYearService.isFirstEnter(huodongid, openid)) {	//未领取，随机生成保额
			HuodongRecord huodongRecord = new HuodongRecord();
			huodongRecord.setAmount(this.getRandomAmount(huodongid, openid) + 10000); // 首次随机保额多1万
			huodongRecord.setCreatedate(new Date());
			huodongRecord.setSponsor(openid);
			huodongRecord.setOpenid(openid);
			huodongRecord.setHuodongid(huodongid);
			try {
	    		  String ip = oConvertUtils.getRealIp();
	    		  huodongRecord.setIp(ip);
	    	  } catch (SocketException e) {
	    		  logger.error("获取服务器端IP出现异常...", e);
	    	  }
			lunarNewYearService.save(huodongRecord);
		}
		BigDecimal myamount = lunarNewYearService.getAmount(huodongid, openid);
		
		BigDecimal hisamount = new BigDecimal("0");
		// 4.1、是否帮他抢过保额
		if (lunarNewYearService.isHelpHim(sponsor, huodongid, openid)) {
			hisamount = lunarNewYearService.getHelpHisAmount(sponsor, huodongid, openid);
			helpHimFlag = true;
		} else {
			helpHimFlag = false;
			// 4.2、帮抢前，先判断分享者保额是否已经超过10万
			BigDecimal amount=lunarNewYearService.getAmount( huodongid, sponsor); //别人现在的保额合计
			amount =  amount == null ? new BigDecimal(0):amount;
			if(amount.intValue() < 100000){
				double randomAmount = this.getRandomAmount(huodongid, sponsor); // 帮朋友抢 1千~1万 
				HuodongRecord huodongRecord = new HuodongRecord();
				huodongRecord.setAmount(randomAmount);
				huodongRecord.setCreatedate(new Date());
				huodongRecord.setSponsor(sponsor);
				huodongRecord.setOpenid(openid);
				huodongRecord.setHuodongid(huodongid);
				lunarNewYearService.save(huodongRecord);
				hisamount = new BigDecimal(randomAmount);
			}else{
				hisamount = new BigDecimal(0);
			}
		}
		// 5、看看朋友们帮抢了了多少
		List<Map<String, Object>> friendList = lunarNewYearService.getFriendList(huodongid, sponsor);
		// 6、分享给朋友、朋友圈		
		String appid = "";
		if ("prod".equalsIgnoreCase(activedProfile)) {
			appid = PRODAPPID;
		} else if ("uat".equalsIgnoreCase(activedProfile)) {
			appid = UATAPPID;
		} else if ("pre".equalsIgnoreCase(activedProfile)) {
			appid = PREAPPID;
		} else if ("dev".equalsIgnoreCase(activedProfile)) {
			appid = UATAPPID;
		}
//		String accessToken = weixinAccountService.getAccessTokenFromAccountEntity();
//		String redirect_uri = ResourceUtil.getDomain() + "/fo/lunarNewYearController.do?sharePage&sponsor="+openid;
//		String encodeUrl = "";
//		try {
//			encodeUrl = java.net.URLEncoder.encode(redirect_uri, "UTF-8");
//			logger.info("encodeUrl==>" + encodeUrl);
//		} catch (UnsupportedEncodingException e) {
//			logger.error("分享link encode报错"); 
//		}
//		logger.info("jssdkPage url ===>" + redirect_uri);
//		logger.info("jssdkPage encode url ===>" + encodeUrl);
//		JsSdkUtil JsSdkUtil = new JsSdkUtil(encodeUrl, appid, accessToken);
//		String JSONString = JsSdkUtil.getWxConfigJSONString();
//		logger.info("JSONString==>" + JSONString);
		
		// 7.1 获取我的保障进度百分比%
		int myProgress = this.getMyProgress(myamount);
		// 7.2保障换成单位：万 
		String myamountWan = this.amountTrans(myamount);
		// 8.剩余抽奖次数
		int remainTimes = this.getMyRemainTimes(myamount, openid);
		// 9.参与人数 
		long peopleCount = 1L;
		peopleCount = hdRecordService.getPeopleCount(huodongid);
		
		request.setAttribute("openid", openid);
		request.setAttribute("sponsor", sponsor);
		request.setAttribute("headimgurl", headimgurl);
		request.setAttribute("myamount", myamount);
		request.setAttribute("myamountWan", myamountWan);
		request.setAttribute("hisamount", hisamount);
		request.setAttribute("helpHimFlag", helpHimFlag);
		request.setAttribute("friendList", friendList);
//		request.setAttribute("url",encodeUrl);
		request.setAttribute("appid",appid);
//		request.setAttribute("JSONString", JSONString);
		request.setAttribute("myProgress", myProgress);
		request.setAttribute("remainTimes", remainTimes);
		request.setAttribute("peopleCount", peopleCount);
		return "/fo/huodong/lunarnewyear/sharePage";
	}
	
	/**
	 * 进入转盘抽奖页面,如果用户hrRecord中没有记录，跳转到资料填写页面
	 * 
	 * @param request productId商品ID
	 * @return
	 */
	@RequestMapping(params = "turnplatePage")
	public ModelAndView turnplatePage(HttpServletRequest request,String productId) {
		return new ModelAndView("redirect:/zpController.do?goTurnplate&productId="+productId);
	}
	

	/**
	 * 进入地图查看保额页面
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "premiumMapPage")
	public ModelAndView premiumMapPage(HttpServletRequest request) {
		String openid = (String) request.getSession().getAttribute(Constants.SESSION_KEY_OPENID);
		if (StringUtil.isEmpty(openid)) {
			openid = request.getParameter("openid");
		}
		//参与人数 
		long peopleCount = hdRecordService.getPeopleCount(huodongid);
		//参与人地图
		List<Map<String, Object>> provinceList = lunarNewYearService.getPeopleInProvince(huodongid);
		//已抢保额
		long premiumCount = lunarNewYearService.getPremiumCount(huodongid);
		/*//最快抢满10万的用户
		Map<String, Object> fastestPeople = lunarNewYearService.getFastestPeople(huodongid);
		if(fastestPeople != null){
			request.setAttribute("nickname", fastestPeople.get("nickname"));
			long minTime = (long)fastestPeople.get("minTime");
			JDateTime jdate = new JDateTime(minTime*1000);
			String timeString =jdate.getDay()+"天"+jdate.getHour()+"小时"+jdate.getMinute()+"分";
			request.setAttribute("minTime", timeString);
		}*/
		BigDecimal amount=lunarNewYearService.getAmount( huodongid, openid);
		amount =  amount == null ? new BigDecimal(0):amount;
		int drawRecordCount = huodongService.drawRecordCount(openid,huodongid);
		int tempCount = amount.intValue()/10000;
		tempCount = tempCount > 10 ? 10 : tempCount;
		//获取当前用户抽奖次数（保额/10000-已经抽过的次数）最大10次
		int drowCount = tempCount-drawRecordCount;
		
		request.setAttribute("hdid", huodongid);
		request.setAttribute("peopleCount", peopleCount);
		request.setAttribute("premiumCount", premiumCount);
		request.setAttribute("drowCount", drowCount);
		request.setAttribute("amount", amount);
		//request.setAttribute("fastestPeople", fastestPeople);
		request.setAttribute("provinceList", JSONUtils.toJSONString(provinceList));
			
		logger.info("========hdid========"+huodongid);
		return new ModelAndView("/fo/huodong/lunarnewyear/premiumMap");
	}
	
	/**
	 * 保存用户资料
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "saveUserData")
	public ModelAndView saveUserData(HttpServletRequest request,String dynamicpassword,
			String customercname, String identifynumber, String mobile)throws Exception {
		String openid = (String) request.getAttribute("openid");
		if (StringUtil.isEmpty(openid)) {
			openid = request.getParameter("openid");
		}
		String message = "";
		ModelAndView mav = new ModelAndView();
		if (StringUtil.isEmpty(mobile)) {
			message = "手机号码不能为空！";
		} else if (StringUtil.isEmpty(identifynumber)) {
			message = "身份证号码不能为空！";
		}else if (StringUtil.isEmpty(customercname)) {
			message = "姓名不能为空！";
		}
		if(StringUtil.isNotEmpty(message)){
			request.setAttribute("message", message);
			mav.setViewName("/fo/huodong/lunarnewyear/writeUserData");
			return mav;
		}
		
		HuodongRecord  huodongRecord=lunarNewYearService.getHuodongRecord(huodongid,openid);
		huodongRecord.setCustomercname(customercname);
		huodongRecord.setIdentifynumber(identifynumber);
		huodongRecord.setPhonenum(mobile);
		lunarNewYearService.saveOrUpdate(huodongRecord);
		
		return new ModelAndView("redirect:/zpController.do?goTurnplate");
	}
	
	
	//判断是否已经参加活动、用户姓名、身份证号、手机号是否都填写了
	private boolean isDataWritten(HttpServletRequest request,String  openid){
		HuodongRecord  huodongRecord=lunarNewYearService.getHuodongRecord(huodongid,openid);
		//判断是否已参加活动
		if(huodongRecord == null){
			return false;
		}
		//判断资料是否填写完整
		if(!StringUtil.isNotEmpty(huodongRecord.getCustomercname()) 
				|| !StringUtil.isNotEmpty(huodongRecord.getIdentifynumber()) 
				|| !StringUtil.isNotEmpty(huodongRecord.getPhonenum())){
			return false;
		}
		return true;
	}
	
	@RequestMapping(params = "JsdkString")
	@ResponseBody
	public AjaxJson JsdkString(HttpServletRequest request) throws Exception {		
		String  jsdkurl=request.getParameter("jsdkurl");	
		logger.info("jssdkPage url ===>" + jsdkurl);
		AjaxJson jsonString = new AjaxJson();	
		String accessToken = weixinAccountService
				.getAccessTokenFromAccountEntity();
		List<WeixinAccountEntity> weixinAccountEntityList = weixinAccountService
				.findValidWeixinAccounts();
		WeixinAccountEntity weixinAccountEntity = weixinAccountEntityList
				.get(0);
		String appid = weixinAccountEntity.getAccountappid();		
		JsSdkUtil JsSdkUtil = new JsSdkUtil(jsdkurl, appid, accessToken);
		String json = JsSdkUtil.getWxConfigJSONString();
		jsonString.setObj(json);
		logger.info("JsSdkUtil.getWxConfigJSONString====>" + json);		
		return jsonString;
	}
	
	/**
	 * 验证手机号和验证码
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "checkUserPhone")
	@ResponseBody
	public String checkUserPhone(HttpServletRequest request) {
		String phonenum = request.getParameter("mobile");
		String verifcode = request.getParameter("dynamicpassword");
		boolean isverifcode = dynamicPasswordService.isValidDynamicPassword(
				phonenum, verifcode);
		if (isverifcode) {
			return "0";
		} else {
			return "1";
		}
	}
	
	/**
	 * 获取微信公众账号ID
	 * @return
	 */
	@SuppressWarnings("unused")
	private String findAccountId(HttpServletRequest request){
		//非法请求，直接返回
		if(request == null){
			return "";
		}
		//request请求中拿到accountid,直接返返回，如果拿不到。则从上下文中获取
		String accountid = request.getParameter("accountid");
		if(accountid != null && !"".equals(accountid)){
			return accountid;
		}else{
			return ResourceUtil.getWeiXinAccountId();
		}
	}
	
	@RequestMapping(params = "getPeopleInProvince")
	@ResponseBody
	public AjaxJson getPeopleInProvince(HttpServletRequest request ,String hdid) throws Exception {		
		AjaxJson jsonString = new AjaxJson();
		List<Map<String, Object>> provinceList = lunarNewYearService.getPeopleInProvince(hdid);
		jsonString.setObj(JSONUtils.toJSONString(provinceList));
		logger.info("provinceList各省份参与人数====>" + provinceList);		
		return jsonString;
	}
	
	/**
	 * 获取我的保障进度百分比%
	 * 
	 * @param myTotalAmount
	 * @return
	 */
	public int getMyProgress(BigDecimal myTotalAmount){
		myTotalAmount = myTotalAmount == null ? new BigDecimal(0) : myTotalAmount;
		
		return myTotalAmount.intValue()/1000;
	}
	
	/**
	 * 转化单位为万
	 * 
	 * @param myTotalAmount
	 * @return
	 */
	public String amountTrans(BigDecimal myTotalAmount){
		double d = myTotalAmount.intValue()/10000.0;
		
		if(Math.round(d)-d==0){
			return String.valueOf((long)d);
		}else{
			return String.valueOf(d);
		}
	}
	
	/**
	 * 剩余抽奖次数
	 * 
	 * @param myTotalAmount
	 * @param openid
	 * @return
	 */
	public int getMyRemainTimes(BigDecimal myTotalAmount,String openid){
		//已使用次数
		int drawRecordCount = huodongService.drawRecordCount(openid,huodongid);
		//总共次数
		myTotalAmount = myTotalAmount == null ? new BigDecimal(0) : myTotalAmount;
		int totalCount = myTotalAmount.intValue()/10000;
		totalCount = totalCount > 10 ? 10 : totalCount;
		//剩余抽奖次数
		int remainTimes = totalCount-drawRecordCount;
		
		return remainTimes;
	}
	
	
	protected void saveUnSubscribeUser(String openid,String oauth2_access_token) {
		try {	
		  WeiXinGzUserInfo weiXinGzUserInfo= new WeiXinGzUserInfo();
		  SnsAPI snsAPI=new SnsAPI();
		  User  user=	snsAPI.userinfo(oauth2_access_token,openid,"zh_CN");
		  weiXinGzUserInfo.setOpenid(user.getOpenid());
		  weiXinGzUserInfo.setNickname(user.getNickname());
		  weiXinGzUserInfo.setSex(user.getSex().toString());
		  weiXinGzUserInfo.setProvince(user.getProvince());
		  weiXinGzUserInfo.setCity(user.getCity());
		  weiXinGzUserInfo.setCountry(user.getCountry());
		  weiXinGzUserInfo.setHeadimgurl(user.getHeadimgurl());		
		  List<WeixinAccountEntity> weixinAccountEntityList = weixinAccountService.findValidWeixinAccounts();
		  WeixinAccountEntity weixinAccountEntity = weixinAccountEntityList.get(0);
		  java.util.Date date = new Date();	 
		  weiXinGzUserInfo.setAccount(weixinAccountEntity);
		  weiXinGzUserInfo.setAddtime(date); 			
		  eventProcessingService.customerSubscribe(weiXinGzUserInfo);
		} catch (Exception e) {
				logger.info("saveUnSubscribeUserError===openid====>"+ openid + ".ErrorMessage:"	+ e.getMessage(),e);			 
			}		
	}
	
	/**
	 * 验证姓名和身份
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "checkIdNumber")
	@ResponseBody
	public String checkIdNumber(HttpServletRequest request,String identifynumber,String customercname) {
		boolean isCheckIn = lunarNewYearService.isUserCheckIn(identifynumber, customercname);
		if (isCheckIn) {
			//已登记过
			return "1";
		} else {
			//未登记过
			return "0";
		}
	}
	
}
