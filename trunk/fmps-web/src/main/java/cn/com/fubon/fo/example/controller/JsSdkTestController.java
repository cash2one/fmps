package cn.com.fubon.fo.example.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import jodd.util.StringUtil;

import org.apache.log4j.Logger;
import org.jeecgframework.core.common.service.CommonService;
import org.jeecgframework.core.util.ResourceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import weixin.guanjia.account.entity.WeixinAccountEntity;
import weixin.guanjia.account.service.WeixinAccountServiceI;
import weixin.guanjia.core.util.WeixinUtil;
import weixin.popular.util.JsonUtil;
import weixin.popular.api.TicketAPI;
import weixin.popular.bean.Ticket;
import weixin.popular.util.JsUtil;
import weixin.util.JsSdkUtil;

@Scope("prototype")
@Controller
@RequestMapping("/fo/exampleController")
public class JsSdkTestController {	
	private static final Logger logger = Logger.getLogger(JsSdkTestController.class);
	@Resource
	private WeixinAccountServiceI weixinAccountService;
	@Resource(name="commonService")
	private CommonService commonService;
	
	@RequestMapping(params = "method=ueditor")
	public ModelAndView ueditor(HttpServletRequest request) {
		System.out.println("<==================================>");
		 request.setAttribute("Domain", ResourceUtil.getDomain());
		return new ModelAndView("/fo/test/ueditor");
	}
	
	@RequestMapping(params = "method=jssdkPage")
	public ModelAndView  jssdkPage(HttpServletRequest request) {	
		String accessToken = weixinAccountService.getAccessTokenFromAccountEntity();
		List<WeixinAccountEntity> weixinAccountEntityList = weixinAccountService.findValidWeixinAccounts();
		WeixinAccountEntity weixinAccountEntity = weixinAccountEntityList.get(0);
	    String  appid = weixinAccountEntity.getAccountappid();
	    
	    String URL = request.getRequestURL() + "?" + request.getQueryString();
	    logger.info("jssdkPage url ===>" + URL);	   
	   // appid = "wxeee8b84bc1946b90";
	   // accessToken="0_tm5xkd1CyjJdlluZKgTCnAUmI8SmZcrId--OYC6Hglzk6ZTDHs5Mslzb38fW_gFtT3jk-0G7BtLLxWfuHBfjPmWBaLepPWlKCDaL9nj00";	
	   
	    JsSdkUtil  JsSdkUtil=new JsSdkUtil (URL, appid, accessToken);
	    String  JSONString =JsSdkUtil.getWxConfigJSONString(); 	   
	    request.setAttribute("JSONString", JSONString);
		return new ModelAndView("/fo/test/JsApiTest");
	}
	
	
	@RequestMapping(params = "method=jssdkPage3")
	public ModelAndView  jssdkPage3(HttpServletRequest request) {
		System.out.println("<==================================>");
		String accessToken = weixinAccountService.getAccessTokenFromAccountEntity();
		List<WeixinAccountEntity> weixinAccountEntityList = weixinAccountService.findValidWeixinAccounts();
		WeixinAccountEntity weixinAccountEntity = weixinAccountEntityList.get(0);
	    String  appid = weixinAccountEntity.getAccountappid();
	    
	    String URL = request.getRequestURL() + "?" + request.getQueryString();
	    logger.info("jssdkPage3 url ===>" + URL);	  
	   // appid = "wxeee8b84bc1946b90";
	   // accessToken="0_tm5xkd1CyjJdlluZKgTCnAUmI8SmZcrId--OYC6Hglzk6ZTDHs5Mslzb38fW_gFtT3jk-0G7BtLLxWfuHBfjPmWBaLepPWlKCDaL9nj00";	
	   
	    JsSdkUtil  JsSdkUtil=new JsSdkUtil (URL, appid, accessToken);
	    String  JSONString =JsSdkUtil.getWxConfigJSONString();
	    request.setAttribute("JSONString", JSONString);
	    request.setAttribute("Domain", ResourceUtil.getDomain());
	    request.setAttribute("url", URL);
		return new ModelAndView("/fo/test/JsApiTest3");
	}
	
