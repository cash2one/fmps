package cn.com.fubon.wechatClaims.service;

import weixin.guanjia.message.entity.ReceiveMessage;

public interface ClaimsSessionManagement {
	/**
	 * 点击菜单处理
	 * 
	 * @param openid
	 * @return
	 */

	public String clickMenuen(String openid);

	/**
	 * 判断目前客户是否处于理赔会话当中
	 * 
	 * @return
	 */
	public boolean isClaimsDeal(String openid);

	/**
	 * 消息处理
	 * 
	 * @param baseMessage
	 * @return
	 */

	public String messageProcessing(ReceiveMessage receiveMessage);

	/**
	 * 当客户超过25分钟未发送任何消息是时发送询问消息
	 * 
	 * @param openid
	 * @return true 表示成功，false 表示发送失败
	 */

	public boolean sendCloseSessionMessage(String openid);

	/**
	 * 理赔人员关闭会话后，调用此方法关闭微信会话
	 * 
	 * @param openid
	 */
	public void colseWechatSession(String openid);

	/**
	 * 客户 超时关闭会话
	 * 
	 * @param openid
	 */

	public void timeoutCloseSession(String openid);

	/**
	 * 保存客户聊天记录
	 * 
	 * @param openid
	 * @param Content
	 * @param RegistNo
	 */
	public void saveweiXinCustomerServiceChatContent(String openid,
			String Content, String RegistNo);

	/**
	 * 客户在线 返回 true 客户退出微理赔 false.不能给客户发送消息
	 * 
	 * @param openid
	 * @return
	 */
	public boolean customerIsOnline(String openid);

}
