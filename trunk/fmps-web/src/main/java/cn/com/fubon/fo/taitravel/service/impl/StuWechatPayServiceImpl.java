package cn.com.fubon.fo.taitravel.service.impl;

import java.util.Map;

import javax.annotation.Resource;

import jodd.datetime.JDateTime;

import org.apache.log4j.Logger;
import org.jeecgframework.core.util.ResourceUtil;
import org.jeecgframework.core.util.UUIDGenerator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import weixin.guanjia.account.service.WeixinAccountServiceI;
import weixin.popular.api.PayMchAPI;
import weixin.popular.bean.pay.PayNotify;
import weixin.popular.bean.paymch.Closeorder;
import weixin.popular.bean.paymch.MchBaseResult;
import weixin.popular.bean.paymch.Unifiedorder;
import weixin.popular.bean.paymch.UnifiedorderResult;
import weixin.popular.util.MapUtil;
import weixin.popular.util.PayUtil;
import weixin.popular.util.SignatureUtil;
import cn.com.fubon.fo.taitravel.service.StuWechatPayService;
import cn.com.fubon.pay.service.WechatUnifiedOrder;
import cn.com.fubon.pay.service.WechatUnifiedOrderResult;
import cn.com.fubon.util.XmlUtils;

/**
 * 微信支付
 * 
 * @author guojunjie
 *
 */
@Service("stuWechatPayServiceImpl")
@Transactional
public class StuWechatPayServiceImpl implements StuWechatPayService {
	private static final Logger logger = Logger
			.getLogger(StuWechatPayServiceImpl.class);
	@Resource
	private WechatUnifiedOrder wechatUnifiedOrderImpl;
	@Resource
	private WechatUnifiedOrderResult wechatUnifiedOrderResultImpl;
	@Resource
	private WeixinAccountServiceI weixinAccountService;

	protected String appid = ""; // 微信分配的公众账号ID
	protected String mch_id = ""; // 微信支付分配的商户号 10025677
	protected String PartnerKey = "26231f2420ff303c61682439165448f1"; // 初始密钥

	protected String nonce_str = UUIDGenerator.generate(); // 随机字符串，不长于32 位
	protected String notify_url = "http://localhost:8080/fmps/payNotifyController.do?payNotify"; // 接收微信支付成功通知

	protected String trade_type = "JSAPI"; // JSAPI、NATIVE、APP
	protected String sign = ""; // 签名,详细签名方法见3.2 节

	protected String openid = ""; // 用户在商户appid下的唯一标识
	protected String body = ""; // 商品描述
	protected String out_trade_no = ""; // 商户系统内部的订单号,32 个字符内、可包含字母,确保 在商户系统唯一.
	protected String total_fee = ""; // 订单总金额，单位为分，不能带小数点
	protected String spbill_create_ip = ""; // 订单生成的机器IP
	protected String attach = ""; // 附加数据，原样返回

	protected String device_info = ""; // 微信支付分配的终端设备号
	protected String time_start = ""; // 订单生成时间， 格式为yyyyMMddHHmmss
	protected String time_expire = ""; // 订单失效时间， 格式为yyyyMMddHHmmss

	/**
	 * 初始化数据
	 * 
	 */
	protected Unifiedorder init(String openid, String body,
			String out_trade_no, String total_fee, String spbill_create_ip,
			String attach) {
		Unifiedorder unifiedorder = new Unifiedorder();

		appid = ResourceUtil.getAppid();// "wxeee8b84bc1946b90";
		mch_id = ResourceUtil.getMchId();
		PartnerKey = ResourceUtil.getPartnerKey();
		JDateTime d = new JDateTime();
		time_start = d.toString("YYYYMMDDhhmmss");
		time_expire = d.addDay(3).toString("YYYYMMDDhhmmss"); // 订单3天后失效
		notify_url = ResourceUtil.getDomain() + "/TaiPayNotifyServlet"; // 接收微信支付成功通知
		unifiedorder.setAppid(appid);
		unifiedorder.setAttach(attach);
		unifiedorder.setBody(body.length() > 30 ? body.substring(0, 30) + "..."
				: body);
		unifiedorder.setDevice_info(device_info);
		unifiedorder.setMch_id(mch_id);
		unifiedorder.setNonce_str(nonce_str.substring(5, 16));// 据网上说这个字段太长会支付失败
		unifiedorder.setNotify_url(notify_url);
		unifiedorder.setOpenid(openid);
		unifiedorder.setOut_trade_no(out_trade_no);
		unifiedorder.setSpbill_create_ip(spbill_create_ip);
		unifiedorder.setTime_expire(time_expire);
		unifiedorder.setTime_start(time_start);
		unifiedorder.setTrade_type(trade_type);
		unifiedorder.setTotal_fee(total_fee);
		wechatUnifiedOrderImpl.save(unifiedorder); // 下单前先保存实体
		return unifiedorder;
	}

	/**
	 * 生成统一支付订单
	 * 
	 * @param unifiedorder
	 * @return
	 */

