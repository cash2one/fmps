/**
 * 
 */
package cn.com.fubon.webservice.externl.coresystem.resphandler;

import org.apache.commons.chain.Context;

/**
 * @author binbin.wang
 *
 */
public class WeixinBindWSResponseHandler extends DefaultCoreWSResponseHandler {

	@Override
	public String getWsClientBeanName() {
		return "coreosWSClientWeixinBind";
	}

	@Override
	public void convertExternalResponseToInnerResponse(Context context) {
		// TODO Auto-generated method stub
	};
	
	@Override
	public void process(Context context) {
		//认证接口是异步调用,WS定时任务重发会把调用方式改为同步,所有处理在定时任务重发的代码中会处理
	}
}
