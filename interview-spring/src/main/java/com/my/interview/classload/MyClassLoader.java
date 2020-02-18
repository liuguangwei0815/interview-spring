package com.my.interview.classload;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 自己定义的classLoader
 * 
 * @author liuwei
 *
 */
public class MyClassLoader extends ClassLoader {

	private String path;// 类文件路径


	public MyClassLoader(String path) {
		this.path = path;
	}

	/**
	 * 覆盖父类查找类路径的方法 将class文件解析成二进制流
	 */
	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		byte[] b = getClassByte(name);
		return super.defineClass(name, b, 0, b.length);
	}

	private byte[] getClassByte(String name) {
		InputStream in = null;
		ByteArrayOutputStream out = null;
		try {
			String fileName = String.format("%s%s.class", path, name);
			System.out.println("获取路径为："+fileName);
			// 定义输入流
			in = new FileInputStream(new File(fileName));
			// 定义输出流
			out = new ByteArrayOutputStream();
			int i = 0;
			//如果他读取read 为-1 表示没有内容了
			while ((i = in.read()) != -1) {
				out.write(i);
			}
			//关闭流
			in.close();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return out.toByteArray();
	}
	
	static class MainTest{
		
		public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
			//1、首先利用javac 命令编译成二进制的class文件
			//2、重写ClassLoader的findClass 获取类的路径 将获取的二级制 传递给definedClass() 方法
			MyClassLoader loader = new MyClassLoader("C:\\Users\\liuwei\\Desktop\\");
			Class<?> clazz = loader.loadClass("MyCTest");
			//只有实例化的时候 static 语句才会执行
			clazz.newInstance();
			
		}

		
	}

}
