/**
 * 
 */
package cn.com.fubon.util;

/**
 * 常量类
 * 
 * @author binbin.wang
 *
 */
public final class Constants{

	/**
	 * 发送状态标志：已发送
	 */
	public final static int STATUS_FLAG_SEND = 1;

	/**
	 * 发送状态标志：未发送
	 */
	public final static int STATUS_FLAG_NOT_SEND = 0;

	/**
	 * 发送状态标志：取消发送
	 */
	public final static int STATUS_FLAG_CANCEL_SEND = 2;

	/**
	 * 状态标志：有效
	 */
	public final static int STATUS_FLAG_VALID = 1;

	/**
	 * 状态标志：无效
	 */
	public final static int STATUS_FLAG_INVALID = 0;

	/**
	 * 用户绑定手机验证码短信类型msgid
	 */
	public static final String CUSTOMER_BIND_MSGID = "70";

	/**
	 * 手机验证码状态:未使用
	 */
	public static final String DYNAMIC_PASSWORD_VALID = "0";

	/**
	 * 手机验证码状态:已使用
	 */
	public static final String DYNAMIC_PASSWORD_INVALID = "1";

	/**
	 * 手机验证码类型:用户绑定
	 */
	public static final String DYNAMIC_PASSWORD_TYPE1 = "100";

	/**
	 * 后台用户session Key
	 */
	public static final String SESSION_KEY_BO_USER = "session_key_bo_user";

	/**
	 * 后台随机码session Key
	 */
	public static final String SESSION_KEY_RAND_CODE = "randCode"; // todo 要统一常量

	public static final String SESSION_CUSTOMERCODE = "customercode"; // customercode
																		// 要统一常量
	
	
	public static final String SESSION_KEY_OPENID = "Customer_openid"; //  从手机页面访问的OPENID
	
	public static final String MEMKEY_WEIXIN_GZUSERINFO = "weixin_gzuserinfo"; //table weixin_gzuserinfo
	
	public static final String SESSION_KEY_redirectUrl = "Customer_redirectUrl"; //  从手机页面访问的OPENID
	
	public static final String SESSION_KEY_redirect_count = "Customer_redirect_count"; //  重定向次数

	/**
	 * 提示信息类型属性名
	 */
	public static final String MESSAGE_TYPE = "messageType";

	/**
	 * 提示信息类型属性值info
	 */
	public static final String MESSAGE_TYPE_INFO = "info";

	/**
	 * 提示信息类型属性值warn
	 */
	public static final String MESSAGE_TYPE_WARN = "warn";

	/**
	 * 提示信息类型属性值error
	 */
	public static final String MESSAGE_TYPE_ERROR = "error";

	/**
	 * 微信险种大类-车险
	 */
	public static final String INSURANCE_PLAN_TYPE_CHE = "01";

	/**
	 * 微信险种大类-家财险
	 */
	public static final String INSURANCE_PLAN_TYPE_JIACAI = "02";

	/**
	 * 微信险种大类-意外险
	 */
	public static final String INSURANCE_PLAN_TYPE_YIWAI = "03";
	/**
	 * 微信险种大类-旅游险
	 */
	public static final String INSURANCE_PLAN_TYPE_LVYOU = "04";

	/**
	 * 微信险种大类-健康险
	 */
	public static final String INSURANCE_PLAN_TYPE_JIANKANG = "05";

	/**
	 * 微信险种大类-责任险
	 */
	public static final String INSURANCE_PLAN_TYPE_LIABILITY = "06";

	/**
	 * 微信用户绑定短信验证码类型为数字
	 */
	public static final String WEIXINBIND_RANDCODETYPE_NUMBER = "1";

	/**
	 * 微信用户绑定短信验证码长度
	 */
	public static final int WEIXINBIND_RANDCODELENGTH = 6;

	/** Memcached Key begin **/
	public static final String MEMKEY_WEIXIN_ACCOUNT_TOKEN = "weixin_account_token";

	public static final String MEMKEY_WEIXIN_unique = "uniqueToken"; // key=ExpireSet+openid

	public static final String MEMKEY_WEIXIN_JsapiTicket = "CachedJsapiTicket";

