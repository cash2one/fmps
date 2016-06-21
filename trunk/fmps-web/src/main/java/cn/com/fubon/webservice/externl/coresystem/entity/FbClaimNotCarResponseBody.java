package cn.com.fubon.webservice.externl.coresystem.entity;

import java.util.List;

import cn.com.fubon.fo.claim.entity.NotCarReportInfo;
import cn.com.fubon.webservice.entity.response.ResponseBody;
import com.thoughtworks.xstream.annotations.XStreamAlias;

public class FbClaimNotCarResponseBody extends ResponseBody{
	@XStreamAlias("reportList")
	//报案信息List
	private List<NotCarReportInfo> notCarReportList ;

	public List<NotCarReportInfo> getNotCarReportList() {
		return notCarReportList;
	}

	public void setNotCarReportList(List<NotCarReportInfo> notCarReportList) {
		this.notCarReportList = notCarReportList;
	}

}
