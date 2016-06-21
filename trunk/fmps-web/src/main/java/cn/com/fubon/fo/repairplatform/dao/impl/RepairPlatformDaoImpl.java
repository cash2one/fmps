/**
 * 
 */
package cn.com.fubon.fo.repairplatform.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.jeecgframework.core.common.dao.impl.GenericBaseCommonDao;
import org.jeecgframework.web.system.pojo.base.TSType;
import org.springframework.stereotype.Repository;

import cn.com.fubon.fo.repairplatform.dao.RepairPlatformDao;

/**
 * @author qingqu.huang
 *
 */
@SuppressWarnings({ "unchecked", "rawtypes" })
@Repository("repairPlatformDao")
public class RepairPlatformDaoImpl extends GenericBaseCommonDao implements
		RepairPlatformDao {

	/**
	 * 根据类型编码获取对应的值
	 */
	public List<TSType> getCityFromTSType(String typegroupcode) {
		List<TSType> cityList = new ArrayList<TSType>();
		StringBuilder sql = new StringBuilder("");
		sql.append("select typecode,typename from t_s_type ");
		sql.append(" where typegroupid in (select id from t_s_typegroup where typegroupcode=?)");
		cityList = this.findForJdbc(sql.toString(), typegroupcode);
		return cityList;
	}
}
