package com.my.interview.equals;

 /**
  * == 和 equal 的区别
  * 1、== 比较对象的内存地址 基本数据类型
  * 2、equal 比较对象的内存地址 非基础类型 String Data 都进行了equal重写 
  * @author liuwei
  */
public class TestMain {
	public static void main(String[] args) {
		//== 和 eqal 比较对象的内存地址 ， == 基础类型 ， 比如String Data 重写eqals  eqals 一起重写  hascod 保证对象的一致性
		String str1 = new String("a");
		String str2 = new String("a");
		System.out.println("str1 == str2: " + (str1==str2));
		System.out.println("str1 equ str2: " + str1.equals(str2));
		int a = 1;
		int b = 1;
		System.out.println("基础类型只能使用== 比较 比较的是值: "+(a==b));
		User user1 = new User("jack");
		User user2 = new User("jack");
		System.out.println("user1 == str2 :" + (user1==user2));
		System.out.println("user1 equ user2 :" + user1.equals(user2));
	}
}
