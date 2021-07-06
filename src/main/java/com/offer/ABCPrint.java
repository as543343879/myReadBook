package com.offer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ABCPrint class
 *
 * @author 格林
 * @date 2021-07-04
 */
public class ABCPrint {
    final  ReentrantLock lock = new ReentrantLock();
    Condition a = lock.newCondition();
    Condition b = lock.newCondition();
    Condition c = lock.newCondition();
    public  void pring() throws InterruptedException {
        Thread t1 =  new Thread(()->{
            lock.tryLock();
            try {
                System.out.println("A");
                b.signal();
            } finally {
                lock.unlock();
            }
        });
        t1.start();
        Thread t2 =  new Thread(()->{
            lock.tryLock();
            try {
                System.out.println("B");
                c.signal();
            } finally {
                lock.unlock();
            }
        });
        t2.start();
        Thread t3 =  new Thread(()->{
            lock.tryLock();
            try {
                System.out.println("A");
                a.signal();
            } finally {
                lock.unlock();
            }
        });
        t3.start();

        t1.join();
        t2.join();
        t3.join();
    }

    public static void main(String[] args) {
        try {
            new ABCPrint().pring();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
