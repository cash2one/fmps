package cn.com.fubon.microshop.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import javax.annotation.Resource;

import jodd.datetime.JDateTime;

import org.apache.commons.chain.Context;
import org.apache.log4j.Logger;
import org.jeecgframework.core.util.ResourceUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import cn.com.fubon.fo.card.entity.Customer;
import cn.com.fubon.fo.card.entity.Policy;
import cn.com.fubon.fo.huodong.service.LunarNewYearGiftInsuranceService;
import cn.com.fubon.product.service.IPlanService;
import cn.com.fubon.util.ShortUUID;
import cn.com.fubon.util.XmlUtils;
import cn.com.fubon.webservice.MainWebServiceClient;
import cn.com.fubon.webservice.WsConstants;
import cn.com.fubon.webservice.entity.request.FbCoreUnderwriteRequestBody;
import cn.com.fubon.webservice.entity.request.FbCoreUnderwriteRequestHead;
import cn.com.fubon.webservice.entity.request.FbWSRequest;
import cn.com.fubon.webservice.externl.coresystemUnderwrite.entity.request.Address;
import cn.com.fubon.webservice.externl.coresystemUnderwrite.entity.request.Applicant;
import cn.com.fubon.webservice.externl.coresystemUnderwrite.entity.request.Application;
import cn.com.fubon.webservice.externl.coresystemUnderwrite.entity.request.Appmaininfo;
import cn.com.fubon.webservice.externl.coresystemUnderwrite.entity.request.Beneficiary;
import cn.com.fubon.webservice.externl.coresystemUnderwrite.entity.request.Insurant;

/**
 * 核心承保服务类
 * 
 */
@Service("coreUnderwriteService")
@Transactional
public class CoreUnderwriteService {
	
	Logger logger = Logger.getLogger(PolicyInformationResponseHandler.class);
	
	@Resource(name = "coreosWSClientUnderwriteMicroShop")
	private MainWebServiceClient underwriteMicroShopWsClient;
	@Resource
	private IPlanService planService;
	@Resource
	private LunarNewYearGiftInsuranceService lunarNewYearGiftInsuranceService;

