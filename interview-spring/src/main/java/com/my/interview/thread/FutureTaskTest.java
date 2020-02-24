/**
 * 
 */
package com.my.interview.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author liuwei
 * callable 的 Future 测试
 * Callable<V> 返回值类型
 */
public class FutureTaskTest implements Callable<String> {
	private String paraName;
	//参数传递
	public FutureTaskTest(String paraName) {
		this.paraName = paraName;
	}
	@Override
	public String call() throws Exception {
		System.out.println("开始执行callable run 方法 获取参数为:"+paraName+" 线程开始休息 1 s ");
		Thread.currentThread().sleep(1000);
		return "callable run 执行完毕";
	}
	static class CallAbleTest{
		public static void main(String[] args) {
			FutureTask<String> task = new FutureTask<String>(new FutureTaskTest("我是参数"));
			new Thread(task).start();
			if(!task.isDone()) {
				System.out.println("线程还未完成，现在线程状态还是等于0");
			}
			String reslut = null;
			try {
				reslut = task.get();
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
			System.out.println("开始获取FutrueTask 子线程的返回值："+reslut);
			
			System.out.println("开始执行Main线程");
		}
	}
}
