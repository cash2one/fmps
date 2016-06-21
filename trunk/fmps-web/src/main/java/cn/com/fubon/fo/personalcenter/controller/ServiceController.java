package cn.com.fubon.fo.personalcenter.controller;

import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import cn.com.fubon.fo.personalcenter.service.PersonalCenterService;

/**
 * 个人中心类
 * 
 * @author patrick.z
 */
@Scope("prototype")
@Controller
@RequestMapping("/fo/binded/personalCenter/service")
public class ServiceController {

	@Resource
	private PersonalCenterService personalCenterService;

	public ServiceController() {

	}

	private static final Logger logger = Logger
			.getLogger(ServiceController.class);

	/**
	 * 进入服务页面
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "serviceindex")
	public String serviceindex(HttpServletRequest request) {
		String openid = request.getParameter("openid");
		// 客户信息
		Map<String, String> customerInfoMap = personalCenterService
				.getCustomerInfoByOpenId(openid);
		
		request.setAttribute("headimgurl", customerInfoMap.get("headimgurl"));
		request.setAttribute("nickname", customerInfoMap.get("nickname"));
		return "fo/person/service";
	}
}
