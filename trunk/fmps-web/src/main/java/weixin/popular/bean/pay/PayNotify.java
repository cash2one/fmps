package weixin.popular.bean.pay;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.jeecgframework.core.common.entity.IdEntity;

@Entity
@Table(name="weixin_notify")
@PrimaryKeyJoinColumn(name = "id")
@XmlRootElement(name="xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class PayNotify extends IdEntity{ 
	
	private String    return_code ;    //  返回状态码   是  String(16)     SUCCESS/FAIL此字段是通信标识，非交易标识，交易是否成功需要查看result_code 来判断
	private String    return_msg  ;    // 返回信息   否  String(128)    返回信息，如非空，为错误原因签名失败参数格式校验错误
	private String    appid       ;    // 公众账号ID    是  String(32)     微信分配的公众账号ID
	private String    mch_id  ;        // 商户号        是  String(32)     微信支付分配的商户号
	private String    device_info  ;   // 设备号    否  String(32)     微信支付分配的终端设备号，       
	private String    nonce_str   ;    // 随机字符串      是  String(32)     随机字符串，不长于32 位
	private String    sign   ;         // 签名            是  String(32)     签名,详细签名 
	private String    result_code  ;   //业务结果   是  String(16)     SUCCESS/FAIL
	private String    err_code    ;    // 错误代码     否  String(32)     错误码见第6 节
	private String    err_code_des ;   //错误代码描述 否  String(128)    结果信息描述
	private String    openid    ;      // 用户标识     是  String(128)    用户在商户appid 下的唯一标识
	private String    is_subscribe  ;  //是否关注公众账号 是  String(1)      用户是否关注公众账号，Y-关注，N-未关注，仅在公众账号类型支付有效
	private String    trade_type    ;  // 交易类型         是  String(16)     JSAPI、NATIVE、MICROPAY、APP
	private String    bank_type  ;     //付款银行      是  String(16)     银行类型，采用字符串类型的银行标识    
	private String    cash_fee ;       // 现金       是  Int            
	private String    total_fee ;      // 总金额       是  Int            订单总金额，单位为分 
	private String    coupon_fee   ;   //现金券金额    否  Int            现金券支付金额<=订单总金额，订单总金额-现金券金额为现金支付金额
	private String    fee_type   ;     //货币种类     否  String(8)      货币类型，符合ISO 4217 标准的三位字母代码，默认人民币：CNY
	private String    transaction_id ; // 微信支付订单号  是  String(32)     微信支付订单号
	private String    out_trade_no  ;  // 商户订单号  是  String(32)     商户系统的订单号，与请求一致。
	private String    attach     ;     // 商家数据包  否  String(128)    商家数据包，原样返回[支付来源，订单号，其他信息]
	private String    time_end   ;     // 支付完成时间  是  String(14)     支付完成时间， 格式为yyyyMMddhhmmss
	public String getReturn_code() {
		return return_code;
	}
	public void setReturn_code(String return_code) {
		this.return_code = return_code;
	}
	public String getReturn_msg() {
		return return_msg;
	}
	public void setReturn_msg(String return_msg) {
		this.return_msg = return_msg;
	}
	public String getAppid() {
		return appid;
	}
	public void setAppid(String appid) {
		this.appid = appid;
	}
	public String getMch_id() {
		return mch_id;
	}
	public void setMch_id(String mch_id) {
		this.mch_id = mch_id;
	}
	public String getDevice_info() {
		return device_info;
	}
	public void setDevice_info(String device_info) {
		this.device_info = device_info;
	}
	public String getNonce_str() {
		return nonce_str;
	}
	public void setNonce_str(String nonce_str) {
		this.nonce_str = nonce_str;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	public String getResult_code() {
		return result_code;
	}
	public void setResult_code(String result_code) {
		this.result_code = result_code;
	}
	public String getErr_code() {
		return err_code;
	}
	public void setErr_code(String err_code) {
		this.err_code = err_code;
	}
	public String getErr_code_des() {
		return err_code_des;
	}
	public void setErr_code_des(String err_code_des) {
		this.err_code_des = err_code_des;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public String getIs_subscribe() {
		return is_subscribe;
	}
	public void setIs_subscribe(String is_subscribe) {
		this.is_subscribe = is_subscribe;
	}
	public String getTrade_type() {
		return trade_type;
	}
	public void setTrade_type(String trade_type) {
		this.trade_type = trade_type;
	}
	public String getBank_type() {
		return bank_type;
	}
	public void setBank_type(String bank_type) {
		this.bank_type = bank_type;
	}
	public String getTotal_fee() {
		return total_fee;
	}
	public void setTotal_fee(String total_fee) {
		this.total_fee = total_fee;
	}
	public String getCash_fee() {
		return cash_fee;
	}
	public void setCash_fee(String cash_fee) {
		this.cash_fee = cash_fee;
	}
	public String getCoupon_fee() {
		return coupon_fee;
	}
	public void setCoupon_fee(String coupon_fee) {
		this.coupon_fee = coupon_fee;
	}
	public String getFee_type() {
		return fee_type;
	}
	public void setFee_type(String fee_type) {
		this.fee_type = fee_type;
	}
	public String getTransaction_id() {
		return transaction_id;
	}
	public void setTransaction_id(String transaction_id) {
		this.transaction_id = transaction_id;
	}
	public String getOut_trade_no() {
		return out_trade_no;
	}
	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
	}
	public String getAttach() {
		return attach;
	}
	public void setAttach(String attach) {
		this.attach = attach;
	}
	public String getTime_end() {
		return time_end;
	}
	public void setTime_end(String time_end) {
		this.time_end = time_end;
	}

	
	
}
