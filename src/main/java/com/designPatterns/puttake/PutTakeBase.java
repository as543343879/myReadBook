package com.designPatterns.puttake;

import java.util.ArrayList;
import java.util.List;

/**
 * PutTakeBase class
 *
 * @author 格林
 * @date 2021-05-18
 */
public class PutTakeBase {
    private Object lock = new Object();
    private List<String> list = new ArrayList<>();

    class Put implements Runnable {
        @Override
        public void run() {
            synchronized (lock) {
                while (list.size() == 1) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                list.add("message");
                lock.notify();
            }
        }
    }

    class Take implements Runnable{
        @Override
        public void run() {
            synchronized (lock) {
                while (list.size() == 0) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(list.get(0));
                list.remove(0);
                lock.notify();
            }
        }
    }

    public static void main(String[] args) {
        PutTakeBase putTakeBase = new PutTakeBase();
        Put put =  putTakeBase.new Put();
        Take take = putTakeBase.new Take();
        new Thread(put).start();
        new Thread(take).start();
        new Thread(take).start();
        new Thread(take).start();
        new Thread(put).start();
        new Thread(put).start();
    }
}


