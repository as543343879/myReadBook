package com.mg.bfbcdys.chapter04;

import java.util.concurrent.TimeUnit;

/**
 * Join class
 *
 * @author 谢小平
 * @date 2019/9/9
 */
public class Join {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("xxp2");},"1");
        thread.start();
        thread.join();
        System.out.println("xxp1");
    }
}
