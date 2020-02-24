/**
 * 
 */
package com.my.interview.volatiletest;

/**
 * @author liuwei 单例线程安全 - 多重检测
 */
public class SingleDubboCheckTest {

	private static volatile SingleDubboCheckTest instanc; //禁止对该isntanc 进行指令重排 应发线程安全

	// 禁止自行建立实例对象
	private SingleDubboCheckTest() {
	}

	public static SingleDubboCheckTest getInstance() {

		// 第一次检测
		if (instanc == null) {
			synchronized (SingleDubboCheckTest.class) {
				// 第二次检测
				if (instanc == null) {
					// 发生线程安全的问题， 因为如果这样子，编译器可能会进行指令重排序优化，以为这里没有依赖关系，即 happen before 运行从排序 ，
					// 当一个对象的实例化 1、分配空间 2 将空间地址 赋值给堆栈的引用 3、实例化对象 但是指令重排可以是 ；1 分配空间 2独享实例 3 将地址赋值给堆
					// 所以 在 第二次判断时候可能就 可能或实例化不了 instanc
					instanc = new SingleDubboCheckTest();
				}
			}
		}
		return instanc;
	}

}
