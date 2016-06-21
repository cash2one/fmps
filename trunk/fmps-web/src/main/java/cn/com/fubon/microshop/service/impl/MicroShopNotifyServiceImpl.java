package cn.com.fubon.microshop.service.impl;

import java.lang.annotation.Annotation;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.chain.Context;
import org.apache.log4j.Logger;
import org.jeecgframework.core.util.ResourceUtil;
import org.jeecgframework.core.util.UUIDGenerator;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import weixin.popular.bean.pay.PayNotify;
import weixin.popular.util.JsonUtil;
import cn.com.fubon.bo.wsinvokelog.entity.WsInvokeFailureLog;
import cn.com.fubon.bo.wsinvokelog.service.WsInvokeFailureLogService;
import cn.com.fubon.fo.card.entity.ContractAddress;
import cn.com.fubon.fo.card.entity.Customer;
import cn.com.fubon.fo.card.entity.Policy;
import cn.com.fubon.fo.card.entity.PolicyInsured;
import cn.com.fubon.fo.card.service.IContractAddressService;
import cn.com.fubon.fo.card.service.ICustomerService;
import cn.com.fubon.fo.card.service.IPolicyInsuredService;
import cn.com.fubon.fo.card.service.IPolicyService;
import cn.com.fubon.microshop.entity.request.PolicyInfoRequest;
import cn.com.fubon.microshop.entity.response.PolicyInfoResponse;
import cn.com.fubon.microshop.service.CoreUnderwriteService;
import cn.com.fubon.microshop.service.MicroShopNotifyService;
import cn.com.fubon.rest.service.impl.RestWebServiceClient;
import cn.com.fubon.util.WebServiceUtils;
import cn.com.fubon.util.XmlUtils;
import cn.com.fubon.webservice.WsConstants;
import cn.com.fubon.webservice.externl.coresystem.CoreWSConstants;
import cn.com.fubon.webservice.externl.coresystemUnderwrite.entity.response.UnderwriteResponse;
import cn.com.fubon.webservice.server.WebServiceClientManagementService;
import cn.com.fubon.webservice.server.entity.WebServiceClientManagement;



@Service("microShopNotifyService")
@Transactional
public class MicroShopNotifyServiceImpl implements MicroShopNotifyService {
	private static final Logger logger = Logger.getLogger(MicroShopNotifyServiceImpl.class);	
	
	@Resource(name="policyInformationAcquisition")
	private RestWebServiceClient policyInformationAcquisition;	
	@Resource
	private WsInvokeFailureLogService wsInvokeFailureLogService;
	@Resource
	private WebServiceClientManagementService  webServiceClientManagementService;
	@Resource
	private CoreUnderwriteService coreUnderwriteService;
	@Resource
	private IContractAddressService contractAddressService;
	@Resource
	private ICustomerService customerService;
	@Resource
	private IPolicyInsuredService policyInsuredService;
	@Resource
	private IPolicyService policyService;
	@Resource(name="updatePolicyInformation")
	private RestWebServiceClient updatePolicyInformation;
	
	public void doUnderwriting(String fmcpPayCode,PayNotify payNotify  ){
		logger.info("微店支付成功开始回调作业===========fmcpPayCode========>"+fmcpPayCode);
	//1、支付成功，根据fmcpPayCode 向企业号获取保单信息.
		PolicyInfoRequest policyInfoRequest =new PolicyInfoRequest("fmps","fcps","json","23",UUIDGenerator.generate(), fmcpPayCode,payNotify.getTransaction_id(),payNotify.getOut_trade_no(),payNotify.getAttach());
		Context context = null;
		String clientCode = ResourceUtil.getBundleEnvAbout().getString(	"clientCode");
		WebServiceClientManagement WebServiceClientManagement = webServiceClientManagementService
				.findUniqueByProperty(WebServiceClientManagement.class,	"clientCode", clientCode);
		String requestJson = JsonUtil.toJSONString(policyInfoRequest);		
		try {
			context = policyInformationAcquisition.startExecuteChain(requestJson, WebServiceClientManagement.getToken(), WebServiceClientManagement.getAESKey() , clientCode);			
			String responeJSON=(String) context.get(WsConstants.RESPONSEJSON);		
			logger.info("1、微店支付成功后向企业号获取保单信息返回回来的JSON=== " + responeJSON);
			PolicyInfoResponse policyInfoResponse = JsonUtil.parseObject(responeJSON,PolicyInfoResponse.class);	
			if(!policyInfoResponse.getErrcode().equals("00000")){ //报文返回信息不等于“00000”。就表示出错了，需要从发
				logger.info("1、1微店支付成功后向企业号获取保单信息返回回来的错误信息==errmsg=> " + policyInfoResponse.getErrmsg());
				this.sendPolicynoToFcps(fmcpPayCode, payNotify.getTransaction_id(),payNotify.getOut_trade_no(),payNotify.getAttach(),"orderNo","","2","微店支付成功后向企业号获取保单信息返回回来的错误信息");	
			}else{
			    logger.info("2、微店支付成功后向企业号获取保单信息成功进入发送核心承保报文=fmcpPayCode==> " + fmcpPayCode);	
				this.policyUnderwrite(policyInfoResponse.getPolicy(),fmcpPayCode,payNotify);				
			}
			
		} catch (Exception e) {
			logger.info("支付成功后向企业号获取保单信息异常",e);
			this.sendPolicynoToFcps(fmcpPayCode, payNotify.getTransaction_id(),payNotify.getOut_trade_no(),payNotify.getAttach(),"orderNo","","2","支付成功后向企业号获取保单信息异常");
			//this.saveWsInvokeFailureLog(policyInfoRequest,null);
			e.printStackTrace();
		}
		
	}
	
