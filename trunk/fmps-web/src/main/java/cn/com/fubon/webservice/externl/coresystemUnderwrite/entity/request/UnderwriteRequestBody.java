package cn.com.fubon.webservice.externl.coresystemUnderwrite.entity.request;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 微店承保请求报文BODY部分
 * 
 * @author yaoming.zhang
 */
@XStreamAlias("BODY")
public class UnderwriteRequestBody {
	
	@XStreamAlias("APPLICATION")
	private Application application;

	public Application getApplication() {
		return application;
	}
	public void setApplication(Application application) {
		this.application = application;
	}
}
