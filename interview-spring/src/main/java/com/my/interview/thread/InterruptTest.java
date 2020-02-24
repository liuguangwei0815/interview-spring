/**
 * 
 */
package com.my.interview.thread;

/**
 * @author liuwei Interrupt 这个类似yield 提示线程终端，这个还是需要被中短线超自行处理的
 */
public class InterruptTest {

	public static void main(String[] args) {

		Runnable target = new Runnable() {
			@Override
			public void run() {
				int i = 0;
				//这个try 必须 放到循环之外 不然没法终止这个while
				//try {
					// 判断该线程是否被中断
					while (!Thread.currentThread().isInterrupted()) {
						//当线程此时是阻塞状态 那么会抛出异常InterruptedExctption 如果不是阻塞仅仅改变此线程的状态
						//Thread.sleep(1000);
						i++;
						System.out.println(Thread.currentThread().getName() + " loop:" + i + " 当前线程状态"
								+ Thread.currentThread().getState());
					}
//				} catch (InterruptedException e) {
//					System.out
//							.println(Thread.currentThread().getName() + " 发生InterruptedException  当前线程状态" + Thread.currentThread().getState());
//				}
			}
		};

		Thread t1 = new Thread(target, "T1");
		System.out.println("T1 此时的线程状态:" + t1.getState());
		t1.start();
		System.out.println("start 此时T1的线程状态:" + t1.getState());
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// 主线程通知t1终止
		System.out.println("Main线程通知t1 进行终止");
		t1.interrupt();
		System.out.println("Main线程通知t1 之后此时T1进行终止之后的状态：" + t1.getState());
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Main线程通知t1 之后此时T1进行终止之后休眠 5s 再次获取T1线程的状态 ：" + t1.getState());
	}

}
