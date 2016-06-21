package cn.com.fubon.mailsending.controller;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jodd.datetime.JDateTime;
import jodd.util.StringUtil;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.util.MyBeanUtils;
import org.jeecgframework.core.util.oConvertUtils;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.tag.vo.datatable.SortDirection;
import org.jeecgframework.web.system.pojo.base.Client;
import org.jeecgframework.web.system.pojo.base.TSUser;
import org.jeecgframework.web.system.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONArray;

import weixin.idea.huodong.entity.HuodongEntity;
import weixin.idea.huodong.service.HuodongService;
import cn.com.fubon.common.service.SendEmailService;
import cn.com.fubon.mailsending.entity.EmailOperateLogEntity;
import cn.com.fubon.mailsending.entity.EmailUserinfoEntity;
import cn.com.fubon.mailsending.entity.EmailUserinfoTempEntity;
import cn.com.fubon.mailsending.service.IEmailOperateService;
import cn.com.fubon.mailsending.service.IToTaiwanMailService;
import cn.com.fubon.util.Constants;
import cn.com.fubon.util.RegexUtils;

/**
 * 赴台学生邮件发送
 * 
 * @author yaoming.zhang
 * @date 2015-12-21
 */
@Scope("prototype")
@Controller
@RequestMapping("/mailsending/toTaiwanMailController")
public class ToTaiwanMailController {
	
	private static final Logger logger = Logger.getLogger(ToTaiwanMailController.class);
	
	private POIFSFileSystem fs;
    private HSSFWorkbook wb;
    private HSSFSheet sheet;
    private HSSFRow row;
    
	@Autowired
	private SystemService systemService;
	
	@Autowired
	private IEmailOperateService emailOperateService;
	
	@Autowired
	private HuodongService huodongService;
	
	@Resource
	private IToTaiwanMailService toTaiwanMailService;
	
	@Resource
	private SendEmailService sendEmailService;
	
	/**
	 * (赴台学生信息)主页
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "toTaiwanMailIndex")
	public ModelAndView toTaiwanMailIndex(HttpServletRequest request) {
		return new ModelAndView("mailsending/toTaiwanMail/toTaiwanMailIndex");
	}
	
	/**
	 * (赴台学生信息)加载赴台学生信息列表
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "datagrid")
	public void datagrid(HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		
		//姓名
		String name = request.getParameter("name");
		//身份证号
		String identifynumber = request.getParameter("identifynumber");
		//赠险单号
		String insuranceno = request.getParameter("insuranceno");
		//操作人
		String importOperator = request.getParameter("importOperator");
		
		EmailUserinfoEntity userinfo = new EmailUserinfoEntity();
		CriteriaQuery cq = new CriteriaQuery(EmailUserinfoEntity.class, dataGrid);
		cq.addOrder("importTime", SortDirection.desc);
		if (!StringUtil.isEmpty(name)) {
			cq.like("name", "%" + name + "%");
		}
		if (!StringUtil.isEmpty(identifynumber)) {
			cq.like("identifynumber", "%" + identifynumber + "%");
		}
		if (!StringUtil.isEmpty(insuranceno)) {
			cq.like("insuranceno", "%" + insuranceno + "%");
		}
		if (!StringUtil.isEmpty(importOperator)) {
			cq.like("importOperator", "%" + importOperator + "%");
		}
		cq.eq("huodongid", "8a828ebb49166847014916deca573456");	//活动id:8a828ebb49166847014916deca573456->2015赴台学生赠险活动
		
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, userinfo);
		cq.add();
		
		toTaiwanMailService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
	
	/**
	 * (赴台学生信息)跳转到学生信息查看页面
	 * 
	 * @param user
	 * @param req
	 * @return
	 */
	@RequestMapping(params = "jumpView")
	public ModelAndView jumpView(EmailUserinfoEntity user, HttpServletRequest req) {

		if (StringUtil.isNotEmpty(user.getId())) {
			user = this.systemService.getEntity(EmailUserinfoEntity.class,user.getId());
			
			req.setAttribute("id", user.getId());
			req.setAttribute("name", user.getName());
			req.setAttribute("identifynumber", user.getIdentifynumber());
			req.setAttribute("sex", user.getSex());
			req.setAttribute("email", user.getEmail());
			req.setAttribute("sendstatus", user.getSendstatus());
		}
		
		return new ModelAndView("mailsending/toTaiwanMail/toTaiwanMailStudentInfo");
	}
	
