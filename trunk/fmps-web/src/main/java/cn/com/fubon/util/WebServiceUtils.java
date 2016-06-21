package cn.com.fubon.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.apache.log4j.Logger;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

/**
 * 
 * @author fangfang.guo
 *
 */
public class WebServiceUtils {
	static Logger logger = Logger.getLogger(WebServiceUtils.class);

	/**
	 * Kryo实现Object序列化 20150701
	 * @param obj
	 * @return
	 */
	public static byte[] serializeObject(Object obj){
		
		Kryo kryo = new Kryo();
		byte[] byteArr = null;
		if(obj != null){
			
			try(ByteArrayOutputStream bos = new ByteArrayOutputStream();
				    Output output = new Output(bos);){
				
				kryo.writeClassAndObject(output, obj);
				byteArr = output.toBytes();
				
				
			} catch (IOException e) {
				logger.error("WebServiceUtils serializeObject IOException");
				e.printStackTrace();
			}
		}
		
		return byteArr;
	}
	
	/**
	 * Kryo实现Object反序列化 20150701
	 * @param obj
	 * @return
	 */
	public static Object unserializeObject(byte[] byteArr){
		
		if(byteArr == null || byteArr.length == 0){
			return null;
		}
		
		Kryo kryo = new Kryo();
		Object obj = null;
		try(Input input = new Input(byteArr)){
			obj = kryo.readClassAndObject(input);
		}
		
		return obj;
	}
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Object obj = WebServiceUtils.unserializeObject(null);
		byte[] byteArr = WebServiceUtils.serializeObject(null);
		System.out.println();
	}

}
