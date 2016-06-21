package cn.com.fubon.wechatClaims.timingtask;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.annotation.Resource;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.entity.mime.MIME;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.jeecgframework.core.util.ResourceUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import weixin.guanjia.account.service.WeixinAccountServiceI;
import weixin.guanjia.message.entity.ReceiveMessage;
import weixin.guanjia.message.service.ReceiveMessageServiceI;
import weixin.popular.api.MediaAPI;
import weixin.util.DateUtils;

@Service("multimediaDownload")
@Transactional
public class MultimediaDownload {
	private static final Logger logger = Logger
			.getLogger(MultimediaDownload.class);
	@Resource
	private ReceiveMessageServiceI receiveMessageService;
	@Resource
	private WeixinAccountServiceI weixinAccountService;

	public void downloadService() throws Exception {

		try {
			// 查找满足条件的下载记录
			List<ReceiveMessage> receiveMessageList = this
					.getReceiveMessageList();
			String access_token = weixinAccountService
					.getAccessTokenFromAccountEntity();
			String filepath = ResourceUtil.getBundleEnvAbout().getString(
					"IMAGE_DOWNLOAD_PATH")
					+ DateUtils.getDate("yyyyMMdd") + File.separator; // 初始文件基础路径
			String filename = "";
			for (ReceiveMessage receiveMessage : receiveMessageList) {
				MediaAPI mediaAPI = new MediaAPI();
				String contentType = "";
				String contentLength = "";
				HttpResponse httpResponse = mediaAPI.mediaGetResponse(
						access_token, receiveMessage.getMediaId());

				String suffix = "";
				switch (receiveMessage.getMsgType()) {
				case "image":
					suffix = ".jpg";
					break;
				case "video":
					suffix = ".mp4";
					break;
				case "voice_mp3":
					suffix = ".mp3";
					break;
				case "voice":
					suffix = ".amr";
					break;
				default:
				}
				filename = receiveMessage.getId() + suffix;

				if (HttpStatus.SC_OK == httpResponse.getStatusLine()
						.getStatusCode()
						&& httpResponse
								.containsHeader(MIME.CONTENT_DISPOSITION)) {

					byte[] byteArr = null;
					try {
						byteArr = EntityUtils.toByteArray(httpResponse
								.getEntity());
					} catch (IOException e1) {
						logger.info("httpResponse toByteArray failed");
					}
					contentType = httpResponse.getLastHeader(MIME.CONTENT_TYPE) == null ? ""
							: httpResponse.getLastHeader(MIME.CONTENT_TYPE)
									.getValue();
					contentLength = httpResponse
							.getLastHeader("Content-Length") == null ? ""
							: httpResponse.getLastHeader("Content-Length")
									.getValue();

					if (byteArr != null && byteArr.length > 0) {

						try {
							this.writeFile(byteArr, filepath, filename);
							receiveMessage.setPath(filepath + filename);
							receiveMessage.setContentType(contentType);
							receiveMessage.setContentLength(contentLength);
							receiveMessageService.saveOrUpdate(receiveMessage);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							logger.info("文件保存错误，保存的文件为:" + filename);
							e.printStackTrace();
						}

					}

				} else {
					logger.info("定时任务下载多媒体文件，HTTP状态不等于200 ");
				}

				// byte[] fileContent = mediaAPI.mediaGet(access_token,
				// receiveMessage.getMediaId());
				// if (fileContent != null && fileContent.length > 0) {
				// this.writeFile(fileContent, filepath, filename);
				// receiveMessage.setPath(filepath + filename);
				// receiveMessageService.saveOrUpdate(receiveMessage);
				// }
			}
		} catch (Exception e) {
			logger.info("=========微信下载多媒体错误=========");
			e.printStackTrace();
		}
	}

	/**
	 * 获取满足需要下载的记录
	 * 
	 * @return
	 */
	private List<ReceiveMessage> getReceiveMessageList() {
		// String
		// sql="select * from  weixin_receive_message  where path is null and msgtype in ('image','voice') and createtime > date_add(sysdate(), interval -3 day)";
		String HQL = "  from  ReceiveMessage where path is null and msgtype in ('image','voice') and  createTime >=:endDate ";
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String date = df.format(new java.util.Date(new java.util.Date()
				.getTime() - 2 * 24 * 60 * 60 * 1000));
		java.sql.Date endDate = java.sql.Date.valueOf(date);
		return receiveMessageService.getSession().createQuery(HQL)
				.setParameter("endDate", endDate).list();
	}

	private void writeFile(byte[] bfile, String filePath, String fileName)
			throws IOException {
		BufferedOutputStream bos = null;
		FileOutputStream fos = null;
		File file = null;

		File dir = new File(filePath);
		if (!dir.exists()) {// 判断文件目录是否存在
			dir.mkdirs();
		}
		file = new File(filePath + fileName);
		fos = new FileOutputStream(file);
		bos = new BufferedOutputStream(fos);
		bos.write(bfile);
		if (bos != null) {
			try {
				bos.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		if (fos != null) {
			try {
				fos.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
}
