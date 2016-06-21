/**
 * 
 */
package weixin.guanjia.core.entity.message.customer;

import java.util.List;

/**
 * @author binbin.wang
 *
 */
public class NewsCustomerMessage extends BaseCustomerMessage {

	private List<Article> news;
		
	public NewsCustomerMessage() {
		this.msgtype = "news";
	}

	public List<Article> getNews() {
		return news;
	}
	
	public void setNews(List<Article> news) {
		this.news = news;
	}
	
}
