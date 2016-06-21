package weixin.guanjia.base.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import net.sf.json.JSONObject;

import org.jeecgframework.core.common.entity.IdEntity;


@Entity
@Table(name = "weixin_openid")
public class WeixinOpenid extends IdEntity {

	//微信号
	private String openid;

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	
	
	
}
