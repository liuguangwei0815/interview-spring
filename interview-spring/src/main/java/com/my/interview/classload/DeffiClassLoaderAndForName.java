/**
 * 
 */
package com.my.interview.classload;

/**
 * @author liuwei ClassLoader 和 ClassForName 的区别
 */
public class DeffiClassLoaderAndForName {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		ClassLoader cl = Reboot.class.getClassLoader();
	}
}
