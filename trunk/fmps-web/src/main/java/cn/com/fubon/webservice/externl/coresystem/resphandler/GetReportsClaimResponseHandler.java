package cn.com.fubon.webservice.externl.coresystem.resphandler;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.chain.Context;

import cn.com.fubon.webservice.WsConstants;
import cn.com.fubon.webservice.entity.response.FbWSResponse;
import cn.com.fubon.webservice.externl.coresystem.entity.FbClaimResponseBody;
import cn.com.fubon.wechatClaims.entity.ReportInfo;

public class GetReportsClaimResponseHandler extends ClaimResponseHandler{

	@Override
	public String getWsClientBeanName() {
		return "claimWSClientGetReports";
	};
	
	@Override
	public void process(Context context) {
		FbWSResponse response = (FbWSResponse)context.get(WsConstants.CHAIN_CONTEXT_KEY_WS_RESPOSNE);
		if(response != null){
			
			List<ReportInfo> reportList = ((FbClaimResponseBody)response.getResponseBody()).getReportList();
			
			//response不为空,要求返回的reportList对象不为空
			if(reportList == null){
				reportList = new ArrayList<ReportInfo>();
			}
			context.put("reportList", reportList);
		}
		
	}
}