	public static final String MEMKEY_WEIXIN_WeChat_claims = "WeChatClaimsUnique";

	public static final String MEMKEY_WEIXIN_locationMessage = "WeChatLocationMessage";

	public static final String MEMKEY_WEIXIN_latitude = "latitude";
	public static final String MEMKEY_WEIXIN_longitude = "longitude";

	/** Memcached Key end **/

	/**
	 * 用户绑定提示信息：openid为空,无法做绑定操作。
	 */
	public static final String WEIXINBIND_MESSAGE_OPENID_IS_NULL = "openid为空,无法做绑定操作。";

	/**
	 * 个人中心提示信息：openid为空,无法获取个人信息
	 */
	public static final String PERSONALCENTER_MESSAGE_OPENID_IS_NULL = "openid为空,无法获取个人信息。";

	/**
	 * 用户绑定提示信息：您尚未关注我司公众号，请先在微信公众号搜索“富邦财险”进行关注。
	 */
	public static final String WEIXINBIND_MESSAGE_NOT_SUBSCRIBE = "您尚未关注我司公众号，请先在微信公众号搜索“富邦财险”进行关注，或者长按以下二维码识别后进行关注。";

	/**
	 * 用户绑定提示信息：您已经是认证客户，请勿重复认证。如需重新认证可先取消关注，再重新关注后进行认证。
	 */
	public static final String WEIXINBIND_MESSAGE_REBIND = "您已经是认证客户，请勿重复认证。如需重新认证可先取消关注，再重新关注后进行认证。";
	
	/**
	 * 用户绑定提示信息：该客户信息已被认证，请勿重复操作。如有疑问，请联系4008-817-518或在线咨询微信客服。
	 */
	public static final String WEIXINBIND_MESSAGE_CUSTOMER_REBIND = "该客户信息已被认证，请勿重复操作。如有疑问，请联系4008-817-518或在线咨询微信客服。";

	/**
	 * 用户绑定提示信息：未查询到您的客户信息,绑定失败。请确认您输入的信息是否有误并重新获取短信验证码。
	 */
	public static final String WEIXINBIND_MESSAGE_CUSTOMERINFO_NOTFOUND = "未查询到您的客户信息,绑定失败。请确认您输入的信息是否有误并重新获取短信验证码。";

	/**
	 * 用户绑定提示信息：验证码错误或已过期,请核对后再试!
	 */
	public static final String WEIXINBIND_MESSAGE_UNAVAILABLE_DYNAMICPASSWORD = "验证码错误或已过期,请核对后再试!";

	/**
	 * 用户绑定提示信息：手机号不合法!
	 */
	public static final String WEIXINBIND_MESSAGE_UNAVAILABLE_MOBILE = "手机号不合法!";

	/**
	 * 用户绑定提示信息：证件号码不能为空!
	 */
	public static final String WEIXINBIND_MESSAGE_IDENTIFYNUMBER_IS_NULL = "证件号码不能为空!";

	/**
	 * 用户绑定提示信息：手机号码不能为空!
	 */
	public static final String WEIXINBIND_MESSAGE_MOBILE_IS_NULL = "手机号码不能为空!";

	/**
	 * 用户绑定提示信息：姓名不能为空!
	 */
	public static final String WEIXINBIND_MESSAGE_CUSTOMERCNAME_IS_NULL = "姓名不能为空!";

	/**
	 * 用户绑定提示信息：验证码不能为空!
	 */
	public static final String WEIXINBIND_MESSAGE_DYNAMICPASSWORD_IS_NULL = "验证码不能为空!";

	/**
	 * 用户绑定提示信息：车牌号不能为空!
	 */
	public static final String WEIXINBIND_MESSAGE_LICENSENO_IS_NULL = "车牌号不能为空!";
	
	/**
	 * 用户发送消息，无法处理的消息。默认回复文本
	 */
	public static final String WEIXIN_MESSAGE_DEFAULT_REPLY = " 请输入数字0接入人工客服,如果想进入微信理赔,请再次输入报案电话。";
	
