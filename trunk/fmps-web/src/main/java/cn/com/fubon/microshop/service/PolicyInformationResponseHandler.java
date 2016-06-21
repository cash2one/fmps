package cn.com.fubon.microshop.service;


import java.lang.annotation.Annotation;
import java.util.List;

import javax.annotation.Resource;


import org.apache.commons.chain.Context;
import org.apache.log4j.Logger;
import org.jeecgframework.core.util.ResourceUtil;
import org.jeecgframework.core.util.UUIDGenerator;
import org.springframework.core.annotation.AnnotationUtils;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import weixin.popular.util.JsonUtil;
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
import cn.com.fubon.rest.handler.DefaultRestWSResponseHandler;
import cn.com.fubon.rest.service.impl.RestWebServiceClient;
import cn.com.fubon.util.XmlUtils;
import cn.com.fubon.webservice.MainWebServiceClient;
import cn.com.fubon.webservice.WsConstants;
import cn.com.fubon.webservice.externl.coresystemUnderwrite.entity.response.UnderwriteResponse;
import cn.com.fubon.webservice.server.WebServiceClientManagementService;
import cn.com.fubon.webservice.server.entity.WebServiceClientManagement;

public class PolicyInformationResponseHandler extends DefaultRestWSResponseHandler {

	Logger logger = Logger.getLogger(PolicyInformationResponseHandler.class);
	
	@Resource
	private ICustomerService customerService;
	@Resource
	private IPolicyService policyService;
	@Resource
	private IContractAddressService contractAddressService;
	@Resource
	private IPolicyInsuredService policyInsuredService;
	@Resource(name = "coreosWSClientUnderwriteMicroShop")
	private MainWebServiceClient underwriteMicroShopWsClient;
	@Resource
	private CoreUnderwriteService coreUnderwriteService;	
	@Resource(name="updatePolicyInformation")
	private RestWebServiceClient updatePolicyInformation;
	@Resource
	private WebServiceClientManagementService webServiceClientManagementService;

	@Override
	public void process(Context context) throws Exception {
		
/*		logger.info("向企业号获取保单信息，报文返回后处理。    ");
		String responeJSON=(String) context.get(WsConstants.RESPONSEJSON);
		
		//获取交易流水号
		String requestJSON = (String) context.get(WsConstants.CHAIN_CONTEXT_KEY_WS_INPUTJSON);
		PolicyInfoRequest policyInfo = JsonUtil.parseObject(requestJSON,PolicyInfoRequest.class);
		String payserialno = policyInfo.getTransactionId();
		
		PolicyInfoResponse policyInfoResponse = JsonUtil.parseObject(responeJSON,PolicyInfoResponse.class);	
		if(policyInfoResponse.getErrcode().equals("00000")){ //报文返回信息等于“00000”。 成功后处理		
			Policy policy=policyInfoResponse.getPolicy();	
	     //调用核心承保报文 	
			//出单人员
			String operatecode = (policy.getOperateCode() == null ? "" : policy.getOperateCode());
			//归属人员，目前保持跟"出单人员"一致
			String handler1code = operatecode;
			
			Context contextFromCore = coreUnderwriteService.sendMessageToCore(policy,operatecode,handler1code,payserialno);
			String coreResponseXML = (String)contextFromCore.get(WsConstants.CHAIN_CONTEXT_KEY_WS_EXTERNL_RESPONSE_XML);
			logger.info("承保响应报文："+coreResponseXML);
			//从承保响应报文获取保单号
			String policyno = this.getPolicyno(coreResponseXML);
			logger.info("policyno:"+policyno);
			
			//测试，用8开头模拟正常数据
//			policyno = "800900";
			if(policyno.startsWith("8")){//"8"开头的是保单号
				//获取fmcpPayCode
				String fmcpPayCode = this.getFmcpPayCode(context);
				logger.info("fmcpPayCode:"+fmcpPayCode);
				
				//发送保单号给企业号
				this.sendPolicynoToFcps(fmcpPayCode, policyno);
				
				//更改policy 中的保单号	
				policy.setPolicyno(policyno);
			}
		 //保存数据库
		this.savePolicy(policy);			
		}else{			
			  throw new Exception("向企业号获取保单信息失败！");			
		}
		*/
	}
	
	private void savePolicy(Policy policy){		
		 ContractAddress contractAddress=policy.getAddressId();
		 contractAddress= contractAddressService.getContractAddress(policy.getPolicyno(),contractAddress.getProvincecode(),contractAddress.getCitycode(),contractAddress.getCountycode(),contractAddress.getInsuredaddress());
		 Customer applicant= policy.getApplicant();	
		 applicant= customerService.getCustomer(applicant.getName(),applicant.getIdentifytype(),applicant.getIdentifynumber(),applicant.getGender(),applicant.getBirthday(),applicant.getPhone(),applicant.getAddress(),applicant.getEmail(),"","","","");
		 List<Customer> insuredList =policy.getInsuredList();
		 for (Customer customer:insuredList ){
		 Customer insured= customerService.getCustomer(customer.getName(),customer.getIdentifytype(),customer.getIdentifynumber(),customer.getGender(),customer.getBirthday(),customer.getPhone(),customer.getAddress(),customer.getEmail(),"","","",""); 
		 PolicyInsured  policyInsured =new PolicyInsured(); 
		 policyInsured.setCustomer(insured);
		 policyInsured.setIdentity("1");//  身份 (1、被保人。2、 受益人 )
		 policyInsured.setPolicyno(policy.getPolicyno());
		 policyInsuredService.save(policyInsured);
		 policy.setApplicant(applicant);
		 policy.setAddressId(contractAddress);
		 policy.setType("2"); //类型为保单
		 policyService.save(policy);		 
		 }		
		
	}
	
	private void sendPolicynoToFcps(String fmcpPayCode,String policyno){
		PolicyInfoRequest policyInfoRequest =new PolicyInfoRequest("fmps","fcps","json","25",UUIDGenerator.generate(),fmcpPayCode,policyno);
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
			logger.info("发送保单号给企业号成功，保单号："+policyno);
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
	
}
