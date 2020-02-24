/**
 * 
 */
package com.my.interview.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author liuwei ArrayBlockingQueue 测试 
 * 1、有界 
 * 2、先进先出
 * 3、取头增尾
 * 4、Blockingqueue 适合消息队列
 */
public class ArrayBlockingQueueTest {
	public static void main(String[] args) throws InterruptedException {
		ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<String>(4);
		queue.offer("a");// 成功 true 失败flalse
		queue.offer("b", 3, TimeUnit.SECONDS);// 将指定的元素插入到此队列的末尾，如果队列已满，则在指定的等待时间之前等待空间可用。
		queue.add("c");// 成功true 否者抛出异常 
		queue.put("d"); //调用了awai方法 、、比如满了 会一致等待 
		// 阻塞 ，full 等待
		String e1 = queue.poll();//对应put 阻塞 没有就阻塞
		System.out.println("从队列头部回去："+e1);
		String e2 = queue.take();//调用了await方法
		System.out.println("take从队列头部回去："+e2);
	}
}
