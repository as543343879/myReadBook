package com.mg.bfbcdys.test;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Producer class
 *
 * @author 格林
 * @date 2020-09-12
 */
public class Producer {
    public static ConcurrentLinkedQueue<Integer> concurrentLinkedQueue = new ConcurrentLinkedQueue<Integer>();
    public static  int count  = 10;
    volatile long insetCount = 0;
    volatile boolean isFinsh = false;


        Integer poll1 = concurrentLinkedQueue.poll();

    public static void main(String[] args) {
        for(int i = 0; i < 10; i ++) {
            new Thread(()->{
                count -- ;
                concurrentLinkedQueue.add(1);
            }).start();
        }
        for(int i = 0; i < 10; i ++) {
            new Thread(()->{
                Integer poll = concurrentLinkedQueue.poll();
                System.out.println("获取资源数 : " + poll);



            }).start();;
        }

    }


}
