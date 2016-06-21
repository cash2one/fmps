package cn.com.fubon.fo.totaiwan.service.impl;

import java.lang.annotation.Annotation;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import jodd.util.StringUtil;

import org.apache.commons.chain.Context;
import org.apache.log4j.Logger;
import org.jeecgframework.core.util.ResourceUtil;
import org.jeecgframework.core.util.UUIDGenerator;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.ContextLoader;

import weixin.guanjia.account.entity.WeixinAccountEntity;
import weixin.guanjia.account.service.WeixinAccountServiceI;
import weixin.popular.api.MessageAPI;
import weixin.popular.bean.pay.PayNotify;
import weixin.popular.util.JsonUtil;
import cn.com.fubon.bo.wsinvokelog.entity.WsInvokeFailureLog;
import cn.com.fubon.bo.wsinvokelog.service.WsInvokeFailureLogService;
import cn.com.fubon.fo.card.entity.Policy;
import cn.com.fubon.fo.card.service.IPolicyService;
import cn.com.fubon.fo.totaiwan.entity.PolicyRequest;
import cn.com.fubon.fo.totaiwan.service.ToTaiWanPayNotifyService;
import cn.com.fubon.microshop.entity.response.PolicyInfoResponse;
import cn.com.fubon.microshop.service.CoreUnderwriteService;
import cn.com.fubon.product.entity.Plan;
import cn.com.fubon.product.entity.Product;
import cn.com.fubon.rest.service.impl.RestWebServiceClient;
import cn.com.fubon.util.WebServiceUtils;
import cn.com.fubon.util.XmlUtils;
import cn.com.fubon.webservice.WsConstants;
import cn.com.fubon.webservice.externl.coresystem.CoreWSConstants;
import cn.com.fubon.webservice.externl.coresystemUnderwrite.entity.response.UnderwriteResponse;
import cn.com.fubon.webservice.server.WebServiceClientManagementService;
import cn.com.fubon.webservice.server.entity.WebServiceClientManagement;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@Service("toTaiWanPayNotifyServiceImpl")
@Transactional
public class ToTaiWanPayNotifyServiceImpl implements ToTaiWanPayNotifyService {
	private static final Logger logger = Logger.getLogger(ToTaiWanPayNotifyServiceImpl.class);

	@Resource
	private IPolicyService policyService;	
	@Resource
	private CoreUnderwriteService coreUnderwriteService;
	@Resource
	private WeixinAccountServiceI weixinAccountService;
	@Resource(name="postMessageToFcps")
	private RestWebServiceClient postMessageToFcps;	
	@Resource
	private WebServiceClientManagementService  webServiceClientManagementService;
	@Resource
	private WsInvokeFailureLogService wsInvokeFailureLogService;
	public static final String TEMPLATEMESSAGEID = "ga828ebb4881111e01488114371a0003";
	public static final String MESSAGE = "支付发送核心失败！";
	public static final String RETURNCODE_1 = "0000";
	public static final String RETURNCODE_2 = "00000";
	
