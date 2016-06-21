package weixin.idea.huodong.service;



import org.jeecgframework.core.common.service.CommonService;

import weixin.idea.huodong.entity.PrizeRecordEntity;


public interface PrizeRecordServiceI extends CommonService{
	
	public void savePrizeRecord(PrizeRecordEntity prizeRecordEntity);
	
	public PrizeRecordEntity getPrizeRecord(String hdid,String openid);

}
