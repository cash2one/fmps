/**
 * 
 */
package cn.com.fubon.fo.cashcoupon.timetask;

import java.net.SocketException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.jeecgframework.core.util.ResourceUtil;
import org.jeecgframework.core.util.oConvertUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.fubon.fo.cashcoupon.service.CashCouponService;

/**
 * 红包定时发送类
 * 
 * @author qingqu.huang
 *
 */
@Service("cashCouponSendTask")
@Transactional
public class CashCouponSendTask {
	private static final Logger logger = Logger
			.getLogger(CashCouponSendTask.class);
	private static final String CERT_NAME = "apiclient_cert";
	private static final String CASHCOUPON_URL = "cashcouponurl";
	@Resource
	private CashCouponService cashCouponServiceImpl;

	public void send() {
		logger.info("定时任务开始发放红包...");
		String huodongid = ResourceUtil.getBundleEnvAbout().getString(
				"cashcouponhuodongid");
		String ip = "";
		try {
			ip = oConvertUtils.getRealIp();
		} catch (SocketException e) {
			logger.error("获取服务器端IP出现异常...", e);
		}
		List<Map<String, Object>> couponList = cashCouponServiceImpl
				.getCouponList(huodongid, ip);
		for (int i = 0; i < couponList.size(); i++) {
			Map<String, Object> cashCouponMap = couponList.get(i);
			int total_amout = Integer.parseInt(String.valueOf(cashCouponMap
					.get("amount")));
			String cashcouponid = (String) cashCouponMap.get("id");
			int seqid = (int) cashCouponMap.get("seqid");
			String openid = (String) cashCouponMap.get("openid");
			String requestxml = cashCouponServiceImpl.getRequestXml(openid, ip,
					total_amout, total_amout, total_amout, 1, huodongid, "1",
					cashcouponid, seqid);
			String cashcouponswift = ResourceUtil.getBundleEnvAbout()
					.getString("cashcouponswift");

			try {
				if ("on".equals(cashcouponswift)) {
					logger.info("调用微信发红包接口");
					cashCouponServiceImpl.sendCashcoupon(requestxml,
							CASHCOUPON_URL, CERT_NAME, openid, huodongid,
							"prod");
				} else {
					logger.info("模拟红包发放");
					cashCouponServiceImpl.sendCashcoupon(requestxml,
							CASHCOUPON_URL, CERT_NAME, openid, huodongid,
							"other");
				}
			} catch (Exception e) {
				cashCouponServiceImpl.updatecashCouponStatus("PREINVOKEFAIL("+e.getMessage()+")", openid, huodongid);
				logger.error("发放红包出现异常...", e);
			}
		}
	}
}
