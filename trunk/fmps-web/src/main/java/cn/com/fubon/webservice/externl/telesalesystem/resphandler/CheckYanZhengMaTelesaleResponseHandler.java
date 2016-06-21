package cn.com.fubon.webservice.externl.telesalesystem.resphandler;
/**
 * 电销webservice返回处理,获取订单信息
 * @author fangfang.guo
 */

import javax.annotation.Resource;
import org.dozer.Mapper;
import org.jeecgframework.core.common.service.CommonService;
import org.springframework.transaction.annotation.Transactional;
import cn.com.fubon.pay.entity.WeiXinOfflineOrderInfo;
import cn.com.fubon.webservice.entity.request.FbWSRequest;
import cn.com.fubon.webservice.externl.telesalesystem.entity.TelesaleResponse;

@Transactional(rollbackFor=Exception.class)
public class CheckYanZhengMaTelesaleResponseHandler implements TelesaleResponseHandler{
	@Resource
	private Mapper mapper;
	@Resource
	private CommonService commonService;
	
	@Override
	public WeiXinOfflineOrderInfo process(TelesaleResponse telesaleResponse){
			
		//xml报文得到的response对象转成订单对象
		WeiXinOfflineOrderInfo weiXinOfflineOrderInfo = mapper.map(telesaleResponse, WeiXinOfflineOrderInfo.class);
		
		//根据支付码查询数据库中已存在的订单信息
		WeiXinOfflineOrderInfo weiXinOfflineOrderInfoOld = commonService.findUniqueByProperty(
				WeiXinOfflineOrderInfo.class, "payCode", weiXinOfflineOrderInfo.getPayCode());
		
		//根据电销返回的支付码状态更新数据库中的订单支付码状态
		if(weiXinOfflineOrderInfoOld != null){
			weiXinOfflineOrderInfoOld.setPayCodeStatus(weiXinOfflineOrderInfo.getPayCodeStatus());
			commonService.updateEntitie(weiXinOfflineOrderInfoOld);
		}
			
		return weiXinOfflineOrderInfo;
	}

	@Override
	public WeiXinOfflineOrderInfo asyncExecuteprocess(
			TelesaleResponse telesaleResponse) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveSendFailure(FbWSRequest fbWSRequest) {
		// TODO Auto-generated method stub
		
	}

}
