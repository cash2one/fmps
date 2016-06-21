package cn.com.fubon.fo.common.dao.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.jeecgframework.core.common.dao.jdbc.JdbcDao;
import org.jeecgframework.core.util.oConvertUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

public abstract class OracleGenericBaseCommonDao<T, PK extends Serializable> {

	/**
	 * 注入一个sessionFactory属性,并注入到父类(HibernateDaoSupport)
	 * **/
	@Autowired
	@Qualifier("oracleSessionFactory")
	private SessionFactory sessionFactory;
	
	@Autowired
	@Qualifier("oracleJdbcTemplate")
	private JdbcTemplate jdbcTemplate;

	@Autowired
	@Qualifier("oracleNamedParameterJdbcTemplate")
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	
	public Session getSession() {
		// 事务必须是开启的(Required)，否则获取不到
		return sessionFactory.getCurrentSession();
	}
	
	/**
	 * 通过sql更新记录
	 * 
	 * @param <T>
	 * @param query
	 * @return
	 */
	public int updateBySqlString(final String query) {

		Query querys = getSession().createSQLQuery(query);
		return querys.executeUpdate();
	}
	
	/**
	 * 通过sql查询语句查找对象
	 * 
	 * @param <T>
	 * @param query
	 * @return
	 */
	public List<T> findListbySql(final String sql) {
		Query querys = getSession().createSQLQuery(sql);
		return querys.list();
	}
	
	/**
	 * 使用指定的检索标准检索数据并分页返回数据
	 */
	public List<Map<String, Object>> findForJdbc(String sql, int page, int rows) {
		// 封装分页SQL
		sql = JdbcDao.jeecgCreatePageSql(sql, page, rows);
		return this.jdbcTemplate.queryForList(sql);
	}


	/**
	 * 使用指定的检索标准检索数据并分页返回数据-采用预处理方式
	 * 
	 * @param criteria
	 * @param firstResult
	 * @param maxResults
	 * @return
	 * @throws DataAccessException
	 */
	public List<Map<String, Object>> findForJdbcParam(String sql, int page,
			int rows, Object... objs) {
		// 封装分页SQL
		sql = JdbcDao.jeecgCreatePageSql(sql, page, rows);
		return this.jdbcTemplate.queryForList(sql, objs);
	}

	/**
	 * 使用指定的检索标准检索数据并分页返回数据For JDBC
	 */
	public Long getCountForJdbc(String sql) {
		return this.jdbcTemplate.queryForObject(sql, Long.class);  
	}

	/**
	 * 使用指定的检索标准检索数据并分页返回数据For JDBC-采用预处理方式
	 * 
	 */
	public Long getCountForJdbcParam(String sql, Object[] objs) {
		return this.jdbcTemplate.queryForObject(sql, objs, Long.class);  
	}

	public List<Map<String, Object>> findForJdbc(String sql, Object... objs) {
		return this.jdbcTemplate.queryForList(sql, objs);
	}
	
	public List<Map<String, Object>> findForJdbc(String sql, Map<String, ?> paramMap) {
		return this.namedParameterJdbcTemplate.queryForList(sql, paramMap);
	}

	public Integer executeSql(String sql, List<Object> param) {
		return this.jdbcTemplate.update(sql, param);
	}

	public Integer executeSql(String sql, Object... param) {
		return this.jdbcTemplate.update(sql, param);
	}

	public Integer executeSql(String sql, Map<String, Object> param) {
		return this.namedParameterJdbcTemplate.update(sql, param);
	}
	
	public Object executeSqlReturnKey(final String sql, Map<String, Object> param) {
		Object keyValue = null;
		KeyHolder keyHolder = new GeneratedKeyHolder(); 
		SqlParameterSource sqlp  = new MapSqlParameterSource(param);
		this.namedParameterJdbcTemplate.update(sql,sqlp, keyHolder);
		if(oConvertUtils.isNotEmpty(keyHolder.getKey())){
			keyValue = keyHolder.getKey().longValue();
		}
		return keyValue;
	}
	public Integer countByJdbc(String sql, Object... param) {
		return this.jdbcTemplate.queryForObject(sql, param, Integer.class);
	}

	public Map<String, Object> findOneForJdbc(String sql, Object... objs) {
		try {
			return this.jdbcTemplate.queryForMap(sql, objs);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}
	
	
}
