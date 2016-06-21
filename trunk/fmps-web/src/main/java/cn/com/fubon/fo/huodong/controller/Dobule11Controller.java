package cn.com.fubon.fo.huodong.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.util.IpUtil;
import org.jeecgframework.core.util.ResourceUtil;
import org.jeecgframework.core.util.UUIDGenerator;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.fubon.fo.repairplatform.controller.RepairFactoryController;
import weixin.guanjia.account.entity.WeixinAccountEntity;
import weixin.guanjia.account.service.WeixinAccountServiceI;
import weixin.util.JsSdkUtil;

@Scope("prototype")
@Controller
@RequestMapping("/fo/dobule11Controller")
public class Dobule11Controller {	
	private static final Logger logger = Logger
			.getLogger(Dobule11Controller.class);
	@Resource
	private WeixinAccountServiceI weixinAccountService;	
	@RequestMapping(params = "JsdkString")
	@ResponseBody
	public AjaxJson JsdkString(HttpServletRequest request) throws Exception {		
		String  attachurl=request.getParameter("attachurl");		
		AjaxJson jsonString = new AjaxJson();	
		String accessToken = weixinAccountService
				.getAccessTokenFromAccountEntity();
		List<WeixinAccountEntity> weixinAccountEntityList = weixinAccountService
				.findValidWeixinAccounts();
		WeixinAccountEntity weixinAccountEntity = weixinAccountEntityList
				.get(0);
		String appid = weixinAccountEntity.getAccountappid();
		String URL = ResourceUtil.getDomain() + attachurl;		
		logger.info("jssdkPage url ===>" + URL);
		JsSdkUtil JsSdkUtil = new JsSdkUtil(URL, appid, accessToken);
		String json = JsSdkUtil.getWxConfigJSONString();
		jsonString.setObj(json);
		logger.info("JsSdkUtil.getWxConfigJSONString====>" + json);		
		return jsonString;
	}

}
