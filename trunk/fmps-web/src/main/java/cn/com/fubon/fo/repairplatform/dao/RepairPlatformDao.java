/**
 * 
 */
package cn.com.fubon.fo.repairplatform.dao;

import java.util.List;

import org.jeecgframework.web.system.pojo.base.TSType;

/**
 * @author qingqu.huang
 *
 */
public interface RepairPlatformDao {

	public List<TSType> getCityFromTSType(String typegroupcode);
}
