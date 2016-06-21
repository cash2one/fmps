package cn.com.fubon.fo.personalcenter.controller;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import cn.com.fubon.fo.personalcenter.service.AccomplishmentService;
import cn.com.fubon.fo.personalcenter.service.PersonalCenterService;

/**
 * 个人中心类
 * 
 * @author patrick.z
 */
@Scope("prototype")
@Controller
@RequestMapping("/fo/binded/personalCenter/accomplishment")
public class AccomplishmentController {

	@Resource
	private AccomplishmentService accomplishmentService;

	@Resource
	private PersonalCenterService personalCenterService;

	public AccomplishmentController() {

	}

	private static final Logger logger = Logger
			.getLogger(AccomplishmentController.class);

	/**
	 * 进入成就页面
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "achvindex")
	public String achvindex(HttpServletRequest request) {
		String openid = request.getParameter("openid");
		logger.info("openid =>" + openid);
		// 客户信息
		Map<String, String> customerInfoMap = personalCenterService
				.getCustomerInfoByOpenId(openid);
		String customerCode = customerInfoMap.get("customercode");
		//logger.info("customerCode =>" + customerCode);
		// 年份tag
		String yearNum = "";
		// 年份信息
		Map<String, Object> accomplishmentMap = new HashMap<String, Object>();
		// 页面总成就信息集合
		List<Map<String, Object>> accomplishmentList = new ArrayList<Map<String, Object>>();
		// 某个年份所有成就信息集合
		List<Map<String, Object>> accomplishmentDetailList = new ArrayList<Map<String, Object>>();
		// SQL查出的总成就信息集合
		List<Map<String, Object>> accomplishmentListTmp = accomplishmentService
				.getAccomplishmentAllByCutomerId(customerCode);
		/* 成就处理start */
		for (Map<String, Object> accomplishmentMapTemp : accomplishmentListTmp) {
			// 年份tag临时变量
			String yearNumTemp = "";
			// 年份成就信息
			Map<String, Object> accomplishmentDetailMap = new HashMap<String, Object>();
			yearNumTemp = (String) accomplishmentMapTemp.get("achv_year");
			if (!yearNumTemp.equals(yearNum)) {//比较不同
				// 取下一个年份
				yearNum = yearNumTemp;
				accomplishmentMap = new HashMap<String, Object>();
				accomplishmentDetailList = new ArrayList<Map<String, Object>>();
				accomplishmentMap.put("year",accomplishmentMapTemp.get("achv_year"));//年份
				accomplishmentList.add(accomplishmentMap);
			}
			//某个年份所有成就信息集合
			accomplishmentDetailMap.put("month",
					accomplishmentMapTemp.get("achv_month"));
			accomplishmentDetailMap.put("name",
					accomplishmentMapTemp.get("achv_name"));
			accomplishmentDetailMap.put("describe",
					accomplishmentMapTemp.get("achv_describe"));
			accomplishmentDetailList.add(accomplishmentDetailMap);
			accomplishmentMap.put("accomplishmentDetailList",
					accomplishmentDetailList);
		}

		/* 成就处理end */

		request.setAttribute("accomplishmentList", accomplishmentList);
		request.setAttribute("nickname", customerInfoMap.get("nickname"));
		request.setAttribute("headimgurl", customerInfoMap.get("headimgurl"));
		return "fo/person/accomplishment";
	}
}
