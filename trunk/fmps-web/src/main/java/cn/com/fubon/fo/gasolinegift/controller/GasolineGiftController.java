package cn.com.fubon.fo.gasolinegift.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jodd.datetime.JDateTime;
import jodd.util.StringUtil;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.chain.Context;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.util.ResourceUtil;
import org.jeecgframework.core.util.UUIDGenerator;
import org.jeecgframework.tag.vo.datatable.SortDirection;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import weixin.guanjia.account.entity.WeixinAccountEntity;
import weixin.guanjia.account.service.WeixinAccountServiceI;
import weixin.guanjia.core.util.WeixinUtil;
import weixin.popular.bean.pay.PayNotify;
import weixin.popular.util.JsonUtil;
import weixin.util.JsSdkUtil;
import cn.com.fubon.common.controller.RandCodeController;
import cn.com.fubon.fo.card.interceptor.Token;
import cn.com.fubon.fo.customerbind.entity.WeiXinGzUserInfo;
import cn.com.fubon.fo.customerbind.service.CustomerBindService;
import cn.com.fubon.fo.dynamicpassword.service.DynamicPasswordService;
import cn.com.fubon.fo.gasolinegift.entity.GasolineGift;
import cn.com.fubon.fo.gasolinegift.entity.GasolinePojo;
import cn.com.fubon.fo.gasolinegift.entity.OilChannel;
import cn.com.fubon.fo.gasolinegift.service.IGasolineGiftService;
import cn.com.fubon.fo.gasolinegift.service.OracleCarQuery;
import cn.com.fubon.fo.repairplatform.entity.response.RecommendListResponse;
import cn.com.fubon.fo.totaiwan.entity.TotaiwanClaimImage;
import cn.com.fubon.microshop.service.MicroShopNotifyService;
import cn.com.fubon.product.entity.Responsibility;
import cn.com.fubon.rest.entity.request.GasolineGiftCarRequest;
import cn.com.fubon.rest.entity.request.GasolineGiftOrgListRequest;
import cn.com.fubon.rest.entity.request.GasolineGiftQueryRequest;
import cn.com.fubon.rest.entity.response.GasolineGiftCarResponse;
import cn.com.fubon.rest.entity.response.GasolineGiftOrgListResponse;
import cn.com.fubon.rest.entity.response.GasolineGiftQueryResponse;
import cn.com.fubon.rest.service.impl.RestWebServiceGasolineGiftClient;
import cn.com.fubon.util.FBStringUtils;
import cn.com.fubon.webservice.WsConstants;
import cn.com.fubon.webservice.server.entity.WebServiceClientManagement;

/**
 * 加油宝
 *  
 */

@Scope("prototype")
@Controller
@RequestMapping("/fo/binded/gasolinegift/gasolinegiftController")
public class GasolineGiftController {

	private static final Logger logger = Logger.getLogger(GasolineGiftController.class); 
	@Resource
	private IGasolineGiftService gasolineGiftService;	
	@Resource
	private WeixinAccountServiceI weixinAccountService;	
	@Resource
	private CustomerBindService customerBindService;	
	@Resource
	private DynamicPasswordService dynamicPasswordService;
	@Resource
	private OracleCarQuery oracleCarQuery;	
	@Resource
	private MicroShopNotifyService microShopNotifyService;	

	
	
