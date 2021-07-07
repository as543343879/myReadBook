package com.concurrent;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * PrintABC class
 * 编写一个程序，开启三个线程，这三个线程的 ID 分别是 A、B 和 C，每个线程把自己的 ID 在屏幕上打印 10 遍，要求输出结果必须按 ABC 的顺序显示，如 ABCABCABC... 依次递推
 * https://segmentfault.com/a/1190000021433079
 * @author 格林
 * @date 2021-07-06
 */
public class PrintABC {
    static Thread threadA,threadB,threadC;
    //基于锁实现
    static ReentrantLock lock = new ReentrantLock();
    static Condition conditionA = lock.newCondition();
    static Condition conditionB = lock.newCondition();
    static Condition conditionC = lock.newCondition();
    static volatile boolean startA = true;
    // 基于信号量实现
    static Semaphore semaphoreA = new Semaphore(1);
    static Semaphore semaphoreB = new Semaphore(0);
    static Semaphore semaphoreC = new Semaphore(0);

    public static void printABC3(){
        threadA = new Thread(()->{
            try {
               for(int i = 0 ;i < 10; i ++ ) {
                   semaphoreA.acquire();
                   System.out.print(Thread.currentThread().getName());
                   semaphoreB.release();
               }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"A");

        threadB = new Thread(()->{
            try {
                for(int i = 0 ;i < 10; i ++ ) {
                    semaphoreB.acquire();
                    System.out.print(Thread.currentThread().getName());
                    semaphoreC.release();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"B");

        threadC = new Thread(()->{
            try {
                for(int i = 0 ;i < 10; i ++ ) {
                    semaphoreC.acquire();
                    System.out.print(Thread.currentThread().getName());
                    semaphoreA.release();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"C");

        threadC.start();
        threadB.start();
        threadA.start();
    }

    public  static void printABC2(){
        threadA = new Thread(()->{
            lock.lock();
            try {
            for(int i = 0; i < 10; i ++) {

                    if(startA) {
                        startA = false;
                    }
                    System.out.print(Thread.currentThread().getName());
                    conditionB.signal();
                    try {
                        conditionA.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

            }
            conditionB.signal();
            } finally {
                System.out.println("a-");
                lock.unlock();
            }
        },"A");

        threadB = new Thread(()->{
            lock.lock();
            try {
            for(int i = 0; i < 10; i ++) {

                    if(!startA) {
                        System.out.print(Thread.currentThread().getName());
                        conditionC.signal();
                        conditionB.await();
                    } else {
                        conditionB.await();
                        i --;
                    }

            }
            conditionC.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println("b-");
                lock.unlock();
            }
        },"B");

        threadC = new Thread(()->{
            lock.lock();
            try {
            for(int i = 0; i < 10; i ++) {

                    if(!startA) {
                        System.out.print(Thread.currentThread().getName());
                        conditionA.signal();
                        conditionC.await();
                    } else {
                        conditionC.await();
                        i --;
                    }


            }
            conditionA.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println("c-");
                lock.unlock();
            }
        },"C");

        threadC.start();
        threadB.start();
        threadA.start();
    }

    public  static void printABC1(){
        threadA = new Thread(()->{
            for(int i = 0; i < 10; i ++) {
                System.out.print(Thread.currentThread().getName());
                LockSupport.unpark(threadB);
                LockSupport.park();
            }
        },"A");

        threadB = new Thread(()->{
            for(int i = 0; i < 10; i ++) {
                LockSupport.park();
                System.out.print(Thread.currentThread().getName());
                LockSupport.unpark(threadC);
            }
        },"B");

        threadC = new Thread(()->{
            for(int i = 0; i < 10; i ++) {
                LockSupport.park();
                System.out.print(Thread.currentThread().getName());
                LockSupport.unpark(threadA);
            }
        },"C");

        threadA.start();
        threadB.start();
        threadC.start();

    }

    public static void main(String[] args) {
//        printABC1();
//        printABC2();
        printABC3();
    }
}
