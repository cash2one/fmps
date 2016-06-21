/**
 * 
 */
package cn.com.fubon.fo.card.service.imp;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.jeecgframework.core.util.StringUtil;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import weixin.util.DateUtils;
import cn.com.fubon.common.entity.occupationtypeEntity.Condition;
import cn.com.fubon.common.entity.occupationtypeEntity.OccupationRequest;
import cn.com.fubon.common.entity.occupationtypeEntity.OccupationRequestBody;
import cn.com.fubon.common.entity.occupationtypeEntity.OccupationRequestHead;
import cn.com.fubon.common.entity.occupationtypeEntity.OccupationResponse;
import cn.com.fubon.fo.card.entity.Card;
import cn.com.fubon.fo.card.entity.Customer;
import cn.com.fubon.fo.card.entity.Policy;
import cn.com.fubon.fo.card.entity.PolicyInsured;
import cn.com.fubon.fo.card.service.ICardWS;
import cn.com.fubon.fo.card.util.CardConstants;
import cn.com.fubon.product.entity.Plan;
import cn.com.fubon.product.service.IProductService;
import cn.com.fubon.util.XmlUtils;
import cn.com.fubon.webservice.commands.cardclient.CardReqAndRep;
import cn.com.fubon.webservice.externl.coresystem.entity.Address;
import cn.com.fubon.webservice.externl.coresystem.entity.Applicant;
import cn.com.fubon.webservice.externl.coresystem.entity.CardRequest;
import cn.com.fubon.webservice.externl.coresystem.entity.CardRequestBody;
import cn.com.fubon.webservice.externl.coresystem.entity.CardRequestSender;
import cn.com.fubon.webservice.externl.coresystem.entity.CardResponse;
import cn.com.fubon.webservice.externl.coresystem.entity.CardResponseBody;
import cn.com.fubon.webservice.externl.coresystem.entity.InsuranceCard;
import cn.com.fubon.webservice.externl.coresystem.entity.Insured;
import cn.com.fubon.webservice.externl.coresystem.entity.Period;
import cn.com.fubon.webservice.externl.coresystem.entity.PolicyRequest;
import cn.com.fubon.webservice.externl.coresystem.entity.PolicyRequestBody;
import cn.com.fubon.webservice.externl.coresystem.entity.PolicyRequestSender;
import cn.com.fubon.webservice.externl.coresystem.entity.PolicyResponse;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * @author qingqu.huang
 *
 */
@Service("ICardWSService")
@Transactional
public class ICardWSImp extends CommonServiceImpl implements ICardWS {
	
	public static final String TRANSTYPE = "request";
	public static final String TRANSCODE = "610004";
	public static final String TRANSCODE_2 = "612001";
	public static final String TRANSCODE_3 = "612002";
	public static final String SIMULATION = "0";
	public static final String BASICDATATYPE = "basicDataType";
	public static final String OCCUPATIONNAME = "occupationName";
	public static final String RESULT_STATUS = "投保";
	public static final String STRUCTURENAME = "钢、钢筋混凝土结构";
	public static final String FROM = "WEIXIN";
	private static final Logger logger = Logger.getLogger(ICardWSImp.class);
	public static final String SEX_1 = "1";	// 1男
	public static final String SEX_2 = "2"; // 2女
	private CardReqAndRep reqAndRep;
	
	@Resource
	private IProductService ProductService;

	/**
	 * 验证卡单是否可以激活
	 * 
	 * @throws IOException
	 * 
	 */
	public CardResponse validateCard(String cardno, String password)
			throws IOException {
		reqAndRep = new CardReqAndRep();
		logger.info("进入验证卡单验证有效性方法..");
		CardRequestSender sender = new CardRequestSender();
		sender.setTransType(TRANSTYPE);
		sender.setTransCode(TRANSCODE_2);
		sender.setSimulation(SIMULATION);
		CardRequestBody body = new CardRequestBody();
		body.setCardNo(cardno);
		body.setCardPasswd(password);
		CardRequest cardRequest = new CardRequest();
		cardRequest.setSender(sender);
		cardRequest.setBody(body);
		String xml = XmlUtils.toXML(cardRequest).toString();
		String responxml = reqAndRep.httpSendReceiver(xml,
				CardConstants.CORE_SYSTEM_PRPAR);
		Class<CardResponse> responseClass = CardResponse.class;
		Annotation annotation = responseClass.getAnnotation(XStreamAlias.class);
		String annotationValue = (String) AnnotationUtils.getValue(annotation);
		CardResponse response = (CardResponse) XmlUtils.fromXML(responxml,
				annotationValue, CardResponse.class);
		// CardPacketPutDB cp=new CardPacketPutDB();
		// cp.writeLog(xml, responxml);
		logger.info("响应报文：" + responxml);
		return response;
	}

