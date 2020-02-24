/**
 * 
 */
package com.my.interview.collection;

import java.util.TreeSet;

/**
 * @author liuwei
 * 
 */
public class HashCodeAndEqual implements Comparable {
	private String name;
	private int age;

	public HashCodeAndEqual(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	// 判断内容
	@Override
	public boolean equals(Object obj) {
		System.out.println(" 调用了 对象的 equal 方法");
		if(obj==this) {
			return true;
		}
		if (!(obj instanceof HashCodeAndEqual)) {
			return false;
		}
		HashCodeAndEqual para = (HashCodeAndEqual) obj;
		if (para.getName().equals(this.name) && para.getAge() == this.age) {
			return true;
		} else {
			return true;
		}
	}

	@Override
	public int hashCode() {
		int ss = super.hashCode();
		System.out.println("获取当前" + this.name + " hashcode:" + ss);
		return ss;
	}

//
//	@Override
//	public int hashCode() {
//		int result = this.name != null ? this.name.hashCode() : 0;
//		System.out.println("调用了 hashCode 方法");
//		return 31 * result + this.age;
//	}
	static class test {
		public static void main(String[] args) {
			
			String str1 = new String("test");
			String str2 = new String("test");
			//== 标识的是存放到堆中的地址
			System.out.println(str1==str2);
			System.out.println(str1.equals(str2));
			
//			HashCodeAndEqual t1 = new HashCodeAndEqual("Tom1", 12);
//			HashCodeAndEqual t2 = new HashCodeAndEqual("Tom1", 12);
//			TreeSet<HashCodeAndEqual> tr = new TreeSet<HashCodeAndEqual>();
//			tr.add(t1);
//			tr.add(t2);
//			tr.forEach(e -> {
//				System.out.println(e.age + " " + e.name);
//			});
		}
	}

	@Override
	public int compareTo(Object o) {
		System.out.println("调用 compareTo 方法");
		HashCodeAndEqual oo = (HashCodeAndEqual) o;
		if (oo.name.compareTo(this.name) > 0) {
			return -1;
		}
		if (oo.name.compareTo(this.name) < 0) {
			return 1;
		}
		if (oo.age > this.age) {
			return -1;
		}
		if (oo.age < this.age) {
			return 1;
		}
		return 0;
	}
}
