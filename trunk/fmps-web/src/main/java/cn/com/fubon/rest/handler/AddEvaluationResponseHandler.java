package cn.com.fubon.rest.handler;

import org.apache.commons.chain.Context;
import org.apache.log4j.Logger;
/**
 * 维修厂新增评价接口响应业务处理
 * @author fangfang.guo
 *
 */
public class AddEvaluationResponseHandler extends DefaultRestWSResponseHandler{
	Logger logger = Logger.getLogger(AddEvaluationResponseHandler.class);

	@Override
	public void process(Context context) {
		logger.info("正在进行维修厂新增评价接口响应业务处理...");
	}
}
