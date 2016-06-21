/**
 * 
 */
package cn.com.fubon.fo.totaiwan.controller;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.extend.datasource.DataSourceContextHolder;
import org.jeecgframework.core.extend.datasource.DataSourceType;
import org.jeecgframework.core.util.ResourceUtil;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.core.util.UUIDGenerator;
import org.jeecgframework.tag.vo.datatable.SortDirection;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import weixin.guanjia.account.entity.WeixinAccountEntity;
import weixin.guanjia.account.service.WeixinAccountServiceI;
import weixin.guanjia.core.util.WeixinUtil;
import weixin.guanjia.message.service.ReceiveMessageServiceI;
import weixin.popular.api.MediaAPI;
import weixin.util.DateUtils;
import weixin.util.JsSdkUtil;
import cn.com.fubon.fo.customerbind.entity.WeiXinGzUserInfo;
import cn.com.fubon.fo.totaiwan.entity.TotaiwanClaimImage;
import cn.com.fubon.fo.totaiwan.service.ToTaiwanService;
import cn.com.fubon.util.FtpClientUtils;
import cn.com.fubon.wechatClaims.entity.ReportInfo;

/**
 * 赴台专区
 * 
 * @author fbxmn06
 *
 */

@Scope("prototype")
@Controller
@RequestMapping("/fo/TotaiwanController")
public class ToTaiwanController {
	private static final Logger logger = Logger
			.getLogger(ToTaiwanController.class);

	@Resource
	private WeixinAccountServiceI weixinAccountService;
	@Resource
	private ReceiveMessageServiceI receiveMessageService;

	@Resource
	private ToTaiwanService toTaiwanServiceImpl;

	/**
	 * 进入赴台旅游专区首页
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "index")
	public ModelAndView index(HttpServletRequest request) {
		String openid;
		String openidParameter = request.getParameter("openid");
		String openidAttribute = (String) request.getAttribute("openid");
		String code = request.getParameter("code");
		logger.info("code=>" + code);
		if (StringUtil.isEmpty(openidParameter)) {
			openid = openidAttribute;
		} else {
			openid = openidParameter;
		}

		if (StringUtil.isEmpty(openid)) {
			DataSourceContextHolder
					.setDataSourceType(DataSourceType.dataSource_jeecg);
			List<WeixinAccountEntity> weixinAccountEntityList = weixinAccountService
					.findValidWeixinAccounts();
			WeixinAccountEntity weixinAccountEntity = weixinAccountEntityList
					.get(0);
			openid = WeixinUtil.getOpenId(
					weixinAccountEntity.getAccountappid(),
					weixinAccountEntity.getAccountappsecret(), code);
			logger.info("根据code获取 openid,获取到的openid=>" + openid);
		}

		request.getSession().setAttribute("openid", openid);
		return new ModelAndView("fo/taitravel/futai");
	}

	/**
	 * 进入理赔资料上传声明界面
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "taiCollect")
	public ModelAndView taiCollect(HttpServletRequest request) {
		return new ModelAndView("fo/taitravel/futaicollect");
	}

	/**
	 * 进入报案界面
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "baoan")
	public ModelAndView baoan(HttpServletRequest request) {
		return new ModelAndView("fo/taitravel/baoan");
	}

	@RequestMapping(params = "futaiuploadimghistory")
	public String futaiuploadimghistory(HttpServletRequest request) {
		String openid = request.getParameter("openid");

		logger.info("历史上传图片获取到的openid=>" + openid);
		TotaiwanClaimImage totaiwanClaimImage = new TotaiwanClaimImage();
		totaiwanClaimImage.setOpenid(openid);

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
		String sql = " select distinct  a.uploadtime uploadtime,(select COUNT(*) from weixin_claim_image b where b.uploadtime=a.uploadtime) as count  from   weixin_claim_image a where a.openid=? order by a.uploadtime desc ";

		List<Map<String, Object>> listt = weixinAccountService.findForJdbc(sql,
				new Object[] { openid });
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
		return "fo/taitravel/futaiuploadimghistory";
	}

	/**
	 * 获取多媒体消息数据流
	 */
	@RequestMapping(params = "getStream")
	public void getMediaidStream(HttpServletRequest request,
			HttpServletResponse response) {
		String id = request.getParameter("id");
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
	 * 进入理赔材料上传页面
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "upload")
	public String upload(HttpServletRequest request,
			HttpServletResponse response) {
		String openid = request.getParameter("openid");
		logger.info("openid:" + openid);
		// 判断用户是否已认证
		// WeiXinGzUserInfo weiXinGzUserInfo = toTaiwanServiceImpl
		// .findUniqueByProperty(WeiXinGzUserInfo.class, "openid", openid);
		// if (weiXinGzUserInfo != null && weiXinGzUserInfo.getBindTime() ==
		// null) {
		// String requestPath = ResourceUtil.getRequestPath(request);//
		// 用户访问的资源地址
		// String url =
		// "/fo/customerBindController.do?method=bindIndex&requestPath="
		// + requestPath;
		// try {
		// request.getRequestDispatcher(url).forward(request, response);
		// } catch (ServletException | IOException e) {
		// logger.error("跳转到用户认证异常...", e);
		// }
		// }
		// 判断用户是否有案件以及案件个数
		// List<ReportInfo> claimcaseList = toTaiwanServiceImpl
		// .getClaimCaseList(openid);
		// if (claimcaseList.size() <= 0) {
		// request.setAttribute("message", "您当前没有理赔案件...");
		// return "/fo/common/message";
		// } else if (claimcaseList.size() > 1) {
		// request.setAttribute("claimcaseList", claimcaseList);
		// request.setAttribute("message", "案件数量大于等于2");
		// return "/fo/common/message";
		// }
		int uploadnum = toTaiwanServiceImpl.getCount(openid);
		String message = "";
		if (uploadnum >= 100) {
			message = "上传图片数量已达上限，如需再传，请联系客服...";
			request.setAttribute("message", message);
			return "/fo/common/message";
		} else {
			int num = 100 - uploadnum;
			request.setAttribute("uploadnum", num);
		}
		String JsonStr = this.getJsonStr(request);
		request.setAttribute("openid", openid);
		request.setAttribute("JsonStr", JsonStr);
		return "fo/taitravel/futaiuploadimg";
	}

