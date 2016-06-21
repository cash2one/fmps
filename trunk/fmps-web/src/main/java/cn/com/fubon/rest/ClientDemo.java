package cn.com.fubon.rest;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.Logger;

import weixin.guanjia.core.util.SignUtil;
import cn.com.fubon.util.AESUtils;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;
import com.sun.jersey.core.util.MultivaluedMapImpl;

public class ClientDemo {
	private static final Logger logger = Logger.getLogger(ClientDemo.class);

	public static void main(String[] args) throws Exception {
		ClientConfig clientConfig = new DefaultClientConfig();
		clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING,
				Boolean.TRUE);
		Client c = Client.create(clientConfig);
		String url = "http://localhost:8080/fmps/rest/students/";
		WebResource r = c.resource(url);
		String token = "ABCDEFGHIJKLMNOP";
		String AESKey = "ABCDEFGHIJKLMNOPABCDEFGHIJKLMNOPABCDEFGHIJK";

		String timestamp = "2015-05-21 09:46:00";
		String clientCode = "100";
		String signature = null;
		// String inputXml = "{'name':'swf','dept':'程序五科'}";
		String inputXml = "<?xml version='1.0' encoding='UTF-8' ?>" + "<CPWS>"
				+ "<CPWS_HEAD>" + "<CPWS_SEQNO>20150521243785</CPWS_SEQNO>"
				+ "<CPWS_DATE>20150521</CPWS_DATE>"
				+ "<CPWS_TIME>155824</CPWS_TIME>"
				+ "<CPWS_CODE>CLM001</CPWS_CODE>" + "<CPWSSERVER_CODE />"
				+ "<CPWSCLIENT_CODE>100</CPWSCLIENT_CODE>" + "</CPWS_HEAD>"
				+ "</CPWS>";

		// 报文加密
		byte[] inputData = inputXml.getBytes();
		inputData = AESUtils.encrypt(inputData, AESUtils.initKey(AESKey));
		inputXml = Base64.encodeBase64String(inputData);

		signature = SignUtil.generateSignature(token, timestamp, inputXml);

		MultivaluedMap<String, String> param = new MultivaluedMapImpl();
		param.add("timestamp", timestamp);
		param.add("signature", signature);
		param.add("inputXml", inputXml);
		param.add("clientCode", clientCode);
		String respone = r.path("getEnCode").queryParams(param)
				.type(MediaType.APPLICATION_JSON).put(String.class);
		logger.info(respone);
		logger.info(new String(AESUtils.decrypt(
				Base64.decodeBase64(respone.getBytes("UTF-8")),
				AESUtils.initKey(AESKey))));

		// Student stu = new Student();
		// // stu.setId(3);
		// stu.setName("沈文锋");
		// stu.setDept("程序五科");
		//
		// ClientResponse response1 = r.path("addStudent")
		// .accept(new String[] { MediaType.TEXT_PLAIN })
		// .entity(stu, MediaType.APPLICATION_XML)
		// .post(ClientResponse.class);
		//
		// logger.info(response1);

		// logger.info(r.path("list").get(String.class));

		// MultivaluedMap<String, String> param = new MultivaluedMapImpl();
		// param.add("studentid", "2");
		// param.add("name", "陈某某");
		// param.add("dept", "商务推广部");
		//
		// ClientResponse response2 = r.path("put").queryParams(param)
		// .type(MediaType.APPLICATION_XML).put(ClientResponse.class);
		// logger.info(response2);

	}
}
