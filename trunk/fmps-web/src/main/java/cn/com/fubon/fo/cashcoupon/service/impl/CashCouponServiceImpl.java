/**
 * 
 */
package cn.com.fubon.fo.cashcoupon.service.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.net.SocketException;
import java.security.KeyStore;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.annotation.Resource;
import javax.net.ssl.SSLContext;

import jodd.datetime.JDateTime;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.jeecgframework.core.util.ResourceUtil;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.core.util.UUIDGenerator;
import org.jeecgframework.core.util.oConvertUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import weixin.guanjia.account.entity.WeixinAccountEntity;
import weixin.guanjia.account.service.WeixinAccountServiceI;
import weixin.guanjia.core.util.WeixinUtil;
import weixin.idea.huodong.entity.HuodongEntity;
import weixin.popular.util.SignatureUtil;
import weixin.popular.util.XMLConverUtil;
import cn.com.fubon.fo.cashcoupon.entity.CashCoupon;
import cn.com.fubon.fo.cashcoupon.entity.CashCouponEntity;
import cn.com.fubon.fo.cashcoupon.entity.CashCouponResult;
import cn.com.fubon.fo.cashcoupon.entity.CashCouponRule;
import cn.com.fubon.fo.cashcoupon.entity.HbResult;
import cn.com.fubon.fo.cashcoupon.entity.Hbinfo;
import cn.com.fubon.fo.cashcoupon.service.CashCouponService;
import cn.com.fubon.fo.customerbind.entity.WeiXinGzUserInfo;
import cn.com.fubon.pay.entity.PayConfig;
import cn.com.fubon.util.CachedUtils;
import cn.com.fubon.util.XmlUtils;

/**
 * 微信红包发放service
 * 
 * @author qingqu.huang
 *
 */
