package cn.com.fubon.wechatClaims.service.impl;

import java.sql.Timestamp;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.annotation.Resource;

import org.apache.commons.lang.math.NumberUtils;
import org.apache.log4j.Logger;
import org.jeecgframework.core.util.ResourceUtil;
import org.jeecgframework.core.util.StringUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import weixin.guanjia.account.service.WeixinAccountServiceI;
import weixin.guanjia.core.util.WeixinUtil;
import weixin.guanjia.message.entity.ReceiveMessage;
import weixin.guanjia.message.service.ReceiveMessageServiceI;
import weixin.util.DateUtils;
import cn.com.fubon.entity.WeChatContext;
import cn.com.fubon.util.CachedUtils;
import cn.com.fubon.util.Constants;
import cn.com.fubon.util.FBStringUtils;
import cn.com.fubon.wechatClaims.entity.ReportInfo;
import cn.com.fubon.wechatClaims.entity.WeiXinCustomerServiceChatDetail;
import cn.com.fubon.wechatClaims.service.ClaimsSessionManagement;
import cn.com.fubon.wechatClaims.service.CustomerChatService;
import cn.com.fubon.wechatClaims.service.DoImageRunnable;
import cn.com.fubon.wechatClaims.service.GetReportRunnable;
import cn.com.fubon.wechatClaims.service.ReportInfoService;
import cn.com.fubon.wechatClaims.service.WeChatContextService;
import cn.com.fubon.wechatClaims.util.ReturnMessageManagement;

/**
 * 微理赔会话管理类
 * 
 * @author shanqi.wang
 *
 */
@Service("claimsSessionManagement")
@Transactional
public class ClaimsSessionManagementImpl implements ClaimsSessionManagement {

	// 客户理赔进度
	public enum Progress {
		/**
		 * 1、取消会话,或超时
		 */
		Cancel_claim_session,
		/**
		 * 2、点选了微理赔,或者输入了手机号
		 */
		Enter_the_claim,
		/**
		 * 3、输入手机号，查询到0报案号
		 */
		Query_claim_0,
		/**
		 * 4、输入手机号，查询到1个报案号
		 */
		Query_claim_1,
		/**
		 * 5、输入手机号，查询到多个报案号
		 */
		Query_claim_multi,
		/**
		 * 6、成功关联本次报案号
		 */
		Successful_association_claim,
		/**
		 * 7、询问用户是否关闭会话
		 */
		Asked_close_session;
	}

	private List<ReportInfo> reportInfoList; // 理赔报案信息
	private ExecutorService exec = Executors.newFixedThreadPool(5); // 默认开启5个线程
	@Resource
	private ReportInfoService reportInfoService;
	@Resource
	private WeChatContextService weChatContextService;
	@Resource
	private CustomerChatService customerChatService;
	@Resource
	private ReceiveMessageServiceI receiveMessageService;
	@Resource
	private WeixinAccountServiceI weixinAccountService;

	private static final Logger logger = Logger
			.getLogger(ClaimsSessionManagementImpl.class);