	public Context sendMessageToCore(Policy policy,String operatecode,String handler1code,String payserialno) throws Exception {
		logger.info("进入核心承保系统.........."+
				"\r\n交易流水号："+payserialno);
		
		//通过policy.getPlanid()查询weixin_plan获取coreproductcode、salemode、operatecode、handler1code、channeltype、businessnature
		StringBuffer sb = new StringBuffer();
		sb.append("	select p.coreproductcode as coreproductcode, ");
		sb.append("	       product.salemode as salemode, ");
		sb.append("	       config.operatecode as operatecode, ");
		sb.append("	       config.handler1code as handler1code, ");
		sb.append("	       config.channeltype as channeltype, ");
		sb.append("	       config.businessnature as businessnature ");
		sb.append("	  from weixin_plan               p, ");
		sb.append("	       weixin_product            product, ");
		sb.append("	       weixin_salechannel_config config ");
		sb.append("	 where p.id = ? ");
		sb.append("	   and p.productid = product.id ");
		sb.append("	   and product.salemode = config.salemode ");
		Map<String, Object> map = planService.findOneForJdbc(sb.toString(), new String[]{policy.getPlanid()});
		
		//合作站点(微信服务号:01;微信企业号:02)
		String site = "";
		String salemode = (String) map.get("salemode");
		if ("2".equalsIgnoreCase(salemode)) {	//微信销售方式：2
			site = "01";
		} else if ("1".equalsIgnoreCase(salemode)) {	//微店销售方式：1
			site = "02";
		} else if ("3".equalsIgnoreCase(salemode)) {	//赠险销售方式：3(微信)
			site = "01";
		}
		
		//保费
		double rate = 1.00;//折扣后保费，默认1.00（没折扣）
		double premium = policy.getPremium();
		double discountPremium = premium*rate;
		
		//coreproductcod:27210001(赠险)-> 销售方式为3， 销售渠道为09，业务来源为99，交易流水号为空，premium为0.0，保额累积，支付方式AUTOTRANSRENEWFLAG传9
		String autotransrenewflag = "";
		double amount = 0.00;
		
		if("3".equalsIgnoreCase(salemode)){
			payserialno = "";
			Map<String,Object> temp = lunarNewYearGiftInsuranceService.getTotalAmount(policy.getHuodongId(), policy.getOpenid());
			amount = Double.parseDouble(temp.get("totalamount").toString());
			//最高保额10万
			double topamount = 100000.00; 
			BigDecimal data1 = new BigDecimal(amount); 
			BigDecimal data2 = new BigDecimal(topamount); 
			amount = data1.compareTo(data2)>=0 ? topamount : amount;
			autotransrenewflag = "9";
		}else{
			amount = 0.00;
			autotransrenewflag = "10";
		}
				
		//报文head
		FbCoreUnderwriteRequestHead head = new FbCoreUnderwriteRequestHead();			
		head.setClientCode(site); //发送给核心承保报
		head.setServerCode(WsConstants.REQUEST_HEAD_KEY_SERVER_CODE_CORE);
		head.setTranscationCode(WsConstants.REQUEST_HEAD_KEY_TRANSATION_CODE_PRP01);
		head.setTranscationDate(new JDateTime(new Date()).toString("YYYY-MM-DD hh:mm:ss"));
		head.setTranscationTime(new JDateTime(new Date()).toString("YYYY-MM-DD hh:mm:ss"));
		head.setTranscationSeqNo(site+ShortUUID.generate()); //交易流水号 
		head.setUser("");
		head.setPassword("");
		
		Appmaininfo appmaininfo = new Appmaininfo();
		appmaininfo.setRiskcode("");//险种
		appmaininfo.setProductcode((String)map.get("coreproductcode"));//产品代码
		appmaininfo.setIsaddtional("");//是否投保附加险
		appmaininfo.setStartdate(new JDateTime(policy.getStartdate()).toString("YYYY-MM-DD"));//起保日期
		appmaininfo.setStarthour("0");//起保小时
		appmaininfo.setEnddate(new JDateTime(policy.getEnddate()).toString("YYYY-MM-DD"));//终保日期
		appmaininfo.setEndhour("24");//终保小时
		appmaininfo.setPeriod("");//保险期限
		appmaininfo.setAppnum("1");//投保份数
		appmaininfo.setInsurednum(Integer.toString(policy.getInsuredList().size()));//被保险人数
		appmaininfo.setTraveldestination("");//旅游目的地
		appmaininfo.setRate(String.format("%.2f", rate));//折扣率,保留2位小数
		appmaininfo.setAmount(String.format("%.2f", amount));//保额
		appmaininfo.setPremium(String.format("%.2f", premium));//保单原保费,保留2位小数
		appmaininfo.setDiscountpremium(String.format("%.2f", discountPremium));//折扣后保费,保留2位小数
		appmaininfo.setAutotransrenewflag(autotransrenewflag);//付款方式
		appmaininfo.setAgentcode("");//代理人
		appmaininfo.setAgreementno("");//代理协议
		appmaininfo.setOperatecode(operatecode.equalsIgnoreCase("")?(String)map.get("operatecode"):operatecode);//出单人员
		appmaininfo.setHandler1code(handler1code.equalsIgnoreCase("")?(String)map.get("handler1code"):handler1code);//归属人员
		appmaininfo.setChanneltype((String)map.get("channeltype"));//销售渠道
		appmaininfo.setBusinessnature((String)map.get("businessnature"));//业务来源
		appmaininfo.setPayserialno(payserialno);//交易流水号
		appmaininfo.setOrderNo("");
		appmaininfo.setAgencyTransacTionNO("");
		appmaininfo.setPolicyNo("");
		appmaininfo.setJobUnit("");
		appmaininfo.setComCode("");
		appmaininfo.setJfeeFlag("");
		appmaininfo.setOperateDate(new JDateTime(new Date()).toString("YYYY-MM-DD hh:mm:ss"));
		//投保人
		Customer policyApplicant = policy.getApplicant();
		Applicant applicant = new Applicant();
		applicant.setAppliName(policyApplicant.getName());
		applicant.setIdCode(policyApplicant.getIdentifynumber());//证件代码
		applicant.setIdType(policyApplicant.getIdentifytype());//证件类型
		applicant.setIdperiod("");//证件有效期
		applicant.setBirthday(new JDateTime(policyApplicant.getBirthday()).toString("YYYY-MM-DD"));
		applicant.setSex(policyApplicant.getGender().toUpperCase().equalsIgnoreCase("M")?"1":"2");
		applicant.setAge(getAge(policyApplicant.getBirthday()));
		applicant.setTelephone(policyApplicant.getPhone());
		applicant.setMobile(policyApplicant.getPhone());
		applicant.setEmail(policyApplicant.getEmail());
		applicant.setAddress(policyApplicant.getAddress());
		applicant.setZipcode("");
		
		//被保险人
		List<Insurant> insurantlist = new ArrayList<Insurant>();
		for(Customer insurant : policy.getInsuredList()){
			Insurant insurantTemp = new Insurant();
			insurantTemp.setInsuredName(insurant.getName());
			insurantTemp.setIdCode(insurant.getIdentifynumber());
			insurantTemp.setIdType(insurant.getIdentifytype());
			insurantTemp.setJobunit(insurant.getSchool());
			insurantTemp.setDepartment(insurant.getDepartment());
			insurantTemp.setStudentNo(insurant.getStudentNo());
			insurantTemp.setIdperiod("");
			insurantTemp.setRelation(policy.getInsuredidentity());//投保人与被保险人关系
			insurantTemp.setOccupationCode(insurant.getOccupationcode());//职业类别
			insurantTemp.setBirthday(new JDateTime(insurant.getBirthday()).toString("YYYY-MM-DD"));
			insurantTemp.setSex(insurant.getGender().toUpperCase().equalsIgnoreCase("M")?"1":"2");
			insurantTemp.setAge(getAge(insurant.getBirthday()));
			insurantTemp.setTelephone(insurant.getPhone());
			insurantTemp.setMobile(insurant.getPhone());
			insurantTemp.setEmail(insurant.getEmail());
			insurantTemp.setAddress(insurant.getAddress());
			insurantTemp.setZipCode("");
			insurantTemp.setBeway("04");//受益方式(目前这个都是法定，就没有这个节点了。后续有可能有指定收益人)

			//受益人信息。没有，也需要传递空标签
			Beneficiary beneficiary = new Beneficiary();
			beneficiary.setBenefName("");
			beneficiary.setIdCode("");
			beneficiary.setIdType("");
			beneficiary.setIdperiod("");
			beneficiary.setRelation("");
			beneficiary.setBenefitrate("");
			beneficiary.setBirthday("");
			beneficiary.setSex("");
			beneficiary.setAge("");
			beneficiary.setTelephone("");
			beneficiary.setMobile("");
			beneficiary.setEmail("");
			beneficiary.setAddress("");
			beneficiary.setZipcode("");
			List<Beneficiary> beneficiaryList = new ArrayList<Beneficiary>();
			beneficiaryList.add(beneficiary);
			insurantTemp.setBeneficiaryList(beneficiaryList);
			
			//标的地址。没有，也需要传递空标签
			Address address = new Address();
			address.setAddressCode("");
			address.setAddressName("");
			address.setProvinceCode("");
			address.setProvinceName("");
			address.setCityCode("");
			address.setCityName("");
			address.setDistrictCode("");
			address.setDistrictName("");
			address.setStructureCode("");
			address.setStructureName("");
			List<Address> addressList = new ArrayList<Address>();
			addressList.add(address);
			insurantTemp.setAddressList(addressList);
			
			insurantlist.add(insurantTemp);
		}
		
		Application application = new Application();
		application.setAppmaininfo(appmaininfo);
		application.setApplicant(applicant);
		application.setInsurant(insurantlist);
		
		FbCoreUnderwriteRequestBody body = new FbCoreUnderwriteRequestBody();
		body.setApplication(application);
		
		FbWSRequest request = new FbWSRequest();
		request.setRequestHead(head);
		request.setRequestBody(body);
	
		// java对象转xml
		logger.info("发送给核心承保报文："+XmlUtils.toXML(request).toString());
		
		underwriteMicroShopWsClient.setRequest(request);
		return underwriteMicroShopWsClient.startExecuteChain();
	}
	
	/**
	 * 根据用户生日计算年龄
	 */
	public static String getAge(Date birthday) {
		Calendar cal = Calendar.getInstance();

		if (cal.before(birthday)) {
			throw new IllegalArgumentException("The birthDay is before Now.It's unbelievable!");
		}

		int yearNow = cal.get(Calendar.YEAR);
		int monthNow = cal.get(Calendar.MONTH) + 1;
		int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH);

		cal.setTime(birthday);
		int yearBirth = cal.get(Calendar.YEAR);
		int monthBirth = cal.get(Calendar.MONTH) + 1;
		int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);

		int age = yearNow - yearBirth;

		if (monthNow <= monthBirth) {
			if (monthNow == monthBirth) {
				// monthNow==monthBirth 
				if (dayOfMonthNow < dayOfMonthBirth) {
					age--;
				}
			} else {
				// monthNow>monthBirth 
				age--;
			}
		}
		return String.valueOf(age);
	}

	/**
	 * 通过key获取dbconfig-*.properties的value值
	 * 
	 * @param key
	 * @return
	 */
	public String getValue(String key) {
		ResourceBundle resourceBundle = ResourceUtil.getBundleEnvAbout();
		return resourceBundle.getString(key);
	}
}
