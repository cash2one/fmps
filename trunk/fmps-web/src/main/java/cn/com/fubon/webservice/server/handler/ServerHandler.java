package cn.com.fubon.webservice.server.handler;

import cn.com.fubon.webservice.entity.request.FbWSRequest;
import cn.com.fubon.webservice.entity.response.FbWSResponse;

public interface ServerHandler {
	public FbWSResponse process(FbWSRequest fbWSRequest);
}
