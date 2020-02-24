/**
 * 
 */
package com.my.interview.excetpion;

/**
 * @author liuwei 异常
 */
public class ExceptionTest {

	@SuppressWarnings("finally")
	public int asd() {
		try {
			int a = 10 / 0;
			System.out.println("a=" + a);
		} catch (ArithmeticException e) {
			System.out.println("执行了ArithmeticException ");
			//抛出改异常，但是在终止之前会执行finally 但是finally 有return 会导致 提前总之掉了 所以返回的3
			return 1;
		} catch (Exception e) {
			return 2;
		}finally {
			System.out.println("执行了finally ");
			return 3;
		}
	}
	public static void main(String[] args) {
		ExceptionTest test = new ExceptionTest();
		System.out.println(test.asd());
	}
}
