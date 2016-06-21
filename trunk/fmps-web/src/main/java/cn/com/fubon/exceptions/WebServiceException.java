/**
 * 
 */
package cn.com.fubon.exceptions;

/**
 * WebService异常
 * 
 * @author pollux
 *
 */
public class WebServiceException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public WebServiceException(String message) {
		super(message);
	}

	public WebServiceException(Throwable cause) {
		super(cause);
	}

	public WebServiceException(String message, Throwable cause) {
		super(message, cause);
	}
}
