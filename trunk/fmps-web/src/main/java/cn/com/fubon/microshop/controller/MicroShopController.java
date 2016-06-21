package cn.com.fubon.microshop.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import jodd.util.StringUtil;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import weixin.guanjia.account.entity.WeixinAccountEntity;
import weixin.guanjia.account.service.WeixinAccountServiceI;
import weixin.guanjia.core.util.WeixinUtil;
import weixin.popular.bean.pay.PayNotify;
import cn.com.fubon.fo.repairplatform.controller.RepairFactoryController;
import cn.com.fubon.microshop.service.MicroShopNotifyService;



@Scope("prototype")
@Controller
@RequestMapping("/microShopController")
public class MicroShopController {
	
	@Resource 
	private MicroShopNotifyService microShopNotifyService;
	@Resource
	private WeixinAccountServiceI weixinAccountService;
	
	private static final Logger logger = Logger
			.getLogger(MicroShopController.class);
	
	@RequestMapping(params = "test")
	public ModelAndView test(HttpServletRequest request)
			throws UnsupportedEncodingException{
		PayNotify payNotify=new PayNotify ();
		payNotify.setTransaction_id("transaction_id");
		payNotify.setOut_trade_no("out_trade_no");
		payNotify.setAttach("attach");
		microShopNotifyService.doUnderwriting("1234568", payNotify);
		
			return new ModelAndView("/fo/customerclaims/claimsInformation");		
	}
	
	  @RequestMapping(params = "getFmpsOpenId")
	public String getFmpsOpenId(HttpServletRequest request) {		
		String code = request.getParameter("code");
		String cpurl = request.getParameter("cpurl");
		String attachedParameter="";		
		 Enumeration paramNames = request.getParameterNames();   
		   while (paramNames.hasMoreElements()) {   
		      String paramName = (String) paramNames.nextElement();		  
		      String[] paramValues = request.getParameterValues(paramName);   
		      if (paramValues.length == 1) {   
		      String paramValue = paramValues[0];   
		        if (paramValue.length() != 0&&!paramName.equals("cpurl")&&!paramName.equals("code")) {   
		        	attachedParameter=attachedParameter+"&"+paramName+"="+paramValue;		         
		        }   
		      }   
		    } 		 
		logger.info("code=>" + code);
		logger.info("cpurl=>" + cpurl);
		List<WeixinAccountEntity> weixinAccountEntityList = weixinAccountService
				.findValidWeixinAccounts();
		WeixinAccountEntity weixinAccountEntity = weixinAccountEntityList
				.get(0);
	    String openid=" ";
		try {
			openid = WeixinUtil.getOpenId(
					weixinAccountEntity.getAccountappid(),
					weixinAccountEntity.getAccountappsecret(), code);
			logger.info("企业号获取到的openid===>"+openid);	
		} catch (Exception e) {
			logger.info("企业号跳转过来的获取openid错误",e);			
		}		
		   
		    return "redirect:"+cpurl+"&mpOpenid="+openid+attachedParameter;  
		}  


}
