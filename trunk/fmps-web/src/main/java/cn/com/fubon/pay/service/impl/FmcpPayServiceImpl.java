package cn.com.fubon.pay.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.jeecgframework.core.common.dao.impl.GenericBaseCommonDao;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import weixin.popular.bean.pay.PayNotify;
import weixin.popular.bean.paymch.Unifiedorder;
import weixin.popular.bean.paymch.UnifiedorderExp;
import cn.com.fubon.pay.service.FmcpPayService;
import cn.com.fubon.pay.service.OfflineWechatPayService;

@Service("fmcpPayService")
@Transactional
public class FmcpPayServiceImpl extends CommonServiceImpl implements
FmcpPayService   {	
	public boolean isUnifiedOrder(String userPayCode){		
		List<UnifiedorderExp>  unifiedordeList=this.findByProperty(UnifiedorderExp.class,"userPayCode",userPayCode);
		return unifiedordeList.size()>0 ? true :false ;			
	}	
	public boolean isPaid(String userPayCode ){		
		String SQL="select  ty.*  from  weixin_unifiedorder  de ,weixin_notify ty where de.out_trade_no=ty.out_trade_no and de.userPayCode= ?";		
		 List<Map<String, Object>>  payNotifyList=this.findForJdbc(SQL,userPayCode);		
		return payNotifyList.size()>0 ? true :false;		 
	}
	
	public String getTotalFee(String userPayCode ){		
		String SQL="select  ty.total_fee  from  weixin_unifiedorder  de ,weixin_notify ty where de.out_trade_no=ty.out_trade_no and de.userPayCode=?";			  	
		List<Map<String, Object>> totalFeeList=   this.findForJdbc(SQL,userPayCode);		
		return (String) totalFeeList.get(0).get("total_fee");		
	}	
	
	public PayNotify getPayNotify(String outTradeNo) {
		List<PayNotify>  payNotifyList=this.findByProperty(PayNotify.class,"out_trade_no",outTradeNo);
		return payNotifyList.get(0);
	}	
	public  List<Map<String, Object>>  getUnifiedOrderlist(String userPayCode){		
		String SQL="select  de.*  from  weixin_unifiedorder  de ,weixin_unifiedorderresult lt where de.out_trade_no=lt.out_trade_no and de.userPayCode=?";		
		  return    this.findForJdbc(SQL,userPayCode);		
	}
}
