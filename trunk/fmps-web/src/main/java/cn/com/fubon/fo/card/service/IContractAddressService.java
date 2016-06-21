/**
 * 
 */
package cn.com.fubon.fo.card.service;

import java.util.List;

import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.DataGridReturn;
import org.jeecgframework.core.common.service.CommonService;

import cn.com.fubon.fo.card.entity.ContractAddress;

/**
 * @author guojunjie
 *
 */
public interface IContractAddressService extends CommonService {

	public DataGridReturn getDataGridReturn(CriteriaQuery cq, boolean isOffset);

	public <T> List<T> getList(Class clas);
	/**
	 * 家财卡投保地址
	 * @param policyno
	 * @param provicecode
	 * @param citycode
	 * @param countycode
	 * @param insuredaddress
	 * @return
	 */
	public ContractAddress getContractAddress( String policyno, String provicecode,String citycode, String countycode, String insuredaddress);

}