	private void policyUnderwrite(Policy policy,String fmcpPayCode,PayNotify payNotify){		
		//出单人员
		String operatecode = (policy.getOperateCode() == null ? "" : policy.getOperateCode());
		//归属人员，目前保持跟"出单人员"一致
		String handler1code = operatecode;
		logger.info("3、微店向企业号获取保单信息成功后，开始向核心发送承保报文===fmcpPayCode==> " + fmcpPayCode);	
		Context contextFromCore = null;
		String coreResponseXML="未知错误";
		try {
			contextFromCore = coreUnderwriteService.sendMessageToCore(policy,operatecode,handler1code,payNotify.getTransaction_id());
			coreResponseXML = (String)contextFromCore.get(WsConstants.CHAIN_CONTEXT_KEY_WS_EXTERNL_RESPONSE_XML);
		} catch (Exception e) {
			logger.info("3.1、微店向企业号获取保单信息成功后，向核心发送承保报文异常===fmcpPayCode==> " + fmcpPayCode);	
			this.sendPolicynoToFcps(fmcpPayCode, payNotify.getTransaction_id(),payNotify.getOut_trade_no(),payNotify.getAttach(),"orderNo","","2","向核心发送承保报文异常");
			e.printStackTrace();
		}
		
		logger.info("4、 微店承保核心返回承保报文============>"+coreResponseXML);
		//从承保响应报文获取保单号
		String policyno = this.getPolicyno(coreResponseXML);
		logger.info("policyno:"+policyno);
		
		//测试，用8开头模拟正常数据
        //policyno = "800900";
		policy.setPolicyno("微店已经支付承保失败保单");
		if(policyno.startsWith("8")){//"8"开头的是保单号
		logger.info("5、 微店核心承保成功,发送保单信息给企业号======fmcpPayCode======>"+fmcpPayCode+",policyno"+policyno);
			//发送保单号给企业号
			this.sendPolicynoToFcps(fmcpPayCode, payNotify.getTransaction_id(),payNotify.getOut_trade_no(),payNotify.getAttach(),"orderNo",policyno,"1","ok");			
			//更改policy 中的保单号	
			policy.setPolicyno(policyno);
		}else{
			this.sendPolicynoToFcps(fmcpPayCode, payNotify.getTransaction_id(),payNotify.getOut_trade_no(),payNotify.getAttach(),"orderNo","","2","核心承保异常，无保单号 返回");	
		}
	 //保存数据库
	this.savePolicy(policy);		
	} 
	
	private void savePolicy(Policy policy){		
		 ContractAddress contractAddress=policy.getAddressId();
		 contractAddress= contractAddressService.getContractAddress(policy.getPolicyno(),contractAddress.getProvincecode(),contractAddress.getCitycode(),contractAddress.getCountycode(),contractAddress.getInsuredaddress()); //String carRelation,String carRelationname,String carownername,String licenseNo
		 Customer applicant= policy.getApplicant();	
		 applicant= customerService.getCustomer(applicant.getName(),applicant.getIdentifytype(),applicant.getIdentifynumber(),applicant.getGender(),applicant.getBirthday(),applicant.getPhone(),applicant.getAddress(),applicant.getEmail(),applicant.getCarRelation(),applicant.getCarRelationname(),applicant.getCarownername(),applicant.getLicenseno());
		 List<Customer> insuredList =policy.getInsuredList();
		 for (Customer customer:insuredList ){
		    Customer insured= customerService.getCustomer(customer.getName(),customer.getIdentifytype(),customer.getIdentifynumber(),customer.getGender(),customer.getBirthday(),customer.getPhone(),customer.getAddress(),customer.getEmail(),applicant.getCarRelation(),applicant.getCarRelationname(),applicant.getCarownername(),applicant.getLicenseno()); 
		    PolicyInsured  policyInsured =new PolicyInsured(); 
		    policyInsured.setCustomer(insured);
		    policyInsured.setIdentity("1");//  身份 (1、被保人。2、 受益人 )
		    policyInsured.setPolicyno(policy.getPolicyno());
		    policyInsuredService.save(policyInsured);
		   }
		 policy.setApplicant(applicant);
		 policy.setAddressId(contractAddress);
		 policy.setType("2"); //类型为保单
		 policyService.save(policy);
	}
	
