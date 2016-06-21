/**
 * 
 */
package cn.com.fubon.product.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jodd.util.StringUtil;

import org.apache.log4j.Logger;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.util.DateUtils;
import org.jeecgframework.core.util.ResourceUtil;
import org.jeecgframework.core.util.RoletoJson;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.tag.vo.datatable.SortDirection;
import org.jeecgframework.web.system.pojo.base.TSDepart;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.com.fubon.product.entity.Affiliated;
import cn.com.fubon.product.entity.InsuranceKind;
import cn.com.fubon.product.entity.Plan;
import cn.com.fubon.product.entity.Product;
import cn.com.fubon.product.entity.ProductRule;
import cn.com.fubon.product.entity.Responsibility;
import cn.com.fubon.product.service.IProductService;

/**
 * 商品管理
 * 
 * @author qingqu.huang
 * @date 2015-05-06
 */
@Scope("prototype")
@Controller
@RequestMapping("/product/ProductController")
public class ProductController {

	private static final Logger logger = Logger
			.getLogger(ProductController.class);

	@Resource
	private IProductService productService;
	private String message;

	/**
	 * easyuiAJAX产品列表请求数据
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 */
	@RequestMapping(params = "datagrid")
	public void datagrid(Product card, HttpServletRequest request,
			HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(Product.class, dataGrid);
		// 查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq,
				card);
		cq.add();
		productService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 进入商品列表界面
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "product")
	public ModelAndView product(HttpServletRequest request) {
		return new ModelAndView("product/productList");
	}

	/**
	 * 进入商品添加界面
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "goprod")
	public ModelAndView goProduct(HttpServletRequest request) {
		request.setAttribute("Domain", ResourceUtil.getDomain());
		return new ModelAndView("product/product");
	}

	/**
	 * 进入商品更新界面
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(HttpServletRequest request, Product product) {
		product = productService.getEntity(Product.class, product.getId());
		request.setAttribute("productname", product.getProductname());
		request.setAttribute("riskshortname", product.getRiskshortname());
		request.setAttribute("type", product.getType());
		request.setAttribute("internalcode", product.getInternalcode());
		request.setAttribute("iscard", product.getIscard());
		request.setAttribute("status", product.getStatus());
		request.setAttribute("imagehref", product.getImagehref());
		request.setAttribute("imagename", product.getImagename());
		request.setAttribute("occupationcategory",
				product.getOccupationcategory());
		request.setAttribute("occupationcode", product.getOccupationcode());
		request.setAttribute("Domain", ResourceUtil.getDomain());
		request.setAttribute("salemode", product.getSalemode());
		request.setAttribute("feature", product.getFeature());
		request.setAttribute("delivery", product.getDelivery());
		request.setAttribute("occupationLevels", product.getOccupationLevels());
		return new ModelAndView("product/product");
	}

	/**
	 * 添加或者更新商品
	 * 
	 * @param req
	 * @param product
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	@ResponseBody
	public AjaxJson addorupdate(HttpServletRequest req, Product product) {
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(product.getId())) {
			logger.info("更新商品...");
			Product prod = productService.getEntity(Product.class,
					product.getId());
			prod.setInternalcode(product.getInternalcode());
			prod.setIscard(product.getIscard());
			prod.setProductname(product.getProductname());
			prod.setStatus(product.getStatus());
			prod.setType(product.getType());
			prod.setImagehref(product.getImagehref());
			prod.setOccupationcategory(product.getOccupationcategory());
			prod.setOccupationcode(product.getOccupationcode());
			prod.setSalemode(product.getSalemode());
			prod.setDelivery(product.getDelivery());
			prod.setFeature(product.getFeature());
			prod.setOccupationLevels(product.getOccupationLevels());
			prod.setRiskshortname(product.getRiskshortname());
			productService.updateEntitie(prod);
			message = "商品: " + product.getProductname() + "更新 成功";
		} else {
			logger.info("添加商品...");
			product.setCreatetime(DateUtils.gettimestamp());
			productService.save(product);
			message = "商品: " + product.getProductname() + "增加 成功";
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 删除商品
	 * 
	 * @param req
	 * @param product
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(HttpServletRequest req, Product product) {
		AjaxJson j = new AjaxJson();
		product = productService.getEntity(Product.class, product.getId());
		// 删除产品关联的计划以及责任维护
		List<Plan> planList = productService.findByProperty(Plan.class,
				"productid", product.getId());
		if (planList.size() > 0) {
			for (Plan plan : planList) {
				List<Responsibility> rebList = productService.findByProperty(
						Responsibility.class, "planid", plan.getId());
				if (rebList.size() > 0) {
					for (Responsibility res : rebList) {
						productService.delete(res);
					}
				}
				productService.delete(plan);
			}
		}
		// 删除产品相关联的投保规则
		List<ProductRule> ruleList = productService.findByProperty(
				ProductRule.class, "productid", product.getId());
		if (ruleList.size() > 0) {
			for (ProductRule pr : ruleList) {
				productService.delete(pr);
			}
		}
		// 删除相关联的附加信息
		List<Affiliated> affList = productService.findByProperty(
				Affiliated.class, "productid", product.getId());
		if (affList.size() > 0) {
			for (Affiliated aff : affList) {
				productService.delete(aff);
			}
		}

		message = "商品: " + product.getProductname() + "被删除 成功";
		productService.delete(product);
		j.setMsg(this.message);
		return j;
	}

	/**
	 * 进入投保规则列表界面
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "prodrulelist")
	public ModelAndView productRuleList(HttpServletRequest request) {
		String id = request.getParameter("id");
		request.setAttribute("prodid", id);
		// logger.info("获取产品ID" + product.getId());
		Product product = productService.getEntity(Product.class, id);
		request.setAttribute("productname", product.getProductname());
		return new ModelAndView("product/ruleList");
	}

	/**
	 * easyuiAJAX投保规则列表请求数据
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 */
	@RequestMapping(params = "ruledatagrid")
	public void ruledatagrid(ProductRule rule, HttpServletRequest request,
			HttpServletResponse response, DataGrid dataGrid) {
		String productid = request.getParameter("prodid");
		logger.info("用于过滤规则的产品ID：" + productid);
		rule.setProductid(productid);
		;
		CriteriaQuery cq = new CriteriaQuery(ProductRule.class, dataGrid);
		// 查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq,
				rule);
		cq.add();
		productService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 进入投保规则界面
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "rule")
	public ModelAndView rule(HttpServletRequest request) {
		String productid = request.getParameter("prodid");
		request.setAttribute("productid", productid);
		return new ModelAndView("product/rule");
	}

	/**
	 * 进入投保规则更新界面
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "ruleUpdate")
	public ModelAndView ruleUpdate(HttpServletRequest request, ProductRule rule) {
		rule = productService.getEntity(ProductRule.class, rule.getId());
		request.setAttribute("id", rule.getId());
		request.setAttribute("productid", rule.getProductid());
		request.setAttribute("minage", rule.getMinage());
		request.setAttribute("maxage", rule.getMaxage());
		request.setAttribute("unit", rule.getUnit());
		request.setAttribute("rulename", rule.getRulename());
		request.setAttribute("ruletype", rule.getRuletype());
		request.setAttribute("ruleclass", rule.getRuleclass());
		return new ModelAndView("product/rule");
	}

	/**
	 * 添加或者更新投保规则
	 * 
	 * @param req
	 * @param product
	 * @return
	 */
	@RequestMapping(params = "addorupdaterule")
	@ResponseBody
	public AjaxJson addorupdaterule(HttpServletRequest req, ProductRule rule) {
		logger.info("产品ID:" + req.getParameter("productid"));
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(rule.getId())) {
			logger.info("更新投保规则...");
			ProductRule oldrule = productService.getEntity(ProductRule.class,
					rule.getId());
			oldrule.setMinage(rule.getMinage());
			oldrule.setMaxage(rule.getMaxage());
			oldrule.setUnit(rule.getUnit());
			oldrule.setRuleclass(rule.getRuleclass());
			oldrule.setRulename(rule.getRulename());
			oldrule.setRuletype(rule.getRuletype());
			productService.updateEntitie(oldrule);
			message = "投保规则更新 成功";
		} else {
			logger.info("添加投保规则...");
			productService.save(rule);
			message = "投保规则增加 成功";
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 删除投保规则
	 * 
	 * @param req
	 * @param product
	 * @return
	 */
	@RequestMapping(params = "delrule")
	@ResponseBody
	public AjaxJson delRule(HttpServletRequest req, ProductRule rule) {
		AjaxJson j = new AjaxJson();
		rule = productService.getEntity(ProductRule.class, rule.getId());
		message = "投保规则被删除 成功";
		productService.delete(rule);
		j.setMsg(this.message);
		return j;
	}

	/**
	 * 进入条款列表界面
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "noticelist")
	public ModelAndView productNoticeList(HttpServletRequest request,
			Product product) {
		String type = request.getParameter("type");
		request.setAttribute("type", type);
		request.setAttribute("prodid", product.getId());
		product = productService.getEntity(Product.class, product.getId());
		request.setAttribute("productname", product.getProductname());
		return new ModelAndView("product/affiliatedList");
	}

	/**
	 * easyuiAJAX条款列表请求数据
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 */
	@RequestMapping(params = "affidatagrid")
	public void affidatagrid(Affiliated aff, HttpServletRequest request,
			HttpServletResponse response, DataGrid dataGrid) {
		String productid = request.getParameter("prodid");
		String type = request.getParameter("type");
		logger.info("用于过滤规则的产品ID：" + productid);
		aff.setProductid(productid);
		aff.setType(type);
		CriteriaQuery cq = new CriteriaQuery(Affiliated.class, dataGrid);
		// 查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq,
				aff);
		cq.add();
		productService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 进入条款添加界面
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "aff")
	public ModelAndView aff(HttpServletRequest request) {
		String productid = request.getParameter("prodid");
		request.setAttribute("productid", productid);
		request.setAttribute("type", "1");
		request.setAttribute("Domain", ResourceUtil.getDomain());
		return new ModelAndView("product/affiliated");
	}

	/**
	 * 进入条款更新界面
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "affupdate")
	public ModelAndView affUpdate(HttpServletRequest request, Affiliated aff) {
		aff = productService.getEntity(Affiliated.class, aff.getId());
		request.setAttribute("id", aff.getId());
		request.setAttribute("productid", aff.getProductid());
		request.setAttribute("type", aff.getType());
		request.setAttribute("document", new String(aff.getDocument()));
		request.setAttribute("description", aff.getDescription());
		request.setAttribute("sorting", aff.getSorting());
		request.setAttribute("Domain", ResourceUtil.getDomain());
		return new ModelAndView("product/affiliated");
	}

	/**
	 * 删除条款
	 * 
	 * @param req
	 * @param plan
	 * @return
	 */
	@RequestMapping(params = "delaff")
	@ResponseBody
	public AjaxJson delAff(HttpServletRequest req, Affiliated aff) {
		AjaxJson j = new AjaxJson();
		aff = productService.getEntity(Affiliated.class, aff.getId());
		message = "条款被删除 成功";
		productService.delete(aff);
		j.setMsg(this.message);
		return j;
	}

	/**
	 * 进入须知界面
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "ntupdate")
	public ModelAndView ntUpdate(HttpServletRequest request) {
		String productid = request.getParameter("id");
		String type = request.getParameter("type");
		Affiliated qaff = new Affiliated();
		qaff.setProductid(productid);
		qaff.setType(type);
		CriteriaQuery cq = new CriteriaQuery(Affiliated.class);
		// 查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq,
				qaff);
		cq.add();
		List<Affiliated> affList = productService.getListByCriteriaQuery(cq,
				true);
		if (affList.size() > 0) {
			for (Affiliated aff : affList) {
				request.setAttribute("id", aff.getId());
				request.setAttribute("productid", aff.getProductid());
				request.setAttribute("type", aff.getType());
				request.setAttribute("document", aff.getDocument());
				request.setAttribute("Domain", ResourceUtil.getDomain());
			}
		} else {
			request.setAttribute("productid", productid);
			request.setAttribute("type", type);
			request.setAttribute("Domain", ResourceUtil.getDomain());
		}

		return new ModelAndView("product/notice");
	}

	/**
	 * 添加或者更新投须知 *
	 * 
	 * @param req
	 * @param
	 * @return
	 */
	@RequestMapping(params = "aopnt")
	@ResponseBody
	public AjaxJson aopNt(HttpServletRequest req, Affiliated aff) {
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(aff.getId())) {
			logger.info("更新须知...");
			Affiliated oldaff = productService.getEntity(Affiliated.class,
					aff.getId());
			oldaff.setType(aff.getType());
			oldaff.setDocument(aff.getDocument());
			oldaff.setDescription("须知");
			productService.updateEntitie(oldaff);
			message = "更新成功";
		} else {
			logger.info("添加须知...");
			aff.setDescription("须知");
			productService.save(aff);
			message = "增加成功";
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 添加或者更新投保条款
	 * 
	 * @param req
	 * @param
	 * @return
	 */
	@RequestMapping(params = "aopaff")
	@ResponseBody
	public AjaxJson aopAff(HttpServletRequest req, Affiliated aff) {
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(aff.getId())) {
			logger.info("更新条款...");
			Affiliated oldaff = productService.getEntity(Affiliated.class,
					aff.getId());
			oldaff.setType(aff.getType());
			oldaff.setDocument(aff.getDocument());			
			oldaff.setSorting(aff.getSorting());			
			oldaff.setDescription(aff.getDescription());
			productService.updateEntitie(oldaff);
			message = "条款更新成功";
		} else {
			logger.info("添加条款...");
			productService.save(aff);
			message = "条款增加成功";
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 进入计划维护列表界面
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "prodplanlist")
	public ModelAndView productPlanList(HttpServletRequest request,
			Product product) {
		request.setAttribute("prodid", product.getId());
		product = productService.getEntity(Product.class, product.getId());
		request.setAttribute("productname", product.getProductname());
		return new ModelAndView("product/planList");
	}

	/**
	 * easyuiAJAX计划列表请求数据
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 */
	@RequestMapping(params = "plandatagrid")
	public void plandatagrid(Plan plan, HttpServletRequest request,
			HttpServletResponse response, DataGrid dataGrid) {
		String productid = request.getParameter("prodid");
		logger.info("用于过滤规则的产品ID：" + productid);
		// Product product = productService.getEntity(Product.class, productid);
		// plan.setProduct(product);
		plan.setProductid(productid);
		CriteriaQuery cq = new CriteriaQuery(Plan.class, dataGrid);
		cq.addOrder("serialno", SortDirection.asc);
		// 查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq,
				plan);
		cq.add();
		productService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除计划维护
	 * 
	 * @param req
	 * @param plan
	 * @return
	 */
	@RequestMapping(params = "delplan")
	@ResponseBody
	public AjaxJson delPlan(HttpServletRequest req, Plan plan) {
		AjaxJson j = new AjaxJson();
		plan = productService.getEntity(Plan.class, plan.getId());
		List<Responsibility> rebList = productService.findByProperty(
				Responsibility.class, "planid", plan.getId());
		if (rebList.size() > 0) {
			for (Responsibility res : rebList) {
				productService.delete(res);
			}
		}
		message = "计划被删除成功";
		productService.delete(plan);
		j.setMsg(this.message);
		return j;
	}

	/**
	 * 添加或者更新计划
	 * 
	 * @param req
	 * @param product
	 * @return
	 */
	@RequestMapping(params = "addorupdateplan")
	@ResponseBody
	public AjaxJson addorupdateplan(HttpServletRequest req, Plan plan) {
		logger.info("产品ID:" + req.getParameter("productid"));
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(plan.getId())) {
			logger.info("更新计划维护...");
			Plan oldplan = productService.getEntity(Plan.class, plan.getId());
			oldplan.setCoreproductcode(plan.getCoreproductcode());
			oldplan.setPeriod(plan.getPeriod());
			oldplan.setPeriodtype(plan.getPeriodtype());
			oldplan.setPlanname(plan.getPlanname());
			oldplan.setPremium(plan.getPremium());
			oldplan.setSerialno(plan.getSerialno());
			oldplan.setStatus(plan.getStatus());
			productService.updateEntitie(oldplan);
			message = "计划更新 成功";
		} else {
			logger.info("添加计划...");
			plan.setCreatetime(DateUtils.gettimestamp());
			// plan.setProduct(product);
			productService.save(plan);
			message = "计划增加 成功";
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 进入计划添加界面
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "plan")
	public ModelAndView plan(HttpServletRequest request) {
		String productid = request.getParameter("prodid");
		request.setAttribute("productid", productid);
		return new ModelAndView("product/plan");
	}

	/**
	 * 进入计划更新界面
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "planUpdate")
	public ModelAndView planUpdate(HttpServletRequest request, Plan plan) {
		plan = productService.getEntity(Plan.class, plan.getId());
		request.setAttribute("id", plan.getId());
		// request.setAttribute("productid", plan.getProduct().getId());
		request.setAttribute("productid", plan.getProductid());
		request.setAttribute("serialno", plan.getSerialno());
		request.setAttribute("planname", plan.getPlanname());
		request.setAttribute("coreproductcode", plan.getCoreproductcode());
		request.setAttribute("period", plan.getPeriod());
		request.setAttribute("periodtype", plan.getPeriodtype());
		request.setAttribute("premium", plan.getPremium());
		request.setAttribute("status", plan.getStatus());
		return new ModelAndView("product/plan");
	}

	/**
	 * 进入责任维护列表界面
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "rebList")
	public ModelAndView rebList(HttpServletRequest request) {
		String kindid = request.getParameter("id");
		request.setAttribute("kindid", kindid);
		String planid = request.getParameter("planid");
		request.setAttribute("planid", planid);
		String productid = request.getParameter("productid");
		Product product = productService.findUniqueByProperty(Product.class,
				"id", productid);
		String productname = product.getProductname();
		request.setAttribute("productid", productid);
		request.setAttribute("productname", productname);
		Plan plan = productService.getEntity(Plan.class, planid);
		request.setAttribute("planname", plan.getPlanname());
		InsuranceKind insuranceKind = productService.getEntity(
				InsuranceKind.class, kindid);
		request.setAttribute("kindname", insuranceKind.getKindname());
		return new ModelAndView("product/responsibilityList");
	}

	/**
	 * easyuiAJAX责任维护列表请求数据
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 */
	@RequestMapping(params = "rebdatagrid")
	public void rebdatagrid(Responsibility res, HttpServletRequest request,
			HttpServletResponse response, DataGrid dataGrid) {
		String planid = request.getParameter("planid");
		String kindid = request.getParameter("kindid");
		logger.info("用于过滤责任的计划ID：" + planid);
		res.setPlanid(planid);
		res.setKindid(kindid);
		CriteriaQuery cq = new CriteriaQuery(Responsibility.class, dataGrid);
		cq.addOrder("liabilitycode", SortDirection.asc);
		// 查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq,
				res);
		cq.add();
		productService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除责任维护
	 * 
	 * @param req
	 * @param plan
	 * @return
	 */
	@RequestMapping(params = "delreb")
	@ResponseBody
	public AjaxJson delreb(HttpServletRequest req, Responsibility res) {
		AjaxJson j = new AjaxJson();
		res = productService.getEntity(Responsibility.class, res.getId());
		message = "责任维护:" + res.getLiabilitycode() + "被删除 成功";
		productService.delete(res);
		j.setMsg(this.message);
		return j;
	}

	/**
	 * 进入责任维护添加界面
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "reb")
	public ModelAndView reb(HttpServletRequest request) {
		String productid = request.getParameter("productid");
		String planid = request.getParameter("planid");
		String kindid = request.getParameter("kindid");
		request.setAttribute("productid", productid);
		request.setAttribute("planid", planid);
		request.setAttribute("kindid", kindid);
		return new ModelAndView("product/responsibility");
	}

	/**
	 * 进入责任维护修改界面
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "rebupdate")
	public ModelAndView rebUpdate(HttpServletRequest request, Responsibility res) {
		res = productService.getEntity(Responsibility.class, res.getId());
		request.setAttribute("id", res.getId());
		request.setAttribute("productid", res.getProductid());
		request.setAttribute("planid", res.getPlanid());
		request.setAttribute("amount", res.getAmount());
		request.setAttribute("liabilitycode", res.getLiabilitycode());
		request.setAttribute("liability", res.getLiability());
		request.setAttribute("unit", res.getUnit());
		return new ModelAndView("product/responsibility");
	}

	/**
	 * 添加或者更新责任维护
	 * 
	 * @param req
	 * @param product
	 * @return
	 */
	@RequestMapping(params = "aopreb")
	@ResponseBody
	public AjaxJson aopreb(HttpServletRequest req, Responsibility res) {
		logger.info("责任维护:" + res.getLiabilitycode());
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(res.getId())) {
			logger.info("更新责任维护...");
			Responsibility reb = productService.getEntity(Responsibility.class,
					res.getId());
			reb.setAmount(res.getAmount());
			reb.setLiability(res.getLiability());
			reb.setLiabilitycode(res.getLiabilitycode());
			reb.setUnit(res.getUnit());
			reb.setProductid(res.getProductid());
			productService.updateEntitie(reb);
			message = "责任维护更新 成功";
		} else {
			logger.info("添加责任维护...");
			// res.setPlan(plan);
			productService.save(res);
			message = "责任维护:" + res.getLiabilitycode() + "增加 成功";
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 进入险种维护列表界面
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "kindList")
	public ModelAndView kindList(HttpServletRequest request) {
		String planid = request.getParameter("id");
		request.setAttribute("planid", planid);
		String productid = request.getParameter("productid");
		Product product = productService.findUniqueByProperty(Product.class,"id", productid);
		
		Affiliated qaff = new Affiliated();
		qaff.setProductid(productid);
		qaff.setType("1");
		CriteriaQuery cq = new CriteriaQuery(Affiliated.class);		
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq,	qaff);
		cq.add();
		List<Affiliated> affList = productService.getListByCriteriaQuery(cq,true);			
		request.setAttribute("affiliatedReplace",RoletoJson.listToReplaceStr(affList, "description", "id"));
				
		String productname = product.getProductname();
		request.setAttribute("productid", productid);
		request.setAttribute("productname", productname);
		Plan plan = productService.getEntity(Plan.class, planid);
		request.setAttribute("planname", plan.getPlanname());
		return new ModelAndView("product/insuranceKindList");
	}

	/**
	 * easyuiAJAX险种维护列表请求数据
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 */
	@RequestMapping(params = "kinddatagrid")
	public void kinddatagrid(InsuranceKind kind, HttpServletRequest request,
			HttpServletResponse response, DataGrid dataGrid) {
		String planid = request.getParameter("planid");
		String productid = request.getParameter("productid");
		logger.info("用于过滤责任的计划ID：" + planid);
		kind.setProductid(productid);
		kind.setPlanid(planid);
		CriteriaQuery cq = new CriteriaQuery(InsuranceKind.class, dataGrid);
		cq.addOrder("kindcode", SortDirection.asc);
		// 查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq,
				kind);
		cq.add();
		productService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 进入险种维护添加界面
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "addkind")
	public ModelAndView addkind(HttpServletRequest request) {
		String planid = request.getParameter("planid");
		String productid = request.getParameter("productid");		
		Affiliated qaff = new Affiliated();
		qaff.setProductid(productid);
		qaff.setType("1");
		CriteriaQuery cq = new CriteriaQuery(Affiliated.class);		
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq,	qaff);
		cq.add();
		List<Affiliated> affList = productService.getListByCriteriaQuery(cq,true);
		request.setAttribute("affList", affList);		
		request.setAttribute("planid", planid);
		request.setAttribute("productid", productid);
		return new ModelAndView("product/insuranceKind");
	}

	/**
	 * 进入险种维护修改界面
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "kindupdate")
	public ModelAndView kindUpdate(HttpServletRequest request,
			InsuranceKind kind) {
		kind = productService.getEntity(InsuranceKind.class, kind.getId());			
		Affiliated qaff = new Affiliated();
		qaff.setProductid(kind.getProductid());
		qaff.setType("1");
		CriteriaQuery cq = new CriteriaQuery(Affiliated.class);		
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq,	qaff);
		cq.add();
		List<Affiliated> affList = productService.getListByCriteriaQuery(cq,true);
		request.setAttribute("affList", affList);		
		request.setAttribute("id", kind.getId());
		request.setAttribute("productid", kind.getProductid());
		request.setAttribute("planid", kind.getPlanid());
		request.setAttribute("kindcode", kind.getKindcode());
		request.setAttribute("kindname", kind.getKindname());
		request.setAttribute("affiliatedId", kind.getAffiliatedId());
		return new ModelAndView("product/insuranceKind");
	}

	/**
	 * 添加或者更新险种维护
	 * 
	 * @param req
	 * @param kind
	 * @return
	 */
	@RequestMapping(params = "aopkind")
	@ResponseBody
	public AjaxJson aopkind(HttpServletRequest req, InsuranceKind kind) {
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(kind.getId())) {
			logger.info("更新责任维护...");
			InsuranceKind oldKind = productService.getEntity(
					InsuranceKind.class, kind.getId());
			oldKind.setProductid(kind.getProductid());
			oldKind.setKindname(kind.getKindname());
			oldKind.setKindcode(kind.getKindcode());
			oldKind.setAffiliatedId(kind.getAffiliatedId());
			productService.updateEntitie(oldKind);
			message = "险种:" + kind.getKindname() + "更新成功";
		} else {
			logger.info("添加责任维护...");
			// res.setPlan(plan);
			productService.save(kind);
			message = "险种:" + kind.getKindname() + "增加成功";
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 删除险种
	 * 
	 * @param req
	 * @param plan
	 * @return
	 */
	@RequestMapping(params = "delkind")
	@ResponseBody
	public AjaxJson delkind(HttpServletRequest req, InsuranceKind kind) {
		AjaxJson j = new AjaxJson();
		kind = productService.getEntity(InsuranceKind.class, kind.getId());
		message = "险种:" + kind.getKindname() + "被删除 成功";
		productService.delete(kind);
		j.setMsg(this.message);
		return j;
	}

	@RequestMapping(params = "refreshDoc")
	@ResponseBody
	public AjaxJson refreshDoc(HttpServletRequest req, Affiliated aff) {
		AjaxJson j = new AjaxJson();
		Affiliated qaff = new Affiliated();
		qaff.setProductid(aff.getProductid());
		qaff.setType(aff.getType());
		CriteriaQuery cq = new CriteriaQuery(Affiliated.class);
		// 查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq,
				qaff);
		cq.add();
		List<Affiliated> affList = productService.getListByCriteriaQuery(cq,
				true);
		if (affList.size() > 0) {
			for (Affiliated affi : affList) {
				j.setMsg(affi.getDocument());
				j.setObj(affi);
			}
		}
		return j;
	}
}
