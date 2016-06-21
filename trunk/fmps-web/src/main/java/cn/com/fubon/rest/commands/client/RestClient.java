package cn.com.fubon.rest.commands.client;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;
public class   RestClient {
	private static  Client client ;	
	static{
		ClientConfig clientConfig = new DefaultClientConfig();
		clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING,Boolean.TRUE);
		client = Client.create(clientConfig);			
	     }
	public static Client  getClient() {		
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}	
}
