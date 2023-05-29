package com.test;

/**
 * MainTest class
 * lamba 表达式的 上下文推导能力更强
 * @author 谢小平
 * @date 2023/5/23
 */
public class MainTest {
    public static void main(String[] args) throws InterruptedException {
        final int t = 1;
        Thread thread2 =  new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("1");
//                        t = 1;
                    }
                }
        );
        thread2.start();

        Thread thread = new Thread(() -> {
            System.out.println(t);
        }

        );
        thread.start();
        thread2.join();
        thread.join();
    }
}

