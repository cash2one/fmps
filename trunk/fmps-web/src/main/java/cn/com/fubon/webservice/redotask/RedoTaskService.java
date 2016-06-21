package cn.com.fubon.webservice.redotask;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.MissingResourceException;

import jodd.datetime.JDateTime;
import net.sf.json.JSONObject;

import org.apache.commons.chain.Context;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.dozer.Mapper;
import org.jeecgframework.core.common.service.CommonService;
import org.jeecgframework.core.extend.datasource.DataSourceContextHolder;
import org.jeecgframework.core.extend.datasource.DataSourceType;
import org.jeecgframework.core.util.ApplicationContextUtil;
import org.jeecgframework.core.util.DateUtils;
import org.jeecgframework.core.util.ResourceUtil;
import org.jeecgframework.core.util.UUIDGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import weixin.guanjia.account.entity.WeixinAccountEntity;
import weixin.guanjia.account.service.WeixinAccountServiceI;
import cn.com.fubon.bo.wsinvokelog.entity.WsInvokeFailureLog;
import cn.com.fubon.bo.wsinvokelog.service.WsInvokeFailureLogService;
import cn.com.fubon.rest.service.impl.RestWebServiceClient;
import cn.com.fubon.transaction.entity.TransactionRecord;
import cn.com.fubon.transaction.service.ITransactionRecordService;
import cn.com.fubon.util.WebServiceUtils;
import cn.com.fubon.util.XmlUtils;
import cn.com.fubon.webservice.MainWebServiceClient;
import cn.com.fubon.webservice.WsConstants;
import cn.com.fubon.webservice.entity.request.FbWSRequest;
import cn.com.fubon.webservice.entity.request.RequestHead;
import cn.com.fubon.webservice.entity.response.FbWSResponse;
import cn.com.fubon.webservice.externl.coresystem.CoreWSConstants;
import cn.com.fubon.webservice.externl.telesalesystem.TelesaleWSConstants;
import cn.com.fubon.webservice.externl.telesalesystem.entity.TelesaleResponse;
import cn.com.fubon.webservice.server.entity.WebServiceClientManagement;

/**
 * 定时查询未发送成功的新车报文从新发送
 * 
 * @author shanqi.wang
 *
 */

@Service("redoTaskService")
@Transactional
public class RedoTaskService {
	@Autowired
	private WsInvokeFailureLogService wsInvokeFailureLogService;

	@Autowired
	private Mapper mapper;

	private static final Logger logger = Logger
			.getLogger(RedoTaskService.class);
	private static final String RESPONESTATE = "无返回";

