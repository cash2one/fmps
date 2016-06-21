package cn.com.fubon.webservice.entity.request;

import java.util.List;

import cn.com.fubon.fo.claim.entity.NotCarImage;

/**
 * 非车理赔接口用到的RequestBody
 * @author xiaomei.wu
 *
 */
public class FbClaimNotCarRequestBody extends RequestBody{
	/**
	 * 发送理赔照片信息至核心接口
	 */
	//报案号
	private String registNo;
	//理赔照片list
	private List<NotCarImage> imageList;
	
	public String getRegistNo() {
		return registNo;
	}
	public void setRegistNo(String registNo) {
		this.registNo = registNo;
	}
	public List<NotCarImage> getImageList() {
		return imageList;
	}
	public void setImageList(List<NotCarImage> imageList) {
		this.imageList = imageList;
	}
	
}
