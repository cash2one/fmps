package cn.com.fubon.fo.personalcenter.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.jeecgframework.core.util.IdcardUtils;
import org.jeecgframework.core.util.StringUtil;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.com.fubon.fo.personalcenter.service.CustomerPolicyService;
import cn.com.fubon.fo.personalcenter.service.PersonalCenterService;
import cn.com.fubon.util.CachedUtils;
import cn.com.fubon.util.Constants;

/**
 * 客户保单查询类
 * 
 * @author patrick.z
 */
@Scope("prototype")
@Controller
@RequestMapping("/fo/binded/personalCenter/customerPolicy")
public class CustomerPolicyController {

	private static final Logger logger = Logger
			.getLogger(ServiceController.class);
	@Resource
	private PersonalCenterService personalCenterService;

	@Resource
	private CustomerPolicyService customerPolicyService;

	public CustomerPolicyController() {
	}

	/**
	 * 根据客户id和险种大类,查找客户保单记录。
	 * 
	 * @param request
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping(params = "list")
	public String list(HttpServletRequest request) {
		String openid = request.getParameter("openid");
		logger.info("openid =>" + openid);
		String insPlanCode = request.getParameter("p2");// 险种大类code
		// 查询险种大类映射的所有险种,返回用逗号分隔的险种
		List<Map<String, Object>> riskCodes = customerPolicyService.getInsPlanCodeListByInsPlanCode(insPlanCode);
		
		String identifynumber = (String)CachedUtils.get(openid + Constants.MEMKEY_IDENTIFYNUMBER);
		String customercname = (String)CachedUtils.get(openid + Constants.MEMKEY_CUSTOMERCNAME);
		
		if(StringUtil.isEmpty(identifynumber) || StringUtil.isEmpty(customercname)){
			
			// 当前客户信息
			Map<String, String> customerInfoMap = personalCenterService.getCustomerInfoByOpenId(openid);
			identifynumber = customerInfoMap.get("identifynumber");
			customercname = customerInfoMap.get("customercname");
		}

		/* 查询处理显示页面的保单信息 start */
		// 保单信息集合,最后传给前端的外层分页相关的List
		List<Map<String, Object>> customerPolicyList = new ArrayList<Map<String, Object>>();
		if (riskCodes != null && riskCodes.size() > 0) {
			// 初始保单号
			String policyNo = "";
			// 一笔保单信息
			Map<String, Object> customerPolicyMap = new HashMap<String, Object>();
			// 保单详细集合
			List<Map<String, Object>> customerPolicyDetailList = new ArrayList<Map<String, Object>>();
			// Sql查询保单信息集合
			List<Map<String, Object>> customerPolicyListTemp = null;
			
			List<Map<String, Object>> licensedFrameNoList = null;
			if (insPlanCode.equals(Constants.INSURANCE_PLAN_TYPE_CHE)) {// 车险
				customerPolicyListTemp = customerPolicyService
						.getCustomerCarPolicyAll(identifynumber,customercname,riskCodes);
				//查询在mysql已上牌的车架号集合
				String sql ="select li.frameno from weixin_newcar_licenseno li where li.identifynumber=? and li.customercname=? ";
				licensedFrameNoList = customerPolicyService.findForJdbc(sql, identifynumber, customercname);
			} else {// 非车
				customerPolicyListTemp = customerPolicyService
						.getCustomerNotCarPolicyAll(identifynumber,customercname,riskCodes);
			}

			for (Map<String, Object> customerPolicyMapTemp : customerPolicyListTemp) {
				// 一笔保单详细信息
				Map<String, Object> customerPolicyDetailMap = new HashMap<String, Object>();
				// 初始保单号临时变量
				String policyNoTemp = "";
				policyNoTemp = (String) customerPolicyMapTemp.get("policyno");

				if (!policyNoTemp.equals(policyNo)) {// 和初始保单比较不同
					// 取下一个保单
					policyNo = policyNoTemp;
					customerPolicyMap = new HashMap<String, Object>();
					customerPolicyDetailList = new ArrayList<Map<String, Object>>();
					customerPolicyMap.put("policyno",
							customerPolicyMapTemp.get("policyno"));// 保单号
					customerPolicyMap.put("insuredname",
							customerPolicyMapTemp.get("insuredname"));// 被保险人
					if (insPlanCode.equals(Constants.INSURANCE_PLAN_TYPE_CHE)) {// 车险
						customerPolicyMap.put("licenseno",
								customerPolicyMapTemp.get("licenseno"));// 车牌号
						
						//如果oracle中为未上牌,且mysql中无已上牌记录则显示"新车上牌"链接
						String licensed = (String)customerPolicyMapTemp.get("licensed");
						if("0".equals(licensed)){
							String frameno = (String)customerPolicyMapTemp.get("frameno");
							Map<String,Object> currFramenoMap = new HashMap<String,Object>();
							currFramenoMap.put("frameno", frameno);
							if(!licensedFrameNoList.contains(currFramenoMap)){
								customerPolicyMap.put("licensed",0);// 是否上牌 1已上牌
							}
						}
																		
					} else {// 非车
						String identifyNum = IdcardUtils.getEncryptionIdentifyNum((String) customerPolicyMapTemp
								.get("identifynumber"));
						customerPolicyMap.put("identifynumber", identifyNum);// 身份证号

					}
					customerPolicyMap.put("sumPremium", customerPolicyMapTemp.get("sumPremium"));
					customerPolicyMap.put("startdate",
							customerPolicyMapTemp.get("startdate"));// 开始日期
					customerPolicyMap.put("enddate",
							customerPolicyMapTemp.get("enddate"));
					customerPolicyList.add(customerPolicyMap);
				}

				// 加入保单详细信息
				customerPolicyDetailMap.put("kindname",
						customerPolicyMapTemp.get("kindname"));// 险种名称
				if (insPlanCode.equals(Constants.INSURANCE_PLAN_TYPE_CHE)) {// 车 险
					customerPolicyDetailMap.put("isdeductible",
							customerPolicyMapTemp.get("isdeductible"));// 不计免赔
				} else {// 非车
					customerPolicyDetailMap.put("itemdetailname",
							customerPolicyMapTemp.get("itemdetailname"));// 保障信息
				}
				
				customerPolicyDetailMap.put("amount",
						customerPolicyMapTemp.get("amount"));// 保额
				customerPolicyDetailMap.put("premium",
						customerPolicyMapTemp.get("premium"));// 保费
				customerPolicyDetailList.add(customerPolicyDetailMap);
				customerPolicyMap.put("customerPolicyDetailList",
						customerPolicyDetailList);

			}
		}
		/* 查询处理显示页面的保单信息 end */

		Map<String,Object> titleMap = customerPolicyService.findOneForJdbc("select insurance_plan_cname from insurance_plan_type where insurance_plan_code=?",
				insPlanCode);
		request.setAttribute("title", titleMap.get("insurance_plan_cname"));
	
		request.setAttribute("customerPolicyList", customerPolicyList);
		request.setAttribute("p2", insPlanCode);

		if (customerPolicyList.size() < 1) {
			request.setAttribute("message", "没有查询到您的保单信息！");
			return "/fo/common/message";
		} else {
			if (insPlanCode.equals(Constants.INSURANCE_PLAN_TYPE_CHE)) {// 车险
				return "fo/person/customercarpolicy";
			} else {// 非车
				return "fo/person/customernotcarpolicy";
			}
		}
	}
}
