package weixin.popular.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import weixin.guanjia.core.entity.message.resp.Article;
import weixin.guanjia.core.entity.message.resp.NewsMessageResp;

import com.sun.xml.txw2.output.CharacterEscapeHandler;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XmlFriendlyNameCoder;
import com.thoughtworks.xstream.io.xml.XppDriver;

/**
 * XML 数据接收对象转换工具类
 * 
 * @author LiYi
 *
 */
public class XMLConverUtil {

	private static Map<Class<?>, Unmarshaller> uMap = new HashMap<Class<?>, Unmarshaller>();
	private static Map<Class<?>, Marshaller> mMap = new HashMap<Class<?>, Marshaller>();

	/**
	 * XML to Object
	 * 
	 * @param <T>
	 * @param clazz
	 * @param xml
	 * @return
	 */
	public static <T> T convertToObject(Class<T> clazz, String xml) {
		return convertToObject(clazz, new StringReader(xml));
	}

	/**
	 * XML to Object
	 * 
	 * @param <T>
	 * @param clazz
	 * @param inputStream
	 * @return
	 */
	public static <T> T convertToObject(Class<T> clazz, InputStream inputStream) {
		return convertToObject(clazz, new InputStreamReader(inputStream));
	}

	/**
	 * XML to Object
	 * 
	 * @param <T>
	 * @param clazz
	 * @param reader
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> T convertToObject(Class<T> clazz, Reader reader) {
		try {
			if (!uMap.containsKey(clazz)) {
				JAXBContext jaxbContext = JAXBContext.newInstance(clazz);
				Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
				uMap.put(clazz, unmarshaller);
			}
			return (T) uMap.get(clazz).unmarshal(reader);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Object to XML
	 * 
	 * @param object
	 * @return
	 */
	public static String convertToXML(Object object) {
		try {
			if (!mMap.containsKey(object.getClass())) {
				JAXBContext jaxbContext = JAXBContext.newInstance(object.getClass());
				Marshaller marshaller = jaxbContext.createMarshaller();
				marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
				marshaller.setProperty(CharacterEscapeHandler.class.getName(),
						new CharacterEscapeHandler() {
							@Override
							public void escape(char[] ac, int i, int j, boolean flag,
									Writer writer) throws IOException {
								writer.write(ac, i, j);
							}
						});
				mMap.put(object.getClass(), marshaller);
			}
			StringWriter stringWriter = new StringWriter();
			mMap.get(object.getClass()).marshal(object, stringWriter);
			return stringWriter.getBuffer().toString();
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 扩展xstream，使其支持CDATA块 new XppDriver(new XmlFriendlyNameCoder("_-", "_"))
	 * 
	 * @date 2013-05-19
	 */
	private static XStream xstream = new XStream(new XppDriver(
			new XmlFriendlyNameCoder("_-", "_")) {
		@Override
		public HierarchicalStreamWriter createWriter(Writer out) {
			return new PrettyPrintWriter(out) {
				// 对所有xml节点的转换都增加CDATA标记
				boolean cdata = true;

				@Override
				@SuppressWarnings("unchecked")
				public void startNode(String name, Class clazz) {
					super.startNode(name, clazz);
				}

				@Override
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

	public static <T> String messageToXml(T message) {
		xstream.alias("xml", message.getClass());
		xstream.aliasAttribute("out__trade__no", "out_trade_no");
		if (message instanceof NewsMessageResp) {
			xstream.alias("item", Article.class);
			// xstream.alias(name, Item);
		}
		return xstream.toXML(message);
	}

}
