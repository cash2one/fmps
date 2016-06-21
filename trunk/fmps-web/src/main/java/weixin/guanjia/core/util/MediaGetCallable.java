/**
 * 
 */
package weixin.guanjia.core.util;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.Callable;

import org.apache.commons.io.FileUtils;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.mime.MIME;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.jeecgframework.core.common.service.CommonService;
import org.jeecgframework.core.util.ResourceUtil;

import weixin.guanjia.message.entity.ReceiveMessage;
import weixin.util.DateUtils;

/**
 * @author binbin.wang
 *
 */
public class MediaGetCallable implements Callable<byte[]> {

	private static final Logger logger = Logger.getLogger(MediaGetCallable.class);

	private final String MEDIA_DOWNLOAD_URL = "http://file.api.weixin.qq.com/cgi-bin/media/get?access_token=%s&media_id=%s";
	private String accessToken;
	private String mediaID;
	private final CommonService commonService;
	private final ReceiveMessage receiveMessage;

	/**
	 * 
	 */
	public MediaGetCallable(CommonService commonService,
			ReceiveMessage receiveMessage, String accessToken, String mediaId) {
		this.commonService = commonService;
		this.receiveMessage = receiveMessage;
		this.accessToken = accessToken;
		this.mediaID = mediaId;
	}

	@Override
	public byte[] call() throws Exception {

		CloseableHttpClient httpClient = null;
		CloseableHttpResponse httpResponse = null;
		byte[] responseData = null;
		try {
			httpClient = HttpClients.createDefault();
			HttpGet httpGet = new HttpGet(String.format(MEDIA_DOWNLOAD_URL,
					accessToken, mediaID));
			httpResponse = httpClient.execute(httpGet);

			if (HttpStatus.SC_OK != httpResponse.getStatusLine().getStatusCode()) {
				logger.info("ThreadId: " + Thread.currentThread().getId()
						+ ";HttpStatus is not ok. HttpStatus ===> "
						+ httpResponse.getStatusLine());

				return responseData;
			}

			if (!httpResponse.containsHeader(MIME.CONTENT_DISPOSITION)) {
				logger.info("ThreadId: " + Thread.currentThread().getId()
						+ ";httpResponse's header not contains Content-Disposition.");
				return responseData;
			}

			String contentType = httpResponse.getLastHeader(MIME.CONTENT_TYPE) == null ? ""
					: httpResponse.getLastHeader(MIME.CONTENT_TYPE).getValue();
			String contentLength = httpResponse.getLastHeader("Content-Length") == null ? ""
					: httpResponse.getLastHeader("Content-Length").getValue();

			String path = ResourceUtil.getBundleEnvAbout().getString(
					"IMAGE_DOWNLOAD_PATH")
					+ DateUtils.getDate("yyyy")
					+ File.separator
					+ DateUtils.getDate("yyyyMMdd") + File.separator; // 初始文件基础路径,basePath+年+年月日

			String contentDisposition = httpResponse.getLastHeader(
					MIME.CONTENT_DISPOSITION).getValue();
			if (contentDisposition == null
					|| contentDisposition.indexOf("filename=\"") <= -1) {

				logger
						.info("ThreadId: "
								+ Thread.currentThread().getId()
								+ ";contentDisposition is null or filename in contentDisposition is null.");
				return responseData;
			}

			String fileName = contentDisposition.substring(
					contentDisposition.indexOf("\"") + 1,
					contentDisposition.lastIndexOf("\""));

			try {
				responseData = EntityUtils.toByteArray(httpResponse.getEntity());
				FileUtils.writeByteArrayToFile(new File(path + fileName), responseData);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				logger.info("write media file failured, the path==>" + path + fileName
						+ "; cause by " + e.getMessage());
				e.printStackTrace();
			}
			receiveMessage.setPath(path + fileName);
			receiveMessage.setContentType(contentType);
			receiveMessage.setContentLength(contentLength);
			// 更新receiveMessage对象
			commonService.saveOrUpdate(receiveMessage);

			return responseData;
		} finally {
			if (httpResponse != null)
				httpResponse.close();

			if (httpClient != null)
				httpClient.close();
		}
	}
}
