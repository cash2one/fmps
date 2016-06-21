package cn.com.fubon.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class RegexUtils {

	public static boolean isEmail(String email) {
		String str = "^([a-zA-Z0-9]*[-_]?[\\.]?[a-zA-Z0-9]+)*@([a-zA-Z0-9]*[-_]?[a-zA-Z0-9]+)+[\\.][A-Za-z]{2,3}([\\.][A-Za-z]{2})?$";
		Pattern p = Pattern.compile(str);
		Matcher m = p.matcher(email);
		return m.matches();
	}
	
	public static void main(String[] args) {
		boolean aaa = isEmail("yaoming_zhang@fubon.com.cn");
		boolean bbb = isEmail("yaoming.zhang@fubon.com.cn");
		boolean ccc = isEmail("271633500@qq.com");
		System.out.println(aaa);
		System.out.println(bbb);
		System.out.println(ccc);
	}
}
