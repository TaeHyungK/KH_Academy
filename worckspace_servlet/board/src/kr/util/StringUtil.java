package kr.util;

public class StringUtil {
	/*
	 * HTML �±׸� ������� ����
	 */
	
	public static String useNoHtml(String str) {
		if(str == null) return null;
		
		return str.replaceAll("<", "&lt;")
				  .replaceAll(">", "&gt;");
	}
}
