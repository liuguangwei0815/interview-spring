/**
 * 
 */
package com.my.interview.concurrentutil;

import java.util.concurrent.CountDownLatch;

import javax.management.RuntimeErrorException;

/**
 * @author liuwei 计数器闭锁
 */
public class CountDownLatchTest {

	public static void main(String[] args) {
		new CountDownLatchTest().go();
	}

	private void go() {
		CountDownLatch latchp = new CountDownLatch(3);
		new Thread(new Task(latchp), "B").start();
		new Thread(new Task(latchp), "C").start();
		new Thread(new Task(latchp), "A").start();
		try {
			latchp.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + "等待执行完了子线程执行完毕，开始执行主线程");
	}

	// 建立一个task
	class Task implements Runnable {
		private CountDownLatch latchp;

		public Task(CountDownLatch latchp) {
			this.latchp = latchp;
		}
		@Override
		public void run() {
			System.out.println(Thread.currentThread().getName() + "执行子任务的闭锁线程start");
			
			if(Thread.currentThread().getName().startsWith("A")) {
				throw new RuntimeException("人造异常");
			}
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "执行子任务的闭锁线程end");
			// 执行计数 标识该线程执行完毕了 然后告诉主线程
			latchp.countDown();
		}
	}
}
