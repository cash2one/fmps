/**
 * 
 */
package cn.com.fubon.fo.card.service;

import java.util.List;

import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.DataGridReturn;
import org.jeecgframework.core.common.service.CommonService;

import cn.com.fubon.fo.card.entity.Card;

/**
 * @author guojunjie
 *
 */
public interface ICardService extends CommonService {

	public DataGridReturn getDataGridReturn(CriteriaQuery cq, boolean isOffset);

	public <T> List<T> getList(Class clas);
	/**
	 * 根据卡号获取卡片信息
	 * @param carNO
	 * @return
	 */
	public Card getCard(String carNO);

}
