package com.jdk8.thread;

/**
 * WaitTest class
 *
 * @author 谢小平
 * @date 2023/2/8
 */
public class WaitTest {

    public static void main(String[] args) {
        Thread t = new Thread(()->{
            System.out.println("before wait");
            synchronized (WaitTest.class) {
                try {
                    WaitTest.class.wait(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("end wait");
        });
        t.start();

        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
