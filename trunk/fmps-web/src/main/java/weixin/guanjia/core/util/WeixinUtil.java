package weixin.guanjia.core.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.ConnectException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.servlet.http.HttpServletRequest;

import jodd.util.StringUtil;
import net.sf.json.JSONObject;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.jeecgframework.core.common.service.CommonService;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.util.ApplicationContextUtil;
import org.jeecgframework.core.util.JSONHelper;
import org.jeecgframework.core.util.ResourceUtil;
import org.jeecgframework.web.system.service.SystemService;

import weixin.guanjia.account.entity.WeixinAccountEntity;
import weixin.guanjia.account.service.WeixinAccountServiceI;
import weixin.guanjia.core.entity.common.AccessToken;
import weixin.guanjia.core.entity.model.AccessTokenYw;
import weixin.guanjia.message.entity.ReceiveMessage;
import weixin.guanjia.message.service.ReceiveMessageServiceI;
import weixin.popular.api.MediaAPI;
import weixin.popular.api.MediaAPI.MediaType;
import weixin.popular.api.MessageAPI;
import weixin.popular.bean.BaseResult;
import weixin.popular.bean.Media;
import weixin.popular.bean.message.ImageMessage;
import weixin.popular.bean.message.Message;
import weixin.popular.bean.message.TextMessage;
import weixin.popular.util.JsonUtil;
import weixin.util.WeiXinConstants;
import cn.com.fubon.fo.customerbind.entity.WeiXinGzUserInfo;
import cn.com.fubon.util.CachedUtils;
import cn.com.fubon.util.Constants;

/**
 * 公众平台通用接口工具类
 * 
 * @author liuyq
 * @date 2013-08-09
 */
public class WeixinUtil {
	// 获取access_token的接口地址（GET） 限200（次/天）
	public final static String access_token_url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
	// 菜单创建（POST） 限100（次/天）
	public static String menu_create_url = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";
	// 客服接口地址
	public static String send_message_url = "https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token=ACCESS_TOKEN";
	// 获取用户基本信息
	public static String get_customer_url = "https://api.weixin.qq.com/cgi-bin/user/info?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";
	// 获取code后，请求以下链接获取access_token(与基础支持中的access_token不同) 以及 OPENID ：
	public static String getAcces_token_url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code";

	// code过期后，可通过此URL重新获取openid
	public static String REFRESH_ACCESS_TOKEN_URL = "https://api.weixin.qq.com/sns/oauth2/refresh_token?appid= APPID&grant_type=refresh_token&refresh_token=REFRESH_TOKEN";
	// 获取微信服务器IP地址
	public static String get_WeChat_IP_URL = "https://api.weixin.qq.com/cgi-bin/getcallbackip?access_token=ACCESS_TOKEN";
	// 微信红包发放红包URL
	public static String CASHCOUPON_URL = "https://api.mch.weixin.qq.com/mmpaymkttransfers/sendredpack";
	// 查询红包发放结果URL
	public static String HBINFO_URL = "https://api.mch.weixin.qq.com/mmpaymkttransfers/gethbinfo";

	private static final Logger logger = Logger.getLogger(WeixinUtil.class);

