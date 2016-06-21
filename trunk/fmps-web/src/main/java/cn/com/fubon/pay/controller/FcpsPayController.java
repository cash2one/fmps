package cn.com.fubon.pay.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import jodd.util.StringUtil;

import org.apache.log4j.Logger;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.util.IpUtil;
import org.jeecgframework.core.util.UUIDGenerator;
import org.jeecgframework.web.system.service.SystemService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.fubon.pay.service.FmcpPayService;
import cn.com.fubon.pay.service.OfflineWechatPayService;
import cn.com.fubon.pay.service.WechatPayService;
import weixin.guanjia.account.entity.WeixinAccountEntity;
import weixin.guanjia.account.service.WeixinAccountServiceI;
import weixin.guanjia.core.util.WeixinUtil;
import weixin.popular.bean.pay.PayNotify;
import weixin.popular.bean.pay.PayOrderqueryResult;

@Scope("prototype")
@Controller
@RequestMapping("/pay/fcpsPay")
public class FcpsPayController {

	@Resource
	private WeixinAccountServiceI weixinAccountService;
	@Resource
	private WechatPayService wechatPayServiceImpl;
	@Resource
	private OfflineWechatPayService offlineWechatPayService;
	@Resource
	private SystemService systemService;
	@Resource
	private FmcpPayService fmcpPayService;

	private static final Logger logger = Logger
			.getLogger(FcpsPayController.class);

