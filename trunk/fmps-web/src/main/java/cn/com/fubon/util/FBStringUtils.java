/**
 * 
 */
package cn.com.fubon.util;

import java.util.List;
import java.util.Random;
import org.apache.commons.lang.StringUtils;
import org.jeecgframework.core.util.StringUtil;

/**
 * @author binbin.wang
 *
 */
public final class FBStringUtils {

	/**
	 * 检查路径与给定列表中的路径是否匹配
	 * 
	 * @param pathList
	 * @param checkPath
	 * @return
	 */
public static boolean checkPathMatch(List<String> pathList, String checkPath) {
		
		//传入的checkPath前面的"/"会被移除，这里收到加上
		if (!StringUtils.isBlank(checkPath) && checkPath.charAt(0) != '/')
			checkPath = "/" + checkPath;

		for(String path : pathList) {
			//完全匹配
			if (checkPath.equals(path))
				return true;
			
			//通配符匹配，暂时支持/path/**
			if (path.indexOf("**") != -1) {
				String prefix = org.apache.commons.lang.StringUtils.substring(path, 0, path.indexOf("**"));
				if (checkPath.startsWith(prefix))
					return true;
			}
		}
		
		return false;
	}
	
	/**
	 * @param randCodeType 决定随机码字符类型
	 * @param randCodeLength 决定随机码的长度
	 * @return 用于生成随机码
	 */
	public static String exctractRandCode(String randCodeType,int randCodeLength) {

		switch (randCodeType.charAt(0)) {
		case '1':
			return RandCodeEnum.NUMBER_CHAR.generateStr(randCodeLength);
		case '2':
			return RandCodeEnum.LOWER_CHAR.generateStr(randCodeLength);
		case '3':
			return RandCodeEnum.UPPER_CHAR.generateStr(randCodeLength);
		case '4':
			return RandCodeEnum.LETTER_CHAR.generateStr(randCodeLength);
		case '5':
			return RandCodeEnum.ALL_CHAR.generateStr(randCodeLength);

		default:
			return RandCodeEnum.NUMBER_CHAR.generateStr(randCodeLength);
		
		}
	}
	
	/**
	 * 验证码辅助类
	 */
	enum RandCodeEnum {
		/**
		 * 混合字符串
		 */
		ALL_CHAR("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"),
		/**
		 * 字符
		 */
		LETTER_CHAR("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"),
		/**
		 * 小写字母
		 */
		LOWER_CHAR("abcdefghijklmnopqrstuvwxyz"),
		/**
		 * 数字
		 */
		NUMBER_CHAR("0123456789"),
		/**
		 * 大写字符
		 */
		UPPER_CHAR("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
		/**
		 * 待生成的字符串
		 */
		private String charStr;

		/**
		 * @param charStr
		 */
		private RandCodeEnum(final String charStr) {
			this.charStr = charStr;
		}

		/**
		 * 生产随机验证码
		 * 
		 * @param codeLength
		 *            验证码的长度
		 * @return 验证码
		 */
		public String generateStr(final int codeLength) {
			final StringBuffer sb = new StringBuffer();
			final Random random = new Random();
			final String sourseStr = getCharStr();

			for (int i = 0; i < codeLength; i++) {
				sb.append(sourseStr.charAt(random.nextInt(sourseStr.length())));
			}

			return sb.toString();
		}

		/**
		 * @return the {@link #charStr}
		 */
		public String getCharStr() {
			return charStr;
		}

	}
	
	/**
	 * 合法手机号校验
	 */
	public static boolean checkMobile(String mobile){
		//如果手机号为null或空字符串则返回false
		if(StringUtil.isEmpty(mobile)){
			return false;
		}
		
		return mobile.matches("1[0-9]{10}");
	}
	
	/**
	 * 校验是否至少存在一个空或空字符串
	 */
	public static boolean isAnyEmpty(String... strings){
		for (String string : strings) {
			if (StringUtil.isEmpty(string) == true) {
				return true;
			}
		}
		return false;
	}
	

}
