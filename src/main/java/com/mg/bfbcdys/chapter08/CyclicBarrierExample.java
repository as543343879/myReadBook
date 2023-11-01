package com.mg.bfbcdys.chapter08;

import java.util.PriorityQueue;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierExample {
    private static final int THREAD_COUNT = 3;
    private static final CyclicBarrier BARRIER = new CyclicBarrier(THREAD_COUNT, new Runnable() {
        @Override
        public void run() {
            System.out.println("所有线程都已到达屏障点，开始执行任务C");
        }
    });

    public static void  main(String[] args) throws InterruptedException {
        for (int i = 0; i < THREAD_COUNT; i++) {
            new Thread(new Task(i)).start();
        }
    }

    static class Task implements Runnable {
        private final int id;

        Task(int id) {
            this.id = id;
        }

        @Override
        public void run() {
            try {
                System.out.println("线程 " + id + " 正在执行任务 " + (id + 1));
                Thread.sleep((long) (Math.random() * 1000)); // 模拟任务执行时间
                System.out.println("线程 " + id + " 已完成任务 " + (id + 1));
                // 等待其他线程到达屏障点
                BARRIER.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }
}