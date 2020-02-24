package com.my.interview.thread;

public class ThreadTest {

	// 建立一个集成thread测试类
	static class MyThread extends Thread {
		private String name;

		public MyThread(String name) {
			this.name = name;
		}

		@Override
		public void run() {

			for (int i = 0; i < 10; i++) {
				System.out.println("集成Thread类："+Thread.currentThread().getName() + "-i:" + i + "-name:" + name);
			}

		}
	}

	// 建立一个实现runable方法的类
	static class MyRunable implements Runnable {
		private String name;

		public MyRunable(String name) {
			this.name = name;
		}

		@Override
		public void run() {
			for (int i = 0; i < 10; i++) {
				System.out.println("实现Runnable实现类："+Thread.currentThread().getName() + "-i:" + i + "-name:" + name);
			}
		}
	}

	// 进行测试
	public static void main(String[] args) {
		// 集成Thread 测试
		MyThread mt1 = new MyThread("jack1");
		MyThread mt2 = new MyThread("jack2");
		MyThread mt3 = new MyThread("jack3");
		mt1.start();
		mt2.start();
		mt3.start();
		// 因为runnable 灭有start 方法 无法调用本地方法调用开启线程，需要依赖threa类
		MyRunable mr1 = new MyRunable("rjack1");
		MyRunable mr2 = new MyRunable("rjack2");
		MyRunable mr3 = new MyRunable("rjack3");
		Thread t1 = new Thread(mr1);
		Thread t2 = new Thread(mr2);
		Thread t3 = new Thread(mr3);
		t1.start();
		t2.start();
		t3.start();
	}

}
