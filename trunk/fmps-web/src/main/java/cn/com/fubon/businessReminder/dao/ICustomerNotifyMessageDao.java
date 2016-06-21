package cn.com.fubon.businessReminder.dao;

import java.util.List;
import java.util.Map;

/**
 * @author yaoming.zhang
 *
 */
public interface ICustomerNotifyMessageDao {

	/**
	 * 查询需要发送消息的新车列表
	 * @return
	 */
	public List<Map<String, Object>> getNewCarUpdateLicenceList();
	
	/**
	 * 更新该条信息的recordid及sendstatus状态为1
	 * @param id
	 * @param recordid
	 * @return
	 */
	public Integer updateRecordByid(String id,String recordid);
	
	/**
	 * 获取记录个数
	 * @param id
	 * @return
	 */
	public List<Map<String, Object>> getThisMsgSendedSizes(String id);
	
	/**
	 * 复制下个月发送的数据,新增的记录:record_id为空、nextsendtime下次发送时间在原来基础上增加一个月,sendstatus为0
	 * @param id
	 * @return
	 */
	public Integer copyNextMonthRecord(String id);
	
	/**
	 * 查询需要发送消息的生日提醒列表
	 * @return
	 */
	public List<Map<String, Object>> getBirthdayBlessList();
	
}
