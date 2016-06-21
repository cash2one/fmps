package cn.com.fubon.webservice.externl.telesalesystem;

public class TelesaleWSConstants {
	
	/** ClientCode:电销系统 **/
	public static final String REQUEST_HEAD_KEY_CLIENT_CODE_TELESALEOS = "200";
	
	/** ServerCode:电销 **/
	public static final String REQUEST_HEAD_KEY_SERVER_CODE_TELESALE = "TELESALE";
	
	/** 电销TelesaleResponseHandler **/
	public static final String CHAIN_CONTEXT_KEY_TELESALE_WS_RESPONSE_HANDLER = "TELESALE_WS_RESPONSE_HANDLER";
	
	/** 调用电销接口方法的参数名 **/
	public static final String REQUEST_TELESALE_PARAMNAME_1 = "PayCode_MD5";
	
	/** 调用电销接口方法的参数名 **/
	public static final String REQUEST_TELESALE_PARAMNAME_2 = "SerialNumber";
	
	/** 调用电销接口方法的参数名 **/
	public static final String REQUEST_TELESALE_PARAMNAME_3 = "CardNo";
	
	/** 调用电销接口方法的参数名 **/
	public static final String REQUEST_TELESALE_PARAMNAME_4 = "payCodeStatus";
	
	/** 电销系统交易码:TranscationCode **/
	public static final String REQUEST_HEAD_KEY_TRANSATION_CODE_2 = "2";
	
	/** 区分车险和非车：CX代表车险，FC代表非车险 **/
	public static final String CLASSCODE_CX = "CX";
	public static final String CLASSCODE_FC = "FC";
	
	/** 支付码状态 001：不存在 002：过期 003：无效-人工置失败 004：已完成支付 005：可用006:支付完成 **/
	public static final String PAYCODESTATUS_1 = "001";
	public static final String PAYCODESTATUS_2 = "002";
	public static final String PAYCODESTATUS_3 = "003";
	public static final String PAYCODESTATUS_4 = "004";
	public static final String PAYCODESTATUS_5 = "005";
	public static final String PAYCODESTATUS_6 = "006";
	
	/** 订单支付状态 0：未支付 1：支付成功 2：支付失败3:支付完成 **/
	public static final int PAYSTATUS_NOTPAY = 0;
	public static final int PAYSTATUS_SUCCESS = 1;
	public static final int PAYSTATUS_FAIL = 2;
	public static final int PAYSTATUS_FINISH = 3;
	
	/** 1：交强险，2：商业险，3：车船税，4：交通守护保险，5：非车险 **/
	public static final String RISKKIND_1 = "1";
	public static final String RISKKIND_2 = "2";
	public static final String RISKKIND_3 = "3";
	public static final String RISKKIND_4 = "4";
	public static final String RISKKIND_5 = "5";
	
	/** 不计免赔:N否，Y是 **/
	public static final String NONDEDUCTIBLE_Y = "Y";
	public static final String NONDEDUCTIBLE_N = "N";
	
	/** 返回代码 0000：成功，0001：验证码不存在，0002：电销数据库错误 **/
	public static final String RETURNCODE_0 = "0000";
	public static final String RETURNCODE_1 = "0001";
	public static final String RETURNCODE_2 = "0002";
	
	/** 发送成功 **/
	public static final int TREATMENT_SUCCESS =  1;
	/** 发送失败 **/
	public static final int TREATMENT_FAILURE = 0;
	/** 待发送 **/
	public static final int TREATMENT_WAITING = -1;
	/** 电销链接失败  **/
	public static final String TELESALE_CONNECT_FAILURE = "8000";
	/** 电销链接失败**/
	public static final String TELESALE_CONNECT_MESSAGE = "电销webservice链接失败";
	
	
	public static final String Clause_Reading_policyno = "policyno";
	
	public static final String Clause_Reading_wxreadflag = "wxreadflag";
	
	public static final String Clause_Reading_wxgiftflag = "wxgiftflag";
	
	public static final String Clause_Reading_wxgift = "wxgift";

}
