package weixin.util;
import org.apache.log4j.Logger;

import cn.com.fubon.fo.customerbind.controller.CustomerBindController;
import cn.com.fubon.util.CachedUtils;
import cn.com.fubon.util.Constants;
import weixin.popular.api.TicketAPI;
import weixin.popular.bean.Ticket;
import weixin.popular.util.JsUtil;
public class JsSdkUtil {	
	private String  url="";
	private String  appid="";
	private String  accessToken="";	
	private static final Logger logger = Logger.getLogger(JsSdkUtil.class);
	
	public JsSdkUtil(String url,String appid,String accessToken ){
		this.url=url;
		this.appid=appid;
		this.accessToken=accessToken;	
	}	
	public  String   getWxConfigJSONString(){		
    String  JSONString= JsUtil.generateConfigJson( this.getJsapiTicket(),false,appid,url,
    	        "checkJsApi",
    	        "onMenuShareTimeline",
    	        "onMenuShareAppMessage",
    	         "onMenuShareQQ",
    	         "onMenuShareWeibo",
    	         "hideMenuItems",
    	         "showMenuItems",
    	         "hideAllNonBaseMenuItem",
    	         "showAllNonBaseMenuItem",
    	         "translateVoice",
    	         "startRecord",
    	         "stopRecord",
    	         "onRecordEnd",
    	         "playVoice",
    	         "pauseVoice",
    	         "stopVoice",
    	         "uploadVoice",
    	         "downloadVoice",
    	         "chooseImage",
    	         "previewImage",
    	         "uploadImage",
    	         "downloadImage",
    	         "getNetworkType",
    	         "openLocation",
    	         "getLocation",
    	         "hideOptionMenu",
    	         "showOptionMenu",
    	         "closeWindow",
    	         "scanQRCode",
    	         "chooseWXPay",
    	         "openProductSpecificView",
    	         "addCard",
    	         "chooseCard",
    	         "openCard");    
      return JSONString;	
	  }	
	
	/**
	 * 根据 JS -SDK 规范获取 JsapiTicket
	 * @return
	 */
	public String getJsapiTicket(){
	String   JsapiTicket=(String) CachedUtils.get(Constants.MEMKEY_WEIXIN_JsapiTicket);
		if(JsapiTicket==null){
			 Ticket ticket= TicketAPI.ticketGetticket(accessToken);
			    JsapiTicket =ticket.getTicket();	
			    CachedUtils.set(Constants.MEMKEY_WEIXIN_JsapiTicket, 30*60, JsapiTicket);
		}
		logger.debug("=========JsapiTicket===================>"+JsapiTicket);		
		return JsapiTicket;
	}

	public  String   getWxConfigJSONStringHasDebug(){		
	    String  JSONString= JsUtil.generateConfigJson( this.getJsapiTicket(),true,appid,url,
	    	        "checkJsApi",
	    	        "onMenuShareTimeline",
	    	        "onMenuShareAppMessage",
	    	         "onMenuShareQQ",
	    	         "onMenuShareWeibo",
	    	         "hideMenuItems",
	    	         "showMenuItems",
	    	         "hideAllNonBaseMenuItem",
	    	         "showAllNonBaseMenuItem",
	    	         "translateVoice",
	    	         "startRecord",
	    	         "stopRecord",
	    	         "onRecordEnd",
	    	         "playVoice",
	    	         "pauseVoice",
	    	         "stopVoice",
	    	         "uploadVoice",
	    	         "downloadVoice",
	    	         "chooseImage",
	    	         "previewImage",
	    	         "uploadImage",
	    	         "downloadImage",
	    	         "getNetworkType",
	    	         "openLocation",
	    	         "getLocation",
	    	         "hideOptionMenu",
	    	         "showOptionMenu",
	    	         "closeWindow",
	    	         "scanQRCode",
	    	         "chooseWXPay",
	    	         "openProductSpecificView",
	    	         "addCard",
	    	         "chooseCard",
	    	         "openCard");    
	      return JSONString;	
		  }	

}
