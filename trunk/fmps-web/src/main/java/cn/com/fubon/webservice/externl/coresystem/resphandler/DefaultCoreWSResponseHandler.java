/**
 * 
 */
package cn.com.fubon.webservice.externl.coresystem.resphandler;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.chain.Context;
import org.apache.log4j.Logger;
import org.jeecgframework.core.util.UUIDGenerator;
import org.springframework.beans.factory.annotation.Autowired;

import cn.com.fubon.bo.wsinvokelog.entity.WsInvokeFailureLog;
import cn.com.fubon.bo.wsinvokelog.service.WsInvokeFailureLogService;
import cn.com.fubon.util.WebServiceUtils;
import cn.com.fubon.util.XmlUtils;
import cn.com.fubon.webservice.ResponseHandler;
import cn.com.fubon.webservice.WsConstants;
import cn.com.fubon.webservice.entity.request.FbWSRequest;
import cn.com.fubon.webservice.entity.request.RequestBody;
import cn.com.fubon.webservice.entity.response.FbWSResponse;
import cn.com.fubon.webservice.externl.coresystem.CoreWSConstants;

/**
 * @author binbin.wang
 *
 */
public abstract class DefaultCoreWSResponseHandler implements ResponseHandler {
	Logger logger = Logger.getLogger(DefaultCoreWSResponseHandler.class);

	@Autowired
	private WsInvokeFailureLogService wsInvokeFailureLogService;
	
	public abstract String getWsClientBeanName();

	@Override
	public void process(Context context) {
		FbWSRequest request = (FbWSRequest)context.get(WsConstants.CHAIN_CONTEXT_KEY_WS_REQUEST);
		FbWSResponse response = (FbWSResponse)context.get(WsConstants.CHAIN_CONTEXT_KEY_WS_RESPOSNE);
		
		String returnCode = (response == null) ? null : response.getResponseHead().getTransResponse().getReturnCode();

		//取消以前发送失败的日志记录  0 发送失败 1 发送成功 ，-1 待发送
		wsInvokeFailureLogService.updateBySqlString("update webservice_invoke_failure_log log set log.status = 0 where log.transcation_seq_no =  '" + request.getRequestHead().getTranscationSeqNo() +"'");

		//调用不成功，记录到发送失败日志表中，重新发送
		if (!CoreWSConstants.CORE_WS_RETURN_CODE_SUCCESS.equals(returnCode)) {
			WsInvokeFailureLog wsInvokeFailureLog = this.generateWsInvokeFailureLog(request, response);
			wsInvokeFailureLogService.save(wsInvokeFailureLog);
		}
	}
	
	private WsInvokeFailureLog generateWsInvokeFailureLog(FbWSRequest request, FbWSResponse response) {
		
		WsInvokeFailureLog wsInvokeFailureLog = new WsInvokeFailureLog();
		
		String internalRequest = XmlUtils.toXML(request);
		String internalResponse = XmlUtils.toXML(response);
			
		wsInvokeFailureLog.setClientCode(request.getRequestHead().getClientCode());
		wsInvokeFailureLog.setInternalRequest(internalRequest);
		wsInvokeFailureLog.setInternalResponse(internalResponse);
		wsInvokeFailureLog.setReturnCode(response == null ? null : response.getResponseHead().getTransResponse().getReturnCode());
		wsInvokeFailureLog.setReturnMessage(response == null ? null : response.getResponseHead().getTransResponse().getReturnMessage());
		
		//产生新的流水号
		wsInvokeFailureLog.setTranscationSeqNo(UUIDGenerator.generate());
		//记录原始的上一笔交易流水号
		wsInvokeFailureLog.setOrginTranscationSeqNo(request.getRequestHead().getTranscationSeqNo());
		wsInvokeFailureLog.setWsClientBeanName(this.getWsClientBeanName());
		wsInvokeFailureLog.setStatus(CoreWSConstants.treatment_waiting);
		//序列化FbWSRequest 20150630
        wsInvokeFailureLog.setInternalRequestObj(WebServiceUtils.serializeObject(request));
		return wsInvokeFailureLog;
	}
	@Override
	public void  saveSendFailure(FbWSRequest request){		
        WsInvokeFailureLog wsInvokeFailureLog = new WsInvokeFailureLog();		
		String internalRequest = XmlUtils.toXML(request);
		wsInvokeFailureLog.setClientCode(request.getRequestHead().getClientCode());
		wsInvokeFailureLog.setInternalRequest(internalRequest);
		//产生新的流水号
		wsInvokeFailureLog.setTranscationSeqNo(UUIDGenerator.generate());
		//记录原始的上一笔交易流水号
		wsInvokeFailureLog.setOrginTranscationSeqNo(request.getRequestHead().getTranscationSeqNo());
		wsInvokeFailureLog.setNextInvokeTime(new Date());
		wsInvokeFailureLog.setStatus(CoreWSConstants.treatment_waiting);
		wsInvokeFailureLog.setReturnCode(CoreWSConstants.CORE_Contact_Failure); 
		wsInvokeFailureLog.setReturnMessage(CoreWSConstants.CORE_Contact_Message); 
		wsInvokeFailureLog.setSendCount(1);
		//序列化FbWSRequest 20150630
        wsInvokeFailureLog.setInternalRequestObj(WebServiceUtils.serializeObject(request));
		wsInvokeFailureLog.setWsClientBeanName(this.getWsClientBeanName());			
		wsInvokeFailureLogService.save(wsInvokeFailureLog);
	}
	

	
}
