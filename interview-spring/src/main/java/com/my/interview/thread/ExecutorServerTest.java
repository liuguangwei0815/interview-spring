/**
 * 
 */
package com.my.interview.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author liuwei 线程池测试
 */
public class ExecutorServerTest implements Callable<String> {
	private String name;

	public ExecutorServerTest(String name) {
		super();
		this.name = name;
	}

	@Override
	public String call() throws Exception {
		System.out.println("ExcutorServer test 获取参数:" + name);
		Thread.currentThread().sleep(2000);
		return "ExcutorServer 子任务完成";
	}

	static class Test {
		static AtomicInteger atomicInteger = new AtomicInteger();

		public static void main(String[] args) throws InterruptedException, ExecutionException {
			ExecutorService exe = null;
			try {

				// 建立一个线程池submit 方法
				exe = Executors.newCachedThreadPool();
				Future<String> future = exe.submit(new ExecutorServerTest("我是executor参数"));
				if (!future.isDone()) {
					System.out.println("线程正在执行中，尚未完成，请稍后。。。");
				}
				String result = future.get();
				System.out.println("线程执行完成获取结果:" + result);
				System.out.println("主线程开始");

				// 建立一个线程invokALl 方法
				List<ExecutorServerTest> tasklist = new ArrayList<ExecutorServerTest>();
				for (int i = 0; i < 5; i++) {
					tasklist.add(new ExecutorServerTest("我是参数:" + atomicInteger.incrementAndGet()));
				}
				//开始执行线程池的任务列表
				List<Future<String>> fulist = exe.invokeAll(tasklist);
				for (Future<String> future2 : fulist) {
					System.out.println(future2.get());
				}
				System.out.println("执行主线程");

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (exe != null) {
					//一定要关闭线程池
					exe.shutdown();
				}
			}
		}
	}
}
