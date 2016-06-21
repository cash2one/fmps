package cn.com.fubon.fo.claim.service;
/**
 * 调用理赔webservice
 */
import java.util.List;

import cn.com.fubon.fo.claim.entity.NotCarReportInfo;
import cn.com.fubon.webservice.entity.response.FbWSResponse;
import cn.com.fubon.webservice.externl.coresystem.entity.ClaimNotCarRequestBody;
public interface NotCarClaimWebService {
	/**
	 * 调用理赔接口获取非车报案信息
	 * @param reportorPhoneNumber 报案电话
	 * @param openid
	 * @return
	 */
	public List<NotCarReportInfo> getReportNotCarList(String reportorPhoneNumber,
			String openid);
	/**
	 * 调用B2B接口发送非车理赔照片信息
	 * @return
	 */
	public FbWSResponse getNotCarPicture(ClaimNotCarRequestBody claimNotCarRequestBody);
}
