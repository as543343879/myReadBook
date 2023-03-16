package com.jdk8;

import org.junit.Test;

import java.util.Collections;
import java.util.Map;

/**
 * ThreadLocalTest class
 *
 * @author 谢小平
 * @date 2020-11-02
 */
public class ThreadLocalTest {
	public static void main(String[] args) {

		ThreadLocal<String> threadLocal1 = new ThreadLocal();
		threadLocal1.set("xxp");

		String s = threadLocal1.get();
		System.out.println(s);


		ThreadLocal<String> threadLocal2 = new ThreadLocal();
		threadLocal2.set("xxpthreadLocal2");

		 s = threadLocal2.get();
		System.out.println(s);
	}


	@Test
	public void testInheritableThreadLocal() {
		final ThreadLocal threadLocal = new InheritableThreadLocal();
		threadLocal.set("droidyue.com");

		final ThreadLocal threadLocal2 = new InheritableThreadLocal();
		threadLocal.set("droidyue.com2");


		Thread t = new Thread() {
			@Override
			public void run() {
				super.run();
				System.out.println("testInheritableThreadLocal =" + threadLocal.get());
			}
		};

		t.start();
	}

	@Test
	public void test2() {
		Map<String, Object> objectObjectMap = Collections.emptyMap();
		System.out.println(objectObjectMap.get("xx"));
	}
}
