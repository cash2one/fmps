package weixin.idea.huodong.service.impl;

import java.util.List;


import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.fubon.util.CachedUtils;
import cn.com.fubon.util.Constants;
import weixin.idea.huodong.entity.HuodongEntity;
import weixin.idea.huodong.service.HuodongService;

@Service("huodongService")
@Transactional
public class HuodongServiceImpl extends CommonServiceImpl implements HuodongService {
	private static final String superDraw = Constants.SUPER_TOTAL_DRAW;
	private static final String oneDraw = Constants.ONE_TOTAL_DRAW;
	private static final String twoDraw = Constants.TWO_TOTAL_DRAW;
	private static final String threeDraw = Constants.THREE_TOTALD_RAW;

	@Override
	public List<HuodongEntity> findHuodongByAccountid(String accountid) {
		//type = 2 转盘
		String hql =" FROM HuodongEntity h WHERE h.accountid=? AND h.type= ? ";
		List<HuodongEntity> hdList = this.findHql(hql, accountid,Constants.ACTIVITYTYPE_TURNTABLE);
		return hdList;
	}

	@Override
	public int drawRecordCount(String openid,String hdid) {
		
		Long drawRecordCount = this
		.getCountForJdbcParam(
				"select count(1) from weixin_prizerecord prize where prize.openid= ? and prize.hdid = ? ",
				new Object[] { openid, hdid});
		return drawRecordCount.intValue();
	}

	@Override
	public boolean canWinPrize(String openid, String hdid) {
		//奖品数量
		long total = this
				.getCountForJdbcParam(
						"select (h.supertotal+h.onetotal+h.twototal+h.threetotal) from weixin_huodong h where h.id = ?",
						new Object[] { hdid});
		//已抽数量
		long totalDraw = this.totalDraw(hdid);
		if(total-totalDraw <= 0){
			return false;
		}
		long isWinPrize = this
				.getCountForJdbcParam(
						"select count(1) from weixin_prizerecord prize where prize.openid= ? and prize.hdid = ? and prize.prize in (0,1,2,3)",
						new Object[] { openid, hdid});
		if(isWinPrize>0){
			return false;
		}
		return true;
	}
	
	/**
	 * 已抽取数量
	 * @param hdid 活动ID
	 * @return long
	 */
	private long totalDraw(String hdid){
		Long superTotalDraw = (Long) CachedUtils.incr(superDraw + hdid,0);
		//superTotalDraw缓存失效，返回 -1
		if(superTotalDraw < 0){
			superTotalDraw = prizeRankTotal(hdid,Constants.PRIZE_RANK_SUPER);
			CachedUtils.incr(superDraw + hdid,0,superTotalDraw);
		}
		//一等奖已抽数量
		Long oneTotalDraw = (Long) CachedUtils.incr(oneDraw + hdid,0);
		if(oneTotalDraw < 0){
			oneTotalDraw = prizeRankTotal(hdid,Constants.PRIZE_RANK_FIRST);
			CachedUtils.incr(oneDraw + hdid,0, oneTotalDraw);
		}
		Long twoTotalDraw = (Long) CachedUtils.incr(twoDraw + hdid,0);
		if(twoTotalDraw < 0){
			twoTotalDraw = prizeRankTotal(hdid,Constants.PRIZE_RANK_SECCOND);
			CachedUtils.incr(twoDraw + hdid,0, twoTotalDraw);
		}
		Long threeTotalDraw = (Long) CachedUtils.incr(threeDraw + hdid,0);
		if(threeTotalDraw < 0){
			threeTotalDraw = prizeRankTotal(hdid,Constants.PRIZE_RANK_THIRD);
			CachedUtils.incr(threeDraw + hdid,0, threeTotalDraw);
		}
		
/*		CachedUtils.desc(superDraw + hdid, 4);
		CachedUtils.desc(oneDraw + hdid, 50);
		CachedUtils.desc(twoDraw + hdid, 200);
		CachedUtils.desc(threeDraw + hdid, 600);*/
		
		long totalDraw;
		if(superTotalDraw != -1 && oneTotalDraw != -1 
				&& twoTotalDraw != -1 && threeTotalDraw != -1){
			totalDraw = superTotalDraw+oneTotalDraw+twoTotalDraw+threeTotalDraw;
			return totalDraw;
		}
		//已抽数量
		totalDraw = this
				.getCountForJdbcParam(
						"select count(1) from weixin_prizerecord prize where  prize.hdid = ? and prize.prize in (0,1,2,3)",
						new Object[] { hdid});
		return totalDraw;
	}

	
	/**
	 * 相应等级已抽取数量
	 * @param hdid 活动ID  rank 奖品等级
	 * @return long
	 */
	private long prizeRankTotal(String hdid,int rank){
		return  this
			.getCountForJdbcParam(
					"select count(1) from weixin_prizerecord prize where  prize.hdid = ? and prize.prize = ?",
					new Object[] { hdid,rank});
	}
}