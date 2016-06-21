/**
 * 
 */
package cn.com.fubon.webservice.commands.cardclient;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.jeecgframework.core.util.ResourceUtil;

/**
 * 卡单激活报文发送接收处理类
 * 
 * @author qingqu.huang
 *
 */
public class CardReqAndRep {

	private static final Logger logger = Logger.getLogger(CardReqAndRep.class);
	private String discr = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";

	/**
	 * 发送请求报文，接收响应报文
	 * 
	 * @param sendStr
	 *            请求报文
	 * @param url
	 *            链接 (修改为传递key值，读取配置文件)
	 * @return 响应报文String
	 * @throws IOException 
	 */
	public String httpSendReceiver(String sendStr, String key) throws IOException {
		sendStr = discr + sendStr;
		logger.info("请求报文:" + sendStr);
		logger.info("-----------------"
				+ ResourceUtil.getBundleEnvAbout().getString("prpall.url"));
		String responseStr = null;
		Date resultCurrtDate = new Date();
		SimpleDateFormat resultsf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		URL url = null;
		url = new URL(ResourceUtil.getBundleEnvAbout().getString(key));
		byte[] iXMLData = httpSendReceiver(sendStr.getBytes("GBK"), url);
		responseStr = new String(iXMLData, "GBK");
		logger.info("响应报文:" + responseStr);
		resultCurrtDate = new Date();
		resultsf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		logger.info("<callBack>" + resultsf.format(resultCurrtDate) + "---："
				+ responseStr);
		CardPacketPutDB ppb = new CardPacketPutDB();
		ppb.writeLog(sendStr, responseStr);
		return responseStr;
	}

	public byte[] httpSendReceiver(byte[] sendStr, URL url) throws IOException {
		// 此函数是平台主动向保险公司发起的http请求,并接收保险公司的响应
		byte[] iXMLData = null;

		HttpURLConnection httpConnection;
		httpConnection = (HttpURLConnection) url // 建立一个HttpURLConnection
				.openConnection();

		httpConnection.setRequestMethod("POST");
		httpConnection.setDoOutput(true);
		httpConnection.setDoInput(true);
		httpConnection.setAllowUserInteraction(true);
		httpConnection.connect();
		// 发送数据给保险公司
		OutputStream outputStream = httpConnection.getOutputStream();

		/* 记录用户操作日志 END */
		byte[] buffer = null;

		outputStream.write(sendStr);
		outputStream.flush();
		outputStream.close();
		// 接收保险公司的数据
		InputStream inputStream = httpConnection.getInputStream();
		BufferedInputStream input = null; // 输入流,用于接收请求的数据
		buffer = new byte[1024]; // 数据缓冲区
		int count = 0; // 每个缓冲区的实际数据长度
		ByteArrayOutputStream streamXML = new ByteArrayOutputStream(); // 请求数据存放对象
		try {
			input = new BufferedInputStream(inputStream);
			while ((count = input.read(buffer)) != -1) {
				streamXML.write(buffer, 0, count);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (Exception f) {
					f.printStackTrace();
				}
			}
		}
		iXMLData = streamXML.toByteArray(); // 得到一个byte数组,提供给平台
		httpConnection.disconnect();
		return iXMLData;
	}
	
	/**
	 * 职业查询发送请求报文，接收响应报文 ,不保存至日志
	 * 
	 * @param sendStr
	 *            请求报文
	 * @param url
	 *            链接 (修改为传递key值，读取配置文件)
	 * @return 响应报文String
	 * @throws IOException 
	 */
	public String httpSendReceiverOccupation(String sendStr, String key) throws IOException {
		sendStr = discr + sendStr;
		logger.info("请求报文:" + sendStr);
		logger.info("-----------"+ ResourceUtil.getBundleEnvAbout().getString("prpall.url"));
		URL url = new URL(ResourceUtil.getBundleEnvAbout().getString(key));
		byte[] iXMLData = httpSendReceiver(sendStr.getBytes("GBK"), url);
		String responseStr = new String(iXMLData, "GBK");
		logger.info("响应报文:" + responseStr);
		Date resultCurrtDate = new Date();
		SimpleDateFormat resultsf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		logger.info("<callBack>" + resultsf.format(resultCurrtDate) + "---："
				+ responseStr);
		return responseStr;
	}

	public static String getUrl(String key) {
		String value = ResourceUtil.getBundleEnvAbout().getString(key);
		return value;
	}

	public static void main(String[] args) {
		System.out.println(ResourceUtil.getBundleEnvAbout().getString(
				"ftpPassword"));
	}

}