	@Override
	public void doUnderwriting(String orderNo,PayNotify payNotify) {
		logger.info("赴台支付成功,处理后续发送核心承保报文======>"+orderNo);		 
		Policy policy=  policyService.getPolicyByOrderNo(orderNo);		
	    String productId=policyService.get(Plan.class, policy.getPlanid()).getProductid();
	    String salemode= policyService.get(Product.class, productId).getSalemode();
		if("4".equals(salemode)){ //销售方式为4手工承保
			logger.info("赴台支付成功,进入离线手工承保===orderNo===>"+orderNo);
			this.offLineUnderwriting(policy, payNotify);
		}else{
			logger.info("赴台支付成功,进入在线承保===orderNo===>"+orderNo);
			this.onLineUnderwriting(policy, payNotify);			
		 }
	  }
	 //在线承保，发送核心报文
	private void onLineUnderwriting(Policy policy,PayNotify payNotify){		
		SimpleDateFormat dateFm = new SimpleDateFormat("yyyy年MM月dd日");
		String activedProfile = ContextLoader.getCurrentWebApplicationContext().getServletContext().getInitParameter("spring.profiles.active");
		String coreResponseXML = null;
		try {
			Context contextFromCore = coreUnderwriteService.sendMessageToCore(policy, "", "", payNotify.getTransaction_id());
			//获取承保响应报文
			coreResponseXML = (String)contextFromCore.get(WsConstants.CHAIN_CONTEXT_KEY_WS_EXTERNL_RESPONSE_XML);
			logger.info("赴台调用承保后响应报文："+coreResponseXML);			
			//从承保响应报文获取保单号
			UnderwriteResponse response = this.getPolicyno(coreResponseXML);
			logger.info("赴台调用承保后响应报文的保单号policyno:"+response.getBody().getPolicyno());			
			if(response.getHead().getReturncode().equals(RETURNCODE_1)){	//返回returncode为0000则成功
				//更新保单号
				policyService.setPolicyNoByOrderNo(policy.getOrderno(), response.getBody().getPolicyno());
				/*
				 * 承保成功后：微信推送客户投保成功模板
				 */
				//保单详情地址
				String domain= ResourceUtil.getDomain();
				String redirect_uri="{domain}/fo/cardController.do?viewnewdetail&policyNo=POLICYNO";				
				redirect_uri=redirect_uri.replace("POLICYNO", response.getBody().getPolicyno()).replace("{domain}", domain);
				String url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid={APPID}&redirect_uri="+URLEncoder.encode(redirect_uri,"UTF-8")+"&response_type=code&scope=snsapi_base&state=STATE#wechat_redirect";
				url= url.replace("{APPID}", getAppid());
				Map<String, String> messageData = new HashMap<String, String>();
//				String templateMessageId = "ga828ebb4881111e01488114371a0003";
				String total = "¥"+changeAmout(payNotify.getTotal_fee());
				messageData.put("first", "你好！你已投保成功！");
				messageData.put("keyword1", policy.getProductname());	//产品名称
				messageData.put("keyword2", response.getBody().getPolicyno());	//保单号
				messageData.put("keyword3", total);	//支付金额
				messageData.put("keyword4", dateFm.format(policy.getStartdate())+"0时至"+ dateFm.format(policy.getEnddate())+"24时");	//保险期间
				messageData.put("remark", "");
				logger.info("keyword1="+policy.getProductname()+",keyword2="+response.getBody().getPolicyno() + ",keyword3="+total+",keyword4="+dateFm.format(policy.getStartdate())+"0时至"+ dateFm.format(policy.getEnddate())+"24时");
				logger.info("openid="+payNotify.getOpenid());
				//判断当前环境,如果非生产的话,读取openid映射
				String openid = null;
				if(!activedProfile.equalsIgnoreCase("prod")){
					try {
						openid = ResourceUtil.getBundleEnvAbout().getString(payNotify.getOpenid());
					}catch (Exception e) {
						logger.error("资源文件没有对应的openid！");
						if(StringUtil.isEmpty(openid))
							openid = payNotify.getOpenid();
					}
				}else{
					openid = payNotify.getOpenid();
				}
				// 2、发送模板消息
				new MessageAPI().sendTemplateMessage(TEMPLATEMESSAGEID, url,openid, messageData);
			}else{
				/*
				 * 承保失败后：发送报文给企业号
				 * 保存失败报文
				 */
				this.sendFalseInfoToFcps(policy, payNotify, coreResponseXML);
			}
		} catch (Exception e) {
			logger.info("赴台支付成功,核心承保报文发送失败======>"+policy.getOrderno(), e);
			this.sendFalseInfoToFcps(policy, payNotify, coreResponseXML);
		}
	}
	