	/**
	 * 判断目前客户是否处于理赔会话当中
	 * 
	 * @return
	 */
	@Override
	public boolean isClaimsDeal(String openid) {
		WeChatContext weChatContext = weChatContextService
				.getWeChatContext(openid);
		Progress claimsProgress = (Progress) weChatContext
				.get(Constants.WEIXINCLAIMS_claimsProgress);
		ReturnMessageManagement.domain = ResourceUtil.getDomain();
		if (claimsProgress.compareTo(Progress.Cancel_claim_session) > 0) { // 还有加个时间过期判断
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 客户点击菜单处理
	 * 
	 * @return
	 */
	@Override
	@SuppressWarnings("unchecked")
	public String clickMenuen(String openid) {
		String retMessage = "";
		// String accessToken =
		// weixinAccountService.getAccessTokenFromAccountEntity();
		// KfSessionAPI kfSessionAPI = new KfSessionAPI();
		// kfSessionAPI.CloseKFSession(accessToken, openid);// 如有进入多客服，先退出。
		// 第一次点击建立会话，
		WeChatContext weChatContext = weChatContextService
				.getWeChatContext(openid);
		Progress claimsProgress = (Progress) weChatContext
				.get(Constants.WEIXINCLAIMS_claimsProgress);
		logger.info("clickMenuen, 当前理赔进度=======>" + claimsProgress);
		switch (claimsProgress) {
		case Cancel_claim_session:
			retMessage = ReturnMessageManagement.getMessageCancelClaimSession();
			weChatContext.save(Constants.WEIXINCLAIMS_claimsProgress,
					Progress.Enter_the_claim);
			break;
		case Enter_the_claim:
			retMessage = ReturnMessageManagement.getMessageEnterTheClaim();
			break;
		case Query_claim_0:
			retMessage = ReturnMessageManagement
					.getMessageQueryClaim0((String) weChatContext
							.get(Constants.WEIXINCLAIMS_claimsphoneNO));
			break;
		case Query_claim_1:
			retMessage = ReturnMessageManagement
					.getMessageQueryClaim1(weChatContext);
			break;
		case Query_claim_multi:
			retMessage = ReturnMessageManagement
					.getMessageQueryClaimMulti(weChatContext);
			break;
		case Successful_association_claim:
			retMessage = ReturnMessageManagement
					.getMessageSuccessfulAssociationClaim(weChatContext);
			break;
		default:
			// weChatContext.save(Constants.WEIXINCLAIMS_claimsProgress,
			// Progress.Enter_the_claim);
		}
		weChatContextService.saveWeChatContext(weChatContext, openid);
		return retMessage;
	}

	/**
	 * 进入微理赔消息处理
	 */
	@Override
	public String messageProcessing(ReceiveMessage receiveMessage) {
		String retMessage = "";
		if (receiveMessage.getMsgType().equals("text")) {
			retMessage = this.textMessageProcessing(receiveMessage);
		} else if (receiveMessage.getMsgType().equals("image")) {
			retMessage = this.imageMessageProcessing(receiveMessage);
		} else if (receiveMessage.getMsgType().equals("voice")) {
			retMessage = this.voiceMessageProcessing(receiveMessage);
		} else {
			retMessage = this.surplusMessageProcessing(receiveMessage);
		}
		return retMessage;
	}

	/**
	 * 客户处于理赔之中，发送过来的消息处理
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private String textMessageProcessing(ReceiveMessage receiveMessage) {
		WeChatContext weChatContext = weChatContextService
				.getWeChatContext(receiveMessage.getFromUserName());

		List<ReportInfo> reportInfoList = null;
		Progress claimsProgress = (Progress) weChatContext
				.get(Constants.WEIXINCLAIMS_claimsProgress); // 当前理赔进度
		logger.info("textMessageProcessing, openid ====>"
				+ receiveMessage.getFromUserName()
				+ "current claim progress=======>" + claimsProgress);
		String retMessage = "";
		switch (claimsProgress) {
		case Query_claim_0:
			retMessage = ReturnMessageManagement
					.getMessageQueryClaim0((String) weChatContext
							.get(Constants.WEIXINCLAIMS_claimsphoneNO));
			weChatContext.save(Constants.WEIXINCLAIMS_claimsProgress,
					Progress.Enter_the_claim); // 提示后改变状态，下次输入还是电话号码。
			break;
		case Query_claim_1:
			retMessage = ReturnMessageManagement
					.getMessageQueryClaim1(weChatContext);
			weChatContext.save(Constants.WEIXINCLAIMS_claimsProgress,
					Progress.Successful_association_claim); // 改变状态下次输入保存到聊天库
			break;
		case Query_claim_multi:
			// 判断用户第二次输入的信息是否符合要求，并设置 当前报案信息，输入错误，请用户再次输入
			reportInfoList = (List<ReportInfo>) weChatContext
					.get(Constants.WEIXINCLAIMS_reportInfoList);
			int userInput = 999;
			if (NumberUtils.isNumber(receiveMessage.getContent())) {
				userInput = Integer.parseInt(receiveMessage.getContent());
			} else {
				retMessage = "您输入的信息非数字，请再次输入。";
				break;
			}
			// 如果用户输入的信息符合要求
			if (userInput <= reportInfoList.size()) {
				ReportInfo reportInfo = reportInfoList.get(userInput - 1);
				if (reportInfoService.isUnderwriting(reportInfo.getRegistNo(),
						receiveMessage.getFromUserName())) {
					weChatContext.save(Constants.WEIXINCLAIMS_reportInfo,
							reportInfo);
					weChatContext.save(
							Constants.WEIXINCLAIMS_claimsImage_total,
							reportInfoService.getImageTotal(reportInfo
									.getRegistNo()));
					reportInfoService.saveOrUpdateReportInfo(reportInfo,
							receiveMessage.getFromUserName(),
							(String) weChatContext
									.get(Constants.WEIXINCLAIMS_claimsphoneNO));
					weChatContext.save(Constants.WEIXINCLAIMS_claimsProgress,
							Progress.Successful_association_claim);
					retMessage = ReturnMessageManagement
							.getMessageQueryClaim1(weChatContext)
							+ "输入0可重新选择。\n";
				} else {
					List<ReportInfo> infoList = reportInfoService
							.findByProperty(ReportInfo.class, "registNo",
									reportInfo.getRegistNo());
					retMessage = ReturnMessageManagement
							.getUnderwritingErrorMessage(infoList.get(0));
				}
			} else {
				// 用户输入的信息不符合要求。
				retMessage = "您输入的信息有误，请再次选择。";
			}
			break;
		case Successful_association_claim:
			// 成功关联报案信息，用户发送过来的消息视为聊天消息 保全数据到聊天记录库
			reportInfoList = (List<ReportInfo>) weChatContext
					.get(Constants.WEIXINCLAIMS_reportInfoList);
			ReportInfo reportInfo = (ReportInfo) weChatContext
					.get(Constants.WEIXINCLAIMS_reportInfo);
			if (receiveMessage.getContent().equals("0")
					&& reportInfoList.size() > 1) { // 输入0 从新关联案件号
				weChatContext.save(Constants.WEIXINCLAIMS_claimsProgress,
						Progress.Query_claim_multi);
				this.saveweiXinCustomerServiceChatContent(
						reportInfo.getOpenid(), "该客户已重选受理案件，会话已关闭(系统自动触发)",
						reportInfo.getRegistNo());
				reportInfoService.updReportInfoByRegistNo(reportInfo
						.getRegistNo()); // 从新选择结束本次会话
				retMessage = "请重新选择:\n"
						+ ReturnMessageManagement
								.getMessageQueryClaimMulti(weChatContext);
			} else if (receiveMessage.getContent().equals("99")) { // 输入99退出微理赔
				retMessage = ReturnMessageManagement
						.getCustomerCloseSessionMessage();
				this.saveweiXinCustomerServiceChatContent(
						reportInfo.getOpenid(), "用户已经选择退出了微理赔(系统自动触发)",
						reportInfo.getRegistNo());
				reportInfoService.updReportInfoByRegistNo(
						reportInfo.getRegistNo(),
						Constants.WECHATCLAIMS_Session_State_USEROFFLINE); // 设置案件状态为用户退出
				this.closeSession(reportInfo.getOpenid());
				return retMessage;
			} else {
				this.saveweiXinCustomerServiceChatDetail(
						receiveMessage.getId(), reportInfo.getRegistNo());
			}
			break;
		case Asked_close_session:
			if (receiveMessage.getContent().equalsIgnoreCase("y")) {
				weChatContext.save(Constants.WEIXINCLAIMS_claimsProgress,
						Progress.Successful_association_claim);
				weChatContext.save(Constants.WEIXINCLAIMS_is_Ask, "Y");
				retMessage = "您已经选择了继续服务，请输入信息，联系我们的理赔人员。";
			} else {
				reportInfo = (ReportInfo) weChatContext
						.get(Constants.WEIXINCLAIMS_reportInfo);
				this.saveweiXinCustomerServiceChatContent(
						reportInfo.getOpenid(), "用户已经退出了微理赔(系统自动触发)",
						reportInfo.getRegistNo());
				retMessage = ReturnMessageManagement
						.getCustomerCloseSessionMessage();
				this.closeSession(reportInfo.getOpenid());
				return retMessage;
			}
			break;
		case Cancel_claim_session:
		case Enter_the_claim:
			logger.info("输入的文本内容=============>" + receiveMessage.getContent());
			boolean b = false;
			b = FBStringUtils.checkMobile(receiveMessage.getContent());
			logger.info("是否是手机号的状态=============>" + b);
			if (b) {
				// 处理后保存数据，并用多客服消息发送给客户
				exec.execute(new GetReportRunnable(receiveMessage
						.getFromUserName(), receiveMessage.getContent()));
			} else {
				retMessage = ReturnMessageManagement.getErrorPhoneMessage();
				return retMessage;
			}
			break;
		default:
		}
		weChatContextService.saveWeChatContext(weChatContext,
				receiveMessage.getFromUserName());
		return retMessage;
	}

	/**
	 * 客户处于理赔之中，发送过来的图片消息处理
	 * 
	 * @return
	 */
	@SuppressWarnings({ "incomplete-switch", "unchecked" })
	private String imageMessageProcessing(ReceiveMessage receiveMessage) {
		WeChatContext weChatContext = weChatContextService
				.getWeChatContext(receiveMessage.getFromUserName());
		Progress claimsProgress = (Progress) weChatContext
				.get(Constants.WEIXINCLAIMS_claimsProgress); // 当前理赔进度
		logger.info("imageMessageProcessing, current claim progress=======>"
				+ receiveMessage.getFromUserName() + ":" + claimsProgress);
		String retMessage = "";
		switch (claimsProgress) {
		case Enter_the_claim:
			// 用户已经进入了微理赔
			retMessage = ReturnMessageManagement.getMessageEnterTheClaim();
			break;
		case Query_claim_0:
			retMessage = ReturnMessageManagement
					.getMessageQueryClaim0((String) weChatContext
							.get(Constants.WEIXINCLAIMS_claimsphoneNO));
			break;
		case Query_claim_1:
			retMessage = ReturnMessageManagement
					.getMessageQueryClaim1(weChatContext);
			weChatContext.save(Constants.WEIXINCLAIMS_claimsProgress,
					Progress.Successful_association_claim); // 改变状态下次输入保存到聊天库
			break;
		case Query_claim_multi:
			retMessage = ReturnMessageManagement
					.getMessageQueryClaimMulti(weChatContext);
			break;
		case Successful_association_claim:
			// 多线程处理图片消息，保存库、发送WebService、多客服消息回复
			ReportInfo reportInfo = (ReportInfo) weChatContext
					.get(Constants.WEIXINCLAIMS_reportInfo);
			this.saveweiXinCustomerServiceChatDetail(receiveMessage.getId(),
					reportInfo.getRegistNo());
			String strIp = ResourceUtil.getBundleEnvAbout().getString("ftpIp");
			int intPort = Integer.parseInt(ResourceUtil.getBundleEnvAbout()
					.getString("ftpPort"));
			String user = ResourceUtil.getBundleEnvAbout().getString("ftpUser");
			String password = ResourceUtil.getBundleEnvAbout().getString(
					"ftpPassword");
			int imagetotal = (int) weChatContext
					.get(Constants.WEIXINCLAIMS_claimsImage_total);
			String ImageExceedMessage = "您好，照片数已达接收上限，如有问题可拨打4008-817-518或与理赔专员沟通。";
			if (imagetotal < 30) { // 图片小于30张，需要处理图片
				imagetotal = imagetotal + 1;
				// retMessage = "您好，您上传了[" + imagetotal + "]张照照片。";
				if (imagetotal > 20) {
					int Surplus = 30 - imagetotal;
					retMessage = Surplus == 0 ? ImageExceedMessage : "您好，仅剩["
							+ Surplus + "]张拍照上传权限。";
				}
				exec.execute(new DoImageRunnable(receiveMessage, strIp,
						intPort, user, password));
				weChatContext.save(Constants.WEIXINCLAIMS_claimsImage_total,
						imagetotal);
			} else {
				retMessage = ImageExceedMessage;
			}
			break;
		}
		weChatContextService.saveWeChatContext(weChatContext,
				receiveMessage.getFromUserName());
		return retMessage;
	}

	/**
	 * 客服发送语音
	 * 
	 * @param receiveMessage
	 * @return
	 */
	private String voiceMessageProcessing(ReceiveMessage receiveMessage) {
		WeChatContext weChatContext = weChatContextService
				.getWeChatContext(receiveMessage.getFromUserName());
		Progress claimsProgress = (Progress) weChatContext
				.get(Constants.WEIXINCLAIMS_claimsProgress); // 当前理赔进度
		logger.info("imageMessageProcessing, 当前理赔进度=======>" + claimsProgress);
		String retMessage = "";
		switch (claimsProgress) {
		case Enter_the_claim:
			// 用户已经进入了微理赔
			retMessage = ReturnMessageManagement.getMessageEnterTheClaim();
			break;
		case Query_claim_0:
			retMessage = ReturnMessageManagement
					.getMessageQueryClaim0((String) weChatContext
							.get(Constants.WEIXINCLAIMS_claimsphoneNO));
			break;
		case Query_claim_1:
			retMessage = ReturnMessageManagement
					.getMessageQueryClaim1(weChatContext);
			weChatContext.save(Constants.WEIXINCLAIMS_claimsProgress,
					Progress.Successful_association_claim); // 改变状态下次输入保存到聊天库
			break;
		case Query_claim_multi:
			retMessage = ReturnMessageManagement
					.getMessageQueryClaimMulti(weChatContext);
			break;
		case Successful_association_claim:
			// 多线程处理图片消息，保存库、发送WebService、多客服消息回复
			ReportInfo reportInfo = (ReportInfo) weChatContext
					.get(Constants.WEIXINCLAIMS_reportInfo);

			this.saveweiXinCustomerServiceChatDetail(receiveMessage.getId(),
					reportInfo.getRegistNo());
			break;
		}
		weChatContextService.saveWeChatContext(weChatContext,
				receiveMessage.getFromUserName());
		return retMessage;
	}

	/**
	 * 剩余通用消息处理
	 * 
	 * @param receiveMessage
	 * @return！
	 */
	private String surplusMessageProcessing(ReceiveMessage receiveMessage) {
		WeChatContext weChatContext = weChatContextService
				.getWeChatContext(receiveMessage.getFromUserName());
		Progress claimsProgress = (Progress) weChatContext
				.get(Constants.WEIXINCLAIMS_claimsProgress); // 当前理赔进度
		logger.info("imageMessageProcessing, 当前理赔进度=======>" + claimsProgress);
		String retMessage = "";
		switch (claimsProgress) {
		case Enter_the_claim:
			// 用户已经进入了微理赔
			retMessage = ReturnMessageManagement.getMessageEnterTheClaim();
			break;
		case Query_claim_0:
			retMessage = ReturnMessageManagement
					.getMessageQueryClaim0((String) weChatContext
							.get(Constants.WEIXINCLAIMS_claimsphoneNO));
			break;
		case Query_claim_1:
			retMessage = ReturnMessageManagement
					.getMessageQueryClaim1(weChatContext);
			weChatContext.save(Constants.WEIXINCLAIMS_claimsProgress,
					Progress.Successful_association_claim); // 改变状态下次输入保存到聊天库
			break;
		case Query_claim_multi:
			retMessage = ReturnMessageManagement
					.getMessageQueryClaimMulti(weChatContext);
			break;
		case Successful_association_claim:
			String message = "客户发送未知内容";

			ReportInfo reportInfo = (ReportInfo) weChatContext
					.get(Constants.WEIXINCLAIMS_reportInfo);
			if (receiveMessage.getMsgType().equals("shortvideo")) {
				message = "客户发送小视频";
				this.saveweiXinCustomerServiceChatContent(
						reportInfo.getOpenid(), message,
						reportInfo.getRegistNo());
			} else if (receiveMessage.getMsgType().equals("location")) {
				this.saveweiXinCustomerServiceChatDetail(
						receiveMessage.getId(), reportInfo.getRegistNo());
			}
			break;
		}
		weChatContextService.saveWeChatContext(weChatContext,
				receiveMessage.getFromUserName());
		return retMessage;
	}

	/**
	 * 保存聊天记录
	 * 
	 * @param receiveMessage
	 *            表 的 MessageId
	 * @param RegistNo
	 *            案件号
	 * */

	private void saveweiXinCustomerServiceChatDetail(String MessageId,
			String RegistNo) {
		WeiXinCustomerServiceChatDetail weiXinCustomerServiceChatDetail = new WeiXinCustomerServiceChatDetail();
		weiXinCustomerServiceChatDetail.setClaimRegistNo(RegistNo);
		weiXinCustomerServiceChatDetail.setCreateTime(Timestamp
				.valueOf(DateUtils.getDate("yyyy-MM-dd HH:mm:ss")));
		weiXinCustomerServiceChatDetail
				.setIsMessageReaded(Constants.WECHATCLAIMS_MESSAGE_NOTREADED);// 未读
		weiXinCustomerServiceChatDetail.setMessageId(MessageId);
		weiXinCustomerServiceChatDetail
				.setMessageSource(Constants.WECHATCLAIMS_MESSAGE_SOURCE_USER);
		// weiXinCustomerServiceChatDetail.setReceiveMessage(receiveMessage);
		customerChatService
				.saveWeiXinCustomerServiceChatDetail(weiXinCustomerServiceChatDetail);
	}

	/**
	 * 保存客户系统自动触发聊天记录
	 * 
	 * @param openid
	 *            客户的openid
	 * @param Content
	 *            自定义文本内容
	 * @param RegistNo
	 *            案件号
	 */

	@Override
	public void saveweiXinCustomerServiceChatContent(String openid,
			String Content, String RegistNo) {
		ReceiveMessage receiveMessage = new ReceiveMessage();
		receiveMessage.setMsgType("text");
		receiveMessage.setContent(Content);
		receiveMessage.setCreateTime(Timestamp.valueOf(DateUtils
				.getDate("yyyy-MM-dd HH:mm:ss.SSS")));
		receiveMessage.setFromUserName(openid);
		receiveMessageService.save(receiveMessage);
		WeiXinCustomerServiceChatDetail weiXinCustomerServiceChatDetail = new WeiXinCustomerServiceChatDetail();
		weiXinCustomerServiceChatDetail.setClaimRegistNo(RegistNo);
		weiXinCustomerServiceChatDetail.setCreateTime(Timestamp
				.valueOf(DateUtils.getDate("yyyy-MM-dd HH:mm:ss")));
		weiXinCustomerServiceChatDetail
				.setIsMessageReaded(Constants.WECHATCLAIMS_MESSAGE_NOTREADED);// 未读
		weiXinCustomerServiceChatDetail.setMessageId(receiveMessage.getId());
		weiXinCustomerServiceChatDetail
				.setMessageSource(Constants.WECHATCLAIMS_MESSAGE_SOURCE_USER);
		weiXinCustomerServiceChatDetail.setReceiveMessage(receiveMessage);
		customerChatService
				.saveWeiXinCustomerServiceChatDetail(weiXinCustomerServiceChatDetail);

	}

	@Override
	public boolean sendCloseSessionMessage(String openid) {
		String returnMessage = "    ";
		WeChatContext weChatContext = weChatContextService
				.getWeChatContext(openid);
		Progress claimsProgress = (Progress) weChatContext
				.get(Constants.WEIXINCLAIMS_claimsProgress); // 当前理赔进度
		String is_Ask = (String) weChatContext
				.get(Constants.WEIXINCLAIMS_is_Ask);
		if ("N".equals(is_Ask)
				&& claimsProgress == Progress.Successful_association_claim) {
			returnMessage = WeixinUtil.sendCustomerServiceMessage(openid,
					"text", ReturnMessageManagement.getAskingCloseSession());
			logger.info("sendCloseSessionMessage(String openid)=======给客户发送结束会话消息=============>"
					+ openid);
			weChatContext.save(Constants.WEIXINCLAIMS_claimsProgress,
					Progress.Asked_close_session);
			weChatContextService.saveWeChatContext(weChatContext, openid);
		}
		return StringUtil.isEmpty(returnMessage);
	}

	@Override
	public void colseWechatSession(String openid) {
		WeChatContext weChatContext = weChatContextService
				.getWeChatContext(openid);
		if (weChatContext != null) {
			Progress claimsProgress = (Progress) weChatContext
					.get(Constants.WEIXINCLAIMS_claimsProgress); // 当前理赔进度
			if (claimsProgress != Progress.Cancel_claim_session) {
				WeixinUtil.sendCustomerServiceMessage(openid, "text",
						ReturnMessageManagement.getCloseSessionMessage());
			}
		}
		ReportInfo reportInfo = (ReportInfo) weChatContext
				.get(Constants.WEIXINCLAIMS_reportInfo);
		boolean returnRes = reportInfoService
				.updReportInfoByRegistNo(reportInfo != null ? reportInfo
						.getRegistNo() : null);
		// List<ReportInfo> ReportInfoList=
		// reportInfoService.getReportInfoList(openid);
		// for (ReportInfo reportInfo:ReportInfoList){
		// boolean returnRes =
		// reportInfoService.updReportInfoByRegistNo(reportInfo.getRegistNo());
		// }
		this.closeSession(openid);
	}

	@Override
	public void timeoutCloseSession(String openid) {
		WeixinUtil.sendCustomerServiceMessage(openid, "text",
				ReturnMessageManagement.getTimeoutMessage());
		this.closeSession(openid);
	}

	@Override
	public boolean customerIsOnline(String openid) {
		WeChatContext weChatContext = weChatContextService
				.getWeChatContext(openid);
		Progress claimsProgress = (Progress) weChatContext
				.get(Constants.WEIXINCLAIMS_claimsProgress); // 当前理赔进度
		if (claimsProgress != Progress.Cancel_claim_session) {
			return true;
		}
		return false;
	}

	private void closeSession(String openid) {
		CachedUtils.delete(Constants.MEMKEY_WEIXIN_WeChat_claims + openid);
	}

}
