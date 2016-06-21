package cn.com.fubon.fo.customernewcarlicence.service.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.hibernate.criterion.DetachedCriteria;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.hibernate.qbc.HqlQuery;
import org.jeecgframework.core.common.hibernate.qbc.PageList;
import org.jeecgframework.core.common.model.common.DBTable;
import org.jeecgframework.core.common.model.common.UploadFile;
import org.jeecgframework.core.common.model.json.DataGridReturn;
import org.jeecgframework.core.common.model.json.ImportFile;
import org.jeecgframework.core.common.model.json.TreeGrid;
import org.jeecgframework.tag.vo.datatable.DataTableReturn;
import org.jeecgframework.tag.vo.easyui.Autocomplete;
import org.jeecgframework.tag.vo.easyui.ComboTreeModel;
import org.jeecgframework.tag.vo.easyui.TreeGridModel;
import org.jeecgframework.web.system.pojo.base.TSDepart;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.fubon.fo.common.dao.impl.OracleGenericBaseCommonDao;
import cn.com.fubon.fo.customernewcarlicence.service.CustomerNewCarLicenceService;

@Service("oracleCustomerNewCarLicenceService")
@Transactional
public class OracleCustomerNewCarLicenceServiceImpl extends
		OracleGenericBaseCommonDao implements CustomerNewCarLicenceService {

	@Override
	public List<Map<String, Object>> getCustomerNewCarLicenceRecord(
			String identifynumber, String customercname, String framenoList) {
		String sql = "select distinct car.brandname, car.frameno,car.licenseno  from   "
				+ "  NETQUERYCITEM_CAR  car , NETQUERYCMAIN ma  "
				+ " where licensed=0 and ma.policyno=car.policyno  and  substr(ma.othflag,3,2)='00'  and ma.enddate + 1 >sysdate and  exists( select 1 from  ecomm_netqueryinsured  ins where car.policyno=ins.policyno and ins.identifynumber=? and ins.insuredname=? ) "
				+ " and  car.frameno not in (" + framenoList + ") ";
		List<Map<String, Object>> returnList = this.findForJdbc(sql,
				new String[] { identifynumber, customercname });
		return returnList;
	}

	@Override
	public Map<String, Object> getCustomerPolicyNoAndCustomerID(
			String identifynumber, String customercname, String frameno) {
		StringBuffer sql = new StringBuffer();
		sql.append(" select ins.policyno, ins.insuredcode ")
				.append("   from NETQUERYCITEM_CAR car, ECOMM_NETQUERYINSURED INS, NETQUERYCMAIN ma ")
				.append("  where car.policyno = ins.policyno ")
				.append("    and ins.insuredcode is not null ")
				.append("    and ma.policyno = car.policyno ")
				.append("    and substr(othflag, 3, 2) = '00' ")
				.append("    and ma.enddate + 1 > sysdate ")
				.append("    and rownum = 1 ")
				.append("    and ins.identifynumber = ? ")
				.append("    and ins.insuredname = ? ")
				.append("    and car.frameno = ? ");

		Map<String, Object> returnRecord = findOneForJdbc(sql.toString(),
				identifynumber, customercname, frameno);

		return returnRecord;
	}

	@Override
	public Map<String, Object> getWeiXinOpenId(String customerId) {
		String sql = " select openid from   weixin_gzuserinfo  where customercode=? ";
		Map<String, Object> returnRecord = findOneForJdbc(sql, customerId);
		return returnRecord;
	}

	@Override
	public List<DBTable> getAllDbTableName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getAllDbTableSize() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> Serializable save(T entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> void saveOrUpdate(T entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public <T> void delete(T entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public <T> void batchSave(List<T> entitys) {
		// TODO Auto-generated method stub

	}

	@Override
	public <T> T get(Class<T> class1, Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T getEntity(Class entityName, Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T findUniqueByProperty(Class<T> entityClass,
			String propertyName, Object value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> List<T> findByProperty(Class<T> entityClass,
			String propertyName, Object value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> List<T> loadAll(Class<T> entityClass) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> void deleteEntityById(Class entityName, Serializable id) {
		// TODO Auto-generated method stub

	}

	@Override
	public <T> void deleteAllEntitie(Collection<T> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public <T> void updateEntitie(T pojo) {
		// TODO Auto-generated method stub

	}

	@Override
	public <T> List<T> findByQueryString(String hql) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> List<T> findByPropertyisOrder(Class<T> entityClass,
			String propertyName, Object value, boolean isAsc) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> List<T> getList(Class clas) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T singleResult(String hql) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageList getPageList(CriteriaQuery cq, boolean isOffset) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataTableReturn getDataTableReturn(CriteriaQuery cq, boolean isOffset) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataGridReturn getDataGridReturn(CriteriaQuery cq, boolean isOffset) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageList getPageList(HqlQuery hqlQuery, boolean needParameter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageList getPageListBySql(HqlQuery hqlQuery, boolean isToEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List findByExample(String entityName, Object exampleEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> List<T> getListByCriteriaQuery(CriteriaQuery cq, Boolean ispage) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T uploadFile(UploadFile uploadFile) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HttpServletResponse viewOrDownloadFile(UploadFile uploadFile) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HttpServletResponse createXml(ImportFile importFile) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void parserXml(String fileName) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<org.jeecgframework.core.common.model.json.ComboTree> comTree(
			List<TSDepart> all,
			org.jeecgframework.core.common.model.json.ComboTree comboTree) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<org.jeecgframework.core.common.model.json.ComboTree> ComboTree(
			List all, ComboTreeModel comboTreeModel, List in) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TreeGrid> treegrid(List all, TreeGridModel treeGridModel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> List<T> getAutoList(Autocomplete autocomplete) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> List<T> findObjForJdbc(String sql, int page, int rows,
			Class<T> clazz) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> List<T> findHql(String hql, Object... param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> List<T> pageList(DetachedCriteria dc, int firstResult,
			int maxResult) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> List<T> findByDetached(DetachedCriteria dc) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Map<String, Object>> getNewCarHasLicenceRecord(
			String identifynumber, String customercname) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<org.jeecgframework.core.common.model.json.ComboTree> CommonWordsComboTree(
			List all, ComboTreeModel comboTreeModel, List in,
			Map<String, String> reaplaceMap) {
		// TODO Auto-generated method stub
		return null;
	}

}