	/**
	 * 用户发送消息，无法处理的消息。默认回复文本附加时间提示
	 */
	public static final String WEIXIN_MESSAGE_DEFAULT_REPLY_TIMING = "（温馨提示：客服在线时间为周一到周日早上8：00-晚上21：00）";

	/**
	 * 当前理赔进度
	 */
	public static final String WEIXINCLAIMS_claimsProgress = "claimsProgress";

	/**
	 * 是否已经询问过用户是否继续服务
	 */

	public static final String WEIXINCLAIMS_is_Ask = "is_Ask";

	/**
	 * 当前理赔电话号码
	 */
	public static final String WEIXINCLAIMS_claimsphoneNO = "claimsphoneNO";
	/**
	 * 单前理赔图片上传张数
	 */
	public static final String WEIXINCLAIMS_claimsImage_total = "claimsImageTotal";

	/**
	 * 理赔报案信息列表
	 */
	public static final String WEIXINCLAIMS_reportInfoList = "reportInfoList";

	/**
	 * 当前处理报案信息
	 */
	public static final String WEIXINCLAIMS_reportInfo = "reportInfo";

	/**
	 * 聊天消息来源为客服
	 */
	public static final int WECHATCLAIMS_MESSAGE_SOURCE_CUSTOMERSERVICE = 0;
	/**
	 * 聊天消息来源为用户
	 */
	public static final int WECHATCLAIMS_MESSAGE_SOURCE_USER = 1;
	/**
	 * 聊天消息为已读
	 */
	public static final int WECHATCLAIMS_MESSAGE_READED = 1;

	/**
	 * 聊天消息为未读
	 */
	public static final int WECHATCLAIMS_MESSAGE_NOTREADED = 0;

	/**
	 * 消息类型为文本
	 */
	public static final String WECHATCLAIMS_MESSAGE_TYPE_TEXT = "001";

	/**
	 * 消息类型为图片
	 */
	public static final String WECHATCLAIMS_MESSAGE_TYPE_IMAGE = "002";

	/**
	 * 案件信息会话进行中
	 */
	public static final int WECHATCLAIMS_REGISTNO_SESSTIONSTATE_LINE = 1;

	/**
	 * 案件信息会话结束
	 */
	public static final int WECHATCLAIMS_REGISTNO_SESSTIONSTATE_OFFLINE = 0;

	/**
	 * 微信后台角色-超级管理员
	 */
	public static final String WEIXIN_USER_ROLE_ADMIN = "admin";

	/**
	 * 微信后台角色-微理赔主管
	 */
	public static final String WEIXIN_USER_ROLE_WECHAT_ADMIN = "wechatad";

	/**
	 * 微信后台角色-微理赔客服
	 */
	public static final String WEIXIN_USER_ROLE_WECHAT = "wechat";

	/**
	 * 微信后台菜单-微理赔客服-案件处理-弹出新窗口
	 */
	public static final String WEIXIN_USER_FUNCTION_WECHAT = "案件处理";

	/**
	 * 微信后台菜单-微理赔客服-历史记录-弹出新窗口
	 */
	public static final String WEIXIN_USER_FUNCTION_WECHAT_HISTORY = "历史记录";

	/**
	 * 微理赔客服-聊天系统-每页记录数
	 */
	public static final int WECHATCLAIMS_REGISTNO_PAGESIZE = 5;

	/**
	 * 微理赔客服-会话状态--用户已经退出
	 */
	public static final int WECHATCLAIMS_Session_State_USEROFFLINE = 2;

	/**
	 * 证件类型代码：01为身份证
	 */
	public static final String IDENTIFYTYPE_01 = "01";

	/**
	 * memcache中证件号码的key：openid+"identifynumber"
	 */
	public static final String MEMKEY_IDENTIFYNUMBER = "identifynumber";

	/**
	 * memcache中证件号码的key：openid+"customercname"
	 */
	public static final String MEMKEY_CUSTOMERCNAME = "customercname";

