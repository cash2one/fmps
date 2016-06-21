package cn.com.fubon.webservice.externl.coresystem.resphandler;

import org.apache.commons.chain.Context;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

import cn.com.fubon.webservice.WsConstants;
import cn.com.fubon.webservice.entity.response.FbWSResponse;
import cn.com.fubon.webservice.entity.response.ResponseHead;
import cn.com.fubon.webservice.externl.coresystem.entity.ClaimNotCarResponse;
import cn.com.fubon.webservice.externl.coresystem.entity.FbClaimNotCarResponseBody;

public class ClaimNotCarResponseHandler extends DefaultCoreWSResponseHandler{
	
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
	 * ClaimNotCarResponse转成FbWSResponse覆盖context中的FbWSResponse对象
	 */
	@Override
	public void convertExternalResponseToInnerResponse(Context context) {
		ClaimNotCarResponse claimNotCarResponse = (ClaimNotCarResponse)context.get(WsConstants.CHAIN_CONTEXT_KEY_WS_EXTERNL_RESPONSE);
		FbWSResponse response = new FbWSResponse();
		ResponseHead head = mapper.map(claimNotCarResponse.getSender(), ResponseHead.class);
		FbClaimNotCarResponseBody body = mapper.map(claimNotCarResponse.getBody(), FbClaimNotCarResponseBody.class);
		response.setResponseHead(head);
		response.setResponseBody(body);
		context.put(WsConstants.CHAIN_CONTEXT_KEY_WS_RESPOSNE, response);
	}
}
