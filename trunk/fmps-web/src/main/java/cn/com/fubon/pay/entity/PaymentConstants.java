/**
 * 
 */
package cn.com.fubon.pay.entity;

/**
 * @author qingqu.huang
 *
 */
public final class PaymentConstants {

	public final static String SINGLETRADEQUERY_GATEWAY="https://mapi.alipay.com/gateway.do?";
	/**
	 * 支付码状态--支付码不存在
	 */
	public final static String PAYCODESTATUS_001 = "001";
	/**
	 * 支付码状态--支付码过期
	 */
	public final static String PAYCODESTATUS_002 = "002";
	/**
	 * 支付码状态--支付码无效
	 */
	public final static String PAYCODESTATUS_003 = "003";
	/**
	 * 支付码状态--支付成功
	 */
	public final static String PAYCODESTATUS_004 = "004";
	/**
	 * 支付码状态--支付码可用
	 */
	public final static String PAYCODESTATUS_005 = "005";
	/**
	 * 支付码状态--支付完成
	 */
	public final static String PAYCODESTATUS_006 = "006";
	/**
	 * 支付宝支付
	 */
	public final static String PAYTYPE_1 = "alipay";
	/**
	 * 微信支付
	 */
	public final static String PAYTYPE_2 = "wxpay";

	/**
	 * 返回错误代码，0001：查询成功
	 */
	public final static String ERRORCODE_0000 = "0000";
	/**
	 * 返回错误代码，0001：参数值为空或者非法
	 */
	public final static String ERRORCODE_0001 = "0001";
	/**
	 * 返回错误代码，0002：找不到订单
	 */
	public final static String ERRORCODE_0002 = "0002";
	/**
	 * 返回错误代码，9999：支付方式可能出错
	 */
	public final static String ERRORCODE_9999 = "9999";
	/**
	 * 查询成功
	 */
	public final static String ERRMSG_OK = "OK";

	public final static String ERRMSG_PAYCODENOTNULL = "支付码不能为空";

	public final static String ERRMSG_PAYTYPENOTNULL = "支付方式不能为空";

	public final static String ERRMSG_NOTFIND = "查询的订单不存在";

	public final static String ERRMSG_CONFIRMTYPE = "该订单还没支付或者请求的支付方式错误";

	public final static String ERRMSG_ALIPAYERR = "调用支付宝单笔订单查询接口失败";

	public final static String ERRMSG_ERRORTYPE = "请求的支付方式错误";

	/**
	 * 交易创建，等待买家付款
	 */
	public final static String ALIPAY_TRADE_STATUS_WAIT_BUYER_PAY = "WAIT_BUYER_PAY";
	/**
	 * 支付宝交易成功，且可对该交易做操作，如：多级分润、退款等。
	 */
	public final static String ALIPAY_TRADE_STATUS_SUCCESS = "TRADE_SUCCESS";
	/**
	 * 支付宝交易成功且结束，即不可再做任何操作
	 */
	public final static String ALIPAY_TRADE_STATUS_FINISHED = "TRADE_FINISHED";
	/**
	 * 支付宝等待卖家收款（买家付款后，如果卖家账号被冻结）
	 */
	public final static String ALIPAY_TRADE_STATUS_PENDING = "TRADE_PENDING";
	/**
	 * 在指定时间段内未支付时关闭的交易;在交易完成全额退款成功时关闭的交易。
	 */
	public final static String ALIPAY_TRADE_STATUS_CLOSED = "TRADE_CLOSED ";

	/**
	 * 单笔交易查询接口，查不到订单
	 */
	public final static String ALIPAY_TRADE_NOT_EXIST = "TRADE_NOT_EXIST";
	/**
	 * 订单待支付
	 */
	public final static int PAYSTATUS_0 = 0;
	/**
	 * 订单支付成功
	 */
	public final static int PAYSTATUS_1 = 1;
	/**
	 * 订单支付失败
	 */
	public final static int PAYSTATUS_2 = 2;
	/**
	 * 订单支付完成
	 */
	public final static int PAYSTATUS_3 = 3;

	/**
	 * 请求成功。请求成功不代表业务处理成功。 T 代表成功 F 代表失败
	 */
	public final static String ALIPAY_IS_SUCCESS_T = "T";

	public final static String ALIPAY_IS_SUCCESS_F = "F";
}
