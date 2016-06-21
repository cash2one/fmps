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

import cn.com.fubon.fo.taitravel.service.IStuPolicyService;

/**
 * 赴台旅游service
 * 
 * @author guojunjie
 *
 */
@Service("stupolicyService")
@Transactional
public class StuPolicyServiceImpl extends CommonServiceImpl implements
		IStuPolicyService {
	private static final Logger logger = Logger
			.getLogger(StuPolicyServiceImpl.class);

	@Override
	public DataGridReturn getDataGridReturn(CriteriaQuery cq, boolean isOffset) {
		return super.getDataGridReturn(cq, isOffset);
	}

	@Override
	public <T> List<T> getList(Class clas) {
		return super.getList(clas);
	}

}
