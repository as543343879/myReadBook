package com.acm.lico.doNotKnow;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Foo114Test class
 *
 * @author 谢小平
 * @date 2022/5/31
 */
public class Foo114Test {
    public static void  semaphore() {
        Semaphore semaphore1 = new Semaphore(0);
        Semaphore semaphore2 = new Semaphore(0);
        Semaphore semaphore3 = new Semaphore(0);
        semaphore1.release();
        final int count = 3;
        new Thread(()->{
            for(int i = 0; i < count; i ++) {
                try {
                    Thread.sleep(2000);
                    semaphore1.acquire();
                    System.out.println("A ");
                    semaphore2.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }).start();

        new Thread(()->{
            for(int i = 0; i < count; i ++) {
                try {
                    semaphore2.acquire();
                    System.out.println("B ");
                    semaphore3.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }).start();


        new Thread(()->{
            for(int i = 0; i < count; i ++) {
                try {
                    semaphore3.acquire();
                    System.out.println("C ");
                    semaphore1.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public static void lock() {
        Lock lock = new ReentrantLock();
        Condition conditionA = lock.newCondition();
        Condition conditionB = lock.newCondition();
        Condition conditionC = lock.newCondition();

        final int count = 3;
        new Thread(()->{
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for(int i = 1; i <= count; i ++) {
                try{
                    lock.lock();
                    System.out.println("A ");
                    conditionB.signal();
                    if (i != count) {
//                        System.out.println("A " + i);
                        conditionA.await();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }

            }
        }).start();

        new Thread(()->{
            for(int i = 1; i <= count; i ++) {
                try{
                    lock.lock();

                    System.out.println("B ");
                    conditionC.signal();
//                    System.out.println("B " + i);
                    if (i != count) {
                        conditionB.await();
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }

            }
        }).start();

        new Thread(()->{
            for(int i = 1; i <= count; i ++) {
                try{
                    lock.lock();

                    System.out.println("C ");
//                    System.out.println("C " + i);
                    conditionA.signal();
                    if (i != count) {
                        conditionC.await();
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }

            }
        }).start();


    }

    static  Thread threadA = null, threadB = null, threadC = null;

    public static void lockSupport() {
        int count = 3;

        threadA = new Thread(()->{
            for(int i = 0; i < count; i ++) {
                System.out.println(Thread.currentThread().getName());
                LockSupport.unpark(threadB);
                LockSupport.park();
            }
        }, "A");

         threadB = new Thread(()->{
            for(int i = 0; i < count; i ++) {
                LockSupport.park();
                System.out.println(Thread.currentThread().getName());
                LockSupport.unpark(threadC);
            }
        }, "B");

         threadC = new Thread(()->{
            for(int i = 0; i < count; i ++) {
                LockSupport.park();
                System.out.println(Thread.currentThread().getName());
                LockSupport.unpark(threadA);
            }
        }, "C");

         threadA.start();
         threadB.start();
         threadC.start();

    }
    public static void main(String[] args) {
//        lock();
//        semaphore();
        lockSupport();
    }

}
