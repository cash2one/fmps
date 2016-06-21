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

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.tag.vo.datatable.SortDirection;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.com.fubon.reportform.user.entity.WeixinGasolineGiftReport;
import cn.com.fubon.reportform.user.service.IGasolineGiftReportService;

/**
 * 加油宝报表
 * 
 * @author yaoming.zhang
 * @date 2015-10-27
 */
@Scope("prototype")
@Controller
@RequestMapping("/gasolineGift/gasolineGiftReportController")
public class GasolineGiftReportController {

	@Resource
	private IGasolineGiftReportService gasolineGiftReportService;

	/**
	 * 进入加油宝报表列表界面
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "gasolinegiftIndex")
	public ModelAndView gasolinegiftIndex(HttpServletRequest request) {
		return new ModelAndView("reportform/gasolinegift/gasolinegiftReportList");
	}

	/**
	 * easyuiAJAX加油宝报表请求数据
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 * @throws ParseException
	 */
	@RequestMapping(params = "datagrid")
	public void datagrid(HttpServletRequest request,
			HttpServletResponse response, DataGrid dataGrid)
			throws ParseException {
		
		//客户名称
		String customercname = request.getParameter("customercname");		
		//机构名称
		String comcname = request.getParameter("comcname");		
		//业务员姓名
		String handlername = request.getParameter("handlername");		
		//车牌号
		String licenseno = request.getParameter("licenseno");		
		//手机号
		String mobile = request.getParameter("mobile");		
		//使用日期
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String applyTime_begin = request.getParameter("applyTime_begin");
		String applyTime_end = request.getParameter("applyTime_end");
		Date applyTime_begindate = new Date();
		Date applyTime_enddate = new Date();
		if (!StringUtil.isEmpty(applyTime_begin)) {
			applyTime_begin = applyTime_begin + " 00:00:00";
			applyTime_begindate = sdf.parse(applyTime_begin);
		}
		if (!StringUtil.isEmpty(applyTime_end)) {
			applyTime_end = applyTime_end + " 00:00:00";
			applyTime_enddate = sdf.parse(applyTime_end);
		}
		
		WeixinGasolineGiftReport weixinGasolineGiftReport = new WeixinGasolineGiftReport();
		
		CriteriaQuery cq = new CriteriaQuery(WeixinGasolineGiftReport.class, dataGrid);
		cq.addOrder("applyTime", SortDirection.desc);
		if (!StringUtil.isEmpty(applyTime_begin)) {
			cq.ge("applyTime", applyTime_begindate);
		}
		if (!StringUtil.isEmpty(applyTime_end)) {
			cq.le("applyTime", applyTime_enddate);
		}
		if (!StringUtil.isEmpty(customercname)) {
			cq.like("customercname", "%" + customercname + "%");
		}
		if (!StringUtil.isEmpty(comcname)) {
			cq.like("comcname", "%" + comcname + "%");
		}
		if (!StringUtil.isEmpty(handlername)) {
			cq.like("handlername", "%" + handlername + "%");
		}
		
		if (!StringUtil.isEmpty(licenseno)) {
			cq.like("licenseno", "%" + licenseno + "%");
		}
		
		if (!StringUtil.isEmpty(mobile)) {
			cq.like("mobile", "%" + mobile + "%");
		}

		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, weixinGasolineGiftReport);
		cq.add();
		
		gasolineGiftReportService.getDataGridReturn(cq, true);

