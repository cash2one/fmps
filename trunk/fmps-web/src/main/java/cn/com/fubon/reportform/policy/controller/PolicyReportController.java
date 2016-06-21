package cn.com.fubon.reportform.policy.controller;

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

import cn.com.fubon.reportform.policy.entity.PolicyReport;
import cn.com.fubon.reportform.policy.service.PolicyReportService;

/**
 * 保单查询报表
 * 
 * @author xiaomei.wu
 * 
 */
@Scope("prototype")
@Controller
@RequestMapping("/policyReport/PolicyReportController")
public class PolicyReportController {

	private static final Logger logger = Logger
			.getLogger(PolicyReportController.class);

	@Resource
	private PolicyReportService policyReportService;


	/**
	 * 进入保单查询列表界面
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "policyReport")
	public ModelAndView product(HttpServletRequest request) {
		return new ModelAndView("reportform/policy/policyReportList");
	}

	/**
	 * easyuiAJAX保单列表请求数据
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 * @throws ParseException
	 */
	@RequestMapping(params = "datagrid")
	public void datagrid(PolicyReport policyReport,
			HttpServletRequest request, HttpServletResponse response,
			DataGrid dataGrid) throws ParseException {

		String create_time_begin = request.getParameter("createTime_begin");
		String create_time_end = request.getParameter("createTime_end");

		String insuredName = request.getParameter("insuredName");
		String identifyNumber = request.getParameter("identifyNumber");
		String policyNo = request.getParameter("policyNo");
		String phone = request.getParameter("phone");
		String policyStatus = request.getParameter("policyStatus");
		
		PolicyReport policyReporto = new PolicyReport();

		CriteriaQuery cq = new CriteriaQuery(PolicyReport.class, dataGrid);
		cq.addOrder("createTime", SortDirection.desc);
		if (!StringUtil.isEmpty(insuredName)) {
			cq.like("insuredName", "%" + insuredName + "%");
		}
		if (!StringUtil.isEmpty(identifyNumber)) {
			cq.like("identifyNumber", "%" + identifyNumber + "%");
		}
		if (!StringUtil.isEmpty(policyNo)) {
			cq.like("policyNo", "%" + policyNo + "%");
		}
		if (!StringUtil.isEmpty(phone)) {
			cq.like("phone", "%" + phone + "%");
		}
		if (!StringUtil.isEmpty(create_time_begin)) {
			cq.ge("createTime", create_time_begin);
		}
		if (!StringUtil.isEmpty(create_time_end)) {
			cq.le("createTime", create_time_end);
		}
		if (!StringUtil.isEmpty(policyStatus)) {
			cq.eq("policyStatus", policyStatus);
		}
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, policyReporto);
		
		cq.add();
		policyReportService.getDataGridReturn(cq, true);

