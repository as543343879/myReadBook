package com.jdk8.concurrency;

import org.junit.Test;

import java.util.concurrent.*;

/**
 * InterruptedTest class
 *
 * @author 谢小平
 * @date 2022/1/27
 */
public class InterruptedTest {
    @Test
    public void test() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<?> future = executorService.submit(() -> {
            while (!Thread.interrupted() ) {
                System.out.println("rung.....");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    System.err.println("interrupted");
                }
            }
        });
        ThreadUtils.sleep(1000);
        future.cancel(true);
        try {
            Object taskRes = future.get();
            System.out.println(taskRes);
        } catch (InterruptedException | CancellationException | ExecutionException e) {
            e.printStackTrace();
        }
        ThreadUtils.sleep(1000 * 60);
    }



    @Test
    public void test2() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<?> future = executorService.submit(() -> {
            int number = 0;
            while (!Thread.interrupted()) {
                number++;
            }
            System.out.println(number);
        });
        ThreadUtils.sleep(1000);
        future.cancel(true);
        try {
            future.get();
        } catch (InterruptedException | CancellationException | ExecutionException e) {
            e.printStackTrace();
        }
        ThreadUtils.sleep(1000 * 60);
    }
}
