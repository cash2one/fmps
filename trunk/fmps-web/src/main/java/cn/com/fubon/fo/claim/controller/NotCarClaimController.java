package cn.com.fubon.fo.claim.controller;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jodd.datetime.JDateTime;
import jodd.util.StringUtil;

import org.apache.commons.chain.Context;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.util.ResourceUtil;
import org.jeecgframework.core.util.UUIDGenerator;
import org.jeecgframework.tag.vo.datatable.SortDirection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import weixin.guanjia.account.entity.WeixinAccountEntity;
import weixin.guanjia.account.service.WeixinAccountServiceI;
import weixin.guanjia.message.service.ReceiveMessageServiceI;
import weixin.popular.api.MediaAPI;
import weixin.popular.util.JsonUtil;
import weixin.util.DateUtils;
import weixin.util.JsSdkUtil;
import cn.com.fubon.common.service.SendEmailService;
import cn.com.fubon.emarketing.api.product.service.ProductService;
import cn.com.fubon.fo.claim.entity.NotCarImage;
import cn.com.fubon.fo.claim.entity.NotCarReportInfo;
import cn.com.fubon.fo.claim.service.NotCarClaimWebService;
import cn.com.fubon.fo.claim.service.NotCarClientService;
import cn.com.fubon.fo.totaiwan.entity.PolicyRequest;
import cn.com.fubon.fo.totaiwan.entity.TotaiwanClaimImage;
import cn.com.fubon.rest.service.impl.RestWebServiceClient;
import cn.com.fubon.util.Constants;
import cn.com.fubon.util.FtpClientUtils;
import cn.com.fubon.util.ImageUtils;
import cn.com.fubon.webservice.WsConstants;
import cn.com.fubon.webservice.entity.response.FbWSResponse;
import cn.com.fubon.webservice.externl.coresystem.entity.ClaimNotCarRequestBody;
import cn.com.fubon.webservice.server.WebServiceClientManagementService;
import cn.com.fubon.webservice.server.entity.WebServiceClientManagement;

/**
 * 理赔专区
 *
 */

@Scope("prototype")
@Controller
@RequestMapping("/fo/notCarClaimController")
public class NotCarClaimController {
	private static final Logger logger = Logger
			.getLogger(NotCarClaimController.class);

	@Resource
	private WeixinAccountServiceI weixinAccountService;
	@Resource
	private ReceiveMessageServiceI receiveMessageService;

	@Resource
	private NotCarClaimWebService notCarClaimWebService;
	
	@Resource
	private NotCarClientService notCarClientService;
	
	@Resource(name="postMessageToFcps")
	private RestWebServiceClient postMessageToFcps;	
	@Resource
	private WebServiceClientManagementService  webServiceClientManagementService;

	@Resource
	private SendEmailService sendEmailServiceImpl;
	

	//@Autowired
	//private ProductService productService;	
	