	/**
	 * 保存卡单信息
	 */
	public Card saveCard(CardResponse response, String openid) {
		CardResponseBody resbody = response.getBody();

		Card card = this.findUniqueByProperty(Card.class, "card_no",
				resbody.getCardNo());
		if (card != null) {
			card.setCard_no(resbody.getCardNo());
			card.setCard_version_code(resbody.getCardVersionCode());
			card.setEnddate(new Date());
			card.setImputdate(new Date());
			card.setNot_pass_reason(resbody.getNotPassReason());
			card.setOpenid(openid);
			card.setResult_status(RESULT_STATUS);
			card.setStartdate(new Date());
			card.setStatus(resbody.getState());
			card.setValidate(resbody.getValidate());
			card.setComcode(resbody.getComCode());
			card.setComname(resbody.getComName());
			card.setComaddress(resbody.getComAddress());
			this.saveOrUpdate(card);
			return card;

		} else {
			Card card2 = new Card();
			card2.setCard_no(resbody.getCardNo());
			card2.setCard_version_code(resbody.getCardVersionCode());
			card2.setEnddate(new Date());
			card2.setImputdate(new Date());
			card2.setNot_pass_reason(resbody.getNotPassReason());
			card2.setOpenid(openid);
			card2.setResult_status(RESULT_STATUS);
			card2.setStartdate(new Date());
			card2.setStatus(resbody.getState());
			card2.setValidate(resbody.getValidate());
			card2.setComcode(resbody.getComCode());
			card2.setComname(resbody.getComName());
			card2.setComaddress(resbody.getComAddress());
			this.save(card2);
			return card2;
		}

	}
	
