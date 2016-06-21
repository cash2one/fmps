/**
 * 
 */
package cn.com.fubon.pay.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jodd.util.StringUtil;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.jeecgframework.core.util.ResourceUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.fubon.pay.entity.PayConfig;
import cn.com.fubon.pay.entity.PayLog;
import cn.com.fubon.pay.entity.WeiXinOfflineOrderInfo;
import cn.com.fubon.pay.service.IPayService;

/**
 * @author qingqu.huang
 *
 */
@Service("payServiceImpl")
@Transactional
public class PayServiceImpl extends CommonServiceImpl implements IPayService {

	private static final Logger logger = Logger.getLogger(PayServiceImpl.class);

	/**
	 * 保存交易记录
	 * 
	 * @param out_trade_no
	 *            保单单号
	 * @param trade_status
	 *            交易结果
	 * @param type
	 *            支付类型
	 */
	public void addPayLog(String out_trade_no, String reqtype,
			String trade_status, String total_fee, String type) {
		PayLog payLog = new PayLog();
		payLog.setOut_trade_no(out_trade_no);
		payLog.setReqtype(reqtype);
		payLog.setResult(trade_status);
		payLog.setTotal_fee(total_fee);
		payLog.setReqtime(new Date());
		payLog.setType(type);
		this.save(payLog);
	}

	/**
	 * 保存保单信息
	 * 
	 */
	@Override
	public void saveOrder() {
		logger.info("保存保单信息...");
	}

	/**
	 * 第三方支付下单获取授权记录
	 * 
	 * @param out_trade_no
	 *            保单单号
	 * @param request_token
	 *            授权
	 * @param sHtmlTextToken
	 *            授权失败错误String(非支付宝String为"错误代码&错误描述")
	 * @param type
	 *            支付方式
	 */
	@Override
	public void saveTokenLog(String out_trade_no, String total_fee,
			String req_data, String request_token, String sHtmlTextToken,
			String type) {
		logger.info("out_trade_no:" + out_trade_no);
		String errcode = "";
		String detail = "";
		PayLog payLog = new PayLog();
		payLog.setOut_trade_no(out_trade_no);
		payLog.setReqtime(new Date());
		payLog.setTotal_fee(total_fee);
		payLog.setType(type);
		payLog.setReqtype("01");
		payLog.setReq_data(req_data);
		if (!StringUtil.isEmpty(request_token)) {
			payLog.setToken(request_token);
			payLog.setResult("success");
		} else {
			String[] strSplitText = sHtmlTextToken.split("&");
			if (!StringUtil.isEmpty(type) && "alipay".equals(type)) {
				Map<String, String> errMap = this.getErrmsg(strSplitText);
				errcode = errMap.get("errcode");
				detail = errMap.get("detail");
			} else {
				errcode = strSplitText[0];
				detail = strSplitText[1];
			}
			payLog.setErrcode(errcode);
			payLog.setErrdetail(detail);
			payLog.setResult("fail");

		}
		this.save(payLog);
	}

	/**
	 * 支付宝获取错误代码和错误描述
	 * 
	 * @param strSplitText
	 * @return
	 */
	public Map<String, String> getErrmsg(String[] strSplitText) {
		Map<String, String> errMap = new HashMap<String, String>();
		// 把切割后的字符串数组变成变量与数值组合的字典数组
		Map<String, String> paraText = new HashMap<String, String>();
		for (int i = 0; i < strSplitText.length; i++) {
			// 获得第一个=字符的位置
			int nPos = strSplitText[i].indexOf("=");
			// 获得字符串长度
			int nLen = strSplitText[i].length();
			// 获得变量名
			String strKey = strSplitText[i].substring(0, nPos);
			// 获得数值
			String strValue = strSplitText[i].substring(nPos + 1, nLen);
			// 放入MAP类中
			paraText.put(strKey, strValue);
		}
		String res_error = paraText.get("res_error");
		try {
			Document document = DocumentHelper.parseText(res_error);
			String errcode = document.selectSingleNode("//err/code").getText();
			String detail = document.selectSingleNode("//err/detail").getText();
			logger.info("错误原因:" + errcode + detail);
			errMap.put("errcode", errcode);
			errMap.put("detail", detail);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return errMap;
	}

	/**
	 * 根据支付方式获取配置信息
	 * 
	 * @param type
	 * @return
	 */
	@Override
	public Map<String, String> getConfigMap(String type) {
		String domain = ResourceUtil.getBundleEnvAbout().getString("domain");
		List<PayConfig> configList = this.findByProperty(PayConfig.class,
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

	/**
	 * 判断投保单是否过期
	 * 
	 * @param weiXinOfflineOrderInfo
	 * @return
	 * @throws Exception
	 */
	public boolean isExpired(String out_trade_no) throws Exception {
		WeiXinOfflineOrderInfo weiXinOfflineOrderInfo = this.getEntity(
				WeiXinOfflineOrderInfo.class, out_trade_no);
		// 参照起保日期来判断当前日期是否过期
		int isEqDate = -1;
		boolean isGtDate = false;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		// 系统当前日期
		String dateSysString = sdf.format(new java.util.Date());
		Date dateSysTemp = sdf.parse(dateSysString);

		if (null != weiXinOfflineOrderInfo.getId()) {
			isGtDate = dateSysTemp.after(weiXinOfflineOrderInfo
					.getPolicyStartDate());
			isEqDate = (dateSysTemp.compareTo(weiXinOfflineOrderInfo
					.getPolicyStartDate()));
		}
		if (isGtDate || isEqDate == 0) {
			return true;
		}
		return false;
	}

}