	/**
	 * 投保类型（"1"投保单）
	 */
	public final static String TYPE_POLICY_1 = "1";// 投保单
	/**
	 * 投保类型（"2"保单）
	 */
	public final static String TYPE_POLICY_2 = "2";// 保单
	/**
	 * 卡单有效性（"0"验证不通过）
	 */
	public final static String CARD_VALIDATE_0 = "0";// 验证不通过
	/**
	 * 卡单有效性（"1"验证通过）
	 */
	public final static String CARD_VALIDATE_1 = "1";// 验证通过
	/**
	 * 卡单当前状态（"-1"可激活）
	 */
	public final static String CARD_STATE_1 = "-1";// 可激活

	/**
	 * 卡单当前状态（"-2"不可激活）
	 */
	public final static String CARD_STATE_2 = "-2";// 不可激活

	/**
	 * 不通过的原因（"0"卡号不存在）
	 */
	public final static String NOT_PASS_REASON_0 = "0";// 卡号不存在

	/**
	 * 不通过的原因（"1"卡密码错误）
	 */
	public final static String NOT_PASS_REASON_1 = "1";// 卡密码错误

	/**
	 * 不通过的原因（"2"该种保险卡已停用）
	 */
	public final static String NOT_PASS_REASON_2 = "2";// 该种保险卡已停用

	/**
	 * 不通过的原因（"3"该保险卡已过期）
	 */
	public final static String NOT_PASS_REASON_3 = "3";// 该保险卡已过期

	/**
	 * 不通过的原因（"4"该保险卡状态错误,不能被激活或者查看）
	 */
	public final static String NOT_PASS_REASON_4 = "4";// 该保险卡状态错误,不能被激活或者查看
	/**
	 * /投保人与被保人不是同一个人
	 */
	public final static String CHECK_FLAG_0 = "0";// 投保人与被保人不是同一个人

	/**
	 * /投保人与被保人是同一个人
	 */
	public final static String CHECK_FLAG_1 = "1";// 投保人与被保人是同一个人

	/**
	 * /投保人与被保人是同一个人
	 */
	public final static String INSUREDIDENTITYFLAG_1 = "1";// 投保人与被保人是同一个人

	/**
	 * /投保人与被保人是同一个人
	 */
	public final static String INSUREDIDENTITYFLAG_2 = "2";// 投保人与被保人不是同一个人

	/**
	 * /家财卡
	 */
	public final static int PRODUCT_TYPE_2 = 2;// 家财卡

	/**
	 * /意外卡
	 */
	public final static int PRODUCT_TYPE_1 = 1;// 家财卡

	/**
	 * 检查memcache二维码信息为0 表示要跳转到维修厂列表
	 */
	public static final String QRCODEAJAX_0 = "0";

	/**
	 * 检查memcache二维码信息为1表示要跳转到维修厂列表
	 */
	public static final String QRCODEAJAX_1 = "1";

	/**
	 * 检查memcache二维码信息为2表示要跳转到维修厂列表
	 */
	public static final String QRCODEAJAX_2 = "2";
	/**
	 * 先生
	 */
	public static final String MR_FLAG = "1";
	/**
	 * 小姐
	 */
	public static final String MISS_FLAG = "2";

	/**
	 * 核心险类:05车险
	 */
	public static final String CORE_CAR_CLASSCODE = "05";
	/**
	 * 核心车险保单长度:21
	 */
	public static final int CORE_CAR_POLICY_LENGTH = 21;

	/**
	 * 车子上牌标志:0表示未上牌
	 */
	public static final String CAR_NOT_LICENSED = "0";

	/**
	 * 前端展示待验证的客户昵称:(待认证)
	 */
	public static final String NOT_BINDED = "(待认证)";

	/**
	 * 核赔确认微信号不是报案微信号:请用报案微信号做核赔金额确认。
	 */
	public static final String CLAIM_FEE_CONFIRMED_INVALID_OPENID = "请用报案微信号做核赔金额确认。";

	/**
	 * 核赔确认微信号不是报案微信号:未获取到当前微信号。
	 */
	public static final String CLAIM_FEE_CONFIRMED_INVALID_CURRENTOPENID = "未获取到当前微信号。";

	/**
	 * 核赔确认微信号不是报案微信号:未获取到报案信息。
	 */
	public static final String CLAIM_FEE_CONFIRMED_INVALID_REGISTNO = "未获取到报案信息。";

