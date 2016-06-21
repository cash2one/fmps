/**
 * 
 */
package cn.com.fubon.exceptions;

/**
 * 无效的消息异常
 * 
 * @author pollux
 *
 */
public class InvalidMessageException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public InvalidMessageException(String message) {
		super(message);
	}

	public InvalidMessageException(Throwable cause) {
		super(cause);
	}

	public InvalidMessageException(String message, Throwable cause) {
		super(message, cause);
	}
}
