package org.wg.map.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MapUtils {
	/**
	 * 按map的key排序 map的key要实现comparable接口
	 * @param sortMap：待排序的Map
	 * @param sort：排序方式，true为升序 fals为降序
	 * @return 排好序的Map
	 */
	public static <K,V> Map<K,V> sortMapByKey(Map<K,V> sortMap,final boolean  sort){
		return sortMapByKey(sortMap,new Comparator<Map.Entry<K,V>>() {
			
			public int compare(Map.Entry<K,V> o1,Map.Entry<K,V> o2) {
				if(sort){
					return ((Comparable<K>)o1.getKey()).compareTo(o2.getKey());
				}else{
					return ((Comparable<K>)o2.getKey()).compareTo(o1.getKey());
				}
			}
		});
	}
	/**
	 * 按map的key排序 ：根据cmp比较
	 * @param sortMap：待排序的Map
	 * @param sort：排序方式，true为升序 fals为降序
	 * @return 排好序的Map
	 */
	public static <K,V> Map<K,V> sortMapByKey(Map<K,V> sortMap,Comparator<Map.Entry<K, V>> cmp ){
		Map<K,V> rtMap = new LinkedHashMap<K,V>();
		List<Map.Entry<K,V>> list = new ArrayList<Map.Entry<K,V>>(sortMap.entrySet());
		Collections.sort(list,cmp);
		for(Map.Entry<K, V> entry:list){
			rtMap.put(entry.getKey(), entry.getValue());
		}
		return rtMap;
	}
	
	/**
	 * 按map的value排序 map的key要实现comparable接口
	 * @param sortMap：待排序的Map
	 * @param sort：排序方式，true为升序 fals为降序
	 * @return 排好序的Map
	 */
	public static <K,V> Map<K,V> sortMapByValue(Map<K,V> sortMap,final boolean sort){
		return sortMapByValue(sortMap,new Comparator<Map.Entry<K,V>>() {
			public int compare(Map.Entry<K,V> o1,Map.Entry<K,V> o2) {
				if(sort){
					return ((Comparable<V>)o1.getValue()).compareTo(o2.getValue());
				}else{
					return ((Comparable<V>)o2.getValue()).compareTo(o1.getValue());
				}
			}
		});
	}
	/**
	 * 按map的value排序 ：根据cmp比较
	 * @param sortMap：待排序的Map
	 * @param sort：排序方式，true为升序 fals为降序
	 * @return 排好序的Map
	 */
	public static <K,V> Map<K,V> sortMapByValue(Map<K,V> sortMap,Comparator<Map.Entry<K, V>> cmp){
		Map<K,V> rtMap = new LinkedHashMap<K,V>();
		List<Map.Entry<K,V>> list = new ArrayList<Map.Entry<K,V>>(sortMap.entrySet());
		Collections.sort(list, cmp);
		for(Map.Entry<K, V> entry:list){
			rtMap.put(entry.getKey(), entry.getValue());
		}
		return rtMap;
	}

}
