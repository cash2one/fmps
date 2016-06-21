package cn.com.fubon.fo.customerhonortitle.service.impl;

import java.util.Map;
import org.apache.log4j.Logger;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import cn.com.fubon.fo.customerhonortitle.service.CustomerHonorTitleService;

@Service("customerHonorTitleService")
@Transactional
public class CustomerHonorTitleServiceImpl extends CommonServiceImpl implements CustomerHonorTitleService {
	private static final Logger logger = Logger.getLogger(CustomerHonorTitleServiceImpl.class);
	/**
	 * 根据保费查询客户荣誉称号和称号描述
	 */
	public Map<String,Object> findHonorByPremium(Double premium){
		Map<String,Object> honor = this.findOneForJdbc(" select honor_name,honor_desc from weixin_honor_title where ? between prem_start and prem_end ", premium);
		logger.info("hornor ===> " + honor);
		return honor;
	}
}
