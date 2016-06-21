package cn.com.fubon.fo.gasolinegift.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import jodd.datetime.JDateTime;

import org.apache.commons.chain.Context;
import org.apache.log4j.Logger;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.jeecgframework.core.util.ResourceUtil;
import org.jeecgframework.core.util.UUIDGenerator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import weixin.popular.util.JsonUtil;
import cn.com.fubon.fo.gasolinegift.dao.IGsolineGiftDao;
import cn.com.fubon.fo.gasolinegift.entity.OilcardOrganization;
import cn.com.fubon.fo.gasolinegift.service.IGasolineGiftService;
import cn.com.fubon.rest.entity.Organization;
import cn.com.fubon.rest.entity.request.GasolineGiftCarRequest;
import cn.com.fubon.rest.entity.request.GasolineGiftOrgListRequest;
import cn.com.fubon.rest.entity.request.GasolineGiftQueryRequest;
import cn.com.fubon.rest.entity.response.GasolineGiftCarResponse;
 
import cn.com.fubon.rest.entity.response.GasolineGiftOrgListResponse;
import cn.com.fubon.rest.entity.response.GasolineGiftQueryResponse;
import cn.com.fubon.rest.service.impl.RestWebServiceGasolineGiftClient;
import cn.com.fubon.webservice.WsConstants;

/**
 * 加油宝service接口实现
 * @author yaoming.zhang
 * 2015-08-26
 */

@Service("gasolineGifService")
@Transactional
public class GasolineGiftServiceImpl extends CommonServiceImpl implements IGasolineGiftService {
	private static final Logger logger = Logger.getLogger(GasolineGiftServiceImpl.class);
	@Resource
	public IGsolineGiftDao gsolineGifDao;	
	@Resource
	private RestWebServiceGasolineGiftClient getGasolineGiftOrganization;	
	@Resource
	private RestWebServiceGasolineGiftClient getGasolineGiftCar;
	@Resource
	private RestWebServiceGasolineGiftClient queryGasolineGiftCar;
	@Resource
	private RestWebServiceGasolineGiftClient queryByDayGasolineGiftCar;

	/**
	 * 通过openid查询该用户领取加油宝数量
	 */
	@Override
	public boolean getGasolineGiftByOpenid(String openid) {
		Integer size = this.gsolineGifDao.getGasolineGiftByOpenid(openid);
		return size > 0 ? true : false;
	}
	
	/**
	 * 通过openid获取加油宝邀请码
	 */
	@Override
	public Map<String, Object> getMyGasolineGiftDetailByOpenid(String openid) {
		return this.gsolineGifDao.getMyGasolineGiftDetailByOpenid(openid);
	}
	
	
	/**
	 * 申请加油宝邀请码
	 */
	public boolean applyMyGasolinegift(String openid,String giftid) {
		Integer size = this.gsolineGifDao.applyMyGasolinegift(openid,giftid);
		return size > 0 ? true : false;
	}
	
	/**
	 * 保存领取信息
	 * 
	 * @param openid
	 * @param giftid
	 * @param address
	 * @param mobile
	 * @param getStatus
	 * @param licenseno
	 */
	@Override
	public void addGasolineGift(String openid, String giftid, String address,
			String mobile, String getStatus, String receiveAddress, String licenseno,String username) {
		this.gsolineGifDao.addGasolineGift(openid, giftid, address, mobile, getStatus, receiveAddress, licenseno,username);
	}
	
	
    public	List<Map<String, Object>>  queryMysqlCarLicensenoList(String openid){
    	    String sql="select ft.licenseno as licenseno  from  weixin_gasolinegift  ft where ft.openid=?";   
       	 return this.findForJdbc(sql, openid);
    	
    }  
    
    public GasolineGiftCarResponse   sendRegisterMessage(GasolineGiftCarRequest  gasolineGiftCarRequest){    	 
    	String gasolineGiftCarRequestJson = JsonUtil.toJSONString(gasolineGiftCarRequest);
    	 Context context=null;
		 logger.info("发送的json=== " + gasolineGiftCarRequestJson);
		 try {
			   context=getGasolineGiftCar.startExecuteChain(gasolineGiftCarRequestJson);
		} catch (Exception e) {
			logger.info("发送的报文申请加油宝卡失败 :" +  e); 
		}
		String responeJson=(String) context.get(WsConstants.RESPONSEJSON);	
		GasolineGiftCarResponse gasolineGiftCarResponse = JsonUtil.parseObject(responeJson,	GasolineGiftCarResponse.class);
    	return gasolineGiftCarResponse ;    	
    }
    
    public GasolineGiftQueryResponse   queryOilCarApplyStatus(GasolineGiftQueryRequest  gasolineGiftQueryRequest){    	 
    	String gasolineGiftQueryRequestJson = JsonUtil.toJSONString(gasolineGiftQueryRequest);
    	 Context context=null;
		 logger.info("发送的json=== " + gasolineGiftQueryRequestJson);
		 try {
			   context=queryGasolineGiftCar.startExecuteChain(gasolineGiftQueryRequestJson);
		} catch (Exception e) {
			logger.info("发送的报文查询加油宝卡状态失败 :" +  e); 
		}
		String responeJson=(String) context.get(WsConstants.RESPONSEJSON);	
		GasolineGiftQueryResponse gasolineGiftQueryResponse = JsonUtil.parseObject(responeJson,	GasolineGiftQueryResponse.class);
    	return gasolineGiftQueryResponse ;    	
    }
    
    public String getOrgCode(String orgName){    	
    	String orgCode="";    	 
    	List<OilcardOrganization>  oilcardOrganizationList=this.findByProperty(OilcardOrganization.class, "orgName", orgName);
    	if(oilcardOrganizationList.size()>0){
    		orgCode=oilcardOrganizationList.get(0).getOrgCode();
    	}else{    	
		JDateTime jnow = new JDateTime(new Date());
	    String reqTime	=jnow.toString("YYYYMMDDhhmmss");
	    String merId = ResourceUtil.getBundleEnvAbout().getString("oilcardmerId");		     
		GasolineGiftOrgListRequest gasolineGiftOrgListRequest =new GasolineGiftOrgListRequest(UUIDGenerator.generate(),merId,reqTime);
		String gasolineGiftOrgListRequestJson = JsonUtil.toJSONString(gasolineGiftOrgListRequest);
		Context context=null;
		logger.info("发送的json=== " + gasolineGiftOrgListRequestJson);
		 try {
			   context=getGasolineGiftOrganization.startExecuteChain(gasolineGiftOrgListRequestJson);
		} catch (Exception e) {
			logger.info("发送的报文申请加油宝卡失败 :" +  e); 
		}
		String responeJson=(String) context.get(WsConstants.RESPONSEJSON);	
		GasolineGiftOrgListResponse gasolineGiftOrgListResponse = JsonUtil.parseObject(responeJson,	GasolineGiftOrgListResponse.class);
		if("0000".equals(gasolineGiftOrgListResponse.getRespCode())&&gasolineGiftOrgListResponse.getOrgList().size()>0){
			this.executeSql("delete from weixin_oilcard_organization");			
			for(Organization organization: gasolineGiftOrgListResponse.getOrgList()){
				OilcardOrganization oilcardOrganization=new OilcardOrganization();
				oilcardOrganization.setOrgCode(organization.getCode());
				oilcardOrganization.setOrgName(organization.getName());
				oilcardOrganization.setUpdateTime(new Date());				
				this.save(oilcardOrganization);
				if(organization.getName().equals(orgName)) {
					orgCode=organization.getCode();	
				}
		    }
		}	
		}
	return orgCode;		
	}
    	
    	
	
}
