package cn.com.fubon.pay.service.impl;

import java.util.List;

import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import weixin.popular.bean.paymch.UnifiedorderResult;
import cn.com.fubon.pay.service.WechatUnifiedOrderResult;

@Service("wechatUnifiedOrderResultImpl")
@Transactional
public class WechatUnifiedOrderResultImpl   extends CommonServiceImpl   implements WechatUnifiedOrderResult   {

  public List<UnifiedorderResult> getEntityByOutTradeNo(String out_trade_no){	  
	  
	  return  this.findByProperty(UnifiedorderResult.class, "out_trade_no", out_trade_no);
  }
	
	
}