	/**
	 * (赴台学生信息)新增、更新学生信息
	 * 
	 * @param user
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(params = "saveorupdate")
	@ResponseBody
	public AjaxJson saveorupdate(EmailUserinfoEntity user,
			HttpServletRequest request, HttpServletResponse response) {
		AjaxJson j = new AjaxJson();
		String id = oConvertUtils.getString(request.getParameter("id"));

		if (StringUtil.isNotEmpty(id)) {
			EmailUserinfoEntity tempUser = this.systemService.getEntity(
					EmailUserinfoEntity.class, user.getId());
			try {
				MyBeanUtils.copyBeanNotNull2Bean(user, tempUser);
				toTaiwanMailService.saveOrUpdate(tempUser);
				
				//记录日志
				HttpSession session = request.getSession();
				Client client = (Client) session.getAttribute(Constants.SESSION_KEY_BO_USER);
				if (client != null) {
					TSUser systemUser = client.getUser();
					emailOperateService.addLog(UUID.randomUUID().toString(), systemUser.getUserName(), "更新", tempUser.getHuodongid(), tempUser.getImportBatchId(), "更新["+tempUser.getName()+"、"+tempUser.getIdentifynumber()+"]赴台学生信息");
				}else{
					logger.info("from httpsession get client failure on login, client is null.");
					response.sendRedirect("login/login");
				}
			} catch (Exception e) {
				j.setMsg("操作失败");
				String message = "更新" + tempUser.getName() + "的信息失败！";
				logger.error(message);
			}
		} else {
			try {
				user.setId(UUID.randomUUID().toString());
				
				toTaiwanMailService.save(user);
				
				//记录日志
				HttpSession session = request.getSession();
				Client client = (Client) session.getAttribute(Constants.SESSION_KEY_BO_USER);
				if (client != null) {
					TSUser systemUser = client.getUser();
					emailOperateService.addLog(UUID.randomUUID().toString(), systemUser.getUserName(), "新增", user.getHuodongid(), user.getImportBatchId(), "新增["+user.getName()+"、"+user.getIdentifynumber()+"]赴台学生信息");
				}else{
					logger.info("from httpsession get client failure on login, client is null.");
					response.sendRedirect("login/login");
				}
			} catch (Exception e) {
				j.setMsg("操作失败");
				String message = "新增赴台学生信息失败！";
				logger.error(message);
			}
		}
		return j;
	}
	
	/**
	 * (赴台学生信息)删除学生信息
	 * 
	 * @param user
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(EmailUserinfoEntity user,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		AjaxJson j = new AjaxJson();
		user = systemService.getEntity(EmailUserinfoEntity.class, user.getId());
		String message = "学生信息删除成功";
		toTaiwanMailService.delete(user);
		
		//记录日志
		HttpSession session = request.getSession();
		Client client = (Client) session
				.getAttribute(Constants.SESSION_KEY_BO_USER);
		if (client != null) {
			TSUser systemUser = client.getUser();
			emailOperateService.addLog(UUID.randomUUID().toString(), systemUser.getUserName(), "删除", user.getHuodongid(), user.getImportBatchId(), "删除["+user.getName()+"、"+user.getIdentifynumber()+"]赴台学生信息");
		}else{
			logger.info("from httpsession get client failure on login, client is null.");
			response.sendRedirect("login/login");
		}

		j.setMsg(message);
		return j;
	}
	
	/**
	 * (赴台学生信息)打开"导入excel"界面
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest request) {
		List<HuodongEntity> huodongList = this.systemService.getList(HuodongEntity.class);
		
		request.setAttribute("huodongList", huodongList);
		return new ModelAndView("mailsending/toTaiwanMail/toTaiwanMaiStudentUpload");
	}

	/**
	 * (赴台学生信息)解析excel入库
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(params = "importExcel", method = RequestMethod.POST)
	@ResponseBody
	public AjaxJson importExcel(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.info("进入importExcel()方法");
		AjaxJson j = new AjaxJson();
		
		HttpSession session = request.getSession();
		Client client = (Client) session
				.getAttribute(Constants.SESSION_KEY_BO_USER);
		if (client != null) {
			TSUser systemUser = client.getUser();
			logger.info("systemUser操作人："+systemUser.getUserName());
			
			MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
			Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();
			for (Map.Entry<String, MultipartFile> entity : fileMap.entrySet()) {
				MultipartFile file = entity.getValue();// 获取上传文件对象
				logger.info("进入解析上传excel：");
				
				try {
					Map<Integer, EmailUserinfoTempEntity> map = this.readExcelContent(file.getInputStream());
		            
		            String importBatchId = new JDateTime(new Date()).toString("YYYYMMDDhhmmss");
		            String huodongid = request.getParameter("huodongid");
		    		
		            //1、先保存到临时表
		            for (int i = 1; i <= map.size(); i++) {
		            	String importResult = "";
		            	
		            	EmailUserinfoTempEntity temp = map.get(i);
		            	String tempId =UUID.randomUUID().toString();
		            	temp.setId(tempId);
		            	logger.info("活动id："+huodongid);
		            	logger.info("操作人："+systemUser.getUserName());
		            	logger.info("批次号id："+importBatchId);
		            	logger.info(temp.getId()+","+temp.getName()+","+temp.getIdentifynumber()+","+temp.getSex()+","+temp.getEmail());
		                
		                if("".equalsIgnoreCase(temp.getName())){
		                	importResult += "姓名不能为空; ";
		                }
		                if("".equalsIgnoreCase(temp.getIdentifynumber())){
		                	importResult += "身份证号不能为空; ";
		                }
		                if(!"1".equalsIgnoreCase(temp.getSex()) && !"2".equalsIgnoreCase(temp.getSex()) ){//男_1,女_2
		                	importResult += "性别输入不对; ";
		                }
		                if("".equalsIgnoreCase(temp.getEmail())){
		                	importResult += "邮箱不能为空; ";
		                }else{
		                	Boolean isValid = RegexUtils.isEmail(temp.getEmail());
		                	if(!isValid){
		                		importResult += "邮箱格式不正确; ";
		                	}
		                }
		                //导入批次号
		                temp.setImportBatchId(importBatchId);
		                //操作时间
		                temp.setImportTime(new Date());
		                //操作人
		                temp.setImportOperator(systemUser.getUserName());
		                //导入结果
		                if(StringUtil.isEmpty(importResult)){
		                	temp.setImportResult("SUCCESS");
		                }else{
		                	temp.setImportResult(importResult);
		                }
		                //活动id
		                temp.setHuodongid(huodongid);
						toTaiwanMailService.saveEmailUserinfoTemp(temp);
					}
		            
		            //2、校验临时表，更新未发送的原始数据信息
		            List<Map<String, Object>> updatelist = toTaiwanMailService.getNeedUpdateEmailUserinfo(importBatchId);
		            logger.info("旧数据:"+updatelist.size());
		            for(Map<String, Object> tempMap : updatelist){
		            	try {
		            		//更新旧数据的性别、邮箱
							toTaiwanMailService.updateNotSendedEmailUserinfo((String) tempMap.get("name"), (String) tempMap.get("identifynumber"), (String) tempMap.get("sex"), (String) tempMap.get("email"));
						
							//记录日志
							emailOperateService.addLog(UUID.randomUUID().toString(), systemUser.getUserName(), "上传更新", (String) tempMap.get("huodongid"), (String) tempMap.get("importBatchId"), "上传更新["+(String) tempMap.get("name")+"、"+(String) tempMap.get("identifynumber")+"]赴台学生信息");
		            	} catch (Exception e) {
							logger.error("更新旧信息出错");
						}
		            }
		            
		            //3、校验临时表，抽取新数据保存到最终表
		            List<Map<String, Object>> list = toTaiwanMailService.getNewEmailUserinfo(importBatchId);
		            logger.info("新数据:"+list.size());
		            for(Map<String, Object> tempMap : list){
		            	try {
			            	EmailUserinfoEntity emailUser = new EmailUserinfoEntity();
			            	emailUser.setId((String) tempMap.get("id"));
			            	emailUser.setName((String) tempMap.get("name"));
			            	emailUser.setIdentifynumber((String) tempMap.get("identifynumber"));
			            	emailUser.setSex((String) tempMap.get("sex"));
			            	emailUser.setEmail((String) tempMap.get("email"));
			            	emailUser.setImportBatchId((String) tempMap.get("importBatchId"));
			            	emailUser.setImportOperator((String) tempMap.get("importOperator"));
			            	emailUser.setImportTime((Date)tempMap.get("importTime"));
			            	emailUser.setHuodongid((String) tempMap.get("huodongid"));
			            	
							toTaiwanMailService.saveEmailUserinfo(emailUser);
							
							//记录日志
							emailOperateService.addLog(UUID.randomUUID().toString(), systemUser.getUserName(), "上传新增", (String) tempMap.get("huodongid"), (String) tempMap.get("importBatchId"), "上传新增["+(String) tempMap.get("name")+"、"+(String) tempMap.get("identifynumber")+"]赴台学生信息");
		            	} catch (Exception e) {
							logger.error("保存赴台学生信息入库出错");
						}
		            }
		            
					j.setMsg("文件导入成功！");
				} catch (Exception e) {
					logger.error(e);
					j.setMsg("文件导入失败！");
				}finally{
					try {
						file.getInputStream().close();
					} catch (IOException e) {
						logger.error(e);
						logger.error("上传excel文件输入流关闭报错");
					}
				}
			}
		}else{
			logger.info("from httpsession get client failure on login, client is null.");
			response.sendRedirect("login/login");
		}

		return j;
	}
	
//	@RequestMapping(params = "test")
//	public String test(){
//		
//		Map<String, String> tempMap=new HashMap<String, String>();
//		String tempid="24339433000009728";
//		tempMap.put("keyword0", "1234567890");//卡号
//		tempMap.put("keyword1", "782342");//密码
//		Date now=new Date();
//		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//		tempMap.put("keyword2", format.format(now));//日期，2015-12-24
//		try {
//			sendEmailService.sendEmail(tempMap,"271633500@qq.com",tempid);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return "1";
//	}
	
	/**
	 * (赴台学生信息)发送单个邮件
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(params = "sendSingeleEmail", method = RequestMethod.POST)
	@ResponseBody
	public AjaxJson sendSingeleEmail(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.info("发送单个邮件");
		AjaxJson j = new AjaxJson();
		
		String selectArray = request.getParameter("selectArray");
		List<EmailUserinfoEntity> userList = JSONArray.parseArray(selectArray, EmailUserinfoEntity.class);
		if(userList == null){
			j.setMsg("请选择一条记录再发送");
			return j;
		}
		
		EmailUserinfoEntity user = userList.get(0);
		String sendstatus = user.getSendstatus();
		String id = user.getId();
		String name = user.getName();
		String identifynumber = user.getIdentifynumber();
		String email = user.getEmail();
		String huodongid = user.getHuodongid();
		String importBatchId = user.getImportBatchId();
		
		j = executeSendEmail(request, response, sendstatus, id, name, identifynumber, email, huodongid, importBatchId);
		
		return j;
	}
	
	/**
	 * (赴台学生信息)批量发送邮件
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(params = "sendBatchEmail", method = RequestMethod.POST)
	@ResponseBody
	public AjaxJson sendBatchEmail(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.info("批量发送邮件");
		AjaxJson j = new AjaxJson();
		
		String selectArray = request.getParameter("selectArray");
		List<EmailUserinfoEntity> userList = JSONArray.parseArray(selectArray, EmailUserinfoEntity.class);
		if(userList == null){
			j.setMsg("请选择一条或多条记录再发送");
			return j;
		}
		
		int successCount = 0;
		int falseCount = 0;
		for (EmailUserinfoEntity user : userList) {
			String sendstatus = user.getSendstatus();
			String id = user.getId();
			String name = user.getName();
			String identifynumber = user.getIdentifynumber();
			String email = user.getEmail();
			String huodongid = user.getHuodongid();
			String importBatchId = user.getImportBatchId();
			
			j = executeSendEmail(request, response, sendstatus, id, name, identifynumber, email, huodongid, importBatchId);
			if(j.isSuccess()){
				successCount++;
			}else{
				falseCount++;
			}
		}
		
		j.setSuccess(true);
		j.setMsg("成功发送邮件"+successCount+"个，失败"+falseCount+"个，具体详情请看\"操作日志\"");
		return j;
	}
	
	public AjaxJson executeSendEmail(HttpServletRequest request,
			HttpServletResponse response, String sendstatus, String id,
			String name, String identifynumber, String email, String huodongid,
			String importBatchId) throws Exception {
		AjaxJson j = new AjaxJson();
		
		HttpSession session = request.getSession();
		Client client = (Client) session
				.getAttribute(Constants.SESSION_KEY_BO_USER);
		if (client == null) {
			logger.info("from httpsession get client failure on login, client is null.");
			response.sendRedirect("login/login");
		}
		TSUser systemUser = client.getUser();
		
		if("1".equalsIgnoreCase(sendstatus)){
			String message = "邮件已发送过，无需再发送！";
			j.setSuccess(false);
			j.setMsg(message);
			//记录日志
			emailOperateService.addLog(UUID.randomUUID().toString(), systemUser.getUserName(), "发送邮件失败", huodongid, importBatchId, message+"发送邮件给["+name+"、"+identifynumber+"、"+email+"]失败");
			
			return j;
		}
	
		// 从weixin_huodong_card表获取卡号、密码
		Map<String, Object> card = toTaiwanMailService.getCardInfo(huodongid);
		String cardid = ((Integer)card.get("id")).toString();
		String cardno = (String)card.get("cardno");
		String password = (String)card.get("password");
		
		Map<String, String> tempMap=new HashMap<String, String>();
		String tempid="24339433000009728";
		tempMap.put("keyword0", cardno);//卡号
		tempMap.put("keyword1", password);//密码
		Date now=new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		tempMap.put("keyword2", format.format(now));
		
		try {
			logger.info("cardid："+cardid);
			logger.info("卡号："+cardno);
			logger.info("密码："+password);
			boolean sendSuccess = sendEmailService.sendEmail(tempMap, email, tempid);
			logger.info("发送邮件成功与否：" + sendSuccess);
			
			String operatelogId = UUID.randomUUID().toString();
			if(sendSuccess){
				j.setMsg("邮件发送成功！");
				//1、变更状态
				toTaiwanMailService.updateSendEmailStatus(id, new JDateTime(new Date()).toString("YYYY-MM-DD hh:mm:ss"), "1", tempMap.get("keyword0"), operatelogId);

				//2、记录已发放卡号、密码记录到weixin_huodong_record;
				toTaiwanMailService.addRecord(cardid, huodongid);
				
				//3、记录日志
				emailOperateService.addLog(operatelogId, systemUser.getUserName(), "发送邮件成功", huodongid, importBatchId, "发送邮件给["+name+"、"+identifynumber+"、"+email+"]成功");
			}else{
				j.setMsg("邮件发送失败！");
				emailOperateService.addLog(operatelogId, systemUser.getUserName(), "发送邮件失败", huodongid, importBatchId, "发送邮件给["+name+"、"+identifynumber+"、"+email+"]失败");
			}
		} catch (Exception e) {
			j.setMsg("邮件发送失败！");
			logger.error("executeSendEmail",e);
		}
		
		return j;
	}
    
	/**
	 * (查看导入日志)主页
	 * 
	 * @param request
	 * @return
	 */
    @RequestMapping(params = "toImportExcelLogIndex")
	public ModelAndView toImportExcelLogIndex(HttpServletRequest request) {
		return new ModelAndView("mailsending/toTaiwanMail/importExcelLogIndex");
	}
    
