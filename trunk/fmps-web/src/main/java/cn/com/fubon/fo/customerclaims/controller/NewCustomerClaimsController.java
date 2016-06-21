package cn.com.fubon.fo.customerclaims.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import jodd.util.StringUtil;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import cn.com.fubon.fo.customerbind.service.CustomerBindService;
import cn.com.fubon.fo.customerclaims.service.NewCustomerClaimsService;
import cn.com.fubon.util.CachedUtils;
import cn.com.fubon.util.Constants;

/**
 * 
 * @author fbxmn07
 *	create by 2015-12-25
 */
@Scope("prototype")
@Controller
@RequestMapping("/fo/binded/customerClaims/newCustomerClaimsController")
public class NewCustomerClaimsController {
	private static final Logger logger = Logger.getLogger(NewCustomerClaimsController.class);
	
	@Resource
	private CustomerBindService customerBindService;
	
	@Resource
	private NewCustomerClaimsService newCustomerClaimsService;
	
	/**
	 * 获取首页的理赔信息
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "getClaimInfo")
	public String getClaimInfo(HttpServletRequest request){
		String openid = (String)request.getAttribute("openid");
		if(StringUtil.isEmpty(openid)){
			openid = request.getParameter("openid");
		}
		
		String identifynumber = (String)CachedUtils.get(openid + Constants.MEMKEY_IDENTIFYNUMBER);
		String customercname = (String)CachedUtils.get(openid + Constants.MEMKEY_CUSTOMERCNAME);
			
		List<Map<String, Object>> indexDatas = newCustomerClaimsService.getIndexInfo(customercname, identifynumber);
		
		if(indexDatas == null || indexDatas.isEmpty()){
			request.setAttribute("message", "未查到理赔记录！");
			return "/fo/common/message";
		}
		
		String currentYear = null;
		List<Map<String, Object>> indexList = new ArrayList<Map<String, Object>>();
		for(int i=0;i<indexDatas.size();i++){
			String tempYear = null;
			// 循环第一次时
			if (currentYear == null) {
				tempYear = (String)indexDatas.get(i).get("reportyear");
				currentYear = tempYear;
			}else {
				if (!currentYear.equals((String)indexDatas.get(i).get("reportyear"))) {
					tempYear = (String)indexDatas.get(i).get("reportyear");
					currentYear = tempYear;
				}
			}
			indexDatas.get(i).put("tempReportYear", tempYear);
			indexList.add(indexDatas.get(i));
		}
		request.setAttribute("indexList", indexList);
		return "/fo/customerclaims/newclaimindexinfo";
	}
	/**
	 * 获取详细理赔详细进度信息
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "getClaimDetailInfo")
	public ModelAndView getClaimDetailInfo(@RequestParam String registno,
			@RequestParam String id){
		ModelAndView result = new ModelAndView();
		
		//查理赔记录,需要取案件经过
		Map<String, Object> claimRecordMap = newCustomerClaimsService.getClaimRecordInfo(id);
		List<Map<String, Object>> detailList = newCustomerClaimsService.getDetailInfo(registno);
		
		if(detailList == null || detailList.isEmpty()){
			result.addObject("message","未查询到理赔进度！");
			result.setViewName("/fo/common/message");
			return result;
		}
		
		result.addObject("tempReportYear", claimRecordMap.get("reportyear"));
		result.addObject("claimRecord", claimRecordMap);
		result.addObject("detailList", detailList);
		result.setViewName("/fo/customerclaims/newclaimdetailinfo");
		return result;
	}
	
	
}
