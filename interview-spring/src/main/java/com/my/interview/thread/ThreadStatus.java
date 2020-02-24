/**
 * 
 */
package com.my.interview.thread;

import java.util.concurrent.locks.LockSupport;

/**
 * @author liuwei
 * 线程状态
 */
public class ThreadStatus {
	
	public static void main(String[] args) throws InterruptedException {
		
		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				System.err.println("执行字线程");
			}
		});
		t.start();
		//等待t执行完
		t.join();
		//继续做个子线程
		System.err.println("主业务逻辑");
		//再次启动t线程，这个是不允许的
		t.start();
		
	}
	

}
