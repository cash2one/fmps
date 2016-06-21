package cn.com.fubon.fo.servicebranch.controller;

import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import cn.com.fubon.fo.servicebranch.service.ServiceBranchService;

/**
 * 服务网点查询类
 * 
 * @author patrick.z
 */
@Scope("prototype")
@Controller
@RequestMapping("/fo/serviceBranch")
public class ServiceBranchController {
	@Resource
	private ServiceBranchService serviceBranchService;

	public ServiceBranchController() {

	}

	/**
	 * 查找所有服务网点记录。
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "list")
	public String list(HttpServletRequest request) {
	
		Map<String, Object> serviceNetWorksMap = serviceBranchService.getServiceNetWorkAll();;
		request.setAttribute("serviceNetWorksMap", serviceNetWorksMap);

		return "fo/servicebranch/servicebranch";

	}
}
