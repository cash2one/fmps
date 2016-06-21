/**
 * 
 */
package cn.com.fubon.pay.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.jeecgframework.core.common.entity.IdEntity;

/**
 * @author qingqu.huang
 *
 */
@Entity
@Table(name = "pay_log")
@PrimaryKeyJoinColumn(name = "id")
public class PayLog extends IdEntity implements Serializable {

	private String out_trade_no;
	private Date reqtime;
	private String type;
	private String total_fee;
	private String result;
	private String errcode;
	private String errdetail;
	private String reqtype;
	private String token;
	private String req_data;
	private String coresystemno;

	/**
	 * @return the req_data
	 */
	@Column(name = "req_data", nullable = false, length = 2000)
	public String getReq_data() {
		return req_data;
	}

	/**
	 * @param req_data
	 *            the req_data to set
	 */
	public void setReq_data(String req_data) {
		this.req_data = req_data;
	}

	/**
	 * @return the coresystemno
	 */
	@Column(name = "coresystemno", nullable = false, length = 32)
	public String getCoresystemno() {
		return coresystemno;
	}

	/**
	 * @param coresystemno
	 *            the coresystemno to set
	 */
	public void setCoresystemno(String coresystemno) {
		this.coresystemno = coresystemno;
	}

	/**
	 * @return the token
	 */
	@Column(name = "token", nullable = false, length = 100)
	public String getToken() {
		return token;
	}

	/**
	 * @param token
	 *            the token to set
	 */
	public void setToken(String token) {
		this.token = token;
	}

	/**
	 * @return the reqtype
	 */
	@Column(name = "reqtype", nullable = false, length = 20)
	public String getReqtype() {
		return reqtype;
	}

	/**
	 * @param reqtype
	 *            the reqtype to set
	 */
	public void setReqtype(String reqtype) {
		this.reqtype = reqtype;
	}

	/**
	 * @return the errcode
	 */
	@Column(name = "errcode", nullable = true, length = 16)
	public String getErrcode() {
		return errcode;
	}

	/**
	 * @param errcode
	 *            the errcode to set
	 */
	public void setErrcode(String errcode) {
		this.errcode = errcode;
	}

	/**
	 * @return the errdetail
	 */
	@Column(name = "errdetail", nullable = true, length = 150)
	public String getErrdetail() {
		return errdetail;
	}

	/**
	 * @param errdetail
	 *            the errdetail to set
	 */
	public void setErrdetail(String errdetail) {
		this.errdetail = errdetail;
	}

	/**
	 * @return the out_trade_no
	 */
	@Column(name = "out_trade_no", nullable = false, length = 32)
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
	 * @return the reqtime
	 */
	@Column(name = "reqtime", nullable = false, length = 255)
	public Date getReqtime() {
		return reqtime;
	}

	/**
	 * @param reqtime
	 *            the reqtime to set
	 */
	public void setReqtime(Date reqtime) {
		this.reqtime = reqtime;
	}

	/**
	 * @return the type
	 */
	@Column(name = "type", nullable = false, length = 20)
	public String getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the total_fee
	 */
	@Column(name = "total_fee", nullable = true, length = 20)
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
	 * @return the result
	 */
	@Column(name = "result", nullable = true, length = 100)
	public String getResult() {
		return result;
	}

	/**
	 * @param result
	 *            the result to set
	 */
	public void setResult(String result) {
		this.result = result;
	}

}
