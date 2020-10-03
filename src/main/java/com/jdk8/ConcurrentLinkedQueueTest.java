package com.jdk8;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * ConcurrentLinkedQueueTest class
 *
 * @author 谢小平
 * @date 2020-09-17
 */
public class ConcurrentLinkedQueueTest {
	public static ConcurrentLinkedQueue<String> concurrentLinkedQueue = new ConcurrentLinkedQueue();
	public static void main(String[] args) throws InterruptedException {
	    new Thread(()->{
			    for(int i = 0; i < 100 ; i ++ ) {

				    concurrentLinkedQueue.add("生产");
			    }

	    }).start();

		Thread thread = new Thread(() -> {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("xxp");
		});
		System.out.println(thread.isDaemon());
//		thread.join();
		thread.start();
	}
}
