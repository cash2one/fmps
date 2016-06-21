package cn.com.fubon.fo.customernewcarlicence.controller;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import jodd.datetime.JDateTime;
import jodd.util.StringUtil;

import org.apache.commons.chain.Context;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.jeecgframework.core.extend.datasource.DataSourceContextHolder;
import org.jeecgframework.core.extend.datasource.DataSourceType;
import org.jeecgframework.core.util.UUIDGenerator;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.com.fubon.fo.customerbind.service.CustomerBindService;
import cn.com.fubon.fo.customernewcarlicence.entity.CustomerNewCarLicenceRecord;
import cn.com.fubon.fo.customernewcarlicence.service.CustomerNewCarLicenceService;
import cn.com.fubon.util.CachedUtils;
import cn.com.fubon.util.Constants;
import cn.com.fubon.webservice.MainWebServiceClient;
import cn.com.fubon.webservice.WsConstants;
import cn.com.fubon.webservice.entity.request.FbNewCarLicenseRequestBody;
import cn.com.fubon.webservice.entity.request.FbWSRequest;
import cn.com.fubon.webservice.entity.request.RequestHead;
import cn.com.fubon.webservice.entity.response.FbWSResponse;
import cn.com.fubon.webservice.externl.coresystem.CoreWSConstants;
import cn.com.fubon.webservice.externl.coresystem.entity.FbNewCarLicenseResponseBody;
import cn.com.fubon.webservice.redotask.RedoTaskService;

/**
 * 客户新车上牌控制类
 * @author shanqi.wang
 *
 */

@Scope("prototype")
@Controller
@RequestMapping("/fo/binded/customerNewCarLicenceController")
public class CustomerNewCarLicenceController {

	@Resource(name="customerNewCarLicenceService")
	private CustomerNewCarLicenceService customerNewCarLicenceService;
	
	@Resource(name="oracleCustomerNewCarLicenceService")
	private CustomerNewCarLicenceService oracleCustomerNewCarLicenceService;
	
	@Resource(name="coreosWSClientNewCar")
	private MainWebServiceClient wsClient;
	
	@Resource(name="redoTaskService")
	private RedoTaskService redoTaskService;
	 
	@Resource
	private CustomerBindService customerBindService;	
	private static final Logger logger = Logger.getLogger(CustomerNewCarLicenceController.class);	
	private  String returnMessage=""; //webservice 返回信息 
	private  String applicationNo="";//核心系统返回的批单号
	
	/**
	 * 查询客户新车信息，返回给JSP页面 
	 * @param request
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(params = "method=getCustomerNewCarLicence")
	public ModelAndView getCustomerNewCarLicence(HttpServletRequest request)
			throws Exception {
		String openid;		
		String openidParameter=request.getParameter("openid");
		String openidAttribute=(String) request.getAttribute("openid");
		 if( StringUtil.isEmpty(openidParameter)){
			 openid= openidAttribute;
		     }else{
		    	 openid=openidParameter;
		      }
		//已经完成上牌的车辆，车架号
		String framenoList="'frameno'";
		//从session 获取客户号
		 /*20141208 patrick.z*/
		// String customerCode =(String)CachedUtils.get(openid);		
		 String identifynumber =(String)CachedUtils.get(openid + Constants.MEMKEY_IDENTIFYNUMBER);
		 String customercname =(String)CachedUtils.get(openid + Constants.MEMKEY_CUSTOMERCNAME);	
		 // WeiXinGzUserInfo weiXinGzUserInfo = customerBindService.findUniqueByProperty(WeiXinGzUserInfo.class, "openid", openid);
		 // identifynumber=weiXinGzUserInfo.getIdentifynumber();
		 // customercname=weiXinGzUserInfo.getCustomercname();
		//查询客户已经上牌的车辆
		List<Map<String, Object>> NewCarHasLicenceList = new ArrayList<Map<String, Object>>(); // 已经完成上牌的车辆		
		NewCarHasLicenceList=customerNewCarLicenceService.getNewCarHasLicenceRecord(identifynumber,customercname);	
		//把mysql 的已经上牌的数据 查出，以便ORACLE 查询排除
		 for (int i = 0; i < NewCarHasLicenceList.size(); i++) {		    
			      framenoList=framenoList+",'"+ (String) NewCarHasLicenceList.get(i).get("frameno")+"'";		   	 
		     }

