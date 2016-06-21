/**
 * 
 */
package cn.com.fubon.fo.cashcoupon.service;

import java.util.List;
import java.util.Map;

import org.jeecgframework.core.common.service.CommonService;

import weixin.idea.huodong.entity.HuodongEntity;

/**
 * @author qingqu.huang
 *
 */
public interface CashCouponService extends CommonService {

	/**
	 * 根据openid判断用户是否关注公众号
	 * 
	 * @param openid
	 * @return
	 */
	public boolean checkUserByOpenid(String openid);

	/**
	 * 根据活动ID获取未使用的卡
	 * 
	 * @param huodongid
	 *            活動ID
	 * @return
	 */
	public List<Map<String, Object>> getCardList(String huodongid);

	/**
	 * 根据openid和huodongid获取用户领取的赠险
	 * 
	 * @param openid
	 * @param huodongid
	 * @return
	 */
	public Map<String, Object> getCashCouponMap(String openid, String huodongid);

	/**
	 * 获取微信红包请求xml
	 * 
	 * @param openid
	 *            微信用户openid
	 * @param client_ip
	 *            客户端ip
	 * @param mch_billno
	 *            订单号
	 * @param total_amout
	 *            红包金额
	 * @param min_value
	 *            红包最小值
	 * @param max_value
	 *            红包最大值
	 * @param total_num
	 *            红包数量
	 * @param huodongid
	 *            活动编号
	 * @return
	 */
	public String getRequestXml(String openid, String client_ip,
			int total_amout, int min_value, int max_value, int total_num,
			String huodongid, String fromtag, String cashcouponid,int seqid);

	/**
	 * 发送红包方法
	 * 
	 * @param requestxml
	 *            请求xml
	 * @param url
	 *            微信红包请求url
	 * @param mch_id
	 *            商户号
	 * @param certname
	 *            证书名称
	 * @return
	 * @throws Exception
	 */
	public String post(String requestxml, String url, String certname)
			throws Exception;

	/**
	 * 领取赠险
	 * 
	 * @param openid
	 * @param huodongid
	 * @param cardno
	 * @param password
	 */
	public void updateCard(String openid, String huodongid,int seqid);

	/**
	 * 判断是否在活动区间
	 * 
	 * @param huodongEntity
	 * @return
	 */
	public boolean isRangeOfDate(HuodongEntity huodongEntity);

	/**
	 * 设置用户手机号
	 * 
	 * @param phonenum
	 *            手机号码
	 * @param identifynumber
	 *            身份证号
	 * @param openid
	 */
	public void setPhonenumForUser(String phonenum, String openid);

	/**
	 * 根据活动编号获取微信红包领取记录前20条
	 * 
	 * @param huodongid
	 *            活动编号
	 * @return
	 */
	public List<Map<String, Object>> getCashHistoryList(String huodongid);

	/**
	 * 根据key值获取相关配置信息
	 * 
	 * @param key
	 * @return
	 */
	public Map<String, String> getConfigMap(String key, String huodongid);

	/**
	 * 统计红包发放金额
	 * 
	 * @return
	 */
	public int getSum(String huodongid);

	/**
	 * 设置红包发放结果
	 * 
	 * @param returncode
	 * @param openid
	 * @param huodongid
	 */
	public void updatecashCouponStatus(String returncode, String openid, String huodongid);

	/**
	 * 计算该方案已发放红包个数
	 * 
	 * @param maxvalue
	 * @param minvalue
	 * @param huodongid
	 * @return
	 */
	public int findHistoryList(Float maxvalue, Float minvalue, String huodongid);

	/**
	 * 计算该方案红包个数
	 * 
	 * @param maxvalue
	 * @param minvalue
	 * @param huodongid
	 * @return
	 */
	public int getCountNum(String huodongid);

	/**
	 * 初始化红包
	 * 
	 * @param huodongEntity
	 * @return
	 */
	public void initcashcoupon(HuodongEntity huodongEntity);

	/**
	 * 获取下一个红包的编号和金额
	 * 
	 * @return
	 */
	public Map<String, Object> getNext(String huodongid);

	/**
	 * 根据活动ID获取红包数据list
	 * 
	 * @param huodongid
	 * @param index
	 * @return
	 */
	public List<Map<String, Object>> getNextCouponList(String huodongid,
			int index);

	/**
	 * 判断当前时间是否在于00:00:00~08:00:00之间
	 * 
	 * @return
	 */
	public boolean checkTime();

	/**
	 * 通过微信查询红包接口获取红包发放结果
	 * 
	 * @param mch_billno
	 * @param openid
	 * @return
	 */
	public boolean queryCouponResut(String mch_billno, String openid);

	/**
	 * 根据红包序列号获取红包数据
	 * 
	 * @param seqid
	 * @return
	 */
	public Map<String, Object> getCashCoupon(int seqid, String huodongid);

	/**
	 * 获取红包序列号
	 * 
	 * @param openid
	 * @return
	 */
	public int getSeqid(String openid, String huodongid);

	/**
	 * 获取红包总个数
	 * 
	 * @param huodongid
	 * @return
	 */
	public int getCount(String huodongid);
	
	public Map<String, Object> sendCashcoupon(String requestxml, String url, String certname,String openid,String huodongid,String activedProfile) throws Exception ;
	
	public String getCashCouponAmount(String openid, String huodongid) throws Exception;
	
	public Map<String, Object> getCashCoupon(String openid,String huodongid);
	
	public List<Map<String, Object>> getCouponList(String huodongid,String ip);
	
	public boolean saveCouponRecord(String amount,String hdid,String openid);
}