	/**
	 * 已核赔确认:已核赔确认。
	 */
	public static final String CLAIM_FEE_CONFIRMED_SUCCESS = "您已确认过核赔金额。";

	/** 核赔金额确认方式:1是人工确认 **/
	public static final String WS_CLAIM_FEE_CONFIRM_STYLE_1 = "1";

	/** 核赔金额确认方式:0是系统自动确认 **/
	public static final String WS_CLAIM_FEE_CONFIRM_STYLE_0 = "0";

	/** 核赔金额确认接口提示信息:核赔确认出错 **/
	public static final String WS_CLAIM_FEE_CONFIRMED_FAILED = "核赔确认出错，系统将于5分钟后自动确认。";

	/**
	 * 模板消息默认的颜色
	 */
	public static final String TEMPLATE_MESSAGE_ITEM_TOPCOLOR = "#FF0000";

	/**
	 * 模板消息值的颜色
	 */
	public static final String TEMPLATE_MESSAGE_ITEM_COLOR = "#173177";

	/**
	 * 模板消息重发最大次数
	 */
	public static final Integer TEMPLATE_MESSAGE_MAX_SEND_COUNT = 5;

	/**
	 * 模板消息送达状态为送达失败（非用户拒绝）:2
	 */
	public static final Integer TEMPLATE_MESSAGE_SYSTEM_FAILED = 2;

	/**
	 * 模板消息送达状态为送达成功:0
	 */
	public static final Integer TEMPLATE_MESSAGE_SUCCESS = 0;

	/**
	 * 模板消息接口调用成功:0
	 */
	public static final String TEMPLATE_MESSAGE_WEIXIN_INVOKED_SUCCESS = "0";

	/**
	 * 模板消息送达状态为用户拒绝接收:1
	 */
	public static final Integer TEMPLATE_MESSAGE_USER_BLOCK = 1;

	/**
	 * 模板消息送达状态为发送失败（非用户拒绝） failed: system failed
	 */
	public static final String TEMPLATE_MESSAGE_WEIXIN_SYSTEM_FAILED = "failed: system failed";

	/**
	 * 模板消息送达状态为成功 success
	 */
	public static final String TEMPLATE_MESSAGE_WEIXIN_SUCCESS = "success";

	/**
	 * 模板消息送达状态为用户拒绝接收 failed:user block
	 */
	public static final String TEMPLATE_MESSAGE_WEIXIN_USER_BLOCK = "failed:user block";
	
	/*
	errcode ：00000   errmsg: ok
	errcode ：10011   errmsg: 券ID为空或格式问题
	errcode ：10014   errmsg: openid 为空
	errcode ：10010   errmsg: 券库存数量不足
	errcode ：10015   errmsg: 已领过此抵用券
	errcode ：10016   errmsg: 领取失败,请重新领取
	 */
	/**
	 * 双11领取活动券，返回码：00000,msg:领取成功
	 */
	public static final String DOUBLE_11_ERRCODE_00000 = "00000";
	/**
	 * 双11领取活动券，返回码：10010,msg:券库存数量不足
	 */
	public static final String DOUBLE_11_ERRCODE_10010 = "10010";
	/**
	 * 双11领取活动券，返回码：10015,msg:已领过此抵用券
	 */
	public static final String DOUBLE_11_ERRCODE_10015 = "10015";
	/**
	 * 双11领取活动券，返回码：10016,msg:领取失败，请在线联系客服或拨打4008-518-718
	 */
	public static final String DOUBLE_11_ERRCODE_10016 = "10016";
	/**
	 * 双11领取活动券，返回码：00000,msg:领取成功
	 */
	public static final String DOUBLE_11_ERRCODE_00000_MSG = "领取成功";
	/**
	 * 双11领取活动券，返回码：10010,msg:券库存数量不足
	 */
	public static final String DOUBLE_11_ERRCODE_10010_MSG = "券库存数量不足";
	/**
	 * 双11领取活动券，返回码：10015,msg:已领过此抵用券
	 */
	public static final String DOUBLE_11_ERRCODE_10015_MSG = "已领过此抵用券";
	/**
	 * 双11领取活动券，返回码：10016,msg:领取失败，请在线联系客服或拨打4008-518-718
	 */
	public static final String DOUBLE_11_ERRCODE_10016_MSG = "领取失败，请在线联系客服或拨打4008-817-518";
	//10025	领券时间为空
	public static final String CAR_HOME_ERRCODE_10025 = "10025";
	public static final String CAR_HOME_ERRCODE_10025_MSG = "领券时间为空";
   // 10026	领券时间无效
	public static final String CAR_HOME_ERRCODE_10026 = "10026";
	public static final String CAR_HOME_ERRCODE_10026_MSG = "领券时间无效";
   // 10029	券库存不足
	public static final String CAR_HOME_ERRCODE_10029 = "10029";
	public static final String CAR_HOME_ERRCODE_10029_MSG = "券库存不足";
	
