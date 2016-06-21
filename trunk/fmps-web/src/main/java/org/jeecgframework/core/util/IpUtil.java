package org.jeecgframework.core.util;

import java.net.SocketException;
import javax.servlet.http.HttpServletRequest;

public class IpUtil {
	/**
	 * 获取登录用户IP地址
	 * 
	 * @param request
	 * @return
	 */
	public static String getIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		if (ip.equals("0:0:0:0:0:0:0:1")) {
			ip = "127.0.0.1";
		}
		return ip;
	}

	public static String getPayIpAddr(HttpServletRequest request) {
		String[] ipArray=IpUtil.getIpAddr(request).split(",");		 
		 return ipArray[0];
	}
	
	public static boolean hasPassIpCheck(String ipFilter) throws SocketException{
		if(ipFilter != null && ipFilter.trim().equalsIgnoreCase("ALL")){
			return true;
		}
		String[] ipList = null;
		if(StringUtil.isNotEmpty(ipFilter)){
			ipList = ipFilter.split(",");
		}
		String ip = oConvertUtils.getRealIp();//获得本机IP
		if(ipList != null){
			for(int i = 0; i < ipList.length; i++){
				if(ip.trim().equals(ipList[i].trim())){
					return true;
				}
			}
		}
		return false;
	}
}
