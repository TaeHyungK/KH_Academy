package kr.util;

public class StringUtil {
	/*
	 * HTML 태그를 허용하지 않음
	 */
	
	public static String useNoHtml(String str) {
		if(str == null) return null;
		
		return str.replaceAll("<", "&lt;")
				  .replaceAll(">", "&gt;");
	}
}
