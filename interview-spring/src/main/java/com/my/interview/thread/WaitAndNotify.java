/**
 * 
 */
package com.my.interview.thread;

/**
 * @author liuwei 
 * wait 和 notify 的使用
 * 
 */
public class WaitAndNotify {
	private final static Object lock = new Object();

	public static void main(String[] args) throws InterruptedException {
	
		new Thread(new Runnable() {
			@Override
			public void run() {
				synchronized (lock) {
					System.out.println(Thread.currentThread().getName() + " 获取了锁");
					try {
						System.out.println(Thread.currentThread().getName() + " 获取了锁 执行wait 无限等待中");
						// 释放cpu 但是 同时释放锁 ，如果没有参数 那么无限等待 必须的显式唤醒 ,这里是等待2s
						lock.wait();
						System.out.println(Thread.currentThread().getName() + " 获取了锁 执行wait 无限等待完毕");
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
		// 上面的线程处理时间长 因为他wati了2s 放弃了锁
		new Thread(new Runnable() {
			@Override
			public void run() {
				synchronized (lock) {
					System.out.println(Thread.currentThread().getName() + " 获取了锁 开始唤醒");
					// 唤醒持有lock 对象的线程
					lock.notify();//或者notify All 
					System.out.println(Thread.currentThread().getName() + " 获取了锁 结束唤醒 ");
				}
			}
		}).start();
	}

}
