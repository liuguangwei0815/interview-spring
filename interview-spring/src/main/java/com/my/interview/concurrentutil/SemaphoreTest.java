/**
 * 
 */
package com.my.interview.concurrentutil;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author liuwei
 * 信号量测试，可以现在线程数的执行个数 ,限制线程执行调速
 */
public class SemaphoreTest {
	
	public static void main(String[] args) {
		ExecutorService service = Executors.newCachedThreadPool();
		//建立信号量 3个信号量 只能执行3个
		Semaphore semaphore = new Semaphore(3);
		for (int i = 0; i < 20; i++) {
			 Runnable runa = new Runnable() {
				@Override
				public void run() {
					try {
						//进行信号量判断
						semaphore.acquire();
						System.out.println(Thread.currentThread().getName()+" 开始执行子任务");
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}finally {
						semaphore.release();
					}
				}
			};
			//和sumbit 是 有返回值的 这个是没有额
			service.execute(runa);
		}
		service.shutdown();
	}
}
