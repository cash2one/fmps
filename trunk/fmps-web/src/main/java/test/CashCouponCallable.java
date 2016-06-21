/**
 * 
 */
package test;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import jodd.datetime.JDateTime;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.log4j.Logger;
import org.jeecgframework.core.util.ResourceUtil;
import org.jeecgframework.core.util.StringUtil;

import weixin.idea.huodong.entity.HuodongEntity;
import cn.com.fubon.fo.cashcoupon.entity.CashCouponRule;
import cn.com.fubon.fo.cashcoupon.service.CashCouponService;
import cn.com.fubon.util.CachedUtils;

/**
 * @author fbxmn06
 *
 */
public class CashCouponCallable implements Runnable {

	private String huodongid;
	private CashCouponService cashCouponServiceImpl;
	private Logger logger = Logger.getLogger(CashCouponCallable.class);

	public CashCouponCallable(String huodongid,
			CashCouponService cashCouponServiceImpl) {
		this.huodongid = huodongid;
		this.cashCouponServiceImpl = cashCouponServiceImpl;
	}

	/**
	 * 获取红包金额
	 * 
	 * @param huodongEntity
	 * @return
	 */
	public synchronized int getAmount(HuodongEntity huodongEntity, boolean lock) {
		int total = 0;
		total = cashCouponServiceImpl.getSum(huodongEntity.getId());
		int dbtotal = huodongEntity.getTotalamount() * 100;
		if (total >= dbtotal) {
			return 0;
		}
		int amount = 1; // 红包金额
		int randnum = 0; // 随机金额
		int count = 0; // 用于计数
		int totalnum = 0; // 发放红包总个数
		int[] tmp = new int[1000];
		Random rand = new Random();
		List<CashCouponRule> ruleList = cashCouponServiceImpl.findByProperty(
				CashCouponRule.class, "huodongid", huodongEntity.getId());
		// 计算红包总数
		for (CashCouponRule cashrule : ruleList) {
			totalnum += cashrule.getNum();
		}
		for (CashCouponRule cashrule : ruleList) {
			// 已发放红包总数
			int num = cashCouponServiceImpl.findHistoryList(
					cashrule.getMaxvalue(), cashrule.getMinvalue(),
					huodongEntity.getId());
			int proportion = Math.round(cashrule.getNum() * 1000 / totalnum);
			if (StringUtil.isNotEmpty(cashrule.getPosition())) {
				proportion = 0;
				if (lock) {
					amount = (int) (cashrule.getMaxvalue() * 100);
					CachedUtils.set("lock", "0");
					return amount;
				}
			}
			for (int i = 0; i < proportion; i++) {
				if (!"".equals(cashrule.getNum()) && num >= cashrule.getNum()) {
					randnum = 0;
				} else {
					randnum = rand
							.nextInt((int) (cashrule.getMaxvalue() * 100 - cashrule
									.getMinvalue() * 100) + 1)
							+ (int) (cashrule.getMinvalue() * 100);
				}
				tmp[count] = randnum;
				count++;
			}
		}
		if (amount == 1) {
			amount = tmp[rand.nextInt(tmp.length)];
		}
		// 如果取到已发完的，重取
		while (amount == 0) {
			amount = tmp[rand.nextInt(tmp.length)];
		}
		return amount;
	}

	public synchronized boolean lock(HuodongEntity huodongEntity) {
		List<CashCouponRule> ruleList = cashCouponServiceImpl.findByProperty(
				CashCouponRule.class, "huodongid", huodongEntity.getId());
		int sendednum = cashCouponServiceImpl
				.getCountNum(huodongEntity.getId());
		logger.info("数据库中已发放红包数：" + sendednum);
		String sended = (String) CachedUtils.get("sendnuer");
		logger.info("memcached中已发放红包数：" + sended);
		if (StringUtil.isNotEmpty(sended)) {
			int send = Integer.parseInt(sended);
			if (sendednum <= send) {
				return false;

			}
			CachedUtils.set("sendnuer", String.valueOf(sendednum));
			for (CashCouponRule cashrule : ruleList) {
				if (StringUtil.isNotEmpty(cashrule.getPosition())) {
					String[] positions = cashrule.getPosition().split("_");
					for (int k = 0; k < positions.length; k++) {
						int temp = Integer.parseInt(positions[k]);
						if (temp == sendednum) {
							CachedUtils.set("lock", "1");
							return true;
						}
					}

				}
			}
		} else {
			CachedUtils.add("sendnuer", "1");
		}
		return false;
	}

	@Override
	public void run() {
		String openid = "";
		openid = UUID.randomUUID().toString().substring(0, 30);
		//cashCouponServiceImpl.updateCard(openid, huodongid);
		String client_ip = "127.0.0.1";
		String mch_id = ResourceUtil.getMchId();
		String randnum = RandomStringUtils.random(10, false, true);
		JDateTime d = new JDateTime();
		// 订单号采取商户号+当前时间拼装+10位随机数，防止重复
		String mch_billno = mch_id + d.toString("YYYYMMDD") + randnum;
		int total_amout = 0;
		HuodongEntity huodongEntity = cashCouponServiceImpl.getEntity(
				HuodongEntity.class, huodongid);
		String cashcouponid = "";
		// 1、加锁
		while (!CachedUtils.add("lock", "1")) {
			try {
				TimeUnit.MICROSECONDS.sleep(10);
			} catch (InterruptedException e) {
			}
		}

		// 2、取红包记录
		try {
			int total = 0;
			total = cashCouponServiceImpl.getSum(huodongEntity.getId());
			int dbtotal = huodongEntity.getTotalamount() * 100;
			if (total >= dbtotal) {
				logger.info("++++++++++++++++++++++++++++++++++++红包派送完了....");
			} else {
				Map nextMap = cashCouponServiceImpl.getNext(huodongid);
				total_amout = (int) nextMap.get("amount");
				cashcouponid = (String) nextMap.get("id");
//				String requestxml = cashCouponServiceImpl.getRequestXml(openid,
//						client_ip, mch_billno, total_amout, total_amout,
//						total_amout, 1, huodongid, "1", cashcouponid);
			//	logger.info("requestxml:" + requestxml);
				String returncode = "";
				returncode = "SUCCESS";
				if (!"".equals(returncode)) {
					cashCouponServiceImpl
							.executeSql(
									"update weixin_cashcouponhistory set status=? where re_openid=? and huodongid=?",
									returncode, openid, huodongid);
					if ("FAIL".equalsIgnoreCase(returncode)) {
					}
				}
			}
		} catch (Exception e) {
			logger.info("发放红包出现异常," + e.getMessage());
		} finally {
			// 3、解锁
			CachedUtils.delete("lock");
		}
	}

}