	/**
	 * 活动类型_转盘
	 */
	public static final String ACTIVITYTYPE_TURNTABLE = "2";
	/**
	 * 转盘奖项_已抽取的特等奖
	 */
	public static final String SUPER_TOTAL_DRAW = "superTotalDraw";
	/**
	 * 转盘奖项_已抽取的一等奖
	 */
	public static final String ONE_TOTAL_DRAW = "oneTotalDraw";
	/**
	 * 转盘奖项_已抽取的二等奖
	 */
	public static final String TWO_TOTAL_DRAW = "twoTotalDraw";
	/**
	 * 转盘奖项_已抽取的三等奖
	 */
	public static final String THREE_TOTALD_RAW = "threeTotalDraw";
	/**
	 * 转盘奖项特等奖
	 */
	public static final int PRIZE_RANK_SUPER = 0;
	/**
	 * 转盘奖项一等奖
	 */
	public static final int PRIZE_RANK_FIRST = 1;
	/**
	 * 转盘奖项_二等奖
	 */
	public static final int PRIZE_RANK_SECCOND = 2;
	/**
	 * 转盘奖项_三等奖
	 */
	public static final int PRIZE_RANK_THIRD = 3;
	/**
	 * 转盘奖项_未中奖
	 */
	public static final String PRIZE_RANK_OTHER = "99";	
	
	//活动开始时间
	public static final String HUODON_START_DATE = "HUODON_START_DATE";
	//活动结束时间
	public static final String HUODON_END_DATE = "HUODON_END_DATE";
	/**
	 *memcached操作类型_set值
	 */
	public static final int MEMCACHED_MODIFY_TYPE_SET = 1;	
	/**
	 *memcached操作类型_delete值
	 */
	public static final int MEMCACHED_MODIFY_TYPE_DELETE = 2;	
	/**
	 *memcached操作类型_decr值
	 */
	public static final int MEMCACHED_MODIFY_TYPE_DECR = 3;	
	/**
	 *memcached操作类型_incr值
	 */
	public static final int MEMCACHED_MODIFY_TYPE_INCR = 4;	
	/**
	 *memcached操作类型_get值
	 */
	public static final int MEMCACHED_MODIFY_TYPE_GET = 5;	
	
	
	/**
	 * 网页授权方式获取的access_token
	 */
	public static final String  OAUTH2_ACCESS_TOKEN ="oauth2_access_token";	
	
	
	/**
	 * 电销阅读条款发红包规定日期
	 */
	public static final String  READ_CLAUSE_RULE_DATE ="2016-05-01 00:00:00";	
	
	/**
	 * 电销阅读条款活动ID
	 */
	public static final String  TELESALE_READ_CLAUSE_huodongid="402881e5479afd0101479b7cc102002c";
	
	
	/**
	 * 渠道为电销
	 */
	public static final String  TELESALE_CHANNEL ="08";
	
	/**
	 * 用户查看条款领红包短信类型msgid
	 */
	public static final String CUSTOMER_READ_CLAUSE_MSGID = "903";
	
	/**
	 * 保单生效第15天
	 */
	public static final String CUSTOMER_READ_CLAUSE_FIFTEEN="15";
}
