package cn.com.fubon.fo.claim.service.impl;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import jodd.datetime.JDateTime;
import org.apache.commons.chain.Context;
import org.apache.log4j.Logger;
import org.jeecgframework.core.util.UUIDGenerator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.fubon.fo.claim.entity.NotCarReportInfo;
import cn.com.fubon.fo.claim.service.NotCarClaimWebService;
import cn.com.fubon.fo.claim.util.ComparatorNotCarReportInfo;
import cn.com.fubon.webservice.MainWebServiceClient;
import cn.com.fubon.webservice.WsConstants;
import cn.com.fubon.webservice.entity.request.FbClaimRequestBody;
import cn.com.fubon.webservice.entity.request.FbWSRequest;
import cn.com.fubon.webservice.entity.request.RequestHead;
import cn.com.fubon.webservice.entity.response.FbWSResponse;
import cn.com.fubon.webservice.externl.coresystem.entity.ClaimNotCarRequestBody;

@Service("notCarClaimWebService")
@Transactional
public class NotCarClaimWebServiceImpl implements NotCarClaimWebService {
	private static final Logger logger = Logger.getLogger(NotCarClaimWebServiceImpl.class);
	
	@Resource(name="claimWSClientGetNotCarReports")
	private MainWebServiceClient wsClaimClientNotCar;
	@Resource(name="claimWSClientGetNotCarPicture")
	private MainWebServiceClient wsClaimClientGetNotCarPicture;

	@SuppressWarnings("unchecked")
	@Override
	public List<NotCarReportInfo> getReportNotCarList(String reportorPhoneNumber,String openid) {
		JDateTime jnow = new JDateTime(new Date());
		RequestHead requestHead = new RequestHead();
		requestHead.setClientCode(WsConstants.REQUEST_HEAD_KEY_CLIENT_CODE_COREOS);
		requestHead.setServerCode(WsConstants.REQUEST_HEAD_KEY_SERVER_CODE_CLAIM);
		requestHead.setTranscationCode(WsConstants.REQUEST_HEAD_KEY_TRANSATION_CODE_5);
		requestHead.setTranscationDate(jnow.toString("YYYY-MM-DD"));
		requestHead.setTranscationTime(jnow.toString("hh:mm:ss"));
		requestHead.setTranscationSeqNo(UUIDGenerator.generate());
		
		FbClaimRequestBody requestBody = new FbClaimRequestBody();
		requestBody.setReportPhoneNo(reportorPhoneNumber);
		requestBody.setWeChatId(openid);
		
		FbWSRequest request = new FbWSRequest();
		request.setRequestHead(requestHead);
		request.setRequestBody(requestBody);
		wsClaimClientNotCar.setRequest(request);
		Context context = null;
		try {
			context = wsClaimClientNotCar.startExecuteChain();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("webservice invoked failed!");
		}
		
		ComparatorNotCarReportInfo comparator = new ComparatorNotCarReportInfo();
		List<NotCarReportInfo> notCarReportList = (List<NotCarReportInfo>)context.get("notCarReportList");
		if(notCarReportList != null){
			Collections.sort(notCarReportList, comparator);
		}
		return notCarReportList;
	}
	
	@Override
	public FbWSResponse getNotCarPicture(ClaimNotCarRequestBody claimNotCarRequestBody) {
		Context context = null;
		JDateTime jnow = new JDateTime(new Date());
		RequestHead requestHead = new RequestHead();
		requestHead.setClientCode(WsConstants.REQUEST_HEAD_KEY_CLIENT_CODE_COREOS);
		requestHead.setServerCode(WsConstants.REQUEST_HEAD_KEY_SERVER_CODE_CLAIM);
		requestHead.setTranscationCode(WsConstants.REQUEST_HEAD_KEY_TRANSATION_CODE_6);
		requestHead.setTranscationDate(jnow.toString("YYYY-MM-DD"));
		requestHead.setTranscationTime(jnow.toString("hh:mm:ss"));
		requestHead.setTranscationSeqNo(UUIDGenerator.generate());
		
		FbWSRequest request = new FbWSRequest();
		request.setRequestHead(requestHead);
		request.setRequestBody(claimNotCarRequestBody);
		
		wsClaimClientGetNotCarPicture.setRequest(request);
		try {
			context = wsClaimClientGetNotCarPicture.startExecuteChain();
		} catch (Exception e) {
			logger.error("非车理赔图片发送核心异常：" + e);
		}
		return (context != null) ? (FbWSResponse)context.get(WsConstants.CHAIN_CONTEXT_KEY_WS_RESPOSNE) : null;
	}
}
