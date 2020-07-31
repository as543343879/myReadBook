package com.mg.bfbcdys.chapter02;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.vm.VM;
import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * AtomicIntegerExample class
 *
 * @author 谢小平
 * @date 2020-07-31
 */
public class AtomicIntegerExample {
	static AtomicInteger atomicInteger = new AtomicInteger(0);
	public static void main(String[] args) throws Exception {
		System.out.println(VM.current().details());
		System.out.println("=================");
		System.out.println(ClassLayout.parseClass(AtomicInteger.class).toPrintable());
		Unsafe unsafe = getUnsafeInstance();
		System.out.println("=================");
		long offset = unsafe.objectFieldOffset(AtomicInteger.class.getDeclaredField("value"));
		atomicInteger.incrementAndGet();
		int va = unsafe.getInt(atomicInteger,offset);
		System.out.println("va: " + va);
		System.out.println("atomicInteger:"+atomicInteger);
	}

	public static Unsafe getUnsafeInstance() throws Exception {
		// 通过反射获取rt.jar下的Unsafe类
		Field theUnsafeInstance = Unsafe.class.getDeclaredField("theUnsafe");
		theUnsafeInstance.setAccessible(true);
		// return (Unsafe) theUnsafeInstance.get(null);是等价的
		return (Unsafe) theUnsafeInstance.get(Unsafe.class);
	}
}