@Service("cashCouponServiceImpl")
@Transactional
public class CashCouponServiceImpl extends CommonServiceImpl implements
		CashCouponService {

	private Logger logger = Logger.getLogger(CashCouponServiceImpl.class);

	private final String wishing[] = { "大侠好运气，叫上伙伴一起抽红包！",
			 "红包这么多，不信你领不到！" ,"红包到手，天下我有",
			 "红星闪闪亮，照我抢红包!","举头望明月，低头抢红包!",
			 "富邦任性发红包！不抢白不抢！","抢红包，变土壕~"};


	@Resource
	private WeixinAccountServiceI weixinAccountService;

	/**
	 * 发送红包方法
	 * 
	 * @param requestxml
	 *            请求xml
	 * @param url
	 *            微信红包请求url
	 * @param mch_id
	 *            商户号
	 * @param certname
	 *            证书名称
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("deprecation")
	public String post(String requestxml, String url, String certname)
			throws Exception {
		logger.info("调取微信红包接口...");
		KeyStore keyStore = KeyStore.getInstance("PKCS12");
		FileInputStream instream = new FileInputStream(new File(ResourceUtil
				.getBundleEnvAbout().getString(certname)));
		try {
			keyStore.load(instream, ResourceUtil.getMchId().toCharArray());
		} finally {
			instream.close();
		}
		SSLContext sslcontext = SSLContexts
				.custom()
				.loadKeyMaterial(keyStore,
						ResourceUtil.getMchId().toCharArray()).build();
		// Allow TLSv1 protocol only
		SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(
				sslcontext, new String[] { "TLSv1" }, null,
				SSLConnectionSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
		CloseableHttpClient httpclient = HttpClients.custom()
				.setSSLSocketFactory(sslsf).build();
		String result = "";
		try {
			HttpPost httpPost = new HttpPost(url);
			StringEntity reqEntity = new StringEntity(requestxml, "UTF-8"); // 如果此处编码不对，可能导致客户端签名跟微信的签名不一致
			reqEntity.setContentType("application/x-www-form-urlencoded");
			httpPost.setEntity(reqEntity);
			CloseableHttpResponse response = httpclient.execute(httpPost);
			try {
				HttpEntity entity = response.getEntity();
				if (entity != null) {
					BufferedReader bufferedReader = new BufferedReader(
							new InputStreamReader(entity.getContent(), "UTF-8"));
					String text;
					while ((text = bufferedReader.readLine()) != null) {
						result += text;
					}
				}
				EntityUtils.consume(entity);
			} finally {
				response.close();
			}
		} finally {
			httpclient.close();
		}
		return result;
	}

	/**
	 * 获取微信红包请求xml
	 * 
	 * @param openid
	 *            微信用户openid
	 * @param client_ip
	 *            客户端ip
	 * @param mch_billno
	 *            订单号
	 * @param total_amout
	 *            红包金额
	 * @param min_value
	 *            红包最小值
	 * @param max_value
	 *            红包最大值
	 * @param total_num
	 *            红包数量
	 * @param huodongid
	 *            活动编号
	 * @return
	 */
	@Override
	public String getRequestXml(String openid, String client_ip,
			int total_amout, int min_value, int max_value, int total_num,
			String huodongid, String fromtag, String cashcouponid, int seqid) {
		CashCouponEntity cashCouponEntity = this.init(openid, client_ip,
				total_amout, min_value, max_value, total_num, huodongid);
		Map<String, String> mapS = objectToMap(cashCouponEntity,
				new String[] { "sign" });
		String sign = SignatureUtil.generateSign(mapS,
				ResourceUtil.getPartnerKey());
		cashCouponEntity.setSign(sign);
		String requestxml = XmlUtils.toXML(cashCouponEntity, "xml",
				CashCouponEntity.class);
		logger.info("-------------------requestxml：" + requestxml);
		cashCouponEntity.setHuodongid(huodongid);
		cashCouponEntity.setRltime(new Date());
		cashCouponEntity.setFromtag(fromtag);
		cashCouponEntity.setCashcouponid(cashcouponid);
		cashCouponEntity.setStatus("PREINVOKE");
		this.save(cashCouponEntity);
		// this.updateCard(openid, huodongid, seqid);
		return requestxml;
	}

	/**
	 * 重写转换对象为map，剔除值为空
	 * 
	 * @param object
	 * @param ignore
	 * @return
	 */
	public static Map<String, String> objectToMap(Object object,
			String... ignore) {
		Map<String, String> tempMap = new LinkedHashMap<String, String>();
		for (Field f : object.getClass().getDeclaredFields()) {
			if (!f.isAccessible()) {
				f.setAccessible(true);
			}
			boolean ig = false;
			if (ignore != null && ignore.length > 0) {
				for (String i : ignore) {
					if (i.equals(f.getName())) {
						ig = true;
						break;
					}
				}
			}
			if (ig) {
				continue;
			} else {
				Object o = null;
				try {
					o = f.get(object);
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
				if (o != null) {
					tempMap.put(f.getName(), o.toString());
				}
			}
		}
		return tempMap;
	}

	/**
	 * 初始化cashcoupon
	 * 
	 * @param openid
	 * @param client_ip
	 * @param mch_billno
	 * @param total_amout
	 * @return
	 */
	public CashCouponEntity init(String openid, String client_ip,
			int total_amout, int min_value, int max_value, int total_num,
			String huodongid) {
		HuodongEntity huodongEntity = this.getEntity(HuodongEntity.class,
				huodongid);
		List<WeixinAccountEntity> weixinAccountEntityList = weixinAccountService
				.findValidWeixinAccounts();
		WeixinAccountEntity weixinAccountEntity = weixinAccountEntityList
				.get(0);
		String appid = ResourceUtil.getAppid();
		String mch_id = ResourceUtil.getMchId();
		String nonce_str = UUIDGenerator.generate();
		String randnum = RandomStringUtils.random(10, false, true);
		JDateTime d = new JDateTime();
		// 订单号采取商户号+当前时间拼装+10位随机数，防止重复
		String mch_billno = mch_id + d.toString("YYYYMMDD") + randnum;
		CashCouponEntity cashcoupon = new CashCouponEntity();
		cashcoupon.setAct_name(huodongEntity.getTitle());
		cashcoupon.setClient_ip(client_ip);
		cashcoupon.setLogo_imgurl(ResourceUtil.getDomain()
				+ weixinAccountEntity.getLogo_imgurl());
		cashcoupon.setMax_value(max_value);
		cashcoupon.setMch_billno(mch_billno);
		cashcoupon.setMch_id(mch_id);
		cashcoupon.setMin_value(min_value);
		cashcoupon.setNick_name(weixinAccountEntity.getAccountname());
		cashcoupon.setNonce_str(nonce_str);
		cashcoupon.setRe_openid(openid);
		cashcoupon.setRemark(huodongEntity.getDescription());
		cashcoupon.setTotal_amount(total_amout);
		cashcoupon.setSend_name(weixinAccountEntity.getAccountname());
		cashcoupon.setTotal_num(total_num);
		Random rand = new Random();
		int num = rand.nextInt(4);
		cashcoupon.setWishing(this.wishing[num]);
		cashcoupon.setWxappid(appid);
		return cashcoupon;
	}

	/**
	 * 根据openid判断用户是否关注公众号
	 * 
	 * @param openid
	 * @return
	 */
	@Override
	public boolean checkUserByOpenid(String openid) {
		if (!StringUtil.isEmpty(openid)) {
			List<WeiXinGzUserInfo> userList = this.findByProperty(
					WeiXinGzUserInfo.class, "openid", openid);
			if (userList.size() > 0) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 根据活动ID获取未使用的卡
	 * 
	 * @param huodongid
	 *            活動ID
	 * @return
	 */
	@Override
	public List<Map<String, Object>> getCardList(String huodongid) {
		List<Map<String, Object>> cardList = this
				.findForJdbc(
						"select cardno,password from weixin_huodong_card where openid is null and huodongid = ?",
						huodongid);
		return cardList;
	}

	/**
	 * 根据openid和huodongid获取用户领取的红包
	 * 
	 * @param openid
	 * @param huodongid
	 * @return
	 */
	@Override
	public Map<String, Object> getCashCouponMap(String openid, String huodongid) {
		Map<String, Object> cardMap = this
				.findOneForJdbc(
						"select total_amount,status,mch_billno,cashcouponid from weixin_cashcouponhistory where re_openid = ? and huodongid =?",
						openid, huodongid);
		return cardMap;
	}

	/**
	 * 领取赠险
	 * 
	 * @param openid
	 * @param huodongid
	 * @param cardno
	 * @param password
	 */
	@Override
	public void updateCard(String openid, String huodongid, int seqid) {
		List<Map<String, Object>> cardList = this
				.findForJdbc(
						"select cardno,password from weixin_huodong_card where openid =? and huodongid = ?",
						openid, huodongid);
		if (cardList.size() <= 0) {
			int cardnum = seqid - 1;
			Map<String, Object> cardMap = this
					.findOneForJdbc(
							"select cardno,password from weixin_huodong_card where huodongid = ? limit ?,1",
							huodongid, cardnum);
			if (cardMap != null) {
				logger.info("cardno:" + cardMap.get("cardno") + ",openid:"
						+ openid);
				this.executeSql(
						"update weixin_huodong_card set openid=?,receivetime=CURRENT_TIMESTAMP() where cardno=? and password=? and huodongid=?",
						openid, cardMap.get("cardno"), cardMap.get("password"),
						huodongid);
			}
		}
	}

	/**
	 * 判断是否在活动区间
	 * 
	 * @param huodongEntity
	 * @return
	 */
	@Override
	public boolean isRangeOfDate(HuodongEntity huodongEntity) {
		Date starttime = huodongEntity.getStarttime();
		Date endtime = huodongEntity.getEndtime();
		Date nowdate = new Date();
		if (nowdate.after(starttime) && nowdate.before(endtime)) {
			if (!this.checkTime()) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 设置用户手机号
	 * 
	 * @param phonenum
	 * @param opendi
	 */
	@Override
	public void setPhonenumForUser(String phonenum, String openid) {
		this.executeSql(
				"update weixin_gzuserinfo userinfo set userinfo.mobile=? where openid=? ",
				phonenum, openid);
	}

	/**
	 * 根据活动编号获取微信红包领取记录前20条
	 * 
	 * @param huodongid
	 *            活动编号
	 * @return
	 */
	@Override
	public List<Map<String, Object>> getCashHistoryList(String huodongid) {
		List<Map<String, Object>> cashHistoryList = new ArrayList<Map<String, Object>>();
		cashHistoryList = this
				.findForJdbc(
						"select cashcoupon.headimgurl,cashcoupon.nickname,cashcoupon.total_amount,cashcoupon.rltime from (SELECT userinfo.headimgurl,userinfo.nickname, FORMAT(cash.total_amount/100,2) total_amount,cash.rltime FROM weixin_cashcouponhistory cash LEFT JOIN weixin_gzuserinfo userinfo ON cash.re_openid=userinfo.openid WHERE cash.huodongid=? ORDER BY cash.total_amount DESC LIMIT 20) as cashcoupon order by cashcoupon.rltime desc",
						huodongid);
		return cashHistoryList;
	}

	/**
	 * 根据key值获取相关配置信息
	 * 
	 * @param key
	 * @return
	 */
	public Map<String, String> getConfigMap(String key, String huodongid) {
		String domain = ResourceUtil.getBundleEnvAbout().getString("domain");
		List<PayConfig> configList = this.findByProperty(PayConfig.class,
				"type", key);
		List<WeixinAccountEntity> weixinAccountEntityList = weixinAccountService
				.findValidWeixinAccounts();
		WeixinAccountEntity weixinAccountEntity = weixinAccountEntityList
				.get(0);
		Map<String, String> config = new HashMap<String, String>();
		config.put("type", key);
		for (PayConfig payConfig : configList) {
			String value = payConfig.getValue();
			value = value.replace("${WebRoot}", domain).replace("{appid}",
					weixinAccountEntity.getAccountappid());
			value = value.replace("%7Bdomain%7D", domain);
			value = value.replace("{huodongid}", huodongid);
			config.put(payConfig.getKey(), value);

		}
		return config;
	}

	/**
	 * 统计红包发放金额
	 * 
	 * @return
	 */
	@Override
	public int getSum(String huodongid) {
		long sumnum = this
				.getCountForJdbcParam(
						"select sum(history.total_amount) from weixin_cashcouponhistory history where huodongid=?",
						new Object[] { huodongid });

		return (int) sumnum;
	}

	/**
	 * 设置红包发放结果
	 * 
	 * @param returncode
	 * @param openid
	 * @param huodongid
	 */
	@Override
	public void updatecashCouponStatus(String returncode, String openid,
			String huodongid) {
		this.executeSql(
				"update weixin_cashcouponhistory set status=? where re_openid=? and huodongid=? order by rltime limit 1",
				returncode, openid, huodongid);
	}

	/**
	 * 计算该方案已发放红包个数
	 * 
	 * @param maxvalue
	 * @param minvalue
	 * @param huodongid
	 * @return
	 */
	@Override
	public int findHistoryList(Float maxvalue, Float minvalue, String huodongid) {
		// 计算该方案已发放红包个数
		long sumnum = this
				.getCountForJdbcParam(
						"select count(*) from weixin_cashcouponhistory where total_amount<=? and total_amount>=? and huodongid=?",
						new Object[] { maxvalue * 100, minvalue * 100,
								huodongid });
		return (int) sumnum;
	}

	/**
	 * 计算该方案红包个数
	 * 
	 * @param maxvalue
	 * @param minvalue
	 * @param huodongid
	 * @return
	 */
	@Override
	public int getCountNum(String huodongid) {
		long sumnum = this.getCountForJdbcParam(
				"select count(*) from weixin_cashcoupon where huodongid=?",
				new Object[] { huodongid });
		return (int) sumnum;
	}

	/**
	 * 初始化红包
	 * 
	 * @param huodongEntity
	 * @return
	 */
	public void initcashcoupon(HuodongEntity huodongEntity) {
		List<CashCouponRule> ruleList = this.findByProperty(
				CashCouponRule.class, "huodongid", huodongEntity.getId());
		List<CashCoupon> cashcouponList = this.findByProperty(CashCoupon.class,
				"huodongid", huodongEntity.getId());
		if (cashcouponList.size() > 0) {
			return;
		}
		// cashcouponList.removeAll(cashcouponList);
		int total_amount = huodongEntity.getTotalamount() * 100;
		int totalnum = 0; // 发放红包总个数
		Random rand = new Random();
		Map<String, CashCouponRule> map = new HashMap<String, CashCouponRule>();
		int count = 0;
		// 计算红包总数
		for (CashCouponRule cashrule : ruleList) {
			if (StringUtil.isEmpty(cashrule.getPosition())) {
				totalnum += cashrule.getNum();
			}
		}
		int[] temp = new int[totalnum];
		for (CashCouponRule cashrule : ruleList) {
			if (StringUtil.isNotEmpty(cashrule.getPosition())) {
				map.put("must", cashrule);
			} else {
				for (int i = 0; i < cashrule.getNum(); i++) {
					int randnum = rand
							.nextInt((int) (cashrule.getMaxvalue() * 100 - cashrule
									.getMinvalue() * 100) + 1)
							+ (int) (cashrule.getMinvalue() * 100);
					temp[count] = randnum;
					count++;
				}
			}
		}
		int sum = 0;
		int positionnum = 0;
		for (int j = 0; j < temp.length; j++) {
			positionnum = positionnum + 1;
			int amount = temp[rand.nextInt(temp.length)];
			if (amount + sum <= total_amount) {
				CashCoupon cashCoupon = new CashCoupon();
				if (map != null && map.size() > 0) {
					CashCouponRule cashrule = map.get("must");
					String[] positions = cashrule.getPosition().split("_");
					boolean match = false;
					for (int k = 0; k < positions.length; k++) {
						if (positionnum == Integer.parseInt(positions[k])) {
							cashCoupon
									.setAmount((int) (cashrule.getMaxvalue() * 100));
							sum += (int) (cashrule.getMaxvalue() * 100);
							match = true;
							break;
						}
					}
					if (!match) {
						cashCoupon.setAmount(amount);
						sum += amount;
					}
				} else {
					cashCoupon.setAmount(amount);
					sum += amount;
				}
				cashCoupon.setSeqid(positionnum);
				cashCoupon.setHuodongid(huodongEntity.getId());
				this.save(cashCoupon);
			}

		}
	}

	/**
	 * 获取下一个红包id和金额
	 */
	@Override
	public Map<String, Object> getNext(String huodongid) {
		Map<String, Object> nextMap = this
				.findOneForJdbc(
						"SELECT c.id,c.amount FROM weixin_cashcoupon c WHERE NOT EXISTS (SELECT 1 FROM weixin_cashcouponhistory ch WHERE c.id = ch.cashcouponid) and huodongid=? limit 1;",
						huodongid);
		return nextMap;
	}

	/**
	 * 判断当前时间是否在于00:00:00~08:00:00之间
	 * 
	 * @return
	 */
	public boolean checkTime() {
		Date nowtime = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String starttime = sdf.format(nowtime) + " 00:00:00";
		String endtiem = sdf.format(nowtime) + " 08:00:00";
		try {
			if (nowtime.after(sf.parse(starttime))
					&& nowtime.before(sf.parse(endtiem))) {
				return true;
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Map<String, Object>> getNextCouponList(String huodongid,
			int index) {
		List<Map<String, Object>> cashCouponList = new ArrayList<Map<String, Object>>();
		cashCouponList = this
				.findForJdbc(
						"SELECT c.id,c.amount,c.seqid,c.huodongid FROM weixin_cashcoupon c WHERE NOT EXISTS (SELECT 1 FROM weixin_cashcouponhistory ch WHERE c.id = ch.cashcouponid) and huodongid=? limit ?;",
						huodongid, index);
		return cashCouponList;
	}

	/**
	 * 根据红包序列号获取红包数据
	 * 
	 * @param seqid
	 * @return
	 */
	public Map<String, Object> getCashCoupon(int seqid, String huodongid) {
		Map<String, Object> cashCouponMap = this
				.findOneForJdbc(
						"SELECT c.id,c.amount FROM weixin_cashcoupon c WHERE seqid=? and huodongid=?;",
						seqid, huodongid);
		return cashCouponMap;
	}

	/**
	 * 获取红包序列号
	 * 
	 * @param openid
	 * @return
	 */
	public int getSeqid(String openid, String huodongid) {
		String cashcouponkey = huodongid + openid + "sequence";
		String huodongseq = huodongid + "sequence";
		long seq = 0l;
		String seqid = (String) CachedUtils.get(cashcouponkey);
		if (seqid == null) {
			seq = CachedUtils.incr(huodongseq, 1);
			if (seq == -1) {
				long maxid = this
						.getCountForJdbcParam(
								"SELECT MAX(cashcoupon.seqid) FROM weixin_cashcoupon cashcoupon left join weixin_cashcouponhistory history on history.cashcouponid = cashcoupon.id where history.huodongid =?",
								new Object[] { huodongid });
				if (maxid > 0) {
					seq = CachedUtils.incr(huodongseq, 1, maxid + 1);
				} else {
					seq = CachedUtils.incr(huodongseq, 1, 1l);
				}
			}
			CachedUtils.set(cashcouponkey, String.valueOf(seq));
			return (int) seq;
		} else {
			return Integer.parseInt((String) CachedUtils.get(cashcouponkey));
		}
	}

	/**
	 * 获取红包总个数
	 * 
	 * @param huodongid
	 * @return
	 */
	public int getCount(String huodongid) {
		String key = huodongid + "totalnumber";
		String totalnum = (String) CachedUtils.get(key);
		if (totalnum == null) {
			int num = this.getCountNum(huodongid);
			CachedUtils.set(key, String.valueOf(num));
			return num;
		} else {
			return Integer.parseInt(totalnum);
		}
	}

	/**
	 * 通过微信查询红包接口获取红包发放结果
	 * 
	 * @param mch_billno
	 * @param openid
	 * @return
	 */
	public boolean queryCouponResut(String mch_billno, String openid) {
		String nonce_str = UUIDGenerator.generate();
		Hbinfo hbinfo = new Hbinfo();
		hbinfo.setAppid(ResourceUtil.getAppid());
		hbinfo.setBill_type("MCHT");
		hbinfo.setMch_billno(mch_billno);
		hbinfo.setMch_id(ResourceUtil.getMchId());
		hbinfo.setNonce_str(nonce_str);
		Map<String, String> mapS = objectToMap(hbinfo, new String[] { "sign" });
		String sign = SignatureUtil.generateSign(mapS,
				ResourceUtil.getPartnerKey());
		hbinfo.setSign(sign);
		String requestxml = XmlUtils.toXML(hbinfo, "xml", Hbinfo.class);
		try {
			String result = this.post(requestxml, WeixinUtil.HBINFO_URL,
					"apiclient_cert");
			HbResult hbResult = XMLConverUtil.convertToObject(HbResult.class,
					result);
			if (hbResult.getResult_code().equals("SUCCESS")) {
				this.executeSql(
						"update weixin_cashcouponhistory set status='SUCCESS' where mch_billno=?",
						mch_billno);
				return true;
			} else {
				Map<String, Object> couponMap = this
						.findOneForJdbc(
								"select cashcoupon.seqid from weixin_cashcoupon cashcoupon where exists (select 1 from weixin_cashcouponhistory history where history.cashcouponid=cashcoupon.id and history.mch_billno=?) ",
								mch_billno);
				if (couponMap != null) {
					String key = openid + "seqid";
					CachedUtils
							.set(key, String.valueOf(couponMap.get("seqid")));
				}
				this.executeSql(
						"delete from weixin_cashcouponhistory where mch_billno=?",
						mch_billno);
			}
		} catch (Exception e) {
			logger.error("查询红包信息出错...", e);
		}
		return false;
	}

	@Override
	public Map<String, Object> sendCashcoupon(String requestxml, String url,
			String certname, String openid, String huodongid,
			String activedProfile) throws Exception {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		String returncode = "";
		String errorcode = "";
		if ("prod".equals(activedProfile)) {
			String result = this.post(requestxml, WeixinUtil.CASHCOUPON_URL,
					certname);
			logger.info("发送微信红包结果：" + result);
			CashCouponResult cashCouponResult = XMLConverUtil.convertToObject(
					CashCouponResult.class, result);
			returncode = cashCouponResult.getReturn_code();
			errorcode = cashCouponResult.getErr_code_des();
			logger.info("微信红包发送结果代码:" + returncode + ",提示消息"
					+ cashCouponResult.getReturn_msg());
		} else {
			returncode = "SUCCESS";
		}
		if (StringUtil.isNotEmpty(returncode)) {
			resultMap.put("returncode", returncode);
			if ("SUCCESS".equalsIgnoreCase(returncode)) {
				this.updatecashCouponStatus(returncode, openid, huodongid);
			} else {
				this.updatecashCouponStatus(returncode + "(" + errorcode + ")",
						openid, huodongid);
			}
			if ("FAIL".equalsIgnoreCase(returncode)) {
				if (!"".equals(errorcode) && "NOTENOUGH".equals(errorcode)) {
					resultMap.put("message", "手慢了~红包已派送完，请关注下次红包派送活动");

				} else {
					resultMap.put("message", "领取失败，请稍候再试");

				}
			}
		}
		return resultMap;
	}

	/**
	 * 双旦活动-随机领取红包
	 * 
	 * @throws Exception
	 * 
	 * @return可领取返回红包数据，不可领取返回null
	 * @added by qingqu.huang
	 * @Date 2015-12-12
	 */
	public String getCashCouponAmount(String openid, String huodongid)
			throws Exception {
		if (this.getCashCoupon(openid, huodongid) != null) {
			return "";
		}
		HuodongEntity huodongEntity = this.findUniqueByProperty(
				HuodongEntity.class, "id", huodongid);
		if (huodongEntity == null) {
			return "";
		}
		Long receivedAmount = this
				.getCountForJdbcParam(
						"select sum(amount) from weixin_cashcoupon where huodongid=? and date_format(receivetime,'%Y-%m-%d')=curdate();",
						new Object[] { huodongid });
		String everyAmountofcached = (String) CachedUtils.get(huodongid
				+ "everyAmount");
		int everyAmount = 0;
		if (StringUtil.isEmpty(everyAmountofcached)) {
			int numofcashcouponsend = daysBetween(huodongEntity.getStarttime(),
					huodongEntity.getEndtime());
			int totalamount = huodongEntity.getTotalamount() * 100;
			everyAmount = totalamount / numofcashcouponsend;
			CachedUtils.add(huodongid + "everyAmount",
					String.valueOf(everyAmount));
		} else {
			everyAmount = Integer.parseInt(everyAmountofcached);
		}
		if (receivedAmount != null && receivedAmount > everyAmount) {
			return "";
		}
		CashCouponRule rule = this.findUniqueByProperty(CashCouponRule.class,
				"huodongid", huodongid);
		if (rule != null) {
			Random rand = new Random();
			int randnum = rand.nextInt((int) (rule.getMaxvalue() * 100 - rule
					.getMinvalue() * 100) + 1)
					+ (int) (rule.getMinvalue() * 100);
			CashCoupon cashCoupon = new CashCoupon();
			cashCoupon.setAmount(randnum);
			cashCoupon.setHuodongid(huodongid);
			cashCoupon.setOpenid(openid);
			cashCoupon.setReceivetime(new Date());
			try {
				String ip = oConvertUtils.getRealIp();
				cashCoupon.setIp(ip);
			} catch (SocketException e) {
				logger.error("领取红包-获取服务器ip发生异常...", e);
			}
			this.save(cashCoupon);
			return String.valueOf(randnum);
		}
		return "";
	}

	/**
	 * 
	 */
	public Map<String, Object> getCashCoupon(String openid, String huodongid) {
		Map<String, Object> cashCouponMap = this
				.findOneForJdbc(
						"select * from weixin_cashcoupon where openid=? and huodongid=?",
						openid, huodongid);
		return cashCouponMap;
	}

	@Override
	public List<Map<String, Object>> getCouponList(String huodongid, String ip) {
		List<Map<String, Object>> CouponList = this
				.findForJdbc(
						"select * from weixin_cashcoupon cashcoupon where ip=? and huodongid=? and not exists (select 1 from weixin_cashcouponhistory history where history.cashcouponid=cashcoupon.id) ",
						ip, huodongid);
		return CouponList;
	}

	/**
	 * 计算两个日期之间相差的天数
	 * 
	 * @param startdate
	 *            较小的时间
	 * @param enddate
	 *            较大的时间
	 * @return 相差天数
	 * @throws ParseException
	 */
	public static int daysBetween(Date startdate, Date enddate)
			throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		startdate = sdf.parse(sdf.format(startdate));
		enddate = sdf.parse(sdf.format(enddate));
		Calendar cal = Calendar.getInstance();
		cal.setTime(startdate);
		long time1 = cal.getTimeInMillis();
		cal.setTime(enddate);
		long time2 = cal.getTimeInMillis();
		long between_days = (time2 - time1) / (1000 * 3600 * 24);

		return Integer.parseInt(String.valueOf(between_days));
	}
	
	/**
	 * 将用户抽到的红包保存到表中，等待定时任务发送
	 * 
	 * @param amount
	 *           红包金额
	 * @param hdid
	 *            活动ID
	 * @param openid 
	 *            
	 * @return 成功/失败
	 * @throws ParseException
	 */
	@Override
	public boolean saveCouponRecord(String amount,String hdid,String openid){
		CashCoupon cashCoupon = new CashCoupon();
		cashCoupon.setAmount(Double.parseDouble(amount));
		cashCoupon.setHuodongid(hdid);
		cashCoupon.setOpenid(openid);
		cashCoupon.setReceivetime(new Date());
		try {
			String ip = oConvertUtils.getRealIp();
			cashCoupon.setIp(ip);
		} catch (SocketException e) {
			logger.error("领取红包-获取服务器ip发生异常...", e);
			return false;
		}
		this.save(cashCoupon);
		return true;
	}
}
