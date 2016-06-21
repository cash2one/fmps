package cn.com.fubon.rest.service.impl;

import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.fubon.rest.service.ShorturlAPIWsService;

@Service("shorturlAPIWsService")
@Transactional
public class ShorturlAPIWsServiceImpl extends CommonServiceImpl implements
		ShorturlAPIWsService {

}