	public static String getOpenId(String appID, String appSecret, String code) {
		if (StringUtil.isEmpty(code)) {
			logger.info("获取微信客户openid失败, 传的CODE为空。code==>" + code);
			return "";
		}

		// 先通过缓存获取openid
		String authorizationInfoJsonString = (String) CachedUtils.get(code);
		if (!StringUtils.isEmpty(authorizationInfoJsonString)) {
			logger.info("get authorization info from memcached. key===>" + code
					+ ";value===>" + authorizationInfoJsonString);
			JSONObject cachedAuthorizationInfo = JSONObject
					.fromObject(authorizationInfoJsonString);
			if (cachedAuthorizationInfo != null
					&& cachedAuthorizationInfo.has("access_token")) {			
				CachedUtils.add(Constants.OAUTH2_ACCESS_TOKEN+code,cachedAuthorizationInfo.getString("access_token"));  
			}
			
			if (cachedAuthorizationInfo != null
					&& cachedAuthorizationInfo.has("openid")) {
				return cachedAuthorizationInfo.getString("openid");
			}
		}

		logger.info("do not get authorization info from memcached, get open id from wechat server.");
		// 替换 发送微信的 url
		String requestUrl = getAcces_token_url.replace("APPID", appID)
				.replace("CODE", code).replace("SECRET", appSecret);
		// 发送 获取code
		JSONObject authorizationInfo = httpRequest(requestUrl, "GET", null);
		if (authorizationInfo == null)
			return "";

		logger.info("获取微信客户openid：" + requestUrl);
		logger.info("微信服务器返回的jsonobject为：" + authorizationInfo.toString());
		
		if (authorizationInfo != null
				&& authorizationInfo.has("access_token")) {			
			CachedUtils.add(Constants.OAUTH2_ACCESS_TOKEN+code,authorizationInfo.getString("access_token"));  
		}

		String openid = "";
		if (authorizationInfo.has("openid")) {
			openid = authorizationInfo.getString("openid");
			String expiresTime = authorizationInfo.getString("expires_in");
			CachedUtils.add(code, Integer.parseInt(expiresTime),
					authorizationInfo.toString());
			logger.info("set authorizationInfo to memcached. key===>" + code
					+ ";value===>" + authorizationInfo.toString()
					+ ";expiresTime===>" + expiresTime);
		}
		return openid;
	}

	/**
	 * 发起https请求并获取结果
	 * 
	 * @param requestUrl
	 *            请求地址
	 * @param requestMethod
	 *            请求方式（GET、POST）
	 * @param outputStr
	 *            提交的数据
	 * @return JSONObject(通过JSONObject.get(key)的方式获取json对象的属性值)
	 */
	public static JSONObject httpRequest(String requestUrl,
			String requestMethod, String outputStr) {
		JSONObject jsonObject = null;
		StringBuffer buffer = new StringBuffer();
		try {
			// 创建SSLContext对象，并使用我们指定的信任管理器初始化
			TrustManager[] tm = { new MyX509TrustManager() };
			SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
			sslContext.init(null, tm, new java.security.SecureRandom());
			// 从上述SSLContext对象中得到SSLSocketFactory对象
			SSLSocketFactory ssf = sslContext.getSocketFactory();

			URL url = new URL(requestUrl);
			HttpsURLConnection httpUrlConn = (HttpsURLConnection) url
					.openConnection();
			httpUrlConn.setSSLSocketFactory(ssf);

			httpUrlConn.setDoOutput(true);
			httpUrlConn.setDoInput(true);
			httpUrlConn.setUseCaches(false);
			// 设置请求方式（GET/POST）
			httpUrlConn.setRequestMethod(requestMethod);

			if ("GET".equalsIgnoreCase(requestMethod))
				httpUrlConn.connect();

			// 当有数据需要提交时
			if (null != outputStr) {
				OutputStream outputStream = httpUrlConn.getOutputStream();
				// 注意编码格式，防止中文乱码
				outputStream.write(outputStr.getBytes("UTF-8"));
				outputStream.close();
			}

			// 将返回的输入流转换成字符串
			InputStream inputStream = httpUrlConn.getInputStream();
			InputStreamReader inputStreamReader = new InputStreamReader(
					inputStream, "utf-8");
			BufferedReader bufferedReader = new BufferedReader(
					inputStreamReader);

			String str = null;
			while ((str = bufferedReader.readLine()) != null) {
				buffer.append(str);
			}
			bufferedReader.close();
			inputStreamReader.close();
			// 释放资源
			inputStream.close();
			inputStream = null;
			httpUrlConn.disconnect();
			jsonObject = JSONObject.fromObject(buffer.toString());
			// jsonObject = JSONObject.fromObject(buffer.toString());
		} catch (ConnectException ce) {
			org.jeecgframework.core.util.LogUtil
					.info("Weixin server connection timed out.");
		} catch (Exception e) {
			org.jeecgframework.core.util.LogUtil.error("https request error:{}"
					+ e.getMessage());
		}
		return jsonObject;
	}

