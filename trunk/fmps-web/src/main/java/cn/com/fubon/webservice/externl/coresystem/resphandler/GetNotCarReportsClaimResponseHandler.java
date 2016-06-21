package cn.com.fubon.webservice.externl.coresystem.resphandler;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.chain.Context;

import cn.com.fubon.fo.claim.entity.NotCarReportInfo;
import cn.com.fubon.webservice.WsConstants;
import cn.com.fubon.webservice.entity.response.FbWSResponse;
import cn.com.fubon.webservice.externl.coresystem.entity.FbClaimNotCarResponseBody;

public class GetNotCarReportsClaimResponseHandler extends ClaimNotCarResponseHandler{

	@Override
	public String getWsClientBeanName() {
		return "claimWSClientGetNotCarReports";
	};
	
	@Override
	public void process(Context context) {
		FbWSResponse response = (FbWSResponse)context.get(WsConstants.CHAIN_CONTEXT_KEY_WS_RESPOSNE);
		if(response != null){
			
			List<NotCarReportInfo> notCarReportList = ((FbClaimNotCarResponseBody)response.getResponseBody()).getNotCarReportList();
			
			//response不为空,要求返回的reportList对象不为空
			if(notCarReportList == null){
				notCarReportList = new ArrayList<NotCarReportInfo>();
			}
			context.put("notCarReportList", notCarReportList);
		}
		
	}
}
