package weixin.idea.huodong.controller;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import jodd.datetime.JDateTime;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.util.ResourceUtil;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.web.system.service.SystemService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.com.fubon.fo.cashcoupon.service.CashCouponService;
import cn.com.fubon.fo.customerbind.entity.WeiXinGzUserInfo;
import cn.com.fubon.fo.customerbind.service.CustomerBindService;
import cn.com.fubon.fo.huodong.entity.HuodongRecord;
import cn.com.fubon.fo.huodong.service.LunarNewYearService;
import cn.com.fubon.util.CachedUtils;
import cn.com.fubon.util.Constants;
import weixin.guanjia.account.service.WeixinAccountServiceI;
import weixin.idea.huodong.entity.HdRecordEntity;
import weixin.idea.huodong.entity.HuodongEntity;
import weixin.idea.huodong.entity.PrizeRecordEntity;
import weixin.idea.huodong.service.HdRecordService;
import weixin.idea.huodong.service.HuodongService;
import weixin.idea.huodong.service.PrizeRecordServiceI;
import weixin.idea.huodong.utils.HdUtils;


/**
 * 微信大转盘
* 
 */
@Controller
@RequestMapping("/zpController")
public class ZpController {
	
	private SystemService systemService;
	private String message;
	
	@Resource(name="systemService")
    public void setSystemService(SystemService systemService) {
		this.systemService = systemService;
	}
	
	@Resource
	private HuodongService huodongService;
	@Resource
	private HdRecordService hdRecordService;
	@Resource
	private PrizeRecordServiceI prizeRecordServiceI;
	@Resource
	private WeixinAccountServiceI weixinAccountService;
	@Resource
	private LunarNewYearService lunarNewYearService;
	@Resource
	private CashCouponService cashCouponService;
	@Resource
	private CustomerBindService customerBindService;
	
	
	private static final Logger logger = Logger.getLogger(ZpController.class);
	private String  huodongid="8a828edfedfre68475034fd3dca5799634";	
	
    /**
     * 刮刮乐
     * @param request
     * @return
     */
    @RequestMapping(params="goGglNew")
	public ModelAndView goGglNew(HttpServletRequest request){
//    	String id = request.getParameter("hdId");
    	String opendId = request.getParameter("openId");
    	String accountid = findAccountId(request);
//    	org.jeecgframework.core.util.LogUtil.info("...opendId...."+opendId+"....hdId..."+id);
    	List<HuodongEntity>  hdlst= this.systemService.findByQueryString(" FROM HuodongEntity h WHERE h.accountid='"+accountid+"' AND type=1");
		HuodongEntity huodongEntity = new HuodongEntity();
		if(hdlst.size()!=0){
			huodongEntity = hdlst.get(0);
		}
    	if(huodongEntity!=null){
    		int randomNum = HdUtils.createPrize(huodongEntity,true);
    		//randomNum = 1;
    		request.setAttribute("prize", randomNum);
    		HttpSession session  = request.getSession();
    		session.setAttribute("hdId", huodongEntity.getId());
    		session.setAttribute("accountid", accountid);
    		session.setAttribute("opendId", opendId);
    		session.setAttribute("prize", randomNum);
    		request.setAttribute("huodongEntity", huodongEntity);
    	}
    	
    	return new ModelAndView("weixin/idea/huodong/ggl/ggl");
	}
    
