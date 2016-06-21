package cn.com.fubon.wechatClaims.util;

import java.util.List;
import org.jeecgframework.core.util.ApplicationContextUtil;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.web.cgform.engine.FreemarkerHelper;
import cn.com.fubon.entity.WeChatContext;
import cn.com.fubon.util.Constants;
import cn.com.fubon.wechatClaims.entity.ReportInfo;
import cn.com.fubon.wechatClaims.service.ClaimsSessionManagement;

public class ReturnMessageManagement{

	private static String photoGuide = ""; // 拍照指引手册 链接
	public static String domain; // 服务器域名 从 ClaimsSessionManagementImpl 类 写入值

	public static void main(String[] args){
		// TODO Auto-generated method stub
		String html = new FreemarkerHelper().parseTemplate(
				"/weixin/welcome.ftl",null);
		System.out.println(html);
	}

	public static String getMessageCancelClaimSession(){
		String retMessage = "请输入您报案时的手机号码，并发送给我们。如您未报案，请先致电4008-817-518，若符合闪赔条件，客服会进行引导。";
		// + "报案电话输入正确后可点击查看" + getPhotoGuide()
		// + "，后台会有理赔专员指导您完成微信闪赔。";
		return retMessage;
	}

	public static String getMessageEnterTheClaim(){
		String retMessage = "请输入您报案时的手机号码，并发送给我们。如您未报案，请先致电4008-817-518，若符合闪赔条件，客服会进行引导。";
		// + "报案电话输入正确后可点击查看" + getPhotoGuide()
		// + "，后台会有理赔专员指导您完成微信闪赔。";
		return retMessage;
	}

	public static String getMessageQueryClaim0(String phoneNO){
		String retMessage = "您好，没有查询到使用[" + phoneNO
				+ "]报案的信息，请确认您已拨打4008-817-518进行过电话报案。";
		return retMessage;
	}

	public static String getMessageQueryClaim1(WeChatContext weChatContext){
		ReportInfo reportInfo = (ReportInfo)weChatContext
				.get(Constants.WEIXINCLAIMS_reportInfo);
		String retMessage = "尊敬的客户，您好，理赔专员" + reportInfo.getOperatorName()
				+ "工号" + reportInfo.getOperatorCode() + "竭诚为您服务：\n "
				+ ReturnMessageManagement.getreportMessage(reportInfo);
		retMessage = retMessage
				+ ReturnMessageManagement
						.getMessageSuccessfulAssociationClaim(weChatContext);
		return retMessage;
	}

	public static String getMessageQueryClaimMulti(WeChatContext weChatContext){
		List<ReportInfo> reportInfoList = (List<ReportInfo>)weChatContext
				.get(Constants.WEIXINCLAIMS_reportInfoList);
		String multiReportMessage = "";
		for(int j = 0; j < reportInfoList.size(); j++){
			int xuhao = j + 1;
			multiReportMessage = multiReportMessage
					+ "\n"
					+ "*序号："
					+ xuhao
					+ "\n"
					+ ReturnMessageManagement.getreportMessage(reportInfoList
							.get(j)) + "\n";
		}
		String retMessage = "您的案件信息列表如下 ，请输入您的选择。  如序号为1，直接输入1。\n"
				+ multiReportMessage;
		return retMessage;
	}

	private static String getreportMessage(ReportInfo reportInfo){
		String reportMessage = "";
		reportMessage = "车牌号："
				+ (reportInfo.getNewCarFlag() == 1 ? "新车" : reportInfo
						.getLicenseNo())
				+ "\n"
				+ "案件描述:\n"
				+ "      "
				+ reportInfo.getRemark()
				+ "\n"
				+ (StringUtil.isEmpty(reportInfo.getCertiMaterialType()) ? ""
						: "所欠缺理赔材料：\n" + reportInfo.getCertiMaterialType());
		return reportMessage;
	}

