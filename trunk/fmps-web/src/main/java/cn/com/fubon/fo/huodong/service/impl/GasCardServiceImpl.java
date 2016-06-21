/**
 * 
 */
package cn.com.fubon.fo.huodong.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import jodd.util.StringUtil;

import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import weixin.idea.huodong.entity.HuodongEntity;
import cn.com.fubon.fo.customerbind.entity.WeiXinGzUserInfo;
import cn.com.fubon.fo.huodong.dao.GasCardDao;
import cn.com.fubon.fo.huodong.entity.HuodongRecord;
import cn.com.fubon.fo.huodong.service.GasCardService;
import cn.com.fubon.util.CachedUtils;

/**
 * @author qingqu.huang
 *
 */
@Service("gasCardServiceImpl")
@Transactional
public class GasCardServiceImpl extends CommonServiceImpl implements
		GasCardService {

	@Resource
	private GasCardDao gasCardDao;

	/**
	 * 判断是否在活动区间
	 * 
	 * @param huodongEntity
	 * @return
	 */
	@Override
	public boolean isRangeOfDate(HuodongEntity huodongEntity) {
		Date starttime = huodongEntity.getStarttime();
		Date endtime = huodongEntity.getEndtime();
		Date nowdate = new Date();
		if (nowdate.after(starttime) && nowdate.before(endtime)) {
			return true;
		}
		return false;
	}

	/**
	 * 保存帮抢记录
	 * 
	 * @param openid
	 * @param sponsor
	 */
	@Override
	public void saveGasCardRecord(String openid, String sponsor,
			String huodongid) {
		String mobilekey = sponsor + "mobile";
		String mobile = (String) CachedUtils.get(mobilekey);
		if (StringUtil.isEmpty(mobile)) {
			WeiXinGzUserInfo userinfo = this
					.findUniqueByProperty(WeiXinGzUserInfo.class, "openid",
							sponsor);
			if (userinfo != null) {
				mobile = userinfo.getMobile();
				if (StringUtil.isNotEmpty(mobile)) {
					CachedUtils.add(mobilekey, mobile);
				}
			}
		}
		HuodongRecord gascardHelpRecord = new HuodongRecord();
		gascardHelpRecord.setOpenid(openid);
		gascardHelpRecord.setSponsor(sponsor);
		gascardHelpRecord.setCreatedate(new Date());
		gascardHelpRecord.setHuodongid(huodongid);
		gascardHelpRecord.setPhonenum(mobile);
		this.save(gascardHelpRecord);
		String helpkey = huodongid + sponsor + openid + "helped";
		CachedUtils.add(helpkey, "1");
	}

	/**
	 * 查询排行榜前300名
	 * 
	 * @param huodongid
	 * @return
	 */
	@Override
	public List<Map<String, Object>> getRankList(String huodongid) {
		String rankkey = huodongid + "rankList";
		List rankList = (List) CachedUtils.get(rankkey);
		if (rankList == null) {
			rankList = gasCardDao.getRankList(huodongid);
			if (rankList.size() > 0) {
				CachedUtils.add(rankkey, 10 * 60, rankList);
			}
		}
		return rankList;
	}

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
	public boolean isHelped(String openid, String sponsor, String huodongid) {
		String helpkey = huodongid + sponsor + openid + "helped";
		String help = (String) CachedUtils.get(helpkey);
		if (help == null) {
			boolean helped = gasCardDao.isHelped(openid, sponsor, huodongid);
			if (helped) {
				CachedUtils.add(helpkey, "1");
				return true;
			}
		} else {
			if ("1".equals(help)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public int getCnt(String huodongid, String openid) {
		return gasCardDao.getCnt(huodongid, openid);
	}
}
