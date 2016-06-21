package weixin.idea.extend.function.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;

import org.jeecgframework.core.util.ApplicationContextUtil;
import org.jeecgframework.core.util.ResourceUtil;

import weixin.guanjia.account.service.WeixinAccountServiceI;
import weixin.guanjia.core.entity.message.resp.Article;
import weixin.guanjia.core.entity.message.resp.BaseMessageResp;
import weixin.guanjia.core.entity.message.resp.NewsMessageResp;
import weixin.guanjia.core.entity.message.resp.TextMessageResp;
import weixin.guanjia.core.util.MessageUtil;
import weixin.idea.extend.function.KeyServiceI;

/**
 * 刮刮乐
 * 
 * @author zhangdaihao
 *
 */
public class GuagualeService implements KeyServiceI {

	@Override
	public String excute(String content, TextMessageResp defaultMessage) {
		WeixinAccountServiceI weixinAccountService = (WeixinAccountServiceI) ApplicationContextUtil
				.getContext().getBean("weixinAccountService");
		String accountid = weixinAccountService.findByToUsername(
				defaultMessage.getFromUserName()).getId();
		ResourceBundle bundler = ResourceBundle.getBundle("sysConfig");
		List<Article> articleList = new ArrayList<Article>();
		Article article = new Article();
		article.setTitle("刮刮乐");
		article.setDescription("刮刮乐咯");
		article.setPicUrl(ResourceUtil.getDomain()
				+ "/plug-in/weixin/images/ggl/card.png");
		article.setUrl(ResourceUtil.getDomain()
				+ "/zpController.do?goGglNew&accountid=" + accountid
				+ "&openId=" + defaultMessage.getToUserName());
		articleList.add(article);
		NewsMessageResp newsMessage = new NewsMessageResp();
		newsMessage.setToUserName(defaultMessage.getToUserName());
		newsMessage.setFromUserName(defaultMessage.getFromUserName());
		newsMessage.setCreateTime(new Date().getTime());
		newsMessage.setArticleCount(articleList.size());
		newsMessage.setArticles(articleList);
		return MessageUtil.messageToXml(newsMessage);
	}

	@Override
	public String getKey() {

		return "大转盘";
	}

	@Override
	public BaseMessageResp excuteReturnBaseMessage(String content,
			TextMessageResp defaultMessage) {
		// TODO Auto-generated method stub
		return null;
	}

}
