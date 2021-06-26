package com.mg.bfbcsj.chapter14;

import org.apache.http.annotation.ThreadSafe;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * OneShotLatch class
 *
 * @author 谢小平
 * @date 2020-08-29
 */
@ThreadSafe
public class OneShotLatch {
	private final Sync sync = new Sync();

	public void signal() {
		sync.releaseShared(0);
	}
	public void await() throws InterruptedException {
		sync.acquireSharedInterruptibly(0);
	}

	private  class Sync extends AbstractQueuedSynchronizer {
		@Override
		protected int tryAcquireShared(int arg) {
			return (getState() == 1) ?  1 : -1;
		}

		@Override
		protected  boolean tryReleaseShared(int arg) {
			setState(1);
			return true;
		}
	}
}
