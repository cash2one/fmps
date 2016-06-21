package org.jeecgframework.web.system.controller.core;
import java.net.SocketException;
import java.text.ParseException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.timer.DynamicTask;
import org.jeecgframework.core.util.IpUtil;
import org.jeecgframework.core.util.MyBeanUtils;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.core.util.oConvertUtils;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.pojo.base.TSTimeTaskEntity;
import org.jeecgframework.web.system.service.SystemService;
import org.jeecgframework.web.system.service.TimeTaskServiceI;
import org.quartz.impl.triggers.CronTriggerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


/**   
 * @Title: Controller
 * @Description: 定时任务管理
 * @author jueyue
 * @date 2013-09-21 20:47:43
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/timeTaskController")
public class TimeTaskController extends BaseController {
	Logger logger = Logger.getLogger(TimeTaskController.class);
	@Autowired
	private TimeTaskServiceI timeTaskService;
	@Autowired
	private DynamicTask dynamicTask;
	@Autowired
	private SystemService systemService;
	private String message;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}


	/**
	 * 定时任务管理列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "timeTask")
	public ModelAndView timeTask(HttpServletRequest request) {
		return new ModelAndView("system/timetask/timeTaskList");
	}

	/**
	 * easyui AJAX请求数据
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 * @param user
	 */

	@RequestMapping(params = "datagrid")
	public void datagrid(TSTimeTaskEntity timeTask,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(TSTimeTaskEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, timeTask, request.getParameterMap());
		this.timeTaskService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除定时任务管理
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(TSTimeTaskEntity timeTask, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		timeTask = systemService.getEntity(TSTimeTaskEntity.class, timeTask.getId());
		
		//如果任务正在运行，resume掉
		message = "定时任务管理删除失败";
		if(dynamicTask.startOrStop(timeTask.getTaskId(),false)){
			timeTaskService.delete(timeTask);
			message = "定时任务管理删除成功";
		};
		
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加定时任务管理
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(TSTimeTaskEntity timeTask, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		CronTriggerImpl trigger = new CronTriggerImpl();
		try {
			trigger.setCronExpression(timeTask.getCronExpression());
		} catch (ParseException e) {
			j.setSuccess(false);
			j.setMsg("Cron表达式错误");
			return j;
		}
		
		//编辑的IP只能是本地的IP
		boolean hasPassIpCheck = false;
		try{
			hasPassIpCheck = IpUtil.hasPassIpCheck(timeTask.getIpFilter());
		}catch(SocketException ex){
			logger.error("hasPassIpCheck SocketException",ex);
			j.setSuccess(false);
			j.setMsg("校验IP时发生异常");
			return j;
		}
		if(!hasPassIpCheck){
			j.setSuccess(false);
			j.setMsg("IP须含有本机IP");
			return j;
		}
		
		message = "定时任务管理更新成功";
		if (StringUtil.isNotEmpty(timeTask.getId())) {
			TSTimeTaskEntity t = timeTaskService.get(TSTimeTaskEntity.class, timeTask.getId());
			try {
				if(!timeTask.getCronExpression().equals(t.getCronExpression())){
					timeTask.setIsEffect("0");
				}
				MyBeanUtils.copyBeanNotNull2Bean(timeTask, t);
				timeTaskService.saveOrUpdate(t);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				message = "定时任务管理更新失败";
				logger.error(message,e);
			}
		} else {
			//如果已经存在同taskId的任务，新增失败
			if(timeTaskService.isExistsTaskId(timeTask.getTaskId())){
				j.setMsg("不能新增已存在的taskId");
				j.setSuccess(false);
				return j;
			}
			timeTaskService.save(timeTask);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 定时任务管理列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(TSTimeTaskEntity timeTask, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(timeTask.getId())) {
			timeTask = timeTaskService.getEntity(TSTimeTaskEntity.class, timeTask.getId());
			req.setAttribute("timeTaskPage", timeTask);
		}
		return new ModelAndView("system/timetask/timeTask");
	}
	
	/**
	 * 更新任务时间使之生效
	 */
	@RequestMapping(params = "updateTime")
	@ResponseBody
	public AjaxJson updateTime(TSTimeTaskEntity timeTask, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		timeTask = timeTaskService.get(TSTimeTaskEntity.class, timeTask.getId());
		try{
			if(!IpUtil.hasPassIpCheck(timeTask.getIpFilter())){
				j.setMsg("定时任务管理更新失败,服务器IP不是任务管理预定IP");
				return j;
			}
		}catch(SocketException e){
			j.setMsg("定时任务管理更新失败,服务器IP获取失败");
			return j;
		}
			
		boolean isUpdate = dynamicTask.updateCronExpression(timeTask.getTaskId() , timeTask.getCronExpression());
		if(isUpdate){
			timeTask.setIsEffect("1");
			timeTask.setIsStart("1");
			timeTaskService.updateEntitie(timeTask);
		}
		j.setMsg(isUpdate?"定时任务管理更新成功":"定时任务管理更新失败");
		return j;
	}
	
	/**
	 * 启动或者停止任务
	 */
	@RequestMapping(params = "startOrStopTask")
	@ResponseBody
	public AjaxJson startOrStopTask(TSTimeTaskEntity timeTask, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		boolean isStart = timeTask.getIsStart().equals("1");
		timeTask = timeTaskService.get(TSTimeTaskEntity.class, timeTask.getId());
	/*	 InetAddress addr = null;
		try {
			addr = InetAddress.getLocalHost();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// addr=oConvertUtils.getlIp();
		 String ip=addr.getHostAddress().toString();//获得本机IP
*/		String ip=""; 
		  try {			   
			ip=oConvertUtils.getRealIp();
		} catch (SocketException e) {
			logger.error("get server IP failed",e);
			j.setMsg("定时任务管理更新失败,服务器IP获取失败");
		}//获得本机IP
		
		//如果任务未生效，不应该直接运行
		if("0".equals(timeTask.getIsEffect())){
			j.setMsg("任务未生效,不能直接运行");
			return j;
		}
		
		try{
			if(IpUtil.hasPassIpCheck(timeTask.getIpFilter())){
				boolean isSuccess = dynamicTask.startOrStop(timeTask.getTaskId() ,isStart);
				if(isSuccess){
					timeTask.setIsStart(isStart?"1":"0");
					timeTaskService.updateEntitie(timeTask);
					systemService.addLog((isStart?"开启任务":"停止任务")+timeTask.getTaskId(),
							Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
				}
				j.setMsg(isSuccess?"定时任务管理更新成功":"定时任务管理更新失败");
				return j;
			}else{
				j.setMsg("定时任务管理更新失败,服务器IP不是任务管理预定IP");
				return j;			
			}
		}catch(SocketException e){
			logger.error("hasPassIpCheck SocketException",e);
			j.setMsg("定时任务管理更新失败");
			return j;
		}
	}
	
}
