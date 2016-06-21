/**
 * 
 */
package cn.com.fubon.reportform.user.controller;

import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jodd.util.StringUtil;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.hssf.util.Region;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.tag.vo.datatable.SortDirection;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.com.fubon.fo.customerbind.entity.WeiXinGzUserInfo;
import cn.com.fubon.reportform.user.service.INoticeUserReportService;

/**
 * 关注用户报表
 * 
 * @author guojunjie
 * @date 2015-07-30
 */
@Scope("prototype")
@Controller
@RequestMapping("/userReport/NoticeUserReportController")
public class NoticeUserReportController {

	private static final Logger logger = Logger
			.getLogger(NoticeUserReportController.class);

	@Resource
	private INoticeUserReportService noticeUserReportService;

	private String message;

	/**
	 * 进入关注用户列表界面
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "noticeUserReport")
	public ModelAndView product(HttpServletRequest request) {
		return new ModelAndView("reportform/user/noticeUserReportList");
	}

	/**
	 * easyuiAJAX关注用户列表请求数据
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 * @throws ParseException
	 */
	@RequestMapping(params = "datagrid")
	public void datagrid(WeiXinGzUserInfo weiXinGzUserInfo,
			HttpServletRequest request, HttpServletResponse response,
			DataGrid dataGrid) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		String bindTime_begin = request.getParameter("bindTime_begin");
		String bindTime_end = request.getParameter("bindTime_end");
		Date bindTime_begindate = new Date();
		Date bindTime_enddate = new Date();

		if (!StringUtil.isEmpty(bindTime_begin)) {
			bindTime_begin = bindTime_begin + " 00:00:00";
			bindTime_begindate = sdf.parse(bindTime_begin);
		}
		if (!StringUtil.isEmpty(bindTime_end)) {
			bindTime_end = bindTime_end + " 00:00:00";
			bindTime_enddate = sdf.parse(bindTime_end);
		}

		String subscribe_time_begin = request
				.getParameter("subscribeTime_begin");
		String subscribe_time_end = request.getParameter("subscribeTime_end");

		Date subscribe_time_begindate = new Date();
		Date subscribe_time_enddate = new Date();
		if (!StringUtil.isEmpty(subscribe_time_begin)) {
			subscribe_time_begin = subscribe_time_begin + " 00:00:00";
			subscribe_time_begindate = sdf.parse(subscribe_time_begin);
		}
		if (!StringUtil.isEmpty(subscribe_time_end)) {
			subscribe_time_end = subscribe_time_end + " 00:00:00";
			subscribe_time_enddate = sdf.parse(subscribe_time_end);
		}

		String isbind = request.getParameter("isbind");

		// String subscribe = request.getParameter("subscribe");

		String customercname = request.getParameter("customercname");
		String nickname = request.getParameter("nickname");
		String identifynumber = request.getParameter("identifynumber");
		String mobile = request.getParameter("mobile");

		WeiXinGzUserInfo weiXinGzUserInfoo = new WeiXinGzUserInfo();
		weiXinGzUserInfoo.setSubscribe("1");

		weiXinGzUserInfo.setSubscribe("1");
		CriteriaQuery cq = new CriteriaQuery(WeiXinGzUserInfo.class, dataGrid);
		cq.addOrder("subscribe_time", SortDirection.desc);
		if (!StringUtil.isEmpty(customercname)) {
			cq.like("customercname", "%" + customercname + "%");
		}
		if (!StringUtil.isEmpty(nickname)) {
			cq.like("nickname", "%" + nickname + "%");
		}
		if (!StringUtil.isEmpty(identifynumber)) {
			cq.like("identifynumber", "%" + identifynumber + "%");
		}
		if (!StringUtil.isEmpty(mobile)) {
			cq.like("mobile", "%" + mobile + "%");
		}
		if (!StringUtil.isEmpty(subscribe_time_begin)) {

			cq.ge("subscribe_time", subscribe_time_begindate);
		}
		if (!StringUtil.isEmpty(subscribe_time_end)) {
			cq.le("subscribe_time", subscribe_time_enddate);
		}
		// if (!StringUtil.isEmpty(bindTime_begin)) {
		// cq.ge("bindTime", bindTime_begindate);
		// }
		// if (!StringUtil.isEmpty(bindTime_end)) {
		// cq.le("bindTime", bindTime_enddate);
		// }
		if (!StringUtil.isEmpty(isbind)) {
			if ("0".equals(isbind)) {
				// mobile
				// cq.notEq("bindTime", cq.isNull("bindTime"));
				// cq.sql(" this_.bindTime is  not  null");
				cq.isNotNull("bindTime");
				// cq.isNotNull("mobile");

				// cq.notEq("bindTime", null);
			} else {
				cq.isNull("bindTime");
			}
		}

