package weixin.idea.huodong.service.impl;



import java.util.List;

import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import weixin.idea.huodong.entity.HdRecordEntity;
import weixin.idea.huodong.service.HdRecordService;


@Service("hdRecordService")
@Transactional
public class HdRecordServiceImpl extends CommonServiceImpl implements HdRecordService {

	@Override
	public List<HdRecordEntity> findHdRecordByhdId(String hdId,
			String openId) {
		String hql = "from HdRecordEntity where hdid= ? and opendid= ? ";
		List<HdRecordEntity> hdRecrdList = this.findHql(hql, hdId,openId);
		return hdRecrdList;
	}

	@Override
	public void saveHdRecord(HdRecordEntity hdRecordEntity) {
		this.save(hdRecordEntity);
	}

	@Override
	public long getPeopleCount(String hdid) {
		long peopleCount = this
				.getCountForJdbcParam(
						"select count(distinct hd.openid) from weixin_huodong_record hd where hd.huodongid= ? ",
						new Object[] { hdid});
		return peopleCount;
	}
	
}