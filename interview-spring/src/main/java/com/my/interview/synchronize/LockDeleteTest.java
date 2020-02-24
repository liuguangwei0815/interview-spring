/**
 * 
 */
package com.my.interview.synchronize;

/**
 * @author liuwei
 * 锁消除  jvm jit 即时编译过程会扫描上下文（即全局扫描） 会消除不可能存在锁竞争的对象 自动去掉方法的synchronize 修饰
 * 比如以下代码
 */
public class LockDeleteTest {
	
	//因为sb 没有被返回 所有不会被其他的线程调用
	public void add(String a,String b) {
		StringBuffer sb = new StringBuffer();
		//sb 里的append 方法修饰的synchronize 这个锁 以为他不存在锁竞争问题
		sb.append(a).append(b);
	}

}
