/**
 * 
 */
package cn.com.fubon.bo.wxtemplatemessage.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.util.MyBeanUtils;
import org.jeecgframework.core.util.ResourceUtil;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.service.SystemService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import weixin.guanjia.account.entity.WeixinAccountEntity;
import weixin.guanjia.account.service.WeixinAccountServiceI;
import cn.com.fubon.bo.wxtemplatemessage.entity.WeiXinTemplate;
import cn.com.fubon.bo.wxtemplatemessage.entity.WeiXinTemplateMessageRecord;
import cn.com.fubon.bo.wxtemplatemessage.service.WeiXinTemplateMessageService;

/**
 * 微信模板消息管理控制类
 * 
 * @author binbin.wang
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/bo/templateMessageController")
public class WeiXinTemplateMessageController {
	
	private static final String PAGE_PATH_TEMPLATE_LIST = "weixin/guanjia/wx_template_message/template_list";
	private static final String PAGE_PATH_TEMPLATE_INFO = "weixin/guanjia/wx_template_message/template_info";
	private static final String PAGE_PATH_MESSAGE_LIST = "weixin/guanjia/wx_template_message/message_list";
	private static final String PAGE_PATH_MESSAGE_INFO = "weixin/guanjia/wx_template_message/message_info";
	
	@Resource
	private WeiXinTemplateMessageService templateMessageService;
	
	@Resource
	private WeixinAccountServiceI weixinAccountService;
	
	@Resource
	private SystemService systemService;
	
	private String message;
	
	@RequestMapping(params = "templateList")
	public ModelAndView templateList() {
		return new ModelAndView(PAGE_PATH_TEMPLATE_LIST);
	}
	
	@RequestMapping(params = "messageList")
	public ModelAndView messageList() {
		
		return new ModelAndView(PAGE_PATH_MESSAGE_LIST);
	}
	
	@RequestMapping(params = "templateGrid")
	public void templateGrid(WeiXinTemplate weixinTemplate, HttpServletRequest request,
			HttpServletResponse response, DataGrid dataGrid) {
		
		CriteriaQuery cq = new CriteriaQuery(WeiXinTemplate.class, dataGrid);
		cq.createCriteria("account");
		cq.eq("account.id", ResourceUtil.getWeiXinAccountId());
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq,
				weixinTemplate);
		this.templateMessageService.getDataGridReturn(cq, true);

		TagUtil.datagrid(response, dataGrid);
	}
	
	@RequestMapping(params = "addorUpdateTemplate")
	public ModelAndView addorUpdateTemplate(HttpServletRequest req) {
		
		String id = req.getParameter("id");
		req.setAttribute("id", id);
		if (StringUtil.isNotEmpty(id)) {
			WeiXinTemplate weiXinTemplate = this.templateMessageService.getEntity(WeiXinTemplate.class, id);
			req.setAttribute("weiXinTemplate", weiXinTemplate);
		}
		
		List<WeixinAccountEntity> accountList = weixinAccountService.findValidWeixinAccounts();
		req.setAttribute("accountList", accountList);
		
		return new ModelAndView(PAGE_PATH_TEMPLATE_INFO);
	}
	
	@RequestMapping(params = "doSaveTemplate")
	@ResponseBody
	public AjaxJson doSaveTemplate(WeiXinTemplate weixinTemplate, HttpServletRequest request) {
		
		AjaxJson returnJson = new AjaxJson();
		String templateId = weixinTemplate.getId();
		
		if (!StringUtils.isBlank(templateId)) {	
			//修改
			WeiXinTemplate weixinTemplateAutoResponse = this.templateMessageService.getEntity(WeiXinTemplate.class, templateId);
			this.message = "修改微信消息模板成功";
			weixinTemplate.setUpdateTime(new Date());
			try {
				MyBeanUtils.copyBeanNotNull2Bean(weixinTemplate, weixinTemplateAutoResponse);
				this.templateMessageService.saveOrUpdate(weixinTemplateAutoResponse);
				systemService.addLog(message, Globals.Log_Type_UPDATE,
						Globals.Log_Leavel_INFO);
			}catch(Exception e) {
				this.message = "修改微信消息模板失败。";
				e.printStackTrace();
			}
		}else {
			//新增
			this.templateMessageService.save(weixinTemplate);
		}
		
		return returnJson;
	}
	
	@RequestMapping(params = "messageGrid")
	public void messageGrid(WeiXinTemplateMessageRecord messageRecord, HttpServletRequest request,
			HttpServletResponse response, DataGrid dataGrid) {
		
		CriteriaQuery cq = new CriteriaQuery(WeiXinTemplateMessageRecord.class, dataGrid);
		cq.eq("account.id", ResourceUtil.getWeiXinAccountId());
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq,
				messageRecord);
		this.templateMessageService.getDataGridReturn(cq, true);

		TagUtil.datagrid(response, dataGrid);
	}

	@RequestMapping(params = "addorUpdateMessage")
	public ModelAndView addorUpdateMessage(HttpServletRequest req) {
		
		String id = req.getParameter("id");
		req.setAttribute("id", id);
		if (StringUtil.isNotEmpty(id)) {
			WeiXinTemplate weiXinTemplate = this.templateMessageService.getEntity(WeiXinTemplate.class, id);
			req.setAttribute("weiXinTemplate", weiXinTemplate);
		}
		
		List<WeixinAccountEntity> accountList = weixinAccountService.findValidWeixinAccounts();
		req.setAttribute("accountList", accountList);
		
		return new ModelAndView(PAGE_PATH_MESSAGE_INFO);
	}
		
}