		TagUtil.datagrid(response, dataGrid);
	}

	@RequestMapping(params = "exportXlscheck")
	public void exportXlscheck(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		PolicyReport policyReport = new PolicyReport();

		CriteriaQuery cq = new CriteriaQuery(PolicyReport.class);
		cq.addOrder("createTime", SortDirection.desc);
		// 查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, policyReport);
		cq.add();
		List<PolicyReport> policyReports = policyReportService.getListByCriteriaQuery(cq, false);
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

		HSSFWorkbook wb = this.export(policyReports, fieldReportStr);

		String fileName = "保单查询列表.xls";
		fileName = new String(fileName.getBytes("GBK"), "iso8859-1");

		response.setHeader("Content-Disposition", "attachment;filename="
				+ fileName);// 指定下载的文件名

		OutputStream ouputStream = response.getOutputStream();
		wb.write(ouputStream);
		ouputStream.flush();
		ouputStream.close();
	}

	public HSSFWorkbook export(List<PolicyReport> policyReports,
			String str) {
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet("policy");

		// 定义单元格报头
		String worksheetTitle = "保单查询列表";

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

		HSSFCellStyle style = createTitleStyle(wb);
		HSSFRow row2 = sheet.createRow((int) 1);
		for (int i = 1; i < excelHeader.length; i++) {
			cell = row2.createCell(i - 1);
			cell.setCellValue(excelHeader[i]);
			cell.setCellStyle(style);
			sheet.setColumnWidth(0, 6000);
			sheet.setColumnWidth(i, 6000);
		}

		logger.info("保单数量=>" + policyReports.size());

		for (int i = 0; i < policyReports.size(); i++) {
			row = sheet.createRow(i + 2);
			PolicyReport policyReport = policyReports.get(i);

			PolicyReport policyReporto = new PolicyReport();

			if (Arrays.asList(excelHeader).contains("微信号")) {
				policyReporto.setOpenid(policyReport.getOpenid());
			} else {
				policyReporto.setOpenid(" ");
			}

			if (Arrays.asList(excelHeader).contains("昵称")) {
				policyReporto.setNickname(policyReport.getNickname());
			} else {
				policyReporto.setNickname(" ");
			}
			if (Arrays.asList(excelHeader).contains("保单号")) {
				policyReporto.setPolicyNo(policyReport.getPolicyNo());
			} else {
				policyReporto.setPolicyNo(" ");
			}

			if (Arrays.asList(excelHeader).contains("被保人姓名")) {
				policyReporto.setInsuredName(policyReport.getInsuredName());
			} else {
				policyReporto.setInsuredName(" ");
			}

			if (Arrays.asList(excelHeader).contains("证件号码")) {
				policyReporto.setIdentifyNumber(policyReport.getIdentifyNumber());
			} else {
				policyReporto.setIdentifyNumber(" ");
			}

			if (Arrays.asList(excelHeader).contains("地址")) {
				policyReporto.setAddress(policyReport.getAddress());
			} else {
				policyReporto.setAddress(" ");
			}
			if (Arrays.asList(excelHeader).contains("电话")) {
				policyReporto.setPhone(policyReport.getPhone());
			} else {
				policyReporto.setPhone(" ");
			}

			if (Arrays.asList(excelHeader).contains("学校")) {
				policyReporto.setSchool(policyReport.getSchool());
			} else {
				policyReporto.setSchool(" ");
			}

			if (Arrays.asList(excelHeader).contains("保费")) {
				policyReporto.setPremium(policyReport.getPremium());
			} else {
				policyReporto.setPremium(" ");
			}

			if (Arrays.asList(excelHeader).contains("投保日期")) {
				policyReporto.setCreateTime(policyReport.getCreateTime());
			} else {
				policyReporto.setCreateTime(" ");
			}

			if (Arrays.asList(excelHeader).contains("保单状态")) {
				policyReporto.setPolicyStatus(policyReport.getPolicyStatus());
			} else {
				policyReporto.setPolicyStatus(" ");
			}

			if (Arrays.asList(excelHeader).contains("支付金额")) {
				policyReporto.setTotalFee(policyReport.getTotalFee());
			} else {
				policyReporto.setTotalFee(" ");
			}

			// excel每列的值
			String fieldReportValueStr = "";

			if (!" ".equals(policyReporto.getOpenid())) {
				fieldReportValueStr = fieldReportValueStr + ";"
						+ policyReporto.getOpenid();
			}
			if (!" ".equals(policyReporto.getNickname())) {
				fieldReportValueStr = fieldReportValueStr + ";"
						+ policyReporto.getNickname();
			}
			if (!" ".equals(policyReporto.getPolicyNo())) {
				fieldReportValueStr = fieldReportValueStr + ";"
						+ policyReporto.getPolicyNo();
			}
			if (!" ".equals(policyReporto.getInsuredName())) {
				fieldReportValueStr = fieldReportValueStr + ";"
						+ policyReporto.getInsuredName();
			}
			if (!" ".equals(policyReporto.getIdentifyNumber())) {
				fieldReportValueStr = fieldReportValueStr + ";"
						+ policyReporto.getIdentifyNumber();
			}
			if (!" ".equals(policyReporto.getAddress())) {
				fieldReportValueStr = fieldReportValueStr + ";"
						+ policyReporto.getAddress();
			}
			if (!" ".equals(policyReporto.getPhone())) {
				fieldReportValueStr = fieldReportValueStr + ";"
						+ policyReporto.getPhone();
			}
			if (!" ".equals(policyReporto.getSchool())) {
				fieldReportValueStr = fieldReportValueStr + ";"
						+ policyReporto.getSchool();
			}
			if (!" ".equals(policyReporto.getPremium())) {
				fieldReportValueStr = fieldReportValueStr + ";"
						+ policyReporto.getPremium();
			}
			if (!" ".equals(policyReporto.getCreateTime())) {
				fieldReportValueStr = fieldReportValueStr + ";"
						+ policyReporto.getCreateTime();
			}
			if (!" ".equals(policyReporto.getPolicyStatus())) {
				fieldReportValueStr = fieldReportValueStr + ";"
						+ policyReporto.getPolicyStatus();
			}
			if (!" ".equals(policyReporto.getTotalFee())) {
				fieldReportValueStr = fieldReportValueStr + ";"
						+ policyReporto.getTotalFee();
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
