package weixin.idea.huodong.service;

import java.util.List;

import org.jeecgframework.core.common.service.CommonService;

import weixin.idea.huodong.entity.HuodongEntity;

public interface HuodongService extends CommonService{
	/**
	 * 根据accountid查找活动
	 * 
	 * @param accountid
	 * @return
	 */
	public List<HuodongEntity> findHuodongByAccountid(String accountid);
	/**
	 * 根据openid,hdid获取已抽奖次数
	 * 
	 * @param openid,hdid
	 * @return
	 */
	public int drawRecordCount(String openid,String hdid);
	/**
	 * 根据openid,hdid获取抽奖次数
	 * 
	 * @param openid,hdid
	 * @return
	 */
	public boolean canWinPrize(String openid,String hdid);

}
