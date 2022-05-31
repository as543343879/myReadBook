package com.acm.lico.doNotKnow;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class PrintABC {
  public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        // 使用ReentrantLock的newCondition()方法创建三个Condition
        // 分别对应A、B、C三个线程
        Condition conditionA = lock.newCondition();
        Condition conditionB = lock.newCondition();
        Condition conditionC = lock.newCondition();

        // A线程
        new Thread(() -> {
            try {
                Thread.sleep(2000);
                lock.lock();
                for (int i = 0; i < 10; i++) {

                    System.out.print(Thread.currentThread().getName());
                    // 叫醒B线程
                    conditionB.signal();
                    // 本线程阻塞
                    conditionA.await();
                }
                // 这里有个坑，要记得在循环之后调用signal()，否则线程可能会一直处于
                // wait状态，导致程序无法结束
                conditionB.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                // 在finally代码块调用unlock方法
                lock.unlock();
            }
        }, "A").start();
        // B线程
        new Thread(() -> {
            try {
                lock.lock();
                for (int i = 0; i < 10; i++) {
                    System.out.print(Thread.currentThread().getName());
                    conditionC.signal();
                    conditionB.await();
                }
                conditionC.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }, "B").start();
        // C线程
        new Thread(() -> {
            try {
                lock.lock();
                for (int i = 0; i < 10; i++) {
                    System.out.print(Thread.currentThread().getName());
                    conditionA.signal();
                    conditionC.await();
                }
                conditionA.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }, "C").start();
    }
}