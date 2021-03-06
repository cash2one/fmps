package cn.com.fubon.rest;

import javax.ws.rs.core.MultivaluedMap;

import org.apache.log4j.Logger;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.util.MultivaluedMapImpl;

public class RestWsDemoTest {
	private String url = "http://localhost/fcps-web/rest/students";

	private static final Logger logger = Logger.getLogger(RestWsDemoTest.class);

	// @Test
	public void testDelete() {
		Client client = Client.create();
		WebResource webResource = client.resource(url + "/delete/1");
		ClientResponse response = webResource.delete(ClientResponse.class);

		logger.info("Response for delete request: " + response.getStatus());
	}

	// @Test
	public void testPut() {
		Client client = Client.create();
		WebResource webResource = client.resource(url + "/put");
		MultivaluedMap queryParams = new MultivaluedMapImpl();
		queryParams.add("studentid", "2");
		queryParams.add("name", "nametest");
		queryParams.add("dept", "depttest");
		ClientResponse response = webResource.queryParams(queryParams).put(
				ClientResponse.class, "foo:test");
		logger.info("Response for put request: " + response.getStatus());
	}
}