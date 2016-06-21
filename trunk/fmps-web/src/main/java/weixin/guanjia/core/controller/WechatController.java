package weixin.guanjia.core.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.util.IpUtil;
import org.jeecgframework.web.system.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cn.com.fubon.util.CachedUtils;
import cn.com.fubon.util.Constants;
import weixin.guanjia.account.entity.WeixinAccountEntity;
import weixin.guanjia.account.service.WeixinAccountServiceI;
import weixin.guanjia.core.service.impl.WechatService;
import weixin.guanjia.core.util.SignUtil;

@Controller
@RequestMapping("/wechatController")
public class WechatController {
	@Autowired
	private WechatService wechatService;
	@Autowired
	private WeixinAccountServiceI weixinAccountService;
	@Autowired
	private SystemService systemService;
	private static final Logger logger = Logger
			.getLogger(WechatController.class);

	@RequestMapping(params = "wechat", method = RequestMethod.GET)
	public void wechatGet(HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam(value = "signature") String signature,
			@RequestParam(value = "timestamp") String timestamp,
			@RequestParam(value = "nonce") String nonce,
			@RequestParam(value = "echostr") String echostr) {
		logger.info("进入验证方法参数如下：signature：" + signature + " timestamp:"
				+ timestamp + " nonce" + nonce + " echostr" + echostr);
		List<WeixinAccountEntity> weixinAccountEntities = weixinAccountService
				.getList(WeixinAccountEntity.class);
		for (WeixinAccountEntity account : weixinAccountEntities) {
//			logger.info("进入验证方法FOR内部 ：account.getAccounttoken()："
//					+ account.getAccounttoken());
			if (SignUtil.checkSignature(account.getAccounttoken(), signature,
					timestamp, nonce)) {
				//logger.info("进入验证方法SignUtil.checkSignature(account.getAccounttoken(), signature,timestamp, nonce))");
				try {
					response.getWriter().print(echostr);
//					logger.info("response.getWriter().print(echostr):"
//							+ echostr);
					break;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	/*
	 * 微信签名校验
	 * 
	 * @author patrick.z 20141201
	 */
	@RequestMapping(params = "wechat", method = RequestMethod.POST)
	public void wechatPost(HttpServletResponse response,
			HttpServletRequest request,
			@RequestParam(value = "signature") String signature,
			@RequestParam(value = "timestamp") String timestamp,
			@RequestParam(value = "nonce") String nonce) throws IOException {
		String respMessage = "";
		String activedProfile = request.getSession().getServletContext()
				.getInitParameter("spring.profiles.active");
		if (activedProfile.equals("prod")) {
			String accountToken;
			//将accountToken放入缓存中
			if (CachedUtils.get(Constants.MEMKEY_WEIXIN_ACCOUNT_TOKEN) != null){
				accountToken = (String)CachedUtils.get(Constants.MEMKEY_WEIXIN_ACCOUNT_TOKEN);
			}else{
				logger.info("get account token from database");
				WeixinAccountEntity weixinAccount = weixinAccountService.findValidWeixinAccounts().get(0);
				accountToken = weixinAccount.getAccounttoken();
				CachedUtils.set(Constants.MEMKEY_WEIXIN_ACCOUNT_TOKEN, accountToken);
			}
//			logger.info("start wechatPost。accesstoken===>" + accountToken + "; timestamp===>" + timestamp
//					+ "; nonce===>" + nonce + "; signature===>" + signature);
			if (!SignUtil.checkSignature(accountToken, signature, timestamp,
					nonce)) {
				String logInfoString = "Signature failure, maybe the message is not from wechat server! accountToken===>"
						+ accountToken
						+ "; timestamp===>" + timestamp + "; nonce===>" + nonce
						+ "; signature===>" + signature;
				//logger.info(logInfoString);
				systemService.addLog(logInfoString, Globals.Log_Type_LOGIN,
						Globals.Log_Leavel_INFO);
				return;
			}
		}
		respMessage = wechatService.coreService(request);
		PrintWriter out = response.getWriter();
		out.print(respMessage);
		out.close();

	}
}
