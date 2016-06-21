package cn.com.fubon.mailsending.service.impl;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.DataGridReturn;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.fubon.fo.huodong.entity.HuodongRecord;
import cn.com.fubon.mailsending.entity.EmailUserinfoEntity;
import cn.com.fubon.mailsending.entity.EmailUserinfoTempEntity;
import cn.com.fubon.mailsending.service.IToTaiwanMailService;

/**
 * 赴台学生邮件发送
 * 
 * @author yaoming.zhang
 * @date 2015-12-21
 */
@Service("ToTaiwanMailService")
@Transactional
public class ToTaiwanMailServiceImpl extends CommonServiceImpl implements
		IToTaiwanMailService {

	private static final Logger logger = Logger.getLogger(ToTaiwanMailServiceImpl.class);
	
	@Override
	public DataGridReturn getDataGridReturn(CriteriaQuery cq, boolean isOffset) {
		return super.getDataGridReturn(cq, isOffset);
	}
	
	public void saveEmailUserinfo(EmailUserinfoEntity tempEntity) {
		this.save(tempEntity);
	}
	
	public <T> Serializable save(T entity) {
 		Serializable t = super.save(entity);
 		//执行新增操作配置的sql增强
 		this.doAddSql((EmailUserinfoEntity)entity);
 		return t;
 	}
	
	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(EmailUserinfoEntity t){
	 	return true;
 	}
 	
	@Override
	public void saveEmailUserinfoTemp(EmailUserinfoTempEntity tempEntity) {
		super.save(tempEntity);
	}

	@Override
	public List<Map<String, Object>> getNewEmailUserinfo(String importBatchId){
		StringBuffer sql = new StringBuffer();
		sql.append(" select temp.* ");
		sql.append("   from weixin_email_userinfo_temp temp ");
		sql.append("  where temp.importResult = 'SUCCESS' ");
		sql.append("    and temp.importBatchId = ? ");
		sql.append("    and not exists (select name, identifynumber ");
		sql.append("           from weixin_email_userinfo ");
		sql.append("          where name = temp.name ");
		sql.append("          and identifynumber = temp.identifynumber) ");
		logger.info("导入excel批次号："+importBatchId);
		logger.info("赴台学生信息导入：获取新导入学生信息SQL->"+sql.toString());
		
		List<Map<String, Object>> list = this.findForJdbc(sql.toString(), new String[]{importBatchId});
		return list;
	}
	
	@Override
	public List<Map<String, Object>> getNeedUpdateEmailUserinfo(String importBatchId){
		StringBuffer sql = new StringBuffer();
		sql.append(" select temp.* ");
		sql.append("   from weixin_email_userinfo_temp temp ");
		sql.append("  where temp.importResult = 'SUCCESS' ");
		sql.append("    and temp.importBatchId = ? ");
		sql.append("    and exists (select name, identifynumber ");
		sql.append("           from weixin_email_userinfo ");
		sql.append("          where name = temp.name ");
		sql.append("          and identifynumber = temp.identifynumber ");
		sql.append("          and sendStatus is null) ");
		logger.info("导入excel批次号："+importBatchId);
		logger.info("赴台学生信息导入：获取需要更新的旧学生信息SQL->："+sql.toString());
		
		List<Map<String, Object>> list = this.findForJdbc(sql.toString(), new String[]{importBatchId});
		return list;
	}
	
	public void updateNotSendedEmailUserinfo(String name,String identifynumber,String sex,String email){
		StringBuffer sql = new StringBuffer();
		sql.append(" update weixin_email_userinfo ");
		sql.append("    set sex = ?, email = ? ");
		sql.append("  where name = ? ");
		sql.append("    and identifynumber = ? ");
		logger.info("赴台学生信息导入：更新未发送的旧数据SQL->"+sql.toString());
		
		this.executeSql(sql.toString(), new String[]{sex,email,name,identifynumber});
	}

	@Override
	public void updateSendEmailStatus(String id, String sendTime, String sendStatus,
			String insuranceNo, String operatelogId) {
		StringBuffer sql = new StringBuffer();
		sql.append(" update weixin_email_userinfo ");
		sql.append("    set sendTime = ?, sendStatus = ?, insuranceNo = ?, operatelogId = ? ");
		sql.append("  where id = ? ");
		logger.info("发送邮件：更新信息状态SQL->"+sql.toString());
		
		this.executeSql(sql.toString(), new String[]{sendTime,sendStatus,insuranceNo,operatelogId,id});
	}

	/**
	 * 随机抽取一条未发放的卡号、密码
	 */
	@Override
	public Map<String, Object> getCardInfo(String huodongid) {
		String sql = " SELECT c.id,c.cardno,c.password,c.huodongid "+
					 "	  FROM weixin_huodong_card c "+
					 "	  WHERE c.huodongid = ? "+
					 "	    AND NOT EXISTS (SELECT h.cashcouponid "+
					 "	         FROM weixin_huodong_record h "+
					 "		        WHERE c.id = h.cashcouponid) "+
					 "	    AND c.cardno IS NOT NULL "+
					 "	    AND c.password IS NOT NULL "+
					 "	  ORDER BY RAND() LIMIT 1";
		Map<String, Object> map = new HashMap<String, Object>();
		
		map = this.findOneForJdbc(sql,huodongid);
		if(map != null && map.size() > 0)
			return map;
		return null;
	}
	
	/**
	 * 已发卡号、密码记录保存到领取记录表中
	 */
	@Override
	public void addRecord(String cashcouponid,String huodongid) {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DAY_OF_YEAR, 6);
		Date enddate = c.getTime();
		HuodongRecord huodongRecord = new HuodongRecord();
		huodongRecord.setCashcouponid(cashcouponid);
		huodongRecord.setHuodongid(huodongid);
		huodongRecord.setCreatedate(new Date());
		huodongRecord.setStarttime(new Date());
		huodongRecord.setEndtime(enddate);
		huodongRecord.setStatus(1);
		super.save(huodongRecord);
	}
	
}
