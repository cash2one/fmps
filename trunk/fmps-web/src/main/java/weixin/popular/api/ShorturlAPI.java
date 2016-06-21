package weixin.popular.api;

import net.sf.json.JSONObject;

import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;

import weixin.guanjia.core.util.WeixinUtil;
import weixin.popular.bean.Shorturl;
import weixin.popular.client.JsonResponseHandler;

public class ShorturlAPI extends BaseAPI {

	/**
	 * 将一条长链接转成短链接
	 * 
	 * @param access_token
	 * @param action
	 *            此处填long2short，代表长链接转短链接
	 * @param long_url
	 *            需要转换的长链接，支持http://、https://、weixin://wxpay 格式的url
	 * @return
	 */
	public Shorturl shorturl(String access_token, String action, String long_url) {
		HttpUriRequest httpUriRequest = RequestBuilder.post()
				.setUri(BASE_URI + "/cgi-bin/shorturl")
				.addParameter("access_token", access_token)
				.addParameter("action", action)
				.addParameter("long_url", long_url).build();
		return localHttpClient.execute(httpUriRequest,
				JsonResponseHandler.createResponseHandler(Shorturl.class));
	}

	/**
	 * 将一条长链接转成短链接 action 默认值 long2short
	 * 
	 * @param access_token
	 * @param long_url
	 * @return
	 */
	public Shorturl shorturl(String access_token, String long_url) {
		return shorturl(access_token, "long2short", long_url);
	}

	/**
	 * 长链接转成短链接 提高扫码速度和成功率
	 *
	 * @param accessToken
	 * @param URL
	 * @return
	 */
	public static String shortURL(String accessToken, String URL) {
		String shortURL = null;
		String requestUrl = "https://api.weixin.qq.com/cgi-bin/shorturl?access_token=ACCESS_TOKEN";
		requestUrl = requestUrl.replace("ACCESS_TOKEN", accessToken);
		String jsonMsg = "{\"action\":\"long2short\",\"long_url\":\"%s\"}";
		JSONObject jsonObject = WeixinUtil.httpRequest(requestUrl, "POST",
				String.format(jsonMsg, URL));
		if (null != jsonObject) {
			try {
				shortURL = jsonObject.getString("short_url");
				System.out.println("short_url---" + shortURL);
				// log.info("生成短链接成功 shortURL:{}", shortURL);
			} catch (Exception e) {
				int errorCode = jsonObject.getInt("errcode");
				String errorMsg = jsonObject.getString("errmsg");
				// log.error("创建永久带参二维码失败 errcode:{} errmsg:{}", errorCode,
				// errorMsg);
			}
		}

		return shortURL;
	}

	public static void main(String[] args) {
		// accessToken2小时会变一次
		String accessToken = "RC8UAVm4SPqeGstyAS_lNJ_OfA4FfFFPyaGQ_8lM8i0yuPIp50vpvnVmspwnl9GbdEuRAgkj6loAVaG3fRfI7-QKLrn5SfOgRX_RfvoJtHU";
		// String url =
		// "http://www.cnblogs.com/zhanghaoh/archive/2012/12/24/2831264.html";
		String url = "http://localhost:8080/fmps/fo/TotaiwanController.do?index";
		ShorturlAPI.shortURL(accessToken, url);
		// ShorturlAPI shorturlAPI = new ShorturlAPI();
		// String short_url = shorturlAPI.shorturl(accessToken, url)
		// .getShort_url();
		// System.out.println("2--" + short_url);
	}

}