    /**
     * 刮刮乐
     * @param request
     * @return
     */
    @RequestMapping(params="doGgl")
    @ResponseBody
    public AjaxJson doGgl(HttpServletRequest request){
    	Timestamp nowTime = new Timestamp(new java.util.Date().getTime());
    	String message = "";
    	AjaxJson j = new AjaxJson();
    	HttpSession session = request.getSession();
		String hdId = session.getAttribute("hdId").toString();
		String openId = session.getAttribute("opendId").toString();
		String accountid = findAccountId(request);
    	String hql = "from HdRecordEntity where hdid='"+hdId+"' and opendid='"+openId+"'";
    	if(StringUtil.isNotEmpty(accountid)){
			hql+=" and accountid='"+accountid+"'";
		}else{
			hql+=" and accountid='-'";
		}
		List<HdRecordEntity> hdRecrdList = this.systemService.findHql(hql, null);
		if(hdRecrdList.size()>0){
			HdRecordEntity hdRecord = hdRecrdList.get(0);
			int total = hdRecord.getTotal();
			org.jeecgframework.core.util.LogUtil.info("....total...."+total);
			HuodongEntity huodongEntitiy = this.systemService.getEntity(HuodongEntity.class, hdId);
			if(total<Integer.parseInt(huodongEntitiy.getCount())){
				String hql1 = "from PrizeRecordEntity where hdid='"+hdId+"' and openId='"+openId+"'";
				if(StringUtil.isNotEmpty(accountid)){
					hql1+=" and accountid='"+accountid+"'";
				}else{
					hql1+=" and accountid='-'";
				}
				List<PrizeRecordEntity> prizeList = this.systemService.findByQueryString(hql1);
				if(prizeList.size()>0){
					j.setSuccess(false);
					message = "对不起本次活动你已经中奖，不能在抽奖！";
				}else{
					j.setSuccess(true);
					hdRecord.setTotal(total+1);
					this.systemService.updateEntitie(hdRecord);
				}
			}else{
				j.setSuccess(false);
				message = "对不起您已经抽奖"+total+"次，不能在抽奖！";
			}
		}else{
			HdRecordEntity hdRecord = new HdRecordEntity();
			hdRecord.setAddtime(nowTime);
			hdRecord.setHdid(hdId);
			hdRecord.setOpendid(openId);
			hdRecord.setTotal(1);
			hdRecord.setNickname("");
			hdRecord.setAccountid(accountid);
			this.systemService.save(hdRecord);
		}
		org.jeecgframework.core.util.LogUtil.info(message);
		j.setMsg(message);
	    return j;
    }
    
    /**
	 * 保存刮刮乐抽奖记录和中奖记录
	 * @return
	 */
	@RequestMapping(params = "saveRecord")
	@ResponseBody
	public AjaxJson saveRecord(HttpServletRequest request) {
		
		AjaxJson j = new AjaxJson();
		HttpSession session = request.getSession();
		String mobile = request.getParameter("mobile");
		Object hdIdObj = session.getAttribute("hdId");
		Object opendIdObj = session.getAttribute("opendId");
		Object prizeObj =  session.getAttribute("prize");
		String accountid = findAccountId(request);
		String prize = "";
		String hdId = "";
		String opendId = "";
		if(prizeObj!=null){
			prize = prizeObj.toString();
		}
		
		if(hdIdObj!=null){
			hdId = hdIdObj.toString();
		}
		
		if(opendIdObj!=null){
			opendId = opendIdObj.toString();
		}
		Timestamp nowTime = new Timestamp(new java.util.Date().getTime());
		org.jeecgframework.core.util.LogUtil.info("....prize...."+prize);
		if("1".equals(prize)||"2".equals(prize)||"3".equals(prize)){
			PrizeRecordEntity prizeEntity = new PrizeRecordEntity();
			prizeEntity.setHdid(hdId);
			prizeEntity.setPrize(prize);
			prizeEntity.setMobile(mobile);
			prizeEntity.setAddtime(nowTime);
			prizeEntity.setOpenId(opendId);
			prizeEntity.setAccountid(accountid);
			this.systemService.save(prizeEntity);
		}
		
		return j;
	}
	
	
	/**
	 * 进入大转盘页面
	 * @param request
	 * @return
	 */
	@RequestMapping(params="goTurnplate")
	public ModelAndView goTurnplate(HttpServletRequest request,String productId){
		String from = request.getParameter("from");
		if(StringUtils.isNotEmpty(from)){
			return new ModelAndView("redirect:/fo/lunarNewYearController.do?huodongMain");
		}
		String openid = (String) request.getAttribute("openid");
		if (StringUtil.isEmpty(openid)) {
			openid = request.getParameter("openid");
		}
		WeiXinGzUserInfo weiXinGzUserInfo = customerBindService
				.findUniqueByProperty(WeiXinGzUserInfo.class, "openid", openid);
		//资料不完善，未参加过此活动，跳转到资料填写页面
		if ( !isDataWritten(request,openid) ) {
			request.setAttribute("productId", productId);
			request.setAttribute("openid", openid);
			request.setAttribute("weiXinGzUserInfo", weiXinGzUserInfo);
			return new ModelAndView( "/fo/huodong/lunarnewyear/writeUserData");
		}
		//中奖记录
		PrizeRecordEntity prizeRecord =  prizeRecordServiceI
				.getPrizeRecord(huodongid,openid);
		String prize = prizeRecord == null ? null :prizeRecord.getPrize();
		BigDecimal amount=lunarNewYearService.getAmount( huodongid, openid);
		amount =  amount == null ? new BigDecimal(0):amount;
		int drawRecordCount = huodongService.drawRecordCount(openid,huodongid);
		int tempCount = amount.intValue()/10000;
		tempCount = tempCount > 10 ? 10 : tempCount;
		//获取当前用户抽奖次数（保额/10000-已经抽过的次数）最大10次
		int drowCount = tempCount-drawRecordCount;
		
		HuodongEntity huodongEntity = systemService.getEntity(HuodongEntity.class, huodongid);
		request.setAttribute("hdEntity", huodongEntity);
		request.setAttribute("hdId", huodongid);
		request.setAttribute("openid", openid);
		request.setAttribute("drowCount", drowCount);
		request.setAttribute("prize", prize);
		request.setAttribute("amount", amount);
		request.setAttribute("drawRecordCount", drawRecordCount);
		logger.info("....hdid...."+huodongid+"...openId.."+openid);
		return new ModelAndView("weixin/idea/huodong/zp/zhuanpan");
	}
	
