/**
 * 
 */
package com.my.interview.gc;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

import com.my.interview.gc.NorObjectWeakReference.NorObject;

/**
 * @author liuwei 弱引用 gc 一旦发生 会被回收
 * 1、可以通过监控ReferencQueue ，通过其get 方法 判断对象是否被回收了
 */
public class NorObjectWeakReference extends WeakReference<NorObject> {

	//如果打印该值表民该对象未被回收
	public String name;

	public NorObjectWeakReference(NorObject referent, ReferenceQueue<NorObject> q) {
		super(referent, q);
		this.name = referent.name;
	}

	@Override
	protected void finalize() throws Throwable {
		System.out.println("NorObjectWeakReference 执行finalize name :" + name);
	}

	// 便利ReferenceQueue
	private static ReferenceQueue<NorObject> qulist = new ReferenceQueue<NorObjectWeakReference.NorObject>();

	public static void checkReferencequery() {
		// 建立一个ReferenceQueue 的内部元素
		Reference<NorObject> ref = null;
		while ((ref = (Reference<NorObject>) qulist.poll()) != null) {
			if(ref!=null) {
				//因为
				System.out.println("当前引用对象的名字："+((NorObjectWeakReference)ref).name);
				//因为他是弱引用，他会把T对象给回收掉，所以这个打印为null
				System.out.println("当前应用的对象："+((NorObjectWeakReference)ref).get());
			}
		}

	}

	public static void main(String[] args) {
		//建立
		List<NorObjectWeakReference> list = new ArrayList<NorObjectWeakReference>();
		for (int i = 0; i < 3; i++) {
			//建立该对象
			NorObject obj = new NorObject("jack"+i);
			//将该对象放到相关引用里，这里的是WeakReference
			NorObjectWeakReference nwr = new NorObjectWeakReference(obj,qulist);
			//将这个引用放到一个list中区，来防止reference 被 回收 ，如果不妨到一个list 继续关联，这个NorObjectWeakReference 也会被销毁
			list.add(nwr);
			System.out.println("添加一个元素:"+nwr);
		}
		//打印该元素 刚开始因为未发生GC qulist 为空的 只有发生了GC gc才会把
		checkReferencequery();
		//提醒调用gc  Full  GC
		System.gc();
		//休息
		try {
			Thread.currentThread().sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//重新打印
		checkReferencequery();
		System.out.println(Thread.currentThread().getName());
	}

	// 普通对象
	static class NorObject {
		public String name;

		public NorObject(String name) {
			super();
			this.name = name;
		}

		@Override
		protected void finalize() throws Throwable {
			System.out.println("NorObject finalize name:" + name);
		}

	}

}
