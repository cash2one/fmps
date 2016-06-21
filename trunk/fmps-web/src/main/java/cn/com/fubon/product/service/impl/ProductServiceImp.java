/**
 * 
 */
package cn.com.fubon.product.service.impl;

import java.util.Date;
import java.util.Map;

import jodd.datetime.JDateTime;

import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.fubon.product.service.IProductService;


/**
 * 卡单激活模块service
 * 
 * @author qingqu.huang
 *
 */
@Service("ProductService")
@Transactional
public class ProductServiceImp extends CommonServiceImpl implements
		IProductService {
	//private static final Logger logger = Logger.getLogger(ProductServiceImp.class);

	@Override
	public Date getFixedStartDate(String productId,String planId){
		String startDate = this.getProductParameterValue(productId,planId,"general","startdate");
		try{
			JDateTime jdateTime = new JDateTime(startDate);
			return jdateTime.convertToDate();
		} catch(Exception e){
			return null;
		}
	}

	@Override
	public String getProductParameterValue(String productId,String planId,String type,
			String key){
		StringBuilder sql = new StringBuilder();
		sql.append("select param_value from product_parameters where productid=? ");
		sql.append("and planid=? ");
		sql.append("and type=? and param_key=?");
		
		Map<String, Object> paramter = this.findOneForJdbc(sql.toString(),productId,planId,type,key);
		return paramter != null ? (String)paramter.get("param_value") : null;
	}
	
	@Override
	public String getProductParameterValue(String productId,String type,String key){
		StringBuilder sql = new StringBuilder();
		sql.append("select param_value from product_parameters where productid=? ");
		sql.append("and type=? and param_key=?");
		
		Map<String, Object> paramter = this.findOneForJdbc(sql.toString(),productId,type,key);
		return paramter != null ? (String)paramter.get("param_value") : null;
	}
	
	public String getProductDescription(String productId,String type,String key){
		StringBuilder sql = new StringBuilder();
		sql.append("select description from product_parameters where productid=? ");
		sql.append("and type=? and param_key=?");
		
		Map<String, Object> paramter = this.findOneForJdbc(sql.toString(),productId,type,key);
		return paramter != null ? (String)paramter.get("description") : null;
	}

	@Override
	public String getToTaiProductParameterValue(String productId){
		return this.getProductParameterValue(productId,"general","toTai");
	}

	@Override
	public String getToTaiProductDescription(String productId){
		return this.getProductDescription(productId,"general","toTai");
	}
	
	@Override
	public String getNeedMailingAddressProductParameterValue(String productId){
		return this.getProductParameterValue(productId,"general","need_mailing_address");
	}

	@Override
	public Map<String, Object> getProductInfo(String planid) {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT plan.id as planid, ");
		sql.append("        plan.planname, ");
		sql.append("        plan.coreproductcode, ");
		sql.append("        plan.period, ");
		sql.append("        plan.periodtype, ");
		sql.append("        plan.premium, ");
		sql.append("        product.productname, ");
		sql.append("        product.id as productid ");
		sql.append("   from weixin_product product, weixin_plan plan ");
		sql.append("  where plan.productid = product.id ");
		sql.append("    and plan.id = ? ");
		
		Map<String, Object> map = this.findOneForJdbc(sql.toString(),planid);
		return map;
	}
	
}