    /**
	 * 大转盘抽奖(
	 * 1.已中奖用户如果再中奖了，会被设置成未中奖，不会重复中奖；
	 * 2.抽奖次数=保额/10000-已经抽过的次数，保额超过10万，按10万计算
	 * 3.用户第一次没中奖，发送贺卡提醒
	 * )
	 * @return
	 */
	@RequestMapping(params = "getTurnplatePrize")
	@ResponseBody
	public AjaxJson getTurnplatePrize(HttpServletRequest request,String hdId) {
		//抽奖结果
		AjaxJson result = new AjaxJson();
		
		String openid = (String) request.getAttribute("openid");
		if (StringUtil.isEmpty(openid)) {
			openid = request.getParameter("openid");
		}
		String accountid = findAccountId(request);
		
		Map<String,Object> returnParams = new HashMap<String, Object>();
		if(StringUtil.isNotEmpty(hdId) && StringUtil.isNotEmpty(openid)){
			//活动规则
			HuodongEntity hdEntity = this.systemService.getEntity(HuodongEntity.class, hdId);
			BigDecimal amount=lunarNewYearService.getAmount( huodongid, openid);
			int drawRecordCount = huodongService.drawRecordCount(openid,huodongid);
			//获取当前用户抽奖次数（保额/10000-已经抽过的次数）
			int total = amount.intValue()/10000-drawRecordCount;
			//int total = 10;		//for test
			//抽奖活动是否过期   true:过期
			boolean isExpired = activityExpired(hdEntity);
			
			if(hdEntity!=null && total > 0 && !isExpired){
	    		boolean canWinPrize = true;
	    		//查询是否能中奖（1、奖品还有 2、没中奖）
	    		canWinPrize = huodongService.canWinPrize(openid, hdId);
	    		//根据设置的概率进行抽奖
	    		int prizetype = HdUtils.createPrize(hdEntity,canWinPrize);
	    		logger.info("canWinPrize============>"+canWinPrize
	    				+"=====firstPrize====="+CachedUtils.incr(Constants.ONE_TOTAL_DRAW + huodongid,0));
	    		returnParams.put("prizetype", prizetype);
	    		
	    		PrizeRecordEntity prizeEntity = new PrizeRecordEntity();
	    		prizeEntity.setHdid(hdId);
	    		if(prizetype > Constants.PRIZE_RANK_THIRD){
	    			prizeEntity.setPrize(Constants.PRIZE_RANK_OTHER);
	    		}else if(prizetype == Constants.PRIZE_RANK_SUPER){
	    			prizeEntity.setPrize(prizetype+"");
	    		}else{
	    			String[] amountArr = {"2000","1000","500"};	//1  2  3等奖对应奖金
	    			cashCouponService.saveCouponRecord(amountArr[prizetype-1],hdId,openid);
	    			prizeEntity.setPrize(prizetype+"");
	    			
	    		}
	    		prizeEntity.setMobile("");
	    		prizeEntity.setAddtime(new Timestamp(new java.util.Date().getTime()));
	    		prizeEntity.setOpenId(openid);
	    		prizeEntity.setAccountid(accountid);
	    		prizeRecordServiceI.save(prizeEntity);
			}else if(total <=0 ){
				result.setSuccess(false);
				returnParams.put("error", "exhaust");
			}else if(isExpired){
				result.setSuccess(false);
				returnParams.put("error", "expired");
			}
		}
		result.setAttributes(returnParams);
		return result;
	}
	
