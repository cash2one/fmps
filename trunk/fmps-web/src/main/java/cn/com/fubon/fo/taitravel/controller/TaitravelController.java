package cn.com.fubon.fo.taitravel.controller;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;

import org.apache.log4j.Logger;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.extend.datasource.DataSourceContextHolder;
import org.jeecgframework.core.extend.datasource.DataSourceType;
import org.jeecgframework.core.util.ResourceUtil;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.tag.vo.datatable.SortDirection;
import org.jeecgframework.web.system.service.SystemService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import weixin.guanjia.account.entity.WeixinAccountEntity;
import weixin.guanjia.account.service.WeixinAccountServiceI;
import weixin.guanjia.core.util.WeixinUtil;
import weixin.util.JsSdkUtil;
import cn.com.fubon.fo.card.service.ICustomerService;
import cn.com.fubon.fo.taitravel.entity.PreinsuredPolicy;
import cn.com.fubon.fo.taitravel.entity.SchemeAddress;
import cn.com.fubon.fo.taitravel.entity.StuPolicy;
import cn.com.fubon.fo.taitravel.service.IPreinsuredPolicyService;
import cn.com.fubon.fo.taitravel.service.IStuPolicyService;
import cn.com.fubon.fo.taitravel.service.StuWechatPayService;
import cn.com.fubon.pay.service.OfflineWechatPayService;
import cn.com.fubon.product.entity.AddressCode;
import cn.com.fubon.product.service.IAddressCodeService;

/**
 * 赴台旅游控制器
 * 
 * @author 郭俊杰
 * 
 */
@Scope("prototype")
@Controller
@RequestMapping("/fo/taitravelController")
public class TaitravelController {
	private Logger log = Logger.getLogger(TaitravelController.class);

	@Resource
	private ICustomerService customerService;

	@Resource
	private WeixinAccountServiceI weixinAccountService;
	@Resource
	private IStuPolicyService stupolicyService;
	@Resource
	private SystemService systemService;
	@Resource
	private StuWechatPayService wechatPayService;
	@Resource
	private IAddressCodeService addressCodeService;
	@Resource
	private OfflineWechatPayService offlineWechatPayService;

	@Resource
	private IPreinsuredPolicyService preinsuredPolicyService;

	private static final Logger logger = Logger
			.getLogger(TaitravelController.class);

	/**
	 * 赴台旅游初始化方法
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "indexTaitravel")
	public String indexTtravel(HttpServletRequest request) {
		String openid;
		String openidParameter = request.getParameter("openid");
		String openidAttribute = (String) request.getAttribute("openid");
		String code = request.getParameter("code");
		logger.info("code=>" + code);
		if (StringUtil.isEmpty(openidParameter)) {
			openid = openidAttribute;
		} else {
			openid = openidParameter;
		}
		if (StringUtil.isEmpty(openid)) {			
			List<WeixinAccountEntity> weixinAccountEntityList = weixinAccountService
					.findValidWeixinAccounts();
			WeixinAccountEntity weixinAccountEntity = weixinAccountEntityList
					.get(0);
			openid = WeixinUtil.getOpenId(
					weixinAccountEntity.getAccountappid(),
					weixinAccountEntity.getAccountappsecret(), code);

			logger.info("根据code获取 openid,获取到的openid=>" + openid);
		}
		request.getSession().setAttribute("openid", openid);

		String accessToken = weixinAccountService
				.getAccessTokenFromAccountEntity();
		List<WeixinAccountEntity> weixinAccountEntityList = weixinAccountService
				.findValidWeixinAccounts();
		WeixinAccountEntity weixinAccountEntity = weixinAccountEntityList
				.get(0);
		String appid = weixinAccountEntity.getAccountappid();
		String URL = ResourceUtil.getDomain() + request.getServletPath() + "?"
				+ request.getQueryString();
		logger.info("jssdkPage url ===>" + URL);
		JsSdkUtil JsSdkUtil = new JsSdkUtil(URL, appid, accessToken);
		String JSONString = JsSdkUtil.getWxConfigJSONString();
		// 获取所有的省份信息并传到前台
		List<AddressCode> addressCodes = addressCodeService
				.loadAll(AddressCode.class);

		// map.put("addressCodes", addressCodes);
		JSONArray json = JSONArray.fromObject(addressCodes);
		request.setAttribute("json", json);
		request.setAttribute("JSONString", JSONString);
		request.setAttribute("openid", openid);
		return "fo/taitravel/taitravelindex";
	}

	/**
	 * 赴台旅游方案选择页面
	 * 
	 * @param request
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping(params = "taitravelInfo")
	public String taitravelInfo(HttpServletRequest request)
			throws UnsupportedEncodingException {
		/*String schemetype = request.getParameter("schemetype");
		schemetype = new String(schemetype.getBytes("ISO-8859-1"), "UTF-8");
		String period = request.getParameter("period");
		period = new String(period.getBytes("ISO-8859-1"), "UTF-8");
		String premium = request.getParameter("premium");
		premium = new String(premium.getBytes("ISO-8859-1"), "UTF-8");*/
		String openid = request.getParameter("openid");
		String insuredIdentifytype = request
				.getParameter("insuredIdentifytype"); //
		String insuredIdentifynumber = request
				.getParameter("insuredIdentifynumber"); //
		String insuredName = request.getParameter("insuredName"); // 被保人名字
		String insuredNameZ = "";
		if (insuredName != null) {
			insuredNameZ = java.net.URLDecoder.decode(insuredName, "UTF-8");
		}
		String insuredPhone = request.getParameter("insuredPhone"); //
		String city = request.getParameter("cityCode"); //
		String province = request.getParameter("provinceCode"); //
		String area = request.getParameter("areaCode"); //
		String detail = request.getParameter("detial"); //