	/**
	 * 定时发送报文
	 * 
	 * @throws Exception
	 */
	public void redoService() throws Exception {
		logger.info("*****RedoTaskService.redoService()*****");
		// 获取所有待发送的数据 ，状态为 -1 且 到发送时间了
		DataSourceContextHolder
				.setDataSourceType(DataSourceType.dataSource_jeecg);
		String hql = "  from WsInvokeFailureLog where status= -1 and now()>next_invoke_time and internal_request_obj is not null and send_count<4 and timestampdiff(day,now(),next_invoke_time)>-1";
		List<WsInvokeFailureLog> wsInvokeFailureLogList = wsInvokeFailureLogService
				.findByQueryString(hql);
		Context context = null;
		String requestJson ="";
		for (WsInvokeFailureLog wsInvokeFailureLog : wsInvokeFailureLogList) {
			if (wsInvokeFailureLog.getInternalRequest().contains(
					"\"transactionFormat\":\"json\"")) { // 是否是json格式报文
				try{
				String clientCode = wsInvokeFailureLog.getClientCode();
				RestWebServiceClient restWebServiceClient = (RestWebServiceClient) ApplicationContextUtil
						.getContext().getBean(
								wsInvokeFailureLog.getWsClientBeanName());
				CommonService commonService = (CommonService) ApplicationContextUtil
						.getContext().getBean("commonService");
				WebServiceClientManagement webServiceClientManagement = commonService
						.findUniqueByProperty(WebServiceClientManagement.class,
								"clientCode", clientCode);
				requestJson = wsInvokeFailureLog.getInternalRequest();
				context = restWebServiceClient.startExecuteChain(requestJson,
						webServiceClientManagement.getToken(),
						webServiceClientManagement.getAESKey(), clientCode);
				String responeJSON = (String) context
						.get(WsConstants.RESPONSEJSON);
				JSONObject responeObj = JSONObject.fromObject(responeJSON);
				if (!responeObj.get("errcode").equals("00000")) { // false
					if (StringUtils
							.isNotEmpty(nextSendSpaceTime(wsInvokeFailureLog
									.getSendCount()))) {
						// 取消本条发送
						this.updateWebserviceInvokeFailureLogStatusAndSeqNo(
								CoreWSConstants.INVOKE_FAILURE_LOG_STATUS_0,
								wsInvokeFailureLog.getTranscationSeqNo());
						wsInvokeFailureLogService.save(this.setNextSendObject(
								wsInvokeFailureLog, requestJson, responeJSON));
					}
				} else { // success
					this.updateWebserviceInvokeFailureLogStatusAndSeqNo(
							CoreWSConstants.INVOKE_FAILURE_LOG_STATUS_1,
							wsInvokeFailureLog.getTranscationSeqNo());
					packetPutDB(requestJson, responeJSON);
				}
				}catch(Exception e){
					this.updateWebserviceInvokeFailureLogStatusAndSeqNo(
							CoreWSConstants.INVOKE_FAILURE_LOG_STATUS_0,
							wsInvokeFailureLog.getTranscationSeqNo());
					wsInvokeFailureLogService.save(this.setNextSendObject(
							wsInvokeFailureLog, requestJson, null));
				}
			} else {
				byte[] savedInternalRequestObj = wsInvokeFailureLog
						.getInternalRequestObj();
				// 反序列化
				FbWSRequest fbWSRequest = (FbWSRequest) WebServiceUtils
						.unserializeObject(savedInternalRequestObj);
				if (fbWSRequest != null) {
					RequestHead requestHead = fbWSRequest.getRequestHead();
					requestHead.setTranscationSeqNo(wsInvokeFailureLog
							.getTranscationSeqNo());
					JDateTime jnow = new JDateTime(new Date());
					
					if("claimWSClientGetNotCarPicture".equals(wsInvokeFailureLog.getWsClientBeanName())){
					requestHead.setTranscationDate(jnow.toString("YYYY-MM-DD"));
					requestHead.setTranscationTime(jnow.toString("hh:mm:ss"));
					}else{					
					requestHead.setTranscationDate(jnow.toString("YYYYMMDD"));
					requestHead.setTranscationTime(jnow.toString("hhmmss"));
					 }
					fbWSRequest.setRequestHead(requestHead);
					this.getResponse(fbWSRequest, wsInvokeFailureLog);
				}
			}
		}
	}

	private void getResponse(FbWSRequest fbWSRequest,
			WsInvokeFailureLog wsInvokeFailureLog) throws Exception {
		MainWebServiceClient wsClient = (MainWebServiceClient) ApplicationContextUtil
				.getContext().getBean(wsInvokeFailureLog.getWsClientBeanName());
		wsClient.setAsyncInvoke(false);// 修改为同步发送webservice
		wsClient.setRequest(fbWSRequest);

		boolean isTelesale = wsInvokeFailureLog.getWsClientBeanName()
				.startsWith("telesaleWSClient");
		try {
			Context context = isTelesale ? wsClient.telesaleStartExecuteChain()
					: wsClient.startExecuteChain();

			String returnCode = null;
			Object response = null;
			if (isTelesale) {
				TelesaleResponse telesaleResponse = (TelesaleResponse) context
						.get("TelesaleResponse");
				// 如果连接失败telesaleResponse有可能为空
				returnCode = telesaleResponse != null ? telesaleResponse
						.getTelesaleResponseProposal().getReturnCode() : null;
				response = telesaleResponse;

			} else {
				FbWSResponse fbWsResponse = (FbWSResponse) context
						.get(WsConstants.CHAIN_CONTEXT_KEY_WS_RESPOSNE);
				returnCode = fbWsResponse != null ? fbWsResponse
						.getResponseHead().getTransResponse().getReturnCode()
						: null;
				response = fbWsResponse;
			}

			if (CoreWSConstants.CORE_WS_RETURN_CODE_SUCCESS.equals(returnCode)) { // 发送成功处理
				this.updateWebserviceInvokeFailureLogStatusAndSeqNo(
						CoreWSConstants.INVOKE_FAILURE_LOG_STATUS_1,
						fbWSRequest.getRequestHead().getTranscationSeqNo());
			} else { // 发送失败处理
				// 取消本条发送
				this.updateWebserviceInvokeFailureLogStatusAndSeqNo(
						CoreWSConstants.INVOKE_FAILURE_LOG_STATUS_0,
						fbWSRequest.getRequestHead().getTranscationSeqNo());
				// 如果需要再次发送，需要生成新的实体对象，保存到数据库中
				if (StringUtils.isNotEmpty(nextSendSpaceTime(wsInvokeFailureLog
						.getSendCount()))) {
					wsInvokeFailureLogService.save(this.genNextSendObject(
							isTelesale, fbWSRequest, response,
							wsInvokeFailureLog.getWsClientBeanName(),
							wsInvokeFailureLog.getSendCount()));
				}
			}
		} catch (Exception e) {
			this.updateWebserviceInvokeFailureLogStatusAndSeqNo(
					CoreWSConstants.INVOKE_FAILURE_LOG_STATUS_0, fbWSRequest
							.getRequestHead().getTranscationSeqNo());
			if (StringUtils.isNotEmpty(nextSendSpaceTime(wsInvokeFailureLog
					.getSendCount()))) {
				wsInvokeFailureLogService.save(this.genNextSendObject(
						isTelesale, fbWSRequest, null,
						wsInvokeFailureLog.getWsClientBeanName(),
						wsInvokeFailureLog.getSendCount()));
			}
		}
	}

