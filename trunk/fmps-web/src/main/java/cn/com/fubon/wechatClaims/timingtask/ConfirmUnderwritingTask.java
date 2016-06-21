package cn.com.fubon.wechatClaims.timingtask;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.jeecgframework.core.util.DateUtils;
import org.jeecgframework.core.util.ResourceUtil;
import org.jeecgframework.core.util.UUIDGenerator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import weixin.popular.util.JsonUtil;
import cn.com.fubon.rest.entity.request.FmcpSendMessageRequest;
import cn.com.fubon.rest.service.impl.RestWebServiceClient;
import cn.com.fubon.util.Constants;
import cn.com.fubon.webservice.WsConstants;
import cn.com.fubon.webservice.entity.response.FbWSResponse;
import cn.com.fubon.webservice.server.WebServiceClientManagementService;
import cn.com.fubon.webservice.server.entity.WebServiceClientManagement;
import cn.com.fubon.wechatClaims.entity.ReportInfo;
import cn.com.fubon.wechatClaims.service.ClaimWebService;
import cn.com.fubon.wechatClaims.service.ReportInfoService;

@Service("confirmUnderwritingTask")
@Transactional
public class ConfirmUnderwritingTask {
	
	private static final Logger logger = Logger
			.getLogger(ConfirmUnderwritingTask.class);
	@Resource(name="confirmUnderwriting")
	private RestWebServiceClient confirmUnderwritingWsClient;
	@Resource(name = "claimWebService")
	private ClaimWebService claimWebService;
	@Resource
	private ReportInfoService reportInfoService;
	@Resource
	private WebServiceClientManagementService  webServiceClientManagementService;
	
	public void autoSendMessage() throws Exception {		
		logger.info("enter_autoSendMessage");		
      List<ReportInfo>  reportInfoList=this.getReportInfoList();    
      for (ReportInfo reportInfo:reportInfoList){    	  
    	if(this.sendMessageToCore(reportInfo) ){
    		//发送核心成功更新本地数据库
    	reportInfo.setConfirmTime(Timestamp.valueOf(DateUtils
				.getDate("yyyy-MM-dd HH:mm:ss")));
    	reportInfo.setConfirmStyle(Constants.WS_CLAIM_FEE_CONFIRM_STYLE_0);
    	reportInfoService.saveOrUpdate(reportInfo);
    	//给企业号发送消息
    	this.sendMessageToFcps(reportInfo);    
    	}
      }		
	}
	
	
	/**
	 * 获取满足条件需要发送消息的记录
	 * 
	 * @return
	 */
	private List<ReportInfo> getReportInfoList() {	
		//1、未被手工确认 2、理赔状态为核赔提交  3、当前时间-核赔时间 > 5分钟 
		return reportInfoService.getAutoConfirmReportInfoList();
	}
	
	
	//发送消息到核心系统,成功true ,失败  false 
	private boolean sendMessageToCore(ReportInfo reportInfo){		
		boolean reMessage=false;
		FbWSResponse response = claimWebService
				.claimFeeConfirmed("",reportInfo.getRegistNo(),
						Constants.WS_CLAIM_FEE_CONFIRM_STYLE_0);
		if(WsConstants.RETURNCODE_1.equals(response.getResponseHead().getTransResponse().getReturnCode())){
			reMessage=true; 
		}
		return  reMessage ;
		
	} 

	//发送消息到微信企业号
	public void sendMessageToFcps(ReportInfo reportInfo){
		logger.info("Enter_sendMessageToFcps--registNo==>"+reportInfo.getRegistNo());
		String clientCode = ResourceUtil.getBundleEnvAbout().getString(
				"clientCode");
		WebServiceClientManagement WebServiceClientManagement = webServiceClientManagementService
				.findUniqueByProperty(WebServiceClientManagement.class,
						"clientCode", clientCode);
		List<String> operatorNameList   =new ArrayList<String>();
		operatorNameList.add(reportInfo.getOperatorCode());	
		String text = "系统自动确认事故号";
		if(Constants.WS_CLAIM_FEE_CONFIRM_STYLE_1.equals(reportInfo.getConfirmStyle())){
			text = "客户手工确认事故号";
		}
		String message="车牌:"+reportInfo.getLicenseNo()+"。\n" 		
 		               +"被保险人："+reportInfo.getReportorName()+"。\n" 
 		               +"报案号："+reportInfo.getRegistNo()+"。\n"  
    	               +"客户"+Timestamp.valueOf(DateUtils.getDate("yyyy-MM-dd HH:mm:ss")) 
 		    		   + text+reportInfo.getRegistNo()+"赔案，最终赔付金额"+reportInfo.getClaimCaseFee().toString() +"元。";	
		String FcpsNoticeApplication = ResourceUtil.getBundleEnvAbout().getString(
				"FcpsNoticeApplication");
		FmcpSendMessageRequest fmcpSendMessageRequest=new FmcpSendMessageRequest("fmps", "fcps","json", "16",UUIDGenerator.generate(), message,operatorNameList,FcpsNoticeApplication);
		String fmcpSendMessageRequestJson = JsonUtil.toJSONString(fmcpSendMessageRequest);		
		try {
			confirmUnderwritingWsClient.startExecuteChain(fmcpSendMessageRequestJson, WebServiceClientManagement.getToken(), WebServiceClientManagement.getAESKey(), clientCode);
		} catch (Exception e) {			 
			logger.error("sendMessageToFcps failed",e);
			
		}
			
	} 

}
