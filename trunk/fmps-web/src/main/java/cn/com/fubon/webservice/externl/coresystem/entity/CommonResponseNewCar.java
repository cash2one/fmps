package cn.com.fubon.webservice.externl.coresystem.entity;

import java.util.Map;

import cn.com.fubon.util.MapConverter;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;

@XStreamAlias("Underwrite")
public class CommonResponseNewCar  {
	
	@XStreamAlias("sender")
	private ResponseSender sender;
	
	@XStreamAlias("endorseInfo")
	@XStreamConverter(MapConverter.class)
	private Map<String, String> endorseInfo;	
	
	public ResponseSender getSender() {
		return sender;
	}

	public void setSender(ResponseSender sender) {
		this.sender = sender;
	}	

	public Map<String, String> getEndorseInfo() {
		return endorseInfo;
	}

	public void setEndorseInfo(Map<String, String> endorseInfo) {
		this.endorseInfo = endorseInfo;
	}
	
	
}