	/**
	 * 生成下次要发送的WsInvokeFailureLog对象
	 * 
	 * @param isTelesale
	 * @param fbWSRequest
	 * @param response
	 * @param wsClientBeanName
	 * @param sendCount
	 * @return
	 */
	private WsInvokeFailureLog genNextSendObject(boolean isTelesale,
			FbWSRequest fbWSRequest, Object response, String wsClientBeanName,
			int sendCount) {

		WsInvokeFailureLog wsInvokeFailureLog = new WsInvokeFailureLog();
		String internalRequest = XmlUtils.toXML(fbWSRequest);
		String internalResponse = XmlUtils.toXML(response);
		wsInvokeFailureLog.setClientCode(fbWSRequest.getRequestHead()
				.getClientCode());
		wsInvokeFailureLog.setInternalRequest(internalRequest);
		wsInvokeFailureLog.setInternalResponse(internalResponse);

		String returnCode = null;
		String returnMessage = null;
		if (isTelesale) {
			returnCode = response != null ? ((TelesaleResponse) response)
					.getTelesaleResponseProposal().getReturnCode()
					: TelesaleWSConstants.TELESALE_CONNECT_FAILURE;
			returnMessage = response != null ? ((TelesaleResponse) response)
					.getTelesaleResponseProposal().getReturnMessage()
					: TelesaleWSConstants.TELESALE_CONNECT_MESSAGE;

		} else {
			returnCode = response != null ? ((FbWSResponse) response)
					.getResponseHead().getTransResponse().getReturnCode()
					: CoreWSConstants.CORE_Contact_Failure;
			returnMessage = response != null ? ((FbWSResponse) response)
					.getResponseHead().getTransResponse().getReturnMessage()
					: CoreWSConstants.CORE_Contact_Message;
		}
		wsInvokeFailureLog.setReturnCode(returnCode);
		wsInvokeFailureLog.setReturnMessage(returnMessage);

		// 产生新的流水号
		wsInvokeFailureLog.setTranscationSeqNo(UUIDGenerator.generate());
		// 记录原始的上一笔交易流水号
		wsInvokeFailureLog.setOrginTranscationSeqNo(fbWSRequest
				.getRequestHead().getTranscationSeqNo());
		wsInvokeFailureLog.setWsClientBeanName(wsClientBeanName);
		wsInvokeFailureLog.setStatus(CoreWSConstants.treatment_waiting); // 发送状态
																			// -1
																			// 为
																			// 待发送
		wsInvokeFailureLog.setSendCount(sendCount + 1); // 发送次数加 1

		String nextSpace = this.nextSendSpaceTime(sendCount);
		Date date = new Date();
		date.setTime(date.getTime() + Integer.parseInt(nextSpace) * 60 * 1000); // 计数下次发送时间
		wsInvokeFailureLog.setNextInvokeTime(date); // 下次发送时间
		// 序列化
		wsInvokeFailureLog.setInternalRequestObj(WebServiceUtils
				.serializeObject(fbWSRequest));
		return wsInvokeFailureLog;
	}

