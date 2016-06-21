/**
 * 
 */
package cn.com.fubon.reportform.offlinepay.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jodd.util.StringUtil;

import org.apache.log4j.Logger;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.com.fubon.pay.controller.PayController;
import cn.com.fubon.pay.entity.WeiXinOfflineOrderInfo;
import cn.com.fubon.product.entity.Product;
import cn.com.fubon.reportform.offlinepay.service.OfflinePayService;

/**
 * 保费支付报表
 * 
 * @author qingqu.huang
 * @date 20150930
 */
@Scope("prototype")
@Controller
@RequestMapping("/report/offlinePayReportController")
public class OfflinePayReportController {

	private static final Logger logger = Logger.getLogger(OfflinePayReportController.class);
	@Resource
	private OfflinePayService offlinePayServiceImpl;

	@RequestMapping(params = "offlinePayReportIndex")
	public String offlinePayReportIndex(HttpServletRequest request) {
		return "/reportform/offlinePayReport";
	}

	/**
	 * easyuiAJAX保单列表请求数据
	 * 
	 * @param weiXinOfflineOrderInfo
	 * @param request
	 * @param response
	 * @param dataGrid
	 */
	@RequestMapping(params = "datagrid")
	public void datagrid(WeiXinOfflineOrderInfo weiXinOfflineOrderInfo,
			HttpServletRequest request, HttpServletResponse response,
			DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(WeiXinOfflineOrderInfo.class,
				dataGrid);
		// 查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq,
				weiXinOfflineOrderInfo);
		String createTime_begin = request.getParameter("CreateTime_begin");
		String createTime_end = request.getParameter("CreateTime_end");
		try {
			if (StringUtil.isNotEmpty(createTime_begin)) {
				cq.ge("createTime", new SimpleDateFormat("yyyy-MM-dd")
						.parse(createTime_begin));
			}
			if (StringUtil.isNotEmpty(createTime_end)) {
				cq.le("createTime", new SimpleDateFormat("yyyy-MM-dd")
						.parse(createTime_end));
			}
		} catch (ParseException e) {
			logger.error("日期格式化出错...", e);
		}
		cq.add();
		offlinePayServiceImpl.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
}
