/**
 * 
 */
package cn.com.fubon.fo.card.service;

import java.util.Date;
import java.util.List;

import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.DataGridReturn;
import org.jeecgframework.core.common.service.CommonService;

import cn.com.fubon.fo.card.entity.Customer;

/**
 * @author guojunjie
 *
 */
public interface ICustomerService extends CommonService {

	public DataGridReturn getDataGridReturn(CriteriaQuery cq, boolean isOffset);

	public <T> List<T> getList(Class clas);

	/**
	 * 先查询数据库，如已经有客户存在，就返回该客户，否则新建客户对象并保存到数据库。
	 * 
	 * @param name
	 * @param identifytype
	 * @param identifynumber
	 * @param gender
	 * @param birthday
	 * @param phone
	 * @param address
	 * @param email
	 * @return
	 */
	public Customer getCustomer(String name, String identifytype,
			String identifynumber, String gender, Date birthday, String phone,
			String address, String email ,String carRelation,String carRelationname,String carownername,String licenseNo);

}
