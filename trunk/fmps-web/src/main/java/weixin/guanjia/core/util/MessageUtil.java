package weixin.guanjia.core.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.jeecgframework.core.util.ApplicationContextUtil;
import org.jeecgframework.core.util.MyBeanUtils;
import org.jeecgframework.web.cgform.engine.FreemarkerHelper;
import weixin.guanjia.core.entity.message.customer.BaseCustomerMessage;
import weixin.guanjia.core.entity.message.customer.Image;
import weixin.guanjia.core.entity.message.customer.ImageCustomerMessage;
import weixin.guanjia.core.entity.message.customer.Text;
import weixin.guanjia.core.entity.message.customer.TextCustomerMessage;
import weixin.guanjia.core.entity.message.resp.Article;
import weixin.guanjia.core.entity.message.resp.BaseMessageResp;
import weixin.guanjia.core.entity.message.resp.NewsMessageResp;
import weixin.guanjia.core.entity.message.resp.TextMessageResp;
import cn.com.fubon.fo.customermessage.entity.CustomerMessageRecord;
import cn.com.fubon.handler.MessageHandler;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;

public class MessageUtil {
		
	/**
	 * 解析微信发来的请求（XML）
	 * 
	 * @param request
	 * @return
	 * @throws IOException
	 * @throws DocumentException
	 * @throws Exception
	 */
	private static final Logger logger = Logger.getLogger(MessageUtil.class);
	
	@SuppressWarnings("unchecked")
	public static Map<String, String> parseXml(HttpServletRequest request)
			throws IOException, DocumentException {
		
		// 将解析结果存储在HashMap中
		Map<String, String> map = new HashMap<String, String>();

		// 从request中取得输入流
		InputStream inputStream = request.getInputStream();
		// 读取输入流
		SAXReader reader = new SAXReader();
		Document document = reader.read(inputStream);		
		// 得到xml根元素
		Element root = document.getRootElement();
		// 得到根元素的所有子节点
		List<Element> elementList = root.elements();

		// 遍历所有子节点
		for (Element e : elementList)
			map.put(e.getName(), e.getText());

		//将原始的XML存入Map
		map.put("rawMessage", document.asXML());
		logger.info("原始的XML报文:"+document.asXML());
		// 释放资源
		inputStream.close();
		inputStream = null;

		return map;
	}

	/**
	 * 消息对象转换成xml
	 * 
	 * @param textMessage
	 *            消息对象
	 * @return xml
	 */
	public static <T extends BaseMessageResp> String messageToXml(T message) {
		xstream.alias("xml", message.getClass());
		if (message instanceof NewsMessageResp) {
			xstream.alias("item", Article.class);
			//xstream.alias(name, Item);
		}
		return xstream.toXML(message);
	}

	/**
	 * 音乐消息对象转换成xml
	 * 
	 * @param musicMessage
	 *            音乐消息对象
	 * @return xml
	 */
/*	public static String musicMessageToXml(MusicMessageResp musicMessage) {
		xstream.alias("xml", musicMessage.getClass());
		return xstream.toXML(musicMessage);
	}*/

	/**
	 * 图文消息对象转换成xml
	 * 
	 * @param newsMessage
	 *            图文消息对象
	 * @return xml
	 * @throws Exception 
	 */
/*	public static String newsMessageToXml(NewsMessageResp newsMessage) {
		xstream.alias("xml", newsMessage.getClass());
		xstream.alias("item", new Article().getClass());
		return xstream.toXML(newsMessage);
	}*/
	
	public static BaseCustomerMessage convertCustomerMessage(CustomerMessageRecord customerMessageRecord) throws Exception {
		
		BaseCustomerMessage baseCustomerMessage = null;
		if (customerMessageRecord.getMsgtype().equals("text")) {
			baseCustomerMessage = new TextCustomerMessage();
			Text text = new Text(customerMessageRecord.getContent());
			
			((TextCustomerMessage)baseCustomerMessage).setText(text);
		}else if (customerMessageRecord.getMsgtype().equals("image")) {
			baseCustomerMessage = new ImageCustomerMessage();
			Image image = new Image(customerMessageRecord.getMediaId());
			
			((ImageCustomerMessage)baseCustomerMessage).setImage(image);
		}
		
		baseCustomerMessage = copyCustomerMessageRecordProperties(customerMessageRecord, baseCustomerMessage);
		return baseCustomerMessage;
	}
	
	private static <T extends BaseCustomerMessage> T copyCustomerMessageRecordProperties(CustomerMessageRecord customerMessageRecord, 
				T baseCustomerMessage) throws Exception {
		MyBeanUtils.copyBeanNotNull2Bean(customerMessageRecord, baseCustomerMessage);
		
		return baseCustomerMessage;
	}
	
