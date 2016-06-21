package cn.com.fubon.businessReminder.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.fubon.businessReminder.dao.ICustomerNotifyMessageDao;
import cn.com.fubon.businessReminder.service.ICustomerNotifyMessageService;

/**
 * @author yaoming.zhang
 *
 */
@Service("customerNotifyMessageService")
@Transactional
public class CustomerNotifyMessageServiceImpl implements ICustomerNotifyMessageService {
	
	@Resource
	public ICustomerNotifyMessageDao customerNotifyMessageDao;

	@Override
	public List<Map<String, Object>> getNewCarUpdateLicenceList() {
		return this.customerNotifyMessageDao.getNewCarUpdateLicenceList();
	}

	@Override
	public boolean updateRecordByid(String id,String recordid) {
		Integer size = this.customerNotifyMessageDao.updateRecordByid(id,recordid);
		return size > 0 ? true : false;
	}

	@Override
	public boolean needCopy(String id) {
		Integer size = this.customerNotifyMessageDao.getThisMsgSendedSizes(id).size();
		return size >= 3 ? false : true;
	}
	
	@Override
	public boolean copyNextMonthRecord(String id) {
		Integer size = this.customerNotifyMessageDao.copyNextMonthRecord(id);
		return size > 0 ? true : false;
	}
	
	@Override
	public List<Map<String, Object>> getBirthdayBlessList() {
		return this.customerNotifyMessageDao.getBirthdayBlessList();
	}
	
}
