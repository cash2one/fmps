package cn.com.fubon.fo.customerpremranking.controller;

import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.jeecgframework.core.util.StringUtil;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import cn.com.fubon.fo.customerbind.entity.WeiXinGzUserInfo;
import cn.com.fubon.fo.customerbind.service.CustomerBindService;
import cn.com.fubon.fo.customerpremranking.service.CustomerPremRankingService;
import cn.com.fubon.util.CachedUtils;
import cn.com.fubon.util.Constants;

@Scope("prototype")
@Controller
@RequestMapping("/fo/binded/customerPremRankingController")
public class CustomerPremRankingController {
	
	@Resource
	private CustomerPremRankingService customerPremRankingService;
	@Resource
	private CustomerBindService customerBindService;
	
	public CustomerPremRankingController(){
	}
	
	/**
	 * 返回保费排名页面
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "method=customerPremRanking")
	public String customerPremRanking(HttpServletRequest request) {

		String openid = (String) request.getAttribute("openid");
		if (StringUtil.isEmpty(openid)) {
			openid = request.getParameter("openid");
		}
		String identifynumber = (String) CachedUtils.get(openid + Constants.MEMKEY_IDENTIFYNUMBER);
		//完整的客户姓名
		String customercname = (String) CachedUtils.get(openid + Constants.MEMKEY_CUSTOMERCNAME);
		
		if(StringUtil.isEmpty(identifynumber) || StringUtil.isEmpty(customercname)){
			// 根据openid取identifynumber和customercname
			WeiXinGzUserInfo weiXinGzUserInfo = customerBindService.findUniqueByProperty(WeiXinGzUserInfo.class, "openid", openid);
			identifynumber = weiXinGzUserInfo.getIdentifynumber();
			customercname = weiXinGzUserInfo.getCustomercname();
		}
		
		//保费排名表中客户名称的姓用*隐藏
		String customername = StringUtil.isEmpty(customercname) ? null : "*" + customercname.substring(1);
		identifynumber = StringUtil.isEmpty(identifynumber) ? null : identifynumber.toUpperCase();
		
		// 保费排名前20名
		List<Map<String,Object>> customerPremRankingList = customerPremRankingService.customerPremRanking();
		
		Map<String,Object> customerPremRanking = null;
		if(!StringUtil.isEmpty(identifynumber) && !StringUtil.isEmpty(customercname)){
			
			customerPremRanking = customerPremRankingService.customerPremRanking(identifynumber,customername);
		}
		
		for(Map<String,Object> var : customerPremRankingList){
			// 如果当前用户在前20名则不单独显示，保费排名表中客户名称的姓用*隐藏
			if(var.get("identifynumber").equals(identifynumber) && var.get("customername").equals(customername)){
				customerPremRanking = null;
				request.setAttribute("rank", var.get("rank")); // 设置前20名中的当前用户字体为红色
				break ;
			}
		}
		
		request.setAttribute("openid", openid);
		request.setAttribute("customerPremRankingList", customerPremRankingList);
		request.setAttribute("customerPremRanking", customerPremRanking);
		
		return "/fo/customerpremranking/customerPremRanking";
	}
}
