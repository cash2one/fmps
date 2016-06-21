package org.jeecgframework.web.system.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.apache.log4j.Logger;
import org.jeecgframework.web.system.manager.ClientManager;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;


/**
 * 监听在线用户上线下线  add by duanql 2013-06-07
 */
public class OnlineListener implements ServletContextListener,HttpSessionListener {

	private static ApplicationContext ctx = null;
	
	private static final Logger logger = Logger.getLogger(OnlineListener.class);

	public OnlineListener() {
	}

	
	public void sessionCreated(HttpSessionEvent httpSessionEvent) {
	}

	
	public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
		try {
			ClientManager.getInstance().removeClient(httpSessionEvent.getSession().getId());
		}catch(Exception e) {
			logger.info("session destroy出现异常:" + e);
		}
	}

	/**
	 * 服务器初始化
	 */
	
	public void contextInitialized(ServletContextEvent evt) {
		ctx = WebApplicationContextUtils.getWebApplicationContext(evt.getServletContext());
	}

	public static ApplicationContext getCtx() {
		return ctx;
	}
	
	
	public void contextDestroyed(ServletContextEvent paramServletContextEvent) {
		
	}

}
