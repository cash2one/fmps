package weixin.guanjia.menu.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.PropertyFilter;

import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.common.model.json.TreeGrid;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.util.LogUtil;
import org.jeecgframework.core.util.MyBeanUtils;
import org.jeecgframework.core.util.ResourceUtil;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.core.util.oConvertUtils;
import org.jeecgframework.tag.vo.datatable.SortDirection;
import org.jeecgframework.tag.vo.easyui.TreeGridModel;
import org.jeecgframework.web.system.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import weixin.guanjia.account.entity.WeixinAccountEntity;
import weixin.guanjia.account.service.WeixinAccountServiceI;
import weixin.guanjia.base.service.WeixinExpandconfigServiceI;
import weixin.guanjia.core.entity.common.Button;
import weixin.guanjia.core.entity.common.CommonButton;
import weixin.guanjia.core.entity.common.ComplexButton;
import weixin.guanjia.core.entity.common.Menu;
import weixin.guanjia.core.entity.common.ViewButton;
import weixin.guanjia.core.util.WeixinUtil;
import weixin.guanjia.menu.entity.MenuEntity;
import weixin.guanjia.menu.service.WeixinMenuServiceI;
import weixin.guanjia.message.entity.NewsTemplate;
import weixin.guanjia.message.entity.TextTemplate;
import weixin.util.WeiXinConstants;

/**
 * 微信自定义菜单
 * 
 */
@Scope("prototype")
@Controller
@RequestMapping("/menuManagerController")
public class MenuManagerController {
	@Autowired
	private SystemService systemService;
	@Autowired
	private WeixinAccountServiceI weixinAccountService;
	@Autowired
	private WeixinMenuServiceI weixinMenuService;
	@Autowired
	private WeixinExpandconfigServiceI weixinExpandconfigService;
	private String message;

	@RequestMapping(params = "list")
	public ModelAndView list() {
		return new ModelAndView("weixin/guanjia/menu/menulist");
	}

