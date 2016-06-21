package cn.com.fubon.webservice.externl.coresystem.entity;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import cn.com.fubon.webservice.entity.request.FbClaimRequestBody;

//别名在对象生成XML时需要
@XStreamAlias("body")
public class ClaimRequestBody extends FbClaimRequestBody{
	public ClaimRequestBody(){
		
	}
	
	
}
