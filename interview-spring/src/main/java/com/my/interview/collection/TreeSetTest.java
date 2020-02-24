/**
 * 
 */
package com.my.interview.collection;

/**
 * @author liuwei
 * TreeSet 底层是TreeMap 实现的 ，将值放到Map的key中 value 实例化一个final的object
 */
public class TreeSetTest implements Comparable {

	@Override
	public int compareTo(Object o) {
		return 0;
	}
	
	public static void main(String[] args) {
		String a = "dsdsd";
		String b = "dsdsd";
		if(a==b) {
			System.out.println(1);
		}
		if(a.equals(b)) {
			System.out.println(12);
		}
		int a1 = 1, a2 = 1;
		if(a1==a2) {
			System.out.println(3);
		}
		
		
		
		
		
		
		
		
	}

}
