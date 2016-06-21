package cn.com.fubon.fo.customerhonortitle.controller;

import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.jeecgframework.core.util.ResourceUtil;
import org.jeecgframework.core.util.StringUtil;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import weixin.guanjia.account.entity.WeixinAccountEntity;
import weixin.guanjia.account.service.WeixinAccountServiceI;
import weixin.guanjia.core.util.WeixinUtil;
import weixin.util.WeiXinConstants;
import cn.com.fubon.fo.customerbind.entity.WeiXinGzUserInfo;
import cn.com.fubon.fo.customerbind.service.CustomerBindService;
import cn.com.fubon.fo.customerhonortitle.service.CustomerHonorTitleService;
import cn.com.fubon.fo.customerpremranking.service.CustomerPremRankingService;

@Scope("prototype")
@Controller
@RequestMapping("/fo/binded/customerHonorTitleController")
public class CustomerHonorTitleController {
	private static final Logger logger = Logger.getLogger(CustomerHonorTitleController.class);
	
	@Resource
	private CustomerHonorTitleService customerHonorTitleService;
	@Resource
	private CustomerPremRankingService customerPremRankingService;
	@Resource
	private CustomerBindService customerBindService;
	@Resource
	private WeixinAccountServiceI weixinAccountService;
	
	/**
	 * 返回称号页面前
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "method=customerHonorTitle")
	public String customerHonorTitle(HttpServletRequest request) {
		String openid = request.getParameter("openid");
		if (StringUtils.isEmpty(openid)) {
			openid = (String)request.getAttribute("openid");
		}
		logger.info("customerHonorTitle write openid to cache==>" + openid);
		
		//url是分享到朋友圈的链接，用redirect目的是把from作为分享人标识带到链接上
		String url = "redirect:/fo/binded/customerHonorTitleController.do?method=customerHonorTitleAfter&state=" + openid;
		logger.info("customerHonorTitle redirect url==>" + url);
		return url;		
	}
	

	
	
	/**
	 * 返回称号页面
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "method=customerHonorTitleAfter")
	public String customerHonorTitleAfter(HttpServletRequest request) {
		//fromopenid是分享人的openid
		String fromopenid = request.getParameter("state");
		logger.info("customerHonorTitleAfter fromopenid==>" + fromopenid);
		
		//如果openid为空，再转发给微信根据code取openid begin
		String code=request.getParameter("code");
		logger.info("customerHonorTitleAfter code=>" + code);
		String openid = request.getParameter("openid");
		if (StringUtils.isEmpty(openid)) {
			openid = (String)request.getAttribute("openid");
		}
		
		logger.info("customerHonorTitleAfter request openid==>" + openid);
		if(!StringUtil.isEmpty(code)){
			openid = getOpenId(code);
			//如果openid获取失败，要跳到错误提示页面；否则可能会陷入死循环
			if(StringUtils.isEmpty(openid)){
				logger.info("customerHonorTitleAfter get openid failed");
				request.setAttribute("message", "openid获取失败");
				return "/fo/common/message";
			}
		}

		//openid为空，通过snsapi_base重定向到当前的方法，目的是返回code
		if(StringUtils.isEmpty(openid)){
			return redirectToGetOpenId(fromopenid);
		}
		
		//如果当前访问人没有关注富邦，则页面不显示“查看我的称号”按钮
		WeiXinGzUserInfo currentGZUser = customerBindService.findUniqueByProperty(WeiXinGzUserInfo.class, "openid", openid);
		if(currentGZUser == null || !WeiXinConstants.SUBSCRIBE_TYPE_VALUE.equals(currentGZUser.getSubscribe())){
			request.setAttribute("subscribed", "您尚未关注我司公众号，可在微信公众号搜索“富邦财险”进行关注。");
		}
		//如果openid为空，再转发给微信根据code取openid end
		
		//根据分享人的openid查询昵称和称号
		String nickname = null;
		WeiXinGzUserInfo iWeiXinGzUserInfo = customerBindService.findUniqueByProperty(WeiXinGzUserInfo.class, "openid", fromopenid);		
		if(!fromopenid.equals(openid)){
			if(iWeiXinGzUserInfo != null){
				nickname = iWeiXinGzUserInfo.getNickname();
			}
		}
		
		String customername = null;
		if(!StringUtils.isEmpty(iWeiXinGzUserInfo.getCustomercname())){
			customername = "*"+iWeiXinGzUserInfo.getCustomercname().substring(1);
		}
		
		//称号页面的欢迎词,如果是本人就提示已认证,否则提示分享人正在参加富邦封神榜
		String welcomeDesc = "您已认证成功，欢迎体验富邦贴心的微信服务。";
		if(!StringUtils.isEmpty(nickname)){
			welcomeDesc = nickname + " 正在参加富邦财险保费排名封神榜。";
		}
		request.setAttribute("nickname", nickname);
		request.setAttribute("welcomeDesc", welcomeDesc);
		
		//查询称号和当前客户保费排名进到称号页面
		Map<String,Object> customerPremRanking = customerPremRankingService.customerPremRanking(iWeiXinGzUserInfo.getIdentifynumber(),customername);
		request.setAttribute("rank", customerPremRanking!=null?(Integer)customerPremRanking.get("rank"):null);
		request.setAttribute("honor_name", customerPremRanking!=null?(String)customerPremRanking.get("honor_name"):null);
		request.setAttribute("honor_desc", customerPremRanking!=null?(String)customerPremRanking.get("honor_desc"):null);
		request.setAttribute("openid", openid);
		
		return "/fo/customerhonortitle/customerHonorTitle";
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
		logger.info("customerHonorTitleAfter code to openid=>" + openid); 
		
		return openid;
	}
	
	/**
	 * 重定向到获取openid的地址
	 * 
	 * @param fromopenid
	 * @return
	 */
	private String redirectToGetOpenId(String fromopenid){
		String url = "redirect:https://open.weixin.qq.com/connect/oauth2/authorize?appid={APPID}&redirect_uri={domain}/fo/binded/customerHonorTitleController.do?method=customerHonorTitleAfter"
				+ "&response_type=code&scope=snsapi_base&state=" + fromopenid + "#wechat_redirect";
		String domain= ResourceUtil.getDomain();
		List<WeixinAccountEntity> weixinAccountEntityList = weixinAccountService.findValidWeixinAccounts();
		WeixinAccountEntity weixinAccountEntity = weixinAccountEntityList.get(0);
		url= url.replace("{APPID}", weixinAccountEntity.getAccountappid()).replace("{domain}", domain) ;
		logger.info("customerHonorTitleAfter redirect url==>" + url);
		
		return url;
	}

}
