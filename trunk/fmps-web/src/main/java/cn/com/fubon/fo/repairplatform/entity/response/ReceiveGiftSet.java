package cn.com.fubon.fo.repairplatform.entity.response;

/**
 * 活动券详情
 * 
 * @author yaoming.zhang
 */
public class ReceiveGiftSet {

	private String giftsetDetailId;//券detail ID(主键)
	private String giftsetname;//礼包名称
	private String giftsetid;//礼包id
	private String name;//券名称
	private String repairlogo;//维修厂logo
	private String deepcolor;//深颜色
	private String lightcolor;//浅颜色
	private String providerepairname;//维修厂名称
	private String startdate;//开始时间
	private String enddate;//结束时间
	private String areaname;//所在地区
	private String cardtype;//券类型
	private String receivedate;//领券时间
	
	public String getGiftsetDetailId() {
		return giftsetDetailId;
	}
	public void setGiftsetDetailId(String giftsetDetailId) {
		this.giftsetDetailId = giftsetDetailId;
	}
	public String getGiftsetname() {
		return giftsetname;
	}
	public void setGiftsetname(String giftsetname) {
		this.giftsetname = giftsetname;
	}
	public String getGiftsetid() {
		return giftsetid;
	}
	public void setGiftsetid(String giftsetid) {
		this.giftsetid = giftsetid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRepairlogo() {
		return repairlogo;
	}
	public void setRepairlogo(String repairlogo) {
		this.repairlogo = repairlogo;
	}
	public String getDeepcolor() {
		return deepcolor;
	}
	public void setDeepcolor(String deepcolor) {
		this.deepcolor = deepcolor;
	}
	public String getLightcolor() {
		return lightcolor;
	}
	public void setLightcolor(String lightcolor) {
		this.lightcolor = lightcolor;
	}
	public String getProviderepairname() {
		return providerepairname;
	}
	public void setProviderepairname(String providerepairname) {
		this.providerepairname = providerepairname;
	}
	public String getStartdate() {
		return startdate;
	}
	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}
	public String getEnddate() {
		return enddate;
	}
	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}
	public String getAreaname() {
		return areaname;
	}
	public void setAreaname(String areaname) {
		this.areaname = areaname;
	}
	public String getCardtype() {
		return cardtype;
	}
	public void setCardtype(String cardtype) {
		this.cardtype = cardtype;
	}
	public String getReceivedate() {
		return receivedate;
	}
	public void setReceivedate(String receivedate) {
		this.receivedate = receivedate;
	}
	
}