	public static String getMessageSuccessfulAssociationClaim(
			WeChatContext weChatContext){
		ReportInfo reportInfo = (ReportInfo)weChatContext
				.get(Constants.WEIXINCLAIMS_reportInfo);
		// ReceiveMessage receiveMessage=new ReceiveMessage();
		// receiveMessage.setMsgType("text");
		// receiveMessage.setContent("用户已经进入微理赔，请注意（本消息系统自动触发）。");
		// receiveMessage.setCreateTime(Timestamp.valueOf(DateUtils.getDate("yyyy-MM-dd HH:mm:ss.SSS")));
		// receiveMessage.setFromUserName(reportInfo.getOpenid());
		// ReceiveMessageServiceI receiveMessageService =
		// (ReceiveMessageServiceI)
		// ApplicationContextUtil.getContext().getBean("receiveMessageService");
		ClaimsSessionManagement ClaimsSessionManagementImpl = (ClaimsSessionManagement)ApplicationContextUtil
				.getContext().getBean("claimsSessionManagement");
		// receiveMessageService.save(receiveMessage);
		// ClaimsSessionManagementImpl.saveweiXinCustomerServiceChatDetail(receiveMessage,
		// weChatContext);
		ClaimsSessionManagementImpl.saveweiXinCustomerServiceChatContent(
				reportInfo.getOpenid(),"用户已经进入微理赔，请注意（本消息系统自动触发）。",
				reportInfo.getRegistNo());
		String retMessage = "拍照指南:\n" + "      请点击," + getPhotoGuide()
				+ "。 在指定位置拍照发送给我们。\n";
		return retMessage;
	}

	private static String getPhotoGuide(){
		// photoGuide = "<a href=\"" + domain +
		// "/plug-in/huodong/photoGuide/index.html" + "\"> 拍照指引手册 </a>";
		photoGuide = "<a href=\""
				+ "http://mp.weixin.qq.com/s?__biz=MzA5NzkyNTMxMg==&mid=203490762&idx=1&sn=e150870697f3659acb69962f7032e747#rd"
				+ "\"> 拍照指引手册 </a>";

		return photoGuide;
	}

	public static String getAskingCloseSession(){
		String retMessage = "  您好，由于长时间未收到您的回复消息，系统将在5分钟后关闭本次对话。如需继续服务，请输入Y；无需服务，输入任意信息可立即结束对话。   ";
		return retMessage;
	}

	public static String getTimeoutMessage(){
		String retMessage = "  您好，由于长时间未收到您的回复消息，系统自动关闭本次会话，如需闪赔服务，可再次在微信输入报案手机号；如需其他服务，可输入数字0转微信客服。感谢您的支持。 ";
		return retMessage;
	}

	public static String getCloseSessionMessage(){
		String retMessage = "   您好，客服已将此次会话关闭，感谢您的支持。如您还需要微信闪赔服务，可再次输入报案手机号。 ";
		return retMessage;
	}

	public static String getCustomerCloseSessionMessage(){
		String retMessage = "   您好，您已经退出微信理赔了，感谢您的支持 ！  ";
		return retMessage;
	}

	public static String getNonworkingtime(){
		String retMessage = "   微信闪赔受理时间为6：30-19：00，如有任何疑问，请拨打4008-817-518咨询。 ";
		return retMessage;
	}

	public static String getxSystemMessage(){
		String retMessage = "   【系统消息】您当前在人工服务状态，如需微信闪赔服务请先退出人工。\n 退出人工[1]\n留在人工[2]。 ";
		return retMessage;
	}

	public static String getErrorMessage(){
		String retMessage = "    系统发生故障，获取案件信息失败，请联系4008-817-518 ";
		return retMessage;
	}

	public static String getErrorPhoneMessage(){
		String retMessage = "    您输入的不是手机号，请重新输入。 ";
		return retMessage;
	}

	public static String getUnderwritingErrorMessage(ReportInfo reportInfo){
		String retMessage = "    此案件已由" + reportInfo.getNickname() + "报案处理，于"
				+ reportInfo.getUnderwritingTime() + "核赔通过。您并非案件处理人，不可选择此案件。 ";
		return retMessage;
	}
}
