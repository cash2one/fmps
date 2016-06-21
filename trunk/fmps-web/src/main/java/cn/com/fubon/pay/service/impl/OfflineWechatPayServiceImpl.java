package cn.com.fubon.pay.service.impl;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.jeecgframework.core.common.dao.impl.GenericBaseCommonDao;
import org.jeecgframework.core.util.UUIDGenerator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.fubon.pay.entity.WeiXinOfflineOrderInfo;
import cn.com.fubon.pay.service.OfflineWechatPayService;
import cn.com.fubon.pay.service.TelesaleWebService;
import cn.com.fubon.util.MD5Utils;
import cn.com.fubon.webservice.redotask.RedoTaskService;

/**
 * 线上微信支付类
 * 
 * @author patrick.z
 */
@SuppressWarnings({ "rawtypes", "unchecked" })
@Service("offlineWechatPayService")
@Transactional
public class OfflineWechatPayServiceImpl extends GenericBaseCommonDao implements
		OfflineWechatPayService {

	@Resource(name = "telesaleWebService")
	private TelesaleWebService telesaleWebService;
	
	//测试
	@Resource(name = "redoTaskService")
	private RedoTaskService redoTaskService;

	private static final Logger logger = Logger
			.getLogger(OfflineWechatPayServiceImpl.class);

	@Override
	public boolean checkOrderByPayCode(String payCode) {
		logger.debug("checkOrderByPayCode(String payCode)" + payCode);
		String sqlString = "";
		if (payCode.length() > 6) {
			sqlString = " SELECT * FROM weixin_offline_orderinfo where paycode_md5 = ? ";
		} else {
			sqlString = " SELECT * FROM weixin_offline_orderinfo where paycode = ? ";
		}
		List<Map<String, Object>> orderInfoList = this.findForJdbc(sqlString,
				new Object[] { payCode });
		logger.debug("checkOrderByPayCode Sql:" + sqlString + "\n");
		if (orderInfoList != null && orderInfoList.size() > 0) {
			logger.debug("have a value");
			return true;
		} else {
			logger.debug("no have a value");
			return false;
		}
	}

	@Override
	public boolean updOrderInfoByOrderIdAndStatus(String orderId, int payStatus) {
		logger.debug("updOrderInfoByPayCode(String orderId)" + orderId);
		String hqlQuery = "update weixin_offline_orderinfo w set w.payStatus = ? where w.id =?";
		logger.debug("updOrderInfoByPayCode hql:" + hqlQuery);
		int rowInt = this.executeSql(hqlQuery,payStatus,orderId);
		if (rowInt >= 1) {
			logger.debug("update success,return value:" + rowInt);
			return true;
		} else {
			logger.debug("update fail,return value:" + rowInt);
			return false;
		}
	}

	@Override
	public void saveOrderInfoLog(String orderId, String payStatus, String errMsg) {
		logger.debug("saveOrderInfoLog(String orderId:" + orderId
				+ ", String payStatus" + payStatus + ", String errMsg:"
				+ errMsg + ")");
		String id = UUIDGenerator.generate();
		String remark = "";
		if (payStatus.equals("success")) {
			payStatus = "1";
			remark = "支付成功！";
		} else {
			payStatus = "2";
			remark = "支付失败！";
		}

		String sql = " insert into weixin_offline_order_log(id,orderinfo_id,Remark,PayStatus,Reason) "
				+ " values (?,?,?,?,?) ";

		this.executeSql(sql, id, orderId, remark, payStatus, errMsg);

	}

	@Override
	public WeiXinOfflineOrderInfo getOrderInfoByPayCode(String payCode)
			throws Exception {
		logger.debug("getOrderInfoByPayCode(String payCode)" + payCode);
		// 检测PayCode
		boolean hasPayCode = this.checkOrderByPayCode(payCode);
		WeiXinOfflineOrderInfo weiXinOfflineOrderInfo = new WeiXinOfflineOrderInfo();
		if (hasPayCode) {
			List list = null;
			if(payCode.length()>6){
				list = this.findByProperty(WeiXinOfflineOrderInfo.class, "paycodemd5", payCode);
			}else{
				list = this.findByProperty(WeiXinOfflineOrderInfo.class, "payCode", payCode);
			}
			
			weiXinOfflineOrderInfo = (WeiXinOfflineOrderInfo) list.get(0);
			return weiXinOfflineOrderInfo;
		} else {
			// db中无订单
			// 调用核心通过验证码获取投保单相关信息方法
			if(payCode.length()==6){
				payCode=MD5Utils.MD5(payCode);
			}
			weiXinOfflineOrderInfo = telesaleWebService.getPayInfo(payCode);
			return weiXinOfflineOrderInfo;
		}
	}

	@Override
	public Map<String, Object> getOrderInfoByDetail(String id) throws Exception {
		Map<String, Object> detailInfo = new LinkedHashMap<String, Object>();
		List<Map<String, String>> detailList = this.findForJdbc("select distinct riskname from weixin_offline_order_detail  where orderinfo_id = ?",id);
		for(Map<String, String> detail : detailList){
			List<Map<String, String>> detailListBydeatail = this.findForJdbc("select distinct KindName,Amount,Premium,riskname,subpremium,RiskKind,Nondeductible,itemname from weixin_offline_order_detail where riskname = ? and orderinfo_id = ?", detail.get("riskname"),id);
			detailInfo.put((String)detail.get("riskname"), detailListBydeatail);
		}
		return detailInfo;
	}
}
