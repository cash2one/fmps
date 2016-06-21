/**
 * 
 */
package cn.com.fubon.rest.entity.response;

import java.util.Date;

/**
 * @author qingqu.huang
 *
 */
public class Trade {

	private String buyer_email;
	private String buyer_id;
	private String discount;
	private String flag_trade_locked;
	private String gmt_create;
	private String gmt_last_modified_time;
	private String gmt_payment;
	private String is_total_fee_adjust;
	private String operator_role;
	private String out_trade_no;
	private String payment_type;
	private String price;
	private String quantity;
	private String seller_email;
	private String seller_id;
	private String subject;
	private String to_buyer_fee;
	private String to_seller_fee;
	private String total_fee;
	private String trade_no;
	private String trade_status;
	private String use_coupon;
	/**
	 * @return the buyer_email
	 */
	public String getBuyer_email() {
		return buyer_email;
	}
	/**
	 * @param buyer_email the buyer_email to set
	 */
	public void setBuyer_email(String buyer_email) {
		this.buyer_email = buyer_email;
	}
	/**
	 * @return the buyer_id
	 */
	public String getBuyer_id() {
		return buyer_id;
	}
	/**
	 * @param buyer_id the buyer_id to set
	 */
	public void setBuyer_id(String buyer_id) {
		this.buyer_id = buyer_id;
	}
	/**
	 * @return the discount
	 */
	public String getDiscount() {
		return discount;
	}
	/**
	 * @param discount the discount to set
	 */
	public void setDiscount(String discount) {
		this.discount = discount;
	}
	/**
	 * @return the flag_trade_locked
	 */
	public String getFlag_trade_locked() {
		return flag_trade_locked;
	}
	/**
	 * @param flag_trade_locked the flag_trade_locked to set
	 */
	public void setFlag_trade_locked(String flag_trade_locked) {
		this.flag_trade_locked = flag_trade_locked;
	}
	
	/**
	 * @return the is_total_fee_adjust
	 */
	public String getIs_total_fee_adjust() {
		return is_total_fee_adjust;
	}
	/**
	 * @param is_total_fee_adjust the is_total_fee_adjust to set
	 */
	public void setIs_total_fee_adjust(String is_total_fee_adjust) {
		this.is_total_fee_adjust = is_total_fee_adjust;
	}
	/**
	 * @return the operator_role
	 */
	public String getOperator_role() {
		return operator_role;
	}
	/**
	 * @param operator_role the operator_role to set
	 */
	public void setOperator_role(String operator_role) {
		this.operator_role = operator_role;
	}
	/**
	 * @return the out_trade_no
	 */
	public String getOut_trade_no() {
		return out_trade_no;
	}
	/**
	 * @param out_trade_no the out_trade_no to set
	 */
	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
	}
	/**
	 * @return the payment_type
	 */
	public String getPayment_type() {
		return payment_type;
	}
	/**
	 * @param payment_type the payment_type to set
	 */
	public void setPayment_type(String payment_type) {
		this.payment_type = payment_type;
	}
	/**
	 * @return the price
	 */
	public String getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(String price) {
		this.price = price;
	}
	/**
	 * @return the quantity
	 */
	public String getQuantity() {
		return quantity;
	}
	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	/**
	 * @return the seller_email
	 */
	public String getSeller_email() {
		return seller_email;
	}
	/**
	 * @param seller_email the seller_email to set
	 */
	public void setSeller_email(String seller_email) {
		this.seller_email = seller_email;
	}
	/**
	 * @return the seller_id
	 */
	public String getSeller_id() {
		return seller_id;
	}
	/**
	 * @param seller_id the seller_id to set
	 */
	public void setSeller_id(String seller_id) {
		this.seller_id = seller_id;
	}
	/**
	 * @return the subject
	 */
	public String getSubject() {
		return subject;
	}
	/**
	 * @param subject the subject to set
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}
	/**
	 * @return the to_buyer_fee
	 */
	public String getTo_buyer_fee() {
		return to_buyer_fee;
	}
	/**
	 * @param to_buyer_fee the to_buyer_fee to set
	 */
	public void setTo_buyer_fee(String to_buyer_fee) {
		this.to_buyer_fee = to_buyer_fee;
	}
	/**
	 * @return the to_seller_fee
	 */
	public String getTo_seller_fee() {
		return to_seller_fee;
	}
	/**
	 * @param to_seller_fee the to_seller_fee to set
	 */
	public void setTo_seller_fee(String to_seller_fee) {
		this.to_seller_fee = to_seller_fee;
	}
	/**
	 * @return the total_fee
	 */
	public String getTotal_fee() {
		return total_fee;
	}
	/**
	 * @param total_fee the total_fee to set
	 */
	public void setTotal_fee(String total_fee) {
		this.total_fee = total_fee;
	}
	/**
	 * @return the trade_no
	 */
	public String getTrade_no() {
		return trade_no;
	}
	/**
	 * @param trade_no the trade_no to set
	 */
	public void setTrade_no(String trade_no) {
		this.trade_no = trade_no;
	}
	/**
	 * @return the trade_status
	 */
	public String getTrade_status() {
		return trade_status;
	}
	/**
	 * @param trade_status the trade_status to set
	 */
	public void setTrade_status(String trade_status) {
		this.trade_status = trade_status;
	}
	/**
	 * @return the use_coupon
	 */
	public String getUse_coupon() {
		return use_coupon;
	}
	/**
	 * @param use_coupon the use_coupon to set
	 */
	public void setUse_coupon(String use_coupon) {
		this.use_coupon = use_coupon;
	}
	/**
	 * @return the gmt_create
	 */
	public String getGmt_create() {
		return gmt_create;
	}
	/**
	 * @param gmt_create the gmt_create to set
	 */
	public void setGmt_create(String gmt_create) {
		this.gmt_create = gmt_create;
	}
	/**
	 * @return the gmt_last_modified_time
	 */
	public String getGmt_last_modified_time() {
		return gmt_last_modified_time;
	}
	/**
	 * @param gmt_last_modified_time the gmt_last_modified_time to set
	 */
	public void setGmt_last_modified_time(String gmt_last_modified_time) {
		this.gmt_last_modified_time = gmt_last_modified_time;
	}
	/**
	 * @return the gmt_payment
	 */
	public String getGmt_payment() {
		return gmt_payment;
	}
	/**
	 * @param gmt_payment the gmt_payment to set
	 */
	public void setGmt_payment(String gmt_payment) {
		this.gmt_payment = gmt_payment;
	}
	
	
}