	/**
	 * 三八活动女王令入口
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "method=jssdkPage2")
	public String jssdkPage2(HttpServletRequest request){
		
		//如果openid为空，再转发给微信根据code取openid begin
		String openid = request.getParameter("openid");
		if (StringUtils.isEmpty(openid)) {
			openid = (String)request.getAttribute("openid");
		}
		
		//如果openid为空，再转发给微信根据code取openid begin
		String code=request.getParameter("code");

		if(!StringUtil.isEmpty(code)){
			openid = getOpenId(code);
			//如果openid获取失败，要跳到错误提示页面；否则可能会陷入死循环
			if(StringUtils.isEmpty(openid)){
				logger.debug("jssdkPage2 get openid failed");
				request.setAttribute("message", "openid获取失败");
				return "/fo/common/message";
			}
		}

		//openid为空，通过snsapi_base重定向到当前的方法，目的是返回code
		if(StringUtils.isEmpty(openid)){
			return redirectToGetOpenId(null);
		}
		
		//url是分享到朋友圈的链接，用redirect目的是把from作为分享人标识带到链接上
		String url = "redirect:/fo/JsSdkTestController.do?method=jssdkPage2After&state=" + openid;
		logger.info("jssdkPage2 redirect url=" + url);
		return url;
	}
	
	/**
	 * 三八活动女王令首页
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "method=jssdkPage2After")
	public String jssdkPage2After(HttpServletRequest request){
		//fromopenid是分享人的openid
		String fromopenid = request.getParameter("state");
	
		//如果openid为空，再转发给微信根据code取openid begin
		String code=request.getParameter("code");

		String openid = request.getParameter("openid");
		if (StringUtils.isEmpty(openid)) {
			openid = (String)request.getAttribute("openid");
		}

		if(!StringUtil.isEmpty(code)){
			openid = getOpenId(code);
			//如果openid获取失败，要跳到错误提示页面；否则可能会陷入死循环
			if(StringUtils.isEmpty(openid)){
				logger.info("jssdkPage2After get openid failed");
				request.setAttribute("message", "openid获取失败");
				return "/fo/common/message";
			}
		}
//openid="owJamuIfaiKgTu7OxGNSHEFSQumQ";
		//openid为空，通过snsapi_base重定向到当前的方法，目的是返回code
		if(StringUtils.isEmpty(openid)){
			return redirectToGetOpenId(fromopenid);
		}
		
		//如果分享人不为空,查询分享人的女王令title和content否则查询本人的女王令
		Map<String,Object> titleMap = commonService.findOneForJdbc("select title,content from weixin_huodong_card_title where openid = ?", fromopenid);
		if(titleMap != null){
			request.setAttribute("title", titleMap.get("title"));
			request.setAttribute("content", titleMap.get("content"));
		}
		request.setAttribute("openid", openid);

		// 页面JS SDK  开始		  
		String accessToken = weixinAccountService.getAccessTokenFromAccountEntity();
		List<WeixinAccountEntity> weixinAccountEntityList = weixinAccountService.findValidWeixinAccounts();
		WeixinAccountEntity weixinAccountEntity = weixinAccountEntityList.get(0);
	    String  appid = weixinAccountEntity.getAccountappid();
	    
	    String url = request.getRequestURL() + "?" + request.getQueryString();
	    logger.info("jssdkPage2After url ===>" + url);
	    request.setAttribute("link", url);
	    JsSdkUtil JsSdkUtil=new JsSdkUtil (url, appid, accessToken);
	    String JSONString = JsSdkUtil.getWxConfigJSONString();    
	    System.out.println("<==================================>"+JSONString);
	    request.setAttribute("JSONString", JSONString);	    
		//  JS SDK 结束 
	    
		return "/fo/test/JsApiTest2";
	}
	
	/**
	 * 根据微信传入的Code获取OpenID
	 * 
	 * @param code
	 * @return
	 */
	private String getOpenId(String code){
		List<WeixinAccountEntity> weixinAccountEntityList = weixinAccountService.findValidWeixinAccounts();
		WeixinAccountEntity weixinAccountEntity = weixinAccountEntityList.get(0);
		String openid = WeixinUtil.getOpenId(weixinAccountEntity.getAccountappid(), weixinAccountEntity.getAccountappsecret(), code);
		
		return openid;
	}
	
	/**
	 * 重定向到获取openid的地址
	 * 
	 * @return
	 */
	private String redirectToGetOpenId(String state){
		String url = "redirect:https://open.weixin.qq.com/connect/oauth2/authorize?appid={APPID}&redirect_uri={domain}/fo/womensDayCardController.do?method=womensDayIndexAfter"
				+ "&response_type=code&scope=snsapi_base&state=" + state + "#wechat_redirect";
		String domain= ResourceUtil.getDomain();
		List<WeixinAccountEntity> weixinAccountEntityList = weixinAccountService.findValidWeixinAccounts();
		WeixinAccountEntity weixinAccountEntity = weixinAccountEntityList.get(0);
		url= url.replace("{APPID}", weixinAccountEntity.getAccountappid()).replace("{domain}", domain) ;
		
		return url;
	}

}
