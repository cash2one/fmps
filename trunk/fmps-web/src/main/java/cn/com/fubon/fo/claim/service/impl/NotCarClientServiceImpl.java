package cn.com.fubon.fo.claim.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.fubon.fo.claim.service.NotCarClientService;

@Service("notCarClientService")
@Transactional
public class NotCarClientServiceImpl extends CommonServiceImpl implements NotCarClientService {
	private static final Logger logger = Logger
			.getLogger(NotCarClientServiceImpl.class);

	/**
	 * 根据用户openid、caseno统计该用户已上传的图片总数量
	 */
	@Override
	public int getCount(String openid,String caseno) {
		long sumnum = this.getCountForJdbcParam(
						"select count(*) from weixin_claim_image where openid=? and caseno=? and status = '1'",
						new Object[] { openid,caseno });
		return (int) sumnum;
	}
	
	/**
	 * 获取某个案件各图片类型已上传的数量
	 */
	@Override
	public Map<String, Object> getImgtypeCount(String openid,String caseno) {
		StringBuffer sql = new StringBuffer();
		sql.append(" select sum(case imgtype when '1' then 1 else 0 end) as 'shenfenzhengCount',");
		sql.append(" 		sum(case imgtype when '2' then 1 else 0 end) as 'xukezhengCount',");
		sql.append(" 		sum(case imgtype when '3' then 1 else 0 end) as 'tongxingzhengCount',");
		sql.append(" 		sum(case imgtype when '4' then 1 else 0 end) as 'zhenduanshuCount',");
		sql.append(" 		sum(case imgtype when '5' then 1 else 0 end) as 'yiliaoshoujuCount',");
		sql.append(" 		sum(case imgtype when '6' then 1 else 0 end) as 'bankcardCount',");
		sql.append(" 		sum(case imgtype when '7' then 1 else 0 end) as 'otherCount'");
		sql.append("  from weixin_claim_image");
		sql.append(" where openid = ? and caseno = ? and status != '2' ");
		logger.info("获取某个案件各图片类型已上传的数量sql："+sql.toString());
		
		Map<String, Object> map = this.findOneForJdbc(sql.toString(), openid, caseno);
		return map;
	}

	/**
	 * 判断是否存在该案件号信息
	 */
	@Override
	public boolean isExist(String registNo) {
		StringBuffer sql = new StringBuffer();
		sql.append(" select count(*) as registCount ");
		sql.append("  from weixin_notcar_report_info");
		sql.append(" where registNo = ?");
		logger.info("是否存在该案件号信息sql："+sql.toString());
		
		Long size = this.getCountForJdbcParam(sql.toString(), new Object[] { registNo });
		System.out.println(size.intValue());
		return size.intValue() > 0 ? true : false;
	}

	/**
	 * 更新该案件号信息
	 */
	@Override
	public void updateRegistInfo(String registNo, String policyNo,
			String reportDate, String reportTime, String startDate,
			String endDate, String remark, String caseStatus,
			String insuredName, String reportorName) {
		StringBuffer sql = new StringBuffer();
		sql.append(" update weixin_notcar_report_info t set t.policyNo = ?, t.reportDate = ?, t.reportTime = ?, t.startDate = ?, t.endDate = ?, t.remark = ?, t.caseStatus=?,t.insuredName=?,t.reportorName=? where t.registNo = ? ");
		logger.info("更新该案件号信息sql："+sql.toString());
		
		this.executeSql(sql.toString(), new String[]{policyNo,reportDate,reportTime,startDate,endDate,remark,caseStatus,insuredName,reportorName,registNo});
	}

	@Override
	public List<Map<String, Object>> getUploadedImg(String openid, String caseno) {
		
		StringBuffer sql = new StringBuffer();
		sql.append(" (select * from weixin_claim_image t where t.openid = ? and t.caseno = ? and imgtype = '1' and status != '2' order by t.uploadtime asc limit 2) ");
		sql.append(" union all ");
		sql.append(" (select * from weixin_claim_image t where t.openid = ? and t.caseno = ? and imgtype = '2' and status != '2' order by t.uploadtime asc limit 2) ");
		sql.append(" union all ");
		sql.append(" (select * from weixin_claim_image t where t.openid = ? and t.caseno = ? and imgtype = '3' and status != '2' order by t.uploadtime asc limit 2) ");
		sql.append(" union all ");
		sql.append(" (select * from weixin_claim_image t where t.openid = ? and t.caseno = ? and imgtype = '4' and status != '2' order by t.uploadtime asc limit 30) ");
		sql.append(" union all ");
		sql.append(" (select * from weixin_claim_image t where t.openid = ? and t.caseno = ? and imgtype = '5' and status != '2' order by t.uploadtime asc limit 30) ");
		sql.append(" union all ");
		sql.append(" (select * from weixin_claim_image t where t.openid = ? and t.caseno = ? and imgtype = '6' and status != '2' order by t.uploadtime asc limit 2) ");
		sql.append(" union all ");
		sql.append(" (select * from weixin_claim_image t where t.openid = ? and t.caseno = ? and imgtype = '7' and status != '2' order by t.uploadtime asc limit 30) ");
		logger.info("查询该案件号已上传图片列表信息sql："+sql.toString());
		
		List<Map<String, Object>> imglist = this.findForJdbc(sql.toString(), new String[]{openid,caseno,openid,caseno,openid,caseno,openid,caseno,openid,caseno,openid,caseno,openid,caseno});
		return imglist;
	}

	@Override
	public List<Map<String, Object>> getImgList(String registNo, String currenttime) {
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT * FROM weixin_claim_image t where t.caseno = ? and t.uploadtime = ? ");
		logger.info("发送非车理赔照片信息列表sql："+sql.toString());
		
		List<Map<String, Object>> imglist = this.findForJdbc(sql.toString(), new String[]{registNo,currenttime});
		return imglist;
	}
	
	/**
	 * 发送核心状态,0表示待发送,1表示发送成功,2表示发送失败
	 * 
	 * @param mediaid
	 * @param status
	 * @return
	 */
	@Override
	public Integer updateStatus(String imageName,String status) {
		StringBuffer sql = new StringBuffer();
		sql.append(" update weixin_claim_image t set t.status = ? where t.localpath  like '%"+imageName+"'");
		
		Integer size= this.executeSql(sql.toString(), new String[]{status});
		return size;
	}
	
}
