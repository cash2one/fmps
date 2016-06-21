/**
 * 
 */
package cn.com.fubon.webservice;

import javax.jws.WebService;

/**
 * 
 * @author binbin.wang
 *
 */
@WebService(targetNamespace=WsConstants.NS)
public interface IHelloWorldService {
	String sayHello();
}