    /**
	 * (查看导入日志)加载"导入日志"列表
	 * 
	 * @param request
	 * @return
	 */
    @RequestMapping(params = "importExcelLogDatagrid")
	public void importExcelLogDatagrid(HttpServletRequest request,
			HttpServletResponse response, DataGrid dataGrid) throws Exception {
		
    	//姓名
		String name = request.getParameter("name");
		//身份证号
		String identifynumber = request.getParameter("identifynumber");
		//导入批次号
		String importBatchId = request.getParameter("importBatchId");
		//操作人
		String importOperator = request.getParameter("importOperator");
		//导入结果
		String importResult = request.getParameter("importResult");
		
		//使用日期
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String importTime_begin = request.getParameter("operateTime_begin");
		String importTime_end = request.getParameter("operateTime_end");
		Date importTime_begindate = new Date();
		Date importTime_enddate = new Date();
		if (!StringUtil.isEmpty(importTime_begin)) {
			importTime_begin = importTime_begin + " 00:00:00";
			importTime_begindate = sdf.parse(importTime_begin);
		}
		if (!StringUtil.isEmpty(importTime_end)) {
			importTime_end = importTime_end + " 00:00:00";
			importTime_enddate = sdf.parse(importTime_end);
		}
				
		EmailUserinfoTempEntity log = new EmailUserinfoTempEntity();
		CriteriaQuery cq = new CriteriaQuery(EmailUserinfoTempEntity.class, dataGrid);
		cq.addOrder("importTime", SortDirection.desc);
		if (!StringUtil.isEmpty(name)) {
			cq.like("name", "%" + name + "%");
		}
		if (!StringUtil.isEmpty(identifynumber)) {
			cq.like("identifynumber", "%" + identifynumber + "%");
		}
		if (!StringUtil.isEmpty(importBatchId)) {
			cq.like("importBatchId", "%" + importBatchId + "%");
		}
		if (!StringUtil.isEmpty(importOperator)) {
			cq.like("importOperator", "%" + importOperator + "%");
		}
		if (!StringUtil.isEmpty(importResult)) {
			cq.like("importResult", "%" + importResult + "%");
		}
		if (!StringUtil.isEmpty(importTime_begin)) {
			cq.ge("importTime", importTime_begindate);
		}
		if (!StringUtil.isEmpty(importTime_end)) {
			cq.le("importTime", importTime_enddate);
		}
		
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, log);
		cq.add();
		
