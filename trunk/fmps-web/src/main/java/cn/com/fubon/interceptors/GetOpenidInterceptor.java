package cn.com.fubon.interceptors;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import jodd.util.StringUtil;
import org.apache.log4j.Logger;
import org.jeecgframework.core.extend.datasource.DataSourceContextHolder;
import org.jeecgframework.core.extend.datasource.DataSourceType;
import org.jeecgframework.core.util.ResourceUtil;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import weixin.guanjia.account.entity.WeixinAccountEntity;
import weixin.guanjia.account.service.WeixinAccountServiceI;
import weixin.guanjia.core.util.WeixinUtil;
import cn.com.fubon.fo.customerbind.service.CustomerBindService;
import cn.com.fubon.util.Constants;
import cn.com.fubon.util.FBStringUtils;

/**
 * 进微信前端的具体Controller之前,获取openid
 * 
 * @author fangfang.guo
 *
 */
public class GetOpenidInterceptor extends HandlerInterceptorAdapter {

	private static final Logger logger = Logger
			.getLogger(GetOpenidInterceptor.class);

	private List<String> excludeUrls;

	@Resource
	private WeixinAccountServiceI weixinAccountService;
	@Resource
	private CustomerBindService customerBindService;

	public List<String> getExcludeUrls() {
		return excludeUrls;
	}

	public void setExcludeUrls(List<String> excludeUrls) {
		this.excludeUrls = excludeUrls;
	}

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {

		String requestPath = ResourceUtil.getRequestPath(request);// 用户访问的资源地址
		logger.info("requestPath:" + requestPath);

		if (excludeUrls != null
				&& FBStringUtils.checkPathMatch(excludeUrls, requestPath))
			return true;
		String activedProfile = request.getSession().getServletContext()
				.getInitParameter("spring.profiles.active");
		String code = request.getParameter("code");
		logger.info("code from request Parameter,code==>" + code);
		//String openid = request.getParameter("openid");		
		String openid = (String)request.getSession().getAttribute(Constants.SESSION_KEY_OPENID);		
		logger.info("openid from request.getSession(),openid==>" + openid);
		if(StringUtil.isEmpty(openid)&&!"prod".equals(activedProfile)){
			openid = request.getParameter("openid");	
		  }
		// 如果code不为空,且openid为空
		if (!StringUtil.isEmpty(code) && StringUtil.isEmpty(openid)) {
			DataSourceContextHolder
					.setDataSourceType(DataSourceType.dataSource_jeecg);
			List<WeixinAccountEntity> weixinAccountEntityList = weixinAccountService
					.findValidWeixinAccounts();
			WeixinAccountEntity weixinAccountEntity = weixinAccountEntityList
					.get(0);
			openid = WeixinUtil.getOpenId(
					weixinAccountEntity.getAccountappid(),
					weixinAccountEntity.getAccountappsecret(), code);
			logger.info("get openid from code,openid=>" + openid);
		}

		// 如果openid获取失败，要跳到错误提示页面；否则可能会陷入死循环
		if (StringUtils.isEmpty(openid)) {
			logger.info("get openid from code failed");
			String userRequestPath =ResourceUtil.getDomain() +request.getServletPath() + "?"+ request.getQueryString();	
			String redirectUrl =  this.redirectToGetOpenId(userRequestPath);			 
			request.getSession().setAttribute(Constants.SESSION_KEY_redirectUrl, redirectUrl);
			response.sendRedirect(redirectUrl);
			//response.sendRedirect(request.getContextPath() + "/loginController.do?message");
			return false;
		}else{
			request.getSession().setAttribute(Constants.SESSION_KEY_OPENID, openid);
		}
		// changed by qingqu.huang @date 2015-10-21 修改判断用户关注
	
		if (WeixinUtil.isSubscribe(openid,activedProfile)) {
			request.setAttribute("issubscribe", "1");
			
		} else {
			request.setAttribute("issubscribe", "0");
		}
		request.setAttribute("openid", openid);
		return true;
	}
	
	
	   /**
       * 重定向到获取openid的地址 
       */	
	private String redirectToGetOpenId(String requestPath){
		String url = "";
		try {
			url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid={APPID}&redirect_uri="+URLEncoder.encode(requestPath,"UTF-8")    
					+ "&response_type=code&scope=snsapi_base&state=state#wechat_redirect";
		} catch (UnsupportedEncodingException e) {
			logger.info("getURL redirectToGetOpenId ERROR==>", e);
		}
		List<WeixinAccountEntity> weixinAccountEntityList = weixinAccountService.findValidWeixinAccounts();
		WeixinAccountEntity weixinAccountEntity = weixinAccountEntityList.get(0);
		url= url.replace("{APPID}", weixinAccountEntity.getAccountappid()) ;		
		return url;
	}

}
