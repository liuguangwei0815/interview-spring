/**
 * 
 */
package com.my.interview.jvm;

/**
 * @author liuwei 斐波那契递归
 */
public class FibonacciStackOverFlowExctionTest {
	
	// 斐波那契 f(0) = 0;f(1)=1;当N>=2 F(N) = F(N-1) + F(N-2)
	// F(2) = F(1) + F(0) = 1
	// F(3) = F(2)+F(1) = 1 + 1 = 2
	// F(4) = F(3) + F(2) = 2 + 1 = 3
	// F(5) = F(4) + F(3) = 3 + 2 = 5
	// F(6) = F(5) + F(4) = 5 + 3 = 8
	public static int fibonacii(int n) {
		if (n == 0)
			return 0;
		if (n == 1)
			return 1;
		return fibonacii(n-1) + fibonacii(n-2);
	}
	
	public static void main(String[] args) {
		System.out.println(fibonacii(2));
		System.out.println(fibonacii(3));
		System.out.println(fibonacii(4));
		System.out.println(fibonacii(5));
		System.out.println(fibonacii(6));
		System.out.println(fibonacii(100000));
	}
	
	
	
	

}
