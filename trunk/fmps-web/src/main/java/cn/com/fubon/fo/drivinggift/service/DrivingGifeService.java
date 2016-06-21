/**
 * 
 */
package cn.com.fubon.fo.drivinggift.service;

import java.util.List;
import java.util.Map;

import org.jeecgframework.core.common.service.CommonService;

/**
 * 
 * @author fbxmn07
 *
 */
public interface DrivingGifeService extends CommonService {

	/**
	 * 查询初始化表中是否还有券可领
	 * 
	 * @param huodongid
	 *            活動ID
	 * @return
	 */
	public int getGiftTotal(String huodongid);

	/**
	 * 根据openid和huodongid判断用户是否有领取过或者领取的券有没有过期
	 * 
	 * @param openid
	 * @param huodongid
	 * @return
	 */
	public List<Map<String, Object>> getIsOverdueList(String openid,
			String huodongid);

	/**
	 * 将领取的券数据数记录到活动领取记录表中
	 * 
	 * @param openid
	 * @param amount
	 * @param starttime
	 * @param endtime
	 * @param total_num
	 * @param huodongid
	 * @param cashcouponid
	 * @return
	 */
	public void getAddRecord(String openid, String cashcouponid,
			String huodongid,String amount);

	/**
	 * 更新数据库被领取过的券
	 * 
	 * @param openid
	 * @param huodongid
	 */
	public void updateGift(String cashcouponid, String openid);

	/**
	 * 初始化表随机取一条数据
	 * 
	 * @param huodongid
	 *            活动编号
	 * @return
	 */
	public Map<String, Object> getDataList(String huodongid);

	/**
	 * 判断当前时间是否在于e代驾活动之间
	 * 
	 * @return
	 */
	public boolean checkTime(String huodongid);

	/**
	 * 获取已领取到券的用户信息
	 * 
	 * @param huodongid
	 * @return
	 */
	public List<Map<String, Object>> getUserInfo(String huodongid);

}
