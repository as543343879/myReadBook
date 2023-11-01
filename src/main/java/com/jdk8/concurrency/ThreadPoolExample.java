package com.jdk8.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolExample {
    public static void main(String[] args) {  
        int poolSize = 10; // 线程池大小  
        ExecutorService executorService = Executors.newFixedThreadPool(poolSize);
        for (int i = 0; i < 100; i++) { // 提交100个任务到线程池  
            executorService.execute(new Runnable() {  
                @Override  
                public void run() {  
                    // 执行任务的代码  
                }  
            });  
        }  
        executorService.shutdown(); // 关闭线程池，不再接受新的任务，等待已提交的任务执行完毕后关闭线程池。  
    }  
}