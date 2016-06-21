/**
 * 
 */
package cn.com.fubon.fo.card.service.imp;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.DataGridReturn;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.fubon.fo.card.entity.Customer;
import cn.com.fubon.fo.card.service.ICustomerService;

/**
 * 卡单激活模块service
 * 
 * @author guojunjie
 *
 */
@Service("customerService")
@Transactional
public class CustomerServiceImp extends CommonServiceImpl implements
		ICustomerService {
	private static final Logger logger = Logger
			.getLogger(CustomerServiceImp.class);

	@Override
	public DataGridReturn getDataGridReturn(CriteriaQuery cq, boolean isOffset) {
		return super.getDataGridReturn(cq, isOffset);
	}

	@Override
	public <T> List<T> getList(Class clas) {
		return super.getList(clas);
	}

	@Override
	public Customer getCustomer(String name, String identifytype,
			String identifynumber, String gender, Date birthday, String phone,
			String address, String email,String carRelation,String carRelationname,String carownername,String licenseNo) {
		Customer customerr = new Customer();
		customerr.setIdentifynumber(identifynumber);
		customerr.setIdentifytype(identifytype);
		customerr.setName(name);
		CriteriaQuery cq = new CriteriaQuery(Customer.class);
		// 查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq,
				customerr);
		cq.add();
		List<Customer> customerList = this.getListByCriteriaQuery(cq, true);
		// List<Customer> customerList = this.findByProperty(Customer.class,
		// "identifynumber", identifynumber); // 后续加入证件类型
		if (customerList.size() > 0) {
			Customer customerg = customerList.get(0);
			customerg.setName(name);
			customerg.setIdentifytype(identifytype);
			customerg.setIdentifynumber(identifynumber);
			customerg.setGender(gender);
			customerg.setBirthday(birthday);
			customerg.setPhone(phone);
			customerg.setAddress(address);
			customerg.setEmail(email);			
			customerg.setCarRelation(carRelation);   
			customerg.setCarRelationname(carRelationname);  
			customerg.setCarownername(carownername); 
			customerg.setLicenseno(licenseNo);  
			this.updateEntitie(customerg);
			return customerg;
		} else {
			Customer customer = new Customer();
			customer.setName(name);
			customer.setIdentifytype(identifytype);
			customer.setIdentifynumber(identifynumber);
			customer.setGender(gender);
			customer.setBirthday(birthday);
			customer.setPhone(phone);
			customer.setAddress(address);
			customer.setEmail(email);
			customer.setCarRelation(carRelation);   
			customer.setCarRelationname(carRelationname);  
			customer.setCarownername(carownername); 
			customer.setLicenseno(licenseNo); 
			this.save(customer);
			return customer;
		}
	}

}
