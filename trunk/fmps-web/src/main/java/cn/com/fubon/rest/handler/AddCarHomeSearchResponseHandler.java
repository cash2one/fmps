package cn.com.fubon.rest.handler;

import org.apache.commons.chain.Context;
import org.apache.log4j.Logger;

public class AddCarHomeSearchResponseHandler implements RestResponseHandler{
	
	Logger logger = Logger.getLogger(AddCarHomeSearchResponseHandler.class);

	@Override
	public void process(Context context) throws Exception {
		
		logger.info("爱车之家查询结果数据ResponseHandler...");
	}

}