	/**
	 * 获取access_token
	 * 
	 * @param appid
	 *            凭证
	 * @param appsecret
	 *            密钥
	 * @return
	 */
	public static AccessToken getAccessToken(SystemService systemService,
			String appid, String appsecret) {
		// 第三方用户唯一凭证
		// String appid = bundle.getString("appId");
		// // 第三方用户唯一凭证密钥
		// String appsecret = bundle.getString("appSecret");

		AccessTokenYw accessTocken = getRealAccessToken(systemService);

		if (accessTocken != null) {
			java.util.Date end = new java.util.Date();
			if (end.getTime() - accessTocken.getAddTime().getTime() > accessTocken
					.getExpires_in() * 1000) {
				AccessToken accessToken = null;
				String requestUrl = access_token_url.replace("APPID", appid)
						.replace("APPSECRET", appsecret);
				JSONObject jsonObject = httpRequest(requestUrl, "GET", null);
				// 如果请求成功
				if (null != jsonObject) {
					try {
						accessToken = new AccessToken();
						accessToken.setToken(jsonObject
								.getString("access_token"));
						accessToken.setExpiresIn(jsonObject
								.getInt("expires_in"));
						// 凭证过期更新凭证
						AccessTokenYw atyw = new AccessTokenYw();
						atyw.setId(accessTocken.getId());
						atyw.setExpires_in(jsonObject.getInt("expires_in"));
						atyw.setAccess_token(jsonObject
								.getString("access_token"));
						updateAccessToken(atyw, systemService);
					} catch (Exception e) {
						accessToken = null;
						// 获取token失败
						String wrongMessage = "获取token失败 errcode:{} errmsg:{}"
								+ jsonObject
										.getString(WeiXinConstants.WEIXIN_RETURN_JSON_KEY_ERROR_CODE)
								+ jsonObject
										.getString(WeiXinConstants.WEIXIN_RETURN_JSON_KEY_ERROR_MESSAGE);
						org.jeecgframework.core.util.LogUtil.info(wrongMessage);
					}
				}
				return accessToken;
			} else {

				AccessToken accessToken = new AccessToken();
				accessToken.setToken(accessTocken.getAccess_token());
				accessToken.setExpiresIn(accessTocken.getExpires_in());
				return accessToken;
			}
		} else {

			AccessToken accessToken = null;
			String requestUrl = access_token_url.replace("APPID", appid)
					.replace("APPSECRET", appsecret);
			JSONObject jsonObject = httpRequest(requestUrl, "GET", null);
			// 如果请求成功
			if (null != jsonObject) {
				try {
					accessToken = new AccessToken();
					accessToken.setToken(jsonObject.getString("access_token"));
					accessToken.setExpiresIn(jsonObject.getInt("expires_in"));

					AccessTokenYw atyw = new AccessTokenYw();
					atyw.setExpires_in(jsonObject.getInt("expires_in"));
					atyw.setAccess_token(jsonObject.getString("access_token"));
					saveAccessToken(atyw, systemService);

				} catch (Exception e) {
					accessToken = null;
					// 获取token失败
					String wrongMessage = "获取token失败 errcode:{} errmsg:{}"
							+ jsonObject
									.getString(WeiXinConstants.WEIXIN_RETURN_JSON_KEY_ERROR_CODE)
							+ jsonObject
									.getString(WeiXinConstants.WEIXIN_RETURN_JSON_KEY_ERROR_MESSAGE);
					org.jeecgframework.core.util.LogUtil.info(wrongMessage);
				}
			}
			return accessToken;
		}
	}

	/**
	 * 从数据库中读取凭证
	 * 
	 * @return
	 */
	public static AccessTokenYw getRealAccessToken(SystemService systemService) {
		List<AccessTokenYw> accessTockenList = systemService
				.findByQueryString("from AccessTokenYw");
		return accessTockenList.get(0);
	}