	/**
	 * 进入支付画面
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "payIndex")
	public String payIndex(HttpServletRequest request) {
		int versionNum = WeixinUtil.getWechatVersion(request);
		if (versionNum < 5) {		
			request.setAttribute("message", "您的微信版本过低，请升级版本为5.0以上！");
			return "/fo/common/message";
		}		
		String code = request.getParameter("code"); // 菜单跳转过来的CODE
		String fmcpPayCode = request.getParameter("fmcpPayCode"); // 企业号支付码
		String totalFee = request.getParameter("totalFee");// 总费用处理 取分
		String policyInfo = request.getParameter("policyInfo"); // 商品信息
		String fmcpPayAttach = request.getParameter("fmcpPayAttach"); // 企业号付款附加信息
		String openid = request.getParameter("openid"); // openid		
		String notify_url = request.getParameter("notify_url"); // 支付结果通知地址	
		//openid，fmcpPayCode，totalFee，policyInfo，fmcpPayAttach		
		String state = request.getParameter("state"); // 菜单跳转过来的CODE
		logger.info("state=========>" + state);
		if(StringUtil.isEmpty(policyInfo)){
			String[] argArray=state.split(",");
			openid=argArray[0];
			fmcpPayCode=argArray[1];
			totalFee=argArray[2];	
			policyInfo=argArray[3];
			fmcpPayAttach=argArray[4];
		}
		boolean isPay=false;  //默认新订单，未支付
		// 对传递过来的保单信息和附加信息decode added by qingqu.huang @date 201511101042
		try {
			if (StringUtil.isNotEmpty(policyInfo)) {
		   policyInfo = java.net.URLDecoder.decode(policyInfo, "UTF-8");
			}
		if (StringUtil.isNotEmpty(fmcpPayAttach)) {
		   fmcpPayAttach = java.net.URLDecoder.decode(fmcpPayAttach,"UTF-8");
				}
		  } catch (UnsupportedEncodingException e) {
			  logger.error("保单信息解码失败", e);
		  }		
		logger.info("code=>" + code);
		logger.info("payIndex=====>fmcpPayCode:["+fmcpPayCode+"] totalFee:["+totalFee+"] policyInfo:["+policyInfo+"] fmcpPayAttach:["+fmcpPayAttach+"] openid:["+openid+"] notify_url:["+notify_url+"]");
		if (StringUtil.isEmpty(openid)) {
			openid = (String) request.getAttribute("openid");
		}
		logger.info("openid=>" + openid);
		if (StringUtil.isEmpty(openid)) {
			List<WeixinAccountEntity> weixinAccountEntityList = weixinAccountService
					.findValidWeixinAccounts();
			WeixinAccountEntity weixinAccountEntity = weixinAccountEntityList
					.get(0);
			openid = WeixinUtil.getOpenId(
					weixinAccountEntity.getAccountappid(),
					weixinAccountEntity.getAccountappsecret(), code);
			logger.info("根据code获取 openid,获取到的openid=>" + openid);
		}
		if (fmcpPayService.isUnifiedOrder(fmcpPayCode)) { // 是否下过单
			if (fmcpPayService.isPaid(fmcpPayCode)) { // 是否支付过					
				isPay= true;
				totalFee=fmcpPayService.getTotalFee(fmcpPayCode); 				 
			} else { // 查询微信支付，看是否支付过				
				List<Map<String, Object>>   unifiedOrderlist = fmcpPayService.getUnifiedOrderlist(fmcpPayCode);				
				for(Map<String, Object> orderMap : unifiedOrderlist ){				
				PayOrderqueryResult payOrderqueryResult =wechatPayServiceImpl.queryOrderByOutTradeNo((String) orderMap.get("out_trade_no"));
				if("SUCCESS".equals(payOrderqueryResult.getTrade_state())){
					isPay= true;
					totalFee=payOrderqueryResult.getTotal_fee();
				  }				
				if(isPay){break; } //如果已经支付过了，就跳出循环				
				}				
			}
		} 
		request.setAttribute("isPaid", isPay);
		request.setAttribute("fmcpPayCode", fmcpPayCode);
		request.setAttribute("totalFee", totalFee);
		request.setAttribute("policyInfo", policyInfo);
		request.setAttribute("fmcpPayAttach", fmcpPayAttach);
		request.setAttribute("openid", openid);
		request.setAttribute("notify_url", notify_url);		
		return "fo/offlinepay/fcpsPayInfo";	
	}

	/**
	 * 调用微信支付下单支付
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(params = "wechatPay")
	@ResponseBody
	public AjaxJson wechatPay(HttpServletRequest request) throws Exception {
		AjaxJson jsonString = new AjaxJson();			
		String openid = request.getParameter("openid"); // openid		
		String fmcpPayCode = request.getParameter("fmcpPayCode"); // 企业号支付码		
		String totalFee = request.getParameter("totalFee");// 总费用处理 取分		
		String policyInfo = request.getParameter("policyInfo"); // 商品信息
		String fmcpPayAttach = request.getParameter("fmcpPayAttach"); // 企业号付款附加信息
		logger.info("AjaxJson wechatPay=====>openid:["+openid+"] fmcpPayCode:["+fmcpPayCode+"] totalFee:["+totalFee+"] policyInfo:["+policyInfo+"] fmcpPayAttach:["+fmcpPayAttach+"]");
		// 微信下单并返回JOSN对象
		//String body = "企业号商品";// 商品描述
		fmcpPayAttach=StringUtil.isEmpty(fmcpPayAttach)?"企业号付款附加信息":fmcpPayAttach;
		String outTradeNo =  UUIDGenerator.generate();//  微信订单号
		String attach = "FMCP" + "," + fmcpPayCode + "," + fmcpPayAttach;// [支付来源，订单号，其他信息]
		logger.info("getPayJosn=attach====>" + attach);
		String json = "   ";
		String spbillCreateIp = IpUtil.getPayIpAddr(request);		
		// 调用支付接口返回支付jason
		String activedProfile = request.getSession().getServletContext()
				.getInitParameter("spring.profiles.active");
		if (activedProfile.equals("prod")) {// 生产环境
			json = wechatPayServiceImpl.getFcpsPayJsRequestJson(openid, policyInfo,
					outTradeNo, totalFee, spbillCreateIp, attach,fmcpPayCode);
		} else {// 其他环境
			json = wechatPayServiceImpl.getFcpsPayJsRequestJson(openid, policyInfo,
					outTradeNo, "1", spbillCreateIp, attach,fmcpPayCode);
		}
		jsonString.setObj(json);
		logger.info("getPayJosn=openid+json====>" + openid + ":" + json);
		// 记录系统日志
		systemService.addLog("企业号发起支付，字符流水号：", Globals.Log_Type_INSERT,
				Globals.Log_Leavel_INFO);
		return jsonString;
	}

}