		List<Map<String, Object>> customerNewCarLicenceList = new ArrayList<Map<String, Object>>(); // 传递到JSP的数据
	    customerNewCarLicenceList=oracleCustomerNewCarLicenceService.getCustomerNewCarLicenceRecord(identifynumber,customercname,framenoList);
	    
	    if(customerNewCarLicenceList.size()<1){
			request.setAttribute("message", "没有查询到您的新车保单");
			return new ModelAndView("/fo/common/message");			
		}else{	    
		  request.setAttribute("customerNewCarLicenceList", customerNewCarLicenceList);	
		  logger.info("request.setAttribute(openid, openid); ====> " + openid); 
		  request.setAttribute("openid", openid);
		  return new ModelAndView("/fo/customernewcarlicence/customernewcarlicence");
		}
	}
	
	 /**
	  * 新车上牌
	  * @param req
	  * @return
	  */
	@RequestMapping(params = "updateNewCarLicence")
	public String updateNewCarLicence(HttpServletRequest req) {
		String message = "";
        String randCode = req.getParameter("randCode"); //验证码    randCode
        String frameno = req.getParameter("frameno");   //车架号 
        String carLicence = req.getParameter("carLicence"); //车牌号	
		 /*20141208 patrick.z*/
		String openid = (String) req.getAttribute("openid");
		if (StringUtil.isEmpty(openid)) {
			openid = req.getParameter("openid");
		}
		String identifynumber =(String)CachedUtils.get(openid + Constants.MEMKEY_IDENTIFYNUMBER);
		String customercname =(String)CachedUtils.get(openid + Constants.MEMKEY_CUSTOMERCNAME);	 
		 
	
    	logger.info("openid ====> " + openid);    	
     	//HttpSession session=req.getSession();
    	//String SessioonRandCode=(String)session.getAttribute(Constants.SESSION_KEY_RAND_CODE);
    	//logger.info("RandCode IN Sessioon ====> " + SessioonRandCode +", SessionID:"+session.getId());    	 
        if (StringUtils.isEmpty(randCode)) {
        	message = "未输入验证码！";
        	req.setAttribute("messageType", Constants.MESSAGE_TYPE_WARN);
        } else if (StringUtils.isEmpty(frameno)) {
        	message = "未选择车辆信息！";
        	req.setAttribute("messageType", Constants.MESSAGE_TYPE_WARN);
        }else if (StringUtils.isEmpty(carLicence)) {
        	message = "未输入车牌号！";
        	req.setAttribute("messageType", Constants.MESSAGE_TYPE_WARN);
        }else if (!randCode.equalsIgnoreCase(String.valueOf(this.getServiceRandCode(req)))) {
            // 使用  与首页相同的验证码   "randCode"为生产验证码时，已经保存到session中了 
        	message = "验证码错误！";
        	req.setAttribute("messageType", Constants.MESSAGE_TYPE_WARN);
        }else if(sendMessage(frameno,carLicence,openid,identifynumber,customercname).equals(CoreWSConstants.CORE_WS_RETURN_CODE_SUCCESS)){        	
        	 //保存 数据
        	 logger.info("报文发送成功，批单号：=========>"+applicationNo);	
           	CustomerNewCarLicenceRecord  customerNewCarLicenceRecord =  new CustomerNewCarLicenceRecord();        
           	customerNewCarLicenceRecord.setFrameno(frameno);
           	customerNewCarLicenceRecord.setLicenseno(carLicence); 
           	//customerNewCarLicenceRecord.setCustomerCode(customerCode);
        	customerNewCarLicenceRecord.setStatus(CoreWSConstants.CORE_WS_RETURN_CODE_SUCCESS);  //  状态 1 成功  2 失败     
        	customerNewCarLicenceRecord.setApplicationNo(applicationNo);
        	customerNewCarLicenceRecord.setIdentifynumber(identifynumber);
        	JDateTime jnow = new JDateTime(new Date());	
        	customerNewCarLicenceRecord.setCreateTime(jnow.convertToDate());
        	customerNewCarLicenceRecord.setCustomercname(customercname);
      	    customerNewCarLicenceService.save(customerNewCarLicenceRecord);       	         	    
            message = "您车架号为 " + frameno + "的新车已经成功上牌！ ";
        } else{
        	String activedProfile = req.getSession().getServletContext().getInitParameter("spring.profiles.active");
        	if(!activedProfile.equals("prod")) {  //如果是开发及测试环境把核心返回的错误一起显示出来 
        		message = "数据保存异常，请稍后再试。"+ returnMessage ;
        	}else {
        		message = "数据保存异常，请稍后再试。  ";
        	}
        	 
        	req.setAttribute("messageType", Constants.MESSAGE_TYPE_ERROR);
        }
        
        req.setAttribute("message", message);    	
		return "/fo/common/message";
	}
	
	
	 /**
	  * 发送报文 返回 0000:处理成功;
      *           1000:处理失败
      *           1111:车牌号已存在;
      *           8888:流水号重复的异常;
      *           9999:未知异常;
	  * @param frameno
	  * @param carLicence
	  * @param openid
	  * @param identifynumber
	  * @param customercname
	  * @return
	  */
	public String sendMessage( String frameno,String carLicence,String openid,String identifynumber,String customercname){
		 String returnCode =CoreWSConstants.CORE_Contact_Failure; //默认错误	 	
		 DataSourceContextHolder.setDataSourceType(DataSourceType.dataSource_oracle);
		 Map<String, Object>  policyinfo =oracleCustomerNewCarLicenceService.getCustomerPolicyNoAndCustomerID(identifynumber,customercname,frameno);		 
		  String policyNo= (String) policyinfo.get("policyno");
		  String customerId= (String) policyinfo.get("insuredcode");			 
		try {
			JDateTime jnow = new JDateTime(new Date());		 
			RequestHead requestHead = new RequestHead();			
			requestHead.setClientCode(WsConstants.REQUEST_HEAD_KEY_CLIENT_CODE_COREOS);
			requestHead.setServerCode(WsConstants.REQUEST_HEAD_KEY_SERVER_CODE_CORE);
			requestHead.setTranscationCode(WsConstants.REQUEST_HEAD_KEY_TRANSATION_CODE_42);
			requestHead.setTranscationDate(jnow.toString("YYYYMMDD"));
			requestHead.setTranscationTime(jnow.toString("hhmmss"));
			requestHead.setTranscationSeqNo(UUIDGenerator.generate()); //交易流水号 			
			FbNewCarLicenseRequestBody requestBody = new FbNewCarLicenseRequestBody();
			requestBody.setPolicyNo(policyNo);  //保单号
			requestBody.setLicenseNo(carLicence);  //新的车牌号
			requestBody.setInsuredCode(customerId);  //客户编码
			requestBody.setOpenId(openid);  //微信账号
			
			//测试使用 -----
			//requestBody.setPolicyNo("805012014210201017591");  //保单号	
			//requestBody.setInsuredCode("5000002000000003");   //客户编码
			//requestBody.setOpenId("Eilly@com.cn");   //微信账号
			//-----
			
			FbWSRequest request = new FbWSRequest();
			request.setRequestHead(requestHead);
			request.setRequestBody(requestBody);			
			wsClient.setRequest(request);
			Context context =wsClient.startExecuteChain();	 
			FbWSResponse fbWsResponse=(FbWSResponse) context.get(WsConstants.CHAIN_CONTEXT_KEY_WS_RESPOSNE);			
		     returnCode=fbWsResponse.getResponseHead().getTransResponse().getReturnCode();
		     returnMessage =fbWsResponse.getResponseHead().getTransResponse().getReturnMessage();
		     FbNewCarLicenseResponseBody   fbNewCarLicenseResponseBody=(FbNewCarLicenseResponseBody) fbWsResponse.getResponseBody();	
             applicationNo=fbNewCarLicenseResponseBody.getApplicationNo(); //  (String) fbWsResponse.getResponseBody().get("applicationNo");		   
		     logger.info("returnCode:"+returnCode+ "" +"returnMessage:"+returnMessage);			
		}catch(Exception e) {
		   logger.info("调用WS出错，错误信息：");
			e.printStackTrace();
		}
		return returnCode;
	}
	
	
	/**
	 * 从session获取验证码
	 * 
	 * @param request
	 * @return String
	 */
	@SuppressWarnings("unused")
	private String getServiceRandCode(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String openid = request.getParameter("openid");
		String randCodeInSession = (String) session
				.getAttribute(Constants.SESSION_KEY_RAND_CODE);
		logger.info("offlineWechatPay,from server session, randCode=>"
				+ randCodeInSession + ",sessionid=>" + session.getId());
		// 若session为空则从membercahced中取值		
		if (StringUtils.isEmpty(randCodeInSession)) {
			randCodeInSession = (String) CachedUtils.get("randCode" + openid);
			logger.info("offlineWechatPay,from server membercahced, randCode=>"
					+ randCodeInSession);
		}
		return randCodeInSession;
	}
	
  }
	
	
	
	
	
	