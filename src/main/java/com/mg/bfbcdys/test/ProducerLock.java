package com.mg.bfbcdys.test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ProducerLock class
 *
 * @author 格林
 * @date 2020-09-12
 */
public class ProducerLock {
    public static  int count  = 0;
    static Lock lock = new ReentrantLock();
    static Condition hashCount = lock.newCondition();
   static Condition noHashCount = lock.newCondition();

    public static void main(String[] args) {
        for(int i = 0; i < 10; i ++) {
            new Thread(()->{
                lock.lock();
                try {
                    while (count == 1) {
                        noHashCount.await();
                    }
                    count = 1;
                    hashCount.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }

            }).start();
        }

        for(int i = 0; i < 10; i ++) {
            new Thread(()->{
                lock.lock();
                try {
                    while (count == 0) {
                        hashCount.await();
                    }
                    System.out.println("拿到一个薯饼");
                    noHashCount.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }

            }).start();
        }

    }
}
