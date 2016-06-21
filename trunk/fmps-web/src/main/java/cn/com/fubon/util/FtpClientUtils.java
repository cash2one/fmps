package cn.com.fubon.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.TimeZone;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPClientConfig;
import org.apache.commons.net.ftp.FTPReply;
import org.apache.log4j.Logger;
import org.jeecgframework.core.util.ResourceUtil;
import org.jeecgframework.core.util.UUIDGenerator;

import weixin.popular.api.MediaAPI;

public class FtpClientUtils {
	private FTPClient ftpClient;
	private String strIp;
	private int intPort;
	private String user;
	private String password;
	private static final Logger logger = Logger.getLogger(FtpClientUtils.class);

	/**
	 * Ftp构造函数
	 */
	public FtpClientUtils(String strIp, int intPort, String user,
			String Password) {
		this.strIp = strIp;
		this.intPort = intPort;
		this.user = user;
		this.password = Password;
		this.ftpClient = new FTPClient();
		logger.info("获取到的参数====>strIp:" + strIp + ". intPort:" + intPort
				+ ". user:" + user + ". password:" + password);
	}

	public FTPClient getFtpClient() {
		return ftpClient;
	}

	public void setFtpClient(FTPClient ftpClient) {
		this.ftpClient = ftpClient;
	}

	/**
	 * 判断是否登入成功
	 */
	public boolean ftpLogin() {
		boolean isLogin = false;
		FTPClientConfig ftpClientConfig = new FTPClientConfig();
		ftpClientConfig.setServerTimeZoneId(TimeZone.getDefault().getID());
		// this.ftpClient.setControlEncoding("GBK");
		this.ftpClient.configure(ftpClientConfig);
		try {
			if (this.intPort > 0) {
				this.ftpClient.connect(this.strIp, this.intPort);
			} else {
				this.ftpClient.connect(this.strIp);
			}
			// FTP服务器连接回答
			int reply = this.ftpClient.getReplyCode();
			if (!FTPReply.isPositiveCompletion(reply)) {
				this.ftpClient.disconnect();
				logger.error("failed to login ftp server!");
				return isLogin;
			}
			this.ftpClient.login(this.user, this.password);
			// 设置传输协议
			this.ftpClient.enterLocalPassiveMode();
			this.ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
			logger.info(this.user + " successed to login FTP Server");
			isLogin = true;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(this.user + " failed to login FTP Server!"
					+ e.getMessage());
		}
		this.ftpClient.setBufferSize(1024 * 2);
		this.ftpClient.setDataTimeout(30 * 1000);
		return isLogin;
	}

	/**
	 * 退出关闭服务器链接
	 */
	public void ftpLogOut() {
		if (null != this.ftpClient && this.ftpClient.isConnected()) {
			try {
				boolean reuslt = this.ftpClient.logout();// 退出FTP服务器
				if (reuslt) {
					logger.info("successed to disconnect ftp server!");
				}
			} catch (IOException e) {
				e.printStackTrace();
				logger.error("failed to disconnect ftp server!"
						+ e.getMessage());
			} finally {
				try {
					this.ftpClient.disconnect();// 关闭FTP服务器的连接
				} catch (IOException e) {
					e.printStackTrace();
					logger.error("failed to disconnect ftp server!");
				}
			}
		}
	}

