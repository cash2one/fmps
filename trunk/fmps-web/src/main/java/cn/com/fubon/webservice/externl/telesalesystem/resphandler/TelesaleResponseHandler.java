package cn.com.fubon.webservice.externl.telesalesystem.resphandler;

/**
 * 电销webservice返回处理
 * @author fangfang.guo
 */

import cn.com.fubon.pay.entity.WeiXinOfflineOrderInfo;
import cn.com.fubon.webservice.entity.request.FbWSRequest;
import cn.com.fubon.webservice.externl.telesalesystem.entity.TelesaleResponse;

public interface TelesaleResponseHandler{

	/**
	 * 同步请求处理
	 * @param telesaleResponse
	 * @return
	 */
	public WeiXinOfflineOrderInfo process(TelesaleResponse telesaleResponse);
	
	/**
	 * 异步请求处理
	 * @param telesaleResponse
	 * @return
	 */
	public WeiXinOfflineOrderInfo asyncExecuteprocess(TelesaleResponse telesaleResponse);
	
	/**
	 * 保存出错信息
	 * @param fbWSRequest
	 */
	public void saveSendFailure(FbWSRequest fbWSRequest);

}
