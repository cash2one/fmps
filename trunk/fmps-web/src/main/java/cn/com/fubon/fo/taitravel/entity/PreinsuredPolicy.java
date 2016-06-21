/**
 * 
 */
package cn.com.fubon.fo.taitravel.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.jeecgframework.core.common.entity.IdEntity;

/**
 * (学生) (微信在线预约)
 * 
 * @author guojunjie
 *
 */
@Entity
@Table(name = "weixin_preinsured_policy")
@PrimaryKeyJoinColumn(name = "id")
public class PreinsuredPolicy extends IdEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4471960658115109291L;
	private String block; // 所在地区
	private Date createtime; // 创建时间
	private String name; // 姓名
	private String openid; // openid
	private String telephone; // 手机

	@Column(name = "block")
	public String getBlock() {
		return block;
	}

	/**
	 * @return the createtime
	 */
	@Column(name = "createtime", nullable = false, length = 255)
	public Date getCreatetime() {
		return createtime;
	}

	@Column(name = "name")
	public String getName() {
		return name;
	}

	@Column(name = "openid")
	public String getOpenid() {
		return openid;
	}

	@Column(name = "telephone")
	public String getTelephone() {
		return telephone;
	}

	public void setBlock(String block) {
		this.block = block;
	}

	/**
	 * @param createtime
	 *            the createtime to set
	 */
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

}
