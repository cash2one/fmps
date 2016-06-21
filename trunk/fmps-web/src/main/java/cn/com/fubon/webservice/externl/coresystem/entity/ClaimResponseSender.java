package cn.com.fubon.webservice.externl.coresystem.entity;

import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import cn.com.fubon.wechatClaims.entity.ReportInfo;

/**
 * 理赔响应报文发送者类
 * 
 * @author fangfang.guo
 *
 */
public class ClaimResponseSender extends ResponseSender{

	private String responseCode;
	private String errorMessage;
//	private String transactionDate;
//	private String transactionTime;
	@XStreamAlias("reportList")
	private List<ReportInfo> reportList;

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

//	public String getTransactionDate() {
//		return transactionDate;
//	}
//
//	public void setTransactionDate(String transactionDate) {
//		this.transactionDate = transactionDate;
//	}
//
//	public String getTransactionTime() {
//		return transactionTime;
//	}
//
//	public void setTransactionTime(String transactionTime) {
//		this.transactionTime = transactionTime;
//	}

	public List<ReportInfo> getReportList() {
		return reportList;
	}

	public void setReportList(List<ReportInfo> reportList) {
		this.reportList = reportList;
	}

}
