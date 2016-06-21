package cn.com.fubon.fo.huodong.task;

import java.lang.annotation.Annotation;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import jodd.datetime.JDateTime;
import net.sf.json.JSONObject;

import org.apache.commons.chain.Context;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.util.IdcardUtils;
import org.jeecgframework.core.util.ResourceUtil;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.web.system.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.ContextLoader;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import weixin.guanjia.account.entity.WeixinAccountEntity;
import weixin.guanjia.account.service.WeixinAccountServiceI;
import weixin.popular.api.MessageAPI;
import cn.com.fubon.fo.card.service.ICustomerService;
import cn.com.fubon.fo.card.service.IPolicyInsuredService;
import cn.com.fubon.fo.card.service.IPolicyService;
import cn.com.fubon.fo.huodong.service.LunarNewYearGiftInsuranceService;
import cn.com.fubon.fo.totaiwan.entity.TaiwanConstants;
import cn.com.fubon.microshop.service.CoreUnderwriteService;
import cn.com.fubon.product.service.IProductService;
import cn.com.fubon.util.Constants;
import cn.com.fubon.util.XmlUtils;
import cn.com.fubon.webservice.WsConstants;
import cn.com.fubon.webservice.externl.coresystemUnderwrite.entity.response.UnderwriteResponse;
import cn.com.fubon.fo.card.entity.Customer;
import cn.com.fubon.fo.card.entity.Policy;
import cn.com.fubon.fo.card.entity.PolicyInsured;

/**
 * 春节活动，定时跑批核心承保
 * 
 * @author yaoming.zhang
 *
 */
@Service("lunarNewYearCoreUnderwriteTask")
public class LunarNewYearCoreUnderwriteTask {
	
	private static final Logger logger = Logger.getLogger(LunarNewYearCoreUnderwriteTask.class);
	
	@Resource
	private IPolicyService policyService;	
	@Resource
	private ICustomerService customerService;
	@Resource
	private IPolicyInsuredService policyInsuredService;
	@Resource
	private WeixinAccountServiceI weixinAccountService;
	@Resource
	private LunarNewYearGiftInsuranceService lunarNewYearGiftInsuranceService;
	@Resource
	private CoreUnderwriteService coreUnderwriteService;
	@Resource
	private IProductService ProductService;
	@Autowired
	private SystemService systemService;
	
	public static final String TEMPLATEMESSAGEID = "ga828ebb4881111e01488114371a0003";
	public static final String MESSAGE = "支付发送核心失败！";
	public static final String RETURNCODE_1 = "0000";
	public static final String RETURNCODE_2 = "00000";
	
