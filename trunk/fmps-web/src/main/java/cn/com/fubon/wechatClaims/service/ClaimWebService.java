package cn.com.fubon.wechatClaims.service;
/**
 * 调用理赔webservice
 */
import java.util.List;
import cn.com.fubon.webservice.entity.response.FbWSResponse;
import cn.com.fubon.webservice.externl.coresystem.entity.ClaimRequestBody;
import cn.com.fubon.wechatClaims.entity.ReportInfo;

public interface ClaimWebService {
	/**
	 * 调用理赔接口获取报案信息
	 * @param reportorPhoneNumber 报案电话
	 * @param openid
	 * @return
	 */
	public List<ReportInfo> getReportList(String reportorPhoneNumber,
			String openid);
	/**
	 * 调用B2B接口发送理赔照片信息
	 * @return
	 */
	public FbWSResponse getPicture(ClaimRequestBody claimRequestBody);
	/**
	 * 理赔金额确认成功后调用核心接口
	 * @return
	 */
	public FbWSResponse claimFeeConfirmed(String openid,String registNo,
			String confirmStyle);
}
