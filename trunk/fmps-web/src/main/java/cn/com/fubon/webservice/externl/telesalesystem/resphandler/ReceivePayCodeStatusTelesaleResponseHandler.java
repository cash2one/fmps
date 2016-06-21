/**
 * 
 */
package cn.com.fubon.webservice.externl.telesalesystem.resphandler;

import java.util.Date;

import javax.annotation.Resource;

import org.dozer.Mapper;
import org.jeecgframework.core.common.service.CommonService;
import org.jeecgframework.core.util.UUIDGenerator;
import org.springframework.transaction.annotation.Transactional;

import cn.com.fubon.bo.wsinvokelog.entity.WsInvokeFailureLog;
import cn.com.fubon.bo.wsinvokelog.service.WsInvokeFailureLogService;
import cn.com.fubon.pay.entity.WeiXinOfflineOrderInfo;
import cn.com.fubon.util.WebServiceUtils;
import cn.com.fubon.util.XmlUtils;
import cn.com.fubon.webservice.entity.request.FbTelesaleRequestBody;
import cn.com.fubon.webservice.entity.request.FbWSRequest;
import cn.com.fubon.webservice.externl.telesalesystem.TelesaleWSConstants;
import cn.com.fubon.webservice.externl.telesalesystem.entity.TelesaleResponse;

/**
 * @author qingqu.huang
 *
 */
@Transactional(rollbackFor=Exception.class)
public class ReceivePayCodeStatusTelesaleResponseHandler implements TelesaleResponseHandler{

	@Resource
	private Mapper mapper;
	@Resource
	private CommonService commonService;
	@Resource
	private WsInvokeFailureLogService wsInvokeFailureLogService;
	
	@Override
	public WeiXinOfflineOrderInfo process(TelesaleResponse telesaleResponse){
		//ReceivePayCodeStatus是异步调用,不处理返回
		return null;
	}
	
	/**
	 * 异步webservice调用失败写webservice_invoke_failure_log表
	 */
	@Override
	public void  saveSendFailure(FbWSRequest fbWSRequest)
	{		
        WsInvokeFailureLog wsInvokeFailureLog = new WsInvokeFailureLog();		
		String internalRequest = XmlUtils.toXML(fbWSRequest);
		wsInvokeFailureLog.setClientCode(fbWSRequest.getRequestHead().getClientCode());
		wsInvokeFailureLog.setInternalRequest(internalRequest);
		//产生新的流水号
		wsInvokeFailureLog.setTranscationSeqNo(UUIDGenerator.generate());
		//记录原始的上一笔交易流水号
		wsInvokeFailureLog.setOrginTranscationSeqNo(fbWSRequest.getRequestHead().getTranscationSeqNo());
		wsInvokeFailureLog.setNextInvokeTime(new Date());
		wsInvokeFailureLog.setStatus(TelesaleWSConstants.TREATMENT_WAITING);
		wsInvokeFailureLog.setReturnCode(TelesaleWSConstants.TELESALE_CONNECT_FAILURE); 
		wsInvokeFailureLog.setReturnMessage(TelesaleWSConstants.TELESALE_CONNECT_MESSAGE); 
		wsInvokeFailureLog.setSendCount(1);
		//因为异步请求还没有取到response所以
		FbTelesaleRequestBody requestBody = (FbTelesaleRequestBody)fbWSRequest.getRequestBody();
		wsInvokeFailureLog.setWsClientBeanName(requestBody!=null ? requestBody.getWsClientBeanName() : "");		
		//序列化
		wsInvokeFailureLog.setInternalRequestObj(WebServiceUtils.serializeObject(fbWSRequest));
		wsInvokeFailureLogService.save(wsInvokeFailureLog);
	}

	@Override
	public WeiXinOfflineOrderInfo asyncExecuteprocess(
			TelesaleResponse telesaleResponse) {
		// TODO Auto-generated method stub
		return null;
	}
}
