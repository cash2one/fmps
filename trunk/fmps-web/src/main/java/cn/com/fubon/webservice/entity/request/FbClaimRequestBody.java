package cn.com.fubon.webservice.entity.request;

import java.util.List;

import cn.com.fubon.wechatClaims.entity.Image;

/**
 * 理赔接口用到的RequestBody
 * @author fangfang.guo
 *
 */
public class FbClaimRequestBody extends RequestBody{
	/**
	 * 根据报案电话获取报案信息接口
	 */
	//报案电话
	private String reportPhoneNo;
	//openid
	private String weChatId;
	
	
	/**
	 * 发送理赔照片信息至核心接口
	 */
	//报案号
	private String registNo;
	//理赔照片list
	private List<Image> imageList;
	
	/**
	 * 理赔金额确认成功后调核心接口
	 */
	//理赔金额确认日期
	private String confirmDate;
	//理赔金额确认时间
	private String confirmTime;
	//确认方式,1-人工确认;0-系统自动确认
	private String confirmStyle;
	
	public String getConfirmDate() {
		return confirmDate;
	}
	public void setConfirmDate(String confirmDate) {
		this.confirmDate = confirmDate;
	}
	public String getConfirmTime() {
		return confirmTime;
	}
	public void setConfirmTime(String confirmTime) {
		this.confirmTime = confirmTime;
	}
	public String getConfirmStyle() {
		return confirmStyle;
	}
	public void setConfirmStyle(String confirmStyle) {
		this.confirmStyle = confirmStyle;
	}
	public String getReportPhoneNo() {
		return reportPhoneNo;
	}
	public void setReportPhoneNo(String reportPhoneNo) {
		this.reportPhoneNo = reportPhoneNo;
	}
	public String getWeChatId() {
		return weChatId;
	}
	public void setWeChatId(String weChatId) {
		this.weChatId = weChatId;
	}
	public String getRegistNo() {
		return registNo;
	}
	public void setRegistNo(String registNo) {
		this.registNo = registNo;
	}
	public List<Image> getImageList() {
		return imageList;
	}
	public void setImageList(List<Image> imageList) {
		this.imageList = imageList;
	}
	
}