	/**
	 * 上传Ftp文件
	 * 
	 * @param localFile
	 *            当地文件
	 * @param romotUpLoadePath上传服务器路径
	 *            - 应该以/结束
	 */
	public boolean uploadFile(File localFile, String romoteUpLoadePath) {
		BufferedInputStream inStream = null;
		boolean success = false;
		try {
			this.ftpClient.changeWorkingDirectory(romoteUpLoadePath);// 改变工作路径
			inStream = new BufferedInputStream(new FileInputStream(localFile));
			logger.info("FtpClientUtil uploadFile " + localFile.getName()
					+ " started");
			success = this.ftpClient.storeFile(localFile.getName(), inStream);
			if (success == true) {
				logger.info("FtpClientUtil uploadFile " + localFile.getName()
						+ " success");
				return success;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			logger.error(localFile + " FileNotFoundException");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (inStream != null) {
				try {
					inStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return success;
	}

	/**
	 * 上传理赔照片
	 * 
	 * @author fangfang.guo
	 * @param byteArr
	 * @return
	 * @throws IOException
	 */
	public String uploadClaimPicture(byte[] byteArr) throws IOException {
		logger.info("按字节流开始上传图片");
		this.ftpLogin();
		String fileName = UUIDGenerator.generate() + ".jpg";
		InputStream inputStream = new ByteArrayInputStream(byteArr);
		// 理赔照片存至FTP服务器的路径
		// D:\weblogic\fubon\pictures\claim\claimDbpic\wechat\yyyy\mm\dd
		SimpleDateFormat sdf = new SimpleDateFormat("/yyyy/MM/dd/");
		String romoteUpLoadPath = sdf.format(new Date());

		// make directory　begin：创建文件夹
		if (romoteUpLoadPath != null && !"".equals(romoteUpLoadPath.trim())) {
			String[] pathes = romoteUpLoadPath.split("/");
			for (String path : pathes) {
				if (path == null || "".equals(path.trim())) {
					continue;
				}

				if (!this.ftpClient.changeWorkingDirectory(path)) {
					this.ftpClient.makeDirectory(path);
					this.ftpClient.changeWorkingDirectory(path);
				}
			}
		}
		// make directory　end：创建文件夹

		try {

			logger.info("ftpclientUtil uploadClaimPicture " + fileName
					+ " started");
			if (this.ftpClient.storeFile(fileName, inputStream) == true) {
				logger.info("ftpclientUtil uploadClaimPicture " + fileName
						+ " success");
				return fileName;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			logger.error("ftpclientUtil uploadClaimPicture " + fileName
					+ " FileNotFoundException");
			return "";
		} catch (IOException e) {
			e.printStackTrace();
			logger.error("ftpclientUtil uploadClaimPicture " + fileName
					+ " IOException");
			return "";
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
					logger.error("ftpclientUtil uploadClaimPicture " + fileName
							+ " IOException");
				}
			}
			this.ftpLogOut();
		}
		return "";
	}

	/**
	 * 上传理赔资料(带远程服务器文件存储路径)
	 * 
	 * @param byteArr
	 * @param remotepath
	 * @return
	 */
	public boolean uploadClaimPicture(byte[] byteArr, String remotepath,String fileName) {
		this.ftpLogin();
		InputStream inputStream = new ByteArrayInputStream(byteArr);
		// make directory　begin：创建文件夹
		if (remotepath != null && !"".equals(remotepath.trim())) {
			String[] pathes = remotepath.split("/");
			for (String path : pathes) {
				if (path == null || "".equals(path.trim())) {
					continue;
				}

				try {
					if (!ftpClient.changeWorkingDirectory(path)) {
						ftpClient.makeDirectory(new String(path.getBytes("UTF-8"),"iso-8859-1"));
						ftpClient.changeWorkingDirectory(new String(path.getBytes("UTF-8"),"iso-8859-1"));
					}
				} catch (IOException e) {
					logger.info("ftpclientUtil changeWorkingDirectory fail...");
					return false;
				}
			}
		}
		// make directory　end：创建文件夹

		try {

			logger.info("ftpclientUtil uploadClaimPicture " + fileName
					+ " started");
			if (ftpClient.storeFile(fileName, inputStream) == true) {
				logger.info("ftpclientUtil uploadClaimPicture " + fileName
						+ " success");			 
			}
		} catch (FileNotFoundException e) {
			logger.error("ftpclientUtil uploadClaimPicture " + fileName
					+ " FileNotFoundException");
			return false;
		} catch (IOException e) {
			logger.error("ftpclientUtil uploadClaimPicture " + fileName
					+ " IOException");
			return false;
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					logger.error("ftpclientUtil uploadClaimPicture " + fileName
							+ " IOException");
					return false;
				}
			}
			this.ftpLogOut();
		}
		return true;
	}

	public static void main(String[] args) throws IOException {
		MediaAPI mediaAPI = new MediaAPI();
		FtpClientUtils ftpClientUtils = new FtpClientUtils("10.1.21.119", 6021,
				"wechatftp", "wechatftp");
		ftpClientUtils
				.uploadClaimPicture(mediaAPI
						.mediaGet(
								"fGp_jru4buQiRCsRI5V6QZuxSdE2gHCHm8zmODtlPIb8ebcxxG7YiQJwY6Ib7zVqfexc_q9yy5EqMJ_82gyi2tBp3gbUsV_lOZV5jpGD2KI",
								"GCzy6ZwQIrNF1BunuO-ovyl8_QLlZYwIfhfsJ_WfkVVOgsOQ5qBVErel3f3YPBJn"));
		// ftpClientUtils.getFile(mediaAPI.mediaGet("fGp_jru4buQiRCsRI5V6QZuxSdE2gHCHm8zmODtlPIb8ebcxxG7YiQJwY6Ib7zVqfexc_q9yy5EqMJ_82gyi2tBp3gbUsV_lOZV5jpGD2KI","GCzy6ZwQIrNF1BunuO-ovyl8_QLlZYwIfhfsJ_WfkVVOgsOQ5qBVErel3f3YPBJn"),
		// "D:\\WSQ\\", UUIDGenerator.generate() + ".jpg");

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
