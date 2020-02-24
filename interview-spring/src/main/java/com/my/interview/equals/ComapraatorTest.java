/**
 * 
 */
package com.my.interview.equals;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author liuwei 1、自然排序 comparable 2、自定义排序 comaprator TreeMap 的 enry
 *         是1、检测Comaprtor 是否实现 2 自然排序
 */
public class ComapraatorTest implements Comparator<UserChange> {

	@Override
	public int compare(UserChange o1, UserChange o2) {
		if (o2.getUserName().compareTo(o1.getUserName()) > 0) {
			return 1;
		}
		if (o2.getUserName().compareTo(o1.getUserName()) < 0) {
			return -1;
		}
		return 0;
	}

	public static void main(String[] args) {
		Set<UserChange> set1 = new TreeSet<UserChange>(new ComapraatorTest());
		set1.add(new UserChange("Tom", 12));
		set1.add(new UserChange("Tom", 12));
		set1.add(new UserChange("Tom", 13));
		set1.add(new UserChange("Tom", 14));
		set1.add(new UserChange("Tom", 15));
		set1.add(new UserChange("Tom", 1));
		System.out.println(set1.size());
		for (UserChange userChange : set1) {
			System.out.println(userChange);
		}
	}
}
