package com.test.jstack;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * JstackTest2 class
 *
 * @author 谢小平
 * @date 2020-09-04
 */
public class JstackTest2 {
	static Lock lock1 = new ReentrantLock();
	static Lock lock2 = new ReentrantLock();
	public static void main(String[] args) {
		new Thread(()->{
			lock1.lock();
			System.out.println("JstackTest01 get lock1");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			lock2.lock();
			System.out.println("JstackTest01 get lock2");


		},"JstackTest01").start();

		new Thread(()->{
			lock2.lock();
			System.out.println("JstackTest02 get lock2");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			lock1.lock();
			System.out.println("JstackTest02 get lock1");
		},"JstackTest02").start();
	}
}
