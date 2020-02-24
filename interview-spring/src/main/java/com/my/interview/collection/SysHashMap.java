/**
 * 
 */
package com.my.interview.collection;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @author liuwei 将Map 同步化
 */
public class SysHashMap {
	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>();
		Map<String, String> sysMap = Collections.synchronizedMap(map);
		sysMap.put("a", "a");
		sysMap.put("b", "a");
		for (Entry<String, String> string : map.entrySet()) {
			System.out.println(string.getKey() + " " + string.getValue());
		}
	}
}
