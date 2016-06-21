package cn.com.fubon.wechatClaims.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.jeecgframework.core.util.ApplicationContextUtil;

import weixin.guanjia.core.util.WeixinUtil;
import cn.com.fubon.entity.WeChatContext;
import cn.com.fubon.util.Constants;
import cn.com.fubon.wechatClaims.entity.ReportInfo;
import cn.com.fubon.wechatClaims.service.impl.ClaimsSessionManagementImpl.Progress;
import cn.com.fubon.wechatClaims.util.ReturnMessageManagement;

public class GetReportRunnable implements Runnable {
	private String openid;
	private String phoneNo;
	private List<ReportInfo> reportInfoList = new ArrayList<ReportInfo>();// 理赔报案信息
	// private ReportInfo reportInfo; // 当前处理报案信息
	private WeChatContextService weChatContextService;
	private ReportInfoService reportInfoService;
	private ClaimWebService claimWebService;

	private static final Logger logger = Logger
			.getLogger(GetReportRunnable.class);

	public GetReportRunnable(String openid, String phoneNo) {
		this.openid = openid;
		this.phoneNo = phoneNo;
		// this.weChatContext = weChatContext;
		weChatContextService = (WeChatContextService) ApplicationContextUtil
				.getContext().getBean("weChatContextService");
		claimWebService = (ClaimWebService) ApplicationContextUtil.getContext()
				.getBean("claimWebService");
		reportInfoService = (ReportInfoService) ApplicationContextUtil
				.getContext().getBean("reportInfoService");
	}

	@Override
	public void run() {
		// 处理业务
		String returnMessage = this.getReportByPhoneNo(phoneNo, openid);
		// 发送客服消息
		String ErrorMessage = WeixinUtil.sendCustomerServiceMessage(openid,
				"text", returnMessage);
		logger.info("根据电话号码获取报案信息==openid==========>" + openid);
		logger.info("根据电话号码获取报案信息==returnMessage===>" + returnMessage);
	}

	/**
	 * 客户输入手机号，获取报案信息
	 */
	private synchronized String getReportByPhoneNo(String phoneNO, String openid) {
		// 根据电话号码是否获取到报案信息报文。先判断报文是否获取成功
		// 根据报案信息个数进一步判断
		// reportInfoList = this.getReportInfoList(phoneNO);

		try {
			reportInfoList = claimWebService.getReportList(phoneNO, openid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			reportInfoList = null;
		}
		String retMessage = "";
		WeChatContext weChatContext = weChatContextService
				.getWeChatContext(openid);
		weChatContext = weChatContextService.getWeChatContext(openid);
		weChatContext.save(Constants.WEIXINCLAIMS_claimsphoneNO, phoneNO);
		if (reportInfoList != null) {
			for (ReportInfo reportInfo : reportInfoList) {
				if (reportInfo.getOperatorCode().equals("9999")) { // 微信无人值班
					return ReturnMessageManagement.getNonworkingtime();
				}
			}
			weChatContext.save(Constants.WEIXINCLAIMS_reportInfoList,
					reportInfoList);
			if (reportInfoList.size() == 0) { // 没有查询到理赔记录
				retMessage = ReturnMessageManagement
						.getMessageQueryClaim0(phoneNO);
				weChatContext.save(Constants.WEIXINCLAIMS_claimsProgress,
						Progress.Enter_the_claim); 
			} else if (reportInfoList.size() == 1) { // 查询到一个报案信息
				if(reportInfoService.isUnderwriting(reportInfoList.get(0).getRegistNo(), openid)){
				weChatContext.save(Constants.WEIXINCLAIMS_claimsProgress,
						Progress.Query_claim_1);
				weChatContext.save(Constants.WEIXINCLAIMS_reportInfo,
						reportInfoList.get(0));
				weChatContext.save(Constants.WEIXINCLAIMS_claimsImage_total,
						reportInfoService.getImageTotal(reportInfoList.get(0)
								.getRegistNo()));
				weChatContext.save(Constants.WEIXINCLAIMS_claimsProgress,
						Progress.Successful_association_claim);
				reportInfoService.saveOrUpdateReportInfo(reportInfoList.get(0),
						openid, phoneNO);// 保存当前报案信息
				retMessage = ReturnMessageManagement
						.getMessageQueryClaim1(weChatContext);
				}else{
					List<ReportInfo> infoList = reportInfoService.findByProperty(
							ReportInfo.class, "registNo", reportInfoList.get(0).getRegistNo());					 
					retMessage=ReturnMessageManagement.getUnderwritingErrorMessage(infoList.get(0));					
				}
				
			} else if (reportInfoList.size() > 1) { // 查询到多个理赔记录
				weChatContext.save(Constants.WEIXINCLAIMS_claimsProgress,
						Progress.Query_claim_multi);
				weChatContext.save(Constants.WEIXINCLAIMS_reportInfoList,
						reportInfoList);
				retMessage = ReturnMessageManagement
						.getMessageQueryClaimMulti(weChatContext);
			}
		} else {
			retMessage = ReturnMessageManagement.getErrorMessage();
			logger.info("根据电话号码获取报案信息==webService通讯失败===>" + phoneNO);
		}
		logger.info("getReportByPhoneNo 微理赔进度=========>"
				+ weChatContext.get(Constants.WEIXINCLAIMS_claimsProgress));
		weChatContextService.saveWeChatContext(weChatContext, openid);
		return retMessage;
	}

}
