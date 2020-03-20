package com.mg.bfbcdys.chapter04;

import java.util.concurrent.TimeUnit;

/**
 * Interrupted class
 *
 * @author 谢小平
 * @date 2019/9/9
 */
public class Interrupted_4_7 {
    public static void main(String[] args) throws InterruptedException {
        Thread sleepThread = new Thread(()->{
            while (true) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"sleeplThread");
        Thread busyThread = new Thread(()->{
            while (true) {
            }
        },"busyThread");

        sleepThread.setDaemon(true);
        busyThread.setDaemon(true);
        sleepThread.start();
        busyThread.start();
        TimeUnit.SECONDS.sleep(5);
        System.out.println(sleepThread.getState() +   " sleepThread interrupted is " + sleepThread.isInterrupted());
        System.out.println(busyThread.getState() +  " BusyThread interrupted is " + busyThread.isInterrupted());
        sleepThread.interrupt();
        busyThread.interrupt();
        System.out.println(sleepThread.getState() +  " sleepThread interrupted is " + sleepThread.isInterrupted());
        System.out.println(busyThread.getState() +  " BusyThread interrupted is " + busyThread.isInterrupted());
        Thread.sleep(2000);
    }
}
