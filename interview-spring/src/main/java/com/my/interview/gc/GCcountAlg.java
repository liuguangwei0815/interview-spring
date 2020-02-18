/**
 * 
 */
package com.my.interview.gc;

import lombok.Data;

/**
 * @author liuwei GC计数算法 无法检测循环应用对象是否是垃圾对象
 */
@Data
public class GCcountAlg {

	private GCcountAlg chirlNode;

	//测试类
	static class GCcountAlgTest {
		public static void main(String[] args) {

			GCcountAlg gc1 = new GCcountAlg();
			GCcountAlg gc2 = new GCcountAlg();
			// 相互设置应用 ，那么GC计数算法无法识别该对象是否垃圾
			gc1.setChirlNode(gc2);
			// 相互设置应用 ，那么GC计数算法无法识别该对象是否垃圾
			gc2.setChirlNode(gc1);

		}
	}

}
