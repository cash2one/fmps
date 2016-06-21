package cn.com.fubon.webservice.externl.coresystem.entity;

import java.util.List;
import cn.com.fubon.webservice.entity.response.ResponseBody;
import cn.com.fubon.wechatClaims.entity.ReportInfo;
import com.thoughtworks.xstream.annotations.XStreamAlias;

public class FbClaimResponseBody extends ResponseBody{
	@XStreamAlias("reportList")
	//报案信息List
	private List<ReportInfo> reportList ;

	public List<ReportInfo> getReportList() {
		return reportList;
	}

	public void setReportList(List<ReportInfo> reportList) {
		this.reportList = reportList;
	}
}
