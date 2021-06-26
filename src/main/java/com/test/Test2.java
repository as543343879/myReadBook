package com.test;

import java.util.concurrent.ForkJoinPool;

/**
 * Test2 class
 *
 * @author 谢小平
 * @date 2020-08-12
 */
public class Test2 {
	public static void main(String[] args) throws InterruptedException {
		ForkJoinPool forkJoinPool = new ForkJoinPool();
		String a = "123";
		a.intern();
		String b = "123";
		System.out.println(a==b      );
//		Thread.sleep(1000 * 100 * 200);
//		LockSupport.park();
	}
}
