package weixin.idea.huodong.service.impl;



import java.util.List;

import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import weixin.idea.huodong.entity.PrizeRecordEntity;
import weixin.idea.huodong.service.PrizeRecordServiceI;

@Service("prizeRecordService")
@Transactional
public class PrizeRecordServiceImpl extends CommonServiceImpl implements PrizeRecordServiceI {

	@Override
	public void savePrizeRecord(PrizeRecordEntity prizeRecordEntity) {
		this.save(prizeRecordEntity);
		
	}

	@Override
	public PrizeRecordEntity getPrizeRecord(String hdid, String openid) {
		//0,1,2,3  特等、一等、二等、三等
		String hql =" FROM PrizeRecordEntity prize WHERE prize.hdid=? AND prize.openId= ? AND prize.prize in (0,1,2,3) ";
		List<PrizeRecordEntity> prizeList = this.findHql(hql, hdid,openid);
		return prizeList.size()>0?prizeList.get(0):null;
	}
	
}