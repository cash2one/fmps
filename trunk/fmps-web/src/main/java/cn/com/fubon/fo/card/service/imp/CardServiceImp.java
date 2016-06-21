/**
 * 
 */
package cn.com.fubon.fo.card.service.imp;

import java.util.List;

import org.apache.log4j.Logger;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.DataGridReturn;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.fubon.fo.card.entity.Card;
import cn.com.fubon.fo.card.service.ICardService;

/**
 * 卡单激活模块service
 * 
 * @author guojunjie
 *
 */
@Service("cardService")
@Transactional
public class CardServiceImp extends CommonServiceImpl implements ICardService {
	private static final Logger logger = Logger.getLogger(CardServiceImp.class);

	@Override
	public DataGridReturn getDataGridReturn(CriteriaQuery cq, boolean isOffset) {
		return super.getDataGridReturn(cq, isOffset);
	}

	@Override
	public <T> List<T> getList(Class clas) {
		return super.getList(clas);
	}

	public Card getCard(String carNO){
		List<Card> cardList=this.findByProperty(Card.class, "card_no", carNO);		
		return cardList.get(0) ;
	}
	
}