	/**
	 * 根据微信消息类型获取实际的消息处理类。<br />
	 * 注意：这里的messageType直接取的是微信传过来的消息类型，即第一个字母是小写。
	 * 
	 * @param messageType
	 * @return
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
//	public static MessageHandler getActualMessageHandler(String messageType) throws ClassNotFoundException, InstantiationException, IllegalAccessException{
//		String handlerPackageName = "cn.com.fubon.handler.imp.message.";
//		String suffix = "MessageHandler";
//		
//		String convertedMessageType = StringUtil.firstUpperCase(null);
//		
//		Class clazz = Class.forName(handlerPackageName + convertedMessageType + suffix);
//		Object handler = clazz.newInstance();
//		
//		return (MessageHandler)handler;
//	}

	
	public static MessageHandler getActualMessageHandler(String messageType) throws ClassNotFoundException, InstantiationException, IllegalAccessException{
	
		String message =messageType.toLowerCase(); //转换为小写。
		String suffix = "MessageHandler";
		String messageHandler=message+suffix;
	
		MessageHandler handler = (MessageHandler) ApplicationContextUtil.getContext().getBean(messageHandler);
		
		return (MessageHandler)handler;
	}

	
	
	
	
	
	
	
	
	
	/**
	 * 生成关注后的欢迎信息
	 * 
	 * @param requestMap
	 * @return
	 */
	public static TextMessageResp generateWelcomeMessage(Map<String, String> requestMap){

		// 发送方帐号（open_id）
		String fromUserName = requestMap.get("FromUserName");
		// 公众帐号
		String toUserName = requestMap.get("ToUserName");
		// 消息类型
		String msgType = requestMap.get("MsgType");
		String msgId = requestMap.get("MsgId");
		
		TextMessageResp textMessage = new TextMessageResp();
		textMessage.setToUserName(fromUserName);
		textMessage.setFromUserName(toUserName);
		textMessage.setCreateTime(new Date().getTime());
		textMessage.setContent(getWelcomeConent());
		
		return textMessage;
	}
	
	/**
	 * 欢迎语
	 * 
	 * @return
	 */
	public static String getWelcomeConent() {
		// 复杂字符串文本读取，采用文件方式存储
		String html = new FreemarkerHelper().parseTemplate(
				"/weixin/welcome.ftl", null);
		return html;
	}
	
	/**
	 * 扩展xstream，使其支持CDATA块
	 * 
	 * @date 2013-05-19
	 */
	private static XStream xstream = new XStream(new XppDriver() {
		public HierarchicalStreamWriter createWriter(Writer out) {
			return new PrettyPrintWriter(out) {
				// 对所有xml节点的转换都增加CDATA标记
				boolean cdata = true;

				@SuppressWarnings("unchecked")
				public void startNode(String name, Class clazz) {
					super.startNode(name, clazz);
				}

				protected void writeText(QuickWriter writer, String text) {
					if (cdata) {
						writer.write("<![CDATA[");
						writer.write(text);
						writer.write("]]>");
					} else {
						writer.write(text);
					}
				}
			};
		}
	});
	
	public static void main(String[] args) throws Exception {
		
		/*Map<String, String> maps = new HashMap<String, String>();
		maps.put("FromUserName", "FromUserName");
		maps.put("ToUserName", "ToUserName");
		maps.put("MsgType", "MsgType");
		maps.put("MsgId", "MsgId");
		
		ImageMessageResp imr = new ImageMessageResp();
		imr.setCreateTime(1000);
		imr.setFromUserName("wbb");
		imr.setToUserName("aaa");
		Image image = new Image();
		image.setMediaId("123123");
		imr.setImage(image);
		
		String xml = MessageUtil.messageToXml(imr);
		System.out.println(xml);
		
		
		CustomerMessageRecord cmr = new CustomerMessageRecord();
		cmr.setMsgtype("image");
		cmr.setTouser("toUser");
		cmr.setMediaId("123456");
		cmr.setContent("hello, world");
		
		BaseCustomerMessage bcm = convertCustomerMessage(cmr);
		
		JSONObject jsonObj = JSONObject.fromObject(bcm);
		System.out.println(jsonObj.toString());
		*/
		Map<String, Object> openid = new HashMap<String, Object>();
		openid.put("id", "testsetset");
		
		MessageUtil messageUtil=new MessageUtil();
		String html=	new FreemarkerHelper().parseTemplate("/weixin/welcome.ftl", openid);
		System.out.println(html);
		
	}
	
}
