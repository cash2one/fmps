package cn.com.fubon.webservice.entity.request;

public class FbTelesaleRequestBody extends RequestBody{
	
	private String paramNames;
	private String params;
	private String wsClientBeanName;
	
	public FbTelesaleRequestBody(){
		
	}

	public String getParamNames() {
		return paramNames;
	}

	public void setParamNames(String paramNames) {
		this.paramNames = paramNames;
	}

	public String getParams() {
		return params;
	}

	public void setParams(String params) {
		this.params = params;
	}

	public String getWsClientBeanName() {
		return wsClientBeanName;
	}

	public void setWsClientBeanName(String wsClientBeanName) {
		this.wsClientBeanName = wsClientBeanName;
	}
	
}