		TagUtil.datagrid(response, dataGrid);
	}

	@RequestMapping(params = "exportXlscheck")
	public void exportXlscheck(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		//下载excel，筛选日期范围
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String begindate = request.getParameter("begindate");
		String enddate = request.getParameter("enddate");
		
		String customercname = request.getParameter("customercname");
		String licenseno = request.getParameter("licenseno");
		String mobile = request.getParameter("mobile");
		String handlername = request.getParameter("handlername");
		String comcname = request.getParameter("comcname");
		
		
		Date search_begindate = new Date();
		Date search_enddate = new Date();
		if (!StringUtil.isEmpty(begindate)) {
			begindate = begindate + " 00:00:00";
			search_begindate = sdf.parse(begindate);
		}
		if (!StringUtil.isEmpty(enddate)) {
			enddate = enddate + " 00:00:00";
			search_enddate = sdf.parse(enddate);
		}
				
		WeixinGasolineGiftReport weixinGasolineGiftReport = new WeixinGasolineGiftReport();

		CriteriaQuery cq = new CriteriaQuery(WeixinGasolineGiftReport.class);
		cq.addOrder("applyTime", SortDirection.desc);
		if (!StringUtil.isEmpty(begindate)) {
			cq.ge("applyTime", search_begindate);
		}
		if (!StringUtil.isEmpty(enddate)) {
			cq.le("applyTime", search_enddate);
		}
		if (!StringUtil.isEmpty(customercname)) {
			cq.like("customercname", "%" + customercname + "%");
		}
		if (!StringUtil.isEmpty(comcname)) {
			cq.like("comcname", "%" + comcname + "%");
		}
		if (!StringUtil.isEmpty(handlername)) {
			cq.like("handlername", "%" + handlername + "%");
		}
		
		if (!StringUtil.isEmpty(licenseno)) {
			cq.like("licenseno", "%" + licenseno + "%");
		}
		
		if (!StringUtil.isEmpty(mobile)) {
			cq.like("mobile", "%" + mobile + "%");
		}
		
		// 查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq,
				weixinGasolineGiftReport);
		cq.add();
		List<WeixinGasolineGiftReport> weixinGasolineGiftReportList = gasolineGiftReportService
				.getListByCriteriaQuery(cq, false);
		// excel所选的字段
		String fieldReportStr = "";
		Map map = new HashMap();
		map = request.getParameterMap();
		Iterator iter = map.entrySet().iterator();
		while (iter.hasNext()) {
			Map.Entry entry = (Map.Entry) iter.next();
			Object key = entry.getKey();
			if(!key.equals("begindate") && !key.equals("enddate")){
				Object[] val = (Object[]) entry.getValue();
				// 排除值为"","确认","on"的参数
				if (val != null && !val[0].equals("") && !val[0].equals("确认")
						&& !val[0].equals("on")) {
					fieldReportStr = fieldReportStr.trim() + ";" + val[0];
				}
			}
		}
		
		HSSFWorkbook wb = this.export(weixinGasolineGiftReportList, fieldReportStr);

		String fileName = "加油宝报表数据.xls";
		fileName = new String(fileName.getBytes("GBK"), "iso8859-1");

		response.setHeader("Content-Disposition", "attachment;filename="
				+ fileName);// 指定下载的文件名

		OutputStream ouputStream = response.getOutputStream();
		wb.write(ouputStream);
		ouputStream.flush();
		ouputStream.close();
	}

	public HSSFWorkbook export(List<WeixinGasolineGiftReport> weixinGasolineGiftReportList,
			String str) {
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet("加油宝报表");

		// 设置第一行
		HSSFRow row = sheet.createRow((int) 0);
		row.setHeight((short) 500);
		// 设置第一列
		HSSFCell cell = row.createCell(0);
		
		/**
		 * 头部区域单元格样式
		 * 如：openid、身份证号、客户名称等....头部
		 */
		HSSFCellStyle style = createTitleStyle(wb);
		
		String[] excelHeader;
		excelHeader = str.split(";");
		for (int i = 1; i < excelHeader.length; i++) {
			cell = row.createCell(i - 1);
			cell.setCellValue(excelHeader[i]);
			cell.setCellStyle(style);
			
			sheet.setColumnWidth(0, 6000);
			sheet.setColumnWidth(i, 6000);
		}
		
		// 使用日期标记
		boolean applytimeflag = false;
		
		// 使用日期标记
		boolean rchgDctExpireflag = false;

		/**
		 * 内容区域单元格样式
		 */
		HSSFCellStyle styleContent = this.solidBorder(wb);
		
		for (int i = 0; i < weixinGasolineGiftReportList.size(); i++) {
			row = sheet.createRow(i + 1);
			row.setHeightInPoints(24);
			WeixinGasolineGiftReport weixinGasolineGiftReport = weixinGasolineGiftReportList.get(i);

			WeixinGasolineGiftReport weixinGasolineGiftReportTemp = new WeixinGasolineGiftReport();

			if (Arrays.asList(excelHeader).contains("openid")) {
				weixinGasolineGiftReportTemp.setOpenid(weixinGasolineGiftReport.getOpenid());
			} else {
				weixinGasolineGiftReportTemp.setOpenid(" ");
			}

			if (Arrays.asList(excelHeader).contains("客户姓名")) {
				weixinGasolineGiftReportTemp.setCustomercname(weixinGasolineGiftReport.getCustomercname());
			} else {
				weixinGasolineGiftReportTemp.setCustomercname(" ");
			}
			
			if (Arrays.asList(excelHeader).contains("身份证号")) {
				weixinGasolineGiftReportTemp.setIdentifynumber(weixinGasolineGiftReport.getIdentifynumber());
			} else {
				weixinGasolineGiftReportTemp.setIdentifynumber(" ");
			}

			if (Arrays.asList(excelHeader).contains("车牌号")) {
				weixinGasolineGiftReportTemp.setLicenseno(weixinGasolineGiftReport.getLicenseno());
			} else {
				weixinGasolineGiftReportTemp.setLicenseno(" ");
			}
			
			if (Arrays.asList(excelHeader).contains("手机")) {
				weixinGasolineGiftReportTemp.setMobile(weixinGasolineGiftReport.getMobile());
			} else {
				weixinGasolineGiftReportTemp.setMobile(" ");
			}

			if (Arrays.asList(excelHeader).contains("领取方式")) {
				String getway = weixinGasolineGiftReport.getGetWay();
				String getwayContent = "";
				if("0".equalsIgnoreCase(getway)){
					getwayContent = "上门自取";
				}else if("1".equalsIgnoreCase(getway)){
					getwayContent = "寄送";
				}
				weixinGasolineGiftReportTemp.setGetWay(getwayContent);
			} else {
				weixinGasolineGiftReportTemp.setGetWay(" ");
			}
			
			if (Arrays.asList(excelHeader).contains("快递寄送地址")) {
				weixinGasolineGiftReportTemp.setExpressAddress(weixinGasolineGiftReport.getExpressAddress());
			} else {
				weixinGasolineGiftReportTemp.setExpressAddress(" ");
			}
			
			if (Arrays.asList(excelHeader).contains("上门自取机构名称")) {
				weixinGasolineGiftReportTemp.setPickupAddress(weixinGasolineGiftReport.getPickupAddress());
			} else {
				weixinGasolineGiftReportTemp.setPickupAddress(" ");
			}

			if (Arrays.asList(excelHeader).contains("业务员姓名")) {
				weixinGasolineGiftReportTemp.setHandlername(weixinGasolineGiftReport.getHandlername());
			} else {
				weixinGasolineGiftReportTemp.setHandlername(" ");
			}
			
			if (Arrays.asList(excelHeader).contains("业务员工号")) {
				weixinGasolineGiftReportTemp.setHandlercode(weixinGasolineGiftReport.getHandlercode());
			} else {
				weixinGasolineGiftReportTemp.setHandlercode(" ");
			}

			if (Arrays.asList(excelHeader).contains("归属机构")) {
				weixinGasolineGiftReportTemp.setComcname(weixinGasolineGiftReport.getComcname());
			} else {
				weixinGasolineGiftReportTemp.setComcname(" ");
			}

			if (Arrays.asList(excelHeader).contains("申请日期")) {
				weixinGasolineGiftReportTemp.setApplyTime(weixinGasolineGiftReport.getApplyTime());
				applytimeflag = true;
			} else {
				applytimeflag = false;
			}
			
			if (Arrays.asList(excelHeader).contains("优惠有效期")) {
				weixinGasolineGiftReportTemp.setRchgDctExpire(weixinGasolineGiftReport.getRchgDctExpire());
				rchgDctExpireflag = true;
			} else {
				rchgDctExpireflag = false;
			}

			if (Arrays.asList(excelHeader).contains("加油宝券id")) {
				weixinGasolineGiftReportTemp.setGiftid(weixinGasolineGiftReport.getGiftid());
			} else {
				weixinGasolineGiftReportTemp.setGiftid(" ");

			}
			if (Arrays.asList(excelHeader).contains("加油卡卡号")) {
				weixinGasolineGiftReportTemp.setOilCardNo(weixinGasolineGiftReport.getOilCardNo());
			} else {
				weixinGasolineGiftReportTemp.setOilCardNo(" ");

			}

			// excel每列的值
			String fieldReportValueStr = "";

			if (!" ".equals(weixinGasolineGiftReportTemp.getOpenid())) {
				fieldReportValueStr = fieldReportValueStr + ";"
						+ weixinGasolineGiftReportTemp.getOpenid();
			}
			if (!" ".equals(weixinGasolineGiftReportTemp.getCustomercname())) {
				fieldReportValueStr = fieldReportValueStr + ";"
						+ weixinGasolineGiftReportTemp.getCustomercname();
			}
			if (!" ".equals(weixinGasolineGiftReportTemp.getIdentifynumber())) {
				fieldReportValueStr = fieldReportValueStr + ";"
						+ weixinGasolineGiftReportTemp.getIdentifynumber();
			}
			if (!" ".equals(weixinGasolineGiftReportTemp.getLicenseno())) {
				fieldReportValueStr = fieldReportValueStr + ";"
						+ weixinGasolineGiftReportTemp.getLicenseno();
			}
			if (!" ".equals(weixinGasolineGiftReportTemp.getMobile())) {
				fieldReportValueStr = fieldReportValueStr + ";"
						+ weixinGasolineGiftReportTemp.getMobile();
			}
			if (!" ".equals(weixinGasolineGiftReportTemp.getGetWay())) {
				fieldReportValueStr = fieldReportValueStr + ";"
						+ weixinGasolineGiftReportTemp.getGetWay();
			}
			if (!" ".equals(weixinGasolineGiftReportTemp.getExpressAddress())) {
				fieldReportValueStr = fieldReportValueStr + ";"
						+ weixinGasolineGiftReportTemp.getExpressAddress();
			}
			if (!" ".equals(weixinGasolineGiftReportTemp.getPickupAddress())) {
				fieldReportValueStr = fieldReportValueStr + ";"
						+ weixinGasolineGiftReportTemp.getPickupAddress();
			}
			if (!" ".equals(weixinGasolineGiftReportTemp.getHandlername())) {
				fieldReportValueStr = fieldReportValueStr + ";"
						+ weixinGasolineGiftReportTemp.getHandlername();
			}
			if (!" ".equals(weixinGasolineGiftReportTemp.getHandlercode())) {
				fieldReportValueStr = fieldReportValueStr + ";"
						+ weixinGasolineGiftReportTemp.getHandlercode();
			}
			if (!" ".equals(weixinGasolineGiftReportTemp.getComcname())) {
				fieldReportValueStr = fieldReportValueStr + ";"
						+ weixinGasolineGiftReportTemp.getComcname();
			}
			if (applytimeflag) {
				fieldReportValueStr = fieldReportValueStr + ";"
						+ weixinGasolineGiftReportTemp.getApplyTime() + "";
			}
			
			if (rchgDctExpireflag) {
				fieldReportValueStr = fieldReportValueStr + ";"
						+ weixinGasolineGiftReportTemp.getRchgDctExpire() + "";
			}			
			
			if (!" ".equals(weixinGasolineGiftReportTemp.getGiftid())) {
				fieldReportValueStr = fieldReportValueStr + ";"
						+ weixinGasolineGiftReportTemp.getGiftid();
			}
			
			if (!" ".equals(weixinGasolineGiftReportTemp.getOilCardNo())) {
				fieldReportValueStr = fieldReportValueStr + ";"
						+ weixinGasolineGiftReportTemp.getOilCardNo();
			}

			String[] fieldReportValueStrs = fieldReportValueStr.split(";");
			for (int z = 1; z < fieldReportValueStrs.length; z++) {
				HSSFCell cellContent = row.createCell(z - 1);
				cellContent.setCellValue(fieldReportValueStrs[z].equalsIgnoreCase("null")?" ":fieldReportValueStrs[z]);
				cellContent.setCellStyle(styleContent);	//实线边框
			}
			
		}
		return wb;
	}

	// 设置excel的title表头样式
	// openid、身份证号、客户名称等....头部
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

		HSSFCellStyle style = this.solidBorder(wb);
		style.setFont(headFont);
		// 水平居中
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER_SELECTION);
		// 垂直居中
		style.setVerticalAlignment(HSSFCellStyle.ALIGN_CENTER_SELECTION);
		style.setDataFormat(HSSFDataFormat.getBuiltinFormat("###,##0.00"));
		// 设置背景颜色
		// style0.setFillForegroundColor((short) 13);// 设置背景色
		// style0.setFillForegroundColor(HSSFColor.LIGHT_CORNFLOWER_BLUE.index);// 设置背景色
		style.setFillForegroundColor(HSSFColor.GREY_25_PERCENT.index);// 浅灰色
		style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);

		return style;
	}
	
	/**
	 * 实线边框
	 * 
	 * @param wb
	 * @return
	 */
	private HSSFCellStyle solidBorder(HSSFWorkbook wb) {
		HSSFCellStyle style = wb.createCellStyle();
		style.setBorderTop(HSSFCellStyle.BORDER_THIN);		// 上边框
		style.setBorderBottom(HSSFCellStyle.BORDER_THIN);	// 下边框
		style.setBorderLeft(HSSFCellStyle.BORDER_THIN);		// 左边框
		style.setBorderRight(HSSFCellStyle.BORDER_THIN);	// 右边框
		style.setTopBorderColor(HSSFColor.BLACK.index);		// 上边框颜色
		style.setBottomBorderColor(HSSFColor.BLACK.index);	// 下边框颜色
		style.setLeftBorderColor(HSSFColor.BLACK.index);	// 左边框颜色
		style.setRightBorderColor(HSSFColor.BLACK.index);	// 右边框颜色

		return style;
	}

}
