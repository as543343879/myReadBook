package com.designPatterns.puttake;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * PutTakeQueue class
 *
 * @author 格林
 * @date 2021-05-18
 */
public class PutTakeQueue {
    private static BlockingQueue<String> queue = new ArrayBlockingQueue<>(5);

    public static BlockingQueue<String> getQueue() {
        return queue;
    }

    public static void main(String[] args) {
            Put put = new Put();
            Take take = new Take();
            new Thread(take).start();
            new Thread(put).start();
            new Thread(take).start();
            new Thread(put).start();
    }
}

class Put implements Runnable {
    @Override
    public void run() {
        try {
            PutTakeQueue.getQueue().put("message");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Take implements Runnable {
    @Override
    public void run() {
        String message = null;
        try {
            message = PutTakeQueue.getQueue().take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(message);
    }
}