	/**
	 * 保存大转盘的中奖记录(old method)
	 * @return
	 */
	@RequestMapping(params = "saveZpPrize")
	@ResponseBody
	public AjaxJson saveZpPrize(HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		String mobile = request.getParameter("mobile");
		HttpSession session = request.getSession();
		Object hdIdObj = session.getAttribute("hdId");
		Object openIdObj = session.getAttribute("openId");
		Object prizeObj = session.getAttribute("prize");
		String hdId = "",openId="",prize="",accountid="";
		accountid = findAccountId(request);
		if(hdIdObj!=null){
			hdId = hdIdObj.toString();
		}
		if(openIdObj!=null){
			openId = openIdObj.toString();
		}
		if(prizeObj!=null){
			prize = prizeObj.toString();
		}
		Timestamp nowTime = new Timestamp(new java.util.Date().getTime());
		PrizeRecordEntity prizeEntity = new PrizeRecordEntity();
		prizeEntity.setHdid(hdId);
		prizeEntity.setPrize(prize);
		prizeEntity.setMobile(mobile);
		prizeEntity.setAddtime(nowTime);
		prizeEntity.setOpenId(openId);
		prizeEntity.setAccountid(accountid);
		this.systemService.save(prizeEntity);
		return j;
	}
	
	/**
	 * 获取微信公众账号ID
	 * @return
	 */
	@SuppressWarnings("unused")
	private String findAccountId(HttpServletRequest request){
		//非法请求，直接返回
		if(request == null){
			return "";
		}
		//request请求中拿到accountid,直接返返回，如果拿不到。则从上下文中获取
		String accountid = request.getParameter("accountid");
		if(accountid != null && !"".equals(accountid)){
			return accountid;
		}else{
			return ResourceUtil.getWeiXinAccountId();
		}
	}
    
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	/**
	 * 如果表中没有该用户参加本活动，往活动参加记录表中添加记录
	 * @return
	 */
	private void insertIntoHdRecordIfNotExist(HuodongEntity hdEntity,String openid){
		List<HdRecordEntity> hdRecrdList = hdRecordService
				.findHdRecordByhdId(huodongid, openid);
		if(hdRecrdList.size() == 0){
			HdRecordEntity hdRecordEntity = new HdRecordEntity();
			hdRecordEntity.setAccountid(hdEntity.getAccountid());
			hdRecordEntity.setAddtime(new Timestamp(new java.util.Date().getTime()));
			hdRecordEntity.setHdid(huodongid);
			hdRecordEntity.setOpendid(openid);
			hdRecordEntity.setNickname("");
			hdRecordService.saveHdRecord(hdRecordEntity);
		}
	}
	
	/**
	 * 判断活动是否过期  false:未过期   true:过期
	 * @return
	 */
	private boolean activityExpired(HuodongEntity hdEntity){
		JDateTime now = new JDateTime();
		if(now.getTimeInMillis() >= hdEntity.getStarttime().getTime() 
				&& now.getTimeInMillis() <= hdEntity.getEndtime().getTime()){
			return false;
		}
		return true;
	}
	//判断是否已经参加活动、用户姓名、身份证号、手机号是否都填写了
	private boolean isDataWritten(HttpServletRequest request,String  openid){
		HuodongRecord  huodongRecord=lunarNewYearService.getHuodongRecord(huodongid,openid);
		//判断是否已参加活动
		if(huodongRecord == null){
			return false;
		}
		//判断资料是否填写完整
		if(!StringUtil.isNotEmpty(huodongRecord.getCustomercname()) 
				|| !StringUtil.isNotEmpty(huodongRecord.getIdentifynumber()) 
				|| !StringUtil.isNotEmpty(huodongRecord.getPhonenum())){
			return false;
		}
		return true;
	}
}