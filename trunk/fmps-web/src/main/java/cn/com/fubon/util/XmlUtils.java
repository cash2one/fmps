/**
 * 
 */
package cn.com.fubon.util;

import java.util.Map;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.XmlFriendlyNameCoder;
import com.thoughtworks.xstream.io.xml.XppDriver;

/**
 * XML工具类
 * 
 * @author binbin.wang
 *
 */
public final class XmlUtils {

	private static XStream xstream;
	
	static {
		setXstream(new XStream(new XppDriver(new XmlFriendlyNameCoder("_-", "_"))));
		getXstream().autodetectAnnotations(true);
	}
	
	public static String toXML(Object obj) {
		getXstream().aliasSystemAttribute(null, "class");
		return getXstream().toXML(obj);
	}
	
	public static Object fromXML(String xml, Object... alias) {
		XStream	xstream	=new XStream(new XppDriver(new XmlFriendlyNameCoder("_-", "_")));
        xstream.autodetectAnnotations(true);
       for(int i = 0; i < alias.length; i=i+2) {
	      xstream.alias(alias[i].toString(), (Class)alias[i+1]);
           }
         return xstream.fromXML(xml);	
	}
	
	public static String toXML(Object obj, Object... alias) {
		for(int i = 0; i < alias.length; i=i+2) {
			getXstream().alias(alias[i].toString(), (Class)alias[i+1]);
		}		
		return getXstream().toXML(obj);
	}

	public static XStream getXstream() {
		return xstream;
	}

	public static void setXstream(XStream xstream) {
		XmlUtils.xstream = xstream;
	}
}
