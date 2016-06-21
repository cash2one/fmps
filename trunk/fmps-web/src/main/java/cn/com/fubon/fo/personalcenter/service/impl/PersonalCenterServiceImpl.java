package cn.com.fubon.fo.personalcenter.service.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import weixin.guanjia.account.entity.WeixinAccountEntity;
import cn.com.fubon.fo.personalcenter.dao.PersonalCenterDao;
import cn.com.fubon.fo.personalcenter.service.PersonalCenterService;
import cn.com.fubon.util.Constants;

@Service("personalCenterService")
@Transactional
public class PersonalCenterServiceImpl extends CommonServiceImpl implements
		PersonalCenterService {
	@Resource
	private PersonalCenterDao personalCenterDao;

	@Override
	public Map<String, String> getCustomerInfoByOpenId(String openid) {
		return personalCenterDao.getCustomerInfoByOpenId(openid);
	}

	@Override
	public WeixinAccountEntity getWeixinAccountByStatus() {
		// TODO Auto-generated method stub
		return this.findUniqueByProperty(WeixinAccountEntity.class, "status",
				Constants.STATUS_FLAG_VALID);
	}

}
