package org.wg.orm.sql;

import java.util.List;

import org.wg.collection.util.CollectionUtils;

public class SqlUtils {
	
	public static String getWhere(String ands){
		if(ands.length()>0){
			return " where "+ands.substring(ands.indexOf("and")-3);
		}
		return "";
	}
	/**
	 * 返回值为 and key in(list....)
	 * @param key 
	 * @param list 
	 * @return
	 */
	public static String List2In(String key ,List<String> list){
		return " and "+key+" in " +CollectionUtils.join(list, ",");
	}
}
