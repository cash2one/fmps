package org.jeecgframework.web.system.controller.core;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.extend.datasource.DataSourceContextHolder;
import org.jeecgframework.core.extend.datasource.DataSourceType;
import org.jeecgframework.core.util.ContextHolderUtils;
import org.jeecgframework.core.util.IpUtil;
import org.jeecgframework.core.util.ListtoMenu;
import org.jeecgframework.core.util.NumberComparator;
import org.jeecgframework.core.util.ResourceUtil;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.core.util.oConvertUtils;
import org.jeecgframework.web.system.pojo.base.Client;
import org.jeecgframework.web.system.pojo.base.TSConfig;
import org.jeecgframework.web.system.pojo.base.TSFunction;
import org.jeecgframework.web.system.pojo.base.TSRole;
import org.jeecgframework.web.system.pojo.base.TSRoleFunction;
import org.jeecgframework.web.system.pojo.base.TSRoleUser;
import org.jeecgframework.web.system.pojo.base.TSUser;
import org.jeecgframework.web.system.service.SystemService;
import org.jeecgframework.web.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import weixin.guanjia.account.entity.WeixinAccountEntity;
import weixin.guanjia.account.service.WeixinAccountServiceI;
import weixin.util.WeiXinConstants;
import cn.com.fubon.util.Constants;

/**
 * 登陆初始化控制器
 * 
 * @author 张代浩
 * 
 */
@Scope("request")
@Controller
@RequestMapping("/loginController")
public class LoginController extends BaseController {
	private Logger log = Logger.getLogger(LoginController.class);
	private SystemService systemService;
	@Autowired
	private WeixinAccountServiceI weixinAccountService;
	private UserService userService;
	private String message = null;

	@Autowired
	public void setSystemService(SystemService systemService) {
		this.systemService = systemService;
	}

	@Autowired
	public void setUserService(UserService userService) {

		this.userService = userService;
	}

	@RequestMapping(params = "goPwdInit")
	public String goPwdInit() {
		return "login/pwd_init";
	}

