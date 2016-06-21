package cn.com.fubon.fo.repairplatform.dao;

import java.util.List;
import java.util.Map;

/**
 * 客户保单查询类
 * 
 * @author guojunjie
 */
public interface OracleRepairPlatformGiftDao {
	public List<Map<String, Object>> findRepairPlatformGift(
			String identifynumber, String customercname);
}
