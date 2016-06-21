package cn.com.fubon.businessReminder.dao.impl;

import java.util.List;
import java.util.Map;

import org.jeecgframework.core.common.dao.impl.GenericBaseCommonDao;
import org.springframework.stereotype.Repository;

import cn.com.fubon.businessReminder.dao.ICustomerNotifyMessageDao;

/**
 * @author yaoming.zhang
 *
 */
@SuppressWarnings({ "unchecked", "rawtypes" })
@Repository("customerNotifyMessageDao")
public class CustomerNotifyMessageDaoImpl extends GenericBaseCommonDao implements ICustomerNotifyMessageDao {
	
	@Override
	public List<Map<String, Object>> getNewCarUpdateLicenceList(){
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT case ");
		sql.append("         when u.customerSex = 'M' then ");
		sql.append("          '先生' ");
		sql.append("         when u.customerSex = 'F' then ");
		sql.append("          '女士' ");
		sql.append("         else ");
		sql.append("          '先生/女士' ");
		sql.append("       end as sex, ");
		sql.append("       u.openid, ");
		sql.append("       t.id, ");
		sql.append("       t.msgtype, ");
		sql.append("       t.sendstatus, ");
		sql.append("       t.identifynumber, ");
		sql.append("       t.insuredname, ");
		sql.append("       t.brandname, ");
		sql.append("       t.engineno, ");
		sql.append("       t.frameno, ");
		sql.append("       t.policyno, ");
		sql.append("       t.licenseno, ");
		sql.append("       t.nextsendtime ");
		sql.append("  FROM weixin_gzuserinfo u, ");
		sql.append("       (SELECT n.id, ");
		sql.append("               n.msgtype, ");
		sql.append("               n.sendstatus, ");
		sql.append("               n.brandname, ");
		sql.append("               n.engineno, ");
		sql.append("               n.frameno, ");
		sql.append("               n.licenseno, ");
		sql.append("               n.policyno, ");
		sql.append("               n.identifynumber, ");
		sql.append("               n.insuredname, ");
		sql.append("               n.nextsendtime ");
		sql.append("          from weixin_customer_notify_message n ");
		sql.append("         where n.msgtype = '1' ");
		sql.append("           and n.sendstatus = '0' ");
		sql.append("           and n.nextsendtime < now() ");
		sql.append("           and n.frameno not in ");
		sql.append("               (select li.frameno ");
		sql.append("                  from weixin_newcar_licenseno li ");
		sql.append("                 where li.identifynumber = n.identifynumber ");
		sql.append("                   and li.customercname = n.insuredname) ");
		sql.append("        ) t ");
		sql.append(" where u.identifynumber = t.identifynumber ");
		sql.append("   and u.customercname = t.insuredname ");

		List<Map<String, Object>> newCarlist= this.findForJdbc(sql.toString());
		return newCarlist;
	}
	
	@Override
	public Integer updateRecordByid(String id,String recordid){
		StringBuffer sql = new StringBuffer();
		sql.append(" update weixin_customer_notify_message t set t.sendstatus = 1, t.record_id = ? where t.id = ? ");
		
		Integer size= this.executeSql(sql.toString(), new String[]{recordid,id});
		return size;
	}

	@Override
	public List<Map<String, Object>> getThisMsgSendedSizes(String id) {
		StringBuffer sql = new StringBuffer();
		sql.append(" select * from weixin_customer_notify_message t where t.id = ? and t.sendstatus = '1' ");
		
		List<Map<String, Object>> list= this.findForJdbc(sql.toString(), new String[]{id});
		return list;
	}
	
	@Override
	public Integer copyNextMonthRecord(String id) {
		StringBuffer sql = new StringBuffer();
		sql.append(" 		insert into weixin_customer_notify_message ");
		sql.append(" 		  (id, ");
		sql.append(" 		   msgtype, ");
		sql.append(" 		   sendstatus, ");
		sql.append(" 		   brandname, ");
		sql.append(" 		   engineno, ");
		sql.append(" 		   frameno, ");
		sql.append(" 		   licenseno, ");
		sql.append(" 		   policyno, ");
		sql.append(" 		   identifynumber, ");
		sql.append(" 		   insuredname, ");
		sql.append(" 		   record_id, ");
		sql.append(" 		   nextsendtime) ");
		sql.append(" 		  select id, ");
		sql.append(" 		         msgtype, ");
		sql.append(" 		         0, ");// 0代表需要发送
		sql.append(" 		         brandname, ");
		sql.append(" 		         engineno, ");
		sql.append(" 		         frameno, ");
		sql.append(" 		         licenseno, ");
		sql.append(" 		         policyno, ");
		sql.append(" 		         identifynumber, ");
		sql.append(" 		         insuredname, ");
		sql.append(" 		         '', ");
		sql.append(" 		         DATE_ADD(nextsendtime, INTERVAL 1 MONTH) ");// 在原来日期加1个月
		sql.append(" 		    from weixin_customer_notify_message ");
		sql.append(" 		   where id = ? ");
		sql.append(" 		   	order by nextsendtime desc ");
		sql.append(" 		   	limit 1 ");
		
		Integer size= this.executeSql(sql.toString(), new String[]{id});
		return size;
	}
	
	@Override
	public List<Map<String, Object>> getBirthdayBlessList() {
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT case ");
		sql.append("         when u.customerSex = 'M' then ");
		sql.append("          '先生' ");
		sql.append("         when u.customerSex = 'F' then ");
		sql.append("          '女士' ");
		sql.append("         else ");
		sql.append("          '先生/女士' ");
		sql.append("       end as sex, ");
		sql.append("       u.openid, ");
		sql.append("       t.id, ");
		sql.append("       t.identifynumber, ");
		sql.append("       t.insuredname, ");
		sql.append("       u.customerBirthday ");
		sql.append("  FROM weixin_gzuserinfo u, weixin_customer_notify_message t ");
		sql.append(" where u.identifynumber = t.identifynumber ");
		sql.append("   and u.customercname = t.insuredname ");
		sql.append("   and t.msgtype = 2 ");
		sql.append("   and t.sendstatus = 0 ");
		sql.append("   and DATE_FORMAT(u.customerbirthday, '%m-%d') = DATE_FORMAT(NOW(), '%m-%d') ");

		List<Map<String, Object>> birthdayBlesslist= this.findForJdbc(sql.toString());
		return birthdayBlesslist;
	}
	
}
