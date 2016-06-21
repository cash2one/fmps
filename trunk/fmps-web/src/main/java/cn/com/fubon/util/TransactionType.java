package cn.com.fubon.util;

import java.util.Map;

import weixin.util.WeiXinConstants;

/**
 * 微信接收消息，交易类型转换类
 * 
 * @author shanqi.wang
 *
 */
public class TransactionType {
	/**
	 * 根据微信服务器端返回的数据解析成Map,传入本方法，返回服务器交易类型
	 * 
	 * @param requestMap
	 * @return
	 */
	public static String convertToTransactionType(Map<String, String> requestMap) {
		// 默认消息返回类型
		String returnStr = "未知交易类型";
		// 消息类型
		String msgType = requestMap.get("MsgType");
		// 事件类型
		String eventType = requestMap.get("Event");
		// 事件KEY值
		String eventKey = requestMap.get("EventKey");
		if (msgType.contains(WeiXinConstants.RESP_MESSAGE_TYPE_GENERAL)) {
			returnStr = WeiXinConstants.MESSAGE_TYPE_GENERAL_TEXT;
		} else if (msgType.equals(WeiXinConstants.REQ_MESSAGE_TYPE_EVENT)) {
			if (eventType.equals(WeiXinConstants.EVENT_TYPE_SUBSCRIBE)) {
				returnStr = WeiXinConstants.MESSAGE_TYPE_SUBSCRIBE_TEXT;
				if (!eventKey.equals("")) // 用户通过扫描关注与普通关注区别是 EventKey 是否有值
					returnStr = WeiXinConstants.MESSAGE_TYPE_UNSUBSCRIBE_SCAN_TEXT;
			} else if (eventType.equals(WeiXinConstants.EVENT_TYPE_UNSUBSCRIBE)) {
				returnStr = WeiXinConstants.MESSAGE_TYPE_UNSUBSCRIBE_TEXT;
			} else if (eventType.equals(WeiXinConstants.EVENT_TYPE_SCAN)) {
				returnStr = WeiXinConstants.MESSAGE_TYPE_SUBSCRIBE_SCAN_TEXT;
			} else if (eventType.equals(WeiXinConstants.EVENT_TYPE_LOCATION)) {
				returnStr = WeiXinConstants.MESSAGE_TYPE_LOCATION_TEXT;
			} else if (eventType.equals(WeiXinConstants.EVENT_TYPE_CLICK)) {
				returnStr = WeiXinConstants.MESSAGE_TYPE_CLICK_TEXT;
			} else if (eventType.equals(WeiXinConstants.EVENT_TYPE_VIEW)) {
				returnStr = WeiXinConstants.MESSAGE_TYPE_VIEW_TEXT;
			}
		}

		return returnStr;
	}
}
