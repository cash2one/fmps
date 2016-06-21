/**
 * 
 */
package cn.com.fubon.fo.drivinggift.controller;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.chain.Context;
import org.apache.log4j.Logger;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.util.ApplicationContextUtil;
import org.jeecgframework.core.util.ResourceUtil;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.core.util.UUIDGenerator;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import weixin.guanjia.account.service.WeixinAccountServiceI;
import weixin.popular.util.JsonUtil;
import cn.com.fubon.bo.wsinvokelog.entity.WsInvokeFailureLog;
import cn.com.fubon.bo.wsinvokelog.service.WsInvokeFailureLogService;
import cn.com.fubon.fo.customerbind.service.CustomerBindService;
import cn.com.fubon.fo.drivinggift.service.DrivingGifeService;
import cn.com.fubon.fo.totaiwan.entity.PolicyRequest;
import cn.com.fubon.microshop.entity.response.PolicyInfoResponse;
import cn.com.fubon.rest.service.impl.RestWebServiceClient;
import cn.com.fubon.util.WebServiceUtils;
import cn.com.fubon.webservice.WsConstants;
import cn.com.fubon.webservice.externl.coresystem.CoreWSConstants;
import cn.com.fubon.webservice.server.WebServiceClientManagementService;
import cn.com.fubon.webservice.server.entity.WebServiceClientManagement;

/**
 * 
 * @author fbxmn07
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/fo/drivingGifeController")
public class DrivingGifeController {
	private static final Logger logger = Logger.getLogger(DrivingGifeController.class);
	
	@Resource
	private DrivingGifeService drivingGifeServiceImpl;
	@Resource
	private WeixinAccountServiceI weixinAccountService;
	@Resource
	private CustomerBindService customerBindService;
	
	public static final String MESSAGE_1 = "抱歉，券已领完！";
	
	/**进入领取E代驾页面
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "initDrivingGift")
	public String initDrivingGift(HttpServletRequest request){
		String huodongid = request.getParameter("huodongid");
		if (StringUtil.isEmpty(huodongid)) {
			huodongid = "8a828ed551604e390151605400f30001";
		}
		String openid = (String) request.getAttribute("openid");
		if (StringUtil.isEmpty(openid)) {
			openid = request.getParameter("openid");
		}
/*		boolean isbind = customerBindService.isBinded(openid);	//是否认证
		if(isbind){*/
			List<Map<String, Object>> giftList = drivingGifeServiceImpl.getIsOverdueList(openid, huodongid);
			if(giftList != null && giftList.size() > 0){ // 券还有且7天之内有领过
				request.setAttribute("giftList", giftList);
				request.setAttribute("amount", giftList.get(0).get("amount"));
				request.setAttribute("externalno", giftList.get(0).get("externalSerialNo"));
				request.setAttribute("huodongid", huodongid);
				request.setAttribute("openid", openid);
				return "/fo/drivinggift/drivingCode";
			} else { //券还有且7天内没领过
				Map<String, Object> mapList = drivingGifeServiceImpl.getDataList(huodongid);
				if(mapList != null && mapList.size() > 0){
					request.setAttribute("huodongid", huodongid);
					request.setAttribute("openid", openid);
					return "/fo/drivinggift/drivingIndex";
				}else{
					logger.info("-------------------------券已领完！");
					request.setAttribute("huodongid", huodongid);
					request.setAttribute("message", MESSAGE_1);
					return "/fo/drivinggift/drivingIndex";
				}
			}
/*		}else{	//跳转认证
			logger.info("-------------------------用户未认证！");
			return "redirect:/fo/customerBindController.do?method=bindIndex&openid="+openid+"";
		}*/
	}
	
	/**
	 * 领取代驾券
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "getDrivingGift")
	public String getDrivingGift(HttpServletRequest request){
		String huodongid = request.getParameter("huodongid");
		String openid = (String) request.getAttribute("openid");
		if (StringUtil.isEmpty(openid)) {
			openid = request.getParameter("openid");
		}
		boolean isbind = customerBindService.isBinded(openid);	//是否认证
		if(isbind){
			List<Map<String, Object>> giftList = drivingGifeServiceImpl.getIsOverdueList(openid, huodongid);
			if(giftList ==null){
					Map<String, Object> mapList = drivingGifeServiceImpl.getDataList(huodongid);
					if(mapList != null && mapList.size() > 0){
						drivingGifeServiceImpl.getAddRecord(openid, (String)mapList.get("id"), huodongid,(mapList.get("amount")).toString());//插入领取记录表中
						request.setAttribute("amount", mapList.get("amount"));
						request.setAttribute("externalno", mapList.get("externalSerialNo"));
						request.setAttribute("huodongid", huodongid);
						request.setAttribute("openid", openid);
					}else{
						logger.info("-------------------------券已领完！");
						request.setAttribute("huodongid", huodongid);
						request.setAttribute("message", MESSAGE_1);
						return "/fo/drivinggift/drivingIndex";
					}
			}else{
				request.setAttribute("amount", giftList.get(0).get("amount"));
				request.setAttribute("externalno", giftList.get(0).get("externalSerialNo"));
				request.setAttribute("huodongid", huodongid);
				request.setAttribute("openid", openid);
			}
		}else{	//跳转认证
			logger.info("-------------------------用户未认证！");
			return "redirect:/fo/customerBindController.do?method=bindIndex&openid="+openid+"&requestPath=fo/drivingGifeController.do?initDrivingGift";
		}
		return "/fo/drivinggift/drivingCode";
	}
	/**
	 * 查询已领取的用户信息
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(params = "getUserInfo")
	@ResponseBody
	public AjaxJson getUserInfo(HttpServletRequest request) throws Exception {
		AjaxJson jsonString = new AjaxJson();
		String huodongid = request.getParameter("huodongid");
		List<Map<String, Object>> userlist = drivingGifeServiceImpl.getUserInfo(huodongid);
		if(userlist !=null && userlist.size() > 0){
			jsonString.setObj(userlist);
		}else{
			jsonString.setMsg("获取数据失败！");
			jsonString.setSuccess(false);
		}
		return jsonString;
	}
	
}
