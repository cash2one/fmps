package weixin.guanjia.base.controller;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.jeecgframework.core.util.JSONHelper;
import org.jeecgframework.core.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import weixin.guanjia.account.controller.WeixinAccountController;
import weixin.guanjia.account.entity.WeixinAccountEntity;
import weixin.guanjia.account.service.WeixinAccountServiceI;
import weixin.guanjia.base.entity.WeixinOpenid;
import weixin.guanjia.base.service.WeiXinOpenIdSynchronous;
import weixin.guanjia.core.entity.message.event.BaseEvent;
import weixin.guanjia.core.util.WeixinUtil;
import weixin.popular.api.UserAPI;
import weixin.popular.bean.User;
import weixin.util.WeiXinConstants;
import cn.com.fubon.fo.customerbind.entity.WeiXinGzUserInfo;
import cn.com.fubon.fo.event.service.IEventProcessingService;

/**
 * 
 * @author shanqi.wang
 *
 */

@Scope("prototype")
@Controller
@RequestMapping("/InitializationCustomer")
public class Initialization {
	
	@Resource
	private IEventProcessingService eventProcessingService;	
	@Resource
	private WeixinAccountServiceI weixinAccountService;	
	@Resource
	private WeiXinOpenIdSynchronous weiXinOpenIdSynchronous;	
	private static final Logger logger = Logger.getLogger(Initialization.class);	
	//private String ToUserName = "gh_7d6e54d74264"; // 需要同步的微信号
	String get_customer_url = "https://api.weixin.qq.com/cgi-bin/user/get?access_token=ACCESS_TOKEN";
	String	accessToken="";	
	int count=0;
	UserAPI  userAPI;
	boolean isStop=false; //是否完成现有openid同步
	
	@RequestMapping(params = "method=getSubscribeCustomer")
	public ModelAndView getSubscribeCustomer(HttpServletRequest request)
			throws Exception {
	      
		 //先删除临时表数据 
		 weiXinOpenIdSynchronous.deleteWeixin_open_table();
		//下载最新的客户OPENID到临时表
		 this.downloadOpenid( ); 
		//获取本地为空，微信官方有关注的openid
		 userAPI= new UserAPI();
		 List<Map<String, Object>> openidMapList=weiXinOpenIdSynchronous.getOpenidNotInGzuserinfo();
		 for (Map<String, Object> openIdMap:openidMapList){			 
			 try {
				this.doSubscribe((String)openIdMap.get("openid"));  //下载客户信息
			} catch (Exception e) {
				logger.info("根据OPENID下载关注用户失败==>"+openIdMap.get("openid"),e);			 
			}		
		 }  		 
 		 //获取本地为关注，微信官方已经取消关注的 openid
	
		 List<Map<String, Object>> unSubscribeOpenIdMapList=weiXinOpenIdSynchronous.getUnSubscribeOpenId();
		 for (Map<String, Object> openIdMap:unSubscribeOpenIdMapList){
			 weiXinOpenIdSynchronous.deleteUnSubscribeUser((String)openIdMap.get("openid")); 
		   } 		 
		 
		return null;

	}
	
	// 下载所有客户的openid 保存到表 
	private void downloadOpenid(){
		if(!isStop){
		accessToken=weixinAccountService.getAccessTokenFromAccountEntity();	 //获取最新的accessToken	
		accessToken="jPUNShT8mbVGddEDWRHrGHVsFMJMfvOsiqlWQ66XV9mba1jM2NAq0aLvoxAe1h6Y1XjGd3_sn8lb9p9eyhQ0MsixMsaJ05IYHZXy0n11Ybg";
		// 下载数据 			
		get_customer_url = get_customer_url.replace("ACCESS_TOKEN", accessToken);		
		JSONObject CustomerJSONObject = WeixinUtil.httpRequest(	get_customer_url, "GET", null);		
		JSONObject openidList = null;
		String openidString="";
		try {
			openidList = CustomerJSONObject.getJSONObject("data");
		} catch (Exception e) {
			logger.info("微信获取关注者列表失败",e);
			 isStop=true;
		}
		if(!openidList.isNullObject()){
		  openidString = openidList.getString("openid").replace("[", "").replace("]", "").replace("\"", "");	
		}		
	   String[] openIdArray = openidString.split(",");
	  if(openIdArray.length>1){  
      for (String openId : openIdArray) {			
			try {
				WeixinOpenid weixinOpenid =new WeixinOpenid();
				weixinOpenid.setOpenid(openId);
				weiXinOpenIdSynchronous.save(weixinOpenid);
			} catch (Exception e) {			
			System.out.println("openId=====>"+openId+count++);	 
			}
		}	
	   }
      String  next_openid =(String) CustomerJSONObject.get("next_openid");
     if(StringUtil.isEmpty(next_openid)){
    	   isStop=true;
       }else{
    	   get_customer_url="https://api.weixin.qq.com/cgi-bin/user/get?access_token=ACCESS_TOKEN&next_openid=NEXT_OPENID";
    	   get_customer_url=get_customer_url.replace("NEXT_OPENID", next_openid); 
    	   this.downloadOpenid();  
       }        
	}      
	}	
	

	private void doSubscribe(String OPENID) throws Exception {	
		System.out.println("需要下载的客户资料openId==>"+OPENID);
		accessToken=weixinAccountService.getAccessTokenFromAccountEntity();	 //获取最新的accessToken
		accessToken="xjj_Kkb3NTP2An3CQTfqvapsIIWK1Fe64oHnDaqI6HfAzPcKOK1omZT10izDopONZrWavuUtcKFbPo2M9fM2-GLwh7m-y4vN6w7qWt1olh8";
		// String requestUrl = WeixinUtil.get_customer_url.replace("ACCESS_TOKEN",	accessToken).replace("OPENID", OPENID);
		 User  user=   userAPI.userInfo( accessToken, OPENID   ); 
		//JSONObject CustomerJSONObject = WeixinUtil.httpRequest(requestUrl,"GET", null);
		WeiXinGzUserInfo weiXinGzUserInfo = new WeiXinGzUserInfo();//   (WeiXinGzUserInfo) JSONHelper.json2Object(CustomerJSONObject.toString(),WeiXinGzUserInfo.class);
		java.util.Date date = new Date();
		weiXinGzUserInfo.setOpenid(OPENID);
		weiXinGzUserInfo.setCity(user.getCity());
		weiXinGzUserInfo.setCountry(user.getCountry());
		weiXinGzUserInfo.setHeadimgurl(user.getHeadimgurl());
		weiXinGzUserInfo.setNickname(user.getNickname());
		weiXinGzUserInfo.setProvince(user.getProvince());
		weiXinGzUserInfo.setSex(user.getSex().toString());
		weiXinGzUserInfo.setSubscribe(user.getSubscribe().toString());
		weiXinGzUserInfo.setSubscribe_time(new Date(user.getSubscribe_time()));
		weiXinGzUserInfo.setAccount(weixinAccountService.findValidWeixinAccounts().get(0));
		weiXinGzUserInfo.setAddtime(date);
 
		// 1:关注
		// 0:取消关注
		// 先保存数据到数据库中
		eventProcessingService.customerSubscribe(weiXinGzUserInfo);
		 
	}

}
