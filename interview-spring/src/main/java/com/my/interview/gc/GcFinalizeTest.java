/**
 * 
 */
package com.my.interview.gc;

/**
 * @author liuwei
 * Object finalize 的作用，它给与一个对象的重生机会
 * 1、至少两次标记 （对象人物是否是认为可以被回收 ）
 * 2、可达性没有关系链的 进行标识，同时判断该对象的finalize是否被执行，如果未执行，则会吧对象放到F-queue 。然后jvm 起一个低级别的线程去执行这些对象的finalize
 * 3、finize 随时可能被中断
 * 4、给对象一个重生的机会
 */
public class GcFinalizeTest {

	//该对象自己
	private static GcFinalizeTest gcFinalizeTest;

	//覆盖
	@Override
	protected void finalize() throws Throwable {
		System.out.println("执行对象的finalize 方法");
		//this 为该对象的堆地址 ，这句话的意思是将该对象的地址重新复制给gcFinalizeTest
		gcFinalizeTest = this;
	}
	
	
	public static void main(String[] args) throws InterruptedException {
		GcFinalizeTest clt = new GcFinalizeTest();
		System.out.println("第一次打印该对象："+clt);
		clt = null;
		//进行对象回收
		System.gc();
		Thread.currentThread().sleep(3000);
		System.out.println("第2次打印该对象（提醒gc进行回收后，并且对象复制=null）："+clt);
		System.out.println("第2次打印该对象（提醒gc进行回收后，并且对象复制=null）："+clt.gcFinalizeTest);
	}
}
