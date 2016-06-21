package cn.com.fubon.util;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.Logger;

/**
 * @author binbin.wang
 *
 */
public class AESUtils {

	public static final String KEY_ALGORITHM = "AES";
	
	public static final String CIPHER_ALGORITHM = "AES/ECB/PKCS5Padding";
	
	private static Key toKey(byte[] key){
		SecretKey secreKey = new SecretKeySpec(key, KEY_ALGORITHM);
		return secreKey;
	}
	
	public static byte[] initKey(String password) throws NoSuchAlgorithmException, UnsupportedEncodingException{
		KeyGenerator keyGenerator = KeyGenerator.getInstance(KEY_ALGORITHM);
		
		//AES要求密钥长度为128、192、256
		//以下两行代码创建的secureRandom用于解决linux上解密失败的问题
		SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");  
	    secureRandom.setSeed(password.getBytes("UTF-8"));
		keyGenerator.init(256, secureRandom);
		
		//生成密钥
		SecretKey secretKey = keyGenerator.generateKey();
		
		//返回密钥的二进制形式
		return secretKey.getEncoded();
	}
	
	/**
	 * 加密 
	 * 
	 * @param data 需加密的数据
	 * @param key  密钥
	 * @return
	 * @throws InvalidKeyException
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchPaddingException
	 * @throws IllegalBlockSizeException
	 * @throws BadPaddingException
	 */
	public static byte[] encrypt(byte[] data, byte[] key) 
			throws InvalidKeyException, NoSuchAlgorithmException, 
				NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException{
		
		Key k = toKey(key);
		Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
		
		//初始化，执行加密模式
		cipher.init(Cipher.ENCRYPT_MODE, k);
		
		return cipher.doFinal(data);
	}
	
	/**
	 * 解密
	 * 
	 * @param data 需解密的数据
	 * @param key  密钥
	 * @return
	 * @throws InvalidKeyException
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchPaddingException
	 * @throws IllegalBlockSizeException
	 * @throws BadPaddingException
	 */
	public static byte[] decrypt(byte[] data, byte[] key) 
			throws InvalidKeyException, NoSuchAlgorithmException, 
			NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException{
		//还原秘钥
		Key k = toKey(key);
		Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
		
		//初始化，执行解密模式
		cipher.init(Cipher.DECRYPT_MODE, k);
		
		return cipher.doFinal(data);
	}
	
	/**
	 * 报文加密
	 * 
	 * @param json
	 *            交易报文明文
	 * @param AESKey
	 *            AES密钥
	 */
	public static String encryptData(String data, byte[] AESKey) {
		byte[] jsonData = null;
		try {
			jsonData = data.getBytes("UTF-8");
			jsonData = AESUtils.encrypt(jsonData, AESKey);
		} catch (InvalidKeyException | NoSuchAlgorithmException
				| NoSuchPaddingException | IllegalBlockSizeException
				| BadPaddingException | UnsupportedEncodingException e) {
			Logger.getLogger(AESUtils.class).error("encrypt failed,data:\n" + data, e);
		}

		return Base64.encodeBase64String(jsonData);
	}
}

