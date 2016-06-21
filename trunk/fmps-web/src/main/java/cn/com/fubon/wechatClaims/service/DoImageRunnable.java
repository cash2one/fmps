package cn.com.fubon.wechatClaims.service;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jodd.datetime.JDateTime;

import org.apache.log4j.Logger;
import org.jeecgframework.core.util.ApplicationContextUtil;

import weixin.guanjia.core.util.WeixinUtil;
import weixin.guanjia.message.entity.ReceiveMessage;
import cn.com.fubon.entity.WeChatContext;
import cn.com.fubon.util.Constants;
import cn.com.fubon.util.FtpClientUtils;
import cn.com.fubon.webservice.entity.response.FbWSResponse;
import cn.com.fubon.webservice.externl.coresystem.entity.ClaimRequestBody;
import cn.com.fubon.wechatClaims.entity.Image;
import cn.com.fubon.wechatClaims.entity.ReportInfo;

public class DoImageRunnable implements Runnable {

	private String openid;
	// private WeChatContext weChatContext;
	private String strIp;
	private int intPort;
	private String user;
	private String password;
	private ReceiveMessage receiveMessage;
	private ClaimWebService claimWebService;
	private static final Logger logger = Logger
			.getLogger(DoImageRunnable.class);

	public DoImageRunnable(ReceiveMessage receiveMessage, String strIp,
			int intPort, String user, String password) {
		this.openid = receiveMessage.getFromUserName();
		// this.weChatContext = weChatContext;
		/*
		 * this.reportInfo = (ReportInfo) weChatContext
		 * .get(Constants.WEIXINCLAIMS_reportInfo);
		 */
		this.receiveMessage = receiveMessage;
		this.strIp = strIp;
		this.intPort = intPort;
		this.user = user;
		this.password = password;

		claimWebService = (ClaimWebService) ApplicationContextUtil.getContext()
				.getBean("claimWebService");
	}

	@Override
	public void run() {
		// 处理业务
		String returnMessage = this.doProcess();
		// 发送客服消息
		WeixinUtil.sendCustomerServiceMessage(openid, "text", returnMessage);
	}

	private String doProcess() {
		logger.info("调用核心上传图片，并发送webService");
		String returnMessage = "";
		String fileName = "";
		// String access_toke =
		// "uYKi8_gIjAxf3K5W8upe-Aq8cma14Mxtsxqm60DFFgWDFI0hKuTU7fwCm0zMG-4ZmJudUpjMeC2jka_cMW5sOb7St-e9grqy6M82vksQ1G4";
		// String media_id =
		// "j-u2X2JcDWBZvYP-lwj360PZ6gSuNWCXsXJ4B15dzmD2EVvMGTMmmDNbDIJ9iicl";

		WeChatContextService weChatContextService = (WeChatContextService) ApplicationContextUtil
				.getContext().getBean("weChatContextService");
		WeChatContext weChatContext = weChatContextService
				.getWeChatContext(this.openid);
		ReportInfo reportInfo = (ReportInfo) weChatContext
				.get(Constants.WEIXINCLAIMS_reportInfo);

		byte[] byteArr = WeixinUtil.blockingDownloadMedia(receiveMessage.getMediaId());

		FtpClientUtils ftpClientUtils = new FtpClientUtils(strIp, intPort,
				user, password);
		try {
			if(byteArr != null && byteArr.length > 0){
				
				fileName = ftpClientUtils.uploadClaimPicture(byteArr);
				fileName = fileName.equals("") ? "图片上传失败" : fileName;
				logger.info("图片上传后文件名为==========================>" + fileName);
			}
			ClaimRequestBody body = new ClaimRequestBody();
			JDateTime jnow = new JDateTime(new Date());
			body.setRegistNo(reportInfo.getRegistNo());
			List<Image> list = new ArrayList<Image>();
			Image image1 = new Image();

			image1.setImageName(fileName);
			image1.setImageForm("jpg");
			image1.setImageSize("50KB");
			image1.setImageUploadDate(jnow.toString("YYYY-MM-DD"));
			image1.setImageUploadTime(jnow.toString("hh:mm:ss"));
			image1.setLicenseNo(reportInfo.getLicenseNo());
			image1.setImgUploadType("wx_claim");

			list.add(image1);
			body.setImageList(list);
			FbWSResponse response = claimWebService.getPicture(body);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			returnMessage = "图片FTP 上传失败";
			logger.info("图片FTP 上传失败 MediaId====>" + receiveMessage.getMediaId());
		}

		return returnMessage;
	}

	public void getFile(byte[] bfile, String filePath, String fileName) {
		BufferedOutputStream bos = null;
		FileOutputStream fos = null;
		File file = null;
		try {
			File dir = new File(filePath);
			if (!dir.exists() && dir.isDirectory()) {// 判断文件目录是否存在
				dir.mkdirs();
			}
			file = new File(filePath + "\\" + fileName);
			fos = new FileOutputStream(file);
			bos = new BufferedOutputStream(fos);
			bos.write(bfile);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
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

}
