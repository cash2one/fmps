/**
 * 
 */
package cn.com.fubon.fo.personalcenter.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.util.StringUtil;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.fubon.fo.card.entity.Policy;
import cn.com.fubon.fo.card.entity.PolicyInsured;
import cn.com.fubon.fo.card.service.IPolicyService;
import cn.com.fubon.fo.totaiwan.entity.TaiwanConstants;
import cn.com.fubon.fo.totaiwan.service.ToTaiwanService;

/**
 * 个人中心-订单
 * 
 * @author qingqu.huang
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/fo/binded/personalCenter/orderController")
public class OrderController {

	@Resource
	private ToTaiwanService toTaiwanServiceImpl;
	@Resource
	private IPolicyService policyService;

	@RequestMapping(params = "cancelOrder")
	@ResponseBody
	public AjaxJson cancelOrder(HttpServletRequest request) {
		AjaxJson ajaxJson = new AjaxJson();
		String orderno = request.getParameter("orderno");
		Policy policy = policyService.findUniqueByProperty(Policy.class,
				"orderno", orderno);
		if (policy == null) {
			ajaxJson.setSuccess(false);
			return ajaxJson;
		}
		List<PolicyInsured> policyInsuredList = policyService.findByProperty(
				PolicyInsured.class, "orderno", orderno);
		policyService.deleteAllEntitie(policyInsuredList);
		policyService.delete(policy);
		ajaxJson.setSuccess(true);
		return ajaxJson;
	}

	@RequestMapping(params = "getPolicyList")
	@ResponseBody
	public AjaxJson getPolicyList(HttpServletRequest request) {
		AjaxJson ajaxJson = new AjaxJson();
		String openid = request.getParameter("openid");
		String status = request.getParameter("status");
		String start = request.getParameter("start");
		List<Map<String, Object>> policyList = null;
		if (StringUtil.isNotEmpty(status)
				&& TaiwanConstants.POLICYSTATUS_0.equals(status)) {
			policyList = toTaiwanServiceImpl.getunPaidPolicyList(openid,Integer.parseInt(start));
		} else {
			policyList = toTaiwanServiceImpl.getPolicyList(openid, status,
					Integer.parseInt(start));
		}
		if (policyList.size() <= 0) {
			ajaxJson.setSuccess(false);
			return ajaxJson;
		}
		ajaxJson.setObj(policyList);
		ajaxJson.setSuccess(true);
		return ajaxJson;
	}
}
