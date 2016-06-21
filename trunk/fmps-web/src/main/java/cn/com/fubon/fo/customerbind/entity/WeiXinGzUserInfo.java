package cn.com.fubon.fo.customerbind.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.jeecgframework.core.common.entity.IdEntity;
import weixin.guanjia.account.entity.WeixinAccountEntity;

/**
 * 微信关注用户信息表weixin_gzuserinfo
 * @author fangfang.guo
 * @20140915
 *
 */

@Entity
@Table(name="weixin_gzuserinfo")
@PrimaryKeyJoinColumn(name = "id")
public class WeiXinGzUserInfo extends IdEntity{
	
	//是否关注 1:关注 0:取消关注
	private String subscribe;
	//微信号
	private String openid;
	//昵称
	private String nickname;
	//性别 1:男，2:女，0:未知
	private String sex;
	//城市
	private String city;
	//省份
	private String province;
	//国家
	private String country;
	//用户头像
	private String headimgurl;
	//备注名称
	private String bzname;
	//组ID
	private String groupid;
	//关注时间
	@Temporal(TemporalType.DATE)
	private Date subscribe_time;
	//添加时间
	@Temporal(TemporalType.DATE)
	private Date addtime;
	//商铺ID
	private WeixinAccountEntity account;
	
	//客户代码
	private String customercode;
	//客户名称
	private String customercname;
	//证件号码
	private String identifynumber;
	//手机号
	private String mobile;
	//车牌号
	private String licenseno;
	//认证类型 car:车牌号认证;other:其他方式认证
	private String bindType;
	//认证时间
	@Temporal(TemporalType.DATE)
	private Date bindTime;
	
	//客户性别 M:男,F:女
	private String customerSex;
	//客户出生日期
	@Temporal(TemporalType.DATE)
	private Date customerBirthday;
	//认证证件类型
	private String identifyType;
	
	//扫码预设KEY
	private String EventKey;
	
	@Column(name="customerSex")
	public String getCustomerSex() {
		return customerSex;
	}
	public void setCustomerSex(String customerSex) {
		this.customerSex = customerSex;
	}
	@Column(name="customerBirthday")
	public Date getCustomerBirthday() {
		return customerBirthday;
	}
	public void setCustomerBirthday(Date customerBirthday) {
		this.customerBirthday = customerBirthday;
	}
	@Column(name="identifyType")
	public String getIdentifyType() {
		return identifyType;
	}
	public void setIdentifyType(String identifyType) {
		this.identifyType = identifyType;
	}
	@Column(name="subscribe")
	public String getSubscribe() {
		return subscribe;
	}
	public void setSubscribe(String subscribe) {
		this.subscribe = subscribe;
	}
	
	@Column(name="openid")
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	
	@Column(name="nickname")
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	@Column(name="sex")
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	@Column(name="city")
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	@Column(name="province")
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	
	@Column(name="country")
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	@Column(name="headimgurl")
	public String getHeadimgurl() {
		return headimgurl;
	}
	public void setHeadimgurl(String headimgurl) {
		this.headimgurl = headimgurl;
	}
	
	@Column(name="bzName")
	public String getBzname() {
		return bzname;
	}
	public void setBzname(String bzname) {
		this.bzname = bzname;
	}
	
	@Column(name="groupId")
	public String getGroupid() {
		return groupid;
	}
	public void setGroupid(String groupid) {
		this.groupid = groupid;
	}
	
	@Column(name="subscribe_time")
	public Date getSubscribe_time() {
		return subscribe_time;
	}
	public void setSubscribe_time(Date subscribe_time) {
		this.subscribe_time = subscribe_time;
	}
	@Column(name="addtime")
	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "account_id")
	public WeixinAccountEntity getAccount() {
		return account;
	}
	public void setAccount(WeixinAccountEntity account) {
		this.account = account;
	}
	public String getCustomercode() {
		return customercode;
	}
	public void setCustomercode(String customercode) {
		this.customercode = customercode;
	}
	public String getCustomercname() {
		return customercname;
	}
	public void setCustomercname(String customercname) {
		this.customercname = customercname;
	}
	public String getIdentifynumber() {
		return identifynumber;
	}
	public void setIdentifynumber(String identifynumber) {
		this.identifynumber = identifynumber;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getLicenseno() {
		return licenseno;
	}
	public void setLicenseno(String licenseno) {
		this.licenseno = licenseno;
	}
	public String getBindType() {
		return bindType;
	}
	public void setBindType(String bindType) {
		this.bindType = bindType;
	}
	public Date getBindTime() {
		return bindTime;
	}
	public void setBindTime(Date bindTime) {
		this.bindTime = bindTime;
	}
	public String getEventKey() {
		return EventKey;
	}
	public void setEventKey(String eventKey) {
		EventKey = eventKey;
	}
	
}
