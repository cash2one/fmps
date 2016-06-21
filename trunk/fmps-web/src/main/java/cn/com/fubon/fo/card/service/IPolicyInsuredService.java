/**
 * 
 */
package cn.com.fubon.fo.card.service;

import java.util.List;

import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.DataGridReturn;
import org.jeecgframework.core.common.service.CommonService;

import cn.com.fubon.fo.card.entity.Customer;
import cn.com.fubon.fo.card.entity.PolicyInsured;

/**
 * @author guojunjie
 *
 */
public interface IPolicyInsuredService extends CommonService {

	public DataGridReturn getDataGridReturn(CriteriaQuery cq, boolean isOffset);

	public <T> List<T> getList(Class clas);

	public PolicyInsured getPolicyInsured(Customer insured, String cardno,
			String identity);
}
