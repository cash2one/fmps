package weixin.popular.util;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonUtil {

	private static Logger log = LoggerFactory.getLogger(JsonUtil.class);

	private JsonUtil() {
	}

	public static <T> T parseObject(String json, Class<T> clazz) {
		return JSON.parseObject(json, clazz);
	}

	public static String toJSONString(Object object) {
		return JSON.toJSONString(object);
	}

	public static Gson create() {
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setDateFormat("yyyy/MM/dd HH:mm:ss");
		return gsonBuilder.create();
	}

	// 对象转json
	public static String toJson(Object object) {
		try {
			String str = JsonUtil.create().toJson(object);
			return str;
		} catch (Exception e) {
			log.error("[toJson]" + e);
			return "";
		}
	}

	// 往页面写数据
	public static void outWrite(HttpServletResponse response, String data) {
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (Exception e) {
			log.error("[outWrite]" + e);
		} finally {
			if (out != null) {
				if (data != null) {
					out.write(data);
				}
				out.close();
			}
		}
	}

	// 对象转json加[]
	public static String toJsonforTree(Object object) {
		try {
			String str = JsonUtil.create().toJson(object);
			if (str != null && str.length() > 0
					&& !str.substring(0, 1).equals("[")) {
				str = "[" + str + "]";
			}
			return str;
		} catch (Exception e) {
			log.error("[toJsonforTree]" + e);
			return "";
		}
	}
}
