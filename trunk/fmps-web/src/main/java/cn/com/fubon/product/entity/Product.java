package cn.com.fubon.product.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import org.jeecgframework.core.common.entity.IdEntity;

/**
 * 
 * @author qingqu.huang
 *
 */
@Entity
@Table(name = "weixin_product")
@PrimaryKeyJoinColumn(name = "id")
public class Product extends IdEntity implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Date createtime; // 创建时间
	private String imagehref; // 图片链接
	private String imagename; // 图片名称
	private String internalcode; // 产品代码
	private String iscard; // 是否卡单
	private String occupationcategory; // 职业类别
	private String occupationcode; // 职业代码
	private String producticon; // 图标链接
	private String productname; // 产品名称
	private String delivery; // 保单寄送方式（1、无  2、仅电子保单 3、仅纸质保单 4、电子保单、纸质保单可选）
	private String status; // 状态
	private String salemode; // 销售方式
	private String feature; // 商品特色
	private int type; // 类型
	private String occupationLevels; // 适用职业范围
	
	private String riskshortname;

	/**
	 * @return the occupationLevels
	 */
	@Column(name = "occupationLevels", nullable = true, length = 20)
	public String getOccupationLevels() {
		return occupationLevels;
	}

	/**
	 * @param occupationLevels
	 *            the occupationLevels to set
	 */
	public void setOccupationLevels(String occupationLevels) {
		this.occupationLevels = occupationLevels;
	}

	/**
	 * @return the salemode
	 */
	@Column(name = "salemode", nullable = true, length = 20)
	public String getSalemode() {
		return salemode;
	}

	/**
	 * @param salemode
	 *            the salemode to set
	 */
	public void setSalemode(String salemode) {
		this.salemode = salemode;
	}

	/**
	 * @return the feature
	 */
	@Column(name = "feature", nullable = true, length = 22)
	public String getFeature() {
		return feature;
	}

	/**
	 * @param feature
	 *            the feature to set
	 */
	public void setFeature(String feature) {
		this.feature = feature;
	}

	@Column(name = "createtime", nullable = false, length = 255)
	public Date getCreatetime() {
		return createtime;
	}

	/**
	 * @return the imagehref
	 */
	@Column(name = "imagehref", nullable = false, length = 255)
	public String getImagehref() {
		return imagehref;
	}

	/**
	 * @return the imagename
	 */
	@Column(name = "imagename", nullable = false, length = 255)
	public String getImagename() {
		return imagename;
	}

	/**
	 * @return the internalcode
	 */
	@Column(name = "internalcode", nullable = false, length = 20)
	public String getInternalcode() {
		return internalcode;
	}

	/**
	 * @return the iscard
	 */
	@Column(name = "iscard", nullable = false, length = 2)
	public String getIscard() {
		return iscard;
	}

	public String getOccupationcategory() {
		return occupationcategory;
	}

	public String getOccupationcode() {
		return occupationcode;
	}

	@Column(name = "producticon")
	public String getProducticon() {
		return producticon;
	}

	@Column(name = "productname", nullable = false, length = 30)
	public String getProductname() {
		return productname;
	}

	@Column(name = "status", nullable = false, length = 5)
	public String getStatus() {
		return status;
	}

	/**
	 * @return the type
	 */
	@Column(name = "type", nullable = false, length = 6)
	public int getType() {
		return type;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	/**
	 * @param imagehref
	 *            the imagehref to set
	 */
	public void setImagehref(String imagehref) {
		this.imagehref = imagehref;
	}

	/**
	 * @param imagename
	 *            the imagename to set
	 */
	public void setImagename(String imagename) {
		this.imagename = imagename;
	}

	/**
	 * @param internalcode
	 *            the internalcode to set
	 */
	public void setInternalcode(String internalcode) {
		this.internalcode = internalcode;
	}

	/**
	 * @param iscard
	 *            the iscard to set
	 */
	public void setIscard(String iscard) {
		this.iscard = iscard;
	}

	public void setOccupationcategory(String occupationcategory) {
		this.occupationcategory = occupationcategory;
	}

	public void setOccupationcode(String occupationcode) {
		this.occupationcode = occupationcode;
	}

	public void setProducticon(String producticon) {
		this.producticon = producticon;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(int type) {
		this.type = type;
	}

	@Column(name = "riskshortname", nullable = false)
	public String getRiskshortname(){
		return riskshortname;
	}

	public void setRiskshortname(String riskshortname){
		this.riskshortname = riskshortname;
	}

	public String getDelivery() {
		return delivery;
	}

	public void setDelivery(String delivery) {
		this.delivery = delivery;
	}
	
}
