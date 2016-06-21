package cn.com.fubon.wechatClaims.service.impl;

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
import cn.com.fubon.webservice.MainWebServiceClient;
import cn.com.fubon.webservice.WsConstants;
import cn.com.fubon.webservice.entity.request.FbClaimRequestBody;
import cn.com.fubon.webservice.entity.request.FbWSRequest;
import cn.com.fubon.webservice.entity.request.RequestHead;
import cn.com.fubon.webservice.entity.response.FbWSResponse;
import cn.com.fubon.webservice.externl.coresystem.entity.ClaimRequestBody;
import cn.com.fubon.wechatClaims.entity.ReportInfo;
import cn.com.fubon.wechatClaims.service.ClaimWebService;
import cn.com.fubon.wechatClaims.util.ComparatorReportInfo;

@Service("claimWebService")
@Transactional
public class ClaimWebServiceImpl implements ClaimWebService {
	private static final Logger logger = Logger.getLogger(ClaimWebServiceImpl.class);

	@Resource(name="claimWSClientGetReports")
	private MainWebServiceClient wsClaimClient;
	@Resource(name="claimWSClientGetPicture")
	private MainWebServiceClient wsClaimClientGetPicture;
	@Resource(name="claimWSClientClaimFeeConfirmed")
	private MainWebServiceClient claimWSClientClaimFeeConfirmed;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ReportInfo> getReportList(String reportorPhoneNumber,String openid) {
		JDateTime jnow = new JDateTime(new Date());
		RequestHead requestHead = new RequestHead();
		requestHead.setClientCode(WsConstants.REQUEST_HEAD_KEY_CLIENT_CODE_COREOS);
		requestHead.setServerCode(WsConstants.REQUEST_HEAD_KEY_SERVER_CODE_CLAIM);
		requestHead.setTranscationCode(WsConstants.REQUEST_HEAD_KEY_TRANSATION_CODE_2);
		requestHead.setTranscationDate(jnow.toString("YYYY-MM-DD"));
		requestHead.setTranscationTime(jnow.toString("hh:mm:ss"));
		requestHead.setTranscationSeqNo(UUIDGenerator.generate());
		
		FbClaimRequestBody requestBody = new FbClaimRequestBody();
		requestBody.setReportPhoneNo(reportorPhoneNumber);
		requestBody.setWeChatId(openid);
		
		FbWSRequest request = new FbWSRequest();
		request.setRequestHead(requestHead);
		request.setRequestBody(requestBody);
		wsClaimClient.setRequest(request);
		Context context = null;
		try {
			context = wsClaimClient.startExecuteChain();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("webservice invoked failed!");
		}
		
		ComparatorReportInfo comparator = new ComparatorReportInfo();
		List<ReportInfo> reportList = (List<ReportInfo>)context.get("reportList");
		if(reportList != null){
			Collections.sort(reportList, comparator);
		}
		return reportList;
	}

	@Override
	public FbWSResponse getPicture(ClaimRequestBody claimRequestBody) {
		Context context = null;
		JDateTime jnow = new JDateTime(new Date());
		RequestHead requestHead = new RequestHead();
		requestHead.setClientCode(WsConstants.REQUEST_HEAD_KEY_CLIENT_CODE_COREOS);
		requestHead.setServerCode(WsConstants.REQUEST_HEAD_KEY_SERVER_CODE_CLAIM);
		requestHead.setTranscationCode(WsConstants.REQUEST_HEAD_KEY_TRANSATION_CODE_3);
		requestHead.setTranscationDate(jnow.toString("YYYY-MM-DD"));
		requestHead.setTranscationTime(jnow.toString("hh:mm:ss"));
		requestHead.setTranscationSeqNo(UUIDGenerator.generate());
		
		FbWSRequest request = new FbWSRequest();
		request.setRequestHead(requestHead);
		request.setRequestBody(claimRequestBody);
		
		wsClaimClientGetPicture.setRequest(request);
		try {
			context = wsClaimClientGetPicture.startExecuteChain();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (context != null) ? (FbWSResponse)context.get(WsConstants.CHAIN_CONTEXT_KEY_WS_RESPOSNE) : null;
	}

	@Override
	public FbWSResponse claimFeeConfirmed(String openid,String registNo,
			String confirmStyle){
		Context context = null;
		JDateTime jnow = new JDateTime(new Date());
		RequestHead requestHead = new RequestHead();
		requestHead
				.setClientCode(WsConstants.REQUEST_HEAD_KEY_CLIENT_CODE_COREOS);
		requestHead
				.setServerCode(WsConstants.REQUEST_HEAD_KEY_SERVER_CODE_CLAIM);
		requestHead
				.setTranscationCode(WsConstants.REQUEST_HEAD_KEY_TRANSATION_CODE_4);
		requestHead.setTranscationDate(jnow.toString("YYYY-MM-DD"));
		requestHead.setTranscationTime(jnow.toString("hh:mm:ss"));
		requestHead.setTranscationSeqNo(UUIDGenerator.generate());

		// 调核心接口
		FbClaimRequestBody fbClaimRequestBody = new FbClaimRequestBody();
		// 做确认的报案号、确认日期、确认时间、确认方式、确认用户微信ID
		fbClaimRequestBody.setRegistNo(registNo);
		fbClaimRequestBody.setConfirmDate(jnow.toString("YYYY-MM-DD"));
		fbClaimRequestBody.setConfirmTime(jnow.toString("hh:mm:ss"));
		// 核赔金额确认方式为人工确认
		fbClaimRequestBody.setConfirmStyle(confirmStyle);
		// 手动确认必须是报案人的openid
		fbClaimRequestBody.setWeChatId(openid);

		FbWSRequest request = new FbWSRequest();
		request.setRequestHead(requestHead);
		request.setRequestBody(fbClaimRequestBody);
		claimWSClientClaimFeeConfirmed.setRequest(request);
		try{
			context = claimWSClientClaimFeeConfirmed.startExecuteChain();
		}catch(Exception e){
			logger.error("claimFeeConfirmed ws invoked failed",e);
		}
		return (context != null) ? (FbWSResponse)context
				.get(WsConstants.CHAIN_CONTEXT_KEY_WS_RESPOSNE) : null;
	}

}
