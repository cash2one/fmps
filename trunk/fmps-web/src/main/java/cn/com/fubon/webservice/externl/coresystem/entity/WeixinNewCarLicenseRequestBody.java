package cn.com.fubon.webservice.externl.coresystem.entity;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import cn.com.fubon.webservice.entity.request.FbNewCarLicenseRequestBody;

//别名在对象转XML时需要
@XStreamAlias("policyInfo")
public class WeixinNewCarLicenseRequestBody extends FbNewCarLicenseRequestBody{
	
	public WeixinNewCarLicenseRequestBody(){
		
	}
	
	
}
