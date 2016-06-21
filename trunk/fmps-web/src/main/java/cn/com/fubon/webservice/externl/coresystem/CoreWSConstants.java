/**
 * 
 */
package cn.com.fubon.webservice.externl.coresystem;

/**
 * 核心web service常量类
 * 
 * @author binbin.wang
 *
 */
public final class CoreWSConstants {

	/** 处理成功 **/
	public static final String CORE_WS_RETURN_CODE_SUCCESS = "0000";
	
	/** 处理失败 **/
	public static final String CORE_WS_RETURN_CODE_FAILTURE = "1000";
	
	/** 未知异常 **/
	public static final String CORE_WS_RETURN_CODE_UNKNOWN_ERROR_ = "9999";
	
	/** 车牌号已存在 **/
	public static final String CORE_WS_RETURN_CODE_LICENSE_NO_EXIST = "1111";
	
	/** 流水号重复 **/
	public static final String CORE_WS_RETURN_CODE_TRANSACTION_SEQ_REPEATED_ = "8888";
	
	/** 发送成功 **/
	public static final int treatment_success =  1;
	/** 发送失败 **/
	public static final int treatment_failure = 0;
	/** 待发送 **/
	public static final int treatment_waiting = -1;
	/** 核心链接失败  **/
	public static final String CORE_Contact_Failure= "9000";
	/** 核心链接失败**/
	public static final String CORE_Contact_Message = "webservice链接失败";
	
	
	/** WS调用失败:0 **/
	public static final String INVOKE_FAILURE_LOG_STATUS_0 = "0";
	
	/** WS调用成功:1 **/
	public static final String INVOKE_FAILURE_LOG_STATUS_1 = "1";
	
}
