/**
 * 
 */
package com.my.interview.concurrentutil;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author liuwei 交换信息之间的信息
 */
public class ExchangeTest {
	public static void main(String[] args) {
		ExecutorService server = Executors.newFixedThreadPool(2);
		Exchanger<String> exchager = new Exchanger<String>();
		server.execute(() -> {
			try {
				String msg = exchager.exchange("男生我很喜欢你");
				System.out.println("女生交换后等到信息：" + msg);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		server.execute(() -> {
			try {
				String msg = exchager.exchange("女生我也喜欢你");
				System.out.println("男生交换后等到信息：" + msg);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		server.shutdown();
	}
}