	@RequestMapping(params = "getSubMenu")
	public void getSubMenu(HttpServletRequest request,
			HttpServletResponse response) {
		String accountid = ResourceUtil.getWeiXinAccountId();
		String msgType = request.getParameter("msgType");
		String resMsg = "";
		JsonConfig config = new JsonConfig();
		config.setJsonPropertyFilter(new PropertyFilter() {
			public boolean apply(Object source, String name, Object value) {
				if (name.equals("menuList")) { // 要过滤的areas ，Map对象中的
					return true;
				} else {
					return false;
				}
			}
		});
		List<MenuEntity> textList = this.weixinMenuService
				.findByQueryString("from MenuEntity t  where t.accountId = '"
						+ accountid + "'");
		JSONArray json = JSONArray.fromObject(textList, config);
		resMsg = json.toString();

		try {
			response.setCharacterEncoding("utf-8");
			PrintWriter writer = response.getWriter();
			writer.write(resMsg);
			writer.flush();
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@RequestMapping(params = "gettemplate")
	public void gettemplate(HttpServletRequest request,
			HttpServletResponse response) {
		String accountid = ResourceUtil.getWeiXinAccountId();
		String msgType = request.getParameter("msgType");
		String resMsg = "";
		if ("text".equals(msgType)) {
			List<TextTemplate> textList = this.weixinMenuService
					.findByQueryString("from TextTemplate t where t.accountId = '"
							+ accountid + "'");
			JSONArray json = JSONArray.fromObject(textList);
			resMsg = json.toString();
		} else if ("news".equals(msgType)) {
			JsonConfig jsonConfig = new JsonConfig();
			jsonConfig.setExcludes(new String[] { "newsItemList" });
			List<NewsTemplate> newsList = this.weixinMenuService
					.findByQueryString("from NewsTemplate t where t.accountId = '"
							+ accountid + "'");
			JSONArray json = JSONArray.fromObject(newsList, jsonConfig);
			resMsg = json.toString();
		} else if ("expand".equals(msgType)) {

			JsonConfig jsonConfig = new JsonConfig();
			jsonConfig.setExcludes(new String[] { "newsItemList" });
			List<NewsTemplate> newsList = this.weixinMenuService
					.findByQueryString("from WeixinExpandconfigEntity t where t.accountid = '"
							+ accountid + "'");
			JSONArray json = JSONArray.fromObject(newsList, jsonConfig);
			resMsg = json.toString();

		}
		try {
			response.setCharacterEncoding("utf-8");
			PrintWriter writer = response.getWriter();
			writer.write(resMsg);
			writer.flush();
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@RequestMapping(params = "datagrid")
	@ResponseBody
	public List<TreeGrid> datagrid(TreeGrid treegrid,
			HttpServletRequest request, HttpServletResponse response,
			DataGrid dataGrid) {

		CriteriaQuery cq = new CriteriaQuery(MenuEntity.class);
		cq.eq("accountId", ResourceUtil.getWeiXinAccountId());
		if (treegrid.getId() != null) {
			cq.eq("menuEntity.id", treegrid.getId());
		} else {

			cq.isNull("menuEntity");
		}

		cq.addOrder("orders", SortDirection.asc);
		cq.add();

		List<MenuEntity> menuList = systemService.getListByCriteriaQuery(cq,
				false);
		List<TreeGrid> treeGrids = new ArrayList<TreeGrid>();
		TreeGridModel treeGridModel = new TreeGridModel();
		// treeGridModel.setIcon("orders");
		treeGridModel.setTextField("name");
		treeGridModel.setParentText("url");
		treeGridModel.setOrder("orders");
		treeGridModel.setSrc("type");
		treeGridModel.setIdField("id");
		treeGridModel.setChildList("menuList");
		treeGridModel.setStatus("status");
		// 添加排序字段
		treeGrids = systemService.treegrid(menuList, treeGridModel);
		return treeGrids;
	}

	@RequestMapping(params = "jumpSuView")
	public ModelAndView jumpSuView(MenuEntity menuEntity, HttpServletRequest req) {

		org.jeecgframework.core.util.LogUtil.info("...menuEntity.getId()..."
				+ menuEntity.getId());
		if (StringUtil.isNotEmpty(menuEntity.getId())) {
			menuEntity = this.systemService.getEntity(MenuEntity.class,
					menuEntity.getId());
			if (menuEntity.getMenuEntity() != null
					&& menuEntity.getMenuEntity().getId() != null) {
				req.setAttribute("fatherId", menuEntity.getMenuEntity().getId());
				req.setAttribute("fatherName", menuEntity.getMenuEntity()
						.getName());
			}
			req.setAttribute("name", menuEntity.getName());
			req.setAttribute("type", menuEntity.getType());
			req.setAttribute("menuKey", menuEntity.getMenuKey());
			req.setAttribute("url", menuEntity.getUrl());
			req.setAttribute("orders", menuEntity.getOrders());
			req.setAttribute("templateId", menuEntity.getTemplateId());
			req.setAttribute("msgType", menuEntity.getMsgType());
			req.setAttribute("status", menuEntity.getStatus());
		}
		String fatherId = req.getParameter("fatherId");
		if (StringUtil.isNotEmpty(fatherId)) {
			MenuEntity fatherMenuEntity = this.systemService.getEntity(
					MenuEntity.class, fatherId);
			req.setAttribute("fatherId", fatherId);
			req.setAttribute("fatherName", fatherMenuEntity.getName());
			org.jeecgframework.core.util.LogUtil.info(".....fatherName...."
					+ fatherMenuEntity.getName());
		}
		return new ModelAndView("weixin/guanjia/menu/menuinfo");
	}

	@RequestMapping(params = "su")
	@ResponseBody
	public AjaxJson su(MenuEntity menuEntity, HttpServletRequest req,
			String fatherName) {
		AjaxJson j = new AjaxJson();
		String id = oConvertUtils.getString(req.getParameter("id"));

		if (StringUtil.isNotEmpty(menuEntity.getId())) {

			MenuEntity tempMenu = this.systemService.getEntity(
					MenuEntity.class, menuEntity.getId());
			MenuEntity menuTemp = new MenuEntity();
			menuTemp.setId(fatherName);
			if("firstLevelMenu".equalsIgnoreCase(fatherName)){
				menuTemp = null;
			}
			tempMenu.setMenuEntity(menuTemp);
//			tempMenu.getMenuEntity().getId();
			this.message = "更新" + tempMenu.getName() + "的菜单信息成功！";
			try {
				MyBeanUtils.copyBeanNotNull2Bean(menuEntity, tempMenu);
				this.weixinMenuService.saveOrUpdate(tempMenu);
				systemService.addLog(message, Globals.Log_Type_UPDATE,
						Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				j.setMsg("操作失败");
				this.message = "更新" + tempMenu.getName() + "的菜单信息失败！";
				systemService.addLog(message, Globals.Log_Type_UPDATE,
						Globals.Log_Leavel_ERROR);
				e.printStackTrace();
			}

		} else {
			Map<String,String> map = checkMenuNumValid(req);//检查菜单个数是否符合规定 1、一级菜单有效的不能超过3个 2、一级菜单下有效的二级菜单不能超过5个
			String flag = map.get("flag");
			if("2".equalsIgnoreCase(flag)){//提示菜单个数不符合
				j.setSuccess(false);
				j.setMsg(map.get("msg"));
				
				return j;
			}
			this.message = "添加" + menuEntity.getName() + "的信息成功！";
			String fatherId = req.getParameter("fatherId");
			if (StringUtil.isNotEmpty(fatherName)) {
				MenuEntity tempMenu = this.systemService.getEntity(
						MenuEntity.class, fatherName);
				menuEntity.setMenuEntity(tempMenu);
			}
			String accountId = ResourceUtil.getWeiXinAccountId();
			if (!"-1".equals(accountId)) {
				this.weixinMenuService.save(menuEntity);
			} else {
				j.setSuccess(false);
				j.setMsg("请添加一个公众帐号。");
			}
			systemService.addLog(message, Globals.Log_Type_INSERT,
					Globals.Log_Leavel_INFO);
		}
		return j;
	}

	@RequestMapping(params = "jumpselect")
	public ModelAndView jumpselect() {
		return new ModelAndView("");
	}

	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(MenuEntity menuEntity, HttpServletRequest req) {
		AjaxJson j = new AjaxJson();
		menuEntity = this.systemService.getEntity(MenuEntity.class,
				menuEntity.getId());

		this.systemService.delete(menuEntity);

		message = "删除" + menuEntity.getName() + "菜单信息数据";
		systemService.addLog(message, Globals.Log_Type_DEL,
				Globals.Log_Leavel_INFO);
		j.setMsg(this.message);
		return j;
	}

	@RequestMapping(params = "changeStatus")
	@ResponseBody
	public AjaxJson changeStatus(MenuEntity menuEntity, HttpServletRequest req) {
		AjaxJson j = new AjaxJson();
		menuEntity = this.systemService.getEntity(MenuEntity.class,
				menuEntity.getId());

		if ("1".equals(menuEntity.getStatus())) {
			menuEntity.setStatus("2");
		} else {
			Map<String,String> map = checkEnableValid(req,menuEntity.getId());//启用前，判断是否已经达到最多启动个数（一级最多3个，二级最多5个）
			String flag = map.get("flag");
			if("2".equalsIgnoreCase(flag)){//提示先停用，后启用
				j.setSuccess(true);
				j.setMsg(map.get("msg"));
				
				return j;
			}
			
			menuEntity.setStatus("1");
		}
		List<String> isfirstmenu = this.systemService
				.findListbySql("SELECT id FROM weixin_menuentity  WHERE fatherid is null and id='"
						+ menuEntity.getId() + "'");
		if (isfirstmenu.size() > 0) {
			List<String> allidString = this.systemService
					.findListbySql("SELECT id FROM weixin_menuentity  WHERE fatherid='"
							+ menuEntity.getId() + "'");
			for (int i = 0; i < allidString.size(); i++) {
				MenuEntity menuEntityy = this.systemService.getEntity(
						MenuEntity.class, allidString.get(i));
				if ("1".equals(menuEntity.getStatus())) {
					menuEntityy.setStatus("1");
				} else {
					menuEntityy.setStatus("2");
				}
				weixinMenuService.updateEntitie(menuEntityy);
			}
		}

		String message = "状态更新成功";
		weixinMenuService.updateEntitie(menuEntity);
		j.setMsg(message);
		return j;
	}

	/**
	 * 检查菜单个数是否符合规定
	 * 1、一级菜单有效的不能超过3个
	 * 2、一级菜单下有效的二级菜单不能超过5个
	 * 
	 * @param request
	 * @return
	 */
	public Map<String,String> checkMenuNumValid(HttpServletRequest request) {
		Map<String,String> map = new HashMap<String,String>();
		String fatherNameString = request.getParameter("fatherName");
		// 表示"1"表示可以通过 "2"表示不可以通过
		String passflag = "";
		if ("firstLevelMenu".equals(fatherNameString)) {
			List<String> isfirstmenu = this.systemService
					.findListbySql("SELECT id FROM weixin_menuentity  WHERE fatherid is null and status='1' ");
			if (isfirstmenu.size() >= 3) {
				passflag = "2";
				map.put("msg","[一级菜单]有效的最多只能3个");
			}
		} else {
			String fatherId = request.getParameter("fatherId");
			List<String> issecondmenu = this.systemService
					.findListbySql("SELECT id FROM weixin_menuentity t WHERE fatherid = '"+fatherId+"' and t.status = '1' ");
			if (issecondmenu.size() >= 5) {
				passflag = "2";
				map.put("msg","[二级菜单]有效的最多只能5个");
			}
		}
		map.put("flag",passflag);
		
		return map;

	}
	
	/**
	 * 启用前，判断是否已经达到最多启动个数（一级最多3个，二级最多5个）
	 * 
	 * @param id
	 * @return
	 */
	public Map<String,String> checkEnableValid(HttpServletRequest request,String id){
		Map<String, String> map = new HashMap<String, String>();
		String fatherNameString = request.getParameter("fatherName");
		if(checkFirstLevelMenu(id)){
			fatherNameString = "firstLevelMenu";
		}
		String passflag = "";
		if ("firstLevelMenu".equals(fatherNameString)) {
			List<String> isfirstmenu = this.systemService
					.findListbySql("SELECT id FROM weixin_menuentity WHERE fatherid is null and status='1' ");
			if (isfirstmenu.size() >= 3) {
				passflag = "2";
				map.put("msg","[一级菜单]最多只能启用3个，请先停用，再启用");
			}
		}else{
			List<String> startedMenu = this.systemService
					.findListbySql("select id from weixin_menuentity t where t.status = '1' and fatherid in (SELECT fatherid FROM weixin_menuentity WHERE id = '" + id + "') ");
			if (startedMenu.size() >= 5) {
				passflag = "2";
				map.put("msg", "[二级菜单]最多只能启用5个，请先停用，再启用");
			}
		}

		map.put("flag", passflag);
		return map;
	}

	/**
	 * 判断是否一级菜单
	 * 
	 * @param id
	 * @return
	 */
	public boolean checkFirstLevelMenu(String id){
		Map<String, Object> map = this.systemService
				.findOneForJdbc("SELECT fatherid FROM WEIXIN_MENUENTITY t where t.id='" + id + "'");
		
		return map.get("fatherid") == null ? true : false;
	}
	
	@RequestMapping(params = "sameMenu")
	@ResponseBody
	public AjaxJson sameMenu(MenuEntity menuEntity, HttpServletRequest req) {
		AjaxJson j = new AjaxJson();
		String domain = ResourceUtil.getDomain();
		List<WeixinAccountEntity> weixinAccountEntityList = weixinAccountService
				.findValidWeixinAccounts();
		WeixinAccountEntity weixinAccountEntity = weixinAccountEntityList
				.get(0);
		String hql = "from MenuEntity where fatherid is null and accountId = '"
				+ ResourceUtil.getWeiXinAccountId() + "'  order by  orders asc";
		List<MenuEntity> menuList = this.systemService.findByQueryString(hql);
		org.jeecgframework.core.util.LogUtil.info(".....一级菜单的个数是....."
				+ menuList.size());
		Menu menu = new Menu();
		Button firstArr[] = new Button[menuList.size()];
		for (int a = 0; a < menuList.size(); a++) {
			MenuEntity entity = menuList.get(a);
			String hqls = "from MenuEntity where fatherid = '" + entity.getId()
					+ "' and accountId = '" + ResourceUtil.getWeiXinAccountId()
					+ "' and status='1'"					
					+ " order by  orders asc";
			List<MenuEntity> childList = this.systemService
					.findByQueryString(hqls);
			// org.jeecgframework.core.util.LogUtil.info("....二级菜单的大小....." +
			// childList.size());
			if (childList.size() == 0) {
				if ("view".equals(entity.getType())) {
					ViewButton viewButton = new ViewButton();
					viewButton.setName(entity.getName());
					viewButton.setType(entity.getType());
					String url = entity.getUrl();
					url = url.replace("{APPID}",
							weixinAccountEntity.getAccountappid()).replace(
							"{domain}", domain);
					// changed by qingqu.huang 20150807
					url = url.replace("%7Bdomain%7D", domain);
					viewButton.setUrl(url);
					firstArr[a] = viewButton;
				} else if ("click".equals(entity.getType())) {
					CommonButton cb = new CommonButton();
					cb.setKey(entity.getMenuKey());
					cb.setName(entity.getName());
					cb.setType(entity.getType());
					firstArr[a] = cb;
				}
			}else if(childList.size() > 5){
				message = "有效菜单项为"+childList.size()+"个，超过微信菜单项5个的限制，请检查。";
				j.setMsg(this.message);
				return j;
			} else {
				ComplexButton complexButton = new ComplexButton();
				complexButton.setName(entity.getName());

				Button[] secondARR = new Button[childList.size()];
				for (int i = 0; i < childList.size(); i++) {
					MenuEntity children = childList.get(i);
					String type = children.getType();
					if ("view".equals(type)) {
						ViewButton viewButton = new ViewButton();
						viewButton.setName(children.getName());
						viewButton.setType(children.getType());
						String url = children.getUrl();
						url = url.replace("{APPID}",
								weixinAccountEntity.getAccountappid()).replace(
								"{domain}", domain);
						// changed by qingqu.huang 20150807
						url = url.replace("%7Bdomain%7D", domain);
						viewButton.setUrl(url);
						secondARR[i] = viewButton;
					} else if ("click".equals(type)) {
						CommonButton cb1 = new CommonButton();
						cb1.setName(children.getName());
						cb1.setType(children.getType());
						cb1.setKey(children.getMenuKey());
						secondARR[i] = cb1;
					}

				}
				complexButton.setSub_button(secondARR);
				firstArr[a] = complexButton;
			}
		}
		menu.setButton(firstArr);
		JSONObject jsonMenu = JSONObject.fromObject(menu);
		String accessToken = weixinAccountService
				.getAccessToken(weixinAccountEntity);
		String url = WeixinUtil.menu_create_url.replace("ACCESS_TOKEN",
				accessToken);
		JSONObject jsonObject = new JSONObject();
		String xxx = jsonMenu.toString();
		try {
			jsonObject = WeixinUtil.httpRequest(url, "POST",
					jsonMenu.toString());
			LogUtil.info(jsonObject);
			if (jsonObject != null) {
				if (Integer
						.parseInt(jsonObject
								.getString(WeiXinConstants.WEIXIN_RETURN_JSON_KEY_ERROR_CODE)) == WeiXinConstants.WEIXIN_RETURN_VALUE_OK) {
					message = "同步菜单信息数据成功！";
				} else {
					message = "同步菜单信息数据失败！错误码为："
							+ jsonObject
									.getString(WeiXinConstants.WEIXIN_RETURN_JSON_KEY_ERROR_CODE)
							+ "错误信息为："
							+ jsonObject
									.getString(WeiXinConstants.WEIXIN_RETURN_JSON_KEY_ERROR_MESSAGE);
				}
			} else {
				message = "同步菜单信息数据失败！同步自定义菜单URL地址不正确。";
			}
		} catch (Exception e) {
			message = "同步菜单信息数据失败！";
		} finally {
			systemService.addLog(message, Globals.Log_Type_DEL,
					Globals.Log_Leavel_INFO);
			j.setMsg(this.message);
		}
		return j;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}