		toTaiwanMailService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
    
    /**
	 * (操作日志)主页
	 * 
	 * @param request
	 * @return
	 */
    @RequestMapping(params = "toEmailOperateLogIndex")
	public ModelAndView toEmailOperateLogIndex(HttpServletRequest request) {
		return new ModelAndView("mailsending/toTaiwanMail/emailOperateLogIndex");
	}
    
    /**
	 * (操作日志)加载赴台学生信息列表
	 * 
	 * @param request
	 * @return
	 */
    @RequestMapping(params = "emailOperateLogDatagrid")
	public void emailOperateLogDatagrid(HttpServletRequest request,
			HttpServletResponse response, DataGrid dataGrid) throws Exception {
		
    	//操作日志id
    	String operatelogId = request.getParameter("operatelogId");
    	
		//操作人
		String operater = request.getParameter("operater");
		
		//使用日期
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String operateTime_begin = request.getParameter("operateTime_begin");
		String operateTime_end = request.getParameter("operateTime_end");
		Date operateTime_begindate = new Date();
		Date operateTime_enddate = new Date();
		if (!StringUtil.isEmpty(operateTime_begin)) {
			operateTime_begin = operateTime_begin + " 00:00:00";
			operateTime_begindate = sdf.parse(operateTime_begin);
		}
		if (!StringUtil.isEmpty(operateTime_end)) {
			operateTime_end = operateTime_end + " 00:00:00";
			operateTime_enddate = sdf.parse(operateTime_end);
		}
				
		EmailOperateLogEntity log = new EmailOperateLogEntity();
		CriteriaQuery cq = new CriteriaQuery(EmailOperateLogEntity.class, dataGrid);
		cq.addOrder("operateTime", SortDirection.desc);
		if (!StringUtil.isEmpty(operatelogId)) {
			cq.like("operatelogId", "%" + operatelogId + "%");
		}
		if (!StringUtil.isEmpty(operater)) {
			cq.like("operater", "%" + operater + "%");
		}
		if (!StringUtil.isEmpty(operateTime_begin)) {
			cq.ge("operateTime", operateTime_begindate);
		}
		if (!StringUtil.isEmpty(operateTime_end)) {
			cq.le("operateTime", operateTime_enddate);
		}
		
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, log);
		cq.add();
		
