package weixin.guanjia.message.dao.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import org.apache.log4j.Logger;
import org.jeecgframework.core.common.dao.impl.GenericBaseCommonDao;
import org.jeecgframework.core.util.MyBeanUtils;
import org.springframework.stereotype.Repository;
import weixin.guanjia.message.dao.TextTemplateDao;
import weixin.guanjia.message.entity.TextTemplate;

@Repository("textTemplateDao")
public class TextTemplateDaoImpl extends GenericBaseCommonDao implements TextTemplateDao{

	private static final Logger logger = Logger.getLogger(TextTemplateDaoImpl.class);
	
	@Override
	public TextTemplate getTextTemplate(String accountid,String templateName){
		String sql = "select id,templateName,content,addTime,accountId from weixin_texttemplate where accountid = ? and templateName = ?";
		Map map = this.findOneForJdbc(sql,accountid,templateName);
		
		TextTemplate textTemplate = new TextTemplate();
		try{
			MyBeanUtils.copyMap2Bean(textTemplate,map);
		}catch(IllegalAccessException | InvocationTargetException e){
			logger.error("copy map to textTemplate failed",e);
		}
		return textTemplate;
	}

}
