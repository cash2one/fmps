/**
 * 
 */
package cn.com.fubon.common.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.jeecgframework.core.common.entity.IdEntity;

/**
 * @author qingqu.huang
 *
 */
@Entity
@Table(name = "content_template")
@PrimaryKeyJoinColumn(name = "id")
public class Contenttemplate extends IdEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8120706789039090537L;

	private String templatemsg;
	private String type;
	private String status;
	private String title;
	private Date createtime;

	public String getTemplatemsg() {
		return templatemsg;
	}

	public void setTemplatemsg(String templatemsg) {
		this.templatemsg = templatemsg;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

}
