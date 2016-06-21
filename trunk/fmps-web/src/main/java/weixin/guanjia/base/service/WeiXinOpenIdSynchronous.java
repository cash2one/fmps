package weixin.guanjia.base.service;

import java.util.List;
import java.util.Map;

import org.jeecgframework.core.common.service.CommonService;

public interface WeiXinOpenIdSynchronous extends CommonService {
	
	//删除 中间表所有数据
	public void deleteWeixin_open_table();
	//获取没下载成功的OPENID
	public List<Map<String, Object>> getOpenidNotInGzuserinfo();
	//获取已经取消关注，关注表未删除的数据
	public List<Map<String, Object>> getUnSubscribeOpenId();
	//删除已经取消关注的用户
	public void deleteUnSubscribeUser(String openid);
}
