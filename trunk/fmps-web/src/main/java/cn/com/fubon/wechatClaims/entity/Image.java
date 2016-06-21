package cn.com.fubon.wechatClaims.entity;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 理赔照片
 * @author fangfang.guo
 *
 */
@XStreamAlias("image")
public class Image {
	
	//车牌号
	private String licenseNo;
	//图片上传类型
	private String imgUploadType;
	//图片名称
	private String imageName;
	//图片格式
	private String imageForm;
	//图片大小 单位KB
	private String imageSize;
	//图片上传日期 YYYY-MM-DD
	private String imageUploadDate;
	//图片上传时间 HH：MM：SS
	private String imageUploadTime;
	
	public String getLicenseNo() {
		return licenseNo;
	}
	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}
	public String getImgUploadType() {
		return imgUploadType;
	}
	public void setImgUploadType(String imgUploadType) {
		this.imgUploadType = imgUploadType;
	}
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	public String getImageForm() {
		return imageForm;
	}
	public void setImageForm(String imageForm) {
		this.imageForm = imageForm;
	}
	public String getImageSize() {
		return imageSize;
	}
	public void setImageSize(String imageSize) {
		this.imageSize = imageSize;
	}
	public String getImageUploadDate() {
		return imageUploadDate;
	}
	public void setImageUploadDate(String imageUploadDate) {
		this.imageUploadDate = imageUploadDate;
	}
	public String getImageUploadTime() {
		return imageUploadTime;
	}
	public void setImageUploadTime(String imageUploadTime) {
		this.imageUploadTime = imageUploadTime;
	}
	
}