		toTaiwanMailService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
	
    /**
     * 读取Excel数据内容
     * @param InputStream
     * @return Map 包含单元格数据内容的Map对象
     */
    public Map<Integer, EmailUserinfoTempEntity> readExcelContent(InputStream is) {
        Map<Integer, EmailUserinfoTempEntity> content = new HashMap<Integer, EmailUserinfoTempEntity>();
        try {
            fs = new POIFSFileSystem(is);
            wb = new HSSFWorkbook(fs);
        } catch (IOException e) {
            logger.error("读取赴台学生Excel出错");
        }
        sheet = wb.getSheetAt(0);
        // 得到总行数
        int rowNum = sheet.getLastRowNum();
        row = sheet.getRow(0);
        int colNum = row.getPhysicalNumberOfCells();
        // 正文内容应该从第二行开始,第一行为表头
        for (int i = 1; i <= rowNum; i++) {
            row = sheet.getRow(i);
            int j = 0;
            EmailUserinfoTempEntity user = new EmailUserinfoTempEntity();
            while (j < colNum) {
                if(j==0){
                	user.setName(getCellFormatValue(row.getCell((short) j)).trim());
                }else if(j==1){
                	user.setIdentifynumber(getCellFormatValue(row.getCell((short) j)).trim());
                }else if(j==2){
                	if("男".equalsIgnoreCase(getCellFormatValue(row.getCell((short) j)).trim())){
                		user.setSex("1");
                	}else if("女".equalsIgnoreCase(getCellFormatValue(row.getCell((short) j)).trim())){
                		user.setSex("2");
                	}else if("".equalsIgnoreCase(getCellFormatValue(row.getCell((short) j)).trim())){
                		user.setSex("0");
                	}
                }else if(j==3){
                	user.setEmail(getCellFormatValue(row.getCell((short) j)).trim());
                }
                j++;
            }
            content.put(i, user);
            user = null;
        }
        return content;
    }
    
