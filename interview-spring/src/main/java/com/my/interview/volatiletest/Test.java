package com.my.interview.volatiletest;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class Test {

	public static void main(String[] args) {

		Thread t1 = new Thread(new SigleRunnable());
		Thread t2 = new Thread(new SigleRunnable());
		Thread t3 = new Thread(new SigleRunnable());
		Thread t4 = new Thread(new SigleRunnable());
		Thread t5 = new Thread(new SigleRunnable());
		Thread t6 = new Thread(new SigleRunnable());
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		t6.start();
		

	}

}
