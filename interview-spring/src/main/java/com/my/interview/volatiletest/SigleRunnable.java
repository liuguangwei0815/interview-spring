package com.my.interview.volatiletest;

public class SigleRunnable implements Runnable{

	@Override
	public void run() {
		if(SingleDubboCheckTest.getInstance()==null)
			System.out.println("dddd");
	}

}