		// 查询条件组装器
//		if (!StringUtil.isEmpty(mobile) || !StringUtil.isEmpty(customercname) || !StringUtil.isEmpty(nickname)) {
//			org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil
//					.installHql(cq, weiXinGzUserInfoo);
//		} else {
//			org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil
//					.installHql(cq, weiXinGzUserInfo);
//		}
		// 暂时取消以上判断逻辑,使用以下方式(updated by yaoming.zhang on 2015/11/13)
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, weiXinGzUserInfoo);
		
		cq.add();
		/*
		 * if (!StringUtil.isEmpty(isbind)) { if ("0".equals(isbind)) {
		 * noticeUserReportService.getDataGridReturn(cq, true); } else {
		 * 
		 * noticeUserReportService.getDataGridReturn(cq, true); } } else {
		 */
		noticeUserReportService.getDataGridReturn(cq, true);
		/* } */

		TagUtil.datagrid(response, dataGrid);
	}

	@RequestMapping(params = "exportXlscheck")
	public void exportXlscheck(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		/*
		 * // List<WeiXinGzUserInfo> weiXinGzUserInfos = noticeUserReportService
		 * // .loadAll(WeiXinGzUserInfo.class);
		 */
		WeiXinGzUserInfo weiXinGzUserInfo = new WeiXinGzUserInfo();
		weiXinGzUserInfo.setSubscribe("1");

		CriteriaQuery cq = new CriteriaQuery(WeiXinGzUserInfo.class);
		cq.addOrder("subscribe_time", SortDirection.desc);
		// 查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq,
				weiXinGzUserInfo);
		cq.add();
		List<WeiXinGzUserInfo> weiXinGzUserInfos = noticeUserReportService
				.getListByCriteriaQuery(cq, false);
		// excel所选的字段
		String fieldReportStr = "";
		Map map = new HashMap();
		map = request.getParameterMap();
		Iterator iter = map.entrySet().iterator();
		while (iter.hasNext()) {
			Map.Entry entry = (Map.Entry) iter.next();
			Object key = entry.getKey();
			Object[] val = (Object[]) entry.getValue();
			// 排除值为"","确认","on"的参数
			if (val != null && !val[0].equals("") && !val[0].equals("确认")
					&& !val[0].equals("on")) {
				fieldReportStr = fieldReportStr.trim() + ";" + val[0];
			}
		}

		HSSFWorkbook wb = this.export(weiXinGzUserInfos, fieldReportStr);

		String fileName = "关注用户列表.xls";
		fileName = new String(fileName.getBytes("GBK"), "iso8859-1");

		response.setHeader("Content-Disposition", "attachment;filename="
				+ fileName);// 指定下载的文件名

		OutputStream ouputStream = response.getOutputStream();
		wb.write(ouputStream);
		ouputStream.flush();
		ouputStream.close();
	}

	public HSSFWorkbook export(List<WeiXinGzUserInfo> weiXinGzUserInfos,
			String str) {
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet("Campaign");

		// 定义单元格报头
		String worksheetTitle = "用户关注列表";

		HSSFRow row = sheet.createRow((int) 0);
		row.setHeight((short) 1000);
		// 设置第一行
		HSSFCell cell = row.createCell(0);
		// 定义单元格为字符串类型
		cell.setCellType(HSSFCell.ENCODING_UTF_16);// 中文处理
		cell.setCellValue(new HSSFRichTextString(worksheetTitle));
		String[] excelHeader;
		excelHeader = str.split(";");
		int colSum = excelHeader.length - 2;
		// 指定合并区域
		/**
		 * public Region(int rowFrom, short colFrom, int rowTo, short colTo)
		 */
		sheet.addMergedRegion(new Region(0, (short) 0, 0, (short) colSum));

		// 定义单元格格式，添加单元格表样式，并添加到工作簿
		HSSFCellStyle cellStyle = wb.createCellStyle();
		// 设置单元格水平对齐类型
		cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 指定单元格居中对齐
		cellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 指定单元格垂直居中对齐
		cellStyle.setWrapText(true);// 指定单元格自动换行
		cellStyle.setFillForegroundColor(HSSFColor.LIGHT_CORNFLOWER_BLUE.index);// 设置背景色
		// 设置单元格字体
		HSSFFont font = wb.createFont();
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		font.setFontName("宋体");
		font.setFontHeight((short) 600);
		cellStyle.setFont(font);
		cell.setCellStyle(cellStyle);

		// HSSFCellStyle style = wb.createCellStyle();

		// style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		HSSFCellStyle style = createTitleStyle(wb);
		HSSFRow row2 = sheet.createRow((int) 1);
		for (int i = 1; i < excelHeader.length; i++) {
			cell = row2.createCell(i - 1);
			cell.setCellValue(excelHeader[i]);
			cell.setCellStyle(style);
			/*
			 * if (excelHeader[i].equals("用户头像")) { sheet.setColumnWidth(i,
			 * 30000); } else { sheet.setColumnWidth(i, 5000); }
			 */
			sheet.setColumnWidth(0, 6000);
			sheet.setColumnWidth(i, 6000);
			//
			// sheet.autoSizeColumn(i);
			// sheet.autoSizeColumn(i + 15000);
		}
		// cell.setCellValue("");
		// sheet.setColumnWidth(excelHeader.length, 5000);
		// Arrays.sort(excelHeader);
		boolean acoountflag = false;
		boolean addtimeflag = false;
		boolean rentimeflag = false;
		boolean noticetimeflag = false;
		boolean birthdayflag = false;

		logger.info("关注用户数量=>" + weiXinGzUserInfos.size());

		for (int i = 0; i < weiXinGzUserInfos.size(); i++) {
			row = sheet.createRow(i + 2);
			WeiXinGzUserInfo weiXinGzUserInfo = weiXinGzUserInfos.get(i);

			WeiXinGzUserInfo weiXinGzUserInfoo = new WeiXinGzUserInfo();

			if (Arrays.asList(excelHeader).contains("微信号")) {
				weiXinGzUserInfoo.setOpenid(weiXinGzUserInfo.getOpenid());
			} else {
				weiXinGzUserInfoo.setOpenid(" ");
			}

			if (Arrays.asList(excelHeader).contains("昵称")) {
				weiXinGzUserInfoo.setNickname(weiXinGzUserInfo.getNickname());
			} else {
				weiXinGzUserInfoo.setNickname(" ");
			}

			if (Arrays.asList(excelHeader).contains("微信账号")) {
				weiXinGzUserInfoo.setAccount(weiXinGzUserInfo.getAccount());
				acoountflag = true;
			} else {
				acoountflag = false;
				// weiXinGzUserInfoo.setAccount(null);

			}

			if (Arrays.asList(excelHeader).contains("性别")) {
				weiXinGzUserInfoo.setSex(weiXinGzUserInfo.getSex());
			} else {
				weiXinGzUserInfoo.setSex(" ");
			}

			if (Arrays.asList(excelHeader).contains("关注时间")) {
				weiXinGzUserInfoo.setSubscribe_time(weiXinGzUserInfo.getSubscribe_time());
				noticetimeflag = true;
			} else {
				noticetimeflag = false;
				// weiXinGzUserInfoo.setSubscribe_time(new Date("00:00:00"));
			}

			if (Arrays.asList(excelHeader).contains("用户头像")) {
				weiXinGzUserInfoo.setHeadimgurl(weiXinGzUserInfo
						.getHeadimgurl());
			} else {
				weiXinGzUserInfoo.setHeadimgurl(" ");
			}

			if (Arrays.asList(excelHeader).contains("备注名称")) {
				weiXinGzUserInfoo.setBzname(weiXinGzUserInfo.getBzname());
			} else {
				weiXinGzUserInfoo.setBzname(" ");
			}

			if (Arrays.asList(excelHeader).contains("添加时间")) {
				weiXinGzUserInfoo.setAddtime(weiXinGzUserInfo.getAddtime());
				addtimeflag = true;
			} else {
				addtimeflag = false;
				// weiXinGzUserInfoo.setAddtime(new Date("00:00:00"));
			}

			if (Arrays.asList(excelHeader).contains("认证类型")) {
				weiXinGzUserInfoo.setBindType(weiXinGzUserInfo.getBindType());

			} else {
				weiXinGzUserInfoo.setBindType(" ");

			}

			if (Arrays.asList(excelHeader).contains("认证时间")) {
				weiXinGzUserInfoo.setBindTime(weiXinGzUserInfo.getBindTime());
				rentimeflag = true;
			} else {
				// weiXinGzUserInfoo.setBindTime(new Date("00:00:00"));
				rentimeflag = false;
			}

			if (Arrays.asList(excelHeader).contains("国家")) {
				weiXinGzUserInfoo.setCountry(weiXinGzUserInfo.getCountry());
			} else {
				weiXinGzUserInfoo.setCountry(" ");
			}

			if (Arrays.asList(excelHeader).contains("省份")) {
				weiXinGzUserInfoo.setProvince(weiXinGzUserInfo.getProvince());
			} else {
				weiXinGzUserInfoo.setProvince(" ");
			}

			if (Arrays.asList(excelHeader).contains("城市")) {
				weiXinGzUserInfoo.setCity(weiXinGzUserInfo.getCity());
			} else {
				weiXinGzUserInfoo.setCity(" ");
			}

			if (Arrays.asList(excelHeader).contains("客户代码")) {
				weiXinGzUserInfoo.setCustomercode(weiXinGzUserInfo
						.getCustomercode());
			} else {
				weiXinGzUserInfoo.setCustomercode(" ");
			}

			if (Arrays.asList(excelHeader).contains("客户名称")) {
				weiXinGzUserInfoo.setCustomercname(weiXinGzUserInfo
						.getCustomercname());
			} else {
				weiXinGzUserInfoo.setCustomercname(" ");
			}

			if (Arrays.asList(excelHeader).contains("证件号码")) {
				weiXinGzUserInfoo.setIdentifynumber(weiXinGzUserInfo
						.getIdentifynumber());
			} else {
				weiXinGzUserInfoo.setIdentifynumber(" ");
			}

			if (Arrays.asList(excelHeader).contains("手机号")) {
				weiXinGzUserInfoo.setMobile(weiXinGzUserInfo.getMobile());
			} else {
				weiXinGzUserInfoo.setMobile(" ");
			}

			if (Arrays.asList(excelHeader).contains("车牌号")) {
				weiXinGzUserInfoo.setLicenseno(weiXinGzUserInfo.getLicenseno());
			} else {
				weiXinGzUserInfoo.setLicenseno(" ");
			}

			if (Arrays.asList(excelHeader).contains("组ID")) {
				weiXinGzUserInfoo.setGroupid(weiXinGzUserInfo.getGroupid());
			} else {
				weiXinGzUserInfoo.setGroupid(" ");
			}

			if (Arrays.asList(excelHeader).contains("是否关注")) {
				weiXinGzUserInfoo.setSubscribe(weiXinGzUserInfo.getSubscribe());
			} else {
				weiXinGzUserInfoo.setSubscribe(" ");
			}

			if (Arrays.asList(excelHeader).contains("认证客户的性别")) {
				weiXinGzUserInfoo.setCustomerSex(weiXinGzUserInfo
						.getCustomerSex());
			} else {
				weiXinGzUserInfoo.setCustomerSex(" ");
			}

			if (Arrays.asList(excelHeader).contains("认证客户的生日")) {
				weiXinGzUserInfoo.setCustomerBirthday(weiXinGzUserInfo
						.getCustomerBirthday());
				birthdayflag = true;
			} else {
				birthdayflag = false;
				// weiXinGzUserInfoo.setIdentifyType(" ");
			}

			if (Arrays.asList(excelHeader).contains("认证客户的证件类型")) {
				weiXinGzUserInfoo.setIdentifyType(weiXinGzUserInfo
						.getIdentifyType());
			} else {
				weiXinGzUserInfoo.setIdentifyType(" ");
			}

			if (Arrays.asList(excelHeader).contains("扫码关注预设值")) {
				weiXinGzUserInfoo.setEventKey(weiXinGzUserInfo.getEventKey());
			} else {
				weiXinGzUserInfoo.setEventKey(" ");
			}
			// excel每列的值
			String fieldReportValueStr = "";

			if (!" ".equals(weiXinGzUserInfoo.getOpenid())) {
				fieldReportValueStr = fieldReportValueStr + ";"
						+ weiXinGzUserInfoo.getOpenid();
			}
			if (!" ".equals(weiXinGzUserInfoo.getNickname())) {
				fieldReportValueStr = fieldReportValueStr + ";"
						+ weiXinGzUserInfoo.getNickname();
			}
			if (acoountflag) {
				if (weiXinGzUserInfoo.getAccount() != null) {
					fieldReportValueStr = fieldReportValueStr + ";"
							+ weiXinGzUserInfoo.getAccount().getId();
				} else {
					fieldReportValueStr = fieldReportValueStr + ";" + "null";
				}

			}
			if (!" ".equals(weiXinGzUserInfoo.getSex())) {
				if (weiXinGzUserInfoo.getSex() != null) {
					if (weiXinGzUserInfoo.getSex().equals("1")) {
						fieldReportValueStr = fieldReportValueStr + ";" + "男";
					} else {
						fieldReportValueStr = fieldReportValueStr + ";" + "女";
					}
				} else {
					fieldReportValueStr = fieldReportValueStr + ";" + "null";
				}

			}
			if (noticetimeflag) {
				fieldReportValueStr = fieldReportValueStr + ";"
						+ weiXinGzUserInfoo.getSubscribe_time() + "";
			}
			if (!" ".equals(weiXinGzUserInfoo.getHeadimgurl())) {
				fieldReportValueStr = fieldReportValueStr + ";"
						+ weiXinGzUserInfoo.getHeadimgurl();
			}
			if (!" ".equals(weiXinGzUserInfoo.getBzname())) {
				fieldReportValueStr = fieldReportValueStr + ";"
						+ weiXinGzUserInfoo.getBzname();
			}
			if (addtimeflag) {
				fieldReportValueStr = fieldReportValueStr + ";"
						+ weiXinGzUserInfoo.getAddtime() + "";
			}
			if (!" ".equals(weiXinGzUserInfoo.getBindType())) {
				fieldReportValueStr = fieldReportValueStr + ";"
						+ weiXinGzUserInfoo.getBindType();
			}
			if (rentimeflag) {
				fieldReportValueStr = fieldReportValueStr + ";"
						+ weiXinGzUserInfoo.getBindTime() + "";
			}
			if (!" ".equals(weiXinGzUserInfoo.getSubscribe())) {
				fieldReportValueStr = fieldReportValueStr + ";"
						+ weiXinGzUserInfoo.getSubscribe();
			}
			if (!" ".equals(weiXinGzUserInfoo.getCountry())) {
				fieldReportValueStr = fieldReportValueStr + ";"
						+ weiXinGzUserInfoo.getCountry();
			}
			if (!" ".equals(weiXinGzUserInfoo.getProvince())) {
				fieldReportValueStr = fieldReportValueStr + ";"
						+ weiXinGzUserInfoo.getProvince();
			}
			if (!" ".equals(weiXinGzUserInfoo.getCity())) {
				fieldReportValueStr = fieldReportValueStr + ";"
						+ weiXinGzUserInfoo.getCity();
			}
			if (!" ".equals(weiXinGzUserInfoo.getCustomercode())) {
				fieldReportValueStr = fieldReportValueStr + ";"
						+ weiXinGzUserInfoo.getCustomercode();
			}

			if (!" ".equals(weiXinGzUserInfoo.getCustomercname())) {
				fieldReportValueStr = fieldReportValueStr + ";"
						+ weiXinGzUserInfoo.getCustomercname();
			}

			if (!" ".equals(weiXinGzUserInfoo.getIdentifynumber())) {
				fieldReportValueStr = fieldReportValueStr + ";"
						+ weiXinGzUserInfoo.getIdentifynumber();
			}
			if (!" ".equals(weiXinGzUserInfoo.getMobile())) {
				fieldReportValueStr = fieldReportValueStr + ";"
						+ weiXinGzUserInfoo.getMobile();
			}
			if (!" ".equals(weiXinGzUserInfoo.getLicenseno())) {
				fieldReportValueStr = fieldReportValueStr + ";"
						+ weiXinGzUserInfoo.getLicenseno();
			}
			if (!" ".equals(weiXinGzUserInfoo.getGroupid())) {
				fieldReportValueStr = fieldReportValueStr + ";"
						+ weiXinGzUserInfoo.getGroupid();
			}
			if (!" ".equals(weiXinGzUserInfoo.getCustomerSex())) {
				if (weiXinGzUserInfoo.getCustomerSex() != null) {
					if (weiXinGzUserInfoo.getCustomerSex().equals("M")) {
						fieldReportValueStr = fieldReportValueStr + ";" + "男";
					} else {
						fieldReportValueStr = fieldReportValueStr + ";" + "女";
					}
				} else {
					fieldReportValueStr = fieldReportValueStr + ";" + "null";
				}

			}

			if (birthdayflag) {
				fieldReportValueStr = fieldReportValueStr + ";"
						+ weiXinGzUserInfoo.getCustomerBirthday() + "";
			}

			if (!" ".equals(weiXinGzUserInfoo.getEventKey())) {
				fieldReportValueStr = fieldReportValueStr + ";"
						+ weiXinGzUserInfoo.getEventKey();
			}
			if (!" ".equals(weiXinGzUserInfoo.getIdentifyType())) {
				fieldReportValueStr = fieldReportValueStr + ";"
						+ weiXinGzUserInfoo.getIdentifyType();
			}

			String[] fieldReportValueStrs = fieldReportValueStr.split(";");
			for (int z = 1; z < fieldReportValueStrs.length; z++) {
				row.createCell(z - 1).setCellValue(fieldReportValueStrs[z]);
			}

		}
		return wb;
	}

	// 设置excel的title表头样式
	private HSSFCellStyle createTitleStyle(HSSFWorkbook wb) {
		// 头部标题样式
		HSSFFont headFont = wb.createFont();
		// 设置字号
		headFont.setFontHeightInPoints((short) 16);

		headFont.setBoldweight((short) 200);

		headFont.setFontHeight((short) 200);
		// 设置字体
		headFont.setFontName("Arial");
		// 设置加粗
		headFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);

		HSSFCellStyle style0 = wb.createCellStyle();
		style0.setFont(headFont);
		// 水平居中
		style0.setAlignment(HSSFCellStyle.ALIGN_CENTER_SELECTION);
		// 垂直居中
		style0.setVerticalAlignment(HSSFCellStyle.ALIGN_CENTER_SELECTION);
		style0.setDataFormat(HSSFDataFormat.getBuiltinFormat("###,##0.00"));
		// 设置背景颜色
		// style0.setFillForegroundColor((short) 13);// 设置背景色
		style0.setFillForegroundColor(HSSFColor.LIGHT_CORNFLOWER_BLUE.index);// 设置背景色
		style0.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);

		return style0;
	}

}