	/**
	 * 生成下次要发送的WsInvokeFailureLog对象
	 * 
	 * @param isTelesale
	 * @param fbWSRequest
	 * @param response
	 * @param wsClientBeanName
	 * @param sendCount
	 * @return
	 */
	private WsInvokeFailureLog setNextSendObject(
			WsInvokeFailureLog invokeFailureLog, String requestJson,
			String responseJson) {

		WsInvokeFailureLog wsInvokeFailureLog = new WsInvokeFailureLog();
		wsInvokeFailureLog.setClientCode(invokeFailureLog.getClientCode());
		wsInvokeFailureLog.setInternalRequest(requestJson);
		wsInvokeFailureLog.setInternalResponse(responseJson);
		JSONObject responeObj = JSONObject.fromObject(responseJson);
		String returnCode = responeObj.get("errcode").toString();
		String returnMessage = responeObj.get("errmsg").toString();

		wsInvokeFailureLog.setReturnCode(returnCode != null ? returnCode
				: RESPONESTATE);
		wsInvokeFailureLog
				.setReturnMessage(returnMessage != null ? returnMessage
						: RESPONESTATE);
		// 产生新的流水号
		wsInvokeFailureLog.setTranscationSeqNo(UUIDGenerator.generate());
		// 记录原始的上一笔交易流水号
		wsInvokeFailureLog.setOrginTranscationSeqNo(invokeFailureLog
				.getTranscationSeqNo());
		wsInvokeFailureLog.setWsClientBeanName(invokeFailureLog
				.getWsClientBeanName());
		wsInvokeFailureLog.setStatus(CoreWSConstants.treatment_waiting); // 发送状态
																			// -1
																			// 为
																			// 待发送
		wsInvokeFailureLog.setSendCount(invokeFailureLog.getSendCount() + 1); // 发送次数加
																				// 1

		String nextSpace = this.nextSendSpaceTime(invokeFailureLog
				.getSendCount());
		Date date = new Date();
		date.setTime(date.getTime() + Integer.parseInt(nextSpace) * 60 * 1000); // 计数下次发送时间
		wsInvokeFailureLog.setNextInvokeTime(date); // 下次发送时间
		// 序列化
		wsInvokeFailureLog.setInternalRequestObj(WebServiceUtils
				.serializeObject(requestJson));
		return wsInvokeFailureLog;
	}

	/**
	 * 根据原始交易流水号更新WS调用失败记录表的状态 0 发送失败 1 发送成功 ，-1 待发送
	 * 
	 * @author patrick.z 20150109
	 * @param status
	 * @param transcationSeqNo
	 * @return
	 */
	private void updateWebserviceInvokeFailureLogStatusAndSeqNo(String status,
			String transcationSeqNo) {
		wsInvokeFailureLogService
				.updateBySqlString("update webservice_invoke_failure_log log set log.status = "
						+ status
						+ " where log.transcation_seq_no =  '"
						+ transcationSeqNo + "'");
	}

	/**
	 * 下次发送距离本次间隔时间
	 * 
	 * @param count
	 * @return
	 */
	private String nextSendSpaceTime(int count) {
		String next = "SPAN_" + String.valueOf(count + 1);

		String spaceMinute = "";
		try {
			spaceMinute = ResourceUtil.getSessionattachmenttitle(next);
		} catch (MissingResourceException e) {
			logger.info("发送次数已达最大次数限制");
		}

		return spaceMinute;
	}

	/**
	 * 交易报文入库
	 */
	public void packetPutDB(String inputJson, String responseJson) {
		WeixinAccountServiceI weixinAccountService = (WeixinAccountServiceI) ApplicationContextUtil
				.getContext().getBean("weixinAccountService");
		List<WeixinAccountEntity> weixinAccountEntityList = weixinAccountService
				.findValidWeixinAccounts();
		WeixinAccountEntity weixinAccountEntity = weixinAccountEntityList
				.get(0);

		TransactionRecord transactionRecord = new TransactionRecord();
		try {
			JSONObject requestJson = JSONObject.fromObject(inputJson);
			transactionRecord.setFromuser(requestJson.get("fromUser")
					.toString());
			transactionRecord.setTouser(requestJson.get("toUser").toString());
			transactionRecord.setTransactionFormat(requestJson.get(
					"transactionFormat").toString());
			transactionRecord.setTransactionType(requestJson.get(
					"transactionType").toString());
			transactionRecord.setTransactionId(requestJson.get("transactionId")
					.toString());
		} catch (Exception e) {
			logger.error("trans inputJson to json failed", e);
		}
		transactionRecord.setExternalRequest(inputJson);
		transactionRecord.setExternalResponse(responseJson);
		Timestamp dateTime = Timestamp.valueOf(DateUtils
				.getDate("yyyy-MM-dd HH:mm:ss"));
		transactionRecord.setCreateTime(dateTime);
		transactionRecord.setAccount(weixinAccountEntity);
		transactionRecord.setRespDateTime(dateTime);
		ITransactionRecordService transactionRecordService = (ITransactionRecordService) ApplicationContextUtil
				.getContext().getBean("transactionRecordService");
		transactionRecordService.save(transactionRecord);
	}
}
