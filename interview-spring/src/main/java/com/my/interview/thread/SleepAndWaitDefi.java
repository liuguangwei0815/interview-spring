/**
 * 
 */
package com.my.interview.thread;

/**
 * @author liuwei sleep 和 wait 的区别 sleep 让出的cpu ，但是未释放锁 wait 让出cpu 和锁
 * 
 */
public class SleepAndWaitDefi {
	private final static Object lock = new Object();

	public static void main(String[] args) throws InterruptedException {
		new Thread(new Runnable() {
			@Override
			public void run() {
				synchronized (lock) {
					System.out.println(Thread.currentThread().getName() + " 获取了锁");
					try {
						// 释放cpu 但是 不释放锁
						System.out.println(Thread.currentThread().getName() + " 获取了锁,开始sleep  1秒");
						Thread.sleep(1000);
						System.out.println(Thread.currentThread().getName() + " 获取了锁,结束sleep  1秒");
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
		new Thread(new Runnable() {
			@Override
			public void run() {
				synchronized (lock) {
					System.out.println(Thread.currentThread().getName() + " 获取了锁");
					try {
						// 模拟执行过程
						// 释放cpu 但是 同时释放锁 ，如果没有参数 那么无限等待 必须的显式唤醒 ,这里是等待2s
						System.out.println(Thread.currentThread().getName() + " 获取了锁 执行wait 等待5s");
						lock.wait(2000);
						System.out.println(Thread.currentThread().getName() + " 获取了锁 执行wait 等待5s完毕");
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();

		//因为线程执行顺序不一定 所有要sleep一下
		Thread.sleep(1000);	
		
		// 上面的线程处理时间长 因为他wati了2s 放弃了锁
		new Thread(new Runnable() {
			@Override
			public void run() {
				synchronized (lock) {
					System.out.println(Thread.currentThread().getName() + " 获取了锁");
					// 释放cpu 但是 同时释放锁 ，如果没有参数 那么无限等待 必须的显式唤醒
					System.out.println(Thread.currentThread().getName() + " 开始执行业务");
				}
			}
		}).start();
	}

}
