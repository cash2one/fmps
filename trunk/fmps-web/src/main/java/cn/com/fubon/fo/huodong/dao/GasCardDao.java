/**
 * 
 */
package cn.com.fubon.fo.huodong.dao;

import java.util.List;
import java.util.Map;

/**
 * @author qingqu.huang
 *
 */
public interface GasCardDao {

	public List<Map<String, Object>> getRankList(String huodongid);
	
	public boolean isHelped(String openid, String sponsor, String huodongid);
	
	public int getCnt(String huodongid, String openid);
}