	/**
	 * admin账户密码初始化
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "pwdInit")
	public ModelAndView pwdInit(HttpServletRequest request) {
		ModelAndView modelAndView = null;
		/*
		 * TSUser user = new TSUser(); user.setUserName("admin"); String newPwd
		 * = "123456"; userService.pwdInit(user, newPwd);
		 */
		modelAndView = new ModelAndView(new RedirectView(
				"loginController.do?login"));
		return modelAndView;
	}

	/**
	 * 检查用户名称
	 * 
	 * @param user
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "checkuser")
	@ResponseBody
	public AjaxJson checkuser(TSUser user, HttpServletRequest request) {
		HttpSession session = request.getSession();
		DataSourceContextHolder
				.setDataSourceType(DataSourceType.dataSource_jeecg);
		AjaxJson j = new AjaxJson();
		String randCode = request.getParameter("randCode");
		String randCodeInSession = (String) session
				.getAttribute(Constants.SESSION_KEY_RAND_CODE);
		log.info("from browser, randCode====>" + randCode);
		log.info("from session, randCode====>" + randCodeInSession
				+ ", SessionID:" + session.getId());

		if (StringUtils.isEmpty(randCode)) {
			j.setMsg("请输入验证码");
			j.setSuccess(false);
		} else if (!randCode.equalsIgnoreCase(randCodeInSession)) {
			// todo "randCode"和验证码servlet中该变量一样，通过统一的系统常量配置比较好，暂时不知道系统常量放在什么地方合适
			log.info("The randcode from browser not equal in httpsession.");
			j.setMsg("验证码错误！");
			j.setSuccess(false);
		} else {
			int users = userService.getList(TSUser.class).size();

			if (users == 0) {
				j.setMsg("a");
				j.setSuccess(false);
			} else {
				// System.out.println("....name..."+user.getUserName()+"...password..."+user.getPassword());
				TSUser u = userService.checkUserExits(user);
				if (u == null) {
					j.setMsg("用户名或密码错误!");
					j.setSuccess(false);
					return j;
				} else {
					Client client = new Client();
					client.setIp(IpUtil.getIpAddr(request));
					client.setLogindatetime(new Date());
					client.setUser(u);
					session.setAttribute(Constants.SESSION_KEY_BO_USER, client);
					log.info("check user success, set user info to http session, session id ===> "
							+ session.getId());
				}
				TSUser u2 = userService.getEntity(TSUser.class, u.getId());

				if (u != null && u2.getStatus() != 0) {
					// if (user.getUserKey().equals(u.getUserKey())) {
					message = "用户: " + user.getUserName() + "["
							+ u.getTSDepart().getDepartname() + "]" + "登录成功";

					// 添加登陆日志
					systemService.addLog(message, Globals.Log_Type_LOGIN,
							Globals.Log_Leavel_INFO);

				} else {
					j.setMsg("用户名或密码错误!");
					j.setSuccess(false);
				}
			}
		}
		return j;
	}

	/**
	 * 用户登录
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "login")
	public String login(ModelMap modelMap, HttpServletRequest request) {
		log.info("checkuser success, do login");
		HttpSession session = request.getSession();
		Client client = (Client) session
				.getAttribute(Constants.SESSION_KEY_BO_USER);
		String roles = "";
		if (client != null) {
			TSUser user = client.getUser();
			WeixinAccountEntity weixinAccountEntity = weixinAccountService
					.findLoginWeixinAccount();
			request.getSession().setAttribute(WeiXinConstants.WEIXIN_ACCOUNT,
					weixinAccountEntity);
			List<TSRoleUser> rUsers = systemService.findByProperty(
					TSRoleUser.class, "TSUser.id", user.getId());
			for (TSRoleUser ru : rUsers) {
				TSRole role = ru.getTSRole();
				roles += role.getRoleName() + ",";
			}
			if (roles.length() > 0) {
				roles = roles.substring(0, roles.length() - 1);
			}
			modelMap.put("roleName", roles);
			modelMap.put("userName", user.getUserName());
			request.getSession().setAttribute("CKFinder_UserRole", "admin");
			// 默认风格
			String indexStyle = "bootstrap";
			Cookie[] cookies = request.getCookies();
			for (Cookie cookie : cookies) {
				if (cookie == null || StringUtils.isEmpty(cookie.getName())) {
					continue;
				}
				if (cookie.getName().equalsIgnoreCase("JEECGINDEXSTYLE")) {
					indexStyle = cookie.getValue();
				}
			}
			// 要添加自己的风格，复制下面三行即可
			if (StringUtils.isNotEmpty(indexStyle)
					&& indexStyle.equalsIgnoreCase("bootstrap")) {
				return "main/shortcut_main";
			}
			if (StringUtils.isNotEmpty(indexStyle)
					&& indexStyle.equalsIgnoreCase("shortcut")) {
				return "main/bootstrap_main";
			}
			if (StringUtils.isNotEmpty(indexStyle)
					&& indexStyle.equalsIgnoreCase("sliding")) {
				return "main/sliding_main";
			}
			return "main/main";
		} else {
			log.info("from httpsession get client failure on login, client is null.");
			return "login/login";
		}

	}

	/**
	 * 退出系统
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(params = "logout")
	public ModelAndView logout(HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		TSUser user = ResourceUtil.getSessionUserName(session);
		systemService.addLog("用户" + user.getUserName() + "已退出",
				Globals.Log_Type_EXIT, Globals.Log_Leavel_INFO);
		session.removeAttribute(Constants.SESSION_KEY_BO_USER);
		ModelAndView modelAndView = new ModelAndView(new RedirectView(
				"loginController.do?login"));
		return modelAndView;
	}

	/**
	 * 菜单跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "left")
	public ModelAndView left(HttpServletRequest request) {
		HttpSession session = request.getSession();
		TSUser user = ResourceUtil.getSessionUserName(session);
		ModelAndView modelAndView = new ModelAndView();
		// 登陆者的权限
		if (user.getId() == null) {
			session.removeAttribute(Globals.USER_SESSION);
			modelAndView.setView(new RedirectView("loginController.do?login"));
		} else {
			List<TSConfig> configs = userService.loadAll(TSConfig.class);
			for (TSConfig tsConfig : configs) {
				request.setAttribute(tsConfig.getCode(), tsConfig.getContents());
			}
			modelAndView.setViewName("main/left");
			request.setAttribute("menuMap", getFunctionMap(user));
		}
		return modelAndView;
	}

	/**
	 * 获取权限的map
	 * 
	 * @param user
	 * @return
	 */
	private Map<Integer, List<TSFunction>> getFunctionMap(TSUser user) {
		Map<Integer, List<TSFunction>> functionMap = new HashMap<Integer, List<TSFunction>>();
		Map<String, TSFunction> loginActionlist = getUserFunction(user);
		if (loginActionlist.size() > 0) {
			Collection<TSFunction> allFunctions = loginActionlist.values();
			for (TSFunction function : allFunctions) {
				if (!functionMap.containsKey(function.getFunctionLevel() + 0)) {
					functionMap.put(function.getFunctionLevel() + 0,
							new ArrayList<TSFunction>());
				}
				functionMap.get(function.getFunctionLevel() + 0).add(function);
			}
			// 菜单栏排序
			Collection<List<TSFunction>> c = functionMap.values();
			for (List<TSFunction> list : c) {
				Collections.sort(list, new NumberComparator());
			}
		}
		return functionMap;
	}

	/**
	 * 获取用户菜单列表
	 * 
	 * @param user
	 * @return
	 */
	private Map<String, TSFunction> getUserFunction(TSUser user) {
		HttpSession session = ContextHolderUtils.getSession();
		Client client = (Client) session
				.getAttribute(Constants.SESSION_KEY_BO_USER);
		if (client.getFunctions() == null || client.getFunctions().size() == 0) {
			Map<String, TSFunction> loginActionlist = new HashMap<String, TSFunction>();
			List<TSRoleUser> rUsers = systemService.findByProperty(
					TSRoleUser.class, "TSUser.id", user.getId());
			for (TSRoleUser ru : rUsers) {
				TSRole role = ru.getTSRole();
				List<TSRoleFunction> roleFunctionList = systemService
						.findByProperty(TSRoleFunction.class, "TSRole.id",
								role.getId());
				for (TSRoleFunction roleFunction : roleFunctionList) {
					TSFunction function = roleFunction.getTSFunction();
					loginActionlist.put(function.getId(), function);
				}
			}
			client.setFunctions(loginActionlist);
		}
		return client.getFunctions();
	}

	/**
	 * 首页跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "home")
	public ModelAndView home(HttpServletRequest request) {
		// 获取用户名字
		HttpSession session = request.getSession();
		TSUser user = ResourceUtil.getSessionUserName(session);
		String userName = user.getUserName();

		// 获取用户角色code
		String roleCode = userService.getUserRole(user);
		String chkRoleCode = "";
		List<String> roleCodeList = StringUtil
				.parseString2ListByCustomerPattern(",", roleCode);
		if (roleCodeList.size() > 0) {
			chkRoleCode = roleCodeList.get(0);
		}

		request.setAttribute("rolecode", chkRoleCode);
		request.setAttribute("username", userName);
		return new ModelAndView("main/home");
	}

	/**
	 * 无权限页面提示跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "noAuth")
	public ModelAndView noAuth(HttpServletRequest request) {
		return new ModelAndView("common/noAuth");
	}

	/**
	 * @Title: top
	 * @Description: bootstrap头部菜单请求
	 * @param request
	 * @return ModelAndView
	 * @throws
	 */
	@RequestMapping(params = "top")
	public ModelAndView top(HttpServletRequest request) {
		HttpSession session = request.getSession();
		TSUser user = ResourceUtil.getSessionUserName(session);

		// 登陆者的权限
		if (user.getId() == null) {
			session.removeAttribute(Globals.USER_SESSION);
			return new ModelAndView(
					new RedirectView("loginController.do?login"));
		}
		request.setAttribute("menuMap", getFunctionMap(user));
		List<TSConfig> configs = userService.loadAll(TSConfig.class);
		for (TSConfig tsConfig : configs) {
			request.setAttribute(tsConfig.getCode(), tsConfig.getContents());
		}
		return new ModelAndView("main/bootstrap_top");
	}

	/**
	 * @Title: top
	 * @author gaofeng
	 * @Description: shortcut头部菜单请求
	 * @param request
	 * @return ModelAndView
	 * @throws
	 */
	@RequestMapping(params = "shortcut_top")
	public ModelAndView shortcut_top(HttpServletRequest request) {
		HttpSession session = request.getSession();
		TSUser user = ResourceUtil.getSessionUserName(session);

		// 登陆者的权限
		if (user.getId() == null) {
			session.removeAttribute(Globals.USER_SESSION);
			return new ModelAndView(
					new RedirectView("loginController.do?login"));
		}
		request.setAttribute("menuMap", getFunctionMap(user));
		List<TSConfig> configs = userService.loadAll(TSConfig.class);
		for (TSConfig tsConfig : configs) {
			request.setAttribute(tsConfig.getCode(), tsConfig.getContents());
		}
		return new ModelAndView("main/shortcut_top");
	}

	/**
	 * @Title: top
	 * @author:gaofeng
	 * @Description: shortcut头部菜单一级菜单列表，并将其用ajax传到页面，实现动态控制一级菜单列表
	 * @return AjaxJson
	 * @throws
	 */
	@RequestMapping(params = "primaryMenu")
	@ResponseBody
	public String getPrimaryMenu(HttpServletRequest request) {
		HttpSession session = request.getSession();
		List<TSFunction> primaryMenu = getFunctionMap(
				ResourceUtil.getSessionUserName(session)).get(0);
		String floor = "";
		for (TSFunction function : primaryMenu) {
			if (function.getFunctionLevel() == 0) {

				if ("Online 开发".equals(function.getFunctionName())) {

					floor += " <li><img class='imag1' src='plug-in/login/images/online.png' /> "
							+ " <img class='imag2' src='plug-in/login/images/online_up.png' style='display: none;' />"
							+ " </li> ";
				} else if ("统计查询".equals(function.getFunctionName())) {

					floor += " <li><img class='imag1' src='plug-in/login/images/guanli.png' /> "
							+ " <img class='imag2' src='plug-in/login/images/guanli_up.png' style='display: none;' />"
							+ " </li> ";
				} else if ("系统管理".equals(function.getFunctionName())) {

					floor += " <li><img class='imag1' src='plug-in/login/images/xtgl.png' /> "
							+ " <img class='imag2' src='plug-in/login/images/xtgl_up.png' style='display: none;' />"
							+ " </li> ";
				} else if ("常用示例".equals(function.getFunctionName())) {

					floor += " <li><img class='imag1' src='plug-in/login/images/cysl.png' /> "
							+ " <img class='imag2' src='plug-in/login/images/cysl_up.png' style='display: none;' />"
							+ " </li> ";
				} else if ("系统监控".equals(function.getFunctionName())) {

					floor += " <li><img class='imag1' src='plug-in/login/images/xtjk.png' /> "
							+ " <img class='imag2' src='plug-in/login/images/xtjk_up.png' style='display: none;' />"
							+ " </li> ";
				} else {
					// 其他的为默认通用的图片模式
					String s = "";
					if (function.getFunctionName().length() >= 5
							&& function.getFunctionName().length() < 7) {
						s = "<div style='width:67px;position: absolute;top:40px;text-align:center;color:#909090;font-size:12px;'><span style='letter-spacing:-1px;'>"
								+ function.getFunctionName() + "</span></div>";
					} else if (function.getFunctionName().length() < 5) {
						s = "<div style='width:67px;position: absolute;top:40px;text-align:center;color:#909090;font-size:12px;'>"
								+ function.getFunctionName() + "</div>";
					} else if (function.getFunctionName().length() >= 7) {
						s = "<div style='width:67px;position: absolute;top:40px;text-align:center;color:#909090;font-size:12px;'><span style='letter-spacing:-1px;'>"
								+ function.getFunctionName().substring(0, 6)
								+ "</span></div>";
					}
					floor += " <li style='position: relative;'><img class='imag1' src='plug-in/login/images/default.png' /> "
							+ " <img class='imag2' src='plug-in/login/images/default_up.png' style='display: none;' />"
							+ s + "</li> ";
				}
			}
		}

		return floor;
	}

	/**
	 * 返回数据
	 */
	@RequestMapping(params = "getPrimaryMenuForWebos")
	@ResponseBody
	public AjaxJson getPrimaryMenuForWebos(HttpServletRequest request) {
		HttpSession session = request.getSession();
		AjaxJson j = new AjaxJson();
		// 将菜单加载到Session，用户只在登录的时候加载一次
		Object getPrimaryMenuForWebos = session
				.getAttribute("getPrimaryMenuForWebos");
		if (oConvertUtils.isNotEmpty(getPrimaryMenuForWebos)) {
			j.setMsg(getPrimaryMenuForWebos.toString());
		} else {
			String PMenu = ListtoMenu.getWebosMenu(getFunctionMap(ResourceUtil
					.getSessionUserName()));
			session.setAttribute("getPrimaryMenuForWebos", PMenu);
			j.setMsg(PMenu);
		}
		return j;
	}
	
	/**
	 * 检查session是否超时或注销
	 */
	@RequestMapping(params = "checkSession")
	@ResponseBody
	public AjaxJson checkSession(HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		j.setSuccess(true);
		j.setMsg("OK");
		if(request.getSession().getAttribute(Constants.SESSION_KEY_BO_USER) == null){
			j.setSuccess(false);
			j.setMsg("FAIL");
		}
		return j;
	}

	public static void main(String[] args) {
		String str1 = "NYXi";
		String str2 = "NYX1";

		System.out.println(str1.equalsIgnoreCase(str2));
	}
	
	/**
	 * 用户手机页面从新登入
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "message")
	public String message(ModelMap modelMap, HttpServletRequest request) {		 
		String redirectUrl = (String)request.getSession().getAttribute(Constants.SESSION_KEY_redirectUrl);	 
		int count = 0;
		try {
			count = (int)request.getSession().getAttribute(Constants.SESSION_KEY_redirect_count);
		} catch (Exception e) {
			request.getSession().setAttribute(Constants.SESSION_KEY_redirect_count, 0);  
		}
		count=count+1;
		request.getSession().setAttribute(Constants.SESSION_KEY_redirect_count, count);
		request.setAttribute("count", count); 
		request.setAttribute("redirectUrl", redirectUrl);
		request.setAttribute("message", "登入超时，请点击如下链接从新登入。");		
		return "/fo/common/notOpenIdMessage";	
	}

}
