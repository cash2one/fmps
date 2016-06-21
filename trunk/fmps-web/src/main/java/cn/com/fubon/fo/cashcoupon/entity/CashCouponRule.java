/**
 * 
 */
package cn.com.fubon.fo.cashcoupon.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.jeecgframework.core.common.entity.IdEntity;

/**
 * @author qingqu.huang
 *
 */
@Entity
@Table(name = "weixin_cashcoupon_rule")
@PrimaryKeyJoinColumn(name = "id")
public class CashCouponRule extends IdEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String rulename;
	private String huodongid;
	private int num;
	private Float maxvalue;
	private Float minvalue;
	private String position;

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getRulename() {
		return rulename;
	}

	public void setRulename(String rulename) {
		this.rulename = rulename;
	}

	public String getHuodongid() {
		return huodongid;
	}

	public void setHuodongid(String huodongid) {
		this.huodongid = huodongid;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public Float getMaxvalue() {
		return maxvalue;
	}

	public void setMaxvalue(Float maxvalue) {
		this.maxvalue = maxvalue;
	}

	public Float getMinvalue() {
		return minvalue;
	}

	public void setMinvalue(Float minvalue) {
		this.minvalue = minvalue;
	}

}
