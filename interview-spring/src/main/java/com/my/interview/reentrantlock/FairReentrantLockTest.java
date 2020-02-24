/**
 * 
 */
package com.my.interview.reentrantlock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author liuwei 再入锁的公平模式
 */
public class FairReentrantLockTest implements Runnable {

	// 设置为true 那么持有这个lock的对象必须 公平的 这个lock 是static 修饰 所以合格是类的
	private static ReentrantLock lock = new ReentrantLock(true);

	@Override
	public void run() {
		while (true) {
			try {
				lock.lock();
				// 尝试获取锁
				System.out.println(Thread.currentThread().getName() + " 获取了锁");
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				// 释放锁
				lock.unlock();
			}
		}
	}

	static class test {

		public static void main(String[] args) {
			Thread th1 = new Thread(new FairReentrantLockTest());
			Thread th2 = new Thread(new FairReentrantLockTest());
			th1.start();
			th2.start();
		}

	}

}
