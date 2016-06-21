/**
 * 
 */
package cn.com.fubon.fo.card.service;

import java.io.IOException;

import org.jeecgframework.core.common.service.CommonService;

import cn.com.fubon.common.entity.occupationtypeEntity.OccupationResponse;
import cn.com.fubon.fo.card.entity.Card;
import cn.com.fubon.fo.card.entity.Policy;
import cn.com.fubon.fo.card.entity.PolicyInsured;
import cn.com.fubon.webservice.externl.coresystem.entity.CardResponse;
import cn.com.fubon.webservice.externl.coresystem.entity.PolicyResponse;

/**
 * @author qingqu.huang
 *
 */
public interface ICardWS extends CommonService {
	/**
	 * 验证卡号密码
	 * 
	 * @param cardno
	 * @param password
	 * @return
	 */
	public CardResponse validateCard(String cardno, String password)
			throws IOException;

	/**
	 * 将核心返回的卡单信息写入到weixin_card_info中
	 * 
	 * @param response
	 * @param openid
	 * @return
	 */
	public Card saveCard(CardResponse response, String openid);

	/**
	 * 投保
	 * 
	 * @param policy
	 * @return
	 */
	public PolicyResponse sendInsured(Policy policy, String type, PolicyInsured policyInsured)
			throws IOException;

	/**
	 * 被保险人职业类别查询
	 * 
	 * @param insurerId
	 * @param insurerName
	 * @return
	 * @throws IOException
	 */
	public OccupationResponse getOccupationType(String basicDataType,
			String occupationName,String ip) throws IOException;

}
