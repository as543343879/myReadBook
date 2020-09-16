package com.test.jstack;

/**
 * JstackTest01 class
 *
 * @author 谢小平
 * @date 2020-09-04
 */
public class JstackTest01 {
	public static Object lok2 = new Object();

	public static void main(String[] args) {
		new Thread(()->{
			synchronized (JstackTest01.class) {
				System.out.println("JstackTest01 get JstackTest01 lock");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				synchronized (lok2) {
					System.out.println("JstackTest01 get lok2 ");
				}
			}
		},"JstackTest01").start();

		new Thread(()->{
			synchronized (lok2) {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("JstackTest02 get lok2");
				synchronized (JstackTest01.class) {
					System.out.println("JstackTest02 get JstackTest01 lock ");
				}
			}
		},"JstackTest02").start();
	}
}
