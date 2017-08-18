package org.wg.string.util;

import java.io.UnsupportedEncodingException;

public class StringUtils {
	/**
	 * 英语字母大写
	 * @param str
	 * @param encode
	 * @return
	 */
	public static String UpperFirst(String str,String encode){
		if(str.length()>0) {
			try {
				byte[] charArray = str.getBytes(encode);
				charArray[0]-=32;
				return new String(charArray,encode);
			} catch (UnsupportedEncodingException e) {
				throw new RuntimeException("编码异常");
			}
		}
		return "";
	}
	public static String UpperFirst(String str){
		return UpperFirst(str,"UTF-8");
	}
	
	/**
	 * str不为null并且不为""
	 * @param str
	 * @return true 表示str为null或“”
	 */
	public static boolean nullEpt(String str){
		return str==null||"".equals(str.trim());
	}
	
	
	public static void main(String[] args) {
		String test ="test";
		String first = UpperFirst(test);
		System.out.println(first);
		System.out.println(nullEpt(""));
		System.out.println(nullEpt(null));
	}
	
	
	
	
}
