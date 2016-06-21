/**
 * 
 */
package cn.com.fubon.bo.wxtemplatemessage.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import org.jeecgframework.core.common.entity.IdEntity;
import weixin.guanjia.account.entity.WeixinAccountEntity;

/**
 * @author binbin.wang
 *
 */
@Entity
@Table(name = "weixin_template")
@PrimaryKeyJoinColumn(name = "id")
public class WeiXinTemplate extends IdEntity implements Serializable{

	private static final long serialVersionUID = 7682280108652283793L;

	private String title;
	private String content;
	private String contentDemo;
	private String templateId;
	private String bussinessType;
	private Integer status;
	private Date createTime;
	private Date updateTime;

	private WeixinAccountEntity account;

	@Column(name = "title",length = 200)
	public String getTitle(){
		return title;
	}

	public void setTitle(String title){
		this.title = title;
	}

	@Column(name = "content",length = 400)
	public String getContent(){
		return content;
	}

	public void setContent(String content){
		this.content = content;
	}

	@Column(name = "content_demo",length = 1000)
	public String getContentDemo(){
		return contentDemo;
	}

	public void setContentDemo(String contentDemo){
		this.contentDemo = contentDemo;
	}

	@Column(name = "template_id",length = 50)
	public String getTemplateId(){
		return templateId;
	}

	public void setTemplateId(String templateId){
		this.templateId = templateId;
	}

	@Column(name = "bussiness_type",length = 5)
	public String getBussinessType(){
		return bussinessType;
	}

	public void setBussinessType(String bussinessType){
		this.bussinessType = bussinessType;
	}

	@Column(name = "status",length = 3)
	public Integer getStatus(){
		return status;
	}

	public void setStatus(Integer status){
		this.status = status;
	}

	@Column(name = "create_time",length = 3)
	public Date getCreateTime(){
		return createTime;
	}

	public void setCreateTime(Date createTime){
		this.createTime = createTime;
	}

	@Column(name = "update_time",length = 3)
	public Date getUpdateTime(){
		return updateTime;
	}

	public void setUpdateTime(Date updateTime){
		this.updateTime = updateTime;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "account_id")
	public WeixinAccountEntity getAccount(){
		return account;
	}

	public void setAccount(WeixinAccountEntity account){
		this.account = account;
	}

}
