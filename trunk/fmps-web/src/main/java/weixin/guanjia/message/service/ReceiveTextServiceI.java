package weixin.guanjia.message.service;

import java.io.Serializable;

import org.jeecgframework.core.common.service.CommonService;

import weixin.guanjia.message.entity.ReceiveMessage;


public interface ReceiveTextServiceI extends CommonService{
	@Override
 	public <T> void delete(T entity);
 	@Override
 	public <T> Serializable save(T entity);
 	@Override
 	public <T> void saveOrUpdate(T entity);
 	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(ReceiveMessage t);
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(ReceiveMessage t);
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(ReceiveMessage t);
 	
}
