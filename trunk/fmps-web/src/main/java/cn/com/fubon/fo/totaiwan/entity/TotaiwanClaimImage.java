/**
 * 
 */
package cn.com.fubon.fo.totaiwan.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.jeecgframework.core.common.entity.IdEntity;

/**
 * 微信理赔资料信息表
 * 
 * @author guojunjie
 *
 */
@Entity
@Table(name = "weixin_claim_image")
@PrimaryKeyJoinColumn(name = "id")
public class TotaiwanClaimImage extends IdEntity implements
		java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1333344673425843864L;
	private String customername; //
	private String localpath; //
	private String mediaid; //
	private String openid; //
	private String phonenum; //

	private Date uploadtime; //

	private String caseno;//案件号
	private String imgtype;//照片类型
	
	private String status;//发送核心状态,0表示待发送,1表示发送成功,2表示发送失败
	
	
	
	
	/**
	 * @return the phonenum
	 */
	public String getPhonenum() {
		return phonenum;
	}

	/**
	 * @param phonenum the phonenum to set
	 */
	public void setPhonenum(String phonenum) {
		this.phonenum = phonenum;
	}

	@Column(name = "customername")
	public String getCustomername() {
		return customername;
	}

	@Column(name = "localpath")
	public String getLocalpath() {
		return localpath;
	}

	@Column(name = "mediaid")
	public String getMediaid() {
		return mediaid;
	}

	@Column(name = "openid")
	public String getOpenid() {
		return openid;
	}


	@Column(name = "uploadtime")
	public Date getUploadtime() {
		return uploadtime;
	}

	public void setCustomername(String customername) {
		this.customername = customername;
	}

	public void setLocalpath(String localpath) {
		this.localpath = localpath;
	}

	public void setMediaid(String mediaid) {
		this.mediaid = mediaid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public void setUploadtime(Date uploadtime) {
		this.uploadtime = uploadtime;
	}

	@Column(name = "caseno")
	public String getCaseno() {
		return caseno;
	}
	public void setCaseno(String caseno) {
		this.caseno = caseno;
	}

	@Column(name = "imgtype")
	public String getImgtype() {
		return imgtype;
	}
	public void setImgtype(String imgtype) {
		this.imgtype = imgtype;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