	private void sendPolicynoToFcps(String fmcpPayCode,
			String wxPayTransactionId, String outTradeNo, String attach,
			String orderNo, String policyNo, String underwritingStatus,
			String errorMessage){		
		PolicyInfoRequest policyInfoRequest =new PolicyInfoRequest("fmps","fcps","json","25",UUIDGenerator.generate(), fmcpPayCode,
				 wxPayTransactionId,  outTradeNo,  attach,
				 orderNo,  policyNo,  underwritingStatus,
				 errorMessage);
		Context context = null;
		String clientCode = ResourceUtil.getBundleEnvAbout().getString(	"clientCode");
		WebServiceClientManagement WebServiceClientManagement = webServiceClientManagementService
				.findUniqueByProperty(WebServiceClientManagement.class,	"clientCode", clientCode);
		String requestJson = JsonUtil.toJSONString(policyInfoRequest);
		try {
			context = updatePolicyInformation.startExecuteChain(requestJson, WebServiceClientManagement.getToken(), WebServiceClientManagement.getAESKey() , clientCode);			
			String responeJSON=(String) context.get(WsConstants.RESPONSEJSON);		
			logger.info("发送保单号给企业号响应的报文JSON=== " + responeJSON);
			PolicyInfoResponse policy = JsonUtil.parseObject(responeJSON,PolicyInfoResponse.class);
//			if(!policy.getErrcode().equals("00000")){ //报文返回信息不等于“00000”。就表示出错了，需要从发
//				logger.info("发送保单号给企业号");
//			}
			logger.info("发送保单号给企业号成功，保单号："+policyNo);
		} catch (Exception e) {
			logger.info("发送保单号给企业号失败",e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 解析承保响应报文获取保单号policyno
	 * @param coreResponseXML
	 * @return
	 */
	private String getPolicyno(String coreResponseXML){
		Class<UnderwriteResponse> responseClass = UnderwriteResponse.class;
		Annotation annotation = responseClass.getAnnotation(XStreamAlias.class);
		String annotationValue = (String) AnnotationUtils.getValue(annotation);
		UnderwriteResponse coreResponse = (UnderwriteResponse) XmlUtils.fromXML(coreResponseXML,annotationValue,UnderwriteResponse.class);
		
		return coreResponse.getBody().getPolicyno();
	}
	
	private String getFmcpPayCode(Context context){
		String inputJson = (String)context.get(WsConstants.CHAIN_CONTEXT_KEY_WS_INPUTJSON);
		PolicyInfoRequest policyInfoRequest = JsonUtil.parseObject(inputJson,PolicyInfoRequest.class);
		
		return policyInfoRequest.getFmcpPayCode();
	}
	
	/**
	 * 报文发送不不成功，保存报文，后续定时任务从发
	 * @param requestJson
	 */
		private void saveWsInvokeFailureLog( PolicyInfoRequest policyInfoRequest, PolicyInfoResponse policy ) {		
			WsInvokeFailureLog wsInvokeFailureLog= new WsInvokeFailureLog();
			String  orginTranscationSeqNo=policyInfoRequest.getTransactionId();		
			String	transcationSeqNo=UUIDGenerator.generate();
			policyInfoRequest.setTransactionId(transcationSeqNo);
			String internalRequest = JsonUtil.toJSONString(policyInfoRequest);
			String internalResponse = policy!=null?JsonUtil.toJSONString(policy): "链条报文出错误，无返回报文 ";		
			wsInvokeFailureLog.setClientCode("00001");
			wsInvokeFailureLog.setInternalRequest(internalRequest);
			wsInvokeFailureLog.setInternalResponse(internalResponse);
			wsInvokeFailureLog.setReturnCode(policy!=null?policy.getErrcode():"无返回");
			wsInvokeFailureLog.setReturnMessage(policy!=null?policy.getErrmsg():"无返回");
			// 产生新的流水号
			wsInvokeFailureLog.setTranscationSeqNo(transcationSeqNo);
			// 记录原始的上一笔交易流水号
			wsInvokeFailureLog.setOrginTranscationSeqNo(orginTranscationSeqNo);		
			wsInvokeFailureLog.setWsClientBeanName("policyInformationAcquisition"); 
			wsInvokeFailureLog.setStatus(CoreWSConstants.treatment_waiting); // 发送状态 -1 为 待发送
			wsInvokeFailureLog.setSendCount(1); // 发送次数 1
			wsInvokeFailureLog.setNextInvokeTime(new Date()); // 下次发送时间
			wsInvokeFailureLog.setInternalRequestObj(WebServiceUtils.serializeObject(policyInfoRequest));		
			wsInvokeFailureLogService.save(wsInvokeFailureLog);		 
		}
	
}
