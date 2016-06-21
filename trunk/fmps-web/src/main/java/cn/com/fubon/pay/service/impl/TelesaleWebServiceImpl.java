package cn.com.fubon.pay.service.impl;

import java.util.Arrays;
import java.util.Date;

import javax.annotation.Resource;

import jodd.datetime.JDateTime;

import org.apache.commons.chain.Context;
import org.apache.log4j.Logger;
import org.jeecgframework.core.util.UUIDGenerator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.fubon.pay.entity.WeiXinOfflineOrderInfo;
import cn.com.fubon.pay.service.TelesaleWebService;
import cn.com.fubon.webservice.MainWebServiceClient;
import cn.com.fubon.webservice.WsConstants;
import cn.com.fubon.webservice.commands.telesaleclient.TelesaleRequestSender;
import cn.com.fubon.webservice.entity.request.FbTelesaleRequestBody;
import cn.com.fubon.webservice.entity.request.FbWSRequest;
import cn.com.fubon.webservice.entity.request.RequestHead;
import cn.com.fubon.webservice.externl.telesalesystem.TelesaleWSConstants;

@Service("telesaleWebService")
@Transactional
public class TelesaleWebServiceImpl implements TelesaleWebService {
	private static final Logger logger = Logger.getLogger(TelesaleWebServiceImpl.class);

	@Resource(name="telesaleWSClientGetPayInfo")
	private MainWebServiceClient telesaleWSClientGetPayInfo;
	
	@Resource(name="telesaleWSClientCheckPayCode")
	private MainWebServiceClient telesaleWSClientCheckPayCode;
	
	@Resource(name="telesaleWSClientUpdatePayInfo")
	private MainWebServiceClient telesaleWSClientUpdatePayInfo;
	
	@Resource(name="clauseReadingWSClient")
	private MainWebServiceClient clauseReadingWSClient;
	
	
	@Resource
	private MainWebServiceClient telesaleWSClientReceivePayCodeStatus;
	
	
	/**
	 * 
	 * @param policyno (保单号)
	 * @param wxreadflag (是否阅读条款，1：已阅读)
	 * @param wxgiftflag (是否领用礼品，1：已领用)
	 * @param wxgift (礼品值)
	 * @return
	 */
	public String sendMessageToTelesale(String policyno, String wxreadflag,String wxgiftflag, String wxgift){
		String[] paramNames = new String[]{TelesaleWSConstants.Clause_Reading_policyno,TelesaleWSConstants.Clause_Reading_wxreadflag,TelesaleWSConstants.Clause_Reading_wxgiftflag,TelesaleWSConstants.Clause_Reading_wxgift};
		String[] params = new String[]{policyno,wxreadflag,wxgiftflag,wxgift};
		
		FbWSRequest request = initFbWSRequest("telesaleWSClientUpdatePayInfo",paramNames,params);
		clauseReadingWSClient.setRequest(request);
		Context context = null;
		try {
			context = clauseReadingWSClient.telesaleStartExecuteChain();
		} catch (Exception e) {
			logger.info("发送给电销的保单阅读情况出错====policyno==>"+policyno);
			e.printStackTrace();
		}
		return  (String) context.get(WsConstants.CHAIN_CONTEXT_KEY_WS_EXTERNL_RESPONSE_XML);
		
		 
	}
	
	
	
	
	/**
	 * 根据支付码获取订单信息
	 */
	@Override
	public WeiXinOfflineOrderInfo getPayInfo(String payCode) throws Exception {
		
		String[] paramNames = new String[]{TelesaleWSConstants.REQUEST_TELESALE_PARAMNAME_1};
		String[] params = new String[]{payCode};
		
		FbWSRequest request = initFbWSRequest("telesaleWSClientGetPayInfo",paramNames,params);
		return callWebService(telesaleWSClientGetPayInfo,request);
	}
	
	/**
	 * 验证支付码
	 */
	@Override
	public WeiXinOfflineOrderInfo checkPayCode(String payCode) throws Exception {
		String[] paramNames = new String[]{TelesaleWSConstants.REQUEST_TELESALE_PARAMNAME_1};
		String[] params = new String[]{payCode};

		FbWSRequest request = initFbWSRequest("telesaleWSClientCheckPayCode",paramNames,params);
		return callWebService(telesaleWSClientCheckPayCode,request);
	}
	