	/**
	 * 保存凭证
	 * 
	 * @return
	 */
	public static void saveAccessToken(AccessTokenYw accessTocken,
			SystemService systemService) {
		systemService.save(accessTocken);
	}

	/**
	 * 更新凭证
	 * 
	 * @return
	 */
	public static void updateAccessToken(AccessTokenYw accessTocken,
			SystemService systemService) {
		String sql = "update accesstoken set access_token='"
				+ accessTocken.getAccess_token() + "',expires_ib="
				+ accessTocken.getExpires_in() + ",addtime=now() where id='"
				+ accessTocken.getId() + "'";
		systemService.updateBySqlString(sql);
	}

	/**
	 * 编码
	 * 
	 * @param bstr
	 * @return String
	 */
	public static String encode(byte[] bstr) {
		return new sun.misc.BASE64Encoder().encode(bstr);
	}

	/**
	 * 解码
	 * 
	 * @param str
	 * @return string
	 */
	public static byte[] decode(String str) {

		byte[] bt = null;
		try {
			sun.misc.BASE64Decoder decoder = new sun.misc.BASE64Decoder();
			bt = decoder.decodeBuffer(str);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return bt;

	}

	/**
	 * 微信版本判断 patrick.z 20141225
	 * 
	 * @param request
	 * @return
	 */
	public static int getWechatVersion(HttpServletRequest request) {
		String userAgent = request.getHeader("USER-AGENT");
		int versionNum = 0;
		if (userAgent.length() > 9) {
			String version = userAgent.substring(8, 9);
			versionNum = Integer.parseInt(version);
		}
		return versionNum;
	}

	/**
	 * @param openid
	 *            接收客户的OPENID
	 * @param msgtype
	 *            消息类型 text：文本消息 image
	 * @param content
	 *            对应 消息类型 text 为字符串， image 为 图片的路径
	 * @return 返回空字符表示成功，非空为错误描述
	 */

	public static String sendCustomerServiceMessage(String openid,
			String msgtype, String content) {
		String retMessage = "";
		Message message;
		MessageAPI messageAPI = new MessageAPI();
		MediaAPI MediaAPI = new MediaAPI();
		WeixinAccountServiceI weChatContextService = (WeixinAccountServiceI) ApplicationContextUtil
				.getContext().getBean("weixinAccountService");
		String access_token = weChatContextService
				.getAccessTokenFromAccountEntity();
		// access_token="b6U44P6oc1DpxFNTdvUOtWVqV2m6sd5z0Grm-glzsdW-eQ_b2xaF54HBU_-3oDOSIrqeBZL8gTZowvgQy5Zt7iIQ8k2t8tc85oUSz22Px4Y";
		int begin = 0;
		int end = 0;
		int step = 800;
		do {
			begin = end;
			end = begin + step;
			if (end > content.length())
				end = content.length();
			if (msgtype == "text") {
				message = new TextMessage(openid, content.substring(begin, end));
			} else if (msgtype == "image") {
				Media media = MediaAPI.mediaUpload(access_token,
						MediaType.image, new File(content));
				String media_id = media.getMedia_id();
				if (StringUtil.isEmpty(media_id))
					return retMessage = "微信图片上传错误，请确认图片大小、格式。";
				message = new ImageMessage(openid, media_id);
			} else {
				return retMessage = "不支持的文件类型";
			}

			BaseResult baseResult = messageAPI.messageCustomSend(access_token,
					message);
			retMessage = baseResult.getErrmsg();
			logger.info("sendCustomerServiceMessage==openid==>" + openid);
			logger.debug("sendCustomerServiceMessage==content==>" + content);
			logger.info("sendCustomerServiceMessage=return=ErrorMessage==>"
					+ baseResult.getErrmsg());
			logger.info("sendCustomerServiceMessage=return=ErrorCode==>"
					+ baseResult.getErrcode());
		} while (end < content.length());

		return retMessage;
	}

	/**
	 * 不阻塞下载多媒体,调用方不需要等待返回
	 * 
	 * @param mediaId
	 */
	public static void nonBlockingDownloadMedia(String mediaId) {
		downloadMedia(mediaId, false);
	}

	/**
	 * 阻塞下载多媒体,调用方需要等待返回
	 * 
	 * @param mediaId
	 * @return
	 */
	public static byte[] blockingDownloadMedia(String mediaId) {
		return downloadMedia(mediaId, true);
	}

	/**
	 * 下载多媒体核心方法
	 * 
	 * @return
	 */
	public static byte[] downloadMedia(String mediaId, boolean isBlocking) {
		logger.info("\nmediaId==>" + mediaId + "\nisBlocking==>" + isBlocking);
		WeixinAccountServiceI weixinAccountService = (WeixinAccountServiceI) ApplicationContextUtil
				.getContext().getBean("weixinAccountService");
		ReceiveMessageServiceI receiveMessageService = (ReceiveMessageServiceI) ApplicationContextUtil
				.getContext().getBean("receiveMessageService");
		final CommonService commonService = (CommonService) ApplicationContextUtil
				.getContext().getBean("commonService");

		String access_token = weixinAccountService
				.getAccessTokenFromAccountEntity();
		final ReceiveMessage receiveMessage = receiveMessageService
				.findUniqueByProperty(ReceiveMessage.class, "mediaId", mediaId);

		if (receiveMessage == null) {
			logger.info("receiveMessage is null, this media not existed。mediaId===>"
					+ mediaId);
			return null;
		}

		if (StringUtil.isNotEmpty(receiveMessage.getPath())) {
			File file = new File(receiveMessage.getPath());
			if (file.exists()) {
				logger.info("downloadMedia file exists path==>"
						+ receiveMessage.getPath());
				try {
					return FileUtils.readFileToByteArray(file);
				} catch (IOException e) {
					logger.info("reading media file failured, the path==>"
							+ file.getPath() + "; cause by " + e.getMessage());
					e.printStackTrace();
				}
			}
		}

		ExecutorService pool = null;
		try {
			pool = Executors.newCachedThreadPool();
			FutureTask<byte[]> task = new FutureTask<>(new MediaGetCallable(
					commonService, receiveMessage, access_token, mediaId));
			pool.submit(task);
			pool.shutdown();

			if (isBlocking)
				return task.get();
		} catch (InterruptedException e) {
			logger.info("downloadMedia latch.await failured, cause by "
					+ e.getMessage());
			e.printStackTrace();
		} catch (ExecutionException ee) {
			logger.info("responseFuture get failured, cause by "
					+ ee.getMessage());
			ee.printStackTrace();
		}

		return null;
	}

	/**
	 * 重定向到获取openid的地址
	 * 
	 * @param state
	 * @return url 重定向的地址
	 */
	public static String redirectUrlForOpenId(String uri, String state,
			boolean isRedirect) {
		// redirect_uri做encode
		String redirect_uri = null;
		try {
			redirect_uri = URLEncoder.encode(uri, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			logger.error(
					"redirectUrlForOpenId encode uri UnsupportedEncodingException",
					e);
		}
		String url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid={APPID}&redirect_uri={domain}"
				+ redirect_uri
				+ "&response_type=code&scope=snsapi_base&state="
				+ state + "#wechat_redirect";
		if (isRedirect) {
			url = "redirect:" + url;
		}
		logger.info("redirectUrlForOpenId url==>" + url);
		String domain = ResourceUtil.getDomain();
		WeixinAccountServiceI weixinAccountService = (WeixinAccountServiceI) ApplicationContextUtil
				.getContext().getBean("weixinAccountService");
		List<WeixinAccountEntity> weixinAccountEntityList = weixinAccountService
				.findValidWeixinAccounts();
		WeixinAccountEntity weixinAccountEntity = weixinAccountEntityList
				.get(0);
		url = url.replace("{APPID}", weixinAccountEntity.getAccountappid())
				.replace("{domain}", domain);

		return url;
	}

	/**
	 * 根据openid判断用户是否关注公众号
	 * 
	 * @param openid
	 * @return
	 */
	public static boolean isSubscribe(String openid,String activedProfile){
		
		//根据关注user.subscribe判断是否关注
		if(null != CachedUtils.get(openid + Constants.MEMKEY_WEIXIN_GZUSERINFO)
			&& WeiXinConstants.SUBSCRIBE_TYPE_VALUE.equals(
					((WeiXinGzUserInfo)CachedUtils.get(openid + Constants.MEMKEY_WEIXIN_GZUSERINFO))
					.getSubscribe())
			){
			logger.debug("memcache WeiXinGzUserInfo.getSubscribe()==1,openid=>" + openid);
			return true;
		}
		
		CommonService commonService = (CommonService)ApplicationContextUtil
				.getContext().getBean("commonService");
		WeiXinGzUserInfo userinfo = commonService.findUniqueByProperty(
				WeiXinGzUserInfo.class,"openid",openid);
		if(userinfo != null && WeiXinConstants.SUBSCRIBE_TYPE_VALUE.equals(userinfo.getSubscribe())){
			logger.debug("exists in weixin_gzuserinfo openid=>" + openid + ",id=>" + userinfo.getId());
			String mobilekey = openid + "mobile";
			String mobile = (String)CachedUtils.get(mobilekey);
			if(StringUtil.isEmpty(mobile)
					&& StringUtil.isNotEmpty(userinfo.getMobile())){
				CachedUtils.add(mobilekey,userinfo.getMobile());
			}
			
			if(null == CachedUtils.get(openid + Constants.MEMKEY_WEIXIN_GZUSERINFO)){
				CachedUtils.add(openid + Constants.MEMKEY_WEIXIN_GZUSERINFO,userinfo);
			}
			
			return true;
		}
		
		if("prod".equals(activedProfile)){
			WeixinAccountServiceI weixinAccountService = (WeixinAccountServiceI)ApplicationContextUtil
					.getContext().getBean("weixinAccountService");
			String access_token = weixinAccountService
					.getAccessTokenFromAccountEntity();
			String requestUrl = get_customer_url.replace("OPENID",openid)
					.replace("ACCESS_TOKEN",access_token);
			JSONObject userInfo = httpRequest(requestUrl,"GET",null);
			Object subscribe = userInfo.get("subscribe");
			if(subscribe != null && "1".equals(userInfo.getString("subscribe"))){
				logger.debug("通过微信公众号查询用户信息接口查询用户已关注...openid=" + openid);
				try {				
				//WeiXinGzUserInfo weiXinGzUserInfo = (WeiXinGzUserInfo)JSONHelper.json2Object(userInfo.toString(),WeiXinGzUserInfo.class);
				WeiXinGzUserInfo weiXinGzUserInfo = JsonUtil.parseObject(userInfo.toString(),	WeiXinGzUserInfo.class);
				Date nowtime = new Date();
				weiXinGzUserInfo.setAddtime(nowtime);
				//weiXinGzUserInfo.setSubscribeTime(nowtime);
				//不用显示setId,id会自动产生,放到memcache在爱车之家违章代缴用到
				commonService.save(weiXinGzUserInfo);
				logger.debug("isSubscribe prod http weiXinGzUserInfo.getId()==>"+ weiXinGzUserInfo.getId());
				CachedUtils.add(openid + Constants.MEMKEY_WEIXIN_GZUSERINFO,weiXinGzUserInfo);
				} catch (Exception e) {
					logger.info("拦截器保存关注用户失败====openid====>"+openid);					
				}
				return true;
			}else{
				// 记录获取用户基本信息接口返回的异常信息
				SystemService systemService = (SystemService)ApplicationContextUtil
						.getContext().getBean("systemService");
				systemService.addLog(userInfo.toString(),
						Globals.Log_Type_OTHER,Globals.Log_Leavel_WARRING);
				return false;
			}
		}
		
		return false;
	}
	
}