	/**
	 * 获取保险终止日期
	 * 
	 * @param period
	 *            保险期限
	 * @param periodType
	 *            保险期限类型
	 * @return
	 */
	public static Date getEndDate(int period, String periodType) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		if ("年".equals(periodType)) {
			calendar.add(Calendar.YEAR, period);
		} else if ("月".equals(periodType)) {
			calendar.add(Calendar.MONTH, period);
		} else {
			calendar.add(Calendar.DAY_OF_MONTH, period);
		}
		return calendar.getTime();
	}

	public static void main(String[] args) {

	}

	/**
	 * 投保报文封装
	 * 
	 * @throws IOException
	 */
	public PolicyResponse sendInsured(Policy policy, String type, PolicyInsured policyInsured)
			throws IOException {
		reqAndRep = new CardReqAndRep();
		logger.info("进入投保报文...");
		PolicyRequestSender sender = new PolicyRequestSender();
		PolicyRequestBody body = new PolicyRequestBody();
		sender.setTransType(TRANSTYPE);
		sender.setTransCode(TRANSCODE_3);
		Applicant applicant = new Applicant();
		applicant.setInsuredname(policy.getApplicant().getName());
		applicant.setEmail(policy.getApplicant().getEmail());
		applicant.setIdentifyNumber(policy.getApplicant().getIdentifynumber());
		applicant.setIdentifyType(policy.getApplicant().getIdentifytype());
		applicant.setPhoneNumber(policy.getApplicant().getPhone());
		if(StringUtil.isNotEmpty( policy.getApplicant().getBirthday())){
			applicant.setBirthday(DateUtils.formatDate(policy.getApplicant().getBirthday()));
			try {
				applicant.setAge(String.valueOf(this.getAge(policy.getApplicant().getBirthday())));
			} catch (Exception e) {
				logger.info("投保人生日计算错误");	 
			}
		}		
		if(StringUtil.isNotEmpty(policy.getApplicant().getGender())&& "F".equals(policy.getApplicant().getGender())){
			applicant.setSex(SEX_2);
		}
		if(StringUtil.isNotEmpty(policy.getApplicant().getGender())&& "M".equals(policy.getApplicant().getGender())){
			applicant.setSex(SEX_1);
		}		
		if (!"".equals(type) && "1".equals(type)) {
			if (!"".equals(policy.getInsuredidentity())
					&& "1".equals(policy.getInsuredidentity())) {
				applicant.setInsuredIdentity("01");
			} else {
				applicant.setInsuredIdentity("99");
			}
		}
		body.setApplicant(applicant);
		InsuranceCard ic = new InsuranceCard();
		ic.setCardno(policy.getCard().getCard_no());
		ic.setCardversioncode(policy.getCard().getCard_version_code());
		ic.setComaddress(policy.getCard().getComaddress());
		ic.setComcode(policy.getCard().getComcode());
		ic.setComname(policy.getCard().getComname());
		ic.setNotpassreason(policy.getCard().getNot_pass_reason());
		ic.setStatus(policy.getCard().getStatus());
		ic.setValidateflag(policy.getCard().getValidate());
		body.setIc(ic);
		List<Customer> insList = policy.getInsuredList();
		List<Insured> insured_list = new ArrayList<Insured>();
		if (insList.size() > 0) {
			for (Customer ctm : insList) {
				Insured is = new Insured();
				is.setEmail(ctm.getEmail());
				is.setIdentifyNumber(ctm.getIdentifynumber());
				is.setIdentifyType(ctm.getIdentifytype());
				is.setInsuredname(ctm.getName());
				is.setPhoneNumber(ctm.getPhone());				
				is.setCarRelation(ctm.getCarRelation());   
				is.setCarRelationname(ctm.getCarRelationname());  
				is.setCarownername(ctm.getCarownername() );   
				is.setLicenseno(ctm.getLicenseno());				
				if(StringUtil.isNotEmpty( ctm.getBirthday())){
					is.setBirthday(DateUtils.formatDate(ctm.getBirthday()));
					try {
						is.setAge(String.valueOf(this.getAge(ctm.getBirthday())));
					} catch (Exception e) {
						logger.info("被保人生日计算错误");	 
					}
					
				}		
				if(StringUtil.isNotEmpty(ctm.getGender())&& "F".equals(policy.getApplicant().getGender())){
					is.setSex(SEX_2);
				}
				if(StringUtil.isNotEmpty(ctm.getGender())&& "M".equals(policy.getApplicant().getGender())){
					is.setSex(SEX_1);
				}
				// 意外险添加职业类型和职业代码
				if (!"".equals(type) && "1".equals(type)) {
					is.setOccupationlevel(policyInsured.getOccupationgrade());
					is.setOccupationcode(policyInsured.getOccupationcode());
				}
				insured_list.add(is);
			}
		}
		body.setInsured_list(insured_list);
		Period period = new Period();
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		period.setStartDate(sf.format(policy.getStartdate()));
		period.setEndDate(sf.format(policy.getEnddate()));
		body.setPeriod(period);
		body.setFrom(FROM);
//根据商品配置参数，判断是否出现标的地址。	
		Plan plan = this.findUniqueByProperty(Plan.class,"coreproductcode", policy.getCard().getCard_version_code());
		String showContractAddress=	ProductService.getProductParameterValue(plan.getProductid(),plan.getId(),"general","showContractAddress");
		if ("Y".equals(showContractAddress)) {
			Address address = new Address();
			if (policy.getAddressId() != null) {
				address.setCitycode(policy.getAddressId().getCitycode());
				address.setCountycode(policy.getAddressId().getCountycode());
				address.setInsuredaddress(policy.getAddressId()
						.getInsuredaddress());
				address.setProvincecode(policy.getAddressId().getProvincecode());
				address.setStructurename(STRUCTURENAME);
				List<Address> addressList = new ArrayList<Address>();
				addressList.add(address);
				body.setAddress(addressList);
			}
		}
		PolicyRequest policyreq = new PolicyRequest();
		policyreq.setSender(sender);
		policyreq.setBody(body);
		String xml = XmlUtils.toXML(policyreq).toString();
		String responxml = reqAndRep.httpSendReceiver(xml,
				CardConstants.CORE_SYSTEM_PRPAR);
		logger.info("响应报文：" + responxml);
		Class<PolicyResponse> responseClass = PolicyResponse.class;
		Annotation annotation = responseClass.getAnnotation(XStreamAlias.class);
		String annotationValue = (String) AnnotationUtils.getValue(annotation);
		PolicyResponse response = (PolicyResponse) XmlUtils.fromXML(responxml,
				annotationValue, PolicyResponse.class);
		return response;
	}

	public Map<String, Object> getProduct(String planid) {
		List<Map<String, Object>> productList = this
				.findForJdbc(
						"select occupationcategory,occupationcode from weixin_product where id in (select productid from weixin_plan where id=?)",
						planid);
		if (productList.size() > 0) {
			return productList.get(0);
		}
		return null;
	}
	
	/**
	 * 被保险人职业类别查询
	 * 
	 * @throws IOException
	 * 
	 */
	public OccupationResponse getOccupationType(String basicDataType, String occupationName,String ip)
			throws IOException {
		reqAndRep = new CardReqAndRep();
		logger.info("获取被保险人职业请求报文..");
		OccupationRequestHead header = new OccupationRequestHead();
		header.setTransType(TRANSTYPE);
		header.setTransCode(TRANSCODE);
		header.setUserIp(ip);
		header.setSimulation(SIMULATION);
		OccupationRequestBody body = new OccupationRequestBody();
		List<Condition> lscd = new ArrayList<Condition>();
		Condition cd = new Condition();
		cd.setKey(BASICDATATYPE);
		cd.setValue(basicDataType);
		Condition cdt = new Condition();
		cdt.setKey(OCCUPATIONNAME);
		cdt.setValue(occupationName);
		lscd.add(cd);
		lscd.add(cdt);
		body.setCondition(lscd);
		OccupationRequest occupationRequest = new OccupationRequest();
		occupationRequest.setHead(header);
		occupationRequest.setBody(body);
		String xml = XmlUtils.toXML(occupationRequest).toString();
		String responxml = reqAndRep.httpSendReceiverOccupation(xml,
				CardConstants.CORE_SYSTEM_PRPAR);
		Class<OccupationResponse> responseClass = OccupationResponse.class;
		Annotation annotation = responseClass.getAnnotation(XStreamAlias.class);
		String annotationValue = (String) AnnotationUtils.getValue(annotation);
		OccupationResponse response = (OccupationResponse) XmlUtils.fromXML(responxml,
				annotationValue, OccupationResponse.class);
		logger.info("获取被保险人职业响应报文：" + responxml);
		return response;
	}

	private  int getAge(Date birthDay) throws Exception {  
        //获取当前系统时间 
        Calendar cal = Calendar.getInstance();  
        //如果出生日期大于当前时间，则抛出异常 
        if (cal.before(birthDay)) {  
            throw new IllegalArgumentException(  
                "The birthDay is before Now.It's unbelievable!");  
        }  
        //取出系统当前时间的年、月、日部分 
        int yearNow = cal.get(Calendar.YEAR);  
        int monthNow = cal.get(Calendar.MONTH);  
        int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH);  
          
        //将日期设置为出生日期 
        cal.setTime(birthDay);  
        //取出出生日期的年、月、日部分   
        int yearBirth = cal.get(Calendar.YEAR);  
        int monthBirth = cal.get(Calendar.MONTH);  
        int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);  
        //当前年份与出生年份相减，初步计算年龄 
        int age = yearNow - yearBirth;  
        //当前月份与出生日期的月份相比，如果月份小于出生月份，则年龄上减1，表示不满多少周岁 
        if (monthNow <= monthBirth) {  
            //如果月份相等，在比较日期，如果当前日，小于出生日，也减1，表示不满多少周岁 
            if (monthNow == monthBirth) {  
                if (dayOfMonthNow < dayOfMonthBirth) age--;  
            }else{  
                age--;  
            }  
        }      
        return age;  
    }  


}
