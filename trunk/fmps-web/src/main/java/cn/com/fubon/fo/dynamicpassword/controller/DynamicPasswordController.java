package cn.com.fubon.fo.dynamicpassword.controller;

import java.util.ResourceBundle;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jodd.util.StringUtil;

import org.jeecgframework.core.common.model.json.AjaxJson;

import org.jeecgframework.core.util.UUIDGenerator;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.fubon.fo.dynamicpassword.entity.TSDynamicPassword;
import cn.com.fubon.fo.dynamicpassword.service.DynamicPasswordService;
import cn.com.fubon.util.Constants;
import cn.com.fubon.util.FBStringUtils;


@Scope("prototype")
@Controller
@RequestMapping("/fo/dynamicPasswordController")
public class DynamicPasswordController {
	
	@Resource
	private DynamicPasswordService dynamicPasswordService;
	
	public DynamicPasswordController(){
	}
	
	/**
	 * 平台发送短信验证码
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(params = "sendDynamicPassword")
	public AjaxJson sendDynamicPassword(HttpServletRequest request,HttpServletResponse response) throws Exception {
		AjaxJson j = new AjaxJson();
		String mobile = request.getParameter("mobile");
		if(StringUtil.isEmpty(mobile)){
			j.setMsg("**手机号不能为空!");
            j.setSuccess(false);
            return j;
		}
		
		//校验该手机号是否已做过绑定 20141020 begin
		if(dynamicPasswordService.isBindedMobile(mobile)){
			j.setMsg("**该手机号已经绑定过微信,如有疑问,请致电4008-817-518!");
            j.setSuccess(false);
            return j;
		}
		//校验该手机号是否已做过绑定 20141020 en
		
		//查询该手机是否存在1分钟内发送的验证码
		boolean isExists = dynamicPasswordService.findLatestTSDynamicPassword(mobile);
		if(isExists){
			j.setMsg("**距离上次发送短信不到1分钟!");
            j.setSuccess(false);
            return j;
		} 
		
		//重新生成四位随机验证码写表
		TSDynamicPassword tsDynamicPassword = new TSDynamicPassword();
		String dynamicPassword = FBStringUtils.exctractRandCode(Constants.WEIXINBIND_RANDCODETYPE_NUMBER,Constants.WEIXINBIND_RANDCODELENGTH);
		tsDynamicPassword.setId(UUIDGenerator.generate());
		tsDynamicPassword.setDynamic_password(dynamicPassword.toUpperCase());
		tsDynamicPassword.setSend_to(mobile);
		//状态 0:未使用 1:已使用
		tsDynamicPassword.setStatus(Constants.DYNAMIC_PASSWORD_VALID);
		//100:微信用户绑定
		tsDynamicPassword.setType(Constants.DYNAMIC_PASSWORD_TYPE1);
		//根据数据库时间写表
		dynamicPasswordService.saveDynamicPassword(tsDynamicPassword);
		
		String activedProfile = request.getSession().getServletContext().getInitParameter("spring.profiles.active");
		String configFileName = activedProfile != null && activedProfile.length() > 0 ? "dbconfig-" + activedProfile : "dbconfig";
		String url = ResourceBundle.getBundle(configFileName).getString("PLATFORM_MSG_URL");
		String sendMsgToMobile = ResourceBundle.getBundle(configFileName).getString("SENDMSGTOMOBILE");
			
		if("true".equals(sendMsgToMobile)){
			//发送短信,不需要等待平台返回短信发送状态
			Boolean status = dynamicPasswordService.sendMsg(url,Constants.CUSTOMER_BIND_MSGID,dynamicPassword.toUpperCase(),mobile);
			if(status){
				j.setMsg("**请查收短信验证码");
	            j.setSuccess(true);
	            
			}else{
				j.setMsg("**短信发送失败,请稍后再试!");
	            j.setSuccess(false);
	            
			}
			
		} else{
			j.setMsg("**您的富邦验证码为" + dynamicPassword.toUpperCase() + ",有效期为15分钟");
            j.setSuccess(true);
		}
		
		return j;
		
	}
	
	/**
	 * 加油宝发送短信验证码  
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(params = "sendgasolineGiftDynamicPassword")
	public AjaxJson sendgasolineGiftDynamicPassword(HttpServletRequest request,HttpServletResponse response) throws Exception {
		AjaxJson j = new AjaxJson();
		String mobile = request.getParameter("mobile");
		if(StringUtil.isEmpty(mobile)){
			j.setMsg("**手机号不能为空!");
            j.setSuccess(false);
            return j;
		}
		
		//查询该手机是否存在1分钟内发送的验证码
		boolean isExists = dynamicPasswordService.findLatestTSDynamicPassword(mobile);
		if(isExists){
			j.setMsg("**距离上次发送短信不到1分钟!");
            j.setSuccess(false);
            return j;
		} 
		
		//重新生成四位随机验证码写表
		TSDynamicPassword tsDynamicPassword = new TSDynamicPassword();
		String dynamicPassword = FBStringUtils.exctractRandCode(Constants.WEIXINBIND_RANDCODETYPE_NUMBER,Constants.WEIXINBIND_RANDCODELENGTH);
		tsDynamicPassword.setId(UUIDGenerator.generate());
		tsDynamicPassword.setDynamic_password(dynamicPassword.toUpperCase());
		tsDynamicPassword.setSend_to(mobile);
		//状态 0:未使用 1:已使用
		tsDynamicPassword.setStatus(Constants.DYNAMIC_PASSWORD_VALID);
		//100:微信用户绑定
		tsDynamicPassword.setType(Constants.DYNAMIC_PASSWORD_TYPE1);
		//根据数据库时间写表
		dynamicPasswordService.saveDynamicPassword(tsDynamicPassword);
		
		String activedProfile = request.getSession().getServletContext().getInitParameter("spring.profiles.active");
		String configFileName = activedProfile != null && activedProfile.length() > 0 ? "dbconfig-" + activedProfile : "dbconfig";
		String url = ResourceBundle.getBundle(configFileName).getString("PLATFORM_MSG_URL");
		String sendMsgToMobile = ResourceBundle.getBundle(configFileName).getString("SENDMSGTOMOBILE");
			
		if("true".equals(sendMsgToMobile)){
			//发送短信,不需要等待平台返回短信发送状态
			Boolean status = dynamicPasswordService.sendMsg(url,Constants.CUSTOMER_BIND_MSGID,dynamicPassword.toUpperCase(),mobile);
			if(status){
				j.setMsg("**请查收短信验证码");
	            j.setSuccess(true);
	            
			}else{
				j.setMsg("**短信发送失败,请稍后再试!");
	            j.setSuccess(false);
	            
			}
			
		} else{
			j.setMsg("**您的富邦验证码为" + dynamicPassword.toUpperCase() + ",有效期为15分钟");
            j.setSuccess(true);
		}
		
		return j;
		
	}
	
//	@ResponseBody
//    @RequestMapping(params = "checkDynamicPassword")
//    public AjaxJson checkDynamicPassword(HttpServletRequest request,HttpServletResponse response) throws Exception{
//    	AjaxJson j = new AjaxJson();
//    	String mobile = request.getParameter("mobile");
//    	String dynamicpassword = request.getParameter("dynamicpassword");
//    	if(FBStringUtils.isAnyEmpty(mobile,dynamicpassword)){
//    		j.setMsg("**手机号和验证码不能为空,请录入后再试");
//            j.setSuccess(false);
//    	}
//    	boolean flag = dynamicPasswordService.checkDynamicPassword(mobile, dynamicpassword.toUpperCase());
//    	if(!flag){
//    		//验证码不可用
//    		j.setMsg("**验证码错误或已过期,请核对后再试");
//            j.setSuccess(false);
//    	}
//    	return j;
//    }
}
