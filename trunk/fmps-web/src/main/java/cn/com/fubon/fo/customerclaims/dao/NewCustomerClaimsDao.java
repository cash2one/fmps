package cn.com.fubon.fo.customerclaims.dao;

import java.util.List;
import java.util.Map;

/**
 * 
 * @author fbxmn07
 *
 */
public interface NewCustomerClaimsDao {
	
	/**
	 * 进入首页查询理赔记录
	 * @param insuredname
	 * @param idedtifynumber
	 * @return
	 */
	public List<Map<String, Object>> getIndexInfo(String insuredname,String idedtifynumber);
	
	/**
	 * 获取查看理赔进度节点详细信息
	 * @param registno
	 * @return
	 */
	public List<Map<String, Object>> getDetailInfo(String registno);
	
	/**
	 * 获取单条详细信息
	 * @param id
	 * @return
	 */
	public Map<String, Object> getClaimRecordInfo(String id);
}
