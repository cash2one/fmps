package cn.com.fubon.webservice.externl.coresystem.resphandler;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.commons.chain.Context;
import org.jeecgframework.core.util.ContextHolderUtils;

import cn.com.fubon.fo.claim.service.NotCarClientService;
import cn.com.fubon.util.Constants;
import cn.com.fubon.webservice.WsConstants;
import cn.com.fubon.webservice.entity.request.FbClaimNotCarRequestBody;
import cn.com.fubon.webservice.entity.request.FbWSRequest;
import cn.com.fubon.webservice.entity.response.FbWSResponse;


public class GetNotCarPictureClaimResponseHandler extends ClaimResponseHandler{
	
	@Resource
	private NotCarClientService notCarClientService;

	@Override
	public String getWsClientBeanName() {
		return "claimWSClientGetNotCarPicture";
	};
	@Override
	public void process(Context context) {
		
		FbWSResponse fbWSResponse=	(context != null) ? (FbWSResponse)context.get(WsConstants.CHAIN_CONTEXT_KEY_WS_RESPOSNE) : null;
		
		String returnCode = fbWSResponse.getResponseHead().getTransResponse().getReturnCode();
		logger.info("发送非车理赔照片信息(响应报文状态,异步换回):" + returnCode);
		
	boolean	sendSuccess= returnCode.equalsIgnoreCase("0000") ? true : false;	
	FbWSRequest request= (FbWSRequest) context.get(WsConstants.CHAIN_CONTEXT_KEY_WS_REQUEST);
	FbClaimNotCarRequestBody  fbClaimNotCarRequestBody=(cn.com.fubon.webservice.entity.request.FbClaimNotCarRequestBody) request.getRequestBody();
	String imageName= fbClaimNotCarRequestBody.getImageList().get(0).getImageName();
	logger.info("发送非车理赔照片信息(响应报文,(首次异步、从发同步) 获取到的imageName):" + imageName); 
		if(sendSuccess){		
			 notCarClientService.updateStatus(imageName, "1");			 
		}else{
			 notCarClientService.updateStatus(imageName, "2");			 
		}		
	}
}