	/**
	 * 理赔专区-主界面(新版)
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "claimsindex")
	public ModelAndView claimsindex(HttpServletRequest request) {	
		String openid = (String) request.getSession().getAttribute(Constants.SESSION_KEY_OPENID);
		if (StringUtil.isEmpty(openid)) {
			openid = request.getParameter("openid");
		}
		logger.info("理赔专区-主界面(claimsindex), openid:"+openid);
		request.setAttribute("openid", openid);
		return new ModelAndView("fo/wechatclaims/futaiclaimsindex");
	}
	
	/**
	 * 理赔专区-案件列表页面(新版)
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "caselist")
	public ModelAndView caselist(HttpServletRequest request) throws Exception {
		ModelAndView mav = new ModelAndView();
		String openid = (String) request.getSession().getAttribute(Constants.SESSION_KEY_OPENID);
		if (StringUtil.isEmpty(openid)) {
			openid = request.getParameter("openid");
		}
		String phonenum = request.getParameter("phonenum");
		logger.info("理赔专区-案件列表页面(caselist), openid:" + openid + ", phonenum:" + phonenum);
		
		List<NotCarReportInfo> list = notCarClaimWebService.getReportNotCarList(phonenum, openid);
		logger.info("理赔专区-案件列表页面(caselist), 案件数量："+list.size());
		request.setAttribute("openid", openid);
		request.setAttribute("phonenum", phonenum);
		String view = "";
		if (list.size() == 0) {
			String message = "查不到报案信息，请确认报案电话是否正确，如有疑问，请联系客服：4008-817-518";
			request.setAttribute("message", message);
			view = "/fo/common/message";
		} else if (list.size() == 1) {
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("openid", openid);
			params.put("phonenum", phonenum);
			params.put("registNo", list.get(0).getRegistNo());
			params.put("reportDate", list.get(0).getReportDate());
			params.put("reportTime", list.get(0).getReportTime());
			params.put("policyNo", list.get(0).getPolicyNo());
			params.put("startDate", list.get(0).getStartDate());
			params.put("endDate", list.get(0).getEndDate());
			params.put("remark", list.get(0).getRemark());
			params.put("caseStatus", list.get(0).getCaseStatus());
			params.put("insuredName", list.get(0).getInsuredName());
			params.put("reportorName", list.get(0).getReportorName());
			mav.addAllObjects(params);
			view = "redirect:/fo/notCarClaimController.do?toUploadimg&version="+java.lang.Math.random();
		} else {
			request.setAttribute("caselist", list);
			view = "fo/wechatclaims/futaicaselist";
		}
		mav.setViewName(view);
		return mav;
	}
	
	/**
	 * 理赔专区-理赔资料上传页面(新版)
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "toUploadimg")
	public String toUploadimg(HttpServletRequest request,NotCarReportInfo reportinfo) throws Exception {
		String openid = (String) request.getSession().getAttribute(Constants.SESSION_KEY_OPENID);
		if (StringUtil.isEmpty(openid)) {
			openid = request.getParameter("openid");
		}
		String phonenum = request.getParameter("phonenum");
		String registNo_refresh = request.getParameter("registNo_refresh");
		logger.info("toUploadimg===phonenum====>"+phonenum+".registNo:"+registNo_refresh);
		if(StringUtil.isNotEmpty(registNo_refresh)){
			reportinfo=notCarClientService.findByProperty(NotCarReportInfo.class, "registNo", registNo_refresh).get(0);	
		   this.sendMessage(registNo_refresh);
		}
		String remark = java.net.URLDecoder.decode(reportinfo.getRemark(), "UTF-8");
		reportinfo.setRemark(remark);
		String insuredName = java.net.URLDecoder.decode(reportinfo.getInsuredName(), "UTF-8");
		reportinfo.setInsuredName(insuredName);
		String reportorName = java.net.URLDecoder.decode(reportinfo.getReportorName(), "UTF-8");
		reportinfo.setReportorName(reportorName);
		logger.info("理赔专区-理赔资料上传页面(toUploadimg), openid:" + openid
				+ ", phonenum:" + phonenum + ", remark:" + remark
				+ ", insuredName:" + insuredName + ", reportorName:" + reportorName);
		
		//判断是否存在：不存在->保存；存在->更新
		if (notCarClientService.isExist(reportinfo.getRegistNo())) {
			notCarClientService.updateRegistInfo(reportinfo.getRegistNo(),
					reportinfo.getPolicyNo(), reportinfo.getReportDate(),
					reportinfo.getReportTime(), reportinfo.getStartDate(),
					reportinfo.getEndDate(), reportinfo.getRemark(),
					reportinfo.getCaseStatus().toString(), reportinfo.getInsuredName(),
					reportinfo.getReportorName());
		} else {
			notCarClientService.save(reportinfo);
		}
		
		int uploadnum = notCarClientService.getCount(openid,reportinfo.getRegistNo());
		String message = "";
		if (uploadnum >= 100) {
			message = "上传图片数量已达上限，如需再传，请联系客服...";
			request.setAttribute("message", message);
			return "/fo/common/message";
		} else {
			int num = 100 - uploadnum;
			request.setAttribute("uploadnum", num);
		}
		List<Map<String, Object>> imglist = notCarClientService.getUploadedImg(openid,reportinfo.getRegistNo());
		logger.info("理赔专区-待回显照片信息=======openid===>"+openid+". imglist.size:"+imglist.size());
		Map<String,Object> map = notCarClientService.getImgtypeCount(openid,reportinfo.getRegistNo());
		String JsonStr = this.getJsonStr(request);
		request.setAttribute("openid", openid);
		request.setAttribute("phonenum", phonenum);
		request.setAttribute("JsonStr", JsonStr);
		request.setAttribute("reportinfo", reportinfo);
		request.setAttribute("map", map);
		request.setAttribute("imglist", imglist);
		return "fo/wechatclaims/futaicaseuploadimg";
	}
	
	private void sendMessage(String registNo ){
		NotCarReportInfo reportInfo=notCarClientService.findUniqueByProperty(NotCarReportInfo.class, "registNo", registNo);
		Map<String, String> tempMap=new HashMap<String, String>();
		String tempid="125425522514524562";
		String sendto=ResourceUtil.getBundleEnvAbout().getString("notCarMailNotice");
		tempMap.put("keyword0", reportInfo.getRegistNo());//报案号
		tempMap.put("keyword1", reportInfo.getPolicyNo());//保单号
		tempMap.put("keyword2", reportInfo.getInsuredName());//被保险人
		tempMap.put("keyword3", reportInfo.getRemark());//案件描述
		List<TotaiwanClaimImage> totaiwanClaimImageList=notCarClientService.findByProperty(TotaiwanClaimImage.class, "caseno", registNo);
		logger.info("理赔专区-理赔资料上传页面(sendMessage), registNo:" + registNo+",图片上传张数为:"+totaiwanClaimImageList.size());
		if(totaiwanClaimImageList.size()==0){
		tempMap.put("keyword3", reportInfo.getRemark()+".[******图片上传失败******]");//案件描述	
		
		 }		
		try {
			sendEmailServiceImpl.sendEmail(tempMap, sendto, tempid); //邮件通知
		} catch (Exception e) {			
			e.printStackTrace();
		}
		tempMap=new HashMap<String, String>();
		tempMap.put("keyword1", reportInfo.getRegistNo());//报案号
		tempMap.put("keyword2", reportInfo.getPolicyNo());//保单号
		tempMap.put("keyword3", reportInfo.getInsuredName());//被保险人
		tempMap.put("keyword4", reportInfo.getRemark());//案件描述		 
		this.sendNoticeToFcps(tempMap); //企业号通知
		
	}
	
	/**
	 * 理赔材料上传成功提示页面
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "uploadsuccess")
	public String uploadSuccess(HttpServletRequest request) {
		String falseCount = request.getParameter("falseCount");
		String registNo = request.getParameter("registNo");
		NotCarReportInfo reportInfo=notCarClientService.findUniqueByProperty(NotCarReportInfo.class, "registNo", registNo);
		Map<String, String> tempMap=new HashMap<String, String>();
		String tempid="125425522514524562";
		String sendto=ResourceUtil.getBundleEnvAbout().getString("notCarMailNotice");
		tempMap.put("keyword0", reportInfo.getRegistNo());//报案号
		tempMap.put("keyword1", reportInfo.getPolicyNo());//保单号
		tempMap.put("keyword2", reportInfo.getInsuredName());//被保险人
		tempMap.put("keyword3", reportInfo.getRemark());//案件描述
		try {
			sendEmailServiceImpl.sendEmail(tempMap, sendto, tempid); //邮件通知
		} catch (Exception e) {			
			e.printStackTrace();
		}
		tempMap=new HashMap<String, String>();
		tempMap.put("keyword1", reportInfo.getRegistNo());//报案号
		tempMap.put("keyword2", reportInfo.getPolicyNo());//保单号
		tempMap.put("keyword3", reportInfo.getInsuredName());//被保险人
		tempMap.put("keyword4", reportInfo.getRemark());//案件描述		 
		this.sendNoticeToFcps(tempMap); //企业号通知
		
		logger.info("理赔资料上传成功提示页面(uploadsuccess), falseCount:" + falseCount+".registNo:"+registNo);
		int count = Integer.parseInt(falseCount);
		if (count > 0) {
			request.setAttribute("message",
					"您的理赔资料部分上传失败，请继续上传，如有疑问，请联系客服：4008-817-518");
		}else{
			request.setAttribute("message",
					"上传成功，进入资料审核中，我们将尽快为您处理！请保持电话畅通，便于理赔人员与您联系，谢谢！");
		}
		return "/fo/common/message";
	}
	
	/**
	 * 理赔专区-历史上传图片(新版)
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "futaiuploadimghistory")
	public String futaiuploadimghistory(HttpServletRequest request) {
		String openid = (String) request.getSession().getAttribute(Constants.SESSION_KEY_OPENID);
		if (StringUtil.isEmpty(openid)) {
			openid = request.getParameter("openid");
		}
		String caseno = request.getParameter("caseno");

		logger.info("理赔专区-历史上传图片(futaiuploadimghistory), openid=>" + openid + ", caseno=>"+caseno);
		TotaiwanClaimImage totaiwanClaimImage = new TotaiwanClaimImage();
		totaiwanClaimImage.setOpenid(openid);
		totaiwanClaimImage.setCaseno(caseno);

		CriteriaQuery cq = new CriteriaQuery(TotaiwanClaimImage.class);
		cq.addOrder("uploadtime", SortDirection.desc);
		// 查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq,
				totaiwanClaimImage);
		cq.add();

		List<TotaiwanClaimImage> totaiwanClaimImageList = weixinAccountService
				.getListByCriteriaQuery(cq, false);
		request.setAttribute("totaiwanClaimImageList数量",
				totaiwanClaimImageList.size());
		String sql = " select distinct  a.uploadtime uploadtime,(select COUNT(*) from weixin_claim_image b where b.uploadtime=a.uploadtime) as count  from   weixin_claim_image a where a.openid=? and a.caseno = ? and a.status = '1' order by a.uploadtime desc ";

		List<Map<String, Object>> listt = weixinAccountService.findForJdbc(sql,
				new Object[] { openid,caseno });
		request.setAttribute("listt数量", listt.size());

		String JSONString = this.getJsonStr(request);
		request.setAttribute("JSONString", JSONString);
		if (totaiwanClaimImageList.size() > 0) {
			request.setAttribute("totaiwanClaimImageList",
					totaiwanClaimImageList);
			request.setAttribute("list", listt);
		} else {
			request.setAttribute("message", "没有您上传的历史图片");
			return "/fo/common/message";
		}
		request.setAttribute("caseno", caseno);
		return "fo/wechatclaims/futaicaseuploadimghistory";
	}
	
	/**
	 * 获取多媒体消息数据流
	 */
	@RequestMapping(params = "getStream")
	public void getMediaidStream(HttpServletRequest request,
			HttpServletResponse response) {
		String id = request.getParameter("id");
		logger.info("理赔专区-待回显照片信息=====getStream==id===>"+id);
		// String mediaid = request.getParameter("mediaid");
		InputStream inputStream = null;
		TotaiwanClaimImage totaiwanClaimImage = weixinAccountService
				.findUniqueByProperty(TotaiwanClaimImage.class, "id", id);
		byte[] byteArr = null;
		try {
			byteArr = FileUtils.readFileToByteArray(new File(totaiwanClaimImage
					.getLocalpath()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// byte[] byteArr = WeixinUtil.blockingDownloadMedia(mediaid);
		// ReceiveMessage receiveMessage = receiveMessageService
		// .findUniqueByProperty(ReceiveMessage.class, "mediaId", mediaid);
		if (byteArr != null && byteArr.length > 0) {
			inputStream = new ByteArrayInputStream(byteArr);
			this.writeStreamToResponse(inputStream, response);
		} else {
			// logger.info("getMediaidStream byteArr is null mediaid=>" +
			// mediaid);
		}

	}

	/**
	 * 把流输出要页面
	 * 
	 * @param inputStream
	 * @param contentType
	 * @param response
	 */
	private void writeStreamToResponse(InputStream inputStream,
			HttpServletResponse response) {
		BufferedInputStream bis = new BufferedInputStream(inputStream);
		// 头信息
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		// response.setContentType(contentType);

		byte[] b = new byte[1024];
		try {
			while (bis.read(b) > -1) {
				response.getOutputStream().write(b);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (inputStream != null) {

				try {
					inputStream.close();
				} catch (IOException e) {
					logger.info("close inputStream IOException");
				}
			}
			if (bis != null) {

				try {
					bis.close();
				} catch (IOException e) {
					logger.info("getVoice IOException");
				}
			}

		}
	}

	/**
	 * 下载图片到服务器
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "downloadimg")
	@ResponseBody
	public String downloadImg(HttpServletRequest request) {
		logger.info("进入图片下载方法....");
		String openid = (String) request.getSession().getAttribute(Constants.SESSION_KEY_OPENID);
		if (StringUtil.isEmpty(openid)) {
			openid = request.getParameter("openid");
		}
		String customername = request.getParameter("customername");
		String insuredName = request.getParameter("insuredName");
		String phonenum = request.getParameter("phonenum");
		String mediaid = request.getParameter("serverid");
		String currenttime = request.getParameter("currenttime");
		String caseno = request.getParameter("caseno");
		String imgtype = request.getParameter("imgtype");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		logger.info("openid:" + openid + ",mediaid:" + mediaid + ", caseno:" + caseno + ", currenttime:" + currenttime);
		String access_token = weixinAccountService
				.getAccessTokenFromAccountEntity();
		String ftpip = ResourceUtil.getBundleEnvAbout().getString("ToTaiFtpIp");
		int port = Integer.parseInt(ResourceUtil.getBundleEnvAbout().getString(
				"ToTaiFtpPort"));
		String username = ResourceUtil.getBundleEnvAbout().getString(
				"ToTaiFtpUser");
		String password = ResourceUtil.getBundleEnvAbout().getString(
				"ToTaiFtpPassword");
		MediaAPI mediaApi = new MediaAPI();
		byte[] media = mediaApi.mediaGet(access_token, mediaid);
		String year = DateUtils.getDate("yyyy");//年
		String month = DateUtils.getDate("MM");	//月
		String day = DateUtils.getDate("dd");	//日
		//本地目录
		String path = ResourceUtil.getBundleEnvAbout().getString(
				"NOT_CAR_IMAGE_DOWNLOAD_PATH")
				+ "cliam"
				+ File.separator
				+ year
				+ File.separator
				+ month
				+ File.separator
				+ day
				+ File.separator; // 初始文件基础路径,/年/月/日，如/2016/02/26
		String result = "2";//"1"表示上传成功。"2"表示上传失败
		String fileName = UUIDGenerator.generate() + ".jpg";
		logger.info("开始上传图片,保存路径为:" + path);	
		try {			
			FileUtils.writeByteArrayToFile(new File(path + fileName), media); //保存本地			
			TotaiwanClaimImage taiClaimImg = new TotaiwanClaimImage();
			taiClaimImg.setCustomername(customername);
			taiClaimImg.setLocalpath(path + fileName);
			taiClaimImg.setMediaid(mediaid);
			taiClaimImg.setOpenid(openid);
			taiClaimImg.setPhonenum(phonenum);
			taiClaimImg.setCaseno(caseno);
			taiClaimImg.setImgtype(imgtype);
			taiClaimImg.setStatus("0");//默认待发送
			try {
				Date now = new Date(Long.parseLong(currenttime));
				String curtime = sdf.format(now);
				taiClaimImg.setUploadtime(sdf.parse(curtime));
			} catch (ParseException e1) {
				logger.info("当前时间格式化出错...");
			}
			notCarClientService.save(taiClaimImg); //保存数据库		
			//开始判断是否需要图片压缩
	    	int srcWidth=ImageUtils.getImageWidth(path + fileName);
	    	logger.info("图片上传完成，图片的宽度为:" + srcWidth);
	    	if(srcWidth>1000){ //需要压缩	    		
	    		ImageUtils.zoomImageByWidth( path + fileName, path +"narrow_"+fileName, 900);
	    		logger.info("压缩后的图片保存路径为:" + path +"narrow_"+fileName);
	    		media=ImageUtils.File2byte(path +"narrow_"+fileName); //读取压缩后的图片上传FTP   		
	    	} 			
			//开始上传 FTP
			String ftpPath = File.separator
					+ year
					+ File.separator
					+ month
					+ File.separator
					+ day
					+ File.separator;
			logger.info("上传FTP的图片路径:" + ftpPath+fileName);
			FtpClientUtils ftpClientUtils = new FtpClientUtils(ftpip, port,
					username, password);
			boolean sendSuccess = ftpClientUtils.uploadClaimPicture(media, ftpPath, fileName);			
			sendSingleClaimImgToCore(caseno,insuredName,fileName,"jpg");
			logger.info("downloadimg() 非车理赔照片发送核心返回状态：" + sendSuccess);
			if(sendSuccess){
				//notCarClientService.updateStatus(mediaid, "1");
				result = "1";
			}else{
				//notCarClientService.updateStatus(mediaid, "2");
				result = "2";
			}			
		
		} catch (Exception e) {
			logger.error("write media file failured, the path==>" + path
					+ fileName + "; cause by " + e.getMessage());
			request.setAttribute("message", "理赔材料上传失败，请稍候重试...");
			return "/fo/common/message";
		} finally {

		}
		return result;		
	}

	/**
	 * 发送非车理赔照片
	 * 
	 * @param request
	 * @return  此方法已经不用了
	 */
	//@RequestMapping(params = "sendClaimImg")
	@ResponseBody
	public String sendClaimImg(HttpServletRequest request) {
		//phonenum:phonenum,openid:openid,registNo:registNo,currenttime:currenttime
//		String phonenum = request.getParameter("phonenum");
//		String openid = request.getParameter("openid");
		String insuredName = request.getParameter("insuredName");
		String registNo = request.getParameter("registNo");
		String currenttime = request.getParameter("currenttime");
		logger.info("发送非车理赔照片(sendClaimImg)：registNo-> " + registNo + ", currenttime-> " + currenttime);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date now = new Date(Long.parseLong(currenttime));
		String curtime = sdf.format(now);
		JDateTime jnow = new JDateTime(now);
		
		List<Map<String, Object>> list = notCarClientService.getImgList(registNo, curtime);
		List<NotCarImage> imageList = new ArrayList<NotCarImage>();
		for (Map<String, Object> map : list) {
			logger.info("localpath:" + map.get("localpath") + ", uploadtime:" + map.get("uploadtime"));
			
			String[] tmp = map.get("localpath").toString().split(System.getProperty("file.separator"));
			String imageName = tmp[tmp.length-1];
			logger.info("imageName:" + imageName);
	 		String imageForm = imageName.substring(imageName.indexOf(".")+1, imageName.length());
	 		logger.info("imageForm:" + imageForm);
	 		
			NotCarImage img = new NotCarImage();
			img.setInsuredName(insuredName);
			img.setImgUploadType("wx_claim");
			img.setImageName(imageName);
			img.setImageForm(imageForm);
			img.setImageSize("20KB");
			img.setImageUploadDate(jnow.toString("YYYY-MM-DD"));
			img.setImageUploadTime(jnow.toString("hh:mm:ss"));
			
			imageList.add(img);
		}
		
		ClaimNotCarRequestBody claimNotCarRequestBody = new ClaimNotCarRequestBody();
		claimNotCarRequestBody.setRegistNo(registNo);
		claimNotCarRequestBody.setImageList(imageList);
		FbWSResponse fbWSResponse = notCarClaimWebService.getNotCarPicture(claimNotCarRequestBody);
		String returnCode = fbWSResponse.getResponseHead().getTransResponse().getReturnCode();
		logger.info("发送非车理赔照片信息(响应报文状态):" + returnCode);
		
		return returnCode.equalsIgnoreCase("0000") ? "1" : "0";
	}
	
	public boolean sendSingleClaimImgToCore(String registNo,String insuredName,String imageName,String imageForm ) {
		JDateTime jnow = new JDateTime(new Date());
		
		NotCarImage img = new NotCarImage();
		img.setInsuredName(insuredName);
		img.setImgUploadType("wx_claim");
		img.setImageName(imageName);
		img.setImageForm(imageForm);
		img.setImageSize("20KB");
		img.setImageUploadDate(jnow.toString("YYYY-MM-DD"));
		img.setImageUploadTime(jnow.toString("hh:mm:ss"));
		
		List<NotCarImage> imageList = new ArrayList<NotCarImage>();
		imageList.add(img);
		
		ClaimNotCarRequestBody claimNotCarRequestBody = new ClaimNotCarRequestBody();
		claimNotCarRequestBody.setRegistNo(registNo);
		claimNotCarRequestBody.setImageList(imageList);
		FbWSResponse fbWSResponse = notCarClaimWebService.getNotCarPicture(claimNotCarRequestBody);
		logger.info("非车理赔发送核心图片返回报文：" + fbWSResponse);
		if (fbWSResponse != null) {
			String returnCode = fbWSResponse.getResponseHead().getTransResponse().getReturnCode();
			logger.info("发送非车理赔照片信息(响应报文状态):" + returnCode);
			
			return returnCode.equalsIgnoreCase("0000") ? true : false;
		}
		return false;
	}
	
	
	/**
	 * 获取微信初始化数据
	 * 
	 * @param request
	 * @return
	 */
	public String getJsonStr(HttpServletRequest request) {
		String accessToken = weixinAccountService
				.getAccessTokenFromAccountEntity();
		List<WeixinAccountEntity> weixinAccountEntityList = weixinAccountService
				.findValidWeixinAccounts();
		WeixinAccountEntity weixinAccountEntity = weixinAccountEntityList
				.get(0);
		String appid = weixinAccountEntity.getAccountappid();
		String URL = ResourceUtil.getDomain() + request.getServletPath() + "?"
				+ request.getQueryString();
		logger.info("jssdkPage url ===>" + URL);
		JsSdkUtil JsSdkUtil = new JsSdkUtil(URL, appid, accessToken);
		String JSONString = JsSdkUtil.getWxConfigJSONString();
		return JSONString;
	}
	
	private void sendNoticeToFcps(Map<String, String> data ){
		PolicyRequest request = new PolicyRequest("fmps","fcps","json", "33", UUIDGenerator.generate(), "notCarClaim",data);
		Context context = null;
		String clientCode = ResourceUtil.getBundleEnvAbout().getString("clientCode");
		WebServiceClientManagement WebServiceClientManagement = webServiceClientManagementService
				.findUniqueByProperty(WebServiceClientManagement.class,	"clientCode", clientCode);
		String requestJson = JsonUtil.toJSONString(request);		
		try {
			context =postMessageToFcps.startExecuteChain(requestJson, WebServiceClientManagement.getToken(), WebServiceClientManagement.getAESKey() , clientCode);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.info("理赔照片上传完成后，发送企业号通知异常 " + e);
		}
		String responeJSON=(String) context.get(WsConstants.RESPONSEJSON);
		logger.info("理赔照片上传完成后，发送企业号通知返回回来的JSON=== " + responeJSON);		
	}
	
	@RequestMapping(params = "testWS")
	public void testWS(){
		this.sendSingleClaimImgToCore("627652016000000000006","石佳","8a8195b354e1ea750154e600472d0009.jpg","jpg");
		
		
	}
	
	// @ResponseBody
	// @RequestMapping(params = "sayhello" )
	// public String sayhello(){		 
		// String ss =productService.sayHello("xxxxxxx");
		// return ss;
	// }
	
	
}
