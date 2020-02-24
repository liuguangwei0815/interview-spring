/**
 * 
 */
package com.my.interview.synchronize;

/**
 * @author liuwei
 * 锁粗化
 */
public class LockBigTesty {
	public static String add() {
		//----- jvm 检测到 append 方法是同步的，同时进行了100次的操作，他就会把这个锁 扩大到 sb 100次 只加一次锁 ，这个叫做锁粗化
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < 100; i++) {
			sb.append(i);
		}
		return sb.toString();
	}
}
