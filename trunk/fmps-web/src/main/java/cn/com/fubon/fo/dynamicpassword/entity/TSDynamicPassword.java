package cn.com.fubon.fo.dynamicpassword.entity;

import java.sql.Timestamp;
import javax.persistence.Entity;
import javax.persistence.Table;
import org.jeecgframework.core.common.entity.IdEntity;

@Entity
@Table(name="t_s_dynamic_password")
public class TSDynamicPassword extends IdEntity{
	//发送对象
	private String send_to;
	//动态密码
	private String dynamic_password;
	//失效时间
	private Timestamp invalid_time;
	//输入错误次数
	private Integer input_error_count;
	//状态,是否已使用 0:未使用 1:已使用
	private String status;
	//业务类型,验证码用于不同的用途便于后续扩展,100:微信用户绑定
	private String type;
	private Timestamp create_time;
	
	public String getSend_to() {
		return send_to;
	}
	public void setSend_to(String send_to) {
		this.send_to = send_to;
	}
	public String getDynamic_password() {
		return dynamic_password;
	}
	public void setDynamic_password(String dynamic_password) {
		this.dynamic_password = dynamic_password;
	}
	public Timestamp getInvalid_time() {
		return invalid_time;
	}
	public void setInvalid_time(Timestamp invalid_time) {
		this.invalid_time = invalid_time;
	}
	public Integer getInput_error_count() {
		return input_error_count;
	}
	public void setInput_error_count(Integer input_error_count) {
		this.input_error_count = input_error_count;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Timestamp getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Timestamp create_time) {
		this.create_time = create_time;
	}

}
