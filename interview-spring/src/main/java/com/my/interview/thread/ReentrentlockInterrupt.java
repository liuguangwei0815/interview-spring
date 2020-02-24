/**
 * 
 */
package com.my.interview.thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author liuwei ReentrantLock- LockInterruptibly 终止先出方法
 */
public class ReentrentlockInterrupt {
	public static void main(String[] args) throws InterruptedException {
		ReentrantLock lokc = new ReentrantLock();
		Reentrantinterrupt1 r1 = new Reentrantinterrupt1(lokc);
		// 获取子线程
		Thread t1 = r1.go();
		t1.start();
		// 主线程休眠一秒 1s
		Thread.sleep(1000);
		System.out.println("主线程休眠1s");
		// 通知子线程中断
		System.out.println("通知子线程中断");
		t1.interrupt();
		
		Norinterrupt1 n1 = new Norinterrupt1();
		Thread td = n1.go();
		td.start();
		Thread.sleep(1000);
		System.out.println("通知普通子线程中断");
		td.interrupt();
	}
	// reentrantLock interrupt 打断
	static class Reentrantinterrupt1 {

		private ReentrantLock lokc;

		public Reentrantinterrupt1(ReentrantLock lokc) {
			this.lokc = lokc;
		}

		public Thread go() {
			return new Thread(() -> {
				try {
					lokc.lockInterruptibly();
					int i = 0;
					while (true) {
						Thread.sleep(100);
						System.out.println(Thread.currentThread().getName() + ":" + i);
					}
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					lokc.unlock();
				}
			}, "A");
		}
	}
	// 普通 线程打断
	static class Norinterrupt1 {
		public Thread go() {
			return new Thread(() -> {
				try {
					int i = 0;
					while (!Thread.currentThread().isInterrupted()) {
						Thread.sleep(100);
						System.out.println(Thread.currentThread().getName() + ":" + i);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}, "B");
		}
	}
}
