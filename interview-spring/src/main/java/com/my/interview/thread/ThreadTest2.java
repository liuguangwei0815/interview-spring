package com.my.interview.thread;
/**
 * join 方法的使用 
 * @author liuwei
 *
 */
public class ThreadTest2 {

	// 建立一个实现runable方法的类
	static class MyRunable implements Runnable {
		private String name;

		public MyRunable(String name) {
			this.name = name;
		}

		@Override
		public void run() {
			try {
				System.out.println(Thread.currentThread().getName()+" 执行 ： Name "+name);
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	// 进行测试
	public static void main(String[] args) throws InterruptedException {

		MyRunable mr1 = new MyRunable("rjack1");
		Thread t1 = new Thread(mr1);
		MyRunable mr2 = new MyRunable("rjack2");
		Thread t2 = new Thread(mr2);
		t1.start();
		//Main 线程会等待t1  线程执行完毕之后再进行
		System.out.println("Main 线程会等待t1  线程执行完毕之后再进行");
		t1.join();
		System.out.println("t2  线程启动");
		t2.start();
		System.out.println("Main 线程会等待t2  线程执行完毕之后再进行");
		t2.join();
		//主线程继续工作
		System.out.println("主线程开始执行");
	}

}