    /**
     * 根据HSSFCell类型设置数据
     * @param cell
     * @return
     */
    private String getCellFormatValue(HSSFCell cell) {
        String cellvalue = "";
        if (cell != null) {
            // 判断当前Cell的Type
            switch (cell.getCellType()) {
            // 如果当前Cell的Type为NUMERIC
            case HSSFCell.CELL_TYPE_NUMERIC:
            case HSSFCell.CELL_TYPE_FORMULA: {
                // 判断当前的cell是否为Date
                if (HSSFDateUtil.isCellDateFormatted(cell)) {
                    // 如果是Date类型则，转化为Data格式
                    
                    //方法1：这样子的data格式是带时分秒的：2011-10-12 0:00:00
                    //cellvalue = cell.getDateCellValue().toLocaleString();
                    
                    //方法2：这样子的data格式是不带带时分秒的：2011-10-12
                    Date date = cell.getDateCellValue();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    cellvalue = sdf.format(date);
                }
                // 如果是纯数字
                else {
                    // 取得当前Cell的数值
                    cellvalue = String.valueOf(cell.getNumericCellValue());
                }
                break;
            }
            // 如果当前Cell的Type为STRIN
            case HSSFCell.CELL_TYPE_STRING:
                // 取得当前的Cell字符串
                cellvalue = cell.getRichStringCellValue().getString();
                break;
            // 默认的Cell值
            default:
                cellvalue = " ";
            }
        } else {
            cellvalue = "";
        }
        
        return cellvalue;
    }
}
