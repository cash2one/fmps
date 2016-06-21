/**
 * 
 */
package cn.com.fubon.rest.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jodd.util.StringUtil;

import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.service.CommonService;
import org.jeecgframework.core.util.ApplicationContextUtil;
import org.jeecgframework.core.util.ResourceUtil;

import weixin.popular.bean.pay.PayNotify;
import weixin.popular.bean.paymch.UnifiedorderExp;
import cn.com.fubon.pay.entity.Notify;
import cn.com.fubon.pay.entity.PayConfig;
import cn.com.fubon.pay.entity.PaymentConstants;
import cn.com.fubon.pay.entity.WeiXinOfflineOrderInfo;
import cn.com.fubon.rest.service.PaymentSWSService;

import com.alipay.util.AlipaySubmit;

/**
 * @author qingqu.huang
 *
 */
public class PaymentWSServiceImpl extends CommonWebServiceImpl implements
		PaymentSWSService {

	@Override
	public WeiXinOfflineOrderInfo getOrderInfo(String paycode) {
		CommonService commonService = (CommonService) ApplicationContextUtil
				.getContext().getBean("commonService");
		WeiXinOfflineOrderInfo weiXinOfflineOrderInfo = commonService
				.findUniqueByProperty(WeiXinOfflineOrderInfo.class,
						"paycodemd5", paycode);
		return weiXinOfflineOrderInfo;
	}

	@Override
	public Notify getNotify(String out_trade_no) {
		CommonService commonService = (CommonService) ApplicationContextUtil
				.getContext().getBean("commonService");
		Notify notify = commonService.findUniqueByProperty(Notify.class,
				"out_trade_no", out_trade_no);
		return notify;
	}

	@Override
	public String queryAliOrder(String out_trade_no,String paytype) {
		CommonService commonService = (CommonService) ApplicationContextUtil
				.getContext().getBean("commonService");
		Map<String, String> configMap=this.getConfigMap(paytype, commonService);
		String sHtmlText="";
		//把请求参数打包成数组
		Map<String, String> sParaTemp = new HashMap<String, String>();
		sParaTemp.put("service", "single_trade_query");
		sParaTemp.put("partner", configMap.get("partner"));
		sParaTemp.put("_input_charset", configMap.get("charset"));
		sParaTemp.put("trade_no", "");
		sParaTemp.put("out_trade_no", out_trade_no);
		try {
			sHtmlText = AlipaySubmit.buildRequest(PaymentConstants.SINGLETRADEQUERY_GATEWAY,"","",sParaTemp,configMap);
		} catch (Exception e) {
			logger.error("调用单笔交易查询接口失败。。。", e);
		}		
		return sHtmlText;
	}
	
	
	public Map<String, String> getConfigMap(String type,CommonService commonService) {
		String domain = ResourceUtil.getBundleEnvAbout().getString("domain");
		List<PayConfig> configList = commonService.findByProperty(PayConfig.class,
				"type", type);
		Map<String, String> configMap = new HashMap<String, String>();
		configMap.put("type", type);
		for (PayConfig payConfig : configList) {
			String value = payConfig.getValue();
			if (!StringUtil.isEmpty(value) && value.contains("${WebRoot}")) {
				value = value.replace("${WebRoot}", domain);
				configMap.put(payConfig.getKey(), value);
			} else {
				configMap.put(payConfig.getKey(), payConfig.getValue());
			}
		}
		return configMap;
	}

	public List<UnifiedorderExp> isUnifiedOrder(String paycode){
		UnifiedorderExp unifiedorderExp=new UnifiedorderExp();
		CriteriaQuery cq = new CriteriaQuery(UnifiedorderExp.class);		
		cq.like("out_trade_no", paycode+"%");
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, unifiedorderExp);
		cq.add();
		CommonService commonService = (CommonService) ApplicationContextUtil
				.getContext().getBean("commonService");
		List<UnifiedorderExp>  unifiedordeList=commonService.getListByCriteriaQuery(cq, false);
		return unifiedordeList ;			
	}	
	public String queryTransactionid(String paycode ){	
		PayNotify payNotify=new PayNotify();
		CriteriaQuery cq = new CriteriaQuery(PayNotify.class);		
		cq.like("out_trade_no", paycode+"%");
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, payNotify);
		cq.add();
		CommonService commonService = (CommonService) ApplicationContextUtil
				.getContext().getBean("commonService");
		 List<PayNotify>  payNotifyList=commonService.getListByCriteriaQuery(cq, false);
		 if(payNotifyList.size()>0){
			 payNotify= payNotifyList.get(0);
			 return payNotify.getTransaction_id();
		 }else{
			 return "";
		 }	 
	}
}
