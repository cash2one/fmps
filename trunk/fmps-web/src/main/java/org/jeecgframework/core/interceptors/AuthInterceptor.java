package org.jeecgframework.core.interceptors;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.jeecgframework.web.system.manager.ClientManager;
import org.jeecgframework.web.system.pojo.base.Client;
import org.jeecgframework.web.system.pojo.base.TSFunction;
import org.jeecgframework.web.system.service.SystemService;
import org.apache.log4j.Logger;
import org.jeecgframework.core.util.ContextHolderUtils;
import org.jeecgframework.core.util.ResourceUtil;
import org.jeecgframework.core.util.oConvertUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import cn.com.fubon.util.Constants;
import cn.com.fubon.util.FBStringUtils;


/**
 * 权限拦截器
 * 
 * @author  张代浩
 * 
 */
public class AuthInterceptor implements HandlerInterceptor {
	 
	private static final Logger logger = Logger.getLogger(AuthInterceptor.class);
	private SystemService systemService;
	private List<String> excludeUrls;
	private static List<TSFunction> functionList;

	public List<String> getExcludeUrls() {
		return excludeUrls;
	}

	public void setExcludeUrls(List<String> excludeUrls) {
		this.excludeUrls = excludeUrls;
	}

	public SystemService getSystemService() {
		return systemService;
	}

	@Autowired
	public void setSystemService(SystemService systemService) {
		this.systemService = systemService;
	}

	/**
	 * 在controller后拦截
	 */
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object object, Exception exception) throws Exception {
	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object object, ModelAndView modelAndView) throws Exception {

	}

	/**
	 * 在controller前拦截
	 */
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {
		String requestPath = ResourceUtil.getRequestPath(request);// 用户访问的资源地址
		logger.debug("requestPath:" + requestPath);
		
		if (FBStringUtils.checkPathMatch(excludeUrls, requestPath)) {
			return true;
		}
		
		HttpSession session = request.getSession();
		logger.debug("********sessionID====>" + session.getId() +"**********");
		//从session中获取Client
		Client client = (Client)session.getAttribute(Constants.SESSION_KEY_BO_USER);
		
		logger.debug(client != null ? "on preHandle, client is not null;" : "on preHandle, client is null;");
		logger.debug((client != null && client.getUser() != null) ? "on preHandle, client.getUser() is not null;" : "on preHandle, client.getUser() is null;");
		
		if (client != null && client.getUser()!=null ) {
			if(!hasMenuAuth(request)){
				logger.debug("send redirect to loginController on  preHandle");
				response.sendRedirect(request.getContextPath() + "/loginController.do?noAuth");
				//request.getRequestDispatcher("webpage/common/noAuth.jsp").forward(request, response);
				return false;
			} 
			String functionId=oConvertUtils.getString(request.getParameter("clickFunctionId"));
			if(!oConvertUtils.isEmpty(functionId)){
				Set<String> operationCodes = systemService.getOperationCodesByUserIdAndFunctionId(client.getUser().getId(), functionId);
				request.setAttribute("operationCodes", operationCodes);
			 
			}
			if(!oConvertUtils.isEmpty(functionId)){
				List<String> allOperation=this.systemService.findListbySql("SELECT operationcode FROM t_s_operation  WHERE functionid='"+functionId+"'"); 
				  
				List<String> newall = new ArrayList<String>();
				if(allOperation.size()>0){
					for(String s:allOperation){ 
					    s=s.replaceAll(" ", "");
						newall.add(s); 
					}						 
					String hasOperSql="SELECT operation FROM t_s_role_function fun, t_s_role_user role WHERE  " +
						"fun.functionid='"+functionId+"' AND fun.operation!=''  AND fun.roleid=role.roleid AND role.userid='"+client.getUser().getId()+"' ";
					List<String> hasOperList = this.systemService.findListbySql(hasOperSql); 
				    for(String strs:hasOperList){
						    for(String s:strs.split(",")){
						        s=s.replaceAll(" ", "");
						    	newall.remove(s);
						    } 
					} 
				}
				 request.setAttribute("noauto_operationCodes", newall);
			}
			return true;
		} else {
			//session为空，跳转到登陆页面
			logger.debug("********session中client为空，跳转到登陆页**********");
			response.sendRedirect(request.getContextPath() + "/loginController.do?login");
			
			return false;
		}
	}
	private boolean hasMenuAuth(HttpServletRequest request){
		String requestPath = ResourceUtil.getRequestPath(request);// 用户访问的资源地址
		// 是否是功能表中管理的url
		boolean bMgrUrl = false;
		if (functionList == null) {
			functionList = systemService.loadAll(TSFunction.class);
		}
		for (TSFunction function : functionList) {
			if (function.getFunctionUrl() != null && function.getFunctionUrl().startsWith(requestPath)) {
				bMgrUrl = true;
				break;
			}
		}
		if (!bMgrUrl) {
			return true;
		}
		 
		String funcid=oConvertUtils.getString(request.getParameter("clickFunctionId"));
		if(!bMgrUrl && (requestPath.indexOf("loginController.do")!=-1||funcid.length()==0)){
			return true;
		} 
		
		Client client = (Client)request.getSession().getAttribute(Constants.SESSION_KEY_BO_USER);
		if (client == null) {
			logger.debug("get client from session is null on hasMenuAuth");
			return false;
		}
		
		String userid = client.getUser().getId();
		//requestPath=requestPath.substring(0, requestPath.indexOf("?")+1);
		String sql = "SELECT DISTINCT f.id FROM t_s_function f,t_s_role_function  rf,t_s_role_user ru " +
					" WHERE f.id=rf.functionid AND rf.roleid=ru.roleid AND " +
					"ru.userid='"+userid+"' AND f.functionurl like '"+requestPath+"%'"; 
		List list = this.systemService.findListbySql(sql);
		if(list.size()==0){
			return false;
		}
		return true;
	}
	
	/**
	 * 转发
	 * 
	 * @param user
	 * @param req
	 * @return
	 */
	@RequestMapping(params = "forword")
	public ModelAndView forword(HttpServletRequest request) {
		return new ModelAndView(new RedirectView("loginController.do?login"));
	}

	private void forward(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("webpage/login/timeout.jsp").forward(request, response);
	}

}
