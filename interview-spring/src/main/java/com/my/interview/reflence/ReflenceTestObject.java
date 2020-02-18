/**
 * 
 */
package com.my.interview.reflence;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import lombok.Data;

/**
 * @author liuwei 反射测试对象
 * 反射就是讲一个类的属性和方法反射一个个对象 方便我们去调用和赋值和获取
 */
@Data
public class ReflenceTestObject extends ReflenceTestObjectParent implements ReferenceInterface{

	public String name;
	private String password;

	private String test1(String parm) {
		return parm;
	}

	public String test2(String parm) {
		return parm;
	}

	String test3(String parm) {
		return parm;
	}
	
	public String test2() {
		System.out.println("反射设置了属性name:"+name+",passowrd:"+password);
		return name+"_"+password;
	}


	/**
	 * Main 测试类
	 * @author liuwei
	 *
	 */
	static class MainTest {
		
		public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException {
			//packege路径
			Class<?> classz = Class.forName("com.my.interview.reflence.ReflenceTestObject");
			ReflenceTestObject rt = (ReflenceTestObject) classz.newInstance();
			//get Method 可以获取此类的所有方法，但是不可以获取接口或者父类的子类的方法
			Method method = classz.getDeclaredMethod("test1", String.class);
			method.setAccessible(true);
			Object restul = method.invoke(rt, "getDereceMethod");
			System.out.println("调用方法private 返回："+restul);
			//这里使用另外一种方法：就是可以获取该类 父类 接口的 public 方法 但是不可以获取私有方法
			Method method2 = classz.getMethod("test2", String.class);
			Object restul1 = method2.invoke(rt, "getMethod");
			System.out.println("调用方法public 返回："+restul1);
			//调用接口的方法 调用不了接口的public static 方法
//			Method method3 = classz.getMethod("interface1", String.class);
//			method3.invoke(rt, "interface1");
			ReferenceInterface.interface1("直接调用");
			Method method4 = classz.getMethod("interface2", String.class);
			method4.invoke(rt, "interface2");
			//调用父类方法
			Method method5 = classz.getMethod("parent", String.class);
			method5.invoke(rt, "parent");
			//获取属性对象
			Field file = classz.getDeclaredField("name");
			//设置属性值 public 属性
			file.set(rt, "jack");
			Method method6 = classz.getMethod("test2");
			method6.invoke(rt);
			//获取属性对象 私有属性
			Field password = classz.getDeclaredField("password");
			password.setAccessible(true);
			//设置属性值
			password.set(rt, "123456");
			Method method7 = classz.getMethod("test2");
			method7.invoke(rt);
		}
		
	}

}