		String school = request.getParameter("insuredSchool"); //


		SchemeAddress schemeAddress = new SchemeAddress();
		schemeAddress.setProvince(province);

		CriteriaQuery cq = new CriteriaQuery(SchemeAddress.class);
		// 查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq,
				schemeAddress);
		cq.addOrder("period", SortDirection.desc);
		cq.add();
		List<SchemeAddress> schemeAddressList = preinsuredPolicyService
				.getListByCriteriaQuery(cq, true);

		if (schemeAddressList.size() > 0) {
			request.setAttribute("schemeAddressList", schemeAddressList);
		}
		request.setAttribute("name", insuredName);
		request.setAttribute("identifytype", insuredIdentifytype);
		request.setAttribute("identifynumber", insuredIdentifynumber);
		request.setAttribute("phone", insuredPhone);
		request.setAttribute("school", school);
		request.setAttribute("province", province);
		request.setAttribute("city", city);
		request.setAttribute("area", area);
		request.setAttribute("detail", detail);

		//request.setAttribute("schemetype", schemetype);
		//request.setAttribute("period", period);
		//request.setAttribute("premium", premium);
		request.setAttribute("openid", openid);
		return "fo/taitravel/taitravelinfo";

	}

	/**
	 * 投保预约页面
	 * 
	 * @param request
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping(params = "preinsuredIndex")
	public String preinsuredIndex(HttpServletRequest request) {
		String openid;
		String openidParameter = request.getParameter("openid");
		String openidAttribute = (String) request.getAttribute("openid");
		String code = request.getParameter("code");
		logger.info("code=>" + code);
		if (StringUtil.isEmpty(openidParameter)) {
			openid = openidAttribute;
		} else {
			openid = openidParameter;
		}
		if (StringUtil.isEmpty(openid)) {

			DataSourceContextHolder
					.setDataSourceType(DataSourceType.dataSource_jeecg);
			List<WeixinAccountEntity> weixinAccountEntityList = weixinAccountService
					.findValidWeixinAccounts();
			WeixinAccountEntity weixinAccountEntity = weixinAccountEntityList
					.get(0);
			openid = WeixinUtil.getOpenId(
					weixinAccountEntity.getAccountappid(),
					weixinAccountEntity.getAccountappsecret(), code);
			logger.info("根据code获取 openid,获取到的openid=>" + openid);
		}
		request.getSession().setAttribute("openid", openid);
		return "fo/taitravel/preinsuredIndex";
	}

	/**
	 * 保存投保预约信息
	 * 
	 * @param request
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping(params = "savePreinsured")
	public String savePreinsured(HttpServletRequest request) {
		String block = request.getParameter("block"); //
		String name = request.getParameter("name"); //
		String telephone = request.getParameter("phone"); //
		String openid = request.getParameter("openid"); //
		PreinsuredPolicy ppreinsuredPolicy = new PreinsuredPolicy();
		ppreinsuredPolicy.setName(name);
		ppreinsuredPolicy.setTelephone(telephone);
		ppreinsuredPolicy.setOpenid(openid);

		CriteriaQuery cq = new CriteriaQuery(PreinsuredPolicy.class);
		// 查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq,
				ppreinsuredPolicy);
		cq.add();
		List<PreinsuredPolicy> preinsuredPolicyList = preinsuredPolicyService
				.getListByCriteriaQuery(cq, true);
		String message = null;
		if (preinsuredPolicyList.size() > 0) {
			PreinsuredPolicy preinsuredPolicy = preinsuredPolicyList.get(0);

			if (preinsuredPolicy != null) {
				Date date = preinsuredPolicy.getCreatetime();
				String dateStr = new SimpleDateFormat("yyyy-MM-dd")
						.format(date);
				String[] dataStrr = dateStr.split("-");
				message = "您已经于" + dataStrr[0] + "年" + dataStrr[1] + "月"
						+ dataStrr[2] + "日完成预约，请勿重复预约，如有疑问请联系客服电话4008-817-518。";
			}

		} else {
			PreinsuredPolicy preinsuredPolicyy = new PreinsuredPolicy();
			preinsuredPolicyy.setCreatetime(new Date());
			preinsuredPolicyy.setName(name);
			preinsuredPolicyy.setTelephone(telephone);
			preinsuredPolicyy.setBlock(block);
			preinsuredPolicyy.setOpenid(openid);
			preinsuredPolicyService.saveOrUpdate(preinsuredPolicyy);
			message = "恭喜，您已预约成功。我司人员后续会主动联系您";
		}
		request.setAttribute("message", message);
		return "/fo/common/message";

	}

}
