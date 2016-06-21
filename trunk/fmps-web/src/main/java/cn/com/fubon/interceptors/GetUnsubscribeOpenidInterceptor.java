package cn.com.fubon.interceptors;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jodd.util.StringUtil;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.jeecgframework.core.extend.datasource.DataSourceContextHolder;
import org.jeecgframework.core.extend.datasource.DataSourceType;
import org.jeecgframework.core.util.JSONHelper;
import org.jeecgframework.core.util.ResourceUtil;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import weixin.guanjia.account.entity.WeixinAccountEntity;
import weixin.guanjia.account.service.WeixinAccountServiceI;
import weixin.guanjia.core.util.WeixinUtil;
import weixin.popular.util.JsonUtil;
import cn.com.fubon.fo.customerbind.entity.WeiXinGzUserInfo;
import cn.com.fubon.fo.customerbind.service.CustomerBindService;
import cn.com.fubon.fo.event.service.IEventProcessingService;
import cn.com.fubon.util.Constants;
import cn.com.fubon.util.FBStringUtils;

/**
 * 未关注用户,获取openid
 * 
 * @author shanqi.wang
 *
 */
public class GetUnsubscribeOpenidInterceptor extends HandlerInterceptorAdapter {

	private static final Logger logger = Logger
			.getLogger(GetUnsubscribeOpenidInterceptor.class);

	private List<String> excludeUrls;

	@Resource
	private WeixinAccountServiceI weixinAccountService;
	@Resource
	private CustomerBindService customerBindService;
	
	@Resource
	private IEventProcessingService eventProcessingService;

	public List<String> getExcludeUrls() {
		return excludeUrls;
	}

	public void setExcludeUrls(List<String> excludeUrls) {
		this.excludeUrls = excludeUrls;
	}

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		String openid = (String)request.getSession().getAttribute(Constants.SESSION_KEY_OPENID);
		String activedProfile = request.getSession().getServletContext().getInitParameter("spring.profiles.active");
		if(StringUtil.isEmpty(openid)&&!"prod".equals(activedProfile)){
			openid = request.getParameter("openid");	
		  }
		String code = request.getParameter("code");
		logger.info("code from request Parameter,code==>" + code);
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
		
       //开始下载未关注客户信息
		logger.info("begin_download_customer_info_openid=>" + openid);
		List<WeixinAccountEntity> weixinAccountEntityList = weixinAccountService.findValidWeixinAccounts();
		WeixinAccountEntity weixinAccountEntity = weixinAccountEntityList.get(0);
		String accessToken = weixinAccountService.getAccessToken( weixinAccountEntity);
		String requestUrl = WeixinUtil.get_customer_url.replace("ACCESS_TOKEN",
				accessToken).replace("OPENID",openid);
		JSONObject CustomerJSONObject = WeixinUtil.httpRequest(requestUrl,
				"GET", null);
		logger.info("Unsubscribe_customer_info=>" + CustomerJSONObject.toString());
		//WeiXinGzUserInfo weiXinGzUserInfo = (WeiXinGzUserInfo) JSONHelper.json2Object(CustomerJSONObject.toString(),WeiXinGzUserInfo.class);
		WeiXinGzUserInfo weiXinGzUserInfo = JsonUtil.parseObject(CustomerJSONObject.toString(),	WeiXinGzUserInfo.class); 
		java.util.Date date = new Date();	 
		weiXinGzUserInfo.setAccount(weixinAccountEntity);
		weiXinGzUserInfo.setAddtime(date); 
		try {
			eventProcessingService.customerSubscribe(weiXinGzUserInfo);			 
		} catch (Exception e) {
			logger.info("saveCustomerSubscribeError===openid====>"
					+ weiXinGzUserInfo.getOpenid() + ".ErrorMessage:"
					+ e.getMessage(),e);			 
		}
		
		return true;
	}
}
