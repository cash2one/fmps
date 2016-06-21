package weixin.guanjia.core.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jodd.util.StringUtil;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.jeecgframework.core.util.ApplicationContextUtil;
import org.springframework.beans.factory.annotation.Autowired;

import cn.com.fubon.wechatClaims.service.ReportInfoService;
import weixin.guanjia.account.service.WeixinAccountServiceI;
import weixin.guanjia.core.util.WeixinUtil;

/**
 * 提交给系统课监控使用，监控是否可正常访问腾讯微信服务器。
 * @author shanqi.wang
 * @v1.4.0.0
 * @20115-7-9 8:49
 */
public class MonitorServlet extends HttpServlet {	
	 
	private WeixinAccountServiceI weixinAccountService;
	private static final Logger logger = Logger
			.getLogger(MonitorServlet.class);

	 
	/**
	 * 访问微信服务器正常 return Success ,异常 return Fail
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String ip_list = null; //获取的ip地址列表
		String errcode = null; //返回的错误码
		String returnMessage="Fail"; //默认返回失败
		logger.debug("enter_doGet_Method");		
		weixinAccountService = (WeixinAccountServiceI) ApplicationContextUtil
				.getContext().getBean("weixinAccountService");
		String ACCESS_TOKEN=weixinAccountService.getAccessTokenFromAccountEntity();	
		logger.debug("ACCESS_TOKEN===>"+ACCESS_TOKEN);
		String url=WeixinUtil.get_WeChat_IP_URL.replace("ACCESS_TOKEN", ACCESS_TOKEN);
		JSONObject jSONObject=	WeixinUtil.httpRequest(url,"GET",null );
		logger.debug("jSONObject.toString====>"+jSONObject);
		
		try {
			ip_list = jSONObject.getString("ip_list");
		} catch (Exception e) {
			logger.error("jSONObject:"+jSONObject+";GET_ip_list_error:"+e.getMessage());
			errcode="error" ;
		}
		try {
			errcode = jSONObject.getString("errcode");
		} catch (Exception e) {
			logger.debug("GET_IP_LIST_ERROR===>"+jSONObject);
			
		}
		//返回的IP列表不为空，请错误代码为空。
		if(!StringUtil.isEmpty(ip_list)&&StringUtil.isEmpty(errcode)){
			returnMessage="Success";
		}
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.print(returnMessage);
		out.close();
		
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}
	
}