	/**
	 * 更新支付结果
	 */
	@Override
	public WeiXinOfflineOrderInfo updatePayInfo(String payCode,String liushuihao,String account) throws Exception {
		String[] paramNames = new String[]{TelesaleWSConstants.REQUEST_TELESALE_PARAMNAME_1,TelesaleWSConstants.REQUEST_TELESALE_PARAMNAME_2,TelesaleWSConstants.REQUEST_TELESALE_PARAMNAME_3};
		String[] params = new String[]{payCode,liushuihao,account};
		
		FbWSRequest request = initFbWSRequest("telesaleWSClientUpdatePayInfo",paramNames,params);
		return callWebService(telesaleWSClientUpdatePayInfo,request);
	}
	
	/**
	 * 支付完成通知公共服务
	 * @param payCode
	 * @param payCodeStatus
	 * @return
	 * @throws Exception
	 */
	public WeiXinOfflineOrderInfo ReceivePayCodeStatus(String payCode,String payCodeStatus) throws Exception{
		String[] paramNames = new String[]{TelesaleWSConstants.REQUEST_TELESALE_PARAMNAME_1,TelesaleWSConstants.REQUEST_TELESALE_PARAMNAME_4};
		String[] params = new String[]{payCode,payCodeStatus};		
		FbWSRequest request = initFbWSRequest("telesaleWSClientReceivePayCodeStatus",paramNames,params);
		return callWebService(telesaleWSClientReceivePayCodeStatus,request);
	}
	

	/**
	 * 调用webservice返回对象
	 * @param webServiceClient
	 * @param request
	 * @return
	 * @throws Exception
	 */
	private WeiXinOfflineOrderInfo callWebService(MainWebServiceClient webServiceClient,FbWSRequest request)
			throws Exception {
		webServiceClient.setRequest(request);
		Context context = webServiceClient.telesaleStartExecuteChain();
		return (WeiXinOfflineOrderInfo)context.get("WeiXinOfflineOrderInfo");
	}

	/**
	 * 组装一个fbWSRequest
	 * @param requestHead
	 * @param requestBody
	 * @return
	 */
	private FbWSRequest initFbWSRequest(String wsClientBeanName,String[] paramNames,String[] params) {
		RequestHead requestHead = initRequestHead();
		FbTelesaleRequestBody requestBody = initRequestBody(wsClientBeanName,paramNames,params);
		FbWSRequest fbWSRequest = new FbWSRequest();
		fbWSRequest.setRequestHead(requestHead);
		fbWSRequest.setRequestBody(requestBody);
		return fbWSRequest;
	}

	/**
	 * 组装一个requestBody
	 * @param paramNames
	 * @param params
	 * @return
	 */
	private FbTelesaleRequestBody initRequestBody(String wsClientBeanName,String[] paramNames,String[] params) {
		FbTelesaleRequestBody requestBody = new FbTelesaleRequestBody();
		requestBody.setParamNames(Arrays.toString(paramNames));
		requestBody.setParams(Arrays.toString(params));
		requestBody.setWsClientBeanName(wsClientBeanName);
		return requestBody;
	}

	/**
	 * 组装一个requestHead
	 * @return
	 */
	private RequestHead initRequestHead() {
		JDateTime jnow = new JDateTime(new Date());
		RequestHead requestHead = new RequestHead();
		requestHead.setClientCode(WsConstants.REQUEST_HEAD_KEY_CLIENT_CODE_COREOS);
		requestHead.setServerCode(TelesaleWSConstants.REQUEST_HEAD_KEY_SERVER_CODE_TELESALE);
		requestHead.setTranscationCode(TelesaleWSConstants.REQUEST_HEAD_KEY_TRANSATION_CODE_2);
		requestHead.setTranscationDate(jnow.toString("YYYYMMDD"));
		requestHead.setTranscationTime(jnow.toString("hhmmss"));
		requestHead.setTranscationSeqNo(UUIDGenerator.generate());
		return requestHead;
	}

}
