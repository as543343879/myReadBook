package com.jdk8;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * LcokTest class
 *
 * @author 谢小平
 * @date 2020-09-16
 */
public class LcokTest {
	public static void main(String[] args) {
	    Lock lock = new ReentrantLock(true);
	    try{
		    lock.lock();
		    System.out.println("get lock ");
		    System.out.println("get lock ");
	    }catch (Exception e) {
	        e.printStackTrace();
	        throw new RuntimeException(e);
	    } finally {
	    	lock.unlock();
	    }

	}
}
