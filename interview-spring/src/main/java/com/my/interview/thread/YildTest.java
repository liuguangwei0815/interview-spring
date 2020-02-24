/**
 * 
 */
package com.my.interview.thread;

/**
 * @author liuwei yild 测试 提示线程调度器 当前线程可以放弃cpu执行机会，但是决定这要看调度去 yild
 *         对cpu执行有影响，对锁是没有影响
 */
public class YildTest {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Runnable runa = new Runnable() {
			@Override
			public void run() {
				for (int i = 1; i <= 10; i++) {
					System.out.println(Thread.currentThread().getName() + i);
					//当i=5 提示线程调度器
					if (i == 5)
						Thread.yield();
				}
			}
		};
		Thread t1 = new Thread(runa, "A");
		Thread t2 = new Thread(runa, "B");
		//必须同时启动 不然没法测试yield 或者在A 中sleep 一下 
		t1.start();
		t2.start();
	}
}
