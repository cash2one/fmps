package cn.com.fubon.webservice.externl.coresystem.resphandler;

import org.apache.commons.chain.Context;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

import cn.com.fubon.webservice.WsConstants;
import cn.com.fubon.webservice.entity.response.FbWSResponse;
import cn.com.fubon.webservice.entity.response.ResponseHead;
import cn.com.fubon.webservice.externl.coresystem.entity.ClaimResponse;
import cn.com.fubon.webservice.externl.coresystem.entity.CommonResponseNewCar;
import cn.com.fubon.webservice.externl.coresystem.entity.FbClaimResponseBody;
import cn.com.fubon.webservice.externl.coresystem.entity.FbNewCarLicenseResponseBody;

public class WeixinNewCarResponseHandler extends DefaultCoreWSResponseHandler {
	
	@Autowired
	private Mapper mapper;

	@Override
	public String getWsClientBeanName() {
		return "coreosWSClientNewCar";
	}

	@Override
	public void convertExternalResponseToInnerResponse(Context context) {
		
		CommonResponseNewCar commonResponseNewCar = (CommonResponseNewCar)context.get(WsConstants.CHAIN_CONTEXT_KEY_WS_EXTERNL_RESPONSE);
		FbWSResponse fbWsResponse=(FbWSResponse) context.get(WsConstants.CHAIN_CONTEXT_KEY_WS_RESPOSNE);
		
		//FbWSResponse response = new FbWSResponse();
		//ResponseHead head = mapper.map(commonResponseNewCar.getSender(), ResponseHead.class);
		//FbClaimResponseBody body = mapper.map(commonResponseNewCar.getEndorseInfo(), FbClaimResponseBody.class);
		FbNewCarLicenseResponseBody  fbNewCarLicenseResponseBody =new FbNewCarLicenseResponseBody();
		fbNewCarLicenseResponseBody.setApplicationNo(commonResponseNewCar.getEndorseInfo().get("applicationNo"));
		fbWsResponse.setResponseBody(fbNewCarLicenseResponseBody);
		//response.setResponseHead(head);
		//response.setResponseBody(body);
		context.put(WsConstants.CHAIN_CONTEXT_KEY_WS_RESPOSNE, fbWsResponse);
		
		
		
		
		//TODO
	};	
	
	@Override
	public void process(Context context) {
		// TODO Auto-generated method stub
		//新车上牌是同步WebService,不需要写webservice_invoke_failure_log
	}

}
