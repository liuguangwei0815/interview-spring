/**
 * 
 */
package com.my.interview.synchronize;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author liuwei 互斥性 、可见性 ，线程安全 ，共享资源 被多个线程同一时刻进行操作，导致数据不一致
 */
public class SynchronizeTest implements Runnable {

	@Override
	public void run() {
		if (Thread.currentThread().getName().startsWith("A")) {
			synblock();
		} else if (Thread.currentThread().getName().startsWith("B")) {
			sysnMethod();
		}else if (Thread.currentThread().getName().startsWith("C")) {
			classBlock();
		}else if (Thread.currentThread().getName().startsWith("D")) {
			classMethod();
		}
	}

	//synchronize static 标识类锁
	private synchronized static void classMethod() {
		try {
			System.out.println("当前线程：" + Thread.currentThread().getName() + "_Start 时间："
					+ new SimpleDateFormat("yyyy-MM-ss HH:mm:ss").format(new Date()));
			Thread.sleep(1000);
			System.out.println("当前线程：" + Thread.currentThread().getName() + "_End 时间："
					+ new SimpleDateFormat("yyyy-MM-ss HH:mm:ss").format(new Date()));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//synchronize（xxx.class） 标识类锁
	private  void classBlock() {
		
		synchronized (SynchronizeTest.class) {
			try {
				System.out.println("当前线程：" + Thread.currentThread().getName() + "_Start 时间："
						+ new SimpleDateFormat("yyyy-MM-ss HH:mm:ss").format(new Date()));
				Thread.sleep(1000);
				System.out.println("当前线程：" + Thread.currentThread().getName() + "_End 时间："
						+ new SimpleDateFormat("yyyy-MM-ss HH:mm:ss").format(new Date()));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}

	// 方法加上synchronized 代表当前当前对象为锁对象（即调用者）//对象锁
	private synchronized void sysnMethod() {
		try {
			System.out.println("当前线程：" + Thread.currentThread().getName() + "_Start 时间："
					+ new SimpleDateFormat("yyyy-MM-ss HH:mm:ss").format(new Date()));
			Thread.sleep(1000);
			System.out.println("当前线程：" + Thread.currentThread().getName() + "_End 时间："
					+ new SimpleDateFormat("yyyy-MM-ss HH:mm:ss").format(new Date()));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//对象锁
	private void synblock() {
		// this 调用synblock 这个对象作为锁
		synchronized (this) {
			try {
				System.out.println("当前线程：" + Thread.currentThread().getName() + "_Start 时间："
						+ new SimpleDateFormat("yyyy-MM-ss HH:mm:ss:SS").format(new Date()));
				Thread.sleep(1000);
				System.out.println("当前线程：" + Thread.currentThread().getName() + "_End 时间："
						+ new SimpleDateFormat("yyyy-MM-ss HH:mm:ss:SS").format(new Date()));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	//类锁
	
	

	static class SynchronizedTest {
		public static void main(String[] args) {
			//建立这个实例对象
			SynchronizeTest synobj = new SynchronizeTest();
//			//两个线程去执行同步代码块
//			Thread th1 = new Thread(new SynchronizeTest(),"A_1");
//			Thread th2 = new Thread(new SynchronizeTest(),"A_2");
//			//两个线程去执行同步方法
//			Thread th3 = new Thread(new SynchronizeTest(),"B_1");
//			Thread th4 = new Thread(new SynchronizeTest(),"B_2");
//			// t1  t2 t3 t4 都是相同的锁对象 因为是synobj 是同一个对象
//			//启动线程 因为他们持有不同对象锁 （this 和 没static synchronize 方法 ） 他们是无序的
//			th1.start();
//			th2.start();
//			th3.start();
//			th4.start();
			
			//不同的锁对象 他们还是同步的 因为他们这些对象只拥有一个class 那他们是互斥的
			Thread th1 = new Thread(synobj,"C_1");
			Thread th2 = new Thread(synobj,"C_2");
			Thread th3 = new Thread(synobj,"D_1");
			Thread th4 = new Thread(synobj,"D_2");
			th1.start();
			th2.start();
			th3.start();
			th4.start();
			
		}
	}

}
