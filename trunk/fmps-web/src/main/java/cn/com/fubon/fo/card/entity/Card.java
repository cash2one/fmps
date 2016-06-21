/**
 * 
 */
package cn.com.fubon.fo.card.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.jeecgframework.core.common.entity.IdEntity;

/**
 * 微信卡单
 * 
 * @author qingqu.huang
 *
 */
@Entity
@Table(name = "weixin_card_info")
@PrimaryKeyJoinColumn(name = "id")
public class Card extends IdEntity implements java.io.Serializable {
	private String card_no; // 卡号
	private Date imputdate; // 插入日期
	private String result_status; // 结果
	private String card_version_code; // 卡版本代码
	private String validate; // 有效性
	private String status; // 当前状态
	private String not_pass_reason; // 归属机构
	private Date startdate; // 保单起始日期
	private Date enddate; // 保单结束日期
	private String openid; // 微信openid
	private String comcode;
	private String comname;
	private String comaddress;
	
	/**
	 * @return the comcode
	 */
	@Column(name = "comcode", nullable = false, length = 20)
	public String getComcode() {
		return comcode;
	}
	/**
	 * @param comcode the comcode to set
	 */
	public void setComcode(String comcode) {
		this.comcode = comcode;
	}
	/**
	 * @return the comname
	 */
	@Column(name = "comname", nullable = false, length = 50)
	public String getComname() {
		return comname;
	}
	/**
	 * @param comname the comname to set
	 */
	public void setComname(String comname) {
		this.comname = comname;
	}
	/**
	 * @return the comaddress
	 */
	@Column(name = "comaddress", nullable = false, length = 100)
	public String getComaddress() {
		return comaddress;
	}
	/**
	 * @param comaddress the comaddress to set
	 */
	public void setComaddress(String comaddress) {
		this.comaddress = comaddress;
	}
	/**
	 * @return the card_no
	 */
	@Column(name = "card_no", nullable = false, length = 50)
	public String getCard_no() {
		return card_no;
	}
	/**
	 * @param card_no the card_no to set
	 */
	public void setCard_no(String card_no) {
		this.card_no = card_no;
	}
	/**
	 * @return the imputdate
	 */
	@Column(name = "imputdate", nullable = false, length = 255)
	public Date getImputdate() {
		return imputdate;
	}
	/**
	 * @param imputdate the imputdate to set
	 */
	public void setImputdate(Date imputdate) {
		this.imputdate = imputdate;
	}
	/**
	 * @return the result_status
	 */
	@Column(name = "result_status", nullable = false, length = 5)
	public String getResult_status() {
		return result_status;
	}
	/**
	 * @param result_status the result_status to set
	 */
	public void setResult_status(String result_status) {
		this.result_status = result_status;
	}
	/**
	 * @return the card_version_code
	 */
	@Column(name = "card_version_code", nullable = false, length = 50)
	public String getCard_version_code() {
		return card_version_code;
	}
	/**
	 * @param card_version_code the card_version_code to set
	 */
	public void setCard_version_code(String card_version_code) {
		this.card_version_code = card_version_code;
	}
	/**
	 * @return the validate
	 */
	@Column(name = "validate", nullable = false, length = 5)
	public String getValidate() {
		return validate;
	}
	/**
	 * @param validate the validate to set
	 */
	public void setValidate(String validate) {
		this.validate = validate;
	}
	
	@Column(name = "status", nullable = false, length = 5)
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	/**
	 * @return the not_pass_reason
	 */
	@Column(name = "not_pass_reason", nullable = false, length = 150)
	public String getNot_pass_reason() {
		return not_pass_reason;
	}
	/**
	 * @param not_pass_reason the not_pass_reason to set
	 */
	public void setNot_pass_reason(String not_pass_reason) {
		this.not_pass_reason = not_pass_reason;
	}
	/**
	 * @return the startdate
	 */
	@Column(name = "startdate", nullable = false, length = 255)
	public Date getStartdate() {
		return startdate;
	}
	/**
	 * @param startdate the startdate to set
	 */
	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}
	/**
	 * @return the enddate
	 */
	@Column(name = "enddate", nullable = false, length = 255)
	public Date getEnddate() {
		return enddate;
	}
	/**
	 * @param enddate the enddate to set
	 */
	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}
	/**
	 * @return the openid
	 */
	@Column(name = "openid", nullable = false, length = 100)
	public String getOpenid() {
		return openid;
	}
	/**
	 * @param openid the openid to set
	 */
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	
}
