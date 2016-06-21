package weixin.popular.api;

import java.nio.charset.Charset;

import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.StringEntity;
import org.jeecgframework.core.util.StringUtil;

import weixin.popular.bean.BaseResult;
import weixin.popular.bean.KfSession;
import weixin.popular.bean.SessionInfo;
import weixin.popular.client.JsonResponseHandler;
import weixin.popular.util.JsonUtil;

public class KfSessionAPI extends BaseAPI {

	/**
	 * 获取客户的会话信息
	 * 
	 * @param access_token
	 * @param openid
	 * @return
	 */

	public KfSession GetCustomerSession(String access_token, String openid) {
		HttpUriRequest httpUriRequest = RequestBuilder.get()
				.setUri(BASE_URI + "/customservice/kfsession/getsession")
				.addParameter("access_token", access_token)
				.addParameter("openid", openid).build();
		return localHttpClient.execute(httpUriRequest,
				JsonResponseHandler.createResponseHandler(KfSession.class));
	}

	public BaseResult CloseSession(String access_token, SessionInfo sessionInfo) {
		String sessionInfoJson = JsonUtil.toJSONString(sessionInfo);
		HttpUriRequest httpUriRequest = RequestBuilder
				.post()
				.setHeader(jsonHeader)
				.setUri(BASE_URI + "/customservice/kfsession/close")
				.addParameter("access_token", access_token)
				.setEntity(
						new StringEntity(sessionInfoJson, Charset
								.forName("utf-8"))).build();
		return localHttpClient.execute(httpUriRequest,
				JsonResponseHandler.createResponseHandler(BaseResult.class));
	}

	public static void main(String[] args) {

		String access_token = "b6U44P6oc1DpxFNTdvUOtSX2mZdfs2hI0g57OVVhfIcLfMMI9IFboLPo7vBPevDgm2tutNI2BaN0iXv1c38s-7RwWSL95qRWyS3djF7L6Qk";
		String openid = "owJamuM6qTM0Q9exfOcvHyvRag_8";
		KfSessionAPI kfSessionAPI = new KfSessionAPI();
		kfSessionAPI.CloseKFSession(access_token, openid);

	}

	/**
	 * 先判断用户是否处于多客服会话中，会话中会关闭会话
	 * 
	 * @param access_token
	 * @param openid
	 */
	public void CloseKFSession(String access_token, String openid) {
		KfSession kfSession = this.GetCustomerSession(access_token, openid);
		if (!StringUtil.isEmpty(kfSession.getKf_account())) {
			SessionInfo sessionInfo = new SessionInfo();
			sessionInfo.setKf_account(kfSession.getKf_account());
			sessionInfo.setOpenid(openid);
			sessionInfo.setText("用户点选了微信闪赔，系统自动退出会话");
			BaseResult baseResult = this
					.CloseSession(access_token, sessionInfo);
		}

	}

}
