/**
 * 
 */
package cn.com.fubon.interceptors;

import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import jodd.util.StringUtil;
import org.apache.log4j.Logger;
import org.jeecgframework.core.extend.datasource.DataSourceContextHolder;
import org.jeecgframework.core.extend.datasource.DataSourceType;
import org.jeecgframework.core.util.ResourceUtil;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import weixin.guanjia.account.entity.WeixinAccountEntity;
import weixin.guanjia.account.service.WeixinAccountServiceI;
import weixin.guanjia.core.util.WeixinUtil;
import weixin.util.WeiXinConstants;
import cn.com.fubon.fo.customerbind.entity.WeiXinGzUserInfo;
import cn.com.fubon.fo.customerbind.service.CustomerBindService;
import cn.com.fubon.util.CachedUtils;
import cn.com.fubon.util.Constants;
import cn.com.fubon.util.FBStringUtils;

/**
 * 微信客户拦截器，访问微信客户相关页面，必须是已绑定用户
 * 
 * @author binbin.wang
 *
 */
public class WeixinCustomerAuthInterceptor extends HandlerInterceptorAdapter {

	private List<String> excludeUrls;

	@Resource
	private CustomerBindService customerBindService;

	@Resource
	private WeixinAccountServiceI weixinAccountService;

	public List<String> getExcludeUrls() {
		return excludeUrls;
	}

	public void setExcludeUrls(List<String> excludeUrls) {
		this.excludeUrls = excludeUrls;
	}

	private static final Logger logger = Logger
			.getLogger(WeixinCustomerAuthInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {

		String requestPath = ResourceUtil.getRequestPath(request);// 用户访问的资源地址
		logger.info("requestPath:" + requestPath); // "fo/binded/customerClaims/customerClaimsController.do?null"

		if (excludeUrls != null
				&& FBStringUtils.checkPathMatch(excludeUrls, requestPath))
			return true;

		String openid = processOpenid(request);

		String identifynumber = (String)CachedUtils.get(openid
				+ Constants.MEMKEY_IDENTIFYNUMBER);
		String customercname = (String) CachedUtils.get(openid
				+ Constants.MEMKEY_CUSTOMERCNAME);
		logger.info("从cache获取到的identifynumber => " + identifynumber
				+ " customercname => " + customercname);

		if (StringUtil.isEmpty(identifynumber)
				|| StringUtil.isEmpty(customercname)) {
			// 判断用户是否进行了微信绑定，如果未进行微信绑定，则跳转到绑定页面
			WeiXinGzUserInfo weiXinGzUserInfo = customerBindService
					.findUniqueByProperty(WeiXinGzUserInfo.class, "openid",
							openid);
			// 判断用户是否已关注 20141223
			/*
			 * if(weiXinGzUserInfo == null ||
			 * !WeiXinConstants.SUBSCRIBE_TYPE_VALUE
			 * .equals(weiXinGzUserInfo.getSubscribe())){
			 * request.setAttribute("message",
			 * Constants.WEIXINBIND_MESSAGE_NOT_SUBSCRIBE);
			 * request.getRequestDispatcher
			 * ("/webpage/fo/common/notSubscribe.jsp").forward(request,
			 * response); return false; }
			 */
			// 根据认证时间判断用户是否已绑定,modified by guofangfang 20150730
			if (weiXinGzUserInfo != null
					&& weiXinGzUserInfo.getBindTime() == null) {
				String url = "/fo/customerBindController.do?method=bindIndex&requestPath="
						+ requestPath;
				request.getRequestDispatcher(url).forward(request, response);
				return false;
			}

			identifynumber = weiXinGzUserInfo.getIdentifynumber();
			customercname = weiXinGzUserInfo.getCustomercname();

			CachedUtils.add(openid + Constants.MEMKEY_IDENTIFYNUMBER,
					identifynumber.toUpperCase());
			CachedUtils.add(openid + Constants.MEMKEY_CUSTOMERCNAME,
					customercname);
		}

		return true;
	}

	private String processOpenid(HttpServletRequest request){
		String code = request.getParameter("code");
		logger.info("code=>" + code);
		String openid = request.getParameter("openid");
		// GetOpenidInterceptor会根据code获取一次openid,set到attribute里
		if(StringUtil.isEmpty(openid)){
			openid = (String)request.getAttribute("openid");
		}
		logger.info("openid from request====>" + openid);
		if(StringUtil.isEmpty(openid)){

			DataSourceContextHolder
					.setDataSourceType(DataSourceType.dataSource_jeecg);
			List<WeixinAccountEntity> weixinAccountEntityList = weixinAccountService
					.findValidWeixinAccounts();
			WeixinAccountEntity weixinAccountEntity = weixinAccountEntityList
					.get(0);
			openid = WeixinUtil.getOpenId(
					weixinAccountEntity.getAccountappid(),
					weixinAccountEntity.getAccountappsecret(),code);
			logger.info("根据code获取 openid,获取到的openid=>" + openid);
		}
		request.setAttribute("openid",openid);
		return openid;
	}

}
