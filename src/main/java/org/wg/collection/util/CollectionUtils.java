package org.wg.collection.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CollectionUtils {
	/**
	 * 将泛型数组中的值以泛型spar链接起来，调用泛型的toString()方法
	 * @param strs
	 * @param spar
	 * @return
	 */
	public static <T> String join( T[] strs ,T spar ,boolean trim){
		StringBuilder sb = new StringBuilder();
		if(trim){
			for (T str : strs) 
				sb.append(str.toString()).append(spar.toString());
			
			if(sb.length()>0)
				sb.delete(sb.length()-spar.toString().length(),sb.length());
			return sb.toString();
		}
		for (T str : strs) 
			sb.append(str.toString().trim()).append(spar.toString());
		if(sb.length()>0)
			sb.delete(sb.length()-spar.toString().length(),sb.length());
		return sb.toString();
	}
	/**
	 * 将T[]数组按泛型spar拼接，去除“  ”
	 * @param strs
	 * @param spar
	 * @return
	 */
	public static <T> String join( T[] strs ,T spar ){
		return join( strs , spar ,true);
	}
	/**
	 * 将list中的数据按spar拼接
	 * @param strs
	 * @param spar
	 * @param trim 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> String join(Collection<T> strs,T spar,boolean trim){
		return join(strs.toArray((T[])new Object[0]),spar,trim);
	}
	
	/**
	 * 将String[]数组按spar字符串拼接，去除“  ”
	 * @param strs
	 * @param spar
	 * @return
	 */
	public static String join(String strs,String spar){
		return join(strs,spar);
	}
	
	
	/**
	 * 将List中的,去除“  ”
	 * @param strs
	 * @param spar
	 * @return
	 */
	public static String join(Collection<String> strs,String spar){
		return join(strs,spar,true);
	}
	
	public static void main(String[] args) {
		List<String>list = new ArrayList<String>(10);
		list.add("hello=10");
		list.add("hi =20");
		String join = CollectionUtils.join(list, "&");
		System.out.println(join);
	}
	
	
	
	
	
	
}
