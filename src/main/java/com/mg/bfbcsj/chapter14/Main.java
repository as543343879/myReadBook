package com.mg.bfbcsj.chapter14;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * Main class
 *
 * @author 谢小平
 * @date 2020-08-29
 */
public abstract class Main {
	public static void main(String[] args) {
		AbstractQueuedSynchronizer abstractQueuedSynchronizer = new AbstractQueuedSynchronizer() {
			@Override
			protected boolean tryAcquire(int arg) {
				return super.tryAcquire(arg);
			}
		};
//		HashMap hashMap = new HashMap(12);
//		HashMap hashMap2 = new HashMap();
//		ConcurrentHashMap



	}
//	state = 0 ,表示没有线程持有锁
//	state > 0 ，有线程持有锁
//	同一线程多次获得锁，就会多次+1
//	同一线程释放锁，就会-1
}
