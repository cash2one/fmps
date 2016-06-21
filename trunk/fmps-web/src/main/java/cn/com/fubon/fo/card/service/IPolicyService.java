/**
 * 
 */
package cn.com.fubon.fo.card.service;

import java.util.List;

import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.DataGridReturn;
import org.jeecgframework.core.common.service.CommonService;

import cn.com.fubon.fo.card.entity.Policy;

/**
 * @author guojunjie
 *
 */
public interface IPolicyService extends CommonService {

	public DataGridReturn getDataGridReturn(CriteriaQuery cq, boolean isOffset);

	public <T> List<T> getList(Class clas);
	/**
	 * 根据保单号 获取保单 ，如没有就新建保单对象 
	 * @param policyNo
	 * @return
	 */
	public Policy getPolicy(String policyNo);
	
	/**
	 * 根据订单号获取保单对象
	 * @param orderno
	 * @return
	 */
	
	public Policy getPolicyByOrderNo(String orderno);
	
	/**
	 * 根据订单号设置，保单表的保单号
	 * @param policyNo
	 * @param orderno
	 * @return
	 */
	public void setPolicyNoByOrderNo(String orderno,String policyNo);	
	

}
