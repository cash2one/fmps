package cn.com.fubon.mailsending.service;

import java.util.List;
import java.util.Map;

import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.DataGridReturn;
import org.jeecgframework.core.common.service.CommonService;

import cn.com.fubon.mailsending.entity.EmailUserinfoEntity;
import cn.com.fubon.mailsending.entity.EmailUserinfoTempEntity;

/**
 * 赴台学生邮件发送
 * 
 * @author yaoming.zhang
 * @date 2015-12-21
 */
public interface IToTaiwanMailService extends CommonService {

	public DataGridReturn getDataGridReturn(CriteriaQuery cq, boolean isOffset);
 	
	public void saveEmailUserinfoTemp(EmailUserinfoTempEntity tempEntity);
	
	public List<Map<String, Object>> getNewEmailUserinfo(String importBatchId);
	
	public List<Map<String, Object>> getNeedUpdateEmailUserinfo(String importBatchId);
	
	public void updateNotSendedEmailUserinfo(String name,String identifynumber,String sex,String email);
	
	public void saveEmailUserinfo(EmailUserinfoEntity entity);
	
	public void updateSendEmailStatus(String id,String sendTime,String sendStatus,String insuranceNo,String operatelogId);
	
	public Map<String, Object> getCardInfo(String huodongid);
	
	public void addRecord(String cashcouponid,String huodongid);
}
