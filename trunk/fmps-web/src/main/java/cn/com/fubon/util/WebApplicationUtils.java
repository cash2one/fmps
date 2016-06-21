/**
 * 
 */
package cn.com.fubon.util;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

/**
 * web应用程序工具类
 * 
 * @author binbin.wang
 *
 */
public final class WebApplicationUtils {

	public static String getWebRootUrl(ServletRequest request) {
		String path = ((HttpServletRequest)request).getContextPath();
		String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort() + path;

		return basePath;
	}

}
