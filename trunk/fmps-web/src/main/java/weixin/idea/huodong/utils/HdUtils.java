package weixin.idea.huodong.utils;

import javax.annotation.Resource;

import cn.com.fubon.util.CachedUtils;
import cn.com.fubon.util.Constants;
import weixin.idea.huodong.entity.HuodongEntity;
import weixin.idea.huodong.service.PrizeRecordServiceI;

public class HdUtils {
	private static final String superDraw = Constants.SUPER_TOTAL_DRAW;
	private static final String oneDraw = Constants.ONE_TOTAL_DRAW;
	private static final String twoDraw = Constants.TWO_TOTAL_DRAW;
	private static final String threeDraw = Constants.THREE_TOTALD_RAW;
	private static final int otherRank = 4; 
	
	@Resource
	private PrizeRecordServiceI prizeRecordServiceI;
	/*先中奖，再确认是中几等奖*/
	public static int createPrize(HuodongEntity hdEntity, boolean canWinPrize){
		String winProbabilityArr[] = hdEntity.getGl().split("/");
		//中奖概率分子
		int numerator = Integer.parseInt(winProbabilityArr[0]);		
		//中奖概率分母
		int denominator = Integer.parseInt(winProbabilityArr[1]);
		
		int randomNum = (int)(Math.random()*denominator);
		//1、奖品没抽完了 2、没中过奖       
		if(canWinPrize && randomNum>=1 && randomNum<= numerator){
			//中奖,返回奖品等级
			return getPrizeRank(hdEntity);
		}
		
		/*没中奖，取个位数，确定转盘转到的位置*/
		String numString = randomNum+"";
		randomNum = Integer.parseInt(numString.substring(numString.length()-1));
		
		if(randomNum >= 0 && randomNum <= 3){
			randomNum = randomNum +4;
		}
		return randomNum;
	}
	
	/**
	 * 获取奖品等级
	 * @param hdid 活动ID  prizeTotal 奖品总数
	 * @return long
	 */
	private static int getPrizeRank(HuodongEntity hdEntity){
		int superTotal = hdEntity.getSupertotal();
		int ontTotal = hdEntity.getOnetotal();
		int twoTotal = hdEntity.getTwototal();
		int threeTotal = hdEntity.getThreetotal();
		int prizeTotal = superTotal+ontTotal+twoTotal+threeTotal;
		
		int randomPrizeRank  = (int)(Math.random()*prizeTotal);
		/*根据比例随机出奖项，如果该奖项抽完了 则没中奖*/
		if(randomPrizeRank < superTotal){
			//特等奖
			Long superTotalDraw = (Long) CachedUtils.incr(superDraw + hdEntity.getId(),0);
			//缓存失效，未获取到该奖项已经抽取多少个，认为全部抽完，没中奖
			int remainSuperTotal = superTotal - (superTotalDraw == -1?superTotal:superTotalDraw.intValue());
			if(superTotalDraw == null || remainSuperTotal <= 0){
				return Constants.PRIZE_RANK_SUPER+otherRank;
			}else{
				CachedUtils.incr(superDraw + hdEntity.getId(),1);
				return Constants.PRIZE_RANK_SUPER;
			}
		}else if(randomPrizeRank < ontTotal+superTotal && randomPrizeRank >=superTotal){
			//一等奖
			Long oneTotalDraw = (Long) CachedUtils.incr(oneDraw + hdEntity.getId(),0);
			//缓存失效，未获取到该奖项已经抽取多少个，认为全部抽完，没中奖
			int remainOneTotal = ontTotal - (oneTotalDraw==-1?ontTotal:oneTotalDraw.intValue());
			if(oneTotalDraw == null || remainOneTotal <=0){
				return Constants.PRIZE_RANK_FIRST+otherRank;
			}else{
				CachedUtils.incr(oneDraw + hdEntity.getId(),1);
				return Constants.PRIZE_RANK_FIRST;
			}
		}else if(randomPrizeRank >= superTotal+ontTotal+twoTotal){
			//三等奖
			Long threeTotalDraw = (Long) CachedUtils.incr(threeDraw + hdEntity.getId(),0);
			//缓存失效，未获取到该奖项已经抽取多少个，认为全部抽完，没中奖
			int remainThreeTotal = threeTotal - (threeTotalDraw==-1?threeTotal:threeTotalDraw.intValue());
			if(threeTotalDraw == null || remainThreeTotal <=0){
				return Constants.PRIZE_RANK_THIRD+otherRank;
			}else{
				CachedUtils.incr(threeDraw + hdEntity.getId(),1);
				return Constants.PRIZE_RANK_THIRD;
			}
		}else {
			//二等奖
			Long twoTotalDraw = (Long) CachedUtils.incr(twoDraw + hdEntity.getId(),0);
			//缓存失效，未获取到该奖项已经抽取多少个，认为全部抽完，没中奖
			int remainTwoTotal = twoTotal - (twoTotalDraw==-1?twoTotal:twoTotalDraw.intValue());
			if(twoTotalDraw == null || remainTwoTotal <=0){
				return Constants.PRIZE_RANK_SECCOND+otherRank;
			}else{
				CachedUtils.incr(twoDraw + hdEntity.getId(),1);
				return Constants.PRIZE_RANK_SECCOND;
			}
		}
	}
	
}
