package org.jeecgframework.core.common.exception;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.jeecgframework.core.util.ExceptionUtil;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import cn.com.fubon.util.Constants;

/**
 * spring mvc异常捕获类
 * 
 */
@Component
public class MyExceptionHandler implements HandlerExceptionResolver {

	private static final Logger logger = Logger
			.getLogger(MyExceptionHandler.class);

	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex) {
		String exceptionMessage = ExceptionUtil.getExceptionMessage(ex);
		logger.error(exceptionMessage);
		String activedProfile = request.getSession().getServletContext()
				.getInitParameter("spring.profiles.active");
		if (ex instanceof RuntimeException && "prod".equals(activedProfile)) { // added by guo 20141202
			request.setAttribute("message", "系统发生未知错误！");
			request.setAttribute(Constants.MESSAGE_TYPE,
					Constants.MESSAGE_TYPE_ERROR);
			StringBuffer requestUrl = request.getRequestURL();
			
			logger.info(request.getRequestURL());
			// 如果是fo包下的就进前端提示页面,否则进后台提示页面
			if ((requestUrl.indexOf("/fo/") != -1 )
					|| requestUrl.indexOf("/pay/") != -1
					 ) {

				return new ModelAndView("fo/common/message");
			} else {
				return new ModelAndView("common/message");

			}
		}
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("exceptionMessage", exceptionMessage);
		model.put("ex", ex);
		return new ModelAndView("common/error", model);
	}
}
