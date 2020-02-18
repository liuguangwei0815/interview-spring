package com.my.interview.reflence;

public interface ReferenceInterface {
	
	 public static String interface1(String pare) {
		System.out.println("反射调用接口的方法static interface1。。。");
		return pare;
	}
	 
	 public default String interface2(String pare) {
			System.out.println("反射调用接口的方法 default interface2。。。");
			return pare;
		}

}