	/**
	 * 理赔材料上传成功提示页面
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "uploadsuccess")
	public String uploadSuccess(HttpServletRequest request) {
		request.setAttribute("message",
				"理赔材料上传成功，我们将尽快为您安排处理，请保持电话畅通，便于服务人员与您联系，谢谢！");
		return "/fo/common/message";
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
		String openid = request.getParameter("openid");
		String customername = request.getParameter("customername");
		String phonenum = request.getParameter("phonenum");
		String mediaid = request.getParameter("serverid");
		String currenttime = request.getParameter("currenttime");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		logger.info("openid:" + openid + ",mediaid:" + mediaid);
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
		String path = ResourceUtil.getBundleEnvAbout().getString(
				"IMAGE_DOWNLOAD_PATH")
				+ "totaiwan_claim"
				+ File.separator
				+ customername
				+ "_"
				+ phonenum
				+ File.separator
				+ DateUtils.getDate("yyyyMMdd")
				+ File.separator; // 初始文件基础路径,basePath+年+年月日
		logger.info("上传图片路径:" + path);
		String fileName = UUIDGenerator.generate() + ".jpg";
		TotaiwanClaimImage taiClaimImg = new TotaiwanClaimImage();
		taiClaimImg.setCustomername(customername);
		taiClaimImg.setLocalpath(path + fileName);
		taiClaimImg.setMediaid(mediaid);
		taiClaimImg.setOpenid(openid);
		taiClaimImg.setPhonenum(phonenum);
		try {
			Date now = new Date(Long.parseLong(currenttime));
			String curtime = sdf.format(now);
			taiClaimImg.setUploadtime(sdf.parse(curtime));
		} catch (ParseException e1) {
			logger.info("当前时间格式化出错...");
		}
		toTaiwanServiceImpl.save(taiClaimImg);
		FtpClientUtils ftpClientUtils = new FtpClientUtils(ftpip, port,
				username, password);
		ftpClientUtils.uploadClaimPicture(media, path, fileName);
		try {
			FileUtils.writeByteArrayToFile(new File(path + fileName), media);
			return "1";
		} catch (IOException e) {
			logger.info("write media file failured, the path==>" + path
					+ fileName + "; cause by " + e.getMessage());
			request.setAttribute("message", "理赔材料上传失败，请稍候重试...");
			return "/fo/common/message";
		} finally {

		}
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
	
	/**
	 * 理赔专区-主界面(新版)
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "claimsindex")
	public ModelAndView claimsindex(HttpServletRequest request) {
		String openid = request.getParameter("openid");
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
	public String caselist(HttpServletRequest request) {
		String openid = request.getParameter("openid");
		logger.info("openid:" + openid);
		
		request.setAttribute("openid", openid);
		return "fo/wechatclaims/futaicaselist";
	}
	
	/**
	 * 理赔专区-理赔资料上传页面(新版)
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "toUploadimg")
	public String toUploadimg(HttpServletRequest request) {
		String openid = request.getParameter("openid");
		String caseno = request.getParameter("caseno");
		logger.info("openid:" + openid);
		logger.info("caseno:" + caseno);
		
		int uploadnum = toTaiwanServiceImpl.getCount(openid);
		String message = "";
		if (uploadnum >= 100) {
			message = "上传图片数量已达上限，如需再传，请联系客服...";
			request.setAttribute("message", message);
			return "/fo/common/message";
		} else {
			int num = 100 - uploadnum;
			request.setAttribute("uploadnum", num);
		}
		String JsonStr = this.getJsonStr(request);
		request.setAttribute("openid", openid);
		request.setAttribute("JsonStr", JsonStr);
		request.setAttribute("caseno", caseno);
		return "fo/wechatclaims/futaicaseuploadimg";
	}

}
