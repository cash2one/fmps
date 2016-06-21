/**
 * 
 */
package cn.com.fubon.reportform.offlinepay.service.impl;

import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.fubon.reportform.offlinepay.service.OfflinePayService;

/**
 * @author qingqu.huang
 *
 */
@Service("offlinePayService")
@Transactional
public class OfflinePayServiceImpl extends CommonServiceImpl implements
		OfflinePayService {

}