	//首页入口
	@RequestMapping(params ="getTheHomePage")
	public ModelAndView getTheHomePage(HttpServletRequest request){
		ModelAndView mav = new ModelAndView();	
		String openid = (String) request.getAttribute("openid");
		if (StringUtil.isEmpty(openid)) {
			openid = request.getParameter("openid");
		}
		logger.info("==getTheHomePage===openid==>" + openid);
		String cityCode= request.getParameter("cityCode");
		if (StringUtil.isEmpty(cityCode)) { //没传城市代码，默认厦门
			cityCode ="350200";
		}
		request.getSession().setAttribute("cityCode", cityCode); //保存城市代码到Session 以便 未认证的用户跳转回来可获取到城市代码
		request.getSession().setAttribute("channel", "1"); //保存channel到Session 以便 未认证的用户跳转回来可获取到城市代码
		String code = request.getParameter("code");
		logger.info("code=>" + code);
		if (StringUtil.isEmpty(openid)) {
			List<WeixinAccountEntity> weixinAccountEntityList = weixinAccountService.findValidWeixinAccounts();
			WeixinAccountEntity weixinAccountEntity = weixinAccountEntityList.get(0);
			openid = WeixinUtil.getOpenId(weixinAccountEntity.getAccountappid(),weixinAccountEntity.getAccountappsecret(), code);
			logger.info("根据code获取 openid,获取到的openid=>" + openid);
		}
		boolean isbind = customerBindService.isAuthenticated(openid);	//是否认证富邦用户
		mav.addObject("isbind", isbind);
		mav.addObject("openid", openid);
		mav.addObject("channel", "1");
		mav.addObject("cityCode", cityCode);
		mav.setViewName("/fo/gasolinegift/fubonIndex");
		return mav;
	  }
	
	
	//94频道入口页面
	@RequestMapping(params ="get94ChannelPage")
	public ModelAndView get94ChannelPage(HttpServletRequest request){
		 ModelAndView mav = new ModelAndView();
		 String openid = (String) request.getAttribute("openid");
		 if (StringUtil.isEmpty(openid)) {
			openid = request.getParameter("openid");
			}
		 String code = request.getParameter("code");
		 if (StringUtil.isEmpty(openid)) {
				List<WeixinAccountEntity> weixinAccountEntityList = weixinAccountService.findValidWeixinAccounts();
				WeixinAccountEntity weixinAccountEntity = weixinAccountEntityList.get(0);
		        openid = WeixinUtil.getOpenId(weixinAccountEntity.getAccountappid(),weixinAccountEntity.getAccountappsecret(), code);
				logger.info("根据code获取 openid,获取到的openid=>" + openid);
			  }
		 logger.info("==get94ChannelPage==openid===>" + openid);	 
		 mav.addObject("openid", openid);
		 mav.addObject("channel", "2");
		 mav.addObject("cityCode", "350200");
		 mav.setViewName("/fo/gasolinegift/94Index");		 
		return mav;
	 }	
	
	//点击申请加油宝按钮，检查是否符合申请(符合跳转到信息填写页，不符合显示提示信息)
	@RequestMapping(params ="isEligibility")
	public ModelAndView isEligibility(HttpServletRequest request ,String channel,String mobile ,String cityCode ){
		ModelAndView mav = new ModelAndView();
		String openid = (String) request.getAttribute("openid");
		if (StringUtil.isEmpty(openid)) {
			openid = request.getParameter("openid");
		}		 
		if (StringUtil.isEmpty(cityCode)) { //如果从认证页面跳转过来没有cityCode,需要从Session获取
			cityCode = (String) request.getSession().getAttribute("cityCode");
		}
		if (StringUtil.isEmpty(channel)) { //如果从认证页面跳转过来没有channel,需要从Session获取
			channel = (String) request.getSession().getAttribute("channel");
		}	
	    logger.info("===isEligibility==(检查是否符合申请)=openid===>" + openid);
	    logger.info("====channel==>"+channel+",mobile:"+mobile+",cityCode"+cityCode);
		mav.addObject("channel", channel);		 
		mav.addObject("openid", openid);
		mav.addObject("cityCode", cityCode);		
		String message=this.checkEligibilityList(channel,mobile,openid);
		if(StringUtil.isEmpty(message)){
		   this.getUserDate(channel, mobile, openid, mav);//根据渠道不同获取对应的数据带到前端页面			
		   mav.setViewName("/fo/gasolinegift/oilApplyFrom");		 
		}else{
			mav.addObject("message", message);
			mav.setViewName("/fo/common/message");	
		}
		return mav;
	}
	
