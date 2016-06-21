package cn.com.fubon.webservice.server.handler;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import javax.annotation.Resource;
import jodd.datetime.JDateTime;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.jeecgframework.core.common.service.CommonService;
import org.jeecgframework.core.util.DateUtils;
import org.jeecgframework.core.util.ResourceUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import weixin.guanjia.account.service.WeixinAccountServiceI;
import weixin.guanjia.core.util.WeixinUtil;
import weixin.popular.api.MessageAPI;
import cn.com.fubon.webservice.WsConstants;
import cn.com.fubon.webservice.entity.request.FbWSRequest;
import cn.com.fubon.webservice.entity.request.RequestBody;
import cn.com.fubon.webservice.entity.response.FbWSResponse;
import cn.com.fubon.webservice.entity.response.ResponseHead;
import cn.com.fubon.webservice.entity.response.TransResponse;
import cn.com.fubon.wechatClaims.entity.ReportInfo;

/**
 * 调用核心理赔webservice响应处理类
 * 
 * @author fangfang.guo
 *
 */

@Service("client100ServerHandler")
@Transactional
public class Client100ServerHandler implements ServerHandler{
	private static final Logger logger = Logger
			.getLogger(Client100ServerHandler.class);
	@Resource
	private CommonService commonService;
	@Resource
	private WeixinAccountServiceI weixinAccountService;

	@Override
	public FbWSResponse process(FbWSRequest fbWSRequest){

		// 组装FbWSResponse对象
		FbWSResponse fbWSResponse = new FbWSResponse();
		ResponseHead responseHead = new ResponseHead();
		TransResponse transResponse = new TransResponse();
		responseHead.setTranscationSeqNo(fbWSRequest.getRequestHead()
				.getTranscationSeqNo());
		responseHead.setTranscationCode(fbWSRequest.getRequestHead()
				.getTranscationCode());
		responseHead
				.setClientCode(fbWSRequest.getRequestHead().getClientCode());
		responseHead
				.setServerCode(fbWSRequest.getRequestHead().getServerCode());
		JDateTime jnow = new JDateTime(new Date());
		responseHead.setTranscationDate(jnow.toString("YYYYMMDD"));
		responseHead.setTranscationTime(jnow.toString("hhmmss"));

		RequestBody requestBody = fbWSRequest.getRequestBody();

		if(requestBody == null){
			transResponse.setReturnCode(WsConstants.RETURNCODE_9);
			transResponse.setReturnMessage(WsConstants.RETURNMESSAGE_9);
		}

		// 请求报文中的openid为空
		else if(requestBody.getOpenid() == null
				|| "".equals(requestBody.getOpenid())){
			transResponse.setReturnCode(WsConstants.RETURNCODE_6);
			transResponse.setReturnMessage(WsConstants.RETURNMESSAGE_6);
		}else{
			ReportInfo reportInfo = this.updateReportInfo(requestBody);

			this.sendClaimTemplateMessage(requestBody,reportInfo);

			transResponse.setReturnCode(WsConstants.RETURNCODE_1);
			transResponse.setReturnMessage(WsConstants.RETURNMESSAGE_1);

		}

		responseHead.setTransResponse(transResponse);
		fbWSResponse.setResponseHead(responseHead);
		return fbWSResponse;
	}

