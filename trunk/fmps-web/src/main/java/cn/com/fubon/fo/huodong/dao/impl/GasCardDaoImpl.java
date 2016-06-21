/**
 * 
 */
package cn.com.fubon.fo.huodong.dao.impl;

import java.util.List;
import java.util.Map;

import org.jeecgframework.core.common.dao.impl.GenericBaseCommonDao;
import org.springframework.stereotype.Repository;

import cn.com.fubon.fo.huodong.dao.GasCardDao;

/**
 * @author qingqu.huang
 *
 */
@SuppressWarnings("unchecked")
@Repository("gasCardDao")
public class GasCardDaoImpl extends GenericBaseCommonDao implements GasCardDao {

	@Override
	public List<Map<String, Object>> getRankList(String huodongid) {
		List<Map<String, Object>> rankList = this
				.findForJdbc("select nickname,cnt,updatetime from weixin_huodong_ranklist where huodongid=?",huodongid);
		return rankList;
	}

	public int getCnt(String huodongid, String openid) {
		long cnt = this.getCountForJdbcParam(
						"select count(*)  from weixin_huodong_record where huodongid=? and sponsor=?",
						new Object[] {huodongid, openid});
		return (int)cnt;
	}

	public boolean isHelped(String openid, String sponsor, String huodongid) {
		List<Map<String, Object>> gascardRecordList = this
				.findForJdbc(
						"select * from weixin_huodong_record where openid=? and sponsor=? and  huodongid=?",
						openid, sponsor, huodongid);
		if (gascardRecordList.size() > 0) {
			return true;
		}

		return false;
	}
}
