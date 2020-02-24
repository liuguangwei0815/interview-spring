/**
 * 
 */
package com.my.interview.collection;

import java.util.LinkedList;
import java.util.TreeSet;

/**
 * @author liuwei List：存取的顺序一样 ，可以重复 ， 操作下标 set : 存取顺序不一样 ，不可重复 不可操作下标
 */
public class ListAndSetTest {
	public static void main(String[] args) {
		// 可重复 存取顺序固定 可操作index
		LinkedList<String> list = new LinkedList<String>();
		list.add("1111");
		list.add("2222");
		list.add("3333");
		list.add("1111");
		list.add("4444");
		list.add("5555");
		System.out.println(list);
		// 不可重复 ，存取顺序不固定 不可操作下标 list 和他相反
		TreeSet<String> set = new TreeSet<String>();
		set.add("aaaa");
		set.add("aaaa");
		set.add("bbbb");
		set.add("cccc");
		set.add("ddddd");
		set.add("eeeee");
		set.add("111112");
		System.out.println(set);
	}
}
