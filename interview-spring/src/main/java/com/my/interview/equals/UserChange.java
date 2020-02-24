/**
 * 
 */
package com.my.interview.equals;

import java.util.Set;
import java.util.TreeSet;

/**
 * @author liuwei 进行重写Equals 和 HashCode（ 自然排序）
 */
public class UserChange implements Comparable {
	private String userName;
	private int age;

	public UserChange(String userName, int age) {
		this.userName = userName;
		this.age = age;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public int hashCode() {
		int result = this.userName == null ? 0 : userName.hashCode();
		System.out.println(" hascode " + result);
		return 31 * result + this.age;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			System.out.println("获取equals ==  值：" + true);
			return true;
		}
		if (!(obj instanceof UserChange)) {
			System.out.println("获取instanceof 值：" + false);
			return false;
		}
		UserChange uc = (UserChange) obj;
		if (uc.getUserName().equals(this.userName) && uc.getAge() == this.age) {
			System.out.println("获取equals 值：" + true);
			return true;
		} else {
			System.out.println("获取equals 值：" + false);
			return false;
		}
	}
	@Override
	public int compareTo(Object o) {
		// 每次添加一次会执行这个方法，这个o 就是上一次的对象 this 就是当前添加的对象的值，如果当前对象大 就返回1 否者返回0
		UserChange uc = (UserChange) o;
		System.out.println(" comparet " + uc.toString());
		if (uc.getUserName().compareTo(this.userName) < 0) {
			return 1;
		}
		if (uc.getUserName().compareTo(this.userName) > 0) {
			return -1;
		}
		if (uc.getAge() < this.age) {
			return 1;
		}
		if (uc.getAge() > this.age) {
			return -1;
		}
		return 0;
	}

	@Override
	public String toString() {
		return this.userName + " ： " + this.age;
	}

	static class test {
		public static void main(String[] args) {
			Set<UserChange> set1 = new TreeSet<UserChange>();
			set1.add(new UserChange("Tom", 12));
			set1.add(new UserChange("Tom", 12));
			set1.add(new UserChange("Tom", 13));
			set1.add(new UserChange("Tom", 14));
			set1.add(new UserChange("Tom", 15));
			set1.add(new UserChange("Tom", 1));
			System.out.println(set1.size());
			for (UserChange userChange : set1) {
				System.out.println(userChange);
			}
		}

	}

}
