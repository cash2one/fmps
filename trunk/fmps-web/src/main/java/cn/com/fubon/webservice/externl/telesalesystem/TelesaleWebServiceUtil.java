package cn.com.fubon.webservice.externl.telesalesystem;

import org.jeecgframework.core.util.ApplicationContextUtil;
import cn.com.fubon.webservice.externl.telesalesystem.resphandler.TelesaleResponseHandler;

public class TelesaleWebServiceUtil {
	public static TelesaleResponseHandler getActualTelesaleResponseHandler(String packetType){
		
		String suffix = "TelesaleResponseHandler";
		String telesaleResponseHandler=packetType+suffix;
	
		TelesaleResponseHandler handler = (TelesaleResponseHandler) ApplicationContextUtil.getContext().getBean(telesaleResponseHandler);
		
		return (TelesaleResponseHandler)handler;
	}
}