	//判断客户是否符合申请条件,符合返回空，不符合返回 具体原因	
	public String checkEligibilityList(String channel,String mobile,String openid ){
		 logger.info("===checkEligibilityList=(按渠道查询数据库，判断是否符合申请条件)==channel===>"+channel +", openid:"+ openid+", mobile:"+mobile);
		String message="";
		if("1".equals(channel)){		
		WeiXinGzUserInfo weiXinGzUserInfo = customerBindService.findUniqueByProperty(WeiXinGzUserInfo.class, "openid", openid);
		List<Map<String, Object>> oracleLicensenoList=oracleCarQuery.queryOracleCarLicensenoList(weiXinGzUserInfo.getCustomercname(), weiXinGzUserInfo.getIdentifynumber());
		List<Map<String, Object>> mysqlLicensenoList=gasolineGiftService.queryMysqlCarLicensenoList(openid); 
	    if(mysqlLicensenoList.size()>5){
	    	message="您的申请名额已用完，感谢您的支持！";		    	
	    } else if (mysqlLicensenoList.size()>=oracleLicensenoList.size()&&mysqlLicensenoList.size()>0){
	    	message="您在富邦投保的车辆均已完成申请！";
	    }	
		}else if("2".equals(channel)){
		 List<OilChannel> oilChannelList=gasolineGiftService.findByProperty(OilChannel.class, "mobile", mobile);
		if(oilChannelList.size()==0){
			message="根据手机号，没有查询到您参与活动的预留信息";
		  }		
		GasolineGift gasolineGift = new GasolineGift();
		gasolineGift.setMobile(mobile);
		gasolineGift.setChannel( Integer.parseInt(channel));
		CriteriaQuery cq = new CriteriaQuery(GasolineGift.class);		
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq,	gasolineGift);
		cq.add();
		List<GasolineGift> gasolineGiftList = gasolineGiftService.getListByCriteriaQuery(cq, false);
		
		if(gasolineGiftList.size()>0){
			message="您的申请名额已用完，感谢您的支持！";	
		}
		}
		return message;
	}
		
	private void getUserDate(String channel,String mobile,String openid,ModelAndView mav ){
		logger.info("===getUserDate=(根据渠道获取用户信息)=openid===>" + openid);
	    logger.info("====channel==>"+channel+",mobile:"+mobile);
		if("1".equals(channel)){ //富邦自己的客户从关注表获取用户信息
			WeiXinGzUserInfo weiXinGzUserInfo = customerBindService.findUniqueByProperty(WeiXinGzUserInfo.class, "openid", openid);
			List<Map<String, Object>> oracleLicensenoList=oracleCarQuery.queryOracleCarLicensenoList(weiXinGzUserInfo.getCustomercname(), weiXinGzUserInfo.getIdentifynumber());
			List<Map<String, Object>> mysqlLicensenoList=gasolineGiftService.queryMysqlCarLicensenoList(openid); 
			ArrayList<String>  licensenoList =new ArrayList(); //允许申请的车牌号列表
			if(oracleLicensenoList.size()==0){ //非车客户，可以申请1辆，手工录入车牌号
				mav.addObject("isCarCustomer", "No");	
			}else{
				mav.addObject("isCarCustomer", "Yes");	
			ArrayList<String>  oarcleList =new ArrayList();
			ArrayList<String>  mySqlList =new ArrayList();
			for(Map<String, Object> licensenoMap :oracleLicensenoList){
				oarcleList.add((String) licensenoMap.get("licenseno"));			
			}
			for(Map<String, Object> licensenoMap :mysqlLicensenoList){
				 mySqlList.add((String) licensenoMap.get("licenseno"));			
			}		
			oarcleList.removeAll(mySqlList); //移除已经申请的车辆
			licensenoList=oarcleList;
			}		
			mav.addObject("licensenoList", licensenoList);			
			mav.addObject("mobile", weiXinGzUserInfo.getMobile());
			mav.addObject("username", weiXinGzUserInfo.getCustomercname());			
		  } else if ("2".equals(channel)){			  
			  OilChannel oilChannel=gasolineGiftService.findByProperty(OilChannel.class, "mobile", mobile).get(0);
			  mav.addObject("mobile", oilChannel.getMobile());
			  mav.addObject("username", oilChannel.getUsername());			  
		  }
		
	   }	
	
	//提交用户填写的申请数据 
	@Token(needRemoveToken = true)
	@RequestMapping(params ="applyMyGasolinegift")
	public ModelAndView applyMyGasolinegif(HttpServletRequest request,GasolinePojo gasolinePojo){
		logger.info("===applyMyGasolinegift=(提交表单，保存数据，发送报文)=openid===>" + gasolinePojo.getOpenid());
		ModelAndView mav = new ModelAndView();		
    //后端检查用户填写的数据
		String message ="";			 
		if (StringUtil.isEmpty(gasolinePojo.getUsername())) {
			message = "姓名不能为空！";
		   }			
		if (!FBStringUtils.checkMobile(gasolinePojo.getMobile())) {
			message ="手机不合法！";			 
		  }		
		if(StringUtil.isNotEmpty(message)){			 
			mav.addObject("message", message);
			mav.setViewName("/fo/gasolinegift/oilApplyFrom");
			return mav;
		}		 
		 
    //处理车非车客户输入的车牌号问题
		String licenseNum =null;
		if("No".equals(gasolinePojo.getIsCarCustomer())||gasolinePojo.getChannel()!=1 ){
			if(gasolinePojo.getCarNo().contains(gasolinePojo.getCarLicense())){
				 gasolinePojo.setLicenseno(gasolinePojo.getCarNo());
			      }else{
				   gasolinePojo.setLicenseno(gasolinePojo.getCarLicense()+gasolinePojo.getCarNo());
			      }			 
		   }else{			
			gasolinePojo.setLicenseno(gasolinePojo.getLicenseno());
		}
		//渠道自取，地址设置为富邦财险
	 //  if(20==gasolinePojo.getReceiveWay() ){
	//	   if(2==gasolinePojo.getChannel()){
	//		   gasolinePojo.setAddress("富邦财产保险有限公司(94频道)");  
	//	   }else{
	//		   gasolinePojo.setAddress("富邦财产保险有限公司");
	//	   }		    
	 //    }		
	//保全用户数据	
    	GasolineGift gasolineGift=new GasolineGift();
		gasolineGift.setOpenid(gasolinePojo.getOpenid());
		gasolineGift.setAddress(gasolinePojo.getAddress());
		gasolineGift.setMobile(gasolinePojo.getMobile());
		gasolineGift.setReceiveAddress(gasolinePojo.getReceiveAddress());
		gasolineGift.setLicenseno(gasolinePojo.getLicenseno());
		gasolineGift.setUsername(gasolinePojo.getUsername());
		gasolineGift.setChannel(gasolinePojo.getChannel());
		gasolineGift.setGiftid("");
		gasolineGift.setReceiveWay(gasolinePojo.getReceiveWay());
		gasolineGiftService.save(gasolineGift);	
		
	//发送和信华通申请卡的报文
		//String orgCode=gasolineGiftService.getOrgCode("子机构1");
		 String orgCode="100000001"; //默认为省内或94渠道客户
		//(cityCode!='510100'&&cityCode!='500000')||channel==2
		if("510100".equals(gasolinePojo.getCityCode())||"500000".equals(gasolinePojo.getCityCode())){
			orgCode="100000002";	
		}
		String oilcardmerId = ResourceUtil.getBundleEnvAbout().getString("oilcardmerId");		
		JDateTime jnow = new JDateTime(new Date());
	    String	reqTime	=jnow.toString("YYYYMMDDhhmmss");
	    GasolineGiftCarRequest  gasolineGiftCarRequest=new GasolineGiftCarRequest(UUIDGenerator.generate(), oilcardmerId, reqTime, gasolinePojo.getMobile() ,gasolinePojo.getUsername(), "19800909",gasolinePojo.getLicenseno() , gasolinePojo.getAddress()+gasolinePojo.getReceiveAddress(),  String.valueOf(gasolinePojo.getReceiveWay()), orgCode);
		GasolineGiftCarResponse gasolineGiftCarResponse=   gasolineGiftService.sendRegisterMessage(gasolineGiftCarRequest);
		gasolineGift.setApplyId(gasolineGiftCarResponse.getApplyId());
		gasolineGift.setRespCode(gasolineGiftCarResponse.getRespCode());
		gasolineGift.setRespMsg(gasolineGiftCarResponse.getRespMsg());
		gasolineGiftService.saveOrUpdate(gasolineGift);		
	if("0000".equals(gasolineGiftCarResponse.getRespCode())){   //发送报文成功，调整支付程序	
		String oilcardPayUrl = ResourceUtil.getBundleEnvAbout().getString("oilcardPayUrl");		
		mav.addObject("oilcardPayUrl", oilcardPayUrl);
		mav.addObject("applyId", gasolineGiftCarResponse.getApplyId());
		mav.setViewName("/fo/gasolinegift/oilPay");
	   }else{
		mav.addObject("message", gasolineGiftCarResponse.getRespMsg());
		mav.setViewName("/fo/common/message"); 		  
	  }
		return mav;
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
	 * 获取appid
	 * 
	 * @param request
	 * @return
	 */
	public String getAppid(HttpServletRequest request) {
		List<WeixinAccountEntity> weixinAccountEntityList = weixinAccountService.findValidWeixinAccounts();
		WeixinAccountEntity weixinAccountEntity = weixinAccountEntityList.get(0);
		String appid = weixinAccountEntity.getAccountappid();
		
		return appid;
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
			
	  //检查用户是否有申请权限
	  @RequestMapping(params = "checkUserQualification")
	  @ResponseBody
	  public AjaxJson checkUserQualification(HttpServletRequest request) {
			String phonenum = request.getParameter("mobile");
			AjaxJson jsonString = new AjaxJson();
		    List<OilChannel> oilChannelList=gasolineGiftService.findByProperty(OilChannel.class, "mobile", phonenum);
			 if(oilChannelList.size()>0){
				 jsonString.setObj(oilChannelList.get(0).getId());
			 } else{
				 jsonString.setSuccess(false);
			 }
			 logger.info("checkUserQualification===phonenum==>"+phonenum+".jsonString:"+jsonString.getJsonStr());
			 return jsonString ;
		  }
	
		@RequestMapping("/payNotify")
		public ModelAndView payNotify (HttpServletRequest request){
			/* PayNotify  payNotify=new PayNotify();
			 payNotify.setTransaction_id("xxxxxx");
			 payNotify.setOut_trade_no("3424234");
			 payNotify.setAttach("setAttach");			 
			 microShopNotifyService.doUnderwriting("8a8195b3540da4d2015432dd80810007", payNotify); */
			 ModelAndView mav = new ModelAndView();
			 String applyId = request.getParameter("applyId");			 
			 List<GasolineGift> gasolineGiftList=gasolineGiftService.findByProperty(GasolineGift.class, "applyId", applyId) ;
			 for(GasolineGift gasolineGift:gasolineGiftList){
				 gasolineGift.setPayStatus(1); 
				 gasolineGiftService.updateEntitie(gasolineGift);
			 }	 	 
			 mav.setViewName("/fo/gasolinegift/oilSucceed");
			  mav.addObject("applyId", applyId);			 
			 return mav;
		}		
		
		@RequestMapping(params ="oilCard")
		public ModelAndView oilCard (HttpServletRequest request) throws IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException{
			ModelAndView mav = new ModelAndView();
			String openid = (String) request.getAttribute("openid");
			if (StringUtil.isEmpty(openid)) {
				openid = request.getParameter("openid");
			}			
		  List<GasolineGift>  gasolineGiftListPage=new  ArrayList<GasolineGift>();			
		  List<GasolineGift> gasolineGiftList=gasolineGiftService.findByProperty(GasolineGift.class, "openid", openid) ;
		for (GasolineGift gasolineGift:gasolineGiftList){
			String oilcardmerId = ResourceUtil.getBundleEnvAbout().getString("oilcardmerId");		
			JDateTime jnow = new JDateTime(new Date());			
		    String	reqTime	=jnow.toString("YYYYMMDDhhmmss");			
			GasolineGiftQueryRequest  gasolineGiftQueryRequest =new GasolineGiftQueryRequest (UUIDGenerator.generate(),oilcardmerId,reqTime, gasolineGift.getMobile(), gasolineGift.getLicenseno(), gasolineGift.getApplyId());
			GasolineGiftQueryResponse gasolineGiftQueryResponse	=	gasolineGiftService.queryOilCarApplyStatus(gasolineGiftQueryRequest);
			gasolineGift.setApplyStatus(gasolineGiftQueryResponse.getApplyStatus()); 
			gasolineGift.setOilCardNo(gasolineGiftQueryResponse.getOilCardNo());
		    if(!StringUtil.isEmpty(gasolineGiftQueryResponse.getRchgDct())){
			gasolineGift.setRchgDct(Integer.parseInt(gasolineGiftQueryResponse.getRchgDct()));
		      }
		     if(!StringUtil.isEmpty(gasolineGiftQueryResponse.getRchgDctExpire())){
			 SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");			 
			 Date date = null;
			  try {
				  date = sdf.parse(gasolineGiftQueryResponse.getRchgDctExpire());
			   } catch (ParseException e) {
				  logger.info("oilCard =日期格式转换错误 =ApplyId=>" + gasolineGift.getApplyId());				
			  }			
			   gasolineGift.setRchgDctExpire(date);
		      }
			gasolineGift.setRespCode(gasolineGiftQueryResponse.getRespCode());
			gasolineGift.setRespMsg(gasolineGiftQueryResponse.getRespMsg());
			gasolineGift.setUpdateTime(new Date());				
			gasolineGiftService.updateEntitie(gasolineGift); //更新状态			
			String applyStatus=gasolineGift.getApplyStatus();//申请状态05:待预充值支付 10:申请待处理（表示已支付）20:申请处理完成 
			GasolineGift gasolineGiftTemp=(GasolineGift) BeanUtils.cloneBean(gasolineGift);
			String applyStatusMessage=this.conversionApplyStatus(applyStatus);
			if( StringUtil.isEmpty(applyStatusMessage)){
				 applyStatusMessage=gasolineGift.getRespMsg();
			}
			gasolineGiftTemp.setApplyStatus(applyStatusMessage);			
			gasolineGiftListPage.add(gasolineGiftTemp);			
		    }
		   String oilcardPayUrl = ResourceUtil.getBundleEnvAbout().getString("oilcardPayUrl");		
		    mav.addObject("oilcardPayUrl", oilcardPayUrl);
		    mav.addObject("gasolineGiftList", gasolineGiftListPage);
			mav.setViewName("/fo/gasolinegift/oilCard");
			return mav;			
		}
		
		private String conversionApplyStatus(String applyStatus){
			String returnMessage=applyStatus;
			if("05".equals(applyStatus)){
				returnMessage= "待预充值";
			}else if("10".equals(applyStatus)){
				returnMessage= "待处理（已支付）";
			}else if("20".equals(applyStatus)){
				returnMessage= "正常";
			}
			return returnMessage;
		}
		
		@RequestMapping(params ="xianxing")
		public String xianxing(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
			return "redirect:http://wx.16u.com/zt/dsn-fb/index.html";		 
		}
 }
