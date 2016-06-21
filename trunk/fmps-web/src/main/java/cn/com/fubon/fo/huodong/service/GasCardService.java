/**
 * 
 */
package cn.com.fubon.fo.huodong.service;

import java.util.List;
import java.util.Map;

import org.jeecgframework.core.common.service.CommonService;

import weixin.idea.huodong.entity.HuodongEntity;

/**
 * @author qingqu.huang
 *
 */
public interface GasCardService extends CommonService {

	/**
	 * 判断是否在活动区间
	 * 
	 * @param huodongEntity
	 * @return
	 */
	public boolean isRangeOfDate(HuodongEntity huodongEntity);

	/**
	 * 保存帮抢记录
	 * 
	 * @param openid
	 * @param sponsor
	 */
	public void saveGasCardRecord(String openid, String sponsor,
			String huodongid);

	/**
	 * 判断是否已经帮抢过
	 * 
	 * @param openid
	 *            帮抢人openid
	 * @param sponsor
	 *            发起人openid
	 * @param huodongid
	 *            活动编号
	 * @return
	 */
	public boolean isHelped(String openid, String sponsor, String huodongid);

	/**
	 * 查询排行榜前100名
	 * 
	 * @param huodongid
	 * @return
	 */
	public List<Map<String, Object>> getRankList(String huodongid);
	
	public int getCnt(String huodongid, String openid);
}
