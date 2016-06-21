/**
 * 
 */
package cn.com.fubon.product.entity;

import java.io.Serializable;
import java.sql.Blob;

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
@Table(name = "weixin_product_affiliated")
@PrimaryKeyJoinColumn(name = "id")
public class Affiliated extends IdEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String productid; // 产品ID
	private String type; // 文档类型
	private String document; // 内容
	private String description; // 标题 
	private String sorting; // 排序 
	

	/**
	 * @return the productid
	 */
	@Column(name = "productid", nullable = false, length = 32)
	public String getProductid() {
		return productid;
	}
	
	/**
	 * @param productid
	 *            the productid to set
	 */
	public void setProductid(String productid) {
		this.productid = productid;
	}

	/**
	 * @return the description
	 */
	@Column(name = "description", nullable = false, length = 200)
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	

	/**
	 * @return the type
	 */
	@Column(name = "type", nullable = false, length = 3)
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
	 * @return the document
	 */
	@Column(name = "document", nullable = false, length = 40000)
	public String getDocument() {
		return document;
	}

	/**
	 * @param document
	 *            the document to set
	 */
	public void setDocument(String document) {
		this.document = document;
	}

	public String getSorting() {
		return sorting;
	}

	public void setSorting(String sorting) {
		this.sorting = sorting;
	}
	
}
