/**
 * 
 */
package cn.com.fubon.fo.taitravel.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.DataGridReturn;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.fubon.fo.taitravel.service.IPreinsuredPolicyService;

/**
 * 预约投保service
 * 
 * @author guojunjie
 *
 */
@Service("preinsuredPolicyService")
@Transactional
public class PreinsuredPolicyServiceImpl extends CommonServiceImpl implements
		IPreinsuredPolicyService {
	private static final Logger logger = Logger
			.getLogger(PreinsuredPolicyServiceImpl.class);

	@Override
	public DataGridReturn getDataGridReturn(CriteriaQuery cq, boolean isOffset) {
		return super.getDataGridReturn(cq, isOffset);
	}

	@Override
	public <T> List<T> getList(Class clas) {
		return super.getList(clas);
	}

}
