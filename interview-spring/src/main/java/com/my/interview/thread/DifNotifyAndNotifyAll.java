/**
 * 
 */
package com.my.interview.thread;

/**
 * @author liuwei NotifyAll 和 notify 的区别 All 是 所有的线程冲等待池中晋升到锁池中 notify
 *         随机一个线程晋升到锁池中
 */
public class DifNotifyAndNotifyAll {

	static volatile boolean go = Boolean.FALSE;

	public static void main(String[] args) throws InterruptedException {
		final DifNotifyAndNotifyAll obj = new DifNotifyAndNotifyAll();

		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					obj.wait1();
					System.out.println("执行完毕 - "+Thread.currentThread().getName());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		},"线程1").start();
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					obj.wait1();
					System.out.println("执行完毕 - "+Thread.currentThread().getName());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		},"线程2").start();
		
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					obj.wait1();
					System.out.println("执行完毕 - "+Thread.currentThread().getName());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		},"线程3").start();
		
		Thread.sleep(1000);
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					obj.wait2();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		},"唤醒线程").start();
		
		
	}

	private synchronized void wait1() throws InterruptedException {
		//当go = true 终止该while
		while (go != Boolean.TRUE) {
			System.out.println("进入  while 循环中，开始执行wait方法 无限等待 - "+Thread.currentThread().getName());
			wait();
			System.out.println("进入  while 循环中，完毕执行wait方法 无限等待 -  "+Thread.currentThread().getName());

		}
		go = Boolean.FALSE;
	}
	

	private synchronized void wait2() throws InterruptedException {
		//当go = true 终止该while
		while(go==false) {
			System.out.println("进入  将go 改为true 并唤醒线程    -"+Thread.currentThread().getName());
			go = Boolean.TRUE;
			notifyAll();
		}
		
	}
}
