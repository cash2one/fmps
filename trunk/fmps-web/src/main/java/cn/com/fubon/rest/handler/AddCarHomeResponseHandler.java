package cn.com.fubon.rest.handler;

import org.apache.commons.chain.Context;
import org.apache.log4j.Logger;

public class AddCarHomeResponseHandler implements RestResponseHandler{
	Logger logger = Logger.getLogger(AddCarHomeResponseHandler.class);
	@Override
	public void process(Context context) throws Exception {
	 
		logger.info("爱车之家首页报文获取ResponseHandler...");
	}

}
