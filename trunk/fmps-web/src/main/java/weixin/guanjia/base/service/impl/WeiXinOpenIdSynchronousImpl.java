package weixin.guanjia.base.service.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.hibernate.qbc.HqlQuery;
import org.jeecgframework.core.common.hibernate.qbc.PageList;
import org.jeecgframework.core.common.model.common.DBTable;
import org.jeecgframework.core.common.model.common.UploadFile;
import org.jeecgframework.core.common.model.json.DataGridReturn;
import org.jeecgframework.core.common.model.json.ImportFile;
import org.jeecgframework.core.common.model.json.TreeGrid;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.jeecgframework.tag.vo.datatable.DataTableReturn;
import org.jeecgframework.tag.vo.easyui.Autocomplete;
import org.jeecgframework.tag.vo.easyui.ComboTreeModel;
import org.jeecgframework.tag.vo.easyui.TreeGridModel;
import org.jeecgframework.web.system.pojo.base.TSDepart;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import weixin.guanjia.base.service.WeiXinOpenIdSynchronous;

@Service("weiXinOpenIdSynchronous")
@Transactional
public class WeiXinOpenIdSynchronousImpl extends CommonServiceImpl implements WeiXinOpenIdSynchronous {

	@Override
	public void deleteWeixin_open_table() {
		 String sql="delete from weixin_openid ";
		this.executeSql(sql);
	}

	
	public List<Map<String, Object>> getOpenidNotInGzuserinfo(){
		String sql="select  op.openid from  weixin_openid op  where op.openid not in ( select inf.openid from  weixin_gzuserinfo inf ) ";
		List<Map<String, Object>> openIdList=this.findForJdbc(sql);		
		return openIdList;
	}

	public List<Map<String, Object>> getUnSubscribeOpenId(){
		String sql="select  inf.openid from  weixin_gzuserinfo inf  where inf.openid not in ( select op.openid from  weixin_openid op )";
		List<Map<String, Object>> openIdList=this.findForJdbc(sql);		
		return openIdList;
	}
	
	public void deleteUnSubscribeUser(String openid){
		String Sql="delete from weixin_gzuserinfo  where openid=? ";
		this.executeSql(Sql,openid);
	}
}