	  //线下手工成功
	private void offLineUnderwriting(Policy policy,PayNotify payNotify){
		logger.info("发送通知企业号消息==orderNo===>"+policy.getOrderno());		
		Map<String, String> data = new HashMap<String, String>();
		data.put("keyword1", policy.getOrderno()); //订单号
		data.put("keyword2", policy.getProductname()); //商品名称
		data.put("keyword3", payNotify.getTotal_fee()); //金额，单位为分
		data.put("keyword4",payNotify.getAttach() ); //附加信息
		data.put("keyword5",policy.getApplicant().getEmail() ); //Email
		data.put("keyword6", "赴台学位生在线支付成功通知");
		PolicyRequest policyRequest = new PolicyRequest("fmps","fcps","json", "33", UUIDGenerator.generate(), "offLinePay",data);
		Context context = null;
		String clientCode = ResourceUtil.getBundleEnvAbout().getString("clientCode");
		WebServiceClientManagement WebServiceClientManagement = webServiceClientManagementService
				.findUniqueByProperty(WebServiceClientManagement.class,	"clientCode", clientCode);
		String requestJson = JsonUtil.toJSONString(policyRequest);	
		
		try {
			context =postMessageToFcps.startExecuteChain(requestJson, WebServiceClientManagement.getToken(), WebServiceClientManagement.getAESKey() , clientCode);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String responeJSON=(String) context.get(WsConstants.RESPONSEJSON);
		logger.info("承保失败后：发送报文给企业号获取保单信息返回回来的JSON=== " + responeJSON);		
	}
	
	private void saveWsInvokeFailureLog(PolicyRequest policyRequest,
			PolicyInfoResponse policyResponse) {
		WsInvokeFailureLog wsInvokeFailureLog= new WsInvokeFailureLog();
		String  orginTranscationSeqNo=policyRequest.getTransactionId();		
		String	transcationSeqNo=UUIDGenerator.generate();
		policyRequest.setTransactionId(transcationSeqNo);
		String internalRequest = JsonUtil.toJSONString(policyRequest);
		String internalResponse = policyResponse!=null?JsonUtil.toJSONString(policyResponse): "链条报文出错误，无返回报文 ";		
		wsInvokeFailureLog.setClientCode("00001");
		wsInvokeFailureLog.setInternalRequest(internalRequest);
		wsInvokeFailureLog.setInternalResponse(internalResponse);
		wsInvokeFailureLog.setReturnCode(policyResponse!=null?policyResponse.getErrcode():"无返回");
		wsInvokeFailureLog.setReturnMessage(policyResponse!=null?policyResponse.getErrmsg():"无返回");
		// 产生新的流水号
		wsInvokeFailureLog.setTranscationSeqNo(transcationSeqNo);
		// 记录原始的上一笔交易流水号
		wsInvokeFailureLog.setOrginTranscationSeqNo(orginTranscationSeqNo);		
		wsInvokeFailureLog.setWsClientBeanName("postMessageToFcps"); 
		wsInvokeFailureLog.setStatus(CoreWSConstants.treatment_waiting); // 发送状态 -1 为 待发送
		wsInvokeFailureLog.setSendCount(1); // 发送次数 1
		wsInvokeFailureLog.setNextInvokeTime(new Date()); // 下次发送时间
		wsInvokeFailureLog.setInternalRequestObj(WebServiceUtils.serializeObject(policyRequest));		
		wsInvokeFailureLogService.save(wsInvokeFailureLog);	
	}

	/**
	 * 解析承保响应报文，返回实体
	 * @param coreResponseXML
	 * @return
	 */
	private UnderwriteResponse getPolicyno(String coreResponseXML){
		Class<UnderwriteResponse> responseClass = UnderwriteResponse.class;
		Annotation annotation = responseClass.getAnnotation(XStreamAlias.class);
		String annotationValue = (String) AnnotationUtils.getValue(annotation);
		UnderwriteResponse coreResponse = (UnderwriteResponse) XmlUtils.fromXML(coreResponseXML,annotationValue,UnderwriteResponse.class);
		return coreResponse;
	}
	
	/**
	 * 解析承保响应报文获取返回的returnMessage
	 * @param coreResponseXML
	 * @return
	 */
	private String getRetrunMessage(String coreResponseXML){
		Class<UnderwriteResponse> responseClass = UnderwriteResponse.class;
		Annotation annotation = responseClass.getAnnotation(XStreamAlias.class);
		String annotationValue = (String) AnnotationUtils.getValue(annotation);
		UnderwriteResponse coreResponse = (UnderwriteResponse) XmlUtils.fromXML(coreResponseXML,annotationValue,UnderwriteResponse.class);
		return coreResponse.getHead().getReturnmessage();
	}
	
	/**
	 * 获取appid
	 * 
	 * @return
	 */
	public String getAppid() {
		List<WeixinAccountEntity> weixinAccountEntityList = weixinAccountService.findValidWeixinAccounts();
		WeixinAccountEntity weixinAccountEntity = weixinAccountEntityList.get(0);
		String appid = weixinAccountEntity.getAccountappid();
		
		return appid;
	}
	
	 /**  
     * 将分为单位的转换为元 （除100）  
     *   
     * @param amount  
     * @return  
     * @throws Exception   
     */    
    public static String changeAmout(String amount) throws Exception{

        return BigDecimal.valueOf(Double.valueOf(amount)).divide(new BigDecimal(100)).toString();    
    }
    
    public void sendFalseInfoToFcps(Policy policy,PayNotify payNotify,String coreResponseXML){
    		SimpleDateFormat dateFm = new SimpleDateFormat("yyyy年MM月dd日");
    	try {
			String date = dateFm.format(policy.getStartdate())+"0时至"+ dateFm.format(policy.getEnddate())+"24时";
			String total = "¥"+changeAmout(payNotify.getTotal_fee());
			Map<String, String> data = new HashMap<String, String>();
			data.put("keyword1", policy.getProductname());
			data.put("keyword2", policy.getPolicyno());
			data.put("keyword3", total);
			data.put("keyword4", date);
			data.put("keyword5", MESSAGE);
			PolicyRequest policyRequest = new PolicyRequest("fmps","fcps","json", "33", UUIDGenerator.generate(), "totaiwan",data);
			Context context = null;
			String clientCode = ResourceUtil.getBundleEnvAbout().getString("clientCode");
			WebServiceClientManagement WebServiceClientManagement = webServiceClientManagementService
					.findUniqueByProperty(WebServiceClientManagement.class,	"clientCode", clientCode);
			String requestJson = JsonUtil.toJSONString(policyRequest);	
			
			context =postMessageToFcps.startExecuteChain(requestJson, WebServiceClientManagement.getToken(), WebServiceClientManagement.getAESKey() , clientCode);
			String responeJSON=(String) context.get(WsConstants.RESPONSEJSON);
			logger.info("承保失败后：发送报文给企业号获取保单信息返回回来的JSON=== " + responeJSON);
			PolicyInfoResponse policyResponse = JsonUtil.parseObject(responeJSON,PolicyInfoResponse.class);	
			if(!policyResponse.getErrcode().equals(RETURNCODE_2)){ //报文返回信息不等于“00000”。就表示出错了，需要从发
				this.saveWsInvokeFailureLog(policyRequest ,policyResponse);	
			}
		} catch (Exception e) {
			logger.info("赴台支付或者承保失败,核心承保报文发送失败或发送报文企业号失败======>"+policy.getPolicyno(), e);
		}
    }
}
