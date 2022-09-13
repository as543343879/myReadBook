package com.jdk8.gc;

import org.springframework.util.StopWatch;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Test1 class
 * Thread.sleep(0); 进入安全点，允许gc。 int 及更小的，在循环过程中不允许gc
 *https://mp.weixin.qq.com/s/YS24qQiW02uJzKkYeNhJZQ
 * @author 谢小平
 * @date 2022/9/13
 */
public class Test1 {
    public static AtomicInteger num = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        Runnable runnable=()->{
            StopWatch stopWatch = new StopWatch();

            stopWatch.start("add");
            for (int i = 0; i < 1000000000; i++) {
                num.getAndAdd(1);
                if(i % 1000 == 0) {
                    try {
                        Thread.sleep(0);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

            stopWatch.stop();

            System.out.println(Thread.currentThread().getName()+"执行结束!" + stopWatch.prettyPrint());
        };

        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);
        t1.start();
        t2.start();
        Thread.sleep(1000);
        System.out.println("num = " + num);
    }
}
