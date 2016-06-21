package cn.com.fubon.webservice.server.impl;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import org.apache.commons.codec.binary.Base64;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.jeecgframework.core.util.ResourceUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.fubon.util.AESUtils;
import cn.com.fubon.webservice.server.WebServiceClientManagementService;
import cn.com.fubon.webservice.server.entity.WebServiceClientManagement;

import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.xiongyingqi.qrcode.QRCodeGenerator;
@Service("webServiceClientManagementService")
@Transactional
public class WebServiceClientManagementServiceImpl extends CommonServiceImpl implements WebServiceClientManagementService  {
	
	/**
	 * 生成二维码文件
	 * 
	 * @param openid
	 * @param uuid
	 * @param logoPath
	 * @param parentfile
	 * @param QRmessage
	 * @param tag
	 *            用于标识二维码
	 * @return
	 */
	public File getQRPng(String openid, String uuid, String logoPath,
			File parentfile, String QRmessage, String tag) {
		File png=null;
		String clientCode = ResourceUtil.getBundleEnvAbout().getString(
				"clientCode");
		WebServiceClientManagement WebServiceClientManagement = this
				.findUniqueByProperty(WebServiceClientManagement.class,
						"clientCode", clientCode);
		String qrContent = uuid + "," + QRmessage + "," + openid + "," + tag;
		String encryqrContent = null;
		try {
			encryqrContent = Base64.encodeBase64String(AESUtils.encrypt(
					qrContent.getBytes("UTF-8"),
					AESUtils.initKey(WebServiceClientManagement.getAESKey())));
		} catch (InvalidKeyException | NoSuchAlgorithmException
				| NoSuchPaddingException | IllegalBlockSizeException
				| BadPaddingException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		png = QRCodeGenerator.newGenerator().content(encryqrContent)
				.characterSet("UTF-8")
				.errorCorrectionLevel(ErrorCorrectionLevel.H).logoFlag(true)
				.format("png").margin(0).width(300).height(300)
				.logoPath(parentfile.getParent() + logoPath).generate();
		return png;
	}

}
