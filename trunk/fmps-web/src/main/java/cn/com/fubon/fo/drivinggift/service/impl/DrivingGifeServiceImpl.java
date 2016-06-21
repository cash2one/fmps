/**
 * 
 */
package cn.com.fubon.fo.drivinggift.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.jeecgframework.core.util.StringUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import weixin.guanjia.account.service.WeixinAccountServiceI;
import cn.com.fubon.fo.cashcoupon.entity.CashCoupon;
import cn.com.fubon.fo.customerbind.entity.WeiXinGzUserInfo;
import cn.com.fubon.fo.drivinggift.service.DrivingGifeService;
import cn.com.fubon.fo.huodong.entity.HuodongRecord;

/**
 * 
 * @author fbxmn07
 *
 */
@Service("drivingGifeServiceImpl")
@Transactional
public class DrivingGifeServiceImpl extends CommonServiceImpl implements DrivingGifeService {

	private Logger logger = Logger.getLogger(DrivingGifeServiceImpl.class);

	@Resource
	private WeixinAccountServiceI weixinAccountService;

	/**
	 * 将领取的券数据数记录到活动领取记录表中
	 * @param openid
	 * @param amount
	 * @param starttime
	 * @param endtime
	 * @param total_num
	 * @param huodongid
	 * @param cashcouponid
	 * @return
	 */
	@Override
	public void getAddRecord(String openid,String cashcouponid,String huodongid,String amount) {
//		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		String starttime = sdf.format(startdate);
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DAY_OF_YEAR, 6);
		Date enddate = c.getTime();
		HuodongRecord huodongRecord = new HuodongRecord();
		huodongRecord.setAmount(Double.parseDouble(amount));
		huodongRecord.setCashcouponid(cashcouponid);
		huodongRecord.setOpenid(openid);
		huodongRecord.setHuodongid(huodongid);
		huodongRecord.setCreatedate(new Date());
//		huodongRecord.setStarttime(DateUtils.str2Date(starttime, sdf));
//		huodongRecord.setEndtime(DateUtils.str2Date(endtime, sdf));
		huodongRecord.setStarttime(new Date());
		huodongRecord.setEndtime(enddate);
		huodongRecord.setStatus(1);
		this.save(huodongRecord);
	}

	/**
	 * 查询初始化表中是否还有券可领
	 */
	@Override
	public int getGiftTotal(String huodongid) {
		long giftTotal = this.getCountForJdbcParam("select count(*) from weixin_cashcoupon c where c.externalSerialNo is not null and c.huodongid = ? for update", new Object[]{huodongid});
		if(giftTotal > 0)
			return (int) giftTotal;
		return -1;
	}

	/**
	 * 根据openid和huodongid判断用户是否有领取过或者领取的券有没有过期
	 * 
	 * @param openid
	 * @param huodongid
	 * @return
	 */
	@Override
	public List<Map<String, Object>> getIsOverdueList(String openid, String huodongid) {
		List<Map<String, Object>> list = this
				.findForJdbc(
						"select h.amount,h.huodongid,h.cashcouponid,c.externalSerialNo from weixin_huodong_record h left join weixin_cashcoupon c on h.cashcouponid = c.id where TIMESTAMPDIFF(day,now(),h.endtime) > 0 and h.`status`= 1 and h.openid = ? and h.huodongid = ?",
						openid, huodongid);
		if(list != null && list.size() > 0)
			return list;
		return null;
	}

	/**
	 * 更新数据库被领取过的券
	 * @param openid
	 * @param huodongid
	 */
	@Override
	public void updateGift(String cashcouponid,String openid) {
		this.executeSql("update weixin_cashcoupon c set c.openid = ? where c.openid is null and c.id = ? limit 1",openid,cashcouponid);
	}

	/**
	 * 初始化表随机取一条数据
	 * 
	 * @param huodongid
	 *            活动编号
	 * @return
	 */
	@Override
	public Map<String, Object> getDataList(String huodongid) {
		Map<String, Object> list = new HashMap<String, Object>();
		list = this.findOneForJdbc(
				"SELECT c.id,c.externalSerialNo,c.huodongid,c.amount FROM weixin_cashcoupon c WHERE NOT EXISTS (SELECT h.cashcouponid FROM weixin_huodong_record h WHERE c.id = h.cashcouponid) AND c.huodongid=? AND c.externalSerialNo IS NOT NULL ORDER BY RAND() LIMIT 1",
				huodongid);
		if(list != null && list.size() > 0)
			return list;
		return null;
	}

	/**
	 * 判断当前时间是否在于e代驾活动之间
	 * 
	 * @return
	 */
	public boolean checkTime(String huodongid) {
		long num = this.getCountForJdbcParam("select count(*) from weixin_huodong g where TIMESTAMPDIFF(day,now(),g.endtime) > 0 and g.id= ? ", new Object[]{huodongid});
		if(num > 0)
			return true;
		return false;
	}
	
	/**
	 * 获取已领取到券的用户信息
	 * @param huodongid
	 * @return
	 */
	@Override
	public List<Map<String, Object>> getUserInfo(String huodongid) {
		List<Map<String, Object>> userlist = new ArrayList<Map<String, Object>>();
		userlist = this.findForJdbc(
						"select h.amount,date_format(h.starttime,'%Y.%m.%d %H:%i') starttime,g.headimgurl,g.nickname,h.huodongid  from weixin_huodong_record h left join weixin_gzuserinfo g on h.openid = g.openid where h.huodongid = ? order by h.starttime desc limit 10",
						huodongid);
		if(userlist != null && userlist.size() > 0)
			return userlist;
		return null;
	}
	
}
