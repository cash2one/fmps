package cn.com.fubon.webservice.entity.request;

import cn.com.fubon.webservice.externl.coresystemUnderwrite.entity.request.Application;

import com.thoughtworks.xstream.annotations.XStreamAlias;


/**
 * 核心承保接口用到的内部RequestBody
 *
 */
public class FbCoreUnderwriteRequestBody extends RequestBody{
	
	@XStreamAlias("APPLICATION")
	private Application application;

	public Application getApplication() {
		return application;
	}
	public void setApplication(Application application) {
		this.application = application;
	}

}