	protected UnifiedorderResult payUnifiedorder(Unifiedorder unifiedorder) {
		// 对象转换MAP
		Map<String, String> mapS = MapUtil.objectToMap(unifiedorder,
				new String[] { "sign" });
		// 签名
		String sign = SignatureUtil.generateSign(mapS, PartnerKey);
		unifiedorder.setSign(sign);
		PayMchAPI payMchAPI = new PayMchAPI();
		UnifiedorderResult unifiedorderResult = payMchAPI
				.payUnifiedorder(unifiedorder);
		return unifiedorderResult;

	}

	/**
	 * 关闭订单
	 * 
	 * @param unifiedorder
	 * @return
	 */

	protected MchBaseResult payCloseOrder(Closeorder closeorder) {
		// 对象转换MAP
		Map<String, String> mapS = MapUtil.objectToMap(closeorder,
				new String[] { "sign" });
		// 签名
		String sign = SignatureUtil.generateSign(mapS, PartnerKey);
		closeorder.setSign(sign);
		PayMchAPI payMchAPI = new PayMchAPI();
		MchBaseResult mchBaseResult = payMchAPI.payCloseorder(closeorder);
		return mchBaseResult;
	}

	/**
	 * 页面支付接口
	 */
	@Override
	public String getPayJsRequestJson(String openid, String body,
			String out_trade_no, String total_fee, String spbill_create_ip,
			String attach) {
		String Jsjosn = "";
		// 先初始化数据
		Unifiedorder unifiedorder = this.init(openid, body, out_trade_no,
				total_fee, spbill_create_ip, attach);
		// 查询系统是否已经下单
		// List<UnifiedorderResult> unifiedorderResultList =
		// wechatUnifiedOrderResultImpl
		// .getEntityByOutTradeNo(out_trade_no);
		// UnifiedorderResult unifiedorderResult = null;
		// if (unifiedorderResultList.size() > 0) {
		// 已经下过单的从数据库直接读取
		// unifiedorderResult = unifiedorderResultList.get(0);
		// Closeorder closeorder = new Closeorder();
		// closeorder.setAppid(unifiedorderResult.getAppid());
		// closeorder.setMch_id(unifiedorderResult.getMch_id());
		// closeorder.setNonce_str(unifiedorderResult.getNonce_str());
		// closeorder.setOut_trade_no(unifiedorderResult.getOut_trade_no());
		// MchBaseResult mchBaseResult = this.payCloseOrder(closeorder);
		// logger.info("取消订单 ==>" + unifiedorderResult.getOut_trade_no()
		// + "结果:" + mchBaseResult.getReturn_msg());
		// } else {
		// 按照微信支付接口下单
		// unifiedorderResult = this.payUnifiedorder(unifiedorder);
		// unifiedorderResult.setOut_trade_no(out_trade_no);
		// wechatUnifiedOrderResultImpl.save(unifiedorderResult); //
		// 下单完成后保存系统返回实体
		// }

		UnifiedorderResult unifiedorderResult = this
				.payUnifiedorder(unifiedorder);
		unifiedorderResult.setOut_trade_no(out_trade_no);
		wechatUnifiedOrderResultImpl.save(unifiedorderResult); //
		// 下单完成后保存系统返回实体

		if (unifiedorderResult.getReturn_code().equals("SUCCESS")) {
			if (unifiedorderResult.getResult_code().equals("SUCCESS")) {
				// 生成页面所需要的json对象
				Jsjosn = PayUtil.generateMchPayJsRequestJson(
						unifiedorderResult.getPrepay_id(), appid, PartnerKey);

			} else {
				logger.info("订单信息返回错误result_code："
						+ unifiedorderResult.getResult_code()
						+ "  下单失败out_trade_no: "
						+ unifiedorderResult.getOut_trade_no());
			}

		} else {
			logger.info("订单信息返回错误return_code："
					+ unifiedorderResult.getReturn_code() + " return_msg:"
					+ unifiedorderResult.getReturn_msg() + "Out_trade_no:"
					+ unifiedorderResult.getOut_trade_no());
		}
		return Jsjosn;
	}

	public static void main(String[] args) {
		// WechatPayServiceImpl wechatPayServiceImpl = new
		// WechatPayServiceImpl();
		// String json=wechatPayServiceImpl.getPayJsRequestJson("openid",
		// "body", "out_trade_no","total_fee", "spbill_create_ip", "attach");
		PayNotify payNotify = new PayNotify();
		payNotify.setAppid("setAppid");
		payNotify.setAttach("attach");
		payNotify.setBank_type("bank_type");
		payNotify.setCoupon_fee("coupon_fee");
		payNotify.setDevice_info("device_info");
		payNotify.setErr_code("err_code");
		payNotify.setErr_code_des("err_code_des");
		payNotify.setFee_type("fee_type");
		payNotify.setIs_subscribe("is_subscribe");
		payNotify.setMch_id("mch_id");
		payNotify.setNonce_str("nonce_str");
		payNotify.setOpenid("openid");
		payNotify.setOut_trade_no("out_trade_no");
		payNotify.setResult_code("result_code");
		payNotify.setReturn_msg("return_msg");
		String xml = XmlUtils.toXML(payNotify, "xml", PayNotify.class);

		System.out.println(xml);

	}

}
