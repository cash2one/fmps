package weixin.idea.huodong.service;

import java.util.List;

import org.jeecgframework.core.common.service.CommonService;

import weixin.idea.huodong.entity.HdRecordEntity;


public interface HdRecordService extends CommonService{
	/**
	 * 根据hdId,openId查找参加活动记录
	 * 
	 * @param hdId,openId
	 * @return
	 */
	public List<HdRecordEntity> findHdRecordByhdId(String hdId,String openId);
	
	public void saveHdRecord(HdRecordEntity hdRecordEntity);
	
	/**
	 * 根据hdId,查找参加活动人数
	 * 
	 * @param hdId
	 * @return
	 */
	public long getPeopleCount(String hdid);
	
	
}
