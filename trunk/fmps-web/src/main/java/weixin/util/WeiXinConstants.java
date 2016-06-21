package weixin.util;


public class WeiXinConstants {

	/**
	 * 登录用户账号信息，加载到session缓存中
	 */
	public static final String WEIXIN_ACCOUNT = "WEIXIN_ACCOUNT";
	/**
	 * 微信商城用户登录是的openid
	 */
	public static final String USER_OPENID = "USER_OPENID";

	public static final String FUBON_MP_TOKEN = "";

	/**
	 * 返回消息类型：文本
	 */
	public static final String RESP_MESSAGE_TYPE_TEXT = "text";
	/**
	 * 返回消息类型：图片
	 */
	public static final String RESP_MESSAGE_TYPE_IMAGE = "image";
	/**
	 * 返回消息类型：语音
	 */
	public static final String RESP_MESSAGE_TYPE_VOICE = "voice";

	/**
	 * 返回消息类型：视频
	 */
	public static final String RESP_MESSAGE_TYPE_VIDEO = "video";

	/**
	 * 返回消息类型：音乐
	 */
	public static final String RESP_MESSAGE_TYPE_MUSIC = "music";

	/**
	 * 返回消息类型：图文
	 */
	public static final String RESP_MESSAGE_TYPE_NEWS = "news";

	/**
	 * 请求消息类型：文本
	 */
	public static final String REQ_MESSAGE_TYPE_TEXT = "text";

	/**
	 * 请求消息类型：图片
	 */
	public static final String REQ_MESSAGE_TYPE_IMAGE = "image";

	/**
	 * 请求消息类型：链接
	 */
	public static final String REQ_MESSAGE_TYPE_LINK = "link";

	/**
	 * 请求消息类型：地理位置
	 */
	public static final String REQ_MESSAGE_TYPE_LOCATION = "location";

	/**
	 * 请求消息类型：音频
	 */
	public static final String REQ_MESSAGE_TYPE_VOICE = "voice";

	/**
	 * 请求消息类型：推送
	 */
	public static final String REQ_MESSAGE_TYPE_EVENT = "event";

	/**
	 * 事件类型：subscribe(订阅)
	 */
	public static final String EVENT_TYPE_SUBSCRIBE = "subscribe";

	/**
	 * 事件类型：unsubscribe(取消订阅)
	 */
	public static final String EVENT_TYPE_UNSUBSCRIBE = "unsubscribe";

	/**
	 * 事件类型：CLICK(自定义菜单点击事件)
	 */
	public static final String EVENT_TYPE_CLICK = "CLICK";
	/**
	 * 事件类型：VIEW(自定义菜单点击事件)
	 */
	public static final String EVENT_TYPE_VIEW = "VIEW";
	
	/**
	 * 事件类型：TEMPLATESENDJOBFINISH(推送模板消息)
	 */
	public static final String EVENT_TYPE_TEMPLATESENDJOBFINISH = "TEMPLATESENDJOBFINISH";

	/**
	 * 微信JSON格式返回值的KEY:errcode
	 */
	public static final String WEIXIN_RETURN_JSON_KEY_ERROR_CODE = "errcode";

	/**
	 * 微信JSON格式返回值的KEY:errmsg
	 */
	public static final String WEIXIN_RETURN_JSON_KEY_ERROR_MESSAGE = "errmsg";

	/**
	 * 微信返回码：成功
	 */
	public static final int WEIXIN_RETURN_VALUE_OK =0;

	/**
	 * 微信返回码：回复时间超过限制 用于取消微信客服消息的发送
	 */
	public static final int WEIXIN_RETURN_VALUE_SEND_MESSAGE_TIME_OUT = 45015;

	// 普通消息
	public static final String RESP_MESSAGE_TYPE_GENERAL = "text.image.voice.video.location.link";

	// 扫描带参数二维码事件 用户已经关注
	public static final String EVENT_TYPE_SCAN = "SCAN";
	// 扫描带参数二维码事件用户未关注
	public static final String EVENT_TYPE_SUBSCRIBE_EventKey = "";
	// 上报地理位置
	public static final String EVENT_TYPE_LOCATION = "LOCATION";
	// 普通消息
	public static final String MESSAGE_TYPE_GENERAL_TEXT = "wei601";
	// 关注订阅号
	public static final String MESSAGE_TYPE_SUBSCRIBE_TEXT = "wei602";
	// 用户已经未关注,且扫描二维码
	public static final String MESSAGE_TYPE_UNSUBSCRIBE_SCAN_TEXT = "wei603";
	// 取消订阅号
	public static final String MESSAGE_TYPE_UNSUBSCRIBE_TEXT = "wei604";
	// 用户已经关注,且扫描二维码
	public static final String MESSAGE_TYPE_SUBSCRIBE_SCAN_TEXT = "wei605";
	// 上报地理位置
	public static final String MESSAGE_TYPE_LOCATION_TEXT = "wei606";
	// 点击菜单拉取消息
	public static final String MESSAGE_TYPE_CLICK_TEXT = "wei607";
	// 点击菜单跳转链接
	public static final String MESSAGE_TYPE_VIEW_TEXT = "wei608";
	// 是否关注 1:关注  
	public static final String SUBSCRIBE_TYPE_VALUE  = "1"; 
	// 是否关注  0:取消关注
	public static final String UNSUBSCRIBE_TYPE_VALUE  = "0"; 
}
