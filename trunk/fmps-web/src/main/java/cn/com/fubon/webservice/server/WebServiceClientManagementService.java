package cn.com.fubon.webservice.server;

import java.io.File;

import org.jeecgframework.core.common.service.CommonService;

public interface WebServiceClientManagementService extends CommonService  {
	
	/**
	 * 生成二维码文件
	 * @param openid
	 * @param uuid
	 * @param logoPath
	 * @param parentfile
	 * @param QRmessage
	 * @param tag 用于标识二维码
	 * @return
	 */
	public File getQRPng(String openid, String uuid, String logoPath,
			File parentfile, String QRmessage,String tag);
}
