/**
 * 
 */
package com.my.interview.concurrentutil;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author liuwei zhalan 栅栏 测试
 * 让线程之间相互等待
 */
public class CyclicBarrierTest {

	public static void main(String[] args) {
		new CyclicBarrierTest().go();
	}

	private void go() {
		CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
		new Thread(new Task(cyclicBarrier), "B").start();
		new Thread(new Task(cyclicBarrier), "C").start();
		new Thread(new Task(cyclicBarrier), "A").start();
	}

	class Task implements Runnable {

		private CyclicBarrier cyclicBarrier;

		public Task(CyclicBarrier cyclicBarrier) {
			this.cyclicBarrier = cyclicBarrier;
		}

		@Override
		public void run() {
			System.out.println(Thread.currentThread().getName() + "执行子任务的栅栏线程start");
			if(Thread.currentThread().getName().startsWith("A")) {
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
			System.out.println(Thread.currentThread().getName() + "业务执行完毕 。进行等待");
			try {
				cyclicBarrier.await();
			} catch (InterruptedException | BrokenBarrierException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "执行子任务的栅栏线程end");
		}

	}
}
