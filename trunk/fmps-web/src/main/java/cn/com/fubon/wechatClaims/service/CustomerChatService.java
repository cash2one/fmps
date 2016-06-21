package cn.com.fubon.wechatClaims.service;
import java.util.List;
import java.util.Map;

import org.jeecgframework.core.common.service.CommonService;
import org.jeecgframework.web.system.pojo.base.TSBaseUser;

import weixin.guanjia.message.entity.ReceiveMessage;
import cn.com.fubon.wechatClaims.entity.WeiXinCustomerServiceChatDetail;
import cn.com.fubon.wechatClaims.entity.WeiXinCustomerServiceChatInfo;
/**
 * 客服聊天记录类
 * @author patrick.z
 */
public interface  CustomerChatService extends CommonService {
	
	/**
	 * 保存客服聊天记录表。
	 * @param weiXinCustomerServiceChatInfo
	 * @return
	 */
	void saveWeiXinCustomerServiceChatInfo(WeiXinCustomerServiceChatInfo weiXinCustomerServiceChatInfo );
	
	/**
	 * 保存聊天记录映射表。
	 * @param WeiXinCustomerServiceChatDetail
	 * @return
	 */
	void saveWeiXinCustomerServiceChatDetail(WeiXinCustomerServiceChatDetail weiXinCustomerServiceChatDetail );
	
	/**
	 * 根据报案号查询聊天记录。
	 * @param registno
	 * @return
	 */
	List<Map<String, Object>> getWeiXinCustomerChatList(String registno);
	
	/**
	 * 根据报案号查询历史案件信息
	 * @param operatorCode
	 * @param roleCode
	 * @param licenseNo
	 * @param registNo
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	List<Map<String, Object>> getHistoryRegistNoListByOperatorCode(String operatorCode,String roleCode,String licenseNo,String registNo,String startTime,String endTime);
	
	/**
	 * 根据报案号查询历史案件分页信息
	 * @param currPageNo
	 * @param operatorCode
	 * @param roleCode
	 * @param licenseNo
	 * @param registNo
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	List<Map<String, Object>> getPageHistoryRegistNoListByOperatorCode(int currPageNo,String operatorCode,String roleCode,String licenseNo,String registNo,String startTime,String endTime);
	
	/**
	 * 根据工号和权限查询案件列表。
	 * @param operatorCode
	 * @param roleCode
	 * @return
	 */
	List<Map<String, Object>> getRegistNoListByOperatorCode(String operatorCode,String roleCode);
	
	/**
	 * 根据工号和权限查询超过25分钟的案件列表。
	 * @param operatorCode
	 * @param roleCode
	 * @return
	 */
	List<Map<String, Object>> getTimeoutTWRegistNoListByOperatorCode(String operatorCode,String roleCode);
	
	/**
	 * 根据工号和权限查询超过30分钟的案件列表。
	 * @param operatorCode
	 * @param roleCode
	 * @return
	 */
	List<Map<String, Object>> getTimeoutTHRegistNoListByOperatorCode(String operatorCode,String roleCode);
	/**
	 * 根据案件号查询已读聊天记录。
	 * @param registNo
	 * @return
	 */
	List<Map<String,Object>>  getCustomerServiceChatReaded(String registNo);
	
	/**
	 * 根据案件号查询未读聊天记录。
	 * @param registNo
	 * @return
	 */
	List<Map<String,Object>>  getCustomerServiceChatNotReaded(String registNo);
	
	/**
	 * 根据案件号统计已读照片数量。
	 * @param registNo
	 * @return
	 */
	public int getCustomerServiceChatReadedImages(String registNo);
	
	/**
	 * 根据案件号查询所有聊天记录。
	 * @param registNo
	 * @return
	 */
	List<Map<String, Object>> getCustomerServiceChatList(String registNo);
	
	/**
	 * 根据案件号查询最后一条聊天记录。
	 * @param registNo
	 * @return
	 */
	Map<String, Object> getLastCustomerServiceChatList(String registNo);
	
	/**
	 * 根据聊天映射表id更新聊天信息状态。
	 * @param id
	 * @return
	 */
	boolean updCustomerServiceChatMessageReadedById(String id);
	
	/**
	 * 查询客服聊天记录表。
	 * @author patrick.z
	 * @param registNo
	 * @return
	 */
	WeiXinCustomerServiceChatInfo getWeiXinCustomerServiceChatInfo(String id);
	
	/**
	 * 查询用户聊天记录表。
	 * @author patrick.z
	 * @param id
	 * @return
	 */
	ReceiveMessage getReceiveMessage(String id);
	
	/**
	 * 根据工号查询微信后台用户。
	 * @author patrick.z
	 * @param operatorCode
	 * @return
	 */
	TSBaseUser getTSBaseUser(String operatorCode);
}