	private void sendClaimTemplateMessage(RequestBody requestBody,
			ReportInfo reportInfo){
		ResourceBundle resourceBundle = ResourceUtil.getBundleEnvAbout();

		Map<String,String> messageData = new HashMap<String,String>();

		// 如果是改派传统理赔要推送模板消息给客户
		if(WsConstants.CLAIM_CASE_HANDLE_WAY_1.equals(requestBody
				.getClaimCaseHandleWay())){

			String templateMessageId = resourceBundle
					.getString("template_message_id_1");

			// 礼貌性、称谓性的用语
			messageData.put("first","尊敬的" + reportInfo.getReportorName()
					+ "先生/女士，您的理赔案件最新进展信息");
			// 车牌号
			messageData.put("keyword1",reportInfo.getLicenseNo());
			// 被保险人
			messageData.put("keyword2",requestBody.getInsuredName());
			// 出险经过
			messageData.put("keyword3",reportInfo.getRemark());
			// 理赔专员
			messageData.put("keyword4",requestBody.getOperatorName());
			// 理赔专员手机
			messageData.put("keyword5",requestBody.getOperatorMobile());
			messageData.put("remark",
					"您好，理赔专员5分钟内会与您联系，请您放心。如有疑问您可拨打4008-817-518进行咨询。【富邦财险】");

			// 启用模板
			new MessageAPI().sendTemplateMessage(templateMessageId,null,
					requestBody.getOpenid(),messageData);

		}
		// 状态为核赔提交,发送模板消息
		else if(WsConstants.CLAIM_CASE_STATUS_110 == reportInfo.getCaseStatus()){

			String templateMessageId = resourceBundle
					.getString("template_message_id_2");

			// 核赔金额确认,要获取到当前用户的openid,所以要返回code,取openid
			String prepareConfirmClaimFeeUrl = WeixinUtil
					.redirectUrlForOpenId(
							"/fo/binded/customerClaims/customerClaimsController.do?method=prepareConfirmClaimFee",
							requestBody.getClaimCaseNo(),false);
			// 礼貌性、称谓性的用语
			messageData.put("first","尊敬的" + reportInfo.getReportorName()
					+ "先生/女士，您的理赔案件最新进展信息");
			// 车牌号
			messageData.put("keyword1",reportInfo.getLicenseNo());
			// 被保险人
			messageData.put("keyword2",requestBody.getInsuredName());
			// 出险经过
			messageData.put("keyword3",reportInfo.getRemark());
			// 理赔金额
			String claimCaseFee = requestBody.getClaimCaseFee();
			java.text.DecimalFormat df = new java.text.DecimalFormat("0.00");
			messageData.put("keyword4",df.format(Double.parseDouble(claimCaseFee)));
			// 理赔所缺材料
			messageData.put("keyword5",reportInfo.getCertiMaterialType());
			messageData
					.put("remark",
							"您好，案件已审核通过，赔款会支付到您指定银行卡。如您欠缺材料请于5个工作日将所缺材料补齐，如有疑问您可拨打4008-817-518进行咨询。【富邦财险】");

			// 启用模板
			new MessageAPI().sendTemplateMessage(templateMessageId,
					prepareConfirmClaimFeeUrl,requestBody.getOpenid(),
					messageData);
		}
	}

	private ReportInfo updateReportInfo(RequestBody requestBody){
		ReportInfo reportInfo = commonService.findUniqueByProperty(
				ReportInfo.class,"registNo",requestBody.getClaimCaseNo());

		reportInfo.setCaseStatus(Integer.valueOf(requestBody
				.getClaimCaseStatus()));
		String claimCaseFee = requestBody.getClaimCaseFee();
		reportInfo
				.setClaimCaseFee(StringUtils.isNotEmpty(claimCaseFee) ? new BigDecimal(
						claimCaseFee) : null);

		String underwritingTime = StringUtils.isNotEmpty(requestBody
				.getClaimEndDate()) ? requestBody.getClaimEndDate() + " "
				+ requestBody.getClaimEndTime() : null;
		if(StringUtils.isNotEmpty(underwritingTime)){
			try{
				reportInfo.setUnderwritingTime(DateUtils.parseTimestamp(
						underwritingTime,"yyyyMMdd HHmmss"));
			}catch(ParseException e){
				logger.error("underwritingTime ParseException",e);
			}

			Timestamp reportTime = null;
			try{
				reportTime = DateUtils.parseTimestamp(
						reportInfo.getReportDate() + " "
								+ reportInfo.getReportTime(),
						"yyyy-MM-dd HH:mm:ss");
			}catch(ParseException e){
				logger.error("reportTime ParseException",e);
			}
			reportInfo
					.setClaimConsumeTime((int)(reportInfo.getUnderwritingTime()
							.getTime() - reportTime.getTime()) / 1000);
		}

		// 报案表状态修改
		commonService.updateEntitie(reportInfo);
		return reportInfo;
	}

}
