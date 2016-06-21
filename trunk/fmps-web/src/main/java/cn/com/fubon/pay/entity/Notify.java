/**
 * 
 */
package cn.com.fubon.pay.entity;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.jeecgframework.core.common.entity.IdEntity;

/**
 * @author qingqu.huang
 *
 */
@Entity
@Table(name = "pay_notify")
@PrimaryKeyJoinColumn(name = "id")
@XmlRootElement(name = "notify")
@XmlAccessorType(XmlAccessType.FIELD)
public class Notify extends IdEntity implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String payment_type; // 支付类型
	private String subject; // 商品名称
	private String trade_no; // 交易号
	private String buyer_email; // 买家账号
	private String gmt_create; // 交易创建时间
	private String notify_type; // 通知类型
	private String quantity; // 购买数量 T
	private String out_trade_no; // 订单号
	private String notify_time; // 通知时间
	private String seller_id; // 卖家ID
	private String trade_status; // 交易状态
	private String is_total_fee_adjust; // 是否调整总价 T
	private String total_fee; // 总价
	private String gmt_payment; // 付款时间
	private String seller_email; // 卖家账号
	private String gmt_close; // 交易关闭时间
	private Double price; // 单价 T
	private String buyer_id; // 买家ID
	private String notify_id; // 通知ID
	private String use_coupon; // 是否使用红包买家 T
	private String refund_status; // 退款状态
	private String gmt_refund; // 退款时间

	/**
	 * @return the seller_id
	 */
	public String getSeller_id() {
		return seller_id;
	}

	/**
	 * @param seller_id
	 *            the seller_id to set
	 */
	public void setSeller_id(String seller_id) {
		this.seller_id = seller_id;
	}

	/**
	 * @return the trade_status
	 */
	public String getTrade_status() {
		return trade_status;
	}

	/**
	 * @param trade_status
	 *            the trade_status to set
	 */
	public void setTrade_status(String trade_status) {
		this.trade_status = trade_status;
	}

	/**
	 * @return the is_total_fee_adjust
	 */
	@Transient
	public String getIs_total_fee_adjust() {
		return is_total_fee_adjust;
	}

	/**
	 * @param is_total_fee_adjust
	 *            the is_total_fee_adjust to set
	 */
	public void setIs_total_fee_adjust(String is_total_fee_adjust) {
		this.is_total_fee_adjust = is_total_fee_adjust;
	}

	/**
	 * @return the total_fee
	 */
	public String getTotal_fee() {
		return total_fee;
	}

	/**
	 * @param total_fee
	 *            the total_fee to set
	 */
	public void setTotal_fee(String total_fee) {
		this.total_fee = total_fee;
	}

	/**
	 * @return the gmt_payment
	 */
	public String getGmt_payment() {
		return gmt_payment;
	}

	/**
	 * @param gmt_payment
	 *            the gmt_payment to set
	 */
	public void setGmt_payment(String gmt_payment) {
		this.gmt_payment = gmt_payment;
	}

	/**
	 * @return the seller_email
	 */
	public String getSeller_email() {
		return seller_email;
	}

	/**
	 * @param seller_email
	 *            the seller_email to set
	 */
	public void setSeller_email(String seller_email) {
		this.seller_email = seller_email;
	}

	/**
	 * @return the gmt_close
	 */
	public String getGmt_close() {
		return gmt_close;
	}

	/**
	 * @param gmt_close
	 *            the gmt_close to set
	 */
	public void setGmt_close(String gmt_close) {
		this.gmt_close = gmt_close;
	}

	/**
	 * @return the price
	 */
	@Transient
	public Double getPrice() {
		return price;
	}

	/**
	 * @param price
	 *            the price to set
	 */
	public void setPrice(Double price) {
		this.price = price;
	}

	/**
	 * @return the buyer_id
	 */
	public String getBuyer_id() {
		return buyer_id;
	}

	/**
	 * @param buyer_id
	 *            the buyer_id to set
	 */
	public void setBuyer_id(String buyer_id) {
		this.buyer_id = buyer_id;
	}

	/**
	 * @return the notify_id
	 */
	public String getNotify_id() {
		return notify_id;
	}

	/**
	 * @param notify_id
	 *            the notify_id to set
	 */
	public void setNotify_id(String notify_id) {
		this.notify_id = notify_id;
	}

	/**
	 * @return the use_coupon
	 */
	@Transient
	public String getUse_coupon() {
		return use_coupon;
	}

	/**
	 * @param use_coupon
	 *            the use_coupon to set
	 */
	public void setUse_coupon(String use_coupon) {
		this.use_coupon = use_coupon;
	}

	/**
	 * @return the refund_status
	 */
	@Transient
	public String getRefund_status() {
		return refund_status;
	}

	/**
	 * @param refund_status
	 *            the refund_status to set
	 */
	public void setRefund_status(String refund_status) {
		this.refund_status = refund_status;
	}

	/**
	 * @return the gmt_refund
	 */
	@Transient
	public String getGmt_refund() {
		return gmt_refund;
	}

	/**
	 * @param gmt_refund
	 *            the gmt_refund to set
	 */
	public void setGmt_refund(String gmt_refund) {
		this.gmt_refund = gmt_refund;
	}

	/**
	 * @return the notify_time
	 */
	public String getNotify_time() {
		return notify_time;
	}

	/**
	 * @param notify_time
	 *            the notify_time to set
	 */
	public void setNotify_time(String notify_time) {
		this.notify_time = notify_time;
	}

	/**
	 * @return the out_trade_no
	 */
	public String getOut_trade_no() {
		return out_trade_no;
	}

	/**
	 * @param out_trade_no
	 *            the out_trade_no to set
	 */
	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
	}

	/**
	 * @return the quantity
	 */
	@Transient
	public String getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity
	 *            the quantity to set
	 */
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	/**
	 * @return the subject
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * @param subject
	 *            the subject to set
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}

	/**
	 * @return the trade_no
	 */
	public String getTrade_no() {
		return trade_no;
	}

	/**
	 * @param trade_no
	 *            the trade_no to set
	 */
	public void setTrade_no(String trade_no) {
		this.trade_no = trade_no;
	}

	/**
	 * @return the buyer_email
	 */
	public String getBuyer_email() {
		return buyer_email;
	}

	/**
	 * @param buyer_email
	 *            the buyer_email to set
	 */
	public void setBuyer_email(String buyer_email) {
		this.buyer_email = buyer_email;
	}

	/**
	 * @return the gmt_create
	 */
	public String getGmt_create() {
		return gmt_create;
	}

	/**
	 * @param gmt_create
	 *            the gmt_create to set
	 */
	public void setGmt_create(String gmt_create) {
		this.gmt_create = gmt_create;
	}

	/**
	 * @return the notify_type
	 */
	@Transient
	public String getNotify_type() {
		return notify_type;
	}

	/**
	 * @param notify_type
	 *            the notify_type to set
	 */
	public void setNotify_type(String notify_type) {
		this.notify_type = notify_type;
	}

	/**
	 * @return the payment_type
	 */
	public String getPayment_type() {
		return payment_type;
	}

	/**
	 * @param payment_type
	 *            the payment_type to set
	 */
	public void setPayment_type(String payment_type) {
		this.payment_type = payment_type;
	}

}