	/**
	 * 定时跑批
	 */
	public void sendLunarNewYearCoreUnderwrite() {
		logger.info("-------" + new JDateTime(new Date()) + "跑批《春节活动核心承保》" + "-------");
		String activedProfile = ContextLoader.getCurrentWebApplicationContext().getServletContext().getInitParameter("spring.profiles.active");
		double totalamount = 0.00;
		
		//1、 从weixin_gzuserinfo、weixin_huodong_record表获取数据，保存到保单表
		List<Map<String, Object>> list = lunarNewYearGiftInsuranceService.getLunarNewYearGiftInsuranceList();
		for(Map<String, Object> map: list){
			String openid = "";
			try {
				openid = (String)map.get("openid");
				String customercname = (String)map.get("customercname");
				String identifynumber = (String)map.get("identifynumber");
				String mobile = (String)map.get("mobile");
				String huodongid = (String)map.get("huodongid");
				Object totalamountTemp = map.get("totalamount");
				totalamount = Double.parseDouble(totalamountTemp.toString());
				String birthdayTemp = IdcardUtils.getBirthByIdCard(identifynumber);
				String gender = IdcardUtils.getGenderByIdCard(identifynumber);
				
				SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
				Date birthday = format.parse(birthdayTemp);
				
				logger.info("赠险用户信息："+openid + "--" 
						+ customercname + "--"
						+ identifynumber + "--"
						+ mobile + "--"
						+ huodongid + "--"
						+ totalamountTemp + "--" 
						+ birthdayTemp + "--" 
						+ birthday + "--" 
						+ gender);
				
				//1.1、投保人更新或新增
				Customer customer = customerService.getCustomer(customercname, "01", identifynumber, gender, birthday, mobile, "", "","","","","");//更新或新增
				
				//1.2、被保险人更新或新增
				String orderno = UUID.randomUUID().toString();
				logger.info("订单号："+orderno);
				ArrayList<Customer> insuredList = new ArrayList<Customer>();
				PolicyInsured policyInsured = new PolicyInsured();
				policyInsured.setOrderno(orderno);
				policyInsured.setIdentity(TaiwanConstants.INSUREDIDENTITYFLAG_01);
				policyInsured.setCustomer(customer);
				policyInsuredService.save(policyInsured);
				insuredList.add(customer);
				
				//1.3、保存保单表
				Map<String,Object> product = ProductService.getProductInfo("8a8195b3523360c3015233aac8ee001a");
				String periodnum = product.get("period").toString();
				String periodtype = (String)product.get("periodtype");
				String period = "--";
				if(StringUtils.isNotEmpty(periodnum)&&StringUtils.isNotEmpty(periodtype)){
					period = periodnum+"个"+periodtype;
				}
				String premium = product.get("premium").toString();
				JDateTime startdate = new JDateTime("2016-02-01 00:00:00");
				JDateTime enddate = new JDateTime("2016-02-29 23:59:59");
				
				Policy policy = new Policy();
				policy.setPolicyno("");	//保单号
				policy.setPlanid("8a8195b3523360c3015233aac8ee001a");	//计划id:8a8195b3523360c3015233aac8ee001a(个人交通事故意外伤害保险_赠送 意外赠险)
				policy.setType(Constants.TYPE_POLICY_1);	//类型（1、投保单   2保单）
				policy.setCreatetime(new Date());	//创建时间
				policy.setStartdate(startdate.convertToDate());	//保单起始日期
				policy.setEnddate(enddate.convertToDate());	//保单终止日期
				policy.setApplicant(customer);	//投保人
				policy.setInsuredidentity(TaiwanConstants.INSUREDIDENTITYFLAG_01);	//投被保人关系（1、本人2、父母  3、子女 等 ）
				policy.setInsuredList(insuredList);
				policy.setIsbeneficiary("1");	//是否法定受益人
//				policy.setAddressId(null);	//保单标的地址
				policy.setOpenid(openid);	//openid
				policy.setPremium(Double.parseDouble(premium));	//保单原保费
				policy.setOrderno(orderno);	//订单号----------------
				policy.setStatus(TaiwanConstants.POLICYSTATUS_0);	//支付状态（未支付：0；支付成功：1，支付失败:2，取消支付:3）
				policy.setProductid((String)product.get("productid"));	//商品ID
				policy.setProductname((String)product.get("productname"));	//商品名称
				policy.setPeriod(period);	//保障期限
				policy.setPlanname((String)product.get("planname"));	//计划名称
				policy.setOperateCode("");	//出单人员
				policy.setHuodongId(huodongid); //活动id
				policyService.save(policy);
				// 记录系统日志
				systemService.addLogNotRequest("保存赠险保单信息成功(openid:"+openid+")：", Globals.Log_Type_OTHER,Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				// 记录系统日志
				systemService.addLogNotRequest("保存赠险保单信息异常(openid:"+openid+")：", Globals.Log_Type_OTHER,Globals.Log_Leavel_ERROR);
			}
		}
			
		SimpleDateFormat dateFm = new SimpleDateFormat("yyyy年MM月dd日");
		//2、 查询春节活动“未承保成功”的保单表列表
		List<Map<String, Object>> policylist = lunarNewYearGiftInsuranceService.getLunarNewYearPolicyList();
		for(Map<String, Object> tempMap : policylist){
			String orderno = "";
			try {
				orderno = (String)tempMap.get("orderno");
				logger.info("批量春节赠险承保：orderno:"+orderno);
				Policy policy=  policyService.getPolicyByOrderNo(orderno);
				logger.info(policy.getId()+","+policy.getOpenid()+","+(policy.getHuodongId()+","+policy.getPlanid()+","+policy.getPlanname()+","+policy.getProductid()+","+policy.getProductname()));
				//3、发送核心承保
				Context contextFromCore = coreUnderwriteService.sendMessageToCore(policy, "", "", "");
				
				//3.1、获取承保响应报文
				String coreResponseXML = (String)contextFromCore.get(WsConstants.CHAIN_CONTEXT_KEY_WS_EXTERNL_RESPONSE_XML);
				logger.info("赠险商品调用承保后响应报文："+coreResponseXML);
				
				//3.2、从承保响应报文获取保单号
				UnderwriteResponse response = this.getPolicyno(coreResponseXML);
				logger.info("赠险调用调用承保后响应报文的保单号policyno:"+response.getBody().getPolicyno());			
				if(response.getHead().getReturncode().equals(RETURNCODE_1)){	//返回returncode为0000则成功
					//3.3、更新保单号
					policyService.setPolicyNoByOrderNo(orderno, response.getBody().getPolicyno());
					// 记录系统日志
					systemService.addLogNotRequest("承保成功(orderno:"+orderno+")：", Globals.Log_Type_OTHER,Globals.Log_Leavel_INFO);
					/*
					 * 承保成功后：微信推送客户投保成功模板
					 */
					//保单详情地址
					String redirect_uri="{domain}/fo/cardController.do?viewnewdetail&policyNo=POLICYNO";
					redirect_uri=redirect_uri.replace("POLICYNO", response.getBody().getPolicyno());
					String url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid={APPID}&redirect_uri="+URLEncoder.encode(redirect_uri,"UTF-8")+"&response_type=code&scope=snsapi_base&state=STATE#wechat_redirect";
					String domain= ResourceUtil.getDomain();
					url= url.replace("{APPID}", getAppid()).replace("{domain}", domain);
					Map<String, String> messageData = new HashMap<String, String>();
					String total = "¥0.00";
					messageData.put("first", "你好！你已投保成功！");
					messageData.put("keyword1", policy.getProductname());	//产品名称
					messageData.put("keyword2", response.getBody().getPolicyno());	//保单号
					messageData.put("keyword3", total);	//支付金额
					messageData.put("keyword4", dateFm.format(policy.getStartdate())+"0时至"+ dateFm.format(policy.getEnddate())+"24时");	//保险期间
					messageData.put("remark", "");
					logger.info("keyword1="+policy.getProductname()+",keyword2="+response.getBody().getPolicyno() + ",keyword3="+total+",keyword4="+dateFm.format(policy.getStartdate())+"0时至"+ dateFm.format(policy.getEnddate())+"24时");
					logger.info("openid="+policy.getOpenid());
					// 2、发送模板消息
					new MessageAPI().sendTemplateMessage(TEMPLATEMESSAGEID, url,policy.getOpenid(), messageData);
				}else{
					// 记录系统日志
					systemService.addLogNotRequest("承保失败(orderno:"+orderno+")：", Globals.Log_Type_OTHER,Globals.Log_Leavel_ERROR);
				}
			} catch (Exception e) {
				// 记录系统日志
				systemService.addLogNotRequest("承保失败异常(orderno:"+orderno+")：", Globals.Log_Type_OTHER,Globals.Log_Leavel_ERROR);
			}
		}
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
}
