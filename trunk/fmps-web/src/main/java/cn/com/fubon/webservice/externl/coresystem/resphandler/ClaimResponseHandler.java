package cn.com.fubon.webservice.externl.coresystem.resphandler;

import org.apache.commons.chain.Context;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

import cn.com.fubon.webservice.WsConstants;
import cn.com.fubon.webservice.entity.response.FbWSResponse;
import cn.com.fubon.webservice.entity.response.ResponseHead;
import cn.com.fubon.webservice.externl.coresystem.entity.ClaimResponse;
import cn.com.fubon.webservice.externl.coresystem.entity.FbClaimResponseBody;

public class ClaimResponseHandler extends DefaultCoreWSResponseHandler{
	
	@Override
	public String getWsClientBeanName() {
		return null;
	}
	
	@Autowired
	private Mapper mapper;
	
	@Override
	public void process(Context context) {
		
	}

	/**
	 * ClaimResponse转成FbWSResponse覆盖context中的FbWSResponse对象
	 */
	@Override
	public void convertExternalResponseToInnerResponse(Context context) {
		ClaimResponse claimResponse = (ClaimResponse)context.get(WsConstants.CHAIN_CONTEXT_KEY_WS_EXTERNL_RESPONSE);
		FbWSResponse response = new FbWSResponse();
		ResponseHead head = mapper.map(claimResponse.getSender(), ResponseHead.class);
		FbClaimResponseBody body = mapper.map(claimResponse.getBody(), FbClaimResponseBody.class);
		response.setResponseHead(head);
		response.setResponseBody(body);
		context.put(WsConstants.CHAIN_CONTEXT_KEY_WS_RESPOSNE, response);
	}
}
