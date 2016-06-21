package cn.com.fubon.mailsending.service.impl;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.jeecgframework.core.util.BrowserUtils;
import org.jeecgframework.core.util.ContextHolderUtils;
import org.jeecgframework.core.util.oConvertUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.fubon.mailsending.entity.EmailOperateLogEntity;
import cn.com.fubon.mailsending.service.IEmailOperateService;

@Service("emailOperateService")
@Transactional
public class EmailOperateServiceImpl extends CommonServiceImpl implements IEmailOperateService {
	
	@Override
	public void addLog(String operatelogId, String operater, String operateType, String huodongid, String importBatchId, String logContent) {
		
		HttpServletRequest request = ContextHolderUtils.getRequest();
		String broswer = BrowserUtils.checkBrowse(request);
		EmailOperateLogEntity log = new EmailOperateLogEntity();
		log.setOperatelogId(operatelogId);
		log.setOperateTime(new Date());
		log.setOperater(operater);
		log.setOperateType(operateType);
		log.setBroswer(broswer);
		log.setHuodongid(huodongid);
		log.setImportBatchId(importBatchId);
		log.setIpAddr(oConvertUtils.getIpAddrByRequest(request));
		log.setLogContent(logContent);
		commonDao.save(log);
	}

}
