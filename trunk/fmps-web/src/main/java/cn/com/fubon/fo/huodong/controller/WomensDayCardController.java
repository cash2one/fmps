package cn.com.fubon.fo.huodong.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.service.CommonService;
import org.jeecgframework.core.util.DateUtils;
import org.jeecgframework.core.util.ResourceUtil;
import org.jeecgframework.core.util.StringUtil;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import weixin.guanjia.account.entity.WeixinAccountEntity;
import weixin.guanjia.account.service.WeixinAccountServiceI;
import weixin.guanjia.core.util.WeixinUtil;
import cn.com.fubon.util.Constants;

@Scope("prototype")
@Controller
@RequestMapping("/fo/womensDayCardController")
public class WomensDayCardController {
	private static final Logger logger = Logger.getLogger(WomensDayCardController.class);

	@Resource(name="commonService")
	private CommonService commonService;
	@Resource
	private WeixinAccountServiceI weixinAccountService;
	
	/**
	 * 三八活动女王令入口
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "method=womensDayIndex")
	public String womensDayIndex(HttpServletRequest request){
		//只在活动起止时间内才可访问,type=3是激活卡活动
		long countHuodong = commonService.getCountForJdbc("select COUNT(1) from weixin_huodong where CURRENT_TIMESTAMP() "
				+ " between starttime and endtime and type=3");
		if(countHuodong == 0){
			request.setAttribute("message", "该活动未开启或已结束!");
			return "/fo/common/message";
		}
		
		//如果openid为空，再转发给微信根据code取openid begin
		String openid = request.getParameter("openid");
		if (StringUtils.isEmpty(openid)) {
			openid = (String)request.getAttribute("openid");
		}
		logger.info("womensDayIndex openid=" + openid);
		
		//如果openid为空，再转发给微信根据code取openid begin
		String code=request.getParameter("code");

		if(!StringUtil.isEmpty(code)){
			openid = getOpenId(code);
			//如果openid获取失败，要跳到错误提示页面；否则可能会陷入死循环
			if(StringUtils.isEmpty(openid)){
				logger.info("womensDayIndex get openid failed");
				request.setAttribute("message", "openid获取失败");
				return "/fo/common/message";
			}
		}

		//openid为空，通过snsapi_base重定向到当前的方法，目的是返回code
		if(StringUtils.isEmpty(openid)){
			String redirectUri = "{domain}/fo/womensDayCardController.do?method=womensDayIndexAfter";
			return redirectToGetOpenId(null,redirectUri);
		}
		
		//url是分享到朋友圈的链接，用redirect目的是把from作为分享人标识带到链接上
		String url = "redirect:/fo/womensDayCardController.do?method=womensDayIndexAfter&state=" + openid;
		logger.info("womensDayIndex redirect url=" + url);
		return url;
	}
	
	/**
	 * 三八活动女王令首页
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "method=womensDayIndexAfter")
	public String womensDayIndexAfter(HttpServletRequest request){
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
				logger.info("womensDayIndexAfter get openid failed");
				request.setAttribute("message", "openid获取失败");
				return "/fo/common/message";
			}
		}
//openid="owJamuIfaiKgTu7OxGNSHEFSQumQ";
		//openid为空，通过snsapi_base重定向到当前的方法，目的是返回code
		if(StringUtils.isEmpty(openid)){
			String redirectUri = "{domain}/fo/womensDayCardController.do?method=womensDayIndexAfter";
			return redirectToGetOpenId(fromopenid,redirectUri);
		}
		
		//如果分享人不为空,查询分享人的女王令title和content否则查询本人的女王令
		Map<String,Object> titleMap = commonService.findOneForJdbc("select title,content from weixin_huodong_card_title where openid = ?", fromopenid);
		if(titleMap != null){
			request.setAttribute("title", titleMap.get("title"));
			request.setAttribute("content", titleMap.get("content"));
		}
		request.setAttribute("openid", openid);
//		// 页面JS SDK  开始		  
//		String accessToken = weixinAccountService.getAccessTokenFromAccountEntity();
//		List<WeixinAccountEntity> weixinAccountEntityList = weixinAccountService.findValidWeixinAccounts();
//		WeixinAccountEntity weixinAccountEntity = weixinAccountEntityList.get(0);
//	    String  appid = weixinAccountEntity.getAccountappid();
//	    
//	    String url = request.getRequestURL() + "?" + request.getQueryString();
//	    logger.info("womensDayCar url ===>" + url);
//	    JsSdkUtil  JsSdkUtil=new JsSdkUtil (url, appid, accessToken);
//	    String  JSONString = JsSdkUtil.getWxConfigJSONString();    
//	    System.out.println("<==================================>"+JSONString);
//	    request.setAttribute("JSONString", JSONString);	    
//		//  JS SDK 结束 
	    
		return "/fo/huodong/card/womensDayIndex";
	}
	
	/**
	 * 切换女王令
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(params = "method=changeTitle")
	public AjaxJson changeTitle(HttpServletRequest request){
		AjaxJson j = new AjaxJson();
		String openid = request.getParameter("openid");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		if(StringUtil.isEmpty(openid)){
			j.setMsg("**openid为空!");
            j.setSuccess(false);
		}else{
			//先查询是否已经有该openid的女王令数据,没有的话新增一条,否则更新
			long countTitle = commonService.getCountForJdbcParam("select count(1) from weixin_huodong_card_title where openid = ?", new Object[]{openid});
			if(countTitle == 0){
				//新增
				commonService.executeSql("insert into weixin_huodong_card_title(openid,title,content) values(?,?,?)",openid,title,content);
			}else{
				//更新
				commonService.executeSql("update weixin_huodong_card_title set title = ?,content = ? where openid = ?",title,content,openid);
			}
            j.setSuccess(true);
		}
		return j;
	}
	
	/**
	 * 三八活动进领卡页面
	 * @param request
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping(params = "method=prepareReceiveCard")
	public String prepareReceiveCard(HttpServletRequest request) throws ParseException, UnsupportedEncodingException{
		//20150727 推文赠险和活动关联
		String huodongid = request.getParameter("state");
		logger.info("prepareReceiveCard huodongid==>" + huodongid);
		String openid = request.getParameter("openid");
		if(StringUtil.isEmpty(openid)){
			openid = (String)request.getAttribute("openid");
		}
		logger.info("prepareReceiveCard openid from request==>" + openid);
		
		//20150727 推文赠险 added by guo begin
		 String code = request.getParameter("code");
		 logger.info("prepareReceiveCard code=>" + code);
		 
		if(StringUtil.isNotEmpty(code)){
			openid = getOpenId(code);
			logger.info("prepareReceiveCard openid from code==>" + openid);
			//如果openid获取失败，要跳到错误提示页面；否则可能会陷入死循环
			if(StringUtils.isEmpty(openid)){
				logger.info("prepareReceiveCard get openid failed");
				request.setAttribute("message", "openid获取失败");
				return "/fo/common/message";
			}
		}

		//openid为空，通过snsapi_base重定向到当前的方法，目的是返回code
		if(StringUtils.isEmpty(openid)){
			String redirectUri = "{domain}/fo/womensDayCardController.do?method=prepareReceiveCard";
			return redirectToGetOpenId(huodongid,redirectUri);
		}
			
		request.setAttribute("openid", openid);
		request.setAttribute("huodongid", huodongid);
		//20150727 推文赠险 added by guo end	
		
		//判断该微信号是否已经领取过礼包,每微信号仅限领取一份
		long receiveCount = commonService.getCountForJdbcParam("select COUNT(1) from weixin_huodong_card where openid = ? and huodongid = ? ",new String[]{openid,huodongid});
		if(receiveCount > 0){
			request.setAttribute("receiveCount", String.valueOf(receiveCount));
		}
		
		return "/fo/huodong/card/receiveCard";
	}

	/**
	 * 三八活动领卡
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "method=receiveCard")
	public String receiveCard(HttpServletRequest request){
		String huodongid = request.getParameter("huodongid");
		logger.info("receiveCard huodongid==>" + huodongid);
		
		String openid = request.getParameter("openid");
		
		if(StringUtils.isEmpty(openid)){
			request.setAttribute("message", "openid为空!");
			return "/fo/common/message";
		}
		
		//如果卡号不为空,表示已经领取过悠游卡,返回成功页面即可(如果是第一次领取,卡号为空,从数据库查防止用户用返回按钮后重复领卡)
		//判断该微信号是否已经领取过礼包,每微信号仅限领取一份
		Map<String, Object> map = commonService.findOneForJdbc("select cardno,password,receivetime from weixin_huodong_card where openid = ? and huodongid = ? ",openid,huodongid);
		if(map != null && map.size() > 0){
			request.setAttribute("cardno", map.get("cardno"));
			request.setAttribute("password", map.get("password"));
			request.setAttribute("receivetime", DateUtils.formatDate(new Date(((Timestamp)map.get("receivetime")).getTime()), "yyyy-MM-dd HH:mm:ss"));
			
		}else{
			
			//随机从活动激活卡表取一张未领用的卡号及密码
			List<Map<String,Object>> availableCards = commonService.findForJdbc("select cardno,password from weixin_huodong_card where receivetime is null and huodongid = ?",huodongid);
			
			if(availableCards != null && availableCards.size() > 0){
				String cardno = (String)availableCards.get(0).get("cardno");
				String password = (String)availableCards.get(0).get("password");
				request.setAttribute("cardno", cardno);
				request.setAttribute("password", password);
				
				//更新活动激活卡表信息
				commonService.executeSql("update weixin_huodong_card set openid=?,receivetime=CURRENT_TIMESTAMP() where cardno=? and password=? and huodongid = ?", openid,cardno,password,huodongid);
				
				
			}else{
				request.setAttribute("message", "赠卡已全部领完，如有疑问，请致电4008-817-518。");
				return "/fo/common/message";
			}
			
		}
		
		//返回领卡成功页面
		return "/fo/huodong/card/receiveCardSuccess";

	}
	
	/**
	 * 安卓阅读条款
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "method=readClause")
	public String readClause(HttpServletRequest request){
		//附件地址fileUrl
		String fileUrl = request.getParameter("fileUrl");
		String userAgent = request.getHeader("user-agent");
		if (userAgent.indexOf("Android") != -1) {
			request.setAttribute("fileUrl", fileUrl);
			return "/fo/huodong/card/down-attachment";
		} else {
			String urlhead = fileUrl.substring(0, fileUrl.lastIndexOf("/") + 1);
			String urltail = fileUrl.substring(fileUrl.lastIndexOf("/") + 1,
					fileUrl.length());
			fileUrl = urlhead + URLEncoder.encode(urltail);
			return "redirect:" + fileUrl;
		}
		
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
		logger.info("code to openid=>" + openid); 
		
		return openid;
	}
	
	/**
	 * 重定向到获取openid的地址
	 * 
	 * @return
	 */
	private String redirectToGetOpenId(String state,String redirectUri){
		String url = "redirect:https://open.weixin.qq.com/connect/oauth2/authorize?appid={APPID}&redirect_uri=" + redirectUri
				+ "&response_type=code&scope=snsapi_base&state=" + state + "#wechat_redirect";
		String domain= ResourceUtil.getDomain();
		List<WeixinAccountEntity> weixinAccountEntityList = weixinAccountService.findValidWeixinAccounts();
		WeixinAccountEntity weixinAccountEntity = weixinAccountEntityList.get(0);
		url= url.replace("{APPID}", weixinAccountEntity.getAccountappid()).replace("{domain}", domain) ;
		logger.info("redirect url==>" + url);
		
		return url;
	}
}
